package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.client.model.ModelPortal;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.lib.Reference;

/**
 * Created by NStel on 11/14/2017.
 */
public class RenderPortal  extends Render implements IRenderFactory<EntityOrgPortal>
{

    ModelBase model;

    public RenderPortal (RenderManager renderManager) {
        super(renderManager);

        this.model = new ModelPortal();
    }

    @Override
    protected ResourceLocation getEntityTexture (Entity entity) {
        return new ResourceLocation(Reference.MODID, "textures/blocks/models/portal.png");
    }

    @Override
    public void doRender (Entity entity, double x, double y, double z, float yaw, float pitch) {
        GL11.glPushMatrix();
        {
	        GL11.glTranslated(x, y+1, z);
	        
	        float ticks = entity.ticksExisted;
	        if(ticks < 10) //Growing
	        	GL11.glScalef(ticks*0.2f, ticks*0.2f, ticks*0.2f);
	        else if(ticks > 90) //Disappearing
	        	GL11.glScalef((100-ticks)*0.2f, (100-ticks)*0.2f, (100-ticks)*0.2f);
	        else //Static size
	        	GL11.glScalef(2.0f, 2.0f, 2.0f);
	        
	        GL11.glRotatef(-Minecraft.getMinecraft().player.getPitchYaw().y, 0, 1, 0);
	
	        bindEntityTexture(entity);
	
	        this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        }
        GL11.glPopMatrix();
    }

    @Override
    public Render<? super EntityOrgPortal> createRenderFor (RenderManager manager) {
        return new RenderPortal(manager);
    }


}
