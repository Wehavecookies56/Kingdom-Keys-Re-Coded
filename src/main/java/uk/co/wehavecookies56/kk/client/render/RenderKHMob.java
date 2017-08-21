package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderKHMob extends RenderLiving<EntityLiving> implements IRenderFactory<EntityMob>
{

    private float scale;
    private ModelBase model;
    private String texturesSprite;
    private ResourceLocation texture;

    public RenderKHMob(RenderManager mg, ModelBase model, float scale, String staticTexture)
    {
        super(mg, model, scale/2);
        this.model = model;
        this.scale = scale;
        this.texturesSprite = staticTexture;
        this.texture = new ResourceLocation("kk:textures/mobs/" + staticTexture + ".png");
    }
    @Override
    protected void preRenderCallback(EntityLiving  entity, float i)
    {
        if(entity instanceof EntityMob)

        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity)
    {
        return this.texture;
    }

    public Render<? super EntityMob> createRenderFor(RenderManager manager)
    {
        return new RenderKHMob(manager, model, scale, texturesSprite);
    }

}
