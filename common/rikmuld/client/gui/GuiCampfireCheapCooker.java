package rikmuld.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import rikmuld.core.lib.Textures;
import rikmuld.inventory.container.ContainerCampfireCheapCooker;
import rikmuld.tileentity.TileEntityCampfireCheapCooker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiCampfireCheapCooker extends GuiContainer {
	
	private TileEntityCampfireCheapCooker campfireInventory;
	
	public GuiCampfireCheapCooker(InventoryPlayer par1InventoryPlayer, TileEntityCampfireCheapCooker par2TileEntitycampfire)
	{
		super(new ContainerCampfireCheapCooker(par1InventoryPlayer, par2TileEntitycampfire));
	    this.campfireInventory = par2TileEntitycampfire;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Cheap Cooker", 57, 6, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_CAMPFIRE_CHEAP);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.campfireInventory.isBurning())
        {
            var7 = this.campfireInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 146, var6 + 37 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }
        
        if (this.campfireInventory.isBurning())
        {
            var7 = this.campfireInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 15, var6 + 37 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }
        
        var7 = this.campfireInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 74, var6 + 38, 176, 14, var7 + 1, 16);
    
    }
	
	@SideOnly(Side.CLIENT)
	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 18 || par2 == 1)
		{
			super.mc.setIngameFocus();
		}
	}
}	