#!/usr/bin/env python3
"""
Convert 1.12.2 ModelBase/ModelRenderer model classes to 1.21 EntityModel/ModelPart.
"""
import re
import sys
import glob
import os

SRC = "/tmp/ref112tree/src/main/java/com/lulan/shincolle/client/model"
DST = "/home/safaid_yuragi/develop/ShinColle-1.21.1/src/main/java/com/lulan/shincolle/client/model"

SKIP = {"ShipModelBase.java", "ShipModelBaseAdv.java", "ShipModelRenderer.java",
        "IModelEmotion.java", "IModelEmotionAdv.java"}

FACE_PARTS = {  # legacy setDefaultFaceModel geometry
    "Face0":  (98, 63,  (-7.0, 0.0, -0.5, 14, 12, 1), (0.0, -12.2, -6.1)),
    "Face1":  (98, 76,  (-7.0, 0.0, -0.5, 14, 12, 1), (0.0, -12.2, -6.1)),
    "Face2":  (98, 89,  (-7.0, 0.0, -0.5, 14, 12, 1), (0.0, -12.2, -6.1)),
    "Face3":  (98, 102, (-7.0, 0.0, -0.5, 14, 12, 1), (0.0, -12.2, -6.1)),
    "Face4":  (98, 115, (-7.0, 0.0, -0.5, 14, 12, 1), (0.0, -12.2, -6.1)),
    "Mouth0": (100, 53, (-3.0, 0.0, -0.5, 6, 4, 1),   (0.0, -4.2, -6.2)),
    "Mouth1": (100, 58, (-3.0, 0.0, -0.5, 6, 4, 1),   (0.0, -4.2, -6.2)),
    "Mouth2": (114, 53, (-3.0, 0.0, -0.5, 6, 4, 1),   (0.0, -4.2, -6.2)),
    "Flush0": (114, 58, (-1.0, 0.0, -0.5, 2, 1, 0),   (-6.0, -3.0, -6.9)),
    "Flush1": (114, 58, (-1.0, 0.0, -0.5, 2, 1, 0),   (6.0, -3.0, -6.9)),
}

def part_key(expr):
    e = expr.strip()
    if e.startswith('this.'):
        e = e[5:]
    return e

def mesh_name(expr):
    return part_key(expr).replace('[', '_').replace(']', '')

def split_args(s):
    args, depth, cur = [], 0, ''
    in_str = None
    for c in s:
        if in_str:
            cur += c
            if c == in_str: in_str = None
            continue
        if c in '"\'':
            in_str = c; cur += c; continue
        if c == ',' and depth == 0:
            args.append(cur.strip()); cur = ''
        else:
            cur += c
            if c in '([{': depth += 1
            elif c in ')]}': depth -= 1
    if cur.strip(): args.append(cur.strip())
    return args

def num(s):
    s = s.strip()
    if re.match(r'^-?\d+(\.\d+)?[dD]$', s):
        s = s[:-1] + 'F'
    elif re.match(r'^-?\d+$', s):
        s = s + '.0F'
    elif re.match(r'^-?\d+\.\d+$', s):
        s = s + 'F'
    return s

def numi(s):
    """int arg for texOffs"""
    s = s.strip()
    m = re.match(r'^(-?\d+)(?:\.0+)?[fFdD]?$', s)
    return m.group(1) if m else s

def parse_members(src):
    """Split class body into top-level members."""
    m = re.search(r'^public class \w+[^\{]*\{', src, re.M)
    pos = m.end()
    out = []
    n = len(src)
    while pos < n:
        # find next '{' or ';' at depth 0
        i = pos
        in_str = None
        while i < n:
            c = src[i]
            if in_str:
                if c == '\\': i += 1
                elif c == in_str: in_str = None
            elif c in '"\'': in_str = c
            elif c == '{' or c == ';': break
            elif c == '}': 
                # class end or stray
                return out
            i += 1
        if i >= n:
            break
        if src[i] == ';':
            out.append(('field', src[pos:i+1], None))
            pos = i + 1
            continue
        # '{': decide method vs field-initializer vs inner class
        header = src[pos:i]
        h = header.strip()
        is_method = ('(' in h and ')' in h) and not re.search(r'=\s*$|=\s*new|\bclass\b', h)
        if not is_method:
            if re.match(r'^(public |private |protected |static |final |abstract )*class \w+', h):
                # inner class: consume block, emit raw
                j = i + 1; d = 1; ins = None
                while d > 0 and j < n:
                    cj = src[j]
                    if ins:
                        if cj == '\\': j += 1
                        elif cj == ins: ins = None
                    elif cj in '"\'': ins = cj
                    elif cj == '{': d += 1
                    elif cj == '}': d -= 1
                    j += 1
                out.append(('raw', src[pos:j], None))
                pos = j
                continue
            # field initializer with braces: scan to ';'
            j = i + 1
            d = 1
            ins = None
            while j < n:
                cj = src[j]
                if ins:
                    if cj == '\\': j += 1
                    elif cj == ins: ins = None
                elif cj in '"\'': ins = cj
                elif cj == '{': d += 1
                elif cj == '}': d -= 1
                elif cj == ';' and d == 0:
                    break
                j += 1
            out.append(('field', src[pos:j+1], None))
            pos = j + 1
            continue
        # method: consume block
        j = i + 1
        d = 1
        ins = None
        while d > 0 and j < n:
            cj = src[j]
            if ins:
                if cj == '\\': j += 1
                elif cj == ins: ins = None
            elif cj in '"\'': ins = cj
            elif cj == '{': d += 1
            elif cj == '}': d -= 1
            j += 1
        out.append(('method', header, src[i+1:j-1]))
        pos = j
    return out


