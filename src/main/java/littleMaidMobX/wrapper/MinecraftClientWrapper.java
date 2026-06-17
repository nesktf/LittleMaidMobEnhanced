package littleMaidMobX.wrapper;

import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;

import cpw.mods.fml.common.Loader;

public class MinecraftClientWrapper {

    private static final IClientVersion instance = getInstance();

    private static IClientVersion getInstance() {
        final String VER = Loader.instance()
            .getMCVersionString();
        if (VER.equalsIgnoreCase("1.7.10")) {
            return new littleMaidMobX.wrapper.mc1710.MinecraftClientVersion();
        }
        // LOG.warning("Unsupported version");
        return null;
    }

    public static void renderSkeletonHead(TileEntitySkullRenderer skullRenderer, float x, float y, float z,
        int p_147530_4_, float p_147530_5_, int p_147530_6_, String p_147530_7_) {
        instance.renderSkeletonHead(skullRenderer, x, y, z, p_147530_4_, p_147530_5_, p_147530_6_, p_147530_7_);
    }
}
