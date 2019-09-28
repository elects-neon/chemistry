package chemistry.System;

import chemistry.chemistry;
//import chemistry.Block.Ore.*;
import chemistry.System.ModBlocks;
import chemistry.System.ModItems;
import chemistry.System.ModFluids;

import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = chemistry.MOD_ID)
public final class EventSubscriber {
	
	//register block
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		
		final Fluid[] fluids = {
				ModFluids.NaOHaq
		};
		
		for(Fluid f : fluids) {
			FluidRegistry.registerFluid(f);
			FluidRegistry.addBucketForFluid(f);
		}
		
		final Block[] blocks = {
				ModBlocks.BAUXITE,
				ModBlocks.CHALCOCITE,
				ModBlocks.CHALCOPYRITE,
				ModBlocks.FLUORITE,
				ModBlocks.LIMESTONE,
				ModBlocks.NATIVE_COPPER,
				ModBlocks.PYROLUSITE,
				ModBlocks.RHODOCHROSITE,
				ModBlocks.SMITHSONITE,
				ModBlocks.SPHALERITE,
				
				//BlockFluidClassic
				ModBlocks.NAOHAQ
		};
		
		// register　ブロック登録
		event.getRegistry().registerAll(blocks);
	}
	
	// register item アイテム登録メソッド
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		// item
		final Item[] items = {
				ModItems.SULFUR,
				ModItems.CRASHED_ORE,
				
				// fluid item
				ModItems.NaOHaqBucket
		};
		
		// itemblock
		final Item[] itemBlocks = {
				new ItemBlock(ModBlocks.BAUXITE).setRegistryName(ModBlocks.BAUXITE.getRegistryName()),
				new ItemBlock(ModBlocks.CHALCOCITE).setRegistryName(ModBlocks.CHALCOCITE.getRegistryName()),
				new ItemBlock(ModBlocks.CHALCOPYRITE).setRegistryName(ModBlocks.CHALCOPYRITE.getRegistryName()),
				new ItemBlock(ModBlocks.FLUORITE).setRegistryName(ModBlocks.FLUORITE.getRegistryName()),
				new ItemBlock(ModBlocks.LIMESTONE).setRegistryName(ModBlocks.LIMESTONE.getRegistryName()),
				new ItemBlock(ModBlocks.NATIVE_COPPER).setRegistryName(ModBlocks.NATIVE_COPPER.getRegistryName()),
				new ItemBlock(ModBlocks.PYROLUSITE).setRegistryName(ModBlocks.PYROLUSITE.getRegistryName()),
				new ItemBlock(ModBlocks.RHODOCHROSITE).setRegistryName(ModBlocks.RHODOCHROSITE.getRegistryName()),
				new ItemBlock(ModBlocks.SMITHSONITE).setRegistryName(ModBlocks.SMITHSONITE.getRegistryName()),
				new ItemBlock(ModBlocks.SPHALERITE).setRegistryName(ModBlocks.SPHALERITE.getRegistryName()),
				
				//BlockFluidClassic
				new ItemBlock(ModBlocks.NAOHAQ).setRegistryName(ModBlocks.NAOHAQ.getRegistryName())
		};
		
		// register
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}
}
