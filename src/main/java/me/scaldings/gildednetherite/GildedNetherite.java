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
    public void onInitialize() { Items.registerItems();}
}
