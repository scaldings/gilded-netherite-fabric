package me.scaldings.gildednetherite.init;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class GildedHoeItem extends HoeItem
{
    protected GildedHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }
}
