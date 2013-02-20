package camping.common.rikmuld.block;

import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.register.ModAchievements;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.core.register.ModItems;
import camping.common.rikmuld.tileentity.TileEntityCampfireCheapCooker;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class CampfireCheapCooker extends Campfire {

	private String color;
	
	public CampfireCheapCooker (int id) 
	{
		super(id, Blocks.BLOCK_META_CAMP_CHEAP_INSTA_NAME, 2, 8, 1);
		
	}
 
 	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
	return new TileEntityCampfireCheapCooker();
	}

	@Override
	public boolean onBlockActivated(World par1world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
	{
		int var6 = par1world.getBlockMetadata(x, y, z);
		ItemStack currentitem = player.getCurrentEquippedItem();
		TileEntity tileEntity = par1world.getBlockTileEntity(x, y, z);
			
		if (var6==1)
		{
			if (currentitem != null)
			{
				if (currentitem.itemID == Item.dyePowder.itemID)
				{
					super.ColorParticle(par1world, x, y, z, player);
					return true;
				}
				if (currentitem.itemID == Item.stick.itemID)
				{
					if(Config.CAMPFIRE_CAN_TRANS_STICK)
					{
						if(currentitem.stackSize>=2)
						{
						     ItemStack torch = new ItemStack(Block.torchWood.blockID, 1, 0);
						     player.inventory.addItemStackToInventory(torch);
						     currentitem.stackSize-=2;
						}
					}
				}	
			    else if (currentitem.itemID == Item.beefRaw.itemID)
			    {
			    	ItemStack beefCooked = new ItemStack(Item.beefCooked, currentitem.stackSize, 0);
	  		     	player.destroyCurrentEquippedItem();
	  		     	player.inventory.addItemStackToInventory(beefCooked);
				}
				
			    else if (currentitem.itemID == Item.chickenRaw.itemID)
			    {	
			    	ItemStack chickenCooked = new ItemStack(Item.chickenCooked, currentitem.stackSize, 0);
		  		    player.destroyCurrentEquippedItem();
		  		    player.inventory.addItemStackToInventory(chickenCooked);
	    	   	}
				
			    else if (currentitem.itemID == Item.fishRaw.itemID)
			    {	
			    	ItemStack fishCooked = new ItemStack(Item.fishCooked, currentitem.stackSize, 0);
		  		    player.destroyCurrentEquippedItem();
		  		    player.inventory.addItemStackToInventory(fishCooked);
	    	   	}
				
			    else if (currentitem.itemID == Item.porkRaw.itemID)
			    {	
			    	ItemStack porkCooked = new ItemStack(Item.porkCooked, currentitem.stackSize, 0);
		  		    player.destroyCurrentEquippedItem();
		  		    player.inventory.addItemStackToInventory(porkCooked);
	    	   	}
				
			    else if (currentitem.itemID == Item.potato.itemID)
			    {	
			    	ItemStack bakedPotato = new ItemStack(Item.bakedPotato, currentitem.stackSize, 0);
		  		    player.destroyCurrentEquippedItem();
		  		    player.inventory.addItemStackToInventory(bakedPotato);
	    	   	}
				
			    else if (currentitem.itemID == ModItems.Marshmallow.itemID&&currentitem.getItemDamage() == 1)
			    {			    
				     ItemStack marsh = new ItemStack(ModItems.MarshmallowFood.itemID, currentitem.stackSize, 0);
				     player.destroyCurrentEquippedItem();
				     player.inventory.addItemStackToInventory(marsh);
				     player.addStat(ModAchievements.campachiev2, 1);
			    }
				
				if (currentitem.itemID == ModItems.TentTools.itemID)
			    {
				    ItemStack camp = new ItemStack(ModBlocks.campfireCheapCooker.blockID, 1, 1);
			        player.inventory.addItemStackToInventory(camp);
			    	par1world.setBlockAndMetadataWithNotify(x, y, z, 0 , 0);
			      	 player.destroyCurrentEquippedItem();
			         ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
			         player.inventory.addItemStackToInventory(k);
			         if (currentitem.getItemDamage()>99)
			         {
			        	 player.destroyCurrentEquippedItem();
			         }
			    	return true;
				}
			}
			return true;
		}
				
		if (var6==0)
		{
			 if (currentitem != null)
			 {
				 if (currentitem.itemID == Item.dyePowder.itemID)
				 {
					super.ColorParticle(par1world, x, y, z, player);
					return true;
				 }
				 if (currentitem.itemID == Item.stick.itemID)
				 {
					 if(Config.CAMPFIRE_CAN_TRANS_STICK)
					 {
						 if(currentitem.stackSize>=2)
						 {
							 ItemStack torch = new ItemStack(Block.torchWood.blockID, 1, 0);
						     player.inventory.addItemStackToInventory(torch);
						     currentitem.stackSize-=2;
						 }
					 }
				 }
				 
				 if (currentitem.itemID == ModItems.Marshmallow.itemID&&currentitem.getItemDamage() == 1)
				 {				    
				     ItemStack marsh = new ItemStack(ModItems.MarshmallowFood, currentitem.stackSize, 0);
				     player.destroyCurrentEquippedItem();
				     player.inventory.addItemStackToInventory(marsh);
				     player.addStat(ModAchievements.campachiev2, 1);
				     return true;			    
				 }
   	
				if (currentitem.itemID == ModItems.TentTools.itemID)
			    {
				    ItemStack camp = new ItemStack(ModBlocks.campfireCheapCooker.blockID, 1, 0);
			        player.inventory.addItemStackToInventory(camp);
			    	par1world.setBlockAndMetadataWithNotify(x, y, z, 0 , 0);
			      	 player.destroyCurrentEquippedItem();
			         ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
			         player.inventory.addItemStackToInventory(k);
			         if (currentitem.getItemDamage()>99)
			         {
			        	 player.destroyCurrentEquippedItem();
			         }
					return true;
				}
				player.openGui(CampingMod.instance, 3, par1world, x, y, z);
				return true;
			}
			player.openGui(CampingMod.instance, 3, par1world, x, y, z);
			return true;
		}
		return true;
	}
}