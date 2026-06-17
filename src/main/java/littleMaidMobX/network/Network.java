package littleMaidMobX.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class Network {

    private static SimpleNetworkWrapper INSTANCE;

    public static void init(String ch) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ch);

        INSTANCE.registerMessage(MessageHandler.class, Message.class, 0, Side.SERVER);
        INSTANCE.registerMessage(MessageHandler.class, Message.class, 0, Side.CLIENT);
    }

    public static void sendPacketToServer(int ch, byte[] data) {
        INSTANCE.sendToServer(new Message(ch, data));
    }

    public static void sendPacketToPlayer(int ch, EntityPlayer player, byte[] data) {
        if (player instanceof EntityPlayerMP) {
            INSTANCE.sendTo(new Message(ch, data), (EntityPlayerMP) player);
        }
    }

    public static void sendPacketToAllPlayer(int ch, byte[] data) {
        INSTANCE.sendToAll(new Message(ch, data));
    }
}
