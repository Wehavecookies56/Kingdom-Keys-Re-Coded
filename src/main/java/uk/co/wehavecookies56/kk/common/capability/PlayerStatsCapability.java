package uk.co.wehavecookies56.kk.common.capability;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryPotionsMenu;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.ShowOverlayPacket;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

public class PlayerStatsCapability {

	List<String> messages = new ArrayList<String>();

	public interface IPlayerStats {
		List<String> getMessages();
		int getExperience();
		int getVExperience();
		int getWExperience();
		int getLExperience();
		int getMExperience();
		int getFExperience();

		int getLevel();
		int getMaxLevel();
		int getMaxExperience();
		int getStrength();
		int getDefense();
		int getMagic();
		int getHP();		
		double getDP();
		double getMaxDP();
		double getMP();
		double getMaxMP();
		boolean getRecharge();
		
		String getChoice1();
		String getChoice2();
		
		boolean setLevel(int level);
		boolean setExperience(int experience);
		boolean setVExperience(int vexperience);
		boolean setWExperience(int wexperience);
		boolean setLExperience(int lexperience);
		boolean setMExperience(int mexperience);
		boolean setFExperience(int fexperience);
		void addExperience(EntityPlayer player, int amount, String type);
		void setStrength(int strength);
		void addStrength(int strength);
		void setDefense(int defense);
		void addDefense(int defense);
		void setMagic(int magic);
		void addMagic(int magic);
		int setHP(int hp);
		int addHP(int hp);
		boolean setDP(double dp);
		void addDP(double dp);
		void remDP(double dp);
		boolean setMP(double mp);
		void addMP(double mp);
		void remMP(double mp);
		void setMaxMP(double mp);
		void setRecharge(boolean recharge);
		
		void setChoice1(String choice);
		void setChoice2(String choice);

		InventoryPotionsMenu getInventoryPotionsMenu();
		
		boolean getHudMode();
		void setHudMode(boolean mode);
		int getExpNeeded(int level, int experience);
		void levelUpStatsAndDisplayMessage(EntityPlayer player);
		void clearMessages();
	}

	public static class Storage implements IStorage<IPlayerStats> {

		@Override
		public NBTBase writeNBT(Capability<IPlayerStats> capability, IPlayerStats instance, EnumFacing side) {
			NBTTagCompound properties = new NBTTagCompound();
			properties.setInteger("Level", instance.getLevel());
			properties.setInteger("Experience", instance.getExperience());
			properties.setInteger("VExperience", instance.getVExperience());
			properties.setInteger("Strength", instance.getStrength());
			properties.setInteger("Defense", instance.getDefense());
			properties.setInteger("Magic", instance.getMagic());
			properties.setInteger("HP", instance.getHP());
			properties.setDouble("DP", instance.getDP());
			properties.setDouble("MP", instance.getMP());
			properties.setDouble("Max MP", instance.getMaxMP());
			properties.setBoolean("Recharge", instance.getRecharge());
			
			properties.setBoolean("HUD", instance.getHudMode());
			
			properties.setString("Choice1", instance.getChoice1());
			properties.setString("Choice2", instance.getChoice2());
			instance.getInventoryPotionsMenu().writeToNBT(properties);

			return properties;
		}

		@Override
		public void readNBT(Capability<IPlayerStats> capability, IPlayerStats instance, EnumFacing side, NBTBase nbt) {
			NBTTagCompound properties = (NBTTagCompound) nbt;
			instance.setLevel(properties.getInteger("Level"));
			instance.setExperience(properties.getInteger("Experience"));
			instance.setStrength(properties.getInteger("Strength"));
			instance.setDefense(properties.getInteger("Defense"));
			instance.setMagic(properties.getInteger("Magic"));
			instance.setHP(properties.getInteger("HP"));
			instance.setDP(properties.getDouble("DP"));
			instance.setMP(properties.getDouble("MP"));
			instance.setMaxMP(properties.getDouble("Max MP"));
			instance.setRecharge(properties.getBoolean("Recharge"));
			instance.setHudMode(properties.getBoolean("HUD"));
			
			instance.setChoice1(properties.getString("Choice1"));
			instance.setChoice2(properties.getString("Choice2"));
			instance.getInventoryPotionsMenu().readFromNBT(properties);
		}
	}
	
