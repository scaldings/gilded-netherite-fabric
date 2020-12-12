package me.scaldings.gildednetherite;

import me.scaldings.gildednetherite.init.Items;
import me.scaldings.gildednetherite.render.GildedShieldItemRenderer;
import me.scaldings.gildednetherite.render.ItemTextures;
import me.scaldings.gildednetherite.render.ModelProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.item.ItemConvertible;

public class GildedNetherite implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        ItemTextures.register();
        ModelProvider.registerShieldModels();
        registerRenderer(Items.GILDED_SHIELD, new GildedShieldItemRenderer());
        Items.registerItems();
    }

    private static void registerRenderer(ItemConvertible item, BuiltinItemRendererRegistry.DynamicItemRenderer itemRenderer)
    {BuiltinItemRendererRegistry.INSTANCE.register(item, itemRenderer);}
}
