package me.scaldings.gildednetherite.item;

import me.scaldings.gildednetherite.GildedNetherite;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class Tools {
    public static final TagKey<Item> REPAIRS_GILDED_NETHERITE = TagKey.create(BuiltInRegistries.ITEM.key(), GildedNetherite.id("repairs_gilded_netherite"));
    public static final TagKey<Item> REPAIRS_GILDED = TagKey.create(BuiltInRegistries.ITEM.key(), GildedNetherite.id("repairs_gilded"));
    public static final TagKey<Item> REPAIRS_GILDED_ELYTRA = TagKey.create(BuiltInRegistries.ITEM.key(), GildedNetherite.id("repairs_gilded_elytra"));

    public static final ToolMaterial GILDED_NETHERITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2258,
            10.0F,
            4.2F,
            23,
            REPAIRS_GILDED_NETHERITE
    );
}
