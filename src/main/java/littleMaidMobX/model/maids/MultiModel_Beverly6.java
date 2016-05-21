package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseBeverly;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;
public class MultiModel_Beverly6 extends ModelModchuBaseBeverly {	//added fields
	public ModelRenderer Ponytail;
	public ModelRenderer BunchR;
	public ModelRenderer BunchL;
	public ModelRenderer hemSkirtR1;
	public ModelRenderer hemSkirtL1;
	public ModelRenderer hemSkirtR2;
	public ModelRenderer hemSkirtL2;
	public ModelRenderer breastR;
	public ModelRenderer breastL;
	public ModelRenderer hipBody;
	protected byte offsetY;
	protected byte headPosY;
	protected byte bodyPosY;
	protected byte legPosY;
	protected boolean isRidingMaster = false;		public MultiModel_Beverly6(StringBuilder hack) {		super(hack);	}	public MultiModel_Beverly6() {
		super();
	}	public MultiModel_Beverly6(float f) {
		super(f);
	}	public MultiModel_Beverly6(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Beverly6(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 128;
		textureHeight = 64;		offsetY = (byte) (f1 + 5); //Global to Local		bodyPosY = 0; //Local waist height = always 0 (ORIGIN)
		headPosY = -9; //Local neck height = 0 - upper bodyLength
		legPosY = 4; //Lcal hip joint height = 0 + lower bodyLength		/* HEAD */
		eyeR = new ModelRenderer(this, 17, 0);
		eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);		eyeL = new ModelRenderer(this, 21, 0);
		eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);		Ponytail = new ModelRenderer(this, 76, 6);
		Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);		BunchR = new ModelRenderer(this, 64, 6);
		BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);		BunchL = new ModelRenderer(this, 70, 6);
		BunchL.mirror = true;
		BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8, f); // Head
		bipedHead.setTextureOffset(32, 0).addBox(-4F, -8F, -4F, 8, 12, 8, f + 0.3F); // Hire
		bipedHead.setTextureOffset(72, 0).addBox(-2F, -7.2F, 4F, 4, 4, 2, f); // ChignonB
		bipedHead.setTextureOffset(56, 0).addBox(-5F, -7F, 0.2F, 1, 3, 3, f); // ChignonR
		bipedHead.setMirror(true);
		bipedHead.setTextureOffset(64, 0).addBox(4F, -7F, 0.2F, 1, 3, 3, f); // ChignonL		rightArm2 = new ModelRenderer(this, 0, 25); //ForeArm
		rightArm2.addBox(-1.001F, -0F, -1.5F, 2, 8, 3, f);		leftArm2 = new ModelRenderer(this, 10, 25);
		leftArm2.mirror = true;
		leftArm2.addBox(-0.999F, -0F, -1.5F, 2, 8, 3, f);		rightArm = new ModelRenderer(this, 0, 16); //UpperArm
		rightArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);		leftArm = new ModelRenderer(this, 10, 16);
		leftArm.mirror = true;
		leftArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);		/* LEGS */
		rightLeg2 = new ModelRenderer(this, 0, 47); //Below Knee
		rightLeg2.addBox(-1.6F, -1F, -2F, 3, 10, 4, f);		leftLeg2 = new ModelRenderer(this, 0, 47);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.4F, -1F, -2F, 3, 10, 4, f);		rightLeg = new ModelRenderer(this, 0, 36); //Above Knee
		rightLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f + 0.2F);		leftLeg = new ModelRenderer(this, 0, 36);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f + 0.2F);		/* SKIRT */
		hemSkirtR2 = new ModelRenderer(this, 68, 48);
		hemSkirtR2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f + 0.2F);		hemSkirtL2 = new ModelRenderer(this, 98, 48);
		hemSkirtL2.mirror = true;
		hemSkirtL2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f + 0.2F);		hemSkirtR1 = new ModelRenderer(this, 69, 34);
		hemSkirtR1.addBox(-3F, -1F, -5F, 6, 7, 7, f);		hemSkirtL1 = new ModelRenderer(this, 99, 34);
		hemSkirtL1.mirror = true;
		hemSkirtL1.addBox(-3F, -1F, -5F, 6, 7, 7, f);		Skirt = new ModelRenderer(this, 18, 48);
		Skirt.addBox(-4F, 0F, -2F, 8, 3, 5, f + 0.6F);		/* BODY */
		breastR = new ModelRenderer(this, 20, 20);
		breastR.addBox(-3F, 0F, -3F, 3, 3, 3, f + 0.1F);		breastL = new ModelRenderer(this, 32, 20);
		breastL.mirror = true;
		breastL.addBox(0F, 0F, -3F, 3, 3, 3, f + 0.1F);		hipBody = new ModelRenderer(this, 18, 39);
		hipBody.addBox(-4F, 0F, -2.4F, 8, 4, 5, f - 0.2F);		bipedBody = new ModelRenderer(this, 0, 0);
		bipedBody.setTextureOffset(20, 26).addBox(-3F, -8.5F, -2.1F, 6, 9, 4, f); //body
		bipedBody.setTextureOffset(24, 16).addBox(-1F, -9.8F, -1F, 2, 2, 2, f + 0.5F); //neck		/* LOCAL SPACE */
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, offsetY, 0F);		bipedRightArm = new ModelRenderer(this);
		bipedLeftArm = new ModelRenderer(this);
		bipedRightLeg = new ModelRenderer(this);
		bipedLeftLeg = new ModelRenderer(this);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightHand = new ModelRenderer(this, 0, 31);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);		leftHand = new ModelRenderer(this, 10, 31);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);		rightArmPlus = new ModelRenderer(this);
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
	}	@Override
	public void defaultAddChildSetting() {
		HeadMount.clearChildModels();
		HeadTop.clearChildModels();
		bipedHead.clearChildModels();
		bipedBody.clearChildModels();
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(rightArm);
		bipedBody.addChild(leftArm);		bipedBody.addChild(Skirt);
		bipedHead.addChild(HeadMount);
		bipedHead.addChild(HeadTop);		rightArm.addChild(rightArm2);
		leftArm.addChild(leftArm2);
		rightLeg.addChild(rightLeg2);
		leftLeg.addChild(leftLeg2);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Ponytail);
		bipedHead.addChild(BunchR);
		bipedHead.addChild(BunchL);
		rightLeg2.addChild(hemSkirtR2);
		leftLeg2.addChild(hemSkirtL2);
		rightLeg.addChild(hemSkirtR1);
		leftLeg.addChild(hemSkirtL1);
		bipedBody.addChild(breastR);
		bipedBody.addChild(breastL);
		bipedBody.addChild(hipBody);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		rightArm2.addChild(Arms[0]);
		leftArm2.addChild(Arms[1]);
		((ModelRenderer) mainFrame).clearChildModels();
		mainFrame.addChild(bipedBody);
		mainFrame.addChild(rightLeg);
		mainFrame.addChild(leftLeg);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	/**
	 * 姿勢制御・初期化
	 */
	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(caps_Entity);
		if (entityliving != null); else return;
		//ふわりスカート
		float velY = (float)ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY) + 0.1F;		float fwBuf10 = velY * 1F;
		fwBuf10 = fwBuf10 > 0.5F ? 0.5F : fwBuf10;
		fwBuf10 = fwBuf10 < -0.5F ? -0.5F : fwBuf10;
		Skirt.rotationPointY += fwBuf10;		float fwBuf11 = velY * 3F;
		fwBuf11 = fwBuf11 > 1F ? 1F : fwBuf11;
		fwBuf11 = fwBuf11 < -2F ? -2F : fwBuf11;
		hemSkirtR1.rotationPointY += fwBuf11;
		hemSkirtL1.rotationPointY += fwBuf11;		float fwBuf12 = velY * 6F;
		fwBuf12 = fwBuf12 > 1F ? 1F : fwBuf12;
		fwBuf12 = fwBuf12 < -3F ? -3F : fwBuf12;
		hemSkirtR2.rotationPointY += fwBuf12;
		hemSkirtL2.rotationPointY += fwBuf12;		float fwBuf2 = velY * 2F;
		fwBuf2 = fwBuf2 > 0.1F ? 0.1F : fwBuf2;
		fwBuf2 = fwBuf2 < -0.7F ? -0.7F : fwBuf2;
		Ponytail.rotateAngleX -= fwBuf2;
		BunchR.rotateAngleZ -= fwBuf2;
		BunchL.rotateAngleZ += fwBuf2;	}	/**
	 * 姿勢制御・更新差分
	 */
	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		//顔向き
		bipedHead.rotateAngleY += f3 / 57.29578F;
		bipedHead.rotateAngleX += f4 / 57.29578F;
		//ポニテツインテ
		Ponytail.rotateAngleX += BunchR.rotateAngleX = BunchL.rotateAngleX = -bipedHead.rotateAngleX;
		Ponytail.rotateAngleZ -= bipedHead.rotateAngleZ;
		if (bipedHead.rotateAngleZ > 0) {
			BunchR.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		} else {
			BunchL.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		}		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			// 背負われている
			if (isRidingMaster) {
				rightArm2.rotateAngleX -= 1.3F;
				leftArm2.rotateAngleX -= 1.3F;
				rightLeg.rotateAngleX -= 1.1F;
				leftLeg.rotateAngleX -= 1.1F;
				rightLeg2.rotateAngleX += 0.9F;
				leftLeg2.rotateAngleX += 0.9F;
				rightLeg.rotateAngleY += 0.3F;
				leftLeg.rotateAngleY -= 0.3F;
				mainFrame.rotationPointY += 12F;
				mainFrame.rotationPointZ += 1F;
			}
			// 乗り物に乗っている
			else {
				rightArm.rotateAngleX -= 0.1F;
				leftArm.rotateAngleX -= 0.1F;
				rightLeg.rotateAngleX -= 1.3F;
				leftLeg.rotateAngleX -= 1.3F;
				rightLeg2.rotateAngleX += 2.5F;
				leftLeg2.rotateAngleX += 2.5F;
				mainFrame.rotationPointY += 4F;
				mainFrame.rotationPointZ += 1F;
				if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {
					mainFrame.rotateAngleY += 0.7F;
					bipedHead.rotateAngleY -= 0.7F;
					if (bipedHead.rotateAngleY < -1.5F) {
						bipedHead.rotateAngleY = -1.5F;
					}
					rightLeg2.rotateAngleX -= 0.5F;
					leftLeg2.rotateAngleX -= 0.5F;
					rightLeg.rotateAngleY += 0.3F;
					leftLeg.rotateAngleY += 0.3F;
					rightLeg2.rotateAngleY += 0.2F;
					leftLeg2.rotateAngleY += 0.2F;
					bipedBody.rotateAngleY += 0.3F;
					hipBody.rotateAngleY += 0.3F;
					hemSkirtR1.rotationPointX += 2F;
					hemSkirtL1.rotationPointX += 2F;
					// hemSkirtR2.rotationPointZ -= 1F;
					//hemSkirtL2.rotationPointZ -= 1F;
				}
			}
		} else {
			if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) //しゃがみ
			{
				if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {//膝立ち
					rightLeg.rotateAngleX -= 0.1F;
					leftLeg.rotateAngleX -= 0.2F;
					rightLeg2.rotateAngleX += 1.7F;
					leftLeg2.rotateAngleX += 1.8F;
					mainFrame.rotationPointY += 6F;
				} else {//中腰
					upperBody.rotateAngleX = 0.5F;
					bipedHead.rotateAngleX -= 0.5F;
					bipedHead.rotationPointY += 1.0F;
					bipedBody.rotationPointY += 1.0F;
					rightLeg.rotationPointY -= 1.0F;
					leftLeg.rotationPointY -= 1.0F;
					hipBody.rotateAngleX -= 0.1F + Helper.sin(f2 * 0.057F) * 0.03F;
					rightArm.rotateAngleX += 0.1F;
					leftArm.rotateAngleX += 0.1F;
					rightLeg.rotateAngleY -= 0.07F;
					leftLeg.rotateAngleY += 0.07F;
					rightLeg.rotateAngleX -= 0.7F;
					leftLeg.rotateAngleX -= 0.7F;
					rightLeg2.rotateAngleX += 0.32F;
					leftLeg2.rotateAngleX += 0.22F;
					//mainFrame.rotationPointY += 0.4F;
					rightLeg.rotateAngleX += 0.5F;
					leftLeg.rotateAngleX += 0.5F;
				}
				//しゃがみ歩行
				float f15 = Helper.sin(f * 0.6565F); //wave1
				float f16 = Helper.cos(f * 0.6565F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave				rightArm.rotateAngleX -= f15 * 0.2F * f1;
				leftArm.rotateAngleX += f15 * 0.2F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;				rightLeg.rotateAngleX += f15 * 0.2F * f1;
				leftLeg.rotateAngleX -= f15 * 0.2F * f1;
				rightLeg2.rotateAngleX += f22 * 0.7F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.7F * f1;				bipedBody.rotateAngleY -= f15 * 0.1F * f1;
				hipBody.rotateAngleY += f15 * 0.1F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - Helper.sin(f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - Helper.sin(f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.5F;
			} else {
				//通常歩行
				upperBody.rotateAngleX = 0.0F;
				rightLeg.rotationPointZ = leftLeg.rotationPointZ = 0.0F;
				float f15 = Helper.sin(f * 0.4444F); //wave1
				float f16 = Helper.cos(f * 0.4444F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave				rightArm.rotateAngleX -= f15 * 0.7F * f1;
				leftArm.rotateAngleX += f15 * 0.7F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;				rightLeg.rotateAngleX += f15 * 0.9F * f1;
				leftLeg.rotateAngleX -= f15 * 0.9F * f1;
				rightLeg2.rotateAngleX += f22 * 0.9F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.9F * f1;				bipedBody.rotateAngleY -= f15 * 0.2F * f1;
				hipBody.rotateAngleY += f15 * 0.3F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - Helper.sin(f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - Helper.sin(f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.1F;
			}
		}		// アイテム持ってるときの腕振りを抑える+表示角オフセット
		if (heldItem[1] != 0) {
			leftArm.rotateAngleX = leftArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[1];
		}
		if (heldItem[0] != 0) {
			rightArm.rotateAngleX = rightArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[0];
		}
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)) {// 待機状態 腕
			rightArm.rotateAngleX += Helper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			rightArm.rotateAngleZ -= 0.3F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			leftArm.rotateAngleX += Helper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			leftArm.rotateAngleZ += 0.3F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
			breastR.rotationPointX += 0.1F;
			breastL.rotationPointX -= 0.1F;
		} else {
			if (aimedBow) {// 弓構え 腕
				float fr6 = Helper.sin(onGrounds[0] * 3.141593F);
				float fl6 = Helper.sin(onGrounds[1] * 3.141593F);
				float fr7 = Helper.sin((1.0F - (1.0F - onGrounds[0]) * (1.0F - onGrounds[0])) * 3.141593F);
				float fl7 = Helper.sin((1.0F - (1.0F - onGrounds[1]) * (1.0F - onGrounds[1])) * 3.141593F);
				rightArm.rotateAngleZ = 0.0F;
				leftArm.rotateAngleZ = 0.0F;
				rightArm.rotateAngleY = -(0.1F - fr6 * 0.6F);
				leftArm.rotateAngleY = 0.1F - fl6 * 0.6F;
				rightArm.rotateAngleX = -1.470796F;
				leftArm.rotateAngleX = -1.470796F;
				rightArm.rotateAngleX -= fr6 * 1.2F - fr7 * 0.4F;
				leftArm.rotateAngleX -= fl6 * 1.2F - fl7 * 0.4F;
				rightArm.rotateAngleZ += Helper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= Helper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += Helper.sin(f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= Helper.sin(f2 * 0.057F) * 0.05F;
				rightArm.rotateAngleX += bipedHead.rotateAngleX;
				leftArm.rotateAngleX += bipedHead.rotateAngleX;
				rightArm.rotateAngleY += bipedHead.rotateAngleY;
				leftArm.rotateAngleY += bipedHead.rotateAngleY;
			} else {// 通常
				rightArm.rotateAngleZ += 0.2F;
				leftArm.rotateAngleZ -= 0.2F;
				rightArm2.rotateAngleZ += 0.05F;
				leftArm2.rotateAngleZ -= 0.05F;
				rightArm.rotateAngleZ += Helper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= Helper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += Helper.sin(f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= Helper.sin(f2 * 0.057F) * 0.05F;
			}
		}		//脚部追従
		float sinBody1X = Helper.sin(bipedBody.rotateAngleX);
		float cosBody1X = 1F - Helper.cos(bipedBody.rotateAngleX);		bipedHead.rotationPointZ -= -headPosY * sinBody1X;
		bipedHead.rotationPointY += -headPosY * cosBody1X;
		breastFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		//INIT POSITION
		bipedHead.setRotationPoint(0F, headPosY, 0F);
		HeadMount.setRotationPoint(0F, 0F, 0F);
		eyeR.setRotationPoint(0F, 0F, 0F);
		eyeL.setRotationPoint(0F, 0F, 0F);
		Ponytail.setRotationPoint(0F, -5.2F, 5F);
		BunchR.setRotationPoint(-4.5F, -5.5F, 1.7F);
		BunchL.setRotationPoint(4.5F, -5.5F, 1.7F);		rightArm.setRotationPoint(-4F, bodyPosY - 7.5F, 0F);
		rightArm2.setRotationPoint(0F, 5F, 0.5F);
		Arms[0].setRotationPoint(-0.5F, 7F, 0F);
		leftArm.setRotationPoint(4F, bodyPosY - 7.5F, 0F);
		leftArm2.setRotationPoint(0F, 5F, 0.5F);
		Arms[1].setRotationPoint(0.5F, 7F, 0F);		rightLeg.setRotationPoint(-2F, legPosY, 0F);
		rightLeg2.setRotationPoint(0F, 6F, 0F);
		leftLeg.setRotationPoint(2F, legPosY, 0F);
		leftLeg2.setRotationPoint(0F, 6F, 0F);		Skirt.setRotationPoint(0F, legPosY - 3F, 0F);
		hemSkirtR1.setRotationPoint(0F, 0F, 2F);
		hemSkirtL1.setRotationPoint(0F, 0F, 2F);
		hemSkirtR2.setRotationPoint(0F, 0F, 1F);
		hemSkirtL2.setRotationPoint(0F, 0F, 1F);		bipedBody.setRotationPoint(0F, bodyPosY, 0F);
		breastR.setRotationPoint(-0.5F, -7.2F, -2.1F);
		breastL.setRotationPoint(0.5F, -7.2F, -2.1F);
		hipBody.setRotationPoint(0F, 0F, 0F);		mainFrame.setRotationPoint(0F, offsetY, 0F);		//INIT ROTATION
		bipedHead.rotateAngleX = 0F;
		bipedHead.rotateAngleY = 0F;
		//bipedHead.rotateAngleZ = 0F;
		Ponytail.rotateAngleX = 0.05F;
		Ponytail.rotateAngleY = 0F;
		Ponytail.rotateAngleZ = 0F;
		BunchR.rotateAngleX = 0F;
		BunchR.rotateAngleY = 0F;
		BunchR.rotateAngleZ = 0.05F;
		BunchL.rotateAngleX = 0F;
		BunchL.rotateAngleY = 0F;
		BunchL.rotateAngleZ = -0.05F;		rightArm.rotateAngleX = 0F;
		rightArm.rotateAngleY = 0F;
		rightArm.rotateAngleZ = 0F;
		rightArm2.rotateAngleX = 0F;
		rightArm2.rotateAngleY = 0F;
		rightArm2.rotateAngleZ = 0F;
		Arms[0].rotateAngleX = 0F;
		Arms[0].rotateAngleY = 0F;
		Arms[0].rotateAngleZ = 0F;
		leftArm.rotateAngleX = 0F;
		leftArm.rotateAngleY = 0F;
		leftArm.rotateAngleZ = 0F;
		leftArm2.rotateAngleX = 0F;
		leftArm2.rotateAngleY = 0F;
		leftArm2.rotateAngleZ = 0F;
		Arms[1].rotateAngleX = 0F;
		Arms[1].rotateAngleY = 0F;
		Arms[1].rotateAngleZ = 0F;		rightLeg.rotateAngleX = -0.05F;
		rightLeg.rotateAngleY = 0.05F;
		rightLeg.rotateAngleZ = -0.05F;
		rightLeg2.rotateAngleX = 0.5F;
		rightLeg2.rotateAngleY = -0.1F;
		rightLeg2.rotateAngleZ = 0.02F;
		leftLeg.rotateAngleX = -0.05F;
		leftLeg.rotateAngleY = -0.05F;
		leftLeg.rotateAngleZ = 0.05F;
		leftLeg2.rotateAngleX = 0.5F;
		leftLeg2.rotateAngleY = 0.1F;
		leftLeg2.rotateAngleZ = -0.02F;		Skirt.rotateAngleX = 0F;
		Skirt.rotateAngleY = 0F;
		Skirt.rotateAngleZ = 0F;
		hemSkirtR1.rotateAngleX = 0F;
		hemSkirtR1.rotateAngleY = 0F;
		hemSkirtR1.rotateAngleZ = 0.05F;
		hemSkirtL1.rotateAngleX = 0F;
		hemSkirtL1.rotateAngleY = 0F;
		hemSkirtL1.rotateAngleZ = -0.05F;
		hemSkirtR2.rotateAngleX = 0F;
		hemSkirtR2.rotateAngleY = 0F;
		hemSkirtR2.rotateAngleZ = -0.03F;
		hemSkirtL2.rotateAngleX = 0F;
		hemSkirtL2.rotateAngleY = 0F;
		hemSkirtL2.rotateAngleZ = 0.03F;		bipedBody.rotateAngleX = -0.1F;
		bipedBody.rotateAngleY = 0F;
		breastR.rotateAngleX = 0.785F;
		breastR.rotateAngleY = 0F;
		breastR.rotateAngleZ = -0.15F;
		breastL.rotateAngleX = 0.785F;
		breastL.rotateAngleY = 0F;
		breastL.rotateAngleZ = 0.15F;
		hipBody.rotateAngleX = 0.2F;
		hipBody.rotateAngleY = 0F;
		hipBody.rotateAngleZ = 0F;		mainFrame.rotateAngleX = 0F;
		mainFrame.rotateAngleY = 0F;
		mainFrame.rotateAngleZ = 0F;
	}	@Override
	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (armSwingFlag(entityCaps)) {
			// 腕振り
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
				rightArm.rotateAngleX -= f7 * 1.2D + f8;
				rightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				rightArm.rotateAngleZ = Helper.sin(onGrounds[0] * 3.141593F) * -0.4F;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Helper.sin(f6 * (float) Math.PI);
				f8 = Helper.sin(onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				leftArm.rotateAngleX -= f7 * 1.2D + f8;
				leftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				leftArm.rotateAngleZ = Helper.sin(onGrounds[1] * 3.141593F) * 0.4F;
			}
		}
	}	@Override
	public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedHeadShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, Ponytail, b);		setCapsValue(entityCaps, caps_visible, BunchR, b);		setCapsValue(entityCaps, caps_visible, BunchL, b);	}	@Override
	public void setArmorBipedBodyShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, breastR, b);		setCapsValue(entityCaps, caps_visible, breastL, b);		setCapsValue(entityCaps, caps_visible, hipBody, b);	}	@Override
	public void setArmorBipedRightLegShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedRightLegShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtR1, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtR2, b);
	}	@Override
	public void setArmorBipedLeftLegShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedLeftLegShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtL1, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtL2, b);
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		setCapsValue(entityCaps, caps_visible, Skirt, b);
		Skirt.isHidden = !b;
		//Modchu_Debug.mDebug("setArmorSkirtShowModel b="+b);
	}
}