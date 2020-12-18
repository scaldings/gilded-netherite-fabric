package me.scaldings.gildednetherite.render.elytra;

import me.scaldings.gildednetherite.init.Items;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GildedElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M>
{
    public static final Identifier GILDED_ELYTRA_SKIN = new Identifier(Items.MOD_ID, "textures/entity/gilded_elytra.png");
    private final ElytraEntityModel<T> elytra = new ElytraEntityModel();
    public GildedElytraFeatureRenderer(FeatureRendererContext<T, M> context) {super(context);}

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l)
    {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.getItem() == Items.GILDED_ELYTRA || itemStack.getItem() == Items.ARMORED_GILDED_ELYTRA) {
            Identifier identifier;
            if (livingEntity instanceof AbstractClientPlayerEntity) {
                AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity) livingEntity;
                if (abstractClientPlayerEntity.canRenderElytraTexture() && abstractClientPlayerEntity.getElytraTexture() != null) {identifier = abstractClientPlayerEntity.getElytraTexture();}
                else if (abstractClientPlayerEntity.canRenderCapeTexture() && abstractClientPlayerEntity.getCapeTexture() != null && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE))
                {identifier = abstractClientPlayerEntity.getCapeTexture();}
                else {identifier = GILDED_ELYTRA_SKIN;}
            }
            else {identifier = GILDED_ELYTRA_SKIN;}

            matrixStack.push();
            matrixStack.translate(0.0D, 0.0D, 0.125D);
            getContextModel().copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.elytra.getLayer(identifier), false, itemStack.hasGlint());
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }
}
