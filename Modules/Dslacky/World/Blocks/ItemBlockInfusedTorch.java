package Modules.Dslacky.World.Blocks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockInfusedTorch extends ItemBlock {
	public static String[] types = { "blueTorch", "greenTorch", "redTorch", "prupleTorch", "whiteTorch" };
	public static String[] names = { "Blue Torch", "Green Torch", "Red Torch", "Purple Torch", "White Torch" };

	public ItemBlockInfusedTorch(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

	}

	public int getMetadata(int meta) {
		return meta;
	}

	public String getUnlocalizedName(ItemStack is) {

		return types[is.getItemDamage()];
	}

	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 5; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	}
}
