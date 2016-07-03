package littleMaidMobX.util.transform;

import java.util.Arrays;

import littleMaidMobX.LittleMaidMobX;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

public class ModContainer extends DummyModContainer {

	public ModContainer() {
		super(new ModMetadata());
		ModMetadata lmeta = getMetadata();
		
		lmeta.modId		= "OldModelLoader";
		lmeta.name		= "LMMNX OldModelLoader";
		lmeta.version	= LittleMaidMobX.VERSION;
		lmeta.authorList	= Arrays.asList("MMM");
		lmeta.description	= "The MultiModel before 1.6.2 is read.";
		lmeta.url			= "";
		lmeta.credits		= "";
		setEnabledState(true);
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		//Disable
		bus.register(this);
		return true;
	}

}
