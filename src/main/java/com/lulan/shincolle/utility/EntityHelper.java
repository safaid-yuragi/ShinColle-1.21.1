package com.lulan.shincolle.utility;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.lulan.shincolle.ai.path.IShipPathNavigate;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipFlyable;
import com.lulan.shincolle.entity.IShipNavigator;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.registry.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/**
 * entity misc helpers (legacy EntityHelper subset needed by AI).
 */
public class EntityHelper
{


    /** find online player by persistent uid, null if offline/not found */
    @Nullable
    public static Player getEntityPlayerByUID(Entity host, int uid)
    {
        if (uid <= 0 || host == null) return null;
        if (!(host.level() instanceof ServerLevel sl)) return null;

        for (ServerPlayer p : sl.getServer().getPlayerList().getPlayers())
        {
            if (TeamHelper.getPlayerUID(p) == uid) return p;
        }

        return null;
    }

    @Nullable
    public static Player getEntityPlayerByUID(Level level, int uid)
    {
        if (uid <= 0 || !(level instanceof ServerLevel sl)) return null;

        for (ServerPlayer p : sl.getServer().getPlayerList().getPlayers())
        {
            if (TeamHelper.getPlayerUID(p) == uid) return p;
        }

        return null;
    }

    /** pointer item in player's hands, null if none */
    @Nullable
    public static ItemStack getPointerInUse(Player player)
    {
        if (player == null) return null;

        ItemStack main = player.getMainHandItem();
        if (!main.isEmpty() && main.is(ModItems.POINTER_ITEM.get())) return main;

        ItemStack off = player.getOffhandItem();
        if (!off.isEmpty() && off.is(ModItems.POINTER_ITEM.get())) return off;

        return null;
    }

    /** entities within aabb filtered by predicate (legacy name) */
    public static <T extends Entity> List<T> getEntitiesWithinAABB(Level level, Class<T> cls,
            AABB aabb, @Nullable Predicate<? super T> filter)
    {
        return level.getEntitiesOfClass(cls, aabb, filter != null ? filter : e -> true);
    }

    /** teleport entity near target pos with liquid-safe landing */
    public static void applyTeleport(IShipNavigator host, double distSq, Vec3 pos)
    {
        Entity ent = (Entity) host;

        if (!(ent.level() instanceof ServerLevel sl)) return;

        //find safe landing pos
        BlockPos target = BlockHelper.getSafeTopPos(sl, BlockPos.containing(pos));

        ent.teleportTo(target.getX() + 0.5D, target.getY(), target.getZ() + 0.5D);
        host.getShipNavigate().clearPathEntity();

        if (ent instanceof LivingEntity living)
        {
            living.fallDistance = 0F;
        }
    }

    /** entity body is inside any liquid */
    public static boolean checkEntityIsInLiquid(Entity ent)
    {
        return ent.isInWater() || ent.isInLava();
    }

    /**
     * liquid depth measured from entity feet to fluid surface
     * (legacy getEntityDepth: scans upward for non-liquid block).
     */
    public static double getEntityTopDepth(Entity ent)
    {
        BlockPos pos = ent.blockPosition();
        Level level = ent.level();
        double depth = 0D;
        double eyeY = ent.getY() + ent.getEyeHeight();

        //entity eye above liquid: depth = 0
        FluidState fs = level.getFluidState(BlockPos.containing(ent.getX(), eyeY, ent.getZ()));

        if (fs.isEmpty()) return 0D;

        //count liquid blocks above feet, up to 8
        for (int i = 0; i < 8; i++)
        {
            FluidState f = level.getFluidState(pos.above(i));

            if (f.isEmpty())
            {
                break;
            }

            depth = i + f.getHeight(level, pos.above(i));
        }

        return Math.max(0D, depth - (eyeY - ent.getY()) + ent.getEyeHeight());
    }

