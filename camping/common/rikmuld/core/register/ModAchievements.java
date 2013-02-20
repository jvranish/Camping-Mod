package camping.common.rikmuld.core.register;

import camping.common.rikmuld.core.lib.ItemStacks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModAchievements {

	private static void addAchievementName(String ach, String name) 
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,"en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc) 
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	
	static void addAchievementLocalizations() 
	{
		ModAchievements.addAchievementName("campachiev", "Campfires!");
		ModAchievements.addAchievementName("campachiev1", "The begining of tents!");
		ModAchievements.addAchievementName("campachiev2", "Campfire tales!");
		ModAchievements.addAchievementName("campachiev3", "Cooking efficient!");
		ModAchievements.addAchievementName("campachiev4", "Power Cooker!");
		ModAchievements.addAchievementName("campachiev5", "We don't need coal!");
		ModAchievements.addAchievementName("campachiev6", "Campfire legend!");
		ModAchievements.addAchievementName("campachiev7", "Tents are awesome!");
		ModAchievements.addAchievementName("campachiev8", "The power of storage!");
		ModAchievements.addAchievementName("campachiev9", "Sleepover!");

		ModAchievements.addAchievementDesc("campachiev", "Make a campfire!");
		ModAchievements.addAchievementDesc("campachiev1", "Make some tent parts!");
		ModAchievements.addAchievementDesc("campachiev2", "Cook a marshmallow!");
		ModAchievements.addAchievementDesc("campachiev3","Make the multi cooking campfire!");
		ModAchievements.addAchievementDesc("campachiev4","Make the fast cooking campfire!");
		ModAchievements.addAchievementDesc("campachiev5","Make the cheap cooking campfire!");
		ModAchievements.addAchievementDesc("campachiev6","Make the insta cooking campfire!");
		ModAchievements.addAchievementDesc("campachiev7", "Make a tent!");
		ModAchievements.addAchievementDesc("campachiev8", "Make a storage tent!");
		ModAchievements.addAchievementDesc("campachiev9", "Make a sleeping tent!");
	}
	
	public static Achievement campachiev;
	public static Achievement campachiev1;
	public static Achievement campachiev2;
	public static Achievement campachiev3;
	public static Achievement campachiev4;
	public static Achievement campachiev5;
	public static Achievement campachiev6;
	public static Achievement campachiev7;
	public static Achievement campachiev8;
	public static Achievement campachiev9;

	public static AchievementPage campachivepage;
	
	public static void init() 
	{
		campachiev = new Achievement(2500,"campachiev", 0, -2, ModBlocks.campfireMultiCooker, null).registerAchievement();
		campachiev1 = new Achievement(2501,"campachiev1", 2, -2, ModItems.TentParts, null).registerAchievement();
		campachiev2 = new Achievement(2502,"campachiev2", -2, -3, ModItems.MarshmallowFood,ModAchievements.campachiev).registerAchievement();
		campachiev3 = new Achievement(2503,"campachiev3", -1, 0, ItemStacks.campfireMulti, ModAchievements.campachiev).registerAchievement();
		campachiev4 = new Achievement(2504,"campachiev4", -1, 1, ModBlocks.campfireFastCooker, ModAchievements.campachiev).registerAchievement();
		campachiev5 = new Achievement(2505,"campachiev5", -1, 2, ModBlocks.campfireCheapCooker, ModAchievements.campachiev).registerAchievement();
		campachiev6 = new Achievement(2506,"campachiev6", -2, 1, ItemStacks.campfireInsta, ModAchievements.campachiev4).registerAchievement();
		campachiev7 = new Achievement(2507,"campachiev7", 4, -1, ModBlocks.tent, ModAchievements.campachiev1).registerAchievement();
		campachiev8 = new Achievement(2508,"campachiev8", 3, 1, Block.chest, ModAchievements.campachiev7).registerAchievement();
		campachiev9 = new Achievement(2509,"campachiev9", 3, 2, Item.bed, ModAchievements.campachiev7).registerAchievement();

		campachivepage = new AchievementPage("Camping milestones", campachiev, campachiev1, campachiev2, campachiev3, campachiev4, campachiev5, campachiev6, campachiev7, campachiev8, campachiev9);
		
		AchievementPage.registerAchievementPage(campachivepage);
		ModAchievements.addAchievementLocalizations();
	}
}
