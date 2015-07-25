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
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.inventory.InventoryKeychain;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.recipes.RecipeKingdomKey;
import wehavecookies56.kk.util.LogHelper;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayer";

	private final EntityPlayer player;

	public final InventoryKeychain inventory = new InventoryKeychain();

	public int munny, maxMunny, level, maxLevel, experience, maxExperience, antiPoints;
	
	public double mp, maxMp, dp, maxDP;

	public List<String> driveForms = new ArrayList<String>();

	public boolean keybladeSummoned, firstKeyblade, inDrive, cheatMode, inRecharge;
	
	public String actualDrive;

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
		this.keybladeSummoned = false;
		this.firstKeyblade = false;
		this.dp = 0;
		this.maxDP = 1000;
		this.inDrive = false;
		this.cheatMode = false;
		this.actualDrive = "none";
		this.antiPoints = 0;
		this.inRecharge = true;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound properties = new NBTTagCompound();
		this.inventory.writeToNBT(properties);

		properties.setInteger("Munny", this.munny);
		properties.setInteger("Level", this.level);
		properties.setInteger("Experience", this.experience);
		properties.setDouble("MP", this.mp);
		properties.setInteger("MaxExperience", this.maxExperience);
		properties.setDouble("MaxMP", this.maxMp);
		properties.setDouble("DP", this.dp);
		properties.setBoolean("KeybladeSummoned", this.keybladeSummoned);
		properties.setBoolean("FirstKeyblade", this.firstKeyblade);
		properties.setBoolean("InDrive", this.inDrive);
		properties.setBoolean("CheatMode", this.cheatMode);
		properties.setString("ActualDrive", this.actualDrive);
		properties.setInteger("AntiPoints", this.antiPoints);
		properties.setBoolean("InRecharge", this.inRecharge);
		NBTTagList tagList = new NBTTagList();
		for (int i = 0; i < driveForms.size(); i++){
			String s = driveForms.get(i);
			if(s != null){
				NBTTagCompound recipes = new NBTTagCompound();
				recipes.setString("DriveForm" + i, s);
				tagList.appendTag(recipes);
			}

		}
		properties.setTag("DriveFormList", tagList);

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventory.readFromNBT(properties);

		this.munny = properties.getInteger("Munny");
		this.level = properties.getInteger("Level");
		this.experience = properties.getInteger("Experience");
		this.mp = properties.getDouble("MP");
		this.maxExperience = properties.getInteger("MaxExperience");
		this.maxMp = properties.getDouble("MaxMP");
		this.dp = properties.getDouble("DP");
		this.keybladeSummoned = properties.getBoolean("KeybladeSummoned");
		this.firstKeyblade = properties.getBoolean("FirstKeyblade");
		this.inDrive = properties.getBoolean("InDrive");
		this.cheatMode = properties.getBoolean("CheatMode");
		this.actualDrive = properties.getString("ActualDrive");
		this.antiPoints = properties.getInteger("AntiPoints");
		this.inRecharge = properties.getBoolean("InRecharge");


		LogHelper.info("Loaded munny: " + properties.getInteger("Munny"));
		LogHelper.info("Loaded DP: " + properties.getInteger("DP"));
		String s = properties.getBoolean("KeybladeSummoned") == true ? "Keyblade is summoned" : "Keyblade is not summoned";
		LogHelper.info("Loaded Summon data: " + s);

		NBTTagList tagList = properties.getTagList("DriveFormList", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound drives = tagList.getCompoundTagAt(i);
			if(!DriveFormRegistry.isDriveFormKnown(player, drives.getString("DriveForm" + i))){
				driveForms.add(i, drives.getString("DriveForm" + i));
				LogHelper.info("Loaded known Drive form: " + drives.getString("Drive Forms" + i) + " " + i);
			}

		}
	}

	@Override
	public void init(Entity entity, World world) {

	}
	
	public boolean getRecharge()
	{
		return this.inRecharge;
	}
	
	public void setRecharge(boolean recharge)
	{
		this.inRecharge = recharge;
		this.sync();
	}
	
	public int getAntiPoints()
	{
		return this.antiPoints;
	}
	
	public void setAntiPoints(int points)
	{
		this.antiPoints = points;
		this.sync();
	}
	
	public void addAntiPoints(int points)
	{
		if(this.antiPoints <= 100)
		{
			this.antiPoints += points;
			System.out.println(this.antiPoints);
			this.sync();
		}
	}
	
	public void removeAntiPoints(int points)
	{
		if(this.antiPoints >= 0)
		{
			if(this.antiPoints - points < 0)
			{
				this.antiPoints = 0;
			}
			else
			{
				this.antiPoints -= points;
			}
			this.sync();
		}
	}

	public boolean getInDrive(){
		return this.inDrive;
	}

	public void setDriveInUse(String drive)
	{
		this.actualDrive = drive;
		this.sync();
	}

	
	public String getDriveInUse()
	{
		return this.actualDrive;
	}
	public void setInDrive(boolean inDrive){
		this.inDrive = inDrive;
		this.sync();
	}

	public double getDP(){
		return this.dp;
	}

	public void setDP(double amount){
		this.dp = amount;
		this.sync();
	}

	public boolean isKeybladeSummoned() {
		return this.keybladeSummoned;
	}

	public void setKeybladeSummoned(boolean summoned) {
		this.keybladeSummoned = summoned;
		this.sync();
	}

	public boolean hasFirstKeyblade() {
		return this.firstKeyblade;
	}

	public void setFirstKeyblade(boolean first) {
		this.firstKeyblade = first;
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
		this.maxLevel = maxLevel;
		this.sync();
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
		this.sync();
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
		this.sync();
	}

	public double getMp() {
		return mp;
	}

	public void setMp(double mp) {
		this.mp = mp;
		this.sync();
	}

	public double getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(double maxMp) {
		this.maxMp = maxMp;
		this.sync();
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

	public boolean addDP(double dp2){
		boolean sufficient = true;

		if(dp2 + this.dp > this.maxDP || dp2 > this.maxDP){
			sufficient = false;
		}

		if (sufficient) {
			this.dp += dp2;
			this.sync();
		} else {
			this.dp = this.maxDP;
			this.sync();
			return false;
		}
		return true;
	}

	public boolean addMp(double amount){
		boolean sufficient = true;

		if(amount + this.mp > this.maxMp || amount > this.maxMp){
			this.mp = this.maxMp;
			this.sync();
			sufficient = false;
		}

		if (sufficient) {
			this.mp += amount;
			this.sync();
		} else {
			return false;
		}
		return true;
	}

	public boolean removeMp(double amount){
		boolean sufficient = true;

		if(this.mp - amount < 0 || amount > this.mp){
			this.mp = 0;
			this.sync();
			sufficient = false;
		}
		if(sufficient){
			this.mp -= amount;
			this.sync();
		} else {
			return false;
		}
		return true;
	}

	public boolean removeDP(double dp2){
		boolean sufficient = true;

		if(this.maxDP - dp2 < 0 || dp2 > this.maxDP){
			sufficient = false;
		}
		if(sufficient){
			this.dp -= dp2;
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

	public void setCheatMode(boolean bool)
	{
		this.cheatMode = bool;
		this.sync();
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

	public void learnDriveForm(DriveForm driveForm) {
		driveForms.add(driveForm.getName());
		if(player instanceof EntityPlayerMP)
			this.sync();
	}


}
