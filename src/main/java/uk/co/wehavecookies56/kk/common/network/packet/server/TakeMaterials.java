package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;

public class TakeMaterials extends AbstractServerMessage<TakeMaterials> {

    int amount;
    String materialName;

    public TakeMaterials () {}

    public TakeMaterials (int amount, String materialName) {
        this.amount = amount;
        this.materialName = materialName;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        amount = buffer.readInt();
        materialName = buffer.readString(100);
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(amount);
        buffer.writeString(materialName);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if (amount > player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).getMaterialAmount(MaterialRegistry.get(materialName)))
            amount = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).getMaterialAmount(MaterialRegistry.get(materialName));
        if (materialName.startsWith("sm.")) {
            ItemStack material = new ItemStack(ModItems.SynthesisMaterial, amount);
            material.setTagCompound(new NBTTagCompound());
            material.getTagCompound().setString("material", materialName);
            if (materialName.endsWith("shard"))
                material.getTagCompound().setString("rank", "sm.rank.c");
            else if (materialName.endsWith("stone"))
                material.getTagCompound().setString("rank", "sm.rank.b");
            else if (materialName.endsWith("gem") || materialName.equals(Strings.SM_ManifestIllusion) || materialName.equals(Strings.SM_Orichalcum))
                material.getTagCompound().setString("rank", "sm.rank.a");
            else if (materialName.endsWith("crystal") || materialName.equals(Strings.SM_LostIllusion) || materialName.equals(Strings.SM_OrichalcumPlus)) material.getTagCompound().setString("rank", "sm.rank.s");

            player.inventory.addItemStackToInventory(material);
            player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial(MaterialRegistry.get(materialName), amount);

        } else if (materialName.startsWith("item.")) {
            if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, materialName.replace("item.", ""))) != null) {
                player.inventory.addItemStackToInventory(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, materialName.replace("item.", ""))), amount));
                player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial(MaterialRegistry.get(materialName), amount);
            } else {
                // VANILLA ITEMS HERE
                if (materialName.equals(Items.WOODEN_SWORD.getTranslationKey())) {
                    player.inventory.addItemStackToInventory(new ItemStack(Items.WOODEN_SWORD, amount));
                    player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial(MaterialRegistry.get(materialName), amount);
                }
                if (materialName.equals(Items.STICK.getTranslationKey())) {
                    player.inventory.addItemStackToInventory(new ItemStack(Items.STICK, amount));
                    player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial(MaterialRegistry.get(materialName), amount);
                }
            }
        } else if (materialName.startsWith("tile.")) if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Reference.MODID, materialName.replace("tile.", ""))) != null) {
            player.inventory.addItemStackToInventory(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Reference.MODID, materialName.replace("tile.", ""))), amount));
            player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial(MaterialRegistry.get(materialName), amount);
        } else {
            // VANILLA BLOCKS HERE
        }
        PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
    }

}
