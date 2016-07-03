package littleMaidMobX.model.maids;import java.util.ArrayList;import java.util.List;import littleMaidMobX.util.helper.Helper;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLivingBase;public class MultiModel_Yomu extends ModelModchuBaseSR2 {	public ModelRenderer Prim;
	public ModelRenderer Tail2;
	public ModelRenderer Skirt1;
	public ModelRenderer Skirt2;
	public ModelRenderer Skirt3;
	public ModelRenderer Skirt4;
	public ModelRenderer Skirt5;
	public ModelRenderer Skirt6;
	public ModelRenderer Skirt7;
	public ModelRenderer Skirt8;
	public ModelRenderer Skirt9;
	public ModelRenderer Skirt10;
	public ModelRenderer Skirt11;
	public ModelRenderer Skirt12;
	public ModelRenderer Skirt13;
	public ModelRenderer Skirt14;
	public ModelRenderer Skirt15;
	public ModelRenderer Skirt16;
	public ModelRenderer HipR;
	public ModelRenderer HipL;
	public ModelRenderer Headband1;
	public ModelRenderer Headband2;
	public ModelRenderer Headband3;
	public ModelRenderer Headband4;
	public ModelRenderer Ribon1;
	public ModelRenderer Ribon2;
	public ModelRenderer Ribon3;
	public ModelRenderer Neck;
	public ModelRenderer Ribon4;
	public ModelRenderer Ribon5;
	public ModelRenderer Ribon6;
	public ModelRenderer Collar1;
	public ModelRenderer Collar2;
	public ModelRenderer Collar3;
	public ModelRenderer Collar4;
	public ModelRenderer Collar5;
	public ModelRenderer Collar6;
	public ModelRenderer Collar7;
	public ModelRenderer Best1;
	public ModelRenderer Best2;
	public ModelRenderer Patch;
	public ModelRenderer Hear;
	public ModelRenderer BradeC;
	public ModelRenderer Brade1;
	public ModelRenderer Brade2;
	public ModelRenderer Brade3;
	public ModelRenderer Brade4;
	public ModelRenderer Tuka1;
	public ModelRenderer Tuka2;
	public ModelRenderer Tuka3;
	public ModelRenderer Tuka4;
	public ModelRenderer Tuka5;
	public ModelRenderer Tuka6;
	public ModelRenderer HanreiC;
	public ModelRenderer Hanrei1;
	public ModelRenderer Hanrei2;
	public ModelRenderer Hanrei3;
	public ModelRenderer Hanrei4;
	public ModelRenderer Hanrei5;
	public ModelRenderer Hanrei6;	// armor only
	public ModelRenderer PlateR1;
	public ModelRenderer PlateR2;
	public ModelRenderer PlateR3;
	public ModelRenderer PlateR4;
	public ModelRenderer PlateR5;
	public ModelRenderer PlateR6;
	public ModelRenderer PlateL1;
	public ModelRenderer PlateL2;
	public ModelRenderer PlateL3;
	public ModelRenderer PlateL4;
	public ModelRenderer PlateL5;
	public ModelRenderer PlateL6;
	public ModelRenderer Glass;	private float x1;
	private float y1;
	private float z1;
	private float IdOffset;
	private List IdList;
	private List AngleYList;
	private List YawOffsetList;
	private float AY;
	private float prevAY;	private float[] pastX = new float[10];
	private float[] pastY = new float[10];
	private float[] pastZ = new float[10];		public MultiModel_Yomu(StringBuilder hack) {		super(hack);	}	public MultiModel_Yomu() {
		this(0.0F);
	}	public MultiModel_Yomu(float f) {
		this(f, 0.0F);
	}	public MultiModel_Yomu(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Yomu(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureHeight = 64;
		textureWidth = 64;
		f1 += 8F;
		IdList = new ArrayList();
		AngleYList = new ArrayList();
		YawOffsetList = new ArrayList();
		bipedHead = new ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
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
		bipedLeftLeg = new ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		Skirt = new ModelRenderer(this, 0, 16);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		HipR = new ModelRenderer(this, 57, 28);
		HipR.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipR.setRotationPoint(0.6F, 1.1F, 2.0F);
		HipR.setRotateAngleDeg(-150F, 0F, 0F);		HipL = new ModelRenderer(this, 57, 24);
		HipL.mirror = true;
		HipL.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipL.setRotationPoint(-0.6F, 1.1F, 2.0F);
		HipL.setRotateAngleDeg(-150F, 0F, 0F);		eyeR = new ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Prim = new ModelRenderer(this, 24, 16);
		Prim.addPlate(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);		Skirt1 = new ModelRenderer(this, 0, 33);//-22,33
		Skirt1.addPlate(-0.8F, -6F, 0F, 20, 6, 0, f);
		Skirt1.setRotationPoint(0F, -5.5F, 0F);		Skirt2 = new ModelRenderer(this, 0, 27);
		Skirt2.addPlate(-0.8F, 0F, 0F, 20, 6, 0, f);
		Skirt2.setRotationPoint(0F, -5.5F, 0F);		Skirt3 = new ModelRenderer(this, 0, 33);
		Skirt3.addPlate(0F, -6F, 0F, 20, 6, 0, f);
		Skirt3.setRotationPoint(0F, -6.0F, 0F);		Skirt4 = new ModelRenderer(this, 0, 27);
		Skirt4.addPlate(0F, 0F, 0F, 20, 6, 0, f);
		Skirt4.setRotationPoint(0F, -6.0F, 0F);		Skirt5 = new ModelRenderer(this, 0, 33);
		Skirt5.addPlate(0F, -6F, 0F, 20, 6, 0, f);
		Skirt5.setRotationPoint(0F, -6.0F, 0F);		Skirt6 = new ModelRenderer(this, 0, 27);
		Skirt6.addPlate(0F, 0F, 0F, 20, 6, 0, f);
		Skirt6.setRotationPoint(0F, -6.0F, 0F);		Skirt7 = new ModelRenderer(this, 0, 33);
		Skirt7.addPlate(-0.8F, -6F, 0F, 20, 6, 0, f);
		Skirt7.setRotationPoint(0F, -5.5F, 0F);		Skirt8 = new ModelRenderer(this, 0, 27);
		Skirt8.addPlate(-0.8F, 0F, 0F, 20, 6, 0, f);
		Skirt8.setRotationPoint(0F, -5.5F, 0F);		Skirt9 = new ModelRenderer(this, 0, 33);
		Skirt9.addPlate(-0.8F, -6F, 0F, 20, 6, 0, f);
		Skirt9.setRotationPoint(0F, -5.5F, 0F);		Skirt10 = new ModelRenderer(this, 0, 27);
		Skirt10.addPlate(-0.8F, 0F, 0F, 20, 6, 0, f);
		Skirt10.setRotationPoint(0F, -5.5F, 0F);		Skirt11 = new ModelRenderer(this, 0, 33);
		Skirt11.addPlate(0F, -6F, 0F, 20, 6, 0, f);
		Skirt11.setRotationPoint(0F, -6.0F, 0F);		Skirt12 = new ModelRenderer(this, 0, 27);
		Skirt12.addPlate(0F, 0F, 0F, 20, 6, 0, f);
		Skirt12.setRotationPoint(0F, -6.0F, 0F);		Skirt13 = new ModelRenderer(this, 0, 33);
		Skirt13.addPlate(0F, -6F, 0F, 20, 6, 0, f);
		Skirt13.setRotationPoint(0F, -6.0F, 0F);		Skirt14 = new ModelRenderer(this, 0, 27);
		Skirt14.addPlate(0F, 0F, 0F, 20, 6, 0, f);
		Skirt14.setRotationPoint(0F, -6.0F, 0F);		Skirt15 = new ModelRenderer(this, 0, 33);
		Skirt15.addPlate(-0.8F, -6F, 0F, 20, 6, 0, f);
		Skirt15.setRotationPoint(0F, -5.5F, 0F);		Skirt16 = new ModelRenderer(this, 0, 27);
		Skirt16.addPlate(-0.8F, 0F, 0F, 20, 6, 0, f);
		Skirt16.setRotationPoint(0F, -5.5F, 0F);		Neck = new ModelRenderer(this, 16, 5);
		Neck.addBox(-1.0F, -1.0F, 1.0F, 2, 1, 2, f);
		Neck.setRotationPoint(0.0F, -3.0F, -2.0F);		Collar1 = new ModelRenderer(this, 0, 16);
		Collar1.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar1.setRotationPoint(0.0F, -2.5F, -2.2F);
		Collar1.setRotateAngleDeg(10F, -172F, -45F);		Collar2 = new ModelRenderer(this, 0, 16);
		Collar2.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar2.setRotationPoint(0.0F, -2.5F, -2.2F);
		Collar2.setRotateAngleDeg(-76F, -170F, -44F);		Collar3 = new ModelRenderer(this, 0, 16);
		Collar3.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar3.setRotationPoint(0.0F, -2.5F, -2.2F);
		Collar3.setRotateAngleDeg(-10F, -8F, -45F);		Collar4 = new ModelRenderer(this, 0, 16);
		Collar4.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar4.setRotationPoint(0.0F, -2.5F, -2.2F);
		Collar4.setRotateAngleDeg(76F, -10F, -44F);		Collar5 = new ModelRenderer(this, 0, 16);
		Collar5.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar5.setRotationPoint(1.5F, -2.6F, -1.99F);
		Collar5.setRotateAngleDeg(45F, -90F, 0F);		Collar6 = new ModelRenderer(this, 0, 16);
		Collar6.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar6.setRotationPoint(-1.5F, -2.6F, -1.99F);
		Collar6.setRotateAngleDeg(45F, -90F, 0F);		Collar7 = new ModelRenderer(this, 48, 2);
		Collar7.addBox(-2.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar7.setRotationPoint(0.0F, -2.58F, 1.4F);
		Collar7.setRotateAngleDeg(45F, 0F, 0F);		Best1 = new ModelRenderer(this, 0, 5);
		Best1.addPlate(0.0F, 0.0F, 0.0F, 3, 1, 0, f);
		Best1.setRotationPoint(0.0F, -0.5F, -2.001F);
		Best1.setRotateAngleDeg(0F, 0F, -61F);		Best2 = new ModelRenderer(this, 0, 5);
		Best2.addPlate(0.0F, 0.0F, 0.0F, 3, 1, 0, f);
		Best2.setRotationPoint(0.0F, -0.5F, -2.001F);
		Best2.setRotateAngleDeg(0F, -180F, -61F);		Patch = new ModelRenderer(this, 0, 39);
		Patch.addPlate(0.0F, 0.0F, 0.0F, 20, 20, 0, f);
		Patch.setRotationPoint(0.8F, -2.1F, -2.002F);
		Patch.setRotateAngleDeg(0F, 0F, 0F);		Headband1 = new ModelRenderer(this, 0, 20);
		Headband1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband1.setRotationPoint(-0.3F, -7.7F, -2.5F);
		Headband1.setRotateAngleDeg(0F, 0F, 0F);		Headband2 = new ModelRenderer(this, 0, 20);
		Headband2.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband2.setRotationPoint(0.3F, -7.701F, -2.5F);
		Headband2.setRotateAngleDeg(0F, 0F, 0F);		Headband3 = new ModelRenderer(this, 0, 20);
		Headband3.addBox(0.0F, -1.0F, 0.0F, 5, 1, 2, f);
		Headband3.setRotationPoint(-4.699F, -7.701F, -2.5F);
		Headband3.setRotateAngleDeg(0F, 0F, 90F);		Headband4 = new ModelRenderer(this, 0, 20);
		Headband4.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband4.setRotationPoint(4.701F, -7.7F, -2.5F);
		Headband4.setRotateAngleDeg(0F, 0F, 90F);		Ribon1 = new ModelRenderer(this, 16, 16);
		Ribon1.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon1.setRotationPoint(-3.0F, -7.0F, -1.2F);
		Ribon1.setRotateAngleDeg(-135F, 180F, -118F);		Ribon2 = new ModelRenderer(this, 16, 16);
		Ribon2.addBox(-0.2F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon2.setRotationPoint(-3.0F, -7.0F, -1.2F);
		Ribon2.setRotateAngleDeg(-135F, 180F, -90F);		Ribon3 = new ModelRenderer(this, 16, 16);
		Ribon3.addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon3.setRotationPoint(-3.0F, -7.0F, -1.2F);
		Ribon3.setRotateAngleDeg(-135F, 180F, -59F);		Ribon4 = new ModelRenderer(this, 0, 22);
		Ribon4.addBox(-1.0F, -0.5F, -0.2F, 2, 1, 1, f);
		Ribon4.setRotationPoint(0.0F, -1.9F, -2.2F);
		Ribon4.setRotateAngleDeg(0F, 0F, 0F);		Ribon5 = new ModelRenderer(this, 0, 22);
		Ribon5.addBox(0.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon5.setRotationPoint(0.3F, -1.7F, -2.2F);
		Ribon5.setRotateAngleDeg(0F, 0F, 15F);		Ribon6 = new ModelRenderer(this, 0, 22);
		Ribon6.addBox(-1.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon6.setRotationPoint(-0.3F, -1.7F, -2.2F);
		Ribon6.setRotateAngleDeg(0F, 0F, -15F);		Hear = new ModelRenderer(this, 20, 32);
		Hear.addBox(-4F, -3.5F, -4F, 8, 7, 8, f);
		Hear.setRotationPoint(0.0F, -3.5F, -0.001F);		BradeC = new ModelRenderer(this, 0, 0);
		BradeC.addBox(0F, 0F, 0.0F, 0, 0, 0, f);
		BradeC.setRotationPoint(0.2F, -4.3F, -0.9F);
		BradeC.setRotateAngleDeg(-20F, 0F, 5F);		Brade1 = new ModelRenderer(this, 0, 0);
		Brade1.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 1, f);
		Brade1.setRotationPoint(3F, 3.5F, 0F);
		Brade1.setRotateAngleDeg(0F, 0F, 0F);		Brade2 = new ModelRenderer(this, 0, 21);
		Brade2.addBox(0.0F, -1.0F, -0.5F, 3, 2, 1, f);
		Brade2.setRotationPoint(3F, 3.5F, 0F);
		Brade2.setRotateAngleDeg(0F, 90F, 0F);		Brade3 = new ModelRenderer(this, 0, 20);
		Brade3.addBox(0.0F, -1.0F, -0.5F, 8, 2, 1, f);
		Brade3.setRotationPoint(3F, 3.5F, 0.001F);
		Brade3.setRotateAngleDeg(0F, -90F, 0F);		Brade4 = new ModelRenderer(this, 0, 21);
		Brade4.addBox(0.0F, -1.0F, -0.5F, 4, 2, 1, f);
		Brade4.setRotationPoint(3F, 3.5F, 7.99F);
		Brade4.setRotateAngleDeg(0F, -90F, 5F);		Tuka1 = new ModelRenderer(this, 0, 9);
		Tuka1.addPlate(-0.5F, -0.5F, -0.5F, 1, 1, 0, f);
		Tuka1.setRotationPoint(3.001F, 3.5F, -2.5F);
		Tuka1.setRotateAngleDeg(0F, -90F, -45F);		Tuka2 = new ModelRenderer(this, 0, 9);
		Tuka2.addPlate(-0.5F, -0.5F, -0.5F, 1, 1, 0, f);
		Tuka2.setRotationPoint(3.001F, 3.5F, -1.5F);
		Tuka2.setRotateAngleDeg(0F, -90F, -45F);		Tuka3 = new ModelRenderer(this, 0, 9);
		Tuka3.addPlate(-0.5F, -0.5F, -0.5F, 1, 1, 0, f);
		Tuka3.setRotationPoint(3.001F, 3.5F, -0.5F);
		Tuka3.setRotateAngleDeg(0F, -90F, -45F);		Tuka4 = new ModelRenderer(this, 0, 9);
		Tuka4.addPlate(-0.5F, -0.5F, 0.5F, 1, 1, 0, f);
		Tuka4.setRotationPoint(2.999F, 3.5F, -2.5F);
		Tuka4.setRotateAngleDeg(0F, -90F, -45F);		Tuka5 = new ModelRenderer(this, 0, 9);
		Tuka5.addPlate(-0.5F, -0.5F, 0.5F, 1, 1, 0, f);
		Tuka5.setRotationPoint(2.999F, 3.5F, -1.5F);
		Tuka5.setRotateAngleDeg(0F, -90F, -45F);		Tuka6 = new ModelRenderer(this, 0, 9);
		Tuka6.addPlate(-0.5F, -0.5F, 0.5F, 1, 1, 0, f);
		Tuka6.setRotationPoint(2.999F, 3.5F, -0.5F);
		Tuka6.setRotateAngleDeg(0F, -90F, -45F);		HanreiC = new ModelRenderer(this, 0, 0);
		//	HanreiC.addBox(6F, -2F,2F, 4, 4, 4, psize);
		HanreiC.addBall(8f, 0, 6f, 4f, 4f, 4f);
		//	HanreiC.setScale(4f,4f,4f);
		HanreiC.setRotationPoint(0F, 0F, 0F);
		x1 = 0F;
		y1 = 0F;
		z1 = 0F;
		IdOffset = 0F;
		AY = 0F;/*
		Hanrei1 = new ModchuModel_ModelRenderer(this,0 ,0);
		//	Hanrei1.addBox(-1F, -1F,-2F, 2, 2, 4, psize);
		Hanrei1.addBall(0f,0f,0f,6f,6f,6f);
		Hanrei1.setRotationPoint(0F,0.0F,0F);
		setRotationDeg(Hanrei1,0F,0F,0F);		Hanrei2 = new ModchuModel_ModelRenderer(this,2 ,24);
		Hanrei2.addBox(-1F, -1F,-2F, 2, 2, 4, psize);
		Hanrei2.setRotationPoint(8F,0.0F,4F);
		setRotationDeg(Hanrei2,90F,0F,0F);		Hanrei3 = new ModchuModel_ModelRenderer(this,2 ,24);
		Hanrei3.addBox(-1F, -1F,-2F, 2, 2, 4, psize);
		Hanrei3.setRotationPoint(8F,0.0F,4F);
		setRotationDeg(Hanrei3,0F,90F,0F);
*/
		Hanrei4 = new ModelRenderer(this, 0, 0);
		//	Hanrei4.addBox(7F, -1F,3F, 2, 2, 2, psize);
		Hanrei4.addBall(8f, 0.3f, 5.0f, 2f, 2f, 2f);
		//	Hanrei4.setScale(2f,2f,2f);
		Hanrei4.setRotationPoint(0F, 0.0F, 0F);//(8F,0.5F,6.5F);		Hanrei5 = new ModelRenderer(this, 0, 0);
		//	Hanrei5.addBox(7.5F, -0.5F,3.5F, 1, 1, 1, psize);
		Hanrei5.addBall(8f, 0.2f, 4.7f, 1f, 1f, 1f);
		//	Hanrei5.setScale(1f,1f,1f);
		Hanrei5.setRotationPoint(0F, 0F, 0F);//(8F,1F,7F)		PlateR1 = new ModelRenderer(this, 45, 52);
		PlateR1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateR1.setRotationPoint(-3.0F, 4.6F + 1.0F, 0.0F);
		PlateR1.setRotateAngleDeg(-50F, 90F, 0F);		PlateR2 = new ModelRenderer(this, 44, 60);
		PlateR2.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR2.setRotationPoint(-3.0F, 4.6F + 1.0F, 2.0F);
		PlateR2.setRotateAngleDeg(60F, 0F, -40F);		PlateR3 = new ModelRenderer(this, 44, 60);
		PlateR3.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR3.setRotationPoint(-3.0F, 4.6F + 1.0F, -2.0F);
		PlateR3.setRotateAngleDeg(-60F, 0F, -40F);		PlateR4 = new ModelRenderer(this, 44, 52);
		PlateR4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateR4.setRotationPoint(-4.5F, 6.3F + 1.0F, 0.0F);
		PlateR4.setRotateAngleDeg(-50F, 90F, 0F);		PlateR5 = new ModelRenderer(this, 44, 60);
		PlateR5.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR5.setRotationPoint(-4.5F, 6.3F + 1.0F, 2.5F);
		PlateR5.setRotateAngleDeg(60F, 0F, -40F);		PlateR6 = new ModelRenderer(this, 44, 60);
		PlateR6.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR6.setRotationPoint(-4.5F, 6.3F + 1.0F, -2.5F);
		PlateR6.setRotateAngleDeg(-60F, 0F, -40F);		PlateL1 = new ModelRenderer(this, 45, 52);
		PlateL1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateL1.setRotationPoint(3.0F, 4.6F + 1.0F, 0.0F);
		PlateL1.setRotateAngleDeg(50F, 90F, 0F);		PlateL2 = new ModelRenderer(this, 44, 60);
		PlateL2.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL2.setRotationPoint(3.0F, 4.6F + 1.0F, 2.0F);
		PlateL2.setRotateAngleDeg(60F, 0F, 40F);		PlateL3 = new ModelRenderer(this, 44, 60);
		PlateL3.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL3.setRotationPoint(3.0F, 4.6F + 1.0F, -2.0F);
		PlateL3.setRotateAngleDeg(-60F, 0F, 40F);		PlateL4 = new ModelRenderer(this, 44, 52);
		PlateL4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateL4.setRotationPoint(4.5F, 6.3F + 1.0F, 0.0F);
		PlateL4.setRotateAngleDeg(50F, 90F, 0F);		PlateL5 = new ModelRenderer(this, 44, 60);
		PlateL5.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL5.setRotationPoint(4.5F, 6.3F + 1.0F, 2.5F);
		PlateL5.setRotateAngleDeg(60F, 0F, 40F);		PlateL6 = new ModelRenderer(this, 44, 60);
		PlateL6.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL6.setRotationPoint(4.5F, 6.3F + 1.0F, -2.5F);
		PlateL6.setRotateAngleDeg(-60F, 0F, 40F);		Glass = new ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f);
		Glass.setRotationPoint(0.0F, -4.0F, -4.0F);		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);		Skirt1.setRotateAngleDeg(-118F, 113F, 42F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 42F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 42F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 42F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 42F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 42F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 42F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 42F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 42F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 42F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 42F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 42F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 42F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 42F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 42F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 42F);		int i = ModelRenderer.RotXYZ;
		Prim.setRotatePriority(i);
		i = ModelRenderer.RotXZY;
		Best1.setRotatePriority(i);
		Best2.setRotatePriority(i);
		Neck.setRotatePriority(i);
		Collar1.setRotatePriority(i);
		Collar2.setRotatePriority(i);
		Collar3.setRotatePriority(i);
		Collar4.setRotatePriority(i);
		Collar5.setRotatePriority(i);
		Collar6.setRotatePriority(i);
		Collar7.setRotatePriority(i);
		Patch.setRotatePriority(i);
		Headband1.setRotatePriority(i);
		Headband2.setRotatePriority(i);
		Headband3.setRotatePriority(i);
		Headband4.setRotatePriority(i);
		Ribon1.setRotatePriority(i);
		Ribon2.setRotatePriority(i);
		Ribon3.setRotatePriority(i);
		Ribon4.setRotatePriority(i);
		Ribon5.setRotatePriority(i);
		Ribon6.setRotatePriority(i);
		Hear.setRotatePriority(i);
		BradeC.setRotatePriority(i);
		Glass.setRotatePriority(i);
		Skirt1.setRotatePriority(i);
		Skirt2.setRotatePriority(i);
		Skirt3.setRotatePriority(i);
		Skirt4.setRotatePriority(i);
		Skirt5.setRotatePriority(i);
		Skirt6.setRotatePriority(i);
		Skirt7.setRotatePriority(i);
		Skirt8.setRotatePriority(i);
		Skirt9.setRotatePriority(i);
		Skirt10.setRotatePriority(i);
		Skirt11.setRotatePriority(i);
		Skirt12.setRotatePriority(i);
		Skirt13.setRotatePriority(i);
		Skirt14.setRotatePriority(i);
		Skirt15.setRotatePriority(i);
		Skirt16.setRotatePriority(i);
		PlateR1.setRotatePriority(i);
		PlateR2.setRotatePriority(i);
		PlateR3.setRotatePriority(i);
		PlateR4.setRotatePriority(i);
		PlateR5.setRotatePriority(i);
		PlateR6.setRotatePriority(i);
		PlateL1.setRotatePriority(i);
		PlateL2.setRotatePriority(i);
		PlateL3.setRotatePriority(i);
		PlateL4.setRotatePriority(i);
		PlateL5.setRotatePriority(i);
		PlateL6.setRotatePriority(i);
		Brade1.setRotatePriority(i);
		Brade2.setRotatePriority(i);
		Brade3.setRotatePriority(i);
		Brade4.setRotatePriority(i);
		Tuka1.setRotatePriority(i);
		Tuka2.setRotatePriority(i);
		Tuka3.setRotatePriority(i);
		Tuka4.setRotatePriority(i);
		Tuka5.setRotatePriority(i);
		Tuka6.setRotatePriority(i);
		HipR.setRotatePriority(i);
		HipL.setRotatePriority(i);		Skirt1.setScale(0.5F, 0.5F, 1.0F);
		Skirt2.setScale(0.5F, 0.5F, 1.0F);
		Skirt3.setScale(0.5F, 0.5F, 1.0F);
		Skirt4.setScale(0.5F, 0.5F, 1.0F);
		Skirt5.setScale(0.5F, 0.5F, 1.0F);
		Skirt6.setScale(0.5F, 0.5F, 1.0F);
		Skirt7.setScale(0.5F, 0.5F, 1.0F);
		Skirt8.setScale(0.5F, 0.5F, 1.0F);
		Skirt9.setScale(0.5F, 0.5F, 1.0F);
		Skirt10.setScale(0.5F, 0.5F, 1.0F);
		Skirt11.setScale(0.5F, 0.5F, 1.0F);
		Skirt12.setScale(0.5F, 0.5F, 1.0F);
		Skirt13.setScale(0.5F, 0.5F, 1.0F);
		Skirt14.setScale(0.5F, 0.5F, 1.0F);
		Skirt15.setScale(0.5F, 0.5F, 1.0F);
		Skirt16.setScale(0.5F, 0.5F, 1.0F);
		Collar1.setScale(0.7F, 0.7F, 0.7F);
		Collar2.setScale(0.6F, 0.6F, 0.6F);
		Collar3.setScale(0.7F, 0.7F, 0.7F);
		Collar4.setScale(0.6F, 0.6F, 0.6F);
		Collar5.setScale(0.9F, 0.9F, 0.9F);
		Collar6.setScale(0.9F, 0.9F, 0.9F);
		Collar7.setScale(0.8F, 0.8F, 0.8F);
		Patch.setScale(0.1F, 0.1F, 0.1F);
		Headband1.setScale(1.0F, 0.3F, 1.0F);
		Headband2.setScale(1.0F, 0.3F, 1.0F);
		Headband3.setScale(1.0F, 0.3F, 1.0F);
		Headband4.setScale(1.0F, 0.3F, 1.0F);
		Ribon4.setScale(0.5F, 0.5F, 0.5F);
		Ribon5.setScale(0.8F, 0.8F, 0.8F);
		Ribon6.setScale(0.8F, 0.8F, 0.8F);
		Hear.setScale(1.1F, 1.1F, 1.1F);
		Glass.setScale(0.5F, 0.5F, 1.0F);
		PlateR1.setScale(0.25F, 0.25F, 0.25F);
		PlateR2.setScale(0.25F, 0.25F, 0.25F);
		PlateR3.setScale(0.25F, 0.25F, 0.25F);
		PlateR4.setScale(0.25F, 0.25F, 0.25F);
		PlateR5.setScale(0.25F, 0.25F, 0.25F);
		PlateR6.setScale(0.25F, 0.25F, 0.25F);
		PlateL1.setScale(0.25F, 0.25F, 0.25F);
		PlateL2.setScale(0.25F, 0.25F, 0.25F);
		PlateL3.setScale(0.25F, 0.25F, 0.25F);
		PlateL4.setScale(0.25F, 0.25F, 0.25F);
		PlateL5.setScale(0.25F, 0.25F, 0.25F);
		PlateL6.setScale(0.25F, 0.25F, 0.25F);
		Brade1.setScale(1.0F, 0.8F, 0.3F);
		Brade2.setScale(1.0F, 0.6F, 0.8F);
		Brade3.setScale(1.0F, 0.7F, 0.9F);
		Brade4.setScale(1.0F, 0.7F, 0.9F);
		Tuka1.setScale(0.65F, 0.65F, 0.8F);
		Tuka2.setScale(0.65F, 0.65F, 0.8F);
		Tuka3.setScale(0.65F, 0.65F, 0.8F);
		Tuka4.setScale(0.65F, 0.65F, 0.8F);
		Tuka5.setScale(0.65F, 0.65F, 0.8F);
		Tuka6.setScale(0.65F, 0.65F, 0.8F);
		if (isAfterInit) afterInit(f, f1);
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
		bipedRightLeg.addChild(HipR);
		bipedLeftLeg.addChild(HipL);
		bipedHead.addChild(Prim);
		bipedBody.addChild(Neck);
		bipedBody.addChild(Collar1);
		bipedBody.addChild(Collar2);
		bipedBody.addChild(Collar3);
		bipedBody.addChild(Collar4);
		bipedBody.addChild(Collar5);
		bipedBody.addChild(Collar6);
		bipedBody.addChild(Collar7);
		bipedBody.addChild(Best1);
		bipedBody.addChild(Best2);
		bipedBody.addChild(Patch);
		bipedHead.addChild(Headband1);
		bipedHead.addChild(Headband2);
		bipedHead.addChild(Headband3);
		bipedHead.addChild(Headband4);
		bipedHead.addChild(Ribon1);
		bipedHead.addChild(Ribon2);
		bipedHead.addChild(Ribon3);
		bipedBody.addChild(Ribon4);
		bipedBody.addChild(Ribon5);
		bipedBody.addChild(Ribon6);
		bipedHead.addChild(Hear);
		bipedBody.addChild(BradeC);
		BradeC.addChild(Brade1);
		BradeC.addChild(Brade2);
		BradeC.addChild(Brade3);
		BradeC.addChild(Brade4);
		BradeC.addChild(Tuka1);
		BradeC.addChild(Tuka2);
		BradeC.addChild(Tuka3);
		BradeC.addChild(Tuka4);
		BradeC.addChild(Tuka5);
		BradeC.addChild(Tuka6);
		bipedHead.addChild(Glass);
		Skirt.addChild(Skirt1);
		Skirt.addChild(Skirt2);
		Skirt.addChild(Skirt3);
		Skirt.addChild(Skirt4);
		Skirt.addChild(Skirt5);
		Skirt.addChild(Skirt6);
		Skirt.addChild(Skirt7);
		Skirt.addChild(Skirt8);
		Skirt.addChild(Skirt9);
		Skirt.addChild(Skirt10);
		Skirt.addChild(Skirt11);
		Skirt.addChild(Skirt12);
		Skirt.addChild(Skirt13);
		Skirt.addChild(Skirt14);
		Skirt.addChild(Skirt15);
		Skirt.addChild(Skirt16);
		Skirt.addChild(PlateR1);
		Skirt.addChild(PlateR2);
		Skirt.addChild(PlateR3);
		Skirt.addChild(PlateR4);
		Skirt.addChild(PlateR5);
		Skirt.addChild(PlateR6);
		Skirt.addChild(PlateL1);
		Skirt.addChild(PlateL2);
		Skirt.addChild(PlateL3);
		Skirt.addChild(PlateL4);
		Skirt.addChild(PlateL5);
		Skirt.addChild(PlateL6);
		mainFrame.addChild(HanreiC);
		mainFrame.addChild(Hanrei4);
		mainFrame.addChild(Hanrei5);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		float f4;		Object ridingEntity = Helper.getRidingEntity(entityliving);
		int ticksExisted = Helper.getEntityTicksExisted(entityliving);
		if (isRiding
				&& ridingEntity != null) {
			f4 = (float)ticksExisted;
		} else {
			f4 = f2;
		}		float f3 = (float)ticksExisted + f4 + ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		int IdIndex;
		float renderYawOffset = ((EntityLivingBase)entityliving).renderYawOffset;//				Modchu_AS.getFloat(Modchu_AS.entityLivingBaseRenderYawOffset, entityliving);
		int entityId = ((Entity)entityliving).getEntityId();
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isOpenInv, entityliving)) {
			try {
				IdIndex = IdList.indexOf(entityId);
				HanreiC.rotateAngleY = (Float) AngleYList.get(IdIndex);
				AY = (Float) YawOffsetList.get(IdIndex);
			} catch (Exception var15) {
				IdList.add(entityId);
				AngleYList.add(HanreiC.rotateAngleY);
				YawOffsetList.add(renderYawOffset);//renderYawOffset);
				IdIndex = IdList.indexOf(entityId);
				AY = renderYawOffset;//renderYawOffset;
			} finally {
				Hanrei4.rotateAngleY = Hanrei5.rotateAngleY = HanreiC.rotateAngleY;
			}
		} else {
			try {
				IdIndex = IdList.indexOf(entityId);
				HanreiC.rotateAngleY = (Float) AngleYList.get(IdIndex);
				AY = (Float) YawOffsetList.get(IdIndex);
			} catch (Exception var14) {
				IdList.add(entityId);
				AngleYList.add(HanreiC.rotateAngleY);
				//	YawOffsetList.add(entityliving.renderYawOffset);
				YawOffsetList.add(renderYawOffset);
				IdIndex = IdList.indexOf(entityId);
				AY = renderYawOffset;//renderYawOffset;
			}			float r1 = (renderYawOffset) / 180F * (float) Math.PI;			float move = r1 - AY / 180F * (float) Math.PI;			HanreiC.rotateAngleY -= move * 0.45F;
			while (HanreiC.rotateAngleY > (float) Math.PI)
				HanreiC.rotateAngleY -= 2f * (float) Math.PI;
			while (HanreiC.rotateAngleY < -(float) Math.PI)
				HanreiC.rotateAngleY += 2f * (float) Math.PI;
			if (HanreiC.rotateAngleY != 0F) {
				//		if(Math.abs(HanreiC.rotateAngleY/200F)>0.01F)
				//			HanreiC.rotateAngleY-=Math.copySign(0.01F,HanreiC.rotateAngleY);
				//		else
				//			HanreiC.rotateAngleY-=HanreiC.rotateAngleY/200F;
				HanreiC.rotateAngleY *= 0.99f;
			}
			Hanrei4.rotateAngleY = Hanrei5.rotateAngleY = HanreiC.rotateAngleY;
			AngleYList.set(IdIndex, HanreiC.rotateAngleY);
			YawOffsetList.set(IdIndex, renderYawOffset);
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entity != null); else return;
		int entityId = ((Entity)entity).getEntityId();
		shiftArray(HanreiC.rotationPointX, HanreiC.rotationPointY, HanreiC.rotationPointZ);
		HeadMount.setRotationPoint(0.0F, 1.0F, 0.0F);		Hanrei4.rotationPointX = pastX[4];
		Hanrei4.rotationPointY = pastY[4] + 1.0F;
		Hanrei4.rotationPointZ = pastZ[4] + 2.5F;		Hanrei5.rotationPointX = pastX[9];
		Hanrei5.rotationPointY = pastY[9] + 1.5F;
		Hanrei5.rotationPointZ = pastZ[9] + 3.5F;		HanreiC.rotationPointX = x1 + Helper.cos((f2 + entityId + 0.01F * f4) * 0.11F) * 0.5F;
		HanreiC.rotationPointZ = z1 + Helper.cos((f2 + entityId + 0.01F * f4) * 0.07F) * 0.5F;
		HanreiC.rotationPointY = y1 + Helper.cos((f2 + entityId + 0.01F * f4) * 0.13F) * 0.5F;		Skirt.rotateAngleX = 0.0F;
		Skirt.rotationPointZ = 0.0F;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			Skirt.rotationPointZ -= 0.8F;
			Skirt.rotateAngleX = Helper.degToRad(-25.0F);
		}
		Skirt.rotationPointY = 4.0F;
		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	private void shiftArray(float x, float y, float z) {
		int i;
		for (i = 0; i < 9; i++) {
			pastX[9 - i] = pastX[8 - i];
			pastY[9 - i] = pastY[8 - i];
			pastZ[9 - i] = pastZ[8 - i];
		}
		pastX[0] = x;
		pastY[0] = y;
		pastZ[0] = z;
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) return;
		float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		Skirt1.setRotateAngleDeg(-118F, 113F, 42F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 42F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 42F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 42F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 42F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 42F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 42F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 42F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 42F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 42F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 42F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 42F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 42F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 42F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 42F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 42F);		float f6 = -motionY * 2.0F - 8F;
		Skirt1.rotationPointY = 2.5F + f6;
		Skirt2.rotationPointY = 2.5F + f6;
		Skirt3.rotationPointY = 2F + f6;
		Skirt4.rotationPointY = 2F + f6;
		Skirt5.rotationPointY = 2F + f6;
		Skirt6.rotationPointY = 2F + f6;
		Skirt7.rotationPointY = 2.5F + f6;
		Skirt8.rotationPointY = 2.5F + f6;
		Skirt9.rotationPointY = 2.5F + f6;
		Skirt10.rotationPointY = 2.5F + f6;
		Skirt11.rotationPointY = 2F + f6;
		Skirt12.rotationPointY = 2F + f6;
		Skirt13.rotationPointY = 2F + f6;
		Skirt14.rotationPointY = 2F + f6;
		Skirt15.rotationPointY = 2.5F + f6;
		Skirt16.rotationPointY = 2.5F + f6;		Skirt1.rotateAngleX += motionY;
		Skirt1.rotateAngleZ += motionY;
		Skirt2.rotateAngleX += motionY;
		Skirt2.rotateAngleZ += motionY;
		Skirt3.rotateAngleX += motionY;
		Skirt3.rotateAngleZ += motionY;
		Skirt4.rotateAngleX += motionY;
		Skirt4.rotateAngleZ += motionY;
		Skirt5.rotateAngleX += motionY;
		Skirt5.rotateAngleZ += motionY;
		Skirt6.rotateAngleX += motionY;
		Skirt6.rotateAngleZ += motionY;
		Skirt7.rotateAngleZ += motionY;
		Skirt8.rotateAngleZ += motionY;
		Skirt9.rotateAngleX += motionY;
		Skirt9.rotateAngleZ += motionY;
		Skirt10.rotateAngleX += motionY;
		Skirt10.rotateAngleZ += motionY;
		Skirt11.rotateAngleX += motionY;
		Skirt11.rotateAngleZ += motionY;
		Skirt12.rotateAngleX += motionY;
		Skirt12.rotateAngleZ += motionY;
		Skirt13.rotateAngleX += motionY;
		Skirt13.rotateAngleZ += motionY;
		Skirt14.rotateAngleX += motionY;
		Skirt14.rotateAngleZ += motionY;
		Skirt15.rotateAngleX += motionY;
		Skirt15.rotateAngleZ += motionY;
		Skirt16.rotateAngleX += motionY;
		Skirt16.rotateAngleZ += motionY;
	}	@Override
	public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
		bipedHead.isHidden = !b;
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
	}
}