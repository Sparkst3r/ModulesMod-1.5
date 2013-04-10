package Modules.Dslacky.Core.Render;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import Modules.Dslacky.Core.Extra.SoundHandler;
//import Modules.Dslacky.Mobs.Entity.EntityFish;
//import Modules.Dslacky.Mobs.Entity.EntityGhost;
//import Modules.Dslacky.Mobs.Entity.EntityGoblin;
//import Modules.Dslacky.Mobs.Entity.EntityRedGoblin;
//import Modules.Dslacky.Mobs.Entity.EntityWolf;
//import Modules.Dslacky.Mobs.Model.ModelFish;
//import Modules.Dslacky.Mobs.Model.ModelGhost;
//import Modules.Dslacky.Mobs.Model.ModelGreenGoblin;
//import Modules.Dslacky.Mobs.Model.ModelRedGoblin;
//import Modules.Dslacky.Mobs.Model.ModelWolf;
//import Modules.Dslacky.Mobs.Render.RenderFish;
//import Modules.Dslacky.Mobs.Render.RenderGhost;
//import Modules.Dslacky.Mobs.Render.RenderGoblin;
//import Modules.Dslacky.Mobs.Render.RenderRedGoblin;
//import Modules.Dslacky.Mobs.Render.RenderWolf;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
    public void registerRender()
        {
                //MinecraftForgeClient.preloadTexture("/Modules/Core/Items.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Core/Blocks.png");
                //MinecraftForgeClient.preloadTexture("ModulesMobs/blocks.png");
                //RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, new RenderWolf(new ModelWolf(), 0.3F));
                //RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderGoblin(new ModelGreenGoblin(), 0.3F));
                //RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new RenderFish(new ModelFish(), 0.3F));
                //RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(new ModelGhost(), 0.3F));
                //RenderingRegistry.registerEntityRenderingHandler(EntityRedGoblin.class, new RenderRedGoblin(new ModelRedGoblin(), 0.3F));
                //MinecraftForgeClient.preloadTexture("/Modules/Machines/Items.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Machines/Blocks.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Torchs/Blocks.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Torchs/Items.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Machines/Blocks/Refinery.png");
                //MinecraftForgeClient.preloadTexture("/Modules/Machines/Blocks/Infuser.png");
        }
	 public void registerSoundHandler(){

	 MinecraftForge.EVENT_BUS.register(new SoundHandler());

	 }

}