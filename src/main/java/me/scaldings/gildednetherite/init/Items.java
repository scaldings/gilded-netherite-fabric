package me.scaldings.gildednetherite.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items
{
    private static final String MOD_ID = "gildednetherite";

    //Items
    public static final Item GILDED_INGOT = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));

    //Armor
    public static final Item GILDED_HELMET = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_CHESTPLATE = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_LEGGINGS = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ItemGroup.COMBAT));
    public static final Item GILDED_BOOTS = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ItemGroup.COMBAT));

    //Tools                                                                                            8.8                1.8
    public static final ToolItem GILDED_SWORD = new SwordItem(GildedToolMaterial.GILDED, 3, -2.2F, new Item.Settings().fireproof().group(ItemGroup.COMBAT));

    public static void registerItems()
    {
        register(GILDED_INGOT, "gilded_ingot");
        register(GILDED_HELMET, "gilded_helmet");
        register(GILDED_CHESTPLATE, "gilded_chestplate");
        register(GILDED_LEGGINGS, "gilded_leggings");
        register(GILDED_BOOTS, "gilded_boots");
        register(GILDED_SWORD, "gilded_sword");
    }

    private static void register(Item item, String name)
    {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }
}
