package rikmuld.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import rikmuld.inventory.inventory.InventoryCampingBagSmall;
import rikmuld.inventory.slot.BackpackSlot;
import rikmuld.item.tool.ToolBackpack;

public class ContainerCampingBagSmall extends Container {
	
	private ItemStack thebackpack;
	private InventoryCampingBagSmall invBack;

	public ContainerCampingBagSmall(IInventory playerInventory, InventoryCampingBagSmall backpackInventoryS, ItemStack backpack) {

		int var3;
		
		backpackInventoryS.openChest();
		
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 0, 62, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 1, 80, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 2, 98, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 3, 62, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 4, 80, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 5, 98, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 6, 62, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 7, 80, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryS, 8, 98, 54));


		for (var3 = 0; var3 < 3; ++var3) 
		{
			for (int var4 = 0; var4 < 9; ++var4) 
			{
				this.addSlotToContainer(new Slot(playerInventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) 
		{
			this.addSlotToContainer(new Slot(playerInventory, var3, 8 + var3 * 18, 142));
		}
	
		thebackpack = backpack;
		invBack = backpackInventoryS;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotPos) 
	{
        ItemStack returnStack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotPos);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack = slot.getStack();
            if ((itemStack.getItem() instanceof ToolBackpack)) {
    	        return returnStack;
            }
            returnStack = itemStack.copy();

            if (slotPos < 3 * 9) {
                if (!this.mergeItemStack(itemStack, 3 * 9, inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemStack, 0, 3 * 9, false)) {
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