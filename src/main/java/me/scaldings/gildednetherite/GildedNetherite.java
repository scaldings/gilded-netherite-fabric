package me.scaldings.gildednetherite;

import me.scaldings.gildednetherite.event.ElytraBoostHandler;
import me.scaldings.gildednetherite.event.ShieldEventHandler;
import me.scaldings.gildednetherite.item.Items;
import me.scaldings.gildednetherite.loot.ModifyLootTables;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class GildedNetherite implements ModInitializer {
	public static final String MOD_ID = "gildednetherite";

	@Override
	public void onInitialize() {
		Items.register();
		ModifyLootTables.register();
		ShieldEventHandler.registerEvents();
		ElytraBoostHandler.registerEvents();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
