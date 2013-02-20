package camping.common.rikmuld.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import camping.common.rikmuld.client.model.ModelCampfire;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.core.proxys.CommonProxy;
import camping.common.rikmuld.tileentity.TileEntityCampfire;

public class TileEntityCampfireRenderer extends TileEntitySpecialRenderer {
	
	private ModelCampfire Modelcampfire;

	public TileEntityCampfireRenderer() 
	{
		Modelcampfire = new ModelCampfire();
	}
	
	public void renderAModelAt(TileEntityCampfire tile, double d, double d1, double d2, float f) 
	{
	                bindTextureByName(Textures.MODEL_LOCATION + Textures.MODEL_CAMPFIRE);
	                GL11.glPushMatrix();
	                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); 
	                GL11.glScalef(1.0F, -1F, -1F); 
	                Modelcampfire.renderModel(0.0625F); 
	                GL11.glPopMatrix();             
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
	renderAModelAt((TileEntityCampfire) tileentity, d, d1, d2, f); 
	}
}
