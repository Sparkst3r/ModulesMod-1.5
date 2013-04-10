package Modules.Dslacky.Core.Items;

import Modules.Dslacky.Core.ModulesCore;
import Modules.Dslacky.Core.Lib.BlockNames;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ImpureCopperIngot extends Item{

	public ImpureCopperIngot(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("impureCopperIngot");
	}

	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon(ModulesCore.modid + ":" + this.getUnlocalizedName());
    }

}