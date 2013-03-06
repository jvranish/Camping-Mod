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
import rikmuld.tileentity.TileEntityCampfireFastCooker;

public final class CampfireFastCooker extends Campfire {

	public CampfireFastCooker (int id) 
	{
		super(id, Blocks.BLOCK_CAMP_FAST_NAME, 1, 4, 4);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityCampfireFastCooker();
	}
	
	@Override
	public boolean onBlockActivated(World par1world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
	{
		ItemStack currentitem = player.getCurrentEquippedItem();
		
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
			     ItemStack camp = new ItemStack(ModBlocks.campfireFastCooker.blockID, 1, 0);
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
			player.openGui(CampingMod.instance, 2, par1world, x, y, z);
			return true;
		}
	player.openGui(CampingMod.instance, 2, par1world, x, y, z);
	return true;
	}
}

	
	