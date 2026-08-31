package am2;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import am2.blocks.BlocksCommonProxy;
import am2.blocks.liquid.BlockLiquidEssence;

public class AMBeeCompat {

    public static void init() {
        // this class in theory shouldn't be loaded unless the following can actually succeed
        // adds tarmaroot as a specialty for the essence bee (has no other specialties) and makes a squeezer recipe to
        // produce liquid essence out of tarma root
        // witchwood would've been more consistent, but it's too mundane and common
        magicbees.bees.BeeSpecies.AM_ESSENCE.addSpecialty(new ItemStack(BlocksCommonProxy.tarmaRoot), 0.06f);
        forestry.api.recipes.RecipeManagers.squeezerManager.addRecipe(
            10,
            new ItemStack[] { new ItemStack(BlocksCommonProxy.tarmaRoot) },
            new FluidStack(BlockLiquidEssence.liquidEssenceFluid, 1));
    }
}
