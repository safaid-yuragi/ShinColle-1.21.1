package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.BasicEntityShip;

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

/**
 * SPHERE LIGHT PARTICLE
 */
public class ParticleDebugPlane extends ShipParticle
{
    
    private int particleType, bodyID;
    private Entity host;
    private float[] parms;
    private float hostWidth, yTop, yBottom, red2, green2, blue2, alpha2;
    
    
    public ParticleDebugPlane(Entity entity, int type, float...parms)
    {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.parms = parms;
        this.hasPhysics = false;
        
        switch (type)
        {
        /**
         * type 0: caress position, a plane indicator to show the caressed position
         */
        case 0:
            if (this.host != null) this.hostWidth = this.host.getBbWidth() * 0.5F;
            this.lifetime = 2;
            this.red2 = 0F;
            this.green2 = 1F;
            this.blue2 = 0F;
            this.alpha2 = 0.6F;
            this.yTop = this.parms[0];
            this.yBottom = this.parms[0];
            this.setPos(entity.getX(), entity.getY(), entity.getZ());
        break;
        /**
         * type 1: body cube position, a cube indicator
         */
        case 1:
        case 2:
        {
            if (this.host != null)
            {
                this.hostWidth = this.host.getBbWidth() * 0.5F;
                
                //set top and bottom color
                if (this.host instanceof BasicEntityShip)
                {
                    //hit sensitive
                    if (this.particleType == 2)
                    {
                        this.red2 = 1F;
                        this.green2 = 0.6F;
                        this.blue2 = 1F;
                        this.alpha2 = 0.6F;
                    }
                    else
                    {
                        this.red2 = 1F;
                        this.green2 = 1F;
                        this.blue2 = 1F;
                        this.alpha2 = 0.15F;
                    }
                    
                    //set side color
                    switch ((int)this.parms[2])
                    {
                    case 0:        //top
                        this.rCol = 1F;
                        this.gCol = 1F;
                        this.bCol = 0F;
                        this.alpha = 0.15F;
                    break;
                    case 1:        //head
                        this.rCol = 0F;
                        this.gCol = 1F;
                        this.bCol = 0F;
                        this.alpha = 0.15F;
                    break;
                    case 2:        //neck
                        this.rCol = 1F;
                        this.gCol = 0F;
                        this.bCol = 1F;
                        this.alpha = 0.15F;
                    break;
                    case 3:        //chest
                        this.rCol = 1F;
                        this.gCol = 1F;
                        this.bCol = 1F;
                        this.alpha = 0.15F;
                    break;
                    case 4:        //belly
                        this.rCol = 0F;
                        this.gCol = 1F;
                        this.bCol = 1F;
                        this.alpha = 0.15F;
                    break;
                    case 5:        //ubelly
                        this.rCol = 1F;
                        this.gCol = 0F;
                        this.bCol = 0F;
                        this.alpha = 0.15F;
                    break;
                    default:    //leg
                        this.rCol = 0F;
                        this.gCol = 0F;
                        this.bCol = 1F;
                        this.alpha = 0.15F;
                    break;
                    }
                }
            }
            
            this.lifetime = 2;
            this.yTop = this.parms[0];
            this.yBottom = this.parms[1];
            this.setPos(entity.getX(), entity.getY(), entity.getZ());
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

        if (this.age <= 1) return;
        
        float x = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
        
        
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
        
        
        
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        //draw top plane, front and back 
        render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
        
        //draw side plane
        if (yTop != yBottom)
        {
            //draw bottom plane, front and back 
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.red2), (float)(this.green2), (float)(this.blue2), (float)(this.alpha2));;
            //draw side1, front and back 
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            //draw side2, front and back 
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            //draw side3, front and back 
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z - hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            //draw side4, front and back 
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x + hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yTop), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)((double)x - hostWidth), (float)((double)y+yBottom), (float)((double)z + hostWidth)).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
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
        case 0:        //type 0: caress indicator
            this.setPos(this.host.getX(), this.host.getY(), this.host.getZ());
        break;
        }
    }
    
    
}
