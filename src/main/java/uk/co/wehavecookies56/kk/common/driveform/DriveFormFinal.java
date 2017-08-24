package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
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
		           
		            if(costs.length == 7 && actualLevel < 7) {
		            	if (actualExp >= costs[actualLevel]){
		            		System.out.println("LEVEL UP");
		                    DRIVE.displayLevelUpMessage(player, DRIVE.getActiveDriveName());

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
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName().equals(getName()))
            player.sendMessage(new TextComponentTranslation(TextFormatting.GRAY + "Final form activated"));
    }

    @Override
    public void update (EntityPlayer player) {
        super.update(player);
    	int actualLevel = player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final);

        boolean j = false;
        if(player.world.isRemote) {
            j = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
        }

        if (j) {
            if(player.motionY > 0) {
                player.motionY += Constants.FINAL_JUMP[actualLevel];
            }
        }

        if (player.onGround && !player.isInWater()) {
            player.motionX *= Constants.FINAL_SPEED[actualLevel];
            player.motionZ *= Constants.FINAL_SPEED[actualLevel];
        } else if (player.motionY < 0) if (player.world.isRemote) {
            if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
                jumpHeld = true;
                player.motionY *= Constants.FINAL_GLIDE[actualLevel];
            } else {
                jumpHeld = false;
            }
            PacketDispatcher.sendToServer(new GlidePacket(jumpHeld));

        } else if (jumpHeld) {
            player.motionY *= Constants.FINAL_GLIDE[actualLevel];
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
