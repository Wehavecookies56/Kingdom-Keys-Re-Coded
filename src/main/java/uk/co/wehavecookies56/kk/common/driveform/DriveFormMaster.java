package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.server.MasterFormPacket;

public class DriveFormMaster extends DriveForm {

    double cost;

    public DriveFormMaster (double cost) {
        this.cost = cost;
    }

    int jumps = 0;

    @Override
    public String getName () {
        return Strings.Form_Master;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/master.png");
    }

    @Override
    public double getCost () {
        return this.cost;
    }

    @Override
    public boolean hasOffHand() {
        return true;
    }

    @Override
    public int getKeychainSlot() {
        return 2;
    }

    @Override
    public void initDrive (EntityPlayer player) {
        super.initDrive(player);
    }

    @Override
    public void update (EntityPlayer player) {
        super.update(player);
        if (player.onGround && !player.isInWater()) {
            player.motionX *= 1.18D;
            player.motionZ *= 1.18D;
        }
        boolean j = false;
        if(player.world.isRemote) {
            j = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
        }

        if (j) {
            if(player.motionY > 0) {
                player.motionY += Constants.MASTER_JUMP_1;
            }
        }
        if (player.onGround)
            jumps = 0;
        else if (player.world.isRemote) if (player.motionY < 0 && Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) if (this.jumps < 1) {
            this.jumps++;
            player.jump();
            PacketDispatcher.sendToServer(new MasterFormPacket());
        }
    }
    @Override
    public void endDrive (EntityPlayer player) {
       super.endDrive(player);
    }

}
