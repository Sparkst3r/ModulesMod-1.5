package Modules.Dslacky.World;

import Modules.Dslacky.Core.Extra.RegistryUtils;
import Modules.Dslacky.World.Blocks.BlockOre;
import Modules.Dslacky.World.Blocks.BlockStorage;
import Modules.Dslacky.World.Blocks.InfusedTorch;
import Modules.Dslacky.World.Blocks.ItemBlockInfusedTorch;
import Modules.Dslacky.World.Blocks.ItemBlockOre;
import Modules.Dslacky.World.Blocks.ItemBlockStorage;
import Modules.Dslacky.World.Items.ItemIngot;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Values and other for the world expansion.
 * 
 * @author Sparkst3r
 *
 */
public class WorldValues {
	
	//Ore Based blocks
	public static Block BlockOreField;
	public static Block BlockStorageField;
	public static Item ItemIngotField;
	public static Block InfusedTorchField;
	
	
	public static boolean initialize() {
		ItemIngotField = new ItemIngot(5000);
		BlockOreField = new BlockOre(700);
		BlockStorageField = new BlockStorage(701);
		InfusedTorchField = new InfusedTorch(702);
		
		addInfoForMeta();
		
		ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		return true;
	}
	
	/**
	 * Adds extra info about meta data blocks/items
	 */
	public static void addInfoForMeta() {
		//Ingot
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ItemIngotField, meta, ItemIngot.names[meta]);
			RegistryUtils.registerOre(ItemIngotField, meta, ItemIngot.types[meta]);
		}
		//Ore Block
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(BlockOreField, meta, ItemBlockOre.names[meta]);
			RegistryUtils.registerOre(BlockOreField, meta, ItemBlockOre.types[meta]);
		}
		
		//Storage Block
		for (int meta = 0; meta < 4; meta++) {
			RegistryUtils.addName(BlockStorageField, meta, ItemBlockStorage.names[meta]);
			RegistryUtils.registerOre(BlockOreField, meta, ItemBlockStorage.types[meta]);
		}
	}
}
