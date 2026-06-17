package littleMaidMobX.textures;

import net.minecraft.util.ResourceLocation;

public interface ITextureEntity {

    public void setTexturePackIndex(int pColor, int[] pIndex);

    public void setTexturePackName(TextureBox[] pTextureBox);

    public void setColor(int pColor);

    public int getColor();

    public void setContract(boolean pContract);

    public boolean isContract();

    public void setTextureBox(TextureBoxBase[] pTextureBox);

    public TextureBoxBase[] getTextureBox();

    public void setTextureIndex(int[] pTextureIndex);

    public int[] getTextureIndex();

    public void setTextures(int pIndex, ResourceLocation[] pNames);

    public ResourceLocation[] getTextures(int pIndex);

    public TextureData getTextureData();

}
