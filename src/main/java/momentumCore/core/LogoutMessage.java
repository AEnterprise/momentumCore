package momentumCore.core;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by AEnterprise
 */
public class LogoutMessage implements IMessage, IMessageHandler<LogoutMessage, IMessage> {
	public int hours, minutes, seconds, milliseconds;
	public boolean running;

	@Override
	public void fromBytes(ByteBuf buf) {
		hours = buf.readInt();
		minutes = buf.readInt();
		seconds = buf.readInt();
		milliseconds = buf.readInt();
		running = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(Timer.hours);
		buf.writeInt(Timer.minutes);
		buf.writeInt(Timer.seconds);
		buf.writeInt(Timer.milliseconds);
		buf.writeBoolean(Timer.running);
	}

	@Override
	public IMessage onMessage(LogoutMessage message, MessageContext ctx) {
		EntityPlayer player = ctx.getServerHandler().playerEntity;
		player.getEntityData().setInteger("hours", message.hours);
		player.getEntityData().setInteger("minutes", message.minutes);
		player.getEntityData().setInteger("seconds", message.seconds);
		player.getEntityData().setInteger("milliseconds", message.milliseconds);
		player.getEntityData().setBoolean("running", message.running);
		return null;
	}
}
