package littleMaidMobX.model.maids;import littleMaidMobX.entity.EntityLittleMaid;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_NM1 extends ModelModchuBaseSR2 {
	public ModelRenderer Headwear;
	public ModelRenderer HornR1;
	public ModelRenderer HornR2;
	public ModelRenderer HornR3;
	public ModelRenderer HornR4;
	public ModelRenderer HeadwearR;
	public ModelRenderer HornL1;
	public ModelRenderer HornL2;
	public ModelRenderer HornL3;
	public ModelRenderer HornL4;
	public ModelRenderer HeadwearL;
	public ModelRenderer ArmR1;
	public ModelRenderer ArmL1;
	public ModelRenderer HandR1;
	public ModelRenderer HandR2;
	public ModelRenderer HandL1;
	public ModelRenderer HandL2;
	public ModelRenderer LegR1;
	public ModelRenderer LegR2;
	public ModelRenderer LegR3;
	public ModelRenderer LegR4;
	public ModelRenderer LegR5;
	public ModelRenderer LegR6;
	public ModelRenderer LegL1;
	public ModelRenderer LegL2;
	public ModelRenderer LegL3;
	public ModelRenderer LegL4;
	public ModelRenderer LegL5;
	public ModelRenderer LegL6;
	public ModelRenderer bootR1;
	public ModelRenderer bootR2;
	public ModelRenderer bootL1;
	public ModelRenderer bootL2;
	public ModelRenderer eyeR1;
	public ModelRenderer eyeL1;
	public ModelRenderer Breast;
	public ModelRenderer Cachusya;
	public ModelRenderer tie;		public MultiModel_NM1(StringBuilder hack) {		super(hack);	}	public MultiModel_NM1() {
		this(0.0F);
	}	public MultiModel_NM1(float f) {
		this(f, 0.0F);
	}	public MultiModel_NM1(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_NM1(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		Headwear = new ModelRenderer(this, 0, 28);
		Headwear.addBox(-4.0F, 0.0F, 1.0F, 8, 12, 3, f);
		Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		Headwear.setRotateAngleX(0.2094395F);
		bipedBody = new ModelRenderer(this, 32, 0);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 9, 4, f);
		bipedBody.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedRightArm = new ModelRenderer(this, 0, 16);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, -2.0F, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 8, 16);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, -2.0F, 0.0F);
		bipedRightLeg = new ModelRenderer(this, 32, 13);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, f);
		bipedRightLeg.setRotationPoint(-1.0F, 13F, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 32, 13);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, f);
		bipedLeftLeg.setRotationPoint(1.0F, 13F, 0.0F);
		Skirt = new ModelRenderer(this, 36, 44);
		Skirt.addBox(-4F, -3F, -3.5F, 8, 14, 6, f);
		Skirt.setRotationPoint(0.0F, -4.0F, 0.0F);
		ChignonB = new ModelRenderer(this, 24, 58);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR1 = new ModelRenderer(this, 52, 28);
		HornR1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
		HornR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR1.setRotateAngleZ(-0.3839724F);
		HornR2 = new ModelRenderer(this, 58, 18);
		HornR2.addBox(-6.9F, -11.3F, 0.0F, 1, 4, 1, f);
		HornR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR2.setRotateAngleZ(0.2792527F);
		HornR3 = new ModelRenderer(this, 52, 22);
		HornR3.addBox(-4.2F, -13F, 0.0F, 1, 4, 1, f);
		HornR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR3.setRotateAngleZ(0.0523599F);
		HornR4 = new ModelRenderer(this, 53, 18);
		HornR4.addBox(-2.4F, -15.2F, 0.0F, 1, 2, 1, f);
		HornR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR4.setRotateAngleZ(-0.0872665F);
		HeadwearR = new ModelRenderer(this, 0, 0);
		HeadwearR.addBox(-4F, 0.0F, -4F, 1, 4, 2, f);
		HeadwearR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmR1 = new ModelRenderer(this, 28, 29);
		ArmR1.addBox(-2F, 4.5F, -1F, 2, 1, 2, f + 0.5F);
		ArmR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandR1 = new ModelRenderer(this, 16, 24);
		HandR1.addBox(-2F, 7.5F, -1F, 2, 2, 2, f + 0.4F);
		HandR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandR2 = new ModelRenderer(this, 16, 16);
		HandR2.addBox(-2F, 6F, -1F, 2, 3, 2, f + 0.2F);
		HandR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR1 = new ModelRenderer(this, 0, 47);
		LegR1.addBox(-2.5F, 2.0F, -2F, 1, 2, 4, f);
		LegR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR2 = new ModelRenderer(this, 0, 43);
		LegR2.addBox(-2F, 2.4F, -3F, 3, 2, 1, f);
		LegR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR3 = new ModelRenderer(this, 11, 44);
		LegR3.addBox(-2F, 5F, 0.0F, 3, 1, 3, f);
		LegR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR4 = new ModelRenderer(this, 5, 53);
		LegR4.addBox(-1F, 2.7F, -5F, 1, 1, 2, f);
		LegR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR5 = new ModelRenderer(this, 0, 53);
		LegR5.addBox(-1F, 2.7F, -3.5F, 1, 2, 1, f);
		LegR5.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR6 = new ModelRenderer(this, 28, 35);
		LegR6.addBox(-3F, 13F, -2F, 3, 11, 4, f + 0.1F);
		LegR6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR1 = new ModelRenderer(this, 0, 57);
		bootR1.addBox(-1.0F, 10F, -3F, 2, 1, 1, f);
		bootR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR2 = new ModelRenderer(this, 0, 53);
		bootR2.addBox(-0.5F, 8F, -6F, 1, 2, 1, f);
		bootR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR2.setRotateAngleX(0.2792527F);
		HornL1 = new ModelRenderer(this, 52, 28);
		HornL1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
		HornL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL1.setRotateAngleZ(0.3839724F);
		HornL2 = new ModelRenderer(this, 58, 18);
		HornL2.addBox(5.9F, -11.3F, 0.0F, 1, 4, 1, f);
		HornL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL2.setRotateAngleZ(-0.2792527F);
		HornL3 = new ModelRenderer(this, 52, 22);
		HornL3.addBox(3.2F, -13F, 0.0F, 1, 4, 1, f);
		HornL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL3.setRotateAngleZ(-0.0523599F);
		HornL4 = new ModelRenderer(this, 53, 18);
		HornL4.addBox(1.4F, -15.2F, 0.0F, 1, 2, 1, f);
		HornL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL4.setRotateAngleZ(0.0872665F);
		HeadwearL = new ModelRenderer(this, 24, 0);
		HeadwearL.addBox(3F, 0.0F, -4F, 1, 4, 2, f);
		HeadwearL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmL1 = new ModelRenderer(this, 41, 29);
		ArmL1.addBox(0.0F, 4.5F, -1F, 2, 1, 2, f + 0.5F);
		ArmL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandL1 = new ModelRenderer(this, 24, 24);
		HandL1.addBox(0.0F, 7.5F, -1F, 2, 2, 2, f + 0.4F);
		HandL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandL2 = new ModelRenderer(this, 24, 16);
		HandL2.addBox(0.0F, 6F, -1F, 2, 3, 2, f + 0.2F);
		HandL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL1 = new ModelRenderer(this, 0, 47);
		LegL1.addBox(1.5F, 2.0F, -2F, 1, 2, 4, f);
		LegL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL2 = new ModelRenderer(this, 0, 43);
		LegL2.addBox(-1F, 2.4F, -3F, 3, 2, 1, f);
		LegL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL3 = new ModelRenderer(this, 11, 44);
		LegL3.addBox(-1F, 5F, 0.0F, 3, 1, 3, f);
		LegL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL4 = new ModelRenderer(this, 5, 53);
		LegL4.addBox(0.0F, 2.7F, -5F, 1, 1, 2, f);
		LegL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL5 = new ModelRenderer(this, 0, 53);
		LegL5.addBox(0.0F, 2.7F, -3.5F, 1, 2, 1, f);
		LegL5.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL6 = new ModelRenderer(this, 28, 35);
		LegL6.addBox(0.0F, 13F, -2F, 3, 11, 4, f + 0.1F);
		LegL6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL1 = new ModelRenderer(this, 0, 57);
		bootL1.addBox(-1.0F, 10F, -3F, 2, 1, 1, f);
		bootL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL2 = new ModelRenderer(this, 0, 53);
		bootL2.addBox(-0.5F, 8F, -6F, 1, 2, 1, f);
		bootL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL2.setRotateAngleX(0.2792527F);
		Breast = new ModelRenderer(this, 53, 0);
		Breast.addBox(0.0F, -2.5F, 0.0F, 3, 5, 2, f);
		Breast.setRotationPoint(0.0F, -1.0F, -2F);
		Breast.setRotateAngleZ(((float) Math.PI / 2F));
		Breast.setRotateAngleY(((float) Math.PI * 2F / 9F));
		eyeR = new ModelRenderer(this, 32, 0);
		eyeR.addPlate(-4F, -4F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 47, 0);
		eyeL.addPlate(0.0F, -4F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR1 = new ModelRenderer(this, 52, 13);
		eyeR1.addPlate(-4F, -4F, -4.002F, 4, 4, 0, f);
		eyeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL1 = new ModelRenderer(this, 56, 13);
		eyeL1.addPlate(0.0F, -4F, -4.002F, 4, 4, 0, f);
		eyeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cachusya = new ModelRenderer(this, 0, 7);
		Cachusya.addPlate(-2F, -9F, -4F, 4, 1, 0, f);
		Cachusya.setRotationPoint(0.0F, 0.0F, 0.0F);
		tie = new ModelRenderer(this, 24, 6);
		tie.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, f + 0.1F);
		tie.setRotationPoint(-0.5F, -8F + f1, -2.1F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);		setCapsValue(null, caps_visible, HornR1, false);
		setCapsValue(null, caps_visible, HornR2, false);
		setCapsValue(null, caps_visible, HornR3, false);
		setCapsValue(null, caps_visible, HornR4, false);
		setCapsValue(null, caps_visible, HornL1, false);
		setCapsValue(null, caps_visible, HornL2, false);
		setCapsValue(null, caps_visible, HornL3, false);
		setCapsValue(null, caps_visible, HornL4, false);
		setCapsValue(null, caps_visible, ArmR1, false);
		setCapsValue(null, caps_visible, HandR1, false);
		setCapsValue(null, caps_visible, HandR2, false);
		setCapsValue(null, caps_visible, ArmL1, false);
		setCapsValue(null, caps_visible, HandL1, false);
		setCapsValue(null, caps_visible, HandL2, false);
		setCapsValue(null, caps_visible, LegR1, false);
		setCapsValue(null, caps_visible, LegR2, false);
		setCapsValue(null, caps_visible, LegR3, false);
		setCapsValue(null, caps_visible, LegR4, false);
		setCapsValue(null, caps_visible, LegR5, false);
		setCapsValue(null, caps_visible, LegL1, false);
		setCapsValue(null, caps_visible, LegL2, false);
		setCapsValue(null, caps_visible, LegL3, false);
		setCapsValue(null, caps_visible, LegL4, false);
		setCapsValue(null, caps_visible, LegL5, false);
		setCapsValue(null, caps_visible, bipedLeftLeg, false);
		setCapsValue(null, caps_visible, bipedRightLeg, false);
		setCapsValue(null, caps_visible, bootR1, false);
		setCapsValue(null, caps_visible, bootR2, false);
		setCapsValue(null, caps_visible, bootL1, false);
		setCapsValue(null, caps_visible, bootL2, false);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModelRenderer(this, 0, 16);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm.setRotationPoint(-3.0F, 1.5F + f1, 0.0F);		rightArmPlus = new ModelRenderer(this);
		rightArmPlus.setTextureOffset(4, 16).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModelRenderer(this, 0, 19);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		rightArmPlus2 = new ModelRenderer(this);
		rightArmPlus2.setTextureOffset(4, 16).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		rightArmPlus2.setTextureOffset(4, 16).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModelRenderer(this, 0, 22);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);		leftArm = new ModelRenderer(this, 8, 16);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm.setRotationPoint(3.0F, 1.5F + f1, 0.0F);		leftArmPlus = new ModelRenderer(this);
		leftArmPlus.setTextureOffset(12, 16).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModelRenderer(this, 8, 20);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		leftArmPlus2 = new ModelRenderer(this);
		leftArmPlus2.setTextureOffset(12, 16).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		leftArmPlus2.setTextureOffset(12, 16).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModelRenderer(this, 8, 24);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);		rightLeg = new ModelRenderer(this, 32, 13);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModelRenderer(this);
		rightLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModelRenderer(this, 32, 18);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModelRenderer(this);
		rightLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		rightLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -6.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModelRenderer(this, 32, 13);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModelRenderer(this);
		leftLegPlus.mirror = true;
		leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModelRenderer(this, 32, 18);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModelRenderer(this);
		leftLegPlus2.mirror = true;
		leftLegPlus2.setTextureOffset(36, 13).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		leftLegPlus2.setTextureOffset(39, 13).addPlate(-1.5F, -2.0F, -6.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedHead.removeChild(Tail);
		bipedHead.addChild(Headwear);
		bipedHead.addChild(Cachusya);
		bipedHead.addChild(eyeR1);
		bipedHead.addChild(eyeL1);
		bipedHead.addChild(HornR1);
		bipedHead.addChild(HornR2);
		bipedHead.addChild(HornR3);
		bipedHead.addChild(HornR4);
		bipedHead.addChild(HeadwearR);
		bipedHead.addChild(HornL1);
		bipedHead.addChild(HornL2);
		bipedHead.addChild(HornL3);
		bipedHead.addChild(HornL4);
		bipedHead.addChild(HornL4);
		bipedHead.addChild(HeadwearL);
		bipedBody.addChild(Breast);
		bipedBody.addChild(tie);
		bipedRightArm.addChild(ArmR1);
		bipedRightArm.addChild(HandR1);
		bipedRightArm.addChild(HandR2);
		bipedLeftArm.addChild(ArmL1);
		bipedLeftArm.addChild(HandL1);
		bipedLeftArm.addChild(HandL2);
		bipedRightLeg.addChild(LegR1);
		bipedRightLeg.addChild(LegR2);
		bipedRightLeg.addChild(LegR3);
		bipedRightLeg.addChild(LegR4);
		bipedRightLeg.addChild(LegR5);
		bipedRightLeg.addChild(bootR1);
		bipedRightLeg.addChild(bootR2);
		bipedLeftLeg.addChild(LegL1);
		bipedLeftLeg.addChild(LegL2);
		bipedLeftLeg.addChild(LegL3);
		bipedLeftLeg.addChild(LegL4);
		bipedLeftLeg.addChild(LegL5);
		bipedLeftLeg.addChild(bootL1);
		bipedLeftLeg.addChild(bootL2);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Arms[0].setRotationPoint(0.5F, 9.0F, 0F);
		Arms[1].setRotationPoint(-0.5F, 9.0F, 0F);
		Arms[0].rotateAngleX =
		Arms[0].rotateAngleY =
		Arms[0].rotateAngleZ =
		Arms[1].rotateAngleX =
		Arms[1].rotateAngleY =
		Arms[1].rotateAngleZ = 0F;
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		int ticksExisted = Helper.getEntityTicksExisted(entityliving);
		float f3 = (float)ticksExisted + f2 + ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);		eyeR.showModel = eyeL.showModel =
		eyeR1.showModel = eyeL1.showModel = false;
		Skirt.showModel = true;
		HornR1.showModel = HornR2.showModel =
		HornR3.showModel = HornR4.showModel =
		HornL1.showModel = HornL2.showModel =
		HornL3.showModel = HornL4.showModel =
		ArmR1.showModel = HandR1.showModel =
		HandR2.showModel = ArmL1.showModel =
		HandL1.showModel = HandL2.showModel =
		LegR1.showModel = LegR2.showModel =
		LegR3.showModel = LegR4.showModel =
		LegR5.showModel = LegL1.showModel =
		LegL2.showModel = LegL3.showModel =
		LegL4.showModel = LegL5.showModel = false;
		LegR6.showModel = LegR6.showModel = true;
		bipedLeftLeg.showModel = bipedRightLeg.showModel =
		bootR1.showModel = bootR2.showModel =
		bootL1.showModel = bootL2.showModel = false;
		if (!ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			boolean isWorkingDelay = ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWorkingDelay);
			if (isWorkingDelay) {
//-@-125
				int maidMode = 0;				if (entityliving instanceof EntityLittleMaid) {					maidMode = ((EntityLittleMaid)entityliving).getMaidModeInt();				}
				int i = 0x00C0;
				int i1 = 0x0021;
//@-@125
/*//125delete
				int maidMode = (Integer)getObjectInvokeMethod(LMM_EntityLittleMaid, "getMaidMode", entityliving);
				int i = 4;
				int i1 = 7;
*///125delete
				if (maidMode == i | maidMode == i1) {
					eyeR1.showModel = eyeL1.showModel = true;
					Skirt.showModel = false;
					HornR1.showModel = HornR2.showModel =
					HornR3.showModel = HornR4.showModel =
					HornL1.showModel = HornL2.showModel =
					HornL3.showModel = HornL4.showModel =
					ArmR1.showModel = HandR1.showModel =
					HandR2.showModel = ArmL1.showModel =
					HandL1.showModel = HandL2.showModel =
					LegR1.showModel = LegR2.showModel =
					LegR3.showModel = LegR4.showModel =
					LegR5.showModel = LegL1.showModel =
					LegL2.showModel = LegL3.showModel =
					LegL4.showModel = LegL5.showModel = true;
					LegR6.showModel = LegR6.showModel = false;
					bipedLeftLeg.showModel = bipedRightLeg.showModel =
					bootR1.showModel = bootR2.showModel =
					bootL1.showModel = bootL2.showModel = true;
				}
			}
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		bipedHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		bipedHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		bipedRightArm.rotateAngleX = Helper.cos(f * 0.5656F + (float) Math.PI) * 1.6F * f1 * 0.5F;
		bipedLeftArm.rotateAngleX = Helper.cos(f * 0.5656F) * 1.6F * f1 * 0.5F;
		bipedRightArm.rotateAngleZ =
		bipedLeftArm.rotateAngleZ = 0.0F;
		bipedRightLeg.rotateAngleX = Helper.cos(f * 0.5656F) * 1.0F * f1;
		bipedLeftLeg.rotateAngleX = Helper.cos(f * 0.5656F + (float) Math.PI) * 1.0F * f1;
		bipedRightLeg.rotateAngleY =
		bipedLeftLeg.rotateAngleY = 0.0F;
		bipedBody.rotationPointY = 8.0F;
		bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = -3.5F;
		bipedLeftArm.rotationPointX = 3.0F;
		bipedLeftArm.rotationPointZ = 0.0F;
		Breast.rotationPointY = -2.5F;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
			bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}		if (heldItem[1] != 0) {			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * heldItem[1];		}		if (heldItem[0] != 0) {			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * heldItem[0];		}		bipedRightArm.rotateAngleY =
		bipedLeftArm.rotateAngleY = 0.0F;
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		bipedBody.rotateAngleX =
		bipedBody.rotateAngleY =
		bipedBody.rotateAngleZ = 0.0F;
		bipedBody.rotationPointZ = 0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			upperBody.rotateAngleX = 0.5F;
			bipedHead.rotateAngleX -= 0.5F;
			bipedHead.rotationPointY = -3F;
			//bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 2.4F;
			bipedBody.rotationPointY -= 1.0F;
			Skirt.rotateAngleX = -upperBody.rotateAngleX;
			Skirt.rotationPointY = 4.3F;
			//Skirt.rotationPointZ = 3.0F;
		} else {
			upperBody.rotateAngleX = 0.0F;
			bipedHead.rotationPointY = -3F;
			bipedRightLeg.rotationPointX = -1.5F;
			bipedLeftLeg.rotationPointX = 1.5F;
			bipedRightLeg.rotationPointY =
			bipedLeftLeg.rotationPointY = 5.5F;
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
			Skirt.rotationPointY = 5.5F;
			Skirt.rotationPointZ =
			Skirt.rotateAngleX = 0.0F;
		}		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait) && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			bipedRightArm.rotateAngleX = Helper.sin(f2 * 0.067F) * 0.05F - 0.7F;
			bipedRightArm.rotateAngleY = 0.0F;
			bipedRightArm.rotateAngleZ = -0.4F;
			bipedLeftArm.rotateAngleX = Helper.sin(f2 * 0.067F) * 0.05F - 0.7F;
			bipedLeftArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.4F;
			Arms[0].rotationPointX -= 2.0F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			Arms[1].rotationPointX += 2.0F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			float f7 = Helper.sin(onGrounds[dominantArm] * (float) Math.PI);
			float f9 = Helper.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * (float) Math.PI);
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f7 * 0.6F);
			bipedLeftArm.rotateAngleY = 0.1F - f7 * 0.6F;
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedLeftArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f7 * 1.2F - f9 * 0.4F;
			bipedLeftArm.rotateAngleX -= f7 * 1.2F - f9 * 0.4F;
			bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX -= Helper.sin(f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX -= bipedHead.rotateAngleX;
			bipedRightArm.rotateAngleY += bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY += bipedHead.rotateAngleY;
		} else {
			if (!ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {
				bipedRightArm.rotateAngleZ += 0.3F;
				bipedLeftArm.rotateAngleZ -= 0.3F;
				bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= Helper.sin(f2 * 0.067F) * 0.05F;
			}
		}
		breastFloats(f, f1, f2, f3, f4, f5, entityCaps);//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}}