package Modules.Dslacky.Core.Extra;
 
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class WorldGen implements IWorldGenerator {
 
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world,
                        IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
                switch(world.provider.dimensionId){
                case -1: generateNether(world, random, chunkX * 16, chunkZ * 16); break;
                case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 2: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 3: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 4: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 5: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 6: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 7: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 8: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 9: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 10: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 11: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
                case 12: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 13: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 14: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 15: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 16: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 17: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 18: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 19: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 20: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;}}
 
        private void generateSurface(World world, Random random, int blockX, int blockZ) 
    	{
    		for(int i = 0; i < 10; i++)
    		{
    			int posX = blockX + random.nextInt(16);
    			int posY = random.nextInt(60);
    			int posZ = blockZ + random.nextInt(16);
    			(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreCopper.blockID, 10)).generate(world, random, posX, posY, posZ);}
    			
    			for(int i = 0; i < 10; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(40);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreElectrode.blockID, 8)).generate(world, random, posX, posY, posZ);}
    			for(int i = 0; i < 10; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(50);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreLead.blockID, 10)).generate(world, random, posX, posY, posZ);}
    			for(int i = 0; i < 3; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(30);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreTitanium.blockID, 2)).generate(world, random, posX, posY, posZ);}
		for(int i = 0; i < 10; i++)
		{
			int posX = blockX + random.nextInt(16);
			int posY = random.nextInt(40);
			int posZ = blockZ + random.nextInt(16);
			(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreTin.blockID, 10)).generate(world, random, posX, posY, posZ);}
		for(int i = 0; i < 10; i++)
		{
			int posX = blockX + random.nextInt(16);
			int posY = random.nextInt(30);
			int posZ = blockZ + random.nextInt(16);
			(new WorldGenMinable(Modules.Dslacky.Core.ModulesCore.OreSilver.blockID, 10)).generate(world, random, posX, posY, posZ);}
}
    	private void generateNether(World world, Random random, int blockX, int blockZ) 
    	{
    	}

 
}