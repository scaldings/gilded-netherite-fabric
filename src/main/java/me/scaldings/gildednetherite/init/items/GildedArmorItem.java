package me.scaldings.gildednetherite.init.items;

import me.scaldings.gildednetherite.init.materials.GildedArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GildedArmorItem extends ArmorItem
{
    private final EquipmentSlot slot;
    private final int protection;
    private final float toughness;
    private final ArmorMaterial type;

    public GildedArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        this.type = GildedArmorMaterial.GILDED;
        this.slot = slot;
        this.protection = this.type.getProtectionAmount(slot);
        this.toughness = this.type.getToughness();
    }

    public int getEnchantability() {
        return this.type.getEnchantability();
    }

    public ArmorMaterial getMaterial() {
        return this.type;
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return this.type.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(itemStack);
        ItemStack itemStack2 = user.getEquippedStack(equipmentSlot);
        if (itemStack2.isEmpty()) {
            user.equipStack(equipmentSlot, itemStack.copy());
            itemStack.setCount(0);
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }

    public int getProtection() {
        return this.protection;
    }

    public float method_26353() {
        return this.toughness;
    }
}
