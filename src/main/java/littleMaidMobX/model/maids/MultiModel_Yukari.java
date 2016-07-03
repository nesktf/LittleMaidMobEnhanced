package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseAug;import littleMaidMobX.render.model.ModelBoxPlate;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_Yukari extends ModelModchuBaseAug {	public ModelRenderer Skirt_R;
	public ModelRenderer Skirt_L;
	public ModelRenderer Skirt_RF;
	public ModelRenderer Skirt_RB;
	public ModelRenderer Skirt_RR;
	public ModelRenderer Skirt_RL;
	public ModelRenderer Skirt_LF;
	public ModelRenderer Skirt_LB;
	public ModelRenderer Skirt_LR;
	public ModelRenderer Skirt_LL;
	public ModelRenderer Arm_RF;
	public ModelRenderer Arm_RB;
	public ModelRenderer Arm_RR;
	public ModelRenderer Arm_RL;
	public ModelRenderer Arm_LF;
	public ModelRenderer Arm_LB;
	public ModelRenderer Arm_LR;
	public ModelRenderer Arm_LL;
	public ModelRenderer Parka_1;
	public ModelRenderer Parka_2;
	public ModelRenderer Parka_F;
	public ModelRenderer Parka_B;
	public ModelRenderer Parka_R;
	public ModelRenderer Parka_L;
	public ModelRenderer RabbitEar_RB1;
	public ModelRenderer RabbitEar_RB2;
	public ModelRenderer RabbitEar_LB1;
	public ModelRenderer RabbitEar_LB2;
	public ModelRenderer RabbitEar_R1;
	public ModelRenderer RabbitEar_R2;
	public ModelRenderer RabbitEar_R3;
	public ModelRenderer RabbitEar_R4;
	public ModelRenderer RabbitEar_L1;
	public ModelRenderer RabbitEar_L2;
	public ModelRenderer RabbitEar_L3;
	public ModelRenderer RabbitEar_L4;
	public ModelRenderer HairOrnament_R;
	public ModelRenderer HairOrnament_L;
	public ModelRenderer PigTail_R1;
	public ModelRenderer PigTail_R2;
	public ModelRenderer PigTail_L1;
	public ModelRenderer PigTail_L2;
	public ModelRenderer Accessory_S1;
	public ModelRenderer Accessory_S2;
	public ModelRenderer Accessory_B1;
	public ModelRenderer Accessory_B2;
	public ModelRenderer Accessory_H;
	public ModelRenderer Accessory_HRF1;
	public ModelRenderer Accessory_HRF2;
	public ModelRenderer Accessory_HRF3;
	public ModelRenderer Accessory_HR1;
	public ModelRenderer Accessory_HR2;
	public ModelRenderer Accessory_HLF1;
	public ModelRenderer Accessory_HLF2;
	public ModelRenderer Accessory_HLF3;
	public ModelRenderer Accessory_HL1;
	public ModelRenderer Accessory_HL2;
	public ModelRenderer Accessory_HB1;
	public ModelRenderer Accessory_HB2;
	public ModelRenderer ArmAccessory_RF;
	public ModelRenderer ArmAccessory_RB;
	public ModelRenderer ArmAccessory_RR;
	public ModelRenderer ArmAccessory_RL;
	public ModelRenderer ArmAccessory_R;
	public ModelRenderer Belt_R;
	public ModelRenderer Belt_L;
	public ModelRenderer BeltAccessory_L;
	public ModelRenderer Incom_1;
	public ModelRenderer Incom_2;
	public ModelRenderer Incom_3;
	public ModelRenderer Shaggy_B1;
	public ModelRenderer Shaggy_B2;
	public ModelRenderer Shaggy_B3;
	public ModelRenderer Shaggy_B4;
	public ModelRenderer Shaggy_B5;
	public ModelRenderer Shaggy_R1;
	public ModelRenderer Shaggy_R2;
	public ModelRenderer Shaggy_R3;
	public ModelRenderer Shaggy_R4;
	public ModelRenderer Shaggy_R5;
	public ModelRenderer Shaggy_L1;
	public ModelRenderer Shaggy_L2;
	public ModelRenderer Shaggy_L3;
	public ModelRenderer Shaggy_L4;
	public ModelRenderer Shaggy_L5;
	public ModelRenderer Cheek_R;
	public ModelRenderer Cheek_L;
	public ModelRenderer Head_F;
	public ModelRenderer Body_B;
	public ModelRenderer Breast;
	public ModelRenderer Breast_C;
	public ModelRenderer Breast_U;
	public ModelRenderer Breast_B;
	public ModelRenderer Breast_R;
	public ModelRenderer Breast_L;
	public ModelRenderer Breast_RU;
	public ModelRenderer Breast_LU;
	public ModelRenderer Breast_RB;
	public ModelRenderer Breast_LB;		public MultiModel_Yukari(StringBuilder hack) {		super(hack);	}	public MultiModel_Yukari() {
		this(0.0F);
	}	public MultiModel_Yukari(float f) {
		this(f, 0.0F);
	}	public MultiModel_Yukari(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Yukari(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
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
		bipedLeftLeg = new ModelRenderer(this, 46, 19);
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		Skirt = new ModelRenderer(this, 0, 20);
		Skirt.addBox(-3F, -2F, -2F, 6, 2, 4, f + 0.15F);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		sidetailUpperR = new ModelRenderer(this);
		sidetailUpperL = new ModelRenderer(this);
		Skirt_R = new ModelRenderer(this, 0, 26);
		Skirt_R.addBox(-1.69F, 0.19F, -2F, 3, 2, 4, f + 0.2F);
		Skirt_L = new ModelRenderer(this, 14, 26);
		Skirt_L.addBox(-1.31F, 0.19F, -2F, 3, 2, 4, f + 0.2F);
		Skirt_RF = new ModelRenderer(this, 26, 44);
		Skirt_RF.addPlate(0.0F, 0.0F, 0.0F, 5, 3, ModelBoxPlate.planeXYFront, f - 0.798F);
		Skirt_RB = new ModelRenderer(this, 37, 44);
		Skirt_RB.addPlate(0.0F, 0.0F, 0.0F, 5, 3, ModelBoxPlate.planeXYBack, f - 0.798F);
		Skirt_RR = new ModelRenderer(this, 20, 44);
		Skirt_RR.addPlate(0.0F, 0.0F, 0.0F, 6, 3, ModelBoxPlate.planeZYRight, f - 0.798F);
		Skirt_RL = new ModelRenderer(this, 31, 44);
		Skirt_RL.addPlate(0.0F, 0.0F, 0.0F, 6, 3, ModelBoxPlate.planeZYLeft, f - 0.798F);
		Skirt_LF = new ModelRenderer(this, 48, 44);
		Skirt_LF.addPlate(0.0F, 0.0F, 0.0F, 5, 3, ModelBoxPlate.planeXYFront, f - 0.798F);
		Skirt_LB = new ModelRenderer(this, 59, 44);
		Skirt_LB.addPlate(0.0F, 0.0F, 0.0F, 5, 3, ModelBoxPlate.planeXYBack, f - 0.798F);
		Skirt_LR = new ModelRenderer(this, 54, 44);
		Skirt_LR.addPlate(0.0F, 0.0F, 0.0F, 6, 3, ModelBoxPlate.planeZYRight, f - 0.798F);
		Skirt_LL = new ModelRenderer(this, 53, 44);
		Skirt_LL.addPlate(0.0F, 0.0F, 0.0F, 6, 3, ModelBoxPlate.planeZYLeft, f - 0.798F);
		Arm_RF = new ModelRenderer(this, 32, 47);
		Arm_RF.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeXYFront, f - 0.999F);
		Arm_RB = new ModelRenderer(this, 36, 47);
		Arm_RB.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeXYBack, f - 0.999F);
		Arm_RR = new ModelRenderer(this, 40, 47);
		Arm_RR.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeZYRight, f - 0.999F);
		Arm_RL = new ModelRenderer(this, 44, 47);
		Arm_RL.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeZYLeft, f - 0.999F);		Arm_LF = new ModelRenderer(this, 48, 47);
		Arm_LF.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeXYFront, f - 0.999F);
		Arm_LB = new ModelRenderer(this, 52, 47);
		Arm_LB.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeXYBack, f - 0.999F);
		Arm_LR = new ModelRenderer(this, 56, 47);
		Arm_LR.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeZYRight, f - 0.999F);
		Arm_LL = new ModelRenderer(this, 60, 47);
		Arm_LL.addPlate(0.0F, 0.0F, 0.0F, 4, 3, ModelBoxPlate.planeZYLeft, f - 0.999F);
		Parka_1 = new ModelRenderer(this, 13, 32);
		Parka_1.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 1, f - 0.5F);
		Parka_2 = new ModelRenderer(this, 29, 32);
		Parka_2.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 1, f - 0.7F);
		Parka_F = new ModelRenderer(this, 33, 39);
		Parka_F.addPlate(-5.5F, -2.5F, 0.0F, 11, 5, 0, f - 2.495F);
		Parka_B = new ModelRenderer(this, 53, 39);
		Parka_B.addPlate(-5.5F, -2.5F, 0.0F, 11, 5, 4, f - 2.495F);
		Parka_R = new ModelRenderer(this, 24, 39);
		Parka_R.addPlate(0.0F, -2.5F, -4.5F, 9, 5, 5, f - 2.495F);
		Parka_L = new ModelRenderer(this, 44, 39);
		Parka_L.addPlate(0.0F, -2.5F, -4.5F, 9, 5, 1, f - 2.495F);
		RabbitEar_RB1 = new ModelRenderer(this, 0, 44);
		RabbitEar_RB1.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
		RabbitEar_RB2 = new ModelRenderer(this, 8, 44);
		RabbitEar_RB2.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
		RabbitEar_LB1 = new ModelRenderer(this, 0, 44);
		RabbitEar_LB1.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
		RabbitEar_LB2 = new ModelRenderer(this, 8, 44);
		RabbitEar_LB2.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
		RabbitEar_R1 = new ModelRenderer(this, 0, 32);
		RabbitEar_R1.addBox(-2F, -1F, -1.5F, 2, 1, 3, f - 0.5F);
		RabbitEar_R2 = new ModelRenderer(this, 5, 32);
		RabbitEar_R2.addBox(-1F, 0.0F, -1.5F, 1, 1, 3, f - 0.5F);
		RabbitEar_R3 = new ModelRenderer(this, 0, 36);
		RabbitEar_R3.addBox(0.0F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
		RabbitEar_R4 = new ModelRenderer(this, 8, 36);
		RabbitEar_R4.addBox(-1F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
		RabbitEar_L1 = new ModelRenderer(this, 0, 32);
		RabbitEar_L1.mirror = true;
		RabbitEar_L1.addBox(0.0F, -1F, -1.5F, 2, 1, 3, f - 0.5F);
		RabbitEar_L2 = new ModelRenderer(this, 5, 32);
		RabbitEar_L2.mirror = true;
		RabbitEar_L2.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, f - 0.5F);
		RabbitEar_L3 = new ModelRenderer(this, 0, 36);
		RabbitEar_L3.mirror = true;
		RabbitEar_L3.addBox(-1F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
		RabbitEar_L4 = new ModelRenderer(this, 8, 36);
		RabbitEar_L4.mirror = true;
		RabbitEar_L4.addBox(0.0F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
		HairOrnament_R = new ModelRenderer(this, 48, 32);
		HairOrnament_R.addBox(-2F, 0.0F, -2F, 4, 3, 4, f - 1.1F);
		HairOrnament_L = new ModelRenderer(this, 48, 32);
		HairOrnament_L.addBox(-2F, 0.0F, -2F, 4, 3, 4, f - 1.1F);
		PigTail_R1 = new ModelRenderer(this, 60, 23);
		PigTail_R1.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, f);
		PigTail_R2 = new ModelRenderer(this, 60, 25);
		PigTail_R2.addBox(-1F, 0.0F, -1F, 1, 2, 1, f);
		PigTail_L1 = new ModelRenderer(this, 60, 23);
		PigTail_L1.mirror = true;
		PigTail_L1.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, f);
		PigTail_L2 = new ModelRenderer(this, 60, 25);
		PigTail_L2.mirror = true;
		PigTail_L2.addBox(0.0F, 0.0F, -1F, 1, 2, 1, f);
		Accessory_S1 = new ModelRenderer(this, 32, 58);
		Accessory_S1.addBox(-1.5F, -1.5F, -3F, 3, 3, 3, f - 1.0F);
		Accessory_S2 = new ModelRenderer(this, 0, 52);
		Accessory_S2.addPlate(-2.5F, -2.5F, -3.8F, 5, 5, 0, f - 2.0F);
		Accessory_B1 = new ModelRenderer(this, 34, 51);
		Accessory_B1.addBox(-2F, -2F, -3F, 4, 4, 3, f - 1.1F);
		Accessory_B2 = new ModelRenderer(this, 0, 52);
		Accessory_B2.addPlate(-2.5F, -2.5F, -3.3F, 5, 5, 0, f - 1.6F);
		Accessory_H = new ModelRenderer(this, 44, 59);
		Accessory_H.addBox(-3.5F, -1F, -0.5F, 7, 2, 3, f - 0.3F);
		Accessory_HRF1 = new ModelRenderer(this, 34, 51);
		Accessory_HRF1.addBox(-2F, -2F, -2F, 4, 4, 3, f - 1.0F);
		Accessory_HRF2 = new ModelRenderer(this, 0, 52);
		Accessory_HRF2.addPlate(-2.5F, -2.5F, -2.3F, 5, 5, 0, f - 1.5F);
		Accessory_HRF3 = new ModelRenderer(this, 41, 58);
		Accessory_HRF3.addBox(0.9F, -0.3F, -1.1F, 1, 1, 1, f - 0.1F);
		Accessory_HR1 = new ModelRenderer(this, 48, 51);
		Accessory_HR1.addBox(-2.5F, -2.5F, -2F, 5, 5, 3, f - 1.25F);
		Accessory_HR2 = new ModelRenderer(this, 0, 52);
		Accessory_HR2.addPlate(-2.5F, -2.5F, -1.8F, 5, 5, 0, f - 1.25F);
		Accessory_HLF1 = new ModelRenderer(this, 34, 51);
		Accessory_HLF1.addBox(-2F, -2F, -2F, 4, 4, 3, f - 1.0F);
		Accessory_HLF2 = new ModelRenderer(this, 0, 52);
		Accessory_HLF2.addPlate(-2.5F, -2.5F, -2.3F, 5, 5, 0, f - 1.5F);
		Accessory_HLF3 = new ModelRenderer(this, 41, 58);
		Accessory_HLF3.addBox(-1.9F, -0.3F, -1.1F, 1, 1, 1, f - 0.1F);
		Accessory_HL1 = new ModelRenderer(this, 48, 51);
		Accessory_HL1.addBox(-2.5F, -2.5F, -2F, 5, 5, 3, f - 1.25F);
		Accessory_HL2 = new ModelRenderer(this, 0, 52);
		Accessory_HL2.addPlate(-2.5F, -2.5F, -1.8F, 5, 5, 0, f - 1.25F);
		Accessory_HB1 = new ModelRenderer(this, 32, 58);
		Accessory_HB1.addBox(-1.5F, -1.5F, -3F, 3, 3, 3, f - 0.85F);
		Accessory_HB2 = new ModelRenderer(this, 0, 52);
		Accessory_HB2.addPlate(-2.5F, -2.5F, -3.8F, 5, 5, 0, f - 1.85F);
		ArmAccessory_RF = new ModelRenderer(this, 16, 47);
		ArmAccessory_RF.addPlate(-2.0F, 0.0F, -2F, 4, 3, ModelBoxPlate.planeXYFront, f - 0.95F);
		ArmAccessory_RB = new ModelRenderer(this, 20, 47);
		ArmAccessory_RB.addPlate(-2.0F, 0.0F, 2.0F, 4, 3, ModelBoxPlate.planeXYBack, f - 0.95F);
		ArmAccessory_RR = new ModelRenderer(this, 24, 47);
		ArmAccessory_RR.addPlate(0.1F, 0.0F, -2F, 4, 3, ModelBoxPlate.planeZYRight, f - 0.95F);
		ArmAccessory_RL = new ModelRenderer(this, 28, 47);
		ArmAccessory_RL.addPlate(-0.1F, 0.0F, -2F, 4, 3, ModelBoxPlate.planeZYLeft, f - 0.95F);
		ArmAccessory_R = new ModelRenderer(this, 45, 36);
		ArmAccessory_R.addPlate(0.0F, 0.0F, 0.0F, 3, 3, ModelBoxPlate.planeXYFront, f - 0.95F);
		Belt_R = new ModelRenderer(this, 0, 57);
		Belt_R.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, f - 0.2F);
		Belt_L = new ModelRenderer(this, 12, 57);
		Belt_L.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, f - 0.2F);
		BeltAccessory_L = new ModelRenderer(this, 16, 50);
		BeltAccessory_L.addPlate(-3.5F, -3.5F, -3.1F, 7, 7, 0, f - 3.1F);
		Incom_1 = new ModelRenderer(this, 24, 55);
		Incom_1.addBox(-1.5F, -2F, -1.2F, 3, 4, 2, f - 0.75F);
		Incom_2 = new ModelRenderer(this, 24, 53);
		Incom_2.addBox(-1.7F, -0.5F, -0.5F, 2, 1, 1, f - 0.3F);
		Incom_3 = new ModelRenderer(this, 30, 53);
		Incom_3.addBox(-1.205F, -0.5F, -0.5F, 1, 1, 1, f - 0.295F);		//不要パーツ（削除するとエラー）
		shaggyB = new ModelRenderer(this, 32, 0);
		//ここまで		Shaggy_B1 = new ModelRenderer(this, 32, 0);
		Shaggy_B1.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
		Shaggy_B2 = new ModelRenderer(this, 32, 2);
		Shaggy_B2.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
		Shaggy_B3 = new ModelRenderer(this, 32, 4);
		Shaggy_B3.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
		Shaggy_B4 = new ModelRenderer(this, 32, 6);
		Shaggy_B4.addPlate(-4F, 0.0F, 0.0F, 8, 1, 4, f);
		Shaggy_B5 = new ModelRenderer(this, 32, 7);
		Shaggy_B5.addPlate(-4F, 0.0F, 0.0F, 8, 1, 4, f);		//不要パーツ（削除するとエラー）
		shaggyR = new ModelRenderer(this, 40, 0);
		//ここまで		Shaggy_R1 = new ModelRenderer(this, 40, 0);
		Shaggy_R1.addPlate(0.0F, 0.0F, -4.0F, 8, 2, 5, f);
		Shaggy_R2 = new ModelRenderer(this, 40, 2);
		Shaggy_R2.addPlate(0.0F, 0.0F, -4F, 8, 2, 5, f);
		Shaggy_R3 = new ModelRenderer(this, 40, 4);
		Shaggy_R3.addPlate(0.0F, 0.0F, -4F, 8, 2, 5, f);
		Shaggy_R4 = new ModelRenderer(this, 40, 6);
		Shaggy_R4.addPlate(0.0F, 0.0F, -4F, 8, 1, 5, f);
		Shaggy_R5 = new ModelRenderer(this, 40, 7);
		Shaggy_R5.addPlate(0.0F, 0.0F, -4F, 8, 1, 5, f);		//不要パーツ（削除するとエラー）
		shaggyL = new ModelRenderer(this, 24, 0);
		//ここまで		Shaggy_L1 = new ModelRenderer(this, 24, 0);
		Shaggy_L1.addPlate(0.0F, 0.0F, -4.0F, 8, 2, 1, f);
		Shaggy_L2 = new ModelRenderer(this, 24, 2);
		Shaggy_L2.addPlate(0.0F, 0.0F, -4F, 8, 2, 1, f);
		Shaggy_L3 = new ModelRenderer(this, 24, 4);
		Shaggy_L3.addPlate(0.0F, 0.0F, -4F, 8, 2, 1, f);
		Shaggy_L4 = new ModelRenderer(this, 24, 6);
		Shaggy_L4.addPlate(0.0F, 0.0F, -4F, 8, 1, 1, f);
		Shaggy_L5 = new ModelRenderer(this, 24, 7);
		Shaggy_L5.addPlate(0.0F, 0.0F, -4F, 8, 1, 1, f);
		sensor1 = new ModelRenderer(this, 0, 0);
		sensor1.addPlate(-8F, -4F, 0.0F, 8, 4, 0, f);
		sensor2 = new ModelRenderer(this, 0, 4);
		sensor2.addPlate(0.0F, -4F, 0.0F, 8, 4, 0, f);
		sensor3 = new ModelRenderer(this, 8, 16);
		sensor3.addPlate(0.0F, -4F, -0F, 8, 4, 1, f);
		sensor4 = new ModelRenderer(this, 0, 16);
		sensor4.addPlate(0.0F, -4F, -8F, 8, 4, 1, f);
		eyeR = new ModelRenderer(this, 42, 19);
		eyeR.addPlate(-4F, -5F, -4.001F, 4, 4, 0, f);
		eyeL = new ModelRenderer(this, 46, 19);
		eyeL.addPlate(0.0F, -5F, -4.001F, 4, 4, 0, f);
		Cheek_R = new ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L = new ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Head_F = new ModelRenderer(this, 16, 16);
		Head_F.addPlate(-4F, -4F, -3F, 8, 8, 0, f - 3F);
		Body_B = new ModelRenderer(this, 24, 16);
		Body_B.addPlate(-4F, -4F, 3F, 8, 8, 4, f - 3F);
		Breast = new ModelRenderer(this, 56, 16);
		Breast.addBox(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
		Breast_C = new ModelRenderer(this, 53, 16);
		Breast_C.addPlate(-2F, 0.0F, 0.0F, 4, 1, 0);
		Breast_U = new ModelRenderer(this, 53, 15);
		Breast_U.addPlate(-2F, -1F, 0.0F, 4, 1, 0);
		Breast_B = new ModelRenderer(this, 53, 17);
		Breast_B.addPlate(-2F, 0.0F, 0.0F, 4, 1, 0);
		Breast_R = new ModelRenderer(this, 52, 16);
		Breast_R.addPlate(-1F, -0.5F, 0.0F, 1, 1, 0);
		Breast_RU = new ModelRenderer(this, 52, 15);
		Breast_RU.addPlate(-1F, -1F, 0.0F, 1, 1, 0);
		Breast_RB = new ModelRenderer(this, 52, 17);
		Breast_RB.addPlate(-1F, 0.0F, 0.0F, 1, 1, 0);
		Breast_L = new ModelRenderer(this, 57, 16);
		Breast_L.addPlate(0.0F, -0.5F, 0.0F, 1, 1, 0);
		Breast_LU = new ModelRenderer(this, 57, 15);
		Breast_LU.addPlate(0.0F, -1F, 0.0F, 1, 1, 0);
		Breast_LB = new ModelRenderer(this, 57, 17);
		Breast_LB.addPlate(0.0F, 0.0F, 0.0F, 1, 1, 0);
		SideTailR = new ModelRenderer(this);
		SideTailL = new ModelRenderer(this);
		mainFrame = new ModelRenderer(this, 0, 0);
		Skirt_R.setRotationPoint(0.0F, 0.0F, 0.0F);		Skirt_L.setRotationPoint(0.0F, 0.0F, 0.0F);		Skirt_RF.setRotationPoint(-2.71F, 0.0F, -3.0F);		Skirt_RB.setRotationPoint(0.0F, 0.0F, 6.0F);		Skirt_RR.setRotationPoint(3.39F, 0.0F, 0.0F);		Skirt_RL.setRotationPoint(1.61F, 0.0F, 0.0F);		Skirt_LF.setRotationPoint(-2.29F, 0.0F, -3.0F);		Skirt_LB.setRotationPoint(0.0F, 0.0F, 6.0F);		Skirt_LR.setRotationPoint(3.39F, 0.0F, 0.0F);		Skirt_LL.setRotationPoint(1.61F, 0.0F, 0.0F);		Arm_RF.setRotationPoint(-2.0F, 3.0F, -2.0F);		Arm_RB.setRotationPoint(0.0F, 0.0F, 4.0F);		Arm_RR.setRotationPoint(0.0F, 0.0F, 0.0F);		Arm_RL.setRotationPoint(4.0F, 0.0F, 0.0F);		Arm_LF.setRotationPoint(-2.0F, 3.0F, -2.0F);		Arm_LB.setRotationPoint(0.0F, 0.0F, 4.0F);		Arm_LR.setRotationPoint(0.0F, 0.0F, 0.0F);		Arm_LL.setRotationPoint(4.0F, 0.0F, 0.0F);		Parka_1.setRotationPoint(0.0F, -3.0F, 2.0F);		Parka_1.setRotateAngleX(0.08726461F);		Parka_2.setRotationPoint(0.0F, -3.0F, 0.18F);		Parka_F.setRotationPoint(0.0F, 3.5F, -4.5F);		Parka_B.setRotationPoint(0.0F, 3.5F, 4.5F);		Parka_R.setRotationPoint(-1.51F, 3.5F, 0.0F);		Parka_L.setRotationPoint(1.51F, 3.5F, 0.0F);		RabbitEar_RB1.setRotationPoint(-2.5F, 3.0F, 1.0F);		RabbitEar_RB2.setRotationPoint(0.0F, 4.5F, 0.0F);		RabbitEar_LB1.setRotationPoint(2.5F, 3.0F, 1.0F);		RabbitEar_LB2.setRotationPoint(0.0F, 4.5F, 0.0F);		RabbitEar_R1.setRotationPoint(-2.3F, -8.0F, -1.5F);		RabbitEar_R1.setRotateAngleZ(0.08726461F);		RabbitEar_R2.setRotationPoint(-2F, -1.0F, 0.0F);		RabbitEar_R2.setRotateAngleZ(-((float) Math.PI / 4F));		RabbitEar_R3.setRotationPoint(-1F, 0.0F, 0.0F);		RabbitEar_R4.setRotationPoint(1.0F, 5.0F, 0.0F);		RabbitEar_R4.setRotateAngleZ(0.1745292F);		RabbitEar_L1.setRotationPoint(2.3F, -8.0F, -1.5F);		RabbitEar_L1.setRotateAngleZ(-0.08726461F);		RabbitEar_L2.setRotationPoint(2.0F, -1.0F, 0.0F);		RabbitEar_L2.setRotateAngleZ(((float) Math.PI / 4F));		RabbitEar_L3.setRotationPoint(1.0F, 0.0F, 0.0F);		RabbitEar_L4.setRotationPoint(-1F, 5.0F, 0.0F);		RabbitEar_L4.setRotateAngleZ(-0.1745292F);		HairOrnament_R.setRotationPoint(3.5F, -1.8F, -3.5F);		HairOrnament_L.setRotationPoint(-3.5F, -1.8F, -3.5F);		PigTail_R1.setRotationPoint(-3.5F, 0.0F, -3.5F);		PigTail_R2.setRotationPoint(0.5F, 1.0F, 0.5F);		PigTail_R2.setRotateAngleX(-0.1745292F);		PigTail_R2.setRotateAngleY(0.0F);		PigTail_R2.setRotateAngleZ(0.1745292F);		PigTail_L1.setRotationPoint(3.5F, 0.0F, -3.5F);		PigTail_L2.setRotationPoint(-0.5F, 1.0F, 0.5F);		PigTail_L2.setRotateAngleX(-0.1745292F);		PigTail_L2.setRotateAngleY(0.0F);		PigTail_L2.setRotateAngleZ(-0.1745292F);		Accessory_S1.setRotationPoint(1.8F, -6.0F, -2.3F);		Accessory_S2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_B1.setRotationPoint(3F, -6.75F, -2.599F);		Accessory_B2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_H.setRotationPoint(0.0F, 1.5F, 0.0F);		Accessory_HRF1.setRotationPoint(-2.3F, 0.4F, -1.4F);		Accessory_HRF1.setRotateAngleZ(0.226888F);		Accessory_HRF2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HRF3.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HRF3.setRotateAngleZ(0.08726461F);		Accessory_HR1.setRotationPoint(-2.7F, 0.0F, -0.65F);		Accessory_HR1.setRotateAngleY(((float) Math.PI / 2F));		Accessory_HR2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HLF1.setRotationPoint(2.3F, 0.4F, -1.4F);		Accessory_HLF1.setRotateAngleZ(-0.226888F);		Accessory_HLF2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HLF3.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HLF3.setRotateAngleZ(-0.08726461F);		Accessory_HL1.setRotationPoint(2.7F, 0.0F, -0.65F);		Accessory_HL1.setRotateAngleY(-((float) Math.PI / 2F));		Accessory_HL2.setRotationPoint(0.0F, 0.0F, 0.0F);		Accessory_HB1.setRotationPoint(0.0F, 0.0F, 0.3F);		Accessory_HB1.setRotateAngleY((float) Math.PI);		Accessory_HB2.setRotationPoint(0.0F, 0.0F, 0.0F);		ArmAccessory_RF.setRotationPoint(0.0F, 5.0F, 0.0F);		ArmAccessory_RB.setRotationPoint(0.0F, 0.0F, 0.0F);		ArmAccessory_RR.setRotationPoint(0.0F, 0.0F, 0.0F);		ArmAccessory_RL.setRotationPoint(0.0F, 0.0F, 0.0F);		ArmAccessory_R.setRotationPoint(-1.5F, 0.36F, -1.97F);		ArmAccessory_R.setRotateAngleY(0.01745292F);		Belt_R.setRotationPoint(-0.3F, 0.35F, 0.0F);		Belt_R.setRotateAngleX(((float) Math.PI * 2F / 9F));		Belt_R.setRotateAngleY(-((float) Math.PI / 2F));		Belt_L.setRotationPoint(0.3F, 0.35F, 0.0F);		Belt_L.setRotateAngleX(((float) Math.PI * 2F / 9F));		Belt_L.setRotateAngleY(((float) Math.PI / 2F));		BeltAccessory_L.setRotationPoint(2.301F, 2.2F, 0.0F);		BeltAccessory_L.setRotateAngleY(-((float) Math.PI / 2F));		Incom_1.setRotationPoint(4F, -1.75F, -2.1F);		Incom_1.setRotateAngleX(((float) Math.PI / 2F));		Incom_1.setRotateAngleY(-1.919821F);		Incom_1.setRotateAngleZ(-((float) Math.PI / 2F));		Incom_2.setRotationPoint(3.1F, -1.0F, -4F);		Incom_2.setRotateAngleZ(-0.2617939F);		Incom_3.setRotationPoint(0.0F, 0.0F, 0.0F);		Shaggy_B1.setRotationPoint(0.0F, -8.0F, 4.0F);		Shaggy_B1.setRotateAngleX(10F / 180F * 3.141526F);		Shaggy_B2.setRotationPoint(0.0F, -6.0F, 4F);		Shaggy_B2.setRotateAngleX(0.1745292F);		Shaggy_B3.setRotationPoint(0.0F, -4.0F, 4F);		Shaggy_B3.setRotateAngleX(0.1745292F);		Shaggy_B4.setRotationPoint(0.0F, -2.0F, 4F);		Shaggy_B4.setRotateAngleX(0.2617939F);		Shaggy_B5.setRotationPoint(0.0F, -1.0F, 4F);		Shaggy_B5.setRotateAngleX(0.2617939F);		Shaggy_R1.setRotationPoint(-4.0F, -8.0F, 0.0F);		Shaggy_R1.setRotateAngleZ(10F / 180F * 3.141526F);		Shaggy_R2.setRotationPoint(-4F, -6.0F, 0.0F);		Shaggy_R2.setRotateAngleZ(0.1745292F);		Shaggy_R3.setRotationPoint(-4F, -4.0F, 0.0F);		Shaggy_R3.setRotateAngleZ(0.1745292F);		Shaggy_R4.setRotationPoint(-4F, -2.0F, 0.0F);		Shaggy_R4.setRotateAngleZ(0.2617939F);		Shaggy_R5.setRotationPoint(-4F, -1.0F, 0.0F);		Shaggy_R5.setRotateAngleZ(0.2617939F);		Shaggy_L1.setRotationPoint(4.0F, -8.0F, 0.0F);		Shaggy_L1.setRotateAngleZ(-10F / 180F * 3.141526F);		Shaggy_L2.setRotationPoint(4F, -6.0F, 0.0F);		Shaggy_L2.setRotateAngleZ(-0.1745292F);		Shaggy_L3.setRotationPoint(4F, -4.0F, 0.0F);		Shaggy_L3.setRotateAngleZ(-0.1745292F);		Shaggy_L4.setRotationPoint(4F, -2.0F, 0.0F);		Shaggy_L4.setRotateAngleZ(-0.2617939F);		Shaggy_L5.setRotationPoint(4F, -1.0F, 0.0F);		Shaggy_L5.setRotateAngleZ(-0.2617939F);		sensor1.setRotationPoint(0.0F, -8.0F, 0.0F);		sensor2.setRotationPoint(0.0F, -8.0F, 0.0F);		sensor3.setRotationPoint(0.0F, -8.0F, 0.0F);		sensor4.setRotationPoint(0.0F, -8.0F, 0.0F);		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Cheek_R.setRotationPoint(0.0F, 1.0F, 0.0F);		Cheek_L.setRotationPoint(0.0F, 1.0F, 0.0F);		Head_F.setRotationPoint(3.25F, -5.25F, -4.002F);		Body_B.setRotationPoint(0.0F, 0.0F, 2.001F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedHead.removeChild(Tail);
		((ModelRenderer) mainFrame).removeChild(Skirt);
//		lowerBody.removeBoneChild(Skirt);
		Skirt_R.clearChildModels();
		Skirt_L.clearChildModels();
		Skirt_RF.clearChildModels();
		Skirt_RF.addChild(Skirt_RB);
		Skirt_RF.addChild(Skirt_RR);
		Skirt_RF.addChild(Skirt_RL);
		Skirt_R.addChild(Skirt_RF);
		Skirt_LF.clearChildModels();
		Skirt_LF.addChild(Skirt_LB);
		Skirt_LF.addChild(Skirt_LR);
		Skirt_LF.addChild(Skirt_LL);
		Skirt_L.addChild(Skirt_LF);
		Arm_RF.clearChildModels();
		Arm_RF.addChild(Arm_RB);
		Arm_RF.addChild(Arm_RR);
		Arm_RF.addChild(Arm_RL);
		Arm_LF.clearChildModels();
		Arm_LF.addChild(Arm_LB);
		Arm_LF.addChild(Arm_LR);
		Arm_LF.addChild(Arm_LL);
		Parka_1.clearChildModels();
		Parka_1.addChild(Parka_2);
		Parka_1.addChild(RabbitEar_RB1);
		RabbitEar_RB1.clearChildModels();
		RabbitEar_RB1.addChild(RabbitEar_RB2);
		Parka_1.addChild(RabbitEar_LB1);
		RabbitEar_LB1.clearChildModels();
		RabbitEar_LB1.addChild(RabbitEar_LB2);
		RabbitEar_R1.clearChildModels();
		RabbitEar_R1.addChild(RabbitEar_R2);
		RabbitEar_R2.addChild(RabbitEar_R3);
		RabbitEar_R3.addChild(RabbitEar_R4);
		RabbitEar_L1.clearChildModels();
		RabbitEar_L1.addChild(RabbitEar_L2);
		RabbitEar_L2.addChild(RabbitEar_L3);
		RabbitEar_L3.addChild(RabbitEar_L4);
		PigTail_R1.clearChildModels();
		PigTail_R1.addChild(PigTail_R2);
		PigTail_L1.clearChildModels();
		PigTail_L1.addChild(PigTail_L2);
		Accessory_S1.clearChildModels();
		Accessory_S1.addChild(Accessory_S2);
		Accessory_B1.clearChildModels();
		Accessory_B1.addChild(Accessory_B2);
		Accessory_H.clearChildModels();
		Accessory_H.addChild(Accessory_HRF1);
		Accessory_HRF1.clearChildModels();
		Accessory_HRF1.addChild(Accessory_HRF2);
		Accessory_HRF1.addChild(Accessory_HRF3);
		Accessory_H.addChild(Accessory_HR1);
		Accessory_HR1.clearChildModels();
		Accessory_HR1.addChild(Accessory_HR2);
		Accessory_H.addChild(Accessory_HLF1);
		Accessory_HLF1.clearChildModels();
		Accessory_HLF1.addChild(Accessory_HLF2);
		Accessory_HLF1.addChild(Accessory_HLF3);
		Accessory_H.addChild(Accessory_HL1);
		Accessory_HL1.clearChildModels();
		Accessory_HL1.addChild(Accessory_HL2);
		Accessory_H.addChild(Accessory_HB1);
		Accessory_HB1.clearChildModels();
		Accessory_HB1.addChild(Accessory_HB2);
		Accessory_H.addChild(Belt_R);
		Accessory_H.addChild(Belt_L);
		Belt_L.clearChildModels();
		Belt_L.addChild(BeltAccessory_L);
		ArmAccessory_RF.clearChildModels();
		ArmAccessory_RF.addChild(ArmAccessory_R);
		ArmAccessory_RF.addChild(ArmAccessory_RB);
		ArmAccessory_RF.addChild(ArmAccessory_RR);
		ArmAccessory_RF.addChild(ArmAccessory_RL);
		Incom_2.clearChildModels();
		Incom_2.addChild(Incom_3);
		Breast_C.clearChildModels();
		Breast_C.addChild(Breast_U);
		Breast_C.addChild(Breast_B);
		Breast_C.addChild(Breast_R);
		Breast_R.clearChildModels();
		Breast_R.addChild(Breast_RU);
		Breast_R.addChild(Breast_RB);
		Breast_C.addChild(Breast_L);
		Breast_L.clearChildModels();
		Breast_L.addChild(Breast_LU);
		Breast_L.addChild(Breast_LB);
		bipedHead.addChild(Incom_1);
		bipedHead.addChild(Incom_2);
		bipedHead.addChild(Shaggy_B1);
		bipedHead.addChild(Shaggy_B2);
		bipedHead.addChild(Shaggy_B3);
		bipedHead.addChild(Shaggy_B4);
		bipedHead.addChild(Shaggy_B5);
		bipedHead.addChild(Shaggy_R1);
		bipedHead.addChild(Shaggy_R2);
		bipedHead.addChild(Shaggy_R3);
		bipedHead.addChild(Shaggy_R4);
		bipedHead.addChild(Shaggy_R5);
		bipedHead.addChild(Shaggy_L1);
		bipedHead.addChild(Shaggy_L2);
		bipedHead.addChild(Shaggy_L3);
		bipedHead.addChild(Shaggy_L4);
		bipedHead.addChild(Shaggy_L5);
		bipedHead.addChild(sensor1);
		bipedHead.addChild(sensor2);
		bipedHead.addChild(sensor3);
		bipedHead.addChild(sensor4);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
		bipedHead.addChild(Head_F);
		bipedHead.addChild(RabbitEar_R1);
		bipedHead.addChild(RabbitEar_L1);
		bipedHead.addChild(HairOrnament_R);
		bipedHead.addChild(HairOrnament_L);
		bipedHead.addChild(PigTail_R1);
		bipedHead.addChild(PigTail_L1);
		bipedHead.addChild(Accessory_S1);
		bipedHead.addChild(Accessory_B1);
		bipedBody.addChild(Skirt);
		bipedBody.addChild(Parka_1);
		bipedBody.addChild(Parka_F);
		bipedBody.addChild(Parka_B);
		bipedBody.addChild(Parka_R);
		bipedBody.addChild(Parka_L);
		bipedBody.addChild(Accessory_H);
		bipedBody.addChild(Body_B);
		bipedBody.addChild(Breast);
		bipedBody.addChild(Breast_C);
		bipedRightArm.addChild(Arm_RF);
		bipedRightArm.addChild(ArmAccessory_RF);
		bipedLeftArm.addChild(Arm_LF);
		bipedRightLeg.addChild(Skirt_R);
		bipedLeftLeg.addChild(Skirt_L);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		Breast.setRotationPoint(0.0F, -3.0F, -2F);
		Breast.setRotateAngleZ(((float) Math.PI / 2F));
		Breast.setRotateAngleY(((float) Math.PI * 2F / 9F));
		Breast_C.setRotationPoint(0.0F, -1.5F, -2.25F);
		Breast_U.setRotationPoint(0.0F, 0.0F, 0.0F);
		Breast_U.setRotateAngleX(-0.2617939F);
		Breast_B.setRotationPoint(0.0F, 1.0F, 0.0F);
		Breast_B.setRotateAngleX(0.2617939F);
		Breast_R.setRotationPoint(-2F, 0.5F, 0.0F);
		Breast_R.setRotateAngleY(0.2617939F);
		Breast_RU.setRotationPoint(0.0F, -0.5F, 0.0F);
		Breast_RU.setRotateAngleX(-0.2617939F);
		Breast_RB.setRotationPoint(0.0F, 0.5F, 0.0F);
		Breast_RB.setRotateAngleX(0.2617939F);
		Breast_L.setRotationPoint(2.0F, 0.5F, 0.0F);
		Breast_L.setRotateAngleY(-0.2617939F);
		Breast_LU.setRotationPoint(0.0F, -0.5F, 0.0F);
		Breast_LU.setRotateAngleX(-0.2617939F);
		Breast_LB.setRotationPoint(0.0F, 0.5F, 0.0F);
		Breast_LB.setRotateAngleX(0.2617939F);
		mainFrame.setRotationPoint(0.0F, 8.0F, 0.0F);
	}	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		int ticksExisted = Helper.getEntityTicksExisted(entityliving);
		float f3 = (float)ticksExisted + f2 + ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			setCapsValue(entityCaps, caps_visible, Cheek_R, true);
			setCapsValue(entityCaps, caps_visible, Cheek_L, true);
			RabbitEar_R3.rotateAngleZ = mh_sin(f3 * 0.09F) * 0.09F + 0.87F;
			RabbitEar_L3.rotateAngleZ = -(mh_sin(f3 * 0.09F) * 0.09F + 0.87F);
		} else {
			setCapsValue(entityCaps, caps_visible, Cheek_R, false);
			setCapsValue(entityCaps, caps_visible, Cheek_L, false);
			RabbitEar_R3.rotateAngleZ = ((float) Math.PI / 4F);
			RabbitEar_L3.rotateAngleZ = -((float) Math.PI / 4F);
		}		if (entityCaps.getCapsValue(caps_currentArmor, 3) != null) {
			Parka_1.setVisible(false);
			Parka_2.setVisible(false);
			RabbitEar_RB1.setVisible(false);
			RabbitEar_RB2.setVisible(false);
			RabbitEar_LB1.setVisible(false);
			RabbitEar_LB2.setVisible(false);
			sensor1.setVisible(false);
			sensor2.setVisible(false);
			sensor3.setVisible(false);
			sensor4.setVisible(false);
		} else {
			Parka_1.setVisible(true);
			Parka_2.setVisible(true);
			RabbitEar_RB1.setVisible(true);
			RabbitEar_RB2.setVisible(true);
			RabbitEar_LB1.setVisible(true);
			RabbitEar_LB2.setVisible(true);
			sensor1.setVisible(true);
			sensor2.setVisible(true);
			sensor3.setVisible(true);
			sensor4.setVisible(true);
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Skirt.setRotationPoint(0.0F, 3.5F, 0.0F);
		Skirt.setRotateAngle(0.0F, 0.0F, 0.0F);		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			RabbitEar_RB1.setRotateAngleX(0.08726461F);
			RabbitEar_LB1.setRotateAngleX(0.08726461F);
			RabbitEar_RB2.setRotateAngleX(0.6108523F);
			RabbitEar_LB2.setRotateAngleX(0.6108523F);
		} else {
			RabbitEar_RB1.setRotateAngleX(0.0F);
			RabbitEar_LB1.setRotateAngleX(0.0F);
			RabbitEar_RB2.setRotateAngleX(0.08726461F);
			RabbitEar_LB2.setRotateAngleX(0.08726461F);
		}
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
	}////	@Override
