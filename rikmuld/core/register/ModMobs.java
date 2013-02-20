package camping.common.rikmuld.core.register;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.entity.Camper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModMobs {

	public static int startEntityId = 300;
	
	public static int getUniqueEntityId() 
	{	
		do {startEntityId++;} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	 
	public static void init() 
	{
		LanguageRegistry.instance().addStringLocalization("entity.CampingMod.Camper.name", "Camper");
		
		EntityRegistry.registerModEntity(Camper.class, "Camper", 1, CampingMod.instance, 80, 3, true);
		EntityRegistry.addSpawn(Camper.class, 1, 1, 4, EnumCreatureType.creature);
		
		registerEntityEgg(Camper.class, 0x747B51, 0x70471B);
	}
}
