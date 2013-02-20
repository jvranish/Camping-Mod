package camping.common.rikmuld.inventory.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryCampingBagLarge extends InventoryBasic {

	private String inventoryTitle;

	private EntityPlayer playerEntity;

	private ItemStack originalIS;

	private boolean reading = false;

	public InventoryCampingBagLarge(EntityPlayer player, ItemStack is) 
	{
		super("", getInventorySize(is));
		
		playerEntity = player;
		originalIS = is;

		if (!hasInventory(is.getTagCompound())) 
		{
			createInventory();
		}
		loadInventory();
	}

	
	@Override
	public void onInventoryChanged() 
	{
		super.onInventoryChanged();
		saveInventory();
	}

	@Override
	public void openChest() 
	{
		loadInventory();
	}

	@Override
	public void closeChest() 
	{
		saveInventory();
	}

	protected static int getInventorySize(ItemStack is)
	{
		return 9 * 3;
	}

	private boolean hasInventory(NBTTagCompound nbt)
	{
		return (nbt != null && (nbt.hasKey("Inventory")));
	}

	private void createInventory() 
	{
		NBTTagCompound tag;
		if (originalIS.hasTagCompound())
		{
			tag = originalIS.getTagCompound();
		} 
		
		else 
		{
			tag = new NBTTagCompound();
		}
		
		writeToNBT(tag);
		originalIS.setTagCompound(tag);
	}
	
	private void setNBT() 
	{
		if(playerEntity.getCurrentEquippedItem() != null) 
		{
			playerEntity.getCurrentEquippedItem().setTagCompound(originalIS.getTagCompound());
		}
	}

	public void loadInventory() 
	{
		readFromNBT(originalIS.getTagCompound());
	}

	public void saveInventory() 
	{
		writeToNBT(originalIS.getTagCompound());
		setNBT();
	}

	private NBTTagCompound writeToNBT(NBTTagCompound outerTag) 
	{
		if (outerTag == null) 
		{
			return null;
		}

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) 
		{
			if (getStackInSlot(i) != null) 
			{
				NBTTagCompound slotEntry = new NBTTagCompound();
				slotEntry.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(slotEntry);
				itemList.appendTag(slotEntry);
			}
		}

		NBTTagCompound inventory = new NBTTagCompound();
		inventory.setTag("Items", itemList);
		outerTag.setCompoundTag("Inventory", inventory);
		return outerTag;
	}

	private void readFromNBT(NBTTagCompound outerTag) 
	{
		if (outerTag == null) 
		{
			return;
		}
		reading = true;
		
		NBTTagList itemList = outerTag.getCompoundTag("Inventory").getTagList("Items");
	
		for (int i = 0; i < itemList.tagCount(); i++) 
		{
			NBTTagCompound slotEntry = (NBTTagCompound) itemList.tagAt(i);
			int j = slotEntry.getByte("Slot") & 0xff;

			if (j >= 0 && j < getSizeInventory()) 
			{
				setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(slotEntry));
			}
		}
		reading = false;
	}
}