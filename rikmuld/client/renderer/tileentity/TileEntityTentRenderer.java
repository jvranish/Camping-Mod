package camping.common.rikmuld.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import camping.common.rikmuld.client.model.ModelTentNormal;
import camping.common.rikmuld.client.model.ModelTentSleeping;
import camping.common.rikmuld.client.model.ModelTentStorage;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.core.proxys.CommonProxy;
import camping.common.rikmuld.tileentity.TileEntityTent;

public class TileEntityTentRenderer extends TileEntitySpecialRenderer {

	private ModelTentNormal Modeltent;
	private ModelTentStorage Modeltent1;
	private ModelTentSleeping Modeltent2;
	
	public TileEntityTentRenderer() 
	{
		Modeltent = new ModelTentNormal();
		Modeltent1 = new ModelTentStorage();
		Modeltent2 = new ModelTentSleeping();
	}

	public void renderAModelAt(TileEntityTent tile, double d, double d1, double d2, float f) 
	{
		int i = tile.getBlockMetadata();
		int j = 0;

		if (i==0||i==1||i==2) {
			j = 0;
		}

		if (i==3||i==4||i==5) {
			j = 90;
		}

		if (i == 0) 
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_NORMAL);
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F); 
			GL11.glScalef(1.0F, -1F, -1F);
			Modeltent.renderModel(0.0625F); 								
			GL11.glPopMatrix(); 
		}
		
		if (i == 1) 
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_STORAGE); 
			GL11.glPushMatrix(); 
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glScalef(1.0F, -1F, -1F); 							
			Modeltent1.renderModel(0.0625F); 
			GL11.glPopMatrix(); 
		}
		
		if (i == 2) 
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_SLEEPING); 
			GL11.glPushMatrix(); 
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F); 
			GL11.glScalef(1.0F, -1F, -1F); 							
			Modeltent2.renderModel(0.0625F); 									
			GL11.glPopMatrix(); 
		}
		
		if (i == 3)
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_NORMAL);
			GL11.glPushMatrix(); 
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); 
			GL11.glScalef(1.0F, -1F, -1F); 
			Modeltent.renderModel(0.0625F); 
			GL11.glPopMatrix();
		}
		
		if (i == 4) 
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_STORAGE); 
			GL11.glPushMatrix(); 
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,(float) d2 + 0.5F); 
			GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); 
			GL11.glScalef(1.0F, -1F, -1F); 									
			Modeltent1.renderModel(0.0625F); 							
			GL11.glPopMatrix(); 
		}
		
		if (i == 5) 
		{
			bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_TENT_SLEEPING);
			GL11.glPushMatrix(); 
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,	(float) d2 + 0.5F); 
			GL11.glRotatef(j, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(1.0F, -1F, -1F); 											
			Modeltent2.renderModel(0.0625F); 
			GL11.glPopMatrix(); 
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) 
	{
		renderAModelAt((TileEntityTent) tileentity, d, d1, d2, f); 
	}
}