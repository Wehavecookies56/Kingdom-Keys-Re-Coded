package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;

public class EntityOrgMoogle extends EntityMoogle{
    boolean canDespawn;

    public EntityOrgMoogle(World worldIn) {
        super(worldIn);
        canDespawn = true;
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    public EntityOrgMoogle(World worldIn, boolean canDespawn) {
        super(worldIn);
        this.canDespawn = canDespawn;
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(!player.isSneaking()) {
            this.world.playSound(player, this.posX, this.posY, this.posZ, ModSounds.kupo, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!this.world.isRemote) {
                PacketDispatcher.sendTo(new SyncMunnyData(player.getCapability(ModCapabilities.MUNNY, null)), (EntityPlayerMP) player);
            }
            player.openGui(KingdomKeys.instance, GuiIDs.GUI_SHOP, this.world, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        }
        return false;
    }

}
