package me.scaldings.gildednetherite.render;

import me.scaldings.gildednetherite.init.Items;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.ElytraItem;
import net.minecraft.util.Identifier;

public class ModelProvider
{
    private static void registerShieldModels()
    {
        FabricModelPredicateProviderRegistry.register(Items.GILDED_SHIELD, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    private static void registerElytraModels()
    {
        FabricModelPredicateProviderRegistry.register(Items.GILDED_ELYTRA, new Identifier("broken"), (itemStack, clientWorld, livingEntity) -> {
            return ElytraItem.isUsable(itemStack) ? 0.0F : 1.0F;
        });
    }

    public static void registerModels()
    {
        registerShieldModels();
        registerElytraModels();
    }
}