class Part:
    def __init__(self, expr):
        self.expr = part_key(expr)
        self.texoffs = None
        self.cubes = []
        self.pose = [None, None, None]
        self.rawpose = [None, None, None]
        self.rot = [None, None, None]
        self.mirror = False
        self.hidden = False
        self.parent = None
        self.children = []
        self.named = False


def parse_ctor(body, cls):
    parts = {}
    order = []
    keep = []
    texw, texh = 64, 32
    named_tex = {}
    warnings = []

    def get_part(expr):
        k = part_key(expr)
        if k not in parts:
            parts[k] = Part(k)
            order.append(parts[k])
        return parts[k]

    for raw in body.split('\n'):
        line = raw.strip()
        if not line or line.startswith('//'):
            continue
        st = line[:-1].strip() if line.endswith(';') else line

        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\s*=\s*new (?:ModelRenderer|ShipModelRenderer)\(this\s*(?:,\s*(.*))?\)$', st)
        if m:
            p = get_part(m.group(1))
            rest = m.group(2)
            if rest:
                rest = rest.strip()
                if rest.startswith('"'):
                    p.named = True
                else:
                    a = split_args(rest)
                    if len(a) >= 2:
                        p.texoffs = (a[0], a[1])
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.setRotationPoint\((.*)\)$', st)
        if m:
            p = get_part(m.group(1))
            p.pose = split_args(m.group(2))[:3]
            p.rawpose = list(p.pose)
            continue
        m = re.match(r'^(?:this\.)?(?:setRotateAngle|setRotation)\(\s*(\w+(?:\[\w+\])?)\s*,\s*(.*)\)$', st)
        if m:
            get_part(m.group(1)).rot = split_args(m.group(2))[:3]
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.addBox\((.*)\)(\s*\.isHidden\s*=\s*true)?$', st)
        if m:
            p = get_part(m.group(1))
            args = split_args(m.group(2))
            if m.group(3):
                p.hidden = True
            if args and args[0].startswith('"'):
                p.cubes.append(('NAMED:' + p.expr + '.' + args[0].strip('"'), args[1:]))
            else:
                p.cubes.append((None, args))
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.mirror\s*=\s*true$', st)
        if m:
            get_part(m.group(1)).mirror = True
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.isHidden\s*=\s*true$', st)
        if m:
            get_part(m.group(1)).hidden = True
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.showModel\s*=\s*(true|false)$', st)
        if m:
            if m.group(2) == 'false':
                get_part(m.group(1)).hidden = True
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.addChild\((.*)\)$', st)
        if m:
            parent = get_part(m.group(1))
            args = split_args(m.group(2))
            if len(args) == 1 and re.match(r'^(?:this\.)?\w+(?:\[\w+\])?$', args[0]):
                child = get_part(args[0])
                child.parent = parent
                if child not in parent.children:
                    parent.children.append(child)
            else:
                warnings.append('posaddchild: ' + st)
                cp = Part(parent.expr + '_ch' + str(len(parent.children)))
                cp.cubes.append((None, args))
                cp.parent = parent
                parent.children.append(cp)
                parts[cp.expr] = cp
            continue
        m = re.match(r'^(?:this\.)?setTextureOffset\("([^"]+)"\s*,\s*(.*)\)$', st)
        if m:
            a = split_args(m.group(2))
            named_tex[m.group(1)] = (a[0], a[1])
            continue
        m = re.match(r'^(?:this\.)?textureWidth\s*=\s*(\d+)$', st)
        if m:
            texw = int(m.group(1)); continue
        m = re.match(r'^(?:this\.)?textureHeight\s*=\s*(\d+)$', st)
        if m:
            texh = int(m.group(1)); continue
        m = re.match(r'^(?:this\.)?setTextureSize\(\s*(\d+)\s*,\s*(\d+)\s*\)$', st)
        if m:
            texw, texh = int(m.group(1)), int(m.group(2)); continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.setTextureSize\(.*\)$', st)
        if m:
            continue
        m = re.match(r'^(?:this\.)?setDefaultFaceModel\(\)$', st)
        if m:
            for name, (u, v, box, posv) in FACE_PARTS.items():
                p = get_part(name)
                p.texoffs = (str(u), str(v))
                p.cubes.append((None, [repr(x) for x in box]))
                p.pose = [repr(x) for x in posv]
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.offset([XYZ])\s*=\s*(.*)$', st)
        if m and m.group(1) != 'this':
            p = get_part(m.group(1))
            idx = 'XYZ'.index(m.group(2))
            cur = p.pose[idx] or '0F'
            p.pose[idx] = '(%s) + (%s) * 16F' % (cur, m.group(3))
            continue
        # ShipModelRenderer tweak fields -> ModelPart equivalents
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.tweakModel\s*=\s*(true|false)$', st)
        if m:
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.scale2([xyz])\s*=\s*(.*)$', st)
        if m:
            keep.append('this.%s.%sScale = %s;' % (m.group(1), m.group(2), m.group(3)))
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.trans2([xyz])\s*=\s*(.*)$', st)
        if m:
            ax = m.group(2)
            keep.append('this.%s.%s = (this.%s.%s + (%s) * 16F) * this.%s.%sScale;' % (
                m.group(1), ax, m.group(1), ax, m.group(3), m.group(1), ax))
            continue
        m = re.match(r'^(?:this\.)?(\w+(?:\[\w+\])?)\.rotat2([xyz])\s*=\s*(.*)$', st)
        if m:
            keep.append('this.%s.%sRot += (%s) * Mth.DEG_TO_RAD;' % (m.group(1), m.group(2), m.group(3)))
            continue
        # unmatched part mutation -> keep with rewrites
        if re.search(r'\.(rotateAngle[XYZ]|rotationPoint[XYZ]|offset[XYZ])\b', st) and not re.match(r'^this\.offset[XYZ]\s*=', st):
            warnings.append('unhandled ctor: ' + st)
        keep.append(line)

    return parts, order, keep, (texw, texh), named_tex, warnings


