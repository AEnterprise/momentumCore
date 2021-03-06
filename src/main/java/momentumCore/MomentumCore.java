package momentumCore;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import momentumCore.core.Listeners;
import momentumCore.core.PacketHandler;
import momentumCore.core.TimerRenderer;
import momentumCore.items.EndOrb;
import momentumCore.items.NetherOrb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by AEnterprise
 */

@Mod(modid = "momentumcore", name = "MomentumCore", version = "@MODVERSION@", acceptedMinecraftVersions = "1.7.10")
public class MomentumCore {
	@Mod.Instance
	public static MomentumCore instance;
	public static Item netherOrb;
	public static Item endOrb;
	public static CreativeTabs creativeTab = new CreativeTabs("momentumCore") {
		@Override
		public Item getTabIconItem() {
			return netherOrb;
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		netherOrb = new NetherOrb();
		endOrb = new EndOrb();
		FMLCommonHandler.instance().bus().register(new Listeners());
		MinecraftForge.EVENT_BUS.register(new Listeners());
		FMLCommonHandler.instance().bus().register(new TimerRenderer());
		PacketHandler.init();
	}
}
