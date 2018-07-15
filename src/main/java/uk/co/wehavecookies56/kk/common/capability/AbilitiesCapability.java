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

		void unlockAbility(Ability ability);

		ArrayList<Ability> getUnlockedAbilities();

		void clearUnlockedAbilities();
		void setUnlockedAbilities(ArrayList<Ability> ability);

		boolean getEquippedAbility(Ability ability);

		void equipAbility(Ability ability, boolean unlocked);

		ArrayList<Ability> getEquippedAbilities();

		void clearEquippedAbilities();

		void setEquippedAbilities(ArrayList<Ability> equippedAbilities);

		// void setKnownTutorials(ArrayList<Integer> list);
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
				Ability ability = GameRegistry.findRegistry(Ability.class).getValue(new ResourceLocation(Reference.MODID + ":" + abilities.getString("Abilities" + i)));
				instance.getUnlockedAbilities().add(i, ability);
				KingdomKeys.logger.info("Loaded known ability: " + abilities.getString("Abilities" + i) + " " + i);
			}
		}
	}

	public static class Default implements IAbilities {
		ArrayList<Ability> unlockedList = new ArrayList<Ability>();

		@Override
		public boolean getUnlockedAbility(Ability ability) {
			return unlockedList.contains(ability);
		}

		@Override
		public void unlockAbility(Ability ability) {
			System.out.println("Going to unlock");
			unlockedList.add(ability);
			
			System.out.println(unlockedList);
		}

		@Override
		public ArrayList<Ability> getUnlockedAbilities() {
			return unlockedList;
		}

		@Override
		public void clearUnlockedAbilities() {
			unlockedList.clear();
		}

		ArrayList<Ability> equippedList = new ArrayList<Ability>();

		@Override
		public boolean getEquippedAbility(Ability ability) {
			return equippedList.contains(ability);
		}

		@Override
		public void equipAbility(Ability ability, boolean equip) {
			if (equip) {
				
				System.out.println("Going to equip "+ability.getName());
				equippedList.add(ability);
			} else {
				System.out.println("Going to unequip "+ability.getName());
				if (equippedList.contains(ability)) {
					for (int i = 0; i < equippedList.size(); i++) {
						if (equippedList.get(i) ==ability) {
							equippedList.remove(i);
						}
					}
				}
			}
			System.out.println(equippedList);
		}

		@Override
		public ArrayList<Ability> getEquippedAbilities() {
			return equippedList;
		}

		@Override
		public void clearEquippedAbilities() {
			equippedList.clear();
		}

		@Override
		public void setUnlockedAbilities(ArrayList<Ability> list) {
			this.unlockedList = list;
		}
		
		@Override
		public void setEquippedAbilities(ArrayList<Ability> list) {
			this.equippedList = list;
		}
	}
}