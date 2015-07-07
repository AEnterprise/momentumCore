package momentumCore.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by AEnterprise
 */
public class Listeners {

	@SubscribeEvent
	public void tick(TickEvent.PlayerTickEvent event) {
		if (event.type == TickEvent.Type.PLAYER && event.phase == TickEvent.Phase.START) {
			Timer.update();
			PacketHandler.instance.sendToServer(new LogoutMessage());
			if (event.player.getEntityData().hasKey("checktime")) {
				event.player.getEntityData().removeTag("checktime");
				World world = event.player.getEntityWorld();
				if (world.provider.dimensionId != -1)
					return;
				for (int x = (int) event.player.posX - 4; x < (int) event.player.posX + 4; x++) {
					for (int y = (int) event.player.posY - 4; y < (int) event.player.posY + 4; y++) {
						for (int z = (int) event.player.posZ - 4; z < (int) event.player.posZ + 4; z++) {
							Block block = world.getBlock(x, y, z);
							if (block == Blocks.obsidian || block == Blocks.portal) {
								world.setBlockToAir(x, y, z);
							}

						}
					}
				}
			}
		}
	}


	@SubscribeEvent
	public void join(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.player.getEntityData().hasKey("running")) {
			Timer.init(event.player.getEntityData().getInteger("hours"), event.player.getEntityData().getInteger("minutes"), event.player.getEntityData().getInteger("seconds"), event.player.getEntityData().getInteger("milliseconds"), event.player.getEntityData().getBoolean("running"));
		} else {
			Timer.init(0, 0, 0, 0, false);
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Timer.start();
	}
}
