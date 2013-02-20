package camping.common.rikmuld.item.tool;

import net.minecraft.item.Item;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.proxys.CommonProxy;
import camping.common.rikmuld.item.CampingItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolCamping extends CampingItem {

	public ToolCamping(int i) 
	{
		super(i);
		maxStackSize = 1;
		setItemName(Items.ITEM_TOOL_CAMP_NAME);
		setMaxDamage(Config.GENERAL_CAMPTOOL_MAX_DURABILATY);
		setIconIndex(23);
		isDamageable();
	}
}

