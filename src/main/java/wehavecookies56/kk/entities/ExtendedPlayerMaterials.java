package wehavecookies56.kk.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

	public Map<String, Integer> knownMaterialsMap = new HashMap<String, Integer>();

	public ExtendedPlayerMaterials(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		Iterator it = getKnownMaterialsMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
			properties.setInteger(pair.getKey().toString(), pair.getValue());
		}

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		Iterator it = properties.getKeySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			getKnownMaterialsMap().put(key.toString(), properties.getInteger(key));
			if (properties.getInteger(key) == 0 && key.toString() != null)
				getKnownMaterialsMap().remove(key.toString());
		}
	}

	public void addMaterial(Material material, int amount) {
		if (getKnownMaterialsMap().containsKey(material.getName())) {
			int currAmount = getKnownMaterialsMap().get(material.getName());
			getKnownMaterialsMap().replace(material.getName(), currAmount + amount);
		} else
			getKnownMaterialsMap().put(material.getName(), amount);
		sync();
	}

	public void removeMaterial(Material material, int amount) {
		if (getKnownMaterialsMap().containsKey(material.getName())) {
			int currAmount = getKnownMaterialsMap().get(material.getName());
			if (amount > currAmount)
				return;
			getKnownMaterialsMap().replace(material.getName(), currAmount - amount);
		} else
			return;
		sync();
	}

	public int getMaterialAmount(Material material) {
		if (getKnownMaterialsMap().containsKey(material.getName())) {
			int currAmount = getKnownMaterialsMap().get(material.getName());
			return currAmount;
		}
		return 0;
	}

	public Map<String, Integer> getKnownMaterialsMap() {
		return this.knownMaterialsMap;
	}

	@Override
	public void init(Entity entity, World world) {
	}

	public void learnMaterial(Material material) {
		// knownMaterials.add(material.getName());
		if (player instanceof EntityPlayerMP)
			sync();
	}

	public final void sync() {
		SyncExtendedPlayerMaterials packet = new SyncExtendedPlayerMaterials(player);
		if (player.worldObj.isRemote)
			PacketDispatcher.sendToServer(packet);

		if (!player.worldObj.isRemote) {
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendTo(packet, player1);
		}
	}

	private static String getSaveKey(EntityPlayer player) {
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayerMaterials playerData = ExtendedPlayerMaterials.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData(SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData(EntityPlayer player) {
		ExtendedPlayerMaterials playerData = ExtendedPlayerMaterials.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if (savedData != null)
			playerData.loadNBTData(savedData);
		playerData.sync();
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerMaterials(player));
	}

	public static final ExtendedPlayerMaterials get(EntityPlayer player) {
		return (ExtendedPlayerMaterials) player.getExtendedProperties(EXT_PROP_NAME);
	}

}
