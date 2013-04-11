package Modules.Dslacky.Core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import Modules.Dslacky.Core.Blocks.CopperOre;
import Modules.Dslacky.Core.Blocks.ElectrodeOre;
import Modules.Dslacky.Core.Blocks.LeadOre;
import Modules.Dslacky.Core.Blocks.SilverOre;
import Modules.Dslacky.Core.Blocks.TinOre;
import Modules.Dslacky.Core.Blocks.TitaniumBlock;
import Modules.Dslacky.Core.Blocks.TitaniumOre;
import Modules.Dslacky.Core.Extra.CreativeTabModules;
//import Modules.Dslacky.Core.Extra.WorldGen;
import Modules.Dslacky.Core.Items.ExtraItem;
import Modules.Dslacky.Core.Items.PowerCell;
import Modules.Dslacky.Core.Items.PowerCellEmpty;
import Modules.Dslacky.Core.Items.*;
import Modules.Dslacky.Core.Items.ItemIngot;
import Modules.Dslacky.Core.Render.CommonProxy;
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
import Modules.Dslacky.Machines.ModulesMachinesAddon;
import Modules.Dslacky.Machines.Blocks.Infuser;
import Modules.Dslacky.Machines.Blocks.Refinery;
import Modules.Dslacky.Machines.Render.GuiHandler;
import Modules.Dslacky.Machines.Render.TileEntityInfuser;
import Modules.Dslacky.Machines.Render.TileEntityRefinery;

@Mod(modid = ModulesCore.modid, name = "Modules", version = "v1.2[1.5.1]")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class ModulesCore {

	public static final String modid = "ModulesCore";

	@SidedProxy(clientSide = "Modules.Dslacky.Core.Render.ClientProxy", serverSide = "Modules.Dslacky.Core.Render.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs Modules1 = new CreativeTabModules();
	@Instance("ModulesCore")
	public static ModulesCore instance;
	
	//Blocks
	public static Block BlockOreField;
	public static Block RefineryIdle;
	public static Block RefineryActive;
	public static Block InfuserIdle;
	public static Block InfuserActive;
	
	//Gui Handler
	private GuiHandler guiHandler = new GuiHandler();
	
	public void load(FMLInitializationEvent fie){
	
	RefineryIdle = new Refinery(1009, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
	RefineryActive = new Refinery(1010, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);		
	InfuserIdle = new Infuser(1011, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
	InfuserActive = new Infuser(1012, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);	

}
}