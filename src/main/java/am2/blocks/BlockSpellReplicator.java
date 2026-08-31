package am2.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import am2.blocks.tileentities.TileEntitySpellReplicator;
import am2.items.SpellBase;
import am2.texture.ResourceManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpellReplicator extends PoweredBlock {

    protected BlockSpellReplicator() {
        super(Material.glass);
        this.setStepSound(Block.soundTypeGlass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int meta, int pass) {
        return blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = ResourceManager.RegisterTexture("spellReplicator", par1IconRegister);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess par1iBlockAccess, int x, int y, int z, int l) {
        return blockIcon;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySpellReplicator();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_,
        float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        boolean toReturn = false;
        if (!(world.getTileEntity(x, y, z) instanceof TileEntitySpellReplicator)) return false;
        if (((TileEntitySpellReplicator) world.getTileEntity(x, y, z)).getStackInSlot(0) != null) {
            if (!world.isRemote) {
                toReturn = true;
                EntityItem entityitem = new EntityItem(
                    world,
                    x,
                    y,
                    z,
                    ((TileEntitySpellReplicator) world.getTileEntity(x, y, z)).getStackInSlot(0));
                float f3 = 0.05F;
                entityitem.motionX = (float) world.rand.nextGaussian() * f3;
                entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
                entityitem.motionZ = (float) world.rand.nextGaussian() * f3;
                world.spawnEntityInWorld(entityitem);
                ((TileEntitySpellReplicator) world.getTileEntity(x, y, z)).yetToConsume = -1;
                ((TileEntitySpellReplicator) world.getTileEntity(x, y, z)).setInventorySlotContents(0, null);
                List<EntityPlayerMP> players = world.getEntitiesWithinAABB(
                    EntityPlayerMP.class,
                    AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1)
                        .expand(256, 256, 256));
                for (EntityPlayerMP player1 : players) {
                    player1.playerNetServerHandler
                        .sendPacket(((TileEntitySpellReplicator) world.getTileEntity(x, y, z)).getDescriptionPacket());
                }
            }
        }
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem()
            .getItem() instanceof SpellBase) {
            ((TileEntitySpellReplicator) world.getTileEntity(x, y, z))
                .setInventorySlotContents(0, player.getCurrentEquippedItem());
            player.inventory.mainInventory[player.inventory.currentItem] = null;
            return true;
        }
        return toReturn;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
