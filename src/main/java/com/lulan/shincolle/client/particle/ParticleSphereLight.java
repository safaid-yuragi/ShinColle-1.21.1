package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.Reference;
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
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.reference.Values;

/**
 * SPHERE LIGHT PARTICLE
 */
public class ParticleSphereLight extends ShipParticle
{

    private static final ResourceLocation TEXTURE1 = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particlegradientline.png");
    private static int NumBeam = 30;
    private int particleType, beamCurrent;
    private Entity host;
    private float[][] beamPos;                    //beam position: 0~1: xy, 2~5:RGBA, 6:age
    private float beamRad, beamSpd, beamThick, beamHeight;
    private EntityRenderDispatcher rm;
    
    
    public ParticleSphereLight(Entity entity, int type, float...parms)
    {
        super((ClientLevel) entity.level(), 0F, 0F, 0F);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = type;
        this.hasPhysics = false;
        this.beamCurrent = 0;                    //new beam index
        
        
        //particleSetting: 0:all, 1:decr, 2:min -> 3:all, 2:decr, 1:min
        NumBeam = (3 - Minecraft.getInstance().options.particles().get().getId()) * 25;
        
        switch (type)
        {
        /**
         * type 0: light beam radiate IN
         * type 1: light beam radiate OUT
         * type 2: light beam radiate UP
         * type 3: light beam radiate DOWN
         * type 4: light beam STEADY
         *   parms: 0:scale, 1:radius, 2:beam speed, 3:beam thickness, 4~7:RGBA
         * 
         * type 5: light beam radiate IN simple
         *   parms: 0:life, 1:scale
         */
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
            this.particleScale = parms[0];
            this.beamRad = parms[1];
            this.beamSpd = parms[2];
            this.beamThick = parms[3];
            this.rCol = parms[4];
            this.gCol = parms[5];
            this.bCol = parms[6];
            this.alpha = parms[7];
            this.beamHeight = parms[8];
            this.lifetime = 40;
            this.beamPos = new float[NumBeam][6];
            this.setPos(entity.getX(), entity.getY()+this.beamHeight, entity.getZ());
        break;
        case 5:
            this.lifetime = (int) parms[0];
            this.particleScale = parms[1];
            this.beamRad = 0.5F;
            this.beamSpd = 0.8F;
            this.beamThick = 2F;
            this.rCol = 0F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0.8F;
            this.beamHeight = entity.getBbHeight() * 0.5F;
            this.beamPos = new float[NumBeam][6];
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

        RenderSystem.setShaderTexture(0, TEXTURE1);
        
        float x = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
        
        
        /*GL*/RenderSystem.enableBlend(); //FIXME x, y, z);
//        /*GL*/RenderSystem.enableBlend(); //FIXME 0F, 1F, 0F);                    //光源為正上方
        /*GL*/RenderSystem.enableBlend(); //FIXME -camera.getYRot(), 0F, 1F, 0F);        //左右視角調整
        /*GL*/RenderSystem.enableBlend(); //FIXME camera.getXRot(), 1F, 0F, 0F);        //上下視角調整
        /*GL*/RenderSystem.enableBlend(); //FIXME -0.25F, -0.25F, 0.25F);
        
        RenderSystem.depthMask(true);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
        
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        
        for (float[] beam : this.beamPos)
        {
            if (beam[0] == 0F && beam[1] == 0F) continue;
            float depth = this.random.nextFloat() * 0.1F;
            
            render.addVertex((float)(this.particleScale * beam[0] - beam[1] * this.beamThick), (float)(this.particleScale * beam[1] + beam[0] * this.beamThick), (float)(depth)).setUv((float)(1D), (float)(1D)).setColor((float)(beam[2]), (float)(beam[3]), (float)(beam[4]), (float)(beam[5]));;
            render.addVertex((float)(this.particleScale * beam[0]), (float)(this.particleScale * beam[1]), (float)(depth)).setUv((float)(1D), (float)(0D)).setColor((float)(beam[2]), (float)(beam[3]), (float)(beam[4]), (float)(beam[5]));;
            render.addVertex((float)(beam[0]), (float)(beam[1]), (float)(depth)).setUv((float)(0D), (float)(0D)).setColor((float)(beam[2]), (float)(beam[3]), (float)(beam[4]), (float)(beam[5]));;
            render.addVertex((float)(beam[0] - beam[1] * this.beamThick), (float)(beam[1] + beam[0] * this.beamThick), (float)(depth)).setUv((float)(0D), (float)(1D)).setColor((float)(beam[2]), (float)(beam[3]), (float)(beam[4]), (float)(beam[5]));;
        }
        
        drawBuf(render);
        
        RenderSystem.depthMask(false);
        
        RenderSystem.disableBlend();
        
        
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
        
        if (this.host != null)
        {
            this.setPos(this.host.getX(), this.host.getY()+this.beamHeight, this.host.getZ());
        }
        
        //update beam
        float[] newpos;
        
        switch (this.particleType)
        {
        case 0:        //IN
        {
            if (this.age <= 30)
            {
                for (int i = 0; i < (3 - Minecraft.getInstance().options.particles().get().getId()) * 3; i++)
                {
                    //create new beam
                    newpos = CalcHelper.rotateXZByAxis(
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.random.nextFloat() * 360F * Values.N.DIV_PI_180, 1F);
                    this.beamPos[this.beamCurrent] = new float[] {newpos[0], newpos[1], this.rCol, this.gCol, this.bCol, this.alpha};
                    this.beamCurrent++;
                    if (this.beamCurrent >= this.beamPos.length) this.beamCurrent = 0;
                }
            }
            
            //update beam pos: halve dist to (0,0,0)
            for (int i = 0; i < this.beamPos.length; i++)
            {
                //move
                this.beamPos[i][0] *= this.beamSpd;
                this.beamPos[i][1] *= this.beamSpd;
                
                //min limit
                if (this.beamPos[i][0] > 0F && this.beamPos[i][0] < 0.001F) this.beamPos[i][0] = 0.001F;
                if (this.beamPos[i][0] < 0F && this.beamPos[i][0] > -0.001F) this.beamPos[i][0] = -0.001F;
                if (this.beamPos[i][1] > 0F && this.beamPos[i][1] < 0.001F) this.beamPos[i][1] = 0.001F;
                if (this.beamPos[i][1] < 0F && this.beamPos[i][1] > -0.001F) this.beamPos[i][1] = -0.001F;
            }
        }
        break;
        case 1:        //OUT
        {
            if (this.age <= 40)
            {
                for (int i = 0; i < 2; i++)
                {
                    //create new beam
                    newpos = CalcHelper.rotateXZByAxis(
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.random.nextFloat() * 540F * Values.N.DIV_PI_180, 1F);
                    this.beamPos[this.beamCurrent] = new float[] {newpos[0], newpos[1], this.rCol, this.gCol, this.bCol, this.alpha};
                    this.beamCurrent++;
                    if (this.beamCurrent >= this.beamPos.length) this.beamCurrent = 0;
                }
            }
            
            //update beam pos: halve dist to (0,0,0)
            for (int i = 0; i < this.beamPos.length; i++)
            {
                //move
                this.beamPos[i][0] *= 1F + this.beamSpd;
                this.beamPos[i][1] *= 1F + this.beamSpd;
                
                if (this.age > 30) this.beamPos[i][5] *= 0.8F;
            }
        }
        break;
        case 2:        //UP or DOWN
        case 3:        //STEADY
        break;
        case 5:        //IN custom data
        {
            if (this.age <= this.lifetime * 0.95F)
            {
                if (this.age > this.lifetime * 0.5F)
                {
                    this.alpha *= 0.8F;
                }
                
                for (int i = 0; i < (3 - Minecraft.getInstance().options.particles().get().getId()) * 3; i++)
                {
                    //create new beam
                    newpos = CalcHelper.rotateXZByAxis(
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.beamRad * (this.random.nextFloat() + 1F),
                                            this.random.nextFloat() * 360F * Values.N.DIV_PI_180, 1F);
                    this.beamPos[this.beamCurrent] = new float[] {newpos[0], newpos[1], this.rCol + this.random.nextFloat() * 0.1F, this.gCol, this.bCol + this.random.nextFloat() * 0.2F, this.alpha};
                    this.beamCurrent++;
                    if (this.beamCurrent >= this.beamPos.length) this.beamCurrent = 0;
                }
            }
            
            //update beam pos: halve dist to (0,0,0)
            for (int i = 0; i < this.beamPos.length; i++)
            {
                //move
                this.beamPos[i][0] *= this.beamSpd;
                this.beamPos[i][1] *= this.beamSpd;
                
                //min limit
                if (this.beamPos[i][0] > 0F && this.beamPos[i][0] < 0.001F) this.beamPos[i][0] = 0.001F;
                if (this.beamPos[i][0] < 0F && this.beamPos[i][0] > -0.001F) this.beamPos[i][0] = -0.001F;
                if (this.beamPos[i][1] > 0F && this.beamPos[i][1] < 0.001F) this.beamPos[i][1] = 0.001F;
                if (this.beamPos[i][1] < 0F && this.beamPos[i][1] > -0.001F) this.beamPos[i][1] = -0.001F;
            }
        }
        break;
        }
        
    }
    
    
}
