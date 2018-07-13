package uk.co.wehavecookies56.kk.common.core.handler.event;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability;
import uk.co.wehavecookies56.kk.common.capability.CheatModeCapability;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.FirstTimeJoinCapability;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.capability.TutorialsCapability;
import uk.co.wehavecookies56.kk.common.lib.Reference;

/**
 * Created by Toby on 19/07/2016.
 */
public class CapabilityEvents {

    @SubscribeEvent
    public void onEntityConstructing (AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MODID, "IOrganizationXIII"), new ICapabilitySerializable<NBTTagCompound>() {
                OrganizationXIIICapability.IOrganizationXIII inst = ModCapabilities.ORGANIZATION_XIII.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.ORGANIZATION_XIII;
                }

                @Override
                public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.ORGANIZATION_XIII ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.ORGANIZATION_XIII.getStorage().writeNBT(ModCapabilities.ORGANIZATION_XIII, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.ORGANIZATION_XIII.getStorage().readNBT(ModCapabilities.ORGANIZATION_XIII, inst, null, nbt);
                }
            });
            event.addCapability(new ResourceLocation(Reference.MODID, "IMunny"), new ICapabilitySerializable<NBTPrimitive>() {
                MunnyCapability.IMunny inst = ModCapabilities.MUNNY.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.MUNNY;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.MUNNY ? (T) inst : null;
                }

                @Override
                public NBTPrimitive serializeNBT() {
                    return (NBTPrimitive) ModCapabilities.MUNNY.getStorage().writeNBT(ModCapabilities.MUNNY, inst, null);
                }

                @Override
                public void deserializeNBT(NBTPrimitive nbt) {
                    ModCapabilities.MUNNY.getStorage().readNBT(ModCapabilities.MUNNY, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "ICheatMode"), new ICapabilitySerializable<NBTPrimitive>() {
                CheatModeCapability.ICheatMode inst = ModCapabilities.CHEAT_MODE.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.CHEAT_MODE;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.CHEAT_MODE ? (T) inst : null;
                }

                @Override
                public NBTPrimitive serializeNBT() {
                    return (NBTPrimitive) ModCapabilities.CHEAT_MODE.getStorage().writeNBT(ModCapabilities.CHEAT_MODE, inst, null);
                }

                @Override
                public void deserializeNBT(NBTPrimitive nbt) {
                    ModCapabilities.CHEAT_MODE.getStorage().readNBT(ModCapabilities.CHEAT_MODE, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "IPlayerStats"), new ICapabilitySerializable<NBTTagCompound>() {
                PlayerStatsCapability.IPlayerStats inst = ModCapabilities.PLAYER_STATS.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.PLAYER_STATS;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.PLAYER_STATS ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.PLAYER_STATS.getStorage().writeNBT(ModCapabilities.PLAYER_STATS, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.PLAYER_STATS.getStorage().readNBT(ModCapabilities.PLAYER_STATS, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "ISummonKeyblade"), new ICapabilitySerializable<NBTTagCompound>() {
                SummonKeybladeCapability.ISummonKeyblade inst = ModCapabilities.SUMMON_KEYBLADE.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SUMMON_KEYBLADE;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SUMMON_KEYBLADE ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.SUMMON_KEYBLADE.getStorage().writeNBT(ModCapabilities.SUMMON_KEYBLADE, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.SUMMON_KEYBLADE.getStorage().readNBT(ModCapabilities.SUMMON_KEYBLADE, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "IMagicState"), new ICapabilitySerializable<NBTTagCompound>() {
                MagicStateCapability.IMagicState inst = ModCapabilities.MAGIC_STATE.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.MAGIC_STATE;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.MAGIC_STATE ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.MAGIC_STATE.getStorage().writeNBT(ModCapabilities.MAGIC_STATE, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.MAGIC_STATE.getStorage().readNBT(ModCapabilities.MAGIC_STATE, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "IDriveState"), new ICapabilitySerializable<NBTTagCompound>() {
                DriveStateCapability.IDriveState inst = ModCapabilities.DRIVE_STATE.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.DRIVE_STATE;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.DRIVE_STATE ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.DRIVE_STATE.getStorage().writeNBT(ModCapabilities.DRIVE_STATE, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.DRIVE_STATE.getStorage().readNBT(ModCapabilities.DRIVE_STATE, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "IFirstTimeJoin"), new ICapabilitySerializable<NBTTagCompound>() {
                FirstTimeJoinCapability.IFirstTimeJoin inst = ModCapabilities.FIRST_TIME_JOIN.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.FIRST_TIME_JOIN;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.FIRST_TIME_JOIN ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.FIRST_TIME_JOIN.getStorage().writeNBT(ModCapabilities.FIRST_TIME_JOIN, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.FIRST_TIME_JOIN.getStorage().readNBT(ModCapabilities.FIRST_TIME_JOIN, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "ISynthesisRecipe"), new ICapabilitySerializable<NBTTagCompound>() {
                SynthesisRecipeCapability.ISynthesisRecipe inst = ModCapabilities.SYNTHESIS_RECIPES.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SYNTHESIS_RECIPES;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SYNTHESIS_RECIPES ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.SYNTHESIS_RECIPES.getStorage().writeNBT(ModCapabilities.SYNTHESIS_RECIPES, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.SYNTHESIS_RECIPES.getStorage().readNBT(ModCapabilities.SYNTHESIS_RECIPES, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "ISynthesisMaterial"), new ICapabilitySerializable<NBTTagCompound>() {
                SynthesisMaterialCapability.ISynthesisMaterial inst = ModCapabilities.SYNTHESIS_MATERIALS.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SYNTHESIS_MATERIALS;
                }

                @SuppressWarnings("unchecked")
                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == ModCapabilities.SYNTHESIS_MATERIALS ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.SYNTHESIS_MATERIALS.getStorage().writeNBT(ModCapabilities.SYNTHESIS_MATERIALS, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.SYNTHESIS_MATERIALS.getStorage().readNBT(ModCapabilities.SYNTHESIS_MATERIALS, inst, null, nbt);
                }
            });

            event.addCapability(new ResourceLocation(Reference.MODID, "ITutorials"), new ICapabilitySerializable<NBTTagCompound>() {
                TutorialsCapability.ITutorials inst = ModCapabilities.TUTORIALS.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.TUTORIALS;
                }

                @Override
                public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.TUTORIALS ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.TUTORIALS.getStorage().writeNBT(ModCapabilities.TUTORIALS, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.TUTORIALS.getStorage().readNBT(ModCapabilities.TUTORIALS, inst, null, nbt);
                }
            });
            
            event.addCapability(new ResourceLocation(Reference.MODID, "IAbilities"), new ICapabilitySerializable<NBTTagCompound>() {
                AbilitiesCapability.IAbilities inst = ModCapabilities.ABILITIES.getDefaultInstance();

                @Override
                public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.ABILITIES;
                }

                @Override
                public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
                    return capability == ModCapabilities.ABILITIES ? (T) inst : null;
                }

                @Override
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound) ModCapabilities.ABILITIES.getStorage().writeNBT(ModCapabilities.ABILITIES, inst, null);
                }

                @Override
                public void deserializeNBT(NBTTagCompound nbt) {
                    ModCapabilities.ABILITIES.getStorage().readNBT(ModCapabilities.ABILITIES, inst, null, nbt);
                }
            });
        }
    }

}
