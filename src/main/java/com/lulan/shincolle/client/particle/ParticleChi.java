package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
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

/**CHI PARTICLE
 * 氣彈環繞特效, entity必須為IShipEmotion
 */
public class ParticleChi extends ShipParticle
{

	private Entity host;
	private int particleType;
	private float radChi;
	
	
    public ParticleChi(ClientLevel level, Entity host, float scale, int type)
    {
        super(level, host.getX(), host.getY()+host.getBbHeight()*0.55D, host.getZ());
        this.setSize(0F, 0F);
        this.host = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.hasPhysics = false;	//can clip = false
        
        switch (type)
        {
        case 1:		//nagato
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.alpha = 1F;
        	this.lifetime = 40;
        	this.radChi = scale * 12F;
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

    	if (this.age <= 1) return;
    	
    	
    	RenderSystem.depthMask(true);
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    		//NO texture
		
		//particle是以玩家視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
    	float f11 = (float)(this.xo + (this.x - this.xo) * (double)ptick - interpPosX);
    	float f12 = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY);
    	float f13 = (float)(this.zo + (this.z - this.zo) * (double)ptick - interpPosZ);
      
        //start
        
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        //注意4個點形成的面只有正面會貼上貼圖, 若玩家在該面背面會看不到正面貼圖, 因此要畫兩面共8個點
        //要使玩家看到正面, 4個座標add順序必須為: 右下 -> 右上 -> 左上 -> 左下
        //chi的形狀為八面體, 總共4個菱形6個頂點
        //若該面起點為y較低的點, 面會呈現內凹, 若起點選較高的點, 該面會外凸 (若四頂點不再同一平面上時)
        //face1
        render.addVertex((float)(f11), (float)(f12), (float)(f13+particleScale)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12+particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11+particleScale), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12-particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //face2
        render.addVertex((float)(f11+particleScale), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12+particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12), (float)(f13-particleScale)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12-particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //face3
        render.addVertex((float)(f11), (float)(f12), (float)(f13-particleScale)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12+particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11-particleScale), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12-particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        //face4
        render.addVertex((float)(f11-particleScale), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12+particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12), (float)(f13+particleScale)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        render.addVertex((float)(f11), (float)(f12-particleScale), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
        
        //draw
        drawBuf(render);
        
        //半透明外殼
        float parAlpha2 = this.alpha * 0.5F;
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        //face1
        render.addVertex((float)(f11), (float)(f12), (float)(f13+particleScale*1.3)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12+particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11+particleScale*1.3), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12-particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        //face2
        render.addVertex((float)(f11+particleScale*1.3), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12+particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12), (float)(f13-particleScale*1.3)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12-particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        //face3
        render.addVertex((float)(f11), (float)(f12), (float)(f13-particleScale*1.3)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12+particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11-particleScale*1.3), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12-particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        //face4
        render.addVertex((float)(f11-particleScale*1.3), (float)(f12), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12+particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12), (float)(f13+particleScale*1.3)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        render.addVertex((float)(f11), (float)(f12-particleScale*1.3), (float)(f13)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(parAlpha2));;
        
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
        
        float[] newPos = CalcHelper.rotateXZByAxis(radChi, 0F, 6.283185F / this.lifetime * this.age, 1F);

        if (this.host != null)
        {
        	this.x = this.host.getX() + newPos[0];
            this.z = this.host.getZ() + newPos[1];
        }
        
        int phase = ((IShipEmotion)host).getStateEmotion(ID.S.Phase);
        
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
        else if (phase == 0 || phase == 2)
       {
        	this.remove();
        }
        
    }
    
    
}
