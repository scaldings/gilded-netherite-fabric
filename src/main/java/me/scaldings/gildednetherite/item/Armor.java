package me.scaldings.gildednetherite.item;

import me.scaldings.gildednetherite.GildedNetherite;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class Armor {
    public static final ResourceKey<EquipmentAsset> GILDED_NETHERITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, GildedNetherite.id("gilded_netherite"));

    public static final int BASE_DURABILITY = 40;
    public static final ArmorMaterial GILDED_NETHERITE_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            23,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.2F,
            0.15F,
            Tools.REPAIRS_GILDED_NETHERITE,
            GILDED_NETHERITE_ARMOR_MATERIAL_KEY
    );
}
