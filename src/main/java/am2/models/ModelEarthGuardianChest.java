package am2.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

public class ModelEarthGuardianChest extends ModelBiped {

    // fields
    ModelRenderer LeftShoulder1;
    ModelRenderer Shoulders;
    ModelRenderer LeftShoulder2;
    ModelRenderer RightShoulder2;
    ModelRenderer RightShoulder1;

    public ModelEarthGuardianChest() {
        textureWidth = 64;
        textureHeight = 64;

        LeftShoulder1 = new ModelRenderer(this, 0, 31);
        LeftShoulder1.addBox(2F, -5F, -4F, 8, 8, 8);
        LeftShoulder1.setRotationPoint(2.5F, 0F, 0F);
        LeftShoulder1.setTextureSize(64, 64);
        LeftShoulder1.mirror = true;
        setRotation(LeftShoulder1, 0F, 0F, 0F);
        LeftShoulder1.mirror = false;
        Shoulders = new ModelRenderer(this, 0, 21);
        Shoulders.addBox(-5F, -3F, -3F, 10, 3, 6);
        Shoulders.setRotationPoint(0F, 0F, 0F);
        Shoulders.setTextureSize(64, 64);
        Shoulders.mirror = true;
        setRotation(Shoulders, 0F, 0F, 0F);
        LeftShoulder2 = new ModelRenderer(this, 0, 48);
        LeftShoulder2.addBox(3F, -4F, -5F, 6, 6, 10);
        LeftShoulder2.setRotationPoint(2.5F, 0F, 0F);
        LeftShoulder2.setTextureSize(64, 64);
        LeftShoulder2.mirror = true;
        setRotation(LeftShoulder2, 0F, 0F, 0F);
        RightShoulder2 = new ModelRenderer(this, 0, 48);
        RightShoulder2.addBox(-9F, -4F, -5F, 6, 6, 10);
        RightShoulder2.setRotationPoint(-2.5F, 0F, 0F);
        RightShoulder2.setTextureSize(64, 64);
        RightShoulder2.mirror = true;
        setRotation(RightShoulder2, 0F, 0F, 0F);
        RightShoulder2.mirror = false;
        bipedBody = new ModelRenderer(this, 0, 31);
        bipedBody.addBox(-10F, 0F, -4F, 7, 8, 8);
        bipedBody.setRotationPoint(6.5F, 0F, 0F);
        bipedBody.setTextureSize(64, 64);
        bipedBody.mirror = true;
        setRotation(bipedBody, 0F, 0F, 0F);
        RightShoulder1 = new ModelRenderer(this, 0, 31);
        RightShoulder1.addBox(-10F, -5F, -4F, 8, 8, 8);
        RightShoulder1.setRotationPoint(-2.5F, 0F, 0F);
        RightShoulder1.setTextureSize(64, 64);
        RightShoulder1.mirror = true;
        setRotation(RightShoulder1, 0F, 0F, 0F);

        bipedRightArm = new ModelRenderer(this, 33, 18);
        bipedRightArm.addBox(-2.5F, 2F, -1F, 4, 8, 4);
        bipedRightArm.setRotationPoint(-2.5F, 0F, 0F);
        bipedRightArm.setTextureSize(64, 64);
        bipedRightArm.mirror = true;
        setRotation(bipedRightArm, 0F, 0F, 0F);
        bipedRightArm.mirror = false;

        bipedLeftArm = new ModelRenderer(this, 33, 18);
        bipedLeftArm.addBox(-1.5F, 2F, -2F, 4, 8, 4);
        bipedLeftArm.setRotationPoint(2.5F, 0F, 0F);
        bipedLeftArm.setTextureSize(64, 64);
        bipedLeftArm.mirror = true;
        setRotation(bipedLeftArm, 0F, 0F, 0F);
    }

    public static boolean saveValues = false;

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        LeftShoulder1.render(f5);
        // Shoulders.render(f5);
        LeftShoulder2.render(f5);
        RightShoulder2.render(f5);
        RightShoulder1.render(f5);

        GL11.glPushMatrix();
        GL11.glScalef(1.4f, 1.3f, 0.8f);
        GL11.glTranslatef(0, -0.01f, 0);
        bipedBody.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glScalef(1.4f, 1.3f, 1.4f);

