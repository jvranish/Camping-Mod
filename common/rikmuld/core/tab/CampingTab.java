package rikmuld.core.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rikmuld.core.register.ModBlocks;

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