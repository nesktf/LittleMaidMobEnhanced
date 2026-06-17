package littleMaidMobX.textures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import littleMaidMobX.model.caps.IModelCaps;

public abstract class TextureBoxBase {

    public String textureName;
    public int contractColor;
    public int wildColor;
    protected float modelHeight;
    protected float modelWidth;
    protected float modelYOffset;
    protected float modelMountedYOffset;
    protected boolean isUpdateSize;

    public void setModelSize(float pHeight, float pWidth, float pYOffset, float pMountedYOffset) {
        modelHeight = pHeight;
        modelWidth = pWidth;
        modelYOffset = pYOffset;
        modelMountedYOffset = pMountedYOffset;
    }

    protected int getRandomColor(int pColor, Random pRand) {
        List<Integer> llist = new ArrayList<Integer>();
        for (int li = 0; li < 16; li++) {
            if ((pColor & 0x01) > 0) {
                llist.add(li);
            }
            pColor = pColor >>> 1;
        }

        if (llist.size() > 0) {
            return llist.get(pRand.nextInt(llist.size()));
        } else {
            return -1;
        }
    }

    public int getContractColorBits() {
        return contractColor;
    }

    public int getWildColorBits() {
        return wildColor;
    }

    // public boolean hasColor(int pIndex, boolean pContract) {
    // return (((pContract ? contractColor : wildColor) >>> pIndex) & 0x01) != 0;
    // }

    public int getRandomWildColor(Random pRand) {
        return getRandomColor(getWildColorBits(), pRand);
    }

    public int getRandomContractColor(Random pRand) {
        return getRandomColor(getContractColorBits(), pRand);
    }

    public float getHeight(IModelCaps pEntityCaps) {
        return modelHeight;
    }

    public float getHeight() {
        return getHeight(null);
    }

    public float getWidth(IModelCaps pEntityCaps) {
        return modelWidth;
    }

    public float getWidth() {
        return getWidth(null);
    }

    public float getYOffset(IModelCaps pEntityCaps) {
        return modelYOffset;
    }

    public float getYOffset() {
        return getYOffset(null);
    }

    public float getMountedYOffset(IModelCaps pEntityCaps) {
        return modelMountedYOffset;
    }

    public float getMountedYOffset() {
        return getMountedYOffset(null);
    }

}
