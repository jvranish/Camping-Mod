package rikmuld.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import rikmuld.item.tool.ToolBackpack;

public class BackpackSlot extends Slot {
	
	public BackpackSlot(IInventory inventory, int slotIndex, int xPos, int yPos) 
	{
		super(inventory, slotIndex, xPos, yPos);
	}

	public boolean isItemValid(ItemStack is) 
	{
        return (is != null && is.getItem() instanceof ToolBackpack) ? false : true;
    }
}