package wehavecookies56.kk.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.client.ShowOverlayPacket;
import wehavecookies56.kk.network.packet.client.SpawnAeroParticles;
import wehavecookies56.kk.network.packet.client.SpawnBlizzardParticles;
import wehavecookies56.kk.network.packet.client.SpawnCureParticles;
import wehavecookies56.kk.network.packet.client.SpawnFireParticles;
import wehavecookies56.kk.network.packet.client.SpawnStopParticles;
import wehavecookies56.kk.network.packet.client.SpawnThunderParticles;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerMaterials;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerRecipes;
import wehavecookies56.kk.network.packet.server.AntiPoints;
import wehavecookies56.kk.network.packet.server.ChangeDP;
import wehavecookies56.kk.network.packet.server.ChangeMP;
import wehavecookies56.kk.network.packet.server.ChangeDefense;
import wehavecookies56.kk.network.packet.server.ChangeStrength;
import wehavecookies56.kk.network.packet.server.ChangeMaxHP;
import wehavecookies56.kk.network.packet.server.ChangeXP;
import wehavecookies56.kk.network.packet.server.CreateFromSynthesisRecipe;
import wehavecookies56.kk.network.packet.server.DeSummonKeyblade;
import wehavecookies56.kk.network.packet.server.MasterFormPacket;
import wehavecookies56.kk.network.packet.server.DriveFormPacket;
import wehavecookies56.kk.network.packet.server.DriveOrbPickup;
import wehavecookies56.kk.network.packet.server.GiveAchievementOpenMenu;
import wehavecookies56.kk.network.packet.server.GlidePacket;
import wehavecookies56.kk.network.packet.server.HpOrbPickup;
import wehavecookies56.kk.network.packet.server.MagicOrbPickup;
import wehavecookies56.kk.network.packet.server.MunnyPickup;
import wehavecookies56.kk.network.packet.server.OpenGui;
import wehavecookies56.kk.network.packet.server.OpenMaterials;
import wehavecookies56.kk.network.packet.server.PlaySoundAtPlayer;
import wehavecookies56.kk.network.packet.server.SummonKeyblade;
import wehavecookies56.kk.network.packet.server.SyncStatMessagesPacket;
import wehavecookies56.kk.network.packet.server.UseRecipe;
import wehavecookies56.kk.network.packet.server.magics.LevelUpMagic;
import wehavecookies56.kk.network.packet.server.magics.MagicAero;
import wehavecookies56.kk.network.packet.server.magics.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.magics.MagicCure;
import wehavecookies56.kk.network.packet.server.magics.MagicFire;
import wehavecookies56.kk.network.packet.server.magics.MagicStop;
import wehavecookies56.kk.network.packet.server.magics.MagicThunder;

public class PacketDispatcher
{
	private static byte packetId = 0;

	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODCHANNEL);

	public static final void registerPackets() {

		//Server to Client
		registerMessage(SyncExtendedPlayer.class);
		registerMessage(SyncExtendedPlayerRecipes.class);
		registerMessage(SyncExtendedPlayerMaterials.class);
		registerMessage(SpawnFireParticles.class);
		registerMessage(SpawnBlizzardParticles.class);
		registerMessage(SpawnThunderParticles.class);
		registerMessage(SpawnCureParticles.class);
		registerMessage(SpawnAeroParticles.class);
		registerMessage(SpawnStopParticles.class);
		registerMessage(ShowOverlayPacket.class);
		registerMessage(SyncStatMessagesPacket.class);

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
		registerMessage(MagicAero.class);
		registerMessage(MagicStop.class);
		registerMessage(UseRecipe.class);
		registerMessage(OpenMaterials.class);
		registerMessage(CreateFromSynthesisRecipe.class);
		registerMessage(DriveOrbPickup.class);
		registerMessage(MagicOrbPickup.class);
		registerMessage(GiveAchievementOpenMenu.class);
		registerMessage(DriveFormPacket.class);
		registerMessage(AntiPoints.class);
		registerMessage(ChangeDP.class);
		registerMessage(ChangeMP.class);
		registerMessage(ChangeXP.class);
		registerMessage(ChangeStrength.class);
		registerMessage(ChangeDefense.class);
		registerMessage(ChangeMaxHP.class);
		registerMessage(GlidePacket.class);
		registerMessage(MasterFormPacket.class);
		registerMessage(LevelUpMagic.class);

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
