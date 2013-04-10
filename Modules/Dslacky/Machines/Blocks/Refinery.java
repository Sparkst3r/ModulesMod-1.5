package Modules.Dslacky.Machines.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Modules.Dslacky.Machines.GuiIds;
import Modules.Dslacky.Core.ModulesCore;
import Modules.Dslacky.Machines.Render.TileEntityRefinery;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class Refinery extends BlockContainer
{
private Random furnaceRand = new Random();

private final boolean isActive;

private static boolean keepFurnaceInventory = false;

public Refinery(int par1, boolean par2)
{
         super(par1, Material.rock);
         this.isActive = par2;
}

@SideOnly(Side.CLIENT)
private Icon field_94393_a;
@SideOnly(Side.CLIENT)
private Icon field_94392_b;
@SideOnly(Side.CLIENT)
private Icon field_94459_cP;
@SideOnly(Side.CLIENT)
private Icon field_94459_cA;

public int idDropped(int par1, Random par2Random, int par3)
{
         return Modules.Dslacky.Core.ModulesCore.RefineryIdle.blockID;
}

public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
         super.onBlockAdded(par1World, par2, par3, par4);
         this.setDefaultDirection(par1World, par2, par3, par4);
}



private void setDefaultDirection(World par1World, int par2, int par3, int par4)
{
         if (!par1World.isRemote)
         {
                 int var5 = par1World.getBlockId(par2, par3, par4 - 1);
                 int var6 = par1World.getBlockId(par2, par3, par4 + 1);
                 int var7 = par1World.getBlockId(par2 - 1, par3, par4);
                 int var8 = par1World.getBlockId(par2 + 1, par3, par4);
                 byte var9 = 3;

                 if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
                 {
                         var9 = 3;
                 }

                 if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
                 {
                         var9 = 2;
                 }

                 if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
                 {
                         var9 = 5;
                 }

                 if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
                 {
                         var9 = 4;
                 }

                 par1World.setBlockMetadataWithNotify(par2, par3, par4, var9, var8);
         }
}

@SideOnly(Side.CLIENT)

public void registerIcons(IconRegister par1IconRegister)
{
    this.field_94392_b = par1IconRegister.registerIcon("refinery_side");
    this.field_94459_cP = par1IconRegister.registerIcon(this.isActive ? "refinery_active" : "refinery_active_front");
    this.field_94459_cA = par1IconRegister.registerIcon(this.isActive ? "refinery_active" : "refinery_active_side");
    this.field_94393_a = par1IconRegister.registerIcon("refinery_top");
}

public Icon getBlockTextureFromSideAndMetadata(int side, int metadata) {
	 switch(side) {

	 case 0:
	   return field_94392_b;
	 case 1:
	   return field_94393_a;
	 default:
	   return blockIcon;
	}
}

@SideOnly(Side.CLIENT)

public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
         if (this.isActive)
         {
                 int var6 = par1World.getBlockMetadata(par2, par3, par4);
                 float var7 = (float)par2 + 0.5F;
                 float var8 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
                 float var9 = (float)par4 + 0.5F;
                 float var10 = 0.52F;
                 float var11 = par5Random.nextFloat() * 0.6F - 0.3F;

                 if (var6 == 1)
                 {
                     par1World.spawnParticle("smoke", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                     par1World.spawnParticle("townaura", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 2)
                 {
                     par1World.spawnParticle("smoke", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                     par1World.spawnParticle("townaura", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 3)
                 {
                     par1World.spawnParticle("smoke", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                     par1World.spawnParticle("townaura", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                 }
                 else if (var6 == 4)
                 {
                     par1World.spawnParticle("smoke", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                     par1World.spawnParticle("townaura", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                 }
                 else
                 {
                     par1World.spawnParticle("smoke", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                     par1World.spawnParticle("townaura", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
                 }}
}



public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
{
if (par1World.isRemote)
{
return true;
}
else if (!par5EntityPlayer.isSneaking())
{
TileEntityRefinery var10 = (TileEntityRefinery) par1World.getBlockTileEntity(par2, par3, par4);
if (var10 != null)
{
par5EntityPlayer.openGui(ModulesCore.instance, GuiIds.REFINERY, par1World, par2, par3, par4);
}
return true;
}
else
{
return false;}}
public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
{
         int var5 = par1World.getBlockMetadata(par2, par3, par4);
         TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
         keepFurnaceInventory = true;

         if (par0)
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, Modules.Dslacky.Core.ModulesCore.RefineryActive.blockID, var5);
         }
         else
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, Modules.Dslacky.Core.ModulesCore.RefineryIdle.blockID, var5);
         }

         keepFurnaceInventory = false;
         par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, var5);

         if (var6 != null)
         {
                 var6.validate();
                 par1World.setBlockTileEntity(par2, par3, par4, var6);
         }
}

public TileEntity createNewTileEntity(World par1World)
{
         return new TileEntityRefinery();
}

public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
{
         int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

         if (var6 == 0)
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, var6);
         }

         if (var6 == 1)
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, var6);
         }

         if (var6 == 2)
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, var6);
         }

         if (var6 == 3)
         {
                 par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, var6);
         }
}

public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
{
    if (!keepFurnaceInventory)
    {
        TileEntityRefinery var7 = (TileEntityRefinery)par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    while (var9.stackSize > 0)
                    {
                        int var13 = this.furnaceRand.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

                        if (var9.hasTagCompound())
                        {
                            var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                        }

                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                        par1World.spawnEntityInWorld(var14);
                    }
                }
            }
        }
    }

    super.breakBlock(par1World, par2, par3, par4, par5, par6);
}
}
