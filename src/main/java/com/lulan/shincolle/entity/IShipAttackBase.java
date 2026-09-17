package com.lulan.shincolle.entity;

import java.util.HashMap;

import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.reference.dataclass.MissileData;

import net.minecraft.world.entity.Entity;

/**
 * attack-capable ship entity (legacy IShipAttackBase).
 *
 * Combines target/revenge tracking, ammo pools, attack-type flags,
 * buff/effect maps and missile tuning data.
 */
public interface IShipAttackBase extends IShipEmotion, IShipOwner, IShipNavigator
{

    /* -------- target -------- */

    Entity getEntityTarget();

    void setEntityTarget(Entity target);

    Entity getEntityRevengeTarget();

    void setEntityRevengeTarget(Entity target);

    int getEntityRevengeTime();

    void setEntityRevengeTime();

    /** ID.ShipDmgType */
    int getDamageType();

    /** attack type flag, id = ID.F.AtkType_* */
    boolean getAttackType(int id);

    /* -------- ammo -------- */

    int getAmmoLight();

    int getAmmoHeavy();

    void setAmmoLight(int num);

    void setAmmoHeavy(int num);

    boolean hasAmmoLight();

    boolean hasAmmoHeavy();

    /* -------- misc -------- */

    int getLevel();

    Attrs getAttrs();

    /** skill attack tick update, true while skill is running */
    boolean updateSkillAttack(Entity target);

    /* -------- effect maps -------- */

    HashMap<Integer, Integer> getBuffMap();

    void setBuffMap(HashMap<Integer, Integer> map);

    HashMap<Integer, int[]> getAttackEffectMap();

    void setAttackEffectMap(HashMap<Integer, int[]> map);

    /** missile params per attack type (0:melee 1:light 2:heavy 3:air light 4:air heavy) */
    MissileData getMissileData(int type);

    void setMissileData(int type, MissileData data);


}
