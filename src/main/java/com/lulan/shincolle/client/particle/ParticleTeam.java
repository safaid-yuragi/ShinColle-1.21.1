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

/**TEAM CIRCLE PARTICLE
 * 顯示team圈選的目標, 點擊的目標, 能控制的目標
 * type:
 * 0: 綠色, 目前所有在隊伍中的至少都會顯示綠色圈選圖
 * 1: 青色, pointer為single mode時會控制的目標
 * 2: 紅色, pointer為group mode會控制的目標
 * 3: 黃色, pointer為formation mode會控制的目標
 * 4: 綠色, moving target (show 20 ticks), alpha fade out
 * 5: 紅色, attack target (show 20 ticks), alpha fade out
 */
public class ParticleTeam extends ShipParticle
{

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particleteam.png");
	private int particleType;	//0:green 1:cyan 2:red 3:yellow
	private double height;
	private float particleAlphaA, particleAlphaC;  //arrow alpha, circle alpha
	private Entity host;
	
	
	//mark at entity
    public ParticleTeam(ClientLevel level, Entity host, float scale, int type)
    {
        super(level, 0D, 0D, 0D);  
        this.setSize(0F, 0F);
        this.xo = host.getX();
        this.yo = host.getY();
        this.zo = host.getZ();
        this.setPos(host.getX(), host.getY(), host.getZ());
        this.host = host;
        this.height = host.getBbHeight();
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.particleScale = scale;
        this.particleAlphaA = 1F;
        this.particleAlphaC = 0.8F;
        this.particleType = type;
        this.hasPhysics = false;	//can clip = false
        
        switch (type)
        {
        default:	//green, normal mode
        	this.rCol = 0F;
        	this.gCol = 1F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 1:		//cyan, single mode
        	this.rCol = 0F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.lifetime = 30;
        break;
        case 2:		//red, group mode
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 1F;
        	this.lifetime = 30;
        break;
        case 3:		//yellow, formation mode
        	this.rCol = 1F;
        	this.gCol = 0.9F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 4:		//green, moving target
        	this.rCol = 0F;
        	this.gCol = 1F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 5:		//red, attack target
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 6:		//white, guard target
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.lifetime = 30;
        break;
        case 7:		//translucent green, friendly target
        	this.rCol = 0F;
        	this.gCol = 1F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        	this.particleAlphaA = 0F;
            this.particleAlphaC = 0.35F;
            this.xo = host.getX();
            this.yo = host.getY()-0.04D;
            this.zo = host.getZ();
            this.setPos(host.getX(), host.getY()-0.04D, host.getZ());
        break;
        }//end switch
    }
    
