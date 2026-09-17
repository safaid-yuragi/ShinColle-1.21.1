package com.lulan.shincolle.utility;

import java.util.Arrays;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.reference.dataclass.AttrsAdv;

/**
 * ship attribute calculation helper.
 *
 * Phase 3 port: raw/buffed/morale/formation math only. Potion buff map
 * and attack effect helpers are ported in Phase 4.
 */
public class BuffHelper
{


    private BuffHelper() {}

    /** calc raw attrs by ship class and level (player ships) */
    public static void updateAttrsRaw(Attrs attrs, int shipClass, float shipLevel)
    {
        if (attrs == null) return;
        if (!Values.ShipAttrMap.containsKey(shipClass)) shipClass = 0;

        float[] attrBase = Arrays.copyOf(Values.ShipAttrMap.get(shipClass), Attrs.AttrsLength);
        float[] attrType = attrs.getAttrsType();
        byte[] attrBonus = attrs.getAttrsBonus();

        attrs.resetAttrsRaw();
        float[] attrRaw = attrs.getAttrsRaw();

        //HP = (base + equip + (bonus + 1) * level * type) * config scale
        attrRaw[ID.Attrs.HP] = (attrBase[ID.AttrsBase.HP] + (attrBonus[ID.AttrsBase.HP] + 1F) * shipLevel * attrType[ID.AttrsBase.HP]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.HP];
        //DEF
        attrRaw[ID.Attrs.DEF] = (attrBase[ID.AttrsBase.DEF] + (attrBonus[ID.AttrsBase.DEF] + 1F) * shipLevel * 0.00133F * attrType[ID.AttrsBase.DEF]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.DEF];
        //SPD
        attrRaw[ID.Attrs.SPD] = (attrBase[ID.AttrsBase.SPD] + (attrBonus[ID.AttrsBase.SPD] + 1F) * shipLevel * 0.004F * attrType[ID.AttrsBase.SPD]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.SPD];
        //MOV
        attrRaw[ID.Attrs.MOV] = (attrBase[ID.AttrsBase.MOV] + (attrBonus[ID.AttrsBase.MOV] + 1F) * shipLevel * 0.002F * attrType[ID.AttrsBase.MOV]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.MOV];
        //HIT
        attrRaw[ID.Attrs.HIT] = (attrBase[ID.AttrsBase.HIT] + (attrBonus[ID.AttrsBase.HIT] + 1F) * shipLevel * 0.02F * attrType[ID.AttrsBase.HIT]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.HIT];

        //baseATK = base + (bonus + 1) * level * 0.133 * type
        float baseATK = attrBase[ID.AttrsBase.ATK] + (attrBonus[ID.AttrsBase.ATK] + 1F) * shipLevel * 0.133F * attrType[ID.AttrsBase.ATK];
        attrRaw[ID.Attrs.ATK_L] = baseATK * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK];
        attrRaw[ID.Attrs.ATK_H] = baseATK * 3F * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK];
        attrRaw[ID.Attrs.ATK_AL] = baseATK * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK];
        attrRaw[ID.Attrs.ATK_AH] = baseATK * 3F * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK];

        //misc attrs
        attrRaw[ID.Attrs.XP] = 1F;
        attrRaw[ID.Attrs.GRUDGE] = 1F;
        attrRaw[ID.Attrs.AMMO] = 1F;
        attrRaw[ID.Attrs.HPRES] = 1F;

        //knockback resistance
        attrRaw[ID.Attrs.KB] = shipLevel * 0.005F;
    }

    /** calc attrs by ship scale and class (hostile ships)
     *  shipScale: 0:mob small, 1:mob large, 2:boss small, 3:boss large */
    public static void updateAttrsRawHostile(Attrs attrs, int shipScale, int shipClass)
    {
        float[] attrmod = Values.HostileShipAttrMap.get(shipClass);
        if (attrmod == null) attrmod = Values.HostileShipAttrMap.get(0);
        double[] attrbase;
        float kb = 0.2F;

        attrs.resetAttrsRaw();
        float[] attrsraw = attrs.getAttrsRaw();

        switch (shipScale)
        {
        case 1:
            attrbase = ShinColleConfig.scaleMobLarge;
            kb = 0.4F;
        break;
        case 2:
            attrbase = ShinColleConfig.scaleBossSmall;
            kb = 0.85F;
        break;
        case 3:
            attrbase = ShinColleConfig.scaleBossLarge;
            kb = 1F;
        break;
        default:
            attrbase = ShinColleConfig.scaleMobSmall;
        break;
        }

        attrsraw[ID.Attrs.HP] = (float) attrbase[ID.AttrsBase.HP] * attrmod[ID.AttrsBase.HP];
        attrsraw[ID.Attrs.ATK_L] = (float) attrbase[ID.AttrsBase.ATK] * attrmod[ID.AttrsBase.ATK];
        attrsraw[ID.Attrs.ATK_H] = (float) attrbase[ID.AttrsBase.ATK] * attrmod[ID.AttrsBase.ATK] * 3F;
        attrsraw[ID.Attrs.ATK_AL] = (float) attrbase[ID.AttrsBase.ATK] * attrmod[ID.AttrsBase.ATK];
        attrsraw[ID.Attrs.ATK_AH] = (float) attrbase[ID.AttrsBase.ATK] * attrmod[ID.AttrsBase.ATK] * 3F;
        attrsraw[ID.Attrs.DEF] = (float) attrbase[ID.AttrsBase.DEF] * attrmod[ID.AttrsBase.DEF];
        attrsraw[ID.Attrs.SPD] = (float) attrbase[ID.AttrsBase.SPD] * attrmod[ID.AttrsBase.SPD];
        attrsraw[ID.Attrs.MOV] = (float) attrbase[ID.AttrsBase.MOV] * attrmod[ID.AttrsBase.MOV];
        attrsraw[ID.Attrs.HIT] = (float) attrbase[ID.AttrsBase.HIT] * attrmod[ID.AttrsBase.HIT];
        attrsraw[ID.Attrs.CRI] = 0.15F;
        attrsraw[ID.Attrs.DHIT] = 0.1F;
        attrsraw[ID.Attrs.THIT] = 0.1F;
        attrsraw[ID.Attrs.MISS] = 0F;
        attrsraw[ID.Attrs.AA] = 0F;
        attrsraw[ID.Attrs.ASM] = 0F;
        attrsraw[ID.Attrs.DODGE] = 0.15F;
        attrsraw[ID.Attrs.XP] = 1F;
        attrsraw[ID.Attrs.GRUDGE] = 1F;
        attrsraw[ID.Attrs.AMMO] = 1F;
        attrsraw[ID.Attrs.HPRES] = 1F;
        attrsraw[ID.Attrs.KB] = kb;
    }

    /** buffed = f(raw, equip, morale, potion, formation) */
    public static float[] calcAttrsBuffed(float[] raw, float[] equip, float[] morale, float[] potion, float[] formation)
    {
        int id;
        float[] buffed = new float[raw.length];

        //HP, HIT, DODGE, XP, GRUDGE, AMMO, HPRES, KB: additive
        id = ID.Attrs.HP;
        buffed[id] = raw[id] + equip[id] + (morale[id] + potion[id] + formation[id]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.HP];
        id = ID.Attrs.HIT;
        buffed[id] = raw[id] + equip[id] + (morale[id] + potion[id] + formation[id]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.HIT];
        id = ID.Attrs.DODGE;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];
        id = ID.Attrs.XP;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];
        id = ID.Attrs.GRUDGE;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];
        id = ID.Attrs.AMMO;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];
        id = ID.Attrs.HPRES;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];
        id = ID.Attrs.KB;
        buffed[id] = raw[id] + equip[id] + morale[id] + potion[id] + formation[id];

        //MOV: raw + equip + (morale + potion) * scale
        id = ID.Attrs.MOV;
        buffed[id] = raw[id] + equip[id] + (morale[id] + potion[id]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.MOV];

        //ATK, SPD, CRI, DHIT, THIT, MISS, AA, ASM: (raw + equip + potion*scale) * morale * formation
        id = ID.Attrs.ATK_L;
        buffed[id] = (raw[id] + equip[id] + potion[id] * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK]) * morale[id] * formation[id];
        id = ID.Attrs.ATK_H;
        buffed[id] = (raw[id] + equip[id] + potion[id] * 3F * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK]) * morale[id] * formation[id];
        id = ID.Attrs.ATK_AL;
        buffed[id] = (raw[id] + equip[id] + potion[id] * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK]) * morale[id] * formation[id];
        id = ID.Attrs.ATK_AH;
        buffed[id] = (raw[id] + equip[id] + potion[id] * 3F * (float) ShinColleConfig.scaleShip[ID.AttrsBase.ATK]) * morale[id] * formation[id];
        id = ID.Attrs.SPD;
        buffed[id] = (raw[id] + equip[id] + potion[id] * (float) ShinColleConfig.scaleShip[ID.AttrsBase.SPD]) * morale[id] * formation[id];
        id = ID.Attrs.CRI;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];
        id = ID.Attrs.DHIT;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];
        id = ID.Attrs.THIT;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];
        id = ID.Attrs.MISS;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];
        id = ID.Attrs.AA;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];
        id = ID.Attrs.ASM;
        buffed[id] = (raw[id] + equip[id] + potion[id]) * morale[id] * formation[id];

        //DEF: (raw + equip + (morale + potion) * scale) * formation
        id = ID.Attrs.DEF;
        buffed[id] = (raw[id] + equip[id] + (morale[id] + potion[id]) * (float) ShinColleConfig.scaleShip[ID.AttrsBase.DEF]) * formation[id];

        return buffed;
    }

    /** combine all buff layers into AttrsBuffed */
    public static void applyBuffOnAttrs(AttrsAdv attrs)
    {
        attrs.setAttrsBuffed(calcAttrsBuffed(
            attrs.getAttrsRaw(), attrs.getAttrsEquip(),
            attrs.getAttrsMorale(), attrs.getAttrsPotion(),
            attrs.getAttrsFormation()));
    }

    /** update morale buff by morale value (0~100+) */
    public static void updateBuffMorale(AttrsAdv attrs, int moraleValue)
    {
        //morale level: 0:excited, 1:happy, 2:normal, 3:unhappy, -1:dizzy
        int level;

        if (moraleValue > 66)
        {
            level = 0;
        }
        else if (moraleValue > 45)
        {
            level = 1;
        }
        else if (moraleValue > 33)
        {
            level = 2;
        }
        else if (moraleValue > 0)
        {
            level = 3;
        }
        else
        {
            level = -1;
        }

        float[] buff = Values.MoraleAttrs.get(level);
        if (buff == null) buff = Values.MoraleAttrs.get(-1);
        attrs.setAttrsMorale(Arrays.copyOf(buff, buff.length));
    }


}
