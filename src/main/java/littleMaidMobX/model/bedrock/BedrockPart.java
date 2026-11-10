package littleMaidMobX.model.bedrock;

import littleMaidMobX.model.maid.ModelBase;
import littleMaidMobX.render.model.ModelRenderer;

public class BedrockPart extends ModelRenderer {

    public float initPosX = 0.0F;
    public float initPosY = 0.0F;
    public float initPosZ = 0.0F;

    public float initRotX = 0.0F;
    public float initRotY = 0.0F;
    public float initRotZ = 0.0F;

    public BedrockPart(ModelBase pModelBase, String pName) {
        super(pModelBase, pName);
        this.rotatePriority = RotZYX;
    }

    public void setInitPosition(float x, float y, float z) {
        this.initPosX = x;
        this.initPosY = y;
        this.initPosZ = z;
        setRotationPoint(x, y, z);
    }

    public void setInitRotation(float x, float y, float z) {
        this.initRotX = x;
        this.initRotY = y;
        this.initRotZ = z;
        this.rotateAngleX = x;
        this.rotateAngleY = y;
        this.rotateAngleZ = z;
    }

    public void resetPose() {
        this.rotationPointX = initPosX;
        this.rotationPointY = initPosY;
        this.rotationPointZ = initPosZ;
        this.rotateAngleX = initRotX;
        this.rotateAngleY = initRotY;
        this.rotateAngleZ = initRotZ;
    }

    @Override
    public void setVisible(boolean pValue) {
        super.setVisible(pValue);
        this.showModel = pValue;
        this.isHidden = !pValue;
    }
}
