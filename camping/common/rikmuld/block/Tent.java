package camping.common.rikmuld.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.register.ModAchievements;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.core.register.ModItems;
import camping.common.rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tent extends BlockContainer {
	
	private int[] xNoRoalteTent = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 1};
	private int[] yNoRoalteTent = {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0};
	private int[] zNoRoalteTent = {-1, 1, 0, -1, 1, 0, -1, 1, 0, 0, 0};
	private int[] xRoalteTent = {0, 1, -1, 0, 0, -1, 1, 0, 0, -1, 1};
	private int[] yRoalteTent = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0};
	private int[] zRoalteTent = {0, 0, 0, -1, -1, -1, -1, -2, -2, -2, -2};
	
	private int BID = 0;
	private int MID = 0;
	Minecraft mc;
	private Random tentRand = new Random();
	private static boolean keepTentInventory = false;
	
	public Tent(int id) 
	{
		super(id, Material.cloth);
		setBlockName(Blocks.BLOCK_TENT_NAME);
		setHardness(1.5F);
		setStepSound(soundWoodFootstep);
		setCreativeTab(CampingMod.customTab);
	}

	public void setBedOccupied(World world, int x, int y, int z, EntityPlayer player, boolean occupied){}
	
	public static boolean isBedOccupied(int par0) 
	{
		return false;
	}

	public boolean isBed(World world, int x, int y, int z, EntityLiving player) 
	{
		return true;
	}

	public ChunkCoordinates getBedSpawnPosition(World world, int x, int y, int z, EntityPlayer player) 
	{
		return BlockBed.getNearestEmptyChunkCoordinates(world, x, y, z, 0);
	}
		
	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int metadata) 
	{
		return 6 + metadata;
	}
	
	 @SideOnly(Side.CLIENT)
	 public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) 
	 {
	 	for (int ix = 0; ix < 1; ix++) 
	 	{
	 		subItems.add(new ItemStack(this, 1, ix));
	 	}
	 }

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) 
	{
		return null;
	}

	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) 
	{
		int var7 = par1World.getBlockMetadata(par2, par3, par4) & 7;
		float var8 = 0.15F;
		
		if(var7<3)
		{
			this.setBlockBounds(0.0F, 0.0F, -0.5F, 3.0F, 1.5F, 1.5F);
		}
		
		else
		{
			this.setBlockBounds(-0.5F, 0.0F, 1.0F, 1.5F, 1.5F, -2.0F);
		}
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}
	
	@Override
	public boolean onBlockActivated(World par1world, int par2, int par3, int par4, EntityPlayer player, int idk, float what, float these, float are) {
	
		ItemStack currentitem = player.getCurrentEquippedItem();	
		par1world.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
		int var6 = par1world.getBlockMetadata(par2, par3, par4);
		ItemStack tenttools0 = new ItemStack (ModItems.TentTools, 1, 0);
		ItemStack tenttools1 = new ItemStack (ModItems.TentTools, 1, 1);

		if(var6==0){
			
			if (currentitem != null)
			{
				 if (currentitem.itemID == ModItems.SleepingBag.itemID)
				 {
					 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 2);
					 ItemStack sleepingbag = new ItemStack(ModItems.SleepingBag, currentitem.stackSize-1);
					 player.destroyCurrentEquippedItem();
					 player.inventory.addItemStackToInventory(sleepingbag);
					 player.addStat(ModAchievements.campachiev9, 1);	
				 }
				 
				 if (currentitem.itemID == Block.chest.blockID) 
				 {
					 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 1);
					 ItemStack chest = new ItemStack(Block.chest, currentitem.stackSize-1);
					 player.destroyCurrentEquippedItem();
					 player.inventory.addItemStackToInventory(chest);										 
					 player.addStat(ModAchievements.campachiev8, 1);			
			     }
				 
				 if (currentitem.itemID == ModItems.TentTools.itemID)
				 {
					BID = par1world.getBlockId(par2, par3+1, par4);
					if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
					{				
						BID = par1world.getBlockId(par2+1, par3, par4);
						if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
						{
							BID = par1world.getBlockId(par2-1, par3, par4);
							if (BID==0||BID==31||BID==78)
							{
								BID = par1world.getBlockId(par2, par3, par4-1);
								if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
								{					
									BID = par1world.getBlockId(par2, par3+1, par4-1);
									if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
									{				
										BID = par1world.getBlockId(par2-1, par3, par4-1);
										if (BID==0||BID==31||BID==78)
										{								
											BID = par1world.getBlockId(par2+1, par3, par4-1);
											if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
											{										
												BID = par1world.getBlockId(par2, par3, par4-2);
												if (BID==0||BID==31||BID==78)
												{										
													BID = par1world.getBlockId(par2, par3+1, par4-2);
													if (BID==0||BID==31||BID==78)
													{											
														BID = par1world.getBlockId(par2-1, par3, par4-2);
														if (BID==0||BID==31||BID==78)
														{												    
															BID = par1world.getBlockId(par2+1, par3, par4-2);
															if (BID==0||BID==31||BID==78)
															{							
																if (par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4)&&
																	par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4)&&
																	par1world.doesBlockHaveSolidTopSurface(par2-1, par3 - 1, par4)&&
																	par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4-1)&&
																	par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4-1)&&
																	par1world.doesBlockHaveSolidTopSurface(par2-1, par3 - 1, par4-1)&&
																	par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4-2)&&
																	par1world.doesBlockHaveSolidTopSurface(par2-1, par3 - 1, par4-2)&&
																	par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4-2))
																{				    
																	par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 3);
																	player.destroyCurrentEquippedItem();
																	ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
																	player.inventory.addItemStackToInventory(k);
																	if (currentitem.getItemDamage()>99)
																	{
																		player.destroyCurrentEquippedItem();
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} 
					}
				}
			}			 
			return true;	
	}

	if(var6==3){
			
			if (currentitem != null)
			{
				 if (currentitem.itemID == ModItems.SleepingBag.itemID)
				    {
					 	 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 5);
					 	 ItemStack sleepingbag = new ItemStack(ModItems.SleepingBag, currentitem.stackSize-1);
					     player.destroyCurrentEquippedItem();
					     player.inventory.addItemStackToInventory(sleepingbag);
						 player.addStat(ModAchievements.campachiev9, 1);
						 
				     return true;
				    }
				 
				 if (currentitem.itemID == Block.chest.blockID) 
				 {
					 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 4);
					 ItemStack chest = new ItemStack(Block.chest, currentitem.stackSize-1);
					 player.destroyCurrentEquippedItem();
					 player.inventory.addItemStackToInventory(chest);
					 player.addStat(ModAchievements.campachiev8, 1);

					 return true;
			      }
				 
				if (currentitem.itemID == ModItems.TentTools.itemID)
				{
					BID = par1world.getBlockId(par2, par3, par4+1);
					if (BID==0||BID==31||BID==78)
					{
			
						BID = par1world.getBlockId(par2, par3, par4-1);
						if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
						{
			   
							BID = par1world.getBlockId(par2, par3+1, par4);
							if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
							{
			
								BID = par1world.getBlockId(par2+1, par3, par4-1);
								if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
								{
				
									BID = par1world.getBlockId(par2+1, par3, par4+1);
									if (BID==0||BID==31||BID==78)
									{
				
										BID = par1world.getBlockId(par2+1, par3+1, par4);
										if (BID==0||BID==31||BID==78)
										{
																	
											BID = par1world.getBlockId(par2+2, par3, par4+1);
											if (BID==0||BID==31||BID==78)
											{
										
												BID = par1world.getBlockId(par2+2, par3+1, par4);
												if (BID==0||BID==31||BID==78)
												{
												
													BID = par1world.getBlockId(par2+2, par3, par4);
													if (BID==0||BID==31||BID==78)
													{
				
														BID = par1world.getBlockId(par2+1, par3, par4);
														if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
														{
			
															BID = par1world.getBlockId(par2, par3+1, par4-1);
														    if (BID==0||BID==ModBlocks.ghostBlock.blockID||BID==31||BID==78)
														    {
																
															    BID = par1world.getBlockId(par2+2, par3, par4-1);
																if (BID==0||BID==31||BID==78)
																{	
						
																	if (par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+2, par3 - 1, par4)&&
																		par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4-1)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4-1)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+2, par3 - 1, par4-1)&&
																		par1world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4+1)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+1, par3 - 1, par4+1)&&
																		par1world.doesBlockHaveSolidTopSurface(par2+2, par3 - 1, par4+1))
																	{				
																		par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 0);
																	   	player.destroyCurrentEquippedItem();
																        ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
																        player.inventory.addItemStackToInventory(k);
																        if (currentitem.getItemDamage()>99)
																        {
																        	player.destroyCurrentEquippedItem();
																        }
																	}															
																}
														    }
														}
													}
												}
											}
										}
									}
								}
							}
						}	
					}
				}    
			}	 
			return true;	
		}
		
		if(var6==1)
		{
			if (currentitem != null)
			{
				 if (currentitem.itemID == ModItems.TentTools.itemID)
				    {
						 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 0);
						 ItemStack chest = new ItemStack(Block.chest, 1);
						 player.inventory.addItemStackToInventory(chest);
						 player.destroyCurrentEquippedItem();
						 ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
						 player.inventory.addItemStackToInventory(k);
						 if (currentitem.getItemDamage()>99)
						 {
							 player.destroyCurrentEquippedItem();
						 }
						 return true;					 
				    }
				player.openGui(CampingMod.instance, 4, par1world, par2, par3, par4);
				return true;
			}
			player.openGui(CampingMod.instance, 4, par1world, par2, par3, par4);
			return true;
		}

	if(var6==4)
	{
			if (currentitem != null)
			{
				 if (currentitem.itemID == ModItems.TentTools.itemID)
				    {
						 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 3);
						 ItemStack chest = new ItemStack(Block.chest, 1);
						 player.inventory.addItemStackToInventory(chest);
						 player.destroyCurrentEquippedItem();
						 ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
						 player.inventory.addItemStackToInventory(k);
						 if (currentitem.getItemDamage()>99)
						 {
						    	player.destroyCurrentEquippedItem();
						 }
						 return true;	 
				     }							
				player.openGui(CampingMod.instance, 4, par1world, par2, par3, par4);
				return true;
			}
			player.openGui(CampingMod.instance, 4, par1world, par2, par3, par4);
			return true;
		}
			
		if(var6==5)
		{			
			 if (currentitem != null)
			 {
				 if (currentitem.itemID == ModItems.TentTools.itemID)
				 {				
						 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 3);
						 ItemStack chest = new ItemStack(ModItems.SleepingBag, 1);
						 player.inventory.addItemStackToInventory(chest);
						 player.destroyCurrentEquippedItem();
						 ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
						 player.inventory.addItemStackToInventory(k);
						 if (currentitem.getItemDamage()>99)
						 {
							player.destroyCurrentEquippedItem();
						 }
						 return true;
				 }				 
			}
		}
		
		if(var6==2)
		{			
			 if (currentitem != null)
				{
				 if (currentitem.itemID == ModItems.TentTools.itemID)
				    {					
						 par1world.setBlockAndMetadataWithNotify(par2, par3, par4, ModBlocks.tent.blockID, 0);
						 ItemStack chest = new ItemStack(ModItems.SleepingBag, 1);
						 player.inventory.addItemStackToInventory(chest);
					     player.destroyCurrentEquippedItem();
						 ItemStack k = new ItemStack(ModItems.TentTools, 1, (currentitem.getItemDamage() + 1));
						 player.inventory.addItemStackToInventory(k);
						 if (currentitem.getItemDamage()>99)
						 {
							player.destroyCurrentEquippedItem();
						 }
						 return true;
					 }				 
				}
		}
		
		if(var6==5||var6==2)
		{	
			 if (par1world.isRemote)
			 {
				 return true;
			 }
			 
			 else 
			 {
				int var10 = par1world.getBlockMetadata(par2, par3, par4);

				if (isBedOccupied(var10)) 
				{
					EntityPlayer var18 = null;
					Iterator var12 = par1world.playerEntities.iterator();

					while (var12.hasNext()) 
					{
						EntityPlayer var13 = (EntityPlayer) var12.next();

						if (var13.isPlayerSleeping()) 
						{
							ChunkCoordinates var14 = var13.playerLocation;

							if (var14.posX == par2 && var14.posY == par3&& var14.posZ == par4) 
							{
								var18 = var13;
							}
						}
					}

					if (var18 != null) 
					{
						player.addChatMessage("tile.bed.occupied");
						return true;
					}

					setBedOccupied(par1world, par2, par3, par4, player,false);
				}

				EnumStatus var20 = player.sleepInBedAt(par2, par3, par4);

				if (var20 == EnumStatus.OK)
				{
					setBedOccupied(par1world, par2, par3, par4, player,true);
					return true;
					} 
				
					else 
					{
						if (var20 == EnumStatus.NOT_POSSIBLE_NOW) 
						{
							player.addChatMessage("tile.bed.noSleep");
						} 
						
						else if (var20 == EnumStatus.NOT_SAFE) 
						{
							player.addChatMessage("tile.bed.notSafe");
						}
						return true;
					}
			}			   
		}
		return true;
	 }
	
	
	 public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	 {	 
			if (par1World.getBlockId(par2, par3, par4-1)!=0 && par1World.getBlockId(par2, par3, par4-1)!=31 && par1World.getBlockId(par2, par3, par4-1)!=78
				||par1World.getBlockId(par2, par3, par4+1)!=0 && par1World.getBlockId(par2, par3, par4+1)!=31 && par1World.getBlockId(par2, par3, par4+1)!=78
				||par1World.getBlockId(par2, par3+1, par4-1)!=0 && par1World.getBlockId(par2, par3+1, par4-1)!=31 && par1World.getBlockId(par2, par3+1, par4-1)!=78
				||par1World.getBlockId(par2, par3+1, par4+1)!=0 && par1World.getBlockId(par2, par3+1, par4+1)!=31 && par1World.getBlockId(par2, par3+1, par4+1)!=78
				||par1World.getBlockId(par2, par3+1, par4)!=0 && par1World.getBlockId(par2, par3+1, par4)!=31  && par1World.getBlockId(par2, par3+1, par4)!=78 
				||par1World.getBlockId(par2+1, par3, par4-1)!=0 && par1World.getBlockId(par2+1, par3, par4-1)!=31 && par1World.getBlockId(par2+1, par3, par4-1)!=78
				||par1World.getBlockId(par2+1, par3, par4+1)!=0 && par1World.getBlockId(par2+1, par3, par4+1)!=31 && par1World.getBlockId(par2+1, par3, par4+1)!=78
				||par1World.getBlockId(par2+1, par3+1, par4-1)!=0 && par1World.getBlockId(par2+1, par3+1, par4-1)!=31 && par1World.getBlockId(par2+1, par3+1, par4-1)!=78
				||par1World.getBlockId(par2+1, par3+1, par4+1)!=0 && par1World.getBlockId(par2+1, par3+1, par4+1)!=31 && par1World.getBlockId(par2+1, par3+1, par4+1)!=78
				||par1World.getBlockId(par2+1, par3+1, par4)!=0 && par1World.getBlockId(par2+1, par3+1, par4)!=31 && par1World.getBlockId(par2+1, par3+1, par4)!=78 
				||par1World.getBlockId(par2+2, par3, par4-1)!=0 && par1World.getBlockId(par2+2, par3, par4-1)!=31 && par1World.getBlockId(par2+2, par3, par4-1)!=78
				||par1World.getBlockId(par2+2, par3, par4+1)!=0 && par1World.getBlockId(par2+2, par3, par4+1)!=31 && par1World.getBlockId(par2+2, par3, par4+1)!=78
				||par1World.getBlockId(par2+2, par3+1, par4-1)!=0 && par1World.getBlockId(par2+2, par3+1, par4-1)!=31 && par1World.getBlockId(par2+2, par3+1, par4-1)!=78
				||par1World.getBlockId(par2+2, par3+1, par4+1)!=0 && par1World.getBlockId(par2+2, par3+1, par4+1)!=31 && par1World.getBlockId(par2+2, par3+1, par4+1)!=78
				||par1World.getBlockId(par2+2, par3+1, par4)!=0 && par1World.getBlockId(par2+2, par3+1, par4)!=31 && par1World.getBlockId(par2+2, par3+1, par4)!=78
				||par1World.getBlockId(par2+2, par3, par4)!=0 && par1World.getBlockId(par2+2, par3, par4)!=31 && par1World.getBlockId(par2+2, par3, par4)!=78
				||par1World.getBlockId(par2+1, par3, par4)!=0 && par1World.getBlockId(par2+1, par3, par4)!=31 && par1World.getBlockId(par2+1, par3, par4)!=78		
				||par1World.getBlockId(par2, par3-1, par4-1)==0||par1World.getBlockId(par2, par3-1, par4+1)==0||par1World.getBlockId(par2, par3-1, par4)==0
				||par1World.getBlockId(par2+1, par3-1, par4-1)==0||par1World.getBlockId(par2+1, par3-1, par4+1)==0||par1World.getBlockId(par2+1, par3-1, par4)==0
				||par1World.getBlockId(par2+2, par3-1, par4-1)==0||par1World.getBlockId(par2+2, par3-1, par4+1)==0||par1World.getBlockId(par2+2, par3-1, par4)==0
				||par1World.getBlockId(par2, par3-1, par4-1)==78||par1World.getBlockId(par2, par3-1, par4+1)==78||par1World.getBlockId(par2, par3-1, par4)==78
				||par1World.getBlockId(par2+1, par3-1, par4-1)==78||par1World.getBlockId(par2+1, par3-1, par4+1)==78||par1World.getBlockId(par2+1, par3-1, par4)==78
				||par1World.getBlockId(par2+2, par3-1, par4-1)==78||par1World.getBlockId(par2+2, par3-1, par4+1)==78||par1World.getBlockId(par2+2, par3-1, par4)==78
				||par1World.getBlockId(par2, par3-1, par4-1)==9||par1World.getBlockId(par2, par3-1, par4+1)==9||par1World.getBlockId(par2, par3-1, par4)==9
				||par1World.getBlockId(par2+1, par3-1, par4-1)==9||par1World.getBlockId(par2+1, par3-1, par4+1)==9||par1World.getBlockId(par2+1, par3-1, par4)==9
				||par1World.getBlockId(par2+2, par3-1, par4-1)==9||par1World.getBlockId(par2+2, par3-1, par4+1)==9||par1World.getBlockId(par2+2, par3-1, par4)==9					
				||par1World.getBlockId(par2, par3-1, par4-1)==10||par1World.getBlockId(par2, par3-1, par4+1)==10||par1World.getBlockId(par2, par3-1, par4)==10
				||par1World.getBlockId(par2+1, par3-1, par4-1)==10||par1World.getBlockId(par2+1, par3-1, par4+1)==10||par1World.getBlockId(par2+1, par3-1, par4)==10
				||par1World.getBlockId(par2+2, par3-1, par4-1)==10||par1World.getBlockId(par2+2, par3-1, par4+1)==10||par1World.getBlockId(par2+2, par3-1, par4)==10
				||par1World.getBlockId(par2, par3-1, par4-1)==11||par1World.getBlockId(par2, par3-1, par4+1)==11||par1World.getBlockId(par2, par3-1, par4)==11
				||par1World.getBlockId(par2+1, par3-1, par4-1)==11||par1World.getBlockId(par2+1, par3-1, par4+1)==11||par1World.getBlockId(par2+1, par3-1, par4)==11
				||par1World.getBlockId(par2+2, par3-1, par4-1)==11||par1World.getBlockId(par2+2, par3-1, par4+1)==11||par1World.getBlockId(par2+2, par3-1, par4)==11
				||par1World.getBlockId(par2, par3-1, par4-1)==8||par1World.getBlockId(par2, par3-1, par4+1)==8||par1World.getBlockId(par2, par3-1, par4)==8
				||par1World.getBlockId(par2+1, par3-1, par4-1)==8||par1World.getBlockId(par2+1, par3-1, par4+1)==8||par1World.getBlockId(par2+1, par3-1, par4)==8
				||par1World.getBlockId(par2+2, par3-1, par4-1)==8||par1World.getBlockId(par2+2, par3-1, par4+1)==8||par1World.getBlockId(par2+2, par3-1, par4)==8				
				||par1World.getBlockId(par2, par3-1, par4-1)==18||par1World.getBlockId(par2, par3-1, par4+1)==18||par1World.getBlockId(par2, par3-1, par4)==18
				||par1World.getBlockId(par2+1, par3-1, par4-1)==18||par1World.getBlockId(par2+1, par3-1, par4+1)==18||par1World.getBlockId(par2+1, par3-1, par4)==18
				||par1World.getBlockId(par2+2, par3-1, par4-1)==18||par1World.getBlockId(par2+2, par3-1, par4+1)==18||par1World.getBlockId(par2+2, par3-1, par4)==18)
				{
				return false;
				}
			
				else 
				{
				return true;
				} 
	}

	@SideOnly(Side.CLIENT)
	public boolean addBlockDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) 
	{
		return true;
	}

	public boolean isOpaqueCube() 
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType() 
	{
		return -1;
	}

	public int tickRate() 
	{
		return 10;
	}
	
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
	{
		int BID = par1World.getBlockId(par2, par3+1, par4-2);
		
		if(BID==ModBlocks.ghostBlock.blockID)
		{
			this.DestroyTentMeta(par1World, par2, par3, par4);
		}
		
		else
		{
			this.DestroyTent(par1World, par2, par3, par4);
		}
	}
	 
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		for(int x=0;x<xNoRoalteTent.length;x++)
		{
			par1World.setBlockAndMetadataWithNotify(par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x], ModBlocks.ghostBlock.blockID, 0);
		}
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
	{
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	{		
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
	
		if(var6==0||var6==1||var6==2)
		{		
			BID = par1World.getBlockId(par2+1, par3, par4-2);
		
			if (BID==ModBlocks.ghostBlock.blockID)
			{
		    par1World.setBlockAndMetadataWithNotify(par2-1, par3, par4, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2-1, par3, par4-1, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2, par3+1, par4-1, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2-1, par3, par4-2, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2+1, par3, par4-2, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2, par3, par4-2, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2, par3+1, par4+1, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2, par3+1, par4, 0, 0);
			par1World.setBlockAndMetadataWithNotify(par2, par3+1, par4-2, 0, 0);
			}
	
			for(int x=0;x<xNoRoalteTent.length;x++)
			{			
				MID = par1World.getBlockMetadata(par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x]);
				BID = par1World.getBlockId(par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x]);
				
				if (BID!=ModBlocks.ghostBlock.blockID)
				{			
					if (BID!=8&&BID!=9&&BID!=10&&BID!=11&&BID!=31&&BID!=78&&BID!=26)
					{
						if (BID!=0)
						{
							this.dropBlockAsItem_do(par1World, par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x], new ItemStack(BID, 1, MID));
						}	
					}
					par1World.setBlockAndMetadataWithNotify(par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x], ModBlocks.ghostBlock.blockID, 0);
					
					if(BID==8||BID==9||BID==10||BID==11)
					{	
						this.DestroyTent(par1World, par2, par3, par4);
						break;
					}
				}
			}
		}
		
		if(var6==3||var6==4||var6==5)
		{			
			BID = par1World.getBlockId(par2+2, par3, par4+1);
			
			if (BID==ModBlocks.ghostBlock.blockID)
			{
			    par1World.setBlockAndMetadataWithNotify(par2, par3, par4+1, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+1, par3, par4+1, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+1, par3+1, par4, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+2, par3, par4-1, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+2, par3, par4+1, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+2, par3+1, par4, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+2, par3, par4, 0, 0);
				par1World.setBlockAndMetadataWithNotify(par2+1, par3, par4, 0, 0);
			}
					
			par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
		
			for(int x=0;x<xRoalteTent.length;x++)
			{			
				MID = par1World.getBlockMetadata(par2+xRoalteTent[x], par3+yRoalteTent[x], par4+zRoalteTent[x]);
				BID = par1World.getBlockId(par2+xRoalteTent[x], par3+yRoalteTent[x], par4+zRoalteTent[x]);
				
				if (BID!=ModBlocks.ghostBlock.blockID)
				{			
					if (BID!=8&&BID!=9&&BID!=10&&BID!=11&&BID!=31&&BID!=78&&BID!=26)
					{
						if (BID!=0)
						{
							this.dropBlockAsItem_do(par1World, par2+xRoalteTent[x], par3+yRoalteTent[x], par4+zRoalteTent[x], new ItemStack(BID, 1, MID));
						}	
					}
					par1World.setBlockAndMetadataWithNotify(par2+xRoalteTent[x], par3+yRoalteTent[x], par4+zRoalteTent[x], ModBlocks.ghostBlock.blockID, 0);
					
					if(BID==8||BID==9||BID==10||BID==11)
					{			
						this.DestroyTentMeta(par1World, par2, par3, par4);
						break;
					}
				}
			}
		
		}

		this.dropIfCantStay(par1World, par2, par3, par4, par5Random);
	}
	
	private void DestroyTent(World world, int par2, int par3, int par4) 
	{
		for(int x=0;x<xNoRoalteTent.length;x++)
		{
			world.setBlockAndMetadataWithNotify(par2+xNoRoalteTent[x], par3+yNoRoalteTent[x], par4+zNoRoalteTent[x], 0, 0);				
		}
		world.setBlock(par2, par3, par4, 0);
	}
	
	private void DestroyTentMeta(World world, int par2, int par3, int par4) 
	{
		for(int x=0;x<xRoalteTent.length;x++)
		{
			world.setBlockAndMetadataWithNotify(par2+xRoalteTent[x], par3+yRoalteTent[x], par4+zRoalteTent[x], 0, 0);
		}
		world.setBlock(par2, par3, par4, 0);
	}

	private boolean dropIfCantStay(World world, int x, int y, int z, Random random) 
	{
		int var6 = world.getBlockMetadata(x, y, z);
		
		if (var6==1||var6==2||var6==0)
		{ 
			if (world.doesBlockHaveSolidTopSurface(x, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x+2, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x+2, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x, y - 1, z+1)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z+1)&&
				world.doesBlockHaveSolidTopSurface(x+2, y - 1, z+1))	
			{
				return true;
			} 
			else 
			{
				this.DestroyTent(world, x, y, z);		
				this.dropBlockAsItem_do(world, x, y, z, new ItemStack(ModBlocks.tent.blockID, 1, 0));
			}
		}
	
		if (var6==3||var6==4||var6==5)
		{ 
			if (world.doesBlockHaveSolidTopSurface(x, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x-1, y - 1, z)&&
				world.doesBlockHaveSolidTopSurface(x, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x-1, y - 1, z-1)&&
				world.doesBlockHaveSolidTopSurface(x, y - 1, z-2)&&
				world.doesBlockHaveSolidTopSurface(x-1, y - 1, z-2)&&
				world.doesBlockHaveSolidTopSurface(x+1, y - 1, z-2))
			{
			return true;
			} 
			
			else 
			{
				this.DestroyTentMeta(world, x, y, z);			
				this.dropBlockAsItem_do(world, x, y, z, new ItemStack(ModBlocks.tent.blockID, 1, 0));
			}
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityTent();
	}

	public static void updateTentBlockState(boolean par0, World par1World, int par2, int par3, int par4) 
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
		keepTentInventory = true;

		if (par0) 
		{
			par1World.setBlockWithNotify(par2, par3, par4,
					ModBlocks.tent.blockID);
		} 
		else 
		{
			par1World.setBlockWithNotify(par2, par3, par4,
					ModBlocks.tent.blockID);
		}

		keepTentInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5);

		if (var6 != null) 
		{
			var6.validate();
			par1World.setBlockTileEntity(par2, par3, par4, var6);
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)	
	{
		if (!keepTentInventory) 
		{
			TileEntityTent var7 = (TileEntityTent) par1World.getBlockTileEntity(par2, par3,	par4);
			if (var7 != null) 
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) 
				{
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null) 
					{
						float var10 = this.tentRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.tentRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.tentRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0) 
						{
							int var13 = this.tentRand.nextInt(21) + 10;

							if (var13 > var9.stackSize) 
							{
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World,(double) ((float) par2 + var10),(double) ((float) par3 + var11),(double) ((float) par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

							if (var9.hasTagCompound()) 
							{
								var14.getEntityItem().setTagCompound((NBTTagCompound) var9.getTagCompound().copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double) ((float) this.tentRand.nextGaussian() * var15);
							var14.motionY = (double) ((float) this.tentRand.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double) ((float) this.tentRand.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}