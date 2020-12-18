package me.scaldings.gildednetherite.init.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import me.scaldings.gildednetherite.init.Items;
import me.scaldings.gildednetherite.init.materials.GildedArmorMaterial;
import me.scaldings.gildednetherite.init.materials.GildedElytraMaterial;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ArmoredGildedElytraItem extends ArmorItem
{
    private static final UUID[] MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public ArmoredGildedElytraItem(Settings settings) {
        super(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        UUID uUID = MODIFIERS[slot.getEntitySlotId()];
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", (double)getProtection(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness", (double)method_26353(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uUID, "Armor knockback resistance", (double)getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public int getEnchantability() {
        return GildedElytraMaterial.ARMORED_GILDED.getEnchantability();
    }

    @Override
    public ArmorMaterial getMaterial() {
        return GildedElytraMaterial.ARMORED_GILDED;
    }

    @Environment(EnvType.CLIENT)
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == Items.GILDED_INGOT;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.CHEST) {
            return this.attributeModifiers;
        }
        return ImmutableMultimap.of();
    }

    public int getProtection() {
        return GildedElytraMaterial.ARMORED_GILDED.getProtectionAmount(EquipmentSlot.CHEST);
    }

    public float getKnockbackResistance() {
        return GildedElytraMaterial.ARMORED_GILDED.getKnockbackResistance();
    }

    public float method_26353() {
        return GildedElytraMaterial.ARMORED_GILDED.getToughness();
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }
}
