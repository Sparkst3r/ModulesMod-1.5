package Modules.Dslacky.Core.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Modules.Dslacky.Core.ModulesCore;
import Modules.Dslacky.Core.Lib.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ElectrodeOre extends Block{

	public ElectrodeOre(int id, Material material){
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setResistance(3.0F);
		setUnlocalizedName("electrodeOre");
	}
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(ModulesCore.modid + ":" + this.getUnlocalizedName());
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    

}