def emit_cube_builder(p, named_tex):
    segs = ['CubeListBuilder.create()']
    if p.mirror:
        segs.append('.mirror()')
    cur_tex = p.texoffs
    first = True
    for tex, args in p.cubes:
        t = tex
        if tex and tex.startswith('NAMED:'):
            t = named_tex.get(tex[6:]) or p.texoffs
        if t and (first or t != cur_tex):
            segs.append('.texOffs(%s, %s)' % (numi(t[0]), numi(t[1])))
            cur_tex = t
        first = False
        if len(args) >= 7:
            if args[6].strip() in ('0.0F', '0F', '0.0', '0'):
                segs.append('.addBox(%s)' % ', '.join(num(x) for x in args[:6]))
            else:
                segs.append('.addBox(%s, %s, %s, %s, %s, %s, new CubeDeformation(%s))'
                            % tuple(num(x) for x in args[:7]))
        else:
            segs.append('.addBox(%s)' % ', '.join(num(x) for x in args[:6]))
    return ''.join(segs)

def is_zero(s):
    return s is None or s.strip() in ('0.0F', '0F', '0.0', '0', '0.0f', '0f')

def emit_pose(p):
    t = [x if x is not None else '0.0F' for x in p.pose]
    r = [x if x is not None else '0.0F' for x in p.rot]
    if all(is_zero(x) for x in r):
        return 'PartPose.offset(%s, %s, %s)' % tuple(num(x) for x in t)
    return 'PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)' % tuple(num(x) for x in t + r)