	public static class Default implements IPlayerStats {
		private int level = 1;
		private int maxLevel = 100;
		private int experience = 0;
		private int valorExperience = 0;
		private int wisdomExperience = 0;
		private int limitExperience = 0;
		private int masterExperience = 0;
		private int finalExperience = 0;
		private int maxExperience = Integer.MAX_VALUE;
		private int valorMaxExperience = Integer.MAX_VALUE;
		private int wisdomMaxExperience = Integer.MAX_VALUE;
		private int limitMaxExperience = Integer.MAX_VALUE;
		private int masterMaxExperience = Integer.MAX_VALUE;
		private int finalMaxExperience = Integer.MAX_VALUE;
		private int strength = 1;
		private int defense = 1;
		private int magic = 1;
		private int hp = 20;
        private double mp = 100;
        private double maxMP = 100;
        private double dp = 0;
        private double maxDP = 1000;
		private boolean recharge = false;
		private boolean cheatMode = false;
		private boolean hudmode = true;
		private int remainingExp = 0;
		private List<String> messages = new ArrayList<String>();
		
		private String choice1="none",choice2="none";
		
		private final InventoryPotionsMenu inventoryPotions = new InventoryPotionsMenu();

		@Override public List<String> getMessages() { return this.messages; }

		@Override public InventoryPotionsMenu getInventoryPotionsMenu(){return this.inventoryPotions;}

        @Override public double getMP() { return this.mp; }
        @Override public double getMaxMP() { return this.maxMP; }
		@Override public int getLevel() { return this.level; }
		@Override public int getMaxLevel() { return this.maxLevel; }
		@Override public int getExperience() { 
			return this.experience;
		}
		@Override public int getVExperience() { 
			return this.valorExperience;
		}
		
		@Override public int getWExperience() { 
			return this.wisdomExperience;
		}
		@Override public int getLExperience() { 
			return this.limitExperience;
		}
		@Override public int getMExperience() { 
			return this.masterExperience;
		}
		@Override public int getFExperience() { 
			return this.finalExperience;
		}
		@Override public int getMaxExperience() { return this.maxExperience; }
		@Override public int getStrength() { return this.strength; }
		@Override public int getDefense() { return this.defense; }
		@Override public int getMagic() { return this.magic; }
		@Override public int getHP() { return this.hp; }
		@Override public double getDP() { return this.dp; }
		@Override public double getMaxDP() { return this.maxDP; }
		@Override public boolean getRecharge() { return this.recharge; }
		@Override public boolean getHudMode() {return this.hudmode;}
		
		@Override public String getChoice1(){return this.choice1;}
		@Override public String getChoice2(){return this.choice2;}
		
		@Override public boolean setLevel(int level) {
			if (level <= this.maxLevel) {
				this.level = level;
				return true;
			}
			return false;
		}

		@Override public void clearMessages() {
			this.getMessages().clear();
		}
		@Override public boolean setExperience(int experience) { 
			if (experience <= this.maxExperience) {
				this.experience = experience; 
				return true; 
			} return false;
		}
		
