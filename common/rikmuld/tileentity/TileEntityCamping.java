package rikmuld.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCamping extends TileEntity {

	 private byte direction = 0;
	 
	 public TileEntityCamping() 
	 {
		  
	 }
 
	 public byte getDirection() 
	 {
		 return direction;
	 }

	 public void setDirection(byte direction) 
	 {

        this.direction = direction;
	 }
	 
	 public boolean isUseableByPlayer(EntityPlayer player) 
	 {
		 return true;
	 }

	 public void readFromNBT(NBTTagCompound nbtTagCompound) 
	 {
		 super.readFromNBT(nbtTagCompound);
		 direction = nbtTagCompound.getByte("direction");
	 }

	 public void writeToNBT(NBTTagCompound nbtTagCompound) 
	 {
		 super.writeToNBT(nbtTagCompound);
		 nbtTagCompound.setByte("direction", direction);	    
	 }
}
