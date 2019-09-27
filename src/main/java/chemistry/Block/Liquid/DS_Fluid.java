package chemistry.Block.Liquid;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

//Deleterious Substances aq なんか有毒な物質溶けた液体をまとめたクラスにする予定
public class DS_Fluid extends Fluid{
	
	protected static int mapColor = 0x5882FA;
	protected static float overlayAlpha = 0.2F;
	protected static SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
	protected static SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
	protected static Material material = Material.WATER;
	
	public DS_Fluid(String fluidname, ResourceLocation still, ResourceLocation flowing) {
		super(fluidname, still, flowing);
	}
	
	public DS_Fluid(String fluidname, ResourceLocation still, ResourceLocation flowing, int mapColor) {
		this(fluidname, still, flowing);
		setColor(mapColor);
	}
	
	public DS_Fluid(String fluidname, ResourceLocation still, ResourceLocation flowing, int mapColor, float overlayAlpha) {
		this(fluidname, still, flowing, mapColor);
		setAlpha(overlayAlpha);
	}
	
	public String getfluidname() {
		return fluidName;
	}
	
	@Override
	public int getColor() {
		return mapColor;
	}
	
	public DS_Fluid setColor(int parColor) {
		mapColor = parColor;
		return this;
	}
	
	public float getAlpha() {
		return overlayAlpha;
	}
	
	public DS_Fluid setAlpha(float parOverlayAlpha) {
		overlayAlpha = parOverlayAlpha;
		return this;
	}
	
	@Override
	public DS_Fluid setEmptySound(SoundEvent parSound) {
		emptySound = parSound;
		return this;
	}
	
	@Override
	public SoundEvent getEmptySound() {
		return emptySound;
	}
	
	@Override
	public DS_Fluid setFillSound(SoundEvent parSound) {
		fillSound = parSound;
		return this;
	}
	
	@Override
	public SoundEvent getFillSound() {
		return fillSound;
	}
	
	public DS_Fluid setMaterial(Material parMaterial) {
		material = parMaterial;
		return this;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	@Override
	public boolean doesVaporize(FluidStack fluidstack) {
		if(block == null) {
			return false;
		}
		return block.getDefaultState().getMaterial() == getMaterial();
	}
}
