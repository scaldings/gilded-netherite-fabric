package me.scaldings.gildednetherite;

import me.scaldings.gildednetherite.init.Items;
import net.fabricmc.api.ModInitializer;

public class GildedNetherite implements ModInitializer {
    @Override
    public void onInitialize() {
        Items.registerItems();
    }
}
