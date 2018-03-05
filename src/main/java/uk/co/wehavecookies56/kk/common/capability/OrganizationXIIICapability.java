package uk.co.wehavecookies56.kk.common.capability;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.util.PortalCoords;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 08/02/2017.
 */
public class OrganizationXIIICapability {

    List<Item> unlockedWeapons = new ArrayList<>();

    public interface IOrganizationXIII {
        //Utils.OrgMember current();
        Utils.OrgMember getMember();

        Item currentWeapon();
        boolean summonedWeapon(EnumHand hand);
        boolean getOpenedGUI();
        PortalCoords getPortalCoords(byte pID);
        int getUnlockPoints();

        List<Item> unlockedWeapons();
        void setMember(Utils.OrgMember member);

        void setCurrentWeapon(Item weapon);
        void setUnlockedWeapons(List<Item> list);
        void addUnlockedWeapon(Item item);
        void removeUnlockedWeapon(Item item);
        void setWeaponSummoned(EnumHand hand, boolean summoned);
        void setOpenedGUI(boolean opened);
        void setPortalCoords(byte pID, PortalCoords coords);
        void setUnlockPoints(int points);
        void removePoints(int points);
        void addPoints(int points);
    }

    public static class Storage implements Capability.IStorage<IOrganizationXIII> {
        @Override
        public NBTBase writeNBT(Capability<IOrganizationXIII> capability, IOrganizationXIII instance, EnumFacing side) {
            NBTTagCompound properties = new NBTTagCompound();
            properties.setInteger("Member", instance.getMember().ordinal());
            new ItemStack(instance.currentWeapon()).writeToNBT(properties);
            
            NBTTagList tagList = new NBTTagList();
            for (int i = 0; i < instance.unlockedWeapons().size(); i++) {
                Item item = instance.unlockedWeapons().get(i);
                if (item != null) {
                    NBTTagCompound weapons = new NBTTagCompound();
                    new ItemStack(item).writeToNBT(weapons);
                    tagList.appendTag(weapons);
                }
            }
            properties.setTag("UnlockedWeapons", tagList);
            properties.setBoolean("Summoned", instance.summonedWeapon(EnumHand.MAIN_HAND));
            properties.setBoolean("SummonedOffhand", instance.summonedWeapon(EnumHand.OFF_HAND));
            properties.setBoolean("Opened", instance.getOpenedGUI());
            for(byte i=0;i<3;i++) {
            	properties.setByte("Portal"+i+"N", instance.getPortalCoords(i).getPID());
	            properties.setDouble("Portal"+i+"X", instance.getPortalCoords(i).getX());
	            properties.setDouble("Portal"+i+"Y", instance.getPortalCoords(i).getY());
	            properties.setDouble("Portal"+i+"Z", instance.getPortalCoords(i).getZ());
	            properties.setInteger("Portal"+i+"D", instance.getPortalCoords(i).getDimID());
            }
            properties.setInteger("UnlockPoints", instance.getUnlockPoints());
            return properties;
        }

        @Override
        public void readNBT(Capability<IOrganizationXIII> capability, IOrganizationXIII instance, EnumFacing side, NBTBase nbt) {
            NBTTagCompound properties = (NBTTagCompound) nbt;
            instance.setMember(Utils.OrgMember.values()[properties.getInteger("Member")]);
            instance.setCurrentWeapon(new ItemStack(properties).getItem());
            
            NBTTagList tagList = properties.getTagList("UnlockedWeapons", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < tagList.tagCount(); i++) {
                NBTTagCompound weapons = tagList.getCompoundTagAt(i);
                if (!instance.unlockedWeapons().contains(new ItemStack(weapons).getItem())) {
                    instance.addUnlockedWeapon(new ItemStack(weapons).getItem());
                    KingdomKeys.logger.info("Loaded unlocked weapon: " + new ItemStack(weapons).getDisplayName());
                }
            }
            instance.setWeaponSummoned(EnumHand.MAIN_HAND, properties.getBoolean("Summoned"));
            instance.setWeaponSummoned(EnumHand.OFF_HAND, properties.getBoolean("SummonedOffhand"));
            instance.setOpenedGUI(properties.getBoolean("Opened"));
            for(byte i=0;i<3;i++) {
	            instance.setPortalCoords(i,new PortalCoords(
	            		properties.getByte("Portal"+i+"N"),
	            		properties.getDouble("Portal"+i+"X"),
	            		properties.getDouble("Portal"+i+"Y"),
	            		properties.getDouble("Portal"+i+"Z"),
	            		properties.getInteger("Portal"+i+"D")));
            }
            instance.setUnlockPoints(properties.getInteger("UnlockPoints"));
        }
    }

    public static class Default implements IOrganizationXIII {
        private Utils.OrgMember member = Utils.OrgMember.NONE;
        private Item weapon = ModItems.KingdomKey;
        private List<Item> weapons = new ArrayList<>();
        private boolean mainHandSummoned = false;
        private boolean offHandSummoned = false;
        private boolean openedGui = false;
        private PortalCoords[] orgPortalCoords = {new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0)};
        private int unlockPoints = 0;

        @Override
        public Utils.OrgMember getMember() {
            return member;
        }

        @Override
        public Item currentWeapon() {
            return weapon;
        }

        @Override
        public void setMember(Utils.OrgMember member) {
            this.member = member;
        }

        @Override
        public void setCurrentWeapon(Item weapon) {
            this.weapon = weapon;
        }

        @Override
        public List<Item> unlockedWeapons() {
            return weapons;
        }

        @Override
        public void setUnlockedWeapons(List<Item> list) {
            this.weapons = list;
        }

        @Override
        public void addUnlockedWeapon(Item item) {
            this.weapons.add(item);
        }

        @Override
        public void removeUnlockedWeapon(Item item) {
            this.weapons.remove(this.weapons.indexOf(item));
        }

        @Override
        public boolean summonedWeapon(EnumHand hand) {
            return hand == EnumHand.MAIN_HAND ? mainHandSummoned : offHandSummoned;
        }

        @Override
        public void setWeaponSummoned(EnumHand hand, boolean summoned) {
            if (hand == EnumHand.MAIN_HAND)
                this.mainHandSummoned = summoned;
            else
                this.offHandSummoned = summoned;
        }

        @Override
        public boolean getOpenedGUI() {
            return openedGui;
        }

        @Override
        public void setOpenedGUI(boolean opened) {
            this.openedGui=opened;
        }
        
        @Override
		public PortalCoords getPortalCoords(byte pID) {
        	return orgPortalCoords[pID];
		}

		@Override
		public void setPortalCoords(byte pID, PortalCoords coords) {
  			orgPortalCoords[pID] = coords;
		}

        @Override
        public int getUnlockPoints() {
            return unlockPoints;
        }

        @Override
        public void setUnlockPoints(int points) {
            this.unlockPoints = points;
        }

        @Override
        public void removePoints(int points) {
            if (unlockPoints - points < 0) {
                unlockPoints = 0;
            } else {
                this.unlockPoints -= points;
            }
        }

        @Override
        public void addPoints(int points) {
            this.unlockPoints += points;
        }
		
    }

}
