package momentumCore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import momentumCore.items.NetherOrb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by AEnterprise
 */

@Mod(modid = "momentumcore", name = "MomentumCore", version = "@MODVERSION@", acceptedMinecraftVersions = "1.7.10")
public class MomentumCore {
	@Mod.Instance
	public static MomentumCore instance;

	public static CreativeTabs creativeTab = new CreativeTabs("momentumCore") {
		@Override
		public Item getTabIconItem() {
			return netherOrb;
		}
	};

	public static Item netherOrb;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		netherOrb = new NetherOrb();
	}
}
