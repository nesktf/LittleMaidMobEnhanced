package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_Angel extends ModelModchuBaseSR2 {	public ModelRenderer Prim;
	public ModelRenderer WingLroot;
	public ModelRenderer WingL2;
	public ModelRenderer WingL3;
	public ModelRenderer WingL4;
	public ModelRenderer WingL5;
	public ModelRenderer WingL6;
	public ModelRenderer WingRroot;
	public ModelRenderer WingR2;
	public ModelRenderer WingR3;
	public ModelRenderer WingR4;
	public ModelRenderer WingR5;
	public ModelRenderer WingR6;
	public ModelRenderer Tail3;
	public ModelRenderer Tail4;
	public ModelRenderer Tail5;
	public ModelRenderer Tail6;
	public ModelRenderer Ahoge;
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
	public ModelRenderer Ribon0;
	public ModelRenderer RibonLU2;
	public ModelRenderer RibonLU3;
	public ModelRenderer RibonLU4;
	public ModelRenderer RibonRU2;
	public ModelRenderer RibonRU3;
	public ModelRenderer RibonRU4;
	public ModelRenderer RibonLD1;
	public ModelRenderer RibonLD2;
	public ModelRenderer RibonLD3;
	public ModelRenderer RibonRD1;
	public ModelRenderer RibonRD2;
	public ModelRenderer RibonRD3;
	public ModelRenderer Circle;
	public ModelRenderer Glass;	private int IdOffset;		public MultiModel_Angel(StringBuilder hack) {		super(hack);	}	public MultiModel_Angel()
	{
		this(0.0F);
	}	public MultiModel_Angel(float f)
	{
		this(f, 0.0F);
	}	public MultiModel_Angel(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}	public MultiModel_Angel(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedCloak = new ModelRenderer(this, 0, 0);
		bipedCloak.showModel = false;
		bipedEars = new ModelRenderer(this, 0, 16);
		bipedEars.showModel = false;
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
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);		eyeR = new ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Glass = new ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f);
		Glass.setRotationPoint(0.0F, -4.0F, -4.0F);		Prim = new ModelRenderer(this, 4, 0);
		Prim.addPlate(-2F, -7.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);		ChignonB = new ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -8F, 3.3F, 4, 4, 2, f - 0.5F);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);		WingLroot = new ModelRenderer(this, 0, 0);
		WingLroot.mirror=true;
		WingLroot.addBox(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingLroot.setRotationPoint(0.4F, -1.0F, 1.2F);		WingL2 = new ModelRenderer(this, 0, 0);
		WingL2.mirror=true;
		WingL2.addBox(-2.4F, 2F, -0.4F, 1, 4, 1,f);		WingL3 = new ModelRenderer(this, 4, 1);
		WingL3.mirror=true;
		WingL3.addBox(4.5F, 2.5F, 1.3F, 1, 3, 1,f);		WingL4 = new ModelRenderer(this, 4, 1);
		WingL4.mirror=true;
		WingL4.addBox(3.5F, 2F, 1.3F, 1, 3, 1,f);		WingL5 = new ModelRenderer(this, 4, 1);
		WingL5.mirror=true;
		WingL5.addBox(2.5F, 2F, 1.3F, 1, 2, 1,f);		WingL6 = new ModelRenderer(this, 4, 1);
		WingL6.mirror=true;
		WingL6.addBox(1.8F, 1.5F, 1.3F, 1, 1, 1,f);		WingRroot = new ModelRenderer(this, 0, 0);
		WingRroot.addBox(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingRroot.setRotationPoint(-0.5F, -1.0F, 1.2F);		WingR2 = new ModelRenderer(this, 0, 0);
		WingR2.addBox(1.4F, 2F, -0.4F, 1, 4, 1,f);		WingR3 = new ModelRenderer(this, 4, 1);
		WingR3.addBox(-5.5F, 2.5F, 1.3F, 1, 3, 1,f);		WingR4 = new ModelRenderer(this, 4, 1);
		WingR4.addBox(-4.5F, 2F, 1.3F, 1, 3, 1,f);		WingR5 = new ModelRenderer(this, 4, 1);
		WingR5.addBox(-3.5F, 2F, 1.3F, 1, 2, 1,f);		WingR6 = new ModelRenderer(this, 4, 1);
		WingR6.addBox(-2.8F, 1.5F, 1.3F, 1, 1, 1,f);		Tail3 = new ModelRenderer(this, 54, 19);
		Tail3.addBox(0F, 1F, 0F, 0, 8, 2,f);
		Tail3.setRotationPoint(-0.5F, -6.5F, 4.7F);		Tail4 = new ModelRenderer(this, 54, 21);
		Tail4.addBox(0F, 1F, 0F, 2, 8, 0,f);
		Tail4.setRotationPoint(-1.0F, -6.5F, 5.2F);		Tail5 = new ModelRenderer(this, 54, 19);
		Tail5.addBox(0F, 1F, 0F, 0, 8, 2,f);
		Tail5.setRotationPoint(0.5F, -6.5F, 4.7F);		Tail6 = new ModelRenderer(this, 54, 21);
		Tail6.addBox(0F, 1F, 0F, 2, 8, 0,f);
		Tail6.setRotationPoint(-1.0F, -6.5F, 6.2F);		Ahoge = new ModelRenderer(this, 0, 1);
		Ahoge.addBox(0F, 0F, 0F, 0, 3, 4,f);
		Ahoge.setRotationPoint(0F, -7F, -4F);		Skirt1 = new ModelRenderer(this, 0, 37);
		Skirt1.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt1.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt2 = new ModelRenderer(this, 0, 16);
		Skirt2.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt2.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt3 = new ModelRenderer(this, 0, 37);
		Skirt3.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt3.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt4 = new ModelRenderer(this, 0, 16);
		Skirt4.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt4.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt5 = new ModelRenderer(this, 0, 37);
		Skirt5.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt5.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt6 = new ModelRenderer(this, 0, 16);
		Skirt6.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt6.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt7 = new ModelRenderer(this, 0, 37);
		Skirt7.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt7.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt8 = new ModelRenderer(this, 0, 16);
		Skirt8.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt8.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt9 = new ModelRenderer(this, 0, 37);
		Skirt9.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt9.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt10 = new ModelRenderer(this, 0, 16);
		Skirt10.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt10.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt11 = new ModelRenderer(this, 0, 34);
		Skirt11.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt11.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt12 = new ModelRenderer(this, 0, 16);
		Skirt12.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt12.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt13 = new ModelRenderer(this, 0, 34);
		Skirt13.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt13.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt14 = new ModelRenderer(this, 0, 16);
		Skirt14.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt14.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt15 = new ModelRenderer(this, 0, 37);
		Skirt15.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt15.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt16 = new ModelRenderer(this, 0, 16);
		Skirt16.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt16.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt21 = new ModelRenderer(this, 0, 46);
		Skirt21.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt21.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt22 = new ModelRenderer(this, 0, 25);
		Skirt22.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt22.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt23 = new ModelRenderer(this, 0, 46);
		Skirt23.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt23.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt24 = new ModelRenderer(this, 0, 25);
		Skirt24.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt24.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt25 = new ModelRenderer(this, 0, 46);
		Skirt25.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt25.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt26 = new ModelRenderer(this, 0, 25);
		Skirt26.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt26.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt27 = new ModelRenderer(this, 0, 46);
		Skirt27.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt27.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt28 = new ModelRenderer(this, 0, 25);
		Skirt28.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt28.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt29 = new ModelRenderer(this, 0, 46);
		Skirt29.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt29.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt210 = new ModelRenderer(this, 0, 25);
		Skirt210.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt210.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt211 = new ModelRenderer(this, 0, 46);
		Skirt211.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt211.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt212 = new ModelRenderer(this, 0, 25);
		Skirt212.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt212.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt213 = new ModelRenderer(this, 0, 46);
		Skirt213.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt213.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt214 = new ModelRenderer(this, 0, 25);
		Skirt214.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt214.setRotationPoint(0.0F, 1.5F, 0.0F);		Skirt215 = new ModelRenderer(this, 0, 46);
		Skirt215.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt215.setRotationPoint(0.0F, 2.0F, 0.0F);		Skirt216 = new ModelRenderer(this, 0, 25);
		Skirt216.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt216.setRotationPoint(0.0F, 2.0F, 0.0F);		Ribon0 = new ModelRenderer(this, 24, 16);
		Ribon0.addBox(-1F, -1F, 0F, 2, 2, 2,f-0.3F);
		Ribon0.setRotationPoint(0F, 1.8F, 2.5F);
		Ribon0.setRotateAngleDeg(25F, 0F, 0F);		RibonLU2 = new ModelRenderer(this, 1, 58);
		RibonLU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU2.setRotationPoint(0.5F, 0.2F, 1.0F);
		RibonLU2.setRotateAngle(0.7853982F, 0F, -0.1745329F);		RibonLU3 = new ModelRenderer(this, 2, 58);
		RibonLU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU3.setRotationPoint(0.5F, 0.2F, 1.0F);
		RibonLU3.setRotateAngle(0.7853982F, 0F, 0.1745329F);		RibonLU4 = new ModelRenderer(this, 2, 58);
		RibonLU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU4.setRotationPoint(0.5F, 0.2F, 1.0F);
		RibonLU4.setRotateAngle(0.7853982F, 0F, 0.5759587F);		RibonRU2 = new ModelRenderer(this, 1, 58);
		RibonRU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU2.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU2.setRotateAngle(-2.356194F, 3.141593F, -0.1745329F);		RibonRU3 = new ModelRenderer(this, 2, 58);
		RibonRU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU3.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU3.setRotateAngle(-2.356194F, 3.141593F, 0.1745329F);		RibonRU4 = new ModelRenderer(this, 2, 58);
		RibonRU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU4.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU4.setRotateAngle(-2.356194F, 3.141593F, 0.5759587F);		RibonLD1 = new ModelRenderer(this, 1, 58);
		RibonLD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLD1.setRotationPoint(-0.5F, -0.3F, 1F);
		RibonLD1.setRotateAngleDeg(-110F, -5F, 27F);		RibonLD2 = new ModelRenderer(this, 0, 58);
		RibonLD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonLD2.setRotationPoint(-0.5F, -0.3F, 1F);
		RibonLD2.setRotateAngleDeg(-110F, -13F, 42F);		RibonLD3 = new ModelRenderer(this, -1, 58);
		RibonLD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonLD3.setRotationPoint(-0.5F,-0.3F, 1F);
		RibonLD3.setRotateAngleDeg(-110F, -21F, 54F);		RibonRD1 = new ModelRenderer(this, 3, 58);
		RibonRD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRD1.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD1.setRotateAngleDeg(20F, -175F, 27F);		RibonRD2 = new ModelRenderer(this, 0, 58);
		RibonRD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonRD2.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD2.setRotateAngleDeg(20F, -167F, 42F);		RibonRD3 = new ModelRenderer(this, -1, 58);
		RibonRD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonRD3.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD3.setRotateAngleDeg(20F, -159F, 54F);		Circle = new ModelRenderer(this, 22, 32);
		Circle.addPlate(-8F, -8F, 0F, 16, 16, 0);
		Circle.setRotationPoint(0F, -12F, 0F);
		Circle.setRotateAngleDeg(-90F, 1F, 1F);		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);		WingLroot.setRotateAngle(1.5707963F, 0.6108652F, 0F);
		WingL4.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingL5.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingRroot.setRotateAngle(1.5707963F, -0.6108652F, 0F);
		WingR4.setRotateAngle(0F, 0.2792527F, 0.4886922F);
		WingR5.setRotateAngle(0F, 0.2792527F, 0.4886922F);		float x = -0.125F;
		float y = 0.0F;
		float z = -0.05F;
		WingR3.setRotationPoint(x, y, z);
		WingR4.setRotationPoint(x, y, z);
		WingR5.setRotationPoint(x, y, z);
		WingR6.setRotationPoint(x, y, z);		x = 0.09F;
		y = 0.05F;
		z = -0.09F;
		WingL3.setRotationPoint(x, y, z);
		WingL4.setRotationPoint(x, y, z);
		WingL5.setRotationPoint(x, y, z);
		WingL6.setRotationPoint(x, y, z);		WingR2.setRotationPoint(2.85F, 2.205F, 0.1F);
		WingL2.setRotationPoint(0.2F, 0.0F, -0.1F);		WingL2.rotateAngleX = 0.0F;
		WingL2.rotateAngleY = 0.0F;
		WingL2.rotateAngleZ = -0.645F;
		WingL3.rotateAngleX = 5.3F;
		WingL3.rotateAngleY = -0.759F;
		WingL3.rotateAngleZ = -WingL3.rotateAngleY;
		WingL6.rotateAngleX = WingL5.rotateAngleX = WingL4.rotateAngleX = WingL3.rotateAngleX;
		WingL6.rotateAngleY = WingL5.rotateAngleY = WingL4.rotateAngleY = WingL3.rotateAngleY;
		WingL6.rotateAngleZ = WingL5.rotateAngleZ = WingL4.rotateAngleZ = WingL3.rotateAngleZ;		WingR2.rotateAngleX = 3.141593F;
		WingR2.rotateAngleY = 0.0F;
		WingR2.rotateAngleZ = -2.5F;
		WingR3.rotateAngleX = 5.3F;
		WingR3.rotateAngleY = 0.77F;
		WingR3.rotateAngleZ = -WingR3.rotateAngleY;
		WingR6.rotateAngleX = WingR5.rotateAngleX = WingR4.rotateAngleX = WingR3.rotateAngleX;
		WingR6.rotateAngleY = WingR5.rotateAngleY = WingR4.rotateAngleY = WingR3.rotateAngleY;
		WingR6.rotateAngleZ = WingR5.rotateAngleZ = WingR4.rotateAngleZ = WingR3.rotateAngleZ;		Skirt1.setRotateAngleDeg(-118F, 113F, 47F);
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
		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);		int i = ModelRenderer.RotXYZ;
		Prim.setRotatePriority(i);
		WingLroot.setRotatePriority(i);
		WingL2.setRotatePriority(i);
		WingRroot.setRotatePriority(i);
		WingR2.setRotatePriority(i);
		i = ModelRenderer.RotXZY;
		WingL3.setRotatePriority(i);
		WingL4.setRotatePriority(i);
		WingL5.setRotatePriority(i);
		WingL6.setRotatePriority(i);
		WingR3.setRotatePriority(i);
		WingR4.setRotatePriority(i);
		WingR5.setRotatePriority(i);
		WingR6.setRotatePriority(i);
		Circle.setRotatePriority(i);
		Glass.setRotatePriority(i);
		RibonRU2.setRotatePriority(i);
		RibonRU3.setRotatePriority(i);
		RibonRU4.setRotatePriority(i);
		RibonRD1.setRotatePriority(i);
		RibonRD2.setRotatePriority(i);
		RibonRD3.setRotatePriority(i);
		RibonLD1.setRotatePriority(i);
		RibonLD2.setRotatePriority(i);
		RibonLD3.setRotatePriority(i);
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
		Skirt216.setRotatePriority(i);		Circle.setScale(0.35F, 0.35F, 0.35F);
		Glass.setScale(0.5F, 0.5F, 1.0F);
		RibonRU2.setScale(0.8F, 0.8F, 0.8F);
		RibonRU3.setScale(0.8F, 0.8F, 0.8F);
		RibonRU4.setScale(0.8F, 0.8F, 0.8F);
		RibonRD1.setScale(0.8F, 0.8F, 0.8F);
		RibonRD2.setScale(0.8F, 0.8F, 0.8F);
		RibonRD3.setScale(0.8F, 0.8F, 0.8F);
		RibonLD1.setScale(0.8F, 0.8F, 0.8F);
		RibonLD2.setScale(0.8F, 0.8F, 0.8F);
		RibonLD3.setScale(0.8F, 0.8F, 0.8F);		Skirt1.setScale(0.25F, 0.33F, 1.0F);
		Skirt2.setScale(0.25F, 0.33F, 1.0F);
		Skirt3.setScale(0.25F, 0.33F, 1.0F);
		Skirt4.setScale(0.25F, 0.33F, 1.0F);
		Skirt5.setScale(0.25F, 0.33F, 1.0F);
		Skirt6.setScale(0.25F, 0.33F, 1.0F);
		Skirt7.setScale(0.25F, 0.33F, 1.0F);
		Skirt8.setScale(0.25F, 0.33F, 1.0F);
		Skirt9.setScale(0.25F, 0.33F, 1.0F);
		Skirt10.setScale(0.25F, 0.33F, 1.0F);
		Skirt11.setScale(0.25F, 0.33F, 1.0F);
		Skirt12.setScale(0.25F, 0.33F, 1.0F);
		Skirt13.setScale(0.25F, 0.33F, 1.0F);
		Skirt14.setScale(0.25F, 0.33F, 1.0F);
		Skirt15.setScale(0.25F, 0.33F, 1.0F);
		Skirt16.setScale(0.25F, 0.33F, 1.0F);
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
		Skirt216.setScale(0.25F, 0.25F, 1.0F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		WingLroot.addChild(WingL2);
		WingLroot.addChild(WingL3);
		WingLroot.addChild(WingL4);
		WingLroot.addChild(WingL5);
		WingLroot.addChild(WingL6);
		WingRroot.addChild(WingR2);
		WingRroot.addChild(WingR3);
		WingRroot.addChild(WingR4);
		WingRroot.addChild(WingR5);
		WingRroot.addChild(WingR6);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Glass);
		bipedHead.addChild(Prim);
		bipedHead.addChild(Tail3);
		bipedHead.addChild(Tail4);
		bipedHead.addChild(Tail5);
		bipedHead.addChild(Tail6);
		bipedHead.addChild(Ahoge);
		bipedHead.addChild(Circle);
		bipedBody.addChild(WingLroot);
		bipedBody.addChild(WingRroot);
		bipedBody.addChild(Ribon0);
		Ribon0.addChild(RibonLU2);
		Ribon0.addChild(RibonLU3);
		Ribon0.addChild(RibonLU4);
		Ribon0.addChild(RibonRU2);
		Ribon0.addChild(RibonRU3);
		Ribon0.addChild(RibonRU4);
		Ribon0.addChild(RibonLD1);
		Ribon0.addChild(RibonLD2);
		Ribon0.addChild(RibonLD3);
		Ribon0.addChild(RibonRD1);
		Ribon0.addChild(RibonRD2);
		Ribon0.addChild(RibonRD3);
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
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		HeadTop.setRotationPoint(0.0F, -7.0F, 0.0F);
		Ribon0.setRotationPoint(0F, 0.8F, 1.5F);		WingLroot.rotateAngleX=1.570796313F;
		WingRroot.rotateAngleX=1.570796313F;
		WingLroot.rotateAngleY=Helper.cos(f2 * 0.5F) * 0.22F + 0.35F;
		WingRroot.rotateAngleY=-WingLroot.rotateAngleY;		Ahoge.rotateAngleY = Helper.cos(f2 * 0.2F + Helper.cos(f2 * 0.05F + IdOffset) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX=2.9F;		Tail3.rotateAngleX=-bipedHead.rotateAngleX;
		Tail4.rotateAngleX=-bipedHead.rotateAngleX;
		Tail5.rotateAngleX=-bipedHead.rotateAngleX;
		Tail6.rotateAngleX=-bipedHead.rotateAngleX;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			WingLroot.rotateAngleX+= 0.5F;
			WingRroot.rotateAngleX+= 0.5F;
			WingLroot.rotateAngleY= -0.3F;
			WingRroot.rotateAngleY= 0.3F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			Skirt.rotateAngleX -= 0.8F;
			Skirt.rotationPointX = 0.0F;
			Skirt.rotationPointY = -1.0F;
			Skirt.rotationPointZ = 4.0F;
		} else {
			Skirt.rotateAngleX = 0.0F;
			Skirt.rotationPointY = -4.5F;
			Skirt.rotationPointZ = 0.0F;
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
		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);		float f6 = -motionY * 2.0F;
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
	public void setArmorBipedHeadShowModel(IModelCaps entityCaps, boolean b) {
		bipedHead.isHidden = !b;
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
	}
}