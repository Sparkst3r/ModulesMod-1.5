package Modules.Dslacky.Machines.Extra;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Modules.Dslacky.Core.ModulesCore;
import Modules.Dslacky.Machines.Render.ContainerRefinery;
import Modules.Dslacky.Machines.Render.TileEntityRefinery;

public class GuiRefinery extends GuiContainer
{
private TileEntityRefinery furnaceInventory;

public GuiRefinery(InventoryPlayer par1InventoryPlayer, TileEntityRefinery par2TileEntityRefinery)
{
         super(new ContainerRefinery(par1InventoryPlayer, par2TileEntityRefinery));
         this.furnaceInventory = par2TileEntityRefinery;
}

protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
         this.fontRenderer.drawString(StatCollector.translateToLocal("Refinery"), 60, 6, 969398);
         this.fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 969048);
}

protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{
         //int var4 = this.mc.renderEngine.getTexture("/mods/ModulesCore/textures/gui/Infuser.png");
         int var4 = this.mc.renderEngine.getTexture(ModulesCore.guiDir + "Refinery.png");
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var5 = (this.width - this.xSize) / 2;
         int var6 = (this.height - this.ySize) / 2;
         this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
         int var7;

         if (this.furnaceInventory.isBurning())
         {
                 var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
                 this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
         }

         var7 = this.furnaceInventory.getCookProgressScaled(24);
         this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
}
}