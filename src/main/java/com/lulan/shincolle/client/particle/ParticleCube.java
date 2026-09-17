package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;

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

/** CUBE PARTICLE
 *  生成兩層方塊, 外殼半透明, 方塊可變大小跟震動等
 * 
 * type:
 *   0: 大和波動砲集氣特效: 震動雙層方塊
 *   
 */
public class ParticleCube extends ShipParticle
{

	private int particleType;
	private float shotYaw, shotPitch, scaleOut, scaleIn, alphaOut, alphaIn;
	private double par1, par2, par3;
	private double[][] vt, vt2;				//cube vertex
	private Entity host;
	
	
    public ParticleCube(ClientLevel level, Entity host, double par1, double par2, double par3, float scale, int type)
    {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setSize(0F, 0F);
        this.host = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;	//can clip = false
        
        float[] lookDeg;
        float[] posOffset;
        
        switch(type)
        {
        case 1:		//yamato beam head
        	this.lifetime = 30;
        	this.rCol = 1F;
        	this.gCol = 0.8F;
        	this.bCol = 0.9F;
        break;
        default:	//yamato cannon charging
        	this.particleScale = (float) par1;  //par1 as new scale
        	this.lifetime = 40;
        	this.rCol = 1F;
        	this.gCol = 0.8F;
        	this.bCol = 0.9F;
        break;
        }
    }

    //par3 = Yaw的cos值, par4 = Pitch的cos值, par5 = Yaw的sin值
    //par6 = Yaw的sin值乘上-Pitch的sin值, par7 = Yaw的cos值乘上Pitch的sin值
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

    	if (this.age <= 1) return;
    	
    	
    	RenderSystem.depthMask(true);
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    		//NO texture
		
