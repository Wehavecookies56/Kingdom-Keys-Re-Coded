package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.OpenPlayerItemsGUI;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncEquippedAbilities;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

public class EquipAbility extends AbstractMessage.AbstractServerMessage<EquipAbility> {

    String abilityName;

    public EquipAbility() {}

    public EquipAbility(String ability) {
		this.abilityName = ability;
	}

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        abilityName = buffer.readString(100);
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeString(abilityName);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
		IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
		IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
		Ability ability = Utils.getAbilityFromName(abilityName);
    	if (ABILITIES.getEquippedAbility(ability)) {
			MinecraftForge.EVENT_BUS.post(new AbilityEvent.Unequip(player, ability));
			STATS.setConsumedAP(STATS.getConsumedAP() - ability.getApCost());
			ABILITIES.equipAbility(ability, false);
			
		} else {
			MinecraftForge.EVENT_BUS.post(new AbilityEvent.Equip(player, ability));
			if (STATS.getConsumedAP() + ability.getApCost() > STATS.getMaxAP()) {
				System.out.println("Not enough AP");
			} else {
				STATS.setConsumedAP(STATS.getConsumedAP() + ability.getApCost());
				ABILITIES.equipAbility(ability, true);
			}
		}
        PacketDispatcher.sendTo(new SyncEquippedAbilities(player.getCapability(ModCapabilities.ABILITIES, null)), (EntityPlayerMP) player);
    }
}
