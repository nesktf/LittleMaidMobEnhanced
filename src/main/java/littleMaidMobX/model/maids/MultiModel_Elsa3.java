package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelBoxPlate;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;/**
 * 標準意匠
 * 身長1.75ブロック級
 */
public class MultiModel_Elsa3 extends ModelModchuBaseSR2 {	public ModelRenderer Ponytail;
	public ModelRenderer BunchR;
	public ModelRenderer BunchL;
	protected byte offsetY;
	protected byte headPosY;
	protected byte bodyPosY;
	protected byte legPosY;		public MultiModel_Elsa3(StringBuilder hack) {		super(hack);	}	public MultiModel_Elsa3() {
		this(0.0F);
	}	public MultiModel_Elsa3(float f) {
		this(f, 0.0F);
	}	public MultiModel_Elsa3(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Elsa3(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		offsetY = (byte) (f1 + 10); //Global to Local		bodyPosY = -6; //Local waist height = always 0 (ORIGIN)
		headPosY = 0; //Local neck height = 0 - upper bodyLength
		legPosY = 9; //Lcal hip joint height = 0 + lower bodyLength		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);		bipedHeadwear = new ModelRenderer(this, 34, -3);
		bipedHeadwear.addBox(-4F, -0.01F, 1F, 8, 4, 3, f);		bipedBody = new ModelRenderer(this, 32, 4);
		bipedBody.addBox(-3F, 0F, -2F, 6, 9, 4, f);		bipedRightArm = new ModelRenderer(this, 42, 17);
		bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);		bipedLeftArm = new ModelRenderer(this, 50, 17);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(0F, -1F, -1F, 2, 10, 2, f);		bipedRightLeg = new ModelRenderer(this, 28, 17);
		bipedRightLeg.addBox(-2F, 0F, -2F, 3, 11, 4, f);		bipedLeftLeg = new ModelRenderer(this, 28, 17);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0F, -2F, 3, 11, 4, f);		Skirt = new ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -3F, -3F, 8, 10, 6, f);
		Skirt.setRotationPoint(0F, 13F, 0F);		ChignonR = new ModelRenderer(this, 0, 2);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0F, 0F, 0F);		ChignonL = new ModelRenderer(this, 0, 2);
		ChignonL.mirror = true;
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0F, 0F, 0F);		ChignonB = new ModelRenderer(this, 24, 2);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0F, 0F, 0F);		eyeR = new ModelRenderer(this, 17, 0);
		eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);
		eyeR.setRotationPoint(0F, 0F, 0F);		eyeL = new ModelRenderer(this, 21, 0);
		eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);
		eyeL.setRotationPoint(0F, 0F, 0F);		Ponytail = new ModelRenderer(this, 52, 5);
		Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);
		Ponytail.setRotationPoint(0F, -5.2F, 5F);		BunchR = new ModelRenderer(this, 58, 18);
		BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);
		BunchR.setRotationPoint(-4.5F, -5.5F, 1.7F);		BunchL = new ModelRenderer(this, 58, 18);
		BunchL.mirror = true;
		BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);
		BunchL.setRotationPoint(4.5F, -5.5F, 1.7F);		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, offsetY, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModelRenderer(this, 42, 17);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		rightArmPlus = new ModelRenderer(this);		rightArm2 = new ModelRenderer(this, 42, 22);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		rightArm2.setRotationPoint(0.0F, 5.0F, 0.0F);		rightArmPlus2 = new ModelRenderer(this);		rightHand = new ModelRenderer(this, 42, 25);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm = new ModelRenderer(this, 50, 17);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		leftArmPlus = new ModelRenderer(this);		leftArm2 = new ModelRenderer(this, 50, 22);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new ModelRenderer(this);		leftHand = new ModelRenderer(this, 50, 25);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg = new ModelRenderer(this, 28, 17);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModelRenderer(this);		rightLeg2 = new ModelRenderer(this, 28, 22);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModelRenderer(this);		leftLeg = new ModelRenderer(this, 28, 17);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModelRenderer(this);
		leftLegPlus.mirror = true;
		leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModelRenderer(this, 28, 22);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModelRenderer(this);		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		bipedBody.setRotationPoint(0F, bodyPosY, 0F);		//INIT POSITION
		bipedHead.setRotationPoint(0F, headPosY, 0F);
		HeadMount.setRotationPoint(0F, 0F, 0F);
		eyeR.setRotationPoint(0F, 0F, 0F);
		eyeL.setRotationPoint(0F, 0F, 0F);
		Ponytail.setRotationPoint(0F, -5.2F, 5F);
		BunchR.setRotationPoint(-4.5F, -5.5F, 1.7F);
		BunchL.setRotationPoint(4.5F, -5.5F, 1.7F);		bipedRightArm.setRotationPoint(-2.0F, 1F, 0F);
		bipedLeftArm.setRotationPoint(2.0F, 1F, 0F);		bipedRightLeg.setRotationPoint(-1.2F, legPosY, 0F);
		Arms[0].setRotationPoint(-0.7F, 8.5F, 0F);
		bipedLeftLeg.setRotationPoint(1.2F, legPosY, 0F);
		Arms[1].setRotationPoint(0.7F, 8.5F, 0F);		Skirt.setRotationPoint(0F, (float)legPosY, 0F);		bipedBody.setRotationPoint(0F, bodyPosY, 0F);		mainFrame.setRotationPoint(0F, offsetY, 0F);		//INIT ROTATION
		bipedHead.rotateAngleX = 0F;
		bipedHead.rotateAngleY = 0F;
		bipedHead.rotateAngleZ = 0F;
		Ponytail.rotateAngleX = 0.05F;
		Ponytail.rotateAngleY = 0F;
		Ponytail.rotateAngleZ = 0F;
		BunchR.rotateAngleX = 0F;
		BunchR.rotateAngleY = 0F;
		BunchR.rotateAngleZ = 0.05F;
		BunchL.rotateAngleX = 0F;
		BunchL.rotateAngleY = 0F;
		BunchL.rotateAngleZ = -0.05F;		bipedRightArm.rotateAngleY = 0F;
		bipedRightArm.rotateAngleZ = 0F;
		Arms[0].rotateAngleX = 0F;
		Arms[0].rotateAngleY = 0F;
		Arms[0].rotateAngleZ = 0F;
		bipedLeftArm.rotateAngleY = 0F;
		bipedLeftArm.rotateAngleZ = 0F;
		Arms[1].rotateAngleX = 0F;
		Arms[1].rotateAngleY = 0F;
		Arms[1].rotateAngleZ = 0F;		bipedRightLeg.rotateAngleX = 0.05F;
		bipedRightLeg.rotateAngleY = 0.1F;
		bipedRightLeg.rotateAngleZ = -0.05F;
		bipedLeftLeg.rotateAngleX = 0.05F;
		bipedLeftLeg.rotateAngleY = -0.1F;
		bipedLeftLeg.rotateAngleZ = 0.05F;		Skirt.rotateAngleX = 0F;
		Skirt.rotateAngleY = 0F;
		Skirt.rotateAngleZ = 0F;		bipedBody.rotateAngleX = -0.05F;
		bipedBody.rotateAngleY = 0F;		//ふわりスカート
		Object entity = getCapsValue(caps_Entity);
		if (entity != null); else return;
		float velY = (float)ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY) + 0.1F;		float fwBuf1 = velY * 5F;
		fwBuf1 = fwBuf1 > 1F ? 1F : fwBuf1;
		fwBuf1 = fwBuf1 < -2.5F ? -2.5F : fwBuf1;
		Skirt.rotationPointY += fwBuf1;		float fwBuf2 = velY * 2F;
		fwBuf2 = fwBuf2 > 0.1F ? 0.1F : fwBuf2;
		fwBuf2 = fwBuf2 < -0.7F ? -0.7F : fwBuf2;
		Ponytail.rotateAngleX -= fwBuf2;
		BunchR.rotateAngleZ -= fwBuf2;
		BunchL.rotateAngleZ += fwBuf2;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		//上
		SkirtTop = new ModelRenderer(this, 6, 16);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 6, ModelBoxPlate.planeXZTop);
		SkirtTop.setRotationPoint(-4.0F, -3.0F, -3.0F);		//前
		SkirtFront = new ModelRenderer(this, 6, 22);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 10, ModelBoxPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//右
		SkirtRight = new ModelRenderer(this, 0, 22);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 6, 10, ModelBoxPlate.planeZYRight);
		SkirtRight.setRotationPoint(8.0F, 0.0F, 0.0F);		//左
		SkirtLeft = new ModelRenderer(this, 14, 22);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 6, 10, ModelBoxPlate.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//後ろ
		SkirtBack = new ModelRenderer(this, 20, 22);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 10, ModelBoxPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 6.0F);
		setCapsValue(null, caps_visible, Skirt, false);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
	}	/**
	 * 姿勢制御・更新差分
	 */
	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		//頭部
		bipedHead.rotateAngleY += f3 / 57.29578F;
		bipedHead.rotateAngleX += f4 / 57.29578F;
		//ポニテツインテ
		Ponytail.rotateAngleX += BunchR.rotateAngleX = BunchL.rotateAngleX = -bipedHead.rotateAngleX;
		Ponytail.rotateAngleZ -= bipedHead.rotateAngleZ;
		if (bipedHead.rotateAngleZ > 0) {
			BunchR.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		} else {
			BunchL.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		}		bipedRightArm.rotateAngleZ = 0F;
		//歩行
		bipedRightArm.rotateAngleX = -Helper.cos(f * 0.5656F) * 0.8F * f1;
		bipedLeftArm.rotateAngleX = Helper.cos(f * 0.5656F) * 0.8F * f1;
		bipedRightLeg.rotateAngleX += Helper.cos(f * 0.5656F) * 1.2F * f1;
		bipedLeftLeg.rotateAngleX -= Helper.cos(f * 0.5656F) * 1.2F * f1;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			// 乗り物に乗っている
			bipedRightArm.rotateAngleX -= 0.3F;
			bipedLeftArm.rotateAngleX -= 0.3F;
			bipedRightLeg.rotateAngleX -= 1.2F;
			bipedLeftLeg.rotateAngleX -= 1.2F;
			bipedRightLeg.rotateAngleY += 0.2F;
			bipedLeftLeg.rotateAngleY -= 0.2F;
			Skirt.rotateAngleX -= 1.2F;
			mainFrame.rotationPointZ += 1.5F;
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}		// アイテム持ってるときの腕振りを抑える+表示角オフセット
		if (heldItem[1] != 0) {
			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[1];
		}
		if (heldItem[0] != 0) {
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[0];
		}
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			// しゃがみ
			upperBody.rotateAngleX = 0.5F;
			bipedHead.rotateAngleX -= 0.5F;			//bipedBody.rotateAngleX += 0.5F;
			bipedRightArm.rotateAngleX += 0.2F;
			bipedLeftArm.rotateAngleX += 0.2F;
			bipedHead.rotationPointY += 1.0F; //upper bodyLength * (1 - cos(0.52rad))
			bipedBody.rotationPointY += 1.5F;			//bipedRightLeg.rotationPointZ = 3.5F; //lower bodyLength * sin(0.52rad)
			//bipedLeftLeg.rotationPointZ = 3.5F; //lower bodyLength * sin(0.52rad)
			//Skirt.rotationPointZ += 3.5F; //lower bodyLength * sin(0.52rad)
			Skirt.rotateAngleX = -0.5F;
			//bipedRightLeg.rotateAngleX -= 0.5F;
			//bipedLeftLeg.rotateAngleX -= 0.5F;
		} else {
			// 通常立ち
			upperBody.rotateAngleX = 0.0F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {
			//待機状態の特別表示
			bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.062F) * 0.05F - 0.6F;
			bipedRightArm.rotateAngleZ -= 0.4F;
			Arms[0].rotationPointX -= 2.0F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			bipedLeftArm.rotateAngleX += Helper.sin(f2 * 0.062F) * 0.05F - 0.6F;
			bipedLeftArm.rotateAngleZ += 0.4F;
			Arms[1].rotationPointX += 2.0F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
		} else {
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
				// 弓構え
				float f6 = Helper.sin(onGrounds[dominantArm] * 3.141593F);
				float f7 = Helper.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);
				bipedRightArm.rotateAngleZ = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.0F;
				bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
				bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
				bipedRightArm.rotateAngleX = -1.470796F;
				bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.062F) * 0.05F;
				bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
				bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
				bipedRightArm.rotateAngleY += bipedHead.rotateAngleY;
				bipedLeftArm.rotateAngleY += bipedHead.rotateAngleY;
			} else {
				// 通常
				bipedRightArm.rotateAngleZ += 0.3F;
				bipedLeftArm.rotateAngleZ -= 0.3F;
				bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= Helper.sin(f2 * 0.067F) * 0.05F;
			}
		}
//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		Skirt.rotationPointY = 10.0F;		SkirtFront.rotationPointX = SkirtBack.rotationPointX = motionY * 4.0F;
		SkirtRight.rotationPointZ = motionY * 4.0F;
		SkirtLeft.rotationPointZ = motionY * 4.0F;		SkirtFront.rotateAngleX = motionY;
		SkirtRight.rotateAngleZ = motionY / 2.0F;
		SkirtLeft.rotateAngleZ = -motionY / 2.0F;
		SkirtBack.rotateAngleX = -motionY;		SkirtFront.scaleX = SkirtBack.scaleX = 1.0F - (motionY * 1.0F);
		SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);
	}	@Override
	public float getHeight(IModelCaps entityCaps) {
		return 1.58F;
	}	@Override
	public float getWidth(IModelCaps entityCaps) {
		return 0.5F;
	}	@Override
	public float getyOffset(IModelCaps entityCaps) {
		return 1.4F;
	}	@Override
	public float getMountedYOffset(IModelCaps entityCaps) {
		return 0.85F;
	}
}