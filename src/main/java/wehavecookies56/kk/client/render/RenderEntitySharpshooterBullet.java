package wehavecookies56.kk.client.render;

import java.io.IOException;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.b3d.B3DLoader;
import wehavecookies56.kk.entities.projectiles.EntitySharpshooterBullet;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;

public class RenderEntitySharpshooterBullet extends Render<EntitySharpshooterBullet> {

	public ModelResourceLocation model = new ModelResourceLocation(Reference.MODID + ":models/item/" + Strings.EternalFlames + ".b3d", "inventory");
	public ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/items/models/" + Strings.EternalFlames + ".png");

	public RenderEntitySharpshooterBullet (RenderManager renderManager) {
		super(renderManager);
	}

	Function<ResourceLocation, TextureAtlasSprite> textureGetter = new Function<ResourceLocation, TextureAtlasSprite>() {
		@Override
		public TextureAtlasSprite apply (ResourceLocation location) {
			return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
		}
	};

	@Override
	protected ResourceLocation getEntityTexture (EntitySharpshooterBullet entity) {
		return texture;
	}

	@Override
	public void doRender (EntitySharpshooterBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		if (entity.ticksExisted < 1) return;

		textureGetter.apply(texture);
		bindEntityTexture(entity);

		GL11.glPushMatrix();
		{
			GL11.glTranslatef((float) x, (float) y, (float) z);
			// GL11.glRotatef(entityYaw, 0.0F, 1.0F, -1.0F);
			GL11.glScalef(0.02f, 0.02f, 0.02f);
			// GL11.glRotatef(90F - entity.prevRotationPitch -
			// (entity.rotationPitch - entity.prevRotationPitch) * partialTicks,
			// 1.0F, 0.0F, 0.0F);
			IModel model = null;

			try {
				model = B3DLoader.instance.loadModel(this.model);
			} catch (IOException e) {
				model = ModelLoaderRegistry.getMissingModel();
			}

			IBakedModel bakedModel = model.bake((TRSRTransformation.identity()), Attributes.DEFAULT_BAKED_FORMAT, textureGetter);
			worldRenderer.begin(7, Attributes.DEFAULT_BAKED_FORMAT);

			// Get Quads
			List<BakedQuad> generalQuads = bakedModel.getGeneralQuads();

			for (BakedQuad q : generalQuads) {
				int[] vd = q.getVertexData();
				worldRenderer.addVertexData(vd);
			}

			for (EnumFacing face : EnumFacing.values()) {
				List<BakedQuad> faceQuads = bakedModel.getFaceQuads(face);
				for (BakedQuad q : faceQuads) {
					int[] vd = q.getVertexData();
					worldRenderer.addVertexData(vd);
				}
			}
			tessellator.draw();
		}
		GL11.glPopMatrix();
	}

}
