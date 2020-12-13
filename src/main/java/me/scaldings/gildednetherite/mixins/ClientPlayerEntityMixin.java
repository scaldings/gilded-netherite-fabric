package me.scaldings.gildednetherite.mixins;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin
{
    @Redirect(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    public Item tickMovement(ItemStack itemStack)
    {
       if (itemStack.getItem() == me.scaldings.gildednetherite.init.Items.GILDED_ELYTRA) {return Items.ELYTRA;}
        return itemStack.getItem();
    }
}
