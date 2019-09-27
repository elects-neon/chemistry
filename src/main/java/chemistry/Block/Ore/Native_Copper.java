package chemistry.Block.Ore;

import java.util.List;

import javax.annotation.Nullable;

import chemistry.chemistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Native_Copper extends Block {
	
	public Native_Copper() {
		super(Material.IRON);
		setCreativeTab(chemistry.CHEMISTRY_ORE);
		setSoundType(SoundType.METAL);
		setRegistryName("native_copper");
		setUnlocalizedName(chemistry.MOD_ID + "." + "native_copper");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add("Cu");
	}

}
