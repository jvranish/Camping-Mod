package rikmuld.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import rikmuld.tileentity.TileEntityTent;

public class ContainerTent extends Container {
	
	private TileEntityTent campfire;

	public ContainerTent(InventoryPlayer par1InventoryPlayer, TileEntityTent par2TileEntitycampfire) 
	{
		campfire = par2TileEntitycampfire;
		int var3;

		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 0, 8, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 1, 26, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 2, 44, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 3, 62, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 4, 80, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 5, 98, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 6, 116, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 7, 134, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 8, 152, 7));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 9, 8, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 10, 26, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 11, 44, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 12, 62, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 13, 80, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 14, 98, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 15, 116, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 16, 134, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 17, 152, 25));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 18, 8, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 19, 26, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 20, 44, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 21, 62, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 22, 80, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 23, 98, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 24, 116, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 25, 134, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 26, 152, 43));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 27, 8, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 28, 26, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 29, 44, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 30, 62, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 31, 80, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 32, 98, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 33, 116, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 34, 134, 61));
		this.addSlotToContainer(new Slot(par2TileEntitycampfire, 35, 152, 61));

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

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) 
	{
		return this.campfire.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer p, int i) 
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(i);
		if (slot != null && slot.getHasStack()) 
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (i < 36) 
			{
				if (!mergeItemStack(itemstack1, 36, inventorySlots.size(), true)) 
				{
					return null;
				}
			} 
			
			else if (!mergeItemStack(itemstack1, 0, 36, false)) 
			{
				return null;
			}
			
			if (itemstack1.stackSize == 0) 
			{
				slot.putStack(null);
			} 
			
			else 
			{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}