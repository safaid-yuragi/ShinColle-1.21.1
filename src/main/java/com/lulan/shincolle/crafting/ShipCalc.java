package com.lulan.shincolle.crafting;

import java.util.Random;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModItems;

import net.minecraft.world.item.ItemStack;

/**
 * ship-related calculations (legacy ShipCalc, kaitai/recycle part).
 */
public class ShipCalc
{

    private static final Random rand = new Random();


    private ShipCalc() {}

    /**
     * ship recycle output (legacy getKaitaiItems).
     * shipID = ship class id; -2: small egg, -1: large egg.
     */
    public static ItemStack[] getKaitaiItems(int shipID)
    {
        ItemStack[] amount = new ItemStack[4];

        switch (shipID)
        {
        case -2:    //pri egg
            amount[0] = new ItemStack(ModItems.GRUDGE.get(), 10 + rand.nextInt(8));
            amount[1] = new ItemStack(ModItems.ABYSS_METAL.get(), 10 + rand.nextInt(8));
            amount[2] = new ItemStack(ModItems.AMMO.get(), 10 + rand.nextInt(8));
            amount[3] = new ItemStack(ModItems.ABYSS_METAL_1.get(), 10 + rand.nextInt(8));
        break;
        case -1:    //adv egg
            amount[0] = new ItemStack(ModItems.GRUDGE.get(), 90 + rand.nextInt(8));
            amount[1] = new ItemStack(ModItems.ABYSS_METAL.get(), 90 + rand.nextInt(8));
            amount[2] = new ItemStack(ModItems.AMMO.get(), 90 + rand.nextInt(8));
            amount[3] = new ItemStack(ModItems.ABYSS_METAL_1.get(), 90 + rand.nextInt(8));
        break;
        case ID.ShipClass.DDI:
        case ID.ShipClass.DDRO:
        case ID.ShipClass.DDHA:
        case ID.ShipClass.DDNI:
        case ID.ShipClass.CLHO:
        case ID.ShipClass.CLHE:
        case ID.ShipClass.CLTO:
        case ID.ShipClass.CLTSU:
        case ID.ShipClass.CLTCHI:
        case ID.ShipClass.CARI:
        case ID.ShipClass.CANE:
        case ID.ShipClass.CVLNU:
        case ID.ShipClass.APWA:
        case ID.ShipClass.SSKA:
        case ID.ShipClass.SSYO:
        case ID.ShipClass.SSSO:
            amount[0] = new ItemStack(ModItems.GRUDGE.get(), 12 + rand.nextInt(8));
            amount[1] = new ItemStack(ModItems.ABYSS_METAL.get(), 12 + rand.nextInt(8));
            amount[2] = new ItemStack(ModItems.AMMO.get(), 12 + rand.nextInt(8));
            amount[3] = new ItemStack(ModItems.ABYSS_METAL_1.get(), 12 + rand.nextInt(8));
        break;
        case ID.ShipClass.CVWO:
        case ID.ShipClass.BBRU:
        case ID.ShipClass.BBTA:
        case ID.ShipClass.BBRE:
        case ID.ShipClass.CVHime:
        case ID.ShipClass.AirfieldHime:
        case ID.ShipClass.ArmoredCVHime:
        case ID.ShipClass.AnchorageHime:
        case ID.ShipClass.HarbourWD:
        case ID.ShipClass.AnchorageWD:
        case ID.ShipClass.BBHime:
        case ID.ShipClass.DDHime:
        case ID.ShipClass.HarbourHime:
        case ID.ShipClass.IsolatedHime:
        case ID.ShipClass.MidwayHime:
        case ID.ShipClass.NorthernHime:
        case ID.ShipClass.SouthernHime:
        case ID.ShipClass.CVWD:
        case ID.ShipClass.CLDemon:
        case ID.ShipClass.BBWD:
        case ID.ShipClass.STHime:
        case ID.ShipClass.AirdefenseHime:
        case ID.ShipClass.CLHime:
        case ID.ShipClass.SSHime:
        case ID.ShipClass.DDWD:
        case ID.ShipClass.CAHime:
        case ID.ShipClass.SupplyDepotHime:
        case ID.ShipClass.SSNH:
            //easy mode: reduce amount to prevent resource dupe
            if (ShinColleConfig.easyMode)
            {
                amount[0] = new ItemStack(ModBlocks.ITEM_GRUDGE.get(), 1);
                amount[1] = new ItemStack(ModBlocks.ITEM_ABYSSIUM.get(), 1);
                amount[2] = new ItemStack(ModItems.AMMO_1.get(), 1);
                amount[3] = new ItemStack(ModBlocks.ITEM_POLYMETAL.get(), 1);
            }
            else
            {
                amount[0] = new ItemStack(ModBlocks.ITEM_GRUDGE.get(), 10 + rand.nextInt(3));
                amount[1] = new ItemStack(ModBlocks.ITEM_ABYSSIUM.get(), 10 + rand.nextInt(3));
                amount[2] = new ItemStack(ModItems.AMMO_1.get(), 10 + rand.nextInt(3));
                amount[3] = new ItemStack(ModBlocks.ITEM_POLYMETAL.get(), 10 + rand.nextInt(3));
            }
        break;
        case ID.ShipClass.SSU511:
        case ID.ShipClass.SSRo500:
        case ID.ShipClass.DDAkatsuki:
        case ID.ShipClass.DDHibiki:
        case ID.ShipClass.DDIkazuchi:
        case ID.ShipClass.DDInazuma:
        case ID.ShipClass.DDShimakaze:
        case ID.ShipClass.Raiden:
            amount[0] = new ItemStack(ModItems.GRUDGE.get(),
                ShinColleConfig.kaitaiAmountSmall +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountSmall * 0.25F) + 1));
            amount[1] = new ItemStack(ModItems.ABYSS_METAL.get(),
                ShinColleConfig.kaitaiAmountSmall +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountSmall * 0.25F) + 1));
            amount[2] = new ItemStack(ModItems.AMMO.get(),
                ShinColleConfig.kaitaiAmountSmall +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountSmall * 0.25F) + 1));
            amount[3] = new ItemStack(ModItems.ABYSS_METAL_1.get(),
                ShinColleConfig.kaitaiAmountSmall +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountSmall * 0.25F) + 1));
        break;
        case ID.ShipClass.CAAtago:
        case ID.ShipClass.CATakao:
        case ID.ShipClass.CLTenryuu:
        case ID.ShipClass.CLTatsuta:
            amount[0] = new ItemStack(ModBlocks.ITEM_GRUDGE.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountLarge * 0.25F) + 1));
            amount[1] = new ItemStack(ModBlocks.ITEM_ABYSSIUM.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountLarge * 0.25F) + 1));
            amount[2] = new ItemStack(ModItems.AMMO_1.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountLarge * 0.25F) + 1));
            amount[3] = new ItemStack(ModBlocks.ITEM_POLYMETAL.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt((int) (ShinColleConfig.kaitaiAmountLarge * 0.25F) + 1));
        break;
        case ID.ShipClass.BBKongou:
        case ID.ShipClass.BBHiei:
        case ID.ShipClass.BBHaruna:
        case ID.ShipClass.BBKirishima:
        case ID.ShipClass.BBNagato:
        case ID.ShipClass.BBYamato:
        case ID.ShipClass.CVKaga:
        case ID.ShipClass.CVAkagi:
            amount[0] = new ItemStack(ModBlocks.ITEM_GRUDGE.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt(ShinColleConfig.kaitaiAmountLarge + 1));
            amount[1] = new ItemStack(ModBlocks.ITEM_ABYSSIUM.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt(ShinColleConfig.kaitaiAmountLarge + 1));
            amount[2] = new ItemStack(ModItems.AMMO_1.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt(ShinColleConfig.kaitaiAmountLarge + 1));
            amount[3] = new ItemStack(ModBlocks.ITEM_POLYMETAL.get(),
                ShinColleConfig.kaitaiAmountLarge +
                rand.nextInt(ShinColleConfig.kaitaiAmountLarge + 1));
        break;
        default:
        break;
        }

        return amount;
    }


}
