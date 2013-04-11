package Modules.Dslacky.Core.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Modules.Dslacky.Core.ModulesCore;
import Modules.Dslacky.Core.Lib.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class TitaniumOre extends Block{

	public TitaniumOre(int id, Material material){
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setResistance(3.0F);
		setUnlocalizedName("titaniumOre");
	}
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(ModulesCore.modid + ":" + this.getUnlocalizedName());
    }

}