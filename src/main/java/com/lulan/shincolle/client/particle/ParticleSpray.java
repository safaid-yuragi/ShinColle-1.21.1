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

/**SPRAY PARTICLE
 * 從cloud修改來, 用於液體中移動的特效
 */
public class ParticleSpray extends ShipParticle
{
	
    private int ptype;
    private float pScale;
    private double speedLimit; 
    
    
    public ParticleSpray(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, int type)
    {
        super(level, x, y, z);

        this.ptype = type;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;

        //color, speed, life setting
        switch (this.ptype)
        {
        case 1:   //white
        	this.speedLimit = 0.25D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 2:   //cyan
        	this.speedLimit = 0.3D;
        	this.rCol = 0.5F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.particleScale *= 1.5F;
            this.pScale = (float) (this.particleScale * zd);
            this.lifetime = 40;
            this.xd = 0D;
            this.zd = 0D;
        break;
        case 3:   //green
        	this.speedLimit = 0.3D;
        	this.rCol = 0.2F;
            this.gCol = 1F;
            this.bCol = 0.6F;
            this.alpha = 0.7F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 10;
        break;
        case 4:   //0.8A red
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0.8F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 5:   //0.5A white
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.5F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 6:   //0.5A LARGE white
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.5F;
            this.particleScale *= 1.5F;
            this.pScale = 15F;
            this.lifetime = 50;
            this.yd = 0D;
        break;
        case 7:   //light cyan
        	this.speedLimit = 0.3D;
        	this.rCol = 0.7F;
            this.gCol = 0.94F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 8:   //yellow
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 0.6F;
            this.alpha = 1F;
            this.particleScale *= 3F;
            this.pScale = this.particleScale;
            this.lifetime = 20;
        break;
        case 9:   //orange
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 0.35F;
            this.bCol = 0F;
            this.alpha = 0.8F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 10:   //transparent cyan
        	this.speedLimit = 0.3D;
        	this.rCol = 0.5F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.2F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 11:   //transparent red
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0.2F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 12:   //transparent white
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.5F;
            this.particleScale *= 0.75F;
            this.pScale = this.particleScale;
            this.lifetime = 50;
        break;
        case 13:   //next waypoint
        	this.speedLimit = 2D;
        	this.rCol = 1F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0.5F;
            this.particleScale *= 3F;
            this.pScale = this.particleScale;
            this.lifetime = 100;
            this.setSize(0F, 0F);
        break;
        case 14:   //paired chest
        	this.speedLimit = 2D;
        	this.rCol = 0.5F;
            this.gCol = 0F;
            this.bCol = 0.5F;
            this.alpha = 0.5F;
            this.particleScale *= 3F;
            this.pScale = this.particleScale;
            this.lifetime = 100;
            this.setSize(0F, 0F);
        break;
        case 15:   //transparent light cyan
        	this.speedLimit = 0.3D;
        	this.rCol = 0.7F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.75F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        break;
        case 16:   //XZ moving white, yd = scale
        	this.yd = 0D;
        	this.speedLimit = 0.25D;
        	this.rCol = 1F;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 1F;
            this.particleScale = (float)yd * 3F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
            this.x += (random.nextDouble() - 0.5D) * yd;
            this.y += (random.nextDouble() - 0.5D) * yd * 0.15D;
            this.z += (random.nextDouble() - 0.5D) * yd;
            this.xd *= 1.5D;
            this.zd *= 1.5D;
        break;
        default:  //default = type 0 = 1A red
        	this.speedLimit = 0.3D;
        	this.rCol = 1F;
            this.gCol = 0F;
            this.bCol = 0F;
            this.alpha = 0.7F;
            this.particleScale *= 1.5F;
            this.pScale = 15F;
            this.lifetime = 40;
            this.yd = 0D;
        break;
        }
        
        //speed limit
        double motsq = this.xd*this.xd+this.yd*this.yd+this.zd*this.zd;
        
        if (motsq > this.speedLimit * this.speedLimit)
        {
        	motsq = Math.sqrt(motsq);
        	this.xd = this.speedLimit * this.xd / motsq;
        	this.yd = this.speedLimit * this.yd / motsq;
        	this.zd = this.speedLimit * this.zd / motsq;
        }
        
    	//reset pos
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setPos(this.x, this.y, this.z);
    }
    
