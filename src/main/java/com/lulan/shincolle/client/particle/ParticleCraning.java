package com.lulan.shincolle.client.particle;

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

/** CRANING PARTICLE
 *   
 */
public class ParticleCraning extends ShipParticle
{

    private int particleType;
    private float lenMax, len;
    private double[][] vt1, vt2;  //cube vertex
    
    
    public ParticleCraning(ClientLevel level, double x, double y, double z, double lengthMax, double scale, int type)
    {
        super(level, x, y, z);
        this.setSize(0F, 0F);
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.lenMax = (float) lengthMax;
        this.particleScale = (float) scale;
        this.particleType = type;
        this.vt1 = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;    //can clip = false
        
        float[] lookDeg;
        float[] posOffset;
        
        switch (type)
        {
        default:    //craning
            this.lifetime = 127;
            this.rCol = 0.6F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.len = 0F;
        break;
        }
    }

    //par3 = Yaw的cos值, par4 = Pitch的cos值, par5 = Yaw的sin值
    //par6 = Yaw的sin值乘上-Pitch的sin值, par7 = Yaw的cos值乘上Pitch的sin值
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
        
        float sizeHead = this.particleScale * 1F;
        float sizeChain = this.particleScale * 0.25F;
        
        //out
        float[] v1 = new float[] {sizeHead * 0.75F, -sizeHead, -sizeHead};
        float[] v2 = new float[] {sizeHead * 0.75F, sizeHead, -sizeHead};
        float[] v3 = new float[] {-sizeHead * 0.75F, sizeHead, -sizeHead};
        float[] v4 = new float[] {-sizeHead * 0.75F, -sizeHead, -sizeHead};
        //in
        float[] v5 = new float[] {sizeChain, -sizeChain * 1.5F, -sizeChain};
        float[] v6 = new float[] {sizeChain, sizeChain * 1.5F, -sizeChain};
        float[] v7 = new float[] {-sizeChain, sizeChain * 1.5F, -sizeChain};
        float[] v8 = new float[] {-sizeChain, -sizeChain * 1.5F, -sizeChain};
        
        //particle是以client端視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
        double hx = this.xo + (this.x - this.xo) * (double)ptick - interpPosX;
        double hy = this.yo + (this.y - this.yo) * (double)ptick - interpPosY - len + this.particleScale * 5D;
        double hz = this.zo + (this.z - this.zo) * (double)ptick - interpPosZ + this.particleScale * 0.5D;
        double z1 = this.particleScale * 0.8D;
        double z2 = this.particleScale * 0.25D;
        double y1 = this.particleScale * 1D;
        
        //crane head
        vt1[0][0] = hx+v1[0];    vt1[0][1] = hy+v1[1];    vt1[0][2] = hz+v1[2];
        vt1[1][0] = hx+v2[0];    vt1[1][1] = hy+v2[1];    vt1[1][2] = hz+v2[2];
        vt1[2][0] = hx+v3[0];    vt1[2][1] = hy+v3[1];    vt1[2][2] = hz+v3[2];
        vt1[3][0] = hx+v4[0];    vt1[3][1] = hy+v4[1];    vt1[3][2] = hz+v4[2];
        vt1[4][0] = hx+v1[0];    vt1[4][1] = hy+v1[1];    vt1[4][2] = hz+v1[2]+z1;
        vt1[5][0] = hx+v2[0];    vt1[5][1] = hy+v2[1];    vt1[5][2] = hz+v2[2]+z1;
        vt1[6][0] = hx+v3[0];    vt1[6][1] = hy+v3[1];    vt1[6][2] = hz+v3[2]+z1;
        vt1[7][0] = hx+v4[0];    vt1[7][1] = hy+v4[1];    vt1[7][2] = hz+v4[2]+z1;
        
        hz -= this.particleScale * 0.47D;
        
        //crane chain
        vt2[0][0] = hx+v5[0];    vt2[0][1] = hy+v5[1]+y1;    vt2[0][2] = hz+v5[2];
        vt2[1][0] = hx+v6[0];    vt2[1][1] = hy+v6[1]+y1;    vt2[1][2] = hz+v6[2];
        vt2[2][0] = hx+v7[0];    vt2[2][1] = hy+v7[1]+y1;    vt2[2][2] = hz+v7[2];
        vt2[3][0] = hx+v8[0];    vt2[3][1] = hy+v8[1]+y1;    vt2[3][2] = hz+v8[2];
        vt2[4][0] = hx+v5[0];    vt2[4][1] = hy+v5[1]+y1;    vt2[4][2] = hz+v5[2]+z2;
        vt2[5][0] = hx+v6[0];    vt2[5][1] = hy+v6[1]+y1;    vt2[5][2] = hz+v6[2]+z2;
        vt2[6][0] = hx+v7[0];    vt2[6][1] = hy+v7[1]+y1;    vt2[6][2] = hz+v7[2]+z2;
        vt2[7][0] = hx+v8[0];    vt2[7][1] = hy+v8[1]+y1;    vt2[7][2] = hz+v8[2]+z2;

