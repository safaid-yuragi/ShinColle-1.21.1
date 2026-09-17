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

/**EMOTION PARTICLE
 * 
 */
public class ParticleEmotion extends ShipParticle
{

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/particles/particleemotion.png");
	public static final int EMO_NUMBER = 30;
	
	private Entity host = null;
	private int particleType, playTimes, fadeTick, fadeState, stayTick, stayTickCount, frameSize;
	private float playSpeed, playSpeedCount, particleIconX, particleIconY, addHeight, hostType;
	private float[] spawnRange;
	private double px, py, pz, addx, addy, addz;
	
	
	/**
	 *  par1: entityType by command /emotes
	 */
    public ParticleEmotion(ClientLevel level, Entity host, double x, double y, double z, float height, int hostType, int emoType)
    {
        super(level, x, y, z);
        this.host = host;
        this.setSize(0F, 0F);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.xd = 0D;
        this.zd = 0D;
        this.yd = 0D;
        this.particleType = emoType;
        this.particleScale = this.random.nextFloat() * 0.05F + 0.275F;
        this.alpha = 0F;
        this.playSpeed = 1F;
        this.playSpeedCount = 0F;
        this.stayTick = 10;
        this.stayTickCount = 0;
        this.fadeTick = 0;
        this.fadeState = 0;  //0:fade in, 1:normal, 2:fade out, 3:set dead
        this.frameSize = 1;
        this.addHeight = height;
        this.hostType = hostType;  //0:any entity, 1:entity, 2:block
        this.age = -1;  //prevent showing the emo's initial moving from y = 0
        this.hasPhysics = false;
        
        //set icon position
        switch(this.particleType)
        {
        case 1:   //小愛心
        	this.particleIconX = 0.0625F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 4;
        	//no stay
        	this.stayTick = 0;
			break;
        case 2:   //噴汗
        	this.particleIconX = 0.0625F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 3;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 5;
        	//no stay
        	this.stayTick = 0;
        	break;
        case 3:   //問號
        	this.particleIconX = 0.125F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
			break;
        case 4:   //驚嘆號
        	this.particleIconX = 0.125F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//long stay
        	this.stayTick = 20;
        	break;
        case 5:   //點點點
        	this.particleIconX = 0.1875F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 20;
        	//slow play
        	this.playSpeed = 0.5F;
			break;
        case 6:   //冒青筋
        	this.particleIconX = 0.1875F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	break;
        case 7:   //音符
        	this.particleIconX = 0.25F;
        	this.particleIconY = 0F;
        	this.lifetime = 15;
        	this.playTimes = 1;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//short stay
        	this.stayTick = 3;
        	//slow play
        	this.playSpeed = 0.7F;
        	break;
        case 8:   //cry
        	this.particleIconX = 0.3125F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 3;
        	//short fade in
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 0;
        	//slow play
        	this.playSpeed = 0.5F;
        	break;
        case 9:   //流口水
        	this.particleIconX = 0.3125F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 2;
        	//short fade in
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 1;
        	//slow play
        	this.playSpeed = 0.5F;
        	break;
        case 10:  //混亂
        	this.particleIconX = 0.375F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 4;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//short stay
        	this.stayTick = 1;
        	break;
        case 11:  //尋找
        	this.particleIconX = 0.375F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 2;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//short stay
        	this.stayTick = 0;
        	//slow play
        	this.playSpeed = 0.75F;
        	break;
        case 12:  //驚嚇
        	this.particleIconX = 0.4375F;
        	this.particleIconY = 0F;
        	this.lifetime = 14;
        	this.playTimes = 1;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//long stay
        	this.stayTick = 20;
        	//slow play
        	this.playSpeed = 0.75F;
        	//large frame
        	this.frameSize = 2;
        	break;
        case 13:  //點頭
        	this.particleIconX = 0.5F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 2;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 0;
        	//slow play
        	this.playSpeed = 0.75F;
        	break;
        case 14:  //+_+
        	this.particleIconX = 0.5F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 2;
        	//short fade in
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 0;
        	break;
        case 15:  //kiss
        	this.particleIconX = 0.5625F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//long stay
        	this.stayTick = 15;
        	//slow play
        	this.playSpeed = 0.7F;
        	break;
        case 16:  //lol
        	this.particleIconX = 0.5625F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 3;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 0;
        	break;
        case 17:  //奸笑
        	this.particleIconX = 0.625F;
        	this.particleIconY = 0F;
        	this.lifetime = 15;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//slow play
        	this.playSpeed = 0.5F;
        	break;
        case 18:  //殘念
        	this.particleIconX = 0.6875F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//no stay
        	this.stayTick = 0;
        	//slow play
        	this.playSpeed = 0.4F;
        	break;
        case 19:  //舔舔
        	this.particleIconX = 0.6875F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 3;
        	//cancel fade in
        	this.alpha = 1F;
        	this.fadeState = 1;
        	this.fadeTick = 3;
        	//no stay
        	this.stayTick = 0;
        	//slow play
        	this.playSpeed = 0.75F;
        	break;
        case 20:  //orz
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//long stay
        	this.stayTick = 20;
        	//slow play
        	this.playSpeed = 0.5F;
        	break;
        case 21:  //O
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 22:  //X
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.5625F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 23:  //!?
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.625F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 24:  //rock
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.6875F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 25:  //paper
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.75F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 26:  //scissors
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.8125F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 27:  //-w-
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.875F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 28:  //-口-
        	this.particleIconX = 0.75F;
        	this.particleIconY = 0.9375F;
        	this.lifetime = 0;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 40;
        	break;
        case 29:  //blink
        	this.particleIconX = 0.8125F;
        	this.particleIconY = 0F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//slow play
        	this.playSpeed = 0.35F;
        	//long stay
        	this.stayTick = 20;
        	break;
        case 30:  //哼
        	this.particleIconX = 0.8125F;
        	this.particleIconY = 0.5F;
        	this.lifetime = 7;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//slow play
        	this.playSpeed = 0.75F;
        	//short stay
        	this.stayTick = 3;
        	break;
        case 31:  //臉紅紅
        	this.particleIconX = 0.875F;
        	this.particleIconY = 0F;
        	this.lifetime = 3;
        	this.particleScale += 0.2F;
        	this.playTimes = 1;
        	//short fade in
        	this.fadeTick = 3;
        	//slow play
        	this.playSpeed = 0.75F;
        	//long stay
        	this.stayTick = 30;
        	break;
        case 32:  //尷尬
        	this.particleIconX = 0.875F;
        	this.particleIconY = 0.25F;
        	this.lifetime = 5;
        	this.playTimes = 4;
        	//slow play
        	this.playSpeed = 0.75F;
        	//no stay
        	this.stayTick = 0;
        	break;
        case 33:  //:P
        	this.particleIconX = 0.875F;
        	this.particleIconY = 0.625F;
        	this.lifetime = 4;
        	this.playTimes = 1;
        	//slow play
        	this.playSpeed = 0.25F;
        	//long stay
        	this.stayTick = 30;
        	break;
        case 34:  //|||
        	this.particleIconX = 0.875F;
        	this.particleIconY = 0.9375F;
        	this.lifetime = 0;
        	this.particleScale += 0.3F;
        	this.playTimes = 1;
        	//long stay
        	this.stayTick = 50;
        	break;
        default:  //汗
        	this.particleIconX = 0F;
        	this.particleIconY = 0F;
        	this.lifetime = 15;
        	this.playTimes = 1;
			break;
        }
        
        //init position
        this.px = x;
        this.py = y;
        this.pz = z;
        this.addx = 0D;
        this.addy = 0D;
        this.addz = 0D;
        
        calcParticlePosition();
    }
    
