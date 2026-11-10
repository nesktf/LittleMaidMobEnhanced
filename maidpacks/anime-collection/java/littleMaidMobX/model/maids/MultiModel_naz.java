package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.modchu.ModelModchuBaseOkota;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_naz extends ModelModchuBaseOkota {

    public ModelRenderer CatEL;
    public ModelRenderer CatER;
    public ModelRenderer CatTail;
    public ModelRenderer Prim;

    public MultiModel_naz(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_naz() {
        this(0.0F);
    }

    public MultiModel_naz(float f) {
        this(f, 0.0F);
    }

    public MultiModel_naz(float f, float f1) {
        this(f, f1, 64, 32);
    }

    public MultiModel_naz(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        super.initModel(f, f1, false);
        CatEL = new ModelRenderer(this, 0, 4);
        CatEL.addBox(2.0F, -11F, -2F, 3, 3, 1, f);
        CatEL.setRotationPoint(0.0F, 0.0F, 0.0F);
        CatER = new ModelRenderer(this, 0, 0);
        CatER.addBox(-5F, -11F, -2F, 3, 3, 1, f);
        CatER.setRotationPoint(0.0F, 0.0F, 0.0F);
        CatTail = new ModelRenderer(this, 0, 16);
        CatTail.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 1, f);
        CatTail.setRotationPoint(0.0F, 4.0F, 2.0F);
        Prim = new ModelRenderer(this, 24, 16);
        Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
        Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyeL = new ModelRenderer(this, 58, 16);
        eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
        eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
        eyeR = new ModelRenderer(this, 60, 16);
        eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
        eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);
        CatTail.setRotateAngleX(-4.363323F);
        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.addChild(CatEL);
        bipedHead.addChild(CatER);
        bipedBody.addChild(CatTail);
        bipedHead.addChild(Prim);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
        CatTail.setRotateAngleX(mh_sin(f * 0.6662F) * 0.5F - 4.363323F);

        if (
            ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)
                && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)
        ) {
            CatTail.setRotateAngleX(mh_sin(f2 * 0.6662F) * 0.1F - 4.363323F);
        }
    }

    @Override
    public String getUsingTexture() {
        return null;
    }
}
