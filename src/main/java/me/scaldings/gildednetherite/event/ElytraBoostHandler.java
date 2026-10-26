package me.scaldings.gildednetherite.event;

import me.scaldings.gildednetherite.item.Items;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ElytraBoostHandler {
    private static final Set<UUID> WAS_GLIDING = new HashSet<>();

    public static void registerEvents() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                boolean isGliding = player.isFallFlying();
                UUID uuid = player.getUUID();

                if (isGliding && !WAS_GLIDING.contains(uuid)) {
                    ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);

                    if (chestItem.is(Items.GILDED_ELYTRA)) {
                        boolean isOnCooldown = player.getCooldowns().isOnCooldown(chestItem);

                        if (!isOnCooldown) {
                            applyFireworkBoost(player);
                            player.getCooldowns().addCooldown(chestItem, 20 * 20);
                        }
                    }
                }

                if (isGliding) {
                    WAS_GLIDING.add(uuid);
                } else {
                    WAS_GLIDING.remove(uuid);
                }
            }
        });
    }

    private static void applyFireworkBoost(ServerPlayer player) {
        ItemStack rocketStack = new ItemStack(net.minecraft.world.item.Items.FIREWORK_ROCKET);

        FireworkRocketEntity firework = new FireworkRocketEntity(
                player.level(),
                rocketStack,
                player
        );

        player.level().addFreshEntity(firework);
    }
}
