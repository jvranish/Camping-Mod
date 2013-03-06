package rikmuld.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rikmuld.core.lib.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Marshmellow extends CampingItem{
			
	public static final String[] metadataNames = new String[] {Items.ITEM_MARSH_NORMAL_NAME, Items.ITEM_MARSH_STICK_NAME};
	
	public Marshmellow(int i)
	{
		super(i);
		maxStackSize = 64;
		setHasSubtypes(true);
		setMaxDamage(0);
		setItemName(Items.ITEM_META_MARSH_NAME);
	}	
	
	@Override
    public String getItemNameIS(ItemStack itemstack)
    {
            return metadataNames[itemstack.getItemDamage()];
    }
	
	@SideOnly(Side.CLIENT)
    public int getIconFromDamage(int i)
    {
     switch(i)
     {
     case 0: return 19;
     case 1: return 20;
     default: return 19;
     } 
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs creativetabs, List list)
	{
		for(int var4 = 0; var4 < 2; ++var4)
		{
			list.add(new ItemStack(par1, 1, var4));
		}
	}	
}