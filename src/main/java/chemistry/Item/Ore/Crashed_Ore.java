package chemistry.Item.Ore;

import java.util.List;

import chemistry.chemistry;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Crashed_Ore extends Item {
	
	public Crashed_Ore() {
		super();
		
		setHasSubtypes(true);
		setMaxDamage(0);
		
		setRegistryName("crashed_ore");
		setCreativeTab(chemistry.CHEMISTRY_ORE);
		setUnlocalizedName(chemistry.MOD_ID + "." + "crashed_ore");
		setMaxStackSize(64);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		String ULName = null;
		switch(stack.getMetadata()) {
		case 0:
			// □黄銅鉱を砕いたもの
			ULName = "crashed_chalcopyrite";
			break;
		case 1:
			// □閃亜鉛鉱を砕いたもの
			ULName = "crashed_sphalerite";
			break;
		}
		
		return chemistry.MOD_ID + "." + ULName;
	}
	
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(this.isInCreativeTab(tab)) {
			for(int i = 0; i < 2; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		switch(stack.getMetadata()) {
		case 0:
			break;
		case 1:
			break;
		}
	}

}
