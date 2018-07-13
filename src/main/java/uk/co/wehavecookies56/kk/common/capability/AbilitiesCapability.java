package uk.co.wehavecookies56.kk.common.capability;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class AbilitiesCapability {


	public interface IAbilities {
		boolean getUnlockedAbility(Ability ability);

		void unlockAbility(Ability ability, boolean unlocked);

		ArrayList<Ability> getUnlockedAbilities();
		
		void clearAbilities();
		
		//void setKnownTutorials(ArrayList<Integer> list);
	}

	public static class Storage implements IStorage<IAbilities> {

		@Override
		public NBTBase writeNBT(Capability<IAbilities> capability, IAbilities instance, EnumFacing side) {
			NBTTagCompound properties = new NBTTagCompound();

			NBTTagList tagList = new NBTTagList();
			for (int i = 0; i < instance.getUnlockedAbilities().size(); i++) {
				Ability a = instance.getUnlockedAbilities().get(i);
				String s = a.getName();
				NBTTagCompound abilities = new NBTTagCompound();
				abilities.setString("Abilities" + i, s);
				tagList.appendTag(abilities);
			}
			properties.setTag("AbilitiesList", tagList);

			return properties;
		}

		@Override
		public void readNBT(Capability<IAbilities> capability, IAbilities instance, EnumFacing side, NBTBase nbt) {
			NBTTagCompound properties = (NBTTagCompound) nbt;

			NBTTagList tagList = properties.getTagList("AbilitiesList", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i < tagList.tagCount(); i++) {
				NBTTagCompound abilities = tagList.getCompoundTagAt(i);
				Ability ability = GameRegistry.findRegistry(Ability.class).getValue(new ResourceLocation(Reference.MODID+":"+abilities.getString("Abilities"+i)));
				instance.getUnlockedAbilities().add(i,ability);
				KingdomKeys.logger.info("Loaded known ability: " + abilities.getString("Abilities" + i) + " " + i);
			}
		}
	}

	public static class Default implements IAbilities {
		ArrayList<Ability> list = new ArrayList<Ability>();

		@Override
		public boolean getUnlockedAbility(Ability ability) {
			return list.contains(ability);
		}

		@Override
		public void unlockAbility(Ability ability, boolean unlock) {
			System.out.println(list);
			if (unlock) {
				list.add(ability);
			} else {
				if (list.contains(ability)) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getName().equals(ability.getName())) {
							list.remove(i);
						}
					}
				}
			}
			System.out.println(list);

		}

		@Override
		public ArrayList<Ability> getUnlockedAbilities() {
			return list;
		}

		@Override
		public void clearAbilities() {
			list.clear();	
		}
	}
}