package com.lulan.shincolle.client.particle;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/**
 * base class for ShinColle custom particles.
 *
 * Legacy 1.12.2 particles each ran their own Tessellator draw inside
 * renderParticle (FX layer 3 = custom). In 1.21 the engine shares one
 * BufferBuilder per ParticleRenderType, so these particles declare
 * {@link ParticleRenderType#CUSTOM} (its shared buffer is simply left
 * empty) and draw through their own private Tesselator inside
 * {@link #render} instead.
 */
public abstract class ShipParticle extends Particle
{

    /** private tessellator for per-particle custom draws */
    protected static final Tesselator TESSELATOR = new Tesselator(4096);

    /** frustum-culling-proof box: legacy particles were never frustum culled */
    private static final AABB RENDER_BOX =
        new AABB(-3.0E7D, -1.0E4D, -3.0E7D, 3.0E7D, 1.0E4D, 3.0E7D);

    /** legacy particleScale (vertex-space size multiplier) */
    protected float particleScale = 0.1F * (this.random.nextFloat() * 0.5F + 0.5F) * 2.0F;


    protected ShipParticle(ClientLevel level, double x, double y, double z)
    {
        super(level, x, y, z);
    }

    protected ShipParticle(ClientLevel level, double x, double y, double z, double mx, double my, double mz)
    {
        super(level, x, y, z, mx, my, mz);
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    public AABB getRenderBoundingBox(float partialTicks)
    {
        return RENDER_BOX;
    }

    /** legacy texture index (0-7) for particles.png frame animation */
    protected int texIndex = 0;

    /** legacy setParticleTextureIndex stub; stores frame index 0-7 */
    protected void setParticleTextureIndex(int index)
    {
        this.texIndex = index;
    }

    /**
     * Draw a standard camera-facing quad using a sprite from the particle atlas.
     * Replaces the legacy default Particle.renderParticle billboard quad.
     */
    protected void renderAtlasQuad(Camera camera, float ptick, String spriteName)
    {
        TextureAtlas atlas = (TextureAtlas) Minecraft.getInstance().getTextureManager()
                .getTexture(TextureAtlas.LOCATION_PARTICLES);
        TextureAtlasSprite icon = atlas.getSprite(
                ResourceLocation.withDefaultNamespace(spriteName));
        Vec3 cam = camera.getPosition();
        float px = (float)(Mth.lerp(ptick, this.xo, this.x) - cam.x);
        float py = (float)(Mth.lerp(ptick, this.yo, this.y) - cam.y);
        float pz = (float)(Mth.lerp(ptick, this.zo, this.z) - cam.z);
        Quaternionf q = new Quaternionf(camera.rotation());
        float scale = this.particleScale;
        float u0 = icon.getU0(), u1 = icon.getU1();
        float v0 = icon.getV0(), v1 = icon.getV1();
        int light = this.getLightColor(ptick);

        BufferBuilder buf = TESSELATOR.begin(VertexFormat.Mode.QUADS,
                DefaultVertexFormat.PARTICLE);
        Vector3f[] corners = new Vector3f[] {
                new Vector3f(-1F, -1F, 0F), new Vector3f(-1F, 1F, 0F),
                new Vector3f(1F, 1F, 0F), new Vector3f(1F, -1F, 0F)};
        for (int i = 0; i < 4; i++)
        {
            corners[i].rotate(q).mul(scale).add(px, py, pz);
        }
        buf.addVertex(corners[0].x, corners[0].y, corners[0].z).setUv(u1, v1)
           .setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(light);
        buf.addVertex(corners[1].x, corners[1].y, corners[1].z).setUv(u1, v0)
           .setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(light);
        buf.addVertex(corners[2].x, corners[2].y, corners[2].z).setUv(u0, v0)
           .setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(light);
        buf.addVertex(corners[3].x, corners[3].y, corners[3].z).setUv(u0, v1)
           .setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(light);

        RenderSystem.setShader(GameRenderer::getParticleShader);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        drawBuf(buf);
    }

    /** draw accumulated vertices; does nothing when the buffer is empty */
    protected static void drawBuf(BufferBuilder buf)
    {
        MeshData mesh = buf.build();
        if (mesh != null) BufferUploader.drawWithShader(mesh);
    }


}
