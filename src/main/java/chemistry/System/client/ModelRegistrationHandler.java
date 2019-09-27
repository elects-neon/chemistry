package chemistry.System.client;

import chemistry.chemistry;
import chemistry.System.ModBlocks;
import chemistry.System.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = chemistry.MOD_ID)
public class ModelRegistrationHandler {
	
	// register block model, item model
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		// Blocks
		registerModel(Item.getItemFromBlock(ModBlocks.BAUXITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.CHALCOCITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.CHALCOPYRITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.FLUORITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.LIMESTONE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.NATIVE_COPPER), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.PYROLUSITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.RHODOCHROSITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SMITHSONITE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SPHALERITE), 0);
		
		// BlockFluidClassic
		registerModel(Item.getItemFromBlock(ModBlocks.NAOHAQ), 0);
		
		// Items
		registerModel(ModItems.SULFUR, 0);
		registerModel(ModItems.SULFUR, 1);
		registerModel(ModItems.SULFUR, 2);
	}
	
	// 1モデル登録を簡単にするためのメソッド
	private static void registerModel(Item item, int meta) {
		// □new ModelResourceLocationの第一引数の文字列がモデル指定するjsonファイルの名前になる
		// □メタデータ付きブロック、アイテムだったらメタ値を後ろにくっつけることによって指定するファイル変えて、テクスチャ変えてる
		if(item.getHasSubtypes()) {
			ModelLoader.setCustomModelResourceLocation(item, meta,
					new ModelResourceLocation(item.getRegistryName() + "_" + Integer.toString(meta) , "inventory"));
		}else {
			ModelLoader.setCustomModelResourceLocation(item, meta,
					new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

}
