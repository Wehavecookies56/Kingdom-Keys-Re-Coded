package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.server.MasterFormPacket;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DriveFormMaster extends DriveForm {

	@SubscribeEvent
	public static void getXP(EntityItemPickupEvent event) {
		EntityPlayer player = event.getEntityPlayer();
        DriveStateCapability.IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null);

        if(DRIVE.getActiveDriveName().equals(Strings.Form_Master)) {
        	if(event.getItem().getItem().getItem() == ModItems.DriveOrb) {
        		int amount = (event.getItem().getItem().getTagCompound().getInteger("amount")/5) > 0 ? event.getItem().getItem().getTagCompound().getInteger("amount")/5 : 1;
        		
	        	DRIVE.setDriveExp(DRIVE.getActiveDriveName(), DRIVE.getDriveExp(DRIVE.getActiveDriveName())+amount);
	        	System.out.println(DRIVE.getDriveExp(DRIVE.getActiveDriveName())+(event.getItem().getItem().getTagCompound().getInteger("amount")/5));
	        	int[] costs = DriveFormRegistry.get(DRIVE.getActiveDriveName()).getExpCosts();
	            int actualLevel = DRIVE.getDriveLevel(DRIVE.getActiveDriveName());
	            int actualExp = DRIVE.getDriveExp(DRIVE.getActiveDriveName());
	           
	            if(costs.length == 7 && actualLevel < 7) {
	            	if (actualExp >= costs[actualLevel]){
	            		System.out.println("LEVEL UP");
	            		DRIVE.setDriveLevel(DRIVE.getActiveDriveName(),actualLevel+1); 
	                    DRIVE.displayLevelUpMessage(player, DRIVE.getActiveDriveName());
	            	}
	            }
	            PacketDispatcher.sendTo(new SyncDriveData(DRIVE), (EntityPlayerMP) player);
        	}
        }
	}
	
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
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName().equals(getName()))
            player.sendMessage(new TextComponentTranslation(TextFormatting.GOLD + "Master form activated"));
    }

    @Override
    public void update (EntityPlayer player) {
        super.update(player);
    	int actualLevel = player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Master);

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
                player.motionY += Constants.MASTER_JUMP[actualLevel];
            }
        }
        if (player.onGround)
            jumps = 0;
        else if (player.world.isRemote)
        	if (player.motionY < 0 && Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) if (this.jumps < 1) {
            this.jumps++;
            player.jump();
            PacketDispatcher.sendToServer(new MasterFormPacket());
        }
    }
    @Override
    public void endDrive (EntityPlayer player) {
       super.endDrive(player);
    }
    
    @Override
	public int[] getExpCosts() {
		return new int[]{0,60,240,456,726,1050,1500};
	}

}
