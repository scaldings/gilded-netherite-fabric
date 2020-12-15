package me.scaldings.gildednetherite.mixins;

import com.google.gson.JsonElement;
import me.scaldings.gildednetherite.GildedNetherite;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin
{
    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info)
    {
        if (GildedNetherite.GILDED_PAXEL_RECIPE != null) {map.put(new Identifier("gildednetherite", "gilded_paxel"), GildedNetherite.GILDED_PAXEL_RECIPE);}
        if (GildedNetherite.GILDED_PAXEL_RECIPE1 != null) {map.put(new Identifier("gildednetherite", "gilded_paxel1"), GildedNetherite.GILDED_PAXEL_RECIPE1);}
    }
}
