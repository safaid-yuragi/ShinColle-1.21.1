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

/**LASER NO TEXTURE PARTICLE
 * 給定host, target -> 生成雷射特效
 * 此為柱狀3D雷射(即六面長方體)
 * 
 * type:
 *   0: 雙紅雷射: par1為X軸位置(分左右光炮), par2為發射高度
 *   1: 大和波動砲: 主砲光束
 *   2: 守衛目標線: 指示船艦到守衛目標的連結線標示
 *   
 */
public class ParticleLaserNoTexture extends ShipParticle
{

	private int particleType;
	private float shotYaw, shotPitch, scaleOut, scaleIn, alphaOut, alphaIn;
	private double tarX, tarY, tarZ, par1, par2, par3;
	private double[][] vt, vt2;				//cube vertex
	private Entity host;
	private Entity target;
	
	
    public ParticleLaserNoTexture(ClientLevel level, Entity host, Entity target, double par1, double par2, double par3, float scale, int type)
    {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setSize(0F, 0F);
        this.host = host;
        this.target = target;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = target.getX();
        this.tarY = target.getY() + target.getBbHeight() * 0.75D;
        this.tarZ = target.getZ();
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;	//can clip = false
        
        float[] lookDeg;
        float[] posOffset;
        
        switch (type)
        {
        case 1:		//大和波動砲
        	this.lifetime = 30;
        	this.rCol = 1F;
        	this.gCol = 0.8F;
        	this.bCol = 0.9F;
        break;
        case 2:		//守衛標示線: entity類
        	lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.lifetime = 8;
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.scaleOut = this.particleScale * 0.5F;
        	this.scaleIn = this.particleScale * 0.125F;
        	this.alphaOut = 0.1F;
        	this.alphaIn = 0.2F;
        break;
        case 4:		//補給標示線
        	lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.tarX = target.getX();
    		this.tarY = target.getY() + target.getBbHeight() * 0.5D;
    		this.tarZ = target.getZ();
        	this.lifetime = 12;
        	this.rCol = 1F;
        	this.gCol = 0.75F;
        	this.bCol = 1F;
        	this.scaleOut = this.particleScale * 0.5F;
        	this.scaleIn = this.particleScale * 0.125F;
        	this.alphaOut = 0.1F;
        	this.alphaIn = 0.2F;
        break;
        case 5:		//位置標示線
        	lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.tarX = target.getX();
    		this.tarY = target.getY() + 0.2D;
    		this.tarZ = target.getZ();
        	this.lifetime = 64;
        	this.rCol = 1F;
        	this.gCol = 0.6F;
        	this.bCol = 1F;
        	this.scaleOut = this.particleScale * 0.5F;
        	this.scaleIn = this.particleScale * 0.125F;
        	this.alphaOut = 0.6F;
        	this.alphaIn = 0.8F;
        break;
        case 6:		//紫色可調粗細光束
        	lookDeg = CalcHelper.getLookDegree(tarX-x, (tarY+target.getBbHeight()*0.5D)-(y+this.par1), tarZ-z, false);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.tarX = target.getX();
    		this.tarY = target.getY() + target.getBbHeight() * 0.5D;
    		this.tarZ = target.getZ();
        	this.lifetime = 16;
        	this.rCol = 0.5F;
        	this.gCol = 0F;
        	this.bCol = 1F;
        	this.scaleOut = (float) this.par2;
        	this.scaleIn = (float) this.par3;
        break;
        default:	//紅光束砲
        	lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
        	posOffset = CalcHelper.rotateXYZByYawPitch((float)par1, 0F, 0.78F, lookDeg[0], lookDeg[1], 1F);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.x += posOffset[0];
        	this.y += (par2 + posOffset[1]);
        	this.z += posOffset[2];
        	this.lifetime = 8;
        	this.rCol = 1F;
        	this.gCol = 0F;
        	this.bCol = 0F;
        	this.scaleOut = this.particleScale * 0.5F;
        	this.scaleIn = this.particleScale * 0.125F;
        	this.alphaOut = 0.1F;
        	this.alphaIn = 0.2F;
        break;
        }//end switch
    }
    
