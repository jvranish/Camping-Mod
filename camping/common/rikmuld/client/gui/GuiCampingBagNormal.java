package camping.common.rikmuld.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.inventory.container.ContainerCampingBagNormal;
import camping.common.rikmuld.inventory.inventory.InventoryCampingBagNormal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCampingBagNormal extends GuiContainer {
	
	private InventoryCampingBagNormal backInventory;
    
	public GuiCampingBagNormal(InventoryPlayer par1InventoryPlayer,	InventoryCampingBagNormal iInventory) 
	{
		super(new ContainerCampingBagNormal(par1InventoryPlayer, iInventory, null));
		backInventory = iInventory;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Camping Bag", 58, 6, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int var4 = this.mc.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_BAG_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(var4);
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);	
	}
	
	protected void keyTyped(char par1, int par2) 
	{
		if (par2 == 18 || par2 == 1) 
		{
			super.mc.setIngameFocus();
		}
	}

}