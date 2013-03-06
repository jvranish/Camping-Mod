package rikmuld.core.register;

import rikmuld.core.lib.Config;
import rikmuld.core.lib.ItemStacks;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipies {
	
	public static void init() 
	{
		GameRegistry.addShapelessRecipe(ItemStacks.marsh1, ItemStacks.stick, ItemStacks.marsh);
		GameRegistry.addShapelessRecipe(ItemStacks.tentPegs_4, ItemStacks.iron, ItemStacks.toolCampDamage);
		GameRegistry.addShapelessRecipe(ItemStacks.canvas_10, ItemStacks.string, ItemStacks.string, ItemStacks.string, ItemStacks.string, ItemStacks.string, ItemStacks.string, ItemStacks.toolCampDamage);
		
		GameRegistry.addRecipe(ItemStacks.tent1, "xxx", "x x", "y y", 'x', ItemStacks.canvas, 'y',ItemStacks.tentPegs);
		GameRegistry.addRecipe(ItemStacks.SleepBag, "   ", "   ", "xxx", 'x', ItemStacks.wool);
		GameRegistry.addRecipe(ItemStacks.toolCampNoDamage, "yxy", "yxy", "yxy", 'x', ItemStacks.iron, 'y', ItemStacks.rosered);
		GameRegistry.addRecipe(ItemStacks.campfire, " x ", "xyx", "zzz", 'x', ItemStacks.torch, 'y', ItemStacks.flint, 'z', ItemStacks.stone);
		GameRegistry.addRecipe(ItemStacks.campfireMulti, " x ", "xyx", " x ", 'x', ItemStacks.furnace, 'y', ItemStacks.campfire);
		GameRegistry.addRecipe(ItemStacks.campfireFast, " x ", "xyx", "   ", 'x', ItemStacks.flintst, 'y', ItemStacks.campfire);
		GameRegistry.addRecipe(ItemStacks.campfireCheap, " x ", "xyx", " z ", 'x', ItemStacks.coal, 'y', ItemStacks.campfire, 'z', ItemStacks.enderp);
		GameRegistry.addRecipe(ItemStacks.marsh, "xyx", "xzx", "xax", 'x', ItemStacks.sugar, 'y', ItemStacks.waterbottle, 'z', ItemStacks.egg, 'a', ItemStacks.bowl);
		GameRegistry.addRecipe(ItemStacks.campingBagSmall, "xxx", "x x", "xxx", 'x', ItemStacks.canvas);
		GameRegistry.addRecipe(ItemStacks.campingBagNormal, "xxx", "xyx", "xxx", 'x', ItemStacks.canvas, 'y',ItemStacks.campingBagSmall);
		GameRegistry.addRecipe(ItemStacks.campingBagLarge, "xxx", "xyx", "xxx", 'x', ItemStacks.canvas, 'y',ItemStacks.campingBagNormal);
		
		if(Config.CAMPFIRE_INSTA_COOK_ENABLED)
		{
			GameRegistry.addRecipe(ItemStacks.campfireInsta, "   ", " a ", "bcd", 'a', ItemStacks.campfireFast, 'b', ItemStacks.campfireMulti, 'c', ItemStacks.campfire, 'd', ItemStacks.campfireCheap);
		}
	}
}
