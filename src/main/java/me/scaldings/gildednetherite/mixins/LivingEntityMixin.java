package me.scaldings.gildednetherite.mixins;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin
{
    @Redirect(method = "initAi()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    public Item initAi(ItemStack itemStack)
    {
        if (itemStack.getItem() == me.scaldings.gildednetherite.init.Items.GILDED_ELYTRA) {return Items.ELYTRA;}
        return itemStack.getItem();
    }
}
