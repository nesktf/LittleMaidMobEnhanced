package littleMaidMobX.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class Message implements IMessage {

    public byte ch;

    public byte[] data;

    public Message() {}

    public Message(int ch, byte[] sendData) {
        this.ch = (byte) ch;
        this.data = sendData;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int len = buf.array().length;
        if (len > 2) {
            this.data = new byte[len - 2];
            this.ch = buf.getByte(0);
            buf.getBytes(1, this.data);
        } else {
            this.data = new byte[] { 0 };
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.ch);
        buf.writeBytes(this.data);
    }
}
