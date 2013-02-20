package camping.common.rikmuld.core.proxys;

import net.minecraftforge.client.MinecraftForgeClient;
import camping.common.rikmuld.client.renderer.tileentity.TileEntityCampfireRenderer;
import camping.common.rikmuld.client.renderer.tileentity.TileEntityTentRenderer;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.tileentity.TileEntityCampfire;
import camping.common.rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers () 
	{
		MinecraftForgeClient.preloadTexture(Textures.SPRITE_LOCATION + Textures.SPRITE_BLOCK);
		MinecraftForgeClient.preloadTexture(Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM);
		MinecraftForgeClient.preloadTexture(Textures.SPRITE_LOCATION + Textures.SPRITE_PARTICLES);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new TileEntityCampfireRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTent.class, new TileEntityTentRenderer());
	}
	
	public void initRenderingAndTextures() 
    {
		
	}
}