package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;public class MultiModel_Tenshi extends ModelModchuBaseSR2 {	public ModelRenderer Skirt1;
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
	public ModelRenderer Skirt21;
	public ModelRenderer Skirt22;
	public ModelRenderer Skirt23;
	public ModelRenderer Skirt24;
	public ModelRenderer Skirt25;
	public ModelRenderer Skirt26;
	public ModelRenderer Skirt27;
	public ModelRenderer Skirt28;
	public ModelRenderer Skirt29;
	public ModelRenderer Skirt210;
	public ModelRenderer Skirt211;
	public ModelRenderer Skirt212;
	public ModelRenderer Skirt213;
	public ModelRenderer Skirt214;
	public ModelRenderer Skirt215;
	public ModelRenderer Skirt216;
	public ModelRenderer HipR;
	public ModelRenderer HipL;
	public ModelRenderer Neck;
	public ModelRenderer Ribon4;
	public ModelRenderer Ribon5;
	public ModelRenderer Ribon6;
	public ModelRenderer ColorPlate1;
	public ModelRenderer ColorPlate2;
	public ModelRenderer ColorPlate3;
	public ModelRenderer ColorPlate4;
	public ModelRenderer ColorPlate5;
	public ModelRenderer ColorPlate6;
	public ModelRenderer ColorPlate7;
	public ModelRenderer ColorPlate8;
	public ModelRenderer ColorPlate9;
	public ModelRenderer ColorPlate10;
	public ModelRenderer ColorPlate11;
	public ModelRenderer ColorPlate12;
	public ModelRenderer ColorPlate13;
	public ModelRenderer ColorPlate14;
	public ModelRenderer ColorPlate15;
	public ModelRenderer ColorPlate16;
	public ModelRenderer Hat1;
	public ModelRenderer Hat2;
	public ModelRenderer Hat3;
	public ModelRenderer Hat4;
	public ModelRenderer Hat5;
	public ModelRenderer Hat6;
	public ModelRenderer Hat7;
	public ModelRenderer Hat8;
	public ModelRenderer Hat9;
	public ModelRenderer Hat10;
	public ModelRenderer Hat11;
	public ModelRenderer Hat12;
	public ModelRenderer Hat13;
	public ModelRenderer Hat14;
	public ModelRenderer Peach1;
	public ModelRenderer Leaf1;
	public ModelRenderer Leaf2;
	public ModelRenderer Patch1;
	public ModelRenderer Patch2;
	public ModelRenderer Patch3;
	public ModelRenderer Calar1;
	public ModelRenderer Calar2;
	public ModelRenderer Line1;
	public ModelRenderer Line2;
	public ModelRenderer Line3;
	public ModelRenderer Line4;	// armor only
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
	public ModelRenderer PlateL6;	private float x1;
	private float y1;
	private float z1;		public MultiModel_Tenshi(StringBuilder hack) {		super(hack);	}	public MultiModel_Tenshi() {
		this(0.0F);
	}	public MultiModel_Tenshi(float f) {
		this(f, 0.0F);
	}	public MultiModel_Tenshi(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Tenshi(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureHeight = 64;
		textureWidth = 64;
		f1 += 8F;
		bipedHead = new ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear = new ModelRenderer(this, 24, -1);
		bipedHeadwear.addBox(-4F, 0.0F, 0.0F, 8, 5, 4, f);
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
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);		Patch3 = new ModelRenderer(this, 31, 16);
		Patch3.addPlate(-0.0F, 0F, 0F, 1, 5, 0, f);
		Patch3.setRotationPoint(-0.5F, -3.0F, -2.002F);		Calar1 = new ModelRenderer(this, 32, 8);
		Calar1.addPlate(-0.0F, -1.2F, 0F, 1, 2, 0, f);
		Calar1.setRotationPoint(0F, 0.5F, -2.001F);
		Calar1.setRotateAngleDeg(0F, 0F, 64F);		Calar2 = new ModelRenderer(this, 32, 8);
		Calar2.addPlate(-0.0F, -0.8F, 0F, 1, 2, 0, f);
		Calar2.setRotationPoint(0F, 0.5F, -2.001F);
		Calar2.setRotateAngleDeg(0F, 0F, 116F);		HipR = new ModelRenderer(this, 57, 28);
		HipR.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipR.setRotationPoint(0.6F, -0.1F, 2.0F);
		HipR.setRotateAngleDeg(-150F, 0F, 0F);		HipL = new ModelRenderer(this, 57, 24);
		HipL.mirror = true;
		HipL.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipL.setRotationPoint(-0.6F, -0.1F, 2.0F);
		HipL.setRotateAngleDeg(-150F, 0F, 0F);		Patch1 = new ModelRenderer(this, 22, 18);
		Patch1.addBox(-1.999F, 2.0F, -0.999F, 2, 3, 2, f);
		Patch1.setRotationPoint(1F, 1F, 0.0F);		Patch2 = new ModelRenderer(this, 22, 18);
		Patch2.addBox(-0.001F, 2.0F, -0.999F, 2, 3, 2, f);
		Patch2.setRotationPoint(-1F, 1F, 0.0F);		eyeR = new ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Skirt1 = new ModelRenderer(this, 0, 34);
		Skirt1.addPlate(-0.8F, -6F, 0F, 22, 6, 0, f);
		Skirt1.setRotationPoint(0F, -5.5F, 0F);		Skirt2 = new ModelRenderer(this, 0, 28);
		Skirt2.addPlate(-0.8F, 0F, 0F, 22, 6, 0, f);
		Skirt2.setRotationPoint(0F, -5.5F, 0F);		Skirt3 = new ModelRenderer(this, 0, 34);
		Skirt3.addPlate(0F, -6F, 0F, 22, 6, 0, f);
		Skirt3.setRotationPoint(0F, -6F, 0F);		Skirt4 = new ModelRenderer(this, 0, 28);
		Skirt4.addPlate(0F, 0F, 0F, 22, 6, 0, f);
		Skirt4.setRotationPoint(0F, -6F, 0F);		Skirt5 = new ModelRenderer(this, 0, 34);
		Skirt5.addPlate(0F, -6F, 0F, 22, 6, 0, f);
		Skirt5.setRotationPoint(0F, -6F, 0F);		Skirt6 = new ModelRenderer(this, 0, 28);
		Skirt6.addPlate(0F, 0F, 0F, 22, 6, 0, f);
		Skirt6.setRotationPoint(0F, -6F, 0F);		Skirt7 = new ModelRenderer(this, 0, 34);
		Skirt7.addPlate(-0.8F, -6F, 0F, 22, 6, 0, f);
		Skirt7.setRotationPoint(0F, -5.5F, 0F);		Skirt8 = new ModelRenderer(this, 0, 28);
		Skirt8.addPlate(-0.8F, 0F, 0F, 22, 6, 0, f);
		Skirt8.setRotationPoint(0F, -5.5F, 0F);		Skirt9 = new ModelRenderer(this, 0, 34);
		Skirt9.addPlate(-0.8F, -6F, 0F, 22, 6, 0, f);
		Skirt9.setRotationPoint(0F, -5.5F, 0F);		Skirt10 = new ModelRenderer(this, 0, 28);
		Skirt10.addPlate(-0.8F, 0F, 0F, 22, 6, 0, f);
		Skirt10.setRotationPoint(0F, -5.5F, 0F);		Skirt11 = new ModelRenderer(this, 0, 34);
		Skirt11.addPlate(0F, -6F, 0F, 22, 6, 0, f);
		Skirt11.setRotationPoint(0F, -6F, 0F);		Skirt12 = new ModelRenderer(this, 0, 28);
		Skirt12.addPlate(0F, 0F, 0F, 22, 6, 0, f);
		Skirt12.setRotationPoint(0F, -6F, 0F);		Skirt13 = new ModelRenderer(this, 0, 34);
		Skirt13.addPlate(0F, -6F, 0F, 22, 6, 0, f);
		Skirt13.setRotationPoint(0F, -6F, 0F);		Skirt14 = new ModelRenderer(this, 0, 28);
		Skirt14.addPlate(0F, 0F, 0F, 22, 6, 0, f);
		Skirt14.setRotationPoint(0F, -6F, 0F);		Skirt15 = new ModelRenderer(this, 0, 34);
		Skirt15.addPlate(-0.8F, -6F, 0F, 22, 6, 0, f);
		Skirt15.setRotationPoint(0F, -5.5F, 0F);		Skirt16 = new ModelRenderer(this, 0, 28);
		Skirt16.addPlate(-0.8F, 0F, 0F, 22, 6, 0, f);
		Skirt16.setRotationPoint(0F, -5.5F, 0F);		Skirt21 = new ModelRenderer(this, 0, 48);
		Skirt21.addPlate(-1.6F, -8F, 0F, 28, 8, 0, f);
		Skirt21.setRotationPoint(0F, -5.5F, 0F);		Skirt22 = new ModelRenderer(this, 0, 40);
		Skirt22.addPlate(-1.6F, 0F, 0F, 28, 8, 0, f);
		Skirt22.setRotationPoint(0F, -5.5F, 0F);		Skirt23 = new ModelRenderer(this, 0, 48);
		Skirt23.addPlate(0F, -8F, 0F, 28, 8, 0, f);
		Skirt23.setRotationPoint(0F, -6F, 0F);		Skirt24 = new ModelRenderer(this, 0, 40);
		Skirt24.addPlate(0F, 0F, 0F, 28, 8, 0, f);
		Skirt24.setRotationPoint(0F, -6F, 0F);		Skirt25 = new ModelRenderer(this, 0, 48);
		Skirt25.addPlate(0F, -8F, 0F, 28, 8, 0, f);
		Skirt25.setRotationPoint(0F, -6F, 0F);		Skirt26 = new ModelRenderer(this, 0, 40);
		Skirt26.addPlate(0F, 0F, 0F, 28, 8, 0, f);
		Skirt26.setRotationPoint(0F, -6F, 0F);		Skirt27 = new ModelRenderer(this, 0, 48);
		Skirt27.addPlate(-1.6F, -8F, 0F, 28, 8, 0, f);
		Skirt27.setRotationPoint(0F, -5.5F, 0F);		Skirt28 = new ModelRenderer(this, 0, 40);
		Skirt28.addPlate(-1.6F, 0F, 0F, 28, 8, 0, f);
		Skirt28.setRotationPoint(0F, -5.5F, 0F);		Skirt29 = new ModelRenderer(this, 0, 48);
		Skirt29.addPlate(-1.6F, -8F, 0F, 28, 8, 0, f);
		Skirt29.setRotationPoint(0F, -5.5F, 0F);		Skirt210 = new ModelRenderer(this, 0, 40);
		Skirt210.addPlate(-1.6F, 0F, 0F, 28, 8, 0, f);
		Skirt210.setRotationPoint(0F, -5.5F, 0F);		Skirt211 = new ModelRenderer(this, 0, 48);
		Skirt211.addPlate(0F, -8F, 0F, 28, 8, 0, f);
		Skirt211.setRotationPoint(0F, -6F, 0F);		Skirt212 = new ModelRenderer(this, 0, 40);
		Skirt212.addPlate(0F, 0F, 0F, 28, 8, 0, f);
		Skirt212.setRotationPoint(0F, -6F, 0F);		Skirt213 = new ModelRenderer(this, 0, 48);
		Skirt213.addPlate(0F, -8F, 0F, 28, 8, 0, f);
		Skirt213.setRotationPoint(0F, -6F, 0F);		Skirt214 = new ModelRenderer(this, 0, 40);
		Skirt214.addPlate(0F, 0F, 0F, 28, 8, 0, f);
		Skirt214.setRotationPoint(0F, -6F, 0F);		Skirt215 = new ModelRenderer(this, 0, 48);
		Skirt215.addPlate(-1.6F, -8F, 0F, 28, 8, 0, f);
		Skirt215.setRotationPoint(0F, -5.5F, 0F);		Skirt216 = new ModelRenderer(this, 0, 40);
		Skirt216.addPlate(-1.6F, 0F, 0F, 28, 8, 0, f);
		Skirt216.setRotationPoint(0F, -5.5F, 0F);		ColorPlate1 = new ModelRenderer(this, 0, 4);
		ColorPlate1.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate1.setRotationPoint(0F, -5.5F, 0F);		ColorPlate2 = new ModelRenderer(this, 2, 4);
		ColorPlate2.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate2.setRotationPoint(0F, -5.5F, 0F);		ColorPlate3 = new ModelRenderer(this, 4, 4);
		ColorPlate3.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate3.setRotationPoint(0F, -5.5F, 0F);		ColorPlate4 = new ModelRenderer(this, 0, 6);
		ColorPlate4.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate4.setRotationPoint(0F, -5.5F, 0F);		ColorPlate5 = new ModelRenderer(this, 2, 6);
		ColorPlate5.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate5.setRotationPoint(0F, -5.5F, 0F);		ColorPlate6 = new ModelRenderer(this, 4, 6);
		ColorPlate6.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate6.setRotationPoint(0F, -5.5F, 0F);		ColorPlate7 = new ModelRenderer(this, 6, 6);
		ColorPlate7.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate7.setRotationPoint(0F, -5.5F, 0F);		ColorPlate8 = new ModelRenderer(this, 6, 4);
		ColorPlate8.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate8.setRotationPoint(0F, -5.5F, 0F);		ColorPlate9 = new ModelRenderer(this, 0, 4);
		ColorPlate9.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate9.setRotationPoint(0F, -5.5F, 0F);		ColorPlate10 = new ModelRenderer(this, 2, 4);
		ColorPlate10.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate10.setRotationPoint(0F, -5.5F, 0F);		ColorPlate11 = new ModelRenderer(this, 4, 4);
		ColorPlate11.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate11.setRotationPoint(0F, -5.5F, 0F);		ColorPlate12 = new ModelRenderer(this, 0, 6);
		ColorPlate12.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate12.setRotationPoint(0F, -5.5F, 0F);		ColorPlate13 = new ModelRenderer(this, 2, 6);
		ColorPlate13.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate13.setRotationPoint(0F, -5.5F, 0F);		ColorPlate14 = new ModelRenderer(this, 4, 6);
		ColorPlate14.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate14.setRotationPoint(0F, -5.5F, 0F);		ColorPlate15 = new ModelRenderer(this, 6, 6);
		ColorPlate15.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate15.setRotationPoint(0F, -5.5F, 0F);		ColorPlate16 = new ModelRenderer(this, 6, 4);
		ColorPlate16.addPlate(6.3F, 2F, 0F, 1, 2, 0, f);
		ColorPlate16.setRotationPoint(0F, -5.5F, 0F);		Hat1 = new ModelRenderer(this, 0, 16);
		Hat1.addBox(-4.0F, -4.0F, 0F, 8, 8, 2, f);
		Hat1.setRotationPoint(0F, -6F, 0F);
		Hat1.setRotateAngleDeg(90F, 180F, 0F);		Hat2 = new ModelRenderer(this, 0, 16);
		Hat2.addBox(-4.0F, -4.0F, 1F, 8, 8, 2, f);
		Hat2.setRotationPoint(0F, -6F, 0F);
		Hat2.setRotateAngleDeg(90F, 180F, 0F);		Hat3 = new ModelRenderer(this, 0, 18);
		Hat3.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0, f);
		Hat3.setRotationPoint(0F, -6F, 0F);
		Hat3.setRotateAngleDeg(90F, 180F, 0F);		Hat4 = new ModelRenderer(this, 0, 18);
		Hat4.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0, f);
		Hat4.setRotationPoint(0F, -6F, 0F);
		Hat4.setRotateAngleDeg(90F, 90F, 0F);		Hat5 = new ModelRenderer(this, 0, 18);
		Hat5.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0, f);
		Hat5.setRotationPoint(0F, -6F, 0F);
		Hat5.setRotateAngleDeg(90F, 0F, 0F);		Hat6 = new ModelRenderer(this, 0, 18);
		Hat6.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0, f);
		Hat6.setRotationPoint(0F, -6F, 0F);
		Hat6.setRotateAngleDeg(90F, -90F, 0F);		Hat7 = new ModelRenderer(this, 0, 18);
		Hat7.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0, f);
		Hat7.setRotationPoint(0F, -6F, 0F);
		Hat7.setRotateAngleDeg(90F, 135F, 0F);		Hat8 = new ModelRenderer(this, 0, 18);
		Hat8.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0, f);
		Hat8.setRotationPoint(0F, -6F, 0F);
		Hat8.setRotateAngleDeg(90F, 45F, 0F);		Hat9 = new ModelRenderer(this, 0, 18);
		Hat9.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0, f);
		Hat9.setRotationPoint(0F, -6F, 0F);
		Hat9.setRotateAngleDeg(90F, -135F, 0F);		Hat10 = new ModelRenderer(this, 0, 18);
		Hat10.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0, f);
		Hat10.setRotationPoint(0F, -6F, 0F);
		Hat10.setRotateAngleDeg(90F, -45F, 0F);		Hat11 = new ModelRenderer(this, 0, 18);
		Hat11.addPlate(0.1F, 4.8F, 0F, 2, 3, 0, f);
		Hat11.setRotationPoint(0F, -6F, 0F);
		Hat11.setRotateAngleDeg(90F, 135F, 0F);		Hat12 = new ModelRenderer(this, 0, 18);
		Hat12.addPlate(0.1F, 4.8F, 0F, 2, 3, 0, f);
		Hat12.setRotationPoint(0F, -6F, 0F);
		Hat12.setRotateAngleDeg(90F, 45F, 0F);		Hat13 = new ModelRenderer(this, 0, 18);
		Hat13.addPlate(0.1F, 4.8F, 0F, 2, 3, 0, f);
		Hat13.setRotationPoint(0F, -6F, 0F);
		Hat13.setRotateAngleDeg(90F, -135F, 0F);		Hat14 = new ModelRenderer(this, 0, 18);
		Hat14.addPlate(0.1F, 4.8F, 0F, 2, 3, 0, f);
		Hat14.setRotationPoint(0F, -6F, 0F);
		Hat14.setRotateAngleDeg(90F, -45F, 0F);		Line1 = new ModelRenderer(this, 52, 10);
		Line1.addBox(-1F, -4F, -4F, 1, 8, 1, f);
		Line1.setRotationPoint(0F, -6.001F, 0F);
		Line1.setRotateAngleDeg(0F, 0F, 90F);		Line2 = new ModelRenderer(this, 52, 10);
		Line2.addBox(-1F, -4F, -4F, 1, 8, 1, f);
		Line2.setRotationPoint(0F, -6.001F, 0F);
		Line2.setRotateAngleDeg(0F, 90F, 90F);		Line3 = new ModelRenderer(this, 52, 10);
		Line3.addBox(-1F, -4F, -4F, 1, 8, 1, f);
		Line3.setRotationPoint(0F, -6.001F, 0F);
		Line3.setRotateAngleDeg(0F, 180F, 90F);		Line4 = new ModelRenderer(this, 52, 10);
		Line4.addBox(-1F, -4F, -4F, 1, 8, 1, f);
		Line4.setRotationPoint(0F, -6.001F, 0F);
		Line4.setRotateAngleDeg(0F, -90F, 90F);		Peach1 = new ModelRenderer(this, 0, 0);
		Peach1.addBox(4.0F, 1.0F, 0F, 2, 2, 2, f);
		Peach1.setRotationPoint(0F, -6.001F, 0F);
		Peach1.setRotateAngleDeg(90F, 180F, 0F);		Leaf1 = new ModelRenderer(this, 1, 6);
		Leaf1.addPlate(0.0F, 0.0F, 0F, 1, 3, 0, f);
		Leaf1.setRotationPoint(-5F, -6.5F, -1F);
		Leaf1.setRotateAngleDeg(-15F, -123F, -170F);		Leaf2 = new ModelRenderer(this, 1, 6);
		Leaf2.addPlate(0.0F, 0.0F, 0F, 1, 3, 0, f);
		Leaf2.setRotationPoint(-5F, -6.0F, -1F);
		Leaf2.setRotateAngleDeg(-25F, -146F, -130F);		Neck = new ModelRenderer(this, 16, 5);
		Neck.addBox(-1.0F, -1.0F, 1.0F, 2, 1, 2, f);
		Neck.setRotationPoint(0.0F, 0.0F, -2.0F);		Ribon4 = new ModelRenderer(this, 22, 16);
		Ribon4.addBox(-1.0F, -0.5F, -0.2F, 2, 1, 1, f);
		Ribon4.setRotationPoint(0.0F, -2.7F, -2.2F);		Ribon5 = new ModelRenderer(this, 22, 16);
		Ribon5.addBox(0.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon5.setRotationPoint(0.3F, -2.7F, -2.2F);
		Ribon5.setRotateAngleDeg(0F, 0F, 15F);		Ribon6 = new ModelRenderer(this, 22, 16);
		Ribon6.addBox(-1.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon6.setRotationPoint(-0.3F, -2.7F, -2.2F);
		Ribon6.setRotateAngleDeg(0F, 0F, -15F);		PlateR1 = new ModelRenderer(this, 45, 52);
		PlateR1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateR1.setRotationPoint(-3.0F, -3.4F + 1.0F, 0.0F);
		PlateR1.setRotateAngleDeg(-50F, 90F, 0F);		PlateR2 = new ModelRenderer(this, 44, 60);
		PlateR2.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR2.setRotationPoint(-3.0F, -3.4F - f1 + 1.0F, 2.0F);
		PlateR2.setRotateAngleDeg(60F, 0F, -40F);		PlateR3 = new ModelRenderer(this, 44, 60);
		PlateR3.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR3.setRotationPoint(-3.0F, -3.4F + 1.0F, -2.0F);
		PlateR3.setRotateAngleDeg(-60F, 0F, -40F);		PlateR4 = new ModelRenderer(this, 44, 52);
		PlateR4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateR4.setRotationPoint(-4.5F, -1.7F + 1.0F, 0.0F);
		PlateR4.setRotateAngleDeg(-50F, 90F, 0F);		PlateR5 = new ModelRenderer(this, 44, 60);
		PlateR5.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR5.setRotationPoint(-4.5F, -1.7F + 1.0F, 2.5F);
		PlateR5.setRotateAngleDeg(60F, 0F, -40F);		PlateR6 = new ModelRenderer(this, 44, 60);
		PlateR6.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR6.setRotationPoint(-4.5F, -1.7F + 1.0F, -2.5F);
		PlateR6.setRotateAngleDeg(-60F, 0F, -40F);		PlateL1 = new ModelRenderer(this, 45, 52);
		PlateL1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateL1.setRotationPoint(3.0F, -3.4F + 1.0F, 0.0F);
		PlateL1.setRotateAngleDeg(50F, 90F, 0F);		PlateL2 = new ModelRenderer(this, 44, 60);
		PlateL2.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL2.setRotationPoint(3.0F, -3.4F + 1.0F, 2.0F);
		PlateL2.setRotateAngleDeg(60F, 0F, 40F);		PlateL3 = new ModelRenderer(this, 44, 60);
		PlateL3.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL3.setRotationPoint(3.0F, -3.4F + 1.0F, -2.0F);
		PlateL3.setRotateAngleDeg(-60F, 0F, 40F);		PlateL4 = new ModelRenderer(this, 44, 52);
		PlateL4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateL4.setRotationPoint(4.5F, -1.7F + 1.0F, 0.0F);
		PlateL4.setRotateAngleDeg(50F, 90F, 0F);		PlateL5 = new ModelRenderer(this, 44, 60);
		PlateL5.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL5.setRotationPoint(4.5F, -1.7F + 1.0F, 2.5F);
		PlateL5.setRotateAngleDeg(60F, 0F, 40F);		PlateL6 = new ModelRenderer(this, 44, 60);
		PlateL6.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL6.setRotationPoint(4.5F, -1.7F + 1.0F, -2.5F);
		PlateL6.setRotateAngleDeg(-60F, 0F, 40F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);		Skirt1.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 47F);
		Skirt21.setRotateAngleDeg(-118F, 113F, 43F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 43F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 44F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 44F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 44F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 44F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 43F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 43F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 43F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 43F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 44F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 44F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 44F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 44F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 43F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 43F);
		ColorPlate1.setRotateAngleDeg(-70F, 67F, 40F);
		ColorPlate2.setRotateAngleDeg(-72F, 91F, 40F);
		ColorPlate3.setRotateAngleDeg(-74F, 114F, 40F);
		ColorPlate4.setRotateAngleDeg(-73F, 137F, 38F);
		ColorPlate5.setRotateAngleDeg(-72F, 159F, 37F);
		ColorPlate6.setRotateAngleDeg(-65F, -180F, 35F);
		ColorPlate7.setRotateAngleDeg(-68F, -159F, 38F);
		ColorPlate8.setRotateAngleDeg(-67F, -136F, 38F);
		ColorPlate9.setRotateAngleDeg(-72F, -114F, 40F);
		ColorPlate10.setRotateAngleDeg(-67F, -90F, 38F);
		ColorPlate11.setRotateAngleDeg(-77F, -69F, 42F);
		ColorPlate12.setRotateAngleDeg(-67F, -44F, 36F);
		ColorPlate13.setRotateAngleDeg(-74F, -23F, 39F);
		ColorPlate14.setRotateAngleDeg(-67F, 1F, 36F);
		ColorPlate15.setRotateAngleDeg(-68F, 22F, 38F);
		ColorPlate16.setRotateAngleDeg(-67F, 45F, 38F);		int i = ModelRenderer.RotXZY;
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
		Skirt21.setRotatePriority(i);
		Skirt22.setRotatePriority(i);
		Skirt23.setRotatePriority(i);
		Skirt24.setRotatePriority(i);
		Skirt25.setRotatePriority(i);
		Skirt26.setRotatePriority(i);
		Skirt27.setRotatePriority(i);
		Skirt28.setRotatePriority(i);
		Skirt29.setRotatePriority(i);
		Skirt210.setRotatePriority(i);
		Skirt211.setRotatePriority(i);
		Skirt212.setRotatePriority(i);
		Skirt213.setRotatePriority(i);
		Skirt214.setRotatePriority(i);
		Skirt215.setRotatePriority(i);
		Skirt216.setRotatePriority(i);
		Patch3.setRotatePriority(i);
		ColorPlate1.setRotatePriority(i);
		ColorPlate2.setRotatePriority(i);
		ColorPlate3.setRotatePriority(i);
		ColorPlate4.setRotatePriority(i);
		ColorPlate5.setRotatePriority(i);
		ColorPlate6.setRotatePriority(i);
		ColorPlate7.setRotatePriority(i);
		ColorPlate8.setRotatePriority(i);
		ColorPlate9.setRotatePriority(i);
		ColorPlate10.setRotatePriority(i);
		ColorPlate11.setRotatePriority(i);
		ColorPlate12.setRotatePriority(i);
		ColorPlate13.setRotatePriority(i);
		ColorPlate14.setRotatePriority(i);
		ColorPlate15.setRotatePriority(i);
		ColorPlate16.setRotatePriority(i);
		Patch1.setRotatePriority(i);
		Patch2.setRotatePriority(i);
		Neck.setRotatePriority(i);
		Hat1.setRotatePriority(i);
		Hat2.setRotatePriority(i);
		Hat3.setRotatePriority(i);
		Hat4.setRotatePriority(i);
		Hat5.setRotatePriority(i);
		Hat6.setRotatePriority(i);
		Hat7.setRotatePriority(i);
		Hat8.setRotatePriority(i);
		Hat9.setRotatePriority(i);
		Hat10.setRotatePriority(i);
		Hat11.setRotatePriority(i);
		Hat12.setRotatePriority(i);
		Hat13.setRotatePriority(i);
		Hat14.setRotatePriority(i);
		Line1.setRotatePriority(i);
		Line2.setRotatePriority(i);
		Line3.setRotatePriority(i);
		Line4.setRotatePriority(i);
		Peach1.setRotatePriority(i);
		Leaf1.setRotatePriority(i);
		Leaf2.setRotatePriority(i);
		Calar1.setRotatePriority(i);
		Calar2.setRotatePriority(i);
		Ribon4.setRotatePriority(i);
		Ribon5.setRotatePriority(i);
		Ribon6.setRotatePriority(i);
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
		Skirt21.setScale(0.25F, 0.25F, 1.0F);
		Skirt22.setScale(0.25F, 0.25F, 1.0F);
		Skirt23.setScale(0.25F, 0.25F, 1.0F);
		Skirt24.setScale(0.25F, 0.25F, 1.0F);
		Skirt25.setScale(0.25F, 0.25F, 1.0F);
		Skirt26.setScale(0.25F, 0.25F, 1.0F);
		Skirt27.setScale(0.25F, 0.25F, 1.0F);
		Skirt28.setScale(0.25F, 0.25F, 1.0F);
		Skirt29.setScale(0.25F, 0.25F, 1.0F);
		Skirt210.setScale(0.25F, 0.25F, 1.0F);
		Skirt211.setScale(0.25F, 0.25F, 1.0F);
		Skirt212.setScale(0.25F, 0.25F, 1.0F);
		Skirt213.setScale(0.25F, 0.25F, 1.0F);
		Skirt214.setScale(0.25F, 0.25F, 1.0F);
		Skirt215.setScale(0.25F, 0.25F, 1.0F);
		Skirt216.setScale(0.25F, 0.25F, 1.0F);
		Patch1.setScale(1.01F, 0.333F, 1.01F);
		Patch2.setScale(1.01F, 0.333F, 1.01F);
		Hat1.setScale(1.1F, 1.1F, 1.1F);
		Line1.setScale(0.6F, 1.101F, 1.101F);
		Line2.setScale(0.6F, 1.101F, 1.101F);
		Line3.setScale(0.6F, 1.101F, 1.101F);
		Line4.setScale(0.6F, 1.101F, 1.101F);
		Ribon4.setScale(0.5F, 0.5F, 0.7F);
		Ribon5.setScale(0.9F, 0.9F, 0.9F);
		Ribon6.setScale(0.9F, 0.9F, 0.9F);
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
		PlateL6.setScale(0.25F, 0.25F, 0.25F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedBody.addChild(Patch3);
		bipedBody.addChild(Calar1);
		bipedBody.addChild(Calar2);
		bipedRightLeg.addChild(HipR);
		bipedLeftLeg.addChild(HipL);
		bipedRightArm.addChild(Patch1);
		bipedLeftArm.addChild(Patch2);
		bipedHead.addChild(Hat1);
		bipedHead.addChild(Hat2);
		bipedHead.addChild(Hat3);
		bipedHead.addChild(Hat4);
		bipedHead.addChild(Hat5);
		bipedHead.addChild(Hat6);
		bipedHead.addChild(Hat7);
		bipedHead.addChild(Hat8);
		bipedHead.addChild(Hat9);
		bipedHead.addChild(Hat10);
		bipedHead.addChild(Hat11);
		bipedHead.addChild(Hat12);
		bipedHead.addChild(Hat13);
		bipedHead.addChild(Hat14);
		bipedHead.addChild(Line1);
		bipedHead.addChild(Line2);
		bipedHead.addChild(Line3);
		bipedHead.addChild(Line4);
		bipedHead.addChild(Peach1);
		bipedHead.addChild(Leaf1);
		bipedHead.addChild(Leaf2);
		bipedBody.addChild(Neck);
		bipedBody.addChild(Ribon4);
		bipedBody.addChild(Ribon5);
		bipedBody.addChild(Ribon6);
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
		Skirt.addChild(Skirt21);
		Skirt.addChild(Skirt22);
		Skirt.addChild(Skirt23);
		Skirt.addChild(Skirt24);
		Skirt.addChild(Skirt25);
		Skirt.addChild(Skirt26);
		Skirt.addChild(Skirt27);
		Skirt.addChild(Skirt28);
		Skirt.addChild(Skirt29);
		Skirt.addChild(Skirt210);
		Skirt.addChild(Skirt211);
		Skirt.addChild(Skirt212);
		Skirt.addChild(Skirt213);
		Skirt.addChild(Skirt214);
		Skirt.addChild(Skirt215);
		Skirt.addChild(Skirt216);
		Skirt.addChild(ColorPlate1);
		Skirt.addChild(ColorPlate2);
		Skirt.addChild(ColorPlate3);
		Skirt.addChild(ColorPlate4);
		Skirt.addChild(ColorPlate5);
		Skirt.addChild(ColorPlate6);
		Skirt.addChild(ColorPlate7);
		Skirt.addChild(ColorPlate8);
		Skirt.addChild(ColorPlate9);
		Skirt.addChild(ColorPlate10);
		Skirt.addChild(ColorPlate11);
		Skirt.addChild(ColorPlate12);
		Skirt.addChild(ColorPlate13);
		Skirt.addChild(ColorPlate14);
		Skirt.addChild(ColorPlate15);
		Skirt.addChild(ColorPlate16);
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
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		HeadTop.setRotationPoint(0.0F, -7.0F, 0.0F);		boolean isHelmet = false;		//TODO: figure this out, maybe create an inventory helper class or just copy the code from other classes over//		Object inventory = entityCaps.getCapsValue(caps_Inventory);
//		if (inventory instanceof IInventory) {
//			Object[] o = ((IInventory)inventory).Modchu_AS.getObjectArray(Modchu_AS.entityPlayerArmorInventory, inventory);
//			if (o != null && o[3] != null) isHelmet = true;
//		}////		if (isHelmet) {
//			Hat1.isHidden = Hat2.isHidden = Hat3.isHidden =
//					Hat4.isHidden = Hat5.isHidden = Hat6.isHidden =
//					Hat7.isHidden = Hat8.isHidden = Hat9.isHidden =
//					Hat10.isHidden = Hat11.isHidden = Hat12.isHidden =
//					Hat13.isHidden = Hat14.isHidden = Peach1.isHidden =
//					Line1.isHidden = Line2.isHidden = Line3.isHidden =
//					Line4.isHidden = Leaf1.isHidden = Leaf2.isHidden = false;
//		} else {
			Hat1.isHidden = Hat2.isHidden = Hat3.isHidden =
					Hat4.isHidden = Hat5.isHidden = Hat6.isHidden =
					Hat7.isHidden = Hat8.isHidden = Hat9.isHidden =
					Hat10.isHidden = Hat11.isHidden = Hat12.isHidden =
					Hat13.isHidden = Hat14.isHidden = Peach1.isHidden =
					Line1.isHidden = Line2.isHidden = Line3.isHidden =
					Line4.isHidden = Leaf1.isHidden = Leaf2.isHidden = true;
//		}	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Skirt.rotationPointY = 4.0F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			Skirt.rotateAngleX -= 0.8F;
		}
		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) return;
		float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		Skirt1.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 47F);
		Skirt21.setRotateAngleDeg(-118F, 113F, 43F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 43F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 44F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 44F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 44F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 44F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 43F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 43F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 43F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 43F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 44F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 44F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 44F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 44F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 43F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 43F);		float f6 = -motionY * 2.0F - 7F;
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
		Skirt16.rotationPointY = 2.5F + f6;
		Skirt21.rotationPointY = 2.5F + f6;
		Skirt22.rotationPointY = 2.5F + f6;
		Skirt23.rotationPointY = 2F + f6;
		Skirt24.rotationPointY = 2F + f6;
		Skirt25.rotationPointY = 2F + f6;
		Skirt26.rotationPointY = 2F + f6;
		Skirt27.rotationPointY = 2.5F + f6;
		Skirt28.rotationPointY = 2.5F + f6;
		Skirt29.rotationPointY = 2.5F + f6;
		Skirt210.rotationPointY = 2.5F + f6;
		Skirt211.rotationPointY = 2F + f6;
		Skirt212.rotationPointY = 2F + f6;
		Skirt213.rotationPointY = 2F + f6;
		Skirt214.rotationPointY = 2F + f6;
		Skirt215.rotationPointY = 2.5F + f6;
		Skirt216.rotationPointY = 2.5F + f6;		Skirt1.rotateAngleX += motionY;
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
		Skirt21.rotateAngleZ += motionY;
		Skirt22.rotateAngleX += motionY;
		Skirt22.rotateAngleZ += motionY;
		Skirt23.rotateAngleX += motionY;
		Skirt23.rotateAngleZ += motionY;
		Skirt24.rotateAngleX += motionY;
		Skirt24.rotateAngleZ += motionY;
		Skirt25.rotateAngleX += motionY;
		Skirt25.rotateAngleZ += motionY;
		Skirt26.rotateAngleX += motionY;
		Skirt26.rotateAngleZ += motionY;
		Skirt27.rotateAngleZ += motionY;
		Skirt28.rotateAngleZ += motionY;
		Skirt29.rotateAngleZ += motionY;
		Skirt210.rotateAngleY += motionY;
		Skirt210.rotateAngleZ += motionY;
		Skirt211.rotateAngleY += motionY;
		Skirt211.rotateAngleZ += motionY;
		Skirt212.rotateAngleY += motionY;
		Skirt212.rotateAngleZ += motionY;
		Skirt213.rotateAngleY += motionY;
		Skirt213.rotateAngleZ += motionY;
		Skirt214.rotateAngleY += motionY;
		Skirt214.rotateAngleZ += motionY;
		Skirt215.rotateAngleY += motionY;
		Skirt215.rotateAngleZ += motionY;
		Skirt216.rotateAngleZ += motionY;
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
	}
}