package camping.common.rikmuld.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.inventory.slot.BackpackSlot;
import camping.common.rikmuld.item.tool.ToolBackpack;

public class ContainerCampingBagNormal extends Container {
	
	private ItemStack thebackpack;

	public ContainerCampingBagNormal(IInventory playerInventory, IInventory backpackInventoryM, ItemStack backpack) {

		int var3;
		
		backpackInventoryM.openChest();
		
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 0, 36, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 1, 54, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 2, 72, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 3, 90, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 4, 108, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 5, 126, 18));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 6, 36, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 7, 54, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 8, 72, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 9, 90, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 10, 108, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 11, 126, 36));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 12, 36, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 13, 54, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 14, 72, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 15, 90, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 16, 108, 54));
		this.addSlotToContainer(new BackpackSlot(backpackInventoryM, 17, 126, 54));

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
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		if(player.getCurrentEquippedItem() == null) 
		{
			return false;
		}
		
		return player.getCurrentEquippedItem().isItemEqual(thebackpack);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotPos) {
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