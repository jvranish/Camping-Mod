package camping.common.rikmuld.core.register;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.block.Campfire;
import camping.common.rikmuld.block.CampfireCheapCooker;
import camping.common.rikmuld.block.CampfireFastCooker;
import camping.common.rikmuld.block.CampfireMultiCooker;
import camping.common.rikmuld.block.GhostBlock;
import camping.common.rikmuld.block.Tent;
import camping.common.rikmuld.block.plant.RadishCrop;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.item.itemblock.ItemCampfireCheapCooker;
import camping.common.rikmuld.item.itemblock.ItemCampfireFastCooker;
import camping.common.rikmuld.item.itemblock.ItemCampfireMultiCooker;
import camping.common.rikmuld.item.itemblock.ItemTent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	
	public static Campfire campfireMultiCooker;
	public static Campfire campfireFastCooker;
	public static Campfire campfireCheapCooker;
	public static Block tent;
	public static Block ghostBlock;
	public static Block RadishCrop;
	
	public static void init() 
	{
		campfireMultiCooker = new CampfireMultiCooker(Blocks.BLOCK_CAMP_MULTI_ID);
		campfireFastCooker = new CampfireFastCooker(Blocks.BLOCK_CAMP_FAST_ID);
		campfireCheapCooker = new CampfireCheapCooker(Blocks.BLOCK_CAMP_CHEAP_ID);
		tent = new Tent(Blocks.BLOCK_TENT_ID);
		ghostBlock = new GhostBlock(Blocks.BLOCK_GHOST_ID);
		RadishCrop = new RadishCrop(Blocks.BLOCK_RADISH_ID);
		
		GameRegistry.registerBlock(campfireMultiCooker, ItemCampfireMultiCooker.class, Blocks.BLOCK_META_CAMP_NORMAL_MULTI_NAME);
		GameRegistry.registerBlock(campfireFastCooker, ItemCampfireFastCooker.class, Blocks.BLOCK_CAMP_FAST_NAME);
		GameRegistry.registerBlock(campfireCheapCooker, ItemCampfireCheapCooker.class, Blocks.BLOCK_META_CAMP_CHEAP_INSTA_NAME);
		GameRegistry.registerBlock(tent, ItemTent.class, Blocks.BLOCK_TENT_NAME);
		GameRegistry.registerBlock(ghostBlock, Blocks.BLOCK_GHOST_NAME);
		GameRegistry.registerBlock(RadishCrop, Blocks.BLOCK_RADISH_NAME);
		
		LanguageRegistry.addName(campfireFastCooker, Blocks.BLOCK_CAMP_FAST_GAME_NAME);
		LanguageRegistry.addName(tent, Blocks.BLOCK_TENT_GAME_NAME);
		
		LanguageRegistry.addName(new ItemStack(campfireMultiCooker, 1, 0), Blocks.BLOCK_CAMP_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(campfireMultiCooker, 1, 1), Blocks.BLOCK_CAMP_MULTI_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(campfireCheapCooker, 1, 0), Blocks.BLOCK_CAMP_CHEAP_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(campfireCheapCooker, 1, 1), Blocks.BLOCK_CAMP_INSTA_GAME_NAME);
	}
}
