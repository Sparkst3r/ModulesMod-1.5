package Modules.Dslacky.Torchs.Items;


import java.util.List;

import Modules.Dslacky.Core.ModulesCore;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


/**
 * Meta-data item for the 4 ingots.
 * 
 * @author Sparkst3r
 *
 */
public class InfusedCoal extends Item {
	/** Texture file names + code name */
    public static String[] types = new String[] {"InfusedRedCoal", "InfusedGreenCoal", "InfusedWhiteCoal", "InfusedPurpleCoal", "InfusedBlueCoal"};     
    
    /** Human-Readable names */
    public static String[] names = new String[] {"Infused Red Coal", "Infused Green Coal", "Infused White Coal", "Infused Purple Coal", "Infused Blue Coal"};
    
    /** Icon Array */
    @SideOnly(Side.CLIENT)
    private Icon[] iconBuffer;

    /**
     * Constructor
     * @param id Item ID
     */
	public InfusedCoal(int id) {
		super(id);
        this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage){
    	return iconBuffer[damage];
    }
    
	/** Register the textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void updateIcons(IconRegister ir) {
		iconBuffer = new Icon[types.length];

		String id = ModulesCore.modid + ":";
		iconBuffer[0] = ir.registerIcon(id + types[0]);
		iconBuffer[1] = ir.registerIcon(id + types[1]);
		iconBuffer[2] = ir.registerIcon(id + types[2]);	
		iconBuffer[3] = ir.registerIcon(id + types[3]);
		iconBuffer[4] = ir.registerIcon(id + types[4]);
	}
    
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 5; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 

	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

}