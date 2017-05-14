package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;

public class OrgPortal extends AbstractMessage.AbstractServerMessage<OrgPortal> {

	public OrgPortal () {}

	BlockPos pos;

	public OrgPortal (BlockPos pos) {
		this.pos = pos;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		pos = buffer.readBlockPos();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeBlockPos(pos);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) 
			player.getCapability(ModCapabilities.PLAYER_STATS, null).setMP(0);

		PacketDispatcher.sendToAllAround(new SpawnPortalParticles(pos), player, 64.0D);
		EntityOrgPortal portal = new EntityOrgPortal(player.world, player, pos.getX(),pos.getY(), pos.getZ());
		player.world.spawnEntity(portal);
		
		PacketDispatcher.sendTo(new SyncMagicData(player.getCapability(ModCapabilities.MAGIC_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);

	}
}
