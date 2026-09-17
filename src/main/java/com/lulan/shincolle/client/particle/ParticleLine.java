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

/**
 * LINE PARTICLE
 */
public class ParticleLine extends ShipParticle
{

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particlegradientline.png");
	private int particleType;
	private float[] parms;
	
	
    public ParticleLine(ClientLevel level, int type, float[] parms)
    {
        super(level, 0D, 0D, 0D);
        this.setSize(0F, 0F);
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.parms = parms;
        this.particleType = type;
        this.hasPhysics = false;
        
        switch (type)
        {
        /**
         * parms: height, width forward, width backward, R, G, B, A, px, py, pz, mx, my, mz
         */
        case 0:		//high speed blur
        	this.lifetime = 50;
        	this.rCol = parms[3];
        	this.gCol = parms[4];
        	this.bCol = parms[5];
        	this.alpha = parms[6];
        	this.x = parms[7];
        	this.y = parms[8];
        	this.z = parms[9];
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

		//particle是以玩家視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
		double px = this.x - interpPosX;
        double py = this.y - interpPosY;
        double pz = this.z - interpPosZ;
        double[] xyzh = new double[] {parms[0]*parms[10], parms[0]*parms[11], parms[0]*parms[12]};
        double[] xyzf = new double[] {parms[1]*parms[10], parms[1]*parms[11], parms[1]*parms[12]};
        double[] xyzb = new double[] {-parms[2]*parms[10], -parms[2]*parms[11], -parms[2]*parms[12]};
        
        //三種正交方式: 若vec為(x, y, z), 則三種簡單正交為(-z, 0, x), (0, -z, y), (-y, x, 0)
        //三種正交都畫出來使各種方向看過去皆有機會看到整個面
        Vec3[] plane1 = new Vec3[]
		{
    		new Vec3(xyzf[0], xyzf[1] - xyzh[2], xyzf[2] + xyzh[1]),
    		new Vec3(xyzf[0], xyzf[1] + xyzh[2], xyzf[2] - xyzh[1]),
    		new Vec3(xyzb[0], xyzb[1] + xyzh[2], xyzb[2] - xyzh[1]),
    		new Vec3(xyzb[0], xyzb[1] - xyzh[2], xyzb[2] + xyzh[1])
        };
        Vec3[] plane2 = new Vec3[]
		{
    		new Vec3(xyzf[0] - xyzh[2], xyzf[1], xyzf[2] + xyzh[0]),
    		new Vec3(xyzf[0] + xyzh[2], xyzf[1], xyzf[2] - xyzh[0]),
    		new Vec3(xyzb[0] - xyzh[2], xyzb[1], xyzb[2] + xyzh[0]),
    		new Vec3(xyzb[0] + xyzh[2], xyzb[1], xyzb[2] - xyzh[0])
        };
        Vec3[] plane3 = new Vec3[]
		{
    		new Vec3(xyzf[0] - xyzh[1], xyzf[1] + xyzh[0], xyzf[2]),
    		new Vec3(xyzf[0] + xyzh[1], xyzf[1] - xyzh[0], xyzf[2]),
    		new Vec3(xyzb[0] - xyzh[1], xyzb[1] + xyzh[0], xyzb[2]),
    		new Vec3(xyzb[0] + xyzh[1], xyzb[1] - xyzh[0], xyzb[2])
        };


		RenderSystem.setShaderTexture(0, TEXTURE);
    	
    	
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	RenderSystem.depthMask(false);
    	
      
        //start tess
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        
        
        //front plane1
        render.addVertex((float)(px + plane1[0].x), (float)(py + plane1[0].y), (float)(pz + plane1[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[1].x), (float)(py + plane1[1].y), (float)(pz + plane1[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[2].x), (float)(py + plane1[2].y), (float)(pz + plane1[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[3].x), (float)(py + plane1[3].y), (float)(pz + plane1[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //back plane1
        render.addVertex((float)(px + plane1[3].x), (float)(py + plane1[3].y), (float)(pz + plane1[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[2].x), (float)(py + plane1[2].y), (float)(pz + plane1[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[1].x), (float)(py + plane1[1].y), (float)(pz + plane1[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane1[0].x), (float)(py + plane1[0].y), (float)(pz + plane1[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //front plane2
        render.addVertex((float)(px + plane2[0].x), (float)(py + plane2[0].y), (float)(pz + plane2[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[1].x), (float)(py + plane2[1].y), (float)(pz + plane2[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[2].x), (float)(py + plane2[2].y), (float)(pz + plane2[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[3].x), (float)(py + plane2[3].y), (float)(pz + plane2[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //back plane2
        render.addVertex((float)(px + plane2[3].x), (float)(py + plane2[3].y), (float)(pz + plane2[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[2].x), (float)(py + plane2[2].y), (float)(pz + plane2[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[1].x), (float)(py + plane2[1].y), (float)(pz + plane2[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane2[0].x), (float)(py + plane2[0].y), (float)(pz + plane2[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //front plane3
        render.addVertex((float)(px + plane3[0].x), (float)(py + plane3[0].y), (float)(pz + plane3[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[1].x), (float)(py + plane3[1].y), (float)(pz + plane3[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[2].x), (float)(py + plane3[2].y), (float)(pz + plane3[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[3].x), (float)(py + plane3[3].y), (float)(pz + plane3[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //back plane3
        render.addVertex((float)(px + plane3[3].x), (float)(py + plane3[3].y), (float)(pz + plane3[3].z)).setUv((float)(0D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[2].x), (float)(py + plane3[2].y), (float)(pz + plane3[2].z)).setUv((float)(0D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[1].x), (float)(py + plane3[1].y), (float)(pz + plane3[1].z)).setUv((float)(1D), (float)(0D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(px + plane3[0].x), (float)(py + plane3[0].y), (float)(pz + plane3[0].z)).setUv((float)(1D), (float)(1D)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        
        drawBuf(render);
        
    	
    	RenderSystem.depthMask(false);
    	RenderSystem.disableBlend();
    	
    }
    
    //layer: 0:particle 1:terrain 2:items 3:custom?
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
        if(this.age++ > this.lifetime)
        {
            this.remove();
        }
        
        switch (this.particleType)
        {
        case 0:
        	this.parms[0] *= 0.88F;
        	this.parms[2] *= 0.85F;
        	this.alpha *= 0.9F;
    	break;
        }
    }
    
    
}
