package camping.common.rikmuld.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.client.renderer.particles.Particles;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.item.itemblock.ItemCampfireCheapCooker;
import camping.common.rikmuld.item.itemblock.ItemCampfireFastCooker;
import camping.common.rikmuld.item.itemblock.ItemCampfireMultiCooker;
import camping.common.rikmuld.tileentity.TileEntityCampfire;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class Campfire extends BlockContainer{

	private int metadata;
	private Random campfireRand = new Random();
	private static boolean keepCampfireInventory = false;
	Minecraft mc;
	RenderEngine renderEngine;
	private int color;
	private int colormeta;
	
	public Campfire(int id, String name, int metadat, int colorparticle, int colorparticlemeta) {
		super(id, Material.fire);
		setBlockName(name);
		setCreativeTab(CampingMod.customTab);
		metadata = metadat;
		setHardness(3.0F);
		setLightValue(1.0F);
		setStepSound(soundWoodFootstep);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.15F, 1.0F);
		color = colorparticle;
		colormeta = colorparticlemeta;
	}
	
	public final boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }
    
    public final boolean isBlockBurning(World world, int x, int y, int z) 
    {
    	if(Config.CAMPFIRE_CAN_BURN)
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    public int getColor() 
    {
    	return color;
    }
    
    public int getColorMeta() 
    {
    	return colormeta;
    }
    
    public void setColor(int colorpar, int colormetapar)
    {
    	color = colorpar;
    	colormeta = colormetapar;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean addBlockDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer)
    {
        return true;
    }

	@Override
	public abstract TileEntity createNewTileEntity(World var1);

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.torchWood.blockID;
    }
 
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(3) + 1;
    }
 
    @SideOnly(Side.CLIENT)
    public final void getSubBlocks(int unknown, CreativeTabs tab, List subItems) 
    {
    	if(this.blockID==Blocks.BLOCK_CAMP_CHEAP_ID)
    	{
	    	if(Config.CAMPFIRE_INSTA_COOK_ENABLED==false)
	    	{
		    	for (int ix = 0; ix < 1; ix++) 
		 		{
			 		subItems.add(new ItemStack(this, 1, ix));
		 		}
	    	}
	    	else
	    	{
	    		for (int ix = 0; ix < metadata; ix++) 
		 		{
			 		subItems.add(new ItemStack(this, 1, ix));
		 		}
	    	}
    	}
    	else
    	{
    		for (int ix = 0; ix < metadata; ix++) 
	 		{
		 		subItems.add(new ItemStack(this, 1, ix));
	 		}
    	}
    }
 
    public final boolean isOpaqueCube()
    {
	  return false;
	}
    
	public final boolean renderAsNormalBlock()
	{
	  return false;
	}
	
	public final int getRenderType() 
	{
	  return -1;
	}

	public void ColorParticle(World par1world, int x, int y, int z, EntityPlayer player)
	{
		int var6 = par1world.getBlockMetadata(x, y, z);
		ItemStack currentitem = player.getCurrentEquippedItem();
		
		if(Config.CAMPFIRE_CAN_BE_RECOLORED)
		{		
			if (var6==1)
			{
				colormeta = currentitem.getItemDamage();
			}
			
			else 
			{
				color = currentitem.getItemDamage();
			}
			
			currentitem.stackSize -= 1;	
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
		double var7 = (double)((float)par2 + 0.5F);
     	double var9 = (double)((float)par3 + 0.3F);
     	double var11 = (double)((float)par4 + 0.5F);

     	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
     	
     	Particles render = new Particles();
     	par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.05D, 0.0D);
     	par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.05D, 0.0D);
     
     	if (var6==1)
     	{
     		render.doSpawnParticle("coloredflame", var7, var9, var11, 0.0D, 0.05D, 0.0D, colormeta);
     	}
     	else
     	{
     		render.doSpawnParticle("coloredflame", var7, var9, var11, 0.0D, 0.05D, 0.0D, color);
     	}
	} 
	
	 @Override
	 public abstract boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9);
	
	 public final int tickRate()
	 {
		return 10;
	 }

	 public void onBlockAdded(World par1World, int par2, int par3, int par4)
	 {
		 par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	 }

	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	 {
		 par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	 }

	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	 {
		 par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
		 this.dropIfCantStay(par1World, par2, par3, par4, par5Random);
		 if(blockID==ModBlocks.campfireMultiCooker.blockID){ItemCampfireMultiCooker.settexture(color, colormeta);}
		 if(blockID==ModBlocks.campfireFastCooker.blockID){ItemCampfireFastCooker.settexture(color, colormeta);}
		 if(blockID==ModBlocks.campfireCheapCooker.blockID){ItemCampfireCheapCooker.settexture(color, colormeta);}
	
	 }	

	 private boolean dropIfCantStay(World world, int x, int y, int z, Random random)
	 {
		if(world.doesBlockHaveSolidTopSurface(x, y-1, z))
		{
			return true;
		}
		
		else
		{
			world.setBlockWithNotify(x, y, z, 0);
			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(Block.torchWood, 3));
		}
		return false;
	 }
	 
	 public void updateCampfireBlockState(boolean par0, World par1World, int par2, int par3, int par4)
		{
		    int var5 = par1World.getBlockMetadata(par2, par3, par4);
		    TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
		    keepCampfireInventory = true;
		
		    if (par0)
		    {
		        par1World.setBlockWithNotify(par2, par3, par4, this.blockID);
		    }
		    
		    else
		    {
		        par1World.setBlockWithNotify(par2, par3, par4, this.blockID);
		    }
		
		    keepCampfireInventory = false;
		    par1World.setBlockMetadataWithNotify(par2, par3, par4, var5);
		
		    if (var6 != null)
		    {
		        var6.validate();
		        par1World.setBlockTileEntity(par2, par3, par4, var6);
		    }
		}
	 
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
	    if (!keepCampfireInventory)
	    {
	        TileEntityCampfire var7 = (TileEntityCampfire)par1World.getBlockTileEntity(par2, par3, par4);
	
	        if (var7 != null)
	        {
	            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
	            {
	                ItemStack var9 = var7.getStackInSlot(var8);
	
	                if (var9 != null)
	                {
	                    float var10 = this.campfireRand.nextFloat() * 0.8F + 0.1F;
	                    float var11 = this.campfireRand.nextFloat() * 0.8F + 0.1F;
	                    float var12 = this.campfireRand.nextFloat() * 0.8F + 0.1F;
	
	                    while (var9.stackSize > 0)
	                    {
	                        int var13 = this.campfireRand.nextInt(21) + 10;
	
	                        if (var13 > var9.stackSize)
	                        {
	                            var13 = var9.stackSize;
	                        }
	
	                        var9.stackSize -= var13;
	                        EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
	
	                        if (var9.hasTagCompound())
	                        {
	                        	var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
	                        }
	
	                        float var15 = 0.05F;
	                        var14.motionX = (double)((float)this.campfireRand.nextGaussian() * var15);
	                        var14.motionY = (double)((float)this.campfireRand.nextGaussian() * var15 + 0.2F);
	                        var14.motionZ = (double)((float)this.campfireRand.nextGaussian() * var15);
	                        par1World.spawnEntityInWorld(var14);
	                    }
	                }
	            }
	        }
	    }
	
	    super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}
