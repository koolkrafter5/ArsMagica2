package am2.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicWall extends AMBlock {

    public BlockMagicWall() {
        super(Material.glass);
        this.setHardness(2.0f);
        this.setResistance(2.0f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (blockAccess.getBlock(x, y, z)
            .isOpaqueCube() || blockAccess.getBlock(x, y, z) == this) return false;
        return true;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return new ArrayList<ItemStack>();
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }
}
