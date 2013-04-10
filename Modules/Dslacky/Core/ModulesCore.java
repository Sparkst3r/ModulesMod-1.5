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
import Modules.Dslacky.Core.Extra.WorldGen;
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

@Mod(modid = ModulesCore.modid , name = "Modules", version = "v1.2[1.5.1]" )
@NetworkMod(clientSideRequired=true, serverSideRequired=true)

public class ModulesCore {
	
	public static final String modid = "ModulesCore";

	
@SidedProxy(clientSide = "Modules.Dslacky.Core.Render.ClientProxy", serverSide= "Modules.Dslacky.Core.Render.CommonProxy")
public static CommonProxy proxy;
public static CreativeTabs Modules1 = new CreativeTabModules();
//Blocks
public static Block OreElectrode;
	public int OreElectrodeId;
public static Block OreCopper;
	public int OreCopperId;
public static Block OreTin;
	public int OreTinId;
public static Block OreSilver;
	public int OreSilverId;
public static Block OreLead;
	public int OreLeadId;
public static Block OreTitanium;
	public int OreTitaniumId;
public static Block BlockTitanium;
	public int BlockTitaniumId;
//Items
public static Item UnrefinedElectrodes;
	public int UnrefinedElectrodesId;
public static Item ImpureCopperIngot;
	public int ImpureCopperIngotId;
public static Item ImpureTinIngot;
	public int ImpureTinIngotId;
public static Item ImpureSilverIngot;
	public int ImpureSilverIngotId;
public static Item ImpureLeadIngot;
	public int ImpureLeadIngotId;
public static Item Electrode;
	public int ElectrodeId;
public static Item CopperIngot;
	public int CopperIngotId;
public static Item TinIngot;
	public int TinIngotId;
public static Item SilverIngot;
	public int SilverIngotId;
public static Item LeadIngot;
	public int LeadIngotId;
public static Item PowerCell;
	public int PowerCellId;
public static Item EmptyPowerCell;
	public int EmptyPowerCellId;
public static Item Filter;
	public int FilterId;
public static Item IronPlating;
	public int IronPlatingId;
public static Item StabilisingRod;
	public int StabilisingRodId;
public static Item FilterSheet;
	public int FilterSheetId;
public static Item ImpureTitaniumIngot;
	public int ImpureTitaniumIngotId;
public static Item TitaniumIngot;
	public int TitaniumIngotId;
public static Item InfusionChamber;
	public int InfusionChamberId;	
	@Instance("ModulesCore")
	public static ModulesCore instance;
	private GuiHandler guiHandler = new GuiHandler();
	public static Block RefineryIdle;
	public static Block RefineryActive;
	public static Block InfuserIdle;
	public static Block InfuserActive;
	
