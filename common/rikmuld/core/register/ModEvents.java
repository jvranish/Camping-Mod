package rikmuld.core.register;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.WorldEvent.Load;
import rikmuld.block.plant.RadishCrop;
import rikmuld.core.helper.CheckVersion;

public class ModEvents {
	
	boolean FirstTime = true;
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new ModEvents());
	}
	
	@ForgeSubscribe
	public void WorldIsLoaded(LivingJumpEvent event)
	{
		if(FirstTime)
		{
			CheckVersion.CheckNewestVersion();
			FirstTime = false;
		}
	}
	
	@ForgeSubscribe
	public void WorldIsLoaded(Load event)
	{
		if(!FirstTime)
		{
			FirstTime = true;
		}
	}
	
	@ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.ID == ModBlocks.RadishCrop.blockID)
            {
                    if (!event.world.isRemote)
                    {
                            ((RadishCrop)ModBlocks.RadishCrop).Grow(event.world, event.X, event.Y, event.Z, event.entityPlayer);
                    }
            }

    }
}
