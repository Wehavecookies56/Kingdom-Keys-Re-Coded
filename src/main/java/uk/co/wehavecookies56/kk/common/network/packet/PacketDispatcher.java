package uk.co.wehavecookies56.kk.common.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.client.OpenOrgGUI;
import uk.co.wehavecookies56.kk.common.network.packet.client.PedestalRotation;
import uk.co.wehavecookies56.kk.common.network.packet.client.ShowOverlayPacket;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnAeroParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnCureParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnFireParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnKH1FireParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnKeybladeParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnLockOnParticle;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnOrgWeaponParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnShockwaveParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnStopParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnThunderEntity;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnThunderParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnWisdomShotParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncCheatModeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveInventory;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveWithPlayers;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncFreeDevRecipeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncHudData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncItemsInventory;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKH1Magic;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicInventory;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncRecipeData;
import uk.co.wehavecookies56.kk.common.network.packet.server.AntiPoints;
import uk.co.wehavecookies56.kk.common.network.packet.server.AttackEntity;
import uk.co.wehavecookies56.kk.common.network.packet.server.CreateFromSynthesisRecipe;
import uk.co.wehavecookies56.kk.common.network.packet.server.DeSummonKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.server.DeSummonOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.server.DepositMaterialsFromBag;
import uk.co.wehavecookies56.kk.common.network.packet.server.DesummonClaymore;
import uk.co.wehavecookies56.kk.common.network.packet.server.DriveFormPacket;
import uk.co.wehavecookies56.kk.common.network.packet.server.DriveOrbPickup;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveBoughtItem;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveItemInSlot;
import uk.co.wehavecookies56.kk.common.network.packet.server.GlidePacket;
import uk.co.wehavecookies56.kk.common.network.packet.server.HpOrbPickup;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpDrive;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpSound;
import uk.co.wehavecookies56.kk.common.network.packet.server.MagicOrbPickup;
import uk.co.wehavecookies56.kk.common.network.packet.server.MagnetBloxMotion;
import uk.co.wehavecookies56.kk.common.network.packet.server.MasterFormPacket;
import uk.co.wehavecookies56.kk.common.network.packet.server.MunnyPickup;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenGui;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenMaterials;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenMenu;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenSynthesis;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgMemberSelect;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortalTP;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgWeaponSelect;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgWeaponUnlock;
import uk.co.wehavecookies56.kk.common.network.packet.server.PedestalItem;
import uk.co.wehavecookies56.kk.common.network.packet.server.PlaySoundAtPlayer;
import uk.co.wehavecookies56.kk.common.network.packet.server.PotionConsume;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlot;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonClaymore;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.server.SyncStatMessagesPacket;
import uk.co.wehavecookies56.kk.common.network.packet.server.SynthesisMaterialPickup;
import uk.co.wehavecookies56.kk.common.network.packet.server.TakeMaterials;
import uk.co.wehavecookies56.kk.common.network.packet.server.TakeSoldItem;
import uk.co.wehavecookies56.kk.common.network.packet.server.UseRecipe;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.LevelUpMagic;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicAero;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicBlizzard;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicCure;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicFire;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicKH1Fire;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicStop;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicThunder;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicWisdomShot;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.SetKH1Fire;

public class PacketDispatcher {
    private static byte packetId = 0;

    private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODCHANNEL);

    public static final void registerPackets () {

        // Server to Client
        registerMessage(SpawnFireParticles.class);
        registerMessage(SpawnKH1FireParticles.class);
        registerMessage(SpawnBlizzardParticles.class);
        registerMessage(SpawnThunderParticles.class);
        registerMessage(SpawnCureParticles.class);
        registerMessage(SpawnAeroParticles.class);
        registerMessage(SpawnStopParticles.class);
        registerMessage(SpawnWisdomShotParticles.class);
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
        registerMessage(SyncFreeDevRecipeData.class);
        registerMessage(SyncOrgXIIIData.class);
        registerMessage(SpawnLockOnParticle.class);
        registerMessage(SyncKH1Magic.class);
        registerMessage(PedestalRotation.class);
        registerMessage(SpawnPortalParticles.class);
        registerMessage(OpenOrgGUI.class);
        registerMessage(SpawnKeybladeParticles.class);
        registerMessage(SpawnOrgWeaponParticles.class);
        registerMessage(SyncOrgPortal.class);
        registerMessage(SpawnShockwaveParticles.class);

        // Client to Server
        registerMessage(MunnyPickup.class);
        registerMessage(HpOrbPickup.class);
        registerMessage(OpenGui.class);
        registerMessage(SummonKeyblade.class);
        registerMessage(DeSummonKeyblade.class);
        registerMessage(PlaySoundAtPlayer.class);
        registerMessage(MagicFire.class);
        registerMessage(MagicKH1Fire.class);
        registerMessage(MagicBlizzard.class);
        registerMessage(MagicThunder.class);
        registerMessage(MagicCure.class);
        registerMessage(MagicAero.class);
        registerMessage(MagicStop.class);
        registerMessage(MagicWisdomShot.class);
        registerMessage(UseRecipe.class);
        registerMessage(OpenMaterials.class);
        registerMessage(DepositMaterialsFromBag.class);
        registerMessage(CreateFromSynthesisRecipe.class);
        registerMessage(DriveOrbPickup.class);
        registerMessage(MagicOrbPickup.class);
        registerMessage(OpenMenu.class);
        registerMessage(OpenSynthesis.class);
        registerMessage(DriveFormPacket.class);
        registerMessage(AntiPoints.class);
        registerMessage(GlidePacket.class);
        registerMessage(MasterFormPacket.class);
        registerMessage(LevelUpMagic.class);
        registerMessage(OrgMemberSelect.class);
        registerMessage(OrgWeaponSelect.class);
        registerMessage(SummonOrgWeapon.class);
        registerMessage(DeSummonOrgWeapon.class);
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
        registerMessage(GiveBoughtItem.class);
        registerMessage(TakeSoldItem.class);
        registerMessage(PedestalItem.class);
        registerMessage(OrgPortal.class);
        registerMessage(SummonClaymore.class);
        registerMessage(DesummonClaymore.class);
        registerMessage(OrgPortalTP.class);
        registerMessage(OrgWeaponUnlock.class);
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
        PacketDispatcher.sendToAllAround(message, player.world.provider.getDimension(), player.posX, player.posY, player.posZ, range);
    }

    public static final void sendToDimension (IMessage message, int dimensionId) {
        PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
    }

    public static final void sendToServer (IMessage message) {
        PacketDispatcher.dispatcher.sendToServer(message);
    }
}
