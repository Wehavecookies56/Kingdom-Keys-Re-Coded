package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants;
import wehavecookies56.kk.inventory.InventoryKeychain;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.recipes.Recipe;
import wehavecookies56.kk.recipes.RecipeKingdomKey;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.LogHelper;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayer";

	private final EntityPlayer player;

	public final InventoryKeychain inventory = new InventoryKeychain();

	public int munny, maxMunny, level, maxLevel, experience, maxExperience, mp, maxMp, keybladeSummoned;

	public ExtendedPlayer(EntityPlayer player){
		this.player = player;
		this.munny = 0;
		this.level = 1;
		this.experience = 0;
		this.mp = 0;
		this.maxMunny = Integer.MAX_VALUE;
		this.maxLevel = 99;
		this.maxExperience = 10;
		this.maxMp = 100;
		this.keybladeSummoned = 0;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound properties = new NBTTagCompound();
		this.inventory.writeToNBT(properties);

		properties.setInteger("Munny", this.munny);
		properties.setInteger("Level", this.level);
		properties.setInteger("Experience", this.experience);
		properties.setInteger("MP", this.mp);
		properties.setInteger("MaxExperience", this.maxExperience);
		properties.setInteger("MaxMP", this.maxMp);
		properties.setInteger("KeybladeSummoned", this.keybladeSummoned);

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventory.readFromNBT(properties);

		this.munny = properties.getInteger("Munny");
		this.level = properties.getInteger("Level");
		this.experience = properties.getInteger("Experience");
		this.mp = properties.getInteger("MP");
		this.maxExperience = properties.getInteger("MaxExperience");
		this.maxMp = properties.getInteger("MaxMP");
		this.keybladeSummoned = properties.getInteger("KeybladeSummoned");
		LogHelper.info("Loaded munny: " + properties.getString("Munny"));
		String s = properties.getInteger("KeybladeSummoned") > 0 ? "Keyblade is summoned" : "Keyblade is not summoned";
		LogHelper.info("Loaded Summon data: " + s);
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public int getSummonedKeyblade() {
		return this.keybladeSummoned;
	}

	public void setSummonedKeyblade(int summoned) {
		this.keybladeSummoned = summoned;
		this.sync();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.sync();
		this.level = level;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.sync();
		this.maxLevel = maxLevel;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.sync();
		this.experience = experience;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.sync();
		this.maxExperience = maxExperience;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.sync();
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.sync();
		this.maxMp = maxMp;
	}

	public boolean addMunny(int amount){
		boolean sufficient = true;

		if(amount + this.munny > this.maxMunny || amount > this.maxMunny){
			sufficient = false;
		}

		if (sufficient) {
			this.munny += amount;
			this.sync();
		} else {
			return false;
		}
		return true;
	}

	public boolean removeMunny(int amount){
		boolean sufficient = true;

		if(amount - this.maxMunny < 0 || amount > this.maxMunny){
			sufficient = false;
		}
		if(sufficient){
			this.munny -= amount;
			this.sync();
		} else {
			return false;
		}
		return true;
	}

	public int getMunny(){
		return this.munny;
	}

	public void setMunny(int amount){
		this.munny = amount;
		this.sync();
	}

	public void setMaxMunny(int max){
		this.maxMunny = max;
		this.sync();
	}

	public int getMaxMunny(){
		return this.maxMunny;
	}


	public final void sync(){
		SyncExtendedPlayer packet = new SyncExtendedPlayer(player);
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
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData (SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData (EntityPlayer player){
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) {
			playerData.loadNBTData(savedData);
		}
		playerData.sync();
	}

	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player){
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}


}