		@Override public boolean setVExperience(int experience) { 
			if (valorExperience <= this.valorMaxExperience) {
				this.valorExperience = experience; 
				return true; 
			} return false;
		}
		@Override public boolean setWExperience(int experience) { 
			if (wisdomExperience <= this.wisdomMaxExperience) {
				this.wisdomExperience = experience; 
				return true; 
			} return false;
		}
		@Override public boolean setLExperience(int experience) { 
			if (limitExperience <= this.limitMaxExperience) {
				this.limitExperience = experience; 
				return true; 
			} return false;
		}
		@Override public boolean setMExperience(int experience) { 
			if (masterExperience <= this.masterMaxExperience) {
				this.masterExperience = experience; 
				return true; 
			} return false;
		}
		@Override public boolean setFExperience(int experience) { 
			if (finalExperience <= this.finalMaxExperience) {
				this.finalExperience = experience; 
				return true; 
			} return false;
		}
		
	
		@Override 
		public void addExperience(EntityPlayer player, int amount, String type)
		{
			if(player != null)
			{
				IPlayerStats stats = player.getCapability(ModCapabilities.PLAYER_STATS, null);
				switch(type)
				{
					case "normal":
							if (this.experience + amount <= this.maxExperience){
								this.experience += amount;
								while (this.getExpNeeded(this.getLevel(), this.experience) <= 0 && this.getLevel() != 100) {
									this.setLevel(this.getLevel() + 1);
									this.levelUpStatsAndDisplayMessage(player);
									PacketDispatcher.sendTo(new ShowOverlayPacket("levelup", level),(EntityPlayerMP)player);
								}
							}else {
								this.experience = this.maxExperience;
							}
							PacketDispatcher.sendTo(new ShowOverlayPacket("exp"),(EntityPlayerMP)player);
						break;
					case Strings.Form_Valor:
						if (this.valorExperience + amount <= this.valorMaxExperience)
							this.valorExperience += amount;
						else
							this.valorExperience = this.valorMaxExperience;
						break;
					case Strings.Form_Wisdom:
						if (this.wisdomExperience + amount <= this.wisdomMaxExperience)
							this.wisdomExperience += amount;
						else
							this.wisdomExperience = this.wisdomMaxExperience;
						break;
					case Strings.Form_Limit:
						if (this.limitExperience + amount <= this.limitMaxExperience)
							this.limitExperience += amount;
						else
							this.limitExperience = this.limitMaxExperience;
						break;
					case Strings.Form_Master:
						if (this.masterExperience + amount <= this.masterMaxExperience)
							this.masterExperience += amount;
						else
							this.masterExperience = this.masterMaxExperience;
						break;
					case Strings.Form_Final:
						if (this.finalExperience + amount <= this.finalMaxExperience)
							this.finalExperience += amount;
						else
							this.finalExperience = this.finalMaxExperience;
						break;
				}
			}
		}
		@Override public void setStrength(int strength) { this.strength = strength; }
		@Override public void addStrength(int strength) { 
			this.strength += strength; 
			messages.add("str");
		}
		@Override public void setDefense(int defense) { this.defense = defense; }
		@Override public void addDefense(int defense) { 
			this.defense += defense; 
			messages.add("def");
		}
		@Override public void setMagic(int magic) { this.magic = magic; }
		@Override public void addMagic(int magic) { 
			this.magic += magic; 
			messages.add("mag");
		}
		@Override public int setHP(int hp) { 
			this.hp = hp; 
			return this.hp;
		}
		@Override public int addHP(int hp) { 
			this.hp += hp; 
			messages.add("hp");
			return this.hp;
		}
        @Override public boolean setDP(double dp) { if (dp <= this.maxDP) {this.dp = dp; return true; } return false; }
        @Override public void addDP(double dp) { if (dp + this.dp > this.maxDP) this.dp = this.maxDP; else this.dp += dp; }
        @Override public void remDP(double dp) {if(cheatMode) return; if (dp + this.dp < 0) this.dp = 0; else this.dp -= dp; }
        @Override public boolean setMP(double mp) { if (mp <= this.maxMP) {this.mp = mp; return true; } return false; }
        @Override public void addMP(double mp) { if (mp + this.mp > this.maxMP) this.mp = this.maxMP; else this.mp += mp; }
        @Override public void remMP(double mp) {if(cheatMode) return; if (this.mp - mp < 0) this.mp = 0;	else this.mp -= mp; }
        @Override public void setMaxMP(double maxMP) { this.maxMP = maxMP;}
		@Override public void setRecharge(boolean recharge) { this.recharge = recharge; }
		@Override public void setHudMode(boolean hud) { this.hudmode = hud; }

		@Override public void setChoice1(String choice){this.choice1=choice;}
		@Override public void setChoice2(String choice){this.choice2=choice;}
		
		@Override
		public int getExpNeeded(int level, int currentExp) {
			if (level == 100) return 0;
			double nextLevel = (double) (((level+1.0)+300.0*(Math.pow(2.0,((level+1.0)/7.0))))*((level+1.0)*0.25));
			int needed = ((int)nextLevel - currentExp);
			this.remainingExp = needed;
			return remainingExp;
		}

