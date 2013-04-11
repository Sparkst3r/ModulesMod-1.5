package Modules.Dslacky.World.Blocks;

import Modules.Dslacky.Core.ModulesCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Modules.Dslacky.Core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockOre extends Block {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockOre(int id) {
		super(id, Material.rock);
		this.setHardness(6F);
		GameRegistry.registerBlock(this, ItemBlockOre.class, "BlockOre");
		this.setCreativeTab(ModulesCore.Modules1);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[5];
    	
		String id = GlobalValues.ModIDCore + ":"; 
		iconBuffer[0] = ir.registerIcon(id + "copperOre");
		iconBuffer[1] = ir.registerIcon(id + "tinOre");
		iconBuffer[2] = ir.registerIcon(id + "silverOre");
		iconBuffer[3] = ir.registerIcon(id + "leadOre");
		iconBuffer[4] = ir.registerIcon(id + "titaniumOre");
	}
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 5)? iconBuffer[meta] : iconBuffer[0];
	}
	
}
