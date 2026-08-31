package am2.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelFireGuardianEars extends ModelBiped {

    // fields
    ModelRenderer Head6;
    ModelRenderer Head4;
    ModelRenderer Head5;
    ModelRenderer Head7;

    public ModelFireGuardianEars() {
        textureWidth = 128;
        textureHeight = 128;

        Head6 = new ModelRenderer(this, 63, 65);
        Head6.addBox(4F, -1.5F, -5F, 2, 3, 6);
        Head6.setRotationPoint(0F, 0F, 0F);
        Head6.setTextureSize(128, 128);
        Head6.mirror = true;
        setRotation(Head6, 0F, 0F, 0F);
        Head4 = new ModelRenderer(this, 63, 65);
        Head4.addBox(-6F, -1.5F, -5F, 2, 3, 6);
        Head4.setRotationPoint(0F, 0F, 0F);
        Head4.setTextureSize(128, 128);
        Head4.mirror = true;
        setRotation(Head4, 0F, 0F, 0F);
        Head5 = new ModelRenderer(this, 63, 57);
        Head5.addBox(-5.5F, -1F, 1F, 1, 2, 5);
        Head5.setRotationPoint(0F, 0F, 0F);
        Head5.setTextureSize(128, 128);
        Head5.mirror = true;
        setRotation(Head5, 0F, 0F, 0F);
        Head7 = new ModelRenderer(this, 63, 57);
        Head7.addBox(4.5F, -1F, 1F, 1, 2, 5);
        Head7.setRotationPoint(0F, 0F, 0F);
        Head7.setTextureSize(128, 128);
        Head7.mirror = true;
        setRotation(Head7, 0F, 0F, 0F);
    }

    public static boolean saveValues = false;

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

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

        GL11.glPushMatrix();

        if (entity != null) {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            GL11.glTranslatef(0, -0.3f, 0);

            setRotation(Head4, bipedHead.rotateAngleX, bipedHead.rotateAngleY, bipedHead.rotateAngleZ);
            setRotation(Head5, bipedHead.rotateAngleX, bipedHead.rotateAngleY, bipedHead.rotateAngleZ);
            setRotation(Head6, bipedHead.rotateAngleX, bipedHead.rotateAngleY, bipedHead.rotateAngleZ);
            setRotation(Head7, bipedHead.rotateAngleX, bipedHead.rotateAngleY, bipedHead.rotateAngleZ);
        } else {
            setRotation(Head4, 0, 0, 0);
            setRotation(Head5, 0, 0, 0);
            setRotation(Head6, 0, 0, 0);
            setRotation(Head7, 0, 0, 0);
        }
        Head6.render(f5);
        Head4.render(f5);
        Head5.render(f5);
        Head7.render(f5);
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
