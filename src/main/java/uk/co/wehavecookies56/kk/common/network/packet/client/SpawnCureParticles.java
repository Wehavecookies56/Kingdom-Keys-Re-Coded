package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnCureParticles extends AbstractMessage.AbstractClientMessage<SpawnCureParticles> {

    double x, y, z;
    boolean savePoint;
    int lvl;

    public SpawnCureParticles () {}

    public SpawnCureParticles (Entity entity, int level) {
        x = entity.posX;
        y = entity.posY+entity.getEyeHeight();
        z = entity.posZ;
        lvl = level;
    }

    public SpawnCureParticles (BlockPos pos, boolean savepoint) {
        x = pos.getX();
        y = pos.getY();
        z = pos.getZ();
        savePoint = savepoint;

    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
        savePoint = buffer.readBoolean();
        lvl = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
        buffer.writeBoolean(savePoint);
        buffer.writeInt(lvl);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        double r;
        switch (this.lvl) {
            case 1:
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x, this.y + 1.5, this.z, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x, this.y + 1.8, this.z, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x, this.y + 1.2, this.z, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x + 0.3, this.y + 1.5, this.z, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x - 0.3, this.y + 1.5, this.z, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x, this.y + 1.5, this.z+0.3, 0.0D, 1.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.x, this.y + 1.5, this.z-0.3, 0.0D, 1.0D, 0.0D);
                break;
        }

        if (savePoint) {
            r = 0.6D;
            x = x + 0.6;
            z = z + 0.6;
            for (int a = 1; a <= 360; a += 7) {
                double x = this.x-0.1 + (r * Math.cos(Math.toRadians(a)));
                double z = this.z-0.1 + (r * Math.sin(Math.toRadians(a)));

                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, this.y + 1.5D, z, 0.0D, 0.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, this.y + 1.05D, z, 0.0D, 0.0D, 0.0D);
                player.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, this.y + 0.5D, z, 0.0D, 0.0D, 0.0D);

            }
        }
    }

}
