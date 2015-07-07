package momentumCore.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

/**
 * Created by AEnterprise
 */
public class TimerRenderer {
	private static final Minecraft MC = Minecraft.getMinecraft();

	@SubscribeEvent
	public void tick(TickEvent.RenderTickEvent event) {
		if (event.phase == TickEvent.Phase.END && MC.currentScreen == null) {
			MC.fontRenderer.drawString(Timer.getDisplayTime(), 0, 0, 0x000000, true);
		}
	}
}
