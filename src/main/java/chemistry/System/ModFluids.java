package chemistry.System;

import chemistry.chemistry;
import chemistry.Block.Liquid.DS_Fluid;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class ModFluids {
	// □液体のインスタンス集
	public static final DS_Fluid NaOHaq = (DS_Fluid) new DS_Fluid("NaOHaq", new ResourceLocation(chemistry.MOD_ID, "NaOHaq_still"), new ResourceLocation(chemistry.MOD_ID, "NaOHaq_flow"))
			.setMaterial(Material.WATER).setDensity(500).setGaseous(false).setLuminosity(0).setViscosity(10000).setTemperature(277);
}
