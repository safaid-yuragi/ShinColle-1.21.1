package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IFloatingEntity;
import com.lulan.shincolle.entity.IShipEmotion;
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

/** NO TEXTURE LIGHTNING PARTICLE
 * 
 *  shape: stem with increase wide & same Y length
 * 
 *  parms: level, host, scale, type
 */
public class ParticleLightning extends ShipParticle
{

    private int particleType;        //0:red white lightning
    private Entity host;
    private int numStem;            //lightning length
    private double[][] prevShape;    //prev lightning shape
    private float scaleXZ, scaleY;
    
    
    public ParticleLightning(ClientLevel level, Entity entity, float scale, int type)
    {
        super(level, 0D, 0D, 0D);
        this.setSize(0F, 0F);
        this.host = entity;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.hasPhysics = false;    //can clip = false

        switch (type)
        {
        default:
            this.rCol = 1F;
            this.gCol = 0.4F + this.random.nextFloat() * 0.3F;
            this.bCol = 0.4F + this.random.nextFloat() * 0.3F;
            this.alpha = 1F;
            this.lifetime = 20;
            this.numStem = 4;
            this.scaleXZ = 0.01F;
            this.scaleY = 0.12F;
            this.y = host.getY() + 1.5D;
            
            //calc particle position for MountHbH
            float randx = random.nextFloat() + 0.1F;
            float[] newPos = CalcHelper.rotateXZByAxis(0.8F+random.nextFloat()*0.2F, randx, ((LivingEntity)host).yBodyRot * -0.01745F, 1F);

            if (this.host != null)
            {
                this.x = this.host.getX() + newPos[0];
                this.y = this.host.getY() + 1.53D + randx * 0.25D;
                this.z = this.host.getZ() + newPos[1];
            }
        break;
        }
        
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.prevShape = new double[numStem][6];    //prev lightning shape
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

        //create lightning shape
        float offx = 0F;
        float offz = 0F;
        float offy = 0F;
        
        //越後面的step, random range越大 (閃電到後面分支分散)
        for (int i = 0; i < numStem; i++)
        {
            //越後面的枝幹分散範圍越大
            offx = (random.nextFloat() - 0.5F) * 0.1F * (i + 1);
            offz = (random.nextFloat() - 0.5F) * 0.1F * (i + 1);
            offy = random.nextFloat() * 0.2F + 0.5F;
            
            //起始y高度 (y往下長)
            if (i == 0)
            {
                prevShape[i][1] = py + cosPitch * scaleY;
                prevShape[i][4] = prevShape[i][1];
            }
            else
            {
                prevShape[i][1] = py + cosPitch * scaleY - i * scaleY;
                prevShape[i][4] = prevShape[i][1];
            }
            
            //從後面的step開始存: x1, y1, z1, x2, y2, z2
            prevShape[i][0] = px + offx + cosYaw * scaleXZ;
            prevShape[i][2] = pz + offz + sinYaw * scaleXZ;
            prevShape[i][3] = px + offx - cosYaw * scaleXZ;
            prevShape[i][5] = pz + offz - sinYaw * scaleXZ;
        }
            
        //start
        render = TESSELATOR.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        //quad strip必須先指定下方兩點(左下 -> 右下), 再指定上方兩點(左上 -> 右上), 該面才會朝向玩家
        //跟quad不同 (右下 -> 右上 -> 左上 -> 左下)
        for (int i = numStem - 1; i >= 0; i--)
        {
            render.addVertex((float)(prevShape[i][0]), (float)(prevShape[i][1]), (float)(prevShape[i][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
            render.addVertex((float)(prevShape[i][3]), (float)(prevShape[i][4]), (float)(prevShape[i][5])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alpha));;
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
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
        
        //type 0: HarbourHime Mount
        if (this.particleType == 0 && host != null)
        {
            float randx = random.nextFloat() + 0.1F;
            float[] newPos = CalcHelper.rotateXZByAxis(0.8F+random.nextFloat()*0.2F, randx, ((LivingEntity)host).yBodyRot * -0.01745F, 1F);

            //x=1 y=1.8, x=0.7 y=1.72, x=0.5 y=1.65, x=0.3 y=1.6, x=0.1 y=1.55
            if (this.host != null)
            {
                this.x = this.host.getX() + newPos[0];
                this.y = this.host.getY() + 1.76D + randx * 0.25D;
                this.z = this.host.getZ() + newPos[1];
            }
            
            if (((IFloatingEntity)host).getEntityDepth() > 0D)
            {
                this.y -= 0.08D;
            }
            
            if (((IShipEmotion)host).getIsSitting())
            {
                this.y -= 0.23D;
            }
        }
    }
    
    
}
