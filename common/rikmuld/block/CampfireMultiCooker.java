package rikmuld.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import rikmuld.CampingMod;
import rikmuld.core.lib.Blocks;
import rikmuld.core.lib.Config;
import rikmuld.core.register.ModAchievements;
import rikmuld.core.register.ModBlocks;
import rikmuld.core.register.ModItems;
import rikmuld.tileentity.TileEntityCampfireMultiCooker;

public final class CampfireMultiCooker extends Campfire {
	
	
	public CampfireMultiCooker (int id) 
	{
		super(id, Blocks.BLOCK_META_CAMP_NORMAL_MULTI_NAME, 2, 15, 2);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityCampfireMultiCooker();
	}
 
	@Override
	public boolean onBlockActivated(World par1world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
	{
		int var6 = par1world.getBlockMetadata(x, y, z);
		ItemStack currentitem = player.getCurrentEquippedItem();
			
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
					     ItemStack marsh = new ItemStack(ModItems.MarshmallowFood.itemID, currentitem.stackSize, 0);
					     player.destroyCurrentEquippedItem();
					     player.inventory.addItemStackToInventory(marsh);
					     player.addStat(ModAchievements.campachiev2, 1);
					}
				    	
					if (currentitem.itemID == ModItems.TentTools.itemID)
					{
					     ItemStack camp = new ItemStack(ModBlocks.campfireMultiCooker.blockID, 1, 0);
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
			}
				
			if (var6==1)
			{
				if (currentitem != null)
				{
					if (currentitem.itemID == Item.dyePowder.itemID)
					{
						super.ColorParticle(par1world, x, y, z, player);
						return true;
					}
					if(Config.CAMPFIRE_CAN_TRANS_STICK)
					{
						if(currentitem.stackSize>=2)
						{
						     ItemStack torch = new ItemStack(Block.torchWood.blockID, 1, 0);
						     player.inventory.addItemStackToInventory(torch);
						     currentitem.stackSize-=2;
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
					     ItemStack camp = new ItemStack(ModBlocks.campfireMultiCooker.blockID, 1, 1);
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
				player.openGui(CampingMod.instance, 1, par1world, x, y, z);
				return true;
				}
				player.openGui(CampingMod.instance, 1, par1world, x, y, z);
				return true;
			}
			return true;		
	 }
}
 