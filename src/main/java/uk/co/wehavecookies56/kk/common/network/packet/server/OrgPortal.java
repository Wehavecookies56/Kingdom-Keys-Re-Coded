package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;

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
		PacketDispatcher.sendToAllAround(new SpawnPortalParticles(pos), player, 64.0D);
		//player.world.setBlockState(pos,Blocks.ICE.getDefaultState());
		EntityOrgPortal portal = new EntityOrgPortal(player.world, player, pos);
		player.world.spawnEntity(portal);
	}
}
