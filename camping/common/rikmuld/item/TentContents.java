package camping.common.rikmuld.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.proxys.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TentContents extends CampingItem {

	public TentContents(int i) 
	{
		super(i);
		maxStackSize = 4;
		setMaxDamage(0);
		setItemName(Items.ITEM_TENT_CONTENTS_NAME);
		setIconIndex(22);
	}
}
