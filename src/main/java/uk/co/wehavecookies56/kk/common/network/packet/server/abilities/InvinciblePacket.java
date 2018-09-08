package uk.co.wehavecookies56.kk.common.network.packet.server.abilities;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncAbilitiesData;

public class InvinciblePacket extends AbstractServerMessage<InvinciblePacket> {

	int ticks;
	
	public InvinciblePacket() {
	}

	public InvinciblePacket(int ticks) {
		this.ticks = ticks;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.ticks = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(ticks);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		World world = player.world;
		IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
		ABILITIES.setInvincible(true);
		ABILITIES.setInvTicks(ticks);
		
		if (!world.isRemote) {
			PacketDispatcher.sendTo(new SyncAbilitiesData(ABILITIES), (EntityPlayerMP) player);
		}
	}

}
