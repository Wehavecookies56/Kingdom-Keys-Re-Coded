package uk.co.wehavecookies56.kk.common.capability;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
import uk.co.wehavecookies56.kk.common.item.ModItems;
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
        boolean summonedWeapon();
        boolean getOpenedGUI();
        double getPortalX();
        double getPortalY();
        double getPortalZ();
        int getUnlockPoints();

        List<Item> unlockedWeapons();
        void setMember(Utils.OrgMember member);
        void setCurrentWeapon(Item weapon);
        void setUnlockedWeapons(List<Item> list);
        void addUnlockedWeapon(Item item);
        void removeUnlockedWeapon(Item item);
        void setWeaponSummoned(boolean summoned);
        void setOpenedGUI(boolean opened);
        void setPortalX(double x);
        void setPortalY(double y);
        void setPortalZ(double z);
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
            properties.setBoolean("Summoned", instance.summonedWeapon());
            properties.setBoolean("Opened", instance.getOpenedGUI());
            properties.setDouble("PortalX", instance.getPortalX());
            properties.setDouble("PortalY", instance.getPortalY());
            properties.setDouble("PortalZ", instance.getPortalZ());
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
                    LogHelper.info("Loaded unlocked weapon: " + new ItemStack(weapons).getDisplayName());
                }
            }
            instance.setWeaponSummoned(properties.getBoolean("Summoned"));
            instance.setOpenedGUI(properties.getBoolean("Opened"));
            instance.setPortalX(properties.getDouble("PortalX"));
            instance.setPortalY(properties.getDouble("PortalY"));
            instance.setPortalZ(properties.getDouble("PortalZ"));
            instance.setUnlockPoints(properties.getInteger("UnlockPoints"));
        }
    }

    public static class Default implements IOrganizationXIII {
        private Utils.OrgMember member = Utils.OrgMember.NONE;
        private Item weapon = ModItems.KingdomKey;
        private List<Item> weapons = new ArrayList<>();
        private boolean summoned, openedGui=false;
        private double orgPortalX = 0;
        private double orgPortalY = 0;
        private double orgPortalZ = 0;
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
        public boolean summonedWeapon() {
            return this.summoned;
        }

        @Override
        public void setWeaponSummoned(boolean summoned) {
            this.summoned = summoned;
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
		public double getPortalX() {
			return orgPortalX;
		}

		@Override
		public double getPortalY() {
			return orgPortalY;
		}

		@Override
		public double getPortalZ() {
			return orgPortalZ;
		}

		@Override
		public void setPortalX(double x) {
            this.orgPortalX = x;
		}

		@Override
		public void setPortalY(double y) {
            this.orgPortalY = y;
		}

		@Override
		public void setPortalZ(double z) {
            this.orgPortalZ = z;
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
