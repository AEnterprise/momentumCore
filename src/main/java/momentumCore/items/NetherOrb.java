package momentumCore.items;

import cpw.mods.fml.common.registry.GameRegistry;
import momentumCore.MomentumCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by AEnterprise
 */
public class NetherOrb extends Item {

	public NetherOrb() {
		setUnlocalizedName("netherOrb");
		setTextureName("momentumCore:netherOrb");
		setCreativeTab(MomentumCore.creativeTab);
		GameRegistry.registerItem(this, "netherOrb");
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (!world.isRemote) {
			player.destroyCurrentEquippedItem();
			player.timeUntilPortal = 3000;
			player.getEntityData().setBoolean("checktime", true);
			player.travelToDimension(-1);
		}
		return true;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.destroyCurrentEquippedItem();
			player.timeUntilPortal = 3000;
			player.getEntityData().setBoolean("checktime", true);
			player.travelToDimension(-1);
		}
		return stack;
	}
}
