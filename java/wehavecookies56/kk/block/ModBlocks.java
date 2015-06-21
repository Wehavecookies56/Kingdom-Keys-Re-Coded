package wehavecookies56.kk.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.item.TabKingdomKeys;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import static wehavecookies56.kk.lib.Strings.*;
import wehavecookies56.kk.lib.Strings;

public class ModBlocks {

	public static Block
		NormalBlox,
		HardBlox,
		MetalBlox,
		DangerBlox,
		BounceBlox,
		BlastBlox,
		PrizeBlox,
		RarePrizeBlox;
	
	public static CreativeTabs tabKingdomKeysBlocks;
		
	public static void init(){
		tabKingdomKeysBlocks = new TabKingdomKeysBlocks(CreativeTabs.getNextID(), Strings.tabKingdomKeysBlocks);
		NormalBlox = new BlockNormalBlox(Material.iron, "pickaxe", 0, 1f, 10f).setUnlocalizedName(Strings.NormalBlox).setCreativeTab(tabKingdomKeysBlocks);
		HardBlox = new BlockHardBlox(Material.iron, "pickaxe", 1, 6f, 30f).setUnlocalizedName(Strings.HardBlox).setCreativeTab(tabKingdomKeysBlocks);
		MetalBlox = new BlockMetalBlox(Material.iron, "pickaxe", 2, 10f, 600f).setUnlocalizedName(Strings.MetalBlox).setCreativeTab(tabKingdomKeysBlocks);
		DangerBlox = new BlockDangerBlox(Material.iron, "pickaxe", 0, 1f, 1f).setUnlocalizedName(Strings.DangerBlox).setCreativeTab(tabKingdomKeysBlocks);
		BounceBlox = new BlockBounceBlox(Material.iron, "pickaxe", 0, 1f, 1f).setUnlocalizedName(Strings.BounceBlox).setCreativeTab(tabKingdomKeysBlocks);
		BlastBlox = new BlockBlastBlox(Material.iron, "pickaxe", 0, 1f, 1f).setUnlocalizedName(Strings.BlastBlox).setCreativeTab(tabKingdomKeysBlocks);		
		PrizeBlox = new BlockPrizeBlox(Material.iron, "pickaxe", 0, 1f, 1f).setUnlocalizedName(Strings.PrizeBlox).setCreativeTab(tabKingdomKeysBlocks);
		RarePrizeBlox = new BlockRarePrizeBlox(Material.iron, "pickaxe", 0, 1f, 1f).setUnlocalizedName(Strings.RarePrizeBlox).setCreativeTab(tabKingdomKeysBlocks);
	}
	
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void register(){
		GameRegistry.registerBlock(NormalBlox, Strings.NormalBlox);
		GameRegistry.registerBlock(HardBlox, Strings.HardBlox);
		GameRegistry.registerBlock(MetalBlox, Strings.MetalBlox);
		GameRegistry.registerBlock(DangerBlox, Strings.DangerBlox);
		GameRegistry.registerBlock(BounceBlox, Strings.BounceBlox);
		GameRegistry.registerBlock(BlastBlox, Strings.BlastBlox);
		GameRegistry.registerBlock(PrizeBlox, Strings.PrizeBlox);
		GameRegistry.registerBlock(RarePrizeBlox, Strings.RarePrizeBlox);
	}
	
	public static void registerRenders(){
		registerRender(NormalBlox);
		registerRender(HardBlox);
		registerRender(MetalBlox);
		registerRender(DangerBlox);
		registerRender(BounceBlox);
		registerRender(BlastBlox);
		registerRender(PrizeBlox);
		registerRender(RarePrizeBlox);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}

