package Modules.Dslacky.World.Blocks;

import java.util.List;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStorage extends ItemBlock{
	public static String[] types = {"blockCopper","blockTin","blockSilver","blockLead"};
	public static String[] names = {"Copper Block","Tin Block","Silver Block", "Lead Block"};
	public ItemBlockStorage(int id) {
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
		for (int meta = 0; meta < 4; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
}