    /**type:
     *   0:missile spray, data: 0:vel0, 1:index
     * 
     */
    public ParticleSpray(Entity host, int type, ArrayList<Float> data)
    {
        super((ClientLevel) host.level(), host.getX(), host.getY(), host.getZ());
        this.ptype = type;
        
        //color, speed, life setting
        switch (this.ptype)
        {
        case 1:   //transparent cyan
        {
            this.x = host.getX() + host.getDeltaMovement().x * 2D - host.getDeltaMovement().x * 1.5D * data.get(1);
            this.y = host.getY() + host.getDeltaMovement().y * 2D - host.getDeltaMovement().y * 1.5D * data.get(1) + 0.5D;
            this.z = host.getZ() + host.getDeltaMovement().z * 2D - host.getDeltaMovement().z*1.5D*data.get(1);
            this.xd = -host.getDeltaMovement().x * 0.1D;
            this.yd = -host.getDeltaMovement().y * 0.1D;
            this.zd = -host.getDeltaMovement().z * 0.1D;
        	this.speedLimit = 2D;
        	
        	float velred = 1.4F - (float)data.get(0);
        	if (velred > 1F) velred = 1F;
        	else if (velred < 0F) velred = 0F;
        	
        	this.rCol = velred;
            this.gCol = 1F;
            this.bCol = 1F;
            this.alpha = 0.75F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        }
        break;
        case 2:   //transparent red
        {
            this.x = host.getX() + host.getDeltaMovement().x * 2D - host.getDeltaMovement().x * 1.5D * data.get(1);
            this.y = host.getY() + host.getDeltaMovement().y * 2D - host.getDeltaMovement().y * 1.5D * data.get(1) + 0.5D;
            this.z = host.getZ() + host.getDeltaMovement().z * 2D - host.getDeltaMovement().z*1.5D*data.get(1);
            this.xd = -host.getDeltaMovement().x * 0.1D;
            this.yd = -host.getDeltaMovement().y * 0.1D;
            this.zd = -host.getDeltaMovement().z * 0.1D;
        	this.speedLimit = 2D;
        	
        	float velgb = ((float)data.get(0) - 0.2F) * 3.333F;
        	if (velgb > 1F) velgb = 1F;
        	else if (velgb < 0F) velgb = 0F;
        	
        	this.rCol = 1F;
            this.gCol = velgb;
            this.bCol = velgb;
            this.alpha = 0.75F;
            this.particleScale *= 1.5F;
            this.pScale = this.particleScale;
            this.lifetime = 40;
        }
        break;
        }
        
        //speed limit
        double motsq = this.xd*this.xd+this.yd*this.yd+this.zd*this.zd;
        
        if (motsq > this.speedLimit * this.speedLimit)
        {
        	motsq = Math.sqrt(motsq);
        	this.xd = this.speedLimit * this.xd / motsq;
        	this.yd = this.speedLimit * this.yd / motsq;
        	this.zd = this.speedLimit * this.zd / motsq;
        }
        
    	//reset pos
		this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setPos(this.x, this.y, this.z);
    }
    
    @Override
	public int getLightColor(float ptick)
    {
        return 240;
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

    	if (this.age == 1) return;
    	
        float f6 = (this.age + ptick) / this.lifetime * 32F;

        if (f6 < 0F) f6 = 0F;
        if (f6 > 1F) f6 = 1F;
        this.particleScale = this.pScale * f6;
        
        
        RenderSystem.depthMask(false);
    	
        this.renderAtlasQuad(camera, ptick, "generic_" + Mth.clamp(7 - this.texIndex, 0, 7));
        
        RenderSystem.depthMask(true);
        
    }

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
        this.setPos(this.x, this.y, this.z);

        //set dead if max age
        if (this.age++ > this.lifetime)
        {
            this.remove();
            return;
        }
        
        switch (this.ptype)
        {
        case 13:
        case 14:
        {
        	
        	this.x += this.xd;
        	this.y += this.yd;
        	this.z += this.zd;
        }
    	break;
    	default:
    	{
            this.xd *= 0.96D;
            this.yd *= 0.96D;
            this.zd *= 0.96D;
            
            if (this.onGround)
            {
                this.xd *= 0.7D;
                this.zd *= 0.7D;
            }
            
            this.move(this.xd, this.yd, this.zd);
    	}
		break;
        }
    }
    
    
}
