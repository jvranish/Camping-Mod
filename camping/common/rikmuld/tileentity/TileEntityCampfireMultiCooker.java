package camping.common.rikmuld.tileentity;


import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.core.register.ModLogger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TileEntityCampfireMultiCooker extends TileEntityCampfire 
{
	private int cook = 500;
	int colormc;
	int colormetamc;
	
	public TileEntityCampfireMultiCooker() 
    {
		super(64, false, 500);
	}

    private ItemStack[] campfireItemStacks = new ItemStack[13];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;

    public int getSizeInventory()
    {
        return this.campfireItemStacks.length;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.campfireItemStacks[par1];
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.campfireItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.campfireItemStacks[par1].stackSize <= par2)
            {
                var3 = this.campfireItemStacks[par1];
                this.campfireItemStacks[par1] = null;
                return var3;
            }

            else
            {
                var3 = this.campfireItemStacks[par1].splitStack(par2);

                if (this.campfireItemStacks[par1].stackSize == 0)
                {
                    this.campfireItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.campfireItemStacks[par1] != null)
        {
            ItemStack var2 = this.campfireItemStacks[par1];
            this.campfireItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.campfireItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.campfireItemStacks = new ItemStack[this.getSizeInventory()];
	    this.colormc =  par1NBTTagCompound.getInteger("colormc");
	    this.colormetamc =  par1NBTTagCompound.getInteger("colormetamc");

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.campfireItemStacks.length)
            {
                this.campfireItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.campfireItemStacks[6]);
        ModBlocks.campfireMultiCooker.setColor(colormc, colormetamc);
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
		int colormc = ModBlocks.campfireMultiCooker.getColor();
		int colormetamc = ModBlocks.campfireMultiCooker.getColorMeta();
		
	    par1NBTTagCompound.setInteger("colormc", colormc);
	    par1NBTTagCompound.setInteger("colormetamc", colormetamc);
        par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.campfireItemStacks.length; ++var3)
        {
            if (this.campfireItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.campfireItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }
    
    @SideOnly(Side.CLIENT)

    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / cook;
    }

    @SideOnly(Side.CLIENT)

    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = cook;
        }

        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.campfireItemStacks[6]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.campfireItemStacks[6] != null)
                    {
                        --this.campfireItemStacks[6].stackSize;

                        if (this.campfireItemStacks[6].stackSize == 0)
                        {
                            this.campfireItemStacks[6] = this.campfireItemStacks[6].getItem().getContainerItemStack(campfireItemStacks[6]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == cook)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceBurnTime > 0)
            {
                var2 = true;
                ModBlocks.campfireMultiCooker.updateCampfireBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
		if (this.campfireItemStacks[0] !=  null||this.campfireItemStacks[1] !=  null||this.campfireItemStacks[2] !=  null||this.campfireItemStacks[3] !=  null||this.campfireItemStacks[4] !=  null|this.campfireItemStacks[5] !=  null)
		{
			if (this.campfireItemStacks[0] !=  null)
	    	{
	            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[0]);
	            if (var1 == null) return false;
	    	}
			
			if (this.campfireItemStacks[1] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[1]);
	            if (var1 == null) return false;
	        }
			
			if (this.campfireItemStacks[2] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[2]);
	            if (var1 == null) return false;	          
	        }			
			
	    	if (this.campfireItemStacks[3] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[3]);
	            if (var1 == null) return false;	      
	    	}
	    	
	    	if (this.campfireItemStacks[4] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[4]);
	            if (var1 == null) return false;	          
	    	}

			if (this.campfireItemStacks[5] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[5]);
	    		if (var1 == null) return false;
	    	}
			
	    	if (this.campfireItemStacks[0] !=  null)
	    	{
	            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[0]);
	            if (this.campfireItemStacks[7] == null) return true;
	            if (!this.campfireItemStacks[7].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[7].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	        }
    	
	    	if (this.campfireItemStacks[1] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[1]);
	            if (this.campfireItemStacks[8] == null) return true;
	            if (!this.campfireItemStacks[8].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[8].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	        }
	    	
	     	if (this.campfireItemStacks[2] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[2]);
	            if (this.campfireItemStacks[9] == null) return true;
	            if (!this.campfireItemStacks[9].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[9].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	        }
	     	
	    	if (this.campfireItemStacks[3] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[3]);
	            if (this.campfireItemStacks[10] == null) return true;
	            if (!this.campfireItemStacks[10].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[10].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	    	}

	      	if (this.campfireItemStacks[4] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[4]);
	            if (this.campfireItemStacks[11] == null) return true;
	            if (!this.campfireItemStacks[11].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[11].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	    	}
	    	
	    	if (this.campfireItemStacks[5] !=  null)
	    	{
	    		ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[5]);
		    	if (this.campfireItemStacks[12] == null) return true;
		    	if (!this.campfireItemStacks[12].isItemEqual(var1)) return false;
		    	int result = campfireItemStacks[12].stackSize + var1.stackSize;
		    	return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	    	}
		}
		return false;
	}

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[0]);
            ItemStack var2 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[1]);
         	ItemStack var3 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[2]);
            ItemStack var4 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[3]);
            ItemStack var5 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[4]);
            ItemStack var6 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[5]);

           
            if (this.campfireItemStacks[0] !=  null)
            {	        	          
		        if (this.campfireItemStacks[7] == null)
		        {
		            this.campfireItemStacks[7] = var1.copy();
		        }

		        else if (this.campfireItemStacks[7].isItemEqual(var1))
		        {
		            campfireItemStacks[7].stackSize += var1.stackSize;
		        }

		        --this.campfireItemStacks[0].stackSize;

		        if (this.campfireItemStacks[0].stackSize <= 0)
		        {
		            this.campfireItemStacks[0] = null;
		        }
            }
           
            if (this.campfireItemStacks[1] !=  null)
            {             
                if (this.campfireItemStacks[8] == null)
                {
                    this.campfireItemStacks[8] = var2.copy();
                }

                else if (this.campfireItemStacks[8].isItemEqual(var2))
                {
                    campfireItemStacks[8].stackSize += var2.stackSize;
                }

                --this.campfireItemStacks[1].stackSize;

                if (this.campfireItemStacks[1].stackSize <= 0)
                {
                    this.campfireItemStacks[1] = null;
                }
            }
   
	        if (this.campfireItemStacks[2] !=  null)
	        {
		        if (this.campfireItemStacks[9] == null)
		        {
		            this.campfireItemStacks[9] = var3.copy();
		        }

		        else if (this.campfireItemStacks[9].isItemEqual(var3))
		        {
		            campfireItemStacks[9].stackSize += var3.stackSize;
		        }

		        --this.campfireItemStacks[2].stackSize;

		        if (this.campfireItemStacks[2].stackSize <= 0)
		        {
		            this.campfireItemStacks[2] = null;
		        }
	        }
    
	    	if (this.campfireItemStacks[3] !=  null)
	    	{  		
			  if (this.campfireItemStacks[10] == null)
		      {
		          this.campfireItemStacks[10] = var4.copy();
		      }

		      else if (this.campfireItemStacks[10].isItemEqual(var4))
		      {
		          campfireItemStacks[10].stackSize += var4.stackSize;
		      }

		      --this.campfireItemStacks[3].stackSize;

		      if (this.campfireItemStacks[3].stackSize <= 0)
		      {
		          this.campfireItemStacks[3] = null;
		      }
	    	}
   
	    	if (this.campfireItemStacks[4] !=  null)
	    	{    		
	      	    if (this.campfireItemStacks[11] == null)
	            {
	                this.campfireItemStacks[11] = var5.copy();
	            }

	            else if (this.campfireItemStacks[11].isItemEqual(var5))
	            {
	                campfireItemStacks[11].stackSize += var5.stackSize;
	            }

	            --this.campfireItemStacks[4].stackSize;

	            if (this.campfireItemStacks[4].stackSize <= 0)
	            {
	                this.campfireItemStacks[4] = null;
	            }
	      	}
		    	
	    	if (this.campfireItemStacks[5] !=  null)
	    	{

	      	  	if (this.campfireItemStacks[12] == null)
	            {
	                this.campfireItemStacks[12] = var6.copy();
	            }
	            else if (this.campfireItemStacks[12].isItemEqual(var6))
	            {
	                campfireItemStacks[12].stackSize += var6.stackSize;
	            }

	            --this.campfireItemStacks[5].stackSize;

	            if (this.campfireItemStacks[5].stackSize <= 0)
	            {
	                this.campfireItemStacks[5] = null;
	            }
		    }
        }         
    }
    
    @Override
	public int getStartInventorySide(ForgeDirection side) 
	{	
		if (side == ForgeDirection.DOWN) return 7;
        if (side == ForgeDirection.UP) return 6; 
        else 
        {
            return 0;	
        }
	}

    @Override
	public int getSizeInventorySide(ForgeDirection side) 
	{
    	if (side == ForgeDirection.DOWN) return 6;
        if (side == ForgeDirection.UP) return 1; 
        else 
        {
            return 6;	
        }
	}
}