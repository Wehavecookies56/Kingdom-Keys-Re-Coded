package uk.co.wehavecookies56.kk.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.client.core.helper.ModelHelper;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.HashMap;

/**
 * Created by NStel on 11/14/2017.
 */
public class ModelPortal extends ModelBase
{
    OBJModel model;
    HashMap<String, IBakedModel> modelParts;

    public ModelPortal() {
        try {
            model = (OBJModel) OBJLoader.INSTANCE.loadModel(new ResourceLocation("kk:models/block/portal.obj"));
            modelParts = ModelHelper.getModelsForGroups(model);
        } catch (Exception e) {
            e.printStackTrace();
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

}
