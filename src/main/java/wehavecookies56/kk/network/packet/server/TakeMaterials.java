package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class TakeMaterials extends AbstractServerMessage<TakeMaterials> {

	int amount;
	String materialName;
	
	public TakeMaterials() {}
	
	public TakeMaterials(int amount, String materialName){
		this.amount = amount;
		this.materialName = materialName;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		amount = buffer.readInt();
		materialName = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(amount);
		buffer.writeString(materialName);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(amount > ExtendedPlayerMaterials.get(player).getMaterialAmount(MaterialRegistry.get(materialName)))
		{
			amount = ExtendedPlayerMaterials.get(player).getMaterialAmount(MaterialRegistry.get(materialName));
		}
		if(materialName.startsWith("sm.")){
			ItemStack material = new ItemStack(ModItems.SynthesisMaterial, amount);
			material.setTagCompound(new NBTTagCompound());
			material.getTagCompound().setString("material", materialName);
			if(materialName.endsWith("shard")){
				material.getTagCompound().setString("rank", "C");
			}else if(materialName.endsWith("stone")){
				material.getTagCompound().setString("rank", "B");
			}else if(materialName.endsWith("gem") || materialName.equals(Strings.SM_ManifestIllusion) || materialName.equals(Strings.SM_Orichalcum)){
				material.getTagCompound().setString("rank", "A");
			}else if(materialName.endsWith("crystal") || materialName.equals(Strings.SM_LostIllusion) || materialName.equals(Strings.SM_OrichalcumPlus)){
				material.getTagCompound().setString("rank", "S");
			}
			
			player.inventory.addItemStackToInventory(material);
			ExtendedPlayerMaterials.get(player).removeMaterial(MaterialRegistry.get(materialName), amount);
									
		}else if(materialName.startsWith("item.")){
			if(GameRegistry.findItem(Reference.MODID, materialName.replace("item.", "")) != null){
				player.inventory.addItemStackToInventory(new ItemStack(GameRegistry.findItem(Reference.MODID, materialName.replace("item.", "")), amount));
				ExtendedPlayerMaterials.get(player).removeMaterial(MaterialRegistry.get(materialName), amount);
			}else{
				//VANILLA ITEMS HERE
				if(materialName.equals(Items.wooden_sword.getUnlocalizedName())){
					player.inventory.addItemStackToInventory(new ItemStack(Items.wooden_sword, amount));
					ExtendedPlayerMaterials.get(player).removeMaterial(MaterialRegistry.get(materialName), amount);
				}
				if(materialName.equals(Items.stick.getUnlocalizedName())){
					player.inventory.addItemStackToInventory(new ItemStack(Items.stick, amount));
					ExtendedPlayerMaterials.get(player).removeMaterial(MaterialRegistry.get(materialName), amount);
				}
			}
		}else if(materialName.startsWith("tile.")){
			if(GameRegistry.findBlock(Reference.MODID, materialName.replace("tile.", "")) != null){
				player.inventory.addItemStackToInventory(new ItemStack(GameRegistry.findBlock(Reference.MODID, materialName.replace("tile.", "")), amount));
				ExtendedPlayerMaterials.get(player).removeMaterial(MaterialRegistry.get(materialName), amount);
			}else{
				//VANILLA BLOCKS HERE
			}
		}
	}
	

}
