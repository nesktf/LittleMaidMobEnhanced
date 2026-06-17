package littleMaidMobX.render.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;

public abstract class ModelBoxBase implements IRenderable {

    public PositionTextureVertex[] vertexPositions;
    public TexturedQuad[] quadList;
    public float posX1;
    public float posY1;
    public float posZ1;
    public float posX2;
    public float posY2;
    public float posZ2;
    public float pSizeAdj;
    public String boxName;

    public void render(Tessellator par1Tessellator, float par2) {
        for (int var3 = 0; var3 < quadList.length; ++var3) {
            quadList[var3].draw(par1Tessellator, par2);
        }
    }

    public ModelBoxBase setBoxName(String pName) {
        boxName = pName;
        return this;
    }

}
