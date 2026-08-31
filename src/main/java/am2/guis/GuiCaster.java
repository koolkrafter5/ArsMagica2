package am2.guis;

import static am2.guis.AMGuiHelper.itemRenderer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import am2.blocks.tileentities.TileEntityBlockCaster;
import am2.containers.ContainerCaster;
import am2.texture.ResourceManager;

public class GuiCaster extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation(
        "arsmagica2",
        ResourceManager.GetGuiTexturePath("casterGui.png"));
    private final TileEntityBlockCaster casterInventory;

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        this.mc.renderEngine.bindTexture(background);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int l = (this.width - this.xSize) / 2;
        int i1 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(l, i1, 0, 0, this.xSize, this.ySize);
    }

    public GuiCaster(InventoryPlayer inventoryplayer, TileEntityBlockCaster tileEntityBlockCaster) {
        super(new ContainerCaster(inventoryplayer, tileEntityBlockCaster));
        this.casterInventory = tileEntityBlockCaster;
        this.xSize = 176;
        this.ySize = 255;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        int l = (this.width - this.xSize) / 2;
        int i1 = 165;
        String essenceString = StatCollector.translateToLocal("am2.gui.castCost") + ":";
        float cost = this.casterInventory.getCastCost();
        String essenceCostString = cost >= 0.0F ? String.format("%.2f", cost) : "N/A";
        int color = cost >= 0.0F ? (cost <= this.casterInventory.getCharge() ? 30464 : 7798784) : 3355443;
        this.fontRendererObj.drawString(
            essenceString,
            this.xSize / 4 - this.fontRendererObj.getStringWidth(essenceString) / 2,
            i1 - 9,
            3355443);
        this.fontRendererObj.drawString(
            essenceCostString,
            this.xSize / 4 - this.fontRendererObj.getStringWidth(essenceCostString) / 2,
            i1,
            color);
    }

    private void drawCostString(String tip, int x, int y) {
        GL11.glDisable(32826);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        int var4 = this.fontRendererObj.getStringWidth(tip);
        int var5 = x + 12;
        int var6 = y - 12;
        byte var8 = 8;
        this.zLevel = 300.0F;
        itemRenderer.zLevel = 300.0F;
        int var9 = -267386864;
        this.drawGradientRect(var5 - 3, var6 - 4, var5 + var4 + 3, var6 - 3, var9, var9);
        this.drawGradientRect(var5 - 3, var6 + var8 + 3, var5 + var4 + 3, var6 + var8 + 4, var9, var9);
        this.drawGradientRect(var5 - 3, var6 - 3, var5 + var4 + 3, var6 + var8 + 3, var9, var9);
        this.drawGradientRect(var5 - 4, var6 - 3, var5 - 3, var6 + var8 + 3, var9, var9);
        this.drawGradientRect(var5 + var4 + 3, var6 - 3, var5 + var4 + 4, var6 + var8 + 3, var9, var9);
        int var10 = 1347420415;
        int var11 = (var10 & 16711422) >> 1 | var10 & -16777216;
        this.drawGradientRect(var5 - 3, var6 - 3 + 1, var5 - 3 + 1, var6 + var8 + 3 - 1, var10, var11);
        this.drawGradientRect(var5 + var4 + 2, var6 - 3 + 1, var5 + var4 + 3, var6 + var8 + 3 - 1, var10, var11);
        this.drawGradientRect(var5 - 3, var6 - 3, var5 + var4 + 3, var6 - 3 + 1, var10, var10);
        this.drawGradientRect(var5 - 3, var6 + var8 + 2, var5 + var4 + 3, var6 + var8 + 3, var11, var11);
        this.fontRendererObj.drawStringWithShadow(tip, var5, var6, -1);
        this.zLevel = 0.0F;
        itemRenderer.zLevel = 0.0F;
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        RenderHelper.enableStandardItemLighting();
        GL11.glEnable(32826);
    }
}
