package rikmuld.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rikmuld.CampingMod;
import rikmuld.core.lib.GuiIds;
import rikmuld.core.lib.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuideBook extends CampingItem{

	public static final String[] metadataNames = new String[]	
	{
		Items.ITEM_BOOK_GUIDE_CAMP_NAME,
		Items.ITEM_BOOK_GUIDE_TENT_NAME, 
		Items.ITEM_BOOK_GUIDE_EQUIP_NAME, 
		Items.ITEM_BOOK_GUIDE_FOOD_NAME, 
		Items.ITEM_BOOK_GUIDE_WORLD_NAME, 
	};

	public GuideBook(int id) 
	{
		super(id);
		setItemName(Items.ITEM_META_BOOK_GUIDE_NAME);
		setHasSubtypes(true);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer par3EntityPlayer)
    {
        switch (stack.getItemDamage())
        {
	        case 0:
	        {
	        	par3EntityPlayer.openGui(CampingMod.instance, GuiIds.GUIGuideCampfire, par2World,  0, 0, 0);
	        }
	        case 1:
	        {
	        	par3EntityPlayer.openGui(CampingMod.instance, GuiIds.GUIGuideTent, par2World,  0, 0, 0);
	        }
	        case 2:
	        {
	        	par3EntityPlayer.openGui(CampingMod.instance, GuiIds.GUIGuideEquipment, par2World,  0, 0, 0);
	        }
	        case 3:
	        {
	        	par3EntityPlayer.openGui(CampingMod.instance, GuiIds.GUIGuideFood, par2World,  0, 0, 0);
	        }
	        case 4:
	        {
	        	par3EntityPlayer.openGui(CampingMod.instance, GuiIds.GUIGuideWorld, par2World,  0, 0, 0);
	        }
        }
        return stack;
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
			case 0:return 29;
			case 1:return 30;
			case 2:return 31;
			case 3:return 32;
			case 4:return 33;
			default:return 29;
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs creativetabs, List list) 
	{
		for (int var4 = 0; var4 < 5; ++var4) 
		{
			list.add(new ItemStack(par1, 1, var4));
		}
	}

}
