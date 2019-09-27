package chemistry.Block.Ore;

import chemistry.chemistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;

public class LimeStone extends Block {
	
	public LimeStone() {
		
		super(Material.ROCK);
		// □どのクリエイティブタブに追加するか
		setCreativeTab(chemistry.CHEMISTRY_ORE);
		// □上歩いた時の音
		setSoundType(SoundType.STONE);
		// □レジストリネーム これがないとエラー吐かれる
		setRegistryName("lime_stone");
		// □Unlocalized Name langファイルで表示名を変える時に使うぞ
		setUnlocalizedName(chemistry.MOD_ID + "." + "lime_stone");
	}
}