package me.scaldings.gildednetherite.init;

import me.scaldings.gildednetherite.init.items.GildedAxeItem;
import me.scaldings.gildednetherite.init.items.GildedHoeItem;
import me.scaldings.gildednetherite.init.items.GildedPickaxeItem;
import me.scaldings.gildednetherite.init.materials.GildedArmorMaterial;
import me.scaldings.gildednetherite.init.materials.GildedToolMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Items
{
    private static final String MOD_ID = "gildednetherite";

    //Items
    public static final Item GILDED_INGOT = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));
    public static final Item DIAMOND_SCRAP = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    //Armor
    public static final Item GILDED_HELMET = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_CHESTPLATE = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_LEGGINGS = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_BOOTS = new ArmorItem(GildedArmorMaterial.GILDED, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));

    //Tools
    public static final ToolItem GILDED_SWORD = new SwordItem(GildedToolMaterial.GILDED, 3, -2.2F, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final ToolItem GILDED_PICKAXE = new GildedPickaxeItem(GildedToolMaterial.GILDED, 1, -2.6F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_AXE = new GildedAxeItem(GildedToolMaterial.GILDED, 5, -2.8F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_SHOVEL = new ShovelItem(GildedToolMaterial.GILDED, 1, -2.8F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_HOE = new GildedHoeItem(GildedToolMaterial.GILDED, -4, 0.2F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));

    public static void registerItems()
    {
        register(GILDED_INGOT, "gilded_ingot");
        register(GILDED_HELMET, "gilded_helmet");
        register(GILDED_CHESTPLATE, "gilded_chestplate");
        register(GILDED_LEGGINGS, "gilded_leggings");
        register(GILDED_BOOTS, "gilded_boots");
        register(GILDED_SWORD, "gilded_sword");
        register(GILDED_PICKAXE, "gilded_pickaxe");
        register(GILDED_AXE, "gilded_axe");
        register(GILDED_SHOVEL, "gilded_shovel");
        register(GILDED_HOE, "gilded_hoe");
        register(DIAMOND_SCRAP, "diamond_scrap");
    }

    private static void register(Item item, String name) {Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);}
}
