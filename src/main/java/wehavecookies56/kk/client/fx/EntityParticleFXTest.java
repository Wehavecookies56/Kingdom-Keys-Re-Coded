package wehavecookies56.kk.client.fx;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.lib.Reference;

public class EntityParticleFXTest extends EntityFX {

	ResourceLocation texture;
	
	public EntityParticleFXTest (ResourceLocation texture, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		this.texture = texture;
		double newrand = (float) Math.random();
		setGravity(.005F);
		setScale(2F);
		setMaxAge(5);
		setRBGColorF(0x255, 0x0, 0x0);
	}
	
	@Override
	public void onUpdate () {
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }
        //this.particleScale = rand.nextFloat();

        this.motionY = 0;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;

        if (this.onGround) {
            this.motionX = 0;
            this.motionZ = 0;
        }
	}
	
	@Override
	public void renderParticle (WorldRenderer worldRenderer, Entity entityIn, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		Tessellator tess = Tessellator.getInstance();
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
		float scale = 0.1F*particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		worldRenderer.pos(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale).tex(0, 0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
		worldRenderer.pos(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale).tex(1, 0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
		worldRenderer.pos(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale).tex(1, 1).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
		worldRenderer.pos(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale).tex(0, 1).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
		tess.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}
	
	public EntityParticleFXTest setMaxAge(int maxAge){
		particleMaxAge = maxAge;
		return this;
	}
	
	public EntityParticleFXTest setGravity(float gravity){
		particleGravity = gravity;
		return this;
	}
	
	public EntityParticleFXTest setScale(float scale){
		particleScale = scale;
		return this;
	}
	
	@Override
	public int getFXLayer () {
		return 3;
	}

}
