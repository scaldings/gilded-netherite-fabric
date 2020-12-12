package me.scaldings.gildednetherite.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(PlayerEntity.class)
public class PlayerEntityMixin
{
    @Redirect(method = "damageShield(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    private Item shields(ItemStack stack) {
        return Items.SHIELD;
    }
}
