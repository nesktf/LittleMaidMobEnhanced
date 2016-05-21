package littleMaidMobX.model.modchu;import littleMaidMobX.util.helper.Helper;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.render.model.ModelBoxPlate;import littleMaidMobX.render.model.ModelRenderer;public class ModelModchuBaseMulti extends ModelModchuBaseSkirt {	public ModelRenderer ChignonR;
	public ModelRenderer ChignonL;
	public ModelRenderer ChignonB;
	public ModelRenderer Tail;
	public ModelRenderer SideTailR;
	public ModelRenderer SideTailL;
	public ModelRenderer Skirt;
	public ModelRenderer SkirtTop;
	public ModelRenderer SkirtFront;
	public ModelRenderer SkirtRight;
	public ModelRenderer SkirtLeft;
	public ModelRenderer SkirtBack;		public ModelModchuBaseMulti(StringBuilder hack) {		super(hack);	}	public ModelModchuBaseMulti() {
		this(0.0F);
	}	public ModelModchuBaseMulti(float f) {
		this(f, 0.0F);
	}	public ModelModchuBaseMulti(float f, float f1) {
		this(f, f1, 64, 32);
	}	public ModelModchuBaseMulti(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}		@Override	public void initModel(float f, float f1)	{		initModel(f, f1, true);	}	
	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedCloak = new ModelRenderer(this, "bipedCloak");
		bipedEars = new ModelRenderer(this, "bipedEars");
		bipedHead = new ModelRenderer(this, 0, 0, "bipedHead");
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHeadwear = new ModelRenderer(this, 24, 0, "bipedHeadwear");
		bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
		bipedBody = new ModelRenderer(this, 32, 8, "bipedBody");
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedRightArm = new ModelRenderer(this, 48, 0, "bipedRightArm");
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm = new ModelRenderer(this, 56, 0, "bipedLeftArm");
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightLeg = new ModelRenderer(this, 32, 19, "bipedRightLeg");
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg = new ModelRenderer(this, 32, 19, "bipedLeftLeg");
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		Skirt = new ModelRenderer(this, 0, 16, "Skirt");
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		ChignonR = new ModelRenderer(this, 24, 18, "ChignonR");
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, -1.5F, 0.0F);
		ChignonL = new ModelRenderer(this, 24, 18, "ChignonL");
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, -1.5F, 0.0F);
		ChignonB = new ModelRenderer(this, 52, 10, "ChignonB");
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, -1.5F, 0.0F);
		Tail = new ModelRenderer(this, 46, 20, "Tail");
		Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModelRenderer(this, 58, 21, "SideTailR");
		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModelRenderer(this, 58, 21, "SideTailL");
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);		mainFrame = new ModelRenderer(this, "mainFrame");
		mainFrame.setRotationPoint(0F, 8F, 0F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void armsinit(float f, float f1) {
		
		Arms[0] = new ModelRenderer(this, 0, 0, "Arm0");
		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
		Arms[1] = new ModelRenderer(this, 0, 0, "Arm1");
		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		Arms[1].isInvertX = true;
		HeadMount = new ModelRenderer(this, "HeadMount");
		HeadMount.setRotationPoint(0F, 0F, 0F);
		HeadTop = new ModelRenderer(this, "HeadTop");
		HeadTop.setRotationPoint(0.0F, -8.0F, 0.0F);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModelRenderer(this, 48, 0, "rightArm");
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		rightArmPlus = new ModelRenderer(this, "rightArmPlus");
		//rightArmPlus.setTextureOffset(52, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModelRenderer(this, 48, 3, "rightArm2");
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		rightArmPlus2 = new ModelRenderer(this, "rightArmPlus2");
		rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
		rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModelRenderer(this, 48, 6, "rightHand");
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm = new ModelRenderer(this, 56, 0, "leftArm");
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		leftArmPlus = new ModelRenderer(this, "leftArmPlus");
		//leftArmPlus.setTextureOffset(60, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModelRenderer(this, 56, 3, "leftArm2");
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new ModelRenderer(this, "leftArmPlus2");
		leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
		leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModelRenderer(this, 56, 6, "leftHand");
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg = new ModelRenderer(this, 32, 19, "rightLeg");
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModelRenderer(this, "rightLegPlus");
		rightLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModelRenderer(this, 32, 23, "rightLeg2");
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModelRenderer(this, "rightLegPlus2");
		rightLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		rightLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModelRenderer(this, 32, 19, "leftLeg");
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModelRenderer(this, "leftLegPlus");
		leftLegPlus.mirror = true;
		leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModelRenderer(this, 32, 23, "leftLeg2");
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModelRenderer(this, "leftLegPlus2");
		leftLegPlus2.mirror = true;
		leftLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		leftLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	
	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		
		SkirtTop = new ModelRenderer(this, 8, 16, "SkirtTop");
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXZTop);
		SkirtTop.setRotationPoint(-4.0F, -4.0F, -4.0F);		
		SkirtFront = new ModelRenderer(this, 8, 24, "SkirtFront");
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		
		SkirtRight = new ModelRenderer(this, 0, 24, "SkirtRight");
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeZYRight);
		SkirtRight.setRotationPoint(8.0F, 0.0F, 0.0F);		
		SkirtLeft = new ModelRenderer(this, 16, 24, "SkirtLeft");
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		
		SkirtBack = new ModelRenderer(this, 24, 24, "SkirtBack");
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModelBoxPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 8.0F);
	}	@Override
	public void defaultAddChild() {
		defaultAddChildSetting();
		defaultSkirtFloatsAddChild();
	}	public void defaultAddChildSetting() {
		if (bipedRightArm != null) bipedRightArm.clearChildModels();
		if (bipedLeftArm != null) bipedLeftArm.clearChildModels();
		if (bipedRightLeg != null) bipedRightLeg.clearChildModels();
		if (bipedLeftLeg != null) bipedLeftLeg.clearChildModels();
		if (bipedHeadwear != null) bipedHeadwear.clearChildModels();
		if (Skirt != null) Skirt.clearChildModels();
		if (ChignonR != null) ChignonR.clearChildModels();
		if (ChignonL != null) ChignonL.clearChildModels();
		if (ChignonB != null) ChignonB.clearChildModels();
		if (Tail != null) Tail.clearChildModels();
		if (SideTailR != null) SideTailR.clearChildModels();
		if (SideTailL != null) SideTailL.clearChildModels();
		if (HeadMount != null) HeadMount.clearChildModels();
		if (HeadTop != null) HeadTop.clearChildModels();
		if (bipedHead != null) {
			bipedHead.clearChildModels();
			if (bipedHeadwear != null) bipedHead.addChild(bipedHeadwear);
			if (ChignonR != null) bipedHead.addChild(ChignonR);
			if (ChignonL != null) bipedHead.addChild(ChignonL);
			if (ChignonB != null) bipedHead.addChild(ChignonB);
			if (Tail != null) bipedHead.addChild(Tail);
			if (SideTailR != null) bipedHead.addChild(SideTailR);
			if (SideTailL != null) bipedHead.addChild(SideTailL);
		}
		if (bipedBody != null) {
			bipedBody.clearChildModels();
			if (bipedHead != null) bipedBody.addChild(bipedHead);
			if (bipedRightArm != null) bipedBody.addChild(bipedRightArm);
			if (bipedLeftArm != null) bipedBody.addChild(bipedLeftArm);
			if (bipedRightLeg != null) bipedBody.addChild(bipedRightLeg);
			if (bipedLeftLeg != null) bipedBody.addChild(bipedLeftLeg);
			if (Skirt != null) bipedBody.addChild(Skirt);
		}
//		if (upperBody != null) {
//			upperBody.clearBoneChildModels();
//			upperBody.clearBoneSpecialChildModels();
//			if (bipedBody != null) upperBody.addBoneChild(bipedBody);
//			if (bipedRightLeg != null) upperBody.addBoneSpecialChild(bipedRightLeg);
//			if (bipedLeftLeg != null) upperBody.addBoneSpecialChild(bipedLeftLeg);
//		}
//		if (lowerBody != null) {
//			lowerBody.clearBoneChildModels();
//			lowerBody.clearBoneSpecialChildModels();
//			if (bipedRightLeg != null) lowerBody.addBoneChild(bipedRightLeg);
//			if (bipedLeftLeg != null) lowerBody.addBoneChild(bipedLeftLeg);
//		}
//		if (hip != null) {
//			hip.clearBoneChildModels();
//			hip.clearBoneSpecialChildModels();
//			if (bipedBody != null) hip.addBoneChild(bipedBody);
//			if (bipedRightLeg != null) hip.addBoneChild(bipedRightLeg);
//			if (bipedLeftLeg != null) hip.addBoneChild(bipedLeftLeg);
//		}
//		if (rightShoulder != null) {
//			rightShoulder.clearBoneChildModels();
//			rightShoulder.clearBoneSpecialChildModels();
//			if (bipedRightArm != null) rightShoulder.addBoneChild(bipedRightArm);
//		}
//		if (leftShoulder != null) {
//			leftShoulder.clearBoneChildModels();
//			leftShoulder.clearBoneSpecialChildModels();
//			if (bipedLeftArm != null) leftShoulder.addBoneChild(bipedLeftArm);
//		}
//		if (center != null) {
//			center.clearBoneChildModels();
//			center.clearBoneSpecialChildModels();
//		}
//		if (leftLegIK != null) {
//			leftLegIK.clearBoneChildModels();
//			leftLegIK.clearBoneSpecialChildModels();
//			if (bipedLeftLeg != null) leftLegIK.addBoneChild(bipedLeftLeg);
//		}
//		if (rightLegIK != null) {
//			rightLegIK.clearBoneChildModels();
//			rightLegIK.clearBoneSpecialChildModels();
//			if (bipedRightLeg != null) rightLegIK.addBoneChild(bipedRightLeg);
//		}
		if (bipedHead != null && HeadMount != null) bipedHead.addChild(HeadMount);
		if (bipedHead != null && HeadTop != null) bipedHead.addChild(HeadTop);
		if (Arms != null) {
			if (bipedRightArm != null && Arms[0] != null) bipedRightArm.addChild(Arms[0]);
			if (bipedLeftArm != null && Arms[1] != null) bipedLeftArm.addChild(Arms[1]);
			if (Arms[0] != null && rightHand != null) rightHand.removeChild((ModelRenderer) Arms[0]);
			if (Arms[1] != null && leftHand != null) leftHand.removeChild((ModelRenderer) Arms[1]);
			if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
			if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		}
		if (mainFrame != null) {
			((ModelRenderer) mainFrame).clearChildModels();
			if (bipedBody != null) mainFrame.addChild(bipedBody);
		}
//		boolean b = true;
//		setCapsValue(null, caps_visible, bipedLeftArm, b);
//		setCapsValue(null, caps_visible, bipedRightArm, b);
//		setCapsValue(null, caps_visible, bipedLeftLeg, b);
//		setCapsValue(null, caps_visible, bipedRightLeg, b);
//		b = false;
//		setCapsValue(null, caps_visible, leftArm, b);
//		setCapsValue(null, caps_visible, rightArm, b);
//		setCapsValue(null, caps_visible, leftLeg, b);
//		setCapsValue(null, caps_visible, rightLeg, b);		leftArm.setVisible(false);		rightArm.setVisible(false);		leftLeg.setVisible(false);		rightLeg.setVisible(false);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		if (SkirtTop != null) {
			if (SkirtFront != null) SkirtTop.addChild(SkirtFront);
			if (SkirtRight != null) SkirtTop.addChild(SkirtRight);
			if (SkirtLeft != null) SkirtTop.addChild(SkirtLeft);
			if (SkirtBack != null) SkirtTop.addChild(SkirtBack);
		}
		if (Skirt != null) {			if (SkirtTop != null)
			if (SkirtTop != null) Skirt.addChild(SkirtTop);
			setCapsValue(null, caps_visible, Skirt, false);
		}
	}	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {		if (bipedHead != null) bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);		if (bipedHeadwear != null) bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);		if (bipedBody != null) bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);		if (bipedRightArm != null) bipedRightArm.setRotationPoint(-3.0F, -3.0F, 0.0F);		if (bipedLeftArm != null) bipedLeftArm.setRotationPoint(3.0F, -3.0F, 0.0F);		if (bipedRightLeg != null) bipedRightLeg.setRotationPoint(-1.5F, 3.5F, 0.0F);		if (bipedLeftLeg != null) bipedLeftLeg.setRotationPoint(1.5F, 3.5F, 0.0F);		if (Skirt != null) Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);//		if (ModelCapsHelper.getCapsValueByte(this, entityCaps, ((IModelCaps) entityCaps).caps_EntityType) == ((IModelCaps) entityCaps).entityType_PFLM) {//			bipedHead.rotateAngleZ = 0.0F;//		}		upperBody.setRotationPoint(0.0F, 0.0F, 0.0F);		upperBody.setRotateAngle(0.0F, 0.0F, 0.0F);		lowerBody.setRotationPoint(0.0F, 0.0F, 0.0F);		lowerBody.setRotateAngle(0.0F, 0.0F, 0.0F);		hip.setRotationPoint(0.0F, 0.0F, 0.0F);		hip.setRotateAngle(0.0F, 0.0F, 0.0F);		rightShoulder.setRotationPoint(0.0F, 0.0F, 0.0F);		rightShoulder.setRotateAngle(0.0F, 0.0F, 0.0F);		leftShoulder.setRotationPoint(0.0F, 0.0F, 0.0F);		leftShoulder.setRotateAngle(0.0F, 0.0F, 0.0F);		center.setRotationPoint(0.0F, 0.0F, 0.0F);		center.setRotateAngle(0.0F, 0.0F, 0.0F);		leftLegIK.setRotationPoint(0.0F, 0.0F, 0.0F);		leftLegIK.setRotateAngle(0.0F, 0.0F, 0.0F);		rightLegIK.setRotationPoint(0.0F, 0.0F, 0.0F);		rightLegIK.setRotateAngle(0.0F, 0.0F, 0.0F);		mainFrame.setRotationPoint(0.0F, 8.0F, 0.0F);	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		
		
		
		
		
		
		//Modchu_Debug.dDebug("setRotationAnglesLM f3="+f3+" f4="+f4, 4);		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotateAngleY = f3 / 57.29578F;
		bipedHead.rotateAngleX = f4 / 57.29578F;
		bipedRightArm.rotateAngleX = Helper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
		bipedLeftArm.rotateAngleX = Helper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)
				&& !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)
				&& ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			bipedRightArm.rotateAngleX = Helper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
			bipedLeftArm.rotateAngleX = Helper.cos(f * 0.6662F) * 1.4F * f1;
			bipedLeftArm.rotateAngleZ = (Helper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
			bipedRightArm.rotateAngleZ = (Helper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
		} else {
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
		}
		bipedRightLeg.rotateAngleX = Helper.cos(f * 0.6662F) * 1.4F * f1;
		bipedLeftLeg.rotateAngleX = Helper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		bipedRightLeg.rotateAngleY = bipedLeftLeg.rotateAngleY = bipedRightLeg.rotateAngleZ = bipedLeftLeg.rotateAngleZ = 0.0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			
			bipedRightArm.rotateAngleX += -0.6283185F;
			bipedLeftArm.rotateAngleX += -0.6283185F;
			bipedRightLeg.rotateAngleX = -1.256637F;
			bipedLeftLeg.rotateAngleX = -1.256637F;
			bipedRightLeg.rotateAngleY = 0.3141593F;
			bipedLeftLeg.rotateAngleY = -0.3141593F;
		} else {
		}
		
		if (heldItem[1] != 0
				&& !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (heldItem[1] == 3) {				bipedLeftArm.rotateAngleX = -0.8F;				bipedLeftArm.rotateAngleY = -0.4F;			} else {				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[1];			}
		}
		if (heldItem[0] != 0
				&& !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (heldItem[0] == 3) {				bipedRightArm.rotateAngleX = -0.8F;				bipedRightArm.rotateAngleY = -0.4F;			} else {				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[0];			}
		}
		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ =
				bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ =
				upperBody.rotateAngleX = upperBody.rotateAngleY = upperBody.rotateAngleZ =
				Skirt.rotateAngleX = Skirt.rotateAngleY = Skirt.rotateAngleZ = 0.0F;
		bipedBody.rotationPointY = 3.5F;
		Skirt.rotationPointY = 5.5F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			
			upperBody.rotateAngleX = 0.5F;
			bipedHead.rotateAngleX -= 0.5F;
			//bipedRightLeg.rotateAngleX -= 0.5F;
			//bipedLeftLeg.rotateAngleX -= 0.5F;
			bipedHead.rotationPointY = -3.0F;
			bipedBody.rotationPointZ = 2.0F;
			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F - 1.0F;
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.3F;
			Skirt.rotateAngleX = -upperBody.rotateAngleX;
			//Skirt.rotationPointY = 6.0F - 0.5F;
			Skirt.rotationPointZ = -1.0F;
		} else {
			
			upperBody.rotateAngleX = 0.0F;
			//Skirt.rotationPointZ = 0.0F;
			bipedHead.rotationPointY = -3.5F;
			bipedBody.rotationPointZ = 0.0F;
			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			
			float f6 = Helper.sin(onGrounds[dominantArm] * 3.141593F);
			float f7 = Helper.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F) + bipedHead.rotateAngleY + 0.4F;
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
			bipedRightArm.rotationPointX = -3F;
			bipedLeftArm.rotationPointX = 3F;
		} else {
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {
				
				bipedRightArm.rotateAngleX = Helper.sin(f2 * 0.062F) * 0.05F - 0.7F;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedRightArm.rotateAngleZ = -0.4F;
				bipedLeftArm.rotateAngleX = Helper.sin(f2 * 0.062F) * 0.05F - 0.7F;
				bipedLeftArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.4F;
			} else {
				
				bipedRightArm.rotateAngleZ += 0.5F;
				bipedLeftArm.rotateAngleZ -= 0.5F;
				bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= Helper.sin(f2 * 0.067F) * 0.05F;
			}
		}
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		SkirtFront.rotationPointX = SkirtBack.rotationPointX = SkirtRight.rotationPointZ = SkirtLeft.rotationPointZ = motionY * 4.0F;		SkirtFront.rotateAngleX = SkirtRight.rotateAngleZ = motionY;
		SkirtLeft.rotateAngleZ = SkirtBack.rotateAngleX = -motionY;		SkirtFront.scaleX = SkirtBack.scaleX = SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);
	}	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (armSwingFlag(entityCaps)) {
			
			float f6, f7, f8;
			f6 = Helper.sin(Helper.sqrt(onGrounds[0]) * (float) Math.PI * 2.0F);
			f7 = Helper.sin(Helper.sqrt(onGrounds[1]) * (float) Math.PI * 2.0F);
			bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
			// R
			if (onGrounds[0] > 0F) {
				f6 = 1.0F - onGrounds[0];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Helper.sin(f6 * (float) Math.PI);
				f8 = Helper.sin(onGrounds[0] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedRightArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedRightArm.rotateAngleZ = Helper.sin(onGrounds[0] * 3.141593F) * -0.4F;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Helper.sin(f6 * (float) Math.PI);
				f8 = Helper.sin(onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedLeftArm.rotateAngleZ = Helper.sin(onGrounds[1] * 3.141593F) * 0.4F;
			}
		}
	}	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		ModelRenderer arm = getDominantArm(entityCaps);
		if (dominantArm != 0) {
			arm.setRotateAngle(0.0F, 0.0F, 0.0F);
			armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		}
		Object entity = entityCaps.getCapsValue(caps_Entity);
		if (entity != null && entityCaps.getCapsValue(caps_currentEquippedItem) != null) {
			if (dominantArm == 0) {
				arm.rotationPointX = -3.0F;
				arm.rotationPointY = 1.5F;
				arm.rotationPointZ = 0.0F;
			} else {
				arm.rotationPointX = -8.0F;
				arm.rotationPointY = 4.0F;
				arm.rotationPointZ = 0.0F;
			}//			if (Modchu_Main.getMinecraftVersion() > 179) {//				//Modchu_Debug.debaf1 = 0.0F;//				//Modchu_Debug.debaf2 = 0.0F;//				//Modchu_Debug.debaf3 = 0.0F;//				//bipedRightArm.rotateAngleX = Modchu_Debug.debaf1;//				//bipedRightArm.rotateAngleY = Modchu_Debug.debaf2;//				//bipedRightArm.rotateAngleZ = Modchu_Debug.debaf3;//				bipedRightArm.rotateAngleX = -0.6F;//				bipedRightArm.rotateAngleY = -1.0F;//				bipedRightArm.rotateAngleZ = 0.8F;//				//bipedRightArm.rotationPointX += Modchu_Debug.debaf1;//				//bipedRightArm.rotationPointY += Modchu_Debug.debaf2;//				//bipedRightArm.rotationPointZ += Modchu_Debug.debaf3;//				bipedRightArm.rotationPointX += -4.8F;//				bipedRightArm.rotationPointY += 5.0F;//				bipedRightArm.rotationPointZ += 0.8F;////				//bipedLeftArm.rotateAngleX = Modchu_Debug.debaf1;//				//bipedLeftArm.rotateAngleY = Modchu_Debug.debaf2;//				//bipedLeftArm.rotateAngleZ = Modchu_Debug.debaf3;//				bipedLeftArm.rotateAngleX = 0.0F;//				bipedLeftArm.rotateAngleY = -0.4F;//				bipedLeftArm.rotateAngleZ = -0.4F;//				//bipedLeftArm.rotationPointX = Modchu_Debug.debaf1;//				//bipedLeftArm.rotationPointY = Modchu_Debug.debaf2;//				//bipedLeftArm.rotationPointZ = Modchu_Debug.debaf3;//				bipedLeftArm.rotationPointX = 5.2F;//				bipedLeftArm.rotationPointY = 6.0F;//				bipedLeftArm.rotationPointZ = -0.8F;//				//Modchu_Debug.mdDebug("debaf1="+Modchu_Debug.debaf1);//				//Modchu_Debug.mdDebug("debaf2="+Modchu_Debug.debaf2, 1);//				//Modchu_Debug.mdDebug("debaf3="+Modchu_Debug.debaf3, 2);//			}		} else {
			
			if (dominantArm == 0) {
				arm.rotateAngleX = 0.0F;
				arm.rotateAngleY = 0.0F;
				arm.rotateAngleZ = 0.5F;
				arm.rotationPointY = 4.0F;
			} else {
				arm.rotateAngleX = 0.0F;
				arm.rotateAngleY = 0.0F;
				arm.rotateAngleZ = -0.5F;
				arm.rotationPointX = 8.0F;
				arm.rotationPointY = 4.0F;
				arm.rotationPointZ = 0.0F;
				//Modchu_Debug.dDebug("X="+arm.rotationPointX+" Y="+arm.rotationPointY+" Z="+arm.rotationPointZ);
			}
			float f6, f7, f8;
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f7 = Helper.sin(f6 * (float) Math.PI);
				f8 = Helper.cos(f6 * (float) Math.PI);
				//Modchu_Debug.mDebug("f7="+f7);
				//arm.rotateAngleZ += f7 * 1.2F;
				//arm.rotateAngleX = Modchu_Debug.debaf1;
				//arm.rotateAngleY = Modchu_Debug.debaf2;
				//arm.rotateAngleZ = Modchu_Debug.debaf3;
				arm.rotateAngleX = 0.2F - f8 * 1.4F;
				arm.rotateAngleY = 0.1F;
				arm.rotateAngleZ = 0.1F;
				//arm.rotateAngleY -= f7 * 0.4F;
				//Modchu_Debug.dDebug("debaf1="+Modchu_Debug.debaf1+" 2="+Modchu_Debug.debaf2+" 3="+Modchu_Debug.debaf3);				//arm.rotationPointX += Modchu_Debug.debaf1;
				//arm.rotationPointY += Modchu_Debug.debaf2;
				//arm.rotationPointZ += Modchu_Debug.debaf3;
				arm.rotationPointX -= f8 * 6F;
				//arm.rotationPointY -= f8 * 6F;
				arm.rotationPointZ -= f8 * 7F;
			}
		}
	}		@Override	public float getHeight(IModelCaps entityCaps) {		return 1.35F;	}		@Override	public float getWidth(IModelCaps entityCaps) {		return 0.5F;	}	@Override	public float getHeight() {		return 1.35F;	}		@Override	public float getWidth() {		return 0.5F;	}	@Override	public float getyOffset(IModelCaps entityCaps) {		return 1.17F;	}	@Override	public float getyOffset() {		return 1.17F;	}	@Override
	public float[] getArmorModelsSize() {
		return new float[]{ 0.1F, 0.5F };
	}		@Override	public float getMountedYOffset(IModelCaps entityCaps) {		float d = 1.0F;		return d;	}		@Override	public float getMountedYOffset() {		float d = 1.0F;		return d;	}	@Override
	public ModelRenderer getDominantArm(IModelCaps entityCaps) {
//		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag) && ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1 | ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 6) {
//			if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;
//			return leftArm;
//		} else {
			if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return bipedRightArm;
			return bipedLeftArm;
//		}
	}	@Override
	public ModelRenderer getArms(int i) {
		return (ModelRenderer) Arms[i];
	}	@Override
	public ModelRenderer getHeadMount() {
		return HeadMount;
	}	@Override
	public String getUsingTexture() {
		return "default";
	}	@Override
	public float getLeashOffset(IModelCaps entityCaps) {
		return 0.4F;
	}	@Override
	public boolean isItemHolder(IModelCaps entityCaps) {
		return true;
	}	/*	 * 	@Override	public void showAllParts(IModelCaps entityCaps) {		int armorType = ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType);		boolean b = armorType == 0;/*		if (entityCaps instanceof IModelCaps				&& ModelCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {			Modchu_Debug.mDebug1("MultiModel showAllParts LMM armorType="+armorType+" b="+b);		} else {			Modchu_Debug.mDebug1("MultiModel showAllParts entityCaps="+entityCaps);			float[] f = getArmorModelsSize();			//Modchu_Debug.mlDebug("modelSize="+modelSize+" "+this);			//Modchu_Debug.mlDebug("modelSize="+modelSize+" f[0]="+f[0]+" f[1]="+f[1]);			armorType = modelSize == f[0] ? 1 : modelSize == f[1] ? 2 : 0;			//Modchu_Debug.mDebug("MultiModel showAllParts LMM armorType="+armorType+" b="+b);		}*/		@Override	public int showArmorParts(IModelCaps entityCaps, int parts, int index) {		switch(parts) {		case 0:			setArmorBipedRightLegShowModel(entityCaps, true);			setArmorBipedLeftLegShowModel(entityCaps, true);			break;		case 1:			setArmorSkirtShowModel(entityCaps, true);			break;		case 2:			setArmorBipedBodyShowModel(entityCaps, true);			setArmorBipedRightArmShowModel(entityCaps, true);			setArmorBipedLeftArmShowModel(entityCaps, true);			break;		case 3:			setArmorBipedHeadShowModel(entityCaps, true);			break;		}		return -1;	}	@Override	public void showAllParts(IModelCaps entityCaps) {		int armorType = ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType); // CORRECT?!?!?!?		boolean b = armorType == 0;/*		if (entityCaps instanceof IModelCaps				&& ModelCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {			Modchu_Debug.mDebug1("MultiModel showAllParts LMM armorType="+armorType+" b="+b);		} else {			Modchu_Debug.mDebug1("MultiModel showAllParts entityCaps="+entityCaps);			float[] f = getArmorModelsSize();			//Modchu_Debug.mlDebug("modelSize="+modelSize+" "+this);			//Modchu_Debug.mlDebug("modelSize="+modelSize+" f[0]="+f[0]+" f[1]="+f[1]);			armorType = modelSize == f[0] ? 1 : modelSize == f[1] ? 2 : 0;			//Modchu_Debug.mDebug("MultiModel showAllParts LMM armorType="+armorType+" b="+b);		}*/		setArmorBipedHeadShowModel(entityCaps, b);		setArmorBipedBodyShowModel(entityCaps, b);		setArmorBipedRightArmShowModel(entityCaps, b);		setArmorBipedLeftArmShowModel(entityCaps, b);		setArmorSkirtShowModel(entityCaps, b);		setArmorBipedRightLegShowModel(entityCaps, b);		setArmorBipedLeftLegShowModel(entityCaps, b);		setArmorBipedOtherShowModel(entityCaps, b);	}	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {		if (Skirt != null) {			if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) {				setCapsValue(entityCaps, caps_visible, Skirt, b);			} else {				setCapsValue(entityCaps, caps_visible, SkirtTop, b);				setCapsValue(entityCaps, caps_visible, SkirtFront, b);				setCapsValue(entityCaps, caps_visible, SkirtRight, b);				setCapsValue(entityCaps, caps_visible, SkirtLeft, b);				setCapsValue(entityCaps, caps_visible, SkirtBack, b);			}		}	}
}
