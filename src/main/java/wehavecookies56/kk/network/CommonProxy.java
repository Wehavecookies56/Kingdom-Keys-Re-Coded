package wehavecookies56.kk.network;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.client.gui.GuiKKChest;
import wehavecookies56.kk.client.gui.GuiKeychains;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.TileEntityKKChest;
import wehavecookies56.kk.entities.TileEntitySynthesisBag;
import wehavecookies56.kk.inventory.ContainerKKChest;
import wehavecookies56.kk.inventory.ContainerKeychain;
import wehavecookies56.kk.inventory.ContainerSynthesisBag;

public class CommonProxy implements IGuiHandler {

	public void init()
	{
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());

	}

	public EntityPlayer getPlayerEntity(MessageContext ctx){
		return ctx.getServerHandler().playerEntity;
	}

	public IThreadListener getThreadFromContext(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity.getServerForPlayer();
	}

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public  static  void storeEntityData (String name, NBTTagCompound compound){
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData (String name){
		return extendedEntityData.remove(name);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(xyz);

		if (ID == KingdomKeys.GUI_KEYCHAIN_INV){
			return new ContainerKeychain(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		else if (ID == KingdomKeys.GUI_KKCHEST_INV){
			//BlockPos xyz = new BlockPos(x, y, z);
			if(te instanceof TileEntityKKChest){
				TileEntityKKChest tekkc = (TileEntityKKChest) te;
				return new ContainerKKChest(player.inventory, tekkc);
			}else{
				return null;
			}		
		}
		
		else if (ID == KingdomKeys.GUI_SYNTHESISBAG_INV){
			if(te != null && te instanceof TileEntitySynthesisBag)
			{
				TileEntitySynthesisBag tesb = (TileEntitySynthesisBag) te;
				return new ContainerSynthesisBag(player.inventory, tesb);
			}
			else{
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(xyz);
		
		if (ID == KingdomKeys.GUI_KEYCHAIN_INV){
			return new GuiKeychains(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		else if (ID == KingdomKeys.GUI_KKCHEST_INV){
			
			if(te instanceof TileEntityKKChest){
				TileEntityKKChest tekkc = (TileEntityKKChest) te;
				return new GuiKKChest(player.inventory, tekkc);
			}else{
				return null;
			}
		}
		else if (ID == KingdomKeys.GUI_SYNTHESISBAG_INV){
			if(te != null && te instanceof TileEntitySynthesisBag)
			{
				TileEntitySynthesisBag tesb = (TileEntitySynthesisBag) te;
				return new ContainerSynthesisBag(player.inventory, tesb);
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}

	}

	public void preInit() {

	}

}
