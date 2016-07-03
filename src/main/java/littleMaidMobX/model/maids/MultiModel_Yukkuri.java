package littleMaidMobX.model.maids;import littleMaidMobX.model.caps.IModelCaps;import littleMaidMobX.model.caps.ModelCapsHelper;import littleMaidMobX.model.modchu.ModelModchuBaseOkota;import littleMaidMobX.render.model.ModelRenderer;import littleMaidMobX.util.helper.Helper;
public class MultiModel_Yukkuri extends ModelModchuBaseOkota {	public ModelRenderer Item1;
	public ModelRenderer Item2;
	public ModelRenderer HeadR;
	public ModelRenderer HeadL;
	public ModelRenderer HeadU;
	public ModelRenderer HatFL;
	public ModelRenderer HatBL;
	public ModelRenderer HatFR;
	public ModelRenderer HatBR;
	public ModelRenderer Bangs1;
	public ModelRenderer Bangs2;
	public ModelRenderer Bangs3;
	public ModelRenderer Bangs4;
	public ModelRenderer MariribonL;
	public ModelRenderer MariribonR;
	public ModelRenderer MariribonC;
	public ModelRenderer Hat1;
	public ModelRenderer Hat2;
	public ModelRenderer Hat3;
	public ModelRenderer Hat4;
	public ModelRenderer Hat5;
	public ModelRenderer Hat6;
	public ModelRenderer Hat7;
	public ModelRenderer Hat8;
	public ModelRenderer Hat9;
	public ModelRenderer THat1;
	public ModelRenderer THat2;
	public ModelRenderer RSidehair1;
	public ModelRenderer RSidehair2;
	public ModelRenderer RSidehair3;
	public ModelRenderer RSidehair4;
	public ModelRenderer LSidehair1;
	public ModelRenderer LSidehair2;
	public ModelRenderer LSidehair3;
	public ModelRenderer LSidehair4;
	public ModelRenderer Backhair1;
	public ModelRenderer Backhair2;
	public ModelRenderer Backhair3;
	public ModelRenderer Backhair4;
	public ModelRenderer Backhair5;
	public ModelRenderer Lribon;
	public ModelRenderer Rribon;
	public ModelRenderer HaneL1;
	public ModelRenderer HaneL2;
	public ModelRenderer HaneR1;
	public ModelRenderer HaneR2;		public MultiModel_Yukkuri(StringBuilder hack) {		super(hack);	}	public MultiModel_Yukkuri() {
		this(0.0F);
	}	public MultiModel_Yukkuri(float f) {
		this(f, 0.0F);
	}	public MultiModel_Yukkuri(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Yukkuri(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-5F, -8F, -5F, 10, 10, 10, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail = new ModelRenderer(this, 0, 0);
		Tail.addBox(-5F, -8F, -4F, 10, 10, 10, f - 0.5F);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadR = new ModelRenderer(this, 0, 0);
		HeadR.addBox(-6F, -8F, -5F, 10, 10, 10, f - 0.5F);
		HeadR.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadL = new ModelRenderer(this, 0, 0);
		HeadL.addBox(-4F, -8F, -5F, 10, 10, 10, f - 0.5F);
		HeadL.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadU = new ModelRenderer(this, 0, 0);
		HeadU.addBox(-5F, -9F, -5F, 10, 10, 10, f - 0.5F);
		HeadU.setRotationPoint(0.0F, 0.0F, 0.0F);
		//maegami
		Bangs1 = new ModelRenderer(this, 40, 0);
		Bangs1.addBox(-5.3F, -7.5F, -5.5F, 3, 4, 1, f);
		Bangs1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bangs2 = new ModelRenderer(this, 40, 0);
		Bangs2.addBox(-2.7F, -7.5F, -5.5F, 3, 4, 1, f);
		Bangs2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bangs3 = new ModelRenderer(this, 40, 0);
		Bangs3.addBox(-0.1F, -7.5F, -5.5F, 3, 4, 1, f);
		Bangs3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bangs4 = new ModelRenderer(this, 40, 0);
		Bangs4.addBox(2.2F, -7.5F, -5.5F, 3, 4, 1, f);
		Bangs4.setRotationPoint(0.0F, 0.0F, 0.0F);
		//back hair
		Backhair1 = new ModelRenderer(this, 56, 0);
		Backhair1.addBox(-1F, 0F, -1F, 2, 8, 2, f);
		Backhair1.setRotationPoint(0F, 0F, 0F);
		Backhair2 = new ModelRenderer(this, 56, 0);
		Backhair2.addBox(-1F, 0F, -1F, 2, 8, 2, f);
		Backhair2.setRotationPoint(0F, 0F, 0.0F);
		Backhair3 = new ModelRenderer(this, 56, 0);
		Backhair3.addBox(-1F, 0F, -1F, 2, 8, 2, f);
		Backhair3.setRotationPoint(0F, 0F, 0.0F);
		Backhair4 = new ModelRenderer(this, 56, 0);
		Backhair4.addBox(-1F, 0F, -1F, 2, 8, 2, f);
		Backhair4.setRotationPoint(0F, 0F, 0.0F);
		Backhair5 = new ModelRenderer(this, 56, 0);
		Backhair5.addBox(-1F, 0F, -1F, 2, 8, 2, f);
		Backhair5.setRotationPoint(0F, 0F, 0.0F);		SideTailL = new ModelRenderer(this, 26, 20);
		SideTailL.mirror = true;
		SideTailL.addBox(1.0F, -13F, 1.5F, 6, 6, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModelRenderer(this, 26, 20);
		SideTailR.addBox(-8F, -13F, 1.5F, 6, 6, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new ModelRenderer(this, 26, 20);
		ChignonL.mirror = true;
		ChignonL.addBox(-1F, -6F, 5.5F, 6, 6, 2, f - 0.5F);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonR = new ModelRenderer(this, 26, 20);
		ChignonR.addBox(-6F, -6F, 5.5F, 6, 6, 2, f - 0.5F);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonB = new ModelRenderer(this, 29, 20);
		ChignonB.addBox(-2F, -9.5F, 4F, 3, 5, 2, f + 0.1F);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		//anko
		bipedBody = new ModelRenderer(this, 10, 24);
		bipedBody.addBox(-1F, -1F, -1F, 2, 2, 2, f + 1.0F);
		bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
		Skirt = new ModelRenderer(this, 2, 20);
		//ago
		Skirt.addBox(-4F, -1F, -4F, 8, 4, 8, f);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		//momiage
		bipedRightArm = new ModelRenderer(this, 48, 10);
		bipedRightArm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, f - 0.2F);
		bipedRightArm.setRotationPoint(-2F, -1.5F, -1F);
		bipedLeftArm = new ModelRenderer(this, 56, 10);
		bipedLeftArm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, f - 0.2F);
		bipedLeftArm.setRotationPoint(0.0F, -1.5F, -1F);
		//
		bipedRightLeg = new ModelRenderer(this);
		bipedLeftLeg = new ModelRenderer(this);
		bipedRightLeg.isHidden = true;
		bipedLeftLeg.isHidden = true;		eyeL = new ModelRenderer(this, 5, 20);
		eyeL.addPlate(0.0F, -6F, -5.001F, 5, 8, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR = new ModelRenderer(this, 0, 20);
		eyeR.addPlate(-5.0F, -6F, -5.001F, 5, 8, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		//temoti
		Item1 = new ModelRenderer(this, 40, 18);
		Item1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, f);
		Item1.setRotationPoint(0.0F, -4.5F, 0.4F);
		Item1.rotateAngleX = -0.175F;
		Item1.rotateAngleY = -0.524F;
		Item1.rotateAngleZ = 0.175F;
		Item2 = new ModelRenderer(this, 40, 15);
		Item2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, f);
		Item2.setRotationPoint(0.0F, -1.5F, 0.4F);
		Item2.rotateAngleX = -0.175F;
		Item2.rotateAngleY = -0.524F;
		Item2.rotateAngleZ = 0.175F;
		//marisa hat_tuba
		HatFL = new ModelRenderer(this, 30, 0);
		HatFL.addPlate(0F, 1F, -6.5F, 10, 10, 0, f);
		HatFL.setRotationPoint(0.0F, 0F, 0F);
		HatFL.rotateAngleX = -1.745F;
		HatBL = new ModelRenderer(this, 30, 0);
		HatBL.addPlate(0.0F, -1F, 6.5F, 10, 10, 0, f);
		HatBL.setRotationPoint(0.0F, 0F, 0F);
		HatBL.rotateAngleX = 1.396F;
		HatFR = new ModelRenderer(this, 30, 0);
		HatFR.mirror = true;
		HatFR.addPlate(-10F, 1F, -6.5F, 10, 10, 0, f);
		HatFR.setRotationPoint(0F, 0F, 0F);
		HatFR.rotateAngleX = -1.745F;
		HatBR = new ModelRenderer(this, 30, 0);
		HatBR.mirror = true;
		HatBR.addPlate(-10F, -1F, 6.5F, 10, 10, 0, f);
		HatBR.setRotationPoint(0F, 0.0F, 0F);
		HatBR.rotateAngleX = 1.396F;
		//marisa hat ribon
		MariribonL = new ModelRenderer(this, 50, 22);
		MariribonL.mirror = true;
		MariribonL.addBox(0.0F, -11F, -6.6F, 5, 4, 2, f);
		MariribonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		MariribonR = new ModelRenderer(this, 50, 22);
		MariribonR.addBox(-5F, -11F, -6.6F, 5, 4, 2, f);
		MariribonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		MariribonC = new ModelRenderer(this, 52, 22);
		MariribonC.addBox(-1.5F, -10.5F, -5.7F, 3, 4, 2, f);
		MariribonC.setRotationPoint(0.0F, 0.0F, 0.0F);
		//marisa hat top parts
		Hat1 = new ModelRenderer(this, 36, 22);
		Hat1.addBox(-2.0F, -2.0F, 0F, 4, 4, 6, f);
		Hat1.setRotationPoint(0F, 0F, 0.0F);
		Hat2 = new ModelRenderer(this, 36, 22);
		Hat2.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
		Hat2.setRotationPoint(0F, 0F, 0.0F);
		Hat3 = new ModelRenderer(this, 36, 22);
		Hat3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
		Hat3.setRotationPoint(0F, 0F, 0.0F);
		Hat4 = new ModelRenderer(this, 36, 22);
		Hat4.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
		Hat4.setRotationPoint(0F, 0F, 0.0F);
		Hat5 = new ModelRenderer(this, 36, 22);
		Hat5.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
		Hat5.setRotationPoint(0F, 0F, 0.0F);
		Hat6 = new ModelRenderer(this, 36, 22);
		Hat6.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
		Hat6.setRotationPoint(0F, 0F, 0.0F);
		Hat7 = new ModelRenderer(this, 36, 22);
		Hat7.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
		Hat7.setRotationPoint(0F, 0F, 0.0F);
		Hat8 = new ModelRenderer(this, 36, 22);
		Hat8.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
		Hat8.setRotationPoint(0F, 0F, 0.0F);		Hat9 = new ModelRenderer(this, 56, 28);
		Hat9.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, f + 0.8F);
		Hat9.setRotationPoint(0F, 0F, 0.0F);
		//tengu hat
		THat1 = new ModelRenderer(this, 10, 20);
		THat1.addBox(0.0F, -2F, 0.0F, 2, 2, 2, f + 0.6F);
		THat1.setRotationPoint(0F, 0F, 0.0F);
		THat2 = new ModelRenderer(this, 10, 20);
		THat2.addBox(0.0F, -2F, 0.0F, 2, 2, 2, f);
		THat2.setRotationPoint(0F, 0F, 0.0F);
		//side hair
		RSidehair1 = new ModelRenderer(this, 48, 0);
		RSidehair1.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
		RSidehair1.setRotationPoint(0F, 0F, 0F);
		RSidehair2 = new ModelRenderer(this, 48, 0);
		RSidehair2.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
		RSidehair2.setRotationPoint(0F, 0F, 0F);
		RSidehair3 = new ModelRenderer(this, 48, 0);
		RSidehair3.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
		RSidehair3.setRotationPoint(0F, 0F, 0F);
		RSidehair4 = new ModelRenderer(this, 48, 0);
		RSidehair4.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
		RSidehair4.setRotationPoint(0F, 0F, 0F);
		LSidehair1 = new ModelRenderer(this, 48, 0);
		LSidehair1.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
		LSidehair1.setRotationPoint(0F, 0F, 0F);
		LSidehair2 = new ModelRenderer(this, 48, 0);
		LSidehair2.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
		LSidehair2.setRotationPoint(0F, 0F, 0F);
		LSidehair3 = new ModelRenderer(this, 48, 0);
		LSidehair3.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
		LSidehair3.setRotationPoint(0F, 0F, 0F);
		LSidehair4 = new ModelRenderer(this, 48, 0);
		LSidehair4.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
		LSidehair4.setRotationPoint(0F, 0F, 0F);
		//head side ribon
		Rribon = new ModelRenderer(this, 40, 10);
		Rribon.addPlate(-8F, -5F, 0F, 8, 5, 0, f);
		Rribon.setRotationPoint(0.0F, 0.0F, 0.0F);
		Lribon = new ModelRenderer(this, 40, 5);
		Lribon.addPlate(0F, -5F, 0F, 8, 5, 0, f);
		Lribon.setRotationPoint(0.0F, 0.0F, 0.0F);
		//hane
		HaneL1 = new ModelRenderer(this, 0, 4);
		HaneL1.addPlate(0F, -3F, 0F, 10, 6, 0, f);
		HaneL1.setRotationPoint(2F, -3F, 6F);		HaneL2 = new ModelRenderer(this, 0, 0);
		HaneL2.addPlate(0F, -1.5F, 0F, 8, 4, 0, f);
		HaneL2.setRotationPoint(0.0F, 0.0F, 0.0F);		HaneR1 = new ModelRenderer(this, 0, 4);
		HaneR1.mirror = true;
		HaneR1.addPlate(-10F, -3F, 0F, 10, 6, 0, f);
		HaneR1.setRotationPoint(-2F, -3F, 6F);		HaneR2 = new ModelRenderer(this, 0, 0);
		HaneR2.mirror = true;
		HaneR2.addPlate(-10F, -1.5F, 0F, 8, 4, 0, f);
		HaneR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		bipedRightArm.clearChildModels();
		bipedLeftArm.clearChildModels();
		bipedRightLeg.clearChildModels();
		bipedLeftLeg.clearChildModels();
		Skirt.clearChildModels();
		ChignonR.clearChildModels();
		ChignonL.clearChildModels();
		ChignonB.clearChildModels();
		Tail.clearChildModels();
		SideTailR.clearChildModels();
		SideTailL.clearChildModels();
		HeadMount.clearChildModels();
		HeadTop.clearChildModels();
		bipedHead.clearChildModels();
		bipedHead.addChild(ChignonR);
		bipedHead.addChild(ChignonL);
		bipedHead.addChild(ChignonB);
		bipedHead.addChild(Tail);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(SideTailL);
		bipedBody.clearChildModels();
		bipedHead.addChild(bipedRightArm);
		bipedHead.addChild(bipedLeftArm);
		bipedHead.addChild(HeadMount);
		bipedHead.addChild(HeadTop);
		bipedRightArm.addChild(Arms[0]);
		bipedLeftArm.addChild(Arms[1]);
		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		((ModelRenderer) mainFrame).clearChildModels();
		bipedHead.addChild(bipedBody);
		bipedHead.addChild(Skirt);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(HeadR);
		bipedHead.addChild(HeadL);
		bipedHead.addChild(HeadU);
		bipedHead.addChild(Bangs1);
		bipedHead.addChild(Bangs2);
		bipedHead.addChild(Bangs3);
		bipedHead.addChild(Bangs4);
		bipedHead.addChild(Backhair1);
		bipedHead.addChild(Backhair2);
		bipedHead.addChild(Backhair3);
		bipedHead.addChild(Backhair4);
		bipedHead.addChild(Backhair5);
		bipedLeftArm.addChild(Item1);
		bipedLeftArm.addChild(Item2);
		bipedHead.addChild(HatFL);
		bipedHead.addChild(HatBL);
		bipedHead.addChild(HatFR);
		bipedHead.addChild(HatBR);
		bipedHead.addChild(MariribonL);
		bipedHead.addChild(MariribonR);
		bipedHead.addChild(MariribonC);
		bipedHead.addChild(Hat1);
		bipedHead.addChild(Hat2);
		bipedHead.addChild(Hat3);
		bipedHead.addChild(Hat4);
		bipedHead.addChild(Hat5);
		bipedHead.addChild(Hat6);
		bipedHead.addChild(Hat7);
		bipedHead.addChild(Hat8);
		bipedHead.addChild(Hat9);
		bipedHead.addChild(THat1);
		bipedHead.addChild(THat2);
		bipedHead.addChild(RSidehair1);
		bipedHead.addChild(RSidehair2);
		bipedHead.addChild(RSidehair3);
		bipedHead.addChild(RSidehair4);
		bipedHead.addChild(LSidehair1);
		bipedHead.addChild(LSidehair2);
		bipedHead.addChild(LSidehair3);
		bipedHead.addChild(LSidehair4);
		bipedHead.addChild(Rribon);
		bipedHead.addChild(Lribon);
		bipedHead.addChild(HaneL1);
		bipedHead.addChild(HaneL2);
		bipedHead.addChild(HaneR1);
		bipedHead.addChild(HaneR2);
		mainFrame.addChild(bipedHead);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		HeadMount.setRotationPoint(0.0F, 2.5F, 0.0F);
		SideTailL.rotateAngleX = SideTailR.rotateAngleX = -0.262F;
		ChignonL.rotateAngleX = ChignonR.rotateAngleX = 0.262F;
		ChignonL.rotateAngleZ = 0.262F;
		ChignonR.rotateAngleZ = -0.262F;
		//足角度マイナスでジャンプ
		float basebipedHeadRotationPointY = 12F;
		bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? basebipedHeadRotationPointY : basebipedHeadRotationPointY - bipedRightLeg.rotateAngleX * 8F;
		bipedBody.rotationPointY = -6F;
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);		bipedRightArm.rotateAngleX = Helper.cos(f * 0.6662F + 3.141593F) * 0.5F * f1 * 0.3F;
		bipedLeftArm.rotateAngleX = Helper.cos(f * 0.6662F) * 0.5F * f1 * 0.3F;
		bipedRightArm.rotationPointX = -7.0F;
		bipedRightArm.rotationPointZ = -3.0F;
		bipedLeftArm.rotationPointX = 5.0F;
		bipedLeftArm.rotationPointZ = -3.0F;
		Item1.rotationPointX = 2.5F;
		Item2.rotationPointX = 2.5F;
		Item1.rotationPointY = 1.0F;
		Item2.rotationPointY = -2F;
		Item1.rotationPointZ = Item2.rotationPointZ = -3.5F;
		MariribonL.rotateAngleX = -0.175F;
		MariribonL.rotateAngleY = -0.175F;
		MariribonL.rotateAngleZ = 0.087F;
		MariribonR.rotateAngleX = -0.175F;
		MariribonR.rotateAngleY = 0.175F;
		MariribonR.rotateAngleZ = -0.087F;
		MariribonC.rotateAngleX = -0.175F;		Hat1.rotateAngleX = 1.134F;
		Hat1.rotateAngleY = 0.349F;
		Hat1.rotateAngleZ = 0F;
		Hat1.rotationPointX = -1.8F;
		Hat1.rotationPointY = -6.8F;
		Hat1.rotationPointZ = -2F;
		Hat2.rotateAngleX = 1.134F;
		Hat2.rotateAngleY = -0.349F;
		Hat2.rotateAngleZ = 0F;
		Hat2.rotationPointX = 1.9F;
		Hat2.rotationPointY = -6.8F;
		Hat2.rotationPointZ = -2F;
		Hat3.rotateAngleX = 1.187F;
		Hat3.rotateAngleY = 0F;
		Hat3.rotateAngleZ = 0.262F;
		Hat3.rotationPointX = -3.0F;
		Hat3.rotationPointY = -6.5F;
		Hat3.rotationPointZ = -1.1F;
		Hat4.rotateAngleX = 1.187F;
		Hat4.rotateAngleY = 0F;
		Hat4.rotateAngleZ = -0.262F;
		Hat4.rotationPointX = 3.3F;
		Hat4.rotationPointY = -6.3F;
		Hat4.rotationPointZ = -1.1F;
		Hat5.rotateAngleX = -0.524F;
		Hat5.rotateAngleY = 0.262F;
		Hat5.rotateAngleZ = 0F;
		Hat5.rotationPointX = -2.0F;
		Hat5.rotationPointY = -9.9F;
		Hat5.rotationPointZ = 1.5F;
		Hat6.rotateAngleX = -0.524F;
		Hat6.rotateAngleY = -0.262F;
		Hat6.rotateAngleZ = 0F;
		Hat6.rotationPointX = 2.2F;
		Hat6.rotationPointY = -9.8F;
		Hat6.rotationPointZ = 1.5F;
		Hat7.rotateAngleX = 0.611F;
		Hat7.rotateAngleY = 0F;
		Hat7.rotateAngleZ = 0.017F;
		Hat7.rotationPointX = 0F;
		Hat7.rotationPointY = -11.3F;
		Hat7.rotationPointZ = 0F;
		Hat8.rotateAngleX = 0F;
		Hat8.rotateAngleY = 1.571F;
		Hat8.rotateAngleZ = 0.262F;
		Hat8.rotationPointX = -3F;
		Hat8.rotationPointY = -10.5F;
		Hat8.rotationPointZ = 4.0F;
		Hat9.rotateAngleX = 0F;
		Hat9.rotateAngleY = 0F;
		Hat9.rotateAngleZ = 0.785F;
		Hat9.rotationPointX = 0F;
		Hat9.rotationPointY = -14.2F;
		Hat9.rotationPointZ = 4.5F;		THat1.rotateAngleX = 0F;
		THat1.rotateAngleY = -0.785F;
		THat1.rotateAngleZ = 0F;
		THat1.rotationPointX = 0F;
		THat1.rotationPointY = -7F;
		THat1.rotationPointZ = -2F;
		THat2.rotateAngleX = 0.785F;
		THat2.rotateAngleY = 1.571F;
		THat2.rotateAngleZ = 0F;
		THat2.rotationPointX = 0F;
		THat2.rotationPointY = -8F;
		THat2.rotationPointZ = 0.5F;
		//横髪 歩いたとき外に広がるように。
		RSidehair1.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
		RSidehair1.rotationPointX = -4.5F;
		RSidehair1.rotationPointY = -5F;
		RSidehair1.rotationPointZ = -2F;
		RSidehair2.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F + 0.2F) + 0.262F;
		RSidehair2.rotationPointX = -4.5F;
		RSidehair2.rotationPointY = -4.5F;
		RSidehair2.rotationPointZ = 0F;
		RSidehair3.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
		RSidehair3.rotationPointX = -4.5F;
		RSidehair3.rotationPointY = -4.3F;
		RSidehair3.rotationPointZ = 2F;
		RSidehair4.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
		RSidehair4.rotationPointX = -4.5F;
		RSidehair4.rotationPointY = -4F;
		RSidehair4.rotationPointZ = 4F;		LSidehair1.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) - 0.262F;
		LSidehair1.rotationPointX = 4.5F;
		LSidehair1.rotationPointY = -5F;
		LSidehair1.rotationPointZ = -2F;
		LSidehair2.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F - 0.2F) - 0.262F;
		LSidehair2.rotationPointX = 4.5F;
		LSidehair2.rotationPointY = -4.5F;
		LSidehair2.rotationPointZ = 0F;
		LSidehair3.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F - 0.1F) - 0.262F;
		LSidehair3.rotationPointX = 4.5F;
		LSidehair3.rotationPointY = -4.3F;
		LSidehair3.rotationPointZ = 2F;
		LSidehair4.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) - 0.262F;
		LSidehair4.rotationPointX = 4.5F;
		LSidehair4.rotationPointY = -4F;
		LSidehair4.rotationPointZ = 4F;
		//後ろ髪 歩いたとき外に広がるように
		Backhair1.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
		Backhair1.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) + 0.175F;
		Backhair1.rotationPointX = 4.0F;
		Backhair1.rotationPointY = -5F;
		Backhair1.rotationPointZ = 4.5F;
		Backhair2.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
		Backhair2.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) + 0.087F;
		Backhair2.rotationPointX = 2.0F;
		Backhair2.rotationPointY = -4.8F;
		Backhair2.rotationPointZ = 4.7F;
		Backhair3.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.2F) + 0.262F;
		Backhair3.rotationPointX = 0F;
		Backhair3.rotationPointY = -5F;
		Backhair3.rotationPointZ = 5F;
		Backhair4.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
		Backhair4.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) - 0.087F;
		Backhair4.rotationPointX = -2.0F;
		Backhair4.rotationPointY = -4.8F;
		Backhair4.rotationPointZ = 4.7F;
		Backhair5.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
		Backhair5.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) - 0.175F;
		Backhair5.rotationPointX = -4.0F;
		Backhair5.rotationPointY = -5F;
		Backhair5.rotationPointZ = 4.5F;		Rribon.rotateAngleX = 0F;
		Rribon.rotateAngleY = 0.349F;
		Rribon.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) - 0.262F;
		Rribon.rotationPointX = -4F;
		Rribon.rotationPointY = -7.5F;
		Rribon.rotationPointZ = -3.5F;
		Lribon.rotateAngleX = 0F;
		Lribon.rotateAngleY = -0.349F;
		Lribon.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) + 0.262F;
		Lribon.rotationPointX = 4F;
		Lribon.rotationPointY = -7.5F;
		Lribon.rotationPointZ = -3.5F;		HaneL1.rotationPointX = 2F;
		HaneL1.rotationPointY = -3F;
		HaneL1.rotationPointZ = 6F;
		HaneL1.rotateAngleX = 0.349F;
		//h1 翼、自動動き + 移動動き
		float h1 = (Helper.cos(f2 * 0.2F) * 0.05F) + (bipedLeftLeg.rotateAngleX / 3F);
		HaneL1.rotateAngleZ = h1 - 0.262F;		HaneL2.rotationPointX = 11F;
		HaneL2.rotationPointY = (Helper.sin(h1) * 8F) - 6F;
		HaneL2.rotationPointZ = 6F;
		HaneL2.rotateAngleX = 0.349F;
		HaneL2.rotateAngleY = h1 + 0.262F;		HaneR1.rotationPointX = -2F;
		HaneR1.rotationPointY = -3F;
		HaneR1.rotationPointZ = 6F;
		HaneR1.rotateAngleX = 0.349F;
		//h2 翼、自動動き + 移動動き 逆側
		float h2 = (Helper.cos(f2 * 0.2F + 3.141593F) * 0.05F) + (bipedRightLeg.rotateAngleX / 3F);
		HaneR1.rotateAngleZ = h2 + 0.262F;		HaneR2.rotationPointX = -9F;
		HaneR2.rotationPointY = (Helper.sin(h2) * -8F) - 6F;
		HaneR2.rotationPointZ = 6F;
		HaneR2.rotateAngleX = 0.349F;
		HaneR2.rotateAngleY = h2 - 0.262F;		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) {
			bipedHead.rotationPointY = basebipedHeadRotationPointY - 5F;
		} else {
//			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSneak)) {
			bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? basebipedHeadRotationPointY : basebipedHeadRotationPointY - bipedRightLeg.rotateAngleX * 8F;
			bipedHead.rotateAngleX += 0.5F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait) && !ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? basebipedHeadRotationPointY : basebipedHeadRotationPointY - bipedRightLeg.rotateAngleX * 8F;
		}
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			float f6 = Helper.sin(onGrounds[dominantArm] * 3.141593F);
			float f7 = Helper.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F) + bipedHead.rotateAngleY + 0.4F;
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedLeftArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			bipedRightArm.rotateAngleZ += Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= Helper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX += Helper.sin(f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedRightArm.rotationPointX = -7F;
			bipedLeftArm.rotationPointX = 6F;
			bipedRightArm.rotationPointZ = -2F;
			bipedLeftArm.rotationPointZ = -2F;
		}
