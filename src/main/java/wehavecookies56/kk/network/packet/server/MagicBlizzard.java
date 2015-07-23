package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityBlizzard;
import wehavecookies56.kk.magic.Magic;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicBlizzard extends AbstractServerMessage<MagicBlizzard> {

	public MagicBlizzard() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).setMp(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp()-Magic.getMagicCost("blizzard"));

		World world = player.worldObj;
		Vec3 look = player.getLookVec();
		world.spawnEntityInWorld(new EntityBlizzard(world, player));
	}

}
