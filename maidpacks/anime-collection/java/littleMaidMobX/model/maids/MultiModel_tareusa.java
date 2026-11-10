package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.modchu.ModelModchuBaseOkota;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_tareusa extends ModelModchuBaseOkota {

    public ModelRenderer ChignonR;
    public ModelRenderer ChignonL;
    public ModelRenderer ChignonB;
    public ModelRenderer SideTailR;
    public ModelRenderer SideTailL;
    public ModelRenderer Prim;
    public ModelRenderer UsaEL;
    public ModelRenderer UsaER;
    public ModelRenderer UsaEL1;
    public ModelRenderer UsaER1;
    public ModelRenderer Usasippo;

    public MultiModel_tareusa(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_tareusa() {
        this(0.0F);
    }

    public MultiModel_tareusa(float f) {
        this(f, 0.0F);
    }

    public MultiModel_tareusa(float f, float f1) {
        this(f, f1, 64, 32);
    }

    public MultiModel_tareusa(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        super.initModel(f, f1, false);
        Prim = new ModelRenderer(this, 24, 16);
        Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
        Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
        UsaEL = new ModelRenderer(this, 0, 0);
        UsaEL.setMirror(true);
        UsaEL.addBox(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
        UsaEL.setRotationPoint(0F, 0F, 0F);
        UsaER = new ModelRenderer(this, 0, 0);
        UsaER.addBox(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
        UsaER.setRotationPoint(0.0F, 0.0F, 0.0F);
        UsaEL1 = new ModelRenderer(this, 0, 0);
        UsaEL1.setMirror(true);
        UsaEL1.addBox(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
        UsaEL1.setRotationPoint(0F, 0F, 0F);
        UsaER1 = new ModelRenderer(this, 0, 0);
        UsaER1.addBox(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
        UsaER1.setRotationPoint(0.0F, 0.0F, 0.0F);

        Usasippo = new ModelRenderer(this, 24, 0);
        Usasippo.addBox(-1.5F, -0.1F, 0.0F, 3, 3, 3, f);
        Usasippo.setRotationPoint(0.0F, 1.5F, 0.0F);
        eyeL = new ModelRenderer(this, 32, 19);
        eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
        eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
        eyeR = new ModelRenderer(this, 42, 19);
        eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
        eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);

        Usasippo.setRotationPointZ(2.0F);
        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.removeChild(bipedHeadwear);
        bipedHead.addChild(Prim);
        bipedHead.addChild(UsaEL);
        bipedHead.addChild(UsaER);
        bipedHead.addChild(UsaEL1);
        bipedHead.addChild(UsaER1);
        bipedBody.addChild(Usasippo);
        bipedHead.addChild(eyeL);
        bipedHead.addChild(eyeR);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);

        Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.3F);
        UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.2F) * 0.1F + 0.2F;
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
            Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.5F);
        }
        if (armSwingFlag(entityCaps)) {
            Usasippo.rotateAngleY = mh_sin(f2 * 0.2F) * 0.2F;
            Usasippo.setRotateAngleX(0.0F);
        }
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
            Usasippo.setRotateAngleY(0.0F);
        }
        if (
            ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)
                && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)
        ) {
            Usasippo.setRotateAngleY(0.0F);
            Usasippo.setRotateAngleX(mh_sin(f2 * 0.3F) * 0.1F);
            UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.1F) * 0.06F + 0.2F;
        }
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
            Usasippo.setRotateAngleY(0.0F);
        }

        UsaEL.rotationPointX = UsaEL1.rotationPointX = 2.5F;
        UsaER.rotationPointX = UsaER1.rotationPointX = -2.5F;
        UsaEL.rotationPointY = UsaER.rotationPointY = UsaEL1.rotationPointY = UsaER1.rotationPointY = -8F;
        UsaEL.rotationPointZ = UsaER.rotationPointZ = UsaEL1.rotationPointZ = UsaER1.rotationPointZ = -0.5F;

        UsaEL1.rotateAngleX = UsaEL.rotateAngleX + 1.5708F;
        UsaER1.rotateAngleX = UsaER.rotateAngleX + 1.5708F;

        UsaER.rotateAngleY = UsaER1.rotateAngleY = mh_sin(f2 * 0.1F) * 0.06F - 1.920F;
        UsaEL.rotateAngleY = UsaEL1.rotateAngleY = mh_sin(f2 * 0.1F) * -0.06F + 1.920F;

    }

    @Override
    public String getUsingTexture() {
        return null;
    }
}
