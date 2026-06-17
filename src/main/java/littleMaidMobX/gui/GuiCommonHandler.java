package littleMaidMobX.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.inventory.ContainerInventory;

public class GuiCommonHandler implements IGuiHandler {

    //

    public static EntityLittleMaid maidClient = null;
    public static EntityLittleMaid maidServer = null;

    public static final int GUI_ID_INVVENTORY = 0;
    public static final int GUI_ID_IFF = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        Object o = null;
        switch (ID) {
            case GUI_ID_INVVENTORY:
                if (maidServer != null) {
                    o = new ContainerInventory(player.inventory, maidServer);
                    maidServer = null;
                }
                break;

            case GUI_ID_IFF:

                break;
        }
        return o;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        Object o = null;
        switch (ID) {
            case GUI_ID_INVVENTORY:
                if (maidClient != null) {
                    o = new GuiInventory(player, maidClient);
                    maidClient = null;
                }
                break;

            case GUI_ID_IFF:
                o = new GuiIFF(player.worldObj, maidClient);
                break;
        }
        return o;
    }
}
