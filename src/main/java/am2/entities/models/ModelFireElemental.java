package am2.entities.models;

import net.minecraft.client.model.ModelBiped;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelFireElemental extends ModelBiped {

    public ModelFireElemental() {
        super();
        this.heldItemRight = 1;
    }
}
