package am2.blocks.liquid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidEssence extends Fluid {

    public FluidEssence() {
        super("liquidEssence");
        setDensity(500);
        setViscosity(500);

        FluidRegistry.registerFluid(this);
    }

}
