package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.client.model.ModelFlyingHeart;
import uk.co.wehavecookies56.kk.common.ability.ModAbilities;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.entity.EntityFlyingHeart;
import uk.co.wehavecookies56.kk.common.entity.EntityXPGet;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class RenderXPGet extends Render implements IRenderFactory<EntityFlyingHeart> {

	//ModelBase model;
	float rotation;

	public RenderXPGet(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 1;
		//this.model = new ModelFlyingHeart();
		rotation = 0;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(Reference.MODID, "textures/items/models/flyingheart.png");
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		if (entity instanceof EntityXPGet) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityXPGet eXP = (EntityXPGet) entity;

			GL11.glPushMatrix();
			{
				GL11.glTranslated(x, y + 1, z);
				GL11.glScaled(0.05, 0.05, 0.05);
				GL11.glRotated(180, 0, 1, 0);
				GL11.glRotated(180, 1, 0, 0);
				GL11.glRotatef(mc.player.getPitchYaw().y, 0, 1, 0);
				GL11.glRotatef(-mc.player.getPitchYaw().x, 1, 0, 0);

				String text = "+0xp";
				// System.out.println(eXP);

				if (mc.player.getDisplayNameString().equals(eXP.killerName)) {

					EntityPlayer player = mc.world.getPlayerEntityByName(eXP.killerName);
					if (mc.world.getEntityByID(eXP.entityID) instanceof EntityLivingBase) {
						EntityLivingBase mobEntity = (EntityLivingBase) mc.world.getEntityByID(eXP.entityID);
						IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
						IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
						if (!ABILITIES.getEquippedAbility(ModAbilities.zeroEXP)) {
							if (STATS.getLevel() < STATS.getMaxLevel())
								text = "+" + ((int) (mobEntity.getMaxHealth() / 2)) * MainConfig.entities.xpMultiplier + "xp";
							mc.fontRenderer.drawString(text, -mc.fontRenderer.getStringWidth(text) / 2, 0, 0x0099ff);
						}
					}
				}
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public Render<? super EntityFlyingHeart> createRenderFor(RenderManager manager) {
		return new RenderXPGet(manager);
	}

}
