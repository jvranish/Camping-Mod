package rikmuld.client.gui.button;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

import rikmuld.core.lib.Textures;

@SideOnly(Side.CLIENT)
public class GuiButtonGuidePage extends GuiButton
{
    private final boolean nextPage;
    private int page;

    public GuiButtonGuidePage(int par1, int par2, int par3, boolean par4, int bookpage)
    {
        super(par1, par2, par3, 23, 13, "");
        this.nextPage = par4;
        page = bookpage;
    }

    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            boolean var4 = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            par1Minecraft.renderEngine.bindTexture(par1Minecraft.renderEngine.getTexture(Textures.GUI_LOCATIONS + Textures.GUI_BOOK_GUIDE));
            int var5 = 0;
            int var6 = 192;

            if ((var4)||(this.nextPage&&page==5)||(!this.nextPage&&page==0))
            {
                var5 += 23;
            }

            if (!this.nextPage)
            {
                var6 += 13;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, var5, var6, 23, 13);
        }
    }
}
