package rikmuld.core.proxys;

import net.minecraftforge.client.MinecraftForgeClient;
import rikmuld.client.renderer.tileentity.TileEntityCampfireRenderer;
import rikmuld.client.renderer.tileentity.TileEntityTentRenderer;
import rikmuld.core.lib.Textures;
import rikmuld.tileentity.TileEntityCampfire;
import rikmuld.tileentity.TileEntityTent;
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