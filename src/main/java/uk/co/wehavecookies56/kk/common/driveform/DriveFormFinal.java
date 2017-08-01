package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;
import uk.co.wehavecookies56.kk.common.network.packet.server.GlidePacket;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DriveFormFinal extends DriveForm {
	
	@SubscribeEvent
	public static void getXP(LivingDeathEvent event) {
		 if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityEnderman) { 
			 if (event.getSource().getTrueSource() instanceof EntityPlayer) {
	            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
	            IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null); 

	            if(DRIVE.getActiveDriveName().equals(Strings.Form_Final)) {
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
	}
	
    double cost;

    public static boolean jumpHeld = false;

    public DriveFormFinal (double cost) {
        this.cost = cost;
    }

    @Override
    public String getName () {
        return Strings.Form_Final;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/final.png");
    }

    @Override
    public boolean hasOffHand() {
        return true;
    }

    @Override
    public int getKeychainSlot() {
        return 3;
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
        boolean j = false;
        if(player.world.isRemote) {
            j = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
        }

        if (j) {
            if(player.motionY > 0) {
                player.motionY += Constants.FINAL_JUMP;
            }
        }

        if (player.onGround && !player.isInWater()) {
            player.motionX *= 1.2D;
            player.motionZ *= 1.2D;
        } else if (player.motionY < 0) if (player.world.isRemote) {
            if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
                jumpHeld = true;
                switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final)) {
                    case 1:
                    case 2:
                        player.motionY *= Constants.FINAL_GLIDE_1;
                        break;
                    case 3:
                    case 4:
                        player.motionY *= Constants.FINAL_GLIDE_2;
                        break;
                    case 5:
                        player.motionY *= Constants.FINAL_GLIDE_3;
                        break;
                    case 7:
                        player.motionY *= Constants.FINAL_GLIDE_4;
                        break;
                }
            } else {
                jumpHeld = false;
            }
            PacketDispatcher.sendToServer(new GlidePacket(jumpHeld));

        } else if (jumpHeld) {
            switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final)) {
	            case 1:
	                player.motionY *= Constants.FINAL_GLIDE_1;
	                break;
	            case 3:
	                player.motionY *= Constants.FINAL_GLIDE_2;
	                break;
	            case 5:
	                player.motionY *= Constants.FINAL_GLIDE_3;
	                break;
	            case 7:
	                player.motionY *= Constants.FINAL_GLIDE_4;
	                break;
            }
        }
    }

    @Override
    public void endDrive (EntityPlayer player) {
        super.endDrive(player);
    }

	@Override
	public int[] getExpCosts() {
		return new int[]{0, 20, 80, 152, 242, 350, 500};
	}

}
