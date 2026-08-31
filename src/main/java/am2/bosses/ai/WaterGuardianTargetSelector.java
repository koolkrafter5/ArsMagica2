package am2.bosses.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;

import am2.bosses.EntityWaterGuardian;

public class WaterGuardianTargetSelector implements IEntitySelector {

    @Override
    public boolean isEntityApplicable(Entity entity) {
        return !(entity instanceof EntityWaterGuardian);
    }

}
