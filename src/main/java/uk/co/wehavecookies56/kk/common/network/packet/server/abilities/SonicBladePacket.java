package uk.co.wehavecookies56.kk.common.network.packet.server.abilities;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityAero;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityAeroga;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityAerora;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnAeroParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;

public class SonicBladePacket extends AbstractServerMessage<SonicBladePacket> {

	public SonicBladePacket() {
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
			player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(10);//Constants.getCost(Strings.Spell_Aero));
		World world = player.world;
		IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
		ABILITIES.setUseSonicBlade(true);
		

		if (!world.isRemote) {
			PacketDispatcher.sendTo(new SyncMagicData(player.getCapability(ModCapabilities.MAGIC_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		}
	}

}
