package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.modchu.ModelModchuBaseSR2;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_Aokise extends ModelModchuBaseSR2 {

    public ModelRenderer sideR;
    public ModelRenderer sideL;
    public ModelRenderer mune;
    public ModelRenderer long1;
    public ModelRenderer long2;
    public ModelRenderer longSL1;
    public ModelRenderer longSL2;
    public ModelRenderer longSL3;
    public ModelRenderer longSR1;
    public ModelRenderer longSR2;
    public ModelRenderer longSR3;
    public ModelRenderer kamidome1;
    public ModelRenderer ribon1;
    public ModelRenderer ribon2;
    public ModelRenderer ribon3;
    public ModelRenderer ribon4;
    // public ModchuModel_ModelRenderer akuse1;
    // public ModchuModel_ModelRenderer akuse2;
    public ModelRenderer kataR;
    public ModelRenderer kataL;

    public MultiModel_Aokise(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_Aokise() {
        this(0.0F);
    }

    public MultiModel_Aokise(float f) {
        this(f, 0.0F);
    }

    public MultiModel_Aokise(float f, float f1) {
        this(f, f1, 64, 64);
    }

    public MultiModel_Aokise(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        textureWidth = 64;
        textureHeight = 64;
        f1 += 8F;
        bipedCloak = new ModelRenderer(this, 0, 0);
        bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, f);
        bipedCloak.showModel = false;
        bipedEars = new ModelRenderer(this, 0, 16);
        bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, f);
        bipedEars.showModel = false;
        bipedHead = new ModelRenderer(this, 0, 0);
        bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHeadwear = new ModelRenderer(this, 24, 0);
        bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
        bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedBody = new ModelRenderer(this, 32, 8);
        bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
        bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
        bipedRightArm = new ModelRenderer(this, 48, 0);
        bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        bipedRightArm.setRotationPoint(-3.0F, -3.5F + f1, 0.0F);
        bipedLeftArm = new ModelRenderer(this, 56, 0);
        bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        bipedLeftArm.setRotationPoint(3.0F, -3.5F + f1, 0.0F);
        bipedRightLeg = new ModelRenderer(this, 32, 19);
        bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
        bipedRightLeg.setRotationPoint(-1.5F, 7F + f1, 0.0F);
        bipedLeftLeg = new ModelRenderer(this, 32, 19);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
        bipedLeftLeg.setRotationPoint(1.5F, 7F + f1, 0.0F);
        Skirt = new ModelRenderer(this, 0, 16);
        Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
        Skirt.setRotationPoint(0.0F, -4F + f1, 0.0F);
        ChignonR = new ModelRenderer(this, 24, 18);
        ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
        ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
        ChignonL = new ModelRenderer(this, 24, 18);
        ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
        ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
        ChignonB = new ModelRenderer(this, 52, 10);
        ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
        ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
        Tail = new ModelRenderer(this, 46, 20);
        Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
        Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
        SideTailR = new ModelRenderer(this, 58, 21);
        SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
        SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
        SideTailL = new ModelRenderer(this, 58, 21);
        SideTailL.mirror = true;
        SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
        SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);

        eyeR = new ModelRenderer(this, 32, 19);
        eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
        eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL = new ModelRenderer(this, 42, 19);
        eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
        eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);

        sideR = new ModelRenderer(this, 0, 35);
        sideR.addBox(-3.2F, -0.8F, -1.5F, 1, 6, 3, f);
        sideR.setRotationPoint(0F, 3.5F, 0F);

        sideL = new ModelRenderer(this, 0, 35);
        sideL.mirror = true;
        sideL.addBox(2.2F, -0.8F, -1.5F, 1, 6, 3, f);
        sideL.setRotationPoint(0F, 3.5F, 0F);

        mune = new ModelRenderer(this, 0, 33);
        mune.addBox(-2F, -0.4F, -2.8F, 4, 1, 1);
        mune.setRotationPoint(0F, -3F, 0F);

        long1 = new ModelRenderer(this, 0, 44);
        long1.addBox(-3F, -6F, 4.2F, 6, 11, 1);
        long1.setRotationPoint(0F, 0F, 0F);

        long2 = new ModelRenderer(this, 0, 56);
        long2.addBox(-3F, 4F, 5F, 6, 7, 1);
        long2.setRotationPoint(0F, 0F, 0F);

        longSL1 = new ModelRenderer(this, 14, 35);
        longSL1.addBox(-2F, -5F, 4.5F, 2, 11, 1);
        longSL1.setRotationPoint(0F, 0F, 0F);

        longSL2 = new ModelRenderer(this, 8, 37);
        longSL2.addBox(-2.9F, 3.5F, 5.5F, 2, 6, 1);
        longSL2.setRotationPoint(0F, 0F, 0F);

        longSL3 = new ModelRenderer(this, 14, 45);
        longSL3.addBox(3.5F, 0F, 1.6F, 1, 10, 2);
        longSL3.setRotationPoint(0F, 0F, 0F);

        longSR1 = new ModelRenderer(this, 14, 35);
        longSR1.mirror = true;
        longSR1.addBox(0F, -5F, 4.5F, 2, 11, 1);
        longSR1.setRotationPoint(0F, 0F, 0F);

        longSR2 = new ModelRenderer(this, 8, 37);
        longSR2.mirror = true;
        longSR2.addBox(1F, 3.5F, 5.5F, 2, 6, 1);
        longSR2.setRotationPoint(0F, 0F, 0F);

        longSR3 = new ModelRenderer(this, 14, 45);
        longSR3.mirror = true;
        longSR3.addBox(-4.5F, 0F, 1.6F, 1, 10, 2);
        longSR3.setRotationPoint(0F, 0F, 0F);

        kamidome1 = new ModelRenderer(this, 8, 35);
        kamidome1.addBox(-0.5F, -5F, 5F, 1, 1, 1);
        kamidome1.setRotationPoint(0F, 0F, 0F);

        ribon1 = new ModelRenderer(this, 10, 33);
        ribon1.addBox(-2.5F, -4.7F, 4.8F, 2, 1, 1);
        ribon1.setRotationPoint(0F, 0F, 0F);

        ribon2 = new ModelRenderer(this, 10, 33);
        ribon2.addBox(0.5F, -4.7F, 4.8F, 2, 1, 1);
        ribon2.setRotationPoint(0F, 0F, 0F);

        ribon3 = new ModelRenderer(this, 0, 16);
        ribon3.addBox(2F, -3.5F, 4.8F, 2, 7, 1);
        ribon3.setRotationPoint(0F, 0F, 0F);

        ribon4 = new ModelRenderer(this, 0, 16);
        ribon4.mirror = true;
        ribon4.addBox(-4F, -3.5F, 4.8F, 2, 7, 1);
        ribon4.setRotationPoint(0F, 0F, 0F);

        mainFrame = new ModelRenderer(this, 0, 0);
        mainFrame.setRotationPoint(0F, 0F + f1, 0F);

        sideR.rotateAngleZ = 0.2094395F;
        sideL.rotateAngleZ = longSL3.rotateAngleY = -0.1745329F;
        long1.rotateAngleX = ribon1.rotateAngleX = ribon2.rotateAngleX = ribon3.rotateAngleX = ribon4.rotateAngleX = kamidome1.rotateAngleX = 0.2443461F;
        long2.rotateAngleX = 0.0872665F;
        longSL1.rotateAngleX = longSL1.rotateAngleZ = longSL3.rotateAngleX = longSR1.rotateAngleX = longSR3.rotateAngleX = longSR3.rotateAngleY = 0.1745329F;
        longSL1.rotateAngleY = longSL2.rotateAngleY = ((float) Math.PI / 4F);
        longSL3.rotateAngleZ = -0.1570796F;
        longSR1.rotateAngleY = longSR2.rotateAngleY = -((float) Math.PI / 4F);
        longSR1.rotateAngleZ = -0.185895F;
        longSR3.rotateAngleZ = 0.1570796F;
        mune.rotateAngleX = ribon1.rotateAngleZ = 0.5235988F;
        ribon2.rotateAngleZ = -0.5235988F;
        ribon3.rotateAngleZ = -0.4363323F;
        ribon4.rotateAngleZ = 0.4363323F;

        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {}

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.addChild(eyeR);
        bipedHead.addChild(eyeL);
        bipedHead.addChild(long1);
        bipedHead.addChild(long2);
        bipedHead.addChild(longSL1);
        bipedHead.addChild(longSL2);
        bipedHead.addChild(longSL3);
        bipedHead.addChild(longSR1);
        bipedHead.addChild(longSR2);
        bipedHead.addChild(longSR3);
        bipedHead.addChild(kamidome1);
        bipedHead.addChild(ribon1);
        bipedHead.addChild(ribon2);
        bipedHead.addChild(ribon3);
        bipedHead.addChild(ribon4);
        bipedBody.addChild(sideR);
        bipedBody.addChild(sideL);
        bipedBody.addChild(mune);
    }

    @Override
    public void defaultSkirtFloatsAddChild() {}

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {}
}
