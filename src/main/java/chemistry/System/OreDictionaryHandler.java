package chemistry.System;

import chemistry.System.ModBlocks;
import chemistry.System.ModItems;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

	
	public static void registerOreDictionary() {
		
		// 1鉱石辞書に鉱石登録
		OreDictionary.registerOre("oreBauxite", ModBlocks.BAUXITE);
	}

}
