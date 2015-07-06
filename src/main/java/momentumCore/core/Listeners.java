package momentumCore.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * Created by AEnterprise
 */
public class Listeners {

	@SubscribeEvent
	public void tick(TickEvent.PlayerTickEvent event) {
		if (event.type == TickEvent.Type.PLAYER && event.phase == TickEvent.Phase.START) {
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
}
