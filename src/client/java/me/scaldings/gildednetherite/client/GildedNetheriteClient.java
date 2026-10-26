package me.scaldings.gildednetherite.client;

import me.scaldings.gildednetherite.GildedNetherite;
import me.scaldings.gildednetherite.client.render.GildedNetheriteShieldSpecialRenderer;
import me.scaldings.gildednetherite.client.render.GildedShieldSpecialRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.special.SpecialModelRenderers;

public class GildedNetheriteClient implements ClientModInitializer {

	public static final ModelLayerLocation GILDED_SHIELD_MODEL = new ModelLayerLocation(
			GildedNetherite.id("gilded_shield"),
			"main"
	);

	public static final ModelLayerLocation GILDED_NETHERITE_SHIELD_MODEL = new ModelLayerLocation(
			GildedNetherite.id("gilded_netherite_shield"),
			"main"
	);

	@Override
	public void onInitializeClient() {
		registerShieldModels();
	}

	private static void registerShieldModels() {
		SpecialModelRenderers.ID_MAPPER.put(GildedNetherite.id("gilded_shield"), GildedShieldSpecialRenderer.Unbaked.MAP_CODEC);
		ModelLayerRegistry.registerModelLayer(GILDED_SHIELD_MODEL, ShieldModel::createLayer);

		SpecialModelRenderers.ID_MAPPER.put(GildedNetherite.id("gilded_netherite_shield"), GildedNetheriteShieldSpecialRenderer.Unbaked.MAP_CODEC);
		ModelLayerRegistry.registerModelLayer(GILDED_NETHERITE_SHIELD_MODEL, ShieldModel::createLayer);
	}
}