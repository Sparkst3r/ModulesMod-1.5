package Modules.Dslacky.Core.Extra;

import Modules.Dslacky.Core.Items.ItemImpureIngot;
import Modules.Dslacky.Core.Items.ItemIngot;
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
public class RegisterItems {

	//Ore Based blocks
	public static Block BlockOreField;
	public static Block BlockStorageField;
	public static Item ItemIngotField;
	public static Item ImpureItemIngotField;


	public static boolean initialize() {
		ItemIngotField = new ItemIngot(5001);
		ImpureItemIngotField = new ItemImpureIngot(5000);

		addInfoForMeta();


		return true;
	}

	/**
	 * Adds extra info about meta data blocks/items
	 */
	public static void addInfoForMeta() {
		//Ingot
		for (int meta = 0; meta < 4; meta++) {
			RegistryUtils.addName(ItemIngotField, meta, ItemIngot.names[meta]);
			RegistryUtils.registerOre(ItemIngotField, meta, ItemIngot.types[meta]);
		}

		//Ore Block
		for (int meta = 0; meta < 4; meta++) {
			RegistryUtils.addName(ImpureItemIngotField, meta, ItemImpureIngot.names[meta]);
			RegistryUtils.registerOre(ImpureItemIngotField, meta, ItemImpureIngot.types[meta]);
		}
	}
}