    //設定此particle是否會被透明物件 ex: ice, water等擋住
    
    public boolean isTransparent()
    {
    	return false;
    }

    @Override
	public void render(VertexConsumer _vc, Camera camera, float ptick)
	{
		Vec3 _cam = camera.getPosition();
		Entity entity = camera.getEntity();
		double interpPosX = _cam.x, interpPosY = _cam.y, interpPosZ = _cam.z;
		float rotX = Mth.cos(camera.getYRot() * Mth.DEG_TO_RAD);
		float rotZ = Mth.cos(camera.getXRot() * Mth.DEG_TO_RAD);
		float rotYZ = Mth.sin(camera.getYRot() * Mth.DEG_TO_RAD);
		float _sp = Mth.sin(camera.getXRot() * Mth.DEG_TO_RAD);
		float rotXY = rotYZ * _sp;
		float rotXZ = rotX * _sp;
		BufferBuilder render = null;

    	if (age < 0) return;
    	
    	RenderSystem.setShaderTexture(0, TEXTURE);
    	
    	  //save prev pos
		RenderSystem.depthMask(true);
		RenderSystem.enableBlend();
		RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		
		
		int frameAge = this.age > this.lifetime ? this.lifetime : this.age;

		float f6 = particleIconX;
		float f7 = f6 + 0.0625F;
		float f8 = particleIconY + frameAge * 0.0625F;
		float f9 = f8 + 0.0625F * this.frameSize;
		
        float f11 = (float)(this.xo + (this.x - this.xo) * (double)ptick - interpPosX);
        float f12 = (float)(this.yo + (this.y - this.yo) * (double)ptick - interpPosY);
        float f13 = (float)(this.zo + (this.z - this.zo) * (double)ptick - interpPosZ);

        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        
        //正面
        render.addVertex((float)(f11 - rotX * particleScale - rotXY * particleScale), (float)(f12 - rotZ * particleScale * frameSize), (float)(f13 - rotYZ * particleScale - rotXZ * particleScale)).setUv((float)(f7), (float)(f9)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 - rotX * particleScale + rotXY * particleScale), (float)(f12 + rotZ * particleScale * frameSize), (float)(f13 - rotYZ * particleScale + rotXZ * particleScale)).setUv((float)(f7), (float)(f8)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 + rotX * particleScale + rotXY * particleScale), (float)(f12 + rotZ * particleScale * frameSize), (float)(f13 + rotYZ * particleScale + rotXZ * particleScale)).setUv((float)(f6), (float)(f8)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 + rotX * particleScale - rotXY * particleScale), (float)(f12 - rotZ * particleScale * frameSize), (float)(f13 + rotYZ * particleScale - rotXZ * particleScale)).setUv((float)(f6), (float)(f9)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        //反面
        render.addVertex((float)(f11 + rotX * particleScale - rotXY * particleScale), (float)(f12 - rotZ * particleScale * frameSize), (float)(f13 + rotYZ * particleScale - rotXZ * particleScale)).setUv((float)(f6), (float)(f9)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 + rotX * particleScale + rotXY * particleScale), (float)(f12 + rotZ * particleScale * frameSize), (float)(f13 + rotYZ * particleScale + rotXZ * particleScale)).setUv((float)(f6), (float)(f8)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 - rotX * particleScale + rotXY * particleScale), (float)(f12 + rotZ * particleScale * frameSize), (float)(f13 - rotYZ * particleScale + rotXZ * particleScale)).setUv((float)(f7), (float)(f8)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;
        render.addVertex((float)(f11 - rotX * particleScale - rotXY * particleScale), (float)(f12 - rotZ * particleScale * frameSize), (float)(f13 - rotYZ * particleScale - rotXZ * particleScale)).setUv((float)(f7), (float)(f9)).setColor((float)(1F), (float)(1F), (float)(1F), (float)(this.alpha));;

        //draw
        drawBuf(render);

        
        RenderSystem.disableBlend();
        RenderSystem.depthMask(false);
        
    }
    
    //layer: 0:particle 1:terrain 2:items 3:custom
    

    /**
     * Called to update the entity's position/logic.
     */
    @Override
	public void tick()
    {
    	//update pos
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        
        if(host != null)
        {
        	updateHostPosition();
        }
        
        //fade state
        switch (this.fadeState)
        {
        case 0:   //fade in
        	this.fadeTick++;
        	this.alpha = this.fadeTick * 0.2F;
        	
        	if (this.fadeTick > 5) this.fadeState = 1;
        	break;
        case 1:   //age++
        	this.playSpeedCount += this.playSpeed;
        	this.age = this.frameSize * (int)this.playSpeedCount;
        	this.alpha = 1F;
        	break;
        case 2:   //fade out
        	this.fadeTick--;
        	this.alpha = this.fadeTick * 0.2F;
        	
        	if (this.fadeTick < 1)
        	{
        		this.remove();
        		return;
        	}
        	break;
    	default:
    		this.remove();
    		return;
        }
        
        //stay at last frame
        if (this.age >= lifetime)
        {
    		this.age = this.lifetime;
    		
    		//count stay ticks
    		if (this.stayTickCount > this.stayTick)
    		{
    			this.age = this.lifetime + 1;  //next loop flag
    			this.stayTickCount = 0;
    		}
    		else
    		{
    			this.stayTickCount += 1;
    		}
    	}

        //loop play
        if (this.age > this.lifetime)
        {
        	//loop times--
        	if (--this.playTimes <= 0)
        	{
        		this.fadeState = 2;  //change to fade out
        	}
        	else
        	{
        		this.age = 0;
        		this.playSpeedCount = 0F;
        	}
        }
    }
    
    private void updateHostPosition()
    {
    	//get host position
    	if (this.host != null)
    	{
            this.x = this.host.getX() + addx;
            this.y = this.host.getY() + addy;
            this.z = this.host.getZ() + addz;
        }
    }
    
    private void calcParticlePosition()
    {
    	//get host position
    	if (this.host != null)
    	{
        	this.px = this.host.getX();
            this.py = this.host.getY();
            this.pz = this.host.getZ();
        }
    	
    	//get player view angle
        float angle = Minecraft.getInstance().player.yBodyRot % 360 * Values.N.DIV_PI_180;
        float[] newPos;
        
        //tweak emote position by entity type
        if (hostType == 1)  //entity type
        {
        	//replace emotes into player's view cone
        	float frontDist = 0.7F;
        	float leftDist = -0.2F;
        	
        	switch (this.particleType)
        	{
        	case 12:  //omg
        		leftDist = 0F;
        		addy += 0.6D;
        		break;
        	case 15:  //kiss
        		frontDist = 1.5F;
            	leftDist = -0.7F;
        		break;
        	case 19:  //lick
        		frontDist = 1.4F;
            	leftDist = -1.1F;
        		break;
        	case 34:  //lll
        		frontDist = -0.2F;
        		leftDist = 0F;
        		addy -= 0.2D;
        		break;
        	}
        	
        	newPos = CalcHelper.rotateXZByAxis(frontDist, leftDist, angle, 1F);
        	addx += newPos[1];
        	addy -= 0.2D;
        	addz += newPos[0];
        }
        else  //block type
        {
        	newPos = CalcHelper.rotateXZByAxis(0F, -0.2F, angle, 1F);
        	addx += newPos[1];
        	addy += 0.5D;
        	addz += newPos[0];
        }
        	
        
        //enlarge if boss entity
        float addx2 = 0F;
        float addy2 = 0F;
        float addz2 = 0F;
        
        if (this.addHeight > 2F)
        {
        	this.particleScale += 1F;
        	addx2 = 1.2F;
        	addy2 = 1.5F;
        	addz2 = 0.5F;
        }
        
        //set particle position
        switch (this.particleType)
        {
        case 2:  //right side
			newPos = CalcHelper.rotateXZByAxis(-0.2F - addz2, this.random.nextFloat() * 0.3F - 1F - addx2, angle, 1F);
			addx = addx + newPos[1];
	    	addy = addy + this.random.nextDouble() * this.addHeight * 0.2D + this.addHeight * 1.8D + addy2;
	    	addz = addz + newPos[0];
        	break;
        case 15: //front
			newPos = CalcHelper.rotateXZByAxis(this.random.nextFloat() * 0.1F - 0.7F - addx2, this.random.nextFloat() * 0.1F + 0.2F + addz2, angle, 1F);
			addx = addx + newPos[1];
			addy = addy + this.random.nextDouble() * this.addHeight * 0.2D + this.addHeight * 1.6D + addy2;
			addz = addz + newPos[0];
        	break;
        case 34: //top
			newPos = CalcHelper.rotateXZByAxis(0.15F, 0F, angle, 1F);
			addx = addx + newPos[1];
			addy = addy + this.random.nextDouble() * this.addHeight * 0.15D + this.addHeight * 1.9D + addy2;
			addz = addz + newPos[0];
        	break;
    	default: //left side
			newPos = CalcHelper.rotateXZByAxis(-0.4F - addz2, this.random.nextFloat() * 0.3F + 0.7F + addx2, angle, 1F);
			addx = addx + newPos[1];
			addy = addy + this.random.nextDouble() * this.addHeight * 0.5D + this.addHeight * 1.5D + addy2;
			addz = addz + newPos[0];
    		break;
        }
        
        //set position
        this.setPos(px + addx, py + addy, pz + addz);
        
    }
    
    
}
