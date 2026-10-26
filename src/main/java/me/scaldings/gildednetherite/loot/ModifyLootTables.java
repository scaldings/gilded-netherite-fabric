package me.scaldings.gildednetherite.loot;

import me.scaldings.gildednetherite.item.Items;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModifyLootTables {
    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, holder) -> {
            if (source.isBuiltin() && BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
                LootPool.Builder chestPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.25F));

                tableBuilder.withPool(chestPool);
            }

            if (source.isBuiltin() && BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
                LootPool.Builder chestPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.GILDED_UPGRADE_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.25F));

                tableBuilder.withPool(chestPool);
            }
        });
    }
}
