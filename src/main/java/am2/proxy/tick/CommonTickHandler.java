package am2.proxy.tick;

import am2.ItemFrameWatcher;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class CommonTickHandler {

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.side == Side.SERVER && event.phase == TickEvent.Phase.START) {
            ItemFrameWatcher.INSTANCE.checkWatchedFrames();
        }
    }
}
