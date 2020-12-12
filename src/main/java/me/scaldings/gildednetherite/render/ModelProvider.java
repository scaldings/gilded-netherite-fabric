package me.scaldings.gildednetherite.render;

import me.scaldings.gildednetherite.init.Items;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModelProvider
{
    public static void registerShieldModels()
    {
        FabricModelPredicateProviderRegistry.register(Items.GILDED_SHIELD, new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }
}
