package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.IExtendedReach;

import java.io.IOException;

public class MessageExtendedReachAttackPacket extends AbstractMessage.AbstractServerMessage<MessageExtendedReachAttackPacket> {
    private int entityId;

    public MessageExtendedReachAttackPacket() {
    }

    public MessageExtendedReachAttackPacket(int parEntityId) {
        entityId = parEntityId;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        //entityId = ByteBufUtils.readVarInt(buf, 4);
        entityId = buffer.readInt();

    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        //ByteBufUtils.writeVarInt(buf, entityId, 4);
        buffer.writeInt(entityId);
        // DEBUG
       // System.out.println("toBytes encoded");
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        // DEBUG
       // System.out.println("Message received");
        // Know it will be on the server so make it thread-safe


        Entity theEntity = player.world.getEntityByID(this.entityId);
        // DEBUG
       // System.out.println("Entity = " + theEntity);

        // Need to ensure that hackers can't cause trick kills,
        // so double check weapon type and reach
        if (ItemStack.areItemStacksEqual(player.getHeldItemMainhand(), ItemStack.EMPTY)) {
            return;
        }
        if (player.getHeldItemMainhand().getItem() instanceof IExtendedReach) {
            IExtendedReach theExtendedReachWeapon = (IExtendedReach) player.getHeldItemMainhand().getItem();
            double distanceSq = player.getDistanceSq(theEntity);
            double reachSq = theExtendedReachWeapon.getReach() * theExtendedReachWeapon.getReach();
            if (reachSq >= distanceSq) {
                player.attackTargetEntityWithCurrentItem(theEntity);
            }
        }
    }

}





