package me.scaldings.gildednetherite.client.render;

import java.util.Objects;
import java.util.function.Consumer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Transformation;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.scaldings.gildednetherite.client.GildedNetheriteClient;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

public class GildedNetheriteShieldSpecialRenderer implements SpecialModelRenderer<DataComponentMap> {
    public static final Transformation DEFAULT_TRANSFORMATION = new Transformation(null, null, new Vector3f(1.0F, -1.0F, -1.0F), null);

    private final SpriteGetter sprites;
    private final ShieldModel model;
    private final SpriteId baseSprite;
    private final SpriteId baseSpriteNoPattern;

    public GildedNetheriteShieldSpecialRenderer(final SpriteGetter sprites, final ShieldModel model, final SpriteId baseSprite, final SpriteId baseSpriteNoPattern) {
        this.sprites = sprites;
        this.model = model;
        this.baseSprite = baseSprite;
        this.baseSpriteNoPattern = baseSpriteNoPattern;
    }

    @Override
    public @Nullable DataComponentMap extractArgument(final ItemStack stack) {
        return stack.immutableComponents();
    }

    @Override
    public void submit(final @Nullable DataComponentMap components, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final int lightCoords, final int overlayCoords, final boolean hasFoil, final int outlineColor) {
        BannerPatternLayers patterns = components != null ? components.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY) : BannerPatternLayers.EMPTY;
        DyeColor baseColor = components != null ? components.get(DataComponents.BASE_COLOR) : null;
        boolean hasPatterns = !patterns.layers().isEmpty() || baseColor != null;
        SpriteId sprite = hasPatterns ? this.baseSprite : this.baseSpriteNoPattern;

        submitNodeCollector.submitModel(this.model, Unit.INSTANCE, poseStack, lightCoords, overlayCoords, -1, sprite, this.sprites, outlineColor);

        if (hasPatterns) {
            BannerRenderer.submitPatterns(this.sprites, poseStack, submitNodeCollector, lightCoords, overlayCoords, this.model, Unit.INSTANCE, false, Objects.requireNonNullElse(baseColor, DyeColor.WHITE), patterns);
        }

        if (hasFoil) {
            submitNodeCollector.submitModel(this.model, Unit.INSTANCE, poseStack, RenderTypes.patternedShieldGlint(), lightCoords, overlayCoords, -1, this.sprites.get(sprite), 0);
        }
    }

    @Override
    public void getExtents(final Consumer<Vector3fc> output) {
        PoseStack poseStack = new PoseStack();
        this.model.root().getExtentsForGui(poseStack, output);
    }

    public record Unbaked(Identifier base, Identifier noPattern) implements SpecialModelRenderer.Unbaked<DataComponentMap> {
        public static final MapCodec<Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(
                Identifier.CODEC.fieldOf("texture").forGetter(Unbaked::base),
                Identifier.CODEC.fieldOf("no_pattern_texture").forGetter(Unbaked::noPattern)
        ).apply(i, Unbaked::new));

        public MapCodec<Unbaked> type() {
            return MAP_CODEC;
        }

        public GildedNetheriteShieldSpecialRenderer bake(final SpecialModelRenderer.BakingContext context) {
            return new GildedNetheriteShieldSpecialRenderer(context.sprites(), new ShieldModel(context.entityModelSet()
                    .bakeLayer(GildedNetheriteClient.GILDED_NETHERITE_SHIELD_MODEL)), Sheets.SHIELD_MAPPER.apply(this.base), Sheets.SHIELD_MAPPER.apply(this.noPattern));
        }
    }
}