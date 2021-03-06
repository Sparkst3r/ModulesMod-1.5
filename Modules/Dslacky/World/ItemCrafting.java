package Modules.Dslacky.World;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Simple class for all the item crafting recipes
 * @author Sparkst3r
 *
 */
public class ItemCrafting {
	/**
	 * Initialise the recipes
	 */
	public static void initialise() {
		FurnaceRecipes.smelting().addSmelting(WorldValues.BlockOreField.blockID, 0, new ItemStack(WorldValues.ItemIngotField, 1, 0), 0.1F);
		FurnaceRecipes.smelting().addSmelting(WorldValues.BlockOreField.blockID, 1, new ItemStack(WorldValues.ItemIngotField, 1, 1), 0.1F);
		FurnaceRecipes.smelting().addSmelting(WorldValues.BlockOreField.blockID, 2, new ItemStack(WorldValues.ItemIngotField, 1, 2), 0.1F);
		FurnaceRecipes.smelting().addSmelting(WorldValues.BlockOreField.blockID, 3, new ItemStack(WorldValues.ItemIngotField, 1, 3), 0.1F);
	}
}
