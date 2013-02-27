package camping.common.rikmuld.core.register;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.lib.ModInfo;

public class ModConfig {

	public static Configuration config;
	 
	public static void preInit(File configFile) 
	{ 
		 config = new Configuration(configFile);
		 
		 try
		 {
			 config.load();
			 		
			 Items.ITEM_TENT_PARTS_ID = config.getItem(Items.ITEM_META_TENT_PARTS_GAME_NAME, Items.ITEM_TENT_PARTS_ID_DEV).getInt(Items.ITEM_TENT_PARTS_ID_DEV);
			 Items.ITEM_TENT_CONTENTS_ID = config.getItem(Items.ITEM_TENT_CONTENTS_GAME_NAME, Items.ITEM_TENT_CONTENTS_ID_DEV).getInt(Items.ITEM_TENT_CONTENTS_ID_DEV);
			 Items.ITEM_MARSH_ID = config.getItem(Items.ITEM_META_MARSH_GAME_NAME, Items.ITEM_MARSH_ID_DEV).getInt(Items.ITEM_MARSH_ID_DEV);
			 Items.ITEM_MARSH_FOOD_ID = config.getItem(Items.ITEM_MARSH_FOOD_GAME_NAME, Items.ITEM_MARSH_FOOD_ID_DEV).getInt(Items.ITEM_MARSH_FOOD_ID_DEV);
			 Items.ITEM_TOOL_CAMP_ID = config.getItem(Items.ITEM_TOOL_CAMP_GAME_NAME, Items.ITEM_TOOL_CAMP_ID_DEV).getInt(Items.ITEM_TOOL_CAMP_ID_DEV);
			 Items.ITEM_TOOL_BACK_ID = config.getItem(Items.ITEM_META_TOOL_BACK_GAME_NAME, Items.ITEM_TOOL_BACK_ID_DEV).getInt(Items.ITEM_TOOL_BACK_ID_DEV);
			 Items.ITEM_RADISH_SEED_ID = config.getItem(Items.ITEM_RADISH_SEED_GAME_NAME, Items.ITEM_RADISH_SEED_ID_DEV).getInt(Items.ITEM_RADISH_SEED_ID_DEV);
			 Items.ITEM_RADISH_FOOD_ID = config.getItem(Items.ITEM_RADISH_FOOD_GAME_NAME, Items.ITEM_RADISH_FOOD_ID_DEV).getInt(Items.ITEM_RADISH_FOOD_ID_DEV);
	
			 if(Items.ITEM_TENT_PARTS_ID<4096||Items.ITEM_TENT_CONTENTS_ID<4096||Items.ITEM_MARSH_ID<4096||Items.ITEM_MARSH_FOOD_ID<4096||Items.ITEM_TOOL_CAMP_ID<4096||Items.ITEM_TOOL_BACK_ID<4096||Items.ITEM_RADISH_SEED_ID<4096||Items.ITEM_RADISH_FOOD_ID<4096)
			 {
				 ModLogger.log(Level.WARNING, "You used an unusable item id in the config, old ones are used now");
				 
				 Items.ITEM_TENT_PARTS_ID = Items.ITEM_TENT_PARTS_ID_DEV;
				 Items.ITEM_TENT_CONTENTS_ID =  Items.ITEM_TENT_CONTENTS_ID_DEV;
				 Items.ITEM_MARSH_ID = Items.ITEM_MARSH_ID_DEV;
				 Items.ITEM_MARSH_FOOD_ID =  Items.ITEM_MARSH_FOOD_ID_DEV;
				 Items.ITEM_TOOL_CAMP_ID = Items.ITEM_TOOL_CAMP_ID_DEV;
				 Items.ITEM_TOOL_BACK_ID = Items.ITEM_TOOL_BACK_ID_DEV;
				 Items.ITEM_RADISH_SEED_ID = Items.ITEM_RADISH_SEED_ID_DEV;
				 Items.ITEM_RADISH_FOOD_ID = Items.ITEM_RADISH_FOOD_ID_DEV;
			 }
			 
			 
			 Blocks.BLOCK_CAMP_MULTI_ID = config.getBlock(Blocks.BLOCK_META_CAMP_NORMAL_MULTI_GAME_NAME, Blocks.BLOCK_CAMP_MULTI_ID_DEV).getInt(Blocks.BLOCK_CAMP_MULTI_ID_DEV);
			 Blocks.BLOCK_CAMP_FAST_ID = config.getBlock(Blocks.BLOCK_CAMP_FAST_GAME_NAME, Blocks.BLOCK_CAMP_FAST_ID_DEV).getInt(Blocks.BLOCK_CAMP_FAST_ID_DEV);
			 Blocks.BLOCK_CAMP_CHEAP_ID = config.getBlock(Blocks.BLOCK_META_CAMP_CHEAP_INSTA_GAME_NAME, Blocks.BLOCK_CAMP_CHEAP_ID_DEV).getInt(Blocks.BLOCK_CAMP_CHEAP_ID_DEV); 
			 Blocks.BLOCK_TENT_ID = config.getBlock(Blocks.BLOCK_TENT_GAME_NAME, Blocks.BLOCK_TENT_ID_DEV).getInt(Blocks.BLOCK_TENT_ID_DEV);
			 Blocks.BLOCK_GHOST_ID = config.getBlock(Blocks.BLOCK_GHOST_GAME_NAME, Blocks.BLOCK_GHOST_ID_DEV).getInt(Blocks.BLOCK_GHOST_ID_DEV);
			 Blocks.BLOCK_RADISH_ID = config.getBlock(Blocks.BLOCK_RADISH_GAME_NAME, Blocks.BLOCK_RADISH_ID_DEV).getInt(Blocks.BLOCK_RADISH_ID_DEV);
			 
			
			 if(Blocks.BLOCK_CAMP_MULTI_ID>4096||Blocks.BLOCK_CAMP_MULTI_ID<256||Blocks.BLOCK_CAMP_FAST_ID>4096||Blocks.BLOCK_CAMP_FAST_ID<256||Blocks.BLOCK_CAMP_CHEAP_ID>4096||Blocks.BLOCK_CAMP_CHEAP_ID<256||Blocks.BLOCK_TENT_ID>4096||Blocks.BLOCK_TENT_ID<256||Blocks.BLOCK_GHOST_ID>4096||Blocks.BLOCK_GHOST_ID<256||Blocks.BLOCK_RADISH_ID>4096||Blocks.BLOCK_RADISH_ID<256)
			 {
				 ModLogger.log(Level.WARNING, "You used an unusable block id in the config, old ones are used now.");
				 
				 Blocks.BLOCK_CAMP_MULTI_ID =  Blocks.BLOCK_CAMP_MULTI_ID_DEV;
				 Blocks.BLOCK_CAMP_FAST_ID = Blocks.BLOCK_CAMP_FAST_ID_DEV;
				 Blocks.BLOCK_CAMP_CHEAP_ID =  Blocks.BLOCK_CAMP_CHEAP_ID_DEV;
				 Blocks.BLOCK_TENT_ID = Blocks.BLOCK_TENT_ID_DEV;
				 Blocks.BLOCK_GHOST_ID = Blocks.BLOCK_GHOST_ID_DEV;
				 Blocks.BLOCK_RADISH_ID = Blocks.BLOCK_RADISH_ID_DEV;
			 }
			 
			 Config.WORLD_GEN_ENABLED = config.get(Config.CATEGORY_WORLD_GEN, Config.WORLD_GEN_ENABLED_MESSAGE, Config.WORLD_GEN_ENABLED_DEV).getBoolean(Config.WORLD_GEN_ENABLED_DEV);
			 Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE = config.get(Config.CATEGORY_WORLD_GEN, Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE_MESSAGE, Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE_DEV).getBoolean(Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE_DEV); 
			 Config.WORLD_GEN_SMALL_CAMP_SPAWN_RARENESS = config.get(Config.CATEGORY_WORLD_GEN, Config.WORD_GEN_SMALL_CAMP_SPAWN_RARENESS_MESSAGE, Config.WORLD_GEN_SMALL_CAMP_SPAWN_RARENESS_DEV).getInt(Config.WORLD_GEN_SMALL_CAMP_SPAWN_RARENESS_DEV);
			 Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE = config.get(Config.CATEGORY_WORLD_GEN, Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE_MESSAGE, Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE_DEV).getInt(Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE_DEV);
			 
			 Config.GENERAL_CAMPTOOL_MAX_DURABILATY = config.get(Config.CATEGORY_GENERAL,  Config.GENERAL_CAMPTOOL_MAX_DURABILATY_MESSAGE, Config.GENERAL_CAMPTOOL_MAX_DURABILATY_DEV).getInt(Config.GENERAL_CAMPTOOL_MAX_DURABILATY_DEV);
			 
			 Config.PLANT_RADISH_HEAL = config.get(Config.CATEGORY_PLANT, Config.PLANT_RADISH_HEAL_MESSAGE, Config.PLANT_RADISH_HEAL_DEV).getInt(Config.PLANT_RADISH_HEAL_DEV);
			 Config.PLANT_MARSHMALLOW_HEAL = config.get(Config.CATEGORY_PLANT, Config.PLANT_MARSHMALLOW_HEAL_MESSAGE, Config.PLANT_MARSHMALLOW_HEAL_DEV).getInt(Config.PLANT_MARSHMALLOW_HEAL_DEV);
			 Config.PLANT_RADISH_DROP_RATE = config.get(Config.CATEGORY_PLANT, Config.PLANT_RADISH_DROP_RATE_MESSAGE, Config.PLANT_RADISH_DROP_RATE_DEV).getInt(Config.PLANT_RADISH_DROP_RATE_DEV);
			 Config.PLANT_RADISH_GROW_RATE = config.get(Config.CATEGORY_PLANT, Config.PLANT_RADISH_GROW_RATE_MESSAGE, Config.PLANT_RADISH_GROW_RATE_DEV).getDouble(Config.PLANT_RADISH_GROW_RATE_DEV);
		 
			 Config.CAMPFIRE_CAN_BURN = config.get(Config.CATEGORY_CAMPFIRE, Config.CAMPFIRE_CAN_BURN_MESSAGE, Config.CAMPFIRE_CAN_BURN_DEV).getBoolean(Config.CAMPFIRE_CAN_BURN_DEV);
			 Config.CAMPFIRE_INSTA_COOK_ENABLED = config.get(Config.CATEGORY_CAMPFIRE, Config.CAMPFIRE_INSTA_COOK_ENABLED_MESSAGE, Config.CAMPFIRE_INSTA_COOK_ENABLED_DEV).getBoolean(Config.CAMPFIRE_INSTA_COOK_ENABLED_DEV);
			 Config.CAMPFIRE_CAN_TRANS_STICK = config.get(Config.CATEGORY_CAMPFIRE, Config.CAMPFIRE_CAN_TRANS_STICK_MESSAGE, Config.CAMPFIRE_CAN_TRANS_STICK_DEV).getBoolean(Config.CAMPFIRE_CAN_TRANS_STICK_DEV);
			 Config.CAMPFIRE_CAN_BE_RECOLORED = config.get(Config.CATEGORY_CAMPFIRE, Config.CAMPFIRE_CAN_BE_RECOLORED_MESSAGE, Config.CAMPFIRE_CAN_BE_RECOLORED_DEV).getBoolean(Config.CAMPFIRE_CAN_BE_RECOLORED_DEV);		
		 }
		 
		 catch(Exception e)
		 {
			 ModLogger.log(Level.SEVERE, ModInfo.MOD_NAME + " could not load its configuration properly.");
		 }
		 
		 finally
		 {
			 config.save();
		 }
	}
}
