package com.lulan.shincolle.client.render;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.lulan.shincolle.client.model.*;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * ship class -> model layer / texture / shadow table (Phase 7).
 * Mirrors legacy RenderShipEntity / RenderSummonEntity / RenderMountsEntity switches.
 */
public final class ShipRenderTable
{

    /** model layer + model ctor + texture + shadow size */
    public static final class RenderInfo
    {
        public final ModelLayerLocation layer;
        public final Function<ModelPart, EntityModel<? extends Entity>> factory;
        public final ResourceLocation texture;
        public final float shadow;

        public RenderInfo(ModelLayerLocation layer, Function<ModelPart, ? extends EntityModel<?>> factory,
                          String texName, float shadow)
        {
            this.layer = layer;
            this.factory = m -> (EntityModel<? extends Entity>) factory.apply(m);
            this.texture = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, Reference.TEXTURES_ENTITY + texName.toLowerCase() + ".png");
            this.shadow = shadow;
        }
    }

    /** ship class id -> render info */
    public static final Map<Integer, RenderInfo> SHIP = new HashMap<>();
    /** ID.ShipMisc id -> render info (summons / mounts / misc) */
    public static final Map<Integer, RenderInfo> MISC = new HashMap<>();

    private static void ship(int cls, ModelLayerLocation layer, Function<ModelPart, ? extends EntityModel<?>> f,
                             String tex, float shadow)
    {
        SHIP.put(cls, new RenderInfo(layer, f, tex, shadow));
    }

    private static void misc(int id, ModelLayerLocation layer, Function<ModelPart, ? extends EntityModel<?>> f,
                             String tex, float shadow)
    {
        MISC.put(id, new RenderInfo(layer, f, tex, shadow));
    }

    static
    {
        //AP
        ship(ID.ShipClass.APWA, ModModelLayers.MODELTRANSPORTWA, ModelTransportWa::new, "EntityTransportWa", 0.7F);
        //BB
        ship(ID.ShipClass.BBRU, ModModelLayers.MODELBATTLESHIPRU, ModelBattleshipRu::new, "EntityBattleshipRu", 0.7F);
        ship(ID.ShipClass.BBTA, ModModelLayers.MODELBATTLESHIPTA, ModelBattleshipTa::new, "EntityBattleshipTa", 0.7F);
        ship(ID.ShipClass.BBRE, ModModelLayers.MODELBATTLESHIPRE, ModelBattleshipRe::new, "EntityBattleshipRe", 0.7F);
        //CA
        ship(ID.ShipClass.CARI, ModModelLayers.MODELHEAVYCRUISERRI, ModelHeavyCruiserRi::new, "EntityHeavyCruiserRi", 0.7F);
        ship(ID.ShipClass.CANE, ModModelLayers.MODELHEAVYCRUISERNE, ModelHeavyCruiserNe::new, "EntityHeavyCruiserNe", 0.7F);
        //CV
        ship(ID.ShipClass.CVWO, ModModelLayers.MODELCARRIERWO, ModelCarrierWo::new, "EntityCarrierWo", 0.7F);
        //DD
        ship(ID.ShipClass.DDI, ModModelLayers.MODELDESTROYERI, ModelDestroyerI::new, "EntityDestroyerI", 0.9F);
        ship(ID.ShipClass.DDRO, ModModelLayers.MODELDESTROYERRO, ModelDestroyerRo::new, "EntityDestroyerRo", 0.9F);
        ship(ID.ShipClass.DDHA, ModModelLayers.MODELDESTROYERHA, ModelDestroyerHa::new, "EntityDestroyerHa", 0.9F);
        ship(ID.ShipClass.DDNI, ModModelLayers.MODELDESTROYERNI, ModelDestroyerNi::new, "EntityDestroyerNi", 0.9F);
        //Hime
        ship(ID.ShipClass.AirfieldHime, ModModelLayers.MODELAIRFIELDHIME, ModelAirfieldHime::new, "EntityAirfieldHime", 0.7F);
        ship(ID.ShipClass.BBHime, ModModelLayers.MODELBATTLESHIPHIME, ModelBattleshipHime::new, "EntityBattleshipHime", 0.7F);
        ship(ID.ShipClass.DDHime, ModModelLayers.MODELDESTROYERHIME, ModelDestroyerHime::new, "EntityDestroyerHime", 0.6F);
        ship(ID.ShipClass.CVHime, ModModelLayers.MODELCARRIERHIME, ModelCarrierHime::new, "EntityCarrierHime", 0.7F);
        ship(ID.ShipClass.CAHime, ModModelLayers.MODELCAHIME, ModelCAHime::new, "EntityCAHime", 0.7F);
        ship(ID.ShipClass.HarbourHime, ModModelLayers.MODELHARBOURHIME, ModelHarbourHime::new, "EntityHarbourHime", 0.8F);
        ship(ID.ShipClass.IsolatedHime, ModModelLayers.MODELISOLATEDHIME, ModelIsolatedHime::new, "EntityIsolatedHime", 0.7F);
        ship(ID.ShipClass.MidwayHime, ModModelLayers.MODELMIDWAYHIME, ModelMidwayHime::new, "EntityMidwayHime", 0.8F);
        ship(ID.ShipClass.NorthernHime, ModModelLayers.MODELNORTHERNHIME, ModelNorthernHime::new, "EntityNorthernHime", 0.5F);
        ship(ID.ShipClass.SSHime, ModModelLayers.MODELSUBMHIME, ModelSubmHime::new, "EntitySubmHime", 0.7F);
        ship(ID.ShipClass.SSNH, ModModelLayers.MODELSSNH, ModelSSNH::new, "EntitySubmHimeNew", 0.5F);
        //SS
        ship(ID.ShipClass.SSKA, ModModelLayers.MODELSUBMKA, ModelSubmKa::new, "EntitySubmKa", 0.5F);
        ship(ID.ShipClass.SSSO, ModModelLayers.MODELSUBMSO, ModelSubmSo::new, "EntitySubmSo", 0.5F);
        ship(ID.ShipClass.SSYO, ModModelLayers.MODELSUBMYO, ModelSubmYo::new, "EntitySubmYo", 0.5F);
        //WD
        ship(ID.ShipClass.CVWD, ModModelLayers.MODELCARRIERWDEMON, ModelCarrierWDemon::new, "EntityCarrierWDemon", 0.7F);
        //hostile ships: BB
        ship(ID.ShipClass.BBNagato, ModModelLayers.MODELBATTLESHIPNAGATO, ModelBattleshipNagato::new, "EntityBattleshipNagato", 0.7F);
        ship(ID.ShipClass.BBYamato, ModModelLayers.MODELBATTLESHIPYAMATO, ModelBattleshipYamato::new, "EntityBattleshipYamato", 0.7F);
        ship(ID.ShipClass.BBKongou, ModModelLayers.MODELBBKONGOU, ModelBBKongou::new, "EntityBBKongou", 0.7F);
        ship(ID.ShipClass.BBHiei, ModModelLayers.MODELBBHIEI, ModelBBHiei::new, "EntityBBHiei", 0.7F);
        ship(ID.ShipClass.BBHaruna, ModModelLayers.MODELBBHARUNA, ModelBBHaruna::new, "EntityBBHaruna", 0.7F);
        ship(ID.ShipClass.BBKirishima, ModModelLayers.MODELBBKIRISHIMA, ModelBBKirishima::new, "EntityBBKirishima", 0.7F);
        //hostile ships: CV
        ship(ID.ShipClass.CVAkagi, ModModelLayers.MODELCARRIERAKAGI, ModelCarrierAkagi::new, "EntityCarrierAkagi", 0.7F);
        ship(ID.ShipClass.CVKaga, ModModelLayers.MODELCARRIERKAGA, ModelCarrierKaga::new, "EntityCarrierKaga", 0.7F);
        //hostile ships: CL
        ship(ID.ShipClass.CLTenryuu, ModModelLayers.MODELCRUISERTENRYUU, ModelCruiserTenryuu::new, "EntityCruiserTenryuu", 0.6F);
        ship(ID.ShipClass.CLTatsuta, ModModelLayers.MODELCRUISERTATSUTA, ModelCruiserTatsuta::new, "EntityCruiserTatsuta", 0.6F);
        //hostile ships: CA
        ship(ID.ShipClass.CAAtago, ModModelLayers.MODELCRUISERATAGO, ModelCruiserAtago::new, "EntityCruiserAtago", 0.7F);
        ship(ID.ShipClass.CATakao, ModModelLayers.MODELCRUISERTAKAO, ModelCruiserTakao::new, "EntityCruiserTakao", 0.7F);
        //hostile ships: DD
        ship(ID.ShipClass.DDAkatsuki, ModModelLayers.MODELDESTROYERAKATSUKI, ModelDestroyerAkatsuki::new, "EntityDestroyerAkatsuki", 0.5F);
        ship(ID.ShipClass.DDHibiki, ModModelLayers.MODELDESTROYERHIBIKI, ModelDestroyerHibiki::new, "EntityDestroyerHibiki", 0.5F);
        ship(ID.ShipClass.DDIkazuchi, ModModelLayers.MODELDESTROYERIKAZUCHI, ModelDestroyerIkazuchi::new, "EntityDestroyerIkazuchi", 0.5F);
        ship(ID.ShipClass.DDInazuma, ModModelLayers.MODELDESTROYERINAZUMA, ModelDestroyerInazuma::new, "EntityDestroyerInazuma", 0.5F);
        ship(ID.ShipClass.DDShimakaze, ModModelLayers.MODELDESTROYERSHIMAKAZE, ModelDestroyerShimakaze::new, "EntityDestroyerShimakaze", 0.5F);
        //hostile ships: SS
        ship(ID.ShipClass.SSRo500, ModModelLayers.MODELSUBMRO500, ModelSubmRo500::new, "EntitySubmRo500", 0.5F);
        ship(ID.ShipClass.SSU511, ModModelLayers.MODELSUBMU511, ModelSubmU511::new, "EntitySubmU511", 0.5F);

        //summons / aircraft
        misc(ID.ShipMisc.AbyssalMissile, ModModelLayers.MODELABYSSMISSILE, ModelAbyssMissile::new, "EntityAbyssMissile", 0.5F);
        misc(ID.ShipMisc.Airplane, ModModelLayers.MODELAIRPLANE, ModelAirplane::new, "EntityAircraft", 0.5F);
        misc(ID.ShipMisc.AirplaneT, ModModelLayers.MODELAIRPLANET, ModelAirplaneT::new, "EntityAirplaneT", 0.7F);
        misc(ID.ShipMisc.AirplaneTako, ModModelLayers.MODELTAKOYAKI, ModelTakoyaki::new, "EntityAircraftTakoyaki", 0.7F);
        misc(ID.ShipMisc.AirplaneZero, ModModelLayers.MODELAIRPLANEZERO, ModelAirplaneZero::new, "EntityAirplaneZero", 0.5F);
        misc(ID.ShipMisc.FloatingFort, ModModelLayers.MODELFLOATINGFORT, ModelFloatingFort::new, "EntityFloatingFort", 0.5F);
        misc(ID.ShipMisc.Rensouhou, ModModelLayers.MODELRENSOUHOU, ModelRensouhou::new, "EntityRensouhou", 0.7F);
        misc(ID.ShipMisc.RensouhouS, ModModelLayers.MODELRENSOUHOUS, ModelRensouhouS::new, "EntityRensouhouS", 0.7F);
        //mounts
        misc(ID.ShipMisc.AirfieldMount, ModModelLayers.MODELMOUNTAFH, ModelMountAfH::new, "EntityMountAfH", 1.5F);
        misc(ID.ShipMisc.BattleshipMount, ModModelLayers.MODELMOUNTBAH, ModelMountBaH::new, "EntityMountBaH", 1.5F);
        misc(ID.ShipMisc.CarrierMount, ModModelLayers.MODELMOUNTCAH, ModelMountCaH::new, "EntityMountCaH", 1.5F);
        misc(ID.ShipMisc.CarrierWDMount, ModModelLayers.MODELMOUNTCAWD, ModelMountCaWD::new, "EntityMountCaWD", 1.5F);
        misc(ID.ShipMisc.HarbourMount, ModModelLayers.MODELMOUNTHBH, ModelMountHbH::new, "EntityMountHbH", 1.5F);
        misc(ID.ShipMisc.IsloatedMount, ModModelLayers.MODELMOUNTISH, ModelMountIsH::new, "EntityMountIsH", 1.5F);
        misc(ID.ShipMisc.MidwayMount, ModModelLayers.MODELMOUNTMIH, ModelMountMiH::new, "EntityMountMiH", 1.5F);
        misc(ID.ShipMisc.SubmMount, ModModelLayers.MODELMOUNTSUH, ModelMountSuH::new, "EntityMountSuH", 1.5F);
    }

    /** default entry (legacy default = DDI) */
    public static RenderInfo defaultShip()
    {
        return SHIP.get((int) ID.ShipClass.DDI);
    }

    public static RenderInfo ship(int cls)
    {
        RenderInfo info = SHIP.get(cls);
        return info != null ? info : defaultShip();
    }

    public static RenderInfo misc(int id)
    {
        RenderInfo info = MISC.get(id);
        return info != null ? info : MISC.get((int) ID.ShipMisc.Rensouhou);
    }


}
