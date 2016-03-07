package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.inventory.InventoryDriveForms;
import wehavecookies56.kk.inventory.InventoryKeychain;
import wehavecookies56.kk.inventory.InventoryPotionsMenu;
import wehavecookies56.kk.inventory.InventorySpells;
import wehavecookies56.kk.item.ItemDriveForm;
import wehavecookies56.kk.item.ItemKKPotion;
import wehavecookies56.kk.item.ItemSpellOrb;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.ShowOverlayPacket;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.server.SyncStatMessagesPacket;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayer";

	private final EntityPlayer player;

	public final InventoryKeychain inventoryKeychain = new InventoryKeychain();
	public final InventoryPotionsMenu inventoryPotions = new InventoryPotionsMenu();
	public final InventorySpells inventorySpells = new InventorySpells();
	public final InventoryDriveForms inventoryDrive = new InventoryDriveForms();

	public int munny, maxMunny;

	public int level;

	public int maxLevel;

	public int experience;

	public int maxExperience;

	public int antiPoints;

	public int strength;

	public int defense;

	public int magic;

	public int hp;

	public double mp, maxMp, dp, maxDP;

	public int fireLevel = 1, blizzardLevel = 1, thunderLevel = 1, cureLevel = 1, gravityLevel = 1, aeroLevel = 1, stopLevel = 1;

	public int valorLevel = 1, wisdomLevel = 1, limitLevel = 1, masterLevel = 1, finalLevel = 1;

	public static List<String> driveForms = new ArrayList<String>();
	public static List<String> spells = new ArrayList<String>();
	public static List<String> items = new ArrayList<String>();

	public boolean keybladeSummoned, firstKeyblade, inDrive, cheatMode, inRecharge;

	public String actualDrive;

	public ExtendedPlayer (EntityPlayer player) {
		this.player = player;
		this.munny = 0;
		this.level = 1;
		this.experience = 0;
		this.mp = 0;
		this.maxMunny = Integer.MAX_VALUE;
		this.maxLevel = 99;
		this.maxExperience = 999999;
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
		this.strength = 1;
		this.defense = 1;
		this.magic = 1;
		this.hp = 20;

		this.fireLevel = 1;
		this.blizzardLevel = 1;
		this.thunderLevel = 1;
		this.gravityLevel = 1;
		this.cureLevel = 1;
		this.aeroLevel = 1;
		this.stopLevel = 1;

		this.valorLevel = 0;
		this.wisdomLevel = 0;
		this.limitLevel = 0;
		this.masterLevel = 0;
		this.finalLevel = 0;
	}

	@Override
	public void saveNBTData (NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		this.inventoryKeychain.writeToNBT(properties);
		this.inventoryPotions.writeToNBT(properties);
		this.inventorySpells.writeToNBT(properties);
		this.inventoryDrive.writeToNBT(properties);

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
		properties.setInteger("Strength", this.strength);
		properties.setInteger("Defense", this.defense);
		properties.setInteger("Magic", this.magic);
		properties.setInteger("HP", this.hp);

		properties.setInteger("FireLevel", this.fireLevel);
		properties.setInteger("BlizzardLevel", this.blizzardLevel);
		properties.setInteger("ThunderLevel", this.thunderLevel);
		properties.setInteger("CureLevel", this.cureLevel);
		properties.setInteger("GravityLevel", this.gravityLevel);
		properties.setInteger("AeroLevel", this.aeroLevel);
		properties.setInteger("StopLevel", this.stopLevel);

		properties.setInteger("ValorLevel", this.valorLevel);
		properties.setInteger("WisdomLevel", this.wisdomLevel);
		properties.setInteger("LimitLevel", this.limitLevel);
		properties.setInteger("MasterLevel", this.masterLevel);
		properties.setInteger("FinalLevel", this.finalLevel);

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData (NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventoryKeychain.readFromNBT(properties);
		this.inventoryPotions.readFromNBT(properties);
		this.inventorySpells.readFromNBT(properties);
		this.inventoryDrive.readFromNBT(properties);

		ExtendedPlayer.spells.clear();
		for (int i = 0; i < this.inventorySpells.getSizeInventory(); i++) {
			if (this.inventorySpells.getStackInSlot(i) != null) {
				ExtendedPlayer.spells.add(((ItemSpellOrb) this.inventorySpells.getStackInSlot(i).getItem()).getMagicName());
			}
		}
		ExtendedPlayer.driveForms.clear();
		for (int i = 0; i < this.inventoryDrive.getSizeInventory(); i++)
			if (this.inventoryDrive.getStackInSlot(i) != null) ExtendedPlayer.driveForms.add(((ItemDriveForm) this.inventoryDrive.getStackInSlot(i).getItem()).getDriveFormName());
		ExtendedPlayer.items.clear();
		for (int i = 0; i < this.inventoryPotions.getSizeInventory(); i++)
			if (this.inventoryPotions.getStackInSlot(i) != null) ExtendedPlayer.items.add(((ItemKKPotion) this.inventoryPotions.getStackInSlot(i).getItem()).getItemName());
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
		this.strength = properties.getInteger("Strength");
		this.defense = properties.getInteger("Defense");
		this.magic = properties.getInteger("Magic");
		this.hp = properties.getInteger("HP");
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.hp);

		this.fireLevel = properties.getInteger("FireLevel");
		this.blizzardLevel = properties.getInteger("BlizzardLevel");
		this.thunderLevel = properties.getInteger("ThunderLevel");
		this.cureLevel = properties.getInteger("CureLevel");
		this.gravityLevel = properties.getInteger("GravityLevel");
		this.aeroLevel = properties.getInteger("AeroLevel");
		this.stopLevel = properties.getInteger("StopLevel");

		this.valorLevel = properties.getInteger("ValorLevel");
		this.wisdomLevel = properties.getInteger("WisdomLevel");
		this.limitLevel = properties.getInteger("LimitLevel");
		this.masterLevel = properties.getInteger("MasterLevel");
		this.finalLevel = properties.getInteger("FinalLevel");
	}

	@Override
	public void init (Entity entity, World world) {}

	public int getMagicLevel (String magic) {
		switch(magic){
			case Strings.Spell_Fire:
				return this.fireLevel;
			case Strings.Spell_Blizzard:
				return this.blizzardLevel;
			case Strings.Spell_Thunder:
				return this.thunderLevel;
			case Strings.Spell_Cure:
				return this.cureLevel;
			case Strings.Spell_Gravity:
				return this.gravityLevel;
			case Strings.Spell_Aero:
				return this.aeroLevel;
			case Strings.Spell_Stop:
				return this.stopLevel;
			default:
				return -1;
		}
	}

	public void setDriveLevel (String form, int level) {
		switch(form){
			case Strings.Form_Valor:
				this.valorLevel = level;
				break;
			case Strings.Form_Wisdom:
				this.wisdomLevel = level;
				break;
			case Strings.Form_Limit:
				this.limitLevel = level;
				break;
			case Strings.Form_Master:
				this.masterLevel = level;
				break;
			case Strings.Form_Final:
				this.finalLevel = level;
				break;
		}
		sync();
	}

	public int getDriveLevel (String form) {
		switch(form){
			case Strings.Form_Valor:
				return this.valorLevel;
			case Strings.Form_Wisdom:
				return this.wisdomLevel;
			case Strings.Form_Limit:
				return this.limitLevel;
			case Strings.Form_Master:
				return this.masterLevel;
			case Strings.Form_Final:
				return this.finalLevel;
			default:
				return -1;
		}
	}

	public void setMagicLevel (String magic, int level) {
		switch(magic){
			case Strings.Spell_Fire:
				this.fireLevel = level;
				break;
			case Strings.Spell_Blizzard:
				blizzardLevel = level;
				break;
			case Strings.Spell_Thunder:
				this.thunderLevel = level;
				break;
			case Strings.Spell_Cure:
				this.cureLevel = level;
				break;
			case Strings.Spell_Gravity:
				this.gravityLevel = level;
				break;
			case Strings.Spell_Aero:
				this.aeroLevel = level;
				break;
			case Strings.Spell_Stop:
				this.stopLevel = level;
				break;
		}
		sync();
	}

	public boolean addStrength (int amount) {
		this.strength += amount;
		sync();
		PlayerLevel.messages.add("str");
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new SyncStatMessagesPacket("str"), (EntityPlayerMP) player);
		return true;
	}

	public int getStrength () {
		return this.strength;
	}

	public void setStrength (int strength) {
		this.strength = strength;
		sync();
	}

	public boolean addDefense (int amount) {
		this.defense += amount;
		sync();
		PlayerLevel.messages.add("def");
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new SyncStatMessagesPacket("def"), (EntityPlayerMP) player);
		return true;
	}

	public int getDefense () {
		return this.defense;
	}

	public void setDefense (int defense) {
		this.defense = defense;
		sync();
	}

	public boolean addMagic (int amount) {
		this.magic += amount;
		sync();
		PlayerLevel.messages.add("mag");
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new SyncStatMessagesPacket("mag"), (EntityPlayerMP) player);
		return true;
	}

	public int getMagic () {
		return this.magic;
	}

	public void setMagic (int magic) {
		this.magic = magic;
		sync();
	}

	public boolean addHP (int amount) {
		this.hp += amount;
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.hp + amount);
		sync();
		PlayerLevel.messages.add("hp");
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new SyncStatMessagesPacket("hp"), (EntityPlayerMP) player);
		return true;
	}

	public int getHP () {
		return this.hp;
	}

	public void setHP (int hp) {
		this.hp = hp;
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(hp);
		sync();
	}

	public boolean getRecharge () {
		return this.inRecharge;
	}

	public void setRecharge (boolean recharge) {
		if (this.inRecharge == recharge) return;
		this.inRecharge = recharge;
		sync();
	}

	public int getAntiPoints () {
		return this.antiPoints;
	}

	public void setAntiPoints (int points) {
		if (this.antiPoints == points) return;
		this.antiPoints = points;
		sync();
	}

	public void addAntiPoints (int points) {
		if (this.antiPoints <= 100) {
			this.antiPoints += points;
			sync();
		}
	}

	public void removeAntiPoints (int points) {
		if (this.antiPoints >= 0) {
			if (this.antiPoints - points < 0)
				this.antiPoints = 0;
			else
				this.antiPoints -= points;
			sync();
		}
	}

	public boolean getInDrive () {
		return this.inDrive;
	}

	public void setDriveInUse (String drive) {
		if (this.actualDrive.equals(drive)) return;
		this.actualDrive = drive;
		sync();
	}

	public String getDriveInUse () {
		return this.actualDrive;
	}

	public void setInDrive (boolean inDrive) {
		if (this.inDrive == inDrive) return;
		this.inDrive = inDrive;
		sync();
	}

	public double getDP () {
		return this.dp;
	}

	public void setDP (double amount) {
		if (amount == this.dp) return;
		this.dp = amount;
		sync();
	}

	public boolean isKeybladeSummoned () {
		return this.keybladeSummoned;
	}

	public void setKeybladeSummoned (boolean summoned) {
		this.keybladeSummoned = summoned;
		sync();
	}

	public boolean hasFirstKeyblade () {
		return this.firstKeyblade;
	}

	public void setFirstKeyblade (boolean first) {
		this.firstKeyblade = first;
		sync();
	}

	public int getLevel () {
		return level;
	}

	public void levelUp () {
		this.level++;
		sync();
		if (!player.worldObj.isRemote) {
			PacketDispatcher.sendTo(new ShowOverlayPacket("levelup"), (EntityPlayerMP) player);
			PacketDispatcher.sendTo(new SyncStatMessagesPacket("clr"), (EntityPlayerMP) player);
		}
	}

	public void levelUp (int level) {
		this.level = level;
		sync();
		if (!player.worldObj.isRemote) {
			PacketDispatcher.sendTo(new ShowOverlayPacket("levelup"), (EntityPlayerMP) player);
			PacketDispatcher.sendTo(new SyncStatMessagesPacket("clr"), (EntityPlayerMP) player);
		}
	}

	public void levelUp (int level, boolean command) {
		// STUFF FOR COMMAND
		this.level = level;
		sync();
		if (!player.worldObj.isRemote) {
			PacketDispatcher.sendTo(new ShowOverlayPacket("levelup"), (EntityPlayerMP) player);
			PacketDispatcher.sendTo(new SyncStatMessagesPacket("clr"), (EntityPlayerMP) player);
		}
	}

	public int getMaxLevel () {
		return maxLevel;
	}

	/*
	 * public void setMaxLevel(int maxLevel) { this.maxLevel = maxLevel;
	 * this.sync(); }
	 */

	public boolean addXP (int amount) {
		boolean sufficient = true;
		setMaxExperience(999999);
		if (amount + this.experience > this.maxExperience || amount > this.maxExperience) {
			this.experience = this.maxExperience;
			sync();
			sufficient = false;
		}

		if (sufficient) {
			this.experience += amount;
			sync();
			PlayerLevel.LevelUp(player);

		} else
			return false;
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new ShowOverlayPacket("exp"), (EntityPlayerMP) player);

		return true;
	}

	public int getXP () {
		return experience;
	}

	public void setXP (int experience) {
		this.experience = experience;
		sync();
		PlayerLevel.LevelUp(player);
	}

	public int getMaxExperience () {
		return maxExperience;
	}

	public void setMaxExperience (int maxExperience) {
		this.maxExperience = maxExperience;
		sync();
	}

	public double getMp () {
		return mp;
	}

	public void setMp (double mp) {
		if (this.mp == mp) return;
		this.mp = mp;
		sync();
	}

	public double getMaxMp () {
		return maxMp;
	}

	public void setMaxMp (double maxMp) {
		this.maxMp = maxMp;
		sync();
	}

	public boolean addMaxMp (double amount) {
		boolean sufficient = true;

		if (amount + this.maxMp > this.maxMp || amount > this.maxMp) sufficient = false;

		if (sufficient) {
			this.maxMp += amount;
			sync();
		} else
			return false;
		return true;
	}

	public boolean addMunny (int amount) {
		boolean sufficient = true;

		if (amount + this.munny > this.maxMunny || amount > this.maxMunny) sufficient = false;

		if (sufficient) {
			this.munny += amount;
			sync();
		} else
			return false;
		if (!player.worldObj.isRemote) PacketDispatcher.sendTo(new ShowOverlayPacket("munny", amount), (EntityPlayerMP) player);
		return true;
	}

	public boolean addDP (double amount) {
		boolean sufficient = true;

		if (amount + this.dp > this.maxDP || amount > this.maxDP) sufficient = false;

		if (sufficient) {
			this.dp += amount;
			sync();
		} else {
			this.dp = this.maxDP;
			sync();
			return false;
		}
		return true;
	}

	public boolean addMp (double amount) {
		boolean sufficient = true;

		if (amount + this.mp > this.maxMp || amount > this.maxMp) {
			this.mp = this.maxMp;
			sync();
			sufficient = false;
		}

		if (sufficient) {
			this.mp += amount;
			sync();
		} else
			return false;
		return true;
	}

	public boolean removeMp (double amount) {
		boolean sufficient = true;

		if (this.mp - amount < 0 || amount > this.mp) {
			this.mp = 0;
			sync();
			sufficient = false;
		}
		if (sufficient) {
			this.mp -= amount;
			sync();
		} else
			return false;
		return true;
	}

	public boolean removeDP (double amount) {
		boolean sufficient = true;

		if (this.maxDP - amount < 0 || amount > this.maxDP) {
			this.dp = 0;
			sync();
			sufficient = false;
		}
		if (sufficient) {
			this.dp -= amount;
			sync();
		} else
			return false;
		return true;
	}

	public boolean removeMunny (int amount) {
		boolean sufficient = true;

		if (amount - this.maxMunny < 0 || amount > this.maxMunny) sufficient = false;
		if (sufficient) {
			this.munny -= amount;
			sync();
		} else
			return false;
		return true;
	}

	public int getMunny () {
		return this.munny;
	}

	public void setMunny (int amount) {
		this.munny = amount;
		sync();
	}

	public void setMaxMunny (int max) {
		this.maxMunny = max;
		sync();
	}

	public int getMaxMunny () {
		return this.maxMunny;
	}

	public void setCheatMode (boolean bool) {
		this.cheatMode = bool;
		sync();
	}

	public final void sync () {
		SyncExtendedPlayer packet = new SyncExtendedPlayer(player);
		if (player.worldObj.isRemote) PacketDispatcher.sendToServer(packet);

		if (!player.worldObj.isRemote) {
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendTo(packet, player1);
		}
	}

	private static String getSaveKey (EntityPlayer player) {
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData (EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData(SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData (EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if (savedData != null) playerData.loadNBTData(savedData);
		playerData.sync();
	}

	public static final void register (EntityPlayer player) {
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get (EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	public void learnDriveForm (DriveForm driveForm) {
		driveForms.add(driveForm.getName());
		if (player instanceof EntityPlayerMP) sync();
	}
}
