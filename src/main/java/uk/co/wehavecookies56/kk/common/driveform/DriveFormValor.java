package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class DriveFormValor extends DriveForm {

    double cost;

    public DriveFormValor (double cost) {
        this.cost = cost;
    }

    @Override
    public String getName () {
        return Strings.Form_Valor;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/valor.png");
    }

    @Override
    public boolean hasOffHand() {
        return true;
    }

    @Override
    public int getKeychainSlot() {
        return 1;
    }

    @Override
    public double getCost () {
        return this.cost;
    }

    @Override
    public void initDrive (EntityPlayer player) {
        super.initDrive(player);
    }

    @Override
    public void update (EntityPlayer player) {
        super.update(player);
        if (player.onGround && !player.isInWater()) {
            player.motionX *= Constants.VALOR_SPEED;
            player.motionZ *= Constants.VALOR_SPEED;
        }
        boolean j = false;
        if(player.world.isRemote) {
            j = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
        }

        if (j) {
            if(player.motionY > 0) {
                switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final)) {
                case 0:
                    player.motionY += Constants.VALOR_JUMP_1;
                    break;
                case 1:
                    player.motionY += Constants.VALOR_JUMP_2;
                    break;
                case 2:
                    player.motionY += Constants.VALOR_JUMP_3;
                    break;
                }
            }
        }
    }
    @Override
    public void endDrive (EntityPlayer player) {
        super.endDrive(player);
    }

}