        //start tess
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        //crane chain
        for (float clen = 0F; clen < len; clen += this.particleScale * 1D)
        {
            float ny = (float) hy + clen;
            
            //crane chain
            vt2[0][0] = hx+v5[0];    vt2[0][1] = ny+v5[1]+y1;    vt2[0][2] = hz+v5[2];
            vt2[1][0] = hx+v6[0];    vt2[1][1] = ny+v6[1]+y1;    vt2[1][2] = hz+v6[2];
            vt2[2][0] = hx+v7[0];    vt2[2][1] = ny+v7[1]+y1;    vt2[2][2] = hz+v7[2];
            vt2[3][0] = hx+v8[0];    vt2[3][1] = ny+v8[1]+y1;    vt2[3][2] = hz+v8[2];
            vt2[4][0] = hx+v5[0];    vt2[4][1] = ny+v5[1]+y1;    vt2[4][2] = hz+v5[2]+z2;
            vt2[5][0] = hx+v6[0];    vt2[5][1] = ny+v6[1]+y1;    vt2[5][2] = hz+v6[2]+z2;
            vt2[6][0] = hx+v7[0];    vt2[6][1] = ny+v7[1]+y1;    vt2[6][2] = hz+v7[2]+z2;
            vt2[7][0] = hx+v8[0];    vt2[7][1] = ny+v8[1]+y1;    vt2[7][2] = hz+v8[2]+z2;
            
            render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            
            render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            
            render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            
            render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            
            render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            
            render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
            render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        }
        
        //crane head
//        tess.setColorRGBA_F(this.rCol, this.gCol, this.bCol, 1F);
        
        render.addVertex((float)(vt1[3][0]), (float)(vt1[3][1]), (float)(vt1[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[2][0]), (float)(vt1[2][1]), (float)(vt1[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[1][0]), (float)(vt1[1][1]), (float)(vt1[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[0][0]), (float)(vt1[0][1]), (float)(vt1[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
        render.addVertex((float)(vt1[0][0]), (float)(vt1[0][1]), (float)(vt1[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[1][0]), (float)(vt1[1][1]), (float)(vt1[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[5][0]), (float)(vt1[5][1]), (float)(vt1[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[4][0]), (float)(vt1[4][1]), (float)(vt1[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
        render.addVertex((float)(vt1[4][0]), (float)(vt1[4][1]), (float)(vt1[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[5][0]), (float)(vt1[5][1]), (float)(vt1[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[6][0]), (float)(vt1[6][1]), (float)(vt1[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[7][0]), (float)(vt1[7][1]), (float)(vt1[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
        render.addVertex((float)(vt1[7][0]), (float)(vt1[7][1]), (float)(vt1[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[6][0]), (float)(vt1[6][1]), (float)(vt1[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[2][0]), (float)(vt1[2][1]), (float)(vt1[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[3][0]), (float)(vt1[3][1]), (float)(vt1[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
        render.addVertex((float)(vt1[1][0]), (float)(vt1[1][1]), (float)(vt1[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[2][0]), (float)(vt1[2][1]), (float)(vt1[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[6][0]), (float)(vt1[6][1]), (float)(vt1[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[5][0]), (float)(vt1[5][1]), (float)(vt1[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
        render.addVertex((float)(vt1[3][0]), (float)(vt1[3][1]), (float)(vt1[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[0][0]), (float)(vt1[0][1]), (float)(vt1[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[4][0]), (float)(vt1[4][1]), (float)(vt1[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        render.addVertex((float)(vt1[7][0]), (float)(vt1[7][1]), (float)(vt1[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(1F));;
        
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
        //update pos
        switch (particleType)
        {
        default:
            //伸長
            float half = lifetime * 0.45F;
            float half2 = lifetime - half;
            
            if (age <= half)
            {
                len = age / half * lenMax;
            }
            //停滯
            else if (age > half && age <= half2)
            {
                len = lenMax;
            }
            //縮回
            else if (age > half2)
            {
                len = (lifetime - age) / half * lenMax;
            }
        break;
        }
        
        if (this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
