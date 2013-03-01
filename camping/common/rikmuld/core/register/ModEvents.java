package camping.common.rikmuld.core.register;

import camping.common.rikmuld.block.plant.RadishCrop;
import camping.common.rikmuld.core.helper.CheckVersion;
import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EnteringChunk;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

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
