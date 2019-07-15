package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class SpawnOrgWeaponParticles extends AbstractMessage.AbstractClientMessage<SpawnOrgWeaponParticles> {
	static final EnumParticleTypes[] particlesArray = {
			EnumParticleTypes.SUSPENDED_DEPTH,
			EnumParticleTypes.CRIT_MAGIC,
			EnumParticleTypes.EXPLOSION_LARGE,
			EnumParticleTypes.SNOWBALL,
			EnumParticleTypes.FIREWORKS_SPARK,
			EnumParticleTypes.ENCHANTMENT_TABLE,
			EnumParticleTypes.FIREWORKS_SPARK,
			EnumParticleTypes.FLAME,
			EnumParticleTypes.NOTE,
			EnumParticleTypes.FIREWORKS_SPARK,
			EnumParticleTypes.PORTAL,
			EnumParticleTypes.VILLAGER_ANGRY,
			EnumParticleTypes.FIREWORKS_SPARK};
    int entityID;
    int orgNum;
    public SpawnOrgWeaponParticles () {}

    public SpawnOrgWeaponParticles (EntityPlayer entity, int num) {
        this.entityID = entity.getEntityId();
        this.orgNum = num;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        entityID = buffer.readInt();
        orgNum = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(entityID);
        buffer.writeInt(orgNum);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        EntityPlayer summoner = (EntityPlayer) player.world.getEntityByID(entityID);
        if (summoner != null) {
            Vec3d userPos = new Vec3d(summoner.posX, summoner.posY, summoner.posZ);
            Vec3d vCenter = new Vec3d(0.4, -1.3D, -0.38D);
            vCenter = vCenter.rotateYaw((float) Math.toRadians(-summoner.renderYawOffset));
            Vec3d v = userPos.add(-vCenter.x, vCenter.y, -vCenter.z);
            for (int a = 0; a < 300; a++) {
                player.world.spawnParticle(particlesArray[orgNum], v.x, summoner.posY + 1, v.z, Utils.randomWithRange(-0.2, 0.2), Utils.randomWithRange(-0.2, 0.2), Utils.randomWithRange(-0.2, 0.2));
                //player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x, y+1, z,rand.nextDouble()*2-1,rand.nextDouble()*2-1,rand.nextDouble()*2-1);
            }
        }
    }

}
