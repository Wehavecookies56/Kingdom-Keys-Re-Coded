package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import uk.co.wehavecookies56.kk.client.model.ModelMoulinRouge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityMoulinRouge;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

/**
 * Created by NStel on 3/1/2017.
 */
public class RenderEntityMoulinRouge extends Render implements IRenderFactory<EntityMoulinRouge> {

    ModelBase model;

    public RenderEntityMoulinRouge (RenderManager renderManager) {
        super(renderManager);
        shadowSize = 1;
        this.model = new ModelMoulinRouge();
    }

    @Override
    protected ResourceLocation getEntityTexture (Entity entity) {
        return new ResourceLocation(Reference.MODID, "textures/items/models/" + Strings.MoulinRouge + ".png");
    }

    @Override
    public void doRender (Entity entity, double x, double y, double z, float yaw, float pitch) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
        float f2 = pitch;
        float f3 = pitch;

        float f4 = 0.5F;
        GL11.glScalef(0.02f, 0.02f, 0.02f);

        GL11.glRotatef(yaw * 100, 1, 0, 0);

        bindEntityTexture(entity);

        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    public Render<? super EntityMoulinRouge> createRenderFor (RenderManager manager) {
        return new RenderEntityMoulinRouge(manager);
    }

}
