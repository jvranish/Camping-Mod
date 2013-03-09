package rikmuld.client.gui.screen;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import rikmuld.client.gui.button.GuiButtonGuideButton;
import rikmuld.core.lib.Textures;

public class GuiGuideCampfire extends GuiGuide { 
	
	public GuiGuideCampfire()
	{
		this.BookPagesTotaal = 5;
	}
	
	@Override
	public void addTextByPage(int page)
	{
		if(page==1)
		{
			 int var1 = MathHelper.floor_float((this.width - this.bookImageWidth) / 2.4F);
			 int var2 = MathHelper.floor_float((this.height - this.bookImageHeight) / 2.4F);
			 GL11.glPushMatrix();
			 GL11.glScalef(1.2F, 1.2F, 1.2F);
			 drawString(fontRenderer,"The Decoration", var1+20, var2+11, 0x3b3b3b);
			 drawString(fontRenderer,"Campfire", var1+39, var2+21, 0x3b3b3b);
			 GL11.glPopMatrix();
	    }
	}
	
	@Override
	public void addImgByPage(int page) 
	{
		if(page==0)
		{
			this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+50, ((this.height - this.bookImageHeight) / 2)+28, 49, 194, 82, 12);
		}
		else
		{
			 this.mc.renderEngine.bindTexture(this.mc.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_COMPONENTS));
			 if(page==1) 
			 {
				 this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+67, ((this.height - this.bookImageHeight) / 2)+75, 0, 0, 50, 50);
				 this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+120, ((this.height - this.bookImageHeight) / 2)+8, 0, 51, 29, 33);
			 }
			 else if (page==2) 
			 {
				 
			 }
		}
	}
	
	@Override
	public void addButtonByPage(int page)
	{
		int var1 = (this.width - this.bookImageWidth) / 2;
		int var2 = (this.height - this.bookImageHeight) / 2;
		
		if(page == 0)
		{
	        this.controlList.add(this.buttonIcon = new GuiButtonGuideButton(2, var1+35, var2+55, 0));
	        this.controlList.add(this.buttonIcon = new GuiButtonGuideButton(3, var1+75, var2+55, 2));
	        this.controlList.add(this.buttonIcon = new GuiButtonGuideButton(4, var1+115, var2+55, 4));
	        this.controlList.add(this.buttonIcon = new GuiButtonGuideButton(5, var1+55, var2+95, 6));
	        this.controlList.add(this.buttonIcon = new GuiButtonGuideButton(6, var1+95, var2+95, 8));
		}
	}
	
	@Override 
	public void triggerButtons(GuiButton button)
	{
		switch(button.id)
		{
			case 2:	this.BookPages = 1;	break;
			case 3:	this.BookPages = 2;	break;
			case 4:	this.BookPages = 3;	break;
			case 5:	this.BookPages = 4;	break;
			case 6:	this.BookPages = 5;	break;
		}
	}
}
