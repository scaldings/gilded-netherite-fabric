package me.scaldings.gildednetherite;

import net.fabricmc.api.ModInitializer;
import me.scaldings.gildednetherite.init.Items;

public class GildedNetherite implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        Items.registerItems();
    }
}
