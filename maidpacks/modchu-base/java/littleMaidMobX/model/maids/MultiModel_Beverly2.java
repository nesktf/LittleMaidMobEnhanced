package littleMaidMobX.model.maids;

import littleMaidMobX.render.model.ModelRenderer;

public class MultiModel_Beverly2 extends MultiModel_Beverly3 {

    public MultiModel_Beverly2(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_Beverly2() {
        super();
    }

    public MultiModel_Beverly2(float f) {
        super(f);
    }

    public MultiModel_Beverly2(float f, float f1) {
        this(f, f1, 64, 64);
    }

    public MultiModel_Beverly2(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
    }

    @Override
    public void initModel(float f, float f1, boolean isAfterInit) {
        super.initModel(f, f1, false);
        eyeR = new ModelRenderer(this);
        eyeL = new ModelRenderer(this);
        shield = new ModelRenderer(this);
        if (isAfterInit) afterInit(f, f1);
    }

    @Override
    public void defaultAddChildSetting() {
        super.defaultAddChildSetting();
        bipedHead.removeChild(eyeR);
        bipedHead.removeChild(eyeL);
        leftArm2.removeChild(shield);
    }
}
