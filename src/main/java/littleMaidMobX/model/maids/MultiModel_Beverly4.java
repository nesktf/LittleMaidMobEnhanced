package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseBeverly;import littleMaidMobX.render.model.ModelBoxPlate;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_Beverly4 extends ModelModchuBaseBeverly {	public ModelRenderer Headwear;
	public ModelRenderer Body2;
	public ModelRenderer Bodywear;
	public ModelRenderer Body3;
	public ModelRenderer SkirtR;
	public ModelRenderer SkirtL;
	public ModelRenderer shield;
	public ModelRenderer SkirtTopL;
	public ModelRenderer SkirtFrontL;
	public ModelRenderer SkirtLeftL;
	public ModelRenderer SkirtBackL;		public MultiModel_Beverly4(StringBuilder hack) {		super(hack);	}	public MultiModel_Beverly4() {		super();	}	public MultiModel_Beverly4(float f) {		super(f);	}	public MultiModel_Beverly4(float f, float f1) {		this(f, f1, 64, 64);	}	public MultiModel_Beverly4(float f, float f1, int i, int j) {		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f = f > 0.0F ? 0.3F : 0.2F;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.5F, -4.0F, 8, 8, 8, f - 0.5F);
		bipedHead.setTextureOffset(35, 39).addBox(-1.5F, -1.0F, -1.2F, 3, 1, 3, f - 0.5F);//neck
		Headwear = new ModelRenderer(this, 32, 0);
		Headwear.addBox(-4.0F, -9.5F, -4.0F, 8, 12, 8, f);
		bipedBody = new ModelRenderer(this, 20, 28);
		bipedBody.addBox(-2.5F, 0.0F, -1.5F, 5, 8, 3, f);
		Body2 = new ModelRenderer(this, 28, 20);
		Body2.addBox(-3.0F, 1.5F, -0.6F, 6, 3, 3, f);
		Body2.rotateAngleX = -0.7854F;
		Bodywear = new ModelRenderer(this, 16, 47);
		Bodywear.addBox(-3.0F, 0.0F, -2.5F, 6, 8, 5, f + 0.1F);
		Body3 = new ModelRenderer(this, 16, 39);
		Body3.addBox(-3.5F, 8.0F, -2.4F, 7, 3, 5, f);
		rightArm = new ModelRenderer(this, 0, 41);
		rightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 7, 2, f + 0.1F);
		rightArm.rotateAngleZ = 0.08727F;
		rightArm2 = new ModelRenderer(this, 0, 50);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		rightArm2.rotateAngleZ = 0.17453F;
		leftArm = new ModelRenderer(this, 8, 41);
		leftArm.mirror = true;
		leftArm.addBox(0.0F, -1.0F, -1.0F, 2, 7, 2, f + 0.1F);
		leftArm.rotateAngleZ = -0.08727F;
		leftArm2 = new ModelRenderer(this, 8, 50);
		leftArm2.mirror = true;
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		leftArm2.rotateAngleZ = -0.17453F;
		rightLeg = new ModelRenderer(this, 0, 16);
		rightLeg.addBox(-2.5F, 0.0F, -2F, 3, 8, 4, f);
		rightLeg2 = new ModelRenderer(this, 0, 28);
		rightLeg2.addBox(-1.1F, 0.0F, -1.5F, 2, 10, 3, f + 0.3F);
		leftLeg = new ModelRenderer(this, 14, 16);
		leftLeg.mirror = true;
		leftLeg.addBox(-0.5F, 0.0F, -2F, 3, 8, 4, f);
		leftLeg2 = new ModelRenderer(this, 10, 28);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-0.9F, 0.0F, -1.5F, 2, 10, 3, f + 0.3F);
		SkirtR = new ModelRenderer(this, 40, 20);
		SkirtR.addBox(-3F, -3F, -3.3F, 5, 12, 7, f);
		SkirtR.rotateAngleZ = 0.02F;
		SkirtL = new ModelRenderer(this, 40, 39);
		SkirtL.mirror = true;
		SkirtL.addBox(-2F, -3F, -3.3F, 5, 12, 7, f);
		SkirtL.rotateAngleZ = -0.02F;		Skirt = new ModelRenderer(this);		// 追加パーツ
		eyeR = new ModelRenderer(this, 17, 0);
		eyeR.addPlate(-2.6F, -4.3F, -3.51F, 2, 2, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 21, 0);
		eyeL.addPlate(0.6F, -4.3F, -3.51F, 2, 2, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		shield = new ModelRenderer(this, 24, 0);
		shield.addBox(-3.5F, -7F, -1F, 7, 7, 1, f);
		shield.setRotationPoint(2.0F, 5F, 0F);
		shield.rotateAngleX = 0.15F;
		shield.rotateAngleY = -1.5F;
		shield.rotateAngleZ = 0.0F;		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);		bipedRightArm = new ModelRenderer(this);
		bipedLeftArm = new ModelRenderer(this);
		bipedRightLeg = new ModelRenderer(this);
		bipedLeftLeg = new ModelRenderer(this);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightHand = new ModelRenderer(this, 0, 55);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);		leftHand = new ModelRenderer(this, 8, 55);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);		rightArmPlus = new ModelRenderer(this);
		rightArmPlus2 = new ModelRenderer(this);
		leftArmPlus = new ModelRenderer(this);
		leftArmPlus2 = new ModelRenderer(this);
		rightLegPlus = new ModelRenderer(this);
		rightLegPlus2 = new ModelRenderer(this);
		leftLegPlus = new ModelRenderer(this);
		leftLegPlus2 = new ModelRenderer(this);		setCapsValue(null, caps_visible, rightHand, false);
		setCapsValue(null, caps_visible, leftHand, false);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		textureWidth = 64;
		textureHeight = 64;
		//SkirtR 上
		SkirtTop = new ModelRenderer(this, 47, 20);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 5, 7, ModelBoxPlate.planeXZTop);
		SkirtTop.setRotationPoint(-3.0F, -2.5F, -3.5F);		//SkirtR 前
		SkirtFront = new ModelRenderer(this, 47, 27);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 5, 12, ModelBoxPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//SkirtR 右
		SkirtRight = new ModelRenderer(this, 40, 27);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 7, 12, ModelBoxPlate.planeZYRight);
		SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);		//SkirtR 後ろ
		SkirtBack = new ModelRenderer(this, 58, 27);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 5, 12, ModelBoxPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 7.0F);		//SkirtL 上
		SkirtTopL = new ModelRenderer(this, 47, 39);
		SkirtTopL.addPlate(0.0F, 0.0F, 0.0F, 5, 7, ModelBoxPlate.planeXZTop);
		SkirtTopL.setRotationPoint(-2.0F, -2.5F, -3.5F);		//SkirtL 前
		SkirtFrontL = new ModelRenderer(this, 47, 46);
		SkirtFrontL.addPlate(0.0F, 0.0F, 0.0F, 5, 12, ModelBoxPlate.planeXYFront);
		SkirtFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);		//SkirtL 左
		SkirtLeftL = new ModelRenderer(this, 53, 46);
		SkirtLeftL.addPlate(0.0F, 0.0F, 0.0F, 7, 12, ModelBoxPlate.planeZYLeft);
		SkirtLeftL.setRotationPoint(5.0F, 0.0F, 0.0F);		//SkirtL 後ろ
		SkirtBackL = new ModelRenderer(this, 58, 46);
		SkirtBackL.addPlate(0.0F, 0.0F, 0.0F, 5, 12, ModelBoxPlate.planeXYBack);
		SkirtBackL.setRotationPoint(0.0F, 0.0F, 7.0F);		SkirtTop.rotateAngleZ = 0.1F;
		SkirtTopL.rotateAngleZ = -0.1F;		SkirtLeft = new ModelRenderer(this);
	}	@Override
	public void defaultAddChildSetting() {
		HeadMount.clearChildModels();
		HeadTop.clearChildModels();
		bipedHead.clearChildModels();
		bipedBody.clearChildModels();
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(rightArm);
		bipedBody.addChild(leftArm);
		bipedHead.addChild(HeadMount);
		bipedHead.addChild(HeadTop);		bipedHead.addChild(Headwear);
		bipedBody.addChild(Body2);
		bipedBody.addChild(Bodywear);
		bipedBody.addChild(Body3);
		rightArm.addChild(rightArm2);
		leftArm.addChild(leftArm2);
		rightLeg.addChild(rightLeg2);
		leftLeg.addChild(leftLeg2);
		rightLeg.addChild(SkirtR);
		leftLeg.addChild(SkirtL);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		leftArm2.addChild(shield);
		rightArm2.addChild(Arms[0]);
		leftArm2.addChild(Arms[1]);
		((ModelRenderer) mainFrame).clearChildModels();
		mainFrame.addChild(bipedBody);
		mainFrame.addChild(rightLeg);
		mainFrame.addChild(leftLeg);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		rightLeg.addChild(SkirtTop);
		SkirtTop.addChild(SkirtFront);
		SkirtTop.addChild(SkirtRight);
		SkirtTop.addChild(SkirtBack);
		leftLeg.addChild(SkirtTopL);
		SkirtTopL.addChild(SkirtFrontL);
		SkirtTopL.addChild(SkirtLeftL);
		SkirtTopL.addChild(SkirtBackL);
		rightLeg.removeChild(SkirtR);
		leftLeg.removeChild(SkirtL);
		setCapsValue(null, caps_visible, SkirtR, false);
		setCapsValue(null, caps_visible, SkirtL, false);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		bipedHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		bipedBody.rotateAngleX = 0.0F;
		float f6 = (float) Math.cos(f2 * 0.09F) * 0.05F;
		rightArm.rotateAngleZ = 0.2F + f6;
		leftArm.rotateAngleZ = -0.2F - f6;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			//bipedHead.rotationPointY = 1.0F;
			bipedBody.rotationPointY = 0.5F;
			rightLeg.rotationPointY += 4.5F;
			leftLeg.rotationPointY += 4.5F;
			rightLeg.rotationPointZ += 1.0F;
			leftLeg.rotationPointZ += 1.0F;
			rightArm.rotateAngleX = -0.7F;
			leftArm.rotateAngleX = -0.7F;
			SkirtL.rotationPointY = -1.0F;
			SkirtR.rotationPointY = SkirtL.rotationPointY;
			SkirtL.rotateAngleZ = 0.0F;
			SkirtR.rotateAngleZ = -SkirtL.rotateAngleZ;
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {
				rightArm2.rotateAngleZ = 0.0F;
				leftArm2.rotateAngleZ = 0.0F;
				rightArm2.rotateAngleX = 0.0F;
				leftArm2.rotateAngleX = 0.0F;
				rightLeg.rotateAngleX = -0.72F;
				rightLeg2.rotateAngleX = 2.15F;
				leftLeg.rotateAngleX = -0.72F;
				leftLeg2.rotateAngleX = 2.27F;
			} else {
				rightArm2.rotateAngleX = -0.1F;
				leftArm2.rotateAngleX = -0.8F;
				rightLeg.rotateAngleX = -2.15F;
				rightLeg2.rotateAngleX = 1.6F;
				leftLeg.rotateAngleX = -2.1F;
				leftLeg2.rotateAngleX = 1.5F;
			}
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
				upperBody.rotateAngleX = 0.35F;
				bipedHead.rotateAngleX -= 0.35F;
				rightArm.rotateAngleX = 0.3F;
				rightArm2.rotateAngleX = -0.2F;
				leftArm.rotateAngleX = 0.3F;
				leftArm2.rotateAngleX = -0.2F;
				rightLeg.rotationPointZ = leftLeg.rotationPointZ = 3.6F;
				float f7 = (float) Math.cos(f * 0.8F);
				float f9 = (float) Math.cos(f * 0.8F - 1.57F);
				float f11 = f9 >= f7 ? f9 : f7;
				float f13 = f9 <= f7 ? f9 : f7;
				rightLeg.rotateAngleX = f7 * 0.4F * f1 - 0.7F;
				rightLeg2.rotateAngleX = f11 * 0.4F * f1 + 0.7F;
				leftLeg.rotateAngleX = -f7 * 0.4F * f1 - 0.8F;
				leftLeg2.rotateAngleX = -f13 * 0.4F * f1 + 0.5F;
				rightLeg.rotateAngleX += 0.35F;
				leftLeg.rotateAngleX += 0.35F;
			} else {
				upperBody.rotateAngleX = 0.0F;
				rightLeg.rotationPointZ = leftLeg.rotationPointZ = 0.0F;
				float f8 = (float) Math.cos(f * 0.4F);
				float f10 = (float) Math.cos(f * 0.4F - 1.57F);
				float f12 = f10 >= f8 ? f10 : f8;
				float f14 = f10 <= f8 ? f10 : f8;				rightArm.rotateAngleX = -f8 * 0.9F * f1;
				float f15 = rightArm.rotateAngleX > 0.0F ? rightArm.rotateAngleX : -rightArm.rotateAngleX;
				rightArm2.rotateAngleX = -0.5F * f15;
				leftArm.rotateAngleX = f8 * 0.9F * f1;
				f15 = leftArm.rotateAngleX > 0.0F ? leftArm.rotateAngleX : -leftArm.rotateAngleX;
				leftArm2.rotateAngleX = -0.5F * f15;
				rightLeg.rotateAngleX = f8 * 1.2F * f1 + 0.06F;
				rightLeg2.rotateAngleX = f12 * 1.2F * f1 + 0.06F - rightLeg.rotateAngleX;
				leftLeg.rotateAngleX = -f8 * 1.2F * f1 - 0.06F;
				leftLeg2.rotateAngleX = -f14 * 1.2F * f1 + 0.06F - leftLeg.rotateAngleX;
			}
		}		//弓構え 腕
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			float f15 = (float) Math.sin(onGrounds[dominantArm] * 3.141593F);
			float f16 = (float) Math.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);
			rightArm2.rotateAngleZ = 0.0F;
			leftArm2.rotateAngleZ = 0.0F;
			rightArm2.rotateAngleY = -(0.1F - f15 * 0.6F);
			leftArm2.rotateAngleY = 0.1F - f15 * 0.6F;
			rightArm2.rotateAngleX = -1.470796F;
			leftArm2.rotateAngleX = -1.470796F;
			rightArm2.rotateAngleX -= f15 * 1.2F - f16 * 0.4F;
			leftArm2.rotateAngleX -= f15 * 1.2F - f16 * 0.4F;
			rightArm2.rotateAngleZ += (float) Math.cos(f2 * 0.09F) * 0.05F + 0.05F;
			leftArm2.rotateAngleZ -= (float) Math.cos(f2 * 0.09F) * 0.05F + 0.05F;
			rightArm2.rotateAngleX += (float) Math.sin(f2 * 0.067F) * 0.05F;
			leftArm2.rotateAngleX -= (float) Math.sin(f2 * 0.067F) * 0.05F;
			rightArm2.rotateAngleX += bipedHead.rotateAngleX;
			leftArm2.rotateAngleX -= bipedHead.rotateAngleX;
		}		if (armSwingFlag(entityCaps)) {
			// 腕振り
			float f15;
			float f16, f17;
			f16 = Helper.sin(Helper.sqrt(onGrounds[0]) * (float) Math.PI * 2.0F);
			f17 = Helper.sin(Helper.sqrt(onGrounds[1]) * (float) Math.PI * 2.0F);
			bipedBody.rotateAngleY = (f16 - f17) * 0.2F;
			rightArm.rotateAngleY = bipedBody.rotateAngleY;
			leftArm.rotateAngleY = bipedBody.rotateAngleY;			// R
			if (onGrounds[0] > 0F) {
				f15 = 1.0F - onGrounds[0];
				f15 *= f15;
				f15 *= f15;
				f15 = 1.0F - f15;
				float f18 = (float) Math.sin(f15 * 3.141593F) * 1.2F;
				float f8 = (float) Math.sin(onGrounds[0] * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				rightArm.rotateAngleX -= (double) f18 + (double) f8;
				rightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				rightArm.rotateAngleZ = (float) Math.sin(onGrounds[0] * 3.141593F) * -0.4F;
			}			// L
			if (onGrounds[1] > 0F) {
				f15 = 1.0F - onGrounds[1];
				f15 *= f15;
				f15 *= f15;
				f15 = 1.0F - f15;
				float f18 = (float) Math.sin(f15 * 3.141593F) * 1.2F;
				float f8 = (float) Math.sin(onGrounds[1] * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				leftArm.rotateAngleX -= (double) f18 + (double) f8;
				leftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				leftArm.rotateAngleZ = (float) Math.sin(onGrounds[1] * 3.141593F) * -0.4F;
			}
		}		//呼吸 腕
		float fb = (float) Math.cos(f2 * 0.07F) * 0.06F;
		rightArm.rotateAngleZ = 0.2F + fb;
		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait) && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			rightArm.rotateAngleX = (float) Math.sin(f2 * 0.067F) * 0.05F - 0.45F;
			rightArm.rotateAngleY = 0.0F;
			rightArm.rotateAngleZ = -0.2F;
			leftArm.rotateAngleX = rightArm.rotateAngleX;
			leftArm.rotateAngleY = rightArm.rotateAngleY;
			leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
			rightArm2.rotateAngleZ = 0.0F;
			leftArm2.rotateAngleZ = 0.0F;
			rightArm2.rotateAngleX = 0.0F;
			leftArm2.rotateAngleX = 0.0F;
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
				Arms[0].rotationPointX -= 1.0F;
				Arms[0].rotationPointY -= 2.0F;
				Arms[0].rotateAngleZ -= 2.0F;
				Arms[0].rotateAngleX -= 1.5F;
				Arms[0].rotateAngleY += 1.5F;
				Arms[1].rotationPointX -= 1.0F;
				Arms[1].rotationPointY += 2.0F;
				Arms[1].rotateAngleZ += 2.0F;
				Arms[1].rotateAngleX -= 1.5F;
				Arms[1].rotateAngleY += 1.5F;
			} else {
				Arms[0].rotationPointX -= 2.0F;
				Arms[0].rotateAngleZ -= 1.5F;
				Arms[0].rotateAngleX -= 0.5F;
				Arms[0].rotateAngleY += 1.5F;
				Arms[1].rotationPointX += 2.0F;
				Arms[1].rotateAngleZ += 1.5F;
				Arms[1].rotateAngleX -= 0.5F;
				Arms[1].rotateAngleY -= 1.5F;
			}
		}
