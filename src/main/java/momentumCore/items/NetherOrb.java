package momentumCore.items;

import cpw.mods.fml.common.registry.GameRegistry;
import momentumCore.MomentumCore;
import net.minecraft.item.Item;

/**
 * Created by AEnterprise
 */
public class NetherOrb extends Item {

	public NetherOrb() {
		setUnlocalizedName("netherOrb");
		setTextureName("momentumCore:netherOrb");
		setCreativeTab(MomentumCore.creativeTab);
		GameRegistry.registerItem(this, "netherOrb");
	}
}