	public static final String mainDir = "/mods/ModulesCore/textures/";
	public static final String guiDir = mainDir + "guis/";
	public static final String entityDir = mainDir + "entities/";
	public static final String blockDir = mainDir + "blocks/";
	public static final String itemDir = mainDir + "items/";
@PreInit
	public void initConfig (FMLPreInitializationEvent evt){
		
		Configuration config = new Configuration (evt.getSuggestedConfigurationFile());
		config.load();
		//Blocks
		OreElectrodeId = config.getBlock("OreElectrode", Configuration.CATEGORY_BLOCK, 1002).getInt();		
		OreCopperId = config.getBlock("OreCopper", Configuration.CATEGORY_BLOCK, 1003).getInt();		
		OreTinId = config.getBlock("OreTin", Configuration.CATEGORY_BLOCK, 1004).getInt();		
		OreSilverId = config.getBlock("OreSilver", Configuration.CATEGORY_BLOCK, 1005).getInt();		
		OreLeadId = config.getBlock("OreLead", Configuration.CATEGORY_BLOCK, 1006).getInt();		
		OreTitaniumId = config.getBlock("OreTitanium", Configuration.CATEGORY_BLOCK, 1007).getInt();		
		BlockTitaniumId = config.getBlock("BlockTitanium", Configuration.CATEGORY_BLOCK, 1008).getInt();		
		//Items
		UnrefinedElectrodesId = config.getItem("UnrefinedElectrodes", Configuration.CATEGORY_ITEM, 15500).getInt();
		ImpureCopperIngotId = config.getItem("ImpureCopperIngot", Configuration.CATEGORY_ITEM, 15501).getInt();		
		ImpureTinIngotId = config.getItem("ImpureTinIngot", Configuration.CATEGORY_ITEM, 15502).getInt();		
		ImpureSilverIngotId = config.getItem("ImpureSilverIngot", Configuration.CATEGORY_ITEM, 15503).getInt();		
		ImpureLeadIngotId = config.getItem("ImpureLeadIngot", Configuration.CATEGORY_ITEM, 15504).getInt();		
		ElectrodeId = config.getItem("Electrode", Configuration.CATEGORY_ITEM, 15505).getInt();		
		CopperIngotId = config.getItem("CopperIngot", Configuration.CATEGORY_ITEM, 15506).getInt();		
		TinIngotId = config.getItem("TinIngot", Configuration.CATEGORY_ITEM, 15507).getInt();		
		SilverIngotId = config.getItem("SilverIngot", Configuration.CATEGORY_ITEM, 15508).getInt();		
		LeadIngotId = config.getItem("LeadIngot", Configuration.CATEGORY_ITEM, 15509).getInt();		
		PowerCellId = config.getItem("PowerCell", Configuration.CATEGORY_ITEM, 15510).getInt();		
		EmptyPowerCellId = config.getItem("EmptyPowerCell", Configuration.CATEGORY_ITEM, 15511).getInt();		
		FilterId = config.getItem("Filter", Configuration.CATEGORY_ITEM, 15512).getInt();		
		IronPlatingId = config.getItem("IronPlating", Configuration.CATEGORY_ITEM, 15513).getInt();		
		StabilisingRodId = config.getItem("StabilisingRod", Configuration.CATEGORY_ITEM, 15514).getInt();		
		FilterSheetId = config.getItem("FilterSheet", Configuration.CATEGORY_ITEM, 15515).getInt();		
		TitaniumIngotId = config.getItem("TitaniumIngot", Configuration.CATEGORY_ITEM, 15516).getInt();		
		ImpureTitaniumIngotId = config.getItem("ImpureTitaniumIngot", Configuration.CATEGORY_ITEM, 15517).getInt();		
		InfusionChamberId = config.getItem("Infusion Chamber", Configuration.CATEGORY_ITEM, 15523).getInt();		

		config.save();}
	@Init 
	public void load(FMLInitializationEvent fie){
        //blocks
		OreTin = (new TinOre(OreTinId, Material.iron)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
		OreCopper = (new CopperOre(OreCopperId, Material.iron)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
		OreSilver = (new SilverOre(OreSilverId, Material.iron)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
		OreLead = (new LeadOre(OreLeadId, Material.iron)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
		OreElectrode = (new ElectrodeOre(OreElectrodeId, Material.iron)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
		OreTitanium = (new TitaniumOre(OreTitaniumId, Material.iron)).setHardness(50.0F).setResistance(900.0F).setStepSound(Block.soundStoneFootstep);
		BlockTitanium = (new TitaniumBlock(BlockTitaniumId,Material.iron)).setHardness(50.0F).setResistance(900.0F).setStepSound(Block.soundStoneFootstep);

		RefineryIdle = new Refinery(1009, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		RefineryActive = new Refinery(1010, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);		
		InfuserIdle = new Infuser(1011, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		InfuserActive = new Infuser(1012, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);		

		//items
		//ImpureTinIngot = new ImpureTinIngot(ImpureTinIngotId);
		//ImpureCopperIngot = new ImpureCopperIngot(ImpureCopperIngotId);
		//ImpureSilverIngot = new ImpureSilverIngot(ImpureSilverIngotId);
		//ImpureLeadIngot = new ImpureLeadIngot(ImpureLeadIngotId);
		//ImpureTitaniumIngot = new ImpureTitaniumIngot(ImpureTitaniumIngotId);
		
		TitaniumIngot = new ItemIngot(TitaniumIngotId);
		CopperIngot = new ItemIngot(CopperIngotId);
		TinIngot = new ItemIngot(TinIngotId);
		SilverIngot = new ItemIngot(SilverIngotId);
		LeadIngot = new ItemIngot(LeadIngotId);

		EmptyPowerCell = new PowerCellEmpty(EmptyPowerCellId);
		PowerCell = new PowerCellEmpty(PowerCellId);
		
		UnrefinedElectrodes = new PowerCell(UnrefinedElectrodesId);	
		Electrode = new PowerCell(ElectrodeId);	
		Filter = new ExtraItem(FilterId);	
		IronPlating = new ExtraItem(IronPlatingId);	
		StabilisingRod = new ExtraItem(StabilisingRodId);	
		FilterSheet = new ExtraItem(FilterSheetId);
		InfusionChamber = new ExtraItem(InfusionChamberId);
		
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		GameRegistry.registerTileEntity(TileEntityRefinery.class,"tileEntityRefinery");				
		GameRegistry.registerBlock(RefineryIdle, "RefineryIdle");
		GameRegistry.registerBlock(RefineryActive, "RefineryActive");
	    LanguageRegistry.addName(RefineryIdle, "Refinery");
        //Infuser
		GameRegistry.registerTileEntity(TileEntityInfuser.class,"tileEntityInfuser");				
		GameRegistry.registerBlock(InfuserIdle, "InfuserIdle");
		GameRegistry.registerBlock(InfuserActive, "InfuserActive");
	    LanguageRegistry.addName(InfuserIdle, "Infuser");
		RegBlocks();
		GenWorld();
		Recipes();
		Smelting();
		langage();
		OreDictionary();
		
		
		
		proxy.registerRender();}
	public void RegBlocks(){
		GameRegistry.registerBlock(OreElectrode ,"Electrode Ore");
		GameRegistry.registerBlock(OreCopper ,"Copper Ore");	
		GameRegistry.registerBlock(OreTin ,"Tin Ore");	
		GameRegistry.registerBlock(OreSilver ,"Silver Ore");	
		GameRegistry.registerBlock(OreLead ,"Lead Ore");
		GameRegistry.registerBlock(OreTitanium ,"Titanium Ore");
		GameRegistry.registerBlock(BlockTitanium ,"Block Of Titanium");}
	public void GenWorld(){
		GameRegistry.registerWorldGenerator(new WorldGen());}
	public void Recipes(){
		GameRegistry.addRecipe(new ItemStack(EmptyPowerCell, 1), new Object[] {" B ","XBX"," X ",Character.valueOf('B'), Item.redstone,Character.valueOf('X'), Item.ingotIron,Character.valueOf('B'), Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(Filter, 1), new Object[] {"XXX","XBX","XXX",Character.valueOf('B'), FilterSheet,Character.valueOf('X'), Item.silk});
		GameRegistry.addRecipe(new ItemStack(FilterSheet, 1), new Object[] {"XXX","XBX","XXX",Character.valueOf('B'), Item.bucketWater,Character.valueOf('X'), Item.silk});
		GameRegistry.addRecipe(new ItemStack(IronPlating, 1), new Object[] {"OOO","XXX","OOO",Character.valueOf('X'), Item.ingotIron,Character.valueOf('O'), Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(StabilisingRod, 1), new Object[] {" X "," B "," X ",Character.valueOf('B'), Item.ingotGold,Character.valueOf('X'), Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(BlockTitanium, 1), new Object[] {"XXX","XXX","XXX",Character.valueOf('X'), TitaniumIngot});
        GameRegistry.addRecipe(new ItemStack(PowerCell, 1), new Object[] {"X  ","O  ","   ",Character.valueOf('X'), Electrode, Character.valueOf('O'), EmptyPowerCell});
        GameRegistry.addRecipe(new ItemStack(InfusionChamber, 1), new Object[] {"XBX","B B","XBX",Character.valueOf('X'), IronPlating, Character.valueOf('B'), StabilisingRod});
        GameRegistry.addRecipe(new ItemStack(RefineryIdle, 1), new Object[] {"XXX","BUB","FFF",Character.valueOf('X'), Block.stone,Character.valueOf('B'), Modules.Dslacky.Core.ModulesCore.StabilisingRod,Character.valueOf('U'), Modules.Dslacky.Core.ModulesCore.Filter,Character.valueOf('F'), Modules.Dslacky.Core.ModulesCore.IronPlating});
	    GameRegistry.addRecipe(new ItemStack(InfuserIdle, 1), new Object[] {"FBF","BUB","FBF",Character.valueOf('B'), Modules.Dslacky.Core.ModulesCore.StabilisingRod,Character.valueOf('U'), Modules.Dslacky.Core.ModulesCore.InfusionChamber,Character.valueOf('F'), Modules.Dslacky.Core.ModulesCore.IronPlating});}    
	
	public void RegItems(){
		GameRegistry.registerItem(CopperIngot, "Copper Ingot",  ModulesCore.modid);
	}
 
    
	//public void RegStacks(){
	//	ItemStack blackWoolStack = new ItemStack(ItemIngot, 42, 15);
	//}
	
	public void Smelting(){
		GameRegistry.addSmelting(OreCopper.blockID, new ItemStack(ImpureCopperIngot), 0.1F);
		GameRegistry.addSmelting(OreSilver.blockID, new ItemStack(ImpureSilverIngot), 0.3F);
		GameRegistry.addSmelting(OreTin.blockID, new ItemStack(ImpureTinIngot), 0.2F);
		GameRegistry.addSmelting(OreLead.blockID, new ItemStack(ImpureLeadIngot), 0.2F);
		GameRegistry.addSmelting(OreTitanium.blockID, new ItemStack(ImpureTitaniumIngot), 1.0F);}
	public void langage(){
			LanguageRegistry.addName(OreElectrode, "Electrode Ore");
			LanguageRegistry.addName(OreCopper, "Copper Ore");
			LanguageRegistry.addName(OreTin, "Tin Ore");
			LanguageRegistry.addName(OreSilver, "Silver Ore");
			LanguageRegistry.addName(OreLead, "Lead Ore");
		    LanguageRegistry.addName(OreTitanium, "Titanium Ore");
	        LanguageRegistry.addName(BlockTitanium, "Titanium Block");

	        LanguageRegistry.addName(ImpureTinIngot,"Impure Tin Ingot");
	        LanguageRegistry.addName(ImpureCopperIngot,"Impure Copper Ingot");
	        LanguageRegistry.addName(ImpureSilverIngot,"Impure Silver Ingot");
	        LanguageRegistry.addName(ImpureLeadIngot,"Impure Lead Ingot");
	        LanguageRegistry.addName(ImpureTitaniumIngot,"Impure Titanium Ingot");
	        LanguageRegistry.addName(TitaniumIngot,"Titanium Ingot");
	        LanguageRegistry.addName(CopperIngot,"Copper Ingot");
	        LanguageRegistry.addName(TinIngot,"Tin Ingot");
	        LanguageRegistry.addName(SilverIngot,"Silver Ingot");
	        LanguageRegistry.addName(LeadIngot,"Lead Ingot");
	        LanguageRegistry.addName(EmptyPowerCell,"Empty Power Cell");
	        LanguageRegistry.addName(PowerCell,"Power Cell");
	        LanguageRegistry.addName(UnrefinedElectrodes,"Unrefined Electrodes");
	        LanguageRegistry.addName(Electrode,"Electrode");
	        LanguageRegistry.addName(Filter,"Filter");
	        LanguageRegistry.addName(IronPlating,"Metal Plating");
	        LanguageRegistry.addName(StabilisingRod,"Stabilising Rod");
	        LanguageRegistry.addName(FilterSheet,"Filter Sheet");
	        LanguageRegistry.addName(InfusionChamber, "Infusion Chamber");
}

	public void OreDictionary(){
		OreDictionary.registerOre("ingotTin", new ItemStack(TinIngot));
		OreDictionary.registerOre("ingotLead", new ItemStack(LeadIngot));
		OreDictionary.registerOre("ingotSilver", new ItemStack(SilverIngot));
		OreDictionary.registerOre("ingotCopper", new ItemStack(CopperIngot));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(TitaniumIngot));
	}
}