package momentumCore.core;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by AEnterprise
 */
public class Timer {
	public static int hours, minutes, seconds, milliseconds;
	public static boolean running;
	private static long lastTime;

	public static void init(int hours, int minutes, int seconds, int milliseconds, boolean running) {
		Timer.hours = hours;
		Timer.minutes = minutes;
		Timer.seconds = seconds;
		Timer.milliseconds = milliseconds;
		Timer.running = running;
		Timer.lastTime = -1;
	}

	public static void update() {
		if (!running)
			return;
		if (lastTime == -1) {
			lastTime = System.currentTimeMillis();
			return;
		}
		long currentTime = System.currentTimeMillis();
		long difference = currentTime - lastTime;
		milliseconds += (int) difference;
		while (milliseconds >= 1000) {
			seconds++;
			milliseconds -= 1000;
		}
		while (seconds >= 60) {
			minutes++;
			seconds -= 60;
		}
		while (minutes >= 60) {
			hours++;
			minutes -= 60;
		}
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		player.getEntityData().setInteger("milliseconds", milliseconds);
		player.getEntityData().setInteger("seconds", seconds);
		player.getEntityData().setInteger("minutes", minutes);
		player.getEntityData().setInteger("hours", hours);
		player.getEntityData().setBoolean("running", running);
		lastTime = currentTime;
	}

	public static String getDisplayTime() {
		String time = "" + EnumChatFormatting.GREEN;
		if (hours < 10)
			time += "0";
		time += hours + ":";
		if (minutes < 10)
			time += "0";
		time += minutes + ":";
		if (seconds < 10)
			time += "0";
		time += seconds;
		return time;
	}

	public static void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

}
