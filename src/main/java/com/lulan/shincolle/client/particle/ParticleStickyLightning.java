package com.lulan.shincolle.client.particle;

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
import com.lulan.shincolle.reference.Values;

/** NO TEXTURE LIGHTNING PARTICLE
 * 
 *  WITHOUT rotate to player viewing angle
 *  
 *  shape: all stem with random wide and random Y length
 *  
 *  parms: level, host, scale, type
 */
public class ParticleStickyLightning extends ShipParticle
{

	private int particleType;		//0:red white lightning
	private Entity host;
	private int numStem;			//lightning length number
	private double[][] prevShape;	//prev lightning shape
	private float scaleX, scaleZ, scaleY, stemWidth;
	
	
    public ParticleStickyLightning(ClientLevel level, Entity entity, float scale, int life, int type)
    {
        super(level, entity.getX(), entity.getY(), entity.getZ());
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.hasPhysics = false;	//can clip = false

        switch (type)
        {
        case 1:  //yamato cannon charge steady state
        	this.rCol = 1F;
            this.gCol = 0.5F;
            this.bCol = 0.7F;
            this.alpha = 1F;
            this.lifetime = life;
            this.numStem = 4;
            this.scaleX = 0.5F + host.getBbWidth() * 0.5F;
            this.scaleY = 0.5F + host.getBbWidth() * 0.5F;
            this.scaleZ = 0.5F + host.getBbWidth() * 0.5F;
            this.stemWidth = 0.01F * host.getBbWidth();
            
            //random position
            this.x = this.host.getX() + random.nextFloat() * this.particleScale * 2F - this.particleScale;
        	this.y = this.host.getY() + host.getBbHeight() * 0.6D;
            this.z = this.host.getZ() + random.nextFloat() * this.particleScale * 2F - this.particleScale;
        break;
        case 2:  //yamato cannon charging state IN, LivingEntity ONLY
        	this.rCol = 1F;
            this.gCol = 0.5F;
            this.bCol = 0.7F;
            this.alpha = 1F;
            this.lifetime = life;
            this.numStem = 12;
            this.scaleX = 0.25F;
            this.scaleY = 0.25F;
            this.scaleZ = 0.25F;
            this.stemWidth = 0.005F;
            
            //particle position
			float[] partPos = CalcHelper.rotateXZByAxis(1F, 0F, (((LivingEntity)host).yBodyRot % 360) * Values.N.DIV_PI_180, 1F);
        	
            this.x = this.host.getX() + partPos[1];
        	this.y = this.host.getY() + host.getBbHeight() * 0.8D;
            this.z = this.host.getZ() + partPos[0];
        break;
        case 3:  //yamato cannon charging state OUT, LivingEntity ONLY
        	this.rCol = 1F;
            this.gCol = 0.5F;
            this.bCol = 0.7F;
            this.alpha = 1F;
            this.lifetime = life;
            this.numStem = 4;
            this.scaleX = 1F;
            this.scaleY = 1F;
            this.scaleZ = 1F;
            this.stemWidth = 0.025F;
        break;
        case 4:  //railgun
        	this.rCol = 0F;
            this.gCol = 0.7F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.lifetime = life;
            this.numStem = 12;
            this.scaleX = 0.75F;
            this.scaleY = 0.75F;
            this.scaleZ = 0.75F;
            this.stemWidth = 0.008F;
            
            //random position
            this.x = this.host.getX() + random.nextFloat() * 0.25F - 0.125F;
        	this.y = this.host.getY() + host.getBbHeight() * 0.5D + random.nextFloat() * 0.25F - 0.125F;
            this.z = this.host.getZ() + random.nextFloat() * 0.25F - 0.125F;
        break;
        case 5:  //black hole
        	this.rCol = 0F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0F;
            this.lifetime = life;
            this.numStem = 4;
            this.scaleX = this.particleScale;
            this.scaleY = this.particleScale;
            this.scaleZ = this.particleScale;
            this.stemWidth = 0.1F;
            
            //random position
            this.x = this.host.getX() + random.nextFloat() * 0.25F - 0.125F;
        	this.y = this.host.getY() + host.getBbHeight() * 0.5D + random.nextFloat() * 0.25F - 0.125F;
            this.z = this.host.getZ() + random.nextFloat() * 0.25F - 0.125F;
        break;
        default:
        	this.rCol = 1F;
            this.gCol = 0.5F;
            this.bCol = 0.7F;
            this.alpha = 1F;
            this.lifetime = life;
            this.numStem = 8;
            this.scaleX = 1.75F;
            this.scaleY = 1.75F;
            this.scaleZ = 1.75F;
            this.stemWidth = 0.006F;
            
            //random position
            this.x = this.host.getX() + random.nextFloat() * 2F - 1F;
        	this.y = this.host.getY() + host.getBbHeight() * 0.5D + random.nextFloat() * 2F - 1F;
            this.z = this.host.getZ() + random.nextFloat() * 2F - 1F;
        break;
        }//end switch
        
        this.prevShape = new double[numStem][6];	//prev lightning shape
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

    	
    	RenderSystem.depthMask(true);
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    		//NO texture
    	
        float px = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float py = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float pz = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
    	float offx = 0F;
        float offz = 0F;
        float offy = 0F;
        
        if (this.age % 2 == 0)
        {
	        //越後面的step, random range越大 (閃電到後面分支分散)
	        for (int i = 0; i < numStem; i++)
	        {
	        	//stem random position
	            offx = (random.nextFloat() - 0.5F) * this.scaleX;
	        	offz = (random.nextFloat() - 0.5F) * this.scaleZ;
	        	offy = (random.nextFloat() - 0.5F) * this.scaleY;
	        	
	        	//xyz position: 0:x1, 1:y1, 2:z1, 3:x2, 4:y2, 5:z2
	        	if (i == 0)
	        	{	//first stem
	        		prevShape[i][0] = px + offx;
	        		prevShape[i][1] = py + offy;
	        		prevShape[i][2] = pz + offz;
	        		prevShape[i][3] = prevShape[i][0];
	        		prevShape[i][4] = prevShape[i][1];
	            	prevShape[i][5] = prevShape[i][2];
	        	}
	        	else if (i == numStem - 1)
	        	{	//last stem
	        		prevShape[i][0] = prevShape[i-1][0] + offx;
	        		prevShape[i][1] = prevShape[i-1][1] + offy;
	        		prevShape[i][2] = prevShape[i-1][2] + offz;
	        		prevShape[i][3] = prevShape[i][0];
	        		prevShape[i][4] = prevShape[i][1];
	            	prevShape[i][5] = prevShape[i][2];
	        	}
	        	else
	        	{	//middle stem
	        		prevShape[i][0] = prevShape[i-1][0] + offx;
	        		prevShape[i][1] = prevShape[i-1][1] + offy;
	        		prevShape[i][2] = prevShape[i-1][2] + offz;
	        		prevShape[i][3] = prevShape[i-1][3] + offx + this.stemWidth;
	        		prevShape[i][4] = prevShape[i-1][4] + offy + this.stemWidth;
	            	prevShape[i][5] = prevShape[i-1][5] + offz + this.stemWidth;
	        	}
	        }
        }
  
        render = TESSELATOR.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        //quad strip必須先指定下方兩點(左下 -> 右下), 再指定上方兩點(左上 -> 右上), 該面才會朝向玩家
    	//跟quad不同 (右下 -> 右上 -> 左上 -> 左下)
        //畫出正面
        for (int i = numStem - 1; i >= 0; i--)
        {
        	render.addVertex((float)(prevShape[i][0]), (float)(prevShape[i][1]), (float)(prevShape[i][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        	render.addVertex((float)(prevShape[i][3]), (float)(prevShape[i][4]), (float)(prevShape[i][5])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        }
        
        //draw
        drawBuf(render);

        //畫出反面
        render = TESSELATOR.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        for (int i = numStem - 1; i >= 0; i--)
        {
        	render.addVertex((float)(prevShape[i][3]), (float)(prevShape[i][4]), (float)(prevShape[i][5])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        	render.addVertex((float)(prevShape[i][0]), (float)(prevShape[i][1]), (float)(prevShape[i][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        }

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
    	//this is both side particle
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setPos(this.x, this.y, this.z);

        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
        
        //change position
        switch (this.particleType)
        {
        case 3:   //yamato cannon charging out
	        //particle position
			float[] partPos2 = CalcHelper.rotateXZByAxis(this.host.getBbWidth() * 2F, 0F, (((LivingEntity)host).yBodyRot % 360) * Values.N.DIV_PI_180, 1F);
	    	
	        this.x = this.host.getX() + partPos2[1];
	    	this.y = this.host.getY() + host.getBbHeight() * 0.6D;
	        this.z = this.host.getZ() + partPos2[0];
	    break;
        }
        
        //change color
        switch (this.particleType)
        {
        case 4:   //railgun
        	if (this.lifetime - this.age < 6 )
        	{
        		this.alpha = (this.lifetime - this.age) * 0.15F + 0.2F;
        	}
        	
        	this.gCol = 0.6F + random.nextFloat() * 0.6F;
        	this.rCol = this.gCol - 0.3F;
        break;
        case 5:   //black hole
        	if (this.lifetime - this.age < 10 )
        	{
        		this.alpha = (this.lifetime - this.age) * 0.015F + 0.018F;
        	}
        	else
        	{
        		this.alpha = 0.35F;
        	}
        	
        	this.gCol = 0F + random.nextFloat() * 0.1F;
        	this.rCol = this.gCol + random.nextFloat() * 0.15F;
        	this.bCol = this.rCol + random.nextFloat() * 0.15F;
        break;
        case 1:   //yamato cannon charge lightning
        case 2:   //yamato cannon charging in
        case 3:   //yamato cannon charging out
        default:  //yamato cannon beam lightning
        	if (this.lifetime - this.age < 6 )
        	{
        		this.alpha = (this.lifetime - this.age) * 0.15F + 0.2F;
        	}
        	
        	this.gCol = 0.4F + random.nextFloat() * 0.75F;
        	this.bCol = 0.1F + this.gCol;
        break;
        }//end switch
        
    }
    
    
}
