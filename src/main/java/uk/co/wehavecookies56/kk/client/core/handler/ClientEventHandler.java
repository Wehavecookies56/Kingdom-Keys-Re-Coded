package uk.co.wehavecookies56.kk.client.core.handler;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Bars;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;

import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.MessageExtendedReachAttackPacket;
import uk.co.wehavecookies56.kk.common.util.IExtendedReach;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.WorldSavedDataKingdomKeys;

import java.util.List;

@SideOnly(Side.CLIENT)
public class ClientEventHandler {

    private Minecraft mc = Minecraft.getMinecraft();
    private MusicHandler musicHandler = new MusicHandler(mc);
    int ticks = 0;

    @SubscribeEvent
    public void debugInfo(RenderGameOverlayEvent.Text event) {
        String modName = "[" + TextFormatting.GOLD + Reference.MODNAME + TextFormatting.RESET + "] ";
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            if (musicHandler.isPlaying()) {
                event.getLeft().add(modName + "Current music: " + musicHandler.getCurrentlyPlaying());
            }
            if (musicHandler.getCurrentlyPlaying() == null) {
                String time = String.format("%.02f", (float) musicHandler.getTimeUntilNextMusic() / 20F);
                event.getLeft().add(modName + "Next music in: " + time + "s");
            }
            boolean combat = EntityEvents.isHostiles || EntityEvents.isBoss;
            boolean cheatMode = (mc.player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode());
            boolean spawnHeartless = WorldSavedDataKingdomKeys.get(mc.world).spawnHeartless;

            TextFormatting colour = TextFormatting.RED;
            if (combat)
                colour = TextFormatting.GREEN;
            event.getLeft().add(modName + "In combat: " + colour + combat);
            colour = TextFormatting.RED;
            if (cheatMode)
                colour = TextFormatting.GREEN;
            event.getLeft().add(modName + "Cheatmode?: " + colour + cheatMode);
            colour = TextFormatting.RED;
            if (spawnHeartless)
                colour = TextFormatting.GREEN;
            event.getLeft().add(modName + "Spawn heartless?: " + colour + spawnHeartless);
            if (!mc.player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName().equals("none")) {
                event.getLeft().add(modName + "Drive form: " + mc.player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName());
            }
            if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE) {
                event.getLeft().add(modName + "Org member: " + mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember());
                boolean orgWeaponSummonedMainHand = mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).summonedWeapon(EnumHand.MAIN_HAND);
                colour = TextFormatting.RED;
                if (orgWeaponSummonedMainHand)
                    colour = TextFormatting.GREEN;
                event.getLeft().add(modName + "Main hand weapon summoned?: " + colour + orgWeaponSummonedMainHand);
                boolean orgWeaponSummonedOffHand = mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).summonedWeapon(EnumHand.OFF_HAND);
                colour = TextFormatting.RED;
                if (orgWeaponSummonedOffHand)
                    colour = TextFormatting.GREEN;
                event.getLeft().add(modName + "Off hand weapon summoned?: " + colour + orgWeaponSummonedOffHand);
            } else {
                colour = TextFormatting.RED;
                boolean mainHandKeybladeSummoned = mc.player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned(EnumHand.MAIN_HAND);
                if (mainHandKeybladeSummoned)
                    colour = TextFormatting.GREEN;
                event.getLeft().add(modName + "Main hand keyblade summoned?: " + colour + mainHandKeybladeSummoned);
                boolean offHandKeybladeSummoned = mc.player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned(EnumHand.OFF_HAND);
                colour = TextFormatting.RED;
                if (offHandKeybladeSummoned)
                    colour = TextFormatting.GREEN;
                event.getLeft().add(modName + "Off hand keyblade summoned?: " + colour + offHandKeybladeSummoned);
            }
        }
    }
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        TickEvent.Phase phase = event.phase;
        TickEvent.Type type = event.type;
        if (phase == TickEvent.Phase.END) {
            if (type.equals(TickEvent.Type.CLIENT)) {
            	if (!mc.isGamePaused() && MainConfig.client.sound.EnableCustomMusic) {
                    musicHandler.update();
                    if (mc.currentScreen instanceof GuiMenu_Bars) {
                        float lowerVolume = Math.max(0, mc.gameSettings.getSoundLevel(SoundCategory.MASTER)-0.2F);
                        mc.getSoundHandler().setSoundLevel(SoundCategory.MASTER, lowerVolume);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void musicControl(PlaySoundEvent event) {
        ISound sound = event.getSound();
        SoundCategory category = sound.getCategory();
        if (category == SoundCategory.MUSIC) {
            if (!sound.getSoundLocation().toString().contains("kk") && MainConfig.client.sound.EnableCustomMusic) {
                event.setResultSound(null);
                return;
            }
            if (!sound.getSoundLocation().toString().contains("kk") && this.musicHandler.isPlaying() && MainConfig.client.sound.EnableCustomMusic) {
                event.setResultSound(null);
                return;
            } else {
                if (MainConfig.client.sound.EnableCustomMusic) {
                    musicHandler.stopSound(sound);
                }
            }
        } else if (category == SoundCategory.RECORDS) {
            this.musicHandler.stopMusic();
            this.mc.getSoundHandler().stopSounds();
            return;
        }
    }

    //long lastAlarmStart;
    @SubscribeEvent
    public void renderTick(TickEvent.RenderTickEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        if (InputHandler.lockOn != null && player != null) {
            if(InputHandler.lockOn.isDead) {
                InputHandler.lockOn = null;
                return;
            }
            EntityLivingBase target = InputHandler.lockOn;

            double dx = player.posX - target.posX;
            double dz = player.posZ - target.posZ;
           // double dy = player.posY - (target.posY - (target.height / 2.0F));
            double dy = player.posY - (target.posY + (target.height / 2.0F)-player.height);
            double angle = Math.atan2(dz, dx) * 180 / Math.PI;
            double pitch = Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * 180 / Math.PI;
            double distance = player.getDistanceToEntity(target);
            float rYaw = (float) (angle - player.rotationYaw);
            while (rYaw > 180) {
                rYaw -= 360;
            }
            while (rYaw < -180) {
                rYaw += 360;
            }
            rYaw += 90F;
            float rPitch = (float) pitch - (float) (10.0F / Math.sqrt(distance)) + (float) (distance * Math.PI / 90);
            //System.out.println(target.height + (target.height / 2.0F));
            player.turn(rYaw, -(rPitch - player.rotationPitch));
        }
    }

    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(MouseEvent event)
    {
        if (event.getButton() == 0 && event.isButtonstate())
        {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer thePlayer = mc.player;
            if (thePlayer != null)
            {
                ItemStack itemstack = thePlayer.getHeldItemMainhand();
                IExtendedReach ieri;
                if (itemstack != null)
                {
                    if (itemstack.getItem() instanceof IExtendedReach)
                    {
                        ieri = (IExtendedReach) itemstack.getItem();
                    } else
                    {
                        ieri = null;
                    }

                    if (ieri != null)
                    {
                        float reach = ieri.getReach();
                        RayTraceResult mov = getMouseOverExtended(reach);

                        if (mov != null)
                        {
                            if (mov.entityHit != null && mov.entityHit.hurtResistantTime == 0)
                            {
                                if (mov.entityHit != thePlayer )
                                {
                                    PacketDispatcher.sendToServer(new MessageExtendedReachAttackPacket(
                                            mov.entityHit.getEntityId()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // This is mostly copied from the EntityRenderer#getMouseOver() method
    public static RayTraceResult getMouseOverExtended(float dist)
    {
        Minecraft mc = FMLClientHandler.instance().getClient();
        Entity theRenderViewEntity = mc.getRenderViewEntity();
        AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
                theRenderViewEntity.posX-0.5D,
                theRenderViewEntity.posY-0.0D,
                theRenderViewEntity.posZ-0.5D,
                theRenderViewEntity.posX+0.5D,
                theRenderViewEntity.posY+1.5D,
                theRenderViewEntity.posZ+0.5D
        );
        RayTraceResult returnMOP = null;
        if (mc.world != null)
        {
            double var2 = dist;
            returnMOP = theRenderViewEntity.rayTrace(var2, 0);
            double calcdist = var2;
            Vec3d pos = theRenderViewEntity.getPositionEyes(0);
            var2 = calcdist;
            if (returnMOP != null)
            {
                calcdist = returnMOP.hitVec.distanceTo(pos);
            }

            Vec3d lookvec = theRenderViewEntity.getLook(0);
            Vec3d var8 = pos.addVector(lookvec.x * var2,
                    lookvec.y * var2,
                    lookvec.z * var2);
            Entity pointedEntity = null;
            float var9 = 1.0F;
            @SuppressWarnings("unchecked")
            List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(
                    theRenderViewEntity,
                    theViewBoundingBox.expand(
                            lookvec.x * var2,
                            lookvec.y * var2,
                            lookvec.z * var2).expand(var9, var9, var9));
            double d = calcdist;

            for (Entity entity : list)
            {
                if (entity.canBeCollidedWith())
                {
                    float bordersize = entity.getCollisionBorderSize();
                    AxisAlignedBB aabb = new AxisAlignedBB(
                            entity.posX-entity.width/2,
                            entity.posY,
                            entity.posZ-entity.width/2,
                            entity.posX+entity.width/2,
                            entity.posY+entity.height,
                            entity.posZ+entity.width/2);
                    aabb.expand(bordersize, bordersize, bordersize);
                    RayTraceResult rTR0 = aabb.calculateIntercept(pos, var8);

                    if (aabb.contains(pos))
                    {
                        if (0.0D < d || d == 0.0D)
                        {
                            pointedEntity = entity;
                            d = 0.0D;
                        }
                    } else if (rTR0 != null)
                    {
                        double d1 = pos.distanceTo(rTR0.hitVec);

                        if (d1 < d || d == 0.0D)
                        {
                            pointedEntity = entity;
                            d = d1;
                        }
                    }
                }
            }

            if (pointedEntity != null && (d < calcdist || returnMOP == null))
            {
                returnMOP = new RayTraceResult(pointedEntity);
            }
        }
        return returnMOP;
    }
}