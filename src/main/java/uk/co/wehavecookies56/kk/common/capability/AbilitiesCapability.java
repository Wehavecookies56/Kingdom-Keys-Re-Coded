package uk.co.wehavecookies56.kk.common.capability;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.Constants;
import uk.co.wehavecookies56.kk.common.KingdomKeys;

public class AbilitiesCapability {


	public interface IAbilities {
		boolean getUnlockedAbility(String id);

		void unlockAbility(String id, boolean unlocked);

		HashMap<String,Integer> getUnlockedAbilities();
		
		//void setKnownTutorials(ArrayList<Integer> list);
	}

	public static class Storage implements IStorage<IAbilities> {

		@Override
		public NBTBase writeNBT(Capability<IAbilities> capability, IAbilities instance, EnumFacing side) {
			NBTTagCompound properties = new NBTTagCompound();

			NBTTagList tagList = new NBTTagList();
			for (int i = 0; i < instance.getUnlockedAbilities().size(); i++) {
				int s = instance.getUnlockedAbilities().get(i);
				NBTTagCompound tutorials = new NBTTagCompound();
				tutorials.setInteger("Abilities" + i, s);
				tagList.appendTag(tutorials);
			}
			properties.setTag("AbilitiesList", tagList);

			return properties;
		}

		@Override
		public void readNBT(Capability<IAbilities> capability, IAbilities instance, EnumFacing side, NBTBase nbt) {
			NBTTagCompound properties = (NBTTagCompound) nbt;

			NBTTagList tagList = properties.getTagList("TutorialList", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i < tagList.tagCount(); i++) {
				NBTTagCompound tutorials = tagList.getCompoundTagAt(i);
				instance.getUnlockedAbilities().add(i, tutorials.getInteger("Tutorials" + i));
				KingdomKeys.logger.info("Loaded known tutorial: " + tutorials.getInteger("Tutorials" + i) + " " + i);
			}
		}
	}

	public static class Default implements IAbilities {
		HashMap<String,Integer> list = new HashMap<String,Integer>();

		@Override
		public boolean getUnlockedAbility(String id) {
			return list.containsKey(id);
		}

		@Override
		public void unlockAbility(String id, boolean unlocked) {
			if (unlocked) {
				if (!list.containsKey(id)) {
					list.add(id);
				}/* else {
					System.out.println("Tutorial already watched");
				}*/
			} else {
				if (list.containsKey(id)) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) == id) {
							list.remove(i);
						}
					}
				}/* else {
					System.out.println("Tutorial was not watched");
				}*/
			}
		}

		@Override
		public HashMap<String, Integer> getUnlockedAbilities() {
			return list;
		}

		/*@Override
		public void setKnownTutorials(ArrayList<Integer> list) {
			//System.out.println(this.list);
			//System.out.println(list);
			this.list = list;
		}*/
	}
}