package littleMaidMobX.model.modchu;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.render.model.ModelRenderer;

public abstract class ModelModchuBaseAction extends ModelModchuBaseBiped {

    public ModelRenderer rightArm;
    public ModelRenderer rightArm2;
    public ModelRenderer rightArmPlus;
    public ModelRenderer rightArmPlus2;
    public ModelRenderer rightHand;
    public ModelRenderer rightLeg;
    public ModelRenderer rightLeg2;
    public ModelRenderer rightLegPlus;
    public ModelRenderer rightLegPlus2;
    public ModelRenderer leftArm;
    public ModelRenderer leftArm2;
    public ModelRenderer leftArmPlus;
    public ModelRenderer leftArmPlus2;
    public ModelRenderer leftHand;
    public ModelRenderer leftLeg;
    public ModelRenderer leftLeg2;
    public ModelRenderer leftLegPlus;
    public ModelRenderer leftLegPlus2;
    public ModelRenderer lowerBody;
    public ModelRenderer upperBody;
    public ModelRenderer hip;
    public ModelRenderer rightShoulder;
    public ModelRenderer leftShoulder;
    public ModelRenderer center;
    public ModelRenderer leftLegIK;
    public ModelRenderer rightLegIK;

    public ModelModchuBaseAction(StringBuilder hack) {
        super(hack);
    }

    public ModelModchuBaseAction() {
        this(0.0F);
    }

    public ModelModchuBaseAction(float psize) {
        this(psize, 0.0F);
    }

    public ModelModchuBaseAction(float psize, float pyoffset) {
        this(psize, pyoffset, 64, 32);
    }

    public ModelModchuBaseAction(float psize, float pyoffset, int par3, int par4, Object... o) {
        super(psize, pyoffset, par3 < 0 ? 64 : par3, par4 < 0 ? 32 : par4, (Object[]) o);
    }

    @Override
    public void afterInit(float f, float f1) {
        armsinit(f, f1);
        bonesInit(f, f1);
        actionPartsInit(f, f1);
        defaultAddChild();
    }

    public void actionPartsInit(float f, float f1) {}

