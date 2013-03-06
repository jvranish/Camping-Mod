package rikmuld.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import rikmuld.core.register.ModAchievements;
import rikmuld.core.register.ModBlocks;
import rikmuld.core.register.ModItems;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftHandler implements ICraftingHandler{

	ItemStack campfire1 = new ItemStack(ModBlocks.campfireMultiCooker, 1, 0);
	ItemStack campfire2 = new ItemStack(ModBlocks.campfireMultiCooker, 1, 1);
	ItemStack campfire3 = new ItemStack(ModBlocks.campfireFastCooker, 1, 0);
	ItemStack campfire4 = new ItemStack(ModBlocks.campfireCheapCooker, 1, 0);
	ItemStack campfire5 = new ItemStack(ModBlocks.campfireCheapCooker, 1, 1);
	ItemStack tent1 = new ItemStack(ModBlocks.tent, 1, 0);
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory inv) 
	{
		if (item.itemID == ModItems.Marshmallow.itemID)
        {
			if(item.getItemDamage() == 0)
			{
				ItemStack bowl = new ItemStack(Item.bowlEmpty);
				player.inventory.addItemStackToInventory(bowl);
			} 
        }
		
		for(int i=0; i < inv.getSizeInventory(); i++)
        {         
            if(inv.getStackInSlot(i) != null)
            {
                ItemStack j = inv.getStackInSlot(i);
                if(j.getItem() != null && j.getItem() == ModItems.TentTools)
                {
                    ItemStack k = new ItemStack(ModItems.TentTools, 2, (j.getItemDamage() + 1));
     
                    if(k.getItemDamage() >= k.getMaxDamage())
                        k = null;
                    inv.setInventorySlotContents(i, k);
                }  
            }
        }
		
		if (item.itemID == campfire1.itemID)
		{	
			if (item.getItemDamage() == campfire1.getItemDamage())
			{
                player.addStat(ModAchievements.campachiev, 1);
			}
			if (item.getItemDamage() == campfire2.getItemDamage())
			{
                player.addStat(ModAchievements.campachiev3, 1);
			}
		}
		
        if (item.itemID == ModItems.TentParts.itemID)
        {
                player.addStat(ModAchievements.campachiev1, 1);
        } 
        
        if (item.itemID  == campfire3.itemID )
        {
                player.addStat(ModAchievements.campachiev4, 1);
        }
        
        if (item.itemID  == campfire4.itemID )
        {
        	if (item.getItemDamage()  == campfire4.getItemDamage() )
        	{
                player.addStat(ModAchievements.campachiev5, 1);
        	}
        	if (item.getItemDamage()  == campfire5.getItemDamage() )
        	{
        		player.addStat(ModAchievements.campachiev6, 1);
        	}	       	 
        }
        
        if (item.itemID == tent1.itemID)
		{	
        	if (item.getItemDamage() == tent1.getItemDamage())
        	{
                player.addStat(ModAchievements.campachiev7, 1);
        	}
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
	
	}

}
