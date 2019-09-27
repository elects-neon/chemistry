package chemistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import chemistry.Block.Ore.*;
import chemistry.System.client.ModelRegistrationHandler;
import chemistry.System.OreDictionaryHandler;
import chemistry.System.tabs.ChemistryOre;
import chemistry.world.gen.ChemOreWorldGen;

@Mod(modid = chemistry.MOD_ID, name = "Chemistry Mod", version="1.0.0", dependencies = "",
acceptedMinecraftVersions = "[1.12, 1.12.2]", useMetadata = true)
public class chemistry {

    public static final String MOD_ID = "chemistry";

    @Instance("chemistry")
    public static chemistry instance;

    /* Blocks */
    public static Block sulfurblock;
    public static Item sulfurblock_item = null;
    
    /* Creative Tab */
    public static final CreativeTabs CHEMISTRY_ORE = new ChemistryOre();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        /* Create Instance */
    	// □試験的に硫黄ブロックを最初に追加したので、硫黄ブロックだけ追加方法が違う。特に意味はないので後々他のブロックと同じように登録する予定
        sulfurblock = new SulfurBlock(Material.ROCK).setUnlocalizedName("sulfur_block").setRegistryName(new ResourceLocation(MOD_ID, "sulfur_block"));
        
        sulfurblock_item = new ItemMultiTexture(sulfurblock, sulfurblock, new ItemMultiTexture.Mapper() {
        	public String apply(ItemStack p_apply_1_) {
        		return SulfurBlock.EnumType.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        	}
        }).setUnlocalizedName("sulfur_block_item").setRegistryName("sulfur_block");

        /* Register Block*/
        /*
    	for(SulfurBlock.EnumType sulfurblock$enumtype : SulfurBlock.EnumType.values()) {
    		sulfurblock = new SulfurBlock(Material.ROCK).setUnlocalizedName(sulfurblock$enumtype.getUnlocalizedName()).setRegistryName(new ResourceLocation(MOD_ID, sulfurblock$enumtype.getUnlocalizedName()));
    		ForgeRegistries.BLOCKS.register(sulfurblock);
    		ForgeRegistries.ITEMS.register(new ItemBlock(sulfurblock).setRegistryName(sulfurblock.getRegistryName()));
    		
    	}
    	*/
        ForgeRegistries.BLOCKS.register(sulfurblock);
        /* Register ItemBlock */
        //ForgeRegistries.ITEMS.register(new ItemBlock(sulfurblock).setRegistryName(sulfurblock.getRegistryName()));
        ForgeRegistries.ITEMS.register(sulfurblock_item);
        

  
        if (event.getSide().isClient()){
            registerModels();
        }
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	GameRegistry.registerWorldGenerator(new ChemOreWorldGen(), 0);
    	
    	OreDictionaryHandler.registerOreDictionary();
    }

    //register Block Model
    @SideOnly(Side.CLIENT)
    public void registerModels(){
    	
    	for(SulfurBlock.EnumType sulfurblock$enumtype : SulfurBlock.EnumType.values()) {
    		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(sulfurblock), sulfurblock$enumtype.getMetadata(), new net.minecraft.client.renderer.block.model.ModelResourceLocation(sulfurblock.getRegistryName(), "inventory"));
    	}
    	/*
        net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(sulfurblock), 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(sulfurblock.getRegistryName(), "inventory"));
        net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(sulfurblock), 1, new net.minecraft.client.renderer.block.model.ModelResourceLocation(sulfurblock.getUnlocalizedName(), "inventory"));
        */
    }
    

    static {
        // □追加した液体が入ったバケツをアイテムとして登録するのに必要
    	FluidRegistry.enableUniversalBucket();
    }
}
