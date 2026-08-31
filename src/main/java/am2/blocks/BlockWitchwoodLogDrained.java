package am2.blocks;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import am2.texture.ResourceManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWitchwoodLogDrained extends BlockWitchwoodLog {

    protected BlockWitchwoodLogDrained() {
        super();
        setHardness(6f);
        setResistance(10f);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return par1Random.nextInt(6) + 1;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Items.stick;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        tree_side = ResourceManager.RegisterTexture("WitchwoodDrained", par1IconRegister);
        tree_top = ResourceManager.RegisterTexture("WitchwoodTop", par1IconRegister);
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return false;
    }
}
