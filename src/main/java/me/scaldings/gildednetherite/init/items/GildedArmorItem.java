package me.scaldings.gildednetherite.init.items;

import me.scaldings.gildednetherite.init.materials.GildedArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class GildedArmorItem extends ArmorItem
{
    private final int protection;
    private final float toughness;
    private final ArmorMaterial type;

    public GildedArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        this.type = GildedArmorMaterial.GILDED;
        this.protection = this.type.getProtectionAmount(slot);
        this.toughness = this.type.getToughness();
    }

    public int getEnchantability() {return this.type.getEnchantability();}

    public ArmorMaterial getMaterial() {return this.type;}

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {return this.type.getRepairIngredient().test(ingredient);}

    public int getProtection() {return this.protection;}

    public float method_26353() {return this.toughness;}
}
