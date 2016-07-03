package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelBoxPlate;import littleMaidMobX.render.model.ModelRenderer;public class MultiModel_st extends ModelModchuBaseSR2 {
	public ModelRenderer ArmR1;
	public ModelRenderer ArmR2;
	public ModelRenderer ArmR3;
	public ModelRenderer HandR;
	public ModelRenderer JointR;
	public ModelRenderer FingerR1;
	public ModelRenderer FingerR2;
	public ModelRenderer FingerR3;
	public ModelRenderer FingerR4;
	public ModelRenderer FingerR5;
	public ModelRenderer FingerR6;
	public ModelRenderer FingerR7;
	public ModelRenderer FingerR8;
	public ModelRenderer ArmL1;
	public ModelRenderer ArmL2;
	public ModelRenderer ArmL3;
	public ModelRenderer HandL;
	public ModelRenderer JointL;
	public ModelRenderer FingerL1;
	public ModelRenderer FingerL2;
	public ModelRenderer FingerL3;
	public ModelRenderer FingerL4;
	public ModelRenderer FingerL5;
	public ModelRenderer FingerL6;
	public ModelRenderer FingerL7;
	public ModelRenderer FingerL8;
	public ModelRenderer Tailroot;
	public ModelRenderer Tail1;
	public ModelRenderer Tail2;
	public ModelRenderer Tail3;
	public ModelRenderer Tailroot1;
	public ModelRenderer Tailroot2;
	public ModelRenderer Tailroot3;
	public ModelRenderer Tailroot4;
	public ModelRenderer Tailend;
	public ModelRenderer Parka;
	public ModelRenderer Mahura;
	public ModelRenderer LegAR;
	public ModelRenderer LegAL;
	public ModelRenderer Breast1;
	public ModelRenderer Cheek_R;
	public ModelRenderer Cheek_L;		public MultiModel_st(StringBuilder hack) {		super(hack);	}	public MultiModel_st() {
		this(0.0F);
	}	public MultiModel_st(float f) {
		this(f, 0.0F);
	}	public MultiModel_st(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_st(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.5F, 0.0F);
		bipedHeadwear = new ModelRenderer(this, 24, 0);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedRightArm = new ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		Skirt = new ModelRenderer(this, 0, 20);
		Skirt.addBox(-3.5F, -2F, -2.5F, 7, 4, 5, f);
		Skirt.setRotationPoint(0.0F, 3.0F, 0.0F);
		ArmR1 = new ModelRenderer(this, 44, 55);
		ArmR1.addBox(-8.5F, 4F, -2F, 3, 2, 7, f);
		ArmR1.setRotationPoint(3.3F, 0.3F, -1.5F);
		ArmR2 = new ModelRenderer(this, 48, 47);
		ArmR2.addBox(-7.5F, 6F, -1.5F, 2, 2, 6, f);
		ArmR2.setRotationPoint(3.3F, 0.3F, -1.5F);
		ArmR3 = new ModelRenderer(this, 27, 45);
		ArmR3.addBox(-10F, 2.5F, 0.5F, 2, 6, 2, f);
		ArmR3.setRotationPoint(3.3F, 0.3F, -1.5F);
		ArmR3.setRotateAngleZ(-0.1745329F);
		HandR = new ModelRenderer(this, 46, 38);
		HandR.addBox(-7.5F, 8F, -2F, 2, 2, 7, f);
		HandR.setRotationPoint(3.3F, 0.3F, -1.5F);
		JointR = new ModelRenderer(this, 31, 32);
		JointR.addBox(-5.5F, -1F, 2.0F, 2, 6, 3, f);
		JointR.setRotationPoint(3.3F, 0.3F, -1.5F);
		JointR.setRotateAngleX(-0.5410521F);
		FingerR1 = new ModelRenderer(this, 36, 57);
		FingerR1.addBox(-7F, 9F, -1.8F, 2, 2, 1, f);
		FingerR1.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR1.setRotateAngleX(-0.122173F);
		FingerR2 = new ModelRenderer(this, 36, 61);
		FingerR2.addBox(-7F, 10F, -5F, 2, 2, 1, f);
		FingerR2.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR2.setRotateAngleX(0.1745329F);
		FingerR3 = new ModelRenderer(this, 42, 51);
		FingerR3.addBox(-6.3F, 10.8F, -2F, 1, 2, 2, f);
		FingerR3.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR3.setRotateAngleZ(0.1570796F);
		FingerR4 = new ModelRenderer(this, 42, 56);
		FingerR4.addBox(-11F, 9.2F, -2F, 1, 3, 2, f);
		FingerR4.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR4.setRotateAngleZ(-0.2792527F);
		FingerR5 = new ModelRenderer(this, 42, 51);
		FingerR5.addBox(-6.3F, 10.8F, 0.5F, 1, 2, 2, f);
		FingerR5.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR5.setRotateAngleZ(0.1570796F);
		FingerR6 = new ModelRenderer(this, 42, 56);
		FingerR6.addBox(-11F, 9.2F, 0.5F, 1, 3, 2, f);
		FingerR6.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR6.setRotateAngleZ(-0.2792527F);
		FingerR7 = new ModelRenderer(this, 42, 51);
		FingerR7.addBox(-6.3F, 10.8F, 3F, 1, 2, 2, f);
		FingerR7.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR7.setRotateAngleZ(0.1570796F);
		FingerR8 = new ModelRenderer(this, 42, 56);
		FingerR8.addBox(-11F, 9.2F, 3F, 1, 3, 2, f);
		FingerR8.setRotationPoint(3.3F, 0.3F, -1.5F);
		FingerR8.setRotateAngleZ(-0.2792527F);
		ArmL1 = new ModelRenderer(this, 44, 55);
		ArmL1.addBox(5.5F, 4F, -2F, 3, 2, 7, f);
		ArmL1.setRotationPoint(-3.3F, 1.0F, -1.5F);
		ArmL2 = new ModelRenderer(this, 48, 47);
		ArmL2.addBox(5.5F, 6F, -1.5F, 2, 2, 6, f);
		ArmL2.setRotationPoint(-3.3F, 1.0F, -1.5F);
		ArmL3 = new ModelRenderer(this, 27, 45);
		ArmL3.addBox(8F, 2.5F, 0.5F, 2, 6, 2, f);
		ArmL3.setRotationPoint(-3.3F, 1.0F, -1.5F);
		ArmL3.setRotateAngleZ(0.1745329F);
		HandL = new ModelRenderer(this, 46, 38);
		HandL.addBox(5.5F, 8F, -2F, 2, 2, 7, f);
		HandL.setRotationPoint(-3.3F, 1.0F, -1.5F);
		JointL = new ModelRenderer(this, 31, 32);
		JointL.addBox(3.5F, -1F, 2.0F, 2, 6, 3, f);
		JointL.setRotationPoint(-3.3F, 0.3F, -1.5F);
		JointL.setRotateAngleX(-0.5410521F);
		FingerL1 = new ModelRenderer(this, 36, 57);
		FingerL1.addBox(5F, 9F, -1.8F, 2, 2, 1, f);
		FingerL1.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL1.setRotateAngleX(-0.122173F);
		FingerL2 = new ModelRenderer(this, 36, 61);
		FingerL2.addBox(5F, 10F, -5F, 2, 2, 1, f);
		FingerL2.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL2.setRotateAngleX(0.1745329F);
		FingerL3 = new ModelRenderer(this, 42, 51);
		FingerL3.addBox(5.3F, 10.8F, -2F, 1, 2, 2, f);
		FingerL3.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL3.setRotateAngleZ(-0.1570796F);
		FingerL4 = new ModelRenderer(this, 42, 56);
		FingerL4.addBox(10F, 9.2F, -2F, 1, 3, 2, f);
		FingerL4.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL4.setRotateAngleZ(0.2792527F);
		FingerL5 = new ModelRenderer(this, 42, 51);
		FingerL5.addBox(5.3F, 10.8F, 0.5F, 1, 2, 2, f);
		FingerL5.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL5.setRotateAngleZ(-0.1570796F);
		FingerL6 = new ModelRenderer(this, 42, 56);
		FingerL6.addBox(10F, 9.2F, 0.5F, 1, 3, 2, f);
		FingerL6.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL6.setRotateAngleZ(0.2792527F);
		FingerL7 = new ModelRenderer(this, 42, 51);
		FingerL7.addBox(5.3F, 10.8F, 3F, 1, 2, 2, f);
		FingerL7.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL7.setRotateAngleZ(-0.1570796F);
		FingerL8 = new ModelRenderer(this, 42, 56);
		FingerL8.addBox(10F, 9.2F, 3F, 1, 3, 2, f);
		FingerL8.setRotationPoint(-3.3F, 0.3F, -1.5F);
		FingerL8.setRotateAngleZ(0.2792527F);
		Tail1 = new ModelRenderer(this, 42, 33);
		Tail1.addBox(-0.5F, 5F, 1.0F, 1, 3, 1, f);
		Tail1.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tail1.setRotateAngleX(0.2617994F);
		Tail2 = new ModelRenderer(this, 42, 33);
		Tail2.addBox(-0.5F, 7.9F, -2F, 1, 3, 1, f);
		Tail2.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tail2.setRotateAngleX(((float) Math.PI / 5F));
		Tail3 = new ModelRenderer(this, 42, 33);
		Tail3.addBox(-0.5F, 10F, -4.3F, 1, 3, 1, f);
		Tail3.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tail3.setRotateAngleX(0.8552113F);
		Tailroot = new ModelRenderer(this, 48, 32);
		Tailroot.addBox(-1.5F, 4F, 2.0F, 3, 1, 1, f);
		Tailroot.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailroot1 = new ModelRenderer(this, 48, 32);
		Tailroot1.addBox(-1.5F, 7F, 1.0F, 3, 1, 1, f);
		Tailroot1.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailroot1.setRotateAngleX(0.2617994F);
		Tailroot2 = new ModelRenderer(this, 48, 35);
		Tailroot2.addBox(-2F, 8.5F, -2F, 4, 1, 1, f);
		Tailroot2.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailroot2.setRotateAngleX(((float) Math.PI / 5F));
		Tailroot3 = new ModelRenderer(this, 48, 35);
		Tailroot3.addBox(-2F, 10F, -2F, 4, 1, 1, f);
		Tailroot3.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailroot3.setRotateAngleX(((float) Math.PI / 5F));
		Tailroot4 = new ModelRenderer(this, 48, 32);
		Tailroot4.addBox(-1.5F, 11F, -4.4F, 3, 1, 1, f);
		Tailroot4.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailroot4.setRotateAngleX(0.8552113F);
		Tailend = new ModelRenderer(this, 48, 28);
		Tailend.addBox(-6.5F, 11F, 4.5F, 2, 1, 2, f);
		Tailend.setRotationPoint(0.0F, -8.0F, 0.0F);
		Tailend.setRotateAngleY(((float) Math.PI / 4F));
		Parka = new ModelRenderer(this, 0, 45);
		Parka.addBox(-4.5F, -9F, -4.1F, 9, 10, 9, f);
		Parka.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mahura = new ModelRenderer(this, 0, 32);
		Mahura.addBox(-5F, -1.6F, -4.6F, 10, 3, 10, f);
		Mahura.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegAR = new ModelRenderer(this, 46, 21);
		LegAR.addBox(-4F, 13.2F, -3F, 4, 1, 5, f);
		LegAR.setRotationPoint(1.0F, -7.0F, 0.0F);
		LegAL = new ModelRenderer(this, 46, 21);
		LegAL.addBox(0.0F, 13.2F, -3F, 4, 1, 5, f);
		LegAL.setRotationPoint(-1F, -7.0F, 0.0F);
		Breast1 = new ModelRenderer(this, 0, 32);
		Breast1.addBox(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
		Breast1.setRotationPoint(0.0F, 1.0F, -2F);
		Breast1.setRotateAngleZ(((float) Math.PI / 2F));
		Breast1.setRotateAngleY(0.4363323F);
		eyeR = new ModelRenderer(this, 0, 16);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 4, 16);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cheek_R = new ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPoint(0.0F, 1.0F, 0.0F);
		Cheek_L = new ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPoint(0.0F, 1.0F, 0.0F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		super.actionPartsInit(f, f1);
		rightHand.isHidden = leftHand.isHidden = rightArm.isHidden =
				leftArm.isHidden = rightArm2.isHidden = leftArm2.isHidden =
				rightLeg.isHidden = rightLeg2.isHidden = leftLeg.isHidden =
				leftLeg2.isHidden = true;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		textureWidth = 64;
		textureHeight = 64;
		//ふんわりスカート上
		SkirtTop = new ModelRenderer(this, 5, 20);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 7, 5, ModelBoxPlate.planeXZTop);
		SkirtTop.setRotationPoint(-3.5F, -2.0F, -2.5F);		//ふんわりスカート前
		SkirtFront = new ModelRenderer(this, 5, 25);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 7, 4, ModelBoxPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート右
		SkirtRight = new ModelRenderer(this, 0, 25);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 5, 4, ModelBoxPlate.planeZYRight);
		SkirtRight.setRotationPoint(7.0F, 0.0F, 0.0F);		//ふんわりスカート左
		SkirtLeft = new ModelRenderer(this, 19, 25);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 5, 4, ModelBoxPlate.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート後ろ
		SkirtBack = new ModelRenderer(this, 12, 25);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 7, 4, ModelBoxPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 5.0F);
		setCapsValue(null, caps_visible, Skirt, false);
	}	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			Cheek_R.setVisible(true);
			Cheek_L.setVisible(true);
		} else {
			Cheek_R.setVisible(false);
			Cheek_L.setVisible(false);
		}
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedRightArm.addChild(ArmR1);
		bipedRightArm.addChild(ArmR2);
		bipedRightArm.addChild(ArmR3);
		bipedRightArm.addChild(HandR);
		bipedRightArm.addChild(JointR);
		bipedRightArm.addChild(FingerR1);
		bipedRightArm.addChild(FingerR2);
		bipedRightArm.addChild(FingerR3);
		bipedRightArm.addChild(FingerR4);
		bipedRightArm.addChild(FingerR5);
		bipedRightArm.addChild(FingerR6);
		bipedRightArm.addChild(FingerR7);
		bipedRightArm.addChild(FingerR8);
		bipedLeftArm.addChild(ArmL1);
		bipedLeftArm.addChild(ArmL2);
		bipedLeftArm.addChild(ArmL3);
		bipedLeftArm.addChild(HandL);
		bipedLeftArm.addChild(JointL);
		bipedLeftArm.addChild(FingerL1);
		bipedLeftArm.addChild(FingerL2);
		bipedLeftArm.addChild(FingerL3);
		bipedLeftArm.addChild(FingerL4);
		bipedLeftArm.addChild(FingerL5);
		bipedLeftArm.addChild(FingerL6);
		bipedLeftArm.addChild(FingerL7);
		bipedLeftArm.addChild(FingerL8);
		Skirt.addChild(Tail1);
		Skirt.addChild(Tail2);
		Skirt.addChild(Tail3);
		Skirt.addChild(Tailroot);
		Skirt.addChild(Tailroot1);
		Skirt.addChild(Tailroot2);
		Skirt.addChild(Tailroot3);
		Skirt.addChild(Tailroot4);
		Skirt.addChild(Tailend);
		bipedRightLeg.addChild(LegAR);
		bipedLeftLeg.addChild(LegAL);
		bipedHead.addChild(Parka);
		bipedHead.addChild(Mahura);
		bipedBody.addChild(Breast1);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
	}	@Override	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		Breast1.setRotationPoint(0.0F, 1.0F, -2F);	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Skirt.rotationPointY -= 2.0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			Skirt.rotateAngleX = -upperBody.rotateAngleX;
		}
	}
}