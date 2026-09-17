package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Reference;

import java.util.ArrayList;
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
import com.lulan.shincolle.reference.Reference;

/**MISS PARTICLE
 * 攻擊miss時發出文字特效 type:0:miss 1:critical 2:double hit 3:triple hit
 * tut: https://github.com/Draco18s/Artifacts/blob/master/main/java/com/draco18s/artifacts/client/RadarParticle.java
 */
public class ParticleTexts extends ShipParticle
{

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particletexts.png");
    private int particleType;    //0:miss 1:critical 2:double hit 3:triple hit 4:dodge

    
    public ParticleTexts(ClientLevel level, double x, double y, double z, float scale, int type)
    {
        super(level, x, y, z);
        this.setSize(0F, 0F);
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0.1D;
        this.particleScale = scale;
        this.lifetime = 25;
        this.particleType = type;
        this.hasPhysics = false;    //can clip = false
    }

    @Override
	public void render(VertexConsumer _vc, Camera camera, float ptick)
	{
		Vec3 _cam = camera.getPosition();
		Entity entity = camera.getEntity();
		double interpPosX = _cam.x, interpPosY = _cam.y, interpPosZ = _cam.z;
		float cosYaw = Mth.cos(camera.getYRot() * Mth.DEG_TO_RAD);
		float cosPitch = Mth.cos(camera.getXRot() * Mth.DEG_TO_RAD);
		float sinYaw = Mth.sin(camera.getYRot() * Mth.DEG_TO_RAD);
		float _sp = Mth.sin(camera.getXRot() * Mth.DEG_TO_RAD);
		float sinYawsinPitch = sinYaw * _sp;
		float cosYawsinPitch = cosYaw * _sp;
		BufferBuilder render = null;

        RenderSystem.setShaderTexture(0, TEXTURE);
        
        
        RenderSystem.depthMask(true);
        
        
        float f6 = 0F;
        float f7 = 1F;
        float f8 = particleType / 5F;
        float f9 = (particleType + 1F) / 5F;
        
        float f10 = 0.8F;
        float f11 = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float f12 = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float f13 = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);

        //start
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
        
        
        //X跟Z位置不加頭部轉動偏移, 只有Y軸會偏向玩家方向
        render.addVertex((float)(f11 - cosYaw * f10), (float)(f12 - cosPitch * 0.2F), (float)(f13 - sinYaw * f10)).setUv((float)(f7), (float)(f9));;
        render.addVertex((float)(f11 - cosYaw * f10), (float)(f12 + cosPitch * 0.2F), (float)(f13 - sinYaw * f10)).setUv((float)(f7), (float)(f8));;
        render.addVertex((float)(f11 + cosYaw * f10), (float)(f12 + cosPitch * 0.2F), (float)(f13 + sinYaw * f10)).setUv((float)(f6), (float)(f8));;
        render.addVertex((float)(f11 + cosYaw * f10), (float)(f12 - cosPitch * 0.2F), (float)(f13 + sinYaw * f10)).setUv((float)(f6), (float)(f9));;
       
        //draw
        drawBuf(render);
        
        
        RenderSystem.depthMask(false);
        
    }
    
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick()
    {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ > this.lifetime)
        {
            this.remove();
        }

        this.move(this.xd, this.yd, this.zd);
        this.yd *= 0.9D;
    }
    
    
}
