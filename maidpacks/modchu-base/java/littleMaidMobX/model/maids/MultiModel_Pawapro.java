package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.modchu.ModelModchuBaseOkota;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_Pawapro extends ModelModchuBaseOkota {

    public ModelRenderer tuba1;
    public ModelRenderer tuba2;
    public ModelRenderer HandR;
    public ModelRenderer HandL;
    public ModelRenderer RLeg2;
    public ModelRenderer LLeg2;
    public ModelRenderer eyeRniko;
    public ModelRenderer eyeLniko;
    public ModelRenderer eyeRFire;
    public ModelRenderer eyeLFire;
    public ModelRenderer Logo1;
    public ModelRenderer Logo2;

    public MultiModel_Pawapro(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_Pawapro() {
        this(0.0F);
    }

    public MultiModel_Pawapro(float f) {
        this(f, 0.0F);
    }

    public MultiModel_Pawapro(float f, float f1) {
        this(f, f1, 64, 32);
    }

    public MultiModel_Pawapro(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        f1 += 8F;
        bipedHead = new ModelRenderer(this, 0, 0);
        bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        tuba1 = new ModelRenderer(this, 0, 29);
        tuba1.addBox(-4F, -5F, -6F, 8, 1, 2, f);
        tuba1.setRotationPoint(0F, 0F, 0F);
        tuba2 = new ModelRenderer(this, 0, 29);
        tuba2.addBox(-3F, -4.9F, -7F, 6, 1, 2, f - 0.1F);
        tuba2.setRotationPoint(0F, 0F, 0F);
        ChignonL = new ModelRenderer(this, 0, 2);
        ChignonL.addBox(3.5F, -4.5F, -1.8F, 1, 3, 3, f);
        ChignonL.setRotationPoint(0F, 0F, 0F);
        Logo1 = new ModelRenderer(this, 24, 0);
        Logo1.addPlate(-4F, -10.5F, -7.2F, 8, 8, 0, f - 3F);
        Logo1.setRotationPoint(0F, 0F, 0F);

        bipedBody = new ModelRenderer(this, 0, 16);
        bipedBody.addBox(-3F, 0.5F, -2F, 6, 8, 4, f);
        bipedBody.setRotationPoint(0.0F, 8F, 0.0F);
        Skirt = new ModelRenderer(this, 28, 18);
        Skirt.addBox(-3F, 7.5F, -2F, 6, 2, 4, f - 0.5F);
        Skirt.setRotationPoint(0F, 0F, 0F);
        Logo2 = new ModelRenderer(this, 40, 0);
        Logo2.mirror = true;
        Logo2.addPlate(-4F, -1.5F, 0.5F, 8, 8, 0, f - 1.8F);
        Logo2.setRotationPoint(0F, 0F, 0F);

        bipedRightArm = new ModelRenderer(this, 20, 22);
        bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, f);
        bipedRightArm.setRotationPoint(-3F, 9.5F, 0.0F);
        HandR = new ModelRenderer(this, 20, 16);
        HandR.addBox(-2.5F, 4.5F, -1.5F, 3, 3, 3, f);
        HandR.setRotationPoint(0.0F, 0.0F, 0F);

        bipedLeftArm = new ModelRenderer(this, 20, 22);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, f);
        bipedLeftArm.setRotationPoint(3F, 9.5F, 0.0F);
        HandL = new ModelRenderer(this, 20, 16);
        HandL.mirror = true;
        HandL.addBox(-0.5F, 4.5F, -1.5F, 3, 3, 3, f);
        HandL.setRotationPoint(0.0F, 0.0F, 0F);

        bipedRightLeg = new ModelRenderer(this, 28, 24);
        bipedRightLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
        bipedRightLeg.setRotationPoint(-2F, 7F, 0.0F);
        RLeg2 = new ModelRenderer(this, 28, 24);
        RLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
        RLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);

        bipedLeftLeg = new ModelRenderer(this, 28, 24);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
        bipedLeftLeg.setRotationPoint(1.0F, 7F, 0.0F);
        LLeg2 = new ModelRenderer(this, 28, 24);
        LLeg2.mirror = true;
        LLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
        LLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);

        eyeR = new ModelRenderer(this, 32, 0);
        eyeR.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL = new ModelRenderer(this, 36, 0);
        eyeL.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeRniko = new ModelRenderer(this, 32, 12);
        eyeRniko.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeRniko.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeLniko = new ModelRenderer(this, 36, 12);
        eyeLniko.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeLniko.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeRFire = new ModelRenderer(this, 32, 4);
        eyeRFire.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeRFire.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeLFire = new ModelRenderer(this, 36, 4);
        eyeLFire.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
        eyeLFire.setRotationPoint(0.0F, 0.0F, 0.0F);
        mainFrame = new ModelRenderer(this, 0, 0);
        mainFrame.setRotationPoint(0F, 0F + f1, 0F);
        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {}

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.removeChild(ChignonB);
        bipedHead.removeChild(ChignonR);
        bipedHead.removeChild(Tail);
        bipedHead.removeChild(SideTailR);
        bipedHead.removeChild(SideTailL);
        ((ModelRenderer) mainFrame).removeChild(Skirt);
        // lowerBody.removeBoneChild(Skirt);
        bipedHead.addChild(tuba1);
        bipedHead.addChild(tuba2);
        bipedHead.addChild(Logo1);
        bipedBody.addChild(Skirt);
        bipedBody.addChild(Logo2);
        bipedRightArm.addChild(HandR);
        bipedLeftArm.addChild(HandL);
        bipedRightLeg.addChild(RLeg2);
        bipedLeftLeg.addChild(LLeg2);
        bipedHead.addChild(eyeRniko);
        bipedHead.addChild(eyeLniko);
        bipedHead.addChild(eyeRFire);
        bipedHead.addChild(eyeLFire);
    }

    @Override
    public void defaultSkirtFloatsAddChild() {}

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {}

    @Override
    public void actionPartsInit(float f, float f1) {
        rightArm = new ModelRenderer(this, 20, 22);
        rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
        rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
        bipedBody.addChild(rightArm);

        rightArmPlus = new ModelRenderer(this);
        // rightArmPlus.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
        // rightArmPlus.rotateAngleX = 1.570796313F;
        // rightArm.addChild(rightArmPlus);

        rightArm2 = new ModelRenderer(this, 20, 26);
        rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
        rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
        rightArm.addChild(rightArm2);

        rightArmPlus2 = new ModelRenderer(this);

        rightHand = new ModelRenderer(this);
        rightArm2.addChild(rightHand);

        leftArm = new ModelRenderer(this, 20, 22);
        leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
        leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
        bipedBody.addChild(leftArm);

        leftArmPlus = new ModelRenderer(this);
        // leftArmPlus.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
        // leftArmPlus.rotateAngleX = 1.570796313F;
        // leftArm.addChild(leftArmPlus);

        leftArm2 = new ModelRenderer(this, 20, 26);
        leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
        leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
        leftArm.addChild(leftArm2);

        leftArmPlus2 = new ModelRenderer(this);

        leftHand = new ModelRenderer(this);
        leftArm2.addChild(leftHand);

        rightLeg = new ModelRenderer(this);
        bipedBody.addChild(rightLeg);

        rightLegPlus = new ModelRenderer(this);

        rightLeg2 = new ModelRenderer(this);
        rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
        rightLeg.addChild(rightLeg2);

        rightLegPlus2 = new ModelRenderer(this);

        leftLeg = new ModelRenderer(this);
        bipedBody.addChild(leftLeg);

        leftLegPlus = new ModelRenderer(this);

        leftLeg2 = new ModelRenderer(this, 32, 23);
        leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
        leftLeg.addChild(leftLeg2);

        leftLegPlus2 = new ModelRenderer(this);

        rightHand.showModel = leftHand.showModel = rightArm.showModel = leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel = leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel = rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel = rightArm2.showModel = leftArm2.showModel = false;
        rightLeg.isHidden = rightLeg2.isHidden = leftLeg.isHidden = leftLeg2.isHidden = true;
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
        Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
        Skirt.setRotateAngle(0.0F, 0.0F, 0.0F);
        bipedHead.rotationPointY += 4.0F;
        bipedRightArm.rotationPointY += 5.0F;
        bipedLeftArm.rotationPointY += 5.0F;
        bipedRightLeg.rotationPointY += 2.0F;
        bipedLeftLeg.rotationPointY += 2.0F;
        setCapsValue(entityCaps, caps_visible, eyeLniko, false);
        setCapsValue(entityCaps, caps_visible, eyeRniko, false);
        setCapsValue(entityCaps, caps_visible, eyeLFire, false);
        setCapsValue(entityCaps, caps_visible, eyeRFire, false);

        if (
            ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)
                && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)
        ) {
            setCapsValue(entityCaps, caps_visible, eyeLniko, true);
            setCapsValue(entityCaps, caps_visible, eyeRniko, true);
        }

        boolean eyeFlag = true;
        // Object itemstack = getCapsValue(entityCaps, caps_currentArmor, 3);
        Object itemstack = entityCaps.getCapsValue(caps_currentArmor, 3);
        if (itemstack != null) {
            int addSupport = addSupportChecks(entityCaps, itemstack, 1);
            if (addSupport == 3 | addSupport == 4) eyeFlag = false;
        }
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
            if (eyeFlag) {
                setCapsValue(entityCaps, caps_visible, eyeLFire, true);
                setCapsValue(entityCaps, caps_visible, eyeRFire, true);
                setCapsValue(entityCaps, caps_visible, eyeL, false);
                setCapsValue(entityCaps, caps_visible, eyeR, false);
            }
        }
        bipedRightLeg.rotateAngleY = 0.5235988F;
        bipedLeftLeg.rotateAngleY = -0.5235988F;
    }

    @Override
    public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
        bipedHead.isHidden = !b;
        super.setArmorBipedHeadShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedBodyShowModel(IModelCaps entityCaps, boolean b) {
        super.setArmorBipedBodyShowModel(entityCaps, b);
        setCapsValue(entityCaps, caps_visible, Logo2, b);
    }

    @Override
    public String getUsingTexture() {
        return null;
    }
}
