package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ItemSynthesisMaterial;
import wehavecookies56.kk.lib.Lists;
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
							index = Lists.Index_BlazingShard;
						}
						if(s.equals(Strings.SM_BlazingStone)){
							index = Lists.Index_BlazingStone;
						}
						if(s.equals(Strings.SM_BlazingGem)){
							index = Lists.Index_BlazingGem;
						}
						if(s.equals(Strings.SM_BlazingCrystal)){
							index = Lists.Index_BlazingCrystal;
						}

						if(s.equals(Strings.SM_BrightShard)){
							index = Lists.Index_BrightShard;
						}
						if(s.equals(Strings.SM_BrightStone)){
							index = Lists.Index_BrightStone;
						}
						if(s.equals(Strings.SM_BrightGem)){
							index = Lists.Index_BrightGem;
						}
						if(s.equals(Strings.SM_BrightCrystal)){
							index = Lists.Index_BrightCrystal;
						}

						if(s.equals(Strings.SM_DarkShard)){
							index = Lists.Index_DarkShard;
						}
						if(s.equals(Strings.SM_DarkStone)){
							index = Lists.Index_DarkStone;
						}
						if(s.equals(Strings.SM_DarkGem)){
							index = Lists.Index_DarkGem;
						}
						if(s.equals(Strings.SM_DarkCrystal)){
							index = Lists.Index_DarkCrystal;
						}

						if(s.equals(Strings.SM_DenseShard)){
							index = Lists.Index_DenseShard;
						}
						if(s.equals(Strings.SM_DenseStone)){
							index = Lists.Index_DenseStone;
						}
						if(s.equals(Strings.SM_DenseGem)){
							index = Lists.Index_DenseGem;
						}
						if(s.equals(Strings.SM_DenseCrystal)){
							index = Lists.Index_DenseCrystal;
						}

						if(s.equals(Strings.SM_EnergyShard)){
							index = Lists.Index_EnergyShard;
						}
						if(s.equals(Strings.SM_EnergyStone)){
							index = Lists.Index_EnergyStone;
						}
						if(s.equals(Strings.SM_EnergyGem)){
							index = Lists.Index_EnergyGem;
						}
						if(s.equals(Strings.SM_EnergyCrystal)){
							index = Lists.Index_EnergyCrystal;
						}

						if(s.equals(Strings.SM_FrostShard)){
							index = Lists.Index_FrostShard;
						}
						if(s.equals(Strings.SM_FrostStone)){
							index = Lists.Index_FrostStone;
						}
						if(s.equals(Strings.SM_FrostGem)){
							index = Lists.Index_FrostGem;
						}
						if(s.equals(Strings.SM_FrostCrystal)){
							index = Lists.Index_FrostCrystal;
						}

						if(s.equals(Strings.SM_LightningShard)){
							index = Lists.Index_LightningShard;
						}
						if(s.equals(Strings.SM_LightningStone)){
							index = Lists.Index_LightningStone;
						}
						if(s.equals(Strings.SM_LightningGem)){
							index = Lists.Index_LightningGem;
						}
						if(s.equals(Strings.SM_LightningCrystal)){
							index = Lists.Index_LightningCrystal;
						}

						if(s.equals(Strings.SM_LostIllusion)){
							index = Lists.Index_LostIllusion;
						}

						if(s.equals(Strings.SM_LucidShard)){
							index = Lists.Index_LucidShard;
						}
						if(s.equals(Strings.SM_LucidStone)){
							index = Lists.Index_LucidStone;
						}
						if(s.equals(Strings.SM_LucidGem)){
							index = Lists.Index_LucidGem;
						}
						if(s.equals(Strings.SM_LucidCrystal)){
							index = Lists.Index_LucidCrystal;
						}

						if(s.equals(Strings.SM_ManifestIllusion)){
							index = Lists.Index_ManifestIllusion;
						}

						if(s.equals(Strings.SM_MythrilShard)){
							index = Lists.Index_MythrilShard;
						}
						if(s.equals(Strings.SM_MythrilStone)){
							index = Lists.Index_MythrilStone;
						}
						if(s.equals(Strings.SM_MythrilGem)){
							index = Lists.Index_MythrilGem;
						}
						if(s.equals(Strings.SM_MythrilCrystal)){
							index = Lists.Index_MythrilCrystal;
						}

						if(s.equals(Strings.SM_Orichalcum)){
							index = Lists.Index_Orichalcum;
						}
						if(s.equals(Strings.SM_OrichalcumPlus)){
							index = Lists.Index_OrichalcumPlus;
						}

						if(s.equals(Strings.SM_PowerShard)){
							index = Lists.Index_PowerShard;
						}
						if(s.equals(Strings.SM_PowerStone)){
							index = Lists.Index_PowerStone;
						}
						if(s.equals(Strings.SM_PowerGem)){
							index = Lists.Index_PowerGem;
						}
						if(s.equals(Strings.SM_PowerCrystal)){
							index = Lists.Index_PowerCrystal;
						}

						if(s.equals(Strings.SM_RemembranceShard)){
							index = Lists.Index_RemembranceShard;
						}
						if(s.equals(Strings.SM_RemembranceStone)){
							index = Lists.Index_RemembranceStone;
						}
						if(s.equals(Strings.SM_RemembranceGem)){
							index = Lists.Index_RemembranceGem;
						}
						if(s.equals(Strings.SM_RemembranceCrystal)){
							index = Lists.Index_RemembranceCrystal;
						}

						if(s.equals(Strings.SM_SerenityShard)){
							index = Lists.Index_SerenityShard;
						}
						if(s.equals(Strings.SM_SerenityStone)){
							index = Lists.Index_SerenityStone;
						}
						if(s.equals(Strings.SM_SerenityGem)){
							index = Lists.Index_SerenityGem;
						}
						if(s.equals(Strings.SM_SerenityCrystal)){
							index = Lists.Index_SerenityCrystal;
						}

						if(s.equals(Strings.SM_TranquilShard)){
							index = Lists.Index_TranquilShard;
						}
						if(s.equals(Strings.SM_TranquilStone)){
							index = Lists.Index_TranquilStone;
						}
						if(s.equals(Strings.SM_TranquilGem)){
							index = Lists.Index_TranquilGem;
						}
						if(s.equals(Strings.SM_TranquilCrystal)){
							index = Lists.Index_TranquilCrystal;
						}

						if(s.equals(Strings.SM_TwilightShard)){
							index = Lists.Index_TwilightShard;
						}
						if(s.equals(Strings.SM_TwilightStone)){
							index = Lists.Index_TwilightStone;
						}
						if(s.equals(Strings.SM_TwilightGem)){
							index = Lists.Index_TwilightGem;
						}
						if(s.equals(Strings.SM_TwilightCrystal)){
							index = Lists.Index_TwilightCrystal;
						}

						if(s.equals(Strings.SM_StormyShard)){
							index = Lists.Index_StormyShard;
						}
						if(s.equals(Strings.SM_StormyStone)){
							index = Lists.Index_StormyStone;
						}
						if(s.equals(Strings.SM_StormyGem)){
							index = Lists.Index_StormyGem;
						}
						if(s.equals(Strings.SM_StormyCrystal)){
							index = Lists.Index_StormyCrystal;
						}
						ExtendedPlayerMaterials.get(player).setMaterialArray(ExtendedPlayerMaterials.get(player).arrayOfAmounts[index] += player.inventory.mainInventory[i].stackSize, index);
						player.inventory.setInventorySlotContents(i, null);
					}

				}
			}
		}
	}

}