		@Override
		public void levelUpStatsAndDisplayMessage (EntityPlayer player) {
			this.getMessages().clear();
			switch (this.level) {
				case 2:
					this.addDefense(1);
					break;
				case 3:
					this.addStrength(1);
					break;
				case 4:
					this.addDefense(1);
					break;
				case 5:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 6:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 7:
					this.addStrength(1);
					break;
				case 8:
					this.addMagic(1);
					break;
				case 9:
					this.addStrength(1);
					break;
				case 10:
					this.addMagic(1);
					this.addDefense(1);
					this.addHP(5);
					break;
				case 11:
					this.addStrength(1);
					break;
				case 12:
					this.addMagic(1);
					break;
				case 13:
					this.addStrength(1);
					break;
				case 14:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 15:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 16:
					this.addMagic(1);
					break;
				case 17:
					this.addStrength(1);
					break;
				case 18:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 19:
					this.addStrength(1);
					break;
				case 20:
					this.addMagic(1);
					this.addHP(5);
					break;
				case 21:
					this.addStrength(1);
					break;
				case 22:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 23:
					this.addStrength(1);
					break;
				case 24:
					this.addMagic(1);
					break;
				case 25:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 26:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 27:
					this.addStrength(1);
					this.addMagic(1);
					break;
				case 28:
					this.addMagic(1);
					break;
				case 29:
					this.addStrength(1);
					break;
				case 30:
					this.addMagic(1);
					this.addDefense(1);
					this.addHP(5);
					break;
				case 31:
					this.addStrength(1);
					break;
				case 32:
					this.addStrength(1);
					this.addMagic(1);
					break;
				case 33:
					this.addStrength(1);
					break;
				case 34:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 35:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 36:
					this.addMagic(1);
					break;
				case 37:
					this.addStrength(1);
					break;
				case 38:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 39:
					this.addStrength(1);
					break;
				case 40:
					this.addMagic(1);
					this.addHP(5);
					break;
				case 41:
					this.addStrength(1);
					break;
				case 42:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 43:
					this.addStrength(1);
					this.addMagic(1);
					break;
				case 44:
					this.addMagic(1);
					break;
				case 45:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 46:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 47:
					this.addStrength(1);
					break;
				case 48:
					this.addStrength(1);
					this.addMagic(1);
					break;
				case 49:
					this.addStrength(1);
					break;
				case 50:
					this.addMagic(1);
					this.addDefense(1);
					this.addHP(5);
					break;
				case 51:
					this.addStrength(1);
					break;
				case 52:
					this.addMagic(1);
					break;
				case 53:
					this.addStrength(1);
					break;
				case 54:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 55:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 56:
					this.addMagic(1);
					break;
				case 57:
					this.addStrength(1);
					break;
				case 58:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 59:
					this.addStrength(1);
					break;
				case 60:
					this.addMagic(1);
					this.addHP(5);
					break;
				case 61:
					this.addStrength(1);
					break;
				case 62:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 63:
					this.addStrength(1);
					break;
				case 64:
					this.addMagic(1);
					break;
				case 65:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 66:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 67:
					this.addStrength(1);
					break;
				case 68:
					this.addMagic(1);
					break;
				case 69:
					this.addStrength(1);
					break;
				case 70:
					this.addMagic(1);
					this.addDefense(1);
					this.addHP(5);
					break;
				case 71:
					this.addStrength(1);
					break;
				case 72:
					this.addMagic(1);
					break;
				case 73:
					this.addStrength(1);
					break;
				case 74:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 75:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 76:
					this.addMagic(1);
					break;
				case 77:
					this.addStrength(1);
					break;
				case 78:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 79:
					this.addStrength(1);
					break;
				case 80:
					this.addMagic(1);
					this.addHP(5);
					break;
				case 81:
					this.addStrength(1);
					break;
				case 82:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 83:
					this.addStrength(1);
					break;
				case 84:
					this.addMagic(1);
					break;
				case 85:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 86:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 87:
					this.addStrength(1);
					break;
				case 88:
					this.addMagic(1);
					break;
				case 89:
					this.addStrength(1);
					break;
				case 90:
					this.addMagic(1);
					this.addDefense(1);
					this.addHP(5);
					break;
				case 91:
					this.addStrength(1);
					break;
				case 92:
					this.addMagic(1);
					break;
				case 93:
					this.addStrength(1);
					break;
				case 94:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 95:
					this.addStrength(1);
					this.addHP(5);
					break;
				case 96:
					this.addMagic(1);
					break;
				case 97:
					this.addStrength(1);
					break;
				case 98:
					this.addMagic(1);
					this.addDefense(1);
					break;
				case 99:
					this.addStrength(1);
					break;
				case 100:
					this.addStrength(10);
					this.addDefense(10);
					this.addMagic(10);
					this.addHP(5);
					break;
			}
			if(this.level%5 == 0) {
				player.setHealth(getHP());
				player.getFoodStats().addStats(20,0);
			}
			if(this.level == 50)
	            AchievementHelper.addAchievement(player, ModAchievements.level50);
			if(this.level == 100)
	            AchievementHelper.addAchievement(player, ModAchievements.level100);
			player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.levelup, SoundCategory.MASTER, 1.0f, 1.0f);
			player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getHP());
			PacketDispatcher.sendTo(new SyncLevelData(player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		}
	}
}