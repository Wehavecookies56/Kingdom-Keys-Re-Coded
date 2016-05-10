package uk.co.wehavecookies56.kk.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class FirstTimeJoinCapability {
	
	public interface IFirstTimeJoin {
		boolean getFirstTimeJoin();
		
		void setFirstTimeJoin(boolean bool);
	}

	public static class Storage implements IStorage<IFirstTimeJoin> {

		@Override
		public NBTBase writeNBT(Capability<IFirstTimeJoin> capability, IFirstTimeJoin instance, EnumFacing side) {
			NBTTagCompound properties = new NBTTagCompound();
			properties.setBoolean("FirstTimeJoin", instance.getFirstTimeJoin());
			return properties;
		}

		@Override
		public void readNBT(Capability<IFirstTimeJoin> capability, IFirstTimeJoin instance, EnumFacing side, NBTBase nbt) {
			NBTTagCompound properties = (NBTTagCompound) nbt;
			instance.setFirstTimeJoin(properties.getBoolean("FirstTimeJoin"));
			
		}
	}
	
	public static class Default implements IFirstTimeJoin {
        private boolean firstTimeJoin = false;
		@Override public boolean getFirstTimeJoin() { return this.firstTimeJoin; }
		@Override public void setFirstTimeJoin(boolean bool) { this.firstTimeJoin = bool; }
    }
}


