package me.scaldings.gildednetherite.event;

import me.scaldings.gildednetherite.item.Items;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class ShieldEventHandler {
    public static void registerEvents() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((defender, source, amount) -> {
            if (defender.isBlocking()) {
                ItemStack activeShield = defender.getUseItem();

                boolean isGilded = activeShield.is(Items.GILDED_SHIELD);
                boolean isGildedNetherite = activeShield.is(Items.GILDED_NETHERITE_SHIELD);

                if (isGilded || isGildedNetherite) {
                    if (source.getEntity() instanceof LivingEntity attacker) {
                        applyKnockback(defender, attacker, 1.0F);

                        if (isGildedNetherite) {
                            applyThornsDamage(defender, attacker, 2.0F);
                        }
                    }
                }
            }
            return true;
        });
    }

    private static void applyKnockback(LivingEntity defender, LivingEntity attacker, double strength) {
        Vec3 knockbackDir = attacker.position().subtract(defender.position()).normalize();

        attacker.push(
                knockbackDir.x * strength,
                0.35,
                knockbackDir.z * strength
        );
    }

    private static void applyThornsDamage(LivingEntity defender, LivingEntity attacker, float damage) {
        if (attacker.level() instanceof ServerLevel serverLevel) {
            attacker.hurtServer(serverLevel, defender.damageSources().thorns(defender), damage);
        }
    }
}
