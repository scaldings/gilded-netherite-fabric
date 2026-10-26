package me.scaldings.gildednetherite.client.datagen;

import me.scaldings.gildednetherite.GildedNetherite;
import me.scaldings.gildednetherite.item.Tools;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class GildedNetheriteItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public GildedNetheriteItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private ResourceKey<Item> key(String id) {
        return ResourceKey.create(Registries.ITEM, GildedNetherite.id(id));
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(Tools.REPAIRS_GILDED_NETHERITE).add(key("gilded_netherite_ingot"));
        builder(Tools.REPAIRS_GILDED).add(key("diamond_scrap"));
        builder(Tools.REPAIRS_GILDED_ELYTRA).add(key("gilded_phantom_membrane"));

        builder(ItemTags.SWORDS).add(key("gilded_netherite_sword"));
        builder(ItemTags.PICKAXES).add(key("gilded_netherite_pickaxe"));
        builder(ItemTags.AXES).add(key("gilded_netherite_axe"));
        builder(ItemTags.SHOVELS).add(key("gilded_netherite_shovel"));
        builder(ItemTags.HOES).add(key("gilded_netherite_hoe"));
        builder(ItemTags.SPEARS).add(key("gilded_netherite_spear"));

        builder(ConventionalItemTags.SHIELD_TOOLS).add(key("gilded_shield"));
        builder(ItemTags.DURABILITY_ENCHANTABLE).add(key("gilded_shield"));

        builder(ConventionalItemTags.SHIELD_TOOLS).add(key("gilded_netherite_shield"));
        builder(ItemTags.DURABILITY_ENCHANTABLE).add(key("gilded_netherite_shield"));

        builder(ItemTags.HEAD_ARMOR).add(key("gilded_netherite_helmet"));
        builder(ItemTags.CHEST_ARMOR).add(key("gilded_netherite_chestplate"));
        builder(ItemTags.LEG_ARMOR).add(key("gilded_netherite_leggings"));
        builder(ItemTags.FOOT_ARMOR).add(key("gilded_netherite_boots"));

        builder(ItemTags.PIGLIN_SAFE_ARMOR)
                .add(key("gilded_netherite_helmet"))
                .add(key("gilded_netherite_chestplate"))
                .add(key("gilded_netherite_leggings"))
                .add(key("gilded_netherite_boots"))
                .add(key("gilded_elytra"));

        builder(ItemTags.DURABILITY_ENCHANTABLE).add(key("gilded_elytra"));
    }
}
