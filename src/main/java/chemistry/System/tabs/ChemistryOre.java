package chemistry.System.tabs;

import chemistry.chemistry;
import chemistry.System.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChemistryOre extends CreativeTabs {
	
	// □クリエイティブタブ
	public ChemistryOre() {
		super(chemistry.MOD_ID + "." + "ore");
	}
	
	// □クリエイティブタブのアイコンのアイテムを指定
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.LIMESTONE));
	}
}
