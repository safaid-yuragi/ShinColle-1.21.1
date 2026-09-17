package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Reference;
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

public class ParticleGradient extends ShipParticle
{
    
    private static final ResourceLocation TEXTURE1 = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particlegradient.png");
    private int particleType, gradCurrent, gradSpace;
    private Entity host;
    private float[][] gradPos;  //grad position: 0: rad, 1: prev rad, 2~5:RGBA, 6:age
    private float gradRad, gradSpd, gradFad, gradHFad, gradSlope;
    private EntityRenderDispatcher rm;
    
    
    public ParticleGradient(Entity entity, int type, float...parms)
    {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        this.gradCurrent = 0;  //new grad index
        
        
        switch (type)
        {
        /**
         * type 0: gradient radiate IN
         * type 1: gradient radiate OUT
         * type 2: gradient radiate OUT and y updated with host
         */
        case 0:
        case 1:
            this.particleScale = parms[0];
            this.gradRad = 0F;
            this.gradFad = parms[1];
            this.gradSpd = parms[2];
            this.gradHFad = 20F;
            this.gradSlope = 1.5F;
            this.gradSpace = (int) parms[3];
            if (this.gradSpace <= 1) this.gradSpace = 1;
            this.rCol = parms[4];
            this.gCol = parms[5];
            this.bCol = parms[6];
            this.alpha = parms[7];
            this.lifetime = 80;
            this.gradPos = new float[20][7];
            this.setPos(entity.getX(), entity.getY(), entity.getZ());
        break;
        case 2:
            this.particleScale = parms[0];
            this.gradRad = 0F;
            this.gradFad = parms[1];
            this.gradSpd = parms[2];
            this.gradSpace = (int) parms[3];
            if (this.gradSpace <= 1) this.gradSpace = 1;
            this.rCol = parms[4];
            this.gCol = parms[5];
            this.bCol = parms[6];
            this.alpha = parms[7];
            this.gradHFad = parms[8];
            this.gradSlope = parms[9];
            this.lifetime = 80;
            this.gradPos = new float[20][7];
            this.setPos(entity.getX(), entity.getY(), entity.getZ());
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

        RenderSystem.setShaderTexture(0, TEXTURE1);
        
        float x = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
        
        
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
        
        
        
        for (float[] grad : this.gradPos)
        {
            
            //too far away, skip
            if (grad[0] > 6F && grad[0] <= 0F || grad[5] < 0.05F) continue;
            
            float rad = grad[1] + (grad[0] - grad[1]) * ptick;
            float h = (this.gradHFad - grad[6]) / this.gradHFad;
            if (h < 0.1F) h = 0.1F;
            
            render = TESSELATOR.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            
            //正面
            render.addVertex((float)(x + rad), (float)(y), (float)(z + rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad), (float)(y), (float)(z + rad)).setUv((float)(1D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(1D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad), (float)(y), (float)(z - rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z - rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad), (float)(y), (float)(z - rad)).setUv((float)(1D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z - rad * this.gradSlope)).setUv((float)(1D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad), (float)(y), (float)(z + rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            
            //反面
            render.addVertex((float)(x + rad), (float)(y), (float)(z + rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad), (float)(y), (float)(z - rad)).setUv((float)(1D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z - rad * this.gradSlope)).setUv((float)(1D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad), (float)(y), (float)(z - rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z - rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad), (float)(y), (float)(z + rad)).setUv((float)(1D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x - rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(1D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad), (float)(y), (float)(z + rad)).setUv((float)(0D), (float)(1D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            render.addVertex((float)(x + rad * this.gradSlope), (float)(y + this.particleScale * h), (float)(z + rad * this.gradSlope)).setUv((float)(0D), (float)(0D)).setColor((float)(grad[2]), (float)(grad[3]), (float)(grad[4]), (float)(grad[5]));;
            
            drawBuf(render);
        }
        
        //draw text
        
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
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
        
        //update movement
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        
        //update grad
        switch (this.particleType)
        {
        case 0:        //IN
        break;
        case 1:        //OUT
        {
            if (this.host != null)
            {
                this.setPos(this.host.getX(), this.host.getY(), this.host.getZ());
            }
            
            if (this.age <= 40 && this.age % this.gradSpace == 0)
            {
                this.gradPos[this.gradCurrent] = new float[] {0F, 0F, this.rCol, this.gCol, this.bCol, this.alpha, 0F};
                this.gradCurrent++;
                if (this.gradCurrent >= this.gradPos.length) this.gradCurrent = 0;
            }
            
            //update grad pos: halve dist to (0,0,0)
            for (int i = 0; i < this.gradPos.length; i++)
            {
                //move
                this.gradPos[i][1] = this.gradPos[i][0];    //prev rad for interpolation
                this.gradPos[i][0] += this.gradSpd;
                
                //age++
                this.gradPos[i][6] += 1;
                
                //alpha--
                if (this.age % 2 == 0) this.gradPos[i][5] *= this.gradFad;
            }
        }
        break;
        case 2:        //OUT and update y
        {
            if (this.age == 1) this.gradPos[0] = new float[] {0F, 0F, this.rCol, this.gCol, this.bCol, this.alpha, 0F};
            
            //move
            this.gradPos[0][1] = this.gradPos[0][0];    //prev rad for interpolation
            this.gradPos[0][0] += this.gradSpd;
            
            //age++
            this.gradPos[0][6] += 1;
            
            //alpha--
            if ((this.age & 1) == 0) this.gradPos[0][5] *= this.gradFad;
        }
        break;
        }
        
    }
    

}