//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		breastFloats(f, f1, f2, f3, f4, f5, entityCaps);		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float)ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);		SkirtFront.rotationPointX = SkirtBack.rotationPointX = motionY * 5.0F;
		SkirtFrontL.rotationPointX = SkirtBackL.rotationPointX = motionY * 2.0F;
		SkirtRight.rotationPointZ = motionY * 2.0F;
		SkirtLeftL.rotationPointZ = motionY * 2.0F;
		SkirtRight.rotationPointZ = SkirtLeftL.rotationPointZ = motionY * 2.0F;		SkirtFront.rotateAngleX = motionY / 2.0F;
		SkirtRight.rotateAngleZ = -motionY / 2.0F;
		SkirtBack.rotateAngleX = -motionY / 2.0F;
		SkirtFrontL.rotateAngleX = motionY / 2.0F;
		SkirtLeftL.rotateAngleZ = motionY / 2.0F;
		SkirtBackL.rotateAngleX = -motionY / 2.0F;		SkirtFront.scaleX = SkirtBack.scaleX = SkirtFrontL.scaleX = SkirtBackL.scaleX = 1.0F - (motionY * 1.2F);
		SkirtRight.scaleZ = SkirtLeftL.scaleZ = 1.0F - (motionY * 1.2F);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.setRotationPoint(0.0F, -3.5F, 0.0F);
		Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bodywear.setRotationPoint(0.0F, -0.5F, 0.0F);
		Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightArm.setRotationPoint(-2.0F, 1.0F, 0.0F);
		rightArm2.setRotationPoint(-1.0F, 6.0F, 0.0F);
		rightHand.setRotationPoint(0.0F, 6.4F, 0.0F);
		leftArm.setRotationPoint(2.0F, 1.0F, 0.0F);
		leftArm2.setRotationPoint(1.0F, 6.0F, 0.0F);
		leftHand.setRotationPoint(0.0F, 6.4F, 0.0F);
		rightLeg.setRotationPoint(-1.0F, 6.0F, 0.0F);
		rightLeg2.setRotationPoint(-0.5F, 7.0F, 0.0F);
		leftLeg.setRotationPoint(1.0F, 6.0F, 0.0F);
		leftLeg2.setRotationPoint(0.5F, 7.0F, 0.0F);
		SkirtR.setRotationPoint(-0.5F, 1.5F, 0.0F);
		SkirtL.setRotationPoint(0.0F, 1.5F, 0.0F);
		SkirtR.rotateAngleZ = 0.14F;
		SkirtL.rotateAngleZ = -SkirtR.rotateAngleZ;
		rightArm2.rotateAngleZ = 0.2F;
		leftArm2.rotateAngleZ = -0.2F;
		rightLeg.rotateAngleZ = -0.07F;
		leftLeg.rotateAngleZ = 0.07F;
		rightLeg2.rotateAngleZ = 0.07F;
		leftLeg2.rotateAngleZ = -0.07F;
		shield.setRotationPoint(1.5F, 5F, 0F);
		Arms[0].setRotationPoint(0.5F, 4.5F, 0F);
		Arms[1].setRotationPoint(-0.5F, 4.5F, 0F);
		Arms[0].rotateAngleX = 0F;
		Arms[0].rotateAngleY = 0F;
		Arms[0].rotateAngleZ = 0F;
		Arms[1].rotateAngleX = 0F;
		Arms[1].rotateAngleY = 0F;
		Arms[1].rotateAngleZ = 0F;
		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
	}	@Override
	public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedHeadShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, Headwear, b);	}	@Override
	public void setArmorBipedBodyShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, Body2, b);		setCapsValue(entityCaps, caps_visible, Body3, b);		setCapsValue(entityCaps, caps_visible, Bodywear, b);		setCapsValue(entityCaps, caps_visible, shield, b);	}	@Override	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {		if (Skirt != null) {			if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) {				setCapsValue(entityCaps, caps_visible, SkirtR, b);				setCapsValue(entityCaps, caps_visible, SkirtL, b);			} else {				setCapsValue(entityCaps, caps_visible, SkirtTop, b);				setCapsValue(entityCaps, caps_visible, SkirtFront, b);				setCapsValue(entityCaps, caps_visible, SkirtRight, b);				setCapsValue(entityCaps, caps_visible, SkirtLeft, b);				setCapsValue(entityCaps, caps_visible, SkirtBack, b);				setCapsValue(entityCaps, caps_visible, SkirtTopL, b);				setCapsValue(entityCaps, caps_visible, SkirtFrontL, b);				setCapsValue(entityCaps, caps_visible, SkirtLeftL, b);				setCapsValue(entityCaps, caps_visible, SkirtBackL, b);			}		}	}	@Override	public String[] getBreastName() {		return new String[]{ "body2" };	}}