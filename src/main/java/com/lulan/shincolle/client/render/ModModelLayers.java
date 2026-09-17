package com.lulan.shincolle.client.render;

import java.util.HashMap;
import java.util.Map;

import com.lulan.shincolle.client.model.*;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/** model layer locations + layer definition registration (Phase 7) */
public final class ModModelLayers
{

	public static final ModelLayerLocation MODELABYSSMISSILE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelabyssmissile"), "main");
	public static final ModelLayerLocation MODELAIRFIELDHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelairfieldhime"), "main");
	public static final ModelLayerLocation MODELAIRPLANE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelairplane"), "main");
	public static final ModelLayerLocation MODELAIRPLANET = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelairplanet"), "main");
	public static final ModelLayerLocation MODELAIRPLANEZERO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelairplanezero"), "main");
	public static final ModelLayerLocation MODELBBHARUNA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbbharuna"), "main");
	public static final ModelLayerLocation MODELBBHIEI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbbhiei"), "main");
	public static final ModelLayerLocation MODELBBKIRISHIMA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbbkirishima"), "main");
	public static final ModelLayerLocation MODELBBKONGOU = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbbkongou"), "main");
	public static final ModelLayerLocation MODELBASICENTITYITEM = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbasicentityitem"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshiphime"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPNAGATO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshipnagato"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPRE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshipre"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPRU = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshipru"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPTA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshipta"), "main");
	public static final ModelLayerLocation MODELBATTLESHIPYAMATO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelbattleshipyamato"), "main");
	public static final ModelLayerLocation MODELBLOCKDESK = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelblockdesk"), "main");
	public static final ModelLayerLocation MODELCAHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcahime"), "main");
	public static final ModelLayerLocation MODELCARRIERAKAGI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcarrierakagi"), "main");
	public static final ModelLayerLocation MODELCARRIERHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcarrierhime"), "main");
	public static final ModelLayerLocation MODELCARRIERKAGA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcarrierkaga"), "main");
	public static final ModelLayerLocation MODELCARRIERWDEMON = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcarrierwdemon"), "main");
	public static final ModelLayerLocation MODELCARRIERWO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcarrierwo"), "main");
	public static final ModelLayerLocation MODELCRUISERATAGO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcruiseratago"), "main");
	public static final ModelLayerLocation MODELCRUISERTAKAO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcruisertakao"), "main");
	public static final ModelLayerLocation MODELCRUISERTATSUTA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcruisertatsuta"), "main");
	public static final ModelLayerLocation MODELCRUISERTENRYUU = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelcruisertenryuu"), "main");
	public static final ModelLayerLocation MODELDESTROYERAKATSUKI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerakatsuki"), "main");
	public static final ModelLayerLocation MODELDESTROYERHA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerha"), "main");
	public static final ModelLayerLocation MODELDESTROYERHIBIKI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerhibiki"), "main");
	public static final ModelLayerLocation MODELDESTROYERHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerhime"), "main");
	public static final ModelLayerLocation MODELDESTROYERI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyeri"), "main");
	public static final ModelLayerLocation MODELDESTROYERIKAZUCHI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerikazuchi"), "main");
	public static final ModelLayerLocation MODELDESTROYERINAZUMA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerinazuma"), "main");
	public static final ModelLayerLocation MODELDESTROYERNI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerni"), "main");
	public static final ModelLayerLocation MODELDESTROYERRO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyerro"), "main");
	public static final ModelLayerLocation MODELDESTROYERSHIMAKAZE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeldestroyershimakaze"), "main");
	public static final ModelLayerLocation MODELFLOATINGFORT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelfloatingfort"), "main");
	public static final ModelLayerLocation MODELHARBOURHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelharbourhime"), "main");
	public static final ModelLayerLocation MODELHEAVYCRUISERNE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelheavycruiserne"), "main");
	public static final ModelLayerLocation MODELHEAVYCRUISERRI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelheavycruiserri"), "main");
	public static final ModelLayerLocation MODELISOLATEDHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelisolatedhime"), "main");
	public static final ModelLayerLocation MODELLARGESHIPYARD = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modellargeshipyard"), "main");
	public static final ModelLayerLocation MODELMIDWAYHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmidwayhime"), "main");
	public static final ModelLayerLocation MODELMOUNTAFH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountafh"), "main");
	public static final ModelLayerLocation MODELMOUNTBAH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountbah"), "main");
	public static final ModelLayerLocation MODELMOUNTCAH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountcah"), "main");
	public static final ModelLayerLocation MODELMOUNTCAWD = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountcawd"), "main");
	public static final ModelLayerLocation MODELMOUNTHBH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmounthbh"), "main");
	public static final ModelLayerLocation MODELMOUNTISH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountish"), "main");
	public static final ModelLayerLocation MODELMOUNTMIH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountmih"), "main");
	public static final ModelLayerLocation MODELMOUNTSUH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelmountsuh"), "main");
	public static final ModelLayerLocation MODELNORTHERNHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelnorthernhime"), "main");
	public static final ModelLayerLocation MODELRENSOUHOU = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelrensouhou"), "main");
	public static final ModelLayerLocation MODELRENSOUHOUS = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelrensouhous"), "main");
	public static final ModelLayerLocation MODELSSNH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelssnh"), "main");
	public static final ModelLayerLocation MODELSMALLSHIPYARD = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsmallshipyard"), "main");
	public static final ModelLayerLocation MODELSUBMHIME = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmhime"), "main");
	public static final ModelLayerLocation MODELSUBMKA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmka"), "main");
	public static final ModelLayerLocation MODELSUBMRO500 = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmro500"), "main");
	public static final ModelLayerLocation MODELSUBMSO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmso"), "main");
	public static final ModelLayerLocation MODELSUBMU511 = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmu511"), "main");
	public static final ModelLayerLocation MODELSUBMYO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelsubmyo"), "main");
	public static final ModelLayerLocation MODELTAKOYAKI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeltakoyaki"), "main");
	public static final ModelLayerLocation MODELTRANSPORTWA = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modeltransportwa"), "main");
	public static final ModelLayerLocation MODELVORTEX = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "modelvortex"), "main");

	private static final Map<ModelLayerLocation, net.minecraft.client.model.geom.builders.LayerDefinition> BAKED = new HashMap<>();

	/** bake helper: get ModelPart root for a layer (call after layer registration) */
	public static void register(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(MODELABYSSMISSILE, ModelAbyssMissile::createBodyLayer);
		event.registerLayerDefinition(MODELAIRFIELDHIME, ModelAirfieldHime::createBodyLayer);
		event.registerLayerDefinition(MODELAIRPLANE, ModelAirplane::createBodyLayer);
		event.registerLayerDefinition(MODELAIRPLANET, ModelAirplaneT::createBodyLayer);
		event.registerLayerDefinition(MODELAIRPLANEZERO, ModelAirplaneZero::createBodyLayer);
		event.registerLayerDefinition(MODELBBHARUNA, ModelBBHaruna::createBodyLayer);
		event.registerLayerDefinition(MODELBBHIEI, ModelBBHiei::createBodyLayer);
		event.registerLayerDefinition(MODELBBKIRISHIMA, ModelBBKirishima::createBodyLayer);
		event.registerLayerDefinition(MODELBBKONGOU, ModelBBKongou::createBodyLayer);
		event.registerLayerDefinition(MODELBASICENTITYITEM, ModelBasicEntityItem::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPHIME, ModelBattleshipHime::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPNAGATO, ModelBattleshipNagato::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPRE, ModelBattleshipRe::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPRU, ModelBattleshipRu::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPTA, ModelBattleshipTa::createBodyLayer);
		event.registerLayerDefinition(MODELBATTLESHIPYAMATO, ModelBattleshipYamato::createBodyLayer);
		event.registerLayerDefinition(MODELBLOCKDESK, ModelBlockDesk::createBodyLayer);
		event.registerLayerDefinition(MODELCAHIME, ModelCAHime::createBodyLayer);
		event.registerLayerDefinition(MODELCARRIERAKAGI, ModelCarrierAkagi::createBodyLayer);
		event.registerLayerDefinition(MODELCARRIERHIME, ModelCarrierHime::createBodyLayer);
		event.registerLayerDefinition(MODELCARRIERKAGA, ModelCarrierKaga::createBodyLayer);
		event.registerLayerDefinition(MODELCARRIERWDEMON, ModelCarrierWDemon::createBodyLayer);
		event.registerLayerDefinition(MODELCARRIERWO, ModelCarrierWo::createBodyLayer);
		event.registerLayerDefinition(MODELCRUISERATAGO, ModelCruiserAtago::createBodyLayer);
		event.registerLayerDefinition(MODELCRUISERTAKAO, ModelCruiserTakao::createBodyLayer);
		event.registerLayerDefinition(MODELCRUISERTATSUTA, ModelCruiserTatsuta::createBodyLayer);
		event.registerLayerDefinition(MODELCRUISERTENRYUU, ModelCruiserTenryuu::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERAKATSUKI, ModelDestroyerAkatsuki::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERHA, ModelDestroyerHa::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERHIBIKI, ModelDestroyerHibiki::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERHIME, ModelDestroyerHime::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERI, ModelDestroyerI::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERIKAZUCHI, ModelDestroyerIkazuchi::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERINAZUMA, ModelDestroyerInazuma::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERNI, ModelDestroyerNi::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERRO, ModelDestroyerRo::createBodyLayer);
		event.registerLayerDefinition(MODELDESTROYERSHIMAKAZE, ModelDestroyerShimakaze::createBodyLayer);
		event.registerLayerDefinition(MODELFLOATINGFORT, ModelFloatingFort::createBodyLayer);
		event.registerLayerDefinition(MODELHARBOURHIME, ModelHarbourHime::createBodyLayer);
		event.registerLayerDefinition(MODELHEAVYCRUISERNE, ModelHeavyCruiserNe::createBodyLayer);
		event.registerLayerDefinition(MODELHEAVYCRUISERRI, ModelHeavyCruiserRi::createBodyLayer);
		event.registerLayerDefinition(MODELISOLATEDHIME, ModelIsolatedHime::createBodyLayer);
		event.registerLayerDefinition(MODELLARGESHIPYARD, ModelLargeShipyard::createBodyLayer);
		event.registerLayerDefinition(MODELMIDWAYHIME, ModelMidwayHime::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTAFH, ModelMountAfH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTBAH, ModelMountBaH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTCAH, ModelMountCaH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTCAWD, ModelMountCaWD::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTHBH, ModelMountHbH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTISH, ModelMountIsH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTMIH, ModelMountMiH::createBodyLayer);
		event.registerLayerDefinition(MODELMOUNTSUH, ModelMountSuH::createBodyLayer);
		event.registerLayerDefinition(MODELNORTHERNHIME, ModelNorthernHime::createBodyLayer);
		event.registerLayerDefinition(MODELRENSOUHOU, ModelRensouhou::createBodyLayer);
		event.registerLayerDefinition(MODELRENSOUHOUS, ModelRensouhouS::createBodyLayer);
		event.registerLayerDefinition(MODELSSNH, ModelSSNH::createBodyLayer);
		event.registerLayerDefinition(MODELSMALLSHIPYARD, ModelSmallShipyard::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMHIME, ModelSubmHime::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMKA, ModelSubmKa::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMRO500, ModelSubmRo500::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMSO, ModelSubmSo::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMU511, ModelSubmU511::createBodyLayer);
		event.registerLayerDefinition(MODELSUBMYO, ModelSubmYo::createBodyLayer);
		event.registerLayerDefinition(MODELTAKOYAKI, ModelTakoyaki::createBodyLayer);
		event.registerLayerDefinition(MODELTRANSPORTWA, ModelTransportWa::createBodyLayer);
		event.registerLayerDefinition(MODELVORTEX, ModelVortex::createBodyLayer);
	}

}