def gen_layer(order, texw, texh, named_tex):
    lines = []
    lines.append('\tpublic static LayerDefinition createBodyLayer()')
    lines.append('\t{')
    lines.append('\t\tMeshDefinition meshdefinition = new MeshDefinition();')
    lines.append('\t\tPartDefinition partdefinition = meshdefinition.getRoot();')
    lines.append('')
    emitted = set()
    counter = [0]

    def emit(p, parent_var):
        name = mesh_name(p.expr)
        var = 'partdef%d' % counter[0]
        counter[0] += 1
        cb = emit_cube_builder(p, named_tex)
        pose = emit_pose(p)
        lines.append('\t\tPartDefinition %s = %s.addOrReplaceChild("%s", %s, %s);' % (var, parent_var, name, cb, pose))
        emitted.add(p.expr)
        for c in p.children:
            emit(c, var)

    for p in order:
        if p.expr in emitted or p.parent is not None:
            continue
        emit(p, 'partdefinition')
    # orphans (shouldn't happen)
    for p in order:
        if p.expr not in emitted:
            emit(p, 'partdefinition')
    lines.append('')
    lines.append('\t\treturn LayerDefinition.create(meshdefinition, %d, %d);' % (texw, texh))
    lines.append('\t}')
    return lines


def gen_bake(order):
    lines = []
    for p in order:
        chain = []
        cur = p
        while cur is not None:
            chain.append(mesh_name(cur.expr))
            cur = cur.parent
        chain.reverse()
        rhs = 'root'
        for c in chain[:-1]:
            rhs += '.getChild("%s")' % c
        rhs += '.getChild("%s")' % chain[-1]
        lines.append('\t\tthis.%s = %s;' % (p.expr, rhs))
    return lines


