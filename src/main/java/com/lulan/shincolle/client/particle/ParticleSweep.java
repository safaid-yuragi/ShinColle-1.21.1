package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.LogHelper;

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
import com.lulan.shincolle.reference.Values;

/**
 * SPHERE LIGHT PARTICLE
 */
public class ParticleSweep extends ShipParticle
{
	
	private static final ResourceLocation TEXTURE1 = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/entity/sweep.png");
    private int particleType;
	private Entity host;
	private float swpFad, swpSpd, swpScale1, swpScale2, swpScale3, swpAngle;
	
	
    public ParticleSweep(Entity entity, int type, float...parms)
    {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        
        switch (type)
        {
        /**
	     * type 0: sword sweep right to left
	     * parms: 0:scale1, 1:scale2, 2:fade, 3:speed , 3~6:RGBA
	     *   scale1: 高度
	     *   scale2: 前後寬度
	     *   scale3: 左右寬度, 使特效由垂直變斜
         */
        case 0:
        	this.swpScale1 = parms[0];
        	this.swpScale2 = parms[1];
        	this.swpScale3 = parms[2];
        	this.swpFad = parms[3];
        	this.lifetime = (int) parms[4];
        	this.rCol = parms[5];
            this.gCol = parms[6];
            this.bCol = parms[7];
            this.alpha = parms[8];
            this.setPos(entity.getX(), entity.getY() + entity.getBbHeight() * 0.6F, entity.getZ());
            
        	if (this.host instanceof LivingEntity)
        	{
        		this.swpAngle = ((LivingEntity) this.host).yBodyRot;
        	}
        	else
        	{
        		this.swpAngle = this.host.getYRot();
        	}
        break;
        }
        
        //init pos
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
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

    	int i = (int) ((float)(this.age + ptick) / (float)this.lifetime * 8F);
    	if (i >= 8) return;
    	
    	RenderSystem.setShaderTexture(0, TEXTURE1);
    	
        float x = (float)(this.xo + (this.x - this.xo) * (double)ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * (double)ptick - interpPosZ);
        float minU = (float)(i % 4) * 0.25F;
        float maxU = minU + 0.24975F;
        float minV = (float)(i / 4) * 0.5F;
        float maxV = minV + 0.4995F;
//        float minU = 0.75F;
//        float maxU = minU + 0.24975F;
//        float minV = 0F;
//        float maxV = minV + 0.4995F;
        float[] pos1 = CalcHelper.rotateXZByAxis(entity.getBbWidth() * 0.35F, 0F, this.swpAngle * Values.N.DIV_PI_180, 1F);
        
        
        RenderSystem.depthMask(true);
        
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
        
        
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        
        //正面
        render.addVertex((float)(x + pos1[1] - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * pos1[1])).setUv((float)((double)minU), (float)((double)minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] + this.swpScale3 * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] - this.swpScale3 * pos1[1])).setUv((float)((double)minU), (float)((double)maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //反面
        render.addVertex((float)(x + pos1[1] + this.swpScale3 * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] - this.swpScale3 * pos1[1])).setUv((float)((double)minU), (float)((double)maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * pos1[1])).setUv((float)((double)minU), (float)((double)minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        
        pos1 = CalcHelper.rotateXZByAxis(entity.getBbWidth() * 0.3F, 0F, this.swpAngle * Values.N.DIV_PI_180 - 0.001F, 1F);
        
        //正面
        render.addVertex((float)(x + pos1[1] - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)maxV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)minV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * 1.25F * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * 1.25F * pos1[1])).setUv((float)((double)minU), (float)((double)minV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] + this.swpScale3 * 1.25F * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] - this.swpScale3 * 1.25F * pos1[1])).setUv((float)((double)minU), (float)((double)maxV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        //反面
        render.addVertex((float)(x + pos1[1] + this.swpScale3 * 1.25F * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] - this.swpScale3 * 1.25F * pos1[1])).setUv((float)((double)minU), (float)((double)maxV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 * 1.25F + this.swpScale3 * 1.25F * pos1[0]), (float)(y + this.swpScale1 * 0.8F), (float)(z + pos1[0] * this.swpScale2 * 1.25F - this.swpScale3 * 1.25F * pos1[1])).setUv((float)((double)minU), (float)((double)minV)).setColor((float)(this.rCol), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)minV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        render.addVertex((float)(x + pos1[1] - this.swpScale3 * pos1[0]), (float)(y - this.swpScale1 * 0.5F), (float)(z + pos1[0] + this.swpScale3 * pos1[1])).setUv((float)((double)maxU), (float)((double)maxV)).setColor((float)(this.rCol * 0.5F), (float)(this.gCol * 0.5F), (float)(this.bCol * 0.5F), (float)(this.alpha));;
        
        drawBuf(render);
        
        RenderSystem.disableBlend();
    	
    	
    }
    
    @Override
    public int getLightColor(float p_189214_1_)
    {
        return 61680;
    }
    
    //layer: 0:particle 1:terrain 2:items 3:custom
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
        //update age
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
        
    	//update movement
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setPos(this.host.getX(), this.host.getY() + this.host.getBbHeight() * 0.6F, this.host.getZ());

        //update beam
        switch (this.particleType)
        {
        case 0:		//out from host's back
        {
        	//angle
        	if (this.host instanceof LivingEntity)
        	{
        		this.swpAngle = ((LivingEntity) this.host).yBodyRot;
        	}
        	else
        	{
        		this.swpAngle = this.host.getYRot();
        	}
        	
        	//alpha
        	float age = (float)this.age / (float)this.lifetime;
        	this.alpha *= 0.6F;
        }
        break;
        }
        
    }
    
    
}