    public void bonesInit(float f, float f1) {
        lowerBody = new ModelRenderer(this, "lowerBody");
        upperBody = new ModelRenderer(this, "upperBody");
        hip = new ModelRenderer(this, "hip");
        rightShoulder = new ModelRenderer(this, "rightShoulder");
        leftShoulder = new ModelRenderer(this, "leftShoulder");
        center = new ModelRenderer(this, "center");
        leftLegIK = new ModelRenderer(this, "leftLegIK");
        rightLegIK = new ModelRenderer(this, "rightLegIK");
    }
    // @Override
    // public void boneProcessing(float f, float f1, float f2, float f3, float f4, float f5, IModelCaps entityCaps) {
    // ModelRenderer m;
    /// *
    // center.rotationPointX = Modchu_Debug.debaf1;
    // center.rotationPointY = Modchu_Debug.debaf2;
    // center.rotationPointZ = Modchu_Debug.debaf3;
    // */
    /// *
    // rightLegIK.rotationPointX = Modchu_Debug.debaf1;
    // rightLegIK.rotationPointY = Modchu_Debug.debaf2;
    // rightLegIK.rotationPointZ = Modchu_Debug.debaf3;
    // //Modchu_Debug.debafNormalise(-3.141592653F, 3.141592653F);
    // Modchu_Debug.dDebug("debaf1="+Modchu_Debug.debaf1+" debaf2="+Modchu_Debug.debaf2+" debaf3="+Modchu_Debug.debaf3);
    // */
    // int boxSizeX;
    // int boxSizeY;
    // int boxSizeZ;
    // float X = 0.0F;
    // float Y = 0.0F;
    // float Z = 0.0F;
    // float tempX = 0.0F;
    // float f7 = 0.0F;
    // //Modchu_Debug.mDebug("boneProcessing center.rotationPointX="+center.rotationPointX);
    // //Modchu_Debug.mDebug("boneProcessing center.rotationPointY="+center.rotationPointY);
    // //Modchu_Debug.mDebug("boneProcessing center.rotationPointZ="+center.rotationPointZ);
    // List<ModelRenderer> boneChildModels = center != null ? center.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // mainFrame.rotationPointX += center.rotationPointX;
    // mainFrame.rotationPointY += center.rotationPointY;
    // mainFrame.rotationPointZ += center.rotationPointZ;
    /// *
    // leftLegIK.rotationPointX -= center.rotationPointX;
    // leftLegIK.rotationPointY -= center.rotationPointY;
    // leftLegIK.rotationPointZ -= center.rotationPointZ;
    // rightLegIK.rotationPointX -= center.rotationPointX;
    // rightLegIK.rotationPointY -= center.rotationPointY;
    // rightLegIK.rotationPointZ -= center.rotationPointZ;
    // */
    // upperBody.rotateAngleX += center.rotateAngleX;
    // upperBody.rotateAngleY += center.rotateAngleY;
    // upperBody.rotateAngleZ += center.rotateAngleZ;
    // }
    // boneChildModels = hip != null ? hip.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // upperBody.setRotateAngle(upperBody.rotateAngleX - hip.rotateAngleX, upperBody.rotateAngleY - hip.rotateAngleY,
    // upperBody.rotateAngleZ - hip.rotateAngleZ);
    // //lowerBody.setRotateAngle(lowerBody.rotateAngleX - hip.rotateAngleX, lowerBody.rotateAngleY + hip.rotateAngleY,
    // lowerBody.rotateAngleZ + hip.rotateAngleZ);
    /// *
    // int bodyBoxSizeX = bipedBody.getBoxSizeX();
    // int bodyBoxSizeY = bipedBody.getBoxSizeY();
    // int bodyBoxSizeZ = bipedBody.getBoxSizeZ();
    // for (int i = 0; i < hip.boneChildModels.size(); i++) {
    // m = (ModchuModel_ModelRenderer) hip.boneChildModels.get(i);
    // if (m != null); else continue;
    // boxSizeX = m.getBoxSizeX();
    // boxSizeY = m.getBoxSizeY();
    // boxSizeZ = m.getBoxSizeZ();
    //
    // f7 = hip.rotateAngleX > 0.0F ? hip.rotateAngleX : -hip.rotateAngleX;
    // Y = bodyBoxSizeY * (1.0F - mh_cos(f7));
    // Z = bodyBoxSizeY * mh_sin(f7);
    // //Modchu_Debug.mDebug("boneProcessing f7="+f7);
    // //Modchu_Debug.mDebug("boneProcessing 2 ="+(mh_cos(hip.rotateAngleX)));
    // m.rotationPointY += hip.rotateAngleX > 0.0F ? -Y : -Y;
    // m.rotationPointZ += hip.rotateAngleX > 0.0F ? -Z : Z;
    //
    // //f7 = hip.rotateAngleX > 0.0F ? hip.rotateAngleX : -hip.rotateAngleX;
    // //Y = boxSizeY * (1.0F - mh_cos(f7));
    // //Z = boxSizeY * mh_sin(f7);
    // //m.rotationPointY += hip.rotateAngleX > 0.0F ? -Y : -Y;
    // //m.rotationPointZ += hip.rotateAngleX > 0.0F ? -Z : Z;
    //
    // //Modchu_Debug.mDebug("boneProcessing mh_cos(hip.rotateAngleX)="+mh_cos(hip.rotateAngleX));
    // //Modchu_Debug.mDebug("boneProcessing hip.rotateAngleX="+hip.rotateAngleX);
    // //Modchu_Debug.dDebug("boneProcessing debaY="+Y+" debaZ="+Z+" mh_cos:"+mh_cos(hip.rotateAngleX));
    // //m.rotationPointX += 6F * mh_cos(hip.rotateAngleZ);
    //
    // //Y = boxSizeZ * (1.0F - mh_cos(f7));
    // //Z = boxSizeZ * mh_sin(f7);
    // //m.rotationPointY += hip.rotateAngleX > 0.0F ? Y : Y;
    // //m.rotationPointZ += hip.rotateAngleX > 0.0F ? -Z : Z;
    // //Modchu_Debug.mDebug("boneProcessing f7="+f7);
    // //Modchu_Debug.mDebug("boneProcessing Y="+Y);
    //
    // f7 = hip.rotateAngleZ > 0.0F ? hip.rotateAngleZ : -hip.rotateAngleZ;
    // X = boxSizeX * mh_sin(f7);
    // Y = (boxSizeX / 2.0F) * (1.0F - mh_cos(f7));
    // //Modchu_Debug.mDebug("boneProcessing f7="+f7);
    // //Modchu_Debug.mDebug("boneProcessing X="+X);
    //
    // m.rotationPointX += hip.rotateAngleZ > 0.0F ? X : -X;
    // m.rotationPointY += -Y;
    //
    // tempX = (boxSizeX * 1.5F) * mh_sin(f7);
    // }
    // */
    // }
    //
    // boneChildModels = lowerBody != null ? lowerBody.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // //Modchu_Debug.mDebug("lowerBody lowerBody.rotateAngleX="+lowerBody.rotateAngleX);
    // //Modchu_Debug.mDebug("lowerBody lowerBody.rotateAngleY="+lowerBody.rotateAngleY);
    // //Modchu_Debug.mDebug("lowerBody lowerBody.rotateAngleZ="+lowerBody.rotateAngleZ);
    // for (int i = 0; i < boneChildModels.size(); i++) {
    // m = boneChildModels.get(i);
    // if (m != null); else continue;
    // boxSizeX = m.getBoxSizeX();
    // boxSizeY = m.getBoxSizeY();
    // boxSizeZ = m.getBoxSizeZ();
    //
    // f7 = lowerBody.rotateAngleX > 0.0F ? lowerBody.rotateAngleX : -lowerBody.rotateAngleX;
    // X = (boxSizeX / 1.5F) * mh_sin(f7);
    // Y = boxSizeX * (1.0F - mh_cos(f7));
    // Z = (boxSizeX / 2.0F) * (1.0F - mh_cos(f7));
    // //Z = (boxSizeX / 2.0F) * mh_sin(f7);
    // //Modchu_Debug.mDebug("boneProcessing boxSizeX="+boxSizeX);
    // //Modchu_Debug.mDebug("boneProcessing f7="+f7);
    // //Modchu_Debug.mDebug("boneProcessing X="+X);
    // //Modchu_Debug.mDebug("boneProcessing Y="+Y);
    // //m.rotationPointX -= lowerBody.rotateAngleX > 0.0F ? -X : X;
    // m.rotationPointY -= Y > 1.0F ? 1.0F : Y < 0.0F ? 0.0F : Y;
    // if (Z > 1.5F) Z = 1.5F;
    // if (Z < -1.5F) Z = -1.5F;
    // m.rotationPointZ -= lowerBody.rotateAngleX > 0.0F ? Z : -Z;
    // //X = X / 10.0F;
    // Y = Y * 5.0F;
    // if (Y > 0.5F) Y = 0.5F;
    // if (Y < -0.5F) Y = -0.5F;
    // m.rotateAngleX += lowerBody.rotateAngleX > 0.0F ? Y : -Y;
    // //m.rotateAngleY += lowerBody.rotateAngleY > 0.0F ? X : X;
    /// *
    // Vector3f result = new Vector3f(m.rotationPointX, m.rotationPointY, m.rotationPointZ);
    // result = ModchuModel_rotateUtil.setRotation(0.0F, boxSizeY, 0.0F, X, Y, Z, m.rotateAngleX, m.rotateAngleY,
    // m.rotateAngleZ, result);
    // X = result.x;
    // Y = result.y;
    // Z = result.z;
    // m.rotateAngleX += X;
    // Modchu_Debug.dDebug("boneProcessing X="+X+" Y="+Y+" Z="+Z, 1);
    // */
    /// *
    // f7 = lowerBody.rotateAngleY > 0.0F ? lowerBody.rotateAngleY : -lowerBody.rotateAngleY;
    // X = (boxSizeX / 1.5F) * mh_sin(f7);
    // Y += (boxSizeX / 5.0F) * (1.0F - mh_cos(f7));
    // Z = (boxSizeX * 2.0F) * mh_sin(f7);
    // //Modchu_Debug.mDebug("boneProcessing X="+X);
    // //m.rotationPointX += -X;
    // //m.rotationPointY += -Y;
    // //m.rotationPointZ -= -Z;
    // X = X / 2.0F;
    // m.rotateAngleX -= -X;
    // */
    // f7 = lowerBody.rotateAngleZ > 0.0F ? lowerBody.rotateAngleZ : -lowerBody.rotateAngleZ;
    // m.rotationPointX += lowerBody.rotateAngleZ > 0.0F ? tempX : -tempX;
    // //X = (boxSizeX / 2.0F) * mh_sin(f7);
    // Y = boxSizeX * mh_sin(f7) < 0.5F ? boxSizeX * mh_sin(f7) : 0.5F;
    // Z = boxSizeX * (1.0F - mh_cos(f7));
    // //Modchu_Debug.mDebug("boneProcessing Z="+Z);
    // //m.rotationPointX += lowerBody.rotateAngleZ > 0.0F ? X : -X;
    // //m.rotationPointY += -Y;
    // //m.rotationPointZ += -Z;
    // Z = Z * 5.0F;
    // if (Z > 0.5F) Z = 0.5F;
    // if (Z < -0.5F) Z = -0.5F;
    // m.rotateAngleZ += lowerBody.rotateAngleZ > 0.0F ? Z : -Z;
    // }
    // }
    // boneChildModels = upperBody != null ? upperBody.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // //Modchu_Debug.mDebug("boneProcessing upperBody.boneChildModels.size()="+upperBody.boneChildModels.size());
    // for (int i = 0; i < boneChildModels.size(); i++) {
    // m = boneChildModels.get(i);
    // if (m != null); else continue;
    // m.rotateAngleX += upperBody.rotateAngleX;
    // m.rotateAngleY += upperBody.rotateAngleY;
    // m.rotateAngleZ += upperBody.rotateAngleZ;
    // boxSizeX = m.getBoxSizeX();
    // boxSizeY = m.getBoxSizeY();
    // boxSizeZ = m.getBoxSizeZ();
    //
    // f7 = upperBody.rotateAngleX > 0.0F ? upperBody.rotateAngleX : -upperBody.rotateAngleX;
    // m.rotationPointY += upperBody.rotateAngleX > 0.0F ? Y : Y;
    // Y = (boxSizeZ / 2.0F) * (1.0F - mh_cos(f7));
    // Z = (boxSizeZ / 2.0F) * (1.0F - mh_cos(f7));
    // //Modchu_Debug.mDebug("boneProcessing upperBody f7="+f7);
    // //Modchu_Debug.mDebug("boneProcessing upperBody boxSizeZ="+boxSizeZ);
    // //Modchu_Debug.mDebug("boneProcessing upperBody Z="+Z);
    // m.rotationPointY += upperBody.rotateAngleX > 0.0F ? Y : Y;
    // m.rotationPointZ += upperBody.rotateAngleX > 0.0F ? -Z : Z;
    //
    // f7 = upperBody.rotateAngleZ > 0.0F ? upperBody.rotateAngleZ : -upperBody.rotateAngleZ;
    // X = (boxSizeX / 2.0F) * mh_sin(f7);
    // Y = (boxSizeX / 2.0F) * (1.0F - mh_cos(f7));
    // //Modchu_Debug.mDebug("boneProcessing upperBody X="+X);
    // m.rotationPointX += upperBody.rotateAngleZ > 0.0F ? X : -X;
    // m.rotationPointY += Y;
    // }
    // List<ModelRenderer> boneSpecialChildModels = upperBody != null ? upperBody.getBoneSpecialChildModels() : null;
    // for (int i = 0; i < boneSpecialChildModels.size(); i++) {
    // m = boneSpecialChildModels.get(i);
    // if (m != null); else continue;
    // boxSizeX = m.getBoxSizeX();
    // boxSizeY = m.getBoxSizeY();
    // boxSizeZ = m.getBoxSizeZ();
    //
    // m.rotateAngleX -= upperBody.rotateAngleX;
    // m.rotateAngleZ -= upperBody.rotateAngleZ;
    /// *
    // f7 = upperBody.rotateAngleY > 0.0F ? upperBody.rotateAngleY : -upperBody.rotateAngleY;
    // Y = (boxSizeY / 2.0F) * mh_sin(f7);
    // Z = (boxSizeZ / 2.0F) * (1.0F - mh_cos(f7));
    // m.rotateAngleX -= upperBody.rotateAngleY > 0.0F ? Y : Y;
    // m.rotateAngleZ -= upperBody.rotateAngleY > 0.0F ? Z : Z;
    // */
    // }
    // }
    // //Modchu_Debug.mDebug("mainFrame.boneChildModels="+mainFrame.boneChildModels);
    // boneChildModels = rightShoulder != null ? rightShoulder.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // for (int i = 0; i < boneChildModels.size(); i++) {
    // m = boneChildModels.get(i);
    // if (m != null); else continue;
    // m.rotateAngleX += rightShoulder.rotateAngleX;
    // m.rotateAngleY += rightShoulder.rotateAngleY;
    // m.rotateAngleZ += rightShoulder.rotateAngleZ;
    // }
    // }
    // boneChildModels = leftShoulder != null ? leftShoulder.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()) {
    // for (int i = 0; i < boneChildModels.size(); i++) {
    // m = boneChildModels.get(i);
    // if (m != null); else continue;
    // m.rotateAngleX += leftShoulder.rotateAngleX;
    // m.rotateAngleY += leftShoulder.rotateAngleY;
    // m.rotateAngleZ += leftShoulder.rotateAngleZ;
    // }
    // }
    // IKProcessing(leftLegIK);
    // IKProcessing(rightLegIK);
    // }
    //
    // public void IKProcessing(ModelRenderer IK) {
    // ModelRenderer m;
    // int boxSizeX;
    // int boxSizeY;
    // int boxSizeZ;
    // float X = 0.0F;
    // float Y = 0.0F;
    // float Z = 0.0F;
    // float f7 = 0.0F;
    // List<ModelRenderer> boneChildModels = IK != null ? IK.getBoneChildModels() : null;
    // if (boneChildModels != null
    // && !boneChildModels.isEmpty()); else return;
    // for (int i = 0; i < boneChildModels.size(); i++) {
    // m = boneChildModels.get(i);
    // if (m != null); else continue;
    // boxSizeX = m.getBoxSizeX();
    // boxSizeY = m.getBoxSizeY();
    // boxSizeZ = m.getBoxSizeZ();
    // float fz1 = IK.rotationPointX;
    // float fz2 = -boxSizeY;
    // if (fz1 == 0.0F
    // && fz2 == 0.0F) {
    // X = 0.0F;
    // } else {
    // X = (float) Math.atan2(fz2, fz1) + 1.570796313F;
    // }
    // m.rotateAngleZ += X;
    /// *
    // fz1 = IK.rotationPointY;
    // fz2 = -boxSizeY;
    // if (fz1 == 0.0F
    // && fz2 == 0.0F) {
    // Y = 0.0F;
    // } else {
    // Y = (float) Math.atan2(fz2, fz1) + 1.570796313F;
    // }
    // m.rotateAngleX += Y;
    // */
    // fz1 = IK.rotationPointZ;
    // fz2 = -boxSizeY;
    // if (fz1 == 0.0F
    // && fz2 == 0.0F) {
    // Z = 0.0F;
    // } else {
    // Z = (float) Math.atan2(fz2, fz1) + 1.570796313F;
    // }
    // m.rotateAngleX += Z;
    // //Modchu_Debug.dDebug("leftLegIK X="+X+" Z="+Z, 1);
    // }
    // int boxSizeY2 = 0;
    // ModelRenderer m2 = null;
    // int i = 0;
    // for (ModelRenderer m1 : boneChildModels) {
    // if (m1 != null); else continue;
    // boxSizeY = m1.getBoxSizeY();
    // List<ModelRenderer> boneSpecialChildModels = m1.getBoneSpecialChildModels();
    // if (boneSpecialChildModels != null
    // && !boneSpecialChildModels.isEmpty()); else {
    // //Modchu_Debug.mDebug("boneSpecialChildModels == null !! m1.getBoxName()="+m1.getBoxName());
    // //Modchu_Debug.mDebug("boneSpecialChildModels == null !! boneSpecialChildModels="+boneSpecialChildModels);
    // continue;
    // }
    // Modchu_Debug.mDebug("boneSpecialChildModels != null !! boneSpecialChildModels="+boneSpecialChildModels);
    // if (i >= boneSpecialChildModels.size()) break;
    // m2 = boneSpecialChildModels.get(i);
    // i++;
    // if (m2 != null) boxSizeY2 = m2.getBoxSizeY();
    // else continue;
    // //Modchu_Debug.mDebug("m2 != null boxSizeY2="+boxSizeY2);
    // boxSizeY += boxSizeY2;
    // float x1 = 0.0F;
    // float y1 = 0.0F;
    // float z1 = 0.0F;
    // float x2 = IK.rotationPointX;
    // float y2 = IK.rotationPointY + boxSizeY;
    // float z2 = IK.rotationPointZ;
    // float ff1 = (float)Math.sqrt((double)(x1-x2)*(double)(x1-x2) + (double)(y1-y2)*(double)(y1-y2) +
    // (double)(z1-z2)*(double)(z1-z2));
    // //f7 = IK.rotationPointY > boxSizeY ? boxSizeY : IK.rotationPointY;
    // if (ff1 < boxSizeY) {
    // ff1 = 1.570796313F * (ff1 - boxSizeY);
    // m1.addRotateAngleX(ff1);
    // m2.addRotateAngleX(-ff1 * 2F);
    // }
    // m1.rotateAngleX = Modchu_Main.floatNormalise(m1.rotateAngleX, -1.570796313F, 1.570796313F);
    // if (m2.rotateAngleX > 3.14159265F) m2.rotateAngleX = Modchu_Main.floatNormalise(m2.rotateAngleX, -3.14159265F,
    // 3.14159265F);

