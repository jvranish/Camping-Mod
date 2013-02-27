package camping.common.rikmuld.inventory.container;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.item.tool.ToolBackpack;
import camping.common.rikmuld.tileentity.TileEntityCampfireFastCooker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ContainerCampfireFastCooker extends Container
{
    private TileEntityCampfireFastCooker campfire;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerCampfireFastCooker(InventoryPlayer par1InventoryPlayer, TileEntityCampfireFastCooker par2TileEntitycampfire)
    {
        this.campfire = par2TileEntitycampfire;
        this.addSlotToContainer(new Slot(par2TileEntitycampfire, 0, 43, 28));
        this.addSlotToContainer(new Slot(par2TileEntitycampfire, 1, 80, 56));
        this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntitycampfire, 2, 116, 28));
        
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.campfire.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.campfire.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.campfire.currentItemBurnTime);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastCookTime != this.campfire.furnaceCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.campfire.furnaceCookTime);
            }

            if (this.lastBurnTime != this.campfire.furnaceBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.campfire.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.campfire.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.campfire.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.campfire.furnaceCookTime;
        this.lastBurnTime = this.campfire.furnaceBurnTime;
        this.lastItemBurnTime = this.campfire.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.campfire.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.campfire.furnaceBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.campfire.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.campfire.isUseableByPlayer(par1EntityPlayer);
    }
    
    @Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotPos) 
	{
        ItemStack returnStack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotPos);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack = slot.getStack();

            returnStack = itemStack.copy();

            if (slotPos < 1 * 2) {
                if (!this.mergeItemStack(itemStack, 1 * 2, inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemStack, 0, 1 * 2, false)) {
                return null;
            }

            if (itemStack.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
        }

        return returnStack;
    }
}