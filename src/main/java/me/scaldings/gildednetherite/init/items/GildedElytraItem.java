package me.scaldings.gildednetherite.init.items;

import me.scaldings.gildednetherite.init.Items;
import me.scaldings.gildednetherite.init.materials.GildedElytraMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class GildedElytraItem extends ArmorItem
{
    public GildedElytraItem(Settings settings)
    {super(GildedElytraMaterial.GILDED, EquipmentSlot.CHEST, settings);}

    @Override
    public EquipmentSlot getSlotType()
    {return EquipmentSlot.CHEST;}

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient)
    {return ingredient.getItem() == Items.GILDED_PHANTOM_MEMBRANE;}
}
