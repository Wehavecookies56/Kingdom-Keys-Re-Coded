package uk.co.wehavecookies56.kk.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryKeychain;

public class SummonKeybladeCapability {
	
	public interface ISummonKeyblade {
		boolean getIsKeybladeSummoned();
		void setIsKeybladeSummoned(boolean summoned);
		
		InventoryKeychain getInventoryKeychain();
	}

	public static class Storage implements IStorage<ISummonKeyblade> {

		@Override
		public NBTBase writeNBT(Capability<ISummonKeyblade> capability, ISummonKeyblade instance, EnumFacing side) {
			NBTTagCompound properties = new NBTTagCompound();
			properties.setBoolean("Is Keyblade Summoned", instance.getIsKeybladeSummoned());
			instance.getInventoryKeychain().writeToNBT(properties);
			
			return properties;
		}

		@Override
		public void readNBT(Capability<ISummonKeyblade> capability, ISummonKeyblade instance, EnumFacing side, NBTBase nbt) {
			NBTTagCompound properties = (NBTTagCompound) nbt;
			instance.setIsKeybladeSummoned(properties.getBoolean("Is Keyblade Summoned"));
			
			instance.getInventoryKeychain().readFromNBT(properties);
		}
	}
	
	public static class Default implements ISummonKeyblade {
    	private boolean keybladeSummoned = false;
    	
		private final InventoryKeychain inventoryKeychain = new InventoryKeychain();

        @Override public boolean getIsKeybladeSummoned() {return this.keybladeSummoned;}
    	@Override public void setIsKeybladeSummoned(boolean summoned) {this.keybladeSummoned = summoned;} 
		@Override public InventoryKeychain getInventoryKeychain(){return this.inventoryKeychain;}

    }
}


