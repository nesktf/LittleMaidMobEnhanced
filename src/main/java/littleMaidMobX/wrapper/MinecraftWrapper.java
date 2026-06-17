package littleMaidMobX.wrapper;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityTameable;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Loader;

public class MinecraftWrapper {

    private static final IMinecraftVersion instance = getInstance();

    private static IMinecraftVersion getInstance() {
        final String VER = Loader.instance()
            .getMCVersionString();
        if (VER.endsWith("1.7.10")) {
            return new littleMaidMobX.wrapper.mc1710.MinecraftVersion();
        }
        // LOG.warning("Unsupported version");
        return null;
    }

    public static void setOwner(EntityTameable entity, String name) {
        instance.setOwner(entity, name);
    }

    public static String getOwnerName(IEntityOwnable entity) {
        String ownerName = instance.getOwnerName(entity);

        // http://forum.minecraftuser.jp/viewtopic.php?f=13&t=23347&p=212078#p212038
        return ownerName != null ? ownerName : "";
    }

    public static GameProfile newGameProfile(String UUIDid, String name) {
        return instance.newGameProfile(UUIDid, name);
    }

    public static void notifyAdmins(ICommandSender sender, ICommand cmd, int p_152374_2_, String s,
        Object... p_152374_4_) {
        instance.notifyAdmins(sender, cmd, p_152374_2_, s, p_152374_4_);
    }
}
