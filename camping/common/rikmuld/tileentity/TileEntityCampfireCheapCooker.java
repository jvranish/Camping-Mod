package camping.common.rikmuld.tileentity;

import java.util.Random;
import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.core.register.ModLogger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public final class TileEntityCampfireCheapCooker extends TileEntityCampfire{

	private int cook = 800;
	int colorcc;
	int colormetacc;
	
    public TileEntityCampfireCheapCooker() 
    {
		super(1, true, 800);
	}

	private ItemStack[] campfireItemStacks = new ItemStack[5];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    Random generator = new Random();

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
	    
	    this.colorcc =  par1NBTTagCompound.getInteger("colorcc");
	    this.colormetacc =  par1NBTTagCompound.getInteger("colormetacc");
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
        this.currentItemBurnTime = getItemBurnTime(this.campfireItemStacks[4]);
        
    	ModBlocks.campfireCheapCooker.setColor(colorcc, colormetacc);
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
		int colorcc = ModBlocks.campfireCheapCooker.getColor();
		int colormetacc = ModBlocks.campfireCheapCooker.getColorMeta();
		
	    par1NBTTagCompound.setInteger("colorcc", colorcc);
	    par1NBTTagCompound.setInteger("colormetacc", colormetacc);
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
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.campfireItemStacks[4]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.campfireItemStacks[4] != null)
                    {
                        --this.campfireItemStacks[4].stackSize;

                        if (this.campfireItemStacks[4].stackSize == 0)
                        {
                            this.campfireItemStacks[4] = this.campfireItemStacks[4].getItem().getContainerItemStack(campfireItemStacks[4]);
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
                ModBlocks.campfireCheapCooker.updateCampfireBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
    	if (this.campfireItemStacks[0] !=  null||this.campfireItemStacks[1] !=  null)
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
			
			if (this.campfireItemStacks[0] !=  null)
			{   			
				ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[0]);
				if (this.campfireItemStacks[2] == null) return true;
				if (!this.campfireItemStacks[2].isItemEqual(var1)) return false;
				int result = campfireItemStacks[2].stackSize + var1.stackSize;
				return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
			}

			if (this.campfireItemStacks[1] !=  null)
			{ 
				ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.campfireItemStacks[1]);
	            if (this.campfireItemStacks[3] == null) return true;
	            if (!this.campfireItemStacks[3].isItemEqual(var1)) return false;
	            int result = campfireItemStacks[3].stackSize + var1.stackSize;
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
            
            if (this.campfireItemStacks[0] !=  null)
            {   
            	int change = generator.nextInt(100) + 1;

            	if (change<15)
            	{      		 
            		if (this.campfireItemStacks[2] == null)
                    {
                        this.campfireItemStacks[2] = var1.copy();
                        campfireItemStacks[2].stackSize += var1.stackSize;
                    }
                    else if (this.campfireItemStacks[2].isItemEqual(var1))
                    {
                        campfireItemStacks[2].stackSize += var1.stackSize+1;
                    }   
            	}

            	if (change>=15)
            	{
	                if (this.campfireItemStacks[2] == null)
	                {
	                    this.campfireItemStacks[2] = var1.copy();
	                }
	                else if (this.campfireItemStacks[2].isItemEqual(var1))
	                {
	                    campfireItemStacks[2].stackSize += var1.stackSize;
	                }                
            	}

                if (change<75)
                {
    	            --this.campfireItemStacks[0].stackSize;
    	        }

                if (this.campfireItemStacks[0].stackSize <= 0)
                {
                    this.campfireItemStacks[0] = null;
                }	  
            }
        

            if (this.campfireItemStacks[1] !=  null)
            {   
            	int change = generator.nextInt(100) + 1;

            	if (change<15)
            	{      		 
            		if (this.campfireItemStacks[3] == null)
                    {
                        this.campfireItemStacks[3] = var2.copy();
                        campfireItemStacks[3].stackSize += var2.stackSize;
                    }
                    else if (this.campfireItemStacks[3].isItemEqual(var2))
                    {
                        campfireItemStacks[3].stackSize += var2.stackSize+1;
                    }   
            	}

            	if (change>=15)
            	{
	                if (this.campfireItemStacks[3] == null)
	                {
	                    this.campfireItemStacks[3] = var2.copy();
	                }
	                else if (this.campfireItemStacks[3].isItemEqual(var2))
	                {
	                    campfireItemStacks[3].stackSize += var2.stackSize;
	                }                
            	}

                if (change<75)
                {
    	            --this.campfireItemStacks[1].stackSize;
    	        }

                if (this.campfireItemStacks[1].stackSize <= 0)
                {
                    this.campfireItemStacks[1] = null;
                }	  
            }	
        }
    }
    
    
    @Override
	public int getStartInventorySide(ForgeDirection side) 
	{	
		if (side == ForgeDirection.DOWN) return 2;
        else 
        {
            return 0;	
        }
	}

    @Override
	public int getSizeInventorySide(ForgeDirection side) 
	{
    	return 2;	
	}
}
