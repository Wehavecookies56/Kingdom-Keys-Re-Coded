package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.client.model.ModelGummiShip;
import uk.co.wehavecookies56.kk.common.entity.EntityGummiShip;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class RenderEntityGummiShip extends Render implements IRenderFactory<EntityGummiShip> {

	ModelBase model;

	public RenderEntityGummiShip(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 1;
		this.model = new ModelGummiShip();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(Reference.MODID, "textures/items/models/gummiship.png");
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		{
			GL11.glTranslated(x, y + 1.5, z);
			GL11.glRotatef(90, 0.0F, 1.0F, 0F);
			GL11.glRotated(-entity.rotationYaw, 0, 1, 0);
			float f2 = pitch;
			float f3 = pitch;

			float f4 = 0.5F;
			// GL11.glScalef(0.02f, 0.02f, 0.02f);

			// GL11.glRotatef(yaw * 100, 1, 0, 0);

			bindEntityTexture(entity);

			GL11.glScalef(-3.0F, -3.0F, 3.0F);

			System.out.println(entity.getEntityData());
			NBTTagCompound nbt = entity.getEntityData() == null ? entity.getEntityData() : null;
			
			if (nbt == null) {
				if ((Minecraft.getMinecraft().player.isRidingSameEntity(entity) && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) { // Made so ship is not rendered if player is riding it
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
					this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
					GL11.glDisable(GL11.GL_BLEND);
				} else {
					this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
				}
			} else {
				if (nbt.hasKey("rep")) {
					if ((Minecraft.getMinecraft().player.isRidingSameEntity(entity) && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) { // Made so ship is not rendered if player is riding it
						GL11.glEnable(GL11.GL_BLEND);
						GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
						for (int i = 0; i < nbt.getInteger("rep"); i++) {
							GL11.glTranslated(0, i, 0);
							this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
						}
						GL11.glDisable(GL11.GL_BLEND);
					} else {
						this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
					}
				}
			}
		}
		GL11.glPopMatrix();

	}

	@Override
	public Render<? super EntityGummiShip> createRenderFor(RenderManager manager) {
		return new RenderEntityGummiShip(manager);
	}
}
