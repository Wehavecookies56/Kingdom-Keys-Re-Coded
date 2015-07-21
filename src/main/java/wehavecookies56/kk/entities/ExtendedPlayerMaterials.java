package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerMaterials;

public class ExtendedPlayerMaterials implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayerMaterials";

	private final EntityPlayer player;

	public int[] arrayOfAmounts;

	public List<String> knownMaterials = new ArrayList<String>();

	public ExtendedPlayerMaterials(EntityPlayer player, int size) {
		this.player = player;
		arrayOfAmounts = new int[size];
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setIntArray("Amounts", arrayOfAmounts);

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		arrayOfAmounts = properties.getIntArray("Amounts");

	}

	@Override
	public void init(Entity entity, World world) {}

	public void setMaterialArray(int amount, int index){
		arrayOfAmounts[index] = amount;
		this.sync();
	}

	public void learnMaterial(Material material){
		knownMaterials.add(material.getName());
		if(player instanceof EntityPlayerMP)
			this.sync();
	}

	public final void sync(){
		SyncExtendedPlayerMaterials packet = new SyncExtendedPlayerMaterials(player);
		if(player.worldObj.isRemote){
			PacketDispatcher.sendToServer(packet);
		}

		if(!player.worldObj.isRemote){
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendTo(packet, player1);
		}
	}

	private static String getSaveKey (EntityPlayer player){
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player){
		ExtendedPlayerMaterials playerData = ExtendedPlayerMaterials.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData (SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData (EntityPlayer player){
		ExtendedPlayerMaterials playerData = ExtendedPlayerMaterials.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) {
			playerData.loadNBTData(savedData);
		}
		playerData.sync();
	}

	public static final void register(EntityPlayer player, int size){
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerMaterials(player, size));
	}

	public static final ExtendedPlayerMaterials get(EntityPlayer player){
		return (ExtendedPlayerMaterials) player.getExtendedProperties(EXT_PROP_NAME);
	}

}
