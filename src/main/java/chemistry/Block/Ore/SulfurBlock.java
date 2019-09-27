package chemistry.Block.Ore;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;

public class SulfurBlock extends Block {
	
	public static final PropertyEnum<SulfurBlock.EnumType> VARIANT = PropertyEnum.<SulfurBlock.EnumType>create("variant", SulfurBlock.EnumType.class);
    /* Constructor */
    public SulfurBlock(Material material){
        super(material);

        /* Block Option */
        /* Creative Tab */
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        /* Light Level */
        this.setLightLevel(0.0F);
        /* Hardness */
        this.setHardness(3.0F);
        /* Resistance against Explosion */
        this.setResistance(30.0F);
        /* Default State */
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, SulfurBlock.EnumType.ORTHORHOMBIC));
    }
    
    /*
    public String getLocalizedName() {
    	return I18n.translateToLocal(this.getUnlocalizedName() + "." + SulfurBlock.EnumType.ORTHORHOMBIC.getUnlocalizedName() + ".name");
    }
    */
    
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
    	return ((SulfurBlock.EnumType)state.getValue(VARIANT)).getMapColor();
    }
    
    /*
     * Gets the metadata of the item this block can drop.
     * This method is called when the block gets destroy.
     */
    public int damageDropped(IBlockState state) {
    	return ((SulfurBlock.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    public void getSubBlocks(CreativeTabs itemin, NonNullList<ItemStack> items) {
    	for(SulfurBlock.EnumType sulfurblock$enumtype : SulfurBlock.EnumType.values()) {
    		items.add(new ItemStack(this, 1, sulfurblock$enumtype.getMetadata()));
    	}
    }
    
    /* 
     * Convert the given metadata into a BlockState
     */
    public IBlockState getStateFromMetadata(int meta) {
    	return this.getDefaultState().withProperty(VARIANT, SulfurBlock.EnumType.byMetadata(meta));
    }
    
    /*
     * Convert the given State into a metadata
     */
    public int getMetaFromState(IBlockState state) {
    	return ((SulfurBlock.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
        /*
        Set which creative tabs show this item
        if don't set this, the item is shown in any creative tabs
         
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list){
        if (tab == this.getCreativeTabToDisplayOn()){
            list.add(new ItemStack(this, 1, 0));
        }
    }
    */

    /*
    Add contents in the tooltip when the item is shown
    The options which with @SideOnly(Side.CLIENT) isn't loaded by server

    @param stack Target item
    @param world Current World
    @param tooltip The list contained Sentences of tooltip
    @param flag whether it was changed to advanced tooltip by f3+H
    */
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced){
    	tooltip.add("S");
    }
    
    public static enum EnumType implements IStringSerializable {
    	
    	// □メタデータ付きのブロックの時はこんな感じにEnumを使って色々する
    	
    	ORTHORHOMBIC(0, MapColor.STONE, "orthorhombic_sulfur", "orthorhombic"),
    	MONOCLINIC(1, MapColor.STONE, "monoclinic_sulfur", "monoclinic"),
    	RUBBERY(2, MapColor.STONE, "rubbery_sulfur", "rubbery");
    	
    	private static final SulfurBlock.EnumType[] META_LOOKUP = new SulfurBlock.EnumType[values().length];
    	
    	private final int meta;
    	private final String name;
    	private final String unlocalizedName;
    	private final MapColor mapcolor;
    	
    	private EnumType(int p_i46384_3_, MapColor p_i46384_4_, String p_i46384_5_, String p_i46384_6_) {
    		this.meta = p_i46384_3_;
    		this.name = p_i46384_5_;
    		this.unlocalizedName = p_i46384_6_;
    		this.mapcolor = p_i46384_4_;
    	}
    	
    	public int getMetadata() {
    		return this.meta;
    	}
    	
    	public MapColor getMapColor() {
    		return this.mapcolor;
    	}
    	
    	public String toString() {
    		return this.name;
    	}
    	
    	public static SulfurBlock.EnumType byMetadata(int meta){
    		if(meta < 0 || meta >= META_LOOKUP.length) {
    			meta = 0;
    		}
    		
    		return META_LOOKUP[meta];
    	}
    	
    	public String getName() {
    		return this.name;
    	}
    	
    	public String getUnlocalizedName() {
    		return this.unlocalizedName;
    	}
    	
    	static {
    		for(SulfurBlock.EnumType sulfurblock$enumtype : values()) {
    			META_LOOKUP[sulfurblock$enumtype.getMetadata()] = sulfurblock$enumtype;
    		}
    	}
    }
}