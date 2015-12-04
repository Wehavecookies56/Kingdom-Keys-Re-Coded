package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.inventory.InventorySynthesisBagS;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerMaterials;
import wehavecookies56.kk.util.LogHelper;

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

		Iterator it = this.getKnownMaterialsMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)it.next();
			properties.setInteger((String)pair.getKey().toString(), pair.getValue());
		}

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		Iterator it = properties.getKeySet().iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			this.getKnownMaterialsMap().put((String)key.toString(), properties.getInteger(key));
		}
	}

	public void addMaterial(Material material, int amount){
		if(this.getKnownMaterialsMap().containsKey(material.getName())){
			int currAmount = this.getKnownMaterialsMap().get(material.getName());
			this.getKnownMaterialsMap().replace(material.getName(), currAmount + amount);
		}else{
			this.getKnownMaterialsMap().put(material.getName(), amount);
		}
		this.sync();
	}
	
	public void removeMaterial(Material material, int amount){
		if(this.getKnownMaterialsMap().containsKey(material.getName())){
			int currAmount = this.getKnownMaterialsMap().get(material.getName());
			if(amount > currAmount){
				return;
			}
			this.getKnownMaterialsMap().replace(material.getName(), currAmount - amount);
		}else{
			return;
		}
		this.sync();
	}
	
	public int getMaterialAmount(Material material)
	{
		if(this.getKnownMaterialsMap().containsKey(material.getName())){
			int currAmount = this.getKnownMaterialsMap().get(material.getName());
				return currAmount;
			}
		return 0;
	}
	
	public Map<String, Integer> getKnownMaterialsMap(){
		return this.knownMaterialsMap;
	}
	
	@Override
	public void init(Entity entity, World world) {}

	public void learnMaterial(Material material){
		//knownMaterials.add(material.getName());
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

	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerMaterials(player));
	}

	public static final ExtendedPlayerMaterials get(EntityPlayer player){
		return (ExtendedPlayerMaterials) player.getExtendedProperties(EXT_PROP_NAME);
	}

}
