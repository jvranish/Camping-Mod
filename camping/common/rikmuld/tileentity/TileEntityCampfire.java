package camping.common.rikmuld.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityCampfire extends TileEntity implements IInventory, ISidedInventory{

	private int feul;
	private boolean nofeul;
	private int cook;  
	
	public TileEntityCampfire(int feulmultiply, boolean neednofeul, int cooktime) 
	{
		feul=feulmultiply;
		nofeul=neednofeul;
		cook=cooktime;
	}
	    
	@Override
	public int getSizeInventory() 
	{
		return 0;
	}

	public int getInventoryStackLimit()
    {
        return 64;
    }
	  
	@Override
	public ItemStack getStackInSlot(int var1) 
	{
		return null;
	}

    public String getInvName()
    {
        return "container.furnace";
    }
    
	@Override
	public ItemStack decrStackSize(int var1, int var2) 
	{
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) 
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) 
	{
		
	}

	public void openChest() {}
	public void closeChest() {}

	public int getStartInventorySide(ForgeDirection side) 
	{	
		if (side == ForgeDirection.DOWN) return 1;
        if (side == ForgeDirection.UP) return 0; 
        return 2;
	}

	public int getSizeInventorySide(ForgeDirection side) 
	{
		return 1;
	}
	
    public int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
        	if (nofeul==true)
        	{
        		return cook;
        	}
        	else 
        	{
        		return 0;
        	}
        }
        else
        {
            int var1 = par0ItemStack.getItem().itemID;
            Item var2 = par0ItemStack.getItem();

			if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[var1] != null)
            {
                Block var3 = Block.blocksList[var1];

                if (var3 == Block.woodSingleSlab)
                {
                    return 1*feul;
                }

                if (var3.blockMaterial == Material.wood)
                {
                    return 2*feul;
                }
            }
            if (var2 instanceof ItemTool && ((ItemTool) var2).getToolMaterialName().equals("WOOD")) return 2*feul;
            if (var2 instanceof ItemSword && ((ItemSword) var2).getToolMaterialName().equals("WOOD")) return 2*feul;
            if (var2 instanceof ItemHoe && ((ItemHoe) var2).func_77842_f().equals("WOOD")) return 2*feul;
            if (var1 == Item.stick.itemID) return 1*feul;
            if (var1 == Item.coal.itemID) return 16*feul;
            if (var1 == Item.bucketLava.itemID) return 200*feul;
            if (var1 == Block.sapling.blockID) return 1*feul;
            if (var1 == Item.blazeRod.itemID) return 24*feul;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }

    public boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }
}
