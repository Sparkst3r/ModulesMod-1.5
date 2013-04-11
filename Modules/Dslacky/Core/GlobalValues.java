package Modules.Dslacky.Core;


import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GlobalValues {
	//Mod Info
	public static final String ModIDCore = "ModulesCore";
	public static final String ModNameCore = "Modules";
	public static final String ModIDWorld = "Modules|World";
	public static final String ModNameWorld = "Modules World Expansion";
	public static final String ModIDMechanical = "Modules|Mech";
	public static final String ModNameMechanical = "Modules Mechanical Expansion";
	public static final String ModIDMachines = "Modules|Mach";
	public static final String ModNameMachines = "Modules Machines Expansion";
	public static final String ModVersion = "0.1.0";

	//Dependency variables
	public static final String Core = "required-after:" + ModIDCore + "@" + ModVersion;
	public static final String World = "required-after:" + ModIDWorld + "@" +  ModVersion;


	//Texture path
	public static final String mainDir = "/mods/ModulesCore/textures/";
	public static final String guiDir = mainDir + "guis/";
	public static final String entityDir = mainDir + "entities/";
	public static final String blockDir = mainDir + "blocks/";
	public static final String itemDir = mainDir + "items/";

	//Creative Tab

	//Material set to immovable
	//public static Material immovable = new MaterialImmovable(MapColor.woodColor);

	//GuiHandlers
	//public static GuiHandlerMechanical GUIMechanical = new GuiHandlerMechanical();

	public static boolean initialize() {
		return true;
	}

}