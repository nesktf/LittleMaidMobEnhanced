package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.modchu.ModelModchuBaseOkota;
import littleMaidMobX.render.model.ModelBoxPlate;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_Petit extends ModelModchuBaseOkota {

    public ModelRenderer Prim;
    public ModelRenderer FaceR;
    public ModelRenderer FaceL;
    public ModelRenderer rightHandPlus;
    public ModelRenderer leftHandPlus;

    public MultiModel_Petit(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_Petit() {
        this(0.0F);
    }

    public MultiModel_Petit(float f) {
        this(f, 0.0F);
    }

    public MultiModel_Petit(float f, float f1) {
        this(f, f1, 64, 32);
    }

    public MultiModel_Petit(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        f1 += 0.4F;
        bipedHead = new ModelRenderer(this, 0, 0);
        bipedHead.addBox(-4.0F, -6.0F, -4.0F, 8, 8, 8, f - 2F);
        bipedHeadwear = new ModelRenderer(this, 24, 0);
        bipedHeadwear.addBox(-2.0F, 0.0F, -1.0F, 4, 5, 3, f);
        bipedBody = new ModelRenderer(this, 32, 8);
        bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 7, 4, f - 1.25F);
        bipedRightArm = new ModelRenderer(this, 48, 0);
        bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
        bipedLeftArm = new ModelRenderer(this, 56, 0);
        bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
        bipedRightLeg = new ModelRenderer(this, 33, 20);
        bipedRightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
        bipedLeftLeg = new ModelRenderer(this, 33, 20);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
        Skirt = new ModelRenderer(this, 0, 16);
        Skirt.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8, f - 1.9F);
        ChignonR = new ModelRenderer(this, 25, 19);
        ChignonR.addBox(-2.55F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
        ChignonL = new ModelRenderer(this, 25, 19);
        ChignonL.addBox(1.6F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
        ChignonB = new ModelRenderer(this, 52, 10);
        ChignonB.addBox(-1.5F, -4.2F, 0.9F, 3, 3, 2, f - 0.4F);
        Tail = new ModelRenderer(this, 46, 20);
        Tail.addBox(-1.5F, -3.9F, 1F, 3, 9, 3, f - 0.8F);
        SideTailR = new ModelRenderer(this, 59, 22);
        SideTailR.addBox(-2.8F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);
        SideTailL = new ModelRenderer(this, 59, 22);
        SideTailL.mirror = true;
        SideTailL.addBox(1.7F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);

        Prim = new ModelRenderer(this, 24, 17);
        Prim.addPlate(-1.5F, -4.7F, -2.1F, 3, 1, 0, f - 0.3F);

        FaceR = new ModelRenderer(this, 29, 16);
        FaceR.addBox(-2.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);
        FaceL = new ModelRenderer(this, 39, 16);
        FaceL.addBox(-0.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);

        eyeL = new ModelRenderer(this, 0, 16);
        eyeL.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);

        eyeR = new ModelRenderer(this, 0, 20);
        eyeR.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);

        mainFrame = new ModelRenderer(this, 0, 0);
        mainFrame.setRotationPoint(0F, 0F, 0F);

        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void actionPartsInit(float f, float f1) {
        rightArm = new ModelRenderer(this, 48, 0);
        rightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
        rightArm.setRotationPoint(-1.0F, -0.5F, 0.0F);

        rightArm2 = new ModelRenderer(this, 48, 1);
        rightArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
        rightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);

        rightHand = new ModelRenderer(this, 48, 3);
        rightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
        rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);

        rightHandPlus = new ModelRenderer(this);
        rightHandPlus.setTextureOffset(52, 5)
            .addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
        rightHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightHandPlus.rotateAngleX = 1.570796313F;

        leftArm = new ModelRenderer(this, 56, 0);
        leftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
        leftArm.setRotationPoint(-1.0F, -0.5F, 0.0F);

        leftArm2 = new ModelRenderer(this, 56, 1);
        leftArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
        leftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);

        leftHand = new ModelRenderer(this, 56, 3);
        leftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
        leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);

        leftHandPlus = new ModelRenderer(this);
        leftHandPlus.setTextureOffset(60, 5)
            .addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
        leftHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftHandPlus.rotateAngleX = 1.570796313F;

        rightLeg = new ModelRenderer(this, 32, 19);
        rightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
        rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);

        rightLeg2 = new ModelRenderer(this, 32, 23);
        rightLeg2.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
        rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);

        leftLeg = new ModelRenderer(this, 32, 19);
        leftLeg.mirror = true;
        leftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
        leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);

        leftLeg2 = new ModelRenderer(this, 32, 23);
        leftLeg2.mirror = true;
        leftLeg2.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
        leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);

        rightArmPlus = new ModelRenderer(this);
        rightArmPlus2 = new ModelRenderer(this);
        leftArmPlus = new ModelRenderer(this);
        leftArmPlus2 = new ModelRenderer(this);
        rightLegPlus = new ModelRenderer(this);
        rightLegPlus2 = new ModelRenderer(this);
        leftLegPlus = new ModelRenderer(this);
        leftLegPlus2 = new ModelRenderer(this);
        rightHand.showModel = leftHand.showModel = rightArm.showModel = leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel = leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel = rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel = rightArm2.showModel = leftArm2.showModel = rightLeg.showModel = rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = rightHandPlus.showModel = leftHandPlus.showModel = false;
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
        if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
        // 上
        SkirtTop = new ModelRenderer(this, 8, 16);
        SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXZTop, f - 1.9F);
        SkirtTop.setRotationPoint(-4.0F, -2.0F, -4.0F);

        // 前
        SkirtFront = new ModelRenderer(this, 8, 24);
        SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXYFront, f - 1.9F);
        SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);

        // 右
        SkirtRight = new ModelRenderer(this, 0, 24);
        SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeZYRight, f - 1.9F);
        SkirtRight.setRotationPoint(4.0F, 0.0F, 0.0F);

        // 左
        SkirtLeft = new ModelRenderer(this, 16, 24);
        SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeZYLeft, f - 1.9F);
        SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);

        // 後ろ
        SkirtBack = new ModelRenderer(this, 24, 24);
        SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXYBack, f - 1.9F);
        SkirtBack.setRotationPoint(0.0F, 0.0F, 8.0F);
        setCapsValue(null, caps_visible, Skirt, false);
    }

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.addChild(Prim);
        bipedHead.addChild(FaceR);
        bipedHead.addChild(FaceL);
    }

    @Override
    public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        mainFrame.setRotationPoint(0F, 0F, 0F);
        bipedHead.setRotationPoint(0.0F, 15.6F, 0.0F);
        bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedBody.setRotationPoint(0.0F, 14.8F, 0.0F);
        bipedRightArm.setRotationPoint(-1.7F, 2.0F, 0.0F);
        bipedLeftArm.setRotationPoint(1.7F, 2.0F, 0.0F);
        bipedRightLeg.setRotationPoint(-0.2F, 5.5F, 0.0F);
        bipedLeftLeg.setRotationPoint(0.2F, 5.5F, 0.0F);
        Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
        ChignonR.setRotationPoint(0.0F, 0.4F, 0.0F);
        ChignonL.setRotationPoint(0.0F, 0.4F, 0.0F);
        ChignonB.setRotationPoint(0.0F, 0.4F, 0.0F);
        Tail.setRotationPoint(0.0F, 0.4F, 0.0F);
        SideTailR.setRotationPoint(0.0F, 0.4F, 0.0F);
        SideTailL.setRotationPoint(0.0F, 0.4F, 0.0F);
        Prim.setRotationPoint(0.0F, 0.4F, 0.0F);
        FaceR.setRotationPoint(0.0F, 0.0F, 0.0F);
        FaceL.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL.setRotationPoint(-0.9F, -2.65F, 0.0F);
        eyeR.setRotationPoint(0.9F, -2.65F, 0.0F);
        Arms[0].setRotationPoint(0.5F, 2.5F, 0F);
        Arms[1].setRotationPoint(-0.5F, 2.5F, 0F);
        HeadMount.setRotationPoint(0F, 0.5F, 0F);
        HeadTop.setRotationPoint(0.0F, -4.0F, 0.0F);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
        bipedHead.rotationPointY = 1.0F;
        bipedBody.rotationPointY = 13.4F;
        bipedRightArm.rotationPointX = -1.7F;
        bipedLeftArm.rotationPointX = 1.7F;
        bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = 2.0F;
        bipedHead.rotationPointZ = 0.0F;
        boolean isSitting = false;// ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSitting);
        boolean isRiding = ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding);
        bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 5.2F;

        if (isSitting | isRiding) {
            Skirt.rotationPointY = 4.0F;
            bipedBody.rotationPointY -= isSitting ? 2.5F : 4.0F;
        } else {
            Skirt.rotationPointY = 5.0F;
        }

        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
            bipedHead.rotationPointY += 0.5F;
            bipedBody.rotationPointY -= 1.0F;
            bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.1F;
            // Skirt.rotationPointZ = 4.0F;
        } else {
            bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
        }

        boolean eyeFlag = true;
        // Object itemstack = getCapsValue(/*entityCaps,*/ caps_currentArmor, 3);
        Object itemstack = entityCaps.getCapsValue(caps_currentArmor, 3);
        if (itemstack != null) {
            int addSupport = addSupportChecks(entityCaps, itemstack, 1);
            if (addSupport == 3 | addSupport == 4) eyeFlag = false;
        }
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
            if (eyeFlag) {
                setCapsValue(entityCaps, caps_visible, eyeR, false);
                setCapsValue(entityCaps, caps_visible, FaceR, false);
            }
        } else {
            if (!eyeFlag | (eyeFlag && 0.0D > (mh_sin(f2 * 0.1F) * 0.3F + (Math.random() * 0.1F) + 0.18F))) {
                setCapsValue(entityCaps, caps_visible, eyeL, false);
                setCapsValue(entityCaps, caps_visible, eyeR, false);
                setCapsValue(entityCaps, caps_visible, FaceL, false);
                setCapsValue(entityCaps, caps_visible, FaceR, false);
            } else {
                setCapsValue(entityCaps, caps_visible, eyeL, true);
                setCapsValue(entityCaps, caps_visible, eyeR, true);
                setCapsValue(entityCaps, caps_visible, FaceL, true);
                setCapsValue(entityCaps, caps_visible, FaceR, true);
            }
        }
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) return;
        float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
        SkirtFront.rotationPointX = SkirtBack.rotationPointX = motionY * 6.0F;
        SkirtRight.rotationPointZ = SkirtLeft.rotationPointZ = motionY * 2.0F;

        SkirtFront.rotationPointY = motionY * 2.0F;
        SkirtFront.rotationPointZ = -motionY * 6.0F;
        SkirtBack.rotationPointY = motionY * 2.0F;
        SkirtBack.rotationPointZ = 8.0F + motionY * 2.0F;
        SkirtLeft.rotationPointX = 4.0F - motionY * 1.0F;

        SkirtFront.rotateAngleX = SkirtRight.rotateAngleZ = motionY;
        SkirtLeft.rotateAngleZ = SkirtBack.rotateAngleX = -motionY;

        SkirtFront.scaleX = SkirtBack.scaleX = SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.2F);
    }

    @Override
    public float getHeight(IModelCaps entityCaps) {
        return 0.9F;
    }

    @Override
    public float getWidth(IModelCaps entityCaps) {
        return 0.5F;
    }

    @Override
    public float getyOffset(IModelCaps entityCaps) {
        return 0.7F;
    }

    @Override
    public float getRidingYOffset(IModelCaps entityCaps) {
        return getyOffset(entityCaps) + 0.4F;
    }

    @Override
    public float getMountedYOffset(IModelCaps entityCaps) {
        return 1.6F;
    }

    @Override
    public String getUsingTexture() {
        return null;
    }
}
