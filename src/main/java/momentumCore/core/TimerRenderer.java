package momentumCore.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

/**
 * Created by AEnterprise
 */
public class TimerRenderer {
	private static final Minecraft MC = Minecraft.getMinecraft();

	@SubscribeEvent
	public void tick(TickEvent.RenderTickEvent event) {
		if (event.phase == TickEvent.Phase.END && MC.currentScreen == null) {
			if (Timer.overlay) {
				GL11.glPushMatrix();
				GL11.glScaled(3, 3, 3);
				MC.fontRenderer.drawString(EnumChatFormatting.AQUA + "Congratulations!", 30, 5, 0x0000, true);
				MC.fontRenderer.drawString(EnumChatFormatting.AQUA + "YOUR TIME:", 40, 20, 0x0000, true);
				MC.fontRenderer.drawString(Timer.getDisplayTime(), 50, 45, 0x000000, true);
				GL11.glPopMatrix();
			} else {
				MC.fontRenderer.drawString(Timer.getDisplayTime(), 8, 8, 0x000000, true);
			}
		}
	}
}