    // Modchu_Debug.dDebug("leftLegIK boxSizeY="+boxSizeY, 3);
    // Modchu_Debug.dDebug("leftLegIK m.rotateAngleX="+m1.rotateAngleX, 3);
    // }
    // }

    @Override
    public void setArmorBipedRightArmShowModel(IModelCaps entityCaps, boolean b) {
        setCapsValue(entityCaps, caps_visible, bipedRightArm, b);
        if (rightArm != null) setCapsValue(entityCaps, caps_visible, rightArm, b);
        if (rightArm2 != null) setCapsValue(entityCaps, caps_visible, rightArm2, b);
        if (rightHand != null) setCapsValue(entityCaps, caps_visible, rightHand, b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(IModelCaps entityCaps, boolean b) {
        setCapsValue(entityCaps, caps_visible, bipedLeftArm, b);
        if (leftArm != null) setCapsValue(entityCaps, caps_visible, leftArm, b);
        if (leftArm2 != null) setCapsValue(entityCaps, caps_visible, leftArm2, b);
        if (leftHand != null) setCapsValue(entityCaps, caps_visible, leftHand, b);
    }

    @Override
    public void setArmorBipedRightLegShowModel(IModelCaps entityCaps, boolean b) {
        setCapsValue(entityCaps, caps_visible, bipedRightLeg, b);
        if (rightLeg != null) setCapsValue(entityCaps, caps_visible, rightLeg, b);
        if (rightLeg2 != null) setCapsValue(entityCaps, caps_visible, rightLeg2, b);
    }

    @Override
    public void setArmorBipedLeftLegShowModel(IModelCaps entityCaps, boolean b) {
        setCapsValue(entityCaps, caps_visible, bipedLeftLeg, b);
        if (leftLeg != null) setCapsValue(entityCaps, caps_visible, leftLeg, b);
        if (leftLeg2 != null) setCapsValue(entityCaps, caps_visible, leftLeg2, b);
    }

    public void setArmorBipedOtherShowModel(IModelCaps entityCaps, boolean b) {
        setCapsValue(entityCaps, caps_visible, bipedHeadwear, b);
    }
}
