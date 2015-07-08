package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.client.gui.GuiMaterialList;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ItemSynthesisMaterial;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class OpenMaterials extends AbstractServerMessage<OpenMaterials> {

	public OpenMaterials() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		for(int i = 0; i < 35;  i++){
			if(player.inventory.mainInventory[i] != null){
				if(player.inventory.mainInventory[i].getItem() instanceof ItemSynthesisMaterial){
					int index = 0;
					if(player.inventory.mainInventory[i].hasTagCompound()){
						String s = player.inventory.mainInventory[i].getTagCompound().getString("material");
						if(s.equals(Strings.SM_BlazingShard)){
							index = GuiMaterialList.Index_BlazingShard;
						}
						if(s.equals(Strings.SM_BlazingStone)){
							index = GuiMaterialList.Index_BlazingStone;
						}
						if(s.equals(Strings.SM_BlazingGem)){
							index = GuiMaterialList.Index_BlazingGem;
						}
						if(s.equals(Strings.SM_BlazingCrystal)){
							index = GuiMaterialList.Index_BlazingCrystal;
						}

						if(s.equals(Strings.SM_BrightShard)){
							index = GuiMaterialList.Index_BrightShard;
						}
						if(s.equals(Strings.SM_BrightStone)){
							index = GuiMaterialList.Index_BrightStone;
						}
						if(s.equals(Strings.SM_BrightGem)){
							index = GuiMaterialList.Index_BrightGem;
						}
						if(s.equals(Strings.SM_BrightCrystal)){
							index = GuiMaterialList.Index_BrightCrystal;
						}

						if(s.equals(Strings.SM_DarkShard)){
							index = GuiMaterialList.Index_DarkShard;
						}
						if(s.equals(Strings.SM_DarkStone)){
							index = GuiMaterialList.Index_DarkStone;
						}
						if(s.equals(Strings.SM_DarkGem)){
							index = GuiMaterialList.Index_DarkGem;
						}
						if(s.equals(Strings.SM_DarkCrystal)){
							index = GuiMaterialList.Index_DarkCrystal;
						}

						if(s.equals(Strings.SM_DenseShard)){
							index = GuiMaterialList.Index_DenseShard;
						}
						if(s.equals(Strings.SM_DenseStone)){
							index = GuiMaterialList.Index_DenseStone;
						}
						if(s.equals(Strings.SM_DenseGem)){
							index = GuiMaterialList.Index_DenseGem;
						}
						if(s.equals(Strings.SM_DenseCrystal)){
							index = GuiMaterialList.Index_DenseCrystal;
						}

						if(s.equals(Strings.SM_EnergyShard)){
							index = GuiMaterialList.Index_EnergyShard;
						}
						if(s.equals(Strings.SM_EnergyStone)){
							index = GuiMaterialList.Index_EnergyStone;
						}
						if(s.equals(Strings.SM_EnergyGem)){
							index = GuiMaterialList.Index_EnergyGem;
						}
						if(s.equals(Strings.SM_EnergyCrystal)){
							index = GuiMaterialList.Index_EnergyCrystal;
						}

						if(s.equals(Strings.SM_FrostShard)){
							index = GuiMaterialList.Index_FrostShard;
						}
						if(s.equals(Strings.SM_FrostStone)){
							index = GuiMaterialList.Index_FrostStone;
						}
						if(s.equals(Strings.SM_FrostGem)){
							index = GuiMaterialList.Index_FrostGem;
						}
						if(s.equals(Strings.SM_FrostCrystal)){
							index = GuiMaterialList.Index_FrostCrystal;
						}

						if(s.equals(Strings.SM_LightningShard)){
							index = GuiMaterialList.Index_LightningShard;
						}
						if(s.equals(Strings.SM_LightningStone)){
							index = GuiMaterialList.Index_LightningStone;
						}
						if(s.equals(Strings.SM_LightningGem)){
							index = GuiMaterialList.Index_LightningGem;
						}
						if(s.equals(Strings.SM_LightningCrystal)){
							index = GuiMaterialList.Index_LightningCrystal;
						}

						if(s.equals(Strings.SM_LostIllusion)){
							index = GuiMaterialList.Index_LostIllusion;
						}

						if(s.equals(Strings.SM_LucidShard)){
							index = GuiMaterialList.Index_LucidShard;
						}
						if(s.equals(Strings.SM_LucidStone)){
							index = GuiMaterialList.Index_LucidStone;
						}
						if(s.equals(Strings.SM_LucidGem)){
							index = GuiMaterialList.Index_LucidGem;
						}
						if(s.equals(Strings.SM_LucidCrystal)){
							index = GuiMaterialList.Index_LucidCrystal;
						}

						if(s.equals(Strings.SM_ManifestIllusion)){
							index = GuiMaterialList.Index_ManifestIllusion;
						}

						if(s.equals(Strings.SM_MythrilShard)){
							index = GuiMaterialList.Index_MythrilShard;
						}
						if(s.equals(Strings.SM_MythrilStone)){
							index = GuiMaterialList.Index_MythrilStone;
						}
						if(s.equals(Strings.SM_MythrilGem)){
							index = GuiMaterialList.Index_MythrilGem;
						}
						if(s.equals(Strings.SM_MythrilCrystal)){
							index = GuiMaterialList.Index_MythrilCrystal;
						}

						if(s.equals(Strings.SM_Orichalcum)){
							index = GuiMaterialList.Index_Orichalcum;
						}
						if(s.equals(Strings.SM_OrichalcumPlus)){
							index = GuiMaterialList.Index_OrichalcumPlus;
						}

						if(s.equals(Strings.SM_PowerShard)){
							index = GuiMaterialList.Index_PowerShard;
						}
						if(s.equals(Strings.SM_PowerStone)){
							index = GuiMaterialList.Index_PowerStone;
						}
						if(s.equals(Strings.SM_PowerGem)){
							index = GuiMaterialList.Index_PowerGem;
						}
						if(s.equals(Strings.SM_PowerCrystal)){
							index = GuiMaterialList.Index_PowerCrystal;
						}

						if(s.equals(Strings.SM_RemembranceShard)){
							index = GuiMaterialList.Index_RemembranceShard;
						}
						if(s.equals(Strings.SM_RemembranceStone)){
							index = GuiMaterialList.Index_RemembranceStone;
						}
						if(s.equals(Strings.SM_RemembranceGem)){
							index = GuiMaterialList.Index_RemembranceGem;
						}
						if(s.equals(Strings.SM_RemembranceCrystal)){
							index = GuiMaterialList.Index_RemembranceCrystal;
						}

						if(s.equals(Strings.SM_SerenityShard)){
							index = GuiMaterialList.Index_SerenityShard;
						}
						if(s.equals(Strings.SM_SerenityStone)){
							index = GuiMaterialList.Index_SerenityStone;
						}
						if(s.equals(Strings.SM_SerenityGem)){
							index = GuiMaterialList.Index_SerenityGem;
						}
						if(s.equals(Strings.SM_SerenityCrystal)){
							index = GuiMaterialList.Index_SerenityCrystal;
						}

						if(s.equals(Strings.SM_TranquilShard)){
							index = GuiMaterialList.Index_TranquilShard;
						}
						if(s.equals(Strings.SM_TranquilStone)){
							index = GuiMaterialList.Index_TranquilStone;
						}
						if(s.equals(Strings.SM_TranquilGem)){
							index = GuiMaterialList.Index_TranquilGem;
						}
						if(s.equals(Strings.SM_TranquilCrystal)){
							index = GuiMaterialList.Index_TranquilCrystal;
						}

						if(s.equals(Strings.SM_TwilightShard)){
							index = GuiMaterialList.Index_TwilightShard;
						}
						if(s.equals(Strings.SM_TwilightStone)){
							index = GuiMaterialList.Index_TwilightStone;
						}
						if(s.equals(Strings.SM_TwilightGem)){
							index = GuiMaterialList.Index_TwilightGem;
						}
						if(s.equals(Strings.SM_TwilightCrystal)){
							index = GuiMaterialList.Index_TwilightCrystal;
						}
						ExtendedPlayerMaterials.get(player).setMaterialArray(ExtendedPlayerMaterials.get(player).arrayOfAmounts[index] += player.inventory.mainInventory[i].stackSize, index);
						player.inventory.setInventorySlotContents(i, null);
					}

				}
			}
		}
	}

}
