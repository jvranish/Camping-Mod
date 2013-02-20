package camping.common.rikmuld.core.register;

import camping.common.rikmuld.core.lib.TileEntitys;
import camping.common.rikmuld.tileentity.TileEntityCampfireCheapCooker;
import camping.common.rikmuld.tileentity.TileEntityCampfireFastCooker;
import camping.common.rikmuld.tileentity.TileEntityCampfireMultiCooker;
import camping.common.rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntitys {

	public static void init() 
	{
		GameRegistry.registerTileEntity(TileEntityCampfireFastCooker.class, TileEntitys.TILE_CAMP_FAST);
		GameRegistry.registerTileEntity(TileEntityCampfireCheapCooker.class, TileEntitys.TILE_CAMP_CHEAP);
		GameRegistry.registerTileEntity(TileEntityCampfireMultiCooker.class, TileEntitys.TILE_CAMP_MULTI);
		GameRegistry.registerTileEntity(TileEntityTent.class, TileEntitys.TILE_TENT);
	}
}
