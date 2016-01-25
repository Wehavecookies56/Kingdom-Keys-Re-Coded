package wehavecookies56.kk.client.render;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;

public class ModelEternalFlames extends ModelBase {

	OBJModel model;
	HashMap<String, IFlexibleBakedModel> modelParts;
	
	public ModelEternalFlames() {
		try {
			model = (OBJModel) OBJLoader.instance.loadModel(new ResourceLocation("kk:models/item/eternalflames.obj"));
			modelParts = RenderEntityEternalFlames.getModelsForGroups(model);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void renderGroupObject(String groupName) {
		RenderEntityEternalFlames.renderBakedModel(modelParts.get(groupName));
	}
	
	@Override
	public void render(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {
		super.render(entity, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale);
		renderGroupObject("ALL");
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}
