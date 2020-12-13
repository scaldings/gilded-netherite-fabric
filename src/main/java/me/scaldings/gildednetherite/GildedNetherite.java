package me.scaldings.gildednetherite;

import me.scaldings.gildednetherite.init.Items;
import me.scaldings.gildednetherite.render.elytra.GildedElytraFeatureRenderer;
import me.scaldings.gildednetherite.render.shield.GildedShieldItemRenderer;
import me.scaldings.gildednetherite.render.shield.ItemTextures;
import me.scaldings.gildednetherite.render.ModelProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemConvertible;

public class GildedNetherite implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        clientSideRegister();
        Items.registerItems();
    }

    @Environment(EnvType.CLIENT)
    private static void clientSideRegister()
    {
        ItemTextures.register();
        ModelProvider.registerModels();
        registerRenderer(Items.GILDED_SHIELD, new GildedShieldItemRenderer());
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((EntityType<? extends LivingEntity> entityType, LivingEntityRenderer<?, ?> entityRenderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper) -> {
            if (entityRenderer.getModel() instanceof PlayerEntityModel || entityRenderer.getModel() instanceof BipedEntityModel || entityRenderer.getModel() instanceof ArmorStandEntityModel)
            {registrationHelper.register(new GildedElytraFeatureRenderer(entityRenderer)); }
        });
    }

    private static void registerRenderer(ItemConvertible item, BuiltinItemRendererRegistry.DynamicItemRenderer itemRenderer)
    {BuiltinItemRendererRegistry.INSTANCE.register(item, itemRenderer);}
}
