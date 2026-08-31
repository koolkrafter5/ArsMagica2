package am2.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class TickrateMessage implements IMessage {

    private float tickrate;

    public TickrateMessage() {}

    public TickrateMessage(float tickrate) {
        this.tickrate = tickrate;
    }

    public float getTickrate() {
        return tickrate;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        tickrate = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(tickrate);
    }
}
