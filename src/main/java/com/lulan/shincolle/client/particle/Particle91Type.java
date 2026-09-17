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

/**91TYPE PARTICLE
 * 攻擊文字特效
 */
public class Particle91Type extends ShipParticle
{

	private static final ResourceLocation TEXTURE1 = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particle91type.png");
	private int partAge;
	private int fadeTime = 16;
	private int middTime = 60;
	private int totalTime = 2 * fadeTime + middTime;
	private float minu, maxu ,x , y, z, scale, alpha;
	private float fadeCoef = 1F / fadeTime;
	
	
    public Particle91Type(ClientLevel level, double x, double y, double z, float scale)
    {
        super(level, 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.setPos(x, y + this.random.nextDouble() * 4F, z);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.lifetime = 136;
        this.hasPhysics = false;	//can clip = false
    }

    /**
     * parms:
     * BufferBuilder, particle entity, cos(Yaw), cos(Pitch), -sin(Yaw) * sin(Pitch), cos(Yaw) * sin(Pitch)
     */
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

    	RenderSystem.setShaderTexture(0, TEXTURE1);
    	
    	
    	RenderSystem.depthMask(true);
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
        
        /**draw text
         * age: 0  ~ 15: color fade in (RGB=0% -> RGB=100%)
         *      16 ~ 55: no change
         *      56 ~ 70: alpha fade out (ALPHA=100% -> ALPHA=0%)
         */
		render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
		
		
        for (int i = 0; i < 6; ++i)
        {
        	partAge = this.age - i * 8;

        	if (partAge > -1 && partAge < totalTime)
        	{
        		//particle是以玩家視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
            	float f11 = (float)(this.xo + (this.x - this.xo) * (double)ptick - interpPosX);
            	float f12 = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY);
            	float f13 = (float)(this.zo + (this.z - this.zo) * (double)ptick - interpPosZ);

        		minu = 1F / 6F * i;
        		maxu = 1F / 6F * (i + 1);
        		x = f11 - (i - 2.5F) * this.particleScale * 2F * cosYaw;
                y = f12;
                z = f13 - (i - 2.5F) * this.particleScale * 2F * sinYaw;
//                x = (float)(this.x - interpPosX - (i - 2.5F) * this.particleScale * 2F * cosYaw);
//                y = (float)(this.y - interpPosY);
//                z = (float)(this.z - interpPosZ - (i - 2.5F) * this.particleScale * 2F * sinYaw);
        	
                if (partAge < fadeTime)
                {	//0~10: color fade in
                	scale = this.particleScale * (3F - 2F * fadeCoef * partAge);
                	alpha = fadeCoef * partAge;
                }
                else if (partAge >= (fadeTime + middTime))
                {	//71~80: alpha fade out
                	partAge -= (fadeTime + middTime);
                	scale = this.particleScale * (1F + 2F * fadeCoef * partAge);
                	alpha = 1F - fadeCoef * partAge;
                }
                else
                {	//other
                	scale = this.particleScale;
                	alpha = 1F;
                }
                
            	addQuad(render, scale, x, y, z, cosYaw, cosPitch, sinYaw, minu, maxu, 0F, 1F);
        	}
        }
  
        drawBuf(render);
        
    	
    	RenderSystem.disableBlend();
    	RenderSystem.depthMask(false);
    	
    }

    //add quad with size
	private void addQuad(BufferBuilder render, float scale, float x, float y, float z, float offx, float offy, float offz, float minu, float maxu, float minv, float maxv)
	{
        float offsetX = offx * scale;
        float offsetY = offy * scale;
        float offsetZ = offz * scale;
        
        render.addVertex((float)(x - offsetX), (float)(y - offsetY), (float)(z - offsetZ)).setUv((float)(maxu), (float)(maxv)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(alpha));;
        render.addVertex((float)(x - offsetX), (float)(y + offsetY), (float)(z - offsetZ)).setUv((float)(maxu), (float)(minv)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(alpha));;
        render.addVertex((float)(x + offsetX), (float)(y + offsetY), (float)(z + offsetZ)).setUv((float)(minu), (float)(minv)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(alpha));;
        render.addVertex((float)(x + offsetX), (float)(y - offsetY), (float)(z + offsetZ)).setUv((float)(minu), (float)(maxv)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(alpha));;	
	}

	//layer: 0:particle 1:terrain 2:items 3:custom?
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
