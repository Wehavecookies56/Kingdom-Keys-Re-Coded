package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

/**
 * Created by Toby on 22/05/2016.
 */
public class LayerRendererDrive extends LayerBipedArmor {

    private RenderPlayer renderPlayer;

    public LayerRendererDrive(RenderLivingBase<?> rendererIn) {
        super(rendererIn);
        this.renderPlayer = (RenderPlayer) rendererIn;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Valor.png");
        String drive = entitylivingbaseIn.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName();
        switch (drive) {
            case Strings.Form_Valor:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Valor.png");
                break;
            case Strings.Form_Wisdom:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Wisdom.png");
                break;
            case Strings.Form_Limit:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Limit.png");
                break;
            case Strings.Form_Master:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Master.png");
                break;
            case Strings.Form_Final:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Final.png");
                break;
            case Strings.Form_Anti:
                texture = new ResourceLocation(Reference.MODID, "textures/armour/Anti.png");
                break;
        }
        if (entitylivingbaseIn.getCapability(ModCapabilities.DRIVE_STATE, null).getInDrive()) {
            ModelPlayer model = renderPlayer.getMainModel();
            model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
            if (model.isSneak) {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }
            renderPlayer.bindTexture(texture);
            if (drive.equals(Strings.Form_Anti)) {
                GlStateManager.color(1, 1, 1,0.95f);
                GlStateManager.enableBlend();
                model.bipedHeadwear.render(scale);
            }
            model.bipedBodyWear.render(scale);
            model.bipedLeftArmwear.render(scale);
            model.bipedRightArmwear.render(scale);
            model.bipedLeftLegwear.render(scale);
            model.bipedRightLegwear.render(scale);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
