package camping.common.rikmuld.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.proxys.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TentParts extends CampingItem {

	public static final String[] metadataNames = new String[] {Items.ITEM_TENT_PARTS_PEGS_NAME, Items.ITEM_TENT_PARTS_CANVAS_NAME };

	public TentParts(int i) 
	{
		super(i);
		maxStackSize = 64;
		setHasSubtypes(true);
		setMaxDamage(0);
		setItemName(Items.ITEM_META_TENT_PARTS_NAME);
	}

	@Override
	public String getItemNameIS(ItemStack itemstack) 
	{
		return metadataNames[itemstack.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i) 
	{
		switch (i) 
		{
		case 0:return 17;
		case 1:return 16;
		default:return 16;
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs creativetabs, List list) 
	{
		for (int var4 = 0; var4 < 2; ++var4) 
		{
			list.add(new ItemStack(par1, 1, var4));
		}
	}

}
