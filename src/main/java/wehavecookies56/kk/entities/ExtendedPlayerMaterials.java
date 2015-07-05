package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerMaterials;
import wehavecookies56.kk.recipes.Recipe;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants;

public class ExtendedPlayerMaterials implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayerMaterials";

	private final EntityPlayer player;

	public ExtendedPlayerMaterials(EntityPlayer player) {
		this.player = player;
	}

	public List<String> materials = new ArrayList<String>();

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		NBTTagList matList = new NBTTagList();
		NBTTagCompound mats = new NBTTagCompound();
		for (int i = 0; i < materials.size(); i++){
			mats.setString("Materials" + i, materials.get(i));
			matList.appendTag(mats);
		}
		properties.setTag("MaterialsList", matList);
		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		NBTTagList matList = properties.getTagList("MaterialsList", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < matList.tagCount(); i++){
			NBTTagCompound mats = matList.getCompoundTagAt(i);
			materials.add(i, mats.getString("Materials" + i));
			LogHelper.info("Loaded material: " + mats.getString("Materials" + i));
		}

	}

	@Override
	public void init(Entity entity, World world) {}

	public void addMaterial(String name){
		materials.add(name);
		if(player instanceof EntityPlayerMP)
			this.sync();
	}

	public boolean consumeMaterial(String name){
		for(int i = 0; i < materials.size(); i++){
			if(materials.get(i).equals(name)){
				materials.remove(i);
				return true;
			}
		}
		return false;
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