def rewrite_body(body, in_render=False, parts=None):
    def rawpos(name, idx):
        if parts is not None:
            p = parts.get(part_key(name))
            if p is not None:
                return p.rawpose[idx] or '0F'
        return '0F'
    out = []
    for raw in body.split('\n'):
        line = raw
        if re.search(r'GlStateManager\.(enableBlend|disableBlend|blendFunc|tryBlendFuncSeparate|enableCull|disableCull|enableLighting|disableLighting|enableAlpha|disableAlpha|enableRescaleNormal|disableRescaleNormal|depthMask|setActiveTexture|enableTexture2D|disableTexture2D|enableBlendProfile|disableBlendProfile|glTexEnv|glTexEnvi|enableNormalize|disableNormalize|alphaFunc|depthFunc|colorMaterial|pushAttrib|popAttrib)\b', line):
            continue
        if re.search(r'OpenGlHelper\.setLightmapTextureCoords', line):
            if re.search(r'240', line):
                out.append('\t\tglowLight = true;')
            else:
                out.append('\t\tglowLight = false;')
            continue
        if in_render:
            line = re.sub(r'\bGlStateManager\.pushMatrix\(\)', 'poseStack.pushPose()', line)
            line = re.sub(r'\bGlStateManager\.popMatrix\(\)', 'poseStack.popPose()', line)
            line = re.sub(r'\bGlStateManager\.translate\(', 'poseStack.translate(', line)
            line = re.sub(r'\bGlStateManager\.scale\(', 'poseStack.scale(', line)
            line = re.sub(r'\bGlStateManager\.rotate\(', 'RenderHelper.rotate(poseStack, ', line)
        else:
            line = re.sub(r'\bGlStateManager\.(pushMatrix|popMatrix)\(\);?', '', line)
            mtr = re.search(r'\bGlStateManager\.translate\(([^;]*)\)', line)
            if mtr:
                a = split_args(mtr.group(1))
                while len(a) < 3: a.append('0F')
                line = re.sub(r'.*GlStateManager\.translate\([^;]*;',
                              'this.animTransX += (%s); this.animTransY += (%s); this.animTransZ += (%s);' % tuple(a[:3]), line)
            line = re.sub(r'\bGlStateManager\.rotate\(', 'RenderHelper.animRotate(this, ', line)
            line = re.sub(r'\bGlStateManager\.scale\(', 'RenderHelper.animScale(this, ', line)
        line = re.sub(r'\bGlStateManager\.color\([^;]*;', '/* GL color removed */;', line)
        line = re.sub(r'\bMathHelper\.', 'Mth.', line)
        line = re.sub(r'\bnew Vec3d\(', 'new Vec3(', line)
        line = re.sub(r'\bVec3d\b', 'Vec3', line)
        line = re.sub(r'\bEnumHandSide\b', 'HumanoidArm', line)
        line = re.sub(r'\bModelRenderer\b', 'ModelPart', line)
        line = re.sub(r'\bEntityLivingBase\b', 'LivingEntity', line)
        line = re.sub(r'\bEntityLiving\b', 'Mob', line)
        line = re.sub(r'\bEntityPlayer\b', 'Player', line)
        line = re.sub(r'\bticksExisted\b', 'tickCount', line)
        line = re.sub(r'\bthis\.isSneak\b', 'entity.isShiftKeyDown()', line)
        line = re.sub(r'\bthis\.isRiding\b', 'entity.isPassenger()', line)
        line = re.sub(r'\bthis\.isChild\b', 'entity.isBaby()', line)
        line = re.sub(r'\bthis\.swingProgress\b', 'entity.getAttackAnim(f2)', line)
        # misc model entity pos -> MiscModel.posX/Y/Z
        line = re.sub(r'(\w+)\.entity\.pos([XYZ])\b', r'\1.pos\2', line)
        # part.render(f5) -> render(poseStack, vertexConsumer, light, overlay)
        line = re.sub(r'\.render\(f5\)', '.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay)', line)
        if re.search(r'\bsetRotationAngles\(f', line) and 'public' not in line:
            continue
        if re.search(r'\bsuper\.render\(', line) or re.search(r'\bsuper\.setRotationAngles\(', line):
            continue
        line = re.sub(r'\.rotateAngleX\b', '.xRot', line)
        line = re.sub(r'\.rotateAngleY\b', '.yRot', line)
        line = re.sub(r'\.rotateAngleZ\b', '.zRot', line)
        line = re.sub(r'\.rotationPointX\b', '.x', line)
        line = re.sub(r'\.rotationPointY\b', '.y', line)
        line = re.sub(r'\.rotationPointZ\b', '.z', line)
        line = re.sub(r'\.showModel\b', '.visible', line)
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.isHidden\s*=\s*true', r'\1.visible = false', line)
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.isHidden\s*=\s*false', r'\1.visible = true', line)
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.isHidden\s*=\s*([^;]+)', r'\1.visible = !(\2)', line)
        line = re.sub(r'!(\w+(?:\.\w+)?(?:\[\d+\])?)\.isHidden\b', r'\1.visible', line)
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.isHidden\b', r'!\1.visible', line)
        def off_assign(m):
            if parts is None or parts.get(part_key(m.group(1))) is None:
                return m.group(0)
            return '%s.%s = (%s) + (%s) * 16F' % (
                m.group(1), m.group(2).lower(), rawpos(m.group(1), 'XYZ'.index(m.group(2))), m.group(3))
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.offset([XYZ])\s*=\s*([^;]+)', off_assign, line)
        def off_read(m):
            if parts is None or parts.get(part_key(m.group(1))) is None:
                return m.group(0)
            return '((%s.getInitialPose().%s - (%s)) / 16F)' % (
                m.group(1), m.group(2).lower(), rawpos(m.group(1), 'XYZ'.index(m.group(2))))
        line = re.sub(r'(\w+(?:\.\w+)?(?:\[\d+\])?)\.offset([XYZ])\b(?!\s*=)', off_read, line)
        line = re.sub(r'\bgetRidingEntity\(\)', 'getVehicle()', line)
        line = re.sub(r'\bent\.isSitting\(\)', 'ent.getIsSitting()', line)
        line = re.sub(r'\bent\.isSneaking\(\)', 'ent.getIsSneaking()', line)
        line = re.sub(r'\.isSitting\(\)', '.isInSittingPose()', line)
        line = re.sub(r'\.isSneaking\(\)', '.isShiftKeyDown()', line)
        line = re.sub(r'\bgetRNG\(\)', 'getRandom()', line)
        line = re.sub(r'\b\w+\.getBrightnessForRender\([^)]*\)', 'packedLight', line)
        line = re.sub(r'(\w+)\.prevLimbSwingAmount \+ \(\1\.limbSwingAmount - \1\.prevLimbSwingAmount\) \* \(f2 - \(int\)f2\)',
                      r'\1.walkAnimation.speed(f2 - (int)f2)', line)
        line = re.sub(r'(\w+)\.limbSwing - \1\.limbSwingAmount \* \(1\.0F - \(f2 - \(int\)f2\)\)',
                      r'\1.walkAnimation.position(f2 - (int)f2)', line)
        line = re.sub(r'\.prevLimbSwingAmount\b', '.walkAnimation.speed()', line)
        line = re.sub(r'\.limbSwingAmount\b', '.walkAnimation.speed()', line)
        line = re.sub(r'\.limbSwing\b', '.walkAnimation.position()', line)
        line = re.sub(r'\bthis\.render\(null, 0F, 0F, 0F, 0F, 0F, f5\)',
                      'this.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, -1)', line)
        mgl = re.search(r'\bGL11\.glTranslatef\(([^;]*)\)', line)
        if mgl:
            a = split_args(mgl.group(1))
            while len(a) < 3: a.append('0F')
            line = re.sub(r'.*GL11\.glTranslatef\([^;]*;',
                          'this.animTransX += (%s); this.animTransY += (%s); this.animTransZ += (%s);' % tuple(a[:3]), line)
        out.append(line)
    return '\n'.join(out)


