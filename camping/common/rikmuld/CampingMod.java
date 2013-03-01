package camping.common.rikmuld;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import camping.common.rikmuld.core.handlers.CraftHandler;
import camping.common.rikmuld.core.helper.CheckVersion;
import camping.common.rikmuld.core.lib.ModInfo;
import camping.common.rikmuld.core.proxys.CommonProxy;
import camping.common.rikmuld.core.register.ModAchievements;
import camping.common.rikmuld.core.register.ModBlocks;
import camping.common.rikmuld.core.register.ModConfig;
import camping.common.rikmuld.core.register.ModEvents;
import camping.common.rikmuld.core.register.ModItems;
import camping.common.rikmuld.core.register.ModLogger;
import camping.common.rikmuld.core.register.ModMobs;
import camping.common.rikmuld.core.register.ModRecipies;
import camping.common.rikmuld.core.register.ModTileEntitys;
import camping.common.rikmuld.core.tab.CampingTab;
import camping.common.rikmuld.world.WorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, dependencies = ModInfo.MOD_DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CampingMod {

	public static CreativeTabs customTab = new CampingTab("customTab");
	
	@Instance(ModInfo.MOD_ID)
	public static CampingMod instance;
	
	@SidedProxy(clientSide = ModInfo.MOD_CLIENT_PROXY, serverSide = ModInfo.MOD_SERVER_PROXY)
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ModLogger.preinit();
		ModConfig.preInit(new File(event.getModConfigurationDirectory().getAbsolutePath() + "\\Camping\\" + ModInfo.MOD_ID + ".cfg"));
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		proxy.registerRenderers();
		
		NetworkRegistry.instance().registerGuiHandler(this, this.proxy);	
		LanguageRegistry.instance().addStringLocalization("itemGroup.customTab", "en_US", "Camping Stuff");
		
		ModBlocks.init();
		ModItems.init();
		ModTileEntitys.init();
		ModRecipies.init();
		ModAchievements.init();
		ModMobs.init();
		ModEvents.init();
		
		GameRegistry.registerCraftingHandler(new CraftHandler());
		GameRegistry.registerWorldGenerator(new WorldGen());	
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		 ModLogger.log(Level.INFO, ModInfo.MOD_NAME + " has loaded successfylly.");
	}
}
