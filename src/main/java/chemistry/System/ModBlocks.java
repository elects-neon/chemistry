package chemistry.System;

import chemistry.chemistry;

import chemistry.System.ModFluids;

import chemistry.Block.Ore.LimeStone;
import chemistry.Block.Ore.Bauxite;
import chemistry.Block.Ore.Fluorite;
import chemistry.Block.Ore.Pyrolusite;
import chemistry.Block.Ore.Rhodochrosite;
import chemistry.Block.Ore.*;

import net.minecraft.block.material.Material;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import net.minecraftforge.fluids.BlockFluidClassic;

@ObjectHolder(chemistry.MOD_ID)
public class ModBlocks {
	
	// 1ブロックのインスタンス集
	public static final LimeStone LIMESTONE = new LimeStone();
	public static final Bauxite BAUXITE = new Bauxite();
	public static final Fluorite FLUORITE = new Fluorite();
	public static final Pyrolusite PYROLUSITE = new Pyrolusite();
	public static final Rhodochrosite RHODOCHROSITE = new Rhodochrosite();
	public static final Chalcopyrite CHALCOPYRITE = new Chalcopyrite();
	public static final Chalcocite CHALCOCITE = new Chalcocite();
	public static final Sphalerite SPHALERITE = new Sphalerite();
	public static final Smithsonite SMITHSONITE = new Smithsonite();
	public static final Native_Copper NATIVE_COPPER = new Native_Copper();
	
	// BlockFluidClassic 液体登録する時に使うブロックのインスタンス集
	public static final BlockFluidClassic NAOHAQ = (BlockFluidClassic) new BlockFluidClassic(ModFluids.NaOHaq, Material.WATER)
			.setRegistryName(ModFluids.NaOHaq.getfluidname()).setCreativeTab(chemistry.CHEMISTRY_ORE);
	
}
