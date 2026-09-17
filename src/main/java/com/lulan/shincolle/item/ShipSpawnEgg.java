package com.lulan.shincolle.item;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ShipClassRegistry;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

/**
 * custom spawn egg (legacy ShipSpawnEgg).
 *
 * Ship selection is stored in the {@code ship_class} component using
 * the legacy meta encoding: 0 = random small ship, 1 = random large
 * ship, N >= 2 = ship class (N - 2), N >= 2002 = hostile mob ship
 * (N - 2002). Saved ship state rides in {@code ship_data}.
 */
public class ShipSpawnEgg extends BasicItem
{

    /** random pools for meta 0/1 (class ids of normal ships) */
    public static final int[] SMALL_SHIP_POOL = new int[] {
        ID.ShipClass.DDI, ID.ShipClass.DDRO, ID.ShipClass.DDHA, ID.ShipClass.DDNI,
        ID.ShipClass.CLTSU, ID.ShipClass.SSKA, ID.ShipClass.SSYO, ID.ShipClass.SSSO
    };
    public static final int[] LARGE_SHIP_POOL = new int[] {
        ID.ShipClass.CARI, ID.ShipClass.CANE, ID.ShipClass.CVWO,
        ID.ShipClass.BBRU, ID.ShipClass.BBTA, ID.ShipClass.BBRE, ID.ShipClass.APWA
    };


    public ShipSpawnEgg(Properties props)
    {
        super(props);
    }

    /** egg meta value for a ship class (legacy: class + 2, mob: class + 2002) */
    public static int eggMetaOf(int shipClass)
    {
        return shipClass >= ShipClassRegistry.MOB_OFFSET
            ? shipClass - ShipClassRegistry.MOB_OFFSET + 2002
            : shipClass + 2;
    }

    /** ship class for an egg meta value; -1 for random eggs */
    public static int shipClassOf(int meta)
    {
        if (meta >= 2002) return meta - 2002 + ShipClassRegistry.MOB_OFFSET;
        if (meta >= 2) return meta - 2;
        return -1;
    }

    public static ItemStack eggOf(int shipClass)
    {
        ItemStack stack = new ItemStack(com.lulan.shincolle.registry.ModItems.SHIP_SPAWN_EGG.get());
        stack.set(ModComponents.SHIP_CLASS.get(), eggMetaOf(shipClass));
        return stack;
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        if (level.isClientSide) return InteractionResult.SUCCESS;

        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        int meta = stack.getOrDefault(ModComponents.SHIP_CLASS.get(), 0);
        int shipClass = shipClassOf(meta);

        //random egg
        if (shipClass < 0)
        {
            int[] pool = meta == 1 ? LARGE_SHIP_POOL : SMALL_SHIP_POOL;
            shipClass = pool[level.random.nextInt(pool.length)];
        }

        EntityType<?> type = ShipClassRegistry.entityTypeOf((short) shipClass);
        if (type == null)
        {
            LogHelper.info("INFO: ShipSpawnEgg: no entity type for class " + shipClass);
            return InteractionResult.FAIL;
        }

        Entity entity = type.create(level);
        if (entity == null) return InteractionResult.FAIL;

        entity.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D,
            context.getHorizontalDirection().toYRot(), 0F);
        if (level instanceof ServerLevel sl)
        {
            //restore saved ship data if present
            CustomData data = stack.get(ModComponents.SHIP_DATA.get());
            if (data != null)
            {
                CompoundTag tag = data.copyTag();
                if (entity instanceof BasicEntityShip ship) ship.readShipData(tag);
                else if (entity instanceof BasicEntityShipHostile ship) ship.readShipData(tag);
            }

            if (entity instanceof BasicEntityShip ship)
            {
                ship.initShip();
                if (player != null) ship.tameTo(player);
            }
            else if (entity instanceof BasicEntityShipHostile ship)
            {
                ship.setScaleLevel(0);
            }

            sl.addFreshEntity(entity);
        }

        if (player == null || !player.getAbilities().instabuild)
        {
            stack.shrink(1);
        }

        return InteractionResult.SUCCESS;
    }

    /** display name shows stored ship class */
    @Override
    public Component getName(ItemStack stack)
    {
        int meta = stack.getOrDefault(ModComponents.SHIP_CLASS.get(), 0);
        int shipClass = shipClassOf(meta);

        if (shipClass >= 0)
        {
            String path = ShipClassRegistry.registryNameOf((short) shipClass);
            if (path != null)
            {
                return Component.translatable("item.shincolle.ship_spawn_egg",
                    Component.translatable("entity.shincolle." + path));
            }
        }

        return super.getName(stack);
    }


}