        if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getHeldItem() == null)
            bipedRightArm.render(f5);
        bipedLeftArm.render(f5);
        GL11.glPopMatrix();
    }

    public void renderArms(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float rotateAngleX1 = super.bipedHead.rotateAngleX;
        float rotateAngleY1 = super.bipedHead.rotateAngleY;
        float rotateAngleZ1 = super.bipedHead.rotateAngleZ;
        float rotatePointX1 = super.bipedHead.rotationPointX;
        float rotatePointY1 = super.bipedHead.rotationPointY;
        float rotatePointZ1 = super.bipedHead.rotationPointZ;

        float rotateAngleX2 = super.bipedBody.rotateAngleX;
        float rotateAngleY2 = super.bipedBody.rotateAngleY;
        float rotateAngleZ2 = super.bipedBody.rotateAngleZ;
        float rotatePointX2 = super.bipedBody.rotationPointX;
        float rotatePointY2 = super.bipedBody.rotationPointY;
        float rotatePointZ2 = super.bipedBody.rotationPointZ;

        float rotateAngleX3 = super.bipedRightArm.rotateAngleX;
        float rotateAngleY3 = super.bipedRightArm.rotateAngleY;
        float rotateAngleZ3 = super.bipedRightArm.rotateAngleZ;
        float rotatePointX3 = super.bipedRightArm.rotationPointX;
        float rotatePointY3 = super.bipedRightArm.rotationPointY;
        float rotatePointZ3 = super.bipedRightArm.rotationPointZ;

        float rotateAngleX4 = super.bipedLeftArm.rotateAngleX;
        float rotateAngleY4 = super.bipedLeftArm.rotateAngleY;
        float rotateAngleZ4 = super.bipedLeftArm.rotateAngleZ;
        float rotatePointX4 = super.bipedLeftArm.rotationPointX;
        float rotatePointY4 = super.bipedLeftArm.rotationPointY;
        float rotatePointZ4 = super.bipedLeftArm.rotationPointZ;

        float rotateAngleX5 = super.bipedLeftLeg.rotateAngleX;
        float rotateAngleY5 = super.bipedLeftLeg.rotateAngleY;
        float rotateAngleZ5 = super.bipedLeftLeg.rotateAngleZ;
        float rotatePointX5 = super.bipedLeftLeg.rotationPointX;
        float rotatePointY5 = super.bipedLeftLeg.rotationPointY;
        float rotatePointZ5 = super.bipedLeftLeg.rotationPointZ;

        float rotateAngleX6 = super.bipedRightLeg.rotateAngleX;
        float rotateAngleY6 = super.bipedRightLeg.rotateAngleY;
        float rotateAngleZ6 = super.bipedRightLeg.rotateAngleZ;
        float rotatePointX6 = super.bipedRightLeg.rotationPointX;
        float rotatePointY6 = super.bipedRightLeg.rotationPointY;
        float rotatePointZ6 = super.bipedRightLeg.rotationPointZ;

        float rotateAngleX7 = super.bipedHeadwear.rotateAngleX;
        float rotateAngleY7 = super.bipedHeadwear.rotateAngleY;
        float rotateAngleZ7 = super.bipedHeadwear.rotateAngleZ;
        float rotatePointX7 = super.bipedHeadwear.rotationPointX;
        float rotatePointY7 = super.bipedHeadwear.rotationPointY;
        float rotatePointZ7 = super.bipedHeadwear.rotationPointZ;
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GL11.glPushMatrix();
        GL11.glScalef(1.05f, 1.3f, 1.05f);
        GL11.glTranslated(0, 0, 1.5);
        bipedRightArm.render(f5);
        GL11.glTranslated(0, 0, -3);
        bipedLeftArm.render(f5);
        GL11.glTranslated(1, 0, 1.5);
        bipedLeftArm.render(f5);
        GL11.glTranslated(-3, 0, 0);
        bipedLeftArm.render(f5);
        GL11.glPopMatrix();

        if (saveValues) {
            saveValues = false;
            super.bipedHead.rotateAngleX = rotateAngleX1;
            super.bipedHead.rotateAngleY = rotateAngleY1;
            super.bipedHead.rotateAngleZ = rotateAngleZ1;
            super.bipedHead.rotationPointX = rotatePointX1;
            super.bipedHead.rotationPointY = rotatePointY1;
            super.bipedHead.rotationPointZ = rotatePointZ1;

            super.bipedBody.rotateAngleX = rotateAngleX2;
            super.bipedBody.rotateAngleY = rotateAngleY2;
            super.bipedBody.rotateAngleZ = rotateAngleZ2;
            super.bipedBody.rotationPointX = rotatePointX2;
            super.bipedBody.rotationPointY = rotatePointY2;
            super.bipedBody.rotationPointZ = rotatePointZ2;

            super.bipedRightArm.rotateAngleX = rotateAngleX3;
            super.bipedRightArm.rotateAngleY = rotateAngleY3;
            super.bipedRightArm.rotateAngleZ = rotateAngleZ3;
            super.bipedRightArm.rotationPointX = rotatePointX3;
            super.bipedRightArm.rotationPointY = rotatePointY3;
            super.bipedRightArm.rotationPointZ = rotatePointZ3;

            super.bipedLeftArm.rotateAngleX = rotateAngleX4;
            super.bipedLeftArm.rotateAngleY = rotateAngleY4;
            super.bipedLeftArm.rotateAngleZ = rotateAngleZ4;
            super.bipedLeftArm.rotationPointX = rotatePointX4;
            super.bipedLeftArm.rotationPointY = rotatePointY4;
            super.bipedLeftArm.rotationPointZ = rotatePointZ4;

            super.bipedLeftLeg.rotateAngleX = rotateAngleX5;
            super.bipedLeftLeg.rotateAngleY = rotateAngleY5;
            super.bipedLeftLeg.rotateAngleZ = rotateAngleZ5;
            super.bipedLeftLeg.rotationPointX = rotatePointX5;
            super.bipedLeftLeg.rotationPointY = rotatePointY5;
            super.bipedLeftLeg.rotationPointZ = rotatePointZ5;

            super.bipedRightLeg.rotateAngleX = rotateAngleX6;
            super.bipedRightLeg.rotateAngleY = rotateAngleY6;
            super.bipedRightLeg.rotateAngleZ = rotateAngleZ6;
            super.bipedRightLeg.rotationPointX = rotatePointX6;
            super.bipedRightLeg.rotationPointY = rotatePointY6;
            super.bipedRightLeg.rotationPointZ = rotatePointZ6;

            super.bipedHeadwear.rotateAngleX = rotateAngleX7;
            super.bipedHeadwear.rotateAngleY = rotateAngleY7;
            super.bipedHeadwear.rotateAngleZ = rotateAngleZ7;
            super.bipedHeadwear.rotationPointX = rotatePointX7;
            super.bipedHeadwear.rotationPointY = rotatePointY7;
            super.bipedHeadwear.rotationPointZ = rotatePointZ7;
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
