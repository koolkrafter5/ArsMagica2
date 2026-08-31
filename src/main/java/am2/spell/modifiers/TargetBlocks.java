package am2.spell.modifiers;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import am2.api.spell.component.interfaces.ISpellModifier;
import am2.api.spell.enums.SpellModifiers;
import am2.items.ItemsCommonProxy;

public class TargetBlocks implements ISpellModifier {

    @Override
    public int getID() {
        return 21;
    }

    @Override
    public Object[] getRecipeItems() {
        return new Object[] { new ItemStack(ItemsCommonProxy.essence, 1, ItemsCommonProxy.essence.META_EARTH),
            Items.arrow, new ItemStack(Blocks.dirt), new ItemStack(Blocks.stone), };
    }

    @Override
    public EnumSet<SpellModifiers> getAspectsModified() {
        return EnumSet.of(SpellModifiers.TARGET_BLOCKS);
    }

    @Override
    public float getModifier(SpellModifiers type, EntityLivingBase caster, Entity target, World world,
        byte[] metadata) {
        return 1;
    }

    @Override
    public float getManaCostMultiplier(ItemStack spellStack, int stage, int quantity, EntityLivingBase caster) {
        return 1.05f * quantity;
    }

    @Override
    public byte[] getModifierMetadata(ItemStack[] matchedRecipe) {
        return null;
    }
}
