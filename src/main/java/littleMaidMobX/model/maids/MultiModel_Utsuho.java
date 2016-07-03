package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseSR2;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;public class MultiModel_Utsuho extends ModelModchuBaseSR2 {	public ModelRenderer Prim;
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
	public ModelRenderer SideTailL2;
	public ModelRenderer SideTailR2;
	public ModelRenderer Tail2;
	public ModelRenderer Bust1;
	public ModelRenderer Bust2;
	public ModelRenderer Bust3;
	public ModelRenderer Bust4;
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
	public ModelRenderer Circle1;
	public ModelRenderer Circle2;
	public ModelRenderer Ribon0;
	public ModelRenderer RibonLU1;
	public ModelRenderer RibonLU2;
	public ModelRenderer RibonLU3;
	public ModelRenderer RibonLU4;
	public ModelRenderer RibonRU1;
	public ModelRenderer RibonRU2;
	public ModelRenderer RibonRU3;
	public ModelRenderer RibonRU4;
	public ModelRenderer RibonLD1;
	public ModelRenderer RibonLD2;
	public ModelRenderer RibonLD3;
	public ModelRenderer RibonRD1;
	public ModelRenderer RibonRD2;
	public ModelRenderer RibonRD3;
	public ModelRenderer CS1;
	public ModelRenderer CS2;
	public ModelRenderer CS3;
	public ModelRenderer CS4;
	public ModelRenderer CS5;
	public ModelRenderer CS6;
	public ModelRenderer CS7;
	public ModelRenderer CS8;
	public ModelRenderer CS9;
	public ModelRenderer RightShoo;
	public ModelRenderer HipR;
	public ModelRenderer HipL;	private float x1;
	private float y1;
	private float z1;
	private float IdOffset;		public MultiModel_Utsuho(StringBuilder hack) {		super(hack);	}	public MultiModel_Utsuho() {
		this(0.0F);
	}	public MultiModel_Utsuho(float f) {
		this(f, 0.0F);
	}	public MultiModel_Utsuho(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Utsuho(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureHeight = 64;
		textureWidth = 64;
		f1 += 8F;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -7F, -4F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear = new ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-4F, 0.0F, 0.0F, 8, 4, 4, f);
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
		Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);		CS1 = new ModelRenderer(this, 0, 20);
		CS1.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS1.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS1.setRotateAngleDeg(0F, 30F, 0F);		CS2 = new ModelRenderer(this, 0, 20);
		CS2.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS2.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS2.setRotateAngleDeg(0F, 90F, 0F);		CS3 = new ModelRenderer(this, 0, 20);
		CS3.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS3.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS3.setRotateAngleDeg(0F, 150F, 0F);		CS4 = new ModelRenderer(this, 0, 20);
		CS4.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS4.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS4.setRotateAngleDeg(0F, -30F, 0F);		CS5 = new ModelRenderer(this, 0, 20);
		CS5.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS5.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS5.setRotateAngleDeg(0F, -90F, 0F);		CS6 = new ModelRenderer(this, 0, 20);
		CS6.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS6.setRotationPoint(0.0F, 4.0F, 0.0F);
		CS6.setRotateAngleDeg(0.0F, -150F, 0F);		CS7 = new ModelRenderer(this, 8, 20);
		CS7.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS7.setRotationPoint(0.0F, 10.0F, 0.0F);
		CS7.setRotateAngleDeg(0F, -60F, 90F);		CS8 = new ModelRenderer(this, 8, 20);
		CS8.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS8.setRotationPoint(0.0F, 10.0F, 0.0F);
		CS8.setRotateAngleDeg(0F, 0F, 90F);		CS9 = new ModelRenderer(this, 8, 20);
		CS9.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS9.setRotationPoint(0.0F, 10.0F, 0F);
		CS9.setRotateAngleDeg(0F, 60F, 90F);		RightShoo = new ModelRenderer(this, 0, 42);
		RightShoo.mirror = true;
		RightShoo.addBox(-3.5F, 0.2F, -2.5F, 4, 6, 5, f);
		RightShoo.setRotationPoint(1.5F, 3.0F, 0.0F);		HipR = new ModelRenderer(this, 57, 28);
		HipR.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipR.setRotationPoint(0.6F, -0.1F, 2.0F);
		HipR.setRotateAngleDeg(-150F, 0F, 0F);		HipL = new ModelRenderer(this, 57, 24);
		HipL.mirror = true;
		HipL.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipL.setRotationPoint(-0.6F, -0.1F, 2.0F);
		HipL.setRotateAngleDeg(-150F, 0F, 0F);		eyeR = new ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Prim = new ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -7.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);		Circle1 = new ModelRenderer(this, 25, 0);
		Circle1.addBall(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Circle1.setRotationPoint(0F, 0F, 0F);
		Circle1.setRotateAngleDeg(45F, 45F, 0F);
		x1 = 1F;
		y1 = 6F;
		z1 = 0F;		Circle2 = new ModelRenderer(this, 25, 0);
		Circle2.addBall(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Circle2.setRotationPoint(0F, 0F, 0F);
		Circle2.setRotateAngleDeg(45F, 45F, 0F);		WingLroot = new ModelRenderer(this, 0, 0);
		WingLroot.mirror = true;
		WingLroot.addBox(-0.5F, 0F, -0.5F, 1, 3, 1, f);
		WingLroot.setRotationPoint(0.4F, -1.0F, 1.2F);		WingL2 = new ModelRenderer(this, 0, 0);
		WingL2.mirror = true;
		WingL2.addBox(-2.4F, 2F, -0.4F, 1, 4, 1, f);		WingL3 = new ModelRenderer(this, 0, 0);
		WingL3.mirror = true;
		WingL3.addBox(4.5F, 2.5F, 1.3F, 1, 3, 1, f);		WingL4 = new ModelRenderer(this, 0, 0);
		WingL4.mirror = true;
		WingL4.addBox(3.5F, 2F, 1.3F, 1, 3, 1, f);		WingL5 = new ModelRenderer(this, 0, 0);
		WingL5.mirror = true;
		WingL5.addBox(2.5F, 2F, 1.3F, 1, 2, 1, f);		WingL6 = new ModelRenderer(this, 0, 0);
		WingL6.mirror = true;
		WingL6.addBox(1.8F, 1.5F, 1.3F, 1, 1, 1, f);		WingRroot = new ModelRenderer(this, 0, 0);
		WingRroot.addBox(-0.5F, 0F, -0.5F, 1, 3, 1, f);
		WingRroot.setRotationPoint(-0.5F, -1.0F, 1.2F);		WingR2 = new ModelRenderer(this, 0, 0);
		WingR2.addBox(1.4F, 2F, -0.4F, 1, 4, 1, f);		WingR3 = new ModelRenderer(this, 0, 0);
		WingR3.addBox(-5.5F, 2.5F, 1.3F, 1, 3, 1, f);		WingR4 = new ModelRenderer(this, 0, 0);
		WingR4.addBox(-4.5F, 2F, 1.3F, 1, 3, 1, f);		WingR5 = new ModelRenderer(this, 0, 0);
		WingR5.addBox(-3.5F, 2F, 1.3F, 1, 2, 1, f);		WingR6 = new ModelRenderer(this, 0, 0);
		WingR6.addBox(-2.8F, 1.5F, 1.3F, 1, 1, 1, f);		Tail = new ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -8.5F, 5.9F, 2, 2, 2, f + 0.1F);
		Tail.setRotationPoint(0.0F, 0.8F, 0.0F);		Tail2 = new ModelRenderer(this, 46, 19);
		Tail2.addBox(-1F, -6.4F, 5.9F, 2, 5, 2, f);
		Tail2.setRotationPoint(0.0F, 0.8F, 0.0F);		Bust1 = new ModelRenderer(this, 54, 17);
		Bust1.addBox(-1.5F, -1.5F, 0F, 3, 3, 1, f);
		Bust1.setRotationPoint(0F, -1.5F, -2.5F);		Bust2 = new ModelRenderer(this, 0, 0);
		Bust2.addBox(-1F, 0F, 0F, 1, 1, 1, f);
		Bust2.setRotationPoint(0F, -2.0F, -2.7F);
		Bust2.setRotateAngleDeg(-45F, 90F, 79F);		Bust3 = new ModelRenderer(this, 0, 0);
		Bust3.addBox(0F, 0F, 0F, 1, 1, 1, f);
		Bust3.setRotationPoint(0F, -2.0F, -2.7F);
		Bust3.setRotateAngleDeg(-45F, 90F, 90F);		Bust4 = new ModelRenderer(this, 0, 0);
		Bust4.addBox(0F, 0F, 0F, 1, 1, 1, f);
		Bust4.setRotationPoint(0F, -1.0F, -2.7F);
		Bust4.setRotateAngleDeg(-45F, 90F, 101F);		Ahoge = new ModelRenderer(this, 0, 1);
		Ahoge.addBox(0F, 0F, 0F, 0, 3, 4, f);
		Ahoge.setRotationPoint(0F, -7F, -4F);		Skirt1 = new ModelRenderer(this, -2, 32);
		Skirt1.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt1.setRotationPoint(2.4F, -3F, -0.6F);		Skirt2 = new ModelRenderer(this, -2, 32);
		Skirt2.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt2.setRotationPoint(2F, -3F, -1.2F);		Skirt3 = new ModelRenderer(this, -6, 32);
		Skirt3.addBox(0F, 0F, 0F, 16, 4, 4, f);
		Skirt3.setRotationPoint(0F, -4F, 0F);		Skirt4 = new ModelRenderer(this, -6, 32);
		Skirt4.addBox(0F, 0F, 0F, 16, 4, 4, f);
		Skirt4.setRotationPoint(0F, -4F, 0F);		Skirt5 = new ModelRenderer(this, -2, 32);
		Skirt5.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt5.setRotationPoint(-2F, -3F, -1.2F);		Skirt6 = new ModelRenderer(this, -2, 32);
		Skirt6.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt6.setRotationPoint(-2.4F, -3F, -0.6F);		Skirt7 = new ModelRenderer(this, -2, 32);
		Skirt7.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt7.setRotationPoint(-2.4F, -3F, 0.6F);		Skirt8 = new ModelRenderer(this, -2, 32);
		Skirt8.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt8.setRotationPoint(-2F, -3F, 1.2F);		Skirt9 = new ModelRenderer(this, -6, 32);
		Skirt9.addBox(0F, 0F, 0F, 16, 4, 4, f);
		Skirt9.setRotationPoint(0F, -4F, 0F);		Skirt10 = new ModelRenderer(this, -6, 32);
		Skirt10.addBox(0F, 0F, 0F, 16, 4, 4, f);
		Skirt10.setRotationPoint(0F, -4F, 0F);		Skirt11 = new ModelRenderer(this, -2, 32);
		Skirt11.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt11.setRotationPoint(2F, -3F, 1.2F);		Skirt12 = new ModelRenderer(this, -2, 32);
		Skirt12.addBox(0F, 0F, 0F, 12, 4, 4, f);
		Skirt12.setRotationPoint(2.4F, -3F, 0.6F);		Ribon0 = new ModelRenderer(this, 0, 16);
		Ribon0.addBox(-1F, -1F, 0F, 2, 2, 2);
		Ribon0.setRotationPoint(0F, -7.2F, 4F);
		Ribon0.setRotateAngleDeg(10F, 0F, 0F);		RibonLU1 = new ModelRenderer(this, 1, 40);
		RibonLU1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU1.setRotationPoint(0.5F, 0.2F, 1F);
		RibonLU1.setRotateAngle(0.7853982F, 0F, -0.4886922F);		RibonLU2 = new ModelRenderer(this, 1, 40);
		RibonLU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU2.setRotationPoint(0.5F, -7F, 5F);
		RibonLU2.setRotateAngle(0.7853982F, 0F, -0.1745329F);		RibonLU3 = new ModelRenderer(this, 2, 40);
		RibonLU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU3.setRotationPoint(0.5F, -7F, 5F);
		RibonLU3.setRotateAngle(0.7853982F, 0F, 0.1745329F);		RibonLU4 = new ModelRenderer(this, 2, 40);
		RibonLU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU4.setRotationPoint(0.0F, -7.5F, 4.5F);
		RibonLU4.setRotateAngle(0.7853982F, 0F, 0.5759587F);		RibonRU1 = new ModelRenderer(this, 1, 40);
		RibonRU1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU1.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU1.setRotateAngle(-2.356194F, 3.141593F, -0.4886922F);		RibonRU2 = new ModelRenderer(this, 1, 40);
		RibonRU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU2.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU2.setRotateAngle(-2.356194F, 3.141593F, -0.1745329F);		RibonRU3 = new ModelRenderer(this, 2, 40);
		RibonRU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU3.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU3.setRotateAngle(-2.356194F, 3.141593F, 0.1745329F);		RibonRU4 = new ModelRenderer(this, 2, 40);
		RibonRU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU4.setRotationPoint(-0.5F, 0.2F, 1F);
		RibonRU4.setRotateAngle(-2.356194F, 3.141593F, 0.5759587F);		RibonLD1 = new ModelRenderer(this, 1, 40);
		RibonLD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLD1.setRotationPoint(-0.5F, -0.3F, 1F);
		RibonLD1.setRotateAngleDeg(-110F, -5F, 27F);		RibonLD2 = new ModelRenderer(this, 0, 40);
		RibonLD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonLD2.setRotationPoint(-0.5F, -0.3F, 1F);
		RibonLD2.setRotateAngleDeg(-110F, -13F, 42F);		RibonLD3 = new ModelRenderer(this, -1, 40);
		RibonLD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonLD3.setRotationPoint(-0.5F, -0.3F, 1F);
		RibonLD3.setRotateAngleDeg(-110F, -21F, 54F);		RibonRD1 = new ModelRenderer(this, 3, 40);
		RibonRD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRD1.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD1.setRotateAngleDeg(20F, -175F, 27F);		RibonRD2 = new ModelRenderer(this, 0, 40);
		RibonRD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonRD2.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD2.setRotateAngleDeg(20F, -167F, 42F);		RibonRD3 = new ModelRenderer(this, -1, 40);
		RibonRD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonRD3.setRotationPoint(0.5F, -0.3F, 1F);
		RibonRD3.setRotateAngleDeg(20F, -159F, 54F);
		mainFrame = new ModelRenderer(this, 0, 0);
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
		WingR6.rotateAngleZ = WingR5.rotateAngleZ = WingR4.rotateAngleZ = WingR3.rotateAngleZ;		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);		int i = ModelRenderer.RotXYZ;
		Circle1.setRotatePriority(i);
		Circle2.setRotatePriority(i);
		Prim.setRotatePriority(i);
		Tail2.setRotatePriority(i);
		Bust1.setRotatePriority(i);
		WingLroot.setRotatePriority(i);
		WingL2.setRotatePriority(i);
		WingRroot.setRotatePriority(i);
		WingR2.setRotatePriority(i);
		RightShoo.setRotatePriority(i);
		CS1.setRotatePriority(i);
		CS2.setRotatePriority(i);
		CS3.setRotatePriority(i);
		CS4.setRotatePriority(i);
		CS5.setRotatePriority(i);
		CS6.setRotatePriority(i);
		i = ModelRenderer.RotXZY;
		CS7.setRotatePriority(i);
		CS8.setRotatePriority(i);
		CS9.setRotatePriority(i);
		WingL3.setRotatePriority(i);
		WingL4.setRotatePriority(i);
		WingL5.setRotatePriority(i);
		WingL6.setRotatePriority(i);
		WingR3.setRotatePriority(i);
		WingR4.setRotatePriority(i);
		WingR5.setRotatePriority(i);
		WingR6.setRotatePriority(i);
		Bust2.setRotatePriority(i);
		Bust3.setRotatePriority(i);
		Bust4.setRotatePriority(i);
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
		Skirt12.setRotatePriority(i);
		RibonLU1.setRotatePriority(i);
		RibonLU2.setRotatePriority(i);
		RibonLU3.setRotatePriority(i);
		RibonLU4.setRotatePriority(i);
		RibonLD1.setRotatePriority(i);
		RibonLD2.setRotatePriority(i);
		RibonLD3.setRotatePriority(i);
		RibonRU1.setRotatePriority(i);
		RibonRU2.setRotatePriority(i);
		RibonRU3.setRotatePriority(i);
		RibonRU4.setRotatePriority(i);
		RibonRD1.setRotatePriority(i);
		RibonRD2.setRotatePriority(i);
		RibonRD3.setRotatePriority(i);
		HipR.setRotatePriority(i);
		HipL.setRotatePriority(i);		Skirt1.setScale(0.5F, 0.5F, 0.5F);
		Skirt2.setScale(0.5F, 0.5F, 0.5F);
		Skirt3.setScale(0.5F, 0.5F, 0.5F);
		Skirt4.setScale(0.5F, 0.5F, 0.5F);
		Skirt5.setScale(0.5F, 0.5F, 0.5F);
		Skirt6.setScale(0.5F, 0.5F, 0.5F);
		Skirt7.setScale(0.5F, 0.5F, 0.5F);
		Skirt8.setScale(0.5F, 0.5F, 0.5F);
		Skirt9.setScale(0.5F, 0.5F, 0.5F);
		Skirt10.setScale(0.5F, 0.5F, 0.5F);
		Skirt11.setScale(0.5F, 0.5F, 0.5F);
		Skirt12.setScale(0.5F, 0.5F, 0.5F);
		CS7.setScale(0.5F, 0.5F, 0.5F);
		CS8.setScale(0.5F, 0.5F, 0.5F);
		CS9.setScale(0.5F, 0.5F, 0.5F);
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
		bipedLeftArm.addChild(CS1);
		bipedLeftArm.addChild(CS2);
		bipedLeftArm.addChild(CS3);
		bipedLeftArm.addChild(CS4);
		bipedLeftArm.addChild(CS5);
		bipedLeftArm.addChild(CS6);
		bipedLeftArm.addChild(CS7);
		bipedLeftArm.addChild(CS8);
		bipedLeftArm.addChild(CS9);
		bipedRightLeg.addChild(RightShoo);
		bipedRightLeg.addChild(HipR);
		bipedLeftLeg.addChild(HipL);
		bipedHead.addChild(Prim);
		bipedLeftLeg.addChild(Circle1);
		bipedLeftLeg.addChild(Circle2);
		bipedBody.addChild(WingLroot);
		WingLroot.addChild(WingL2);
		WingLroot.addChild(WingL3);
		WingLroot.addChild(WingL4);
		WingLroot.addChild(WingL5);
		WingLroot.addChild(WingL6);
		bipedBody.addChild(WingRroot);
		WingRroot.addChild(WingR2);
		WingRroot.addChild(WingR3);
		WingRroot.addChild(WingR4);
		WingRroot.addChild(WingR5);
		WingRroot.addChild(WingR6);
		bipedHead.addChild(Tail2);
		bipedBody.addChild(Bust1);
		bipedBody.addChild(Bust2);
		bipedBody.addChild(Bust3);
		bipedBody.addChild(Bust4);
		bipedHead.addChild(Ahoge);
		bipedHead.addChild(Ribon0);
		Ribon0.addChild(RibonLU1);
		bipedHead.addChild(RibonLU2);
		bipedHead.addChild(RibonLU3);
		bipedHead.addChild(RibonLU4);
		Ribon0.addChild(RibonRU1);
		Ribon0.addChild(RibonRU2);
		Ribon0.addChild(RibonRU3);
		Ribon0.addChild(RibonRU4);
		bipedHead.addChild(RibonLD1);
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
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		HeadTop.setRotationPoint(0.0F, -7.0F, 0.0F);
		WingLroot.rotateAngleX = 1.570796313F;
		WingRroot.rotateAngleX = 1.570796313F;
		WingLroot.rotateAngleY = Helper.cos(f2 * 0.5F) * 0.22F + 0.35F;
		WingRroot.rotateAngleY = -WingLroot.rotateAngleY;
		Ahoge.rotateAngleY = Helper.cos(f2 * 0.2F + Helper.cos(f2 * 0.05F + IdOffset) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX = 2.9F;
		Circle1.rotationPointX = x1 + Helper.cos(f2 * 0.3F + IdOffset) * 3F;
		Circle1.rotationPointZ = z1 + Helper.cos(f2 * 0.3F + ((float) Math.PI / 2F) + IdOffset) * 3F;
		Circle1.rotationPointY = y1 + Helper.cos(f2 * 0.37F + IdOffset) * 1.5F;
		Circle2.rotationPointX = x1 + Helper.cos(f2 * 0.3F + 2.5F + IdOffset) * 3F;
		Circle2.rotationPointZ = z1 + Helper.cos(f2 * 0.3F + 2.5F + ((float) Math.PI / 2F) + IdOffset) * 3F;
		Circle2.rotationPointY = y1 - Helper.cos(f2 * 0.37F + 2.5F + IdOffset) * 1.5F;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			WingLroot.rotateAngleX += 0.5F;
			WingRroot.rotateAngleX += 0.5F;
			WingLroot.rotateAngleY = -0.3F;
			WingRroot.rotateAngleY = 0.3F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			Skirt.rotateAngleX -= 0.8F;
		}
		Skirt.rotationPointY = 4.0F;
		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) return;
		float motionY = (float) ModelCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);		float f6 = -motionY;
		Skirt1.rotationPointY = -3F + f6;
		Skirt2.rotationPointY = -3F + f6;
		Skirt3.rotationPointY = -4F + f6;
		Skirt4.rotationPointY = -4F + f6;
		Skirt5.rotationPointY = -3F + f6;
		Skirt6.rotationPointY = -3F + f6;
		Skirt7.rotationPointY = -3F + f6;
		Skirt8.rotationPointY = -3F + f6;
		Skirt9.rotationPointY = -4F + f6;
		Skirt10.rotationPointY = -4F + f6;
		Skirt11.rotationPointY = -3F + f6;
		Skirt12.rotationPointY = -3F + f6;		Skirt1.rotateAngleX += motionY;
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
	}	@Override
	public void setArmorSkirtShowModel(IModelCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
	}
}