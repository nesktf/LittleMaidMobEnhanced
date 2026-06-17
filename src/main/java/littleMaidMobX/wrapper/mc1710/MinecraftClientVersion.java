package littleMaidMobX.wrapper.mc1710;

import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;

import littleMaidMobX.wrapper.IClientVersion;

public class MinecraftClientVersion implements IClientVersion {

    @Override
    public void renderSkeletonHead(TileEntitySkullRenderer skullRenderer, float x, float y, float z, int p_147530_4_,
        float p_147530_5_, int p_147530_6_, String p_147530_7_) {
        skullRenderer.func_152674_a(x, y, z, p_147530_4_, p_147530_5_, p_147530_6_, null);
    }
}
