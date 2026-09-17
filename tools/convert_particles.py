#!/usr/bin/env python3
"""Convert legacy 1.12.2 ShinColle particle classes to 1.21.1.

Usage: python3 tools/convert_particles.py [out_dir]
Reads /tmp/ref112tree/.../client/particle/*.java, writes converted files.

Handles the mechanical translation:
- Particle field/API renames (posX->x, motionX->xd, particleAge->age, ...)
- renderParticle(BufferBuilder...) -> render(VertexConsumer, Camera, float)
  with interpolated camera pos + view-matrix rotation locals
- per-particle Tessellator draws via ShipParticle.TESSELATOR
- vertex chains pos().tex().color().lightmap().endVertex() ->
  addVertex().setUv().setColor().setUv2()
- GlStateManager -> RenderSystem / shader picks by vertex format
- texture binding -> RenderSystem.setShaderTexture
"""
import os, re, sys

SRC = "/tmp/ref112tree/src/main/java/com/lulan/shincolle/client/particle"
OUT = sys.argv[1] if len(sys.argv) > 1 else "src/main/java/com/lulan/shincolle/client/particle"

# files handled manually / differently
SKIP = {"ParticleSmoke.java"}   # atlas sprite particle, ported by hand

IMPORTS = """import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.gui.Font;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
"""

SHADER_FOR = {
    "POSITION_TEX_COLOR": "getPositionTexColorShader",
    "POSITION_TEX": "getPositionTexShader",
    "POSITION_COLOR": "getPositionColorShader",
    "POSITION_COLOR_LIGHTMAP": "getPositionColorLightmapShader",
    "POSITION_COLOR_TEX_LIGHTMAP": "getPositionColorTexLightmapShader",
    "POSITION_TEX_LIGHTMAP": "getPositionTexLightmapShader",
    "PARTICLE": "getParticleShader",
}
MODE_FOR = {
    "GL_QUADS": "QUADS",
    "GL_QUAD_STRIP": "TRIANGLE_STRIP",
    "GL_TRIANGLES": "TRIANGLES",
    "GL_TRIANGLE_STRIP": "TRIANGLE_STRIP",
    "GL_TRIANGLE_FAN": "TRIANGLE_FAN",
    "GL_LINES": "LINES",
    "GL_LINE_STRIP": "LINE_STRIP",
    "GL_POLYGON": "TRIANGLE_FAN",
}


def split_args(s, i):
    """s[i] == '(' -> (inner, index after ')')"""
    assert s[i] == '('
    depth = 0
    j = i
    while j < len(s):
        c = s[j]
        if c == '(':
            depth += 1
        elif c == ')':
            depth -= 1
            if depth == 0:
                return s[i+1:j], j+1
        j += 1
    raise ValueError("unbalanced")


def split_top_commas(s):
    out, depth, cur = [], 0, ""
    for c in s:
        if c in '([{': depth += 1
        elif c in ')]}': depth -= 1
        if c == ',' and depth == 0:
            out.append(cur); cur = ""
        else:
            cur += c
    out.append(cur)
    return [a.strip() for a in out]


