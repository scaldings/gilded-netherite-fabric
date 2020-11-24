package me.scaldings.gildednetherite.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items
{
    private static final String MOD_ID = "gildednetherite";

    //Items
    public static final Item GILDED_NETHERITE_INGOT = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));

    //Armor
    public static final Item GILDED_NETHERITE_HELMET = new ArmorItem(GildedNetheriteMaterial.GILDED_NETHERITE, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_NETHERITE_CHESTPLATE = new ArmorItem(GildedNetheriteMaterial.GILDED_NETHERITE, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_NETHERITE_LEGGINGS = new ArmorItem(GildedNetheriteMaterial.GILDED_NETHERITE, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_NETHERITE_BOOTS = new ArmorItem(GildedNetheriteMaterial.GILDED_NETHERITE, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ItemGroup.COMBAT));

    public static void registerItems()
    {
        register(GILDED_NETHERITE_INGOT, "gilded_netherite_ingot");
        register(GILDED_NETHERITE_HELMET, "gilded_netherite_helmet");
        register(GILDED_NETHERITE_CHESTPLATE, "gilded_netherite_chestplate");
        register(GILDED_NETHERITE_LEGGINGS, "gilded_netherite_leggings");
        register(GILDED_NETHERITE_BOOTS, "gilded_netherite_boots");
    }

    private static void register(Item item, String name)
    {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }
}
