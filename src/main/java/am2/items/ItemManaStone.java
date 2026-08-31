package am2.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import am2.playerextensions.ExtendedProperties;

public class ItemManaStone extends ArsMagicaItem {

    private static final String KEY_NBT_MANA = "Stored_MANA";

    public ItemManaStone() {
        super();
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        String[] strings = StatCollector.translateToLocal("am2.tooltip.stoneUse")
            .split(" ");
        String firstHalf = "";
        String secondHalf = "";
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length / 2) firstHalf += strings[i] + " ";
            else secondHalf += strings[i] + " ";
        }
        list.add(String.format(StatCollector.translateToLocal("am2.tooltip.containedMana"), getManaInStone(stack)));
        list.add(firstHalf);
        list.add(secondHalf);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stone, World world, EntityPlayer player) {

        if (player.isSneaking() && !isFull(stone)) {
            if (ExtendedProperties.For(player)
                .getCurrentMana() > 50) {
                ExtendedProperties.For(player)
                    .setCurrentMana(
                        ExtendedProperties.For(player)
                            .getCurrentMana() - 50);
                if (!player.worldObj.isRemote) addManaToStone(stone, 50);
            }
        } else {
            int amtp = Math.min(getManaInStone(stone), 50);
            float amt = Math.min(
                ExtendedProperties.For(player)
                    .getMaxMana()
                    - ExtendedProperties.For(player)
                        .getCurrentMana(),
                amtp);
            if (amt > 0) {
                ExtendedProperties.For(player)
                    .setCurrentMana(
                        ExtendedProperties.For(player)
                            .getCurrentMana() + amt);
                if (!player.worldObj.isRemote) deductManaFromStone(stone, (int) amt);
            }
        }

        return super.onItemRightClick(stone, world, player);
    }

    public static void addManaToStone(ItemStack stone, int amount) {
        if (!stone.hasTagCompound()) stone.stackTagCompound = new NBTTagCompound();
        int value = Math.min(stone.stackTagCompound.getInteger(KEY_NBT_MANA) + amount, 1000);
        stone.stackTagCompound.setInteger(KEY_NBT_MANA, value);
    }

    public static void deductManaFromStone(ItemStack stone, int amount) {
        addManaToStone(stone, -amount);
    }

    public static int getManaInStone(ItemStack stone) {
        if (!stone.hasTagCompound()) return 0;
        return stone.stackTagCompound.getInteger(KEY_NBT_MANA);
    }

    public static boolean isFull(ItemStack stone) {
        if (!stone.hasTagCompound()) return false;
        return stone.stackTagCompound.getInteger(KEY_NBT_MANA) >= 1000;
    }

}
