package rikmuld.block.plant;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import rikmuld.core.lib.Blocks;
import rikmuld.core.lib.Config;
import rikmuld.core.lib.Textures;
import rikmuld.core.register.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RadishCrop extends BlockFlower {
	
	    public RadishCrop(int par1)
	    {
	        super(par1, 0);
	        this.blockIndexInTexture = 0;
	        this.setTickRandomly(true);
	        float var3 = 0.5F;
	        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
	        this.setHardness(0.0F);
	        this.setStepSound(soundGrassFootstep);
	        this.disableStats();
	        this.setRequiresSelfNotify();
	        this.setBlockName(Blocks.BLOCK_RADISH_NAME);
	    }
	    
	    @Override
	    public void onBlockAdded(World par1World, int par2, int par3, int par4) 
	    {
	   	 	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	    }

	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        super.updateTick(par1World, par2, par3, par4, par5Random);

	        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	        {
	            int var6 = par1World.getBlockMetadata(par2, par3, par4);

	            if (var6 < 7)
	            {
	                double var7 = this.getGrowthRate(par1World, par2, par3, par4);

	                if (par5Random.nextInt((int)(25.0F / var7) + 1) == 0)
	                {
	                    ++var6;
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
	                }
	            }
	        }
	    }

	    public boolean Grow(World par1World, int par2, int par3, int par4, EntityPlayer player)
	    {

	    	int var6 = par1World.getBlockMetadata(par2, par3, par4);
			ItemStack currentitem = player.getCurrentEquippedItem();
				
			if (var6!=7)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
				currentitem.stackSize--;
				return true;
			}
			return true;
	    }

	    private double getGrowthRate(World par1World, int par2, int par3, int par4)
	    {	
	        double var5 = 1.0D;
	        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
	        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
	        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
	        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
	        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
	        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
	        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
	        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
	        boolean var14 = var8 == this.blockID || var9 == this.blockID;
	        boolean var15 = var6 == this.blockID || var7 == this.blockID;
	        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

	        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
	        {
	            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
	            {
	                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
	                double var20 = 0.0D;

	                if (blocksList[var19] != null && blocksList[var19].canSustainPlant(par1World, var17, par3 - 1, var18, ForgeDirection.UP, this))
	                {
	                    var20 = (1.0D*Config.PLANT_RADISH_GROW_RATE);

	                    if (blocksList[var19].isFertile(par1World, var17, par3 - 1, var18))
	                    {
	                        var20 = (3.0D*Config.PLANT_RADISH_GROW_RATE);
	                    }
	                }

	                if (var17 != par2 || var18 != par4)
	                {
	                    var20 /= 0.5D;
	                }

	                var5 += var20+(1.0D*Config.PLANT_RADISH_GROW_RATE);
	            }
	        }

	        if (var16 || var14 && var15)
	        {
	            var5 /= 0.5D;
	        }

	        return var5+(3.0D*Config.PLANT_RADISH_GROW_RATE);
	    }

	    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	        if (par2 < 0)
	        {
	            par2 = 7;
	        }

	        return this.blockIndexInTexture + par2;
	    }

	    public int getRenderType()
	    {
	        return 6;
	    }

	    protected int getSeedItem()
	    {
	        return ModItems.radishSeed.itemID;
	    }

	    protected int getCropItem()
	    {
	        return ModItems.radish.itemID;
	    }

	    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	    {
	        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
	    }

	    @Override 
	    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	    {
	        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

	        if (metadata >= 7)
	        {
	            for (int n = 0; n < 3 + fortune; n++)
	            {
	                if (world.rand.nextInt(15) <= metadata)
	                {
	                    ret.add(new ItemStack(this.getSeedItem(), 1, 0));
	                }
	            }
	        }

	        return ret;
	    }


	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return par1 == 7 ? this.getCropItem() : this.getSeedItem();
	    }

	    public int quantityDropped(Random par1Random)
	    {
	        return 1;
	    }

	    @Override
	    public int idPicked (World world, int x, int y, int z) {
	        return ModItems.radishSeed.itemID;
	    }
	    
	    @SideOnly(Side.CLIENT)
 		public String getTextureFile()
 		{ 
	    	return Textures.SPRITE_LOCATION + Textures.SPRITE_BLOCK;
 		}
}