    //mark at block
    public ParticleTeam(ClientLevel level, float scale, int type, double x, double y, double z)
    {
        super(level, 0D, 0D, 0D);
        this.setSize(0F, 0F);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.height = 1.5D;
        this.particleScale = scale;
        this.particleAlphaA = 1F;
        this.particleAlphaC = 0.5F;
        this.particleType = type;
        this.hasPhysics = false;	//can clip = false
        
        switch (type)
        {
        default:	//green, normal mode
        case 4:		//green, moving target
        	this.rCol = 0F;
        	this.gCol = 1F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 5:		//red, attack target
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.lifetime = 30;
        break;
        case 6:		//white, guard target
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.lifetime = 30;
        break;
        case 8:		//waypoint
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.lifetime = 31;
        	this.particleAlphaA = 0.8F;
            this.particleAlphaC = 0.9F;
        break;
        case 9:		//waypoint
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.lifetime = 31;
        	this.particleAlphaA = 0F;
            this.particleAlphaC = 0.9F;
        break;
        }//end switch
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
    	RenderSystem.enableBlend();
    	RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
    	
    	
		float xmin = 0F;
		float xmax = 1F;
		float y1min = 0F;	//箭頭圖案
		float y1max = 0.5F;
		float y2min = 0.5F;	//圈圈圖案
		float y2max = 1F;
		float halfScale = particleScale * 0.5F;
		
		//particle是以玩家視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
		double f11 = (float)(this.xo + (this.x - this.xo) * (double)ptick - interpPosX);
		double f12 = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY + this.height + 1.3D);
		double f12b = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY + 0.3D);
		double f13 = (float)(this.zo + (this.z - this.zo) * (double)ptick - interpPosZ);

        //start
		render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
		
		
        //畫出箭頭
        //X跟Z位置不加頭部轉動偏移, 只有Y軸會偏向玩家方向
        render.addVertex((float)(f11 - cosYaw * particleScale), (float)(f12 - cosPitch * particleScale * 2.0F), (float)(f13 - sinYaw * particleScale)).setUv((float)(xmax), (float)(y1max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaA));;
        render.addVertex((float)(f11 - cosYaw * particleScale), (float)(f12 + cosPitch * particleScale * 2.0F), (float)(f13 - sinYaw * particleScale)).setUv((float)(xmax), (float)(y1min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaA));;
        render.addVertex((float)(f11 + cosYaw * particleScale), (float)(f12 + cosPitch * particleScale * 2.0F), (float)(f13 + sinYaw * particleScale)).setUv((float)(xmin), (float)(y1min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaA));;
        render.addVertex((float)(f11 + cosYaw * particleScale), (float)(f12 - cosPitch * particleScale * 2.0F), (float)(f13 + sinYaw * particleScale)).setUv((float)(xmin), (float)(y1max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaA));;

        halfScale = particleScale * 3F;
        
        //畫出圈圈(朝上)
        render.addVertex((float)(f11 + halfScale), (float)(f12b), (float)(f13 + halfScale)).setUv((float)(xmax), (float)(y2max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 + halfScale), (float)(f12b), (float)(f13 - halfScale)).setUv((float)(xmax), (float)(y2min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 - halfScale), (float)(f12b), (float)(f13 - halfScale)).setUv((float)(xmin), (float)(y2min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 - halfScale), (float)(f12b), (float)(f13 + halfScale)).setUv((float)(xmin), (float)(y2max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;

        //畫出圈圈(朝下)
        render.addVertex((float)(f11 + halfScale), (float)(f12b), (float)(f13 - halfScale)).setUv((float)(xmax), (float)(y2max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 + halfScale), (float)(f12b), (float)(f13 + halfScale)).setUv((float)(xmax), (float)(y2min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 - halfScale), (float)(f12b), (float)(f13 + halfScale)).setUv((float)(xmin), (float)(y2min)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        render.addVertex((float)(f11 - halfScale), (float)(f12b), (float)(f13 - halfScale)).setUv((float)(xmin), (float)(y2max)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.particleAlphaC));;
        
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
    	//check host position
    	if (host != null)
    	{
    		switch (this.particleType)
    		{
    		case 7:
        		//set interpolation position
        		this.xo = this.x;
                this.yo = this.y;
                this.zo = this.z;
    			this.setPos(host.getX(), host.getY()-0.04D, host.getZ());
        	break;
    		default:
    			//set interpolation position
        		this.xo = this.x;
                this.yo = this.y;
                this.zo = this.z;
    			this.setPos(host.getX(), host.getY(), host.getZ());
    		break;
    		}
    	}
    	else
    	{
    		if (particleType < 4)
    		{
    			this.remove();
    		}
    	}
    	
    	//special effect
    	switch (this.particleType)
    	{
    	case 4:
    	case 5:
    	case 6:
    		//fade out effect
        	if (age > 10)
        	{
        		this.particleAlphaA = 1F - ((age - 10F) / 20F);
        		this.particleAlphaC = this.particleAlphaA * 0.5F;
        	}
    	break;
    	case 9:  //waypoint
    		this.xo = this.x;
            this.yo = this.y;
            this.zo = this.z;
			this.setPos(this.x, this.y + this.age * 0.002D, this.z);
			
			this.particleAlphaC = 0.9F - this.age * 0.027F;
		break;
    	}//end switch
    	
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
