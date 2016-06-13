package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
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
		Vec3d v = player.getLookVec().normalize();
		int range = 50;
		if (v != null)
		{
			for(int i = 1;i<range;i++)
			{
				AxisAlignedBB aabb = new AxisAlignedBB(player.posX + v.xCoord * i, player.posY + v.yCoord * i, player.posZ + v.zCoord * i, player.posX + v.xCoord * i, player.posY + v.yCoord * i, player.posZ + v.zCoord * i);
				List list = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, aabb);
				if(list.iterator().hasNext()){
					EntityLiving target = (EntityLiving)list.get(0);
					System.out.println(v+" "+target);
				}
			}
			//System.out.println(v+" ");
		}
	}
}
