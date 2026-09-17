package com.lulan.shincolle.crafting;

import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.registry.ModRecipeSerializers;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.core.component.DataComponents;

/**
 * recipe for enchant shell (legacy RecipeEnchantShell).
 *
 * 3x3 crafting grid: slot (0,0) and all slots except center hold the same
 * potion, center holds an EquipAmmo meta 7 (now {@code equip_ammo_7}).
 * Result: the ammo with a potion-effect list stored in
 * {@link DataComponents#CUSTOM_DATA} under key {@value #PLIST}.
 *
 * The stored list entry keeps the legacy NBT layout, except PID is now the
 * mob effect registry id string (e.g. "minecraft:strength") instead of the
 * old numeric potion id:
 *   PLIST: [{ PID: "<effect id>", PLEVEL: int, PTIME: int, PCHANCE: int }]
 */
public class RecipeEnchantShell extends CustomRecipe
{

    //legacy NBT keys, kept for compat with EquipAmmo potion-effect handling
    public static final String PLIST   = "PList";
    public static final String PID     = "PID";
    public static final String PLEVEL  = "PLV";
    public static final String PTIME   = "PTick";
    public static final String PCHANCE = "PChance";


    public RecipeEnchantShell(CraftingBookCategory category)
    {
        super(category);
    }

    /**
     * grid must be 3x3: (0,0) = potion, (1,1) = equip_ammo_7,
     * every other slot = a potion with identical contents to (0,0)
     */
    @Override
    public boolean matches(CraftingInput input, Level level)
    {
        if (input.width() != 3 || input.height() != 3) return false;

        ItemStack stack0 = input.getItem(0, 0);
        if (stack0.isEmpty() || !stack0.is(Items.POTION)) return false;

        for (int i = 0; i < input.width(); ++i)
        {
            for (int j = 0; j < input.height(); ++j)
            {
                if (i == 0 && j == 0) continue;

                ItemStack stackX = input.getItem(i, j);
                if (stackX.isEmpty()) return false;

                //center must be the enchantable ammo shell
                if (i == 1 && j == 1)
                {
                    if (!stackX.is(ModItems.EQUIP_AMMO_7.get())) return false;
                }
                //other slots must be potions identical to (0,0)
                else if (stackX.is(Items.POTION))
                {
                    if (!ItemStack.isSameItemSameComponents(stack0, stackX)) return false;
                }
                else
                {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * apply the potion's first effect to the shell; repeated crafting with the
     * same effect extends duration (+20) and proc chance (+10, cap 100)
     */
    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
    {
        ItemStack ammo = input.getItem(1, 1);
        ItemStack potion = input.getItem(0, 0);

        if (ammo.isEmpty() || !ammo.is(ModItems.EQUIP_AMMO_7.get()) ||
            potion.isEmpty() || !potion.is(Items.POTION))
        {
            return ItemStack.EMPTY;
        }

        ItemStack ammoNew = ammo.copy();

        //get first potion effect
        PotionContents contents = potion.get(DataComponents.POTION_CONTENTS);
        if (contents == null) return ammoNew;

        MobEffectInstance effect = null;
        for (MobEffectInstance inst : contents.getAllEffects())
        {
            effect = inst;
            break;
        }
        if (effect == null) return ammoNew;    //potion has no effect

        Holder<MobEffect> holder = effect.getEffect();
        String pid = BuiltInRegistries.MOB_EFFECT.getKey(holder.value()).toString();
        int plv = effect.getAmplifier();
        int ptime = 100;
        int pchance = 20;

        //read existing effect list from old ammo
        CustomData oldData = ammo.get(DataComponents.CUSTOM_DATA);
        if (oldData != null)
        {
            CompoundTag nbtOld = oldData.copyTag();
            ListTag listOld = nbtOld.getList(PLIST, Tag.TAG_COMPOUND);

            if (!listOld.isEmpty())
            {
                CompoundTag nbt0 = listOld.getCompound(0);
                if (pid.equals(nbt0.getString(PID)) && plv == nbt0.getInt(PLEVEL))
                {
                    ptime = nbt0.getInt(PTIME) + 20;
                    pchance = nbt0.getInt(PCHANCE) + 10;
                    if (pchance > 100) pchance = 100;
                }
            }
        }

        //write new effect list
        CompoundTag nbtNew = new CompoundTag();
        ListTag listNew = new ListTag();
        CompoundTag nbt0 = new CompoundTag();
        nbt0.putString(PID, pid);
        nbt0.putInt(PLEVEL, plv);
        nbt0.putInt(PTIME, ptime);
        nbt0.putInt(PCHANCE, pchance);
        listNew.add(nbt0);
        nbtNew.put(PLIST, listNew);
        ammoNew.set(DataComponents.CUSTOM_DATA, CustomData.of(nbtNew));

        return ammoNew;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return width == 3 && height == 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.ENCHANT_SHELL.get();
    }


}
