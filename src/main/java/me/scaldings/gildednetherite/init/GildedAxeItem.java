package me.scaldings.gildednetherite.init;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class GildedAxeItem extends AxeItem
{
    protected GildedAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }
}
