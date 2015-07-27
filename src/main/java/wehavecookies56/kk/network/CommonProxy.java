package wehavecookies56.kk.network;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.client.gui.GuiKeychains;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.ContainerKeychain;

public class CommonProxy implements IGuiHandler {

	public void init()
	{
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());

	}

	public void spawnFireParticles(Entity entity){

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
		if (ID == KingdomKeys.GUI_KEYCHAIN_INV){
			return new ContainerKeychain(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		else{
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == KingdomKeys.GUI_KEYCHAIN_INV){
			return new GuiKeychains(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		else{
			return null;
		}

	}

}
