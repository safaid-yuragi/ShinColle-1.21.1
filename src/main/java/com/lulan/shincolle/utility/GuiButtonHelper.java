package com.lulan.shincolle.utility;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.blockentity.TileEntityCrane;
import com.lulan.shincolle.blockentity.TileEntitySmallShipyard;
import com.lulan.shincolle.blockentity.TileEntityVolCore;
import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;

/**
 * server-side GUI button dispatch (legacy PacketHelper.setEntityByGUI /
 * setTileEntityByGUI). Called by GuiButtonPayload handler.
 */
public final class GuiButtonHelper
{


    private GuiButtonHelper() {}

    /* ==================== ENTITY ==================== */

    /** process ship/morph inventory GUI click: button = ID.B.ShipInv_*, value = arg */
    public static void setEntityByGUI(BasicEntityShip entity, int button, int value)
    {
        if (entity == null) return;

        switch (button)
        {
        case ID.B.ShipInv_Melee:     entity.setStateFlagI(ID.F.UseMelee, value);       break;
        case ID.B.ShipInv_AmmoLight: entity.setStateFlagI(ID.F.UseAmmoLight, value);   break;
        case ID.B.ShipInv_AmmoHeavy: entity.setStateFlagI(ID.F.UseAmmoHeavy, value);   break;
        case ID.B.ShipInv_AirLight:  entity.setStateFlagI(ID.F.UseAirLight, value);    break;
        case ID.B.ShipInv_AirHeavy:  entity.setStateFlagI(ID.F.UseAirHeavy, value);    break;
        case ID.B.ShipInv_FollowMin:
            entity.setStateMinor(ID.M.FollowMin, value);
            if (entity.getStateMinor(ID.M.FollowMax) <= value)
                entity.setStateMinor(ID.M.FollowMax, value + 1);
        break;
        case ID.B.ShipInv_FollowMax:
            entity.setStateMinor(ID.M.FollowMax, value);
            if (entity.getStateMinor(ID.M.FollowMin) >= value)
                entity.setStateMinor(ID.M.FollowMin, value - 1);
        break;
        case ID.B.ShipInv_FleeHP:     entity.setStateMinor(ID.M.FleeHP, value);        break;
        case ID.B.ShipInv_TarAI:      entity.setStateFlagI(ID.F.PassiveAI, value);     break;
        case ID.B.ShipInv_AuraEffect: entity.setStateFlagI(ID.F.UseRingEffect, value); break;
        case ID.B.ShipInv_OnSightAI:  entity.setStateFlagI(ID.F.OnSightChase, value);  break;
        case ID.B.ShipInv_PVPAI:      entity.setStateFlagI(ID.F.PVPFirst, value);      break;
        case ID.B.ShipInv_AAAI:       entity.setStateFlagI(ID.F.AntiAir, value);       break;
        case ID.B.ShipInv_ASMAI:      entity.setStateFlagI(ID.F.AntiSS, value);        break;
        case ID.B.ShipInv_TIMEKEEPAI: entity.setStateFlagI(ID.F.TimeKeeper, value);    break;
        case ID.B.ShipInv_InvPage:    entity.setInventoryPage(value);                  break;
        case ID.B.ShipInv_PickitemAI: entity.setStateFlagI(ID.F.PickItem, value);      break;
        case ID.B.ShipInv_WpStay:     entity.setStateMinor(ID.M.WpStay, value);        break;
        case ID.B.ShipInv_ShowHeld:   entity.setStateFlagI(ID.F.ShowHeldItem, value);  break;
        case ID.B.ShipInv_AutoCR:     entity.setStateMinor(ID.M.UseCombatRation, value); break;
        case ID.B.ShipInv_AutoPump:   entity.setStateFlagI(ID.F.AutoPump, value);      break;
        case ID.B.ShipInv_ModelState01: case ID.B.ShipInv_ModelState02:
        case ID.B.ShipInv_ModelState03: case ID.B.ShipInv_ModelState04:
        case ID.B.ShipInv_ModelState05: case ID.B.ShipInv_ModelState06:
        case ID.B.ShipInv_ModelState07: case ID.B.ShipInv_ModelState08:
        case ID.B.ShipInv_ModelState09: case ID.B.ShipInv_ModelState10:
        case ID.B.ShipInv_ModelState11: case ID.B.ShipInv_ModelState12:
        case ID.B.ShipInv_ModelState13: case ID.B.ShipInv_ModelState14:
        case ID.B.ShipInv_ModelState15: case ID.B.ShipInv_ModelState16:
        {
            int bit = button - ID.B.ShipInv_ModelState01;
            entity.setStateEmotion(ID.S.State,
                entity.getStateEmotion(ID.S.State) ^ Values.N.Pow2[bit], false);
        }
        break;
        case ID.B.ShipInv_Task:     entity.setStateMinor(ID.M.Task, value);            break;
        case ID.B.ShipInv_TaskSide: entity.setStateMinor(ID.M.TaskSide, value);        break;
        case ID.B.ShipInv_NoFuel:   entity.setStateFlagI(ID.F.NoFuel, value);          break;
        case ID.B.ShipInv_Sit:      entity.setEntitySit(!entity.getIsSitting());       break;
        case ID.B.ShipInv_EmoFlag1: entity.setStateEmotion(ID.S.Emotion, value, true);  break;
        case ID.B.ShipInv_EmoFlag2: entity.setStateEmotion(ID.S.Emotion4, value, true); break;
        default: break;
        }
    }

    /* ==================== TILE ==================== */

    /** process tile GUI click: button = ID.B.*, value/value2 = args */
    public static void setTileEntityByGUI(BasicBlockEntity tile, int button,
            int value, int value2)
    {
        if (tile == null) return;

        if (tile instanceof TileEntitySmallShipyard sy)
        {
            sy.setField(TileEntitySmallShipyard.FIELD_BUILDTYPE, value);
            return;
        }

        if (tile instanceof TileMultiGrudgeHeavy heavy)
        {
            switch (button)
            {
            case ID.B.Shipyard_Type:      heavy.setBuildType(value);          break;
            case ID.B.Shipyard_InvMode:   heavy.setInvMode(value);            break;
            case ID.B.Shipyard_SelectMat: heavy.setSelectMat(value);          break;
            case ID.B.Shipyard_INCDEC:
                TileEntityHelper.setLargeShipyardBuildMats(heavy, value, value2);
            break;
            default: break;
            }
            return;
        }

        if (tile instanceof TileEntityCrane crane)
        {
            switch (button)
            {
            case ID.B.Crane_Load:   crane.setField(6, value);  break;
            case ID.B.Crane_Unload: crane.setField(7, value);  break;
            case ID.B.Crane_Power:
                crane.setField(2, value);
                if (value == 0) crane.setShip(null);
            break;
            case ID.B.Crane_Meta:   crane.setField(3, value);  break;
            case ID.B.Crane_Dict:   crane.setField(4, value);  break;
            case ID.B.Crane_Mode:   crane.setField(5, value);  break;
            case ID.B.Crane_Nbt:    crane.setField(8, value);  break;
            case ID.B.Crane_Red:    crane.setField(10, value > 2 ? 0 : value); break;
            case ID.B.Crane_Liquid: crane.setField(12, value > 2 ? 0 : value); break;
            case ID.B.Crane_Energy: crane.setField(13, value > 2 ? 0 : value); break;
            default: break;
            }
            return;
        }

        if (tile instanceof TileEntityVolCore vol)
        {
            if (button == ID.B.VolCore_Power) vol.setField(0, value);
        }
    }


}
