package Modules.Dslacky.Core.Items;

import Modules.Dslacky.Core.ModulesCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerCell extends Item{

	public PowerCell(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("PowerCell");
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon(ModulesCore.modid + ":" + this.getUnlocalizedName());
    }
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;}
}