package Modules.Dslacky.Machines.Render;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Modules.Dslacky.Machines.GuiIds;
import Modules.Dslacky.Machines.Extra.GuiInfuser;
import Modules.Dslacky.Machines.Extra.GuiRefinery;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch (ID) {

		case GuiIds.REFINERY:
			if (!(tile instanceof TileEntityRefinery))
				return null;
			return new GuiRefinery(player.inventory, (TileEntityRefinery) tile);

		case GuiIds.INFUSER:
			if (!(tile instanceof TileEntityInfuser))
				return null;
			return new GuiInfuser(player.inventory, (TileEntityInfuser) tile);

		default:
			return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch (ID) {

		case GuiIds.REFINERY:
			if (!(tile instanceof TileEntityRefinery))
				return null;
			return new ContainerRefinery(player.inventory, (TileEntityRefinery) tile);

		case GuiIds.INFUSER:
			if (!(tile instanceof TileEntityInfuser))
				return null;
			return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile);

		default:
			return null;
		}
	}

}