package uk.co.wehavecookies56.kk.common.core.handler.event;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.*;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import javax.annotation.Nullable;

/**
 * Created by Toby on 19/07/2016.
 */
public class CapabilityEvents {

    @SubscribeEvent
    public void onEntityConstructing (AttachCapabilitiesEvent<Entity> event) {
        event.addCapability(new ResourceLocation(Reference.MODID, "IOrganizationXIII"), new ICapabilitySerializable<NBTTagCompound>()
        {
            OrganizationXIIICapability.IOrganizationXIII inst = ModCapabilities.ORGANIZATION_XIII.getDefaultInstance();

            @Override
            public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
                return capability == ModCapabilities.ORGANIZATION_XIII;
            }

            @Override
            public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
                return capability == ModCapabilities.ORGANIZATION_XIII ? (T)inst : null;
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
        event.addCapability(new ResourceLocation(Reference.MODID, "IMunny"), new ICapabilitySerializable<NBTPrimitive>()
        {
            MunnyCapability.IMunny inst = ModCapabilities.MUNNY.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.MUNNY;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.MUNNY ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "ICheatMode"), new ICapabilitySerializable<NBTPrimitive>()
        {
            CheatModeCapability.ICheatMode inst = ModCapabilities.CHEAT_MODE.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.CHEAT_MODE;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.CHEAT_MODE ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "IPlayerStats"), new ICapabilitySerializable<NBTTagCompound>()
        {
            PlayerStatsCapability.IPlayerStats inst = ModCapabilities.PLAYER_STATS.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.PLAYER_STATS;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.PLAYER_STATS ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "ISummonKeyblade"), new ICapabilitySerializable<NBTTagCompound>()
        {
            SummonKeybladeCapability.ISummonKeyblade inst = ModCapabilities.SUMMON_KEYBLADE.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.SUMMON_KEYBLADE;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.SUMMON_KEYBLADE ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "IMagicState"), new ICapabilitySerializable<NBTTagCompound>()
        {
            MagicStateCapability.IMagicState inst = ModCapabilities.MAGIC_STATE.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.MAGIC_STATE;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.MAGIC_STATE ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "IDriveState"), new ICapabilitySerializable<NBTTagCompound>()
        {
            DriveStateCapability.IDriveState inst = ModCapabilities.DRIVE_STATE.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.DRIVE_STATE;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.DRIVE_STATE ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "IFirstTimeJoin"), new ICapabilitySerializable<NBTTagCompound>()
        {
            FirstTimeJoinCapability.IFirstTimeJoin inst = ModCapabilities.FIRST_TIME_JOIN.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.FIRST_TIME_JOIN;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.FIRST_TIME_JOIN ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "ISynthesisRecipe"), new ICapabilitySerializable<NBTTagCompound>()
        {
            SynthesisRecipeCapability.ISynthesisRecipe inst = ModCapabilities.SYNTHESIS_RECIPES.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.SYNTHESIS_RECIPES;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.SYNTHESIS_RECIPES ? (T)inst : null;
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

        event.addCapability(new ResourceLocation(Reference.MODID, "ISynthesisMaterial"), new ICapabilitySerializable<NBTTagCompound>()
        {
            SynthesisMaterialCapability.ISynthesisMaterial inst = ModCapabilities.SYNTHESIS_MATERIALS.getDefaultInstance();
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == ModCapabilities.SYNTHESIS_MATERIALS;
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                return capability == ModCapabilities.SYNTHESIS_MATERIALS ? (T)inst : null;
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

    }

}