//		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	protected void eyeRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
		boolean eyeFlag = equipmentCheckOfHead(entityCaps);
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			if (eyeFlag) {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			}
		} else {
			if (eyeFlag
					&& 0.0D > (mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
				setCapsValue(entityCaps, caps_visible, eyeL, false);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			} else {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, true);
			}
		}
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
				bipedRightArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedRightArm.rotateAngleZ = Helper.sin(onGrounds[0] * 3.141593F) * -0.4F;
			} else {
				bipedRightArm.rotateAngleZ = 0.0F;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Helper.sin(f6 * (float) Math.PI);
				f8 = Helper.sin(onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedLeftArm.rotateAngleZ = Helper.sin(onGrounds[1] * 3.141593F) * 0.4F;
			} else {
				bipedLeftArm.rotateAngleZ = 0.0F;
			}
		}
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
	}	@Override
	public float getHeight(IModelCaps entityCaps) {
		return 0.999F;
	}	@Override
	public float getWidth(IModelCaps entityCaps) {
		return 1.2F;
	}	@Override
	public float getyOffset(IModelCaps entityCaps) {
		return 0.4F;
	}	@Override
	public float getMountedYOffset(IModelCaps entityCaps) {
		float d = 1.4F;
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isRiding)) d -= 0.1F;
		return d;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}