package Modules.Dslacky.Machines.Extra;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

	public class RefineryRecipes
	{
	private static final RefineryRecipes smeltingBase = new RefineryRecipes();

	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private HashMap<List, ItemStack> metaSmeltingList = new HashMap<List, ItemStack>();
	private HashMap<List, Float> metaExperience = new HashMap<List, Float>();

	public static final RefineryRecipes smelting()
	{
	         return smeltingBase;
	}

private RefineryRecipes()
{
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.ImpureTinIngot.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.TinIngot), 0.7F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.ImpureCopperIngot.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.CopperIngot), 1.0F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.ImpureLeadIngot.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.LeadIngot), 1.0F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.ImpureSilverIngot.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.SilverIngot), 1.1F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.ImpureTitaniumIngot.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.TitaniumIngot), 1.35F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.UnrefinedElectrodes.itemID, new ItemStack(Modules.Dslacky.Core.ModulesCore.Electrode), 0.7F);
         //this.addSmelting(Modules.Dslacky.Core.ModulesCore.BlockTitanium.blockID, new ItemStack(Modules.Dslacky.Core.ModulesCore.TitaniumIngot, 8), 0.7F);

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