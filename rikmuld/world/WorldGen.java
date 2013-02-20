package camping.common.rikmuld.world;

import java.util.Random;

import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.world.structures.CampsiteSimple;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1: generateNether(world, random, chunkX*16, chunkZ*16);
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{ 
		if (Config.WORLD_GEN_ENABLED)
		{
			int Xcoord1 = blockX + random.nextInt(Config.WORLD_GEN_SMALL_CAMP_SPAWN_RARENESS);
			int Ycoord1 = random.nextInt(80);
			int Zcoord1 = blockZ + random.nextInt(Config.WORLD_GEN_SMALL_CAMP_SPAWN_RARENESS);
			
			(new CampsiteSimple()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
	}
 
	private void generateNether(World world, Random random, int blockX, int blockZ) {}
}
