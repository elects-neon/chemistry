package chemistry.System;

import chemistry.chemistry;
import chemistry.System.ModFluids;
import chemistry.Item.Simple_Subs.*;
import chemistry.Item.Ore.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(chemistry.MOD_ID)
public class ModItems {
	
	public static final Sulfur SULFUR = new Sulfur();
	public static final Crashed_Ore CRASHED_ORE = new Crashed_Ore();
	
	// fluid bucket
	public static final Item NaOHaqBucket = (FluidUtil.getFilledBucket(new FluidStack(ModFluids.NaOHaq, 1)).getItem()).setCreativeTab(chemistry.CHEMISTRY_ORE);
}
