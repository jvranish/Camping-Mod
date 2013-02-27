package camping.common.rikmuld.core.register;

import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.lib.ItemStacks;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipies {
    
	static ItemStacks IS;
	
	public static void init() 
	{
		GameRegistry.addShapelessRecipe(IS.marsh1, IS.stick, IS.marsh);
		GameRegistry.addShapelessRecipe(IS.tentPegs_4, IS.iron, IS.toolCampDamage);
		GameRegistry.addShapelessRecipe(IS.canvas_10, IS.string, IS.string, IS.string, IS.string, IS.string, IS.string, IS.toolCampDamage);
		
		GameRegistry.addRecipe(IS.tent1, "xxx", "x x", "y y", 'x', IS.canvas, 'y',IS.tentPegs);
		GameRegistry.addRecipe(IS.SleepBag, "   ", "   ", "xxx", 'x', IS.wool);
		GameRegistry.addRecipe(IS.toolCampNoDamage, "yxy", "yxy", "yxy", 'x', IS.iron, 'y', IS.rosered);
		GameRegistry.addRecipe(IS.campfire, " x ", "xyx", "zzz", 'x', IS.torch, 'y', IS.flint, 'z', IS.stone);
		GameRegistry.addRecipe(IS.campfireMulti, " x ", "xyx", " x ", 'x', IS.furnace, 'y', IS.campfire);
		GameRegistry.addRecipe(IS.campfireFast, " x ", "xyx", "   ", 'x', IS.flintst, 'y', IS.campfire);
		GameRegistry.addRecipe(IS.campfireCheap, " x ", "xyx", " z ", 'x', IS.coal, 'y', IS.campfire, 'z', IS.enderp);
		GameRegistry.addRecipe(IS.marsh, "xyx", "xzx", "xax", 'x', IS.sugar, 'y', IS.waterbottle, 'z', IS.egg, 'a', IS.bowl);
		GameRegistry.addRecipe(IS.campingBagSmall, "xxx", "x x", "xxx", 'x', IS.canvas);
		GameRegistry.addRecipe(IS.campingBagNormal, "xxx", "xyx", "xxx", 'x', IS.canvas, 'y',IS.campingBagSmall);
		GameRegistry.addRecipe(IS.campingBagLarge, "xxx", "xyx", "xxx", 'x', IS.canvas, 'y',IS.campingBagNormal);
		
		if(Config.CAMPFIRE_INSTA_COOK_ENABLED)
		{
			GameRegistry.addRecipe(IS.campfireInsta, "   ", " a ", "bcd", 'a', IS.campfireFast, 'b', IS.campfireMulti, 'c', IS.campfire, 'd', IS.campfireCheap);
		}
	}
}
