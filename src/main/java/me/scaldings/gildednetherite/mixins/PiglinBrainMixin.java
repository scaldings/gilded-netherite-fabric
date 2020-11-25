package me.scaldings.gildednetherite.mixins;

import me.scaldings.gildednetherite.init.GildedArmorMaterial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Iterator;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin
{
    /**
     * @author scaldings
     */
    @Overwrite
    public static boolean wearsGoldArmor(LivingEntity entity)
    {
        Iterable<ItemStack> armorItems = entity.getArmorItems();
        Iterator iterator = armorItems.iterator();
        Item item;
        boolean shouldRepeat;
        do
        {
            if (!iterator.hasNext()) {return false;}

            item = ((ItemStack)iterator.next()).getItem();
            if (item instanceof ArmorItem)
            {
                if (((ArmorItem)item).getMaterial() != GildedArmorMaterial.GILDED)
                {
                    if (((ArmorItem)item).getMaterial() != ArmorMaterials.GOLD) {shouldRepeat = true;}
                    else {shouldRepeat = false;}
                }
                else {shouldRepeat = false;}
            }
            else {shouldRepeat = true;}
        } while(shouldRepeat);

        return true;
    }
}
