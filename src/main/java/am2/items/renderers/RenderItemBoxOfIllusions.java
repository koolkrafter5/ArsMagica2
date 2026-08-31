package am2.items.renderers;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import net.tclproject.mysteriumlib.asm.fixes.MysteriumPatchesFixesMagicka;

import org.lwjgl.opengl.GL11;

import am2.blocks.tileentities.TileEntityCelestialPrism;
import am2.network.AMDataWriter;
import am2.network.AMNetHandler;
import am2.network.AMPacketIDs;
import am2.texture.ResourceManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderItemBoxOfIllusions implements IItemRenderer {

    IModelCustom model;
    ResourceLocation texture1 = new ResourceLocation("arsmagica2", "obj/boxOfIllusions.png");
    private ResourceLocation rLoc_celestial;
    private final WavefrontObject model_celestial;

    public RenderItemBoxOfIllusions() {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("arsmagica2", "obj/makeupboxjoined.obj"));
        model_celestial = (WavefrontObject) AdvancedModelLoader
            .loadModel(ResourceManager.getOBJFilePath("celestial_prism.obj"));
        rLoc_celestial = new ResourceLocation("arsmagica2", ResourceManager.getCustomBlockTexturePath("fractal.png"));
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    private void renderCelestial(TileEntityCelestialPrism tile, double d, double d1, double d2, float f) {
        Minecraft.getMinecraft().renderEngine.bindTexture(rLoc_celestial);
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslated(0.1, 0.1, 0.05);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_CULL_FACE);
        RenderHelper.disableStandardItemLighting();
        Tessellator tessellator = Tessellator.instance;

        try {
            model_celestial.renderAll();
        } catch (Throwable t) {

        }

        RenderHelper.enableStandardItemLighting();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    public static boolean doRotations = false;
    public static int rotationTick = 0;

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture1);

        if (type == EQUIPPED_FIRST_PERSON) { // yes, I know switches exist. Don't want them.
            if (cooldown > 0) cooldown--;
            GL11.glPushMatrix();
            GL11.glScalef(1f, 1f, 1f);
            GL11.glRotated(130, 0, -1, 0);
            GL11.glTranslated(-0.02, 0.5, -0.6);
            GL11.glPushMatrix();
            if (doRotations) {
                rotationTick++;
                GL11.glRotated(rotationTick * 3, 0, 1, 0);
                if (rotationTick > 120) {
                    doRotations = false;
                    rotationTick = 0;
                    setCustomRenderer();
                }
            }
            model.renderAll();
            renderCelestial(new TileEntityCelestialPrism(), 1, 1, 1, 1);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        } else if (type == INVENTORY) {
            GL11.glPushMatrix();
            GL11.glScalef(1.2f, 1.2f, 1.2f);
            GL11.glTranslated(0.02, -0.4, 0.02);
            GL11.glPushMatrix();
            model.renderAll();
            renderCelestial(new TileEntityCelestialPrism(), 1, 1, 1, 1);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        } else if (type == EQUIPPED) { // third person
            if (cooldown > 0) cooldown--;
            GL11.glPushMatrix();
            GL11.glScalef(1.1f, 1.1f, 1.1f);
            GL11.glTranslated(0.415, 0.4, 0.615);
            GL11.glPushMatrix();
            if (doRotations) {
                rotationTick++;
                GL11.glRotated(rotationTick * 3, 0, 1, 0);
                if (rotationTick > 120) {
                    doRotations = false;
                    rotationTick = 0;
                    setCustomRenderer();
                }
            }
            model.renderAll();
            renderCelestial(new TileEntityCelestialPrism(), 1, 1, 1, 1);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glScalef(1, 1, 1);
            GL11.glPushMatrix();
            model.renderAll();
            renderCelestial(new TileEntityCelestialPrism(), 1, 1, 1, 1);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }

    private int cooldown = 0; // to prevent glitches in case calling would happen twice

    private void setCustomRenderer() {
        if (cooldown > 0) return;
        if (MysteriumPatchesFixesMagicka.playerModelMap.get(Minecraft.getMinecraft().thePlayer.getCommandSenderName())
            != null) {
            MysteriumPatchesFixesMagicka.playerModelMap
                .remove(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
            return;
        }
        for (ItemStack stack : Minecraft.getMinecraft().thePlayer.inventory.mainInventory) {
            if (stack != null) {
                if (stack.getItem() == Items.spider_eye) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "spider");
                    return;
                } else if (stack.getItem() == Items.rotten_flesh) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "zombie");
                    return;
                } else if (stack.getItem() == Items.redstone) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "witch");
                    return;
                } else if (stack.getItem() == Items.snowball) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "snowman");
                    return;
                } else if (stack.getItem() == Items.gunpowder) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "creeper");
                    return;
                } else if (stack.getItem() == Items.feather) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "chicken");
                    return;
                } else if (stack.getItem() == Items.leather) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "cow");
                    return;
                } else if (stack.getItem() == Items.ender_eye) {
                    MysteriumPatchesFixesMagicka.playerModelMap
                        .put(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), "ender");
                    return;
                } else if (stack.getItem() == Items.emerald) {
                    MysteriumPatchesFixesMagicka.playerModelMap.put(
                        Minecraft.getMinecraft().thePlayer.getCommandSenderName(),
                        "maid" + Minecraft.getMinecraft().theWorld.rand.nextInt(8));
                    return;
                }
            }
        }
        cooldown = 80;
        AMDataWriter writer = new AMDataWriter();
        writer.add(MysteriumPatchesFixesMagicka.playerModelMap.size());
        for (Map.Entry<String, String> entry : MysteriumPatchesFixesMagicka.playerModelMap.entrySet()) {
            writer.add(entry.getKey());
            writer.add(entry.getValue());
        }
        AMNetHandler.INSTANCE.sendPacketToServer(AMPacketIDs.SYNCMAPTOSERVER, writer.generate());
    }

}