    /** simpler depth: how deep the entity's feet are below the fluid surface */
    public static double getEntityDepth(Entity ent)
    {
        Level level = ent.level();
        BlockPos pos = ent.blockPosition();

        if (level.getFluidState(pos).isEmpty()) return 0D;

        double depth = 0D;
        BlockPos.MutableBlockPos mp = pos.mutable();

        for (int i = 0; i < 16; i++)
        {
            FluidState f = level.getFluidState(mp);

            if (f.isEmpty()) break;

            depth = mp.getY() + f.getHeight(level, mp) - ent.getY();
            mp.move(0, 1, 0);
        }

        return depth;
    }

    /** entity move type for AA/ASM damage mods (legacy getEntityMoveType) */
    public static com.lulan.shincolle.reference.Enums.MoveType getEntityMoveType(Entity entity)
    {
        if (entity instanceof com.lulan.shincolle.entity.IShipAttackBase ship)
        {
            return switch (ship.getDamageType())
            {
                case com.lulan.shincolle.reference.ID.ShipDmgType.AIRPLANE ->
                    com.lulan.shincolle.reference.Enums.MoveType.FLY;
                case com.lulan.shincolle.reference.ID.ShipDmgType.SUBMARINE ->
                    com.lulan.shincolle.reference.Enums.MoveType.UNDERSEA;
                default -> com.lulan.shincolle.reference.Enums.MoveType.LAND;
            };
        }
        else if (entity instanceof net.minecraft.world.entity.monster.Guardian ||
                 entity instanceof net.minecraft.world.entity.animal.WaterAnimal)
        {
            return com.lulan.shincolle.reference.Enums.MoveType.UNDERSEA;
        }
        else if (entity instanceof net.minecraft.world.entity.monster.Blaze ||
                 entity instanceof net.minecraft.world.entity.boss.wither.WitherBoss ||
                 entity instanceof net.minecraft.world.entity.boss.enderdragon.EnderDragon ||
                 entity instanceof net.minecraft.world.entity.ambient.Bat ||
                 entity instanceof net.minecraft.world.entity.FlyingMob ||
                 entity instanceof net.minecraft.world.entity.monster.Vex ||
                 entity instanceof IShipFlyable)
        {
            return com.lulan.shincolle.reference.Enums.MoveType.FLY;
        }

        return com.lulan.shincolle.reference.Enums.MoveType.LAND;
    }

    /** ship entity by ship uid in the same level */
    @Nullable
    public static BasicEntityShip getShipByUID(Entity host, int shipUID)
    {
        if (shipUID <= 0 || host == null) return null;

        AABB box = host.getBoundingBox().inflate(64D);

        for (BasicEntityShip ship : host.level().getEntitiesOfClass(BasicEntityShip.class, box))
        {
            if (ship.getShipUID() == shipUID) return ship;
        }

        return null;
    }



    /** yHeadRot in radians (legacy getRadRenderYawHead) */
    public static float getRadRenderYawHead(Entity host)
    {
        if (host == null) return 0F;
        return host instanceof LivingEntity le ?
               (le.getYHeadRot() % 360F) * Values.N.DIV_PI_180 :
               (host.getYRot() % 360F) * Values.N.DIV_PI_180;
    }

    /** body yaw (yBodyRot) or yRot in radians (legacy getRadRenderYawOffset) */
    public static float getRadRenderYawOffset(Entity host)
    {
        if (host == null) return 0F;
        return host instanceof LivingEntity le ?
               (le.yBodyRot % 360F) * Values.N.DIV_PI_180 :
               (host.getYRot() % 360F) * Values.N.DIV_PI_180;
    }

    /** xRot in radians (legacy getRadRenderPitch) */
    public static float getRadRenderPitch(Entity host)
    {
        if (host == null) return 0F;
        return host.getXRot() * Values.N.DIV_PI_180;
    }



    /** client-side player lookup by entity id (legacy getEntityPlayerByID client path) */
    @Nullable
    public static Player getPlayerByEntityID(Level level, int eid)
    {
        if (level == null || eid <= 0) return null;
        Entity e = level.getEntity(eid);
        return e instanceof Player ? (Player) e : null;
    }


}