//	public void actionPartsAddChild() {
//		Modchu_Debug.mDebug("actionPartsAddChild");
//		super.actionPartsAddChild();
//		bipedRightLeg.removeChild(Skirt_R);
//		bipedRightArm.removeChild(Arm_RF);
//		bipedRightArm.removeChild(ArmAccessory_RF);
//		bipedLeftLeg.removeChild(Skirt_L);
//		bipedLeftArm.removeChild(Arm_LF);
//		rightLeg.addChild(Skirt_R);
//		rightArm.addChild(Arm_RF);
//		rightArm2.addChild(ArmAccessory_RF);
//		leftLeg.addChild(Skirt_L);
//		leftArm.addChild(Arm_LF);
//		//((ModchuModel_ModelRenderer) mainFrame).removeChild(Skirt);
//		//bipedBody.addChild(Skirt);
//	}	@Override
	public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
		bipedHead.isHidden = !b;
		super.setArmorBipedHeadShowModel(entityCaps, b);
		RabbitEar_R1.setVisible(b);
		RabbitEar_R2.setVisible(b);
		RabbitEar_R3.setVisible(b);
		RabbitEar_R4.setVisible(b);
		RabbitEar_L1.setVisible(b);
		RabbitEar_L2.setVisible(b);
		RabbitEar_L3.setVisible(b);
		RabbitEar_L4.setVisible(b);
		HairOrnament_R.setVisible(b);
		HairOrnament_L.setVisible(b);
		PigTail_R1.setVisible(b);
		PigTail_R2.setVisible(b);
		PigTail_L1.setVisible(b);
		PigTail_L2.setVisible(b);
		Accessory_S1.setVisible(b);
		Accessory_S2.setVisible(b);
		Accessory_B1.setVisible(b);
		Accessory_B2.setVisible(b);
		Incom_1.setVisible(b);
		Incom_2.setVisible(b);
		Incom_3.setVisible(b);
		Shaggy_B1.setVisible(b);
		Shaggy_B2.setVisible(b);
		Shaggy_B3.setVisible(b);
		Shaggy_B4.setVisible(b);
		Shaggy_B5.setVisible(b);
		Shaggy_R1.setVisible(b);
		Shaggy_R2.setVisible(b);
		Shaggy_R3.setVisible(b);
		Shaggy_R4.setVisible(b);
		Shaggy_R5.setVisible(b);
		Shaggy_L1.setVisible(b);
		Shaggy_L2.setVisible(b);
		Shaggy_L3.setVisible(b);
		Shaggy_L4.setVisible(b);
		Shaggy_L5.setVisible(b);
		sensor1.setVisible(b);
		sensor2.setVisible(b);
		sensor3.setVisible(b);
		sensor4.setVisible(b);
		eyeR.setVisible(b);
		eyeL.setVisible(b);
		Cheek_R.setVisible(b);
		Cheek_L.setVisible(b);
		Head_F.setVisible(b);
	}	@Override
	public void setArmorBipedBodyShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
		Arm_RF.setVisible(b);
		Arm_RB.setVisible(b);
		Arm_RR.setVisible(b);
		Arm_RL.setVisible(b);
		Arm_LF.setVisible(b);
		Arm_LB.setVisible(b);
		Arm_LR.setVisible(b);
		Arm_LL.setVisible(b);
		Parka_1.setVisible(b);
		Parka_2.setVisible(b);
		Parka_F.setVisible(b);
		Parka_B.setVisible(b);
		Parka_R.setVisible(b);
		Parka_L.setVisible(b);
		RabbitEar_RB1.setVisible(b);
		RabbitEar_RB2.setVisible(b);
		RabbitEar_LB1.setVisible(b);
		RabbitEar_LB2.setVisible(b);
		Accessory_H.setVisible(b);
		Accessory_HRF1.setVisible(b);
		Accessory_HRF2.setVisible(b);
		Accessory_HRF3.setVisible(b);
		Accessory_HR1.setVisible(b);
		Accessory_HR2.setVisible(b);
		Accessory_HLF1.setVisible(b);
		Accessory_HLF2.setVisible(b);
		Accessory_HLF3.setVisible(b);
		Accessory_HL1.setVisible(b);
		Accessory_HL2.setVisible(b);
		Accessory_HB1.setVisible(b);
		Accessory_HB2.setVisible(b);
		ArmAccessory_RF.setVisible(b);
		ArmAccessory_RB.setVisible(b);
		ArmAccessory_RR.setVisible(b);
		ArmAccessory_RL.setVisible(b);
		ArmAccessory_R.setVisible(b);
		Belt_R.setVisible(b);
		Belt_L.setVisible(b);
		BeltAccessory_L.setVisible(b);
		Body_B.setVisible(b);
		Breast.setVisible(b);
		Breast_C.setVisible(b);
		Breast_U.setVisible(b);
		Breast_B.setVisible(b);
		Breast_R.setVisible(b);
		Breast_L.setVisible(b);
		Breast_RU.setVisible(b);
		Breast_LU.setVisible(b);
		Breast_RB.setVisible(b);
		Breast_LB.setVisible(b);
		Breast_C.rotationPointZ = -2.35F;
		//Skirt_LR.setRotationPoint(3.39F, 0.0F, 0.0F);
	}	@Override
	public void setArmorBipedRightArmShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedRightArmShowModel(entityCaps, b);
		bipedRightArm.isHidden = !b;
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
		Skirt_R.setVisible(b);
		Skirt_L.setVisible(b);
		Skirt_RF.setVisible(b);
		Skirt_RB.setVisible(b);
		Skirt_RR.setVisible(b);
		Skirt_RL.setVisible(b);
		Skirt_LF.setVisible(b);
		Skirt_LB.setVisible(b);
		Skirt_LR.setVisible(b);
		Skirt_LL.setVisible(b);
	}	@Override
	public void setArmorBipedLeftArmShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedLeftArmShowModel(entityCaps, b);
		bipedLeftArm.isHidden = !b;
	}	@Override
	public void setArmorBipedRightLegShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedRightLegShowModel(entityCaps, b);
		bipedRightLeg.isHidden = !b;
	}	@Override
	public void setArmorBipedLeftLegShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorBipedLeftLegShowModel(entityCaps, b);
		bipedLeftLeg.isHidden = !b;
	}
}