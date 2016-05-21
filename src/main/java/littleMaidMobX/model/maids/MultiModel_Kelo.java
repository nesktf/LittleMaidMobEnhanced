package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseOkota;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_Kelo extends ModelModchuBaseOkota {	public ModelRenderer tailL1;
	public ModelRenderer tailL2;
	public ModelRenderer tailR1;
	public ModelRenderer tailR2;
	public ModelRenderer BreastPocket;
	public ModelRenderer LsidePocket;
	public ModelRenderer RsidePocket;
	public ModelRenderer Backpack;
	public ModelRenderer BackpackPocket;
	public ModelRenderer Zipper;
	public ModelRenderer SleeveR;
	public ModelRenderer SleeveL;
	public ModelRenderer ShoesL;
	public ModelRenderer ShoesR;
	public ModelRenderer KeloeyeL1;
	public ModelRenderer KeloeyeR1;
	public ModelRenderer KeloeyeL2;
	public ModelRenderer KeloeyeR2;	public ModelRenderer headwear;
	public ModelRenderer rightHandPlus;
	public ModelRenderer leftHandPlus;		public MultiModel_Kelo(StringBuilder hack) {		super(hack);	}	public MultiModel_Kelo() {
		this(0.0F);
	}	public MultiModel_Kelo(float f) {
		this(f, 0.0F);
	}	public MultiModel_Kelo(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Kelo(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		tailL1 = new ModelRenderer(this, 0, 0);
		tailL1.addBox(1.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailL2 = new ModelRenderer(this, 27, 16);
		tailL2.addBox(2F, -1F, 4.5F, 3, 3, 3, f);
		tailL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailR1 = new ModelRenderer(this, 0, 4);
		tailR1.addBox(-3.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailR2 = new ModelRenderer(this, 48, 19);
		tailR2.addBox(-5F, -1F, 4.5F, 3, 3, 3, f);
		tailR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModelRenderer(this, 56, 3);
		SideTailL.mirror = true;
		SideTailL.addBox(3.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModelRenderer(this, 60, 3);
		SideTailR.addBox(-4.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		headwear = new ModelRenderer(this, 32, 0);
		headwear.addBox(-4F, -8F, -4.5F, 8, 4, 8, f + 0.5F);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonR = new ModelRenderer(this, 24, 2);
		ChignonR.addBox(-5F, -11F, -2.5F, 4, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new ModelRenderer(this, 24, 2);
		ChignonL.addBox(1F, -11F, -2.5F, 4, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeL1 = new ModelRenderer(this, 28, 0);
		KeloeyeL1.addBox(2F, -10F, -2.5F, 2, 2, 0, f - 0.2F);
		KeloeyeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeR1 = new ModelRenderer(this, 24, 0);
		KeloeyeR1.addBox(-4F, -10F, -2.5F, 2, 2, 0, f - 0.2F);
		KeloeyeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeL2 = new ModelRenderer(this, 36, 0);
		KeloeyeL2.addBox(2F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeR2 = new ModelRenderer(this, 32, 0);
		KeloeyeR2.addBox(-4F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new ModelRenderer(this, 12, 19);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 3, f + 0.3F);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		Backpack = new ModelRenderer(this, 48, 25);
		Backpack.addBox(-2F, 1F, 1F, 4, 5, 2, f + 0.3F);
		Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackpackPocket = new ModelRenderer(this, 48, 27);
		BackpackPocket.addBox(-2F, 3.2F, 0.5F, 4, 2, 2, f + 0.6F);
		BackpackPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		BreastPocket = new ModelRenderer(this, 24, 16);
		BreastPocket.addBox(1F, 2F, -2.5F, 2, 2, 1, f);
		BreastPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		LsidePocket = new ModelRenderer(this, 32, 12);
		LsidePocket.addBox(2.5F, 6F, -2.5F, 1, 2, 2, f);
		LsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		RsidePocket = new ModelRenderer(this, 32, 12);
		RsidePocket.addBox(-3.5F, 6F, -2.5F, 1, 2, 2, f);
		RsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		Zipper = new ModelRenderer(this, 30, 22);
		Zipper.addBox(-1.5F, -1F, -1.5F, 3, 10, 0, f - 1F);
		Zipper.setRotationPoint(0.0F, 0.0F, 0.0F);
		Skirt = new ModelRenderer(this, 46, 12);
		Skirt.addBox(-3F, -2F, -2F, 6, 2, 3, f + 0.8F);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightArm = new ModelRenderer(this, 36, 19);
		bipedRightArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.5F);
		SleeveR = new ModelRenderer(this, 36, 14);
		SleeveR.addBox(-3F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
		bipedLeftArm = new ModelRenderer(this, 36, 19);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedLeftArm.setRotationPoint(3.5F, 0.0F, 0.5F);
		SleeveL = new ModelRenderer(this, 36, 14);
		SleeveL.mirror = true;
		SleeveL.addBox(0F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
		bipedRightLeg = new ModelRenderer(this, 0, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedRightLeg.setRotationPoint(-1.5F, 0.0F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 0, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedLeftLeg.setRotationPoint(1.5F, 0.0F, 0.0F);
		ShoesR = new ModelRenderer(this, 0, 16);
		ShoesR.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
		ShoesL = new ModelRenderer(this, 0, 16);
		ShoesL.mirror = true;
		ShoesL.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
		eyeL = new ModelRenderer(this, 16, 16);
		eyeL.addBox(0F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR = new ModelRenderer(this, 8, 16);
		eyeR.addBox(-4F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModelRenderer(this, 36, 19);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm.setRotationPoint(-3.0F, 1.5F + f1, 0.0F);		rightArmPlus = new ModelRenderer(this);
		rightArmPlus.setTextureOffset(39, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModelRenderer(this, 36, 23);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		rightArmPlus2 = new ModelRenderer(this);
		rightArmPlus2.setTextureOffset(39, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		rightArmPlus2.setTextureOffset(42, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModelRenderer(this, 36, 26);
		rightHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);		rightHandPlus = new ModelRenderer(this);
		rightHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		rightHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		rightHandPlus.rotateAngleX = 1.570796313F;		leftArm = new ModelRenderer(this, 36, 19);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm.setRotationPoint(3.0F, 1.5F + f1, 0.0F);		leftArmPlus = new ModelRenderer(this);
		leftArmPlus.setTextureOffset(39, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModelRenderer(this, 36, 23);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		leftArmPlus2 = new ModelRenderer(this);
		leftArmPlus2.setTextureOffset(39, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		leftArmPlus2.setTextureOffset(42, 19).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModelRenderer(this, 36, 26);
		leftHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);		leftHandPlus = new ModelRenderer(this);
		leftHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		leftHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		leftHandPlus.rotateAngleX = 1.570796313F;		rightLeg = new ModelRenderer(this, 0, 19);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModelRenderer(this);
		rightLegPlus.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModelRenderer(this, 0, 24);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModelRenderer(this);
		//rightLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F - 0.5F, 0.01F, 3, 3, 4, f);
		rightLegPlus2.setTextureOffset(6, 19).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModelRenderer(this, 0, 19);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModelRenderer(this);
		leftLegPlus.mirror = true;
		leftLegPlus.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModelRenderer(this, 0, 24);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModelRenderer(this);
		leftLegPlus2.mirror = true;
		//leftLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F, 0.01F, 3, 3, 4, f);
		leftLegPlus2.setTextureOffset(6, 19).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel =
				rightHandPlus.showModel = leftHandPlus.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(Tail);
		bipedHead.addChild(tailL1);
		bipedHead.addChild(tailL2);
		bipedHead.addChild(tailR1);
		bipedHead.addChild(tailR2);
		bipedHead.addChild(SideTailL);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(headwear);
		bipedHead.addChild(ChignonR);
		bipedHead.addChild(ChignonL);
		bipedHead.addChild(KeloeyeL1);
		bipedHead.addChild(KeloeyeR1);
		bipedHead.addChild(KeloeyeL2);
		bipedHead.addChild(KeloeyeR2);
		bipedBody.addChild(Backpack);
		bipedBody.addChild(BackpackPocket);
		bipedBody.addChild(BreastPocket);
		bipedBody.addChild(LsidePocket);
		bipedBody.addChild(RsidePocket);
		bipedBody.addChild(Zipper);
		bipedRightArm.addChild(SleeveR);
		bipedLeftArm.addChild(SleeveL);
		bipedRightLeg.addChild(ShoesR);
		bipedLeftLeg.addChild(ShoesL);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		mainFrame.setRotationPoint(0F, 0F, 0F);
		bipedRightLeg.rotateAngleX = (Helper.cos(f * 0.6662F) * 1.4F * f1) / 1.5F;
		bipedLeftLeg.rotateAngleX = (Helper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1) / 1.5F;
		setCapsValue(entityCaps, caps_visible, KeloeyeL1, true);
		setCapsValue(entityCaps, caps_visible, KeloeyeR1, true);
		setCapsValue(entityCaps, caps_visible, KeloeyeL2, false);
		setCapsValue(entityCaps, caps_visible, KeloeyeR2, false);		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			bipedRightLeg.rotateAngleX = -1.256637F;
			bipedLeftLeg.rotateAngleX = -1.256637F;
			bipedRightLeg.rotateAngleY = 0.3141593F;
			bipedLeftLeg.rotateAngleY = -0.3141593F;
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		if (armSwingFlag(entityCaps)) {
			bipedRightArm.rotationPointZ = Helper.sin(bipedBody.rotateAngleY) * 4F;
			bipedRightArm.rotationPointX = -Helper.cos(bipedBody.rotateAngleY) * 3.5F + 1.0F;
			bipedLeftArm.rotationPointZ = -Helper.sin(bipedBody.rotateAngleY) * 4F;
			bipedLeftArm.rotationPointX = Helper.cos(bipedBody.rotateAngleY) * 3.5F - 1.0F;
		}
		Skirt.rotationPointY = 10.0F;
		bipedHead.rotationPointY =
		bipedRightArm.rotationPointY =
		bipedLeftArm.rotationPointY = 0.0F;
		bipedRightLeg.rotationPointY =
		bipedLeftLeg.rotationPointY = 10.0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			upperBody.rotateAngleX = 0.5F;
			bipedBody.rotationPointY = 5.0F;
			bipedRightLeg.rotationPointZ =
					bipedLeftLeg.rotationPointZ -= 0.6F;
			bipedRightLeg.rotationPointY =
					bipedLeftLeg.rotationPointY -= 0.4F;
			//Skirt.rotationPointZ = bipedRightLeg.rotationPointZ + 1.0F;
			Skirt.rotationPointY = 9.5F;
			//Skirt.rotateAngleX += 0.3F;
		} else {
			bipedBody.rotationPointY = 6.0F;
			//Skirt.rotationPointZ = 0.0F;
		}		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait) && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, KeloeyeL1, false);
			setCapsValue(entityCaps, caps_visible, KeloeyeR1, false);
			setCapsValue(entityCaps, caps_visible, KeloeyeL2, true);
			setCapsValue(entityCaps, caps_visible, KeloeyeR2, true);
		}
		headwear.rotateAngleX = -0.087F;
//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}//	@Override
//	public void actionPartsAddChild() {
//		super.actionPartsAddChild();
//		setCapsValue(null, caps_visible, rightHandPlus, true);
//		setCapsValue(null, caps_visible, leftHandPlus, true);
//		bipedRightArm.removeChild(SleeveR);
//		bipedLeftArm.removeChild(SleeveL);
//		bipedRightLeg.removeChild(ShoesR);
//		bipedLeftLeg.removeChild(ShoesL);
//		rightArm2.addChild(SleeveR);
//		leftArm2.addChild(SleeveL);
//		rightLeg2.addChild(ShoesR);
//		leftLeg2.addChild(ShoesL);
//	}////	@Override
//	public void actionRelease1(IModelCaps entityCaps) {
//		super.actionRelease1(entityCaps);
///*
//		rightHandPlus.showModel = leftHandPlus.showModel = false;
//		bipedRightArm.addChild(SleeveR);
//		bipedLeftArm.addChild(SleeveL);
//		bipedRightLeg.addChild(ShoesR);
//		bipedLeftLeg.addChild(ShoesL);
//		rightArm2.removeChild(SleeveR);
//		leftArm2.removeChild(SleeveL);
//		rightLeg2.removeChild(ShoesR);
//		leftLeg2.removeChild(ShoesL);
//*/
//		SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
//		SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
//		ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
//		ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
//	}	@Override
	public float getHeight(IModelCaps entityCaps) {
		return 1.6F;
	}	@Override
	public float getWidth(IModelCaps entityCaps) {
		return 0.7F;
	}	@Override
	public float getyOffset(IModelCaps entityCaps) {
		return 1.2F;
	}	@Override
	public float getMountedYOffset(IModelCaps entityCaps) {
		float d = 0.85F;
		return d;
	}	@Override
	public double getSittingYOffset(IModelCaps entityCaps) {
		return -0.5D;
	}	@Override
	public float ridingViewCorrection(IModelCaps entityCaps) {
		return -0.75F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
	@Override	public String[] getBreastName() {		return null;	}}