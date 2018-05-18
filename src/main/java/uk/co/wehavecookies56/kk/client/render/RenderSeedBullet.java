package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.model.ModelCube;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySeedBullet;

@SideOnly(Side.CLIENT)
public class RenderSeedBullet extends Render implements IRenderFactory<EntitySeedBullet>
{

	private ModelCube model;
	private double red, blue, green, alpha;
	
	public RenderSeedBullet(RenderManager render)
	{
		super(render);
		this.red = 96;
		this.green = 140;
		this.blue = 109;
		this.alpha = 255;
    	this.model = new ModelCube();
	}

	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glPushMatrix();
		
    	GL11.glTranslatef((float)par2, (float)par4, (float)par6);
    	GL11.glDisable(GL11.GL_TEXTURE_2D);
    	//GL11.glEnable(GL11.GL_BLEND);
    	//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA); 
		
    	GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
    	GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
    	
    	GL11.glColor4f((float)this.red/255, (float)this.green/255, (float)this.blue/255, (float)this.alpha/255);
    	GL11.glScaled(1, 0.5, 0.5);
    	
		this.model.render(entity, (float)par2, (float)par4, (float)par6, 0.0F, 0.0F, 0.0625F);
		
    	//GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glPopMatrix();
	}
	
	public Render<? super EntitySeedBullet> createRenderFor(RenderManager manager)
	{
		return new RenderSeedBullet(manager);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}

}