def convert_sig(header, cls):
    # strip line comments first, then annotations, then join
    h = '\n'.join(re.sub(r'//.*', '', l) for l in header.split('\n'))
    h = re.sub(r'@\w+', '', h)
    h = ' '.join(h.split()).strip()
    if not h:
        return None, 'drop'
    if re.match(r'^(?:public|private|protected)?\s*void (setRotateAngle|setRotation)\(ModelPart \w+, float \w+, float \w+, float \w+\)$', h) or \
       re.match(r'^(?:public|private|protected)?\s*void (setRotateAngle|setRotation)\(ModelRenderer \w+, float \w+, float \w+, float \w+\)$', h):
        return None, 'drop'  # helpers live in base class
    if re.match(r'^(public )?%s\(\)' % cls, h):
        return None, 'ctor'
    if re.match(r'public void render\(Entity entity, float f, float f1, float f2, float f3, float f4, float f5\)', h):
        return '@Override\n\tpublic void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color)', 'render'
    if re.match(r'public void render\(float f5\)', h) or re.match(r'public void renderModel\(float f5\)', h):
        return 'public void renderModel(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay)', 'renderModel'
    m = re.match(r'public void setRotationAngles\((.*)\)', h)
    if m:
        a = split_args(m.group(1))
        names = [x.split()[-1] for x in a]
        return '@Override\n\tpublic void setupAnim(T entity, float %s, float %s, float %s, float %s, float %s)' % tuple(names[:5]), 'setupAnim'
    if 'setLivingAnimations' in h:
        h2 = re.sub(r'setLivingAnimations\(EntityLivingBase \w+, float (\w+), float (\w+), float (\w+)\)',
                    r'prepareMobModel(T entity, float \1, float \2, float \3)', h)
        return '@Override\n\t' + h2, 'method'
    h2 = h
    h2 = re.sub(r'\bShipModelRenderer\b', 'ModelPart', h2)
    h2 = re.sub(r'\bModelRenderer\b', 'ModelPart', h2)
    h2 = re.sub(r'\bEnumHandSide\b', 'HumanoidArm', h2)
    h2 = re.sub(r'\bEntityLivingBase\b', 'LivingEntity', h2)
    h2 = re.sub(r'\bEntityLiving\b', 'Mob', h2)
    h2 = re.sub(r'\bEntityPlayer\b', 'Player', h2)
    return h2, 'method'


