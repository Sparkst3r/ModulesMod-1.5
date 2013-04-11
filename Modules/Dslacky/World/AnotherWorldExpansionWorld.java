package Modules.Dslacky.World;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import Modules.Dslacky.Core.GlobalValues;
import Modules.Dslacky.Core.Render.CommonProxy;

@Mod(
		modid = GlobalValues.ModIDWorld, 
		name = GlobalValues.ModNameWorld, 
		version = GlobalValues.ModVersion,
		dependencies = GlobalValues.Core 
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class AnotherWorldExpansionWorld {
	
	//SidedProxy annotation to specify the Client and Common proxies
	@SidedProxy(
	clientSide = "Modules.Dslacky.Core.Render.ClientProxy",
	serverSide = "Modules.Dslacky.Core.Render.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    	WorldValues.initialize();
    	GameRegistry.registerWorldGenerator(new WorldGenerator());
    }
    
	//Called during the loading phase
	@Init 
	public void load(FMLInitializationEvent event) {
	}
	
	//Called during the post-load phase
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
