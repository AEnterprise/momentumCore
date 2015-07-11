package momentumCore.core;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by AEnterprise
 */
public class PacketHandler {

	public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("momentumCore");

	public static void init() {
		instance.registerMessage(LogoutMessage.class, LogoutMessage.class, 0, Side.SERVER);
		instance.registerMessage(FireworkMessage.class, FireworkMessage.class, 1, Side.SERVER);
	}
}
