package camping.common.rikmuld.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;

import org.lwjgl.opengl.GL11;

import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.inventory.container.ContainerCampingBagLarge;
import camping.common.rikmuld.inventory.inventory.InventoryCampingBagLarge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCampingBagLarge extends GuiContainer {
	
	private InventoryCampingBagLarge backInventory;
    
	public GuiCampingBagLarge(InventoryPlayer par1InventoryPlayer,	IInventory iInventory) 
	{
		super(new ContainerCampingBagLarge(par1InventoryPlayer, iInventory, null));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Large Camping Bag", 40, 6, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int var4 = this.mc.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_BAG_LARGE);
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