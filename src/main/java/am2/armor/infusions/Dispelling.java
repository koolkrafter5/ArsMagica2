package am2.armor.infusions;

import java.util.ArrayList;
import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import am2.api.items.armor.IArmorImbuement;
import am2.api.items.armor.ImbuementApplicationTypes;
import am2.api.items.armor.ImbuementTiers;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class Dispelling implements IArmorImbuement {

    @Override
    public String getID() {
        return "dispel";
    }

    @Override
    public int getIconIndex() {
        return 25;
    }

    @Override
    public ImbuementTiers getTier() {
        return ImbuementTiers.FOURTH;
    }

    @Override
    public EnumSet<ImbuementApplicationTypes> getApplicationTypes() {
        return EnumSet.of(ImbuementApplicationTypes.ON_TICK);
    }

    @Override
    public boolean applyEffect(EntityPlayer player, World world, ItemStack stack, ImbuementApplicationTypes matchedType,
        Object... params) {
        if (player.getActivePotionEffects()
            .size() == 0) return false;

        if (player.worldObj.isRemote) return false;

        ArrayList<Integer> effectsToRemove = new ArrayList<Integer>();
        Object[] safeCopy = player.getActivePotionEffects()
            .toArray();
        for (Object o : safeCopy) {
            PotionEffect pe = (PotionEffect) o;
            boolean badEffect;
            if (ReflectionHelper
                .getPrivateValue(Potion.class, Potion.potionTypes[pe.getPotionID()], 35) instanceof Boolean) {
                badEffect = ReflectionHelper.getPrivateValue(Potion.class, Potion.potionTypes[pe.getPotionID()], 35);
            } else {
                badEffect = true; // just get rid of all potion effects if can't determine if it's good or bad, hotfix
                                  // for crash
            }
            if (pe.getIsAmbient() || !badEffect) continue;
            effectsToRemove.add(pe.getPotionID());
        }

        for (Integer i : effectsToRemove) {
            player.removePotionEffect(i);
        }
        return effectsToRemove.size() > 0;
    }

    @Override
    public int[] getValidSlots() {
        return new int[] { ImbuementRegistry.SLOT_LEGS };
    }

    @Override
    public boolean canApplyOnCooldown() {
        return false;
    }

    @Override
    public int getCooldown() {
        return 600;
    }

    @Override
    public int getArmorDamage() {
        return 75;
    }
}
