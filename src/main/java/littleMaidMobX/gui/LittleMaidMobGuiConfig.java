package littleMaidMobX.gui;

import java.util.ArrayList;
import java.util.List;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.io.Config;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LittleMaidMobGuiConfig extends GuiConfig
{
    public LittleMaidMobGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen, getConfigElements(), LittleMaidMobX.DOMAIN, false, false, "Little Maid Mob Settings");
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<>();
        
        list.add(categoryElement(Config.CATEGORY_MAIDS, "Maids", "littlemaidmob.configgui.ctgy.maids"));
        list.add(categoryElement(Config.CATEGORY_SPAWNING, "Spawning", "littlemaidmob.configgui.ctgy.spawning"));
        list.add(categoryElement(Config.CATEGORY_ITEMS, "Items", "littlemaidmob.configgui.ctgy.items"));
        list.add(categoryElement(Config.CATEGORY_MMMLIB, "MMMLib", "littlemaidmob.configgui.ctgy.mmmlib"));
        list.add(categoryElement(Config.CATEGORY_DEBUG, "Debugging", "littlemaidmob.configgui.ctgy.debug"));
        
        return list;
    }
    
    /** Creates a button linking to another screen where all options of the category are available */
    private static IConfigElement categoryElement(String category, String name, String tooltip_key)
    {
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key, new ConfigElement(Config.config.getCategory(category)).getChildElements());
    }
}