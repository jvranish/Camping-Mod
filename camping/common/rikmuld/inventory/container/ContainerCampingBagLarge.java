package camping.common.rikmuld.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.inventory.inventory.InventoryCampingBagLarge;
import camping.common.rikmuld.inventory.slot.BackpackSlot;
import camping.common.rikmuld.item.tool.ToolBackpack;

public class ContainerCampingBagLarge extends Container {
	
	private ItemStack thebackpack;
	private InventoryCampingBagLarge backInv;

	public ContainerCampingBagLarge(IInventory playerInventory, InventoryCampingBagLarge backpackInventoryL, ItemStack backpack) {

		int var3;
		
		backpackInventoryL.openChest();
		
		for (int row = 0; row < 3; ++row) for (int col = 0; col < 9; ++col) 
		{
			this.addSlotToContainer(new BackpackSlot(backpackInventoryL, col + row * 9, 8 + col * 18, 18 + row * 18));
		}

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
		backInv = backpackInventoryL;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
			return true;
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