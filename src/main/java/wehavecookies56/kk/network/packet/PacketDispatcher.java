package wehavecookies56.kk.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerRecipes;
import wehavecookies56.kk.network.packet.server.DeSummonKeyblade;
import wehavecookies56.kk.network.packet.server.HpOrbPickup;
import wehavecookies56.kk.network.packet.server.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.MagicCure;
import wehavecookies56.kk.network.packet.server.MagicFire;
import wehavecookies56.kk.network.packet.server.MagicThunder;
import wehavecookies56.kk.network.packet.server.MunnyPickup;
import wehavecookies56.kk.network.packet.server.OpenGui;
import wehavecookies56.kk.network.packet.server.PlaySoundAtPlayer;
import wehavecookies56.kk.network.packet.server.SummonKeyblade;

public class PacketDispatcher
{
	private static byte packetId = 0;

	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODCHANNEL);

	public static final void registerPackets() {

		//Server to Client
		registerMessage(SyncExtendedPlayer.class);
		registerMessage(SyncExtendedPlayerRecipes.class);

		//Client to Server
		registerMessage(MunnyPickup.class);
		registerMessage(HpOrbPickup.class);
		registerMessage(OpenGui.class);
		registerMessage(SummonKeyblade.class);
		registerMessage(DeSummonKeyblade.class);
		registerMessage(PlaySoundAtPlayer.class);
		registerMessage(MagicFire.class);
		registerMessage(MagicBlizzard.class);
		registerMessage(MagicThunder.class);
		registerMessage(MagicCure.class);		

		//Bidirectional
	}

	private static final <T extends AbstractMessage<T> & IMessageHandler<T, IMessage>> void registerMessage(Class<T> clazz) {
		if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.CLIENT);
		} else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		} else {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		}
	}

	public static final void sendTo(IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(message, player);
	}

	public static void sendToAll(IMessage message) {
		PacketDispatcher.dispatcher.sendToAll(message);
	}

	public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
		PacketDispatcher.dispatcher.sendToAllAround(message, point);
	}

	public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
		PacketDispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}

	public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
		PacketDispatcher.sendToAllAround(message, player.worldObj.provider.getDimensionId(), player.posX, player.posY, player.posZ, range);
	}

	public static final void sendToDimension(IMessage message, int dimensionId) {
		PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
	}

	public static final void sendToServer(IMessage message) {
		PacketDispatcher.dispatcher.sendToServer(message);
	}
}
