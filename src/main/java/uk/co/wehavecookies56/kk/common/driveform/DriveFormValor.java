package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.util.Utils;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DriveFormValor extends DriveForm {

	@SubscribeEvent
	public static void getXP(LivingHurtEvent event) {
        if (event.getSource().getImmediateSource() instanceof EntityPlayer) {
        	EntityPlayer player = (EntityPlayer) event.getSource().getImmediateSource();
        	
            PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
            DriveStateCapability.IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null);

        	if(DRIVE.getActiveDriveName().equals(Strings.Form_Valor)) {
        		DRIVE.setDriveExp(DRIVE.getActiveDriveName(), DRIVE.getDriveExp(DRIVE.getActiveDriveName())+1);
	            
	            int[] costs = DriveFormRegistry.get(DRIVE.getActiveDriveName()).getExpCosts();
	            int actualLevel = DRIVE.getDriveLevel(DRIVE.getActiveDriveName());
	            int actualExp = DRIVE.getDriveExp(DRIVE.getActiveDriveName());
	            System.out.println(actualLevel+":"+actualExp);
	           
	            if(costs.length == 7 && actualLevel < 7) {
	            	System.out.println(actualExp+"::"+costs[actualLevel]);
	            	if (actualExp >= costs[actualLevel]){
	            		System.out.println("LEVEL UP");
	            		DRIVE.setDriveLevel(DRIVE.getActiveDriveName(),actualLevel+1); 
	            	}
	            }
	            PacketDispatcher.sendTo(new SyncDriveData(DRIVE, player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
        	}
        }
	}
	
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
                switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Valor)) {
                case 1:
                    player.motionY += Constants.VALOR_JUMP_1;
                    break;
                case 3:
                    player.motionY += Constants.VALOR_JUMP_2;
                    break;
                case 5:
                    player.motionY += Constants.VALOR_JUMP_3;
                    break;
                case 7:
                    player.motionY += Constants.VALOR_JUMP_4;
                    break;
                }
            }
        }
    }
    @Override
    public void endDrive (EntityPlayer player) {
        super.endDrive(player);
    }
    
    @Override
	public int[] getExpCosts() {
		return new int[]{0,80,240,520,968,1528,2200};
	}

}
