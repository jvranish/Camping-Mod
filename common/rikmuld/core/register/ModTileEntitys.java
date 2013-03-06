package rikmuld.core.register;

import rikmuld.core.lib.TileEntitys;
import rikmuld.tileentity.TileEntityCampfireCheapCooker;
import rikmuld.tileentity.TileEntityCampfireFastCooker;
import rikmuld.tileentity.TileEntityCampfireMultiCooker;
import rikmuld.tileentity.TileEntityCamping;
import rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntitys {

	public static void init() 
	{
		GameRegistry.registerTileEntity(TileEntityCampfireFastCooker.class, TileEntitys.TILE_CAMP_FAST);
		GameRegistry.registerTileEntity(TileEntityCampfireCheapCooker.class, TileEntitys.TILE_CAMP_CHEAP);
		GameRegistry.registerTileEntity(TileEntityCampfireMultiCooker.class, TileEntitys.TILE_CAMP_MULTI);
		GameRegistry.registerTileEntity(TileEntityTent.class, TileEntitys.TILE_TENT);
		GameRegistry.registerTileEntity(TileEntityCamping.class, "TileCamping");
	}
}
