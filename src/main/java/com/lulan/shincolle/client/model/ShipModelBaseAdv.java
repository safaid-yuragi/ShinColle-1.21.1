package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.EmotionHelper;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

/**
 * model base for advance emotion
 */
abstract public class ShipModelBaseAdv<T extends Entity> extends ShipModel<T> implements IModelEmotionAdv
{

    /** basic model */
    public ModelPart Face0;
    public ModelPart Face1;
    public ModelPart Face2;
    public ModelPart Face3;
    public ModelPart Face4;
    public ModelPart Mouth0;
    public ModelPart Mouth1;
    public ModelPart Mouth2;
    public ModelPart Flush0;
    public ModelPart Flush1;


    public ShipModelBaseAdv() {}

    /**
     * add default face boxes under the given head part.
     * replaces legacy setDefaultFaceModel() + head.addChild(Face0..Flush1).
     */
    public static void addDefaultFaceParts(PartDefinition head)
    {
        head.addOrReplaceChild("Face0", CubeListBuilder.create().texOffs(98, 63).addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1), PartPose.offset(0.0F, -12.2F, -6.1F));
        head.addOrReplaceChild("Face1", CubeListBuilder.create().texOffs(98, 76).addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1), PartPose.offset(0.0F, -12.2F, -6.1F));
        head.addOrReplaceChild("Face2", CubeListBuilder.create().texOffs(98, 89).addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1), PartPose.offset(0.0F, -12.2F, -6.1F));
        head.addOrReplaceChild("Face3", CubeListBuilder.create().texOffs(98, 102).addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1), PartPose.offset(0.0F, -12.2F, -6.1F));
        head.addOrReplaceChild("Face4", CubeListBuilder.create().texOffs(98, 115).addBox(-7.0F, 0.0F, -0.5F, 14, 12, 1), PartPose.offset(0.0F, -12.2F, -6.1F));
        head.addOrReplaceChild("Mouth0", CubeListBuilder.create().texOffs(100, 53).addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1), PartPose.offset(0.0F, -4.2F, -6.2F));
        head.addOrReplaceChild("Mouth1", CubeListBuilder.create().texOffs(100, 58).addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1), PartPose.offset(0.0F, -4.2F, -6.2F));
        head.addOrReplaceChild("Mouth2", CubeListBuilder.create().texOffs(114, 53).addBox(-3.0F, 0.0F, -0.5F, 6, 4, 1), PartPose.offset(0.0F, -4.2F, -6.2F));
        head.addOrReplaceChild("Flush0", CubeListBuilder.create().texOffs(114, 58).addBox(-1.0F, 0.0F, -0.5F, 2, 1, 0), PartPose.offset(-6.0F, -3.0F, -6.9F));
        head.addOrReplaceChild("Flush1", CubeListBuilder.create().texOffs(114, 58).addBox(-1.0F, 0.0F, -0.5F, 2, 1, 0), PartPose.offset(6.0F, -3.0F, -6.9F));
    }

    /** bake face fields from the head part that owns them */
    public void bakeFaceParts(ModelPart head)
    {
        this.Face0 = head.getChild("Face0");
        this.Face1 = head.getChild("Face1");
        this.Face2 = head.getChild("Face2");
        this.Face3 = head.getChild("Face3");
        this.Face4 = head.getChild("Face4");
        this.Mouth0 = head.getChild("Mouth0");
        this.Mouth1 = head.getChild("Mouth1");
        this.Mouth2 = head.getChild("Mouth2");
        this.Flush0 = head.getChild("Flush0");
        this.Flush1 = head.getChild("Flush1");
    }

    /** set model pose */
    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
    {
        this.entity = entity;
        IShipEmotion ent = (IShipEmotion) entity;

        //set equip
        this.showEquip(ent);

        //apply flush
        if (ent.getStateMinor(ID.M.Morale) > ID.Morale.L_Happy)
        {
            this.setFlush(true);
        }
        else
        {
            this.setFlush(false);
        }

        //roll emotion
        EmotionHelper.rollEmotionAdv(this, ent);

        if (ent.getStateFlag(ID.F.NoFuel))
        {
            this.applyDeadPose(f, f1, f2, f3, f4, ent);
        }
        else
        {
            this.applyNormalPose(f, f1, f2, f3, f4, ent);
        }

        this.syncRotationGlowPart();
    }

    //設定顯示的臉型
    @Override
    public void setFace(int emo)
    {
        switch (emo)
        {
        case 0:
            this.setFaceVisible(this.Face0, 0F);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 1:
            this.hidePart(this.Face0);
            this.setFaceVisible(this.Face1, 0F);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 2:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.setFaceVisible(this.Face2, 0F);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 3:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.setFaceVisible(this.Face3, 0F);
            this.hidePart(this.Face4);
        break;
        case 4:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.setFaceVisible(this.Face4, 0F);
        break;
        case 5:
            this.setFaceVisible(this.Face0, 3.14159F);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 6:
            this.hidePart(this.Face0);
            this.setFaceVisible(this.Face1, 3.14159F);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 7:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.setFaceVisible(this.Face2, 3.14159F);
            this.hidePart(this.Face3);
            this.hidePart(this.Face4);
        break;
        case 8:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.setFaceVisible(this.Face3, 3.14159F);
            this.hidePart(this.Face4);
        break;
        case 9:
            this.hidePart(this.Face0);
            this.hidePart(this.Face1);
            this.hidePart(this.Face2);
            this.hidePart(this.Face3);
            this.setFaceVisible(this.Face4, 3.14159F);
        break;
        default:
        break;
        }
    }

    private void setFaceVisible(ModelPart part, float yRot)
    {
        if (part != null)
        {
            part.visible = true;
            part.yRot = yRot;
        }
    }

    private void hidePart(ModelPart part)
    {
        if (part != null) part.visible = false;
    }

    //設定顯示的嘴型
    @Override
    public void setMouth(int emo)
    {
        switch (emo)
        {
        case 0:
            this.setFaceVisible(this.Mouth0, 0F);
            this.hidePart(this.Mouth1);
            this.hidePart(this.Mouth2);
        break;
        case 1:
            this.hidePart(this.Mouth0);
            this.setFaceVisible(this.Mouth1, 0F);
            this.hidePart(this.Mouth2);
        break;
        case 2:
            this.hidePart(this.Mouth0);
            this.hidePart(this.Mouth1);
            this.setFaceVisible(this.Mouth2, 0F);
        break;
        case 3:
            this.setFaceVisible(this.Mouth0, 3.14159F);
            this.hidePart(this.Mouth1);
            this.hidePart(this.Mouth2);
        break;
        case 4:
            this.hidePart(this.Mouth0);
            this.setFaceVisible(this.Mouth1, 3.14159F);
            this.hidePart(this.Mouth2);
        break;
        case 5:
            this.hidePart(this.Mouth0);
            this.hidePart(this.Mouth1);
            this.setFaceVisible(this.Mouth2, 3.14159F);
        break;
        default:
        break;
        }
    }

    //設定是否顯示臉紅紅
    @Override
    public void setFlush(boolean show)
    {
        if (this.Flush0 != null) this.Flush0.visible = show;
        if (this.Flush1 != null) this.Flush1.visible = show;
    }

    @Override
    public void setFaceNormal(IShipEmotion ent)
    {
        this.setFace(0);

        if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED && (ent.getTickExisted() & 255) > 160)
        {
            this.setMouth(3);
        }
        else
        {
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent)
    {
        this.setFace(0);
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent)
    {
        this.setFace(1);
    }

    @Override
    public void setFaceCry(IShipEmotion ent)
    {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;

        if (t < 128)
        {
            this.setFace(6);

            if (t < 64)
            {
                this.setMouth(5);
            }
            else
            {
                this.setMouth(2);
            }
        }
        else
        {
            this.setFace(7);
            this.setMouth(2);
        }
    }

    @Override
    public void setFaceAttack(IShipEmotion ent)
    {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;

        if (t < 128)
        {
            this.setFace(1);

            if (t < 64)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(2);
            }
        }
        else if (t < 256)
        {
            this.setFace(2);

            if (t < 180)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(1);
            }
        }
        else if (t < 384)
        {
            this.setFace(3);

            if (t < 320)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(4);
            }
        }
        else
        {
            this.setFace(8);

            if (t < 450)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent)
    {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;

        if (t < 200)
        {
            this.setFace(6);

            if (t < 60)
            {
                this.setMouth(5);
            }
            else
            {
                this.setMouth(2);
            }
        }
        else if (t < 400)
        {
            this.setFace(3);

            if (t < 250)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(4);
            }
        }
        else
        {
            this.setFace(9);

            if (t < 450)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceScorn(IShipEmotion ent)
    {
        this.setFace(2);
        this.setMouth(1);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent)
    {
        this.setFace(4);
        this.setMouth(2);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent)
    {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;

        if (t < 128)
        {
            this.setFace(1);

            if (t < 64)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(1);
            }
        }
        else
        {
            this.setFace(2);

            if (t < 170)
            {
                this.setMouth(1);
            }
            else
            {
                this.setMouth(2);
            }
        }
    }

    @Override
    public void setFaceBored(IShipEmotion ent)
    {
        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;

        if (t < 170)
        {
            this.setFace(5);

            if (t < 80)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(4);
            }
        }
        else if (t < 340)
        {
            this.setFace(8);
            this.setMouth(0);
        }
        else
        {
            this.setFace(0);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceShy(IShipEmotion ent)
    {
        this.setFlush(true);

        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;

        if (t < 140)
        {
            this.setFace(0);

            if (t < 80)
            {
                this.setMouth(3);
            }
            else
            {
                this.setMouth(2);
            }
        }
        else
        {
            this.setFace(8);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceHappy(IShipEmotion ent)
    {
        this.setFlush(true);

        int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;

        if (t < 140)
        {
            this.setFace(3);

            if (t < 80)
            {
                this.setMouth(0);
            }
            else
            {
                this.setMouth(4);
            }
        }
        else
        {
            this.setFace(8);
            this.setMouth(4);
        }
    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void setField(int id, float value)
    {
    }

    @Override
    public float getField(int id)
    {
        return 0;
    }

    @Override
    public boolean shouldRenderMiscModel(int miscID)
    {
        return false;
    }


}
