package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;public class MultiModel_dm extends ModelModchuBaseSR2 {
	public ModelRenderer HornR1;
	public ModelRenderer HornR2;
	public ModelRenderer HornR3;
	public ModelRenderer HornR4;
	public ModelRenderer HornR5;
	public ModelRenderer HornR6;
	public ModelRenderer HornR7;
	public ModelRenderer HornR8;
	public ModelRenderer HornR9;
	public ModelRenderer HornR10;
	public ModelRenderer HornL1;
	public ModelRenderer HornL2;
	public ModelRenderer HornL3;
	public ModelRenderer HornL4;
	public ModelRenderer HornL5;
	public ModelRenderer HornL6;
	public ModelRenderer HornL7;
	public ModelRenderer HornL8;
	public ModelRenderer HornL9;
	public ModelRenderer HornL10;
	public ModelRenderer HairR1;
	public ModelRenderer HairR2;
	public ModelRenderer HairR3;
	public ModelRenderer HairL1;
	public ModelRenderer HairL2;
	public ModelRenderer HairL3;
	public ModelRenderer WingR1;
	public ModelRenderer WingR2;
	public ModelRenderer WingR3;
	public ModelRenderer WingL1;
	public ModelRenderer WingL2;
	public ModelRenderer WingL3;
	public ModelRenderer Cachusya;
	public ModelRenderer Bribonc;
	public ModelRenderer BribonR;
	public ModelRenderer BribonL;
	public ModelRenderer Breast1;
	public ModelRenderer Cheek_R;
	public ModelRenderer Cheek_L;		public MultiModel_dm(StringBuilder hack) {		super(hack);	}	public MultiModel_dm() {
		this(0.0F);
	}	public MultiModel_dm(float f) {
		this(f, 0.0F);
	}	public MultiModel_dm(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_dm(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
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
		Skirt = new ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
		HornR1 = new ModelRenderer(this, 0, 6);
		HornR1.addBox(-1F, -9F, -1F, 3, 1, 1, f);
		HornR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR1.setRotateAngleZ(-0.6108652F);
		HornR2 = new ModelRenderer(this, 0, 0);
		HornR2.addBox(-2.7F, -9.5F, -1F, 1, 1, 1, f);
		HornR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR2.setRotateAngleZ(-0.296706F);
		HornR3 = new ModelRenderer(this, 0, 6);
		HornR3.addBox(-5.2F, -9.8F, -1F, 3, 1, 1, f);
		HornR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR3.setRotateAngleZ(-0.1396263F);
		HornR4 = new ModelRenderer(this, 0, 0);
		HornR4.addBox(-5F, -10.2F, -1F, 1, 1, 1, f);
		HornR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR4.setRotateAngleZ(-0.0349066F);
		HornR5 = new ModelRenderer(this, 0, 6);
		HornR5.addBox(-7.5F, -10F, -1F, 3, 1, 1, f);
		HornR5.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR5.setRotateAngleZ(0.122173F);
		HornR6 = new ModelRenderer(this, 0, 0);
		HornR6.addBox(-6.5F, -10.7F, -1F, 1, 1, 1, f);
		HornR6.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR6.setRotateAngleZ(0.1396263F);
		HornR7 = new ModelRenderer(this, 0, 6);
		HornR7.addBox(-9F, -10.5F, -1F, 3, 1, 1, f);
		HornR7.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR7.setRotateAngleZ(0.2792527F);
		HornR8 = new ModelRenderer(this, 0, 0);
		HornR8.addBox(-8F, -11F, -1F, 1, 1, 1, f);
		HornR8.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR8.setRotateAngleZ(0.296706F);
		HornR9 = new ModelRenderer(this, 0, 3);
		HornR9.addBox(-9F, -11.5F, -1F, 2, 1, 1, f);
		HornR9.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR9.setRotateAngleZ(0.3490659F);
		HornR10 = new ModelRenderer(this, 0, 0);
		HornR10.addBox(-14.4F, -3F, -1F, 1, 1, 1, f);
		HornR10.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR10.setRotateAngleZ(1.151917F);
		HornL1 = new ModelRenderer(this, 0, 6);
		HornL1.addBox(-2F, -9F, -1F, 3, 1, 1, f);
		HornL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL1.setRotateAngleZ(0.6108652F);
		HornL2 = new ModelRenderer(this, 0, 0);
		HornL2.addBox(1.7F, -9.5F, -1F, 1, 1, 1, f);
		HornL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL2.setRotateAngleZ(0.296706F);
		HornL3 = new ModelRenderer(this, 0, 6);
		HornL3.addBox(2.2F, -9.8F, -1F, 3, 1, 1, f);
		HornL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL3.setRotateAngleZ(0.1396263F);
		HornL4 = new ModelRenderer(this, 0, 0);
		HornL4.addBox(4F, -10.2F, -1F, 1, 1, 1, f);
		HornL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL4.setRotateAngleZ(0.0349066F);
		HornL5 = new ModelRenderer(this, 0, 6);
		HornL5.addBox(4.5F, -10F, -1F, 3, 1, 1, f);
		HornL5.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL5.setRotateAngleZ(-0.122173F);
		HornL6 = new ModelRenderer(this, 0, 0);
		HornL6.addBox(5.5F, -10.7F, -1F, 1, 1, 1, f);
		HornL6.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL6.setRotateAngleZ(-0.1396263F);
		HornL7 = new ModelRenderer(this, 0, 6);
		HornL7.addBox(6F, -10.5F, -1F, 3, 1, 1, f);
		HornL7.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL7.setRotateAngleZ(-0.2792527F);
		HornL8 = new ModelRenderer(this, 0, 0);
		HornL8.addBox(7F, -11F, -1F, 1, 1, 1, f);
		HornL8.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL8.setRotateAngleZ(-0.296706F);
		HornL9 = new ModelRenderer(this, 0, 3);
		HornL9.addBox(7F, -11.5F, -1F, 2, 1, 1, f);
		HornL9.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL9.setRotateAngleZ(-0.3490659F);
		HornL10 = new ModelRenderer(this, 0, 0);
		HornL10.addBox(13.4F, -3F, -1F, 1, 1, 1, f);
		HornL10.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL10.setRotateAngleZ(-1.151917F);
		HairR1 = new ModelRenderer(this, 52, 10);
		HairR1.addBox(-5F, -7F, -2F, 1, 5, 5, f);
		HairR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HairR2 = new ModelRenderer(this, 6, 32);
		HairR2.addBox(-5F, -2F, -4F, 1, 2, 6, f);
		HairR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HairR3 = new ModelRenderer(this, 24, 5);
		HairR3.addBox(-4F, 0.0F, -4F, 1, 2, 1, f);
		HairR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HairL1 = new ModelRenderer(this, 52, 10);
		HairL1.addBox(4F, -7F, -2F, 1, 5, 5, f);
		HairL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HairL2 = new ModelRenderer(this, 6, 32);
		HairL2.addBox(4F, -2F, -4F, 1, 2, 6, f);
		HairL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HairL3 = new ModelRenderer(this, 24, 5);
		HairL3.addBox(3F, 0.0F, -4F, 1, 2, 1, f);
		HairL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		WingR1 = new ModelRenderer(this, 30, 0);
		WingR1.addBox(-5F, 0.0F, 2.0F, 3, 1, 1, f);
		WingR1.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingR1.setRotateAngleZ(-0.7330383F);
		WingR2 = new ModelRenderer(this, 39, 0);
		WingR2.addBox(-5F, -2F, 2.0F, 1, 3, 1, f);
		WingR2.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingR2.setRotateAngleZ(-((float) Math.PI * 2F / 9F));
		WingR3 = new ModelRenderer(this, 44, 0);
		WingR3.addBox(-5F, 1.0F, 2.0F, 1, 5, 1, f);
		WingR3.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingR3.setRotateAngleZ(0.1745329F);
		WingL1 = new ModelRenderer(this, 30, 0);
		WingL1.addBox(2.0F, 0.0F, 2.0F, 3, 1, 1, f);
		WingL1.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingL1.setRotateAngleZ(0.7330383F);
		WingL2 = new ModelRenderer(this, 39, 0);
		WingL2.addBox(4F, -2F, 2.0F, 1, 3, 1, f);
		WingL2.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingL2.setRotateAngleZ(((float) Math.PI * 2F / 9F));
		WingL3 = new ModelRenderer(this, 44, 0);
		WingL3.addBox(4F, 1.0F, 2.0F, 1, 5, 1, f);
		WingL3.setRotationPoint(0.0F, -4.0F, 0.0F);
		WingL3.setRotateAngleZ(-0.1745329F);
		Cachusya = new ModelRenderer(this, 24, 33);
		Cachusya.addPlate(-2F, -9F, -4F, 4, 1, 0, f);
		Cachusya.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bribonc = new ModelRenderer(this, 0, 20);
		Bribonc.addBox(-0.5F, 4.6F, 3F, 1, 1, 2, f);
		Bribonc.setRotationPoint(0.0F, -4.0F, 0.0F);
		BribonR = new ModelRenderer(this, 24, 19);
		BribonR.addPlate(-3.5F, 4.6F, 4.7F, 3, 3, 0, f);
		BribonR.setRotationPoint(0.0F, -4.0F, 0.0F);
		BribonL = new ModelRenderer(this, 24, 16);
		BribonL.addPlate(0.5F, 4.6F, 4.7F, 3, 3, 0, f);
		BribonL.setRotationPoint(0.0F, -4.0F, 0.0F);
		Breast1 = new ModelRenderer(this, 0, 32);
		Breast1.addBox(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
		Breast1.setRotationPoint(0.0F, -2.5F, -2F);
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
		Cheek_R.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cheek_L = new ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(HornR1);
		bipedHead.addChild(HornR2);
		bipedHead.addChild(HornR3);
		bipedHead.addChild(HornR4);
		bipedHead.addChild(HornR5);
		bipedHead.addChild(HornR6);
		bipedHead.addChild(HornR7);
		bipedHead.addChild(HornR8);
		bipedHead.addChild(HornR9);
		bipedHead.addChild(HornR10);
		bipedHead.addChild(HornL1);
		bipedHead.addChild(HornL2);
		bipedHead.addChild(HornL3);
		bipedHead.addChild(HornL4);
		bipedHead.addChild(HornL5);
		bipedHead.addChild(HornL6);
		bipedHead.addChild(HornL7);
		bipedHead.addChild(HornL8);
		bipedHead.addChild(HornL9);
		bipedHead.addChild(HornL10);
		bipedHead.addChild(Cachusya);
		bipedHead.addChild(Cachusya);
		bipedHead.addChild(HairR1);
		bipedHead.addChild(HairR2);
		bipedHead.addChild(HairR3);
		bipedHead.addChild(HairL1);
		bipedHead.addChild(HairL2);
		bipedHead.addChild(HairL3);
		bipedBody.addChild(Bribonc);
		bipedBody.addChild(BribonR);
		bipedBody.addChild(BribonL);
		bipedBody.addChild(WingR1);
		bipedBody.addChild(WingR2);
		bipedBody.addChild(WingR3);
		bipedBody.addChild(WingL1);
		bipedBody.addChild(WingL2);
		bipedBody.addChild(WingL3);
		bipedBody.addChild(Breast1);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
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
	}	@Override	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		Breast1.setRotationPoint(0.0F, -2.5F, -2F);	}/*	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
		//rightHand.rotationPointY = 0.0F;
		//leftHand.rotationPointY = 0.0F;
		//rightHand.rotateAngleY = 0.0F;
		//leftHand.rotateAngleY = 0.0F;
	}
*/}