package rikmuld.item.tool;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rikmuld.CampingMod;
import rikmuld.core.lib.Items;
import rikmuld.inventory.inventory.InventoryCampingBagLarge;
import rikmuld.inventory.inventory.InventoryCampingBagNormal;
import rikmuld.inventory.inventory.InventoryCampingBagSmall;
import rikmuld.item.CampingItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolBackpack extends CampingItem {

public static final String[] metadataNames = new String[] {Items.ITEM_TOOL_BACK_SMALL_NAME, Items.ITEM_TOOL_BACK_NORMAL_NAME, Items.ITEM_TOOL_BACK_LARGE_NAME };

		public ToolBackpack(int i) 
		{
			super(i);
			maxStackSize = 1;
			setHasSubtypes(true);
			setMaxDamage(0);
			setItemName(Items.ITEM_META_TOOL_BACK_NAME);
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
			case 0:return 24;
			case 1:return 25;
			case 2:return 26;
			default:return 24;
			}
		}

		@SideOnly(Side.CLIENT)
		public void getSubItems(int par1, CreativeTabs creativetabs, List list) 
		{
			for (int var4 = 0; var4 < 3; ++var4) 
			{
				list.add(new ItemStack(par1, 1, var4));
			}
		}
		
		@Override
		public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
			if (par1ItemStack.itemID == this.itemID)
			{
				if(par1ItemStack.getItemDamage() == 2)
				{
					par3EntityPlayer.openGui(CampingMod.instance, 5, par2World,  0, 0, 0);
				}
				if(par1ItemStack.getItemDamage() == 1)
				{
					par3EntityPlayer.openGui(CampingMod.instance, 6, par2World,  0, 0, 0);
				}
				if(par1ItemStack.getItemDamage() == 0)
				{
					par3EntityPlayer.openGui(CampingMod.instance, 7, par2World,  0, 0, 0);
				}
			}
			
			return par1ItemStack;
	    }
		
		public static IInventory getBackpackInv(EntityPlayer player)
		{
			ItemStack backpack;
			IInventory inventoryBackpack = null;

			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ToolBackpack) {
				backpack = player.getCurrentEquippedItem();
				
				if(backpack.getItemDamage() == 2)
				{
					inventoryBackpack = new InventoryCampingBagLarge(player, backpack);
				}
				if(backpack.getItemDamage() == 1)
				{
					inventoryBackpack = new InventoryCampingBagNormal(player, backpack);
				}
				if(backpack.getItemDamage() == 0)
				{
					inventoryBackpack = new InventoryCampingBagSmall(player, backpack);
				}
			}
			return inventoryBackpack;
		}
}

