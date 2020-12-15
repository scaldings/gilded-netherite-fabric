package me.scaldings.gildednetherite;

import com.google.gson.JsonObject;
import me.scaldings.gildednetherite.init.DynamicWriter;
import me.scaldings.gildednetherite.init.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class GildedNetherite implements ModInitializer
{
    public static JsonObject GILDED_PAXEL_RECIPE = null;
    public static JsonObject GILDED_PAXEL_RECIPE1 = null;

    @Override
    public void onInitialize()
    {
        Items.registerItems();
        if (FabricLoader.getInstance().isModLoaded("adapaxels"))
        {
            Items.registerPaxelItems();
            createGildedPaxelRecipes();
        }
    }

    private static void createGildedPaxelRecipes()
    {
        Identifier base = new Identifier("adapaxels", "netherite_paxel");
        Identifier addition = new Identifier(Items.MOD_ID, "diamond_scrap");
        Identifier result = new Identifier(Items.MOD_ID, "gilded_paxel");
        GILDED_PAXEL_RECIPE = DynamicWriter.createSmithingRecipeJson(base, addition, result);

        Identifier base1 = new Identifier("adapaxels", "diamond_paxel");
        Identifier addition1 = new Identifier(Items.MOD_ID, "gilded_ingot");
        Identifier result1 = new Identifier(Items.MOD_ID, "gilded_paxel");
        GILDED_PAXEL_RECIPE1 = DynamicWriter.createSmithingRecipeJson(base1, addition1, result1);
    }
}
