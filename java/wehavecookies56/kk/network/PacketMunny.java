package wehavecookies56.kk.network;

import wehavecookies56.kk.entities.ExtendedPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketMunny extends AbstractPacket {

	public PacketMunny() {}
	
	private int munny;
	
	public PacketMunny(int munny){
		this.munny = munny;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
		buf.writeInt(munny);		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buf) {
		this.munny = buf.readInt();
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);	
		props.munny = this.munny;
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);	
		props.munny = this.munny;
		
	}

}
