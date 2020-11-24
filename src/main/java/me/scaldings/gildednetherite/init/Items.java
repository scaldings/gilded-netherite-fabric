package me.scaldings.gildednetherite.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items
{
    private static final String MOD_ID = "gildednetherite";
    public static final Item GILDED_NETHERITE_INGOT = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));

    public static void registerItems()
    {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gilded_netherite_ingot"), GILDED_NETHERITE_INGOT);
    }
}