def convert_chains(text):
    """X.pos(a,b,c).tex(u,v).color(r,g,b,a).lightmap(i,j).endVertex() chains."""
    out = []
    i = 0
    pat = re.compile(r'(\w+)\.pos\(')
    while True:
        m = pat.search(text, i)
        if not m:
            out.append(text[i:])
            break
        buf = m.group(1)
        args, j = split_args(text, m.end() - 1)
        # walk the element chain after pos(...)
        chain = []
        k = j
        ok = True
        while True:
            mm = re.match(r'\s*\.\s*(\w+)\s*\(', text[k:])
            if not mm:
                break
            name = mm.group(1)
            if name == 'endVertex':
                break
            astart = k + mm.end() - 1
            try:
                a2, k = split_args(text, astart)
            except ValueError:
                ok = False
                break
            chain.append((name, a2))
        m2 = re.match(r'\s*\.\s*endVertex\s*\(\s*\)', text[k:])
        if not m2:
            # not a full chain - keep original text
            out.append(text[i:m.end()-1] + '(' + args + ')')
            i = j
            continue
        k += m2.end()
        xyz = split_top_commas(args)
        if len(xyz) != 3:
            out.append(text[i:k]); i = k; continue
        expr = f"{buf}.addVertex((float)({xyz[0]}), (float)({xyz[1]}), (float)({xyz[2]}))"
        for name, a2 in chain:
            if name == 'pos':
                p = split_top_commas(a2)
                expr += f".addVertex((float)({p[0]}), (float)({p[1]}), (float)({p[2]}))"
            elif name == 'tex':
                p = split_top_commas(a2)
                expr += f".setUv((float)({p[0]}), (float)({p[1]}))"
            elif name == 'color':
                p = split_top_commas(a2)
                if len(p) == 1:
                    expr += f".setColor({p[0]})"
                else:
                    expr += "".join(f".setColor({q})" for q in [])
                    expr += f".setColor((float)({p[0]}), (float)({p[1]}), (float)({p[2]}), (float)({p[3]}))"
            elif name == 'lightmap':
                p = split_top_commas(a2)
                expr += f".setUv2((int)({p[0]}), (int)({p[1]}))"
            elif name == 'normal':
                p = split_top_commas(a2)
                expr += f".setNormal((float)({p[0]}), (float)({p[1]}), (float)({p[2]}))"
            else:
                expr += f".{name}({a2})"
        out.append(text[i:m.start()])
        out.append(expr + ";")
        i = k
    return "".join(out)