def convert_file(path):
    src = open(path).read()
    cls = os.path.basename(path)[:-5]
    m = re.search(r'public class %s extends (\w+)([^\{]*)\{' % cls, src)
    if not m:
        return None, ['no class decl']
    base = m.group(1)
    implements = 'IModelEmotion' in m.group(2)

    members = parse_members(src)
    ctor_body = None
    methods = []
    fields = []
    raws = []
    for kind, header, body in members:
        if kind == 'field':
            fields.append(header)
        elif kind == 'raw':
            raws.append(header)
        elif kind == 'method':
            # strip line comments BEFORE joining lines, or '//' would eat the signature
            h = ' '.join(' '.join(re.sub(r'//.*', '', l) for l in header.split('\n')).split()).strip()
            if re.match(r'^(public )?%s\(\)' % cls, h):
                ctor_body = body
            else:
                methods.append((h, body))

    if ctor_body is None:
        return None, ['no ctor']

    parts, order, keep, (texw, texh), named_tex, warns = parse_ctor(ctor_body, cls)

    if base == 'ShipModelBaseAdv':
        ext = 'ShipModelBaseAdv<T>'
    elif base == 'ShipModelBase':
        ext = 'ShipModelBase<T>'
    else:
        ext = 'ShipModel<T>'

    out = []
    out.append('package com.lulan.shincolle.client.model;')
    out.append('')
    out.append('import java.util.ArrayList;')
    out.append('import java.util.Random;')
    out.append('')
    out.append('import com.lulan.shincolle.entity.BasicEntityMount;')
    out.append('import com.lulan.shincolle.entity.BasicEntityShip;')
    out.append('import com.lulan.shincolle.entity.BasicEntityShipCV;')
    out.append('import com.lulan.shincolle.entity.BasicEntityShipHostile;')
    out.append('import com.lulan.shincolle.entity.BasicEntitySummon;')
    out.append('import com.lulan.shincolle.entity.IFloatingEntity;')
    out.append('import com.lulan.shincolle.entity.IShipEmotion;')
    out.append('import com.lulan.shincolle.entity.IShipRiderType;')
    out.append('import com.lulan.shincolle.entity.IShipState;')
    out.append('import com.lulan.shincolle.entity.EntityDestroyerAkatsuki;')
    out.append('import com.lulan.shincolle.entity.EntityDestroyerInazuma;')
    out.append('import com.lulan.shincolle.reference.ID;')
    out.append('import com.lulan.shincolle.reference.Values;')
    out.append('import com.lulan.shincolle.utility.CalcHelper;')
    out.append('import com.lulan.shincolle.utility.EmotionHelper;')
    out.append('import com.lulan.shincolle.utility.RenderHelper;')
    out.append('')
    out.append('import com.mojang.blaze3d.vertex.PoseStack;')
    out.append('import com.mojang.blaze3d.vertex.VertexConsumer;')
    out.append('')
    out.append('import net.minecraft.client.model.geom.ModelPart;')
    out.append('import net.minecraft.client.model.geom.PartPose;')
    out.append('import net.minecraft.client.model.geom.builders.CubeDeformation;')
    out.append('import net.minecraft.client.model.geom.builders.CubeListBuilder;')
    out.append('import net.minecraft.client.model.geom.builders.LayerDefinition;')
    out.append('import net.minecraft.client.model.geom.builders.MeshDefinition;')
    out.append('import net.minecraft.client.model.geom.builders.PartDefinition;')
    out.append('import net.minecraft.client.renderer.LightTexture;')
    out.append('import net.minecraft.util.Mth;')
    out.append('import net.minecraft.world.entity.Entity;')
    out.append('import net.minecraft.world.entity.HumanoidArm;')
    out.append('import net.minecraft.world.entity.LivingEntity;')
    out.append('import net.minecraft.world.entity.Mob;')
    out.append('import net.minecraft.world.entity.player.Player;')
    out.append('import net.minecraft.world.phys.Vec3;')
    out.append('')

    impl = ''
    if implements and ext == 'ShipModel<T>':
        impl = ' implements IModelEmotion'
    out.append('public class %s<T extends Entity> extends %s%s' % (cls, ext, impl))
    out.append('{')
    out.append('')

    for f in fields:
        for l in f.strip().split('\n'):
            l2 = l.rstrip()
            if not l2.strip():
                continue
            l2 = re.sub(r'\bShipModelRenderer\b', 'ModelPart', l2)
            l2 = re.sub(r'\bModelRenderer\b', 'ModelPart', l2)
            l2 = re.sub(r'\bEnumHandSide\b', 'HumanoidArm', l2)
            l2 = re.sub(r'\bVec3d\b', 'Vec3', l2)
            l2 = re.sub(r'\bEntityLivingBase\b', 'LivingEntity', l2)
            out.append('\t' + l2.strip())
    out.append('')

    out += gen_layer(order, texw, texh, named_tex)
    out.append('')

    out.append('\tpublic %s(ModelPart root)' % cls)
    out.append('\t{')
    for l in gen_bake(order):
        out.append(l)
    for l in keep:
        l2 = l
        l2 = re.sub(r'\bShipModelRenderer\b', 'ModelPart', l2)
        l2 = re.sub(r'\bModelRenderer\b', 'ModelPart', l2)
        l2 = re.sub(r'\bVec3d\b', 'Vec3', l2)
        l2 = re.sub(r'\bEnumHandSide\b', 'HumanoidArm', l2)
        out.append('\t\t' + l2.strip())
    for p in order:
        if p.hidden:
            out.append('\t\tthis.%s.visible = false;' % p.expr)
    out.append('\t}')
    out.append('')

    render_pre = []
    render_post = []
    setupAnim_present = False
    for header, body in methods:
        h = ' '.join(re.sub(r'//.*','',l) for l in header.split()).strip()
        h = re.sub(r'@\w+', '', h).strip()
        if re.match(r'public void render\(Entity entity, float', h):
            # split body at setRotationAngles call
            lines = body.split('\n')
            idx = None
            for i, l in enumerate(lines):
                if 'setRotationAngles(' in l and 'public' not in l:
                    idx = i; break
            if idx is None:
                render_post = lines
            else:
                render_pre = lines[:idx]
                render_post = lines[idx+1:]
                # rebalance braces: blocks opened in pre but closed in post
                # (e.g. `if (ticksExisted > 6) {` wrapping the whole render)
                net = sum(l.count('{') - l.count('}') for l in render_pre)
                if net > 0:
                    dropped = 0
                    kept = []
                    for l in render_post:
                        o, c = l.count('{'), l.count('}')
                        if dropped < net and c > o:
                            # drop (c-o) surplus closers but cap at what pre opened
                            surplus = c - o
                            take = min(surplus, net - dropped)
                            if take == c and o == 0:
                                dropped += take
                                continue  # whole line was closers
                            # partial: strip `take` closing braces from the line
                            l2 = l
                            for _ in range(take):
                                l2 = re.sub(r'}', '', l2, count=1)
                            dropped += take
                            l = l2
                        kept.append(l)
                    render_post = kept
                    render_pre = render_pre + ['\t}' * 1] * net
        if re.match(r'public void setRotationAngles\(', h):
            setupAnim_present = True

    setup_param_names = None
    for header, body in methods:
        h = re.sub(r'@\w+', '', ' '.join(' '.join(re.sub(r'//.*','',l) for l in header.split('\n')).split())).strip()
        m = re.match(r'public void setRotationAngles\((.*)\)', h)
        if m:
            a = split_args(m.group(1))
            setup_param_names = [x.split()[-1] for x in a][:5]

    for header, body in methods:
        newh, kind = convert_sig(header, cls)
        if newh is None:
            continue
        out.append('\t' + newh)
        out.append('\t{')
        if kind == 'render':
            out.append('\t\tEntity entity = this.entity;')
            out.append('\t\tfloat[] _a = this.beginRender();')
            out.append('\t\tfloat f = _a[0], f1 = _a[1], f2 = _a[2], f3 = _a[3], f4 = _a[4];')
            out.append('\t\tposeStack.translate(this.animTransX, this.animTransY, this.animTransZ);')
            out.append('\t\tposeStack.mulPose(this.animRot);')
            out.append('\t\tposeStack.scale(this.animScaleX, this.animScaleY, this.animScaleZ);')
            out.append(rewrite_body('\n'.join(render_post), in_render=True, parts=parts))
        elif kind == 'setupAnim':
            pn = setup_param_names or ['f','f1','f2','f3','f4']
            out.append('\t\tthis.captureAnimParms(entity, %s);' % ', '.join(pn))
            out.append(rewrite_body('\n'.join(render_pre), parts=parts))
            out.append(rewrite_body(body, parts=parts))
        elif kind == 'renderModel':
            out.append(rewrite_body(body, in_render=True, parts=parts))
        else:
            out.append(rewrite_body(body, parts=parts))
        out.append('\t}')
        out.append('')

    # emit setupAnim override when needed
    if render_pre and not setupAnim_present:
        out.append('\t@Override')
        out.append('\tpublic void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)')
        out.append('\t{')
        out.append('\t\tthis.captureAnimParms(entity, f, f1, f2, f3, f4);')
        out.append(rewrite_body('\n'.join(render_pre), parts=parts))
        if ext != 'ShipModel<T>':
            out.append('\t\tsuper.setupAnim(entity, f, f1, f2, f3, f4);')
        out.append('\t}')
        out.append('')
    elif not setupAnim_present:
        # EntityModel.setupAnim is abstract - provide capture-only impl
        out.append('\t@Override')
        out.append('\tpublic void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)')
        out.append('\t{')
        out.append('\t\tthis.captureAnimParms(entity, f, f1, f2, f3, f4);')
        if ext != 'ShipModel<T>':
            out.append('\t\tsuper.setupAnim(entity, f, f1, f2, f3, f4);')
        out.append('\t}')
        out.append('')

    for r in raws:
        out.append(rewrite_body(r))

    out.append('}')
    out.append('')
    return '\n'.join(out), warns


def main():
    files = sorted(glob.glob(os.path.join(SRC, "*.java")))
    fail = []
    for f in files:
        b = os.path.basename(f)
        if b in SKIP:
            continue
        try:
            r = convert_file(f)
            if r is None:
                fail.append(b)
                continue
            text, warns = r
            open(os.path.join(DST, b), 'w').write(text)
            if warns:
                print('WARN', b)
                for w in warns: print('   ', w)
        except Exception as e:
            import traceback; traceback.print_exc()
            fail.append(b)
    print('FAILED:', fail)

if __name__ == '__main__':
    main()
