package me.scaldings.gildednetherite.client.datagen;

import me.scaldings.gildednetherite.GildedNetherite;
import me.scaldings.gildednetherite.client.render.GildedNetheriteShieldSpecialRenderer;
import me.scaldings.gildednetherite.client.render.GildedShieldSpecialRenderer;
import me.scaldings.gildednetherite.item.Items;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;

public class GildedNetheriteModelProvider extends FabricModelProvider {
    public GildedNetheriteModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        generateGildedNetheriteShieldModel(itemModelGenerator);
        generateGildedShieldModel(itemModelGenerator);
    }

    public void generateGildedShieldModel(ItemModelGenerators itemModelGenerator) {
        Identifier vanillaShieldModelLocation = ModelLocationUtils.getModelLocation(net.minecraft.world.item.Items.SHIELD);
        Identifier modelLocation = ModelLocationUtils.getModelLocation(Items.GILDED_SHIELD);

        ModelTemplate shieldTemplate = new ModelTemplate(Optional.of(vanillaShieldModelLocation), Optional.empty(), TextureSlot.PARTICLE);
        shieldTemplate.create(modelLocation, TextureMapping.singleSlot(TextureSlot.PARTICLE, new Material(ModelLocationUtils.getModelLocation(Blocks.ACACIA_PLANKS))), itemModelGenerator.modelOutput);

        ModelTemplate blockingShieldTemplate = new ModelTemplate(Optional.of(vanillaShieldModelLocation.withSuffix("_blocking")), Optional.empty(), TextureSlot.PARTICLE);
        blockingShieldTemplate.create(modelLocation.withSuffix("_blocking"), TextureMapping.singleSlot(TextureSlot.PARTICLE, new Material(ModelLocationUtils.getModelLocation(Blocks.ACACIA_PLANKS))), itemModelGenerator.modelOutput);

        GildedShieldSpecialRenderer.Unbaked specialRenderer = new GildedShieldSpecialRenderer.Unbaked(
                GildedNetherite.id("gilded_shield_base"),
                GildedNetherite.id("gilded_shield_base_nopattern")
        );
        itemModelGenerator.itemModelOutput.accept(Items.GILDED_SHIELD, ItemModelUtils.conditional(GildedShieldSpecialRenderer.DEFAULT_TRANSFORMATION, ItemModelUtils.isUsingItem(),
                ItemModelUtils.specialModel(modelLocation.withSuffix("_blocking"), specialRenderer),
                ItemModelUtils.specialModel(modelLocation, specialRenderer)
        ));
    }

    public void generateGildedNetheriteShieldModel(ItemModelGenerators itemModelGenerator) {
        Identifier vanillaShieldModelLocation = ModelLocationUtils.getModelLocation(net.minecraft.world.item.Items.SHIELD);
        Identifier modelLocation = ModelLocationUtils.getModelLocation(Items.GILDED_NETHERITE_SHIELD);

        ModelTemplate shieldTemplate = new ModelTemplate(Optional.of(vanillaShieldModelLocation), Optional.empty(), TextureSlot.PARTICLE);
        shieldTemplate.create(modelLocation, TextureMapping.singleSlot(TextureSlot.PARTICLE, new Material(ModelLocationUtils.getModelLocation(Blocks.ACACIA_PLANKS))), itemModelGenerator.modelOutput);

        ModelTemplate blockingShieldTemplate = new ModelTemplate(Optional.of(vanillaShieldModelLocation.withSuffix("_blocking")), Optional.empty(), TextureSlot.PARTICLE);
        blockingShieldTemplate.create(modelLocation.withSuffix("_blocking"), TextureMapping.singleSlot(TextureSlot.PARTICLE, new Material(ModelLocationUtils.getModelLocation(Blocks.ACACIA_PLANKS))), itemModelGenerator.modelOutput);

        GildedNetheriteShieldSpecialRenderer.Unbaked specialRenderer = new GildedNetheriteShieldSpecialRenderer.Unbaked(
                GildedNetherite.id("gilded_netherite_shield_base"),
                GildedNetherite.id("gilded_netherite_shield_base_nopattern")
        );
        itemModelGenerator.itemModelOutput.accept(Items.GILDED_NETHERITE_SHIELD, ItemModelUtils.conditional(GildedNetheriteShieldSpecialRenderer.DEFAULT_TRANSFORMATION, ItemModelUtils.isUsingItem(),
                ItemModelUtils.specialModel(modelLocation.withSuffix("_blocking"), specialRenderer),
                ItemModelUtils.specialModel(modelLocation, specialRenderer)
        ));
    }
}
