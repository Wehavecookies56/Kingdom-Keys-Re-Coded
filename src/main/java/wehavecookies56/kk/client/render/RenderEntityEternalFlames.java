package wehavecookies56.kk.client.render;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.obj.OBJModel;
import wehavecookies56.kk.entities.projectiles.EntityEternalFlames;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;

public class RenderEntityEternalFlames extends Render<EntityEternalFlames> {
	
	ModelBase model;
	
	public RenderEntityEternalFlames(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 1;
		this.model = new ModelEternalFlames();
	}

	public static Function<ResourceLocation, TextureAtlasSprite> textureGetter = new Function<ResourceLocation, TextureAtlasSprite>() {
		public TextureAtlasSprite apply(ResourceLocation location) {
			return DummyAtlasTextureNormal.instance;
		}
	};
	
	public static Function<ResourceLocation, TextureAtlasSprite> textureGetterFlipV = new Function<ResourceLocation, TextureAtlasSprite>() {
		public TextureAtlasSprite apply(ResourceLocation location) {
			return DummyAtlasTextureFlipV.instance;
		}
	};
	
	private static class DummyAtlasTextureNormal extends TextureAtlasSprite {
		public static DummyAtlasTextureNormal instance = new DummyAtlasTextureNormal();

		protected DummyAtlasTextureNormal() {
			super("dummy");
		}

		@Override
		public float getInterpolatedU(double u) {
			return (float) u / 16;
		}

		@Override
		public float getInterpolatedV(double v) {
			return (float) v / 16;
		}
	}
	
	private static class DummyAtlasTextureFlipV extends TextureAtlasSprite {
		public static DummyAtlasTextureFlipV instance = new DummyAtlasTextureFlipV();

		protected DummyAtlasTextureFlipV() {
			super("dummyFlipV");
		}

		@Override
		public float getInterpolatedU(double u) {
			return (float) u / 16;
		}

		@Override
		public float getInterpolatedV(double v) {
			return (float) v / -16;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEternalFlames entity) {
		return new ResourceLocation(Reference.MODID, "textures/items/models/" + Strings.EternalFlames + ".png");
	}

	@Override
	public void doRender(EntityEternalFlames entity, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		float f2 = pitch;
		float f3 = pitch;

		float f4 = 0.5F;
		GL11.glScalef(0.02f, 0.02f, 0.02f);
		
		GL11.glRotatef(yaw * 100, 0, 0, 1);
		
		this.bindEntityTexture(entity);

		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);


		GL11.glPopMatrix();
	}
	
	public static HashMap<String, IFlexibleBakedModel> getModelsForGroups(OBJModel objModel) {

		HashMap<String, IFlexibleBakedModel> modelParts = new HashMap<String, IFlexibleBakedModel>();

		if (!objModel.getMatLib().getGroups().keySet().isEmpty()) {
			for (String key : objModel.getMatLib().getGroups().keySet()) {
				String k = key;
				if (!modelParts.containsKey(key)) {
					modelParts.put(k, objModel.bake(new OBJModel.OBJState(ImmutableList.of(k), false), Attributes.DEFAULT_BAKED_FORMAT, textureGetterFlipV));

				}
			}
		}

		modelParts.put("ALL", objModel.bake(objModel.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT, textureGetterFlipV));

		return modelParts;
	}
	
	public static void renderBakedModel(IFlexibleBakedModel bakedModel) {
		Tessellator tessellator = Tessellator.getInstance();

		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.func_181668_a(GL11.GL_QUADS, bakedModel.getFormat());
		for (BakedQuad bakedQuad : bakedModel.getGeneralQuads()) {
			worldrenderer.addVertexData(bakedQuad.getVertexData());
		}

		tessellator.draw();
	}

}
