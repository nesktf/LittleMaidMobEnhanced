package littleMaidMobX.network;

import littleMaidMobX.registry.ModelManager;

public class ProxyServer extends ProxyCommon {
	public void loadTextures()
	{
		ModelManager.instance.loadTextures(true);
	}
}
