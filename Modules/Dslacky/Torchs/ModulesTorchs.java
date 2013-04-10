/*
package Modules.Dslacky.Torchs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import Modules.Dslacky.Core.Render.CommonProxy;
import Modules.Dslacky.Torchs.Blocks.BlockTorchBlue;
import Modules.Dslacky.Torchs.Blocks.BlockTorchGreen;
import Modules.Dslacky.Torchs.Blocks.BlockTorchPurple;
import Modules.Dslacky.Torchs.Blocks.BlockTorchRed;
import Modules.Dslacky.Torchs.Blocks.BlockTorchWhite;
import Modules.Dslacky.Torchs.Items.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ModulesTorchs", name = "ModulesTorchs", version = "v2.1" )
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class ModulesTorchs {
@SidedProxy(clientSide = "Modules.Dslacky.Core.Render.ClientProxy", serverSide= "Modules.Dslacky.Core.Render.CommonProxy")
public static CommonProxy proxy;
//Blocks
public static Block InfusedRedTorch;
	public int InfusedRedTorchId;
public static Block InfusedGreenTorch;
	public int InfusedGreenTorchId;
public static Block InfusedWhiteTorch;
	public int InfusedWhiteTorchId;
public static Block InfusedPurpleTorch;
	public int InfusedPurpleTorchId;
public static Block InfusedBlueTorch;
	public int InfusedBlueTorchId;
//Items
public static Item InfusedRedCoal;
	public int InfusedRedCoalId;
public static Item InfusedGreenCoal;
	public int InfusedGreenCoalId;
public static Item InfusedWhiteCoal;
	public int InfusedWhiteCoalId;
public static Item InfusedPurpleCoal;
	public int InfusedPurpleCoalId;
public static Item InfusedBlueCoal;
	public int InfusedBlueCoalId;

@PreInit
	public void initConfig (FMLPreInitializationEvent evt){
		
		Configuration config = new Configuration (evt.getSuggestedConfigurationFile());
		config.load();
		//Blocks
		InfusedRedTorchId = config.get(Configuration.CATEGORY_BLOCK, "InfusedRedTorch", 1013).getInt();		
		InfusedGreenTorchId = config.get(Configuration.CATEGORY_BLOCK, "InfusedGreenTorch", 1014).getInt();	
		InfusedWhiteTorchId = config.get(Configuration.CATEGORY_BLOCK, "InfusedWhiteTorch", 1015).getInt();		
		InfusedPurpleTorchId = config.get(Configuration.CATEGORY_BLOCK, "InfusedPurpleTorch", 1016).getInt();		
		InfusedBlueTorchId = config.get(Configuration.CATEGORY_BLOCK, "InfusedBlueTorch", 1017).getInt();		
		//Items//1049
		InfusedRedCoalId = config.get(Configuration.CATEGORY_ITEM, "InfusedRedCoal", 15518).getInt();
		InfusedGreenCoalId = config.get(Configuration.CATEGORY_ITEM, "InfusedGreenCoal", 15519).getInt();	
		InfusedWhiteCoalId = config.get(Configuration.CATEGORY_ITEM, "InfusedWhiteCoal", 15520).getInt();
		InfusedPurpleCoalId = config.get(Configuration.CATEGORY_ITEM, "InfusedPurpleCoal", 15521).getInt();		
		InfusedBlueCoalId = config.get(Configuration.CATEGORY_ITEM, "InfusedBlueCoal", 15522).getInt();	
		config.save();}
	@Init 
	public void load(FMLInitializationEvent fie){
//blocks
		InfusedRedTorch = (new BlockTorchRed(InfusedRedTorchId, 4)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1);
		InfusedGreenTorch = (new BlockTorchGreen(InfusedGreenTorchId, 1)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1);
		InfusedWhiteTorch = (new BlockTorchWhite(InfusedWhiteTorchId, 3)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1);
		InfusedPurpleTorch = (new BlockTorchPurple(InfusedPurpleTorchId, 2)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1);
		InfusedBlueTorch = (new BlockTorchBlue(InfusedBlueTorchId, 0)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1);

		//items
		InfusedRedCoal = (new InfusedCoal(InfusedRedCoalId).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1));
		InfusedGreenCoal = (new InfusedCoal (InfusedGreenCoalId).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1));
		InfusedWhiteCoal = (new InfusedCoal(InfusedWhiteCoalId).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1));
		InfusedPurpleCoal = (new InfusedCoal(InfusedPurpleCoalId).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1));
		InfusedBlueCoal = (new InfusedCoal(InfusedBlueCoalId).setCreativeTab(Modules.Dslacky.Core.ModulesCore.Modules1));
		RegBlocks();
		GenWorld();
		Recipes();
		Smelting();
		langage();
		OreDictionary();
		
		proxy.registerRender();}
	public void RegBlocks(){
		GameRegistry.registerBlock(InfusedRedTorch, "Infused Red Torch");
		GameRegistry.registerBlock(InfusedGreenTorch, "Infused Green Torch");	
		GameRegistry.registerBlock(InfusedWhiteTorch, "Infused White Torch");	
		GameRegistry.registerBlock(InfusedPurpleTorch, "Infused Purple Torch");	
		GameRegistry.registerBlock(InfusedBlueTorch, "Infused Blue Torch");
		}
	public void GenWorld(){}
	public void Recipes(){
		GameRegistry.addRecipe(new ItemStack(InfusedRedTorch, 4), new Object[] {"X", "#", 'X', InfusedRedCoal, '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(InfusedGreenTorch, 4), new Object[] {"X", "#", 'X', InfusedGreenCoal, '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(InfusedWhiteTorch, 4), new Object[] {"X", "#", 'X', InfusedWhiteCoal, '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(InfusedPurpleTorch, 4), new Object[] {"X", "#", 'X', InfusedPurpleCoal, '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(InfusedBlueTorch, 4), new Object[] {"X", "#", 'X', InfusedBlueCoal, '#', Item.stick});

	}

	public void Smelting(){}
	public void langage(){
			LanguageRegistry.addName(InfusedRedTorch, "Infused Red Torch");
			LanguageRegistry.addName(InfusedGreenTorch, "Infused Green Torch");
			LanguageRegistry.addName(InfusedWhiteTorch, "Infused White Torch");
			LanguageRegistry.addName(InfusedPurpleTorch, "Infused Purple Torch");
			LanguageRegistry.addName(InfusedBlueTorch, "Infused Blue Torch");


			LanguageRegistry.addName(InfusedRedCoal, "Infused Red Coal");
			LanguageRegistry.addName(InfusedGreenCoal, "Infused Green Coal");
			LanguageRegistry.addName(InfusedWhiteCoal, "Infused White Coal");
			LanguageRegistry.addName(InfusedPurpleCoal, "Infused Purple Coal");
			LanguageRegistry.addName(InfusedBlueCoal, "Infused Blue Coal");}
	public void OreDictionary(){
	}
}
*/