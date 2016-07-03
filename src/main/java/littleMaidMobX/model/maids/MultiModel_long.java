package littleMaidMobX.model.maids;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;public class MultiModel_long extends ModelModchuBaseSR2 {
	public ModelRenderer longhear;
	public ModelRenderer kamidome;		public MultiModel_long(StringBuilder hack) {		super(hack);	}	public MultiModel_long() {
		this(0.0F);
	}	public MultiModel_long(float f) {
		this(f, 0.0F);
	}	public MultiModel_long(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_long(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		longhear = new ModelRenderer(this, 52, 12);
		longhear.addBox(-1.5F, -9F, 7F, 3, 17, 3);
		longhear.setRotationPoint(0F, 0F, 0F);
		kamidome = new ModelRenderer(this, 46, 19);
		kamidome.addBox(-1F, -7F, 6F, 2, 2, 1);
		kamidome.setRotationPoint(0F, 0F, 0F);		kamidome.rotateAngleX = 0.2974289F;
		longhear.rotateAngleX = 0.2974289F;
		setCapsValue(null, caps_visible, Tail, false);
		setCapsValue(null, caps_visible, SideTailL, false);
		setCapsValue(null, caps_visible, SideTailR, false);
		setCapsValue(null, caps_visible, ChignonB, false);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(longhear);
		bipedHead.addChild(kamidome);
	}
}