def convert_class(name, text):
    # strip package/imports
    body = re.sub(r'^package [^;]+;', '', text)
    body = re.sub(r'^import [^;]+;\s*$', '', body, flags=re.M)
    # strip SideOnly annotations
    body = re.sub(r'@SideOnly\([^)]*\)\s*', '', body)

    # --- class decl: extends Particle -> extends ShipParticle
    body = re.sub(r'extends\s+Particle\b', 'extends ShipParticle', body)

    # --- renderParticle signature -> render()
    def sig_repl(m):
        buf, ent, pt, r1, r2, r3, r4, r5 = m.groups()
        return (
            "@Override\n"
            f"\tpublic void render(VertexConsumer _vc, Camera camera, float {pt})\n"
            "\t{\n"
            f"\t\tVec3 _cam = camera.getPosition();\n"
            f"\t\tEntity {ent} = camera.getEntity();\n"
            f"\t\tdouble interpPosX = _cam.x, interpPosY = _cam.y, interpPosZ = _cam.z;\n"
            f"\t\tfloat {r1} = Mth.cos(camera.getYRot() * Mth.DEG_TO_RAD);\n"
            f"\t\tfloat {r2} = Mth.cos(camera.getXRot() * Mth.DEG_TO_RAD);\n"
            f"\t\tfloat {r3} = Mth.sin(camera.getYRot() * Mth.DEG_TO_RAD);\n"
            f"\t\tfloat _sp = Mth.sin(camera.getXRot() * Mth.DEG_TO_RAD);\n"
            f"\t\tfloat {r4} = {r3} * _sp;\n"
            f"\t\tfloat {r5} = {r1} * _sp;\n"
            f"\t\tBufferBuilder {buf} = null;\n"
        )
    body = re.sub(r'@Override\s*public\s+void\s+renderParticle', 'public void renderParticle', body)
    body = re.sub(
        r'public\s+void\s+renderParticle\s*\(\s*(?:BufferBuilder|VertexBuffer)\s+(\w+)\s*,\s*Entity\s+(\w+)\s*,\s*float\s+(\w+)\s*,\s*float\s+(\w+)\s*,\s*float\s+(\w+)\s*,\s*float\s+(\w+)\s*,\s*float\s+(\w+)\s*,\s*float\s+(\w+)\s*\)\s*\{',
        sig_repl, body)

    # --- begin(mode, fmt) -> own tesselator + shader pick
    def begin_repl(m):
        var, mode, fmt = m.groups()
        vmode = MODE_FOR.get(mode, "QUADS")
        shader = SHADER_FOR.get(fmt)
        s = f"{var} = TESSELATOR.begin(VertexFormat.Mode.{vmode}, DefaultVertexFormat.{fmt});"
        if shader:
            s += f"\n\t\tRenderSystem.setShader(GameRenderer::{shader});"
        return s
    body = re.sub(
        r'(\w+)\.begin\(\s*GL11\.(GL_\w+)\s*,\s*DefaultVertexFormats\.(\w+)\s*\)\s*;',
        begin_repl, body)
    body = re.sub(r'DefaultVertexFormats\.(\w+)', r'DefaultVertexFormat.\1', body)

    # --- draw()
    body = re.sub(r'Tessellator\.getInstance\(\)\.draw\(\)\s*;', 'drawBuf(render);', body)
    body = re.sub(r'Tessellator\.getInstance\(\)\.getBuffer\(\)', 'render', body)

    # --- GL state calls
    body = re.sub(r'Minecraft\.getMinecraft\(\)\.renderEngine\.bindTexture\(([^;]+)\);',
                  r'RenderSystem.setShaderTexture(0, \1);', body)
    body = re.sub(r'Minecraft\.getMinecraft\(\)\.getTextureManager\(\)\.bindTexture\(([^;]+)\);',
                  r'RenderSystem.setShaderTexture(0, \1);', body)
    for f in ['pushMatrix', 'popMatrix', 'disableTexture2D', 'enableTexture2D',
              'disableLighting', 'enableLighting', 'alphaFunc', 'colorMaterial',
              'disableFog', 'enableFog', 'colorLogicOp', 'disableRescaleNormal',
              'enableRescaleNormal', 'disableNormalize', 'enableNormalize',
              'tryBlendFuncSeparate', 'shadeModel', 'color(']:
        if f == 'tryBlendFuncSeparate':
            body = re.sub(r'GlStateManager\.tryBlendFuncSeparate\(([^;]+)\);',
                          r'RenderSystem.blendFuncSeparate(\1);', body)
            continue
        if f == 'color(':
            body = re.sub(r'GlStateManager\.color\([^;]+\);', '', body)
            continue
        if f == 'alphaFunc' or f == 'colorLogicOp' or f == 'shadeModel' or f == 'colorMaterial':
            body = re.sub(r'GlStateManager\.' + f + r'\([^;]*\);', '', body)
            continue
        body = re.sub(r'GlStateManager\.' + f + r'\(\);', '', body)
    body = re.sub(r'GlStateManager\.blendFunc\(', 'RenderSystem.blendFunc(', body)
    body = re.sub(r'GlStateManager\.depthMask\(', 'RenderSystem.depthMask(', body)
    body = re.sub(r'GlStateManager\.enableBlend\(\)', 'RenderSystem.enableBlend()', body)
    body = re.sub(r'GlStateManager\.disableBlend\(\)', 'RenderSystem.disableBlend()', body)
    body = re.sub(r'GlStateManager\.disableCull\(\)', 'RenderSystem.disableCull()', body)
    body = re.sub(r'GlStateManager\.enableCull\(\)', 'RenderSystem.enableCull()', body)
    body = re.sub(r'GlStateManager\.disableDepth\(\)', 'RenderSystem.disableDepthTest()', body)
    body = re.sub(r'GlStateManager\.enableDepth\(\)', 'RenderSystem.enableDepthTest()', body)
    body = re.sub(r'GlStateManager\.depthFunc\(', 'RenderSystem.depthFunc(', body)
    body = re.sub(r'GlStateManager\.\w+\(', '/*GL*/RenderSystem.enableBlend(); //FIXME ', body)
    body = re.sub(r'OpenGlHelper\.setLightmapTextureCoords\([^;]+\);', '', body)

    # --- vertex chains
    body = convert_chains(body)

    # --- identifier renames (qualified first)
    # this.field renames (own particle fields)
    this_pairs = [
        (r'\bthis\.prevPosX\b', 'this.xo'), (r'\bthis\.prevPosY\b', 'this.yo'),
        (r'\bthis\.prevPosZ\b', 'this.zo'),
        (r'\bthis\.posX\b', 'this.x'), (r'\bthis\.posY\b', 'this.y'),
        (r'\bthis\.posZ\b', 'this.z'),
        (r'\bthis\.motionX\b', 'this.xd'), (r'\bthis\.motionY\b', 'this.yd'),
        (r'\bthis\.motionZ\b', 'this.zd'),
        (r'\bthis\.particleAge\b', 'this.age'), (r'\bthis\.particleMaxAge\b', 'this.lifetime'),
        (r'\bthis\.particleAlpha\b', 'this.alpha'),
        (r'\bthis\.particleRed\b', 'this.rCol'), (r'\bthis\.particleGreen\b', 'this.gCol'),
        (r'\bthis\.particleBlue\b', 'this.bCol'),
        (r'\bthis\.particleGravity\b', 'this.gravity'),
        (r'\bthis\.canCollide\b', 'this.hasPhysics'),
        (r'\bthis\.rand\b', 'this.random'),
        (r'\bthis\.world\b', 'this.level'),
        (r'\bthis\.setExpired\(\)', 'this.remove()'),
        (r'\bthis\.setPosition\(', 'this.setPos('),
        (r'\bthis\.isCollided\b', 'this.onGround'),
        (r'\bthis\.onGround\b(?!\()', 'this.onGround'),
    ]
    for pat, rep in this_pairs:
        body = re.sub(pat, rep, body)

    pairs = [
        (r'\.xCoord\b', '.x'), (r'\.yCoord\b', '.y'), (r'\.zCoord\b', '.z'),
        (r'\.renderYawOffset\b', '.yBodyRot'), (r'\.prevRenderYawOffset\b', '.yBodyRotO'),
        (r'\.rotationYawHead\b', '.getYHeadRot()'), (r'\.prevRotationYawHead\b', '.yHeadRotO'),
        (r'\.rotationPitch\b', '.getXRot()'), (r'\.rotationYaw\b', '.getYRot()'),
        (r'\b(?!this\b)(\w+)\.prevPosX\b', r'\1.xo'), (r'\b(?!this\b)(\w+)\.prevPosY\b', r'\1.yo'),
        (r'\b(?!this\b)(\w+)\.prevPosZ\b', r'\1.zo'),
        (r'\b(?!this\b)(\w+)\.posX\b', r'\1.getX()'), (r'\b(?!this\b)(\w+)\.posY\b', r'\1.getY()'),
        (r'\b(?!this\b)(\w+)\.posZ\b', r'\1.getZ()'),
        (r'\b(?!this\b)(\w+)\.motionX\b', r'\1.getDeltaMovement().x'),
        (r'\b(?!this\b)(\w+)\.motionY\b', r'\1.getDeltaMovement().y'),
        (r'\b(?!this\b)(\w+)\.motionZ\b', r'\1.getDeltaMovement().z'),
        (r'\b(?!this\b)(\w+)\.prevRotationYaw\b', r'\1.yRotO'),
        (r'\b(?!this\b)(\w+)\.prevRotationPitch\b', r'\1.xRotO'),
        (r'\b(?!this\b)(\w+)\.rotationYawHead\b', r'\1.getYHeadRot()'),
        (r'\b(?!this\b)(\w+)\.rotationYaw\b', r'\1.getYRot()'),
        (r'\b(?!this\b)(\w+)\.rotationPitch\b', r'\1.getXRot()'),
        (r'\b(?!this\b)(\w+)\.renderYawOffset\b', r'\1.yBodyRot'),
        (r'\b(?!this\b)(\w+)\.prevRenderYawOffset\b', r'\1.yBodyRotO'),
        (r'\b(?!this\b)(\w+)\.ticksExisted\b', r'\1.tickCount'),
        (r'\b(?!this\b)(\w+)\.isDead\b', r'\1.isRemoved()'),
        (r'\b(?!this\b)(\w+)\.height\b', r'\1.getBbHeight()'),
        (r'\b(?!this\b)(\w+)\.width\b', r'\1.getBbWidth()'),
        (r'\b(?!this\b)(\w+)\.worldObj\b', r'\1.level()'),
        (r'\b(?!this\b)(\w+)\.world\b', r'\1.level()'),
        (r'\b(?!this\b)(\w+)\.getEntityWorld\(\)', r'\1.level()'),
        (r'\b(?!this\b)(\w+)\.getRNG\(\)', r'\1.getRandom()'),
        (r'\b(?!this\b)(\w+)\.getDistanceToEntity\(', r'\1.distanceTo('),
        (r'\b(?!this\b)(\w+)\.getPositionVector\(\)', r'\1.position()'),
        (r'\b(?!this\b)(\w+)\.getLookVec\(\)', r'\1.getLookAngle()'),
        (r'\b(?!this\b)(\w+)\.getLook\(', r'\1.getViewVector('),
        (r'\b(?!this\b)(\w+)\.getPositionEyes\(', r'\1.getEyePosition('),
        (r'\b(?!this\b)(\w+)\.getEntityBoundingBox\(\)', r'\1.getBoundingBox()'),
        (r'\b(?!this\b)(\w+)\.getCollisionBoundingBox\(\)', r'\1.getBoundingBox()'),
        (r'\b(?!this\b)(\w+)\.getEntityId\(\)', r'\1.getId()'),
        (r'\b(?!this\b)(\w+)\.getUniqueID\(\)', r'\1.getUUID()'),
        (r'\b(\w+)\.onGround\b(?!\()', r'\1.onGround()'),
        (r'\b(?!this\b)(\w+)\.rand\b', r'\1.getRandom()'),
        (r'\b(?!this\b)(\w+)\.canCollide\b', r'\1.hasPhysics'),
        (r'\b(?!this\b)(\w+)\.isCollided\b', r'\1.onGround()'),
        (r'\b(?!this\b)(\w+)\.getDisplayName\(\)', r'\1.getDisplayName()'),
    ]
    for pat, rep in pairs:
        body = re.sub(pat, rep, body)



    # bare field renames (own fields, unqualified)
    bare_pairs = [
        (r'\bprevPosX\b', 'xo'), (r'\bprevPosY\b', 'yo'), (r'\bprevPosZ\b', 'zo'),
        (r'\bposX\b', 'x'), (r'\bposY\b', 'y'), (r'\bposZ\b', 'z'),
        (r'\bmotionX\b', 'xd'), (r'\bmotionY\b', 'yd'), (r'\bmotionZ\b', 'zd'),
        (r'\brand\b', 'random'),
        (r'\bparticleAge\b', 'age'), (r'\bparticleMaxAge\b', 'lifetime'),
        (r'\bparticleAlpha\b', 'alpha'), (r'\bparticleRed\b', 'rCol'),
        (r'\bparticleGreen\b', 'gCol'), (r'\bparticleBlue\b', 'bCol'),
        (r'\bparticleGravity\b', 'gravity'),
        (r'\bsetExpired\(\)', 'remove()'), (r'\bsetPosition\(', 'setPos('),
        (r'\bmoveEntity\(', 'move('),
        (r'\bonUpdate\(\)', 'tick()'),
        (r'\bgetBrightnessForRender\(', 'getLightColor('),
        (r'\bcanCollide\b', 'hasPhysics'),
        (r'\bisCollided\b', 'onGround'),
        (r'\bisExpired\b', 'removed'),
        (r'\bMathHelper\.', 'Mth.'),
        (r'\bMinecraft\.getMinecraft\(\)', 'Minecraft.getInstance()'),
        (r'\bMinecraft\.getInstance\(\)\.gameSettings\.particleSetting\b',
         'Minecraft.getInstance().options.particles().get().getId()'),
        (r'\bnew ResourceLocation\(', 'ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, '),
        (r'\bVec3d\b', 'Vec3'),
        (r'\bEntityLivingBase\b', 'LivingEntity'),
        (r'\bEntityPlayer\b', 'Player'),
        (r'\bClientProxy\.getClientWorld\(\)', 'Minecraft.getInstance().level'),
        (r'\bClientProxy\.getClientPlayer\(\)', 'Minecraft.getInstance().player'),
        (r'\bClientProxy\.getMineraft\(\)', 'Minecraft.getInstance()'),
        (r'\.gameSettings\.particleSetting\b', '.options.particles().get().getId()'),
        (r'\bIBlockState\b', 'BlockState'),
        (r'\bworld\.rand\b', 'level.random'),
        (r'\bthis\.world\b', 'this.level'),
    ]
    for pat, rep in bare_pairs:
        body = re.sub(pat, rep, body)

    body = re.sub(r'\bVertexBuffer\b', 'BufferBuilder', body)

    # 'world' identifier -> 'level', World type -> ClientLevel
    body = re.sub(r'\bWorld\b', 'ClientLevel', body)
    body = re.sub(r'\bworld\b', 'level', body)

    # super(level...) already ok; super(entity.level() needs ClientLevel cast
    body = re.sub(r'super\((\w+)\.level\(\)', r'super((ClientLevel) \1.level()', body)

    # ConfigHandler -> ShinColleConfig
    body = re.sub(r'\bConfigHandler\.', 'ShinColleConfig.', body)

    # TEXTURES_PARTICLE path -> textures/particles/
    body = re.sub(r'Reference\.TEXTURES_PARTICLE\s*\+\s*"([A-Za-z0-9_]+\.png)"',
                  lambda m: '"textures/particles/%s"' % m.group(1).lower(), body)

    body = re.sub(r'@Override(\s*public\s+boolean\s+isTransparent)', r'\1', body)

    # getFXLayer / getFXTexture blocks -> drop method
    body = re.sub(r'@Override\s*public\s+int\s+getFXLayer\s*\(\s*\)\s*\{[^{}]*\}', '', body)
    body = re.sub(r'@Override\s*public\s+ResourceLocation\s+getFXTexture\s*\(\s*\)\s*\{[^{}]*\}', '', body)
    body = re.sub(r'@Override\s*public\s+int\s+getBrightnessForRender\s*\(\s*float\s+\w+\s*\)\s*\{[^{}]*\}', '', body)

    body = re.sub(r'\bRenderManager\b', 'EntityRenderDispatcher', body)
    body = re.sub(r'\bFontRenderer\b', 'Font', body)
    body = re.sub(r'\brm\.playerViewY\b', 'camera.getYRot()', body)
    body = re.sub(r'\brm\.playerViewX\b', 'camera.getXRot()', body)
    body = re.sub(r'\bthis\.rm\s*=\s*[^;]+;', '', body)

    # setParticleTextureIndex -> sprite pick (manual fix later)
    # leave as-is; will error -> fix manually

    # Reference class import needed when ResourceLocation used
    out = "package com.lulan.shincolle.client.particle;\n\n"
    # keep com.lulan imports from original
    kept = []
    for m in re.finditer(r'^import (com\.lulan\.shincolle\.[^;]+);', text, re.M):
        imp = m.group(1)
        if '.proxy.' in imp or '.handler.' in imp:
            continue
        kept.append(imp)
    if kept:
        out += "\n".join(f"import {k};" for k in kept) + "\n\n"
    out += IMPORTS
    # extra imports
    if 'ShinColleConfig' in body:
        out += "import com.lulan.shincolle.config.ShinColleConfig;\n"
    if re.search(r'\bReference\b', body):
        out += "import com.lulan.shincolle.reference.Reference;\n"
    if re.search(r'\bID\b', body):
        out += "import com.lulan.shincolle.reference.ID;\n"
    if re.search(r'\bValues\b', body):
        out += "import com.lulan.shincolle.reference.Values;\n"
    if re.search(r'\bParticleData\b', body):
        out += "import com.lulan.shincolle.reference.dataclass.ParticleData;\n"
    if re.search(r'\bBlockState\b', body):
        out += "import net.minecraft.world.level.block.state.BlockState;\n"
    out += "\n" + body.strip() + "\n"
    return out


def main():
    os.makedirs(OUT, exist_ok=True)
    fails = []
    for fn in sorted(os.listdir(SRC)):
        if not fn.endswith('.java') or fn in SKIP:
            continue
        src = open(os.path.join(SRC, fn), encoding='utf-8').read()
        try:
            out = convert_class(fn, src)
            open(os.path.join(OUT, fn), 'w', encoding='utf-8').write(out)
            print("OK", fn)
        except Exception as e:
            print("FAIL", fn, e)
            fails.append(fn)
    print("FAILED:", fails)


if __name__ == '__main__':
    main()
