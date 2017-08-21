package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DriveFormLimit extends DriveForm {
	
	@SubscribeEvent
	public static void getXP(LivingHurtEvent event) {
        if (event.getSource().getImmediateSource() instanceof EntityPlayer) {
        	EntityPlayer player = (EntityPlayer) event.getSource().getImmediateSource();
        	
            PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
            DriveStateCapability.IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null);

            if(DRIVE.getActiveDriveName().equals(Strings.Form_Limit)) {
            	DRIVE.setDriveExp(DRIVE.getActiveDriveName(), DRIVE.getDriveExp(DRIVE.getActiveDriveName())+1);
            
	            int[] costs = DriveFormRegistry.get(DRIVE.getActiveDriveName()).getExpCosts();
	            int actualLevel = DRIVE.getDriveLevel(DRIVE.getActiveDriveName());
	            int actualExp = DRIVE.getDriveExp(DRIVE.getActiveDriveName());
	           
	            if(costs.length == 7 && actualLevel < 7) {
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

    public DriveFormLimit (double cost) {
        this.cost = cost;
    }

    @Override
    public String getName () {
        return Strings.Form_Limit;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/limit.png");
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
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName().equals(getName()))
            player.sendMessage(new TextComponentTranslation(TextFormatting.RED + "Limit form activated"));
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
		return new int[]{0,80,240,520,968,1528,2200};
	}
}
