package momentumCore.core;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.Random;

/**
 * Created by AEnterprise
 */
public class FireworkMessage implements IMessage, IMessageHandler<FireworkMessage, IMessage> {
	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public IMessage onMessage(FireworkMessage message, MessageContext ctx) {
		EntityPlayer player = ctx.getServerHandler().playerEntity;
		for (int i = 0; i < 10; i++) {
			NBTTagCompound explosion = new NBTTagCompound();
			NBTTagCompound tag = new NBTTagCompound();
			Random random = new Random();
			int[] c = new int[5];
			for (int j = 0; j < 2; j++)
				c[j] = ItemDye.field_150922_c[random.nextInt(15) + 1];
			explosion.setIntArray("Colors", c);
			explosion.setBoolean("Trail", true);
			explosion.setByte("Type", (byte) 1);
			NBTTagList list = new NBTTagList();
			list.appendTag(explosion);
			tag.setTag("Explosions", list);
			tag.setByte("Flight", (byte) 1);

			ItemStack firework = new ItemStack(Items.fireworks);
			firework.stackTagCompound = new NBTTagCompound();
			firework.stackTagCompound.setTag("Fireworks", tag);
			player.worldObj.spawnEntityInWorld(new EntityFireworkRocket(player.worldObj, player.posX + random.nextInt(3), player.posY + random.nextInt(3), player.posZ + random.nextInt(3), firework));
		}
		return null;
	}
}
