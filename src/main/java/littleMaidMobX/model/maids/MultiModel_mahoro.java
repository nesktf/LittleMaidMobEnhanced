package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.modchu.ModelModchuBaseMulti;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_mahoro extends ModelModchuBaseMulti {

    public ModelRenderer Prim;
    public ModelRenderer RibonUR;
    public ModelRenderer RibonUL;
    public ModelRenderer RibonBR;
    public ModelRenderer RibonBL;
    public ModelRenderer SensorR;
    public ModelRenderer SensorL;
    public ModelRenderer DropTail;
    public ModelRenderer ShoulderR;
    public ModelRenderer ShoulderL;
    public ModelRenderer eyeR;
    public ModelRenderer eyeL;

    public MultiModel_mahoro(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_mahoro() {
        this(0.0F);
    }

    public MultiModel_mahoro(float f) {
        this(f, 0.0F);
    }

    public MultiModel_mahoro(float f, float f1) {
        this(f, f1, 64, 32);
    }

    public MultiModel_mahoro(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        super.initModel(f, f1, false);
        f1 += 8F;
        Prim = new ModelRenderer(this, 0, 1);
        Prim.addBox(0F, -3F, -2F, 1, 6, 1, f);
        Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
        Prim.setRotateAngleDegZ(90F); // deg
        Prim.rotationPointY = -9F;

        RibonUR = new ModelRenderer(this, 42, 19);
        RibonUR.addBox(-4.5F, -2F, 4F, 4, 2, 1, f);
        RibonUR.setRotationPoint(0.0F, 0.0F, 0.0F);
        RibonUL = new ModelRenderer(this, 42, 19);
        RibonUL.setMirror(true);
        RibonUL.addBox(0.5F, -2F, 4F, 4, 2, 1, f);
        RibonUL.setRotationPoint(0.0F, 0.0F, 0.0F);
        RibonBR = new ModelRenderer(this, 42, 19);
        RibonBR.addBox(-4.5F, -2F, 3.5F, 4, 2, 1, f);
        RibonBR.setRotationPoint(0.0F, 0.0F, 0.0F);
        // this requires a lot of changes.. see ModchuModel_ModelRendererMaster parentModel field access hierachy
        // RibonBR.setParentModel(bipedHead);

        RibonBR.rotateAngleZ = -70F / 180F * 3.141526F;
        RibonBL = new ModelRenderer(this, 42, 19);
        RibonBL.setMirror(true);
        RibonBL.addBox(0.5F, -2F, 3.5F, 4, 2, 1, f);
        RibonBL.setRotationPoint(0.0F, 0.0F, 0.0F);
        RibonBL.rotateAngleZ = 70F / 180F * 3.141526F;

        SensorR = new ModelRenderer(this, 24, 16);
        SensorR.addBox(-2.5F, -0.5F, -2F, 3, 1, 1, f);
        SensorR.setRotationPoint(0.0F, 0.0F, 0.0F);
        SensorR.rotateAngleZ = -10F / 180F * 3.141526F;
        SensorR.rotationPointY = -3.5F;
        SensorR.rotationPointX = -4.0F;
        SensorL = new ModelRenderer(this, 24, 16);
        SensorL.setMirror(true);
        SensorL.addBox(-0.5F, -0.5F, -2F, 3, 1, 1, f);
        SensorL.setRotationPoint(0.0F, 0.0F, 0.0F);
        SensorL.rotateAngleZ = 10F / 180F * 3.141526F;
        SensorL.rotationPointY = -3.5F;
        SensorL.rotationPointX = 4.0F;

        DropTail = new ModelRenderer(this, 46, 22);
        DropTail.addBox(-1.0F, -0.5F, 0.0F, 2, 9, 1, f);
        DropTail.setRotationPoint(0.0F, 0.0F, 0.0F);
        DropTail.rotationPointY = -1.0F;
        DropTail.rotationPointZ = 3.7F;

        ShoulderR = new ModelRenderer(this, 52, 18);
        ShoulderR.addBox(-5.0F, -0.5F, -2F, 2, 3, 4, f);
        ShoulderR.setRotationPoint(0.0F, -3.0F, 0.0F);
        ShoulderL = new ModelRenderer(this, 52, 25);
        ShoulderL.addBox(3.0F, -0.5F, -2F, 2, 3, 4, f);
        ShoulderL.setRotationPoint(0.0F, -3.0F, 0.0F);

        // 目
        eyeR = new ModelRenderer(this, 0, 16);
        eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
        eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL = new ModelRenderer(this, 4, 16);
        eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
        eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.removeChild(Tail);
        bipedHead.removeChild(SideTailR);
        bipedHead.removeChild(SideTailL);
        bipedHead.addChild(Prim);
        bipedHead.addChild(RibonUR);
        bipedHead.addChild(RibonUL);
        bipedHead.addChild(RibonBR);
        bipedHead.addChild(RibonBL);
        bipedHead.addChild(SensorR);
        bipedHead.addChild(SensorL);
        bipedHead.addChild(DropTail);
        bipedBody.addChild(ShoulderR);
        bipedBody.addChild(ShoulderL);
        bipedHead.addChild(eyeR);
        bipedHead.addChild(eyeL);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);

        // 特殊モーション
        SensorR.rotateAngleZ = bipedRightArm.rotateAngleX * 0.3F + mh_sin(f2 * 0.067F) * 0.1F
            + (-10F / 180F * 3.141526F);
        SensorL.rotateAngleZ = -SensorR.rotateAngleZ;
        // DropTail.rotateAngleX = 10F / 180F * 3.141526F - bipedHead.rotateAngleX;

        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
            eyeL.showModel = true;
            eyeR.showModel = false;
        } else {
            if (0.0D > (mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
                eyeL.showModel = true;
                eyeR.showModel = true;
            } else {
                eyeL.showModel = false;
                eyeR.showModel = false;
            }
        }
    }

    @Override
    public String getUsingTexture() {
        return null;
    }
}
