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

/**LASER PARTICLE
 * 給定host, target -> 生成雷射特效
 * RE-CLASS, 部分姬級用
 * 
 * type: 0:持續11 ticks 
 *       1:
 */
public class ParticleLaser extends ShipParticle
{

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particlelaser.png");
	private int particleType;
	private double tarX, tarY, tarZ;
	
    public ParticleLaser(ClientLevel level, double x, double y, double z, double tarX, double tarY, double tarZ, float scale, int type)
    {
        super(level, x, y, z);
        this.setSize(0F, 0F);
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.hasPhysics = false;	//can clip = false
        
        switch (type)
        {
        case 0:		//re-class laser
        	this.lifetime = 11;
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.alpha = 1F;
        break;
        case 1:		//NGT speed blur
        	this.lifetime = 11;
        	this.age = 4;
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.alpha = 1F;
        break;
        }
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
		double f11 = this.xo + (this.x - this.xo) * (double)ptick - interpPosX;
        double f12 = this.yo + (this.y - this.yo) * (double)ptick - interpPosY;
        double f13 = this.zo + (this.z - this.zo) * (double)ptick - interpPosZ;
        double f21 = this.tarX - interpPosX;
        double f22 = this.tarY - interpPosY;
        double f23 = this.tarZ - interpPosZ;
        
		float minU = 0F;
		float maxU = random.nextInt(32)+32;
		float minV = this.age % 12 / 12F;
		float maxV = minV + 0.08333333F;
    	
		RenderSystem.setShaderTexture(0, TEXTURE);

    	
    	RenderSystem.enableBlend();
    	RenderSystem.depthMask(true);
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    	
        //start tess
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        
        
        //注意4個點形成的面只有正面會貼上貼圖, 若玩家在該面背面會看不到正面貼圖, 因此要畫兩面共8個點
        //要使玩家看到正面, 4個座標add順序必須為: 右下 -> 右上 -> 左上 -> 左下
        //add front plane
        render.addVertex((float)(f21), (float)(f22), (float)(f23)).setUv((float)(maxU), (float)(maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f21), (float)(f22 + particleScale * 0.3D), (float)(f23)).setUv((float)(maxU), (float)(minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12 + particleScale * 0.3D), (float)(f13)).setUv((float)(minU), (float)(minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12), (float)(f13)).setUv((float)(minU), (float)(maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //add back plane
        render.addVertex((float)(f11), (float)(f12), (float)(f13)).setUv((float)(minU), (float)(maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12 + particleScale * 0.3D), (float)(f13)).setUv((float)(minU), (float)(minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f21), (float)(f22 + particleScale * 0.3D), (float)(f23)).setUv((float)(maxU), (float)(minV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f21), (float)(f22), (float)(f23)).setUv((float)(maxU), (float)(maxV)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        
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
        if(this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
