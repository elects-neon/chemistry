package chemistry.Block.Ore;

import chemistry.chemistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Bauxite extends Block{
	
	public Bauxite() {
		super(Material.ROCK);
		setCreativeTab(chemistry.CHEMISTRY_ORE);
		setSoundType(SoundType.STONE);
		setRegistryName("bauxite");
		setUnlocalizedName(chemistry.MOD_ID + "." + "bauxite");
	}

}
