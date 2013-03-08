package rikmuld.client.gui.screen;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.opengl.GL11;

import rikmuld.client.gui.button.GuiButtonUniversalSprite;
import rikmuld.client.gui.button.GuiButtonGuidePage;
import rikmuld.core.lib.Textures;

public class GuiGuide extends GuiScreen{
    
	private int bookImageWidth = 188;
    private int bookImageHeight = 192;
    private GuiButtonGuidePage buttonNextPage;
    private GuiButtonGuidePage buttonPreviousPage;
    private int BookPages;
    private int BookPagesTotaal = 15;
    private GuiButtonUniversalSprite buttonIcon;

	public void initGui()
	{
		controlList.clear();
	    addButtonByPage(BookPages);
		int var1 = (this.width - this.bookImageWidth) / 2;
		int var2 = (this.height - this.bookImageHeight) / 2;
        this.controlList.add(this.buttonNextPage = new GuiButtonGuidePage(0, var1 + 132, var2 + 140, true));
        this.controlList.add(this.buttonPreviousPage = new GuiButtonGuidePage(1, var1 + 26, var2 + 140, false));
	}
	
	private void addImgByPage(int page) 
	{
		if(page==0)
		{
			this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2)+22, ((this.height - this.bookImageHeight) / 2)+11, 0, 240, 136, 15);
		}
	}

	private void addButtonByPage(int page) {}
	private void addTextByPage(int page) {}

	@Override
	public void actionPerformed(GuiButton button)
	{
		if(button.id==0&&BookPages<BookPagesTotaal) 
		{
			BookPages+=1;
		}
		
		if(button.id==1&&BookPages>0)
		{
			BookPages-=1;
		}
		this.updateScreen();
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		 int var4 = this.mc.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_BOOK_GUIDE);
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 this.mc.renderEngine.bindTexture(var4);
		 int var5 = (this.width - this.bookImageWidth) / 2;
		 int var6 = ((this.height - this.bookImageHeight) / 2)-10;
		 this.drawTexturedModalRect(var5, var6, 0, 0, this.bookImageWidth, this.bookImageHeight);
		 int var1 = (this.width - this.bookImageWidth) / 2;
		 int var2 = (this.height - this.bookImageHeight) / 2;
		 int var3 = 0;
	     addTextByPage(BookPages);
	     addImgByPage(BookPages);
		 if(BookPages>=9)
		 {
			 var3 = 4;
		 }
		 drawString(fontRenderer,Integer.toString(BookPages+1), var1+89-var3, var2 + 145, 4210752);
	     super.drawScreen(par1, par2, par3);
	}
}
