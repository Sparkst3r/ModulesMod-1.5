package Modules.Dslacky.Machines.Extra;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

	public class InfuserRecipes
	{
	private static final InfuserRecipes smeltingBase = new InfuserRecipes();

	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private HashMap<List, ItemStack> metaSmeltingList = new HashMap<List, ItemStack>();
	private HashMap<List, Float> metaExperience = new HashMap<List, Float>();

	public static final InfuserRecipes smelting()
	{
	         return smeltingBase;
	}
private InfuserRecipes()
{
         //this.addSmelting(Block.plantRed.blockID, new ItemStack(Modules.Dslacky.Torchs.ModulesTorchs.InfusedRedCoal), 1.0F);
         //this.addSmelting(Block.cactus.blockID, new ItemStack(Modules.Dslacky.Torchs.ModulesTorchs.InfusedGreenCoal), 1.0F);
         //this.addSmelting(Block.blockSnow.blockID, new ItemStack(Modules.Dslacky.Torchs.ModulesTorchs.InfusedWhiteCoal), 1.0F);
         //this.addSmelting(Block.obsidian.blockID, new ItemStack(Modules.Dslacky.Torchs.ModulesTorchs.InfusedPurpleCoal), 1.0F);
         //this.addSmelting(Item.bucketWater.itemID, new ItemStack(Modules.Dslacky.Torchs.ModulesTorchs.InfusedBlueCoal), 1.0F);
         this.addSmelting(Modules.Dslacky.Core.ModulesCore.OreElectrode.blockID, new ItemStack(Modules.Dslacky.Core.ModulesCore.UnrefinedElectrodes), 1.0F);

}

public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
{
         this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
         this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
}

@Deprecated
public ItemStack getSmeltingResult(int par1)
{
         return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
}

public Map getSmeltingList()
{
         return this.smeltingList;
}

@Deprecated //In favor of ItemStack sensitive version
public float getExperience(int par1)
{
         return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
}
public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
{
         metaSmeltingList.put((List) Arrays.asList(itemID, metadata), itemstack);
         metaExperience.put((List) Arrays.asList(itemID, metadata), experience);
}
public ItemStack getSmeltingResult(ItemStack item)
{
         if (item == null)
         {
                 return null;
         }
         ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
         if (ret != null)
         {
                 return ret;
         }
         return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
}

public float getExperience(ItemStack item)
{
         if (item == null || item.getItem() == null)
         {
                 return 0;
         }
         float ret = item.getItem().getSmeltingExperience(item);
         if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
         {
                 ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
         }
         if (ret < 0 && experienceList.containsKey(item.itemID))
         {
                 ret = ((Float)experienceList.get(item.itemID)).floatValue();
         }
         return (ret < 0 ? 0 : ret);
}
}