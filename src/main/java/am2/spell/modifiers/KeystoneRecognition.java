package am2.spell.modifiers;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import am2.api.spell.component.interfaces.ISpellModifier;
import am2.api.spell.enums.SpellModifiers;
import am2.items.ItemsCommonProxy;

public class KeystoneRecognition implements ISpellModifier {

    @Override
    public int getID() {
        return 27;
    }

    @Override
    public Object[] getRecipeItems() {
        return new Object[] { Items.gold_nugget,
            new ItemStack(ItemsCommonProxy.rune, 1, ItemsCommonProxy.rune.META_LIME),
            new ItemStack(ItemsCommonProxy.rune, 1, ItemsCommonProxy.rune.META_RED),
            new ItemStack(ItemsCommonProxy.itemOre, 1, ItemsCommonProxy.itemOre.META_VINTEUMDUST), };
    }

    @Override
    public EnumSet<SpellModifiers> getAspectsModified() {
        return EnumSet.of(SpellModifiers.KEYSTONE_REC);
    }

    @Override
    public float getModifier(SpellModifiers type, EntityLivingBase caster, Entity target, World world,
        byte[] metadata) {
        return 1;
    }

    @Override
    public float getManaCostMultiplier(ItemStack spellStack, int stage, int quantity, EntityLivingBase caster) {
        return 1.0f;
    }

    @Override
    public byte[] getModifierMetadata(ItemStack[] matchedRecipe) {
        return null;
    }
}
