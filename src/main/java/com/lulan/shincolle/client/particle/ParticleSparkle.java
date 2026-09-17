package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.utility.EntityHelper;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;

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
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;

/**
 * SPHERE LIGHT PARTICLE
 */
public class ParticleSparkle extends ShipParticle
{
	
	private static int NumBeam = 30;
	private int particleType, beamCurrent;
	private Entity host;
	private float[][] beamPos;					//beam position: 0~1: xy, 2~5:RGBA, 6:age
	private float beamFad, beamSpd, beamThick, beamHeight;
	
	
    public ParticleSparkle(Entity entity, int type, float...parms)
    {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        this.beamCurrent = 0;					//new beam index
        
        switch (type)
        {
        /**
	     * light quad sparkle around point
	     *   0: red random
	     *   2: green random
	     *   3: blue random
	     *   4: RG random
	     *   5: RB random
	     *   6: GB random
	     *   7: RGB random
	     *   8: R only
	     *   9: G only
	     *   10: B only
	     * parms: 0:scale, 1:radius, 2:beam speed, 3:beam thickness, 4~6:motionXYZ, 7:alpha, 8:height
         */
        case 0:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 9:
        case 10:
        	this.particleScale = parms[0];
        	this.beamFad = parms[1];
        	this.beamSpd = parms[2];
        	this.beamThick = parms[3];
        	this.rCol = parms[4];
            this.gCol = parms[5];
            this.bCol = parms[6];
            this.alpha = parms[7];
            this.beamHeight = parms[8];
            this.lifetime = 20;
            this.NumBeam = (3 - Minecraft.getInstance().options.particles().get().getId()) * 15;
            this.beamPos = new float[NumBeam][8];
            this.setPos(entity.getX(), entity.getY()+this.beamHeight, entity.getZ());
        break;	
        case 8:
        	this.particleScale = parms[0];
        	this.beamFad = parms[1];
        	this.beamSpd = parms[2];
        	this.beamThick = parms[3];
        	this.rCol = parms[4];
            this.gCol = parms[5];
            this.bCol = parms[6];
            this.alpha = parms[7];
            this.beamHeight = parms[8];
            this.lifetime = 120;
            this.NumBeam = (3 - Minecraft.getInstance().options.particles().get().getId()) * 30;
            this.beamPos = new float[NumBeam][8];
            this.setPos(entity.getX(), entity.getY()+this.beamHeight, entity.getZ());
        break;
        /**
	     * type 1: blue eye fire particle
	     * parms: 0:height, 1:eye x, 2:eye z, 3~6:RGBA
         */
        case 1:
        	this.particleScale = 0.018F;
        	this.beamHeight = parms[0];
        	this.beamFad = parms[1];
        	this.beamSpd = parms[2];
        	this.rCol = parms[3];
            this.gCol = parms[4];
            this.bCol = parms[5];
            this.alpha = parms[6];
            this.lifetime = 50;
            this.NumBeam = (3 - Minecraft.getInstance().options.particles().get().getId()) * 15;
            this.beamPos = new float[NumBeam][11];
            this.setPos(entity.getX(), entity.getY()+this.beamHeight, entity.getZ());
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

        float x = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
        
        Vec3[] avec3d = new Vec3[] {
        		new Vec3((double)(-cosYaw * this.particleScale - sinYawsinPitch * this.particleScale),
        				  (double)(-cosPitch * this.particleScale),
        				  (double)(-sinYaw * this.particleScale - cosYawsinPitch * this.particleScale)),
        		new Vec3((double)(-cosYaw * this.particleScale + sinYawsinPitch * this.particleScale),
        				  (double)(cosPitch * this.particleScale),
        				  (double)(-sinYaw * this.particleScale + cosYawsinPitch * this.particleScale)),
        		new Vec3((double)(cosYaw * this.particleScale + sinYawsinPitch * this.particleScale),
        				  (double)(cosPitch * this.particleScale),
        				  (double)(sinYaw * this.particleScale + cosYawsinPitch * this.particleScale)),
        		new Vec3((double)(cosYaw * this.particleScale - sinYawsinPitch * this.particleScale),
        				  (double)(-cosPitch * this.particleScale),
        				  (double)(sinYaw * this.particleScale - cosYawsinPitch * this.particleScale))};

    	
    	RenderSystem.depthMask(false);
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    	
		
		render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
		
        for (float[] beam : this.beamPos)
        {
        	if (beam[3] == 0F || beam[4] == 0F || beam[5] == 0F || beam[6] == 0F) continue;
        	float size = (20F - beam[7]) * 0.05F;
	        
	        render.addVertex((float)((double)x + beam[0] + avec3d[0].x * size), (float)((double)y + beam[1] + avec3d[0].y * size), (float)((double)z + beam[2] + avec3d[0].z * size)).setColor((float)(beam[3]), (float)(beam[4]), (float)(beam[5]), (float)(beam[6]));;
	        render.addVertex((float)((double)x + beam[0] + avec3d[1].x * size), (float)((double)y + beam[1] + avec3d[1].y * size), (float)((double)z + beam[2] + avec3d[1].z * size)).setColor((float)(beam[3]), (float)(beam[4]), (float)(beam[5]), (float)(beam[6]));;
	        render.addVertex((float)((double)x + beam[0] + avec3d[2].x * size), (float)((double)y + beam[1] + avec3d[2].y * size), (float)((double)z + beam[2] + avec3d[2].z * size)).setColor((float)(beam[3]), (float)(beam[4]), (float)(beam[5]), (float)(beam[6]));;
	        render.addVertex((float)((double)x + beam[0] + avec3d[3].x * size), (float)((double)y + beam[1] + avec3d[3].y * size), (float)((double)z + beam[2] + avec3d[3].z * size)).setColor((float)(beam[3]), (float)(beam[4]), (float)(beam[5]), (float)(beam[6]));;
        }
        
        drawBuf(render);
        
    	
    	
    	RenderSystem.disableBlend();
    	RenderSystem.depthMask(true);
    	
    }
    
    //layer: 0:particle 1:terrain 2:items 3:custom
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
        //update age
        if (this.age++ > this.lifetime || this.host == null)
        {
            this.remove();
            return;
        }
        
    	//update movement
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        
        //update beam
        switch (this.particleType)
        {
        /**
	     * light quad sparkle around point
	     *   0: red random
	     *   2: green random
	     *   3: blue random
	     *   4: RG random
	     *   5: RB random
	     *   6: GB random
	     *   7: RGB random
	     *   8: R only
	     *   9: G only
	     *   10: B only
         */
        case 0:		//light sparkle around point
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        {
        	float red = 1F;
        	float green = 1F;
        	float blue = 1F;
        	
        	for (int i = 0; i < (4 - Minecraft.getInstance().options.particles().get().getId()); i++)
        	{
        		//random color
        		switch (this.particleType)
        		{
                case 0:
                	red += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 2:
                	green += this.random.nextFloat() * 1.2F - 0.3F;
            	break;
                case 3:
                	blue += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 4:
                	red += this.random.nextFloat() * 1.2F - 0.5F;
                	green += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 5:
                	red += this.random.nextFloat() * 1.2F - 0.5F;
                	blue += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 6:
                	green += this.random.nextFloat() * 1.2F - 0.5F;
                	blue += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 7:
                	red += this.random.nextFloat() * 1.2F - 0.5F;
                	green += this.random.nextFloat() * 1.2F - 0.5F;
                	blue += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
                case 8:
                	red += this.random.nextFloat() * 1.2F - 0.5F;
                	green = 0.001F;
                	blue = 0.001F;
            	break;
                case 9:
                	red = 0.001F;
                	green += this.random.nextFloat() * 1.2F - 0.5F;
                	blue = 0.001F;
            	break;
                case 10:
                	red = 0.001F;
                	green = 0.001F;
                	blue += this.random.nextFloat() * 1.2F - 0.5F;
            	break;
        		}
        		
            	//create new beam
            	this.beamPos[this.beamCurrent] = new float[]
            	{
            		(float) (this.host.getX() - this.x) + (this.random.nextFloat() - 0.5F) * this.beamFad,
            		(float) (this.host.getY() - this.y) + this.beamHeight + (this.random.nextFloat() - 0.5F) * this.beamFad,
            		(float) (this.host.getZ() - this.z) + (this.random.nextFloat() - 0.5F) * this.beamFad,
            		red,
        			green,
        			blue,
        			this.alpha, 0F
        		};
            	this.beamCurrent++;
            	if (this.beamCurrent >= this.beamPos.length) this.beamCurrent = 0;
        	}
        	
        	//update beam pos: halve dist to (0,0,0)
        	for (int i = 0; i < this.beamPos.length; i++)
        	{
        		//move
        		this.beamPos[i][0] += this.rCol;
				this.beamPos[i][1] += this.gCol;
				this.beamPos[i][2] += this.bCol;
        		
        		//age++
        		this.beamPos[i][7] += 1F;
        		
        		//alpha random
        		this.beamPos[i][6] = this.random.nextFloat() + 0.1F;
        		if (this.beamPos[i][6] > 1F) this.beamPos[i][6] = 1F;
        	}
        }
        break;
        case 1:		//blue eye fire
        {
        	//update pos
        	this.setPos(this.host.getX(), this.host.getY()+this.beamHeight, this.host.getZ());
        	
        	float eyex = ((IShipEmotion) this.host).getStateFlag(ID.F.HeadTilt) ? this.beamFad - 0.05F : this.beamFad;
        	float eyeh = ((IShipEmotion) this.host).getStateFlag(ID.F.HeadTilt) ? 0.02F : 0F;
        	float[] headpos =  CalcHelper.rotateXYZByYawPitch(eyex, 0.19F + eyeh, this.beamSpd,
        			EntityHelper.getRadRenderYawHead(this.host),
        			this.host.getXRot() * Values.N.DIV_PI_180, 1F);
        	float[] headmov =  CalcHelper.rotateXZByAxis(1F, 1F,
        			((LivingEntity)this.host).getYHeadRot() * Values.N.DIV_PI_180, 0.025F);
        	
        	for (int i = 0; i < (4 - Minecraft.getInstance().options.particles().get().getId()); i++)
        	{
            	//create new beam
            	this.beamPos[this.beamCurrent] = new float[]
            	{
            		(float) headpos[0] + (this.random.nextFloat() - 0.5F) * 0.1F,	//xyz pos
            		(float) headpos[1] + (this.random.nextFloat() - 0.5F) * 0.1F,
            		(float) headpos[2] + (this.random.nextFloat() - 0.5F) * 0.1F,
            		this.rCol + this.random.nextFloat() + 0.4F,			//rgba
        			this.gCol,
        			this.bCol,
        			this.alpha,
        			0F,															//age
        			headmov[1], 0.01F, headmov[0]								//motion
        		};
            	this.beamCurrent++;
            	if (this.beamCurrent >= this.beamPos.length) this.beamCurrent = 0;
        	}
        	
        	//update beam pos: halve dist to (0,0,0)
        	for (int i = 0; i < this.beamPos.length; i++)
        	{
        		//move
        		this.beamPos[i][8] *=  0.99F;
        		this.beamPos[i][9] *=  1.08F;
        		this.beamPos[i][10] *=  0.99F;
        		this.beamPos[i][0] += this.beamPos[i][8];
        		this.beamPos[i][1] += this.beamPos[i][9];
        		this.beamPos[i][2] += this.beamPos[i][10];
        		
        		//age++
        		this.beamPos[i][7] += 1F;
        		
        		//alpha random
        		this.beamPos[i][6] *= 0.92F;
        		if (this.beamPos[i][6] > 1F) this.beamPos[i][6] = 1F;
        	}
        }
        break;
        }
        
    }
    
    
}
