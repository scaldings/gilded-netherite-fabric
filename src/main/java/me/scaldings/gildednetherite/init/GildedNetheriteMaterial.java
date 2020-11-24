package me.scaldings.gildednetherite.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum GildedNetheriteMaterial implements ArmorMaterial
{
    GILDED_NETHERITE(ArmorMaterials.NETHERITE);

    private ArmorMaterial MATERIAL;
    GildedNetheriteMaterial(ArmorMaterials material) {MATERIAL = material;}

    @Override
    public int getDurability(EquipmentSlot slot) {return MATERIAL.getDurability(slot);}

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {return MATERIAL.getProtectionAmount(slot);}

    @Override
    public int getEnchantability() {return MATERIAL.getEnchantability();}

    @Override
    public SoundEvent getEquipSound() {return MATERIAL.getEquipSound();}

    @Override
    public Ingredient getRepairIngredient() {return Ingredient.ofStacks(new ItemStack(Items.GILDED_NETHERITE_INGOT));}

    @Override
    public String getName() {return MATERIAL.getName();}

    @Override
    public float getToughness() {return MATERIAL.getToughness();}

    @Override
    public float getKnockbackResistance() {return MATERIAL.getKnockbackResistance();}
}