    public ParticleLaserNoTexture(ClientLevel level, Entity host, double tarX, double tarY, double tarZ, float scale, int type)
    {
        super(level, host.getX(), host.getY(), host.getZ());
        this.setSize(0F, 0F);
        this.host = host;
        this.target = host;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.par1 = 0D;
        this.par2 = 0D;
        this.par3 = 0D;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.hasPhysics = false;	//can clip = false
        
        float[] lookDeg;
        float[] posOffset;
        
        switch (type)
        {
        case 3:		//守衛標示線: block類
        	lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
        	this.shotYaw = lookDeg[0];
        	this.shotPitch = lookDeg[1];
        	this.lifetime = 8;
        	this.rCol = 1F;
        	this.gCol = 1F;
        	this.bCol = 1F;
        	this.scaleOut = this.particleScale * 0.5F;
        	this.scaleIn = this.particleScale * 0.125F;
        	this.alphaOut = 0.1F;
        	this.alphaIn = 0.2F;
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
		
		//out
		float[] v1 = CalcHelper.rotateXYZByYawPitch(1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v2 = CalcHelper.rotateXYZByYawPitch(1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v3 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, -1F, shotYaw, shotPitch, this.scaleOut);
		float[] v4 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, -1F, shotYaw, shotPitch, this.scaleOut);
		//in
		float[] v5 = CalcHelper.rotateXYZByYawPitch(1F, -1F, 0F, shotYaw, shotPitch, this.scaleIn);
		float[] v6 = CalcHelper.rotateXYZByYawPitch(1F, 1F, 0F, shotYaw, shotPitch, this.scaleIn);
		float[] v7 = CalcHelper.rotateXYZByYawPitch(-1F, 1F, 0F, shotYaw, shotPitch, this.scaleIn);
		float[] v8 = CalcHelper.rotateXYZByYawPitch(-1F, -1F, 0F, shotYaw, shotPitch, this.scaleIn);
		
		//particle是以client端視野來render, 因此座標要扣掉interpPos轉換為玩家視野座標
		double hx = this.xo + (this.x - this.xo) * (double)ptick - interpPosX;
        double hy = this.yo + (this.y - this.yo) * (double)ptick - interpPosY;
        double hz = this.zo + (this.z - this.zo) * (double)ptick - interpPosZ;
        double tx = this.tarX - interpPosX;
        double ty = this.tarY - interpPosY;
        double tz = this.tarZ - interpPosZ;
        
        //計算外層紅色的8個vertex
        vt[0][0] = hx+v1[0];	vt[0][1] = hy+v1[1];	vt[0][2] = hz+v1[2];
        vt[1][0] = hx+v2[0];	vt[1][1] = hy+v2[1];	vt[1][2] = hz+v2[2];
        vt[2][0] = hx+v3[0];	vt[2][1] = hy+v3[1];	vt[2][2] = hz+v3[2];
        vt[3][0] = hx+v4[0];	vt[3][1] = hy+v4[1];	vt[3][2] = hz+v4[2];
        vt[4][0] = tx+v1[0];	vt[4][1] = ty+v1[1];	vt[4][2] = tz+v1[2];
        vt[5][0] = tx+v2[0];	vt[5][1] = ty+v2[1];	vt[5][2] = tz+v2[2];
        vt[6][0] = tx+v3[0];	vt[6][1] = ty+v3[1];	vt[6][2] = tz+v3[2];
        vt[7][0] = tx+v4[0];	vt[7][1] = ty+v4[1];	vt[7][2] = tz+v4[2];
        //計算內層白色的8個vertex
        vt2[0][0] = hx+v5[0];	vt2[0][1] = hy+v5[1];	vt2[0][2] = hz+v5[2];
        vt2[1][0] = hx+v6[0];	vt2[1][1] = hy+v6[1];	vt2[1][2] = hz+v6[2];
        vt2[2][0] = hx+v7[0];	vt2[2][1] = hy+v7[1];	vt2[2][2] = hz+v7[2];
        vt2[3][0] = hx+v8[0];	vt2[3][1] = hy+v8[1];	vt2[3][2] = hz+v8[2];
        vt2[4][0] = tx+v5[0];	vt2[4][1] = ty+v5[1];	vt2[4][2] = tz+v5[2];
        vt2[5][0] = tx+v6[0];	vt2[5][1] = ty+v6[1];	vt2[5][2] = tz+v6[2];
        vt2[6][0] = tx+v7[0];	vt2[6][1] = ty+v7[1];	vt2[6][2] = tz+v7[2];
        vt2[7][0] = tx+v8[0];	vt2[7][1] = ty+v8[1];	vt2[7][2] = tz+v8[2];

        //start
        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
        
        
        //內層白色
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[1][0]), (float)(vt2[1][1]), (float)(vt2[1][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[2][0]), (float)(vt2[2][1]), (float)(vt2[2][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[6][0]), (float)(vt2[6][1]), (float)(vt2[6][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[5][0]), (float)(vt2[5][1]), (float)(vt2[5][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        render.addVertex((float)(vt2[3][0]), (float)(vt2[3][1]), (float)(vt2[3][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[0][0]), (float)(vt2[0][1]), (float)(vt2[0][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[4][0]), (float)(vt2[4][1]), (float)(vt2[4][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        render.addVertex((float)(vt2[7][0]), (float)(vt2[7][1]), (float)(vt2[7][2])).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alphaIn));;
        
        //外層紅色
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[1][0]), (float)(vt[1][1]), (float)(vt[1][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[2][0]), (float)(vt[2][1]), (float)(vt[2][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[6][0]), (float)(vt[6][1]), (float)(vt[6][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[5][0]), (float)(vt[5][1]), (float)(vt[5][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
        render.addVertex((float)(vt[3][0]), (float)(vt[3][1]), (float)(vt[3][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[0][0]), (float)(vt[0][1]), (float)(vt[0][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[4][0]), (float)(vt[4][1]), (float)(vt[4][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        render.addVertex((float)(vt[7][0]), (float)(vt[7][1]), (float)(vt[7][2])).setColor((float)(this.rCol), (float)(this.gCol), (float)(this.bCol), (float)(this.alphaOut));;
        
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
    	
    	//null check
    	if (host == null || target == null)
    	{
    		this.remove();
    	}
    	//update pos
    	else
    	{
    		float[] lookDeg;
    		float[] posOffset;
    		
    		switch (this.particleType)
    		{
    		case 1:		//yamato cannon beam
    			lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
            	posOffset = CalcHelper.rotateXYZByYawPitch(0F, 0F, host.getBbWidth() * 2F, lookDeg[0], lookDeg[1], 1F);
            	
        		this.x = host.getX() + posOffset[0];
            	this.y = host.getY() + host.getBbHeight() * 0.6D;
            	this.z = host.getZ() + posOffset[2];
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
        		this.tarX = target.getX();
        		this.tarY = target.getY() + target.getBbHeight() * 0.5F;
        		this.tarZ = target.getZ();
        		
        		//change alpha
        		if (this.age > 20)
        		{
        			this.alphaIn = 1F + (20 - age) * 0.1F;
        			this.alphaOut = this.alphaIn * 0.25F;
        		}
        		else if (this.age < 4)
        		{
        			this.alphaIn = 0.2F + age * 0.2F;
        			this.alphaOut = this.alphaIn * 0.25F;
        		}
        		else
        		{
        			this.alphaIn = 1F;
        			this.alphaOut = 0.1F + this.random.nextFloat() * 0.25F;
        		}
        		
        		//change scale
        		if (this.age > 20)
        		{
        			this.scaleOut = this.particleScale * (1F + (age - 20));
                	this.scaleIn = this.particleScale * 0.35F  * (1F - (age - 20) * 0.1F);
        		}
        		else if (this.age < 8)
        		{
        			this.scaleOut = this.particleScale * 0.3F * (age * 0.3F);
                	this.scaleIn = this.particleScale * 0.35F * (age * 0.125F);
        		}
        		else
        		{
        			this.scaleOut = this.particleScale * 1F;
                	this.scaleIn = this.particleScale * 0.35F;
        		}
        		
        		//random scale effect
	        	this.scaleOut += this.random.nextFloat() * 0.2F - 0.05F;
	        	this.scaleIn += this.random.nextFloat() * 0.08F - 0.04F;
	        	
        	break;
    		case 2:		//守衛標示線: entity類
    			this.tarX = target.getX();
        		this.tarY = target.getY();
        		this.tarZ = target.getZ();
    		case 3:		//守衛標示線: block類
    			this.x = host.getX();
            	this.y = host.getY();
            	this.z = host.getZ();
            	
    			lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
            	
        		if (this.age > 4)
        		{
        			this.alphaIn = 1.0F + (4 - age) * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
        		else
        		{
        			this.alphaIn = 0.2F + age * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
    		break;
    		case 4:		//補給標示線
    			this.tarX = target.getX();
        		this.tarY = target.getY() + target.getBbHeight() * 0.5D;
        		this.tarZ = target.getZ();
        		this.x = host.getX();
            	this.y = host.getY();
            	this.z = host.getZ();
            	
    			lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
            	
        		if (this.age > 4)
        		{
        			this.alphaIn = 1.0F + (4 - age) * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
        		else
        		{
        			this.alphaIn = 0.2F + age * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
    		break;
    		case 5:		//位置標示線
    			this.tarX = target.getX();
        		this.tarY = target.getY() + 0.2D;
        		this.tarZ = target.getZ();
        		this.x = host.getX();
            	this.y = host.getY() + 0.65D;
            	this.z = host.getZ();
            	
    			lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
            	
        		if (this.age > 56)
        		{
        			this.alphaIn *= 0.6F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
    		break;
    		case 6:		//紫色可調粗細光束
	        	lookDeg = CalcHelper.getLookDegree(tarX-x, (tarY+target.getBbHeight()*0.5D)-(y+this.par1), tarZ-z, false);
	        	this.shotYaw = lookDeg[0];
	        	this.shotPitch = lookDeg[1];
        		this.x = host.getX();
            	this.y = host.getY() + this.par1;
            	this.z = host.getZ();
	        	this.tarX = target.getX();
	    		this.tarY = target.getY() + target.getBbHeight() * 0.5D;
	    		this.tarZ = target.getZ();
	    		
        		if (this.age < 8)
        		{
                	this.scaleIn = (float)this.par3 * (1F + 0.6F * this.age);
        			this.alphaIn = 0.2F + age * 0.1F;
        			this.alphaOut = this.alphaIn * 0.25F;
        		}
        		else if (this.age > 10)
        		{
        			this.scaleIn = this.scaleIn * 0.75F;
        			this.alphaIn = 1F + (10 - age) * 0.15F;
        			this.alphaOut = this.alphaIn * 0.25F;
        		}
        		else
        		{
        			this.alphaIn = 1F;
        			this.alphaOut = 0.25F;
        		}
        	break;
    		default:	//red laser
    			//force host look vector
    		    if (this.host instanceof LivingEntity)
    		    {
    		        ((LivingEntity) this.host).yBodyRot = shotYaw * Values.N.DIV_180_PI;
    		    }
    		    else
    		    {
    		        this.host.setYRot(shotYaw * Values.N.DIV_180_PI);
    		    }
    			
    			lookDeg = CalcHelper.getLookDegree(tarX-x, tarY-y, tarZ-z, false);
            	posOffset = CalcHelper.rotateXYZByYawPitch((float)par1, 0F, 0.78F, lookDeg[0], lookDeg[1], 1F);
            	this.shotYaw = lookDeg[0];
            	this.shotPitch = lookDeg[1];
            	this.x = host.getX() + posOffset[0];
            	this.y = host.getY() + par2 + posOffset[1];
            	this.z = host.getZ() + posOffset[2];
        		this.tarX = target.getX();
        		this.tarY = target.getY() + target.getBbHeight() * 0.75D;
        		this.tarZ = target.getZ();
        		
        		if (this.age > 4)
        		{
        			this.alphaIn = 1.0F + (4 - age) * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
        		else
        		{
        			this.alphaIn = 0.2F + age * 0.2F;
        			this.alphaOut = this.alphaIn * 0.5F;
        		}
    		break;
    		}//end switch
    	}
    	
        if(this.age++ > this.lifetime)
        {
            this.remove();
        }
    }
    
    
}
