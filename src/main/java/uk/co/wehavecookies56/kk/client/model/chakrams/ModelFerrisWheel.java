package uk.co.wehavecookies56.kk.client.model.chakrams;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import uk.co.wehavecookies56.kk.client.core.helper.ModelHelper;

/**
 * Created by NStel on 3/2/2017.
 */
public class ModelFerrisWheel extends ModelBase {
    OBJModel model;
    HashMap<String, IBakedModel> modelParts;

    public ModelFerrisWheel () {
        try {
            model = (OBJModel) OBJLoader.INSTANCE.loadModel(new ResourceLocation("kk:models/item/ferriswheel.obj"));
            modelParts = ModelHelper.getModelsForGroups(model);
        } catch (Exception e) {

        }
    }

    public void renderGroupObject (String groupName) {
        ModelHelper.renderBakedModel(modelParts.get(groupName));
    }

    @Override
    public void render (Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {
        super.render(entity, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale);
        renderGroupObject(ModelHelper.ALL_PARTS);
    }

    private void setRotation (ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles (float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }
}