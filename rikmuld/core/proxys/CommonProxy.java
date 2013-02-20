package camping.common.rikmuld.core.proxys;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import camping.common.rikmuld.client.gui.GuiCampfireCheapCooker;
import camping.common.rikmuld.client.gui.GuiCampfireFastCooker;
import camping.common.rikmuld.client.gui.GuiCampfireMultiCooker;
import camping.common.rikmuld.client.gui.GuiCampingBagLarge;
import camping.common.rikmuld.client.gui.GuiCampingBagNormal;
import camping.common.rikmuld.client.gui.GuiCampingBagSmall;
import camping.common.rikmuld.client.gui.GuiTent;
import camping.common.rikmuld.core.lib.GuiIds;
import camping.common.rikmuld.inventory.container.ContainerCampfireCheapCooker;
import camping.common.rikmuld.inventory.container.ContainerCampfireFastCooker;
import camping.common.rikmuld.inventory.container.ContainerCampfireMultiCooker;
import camping.common.rikmuld.inventory.container.ContainerCampingBagLarge;
import camping.common.rikmuld.inventory.container.ContainerCampingBagNormal;
import camping.common.rikmuld.inventory.container.ContainerCampingBagSmall;
import camping.common.rikmuld.inventory.container.ContainerTent;
import camping.common.rikmuld.item.tool.ToolBackpack;
import camping.common.rikmuld.tileentity.TileEntityCampfireCheapCooker;
import camping.common.rikmuld.tileentity.TileEntityCampfireFastCooker;
import camping.common.rikmuld.tileentity.TileEntityCampfireMultiCooker;
import camping.common.rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	public void initRenderingAndTextures() {} 
	public void registerRenderers() {}
	public void registerTileEntitySpecialRenderer(TileEntity tileentity){}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if(tileEntity instanceof TileEntityCampfireMultiCooker)
		{
				return new ContainerCampfireMultiCooker(player.inventory, (TileEntityCampfireMultiCooker) tileEntity);
		}
		
		if(tileEntity instanceof TileEntityCampfireFastCooker)
		{
				return new ContainerCampfireFastCooker(player.inventory, (TileEntityCampfireFastCooker) tileEntity);
		}
		if(tileEntity instanceof TileEntityCampfireCheapCooker)
		{
				return new ContainerCampfireCheapCooker(player.inventory, (TileEntityCampfireCheapCooker) tileEntity);
		}
		if(tileEntity instanceof TileEntityTent)
		{
				return new ContainerTent(player.inventory, (TileEntityTent) tileEntity);
		}
		if (ID == GuiIds.GUICampingBagLarge) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagLarge(player.inventory, ToolBackpack.getBackpackInv(player), backpack);
		}
		if (ID == GuiIds.GUICampingBagNormal) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagNormal(player.inventory, ToolBackpack.getBackpackInv(player), backpack);
		}
		if (ID == GuiIds.GUICampingBagSmall) 
		{
			ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagSmall(player.inventory, ToolBackpack.getBackpackInv(player), backpack);
     	}
		return null;
	
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityCampfireMultiCooker)
		{
				return new GuiCampfireMultiCooker(player.inventory, (TileEntityCampfireMultiCooker) tileEntity);
		}
		if(tileEntity instanceof TileEntityCampfireFastCooker)
		{
				return new GuiCampfireFastCooker(player.inventory, (TileEntityCampfireFastCooker) tileEntity);
		}
		if(tileEntity instanceof TileEntityCampfireCheapCooker)
		{
				return new GuiCampfireCheapCooker(player.inventory, (TileEntityCampfireCheapCooker) tileEntity);
		}
		if(tileEntity instanceof TileEntityTent)
		{
				return new GuiTent(player.inventory, (TileEntityTent) tileEntity);
		}
		
		if (ID == GuiIds.GUICampingBagLarge) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new GuiCampingBagLarge(player.inventory, ToolBackpack.getBackpackInv(player));
	    }
		if (ID == GuiIds.GUICampingBagNormal) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new GuiCampingBagNormal(player.inventory, ToolBackpack.getBackpackInv(player));
	    }
		if (ID == GuiIds.GUICampingBagSmall) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new GuiCampingBagSmall(player.inventory, ToolBackpack.getBackpackInv(player));
	    }
		return null;	
	}
}
