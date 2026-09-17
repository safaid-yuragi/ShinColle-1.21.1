package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.reference.dataclass.ParticleData;

import java.util.ArrayList;
import java.util.Arrays;
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
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.network.chat.FormattedText;
import org.joml.Matrix4f;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import com.lulan.shincolle.reference.dataclass.ParticleData;

/**
 * CUSTOM TEXT PARTICLE
 * 顯示任意文字在目標上
 */
public class ParticleTextsCustom extends ShipParticle
{

    private int particleType, textWidth, textHeight;
    private ArrayList<Float> parms;
    private EntityRenderDispatcher rm;
    private Font fr;
    private String text;
    private Entity host;
    
    
    public ParticleTextsCustom(Entity host, ClientLevel level, ParticleData data)
    {
        super(level, 0D, 0D, 0D);
        this.setSize(0F, 0F);
        this.x = data.getFloatData(0);
        this.y = data.getFloatData(1);
        this.z = data.getFloatData(2);
        this.xd = 0D;
        this.yd = 0D;
        this.zd = 0D;
        this.particleScale = data.getFloatData(3);
        this.particleType = data.getIntData(1);
        this.hasPhysics = false;    //can clip = false
        this.host = host;
        
        
        this.fr = Minecraft.getInstance().font;
        
        switch (this.particleType)
        {
        case 0: //draw string with specific #lines and width
            this.lifetime = 30;
            this.textHeight = data.getIntData(2) - 1;
            this.textWidth = data.getIntData(3) / 2;
            this.text = data.getStringData(0);
            this.setPos(x, y, z);
        break;
        case 1: //draw string with entity
            this.lifetime = 30;
            this.textHeight = data.getIntData(2) - 1;
            this.textWidth = data.getIntData(3) / 2;
            this.text = data.getStringData(0);
            this.parms = new ArrayList<Float>(Arrays.asList((float)x, (float)y, (float)z));
            this.setPos(this.host.getX() + this.parms.get(0), this.host.getY() + this.parms.get(1), this.host.getZ() + this.parms.get(2));
        break;
        }
        
        //init position
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

        float x = (float)(this.xo + (this.x - this.xo) * ptick - interpPosX);
        float y = (float)(this.yo + (this.y - this.yo) * ptick - interpPosY);
        float z = (float)(this.zo + (this.z - this.zo) * ptick - interpPosZ);
        
        
        PoseStack pose = new PoseStack();
        pose.translate(x, y, z);
        pose.mulPose(camera.rotation());
        pose.scale(-0.025F, -0.025F, 0.025F);
        Matrix4f m4 = pose.last().pose();

        render = TESSELATOR.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
		RenderSystem.setShader(GameRenderer::getPositionColorShader);
		RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        render.addVertex(m4, -this.textWidth - 1, -1F - this.textHeight * 9F, 0F).setColor(0F, 0F, 0F, 0.25F);
        render.addVertex(m4, -this.textWidth - 1, 8F, 0F).setColor(0F, 0F, 0F, 0.25F);
        render.addVertex(m4, this.textWidth + 1, 8F, 0F).setColor(0F, 0F, 0F, 0.25F);
        render.addVertex(m4, this.textWidth + 1, -1F - this.textHeight * 9F, 0F).setColor(0F, 0F, 0F, 0.25F);
        drawBuf(render);
        RenderSystem.depthMask(true);

        //draw text
        MultiBufferSource.BufferSource bs = Minecraft.getInstance().renderBuffers().bufferSource();
        List<FormattedCharSequence> lines = this.fr.split(FormattedText.of(this.text), this.textWidth * 2);
        int ly = -this.textHeight * 9;
        for (FormattedCharSequence line : lines)
        {
            this.fr.drawInBatch(line, -this.textWidth, ly, -1, false, m4, bs, Font.DisplayMode.NORMAL, 0, 15728880);
            ly += 9;
        }
        bs.endBatch();
        RenderSystem.disableBlend();
        
        
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
            return;
        }
        
        switch (this.particleType)
        {
        case 1:
            if (this.host == null)
            {
                this.remove();
                return;
            }
            
            this.setPos(this.host.getX() + this.parms.get(0), this.host.getY() + this.parms.get(1), this.host.getZ() + this.parms.get(2));
        break;
        }
    }
    
    
}
