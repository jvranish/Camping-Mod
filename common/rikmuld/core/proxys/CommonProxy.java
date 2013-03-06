package rikmuld.core.proxys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import rikmuld.client.gui.GuiCampfireCheapCooker;
import rikmuld.client.gui.GuiCampfireFastCooker;
import rikmuld.client.gui.GuiCampfireMultiCooker;
import rikmuld.client.gui.GuiCampingBagLarge;
import rikmuld.client.gui.GuiCampingBagNormal;
import rikmuld.client.gui.GuiCampingBagSmall;
import rikmuld.client.gui.GuiTent;
import rikmuld.client.gui.screen.GuiGuideCampfire;
import rikmuld.client.gui.screen.GuiGuideEquipment;
import rikmuld.client.gui.screen.GuiGuideFood;
import rikmuld.client.gui.screen.GuiGuideTent;
import rikmuld.client.gui.screen.GuiGuideWorld;
import rikmuld.core.lib.GuiIds;
import rikmuld.inventory.container.ContainerCampfireCheapCooker;
import rikmuld.inventory.container.ContainerCampfireFastCooker;
import rikmuld.inventory.container.ContainerCampfireMultiCooker;
import rikmuld.inventory.container.ContainerCampingBagLarge;
import rikmuld.inventory.container.ContainerCampingBagNormal;
import rikmuld.inventory.container.ContainerCampingBagSmall;
import rikmuld.inventory.container.ContainerTent;
import rikmuld.inventory.inventory.InventoryCampingBagLarge;
import rikmuld.inventory.inventory.InventoryCampingBagNormal;
import rikmuld.inventory.inventory.InventoryCampingBagSmall;
import rikmuld.item.tool.ToolBackpack;
import rikmuld.tileentity.TileEntityCampfireCheapCooker;
import rikmuld.tileentity.TileEntityCampfireFastCooker;
import rikmuld.tileentity.TileEntityCampfireMultiCooker;
import rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	public void initRenderingAndTextures() {} 
	public void registerRenderers() {}
	public void registerTileEntitySpecialRenderer(TileEntity tileentity){}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if(ID == GuiIds.GuiCampfireMultiCooker)
		{
				return new ContainerCampfireMultiCooker(player.inventory, (TileEntityCampfireMultiCooker) tileEntity);
		}
		if(ID == GuiIds.GuiCampfireFastCooker)
		{
				return new ContainerCampfireFastCooker(player.inventory, (TileEntityCampfireFastCooker) tileEntity);
		}
		if(ID == GuiIds.GuiCampfireCheapCooker)
		{
				return new ContainerCampfireCheapCooker(player.inventory, (TileEntityCampfireCheapCooker) tileEntity);
		}
		if(ID == GuiIds.GuiTent)
		{
				return new ContainerTent(player.inventory, (TileEntityTent) tileEntity);
		}
		if (ID == GuiIds.GUICampingBagLarge) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagLarge(player.inventory, (InventoryCampingBagLarge) ToolBackpack.getBackpackInv(player), backpack);
		}
		if (ID == GuiIds.GUICampingBagNormal) 
		{
		 	ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagNormal(player.inventory, (InventoryCampingBagNormal) ToolBackpack.getBackpackInv(player), backpack);
		}
		if (ID == GuiIds.GUICampingBagSmall) 
		{
			ItemStack backpack = player.getCurrentEquippedItem();
            return new ContainerCampingBagSmall(player.inventory, (InventoryCampingBagSmall) ToolBackpack.getBackpackInv(player), backpack);
     	}
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if(ID == GuiIds.GuiCampfireMultiCooker)
		{
				return new GuiCampfireMultiCooker(player.inventory, (TileEntityCampfireMultiCooker) tileEntity);
		}
		if(ID == GuiIds.GuiCampfireFastCooker)
		{
				return new GuiCampfireFastCooker(player.inventory, (TileEntityCampfireFastCooker) tileEntity);
		}
		if(ID == GuiIds.GuiCampfireCheapCooker)
		{
				return new GuiCampfireCheapCooker(player.inventory, (TileEntityCampfireCheapCooker) tileEntity);
		}
		if(ID == GuiIds.GuiTent)
		{
				return new GuiTent(player.inventory, (TileEntityTent) tileEntity);
		}
		
		if (ID == GuiIds.GUICampingBagLarge) 
		{
            return new GuiCampingBagLarge(player.inventory, (InventoryCampingBagLarge) ToolBackpack.getBackpackInv(player));
	    }
		if (ID == GuiIds.GUICampingBagNormal) 
		{
            return new GuiCampingBagNormal(player.inventory, (InventoryCampingBagNormal) ToolBackpack.getBackpackInv(player));
	    }
		if (ID == GuiIds.GUICampingBagSmall) 
		{
            return new GuiCampingBagSmall(player.inventory, (InventoryCampingBagSmall) ToolBackpack.getBackpackInv(player));
	    }	
		if (ID == GuiIds.GUIGuideCampfire) 
		{
            return new GuiGuideCampfire();
	    }
		if (ID == GuiIds.GUIGuideTent) 
		{
            return new GuiGuideTent();
	    }
		if (ID == GuiIds.GUIGuideEquipment) 
		{
            return new GuiGuideEquipment();
	    }
		if (ID == GuiIds.GUIGuideFood) 
		{
            return new GuiGuideFood();
	    }
		if (ID == GuiIds.GUIGuideWorld) 
		{
            return new GuiGuideWorld();
	    }
		return null;	
	}
}
