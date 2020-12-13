package me.scaldings.gildednetherite.mixins;

import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UnbreakingEnchantment.class)
public class UnbreakingEnchantmentMixin
{
    @Redirect(method = "shouldPreventDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    private static Item shouldPreventDamage(ItemStack stack)
    {
        if (stack.getItem() == me.scaldings.gildednetherite.init.Items.GILDED_ELYTRA) {return Items.ELYTRA;}
        return stack.getItem();
    }
}
