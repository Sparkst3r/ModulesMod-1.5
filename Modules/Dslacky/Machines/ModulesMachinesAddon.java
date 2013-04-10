package Modules.Dslacky.Machines;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import Modules.Dslacky.Core.Render.CommonProxy;
import Modules.Dslacky.Machines.Blocks.Infuser;
import Modules.Dslacky.Machines.Blocks.Refinery;
import Modules.Dslacky.Machines.Render.GuiHandler;
import Modules.Dslacky.Machines.Render.TileEntityInfuser;
import Modules.Dslacky.Machines.Render.TileEntityRefinery;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ModulesMachinesAddon", name = "ModulesMachinesAddon", version = "v1.2" )
@NetworkMod(clientSideRequired=true, serverSideRequired=true)

public class ModulesMachinesAddon {
@SidedProxy(clientSide = "Modules.Dslacky.Core.Render.ClientProxy", serverSide= "Modules.Dslacky.Core.Render.CommonProxy")
public static CommonProxy proxy;
//Blocks
//Items
@PreInit
	public void initConfig (FMLPreInitializationEvent evt){
		
		Configuration config = new Configuration (evt.getSuggestedConfigurationFile());
		config.load();
		//Blocks

		config.save();}
	@Init 
	public void load(FMLInitializationEvent fie){
//Refinery
	
	    
	    //items
		RegBlocks();
		GenWorld();
		Recipes();
		Smelting();
		langage();
		OreDictionary();
		
		proxy.registerRender();}
	public void RegBlocks(){}
	public void GenWorld(){}
	public void Recipes(){}
public void Smelting(){}
	public void langage(){}
	public void OreDictionary(){}
}