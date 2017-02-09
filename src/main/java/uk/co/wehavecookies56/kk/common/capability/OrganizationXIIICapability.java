package uk.co.wehavecookies56.kk.common.capability;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 08/02/2017.
 */
public class OrganizationXIIICapability {

    public interface IOrganizationXIII {
        Utils.OrgMember getMember();
        Item currentWeapon();

        void setMember(Utils.OrgMember member);
        void setCurrentWeapon(Item weapon);
    }

    public static class Storage implements Capability.IStorage<IOrganizationXIII> {
        @Override
        public NBTBase writeNBT(Capability<IOrganizationXIII> capability, IOrganizationXIII instance, EnumFacing side) {
            NBTTagCompound properties = new NBTTagCompound();
            properties.setInteger("Member", instance.getMember().ordinal());
            new ItemStack(instance.currentWeapon()).writeToNBT(properties);
            return properties;
        }

        @Override
        public void readNBT(Capability<IOrganizationXIII> capability, IOrganizationXIII instance, EnumFacing side, NBTBase nbt) {
            NBTTagCompound properties = (NBTTagCompound) nbt;
            instance.setMember(Utils.OrgMember.values()[properties.getInteger("Member")]);
            instance.setCurrentWeapon(ItemStack.loadItemStackFromNBT(properties).getItem());
        }
    }

    public static class Default implements IOrganizationXIII {
        private Utils.OrgMember member = Utils.OrgMember.NONE;
        private Item weapon = ModItems.KingdomKey;

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
    }

}
