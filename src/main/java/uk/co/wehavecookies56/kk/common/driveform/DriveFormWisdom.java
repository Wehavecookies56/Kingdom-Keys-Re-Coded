package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DriveFormWisdom extends DriveForm {
	
	@SubscribeEvent
	public static void getXP(LivingDeathEvent event) {
		 if (!event.getEntity().world.isRemote && event.getEntity() instanceof IKHMob) { 
			 if (event.getSource().getTrueSource() instanceof EntityPlayer) {
	            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
	            IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null); 

	            if(DRIVE.getActiveDriveName().equals(Strings.Form_Wisdom)) {
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

    public DriveFormWisdom (double cost) {
        this.cost = cost;
    }

    @Override
    public String getName () {
        return Strings.Form_Wisdom;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/wisdom.png");
    }

    @Override
    public double getCost () {
        return this.cost;
    }

    @Override
    public boolean hasOffHand() {
        return false;
    }

    @Override
    public int getKeychainSlot() {
        return 0;
    }

    @Override
    public void initDrive (EntityPlayer player) {
        super.initDrive(player);
    }

    @Override
    public void update (EntityPlayer player) {
        super.update(player);
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