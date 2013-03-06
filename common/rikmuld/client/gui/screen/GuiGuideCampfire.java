package rikmuld.client.gui.screen;

import net.minecraft.client.gui.GuiScreen;

public class GuiGuideCampfire extends GuiScreen{

	public GuiGuideCampfire()
	{
		
	}

	public void initGui()
	{
		controlList.clear();
	}

	public void drawScreen(int i, int j, float f)
	{
		drawDefaultBackground();		 
		
		drawCenteredString(fontRenderer, "Elrik's guide to lost knowledge", width / 2, height /2 - 100, 0xffffff);
		super.drawScreen(i, j, f);
	}
}
