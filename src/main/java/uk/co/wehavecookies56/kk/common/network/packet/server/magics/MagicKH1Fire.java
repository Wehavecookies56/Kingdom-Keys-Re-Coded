package uk.co.wehavecookies56.kk.common.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFira;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFiraga;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityKH1Fire;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnKH1FireParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;

public class MagicKH1Fire extends AbstractMessage.AbstractServerMessage<MagicKH1Fire> {

	public MagicKH1Fire () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(Constants.getCost(Strings.Spell_Fire));
		World world = player.worldObj;
		switch (player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(Strings.Spell_Fire)) {
			case 1:
				EntityKH1Fire entityKH1Fire = new EntityKH1Fire(world, player);
				world.spawnEntityInWorld(entityKH1Fire);
				entityKH1Fire.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
				PacketDispatcher.sendToAllAround(new SpawnKH1FireParticles(new EntityKH1Fire(world), 1), player, 64.0D);
				break;
			case 2:
				//world.spawnEntityInWorld(new EntityFira(world, player, player.posX, player.posY, player.posZ));
				break;
			case 3:
				//world.spawnEntityInWorld(new EntityFiraga(world, player, player.posX, player.posY, player.posZ));
				break;
		}
		PacketDispatcher.sendTo(new SyncMagicData(player.getCapability(ModCapabilities.MAGIC_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
	}
}