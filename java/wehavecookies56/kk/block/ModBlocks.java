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
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import static wehavecookies56.kk.lib.Strings.*;
import wehavecookies56.kk.lib.Strings;

public class ModBlocks {

	public static Block
		NormalBlox;
		
	public static void init(){
		
		NormalBlox = new Block(Material.iron).setUnlocalizedName(Strings.AbaddonPlasma);
	}
	
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void register(){
		GameRegistry.registerBlock(NormalBlox, Strings.NormalBlox);
	}
	
	public static void registerRenders(){
		registerRender(NormalBlox);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}

