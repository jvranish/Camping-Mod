package camping.common.rikmuld.core.tab;

import camping.common.rikmuld.core.register.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CampingTab extends CreativeTabs {
	
	public CampingTab(String label) 
	{
	    super(label);
	}	
	
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(ModBlocks.campfireMultiCooker);
	}
}