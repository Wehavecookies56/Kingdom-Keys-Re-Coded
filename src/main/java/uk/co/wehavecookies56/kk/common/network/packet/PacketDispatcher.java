package uk.co.wehavecookies56.kk.common.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.client.*;
import uk.co.wehavecookies56.kk.common.network.packet.server.*;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.LevelUpMagic;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicAero;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicBlizzard;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicCure;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicFire;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicStop;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicThunder;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.SetKH1Fire;

public class PacketDispatcher {
	private static byte packetId = 0;

	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODCHANNEL);

	public static final void registerPackets () {

		// Server to Client
		registerMessage(SpawnFireParticles.class);
		registerMessage(SpawnBlizzardParticles.class);
		registerMessage(SpawnThunderParticles.class);
		registerMessage(SpawnCureParticles.class);
		registerMessage(SpawnAeroParticles.class);
		registerMessage(SpawnStopParticles.class);
		registerMessage(ShowOverlayPacket.class);
		registerMessage(SyncStatMessagesPacket.class);
		registerMessage(SpawnThunderEntity.class);
		registerMessage(SpawnDriveFormParticles.class);
		registerMessage(SyncRecipeData.class);
		registerMessage(SyncMaterialData.class);
		registerMessage(SyncDriveData.class);
		registerMessage(SyncMagicData.class);
		registerMessage(SyncMunnyData.class);
		registerMessage(SyncMagicInventory.class);
		registerMessage(SyncItemsInventory.class);
		registerMessage(SyncDriveInventory.class);
		registerMessage(SyncKeybladeData.class);
		registerMessage(SyncCheatModeData.class);
		registerMessage(SyncHudData.class);
		registerMessage(SyncLevelData.class);
		registerMessage(SyncDriveWithPlayers.class);

		// Client to Server
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
		registerMessage(OpenMenu.class);
		registerMessage(DriveFormPacket.class);
		registerMessage(AntiPoints.class);
		registerMessage(GlidePacket.class);
		registerMessage(MasterFormPacket.class);
		registerMessage(LevelUpMagic.class);
		registerMessage(ManifestKnowledgePacket.class);
		registerMessage(LevelUpDrive.class);
		registerMessage(SynthesisMaterialPickup.class);
		registerMessage(MagnetBloxMotion.class);
		registerMessage(TakeMaterials.class);
		registerMessage(RemoveItemInSlot.class);
		registerMessage(GiveItemInSlot.class);
		registerMessage(PotionConsume.class);
		registerMessage(AttackEntity.class);
		registerMessage(SetKH1Fire.class);
		registerMessage(LevelUpSound.class);
		registerMessage(LockOn.class);

		// Bidirectional
	}

	private static final <T extends AbstractMessage<T> & IMessageHandler<T, IMessage>> void registerMessage (Class<T> clazz) {
		if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz))
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.CLIENT);
		else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom(clazz))
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		else {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		}
	}

	public static final void sendTo (IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(message, player);
	}

	public static void sendToAll (IMessage message) {
		PacketDispatcher.dispatcher.sendToAll(message);
	}

	public static final void sendToAllAround (IMessage message, NetworkRegistry.TargetPoint point) {
		PacketDispatcher.dispatcher.sendToAllAround(message, point);
	}

	public static final void sendToAllAround (IMessage message, int dimension, double x, double y, double z, double range) {
		PacketDispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}

	public static final void sendToAllAround (IMessage message, EntityPlayer player, double range) {
		PacketDispatcher.sendToAllAround(message, player.worldObj.provider.getDimension(), player.posX, player.posY, player.posZ, range);
	}

	public static final void sendToDimension (IMessage message, int dimensionId) {
		PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
	}

	public static final void sendToServer (IMessage message) {
		PacketDispatcher.dispatcher.sendToServer(message);
	}
}
