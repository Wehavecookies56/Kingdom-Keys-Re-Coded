package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.entity.mobs.BaseEntityBomb;

public class RenderKHCreeper extends RenderLiving<EntityLiving> implements IRenderFactory<EntityMob>
{

	private float scale;
	private ModelBase model;
	private String texturesSprite;
	private ResourceLocation texture, swordTexture, spearTexture;

	public RenderKHCreeper(RenderManager mg, ModelBase model, float scale)
	{
		super(mg, model, scale / 2);
		this.model = model;
		this.scale = scale;
		this.texture = new ResourceLocation("kk:textures/mobs/creeper.png");
		this.swordTexture = new ResourceLocation("kk:textures/mobs/creepersword.png");
		this.spearTexture = new ResourceLocation("kk:textures/mobs/creeperspear.png");
	}

	@Override
	protected void preRenderCallback(EntityLiving entity, float i)
	{
		if (entity instanceof EntityMob)
			GL11.glScalef(this.scale, this.scale, this.scale);
	}

	protected ResourceLocation getEntityTexture(EntityLiving entity)
	{
		if(EntityHelper.getState(entity) == 0 || EntityHelper.getState(entity) == 3)
			return this.texture;
		else if(EntityHelper.getState(entity) == 1)
			return this.swordTexture;
		else if(EntityHelper.getState(entity) == 2)
			return this.spearTexture;
		
		return texture;
	}

	public Render<? super EntityMob> createRenderFor(RenderManager manager)
	{
		return new RenderKHCreeper(manager, model, scale);
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
}
