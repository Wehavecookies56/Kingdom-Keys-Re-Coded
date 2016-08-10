package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityLockOn;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class LockOn extends AbstractMessage.AbstractServerMessage<LockOn> {

	public LockOn () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		World world = player.worldObj;
		InputHandler.lockOn = null;

		EntityLockOn lockon = new EntityLockOn(world, player);
		world.spawnEntityInWorld(lockon);
		lockon.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 10, 0);
	}
}
