package me.scaldings.gildednetherite.item;

import me.scaldings.gildednetherite.GildedNetherite;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Items {
    public static final Item GILDED_NETHERITE_INGOT = create(
            "gilded_netherite_ingot",
            Item::new,
            new Item.Properties().fireResistant(),
            CreativeModeTabs.INGREDIENTS);

    public static final Item DIAMOND_SCRAP = create(
            "diamond_scrap",
            Item::new,
            new Item.Properties(),
            CreativeModeTabs.INGREDIENTS);

    public static final Item GILDED_PHANTOM_MEMBRANE = create(
            "gilded_phantom_membrane",
            Item::new,
            new Item.Properties(),
            CreativeModeTabs.INGREDIENTS);

    public static final Item GILDED_UPGRADE_SMITHING_TEMPLATE = create(
            "gilded_upgrade_smithing_template",
            Item::new,
            new Item.Properties().rarity(Rarity.UNCOMMON),
            CreativeModeTabs.INGREDIENTS
    );

    public static final Item GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE = create(
            "gilded_netherite_upgrade_smithing_template",
            Item::new,
            new Item.Properties().fireResistant().rarity(Rarity.EPIC),
            CreativeModeTabs.INGREDIENTS
    );

    public static final Item GILDED_NETHERITE_SWORD = create(
            "gilded_netherite_sword",
            Item::new,
            new Item.Properties().sword(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL, 3F, -2.2F)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT);

    public static final Item GILDED_NETHERITE_PICKAXE = create(
            "gilded_netherite_pickaxe",
            Item::new,
            new Item.Properties().pickaxe(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL, 1F, -2.6F)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final Item GILDED_NETHERITE_AXE = create(
            "gilded_netherite_axe",
            Item::new,
            new Item.Properties().axe(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL, 5F, -2.8F)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final Item GILDED_NETHERITE_SHOVEL = create(
            "gilded_netherite_shovel",
            Item::new,
            new Item.Properties().shovel(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL, 1F, -2.8F)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final Item GILDED_NETHERITE_HOE = create(
            "gilded_netherite_hoe",
            Item::new,
            new Item.Properties().hoe(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL, -4F, 0.2F)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final Item GILDED_NETHERITE_SPEAR = create(
            "gilded_netherite_spear",
            Item::new,
            new Item.Properties().spear(
                    Tools.GILDED_NETHERITE_TOOL_MATERIAL,
                            1.15F,
                            1.2F,
                            0.4F,
                            2.5F,
                            9.0F,
                            5.5F,
                            5.1F,
                            8.75F,
                            4.6F
                    )
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT);

    public static final Item GILDED_SHIELD = create(
            "gilded_shield",
            ShieldItem::new,
            new Item.Properties()
                    .durability(622)
                    .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
                    .repairable(Tools.REPAIRS_GILDED)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .delayedComponent(DataComponents.BLOCKS_ATTACKS, (context) -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)), new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F), Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK)))
                    .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BLOCK)
                    .rarity(Rarity.UNCOMMON),
            CreativeModeTabs.COMBAT
    );

    public static final Item GILDED_NETHERITE_SHIELD = create(
            "gilded_netherite_shield",
            ShieldItem::new,
            new Item.Properties()
                    .durability(932)
                    .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
                    .repairable(Tools.REPAIRS_GILDED_NETHERITE)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .delayedComponent(DataComponents.BLOCKS_ATTACKS, (context) -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)), new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F), Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK)))
                    .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BLOCK)
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static final Item GILDED_NETHERITE_HELMET = create(
            "gilded_netherite_helmet",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            Armor.GILDED_NETHERITE_ARMOR_MATERIAL,
                            ArmorType.HELMET
                    )
                    .durability(ArmorType.HELMET.getDurability(Armor.BASE_DURABILITY))
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static final Item GILDED_NETHERITE_CHESTPLATE = create(
            "gilded_netherite_chestplate",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            Armor.GILDED_NETHERITE_ARMOR_MATERIAL,
                            ArmorType.CHESTPLATE
                    )
                    .durability(ArmorType.CHESTPLATE.getDurability(Armor.BASE_DURABILITY))
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static final Item GILDED_NETHERITE_LEGGINGS = create(
            "gilded_netherite_leggings",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            Armor.GILDED_NETHERITE_ARMOR_MATERIAL,
                            ArmorType.LEGGINGS
                    )
                    .durability(ArmorType.LEGGINGS.getDurability(Armor.BASE_DURABILITY))
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static final Item GILDED_NETHERITE_BOOTS = create(
            "gilded_netherite_boots",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            Armor.GILDED_NETHERITE_ARMOR_MATERIAL,
                            ArmorType.BOOTS
                    )
                    .durability(ArmorType.BOOTS.getDurability(Armor.BASE_DURABILITY))
                    .fireResistant()
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static final ResourceKey<EquipmentAsset> GILDED_ELYTRA_ASSET_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID, GildedNetherite.id("gilded_elytra")
    );

    public static final Item GILDED_ELYTRA = create(
            "gilded_elytra",
            Item::new,
            new Item.Properties()
                    .durability(682)
                    .component(DataComponents.GLIDER, Unit.INSTANCE)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                            .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                            .setAsset(GILDED_ELYTRA_ASSET_KEY)
                            .build())
                    .repairable(Tools.REPAIRS_GILDED_ELYTRA)
                    .rarity(Rarity.RARE),
            CreativeModeTabs.COMBAT
    );

    public static Item create(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings, ResourceKey<CreativeModeTab> creativeModeTab) {
        ResourceKey<Item> itemResourceKey = ResourceKey.create(Registries.ITEM, GildedNetherite.id(name));
        Item item = itemFactory.apply(settings.setId(itemResourceKey));
        Registry.register(BuiltInRegistries.ITEM, itemResourceKey, item);

        if (name.contains("_axe")) {
            CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> creativeTab.accept(item));
        }

        CreativeModeTabEvents.modifyOutputEvent(creativeModeTab).register((creativeTab) -> creativeTab.accept(item));
        return item;
    }

    public static void register() { }
}
