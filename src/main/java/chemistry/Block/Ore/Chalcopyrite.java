package chemistry.Block.Ore;

import java.util.List;

import javax.annotation.Nullable;

import chemistry.chemistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Chalcopyrite extends Block {
	
	public Chalcopyrite() {
		super(Material.ROCK);
		setCreativeTab(chemistry.CHEMISTRY_ORE);
		setSoundType(SoundType.STONE);
		setRegistryName("chalcopyrite");
		setUnlocalizedName(chemistry.MOD_ID + "." + "chalcopyrite");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add("CuFeS2");
	}

}
