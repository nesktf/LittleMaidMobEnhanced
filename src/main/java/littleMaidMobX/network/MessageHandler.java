package littleMaidMobX.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import littleMaidMobX.LittleMaidMobX;

public class MessageHandler implements IMessageHandler<Message, IMessage> {

    @Override
    public IMessage onMessage(Message message, MessageContext ctx) {
        if (message.data != null) {
            if (ctx.side.isClient()) {
                LittleMaidMobX.proxy.clientCustomPayload(message);
            } else {
                if (message.ch == 1) {
                    LittleMaidMobX.serverCustomPayload(ctx.getServerHandler().playerEntity, message);
                }
                if (message.ch == 2) {
                    Net.serverCustomPayload(ctx.getServerHandler().playerEntity, message);
                }
            }
        }
        return null;
    }
}
