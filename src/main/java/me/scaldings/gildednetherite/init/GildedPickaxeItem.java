package me.scaldings.gildednetherite.init;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class GildedPickaxeItem extends PickaxeItem
{
    protected GildedPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }
}
