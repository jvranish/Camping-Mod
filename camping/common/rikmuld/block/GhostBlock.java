package camping.common.rikmuld.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Textures;

public class GhostBlock extends Block {
	
	public GhostBlock(int id) 
	{
		super(id, Material.air);
		setBlockName(Blocks.BLOCK_GHOST_NAME);
		blockIndexInTexture = 40;
		setHardness(1.5F);
	}

	public int getRenderType() 
	{
		return -1;
	}

	@Override
	public String getTextureFile() 
	{
		return Textures.SPRITE_LOCATION + Textures.SPRITE_BLOCK;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	public boolean isAirBlock(World world, int x, int y, int z) 
	{
		return true;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) 
	{
		int var7 = par1World.getBlockMetadata(par2, par3, par4) & 7;
		float var8 = 0.15F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		return null;
	}
	
	public int quantityDropped(Random par1Random) 
	{
		return 0;
	}

	public boolean renderAsNormalBlock() 
	{
		return false;
	}
}