		//calc rotate vector
		//out
		float[] v1 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v2 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v3 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v4 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v5 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 1F, shotYaw, shotPitch, this.scaleOut);
		float[] v6 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 1F, shotYaw, shotPitch, this.scaleOut);
		float[] v7 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 1F, shotYaw, shotPitch, this.scaleOut);
		float[] v8 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 1F, shotYaw, shotPitch, this.scaleOut);
		//in
		float[] t1 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleIn);
		float[] t2 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleIn);
		float[] t3 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleIn);
		float[] t4 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleIn);
		float[] t5 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 1F, shotYaw, shotPitch, this.scaleIn);
		float[] t6 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 1F, shotYaw, shotPitch, this.scaleIn);
		float[] t7 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 1F, shotYaw, shotPitch, this.scaleIn);
		float[] t8 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 1F, shotYaw, shotPitch, this.scaleIn);
		
		//particle是以client視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
		double hx = this.xo + (this.x - this.xo) * (double)ptick - interpPosX;
        double hy = this.yo + (this.y - this.yo) * (double)ptick - interpPosY;
        double hz = this.zo + (this.z - this.zo) * (double)ptick - interpPosZ;
        
        //out
        vt[0][0] = hx+v1[0];	vt[0][1] = hy+v1[1];	vt[0][2] = hz+v1[2];
        vt[1][0] = hx+v2[0];	vt[1][1] = hy+v2[1];	vt[1][2] = hz+v2[2];
        vt[2][0] = hx+v3[0];	vt[2][1] = hy+v3[1];	vt[2][2] = hz+v3[2];
        vt[3][0] = hx+v4[0];	vt[3][1] = hy+v4[1];	vt[3][2] = hz+v4[2];
        vt[4][0] = hx+v5[0];	vt[4][1] = hy+v5[1];	vt[4][2] = hz+v5[2];
        vt[5][0] = hx+v6[0];	vt[5][1] = hy+v6[1];	vt[5][2] = hz+v6[2];
        vt[6][0] = hx+v7[0];	vt[6][1] = hy+v7[1];	vt[6][2] = hz+v7[2];
        vt[7][0] = hx+v8[0];	vt[7][1] = hy+v8[1];	vt[7][2] = hz+v8[2];
        //in
        vt2[0][0] = hx+t1[0];	vt2[0][1] = hy+t1[1];	vt2[0][2] = hz+t1[2];
        vt2[1][0] = hx+t2[0];	vt2[1][1] = hy+t2[1];	vt2[1][2] = hz+t2[2];
        vt2[2][0] = hx+t3[0];	vt2[2][1] = hy+t3[1];	vt2[2][2] = hz+t3[2];
        vt2[3][0] = hx+t4[0];	vt2[3][1] = hy+t4[1];	vt2[3][2] = hz+t4[2];
        vt2[4][0] = hx+t5[0];	vt2[4][1] = hy+t5[1];	vt2[4][2] = hz+t5[2];
        vt2[5][0] = hx+t6[0];	vt2[5][1] = hy+t6[1];	vt2[5][2] = hz+t6[2];
        vt2[6][0] = hx+t7[0];	vt2[6][1] = hy+t7[1];	vt2[6][2] = hz+t7[2];
        vt2[7][0] = hx+t8[0];	vt2[7][1] = hy+t8[1];	vt2[7][2] = hz+t8[2];

        //start
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        //in
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;

        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        //out
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;

        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        //draw
        drawBuf(render);
        
    	
    	RenderSystem.disableBlend();
    	RenderSystem.depthMask(false);
    	
    	
    }
    
    //layer: 0:particle 1:terrain 2:items 3:custom?
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
    	this.xo = this.x;
    	this.yo = this.y;
    	this.zo = this.z;
    	
    	//null check
    	if (host == null)
    	{
    		this.remove();
    	}
    	//update pos
    	else
    	{
    	    float yawDeg;
    		float[] lookDeg;
    		float[] posOffset;
    		
    		switch (this.particleType)
    		{
    		case 1:		//yamato beam head
    			//particle position
    			lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
            	posOffset = CalcHelper.rotateXYZByYawPitch(0F, 0F, host.getBbWidth() * 2F, lookDeg[0], lookDeg[1], 1F);
            	
        		this.x = this.host.getX() + posOffset[0];
            	this.y = this.host.getY() + this.host.getBbHeight() * 0.6D;
                this.z = this.host.getZ() + posOffset[2];
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
            	
            	//change alpha
        		if (this.age > 20)
        		{
        			this.alphaIn = 1F + (20 - age) * 0.1F;
        		}
        		else if (this.age < 4)
        		{
        			this.alphaIn = 0.2F + age * 0.2F;
        		}
        		else
        		{
        			this.alphaIn = 0.95F;
        		}
        		this.alphaOut = 0F;
        		
        		//change scale
        		if (this.age > 20)
        		{
        			this.scaleOut = this.particleScale * (1F + (age - 20));
                	this.scaleIn = this.particleScale * 0.4F  * (1F - (age - 20) * 0.1F);
        		}
        		else if (this.age < 8)
        		{
        			this.scaleOut = this.particleScale * 0.3F * (age * 0.3F);
                	this.scaleIn = this.particleScale * 0.4F * (age * 0.125F);
        		}
        		else
        		{
        			this.scaleOut = this.particleScale * 1F;
                	this.scaleIn = this.particleScale * 0.4F;
        		}
        		
        		//random scale effect
	        	this.scaleOut += this.random.nextFloat() * 0.04F - 0.01F;
	        	this.scaleIn += this.random.nextFloat() * 0.04F - 0.005F;
    		break;
    		default:	//yamato cannon charging
    			//particle position
    		    yawDeg = EntityHelper.getRadRenderYawOffset(this.host);
    			posOffset = CalcHelper.rotateXZByAxis(this.host.getBbWidth() * 2F, 0F, yawDeg, 1F);
            	
				this.x = this.host.getX() + posOffset[1];
            	this.y = this.host.getY() + host.getBbHeight() * 0.6D;
                this.z = this.host.getZ() + posOffset[0];
    			this.shotYaw = yawDeg;
            	this.shotPitch = EntityHelper.getRadRenderPitch(this.host);
            	
        		//change alpha
            	if (this.age < 32)
            	{
            		this.alphaIn = this.random.nextFloat() * 0.5F + 0.75F;
            	}
            	else
            	{
            		this.alphaIn = (this.lifetime - this.age) * 0.1F + 0.2F;
            	}
            	this.alphaOut = this.alphaIn * 0.25F;
        		
        		//change scale
    			this.scaleOut = this.particleScale * this.age * ((Mth.cos(this.age) + 1F) * 0.005F + 0.015F);
            	this.scaleIn = this.scaleOut * 0.75F;
            	
        		//random scale effect
	        	this.scaleOut += this.random.nextFloat() * 0.04F - 0.01F;
	        	this.scaleIn += this.random.nextFloat() * 0.04F - 0.005F;
        	break;
    		}//end switch
    	}
    	
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
