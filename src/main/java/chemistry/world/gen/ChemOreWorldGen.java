package chemistry.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import chemistry.System.ModBlocks;

public class ChemOreWorldGen implements IWorldGenerator {
	
	private final List<WorldGenMinable> ChemOverworldGenerator = new ArrayList<WorldGenMinable>();
	public ChemOreWorldGen() {
		// □自然生成させたいブロックをChemOverworldGeneratorに登録しておく
		// □後ろのBlockMatcher.forBlock([ブロック名])は、ブロックをワールドに生成する際、どのブロックと置き換えて生成するか、を指定する
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.BAUXITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.CHALCOCITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.CHALCOPYRITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.FLUORITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.LIMESTONE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.NATIVE_COPPER.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.PYROLUSITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.RHODOCHROSITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.SMITHSONITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
		ChemOverworldGenerator.add(new WorldGenMinable(ModBlocks.SPHALERITE.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE)));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionType()) {
		case NETHER:
			break;
		case OVERWORLD:
			// ChemOverworldGeneratorの中のブロックを全部genstandardメソッドでワールドに生成する
			for(WorldGenMinable wgm : ChemOverworldGenerator) {
				genStandard(wgm, world, random, chunkX, chunkZ, 10, 0, 150);
			}
			break;
		case THE_END:
			break;
		}
	}
	
	// □鉱石生成する時に使うメソッド
	private void genStandard(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int spawnTries, int minHeight, int maxHeight) {
		// □ここからminHeightとmaxHeightを正しい数値にするための処理
		if(minHeight < 0) minHeight = 0;
		if(maxHeight > 255) maxHeight = 255;
		
		if(maxHeight < minHeight) {
			int i = minHeight;
			minHeight = maxHeight;
			maxHeight = i;
		}else if(maxHeight == minHeight) {
			if(maxHeight < 255) {
				maxHeight++;
			}else minHeight--;
		}
		// □ここまでminHeightとmaxHeightを正しい数値にするための処理
		
		BlockPos chunkPosAsBlockPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < spawnTries; i++) {
			// □メソッド呼び出して鉱石生成
			generator.generate(world, random, chunkPosAsBlockPos.add(random.nextInt(16), minHeight + random.nextInt(heightDiff), random.nextInt(16)));
		}
	}
}
