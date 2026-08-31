package am2.buffs;

import net.minecraft.entity.EntityLivingBase;

public class BuffEffectPsychedelic extends BuffEffect {

    public BuffEffectPsychedelic(int duration, int amplifier) {
        super(BuffList.psychedelic.id, duration, amplifier);
    }

    @Override
    public void applyEffect(EntityLivingBase entityliving) {}

    @Override
    public void stopEffect(EntityLivingBase entityliving) {}

    @Override
    protected String spellBuffName() {
        return "Psychedelic";
    }
}
