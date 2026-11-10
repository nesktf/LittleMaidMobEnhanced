package littleMaidMobX.model.bedrock;

public class MultiModelBedrock extends littleMaidMobX.model.maid.MultiModelBedrock {

    public MultiModelBedrock() {
        super();
    }

    public MultiModelBedrock(float pSizeAdjust) {
        super(pSizeAdjust);
    }

    public MultiModelBedrock(float pSizeAdjust, String pModelPath) {
        super(pSizeAdjust, pModelPath);
    }

    public MultiModelBedrock(float pSizeAdjust, float pYOffset, int pTextureWidth, int pTextureHeight) {
        super(pSizeAdjust, pYOffset, pTextureWidth, pTextureHeight);
    }
}
