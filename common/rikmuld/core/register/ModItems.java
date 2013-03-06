package rikmuld.core.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import rikmuld.core.lib.Config;
import rikmuld.core.lib.Items;
import rikmuld.item.GuideBook;
import rikmuld.item.Marshmellow;
import rikmuld.item.RadishSeed;
import rikmuld.item.TentContents;
import rikmuld.item.TentParts;
import rikmuld.item.food.FoodMarshmellow;
import rikmuld.item.food.FoodRadish;
import rikmuld.item.tool.ToolBackpack;
import rikmuld.item.tool.ToolCamping;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
	
	public static Item TentTools;
	public static Item Marshmallow;
	public static Item MarshmallowFood;
	public static Item TentParts;
	public static Item SleepingBag;
	public static Item CampingBag;
	public static Item radishSeed;
	public static Item guideBook;
	public static ItemFood radish;
	
	public static void init() 
	{
		TentTools = new ToolCamping(Items.ITEM_TOOL_CAMP_ID);
		Marshmallow = new Marshmellow(Items.ITEM_MARSH_ID);
		MarshmallowFood = new FoodMarshmellow(Items.ITEM_MARSH_FOOD_ID, 10, false);
		TentParts = new TentParts(Items.ITEM_TENT_PARTS_ID);
		SleepingBag = new TentContents(Items.ITEM_TENT_CONTENTS_ID);
		CampingBag = new ToolBackpack(Items.ITEM_TOOL_BACK_ID);
		radish = new FoodRadish(Items.ITEM_RADISH_FOOD_ID, 10, false);
		radishSeed = new RadishSeed(Items.ITEM_RADISH_SEED_ID, ModBlocks.RadishCrop.blockID, Block.grass.blockID);
		guideBook = new GuideBook(Items.ITEM_BOOK_GUIDE_ID);
		
		LanguageRegistry.addName(TentTools, Items.ITEM_TOOL_CAMP_GAME_NAME);
		LanguageRegistry.addName(MarshmallowFood, Items.ITEM_MARSH_FOOD_GAME_NAME);
		LanguageRegistry.addName(SleepingBag, Items.ITEM_TENT_CONTENTS_GAME_NAME);
		LanguageRegistry.addName(radish, Items.ITEM_RADISH_FOOD_GAME_NAME);
		LanguageRegistry.addName(radishSeed, Items.ITEM_RADISH_SEED_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(TentParts, 1, 0), Items.ITEM_TENT_PARTS_PEGS_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(TentParts, 1, 1), Items.ITEM_TENT_PARTS_CANVAS_GAME_NAME);		
		LanguageRegistry.addName(new ItemStack(Marshmallow, 1, 0), Items.ITEM_MARSH_NORMAL_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(Marshmallow, 1, 1), Items.ITEM_MARSH_STICK_GAME_NAME);		
		LanguageRegistry.addName(new ItemStack(CampingBag, 1, 0), Items.ITEM_TOOL_BACK_SMALL_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(CampingBag, 1, 1), Items.ITEM_TOOL_BACK_NORMAL_GAME_NAME);	
		LanguageRegistry.addName(new ItemStack(CampingBag, 1, 2), Items.ITEM_TOOL_BACK_LARGE_GAME_NAME);	
		LanguageRegistry.addName(new ItemStack(guideBook, 1, 0), Items.ITEM_BOOK_GUIDE_CAMP_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(guideBook, 1, 1), Items.ITEM_BOOK_GUIDE_TENT_GAME_NAME);	
		LanguageRegistry.addName(new ItemStack(guideBook, 1, 2), Items.ITEM_BOOK_GUIDE_EQUIP_GAME_NAME);	
		LanguageRegistry.addName(new ItemStack(guideBook, 1, 3), Items.ITEM_BOOK_GUIDE_FOOD_GAME_NAME);
		LanguageRegistry.addName(new ItemStack(guideBook, 1, 4), Items.ITEM_BOOK_GUIDE_WORLD_GAME_NAME);
		
	    MinecraftForge.addGrassSeed(new ItemStack(radishSeed), Config.PLANT_RADISH_DROP_RATE);
	}
}
