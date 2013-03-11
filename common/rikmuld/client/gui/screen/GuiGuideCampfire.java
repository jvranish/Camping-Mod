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
		 int var1 = MathHelper.floor_float((this.width - this.bookImageWidth) / 2.2F);
		 int var2 = MathHelper.floor_float((this.height - this.bookImageHeight) / 2.2F);
		 
		 int var3 = MathHelper.floor_float((this.width - this.bookImageWidth) / 1.2F);
		 int var4 = MathHelper.floor_float((this.height - this.bookImageHeight) / 1.2F);
	
		 GL11.glPushMatrix();
		 GL11.glScalef(1.10F, 1.10F, 1.10F);	
		 if(page!=0)
		 {
			 	fontRenderer.drawString("Campfire", var1+47, var2+21, 0x2b2b2b, false);
		 }
		 if(page==1)
		 {		
			 	fontRenderer.drawString("The Decoration", var1+28, var2+11, 0x2b2b2b, false);		 
		 }	
		 if(page==2)
		 {
			 	fontRenderer.drawString("The Multi-Cooking", var1+24, var2+11, 0x2b2b2b, false);
		 }	
		 if(page==3)
		 {
			 	fontRenderer.drawString("The Fast-Cooking", var1+24, var2+11, 0x2b2b2b, false);
		 }
		 if(page==4)
		 {
			 	fontRenderer.drawString("The Cheap-Cooking", var1+21, var2+11, 0x2b2b2b, false);
		 }
		 if(page==5)
		 {
			 	fontRenderer.drawString("The Insta-Cooking", var1+22, var2+11, 0x2b2b2b, false);
		 }
		 GL11.glPopMatrix();
		 
		 GL11.glPushMatrix();
		 GL11.glScalef(0.6F, 0.6F, 0.6F);
		 if(page==1)
		 {
			 fontRenderer.drawString("The Decoration campfire is the first", var3+32, var4+65, 0x2b2b2b, false);
			 fontRenderer.drawString("campfire you can make as a camper.", var3+32, var4+75, 0x2b2b2b, false);
			 fontRenderer.drawString("Every campfire had his one special ", var3+32, var4+85, 0x2b2b2b, false);
			 fontRenderer.drawString("abilities, however evry special campfire", var3+32, var4+95, 0x2b2b2b, false);
			 fontRenderer.drawString("has the abilaties of this one.", var3+32, var4+105, 0x2b2b2b, false);
			 fontRenderer.drawString("Specifications:", var3+32, var4+120, 0x2b2b2b, false);
			 fontRenderer.drawString("Can change 2 sticks into 1 torch.", var3+32, var4+135, 0x2b2b2b, false);
			 fontRenderer.drawString("Has a normal flame particle.", var3+32, var4+145, 0x2b2b2b, false);
			 fontRenderer.drawString("It drops 3 torches by", var3+32, var4+155, 0x2b2b2b, false);
			 fontRenderer.drawString("break, but you can use a", var3+32, var4+165, 0x2b2b2b, false);
			 fontRenderer.drawString("camper's tool to retrieve it.",var3+32, var4+175, 0x2b2b2b, false);
			 fontRenderer.drawString("It will burn entitys.", var3+32, var4+185, 0x2b2b2b, false);
			 fontRenderer.drawString("It lights the environment.", var3+32, var4+195, 0x2b2b2b, false);
			 fontRenderer.drawString("Can be colored with every", var3+32, var4+205, 0x2b2b2b, false);
			 fontRenderer.drawString("minecraft color.", var3+32, var4+215, 0x2b2b2b, false);
		 }
		 if(page==2)
		 {
			 fontRenderer.drawString("The Multi-Cooking campfire is the best", var3+32, var4+65, 0x2b2b2b, false);
			 fontRenderer.drawString("campfire to use if you want to cook", var3+32, var4+75, 0x2b2b2b, false);
			 fontRenderer.drawString("a lot of food, becouse you can cook 6", var3+32, var4+85, 0x2b2b2b, false);
			 fontRenderer.drawString("things at the same time!!", var3+32, var4+95, 0x2b2b2b, false);
			 fontRenderer.drawString("Specifications:", var3+32, var4+110, 0x2b2b2b, false);
			 fontRenderer.drawString("It can cook 6 things at the same time.", var3+32, var4+125, 0x2b2b2b, false);
			 fontRenderer.drawString("it use 1 coal for 3 cook cycles.", var3+32, var4+135, 0x2b2b2b, false);
			 fontRenderer.drawString("It has an gui", var3+32, var4+145, 0x2b2b2b, false);
			 fontRenderer.drawString("Has a green flame particle.", var3+32, var4+155, 0x2b2b2b, false);
			 fontRenderer.drawString("It cooks 2,5 times slower", var3+32, var4+165, 0x2b2b2b, false);
			 fontRenderer.drawString("than a regular furnage.", var3+32, var4+175, 0x2b2b2b, false);
		 }
		 if(page==3)
		 {
			 fontRenderer.drawString("The Fast-Cooking campfire is the best", var3+32, var4+65, 0x2b2b2b, false);
			 fontRenderer.drawString("campfire to use if you want to cook", var3+32, var4+75, 0x2b2b2b, false);
			 fontRenderer.drawString("very fast, becouse you can cook 5", var3+32, var4+85, 0x2b2b2b, false);
			 fontRenderer.drawString("times faster then normal!!", var3+32, var4+95, 0x2b2b2b, false);
			 fontRenderer.drawString("Specifications:", var3+32, var4+110, 0x2b2b2b, false);
			 fontRenderer.drawString("It can cook 1 thing at the same time.", var3+32, var4+125, 0x2b2b2b, false);
			 fontRenderer.drawString("it use 1 coal for 5 cook cycles.", var3+32, var4+135, 0x2b2b2b, false);
			 fontRenderer.drawString("It has an gui", var3+32, var4+145, 0x2b2b2b, false);
			 fontRenderer.drawString("Has a blue flame particle.", var3+32, var4+155, 0x2b2b2b, false);
			 fontRenderer.drawString("It cooks 5 times faster", var3+32, var4+165, 0x2b2b2b, false);
			 fontRenderer.drawString("than a regular furnage.", var3+32, var4+175, 0x2b2b2b, false);
		 }
		 if(page==4)
		 {
			 fontRenderer.drawString("The Cheap-Cooking campfire is the best", var3+32, var4+65, 0x2b2b2b, false);
			 fontRenderer.drawString("campfire to save you some coal and", var3+32, var4+75, 0x2b2b2b, false);
			 fontRenderer.drawString("get the best out of your ores with", var3+32, var4+85, 0x2b2b2b, false);
			 fontRenderer.drawString("the newest enderpearl technolgy!!", var3+32, var4+95, 0x2b2b2b, false);
			 fontRenderer.drawString("Specifications:", var3+32, var4+110, 0x2b2b2b, false);
			 fontRenderer.drawString("It can cook 2 things at the same time.", var3+32, var4+125, 0x2b2b2b, false);
			 fontRenderer.drawString("it doesn't use any coal.", var3+32, var4+135, 0x2b2b2b, false);
			 fontRenderer.drawString("It has an gui", var3+32, var4+145, 0x2b2b2b, false);
			 fontRenderer.drawString("Has a gray flame particle.", var3+32, var4+155, 0x2b2b2b, false);
			 fontRenderer.drawString("It cooks 5 times slower", var3+32, var4+165, 0x2b2b2b, false);
			 fontRenderer.drawString("than a regular furnage.", var3+32, var4+175, 0x2b2b2b, false);
			 fontRenderer.drawString("Couse of the enderpearl", var3+32, var4+185, 0x2b2b2b, false);
			 fontRenderer.drawString("technologie you have a 15%", var3+32, var4+195, 0x2b2b2b, false);
			 fontRenderer.drawString("change that your output get", var3+32, var4+205, 0x2b2b2b, false);
			 fontRenderer.drawString("doubled, and a 25% that your", var3+32, var4+215, 0x2b2b2b, false);
			 fontRenderer.drawString("imput will stay after a cook cycle", var3+32, var4+225, 0x2b2b2b, false);
		 }
		 if(page==5)
		 {
			 fontRenderer.drawString("The Insta-Cooking campfire is the best", var3+32, var4+65, 0x2b2b2b, false);
			 fontRenderer.drawString("campfire for just everything.", var3+32, var4+75, 0x2b2b2b, false);
			 fontRenderer.drawString("You can cook things instandly!!", var3+32, var4+85, 0x2b2b2b, false);
			 fontRenderer.drawString("however you can only cook food with it.", var3+32, var4+95, 0x2b2b2b, false);
			 fontRenderer.drawString("Specifications:", var3+32, var4+110, 0x2b2b2b, false);
			 fontRenderer.drawString("It can cook a stack at ones", var3+32, var4+125, 0x2b2b2b, false);
			 fontRenderer.drawString("it doesn't use any coal.", var3+32, var4+135, 0x2b2b2b, false);
			 fontRenderer.drawString("Has a red flame particle.", var3+32, var4+145, 0x2b2b2b, false);
			 fontRenderer.drawString("It cooks food instandly,", var3+32, var4+155, 0x2b2b2b, false);
			 fontRenderer.drawString("with just a right click", var3+32, var4+165, 0x2b2b2b, false);	 
		 }
		 GL11.glPopMatrix();
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
			 int a = 0;
			 
			 for(int i=1; i<6;i++)
			 {	 
				if(page==i)
				{
					this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+108, ((this.height - this.bookImageHeight) / 2)+85, a+i, 0, 50, 50);
					this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+131, ((this.height - this.bookImageHeight) / 2)+8, a+i, 51, 23, 25);					 
				} 
				a+=50;	
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
