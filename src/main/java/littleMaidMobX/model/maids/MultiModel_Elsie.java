package littleMaidMobX.model.maids;import littleMaidMobX.util.helper.Helper;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseMulti;import littleMaidMobX.render.model.ModelRenderer;public class MultiModel_Elsie extends ModelModchuBaseMulti {	public ModelRenderer RightSkirt;
	public ModelRenderer LeftSkirt;
	public ModelRenderer bipedHeadwearB;
	public ModelRenderer SkirtTopL;
	public ModelRenderer SkirtFrontL;
	public ModelRenderer SkirtLeftL;
	public ModelRenderer SkirtBackL;
	public ModelRenderer SkirtRightL;		public MultiModel_Elsie(StringBuilder hack) {		super(hack);	}	public MultiModel_Elsie() {
		this(0.0F);
	}	public MultiModel_Elsie(float f) {
		this(f, 0.0F);
	}	public MultiModel_Elsie(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Elsie(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 4.0F, 0.0F);
		bipedHeadwearB = new ModelRenderer(this, 42, 0);
		bipedHeadwearB.addBox(-4F, -1.5F, 1.0F, 8, 6, 3, f);
		bipedHeadwearB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new ModelRenderer(this, 36, 20);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 4, f);
		bipedBody.setRotationPoint(0.0F, 4.0F, 0.0F);
		bipedRightArm = new ModelRenderer(this, 56, 20);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 20, "bipedLeftArm");
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.0F, 0.0F, -1F, 2, 10, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 0, 16);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 8F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 0, 16);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 8F, 0.0F);
		Skirt = new ModelRenderer(this, 36, 10);
		Skirt.addBox(-4F, 0.0F, -3F, 8, 4, 6, f);
		Skirt.setRotationPoint(0.0F, 6.0F, 0.0F);
		RightSkirt = new ModelRenderer(this, 14, 16);
		RightSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
		RightSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSkirt = new ModelRenderer(this, 14, 16);
		LeftSkirt.mirror = true;
		LeftSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
		LeftSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonR = new ModelRenderer(this, 24, 2);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new ModelRenderer(this, 24, 2);
		ChignonL.mirror = true;
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModelRenderer(this, 32, 0);
		SideTailR.addBox(-6.5F, -6.8F, 0.9F, 2, 13, 3, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModelRenderer(this, 32, 0);
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 2, 13, 3, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModelRenderer(this, 56, 20);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		rightArmPlus = new ModelRenderer(this);		rightArm2 = new ModelRenderer(this, 56, 25);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		rightArmPlus2 = new ModelRenderer(this);		rightHand = new ModelRenderer(this, 56, 28);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm = new ModelRenderer(this, 56, 20);
		leftArm.setMirror(true);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		leftArmPlus = new ModelRenderer(this);		leftArm2 = new ModelRenderer(this, 56, 25);
		leftArm2.setMirror(true);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new ModelRenderer(this);		leftHand = new ModelRenderer(this, 56, 28);
		leftHand.setMirror(true);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg = new ModelRenderer(this, 0, 16);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModelRenderer(this);		rightLeg2 = new ModelRenderer(this, 0, 22);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModelRenderer(this);		leftLeg = new ModelRenderer(this, 0, 16);
		leftLeg.setMirror(true);
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModelRenderer(this);		leftLeg2 = new ModelRenderer(this, 0, 22);
		leftLeg2.setMirror(true);
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModelRenderer(this);		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Arms[0].setRotationPoint(0.5F, 9.0F, 0F);
		Arms[1].setRotationPoint(-0.5F, 9.0F, 0F);
		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSkirt.rotationPointZ = 0.0F;
		LeftSkirt.rotationPointZ = 0.0F;
		RightSkirt.rotateAngleX = -0.01F;
		LeftSkirt.rotateAngleX = 0.01F;
		RightSkirt.rotateAngleY = 0.0F;
		LeftSkirt.rotateAngleY = 0.0F;
		RightSkirt.rotateAngleZ = 0.0F;
		LeftSkirt.rotateAngleZ = 0.0F;		RightSkirt.rotationPointY =
				LeftSkirt.rotationPointY = -2.0F;
		Skirt.rotationPointY = 6.0F;
		bipedHead.rotationPointY = 0.0F;
		bipedBody.rotationPointY = 4.0F;
		bipedRightLeg.rotationPointY =
		bipedLeftLeg.rotationPointY = 8.0F;		bipedRightArm.rotationPointY += 3.0F;
		bipedLeftArm.rotationPointY += 3.0F;
		bipedBody.rotationPointZ = 0.0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			RightSkirt.rotationPointY =
					LeftSkirt.rotationPointY = -2.4F;
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			bipedHead.rotationPointY += 1.0F;
			bipedBody.rotationPointY += 1.0F;
			bipedBody.rotationPointZ -= 0.1F;
			//bipedRightLeg.rotationPointZ += 0.3F;
			//bipedLeftLeg.rotationPointZ += 0.3F;
			//bipedRightLeg.rotationPointY -= 1.0F;
			//bipedLeftLeg.rotationPointY -= 1.0F;
			//Skirt.rotationPointZ = 4.0F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait) && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			bipedRightArm.rotateAngleX = Helper.sin(f2 * 0.067F) * 0.05F - 0.7F;
			bipedRightArm.rotateAngleY = 0.0F;
			bipedRightArm.rotateAngleZ = -0.4F;
			bipedLeftArm.rotateAngleX = Helper.sin(f2 * 0.067F) * 0.05F - 0.7F;
			bipedLeftArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.4F;
		}
		
		RightSkirt.rotateAngleZ += mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
		LeftSkirt.rotateAngleZ -= mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
		RightSkirt.rotateAngleX += mh_sin(f2 * 0.04F) * 0.03F;
		LeftSkirt.rotateAngleX -= mh_sin(f2 * 0.04F) * 0.03F;		SideTailR.rotateAngleZ = mh_sin(f2 * 0.08F) * 0.03F + 0.03F;
		SideTailL.rotateAngleZ = -(mh_sin(f2 * 0.08F) * 0.03F + 0.03F);
		SideTailR.rotateAngleX = mh_cos(f2 * 0.05F) * 0.03F;
		SideTailL.rotateAngleX = mh_cos(f2 * 0.05F) * 0.03F;
		//bipedHeadwear.rotateAngleX = -(mh_sin(f2 * 0.09F) * 0.03F + 0.03F);
//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);		rightHand.showModel = leftHand.showModel = rightArm.showModel =				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(Tail);
		bipedHead.addChild(bipedHeadwearB);
		bipedRightLeg.addChild(RightSkirt);
		bipedLeftLeg.addChild(LeftSkirt);
	}	@Override
	public float getHeight(IModelCaps entityCaps) {
		return 1.58F;
	}	@Override
	public float getWidth(IModelCaps entityCaps) {
		return 0.55F;
	}	@Override
	public float getyOffset(IModelCaps entityCaps) {
		return 1.4F;
	}	@Override
	public float getMountedYOffset(IModelCaps entityCaps) {
		return 0.85F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}
