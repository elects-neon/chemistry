package chemistry.Item.Simple_Subs;

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

public class Sulfur extends Item{
	
	public Sulfur() {
		super();
		
		// Metadata
		setHasSubtypes(true);
		setMaxDamage(0);
		
		setRegistryName("sulfur");
		setCreativeTab(CreativeTabs.MATERIALS);
		setUnlocalizedName(chemistry.MOD_ID + "." + "orthor_sulfur");
		setMaxStackSize(64);
	}
	
	public String getRegistryName(ItemStack stack) {
		switch(stack.getMetadata()) {
		case 0:
			return "orthor_sulfur";
		case 1:
			return "monoclinic_sulfur";
		case 2:
			return "rubbery_sulfur";
		}
		
		return "orthor_sulfur";
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		
		String ULName = null;
		switch(stack.getMetadata()) {
		case 0:
			ULName = "orthor_sulfur";
			break;
		case 1:
			ULName = "monoclinic_sulfur";
			break;
		case 2:
			ULName = "rubbery_sulfur";
			break;
		}
		
		return chemistry.MOD_ID + "." + ULName;
	}
	
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(this.isInCreativeTab(tab)) {
			for(int i = 0; i < 3; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	// add Information to tooltip
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add("S");
	}
	
}
