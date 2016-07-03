package littleMaidMobX.util.transform;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class CoreMod implements IFMLLoadingPlugin{

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {"littleMaidMobX.util.transform.Transformer"};
	}

	@Override
	public String getModContainerClass() {
		return "littleMaidMobX.util.transform.ModContainer";
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

}