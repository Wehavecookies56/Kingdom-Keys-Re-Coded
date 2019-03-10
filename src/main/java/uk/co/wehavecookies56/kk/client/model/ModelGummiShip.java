package uk.co.wehavecookies56.kk.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;

public class ModelGummiShip extends ModelBase {
    public ModelRenderer cabin;
    public ModelRenderer glass;
    public ModelRenderer tube;
    public ModelRenderer peak;

    public ModelGummiShip() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tube = new ModelRenderer(this, 0, 18);
        this.tube.setRotationPoint(5.0F, 4.0F, -3.5F);
        this.tube.addBox(0.0F, 0.0F, 0.0F, 8, 5, 5, 0.0F);
        this.setRotateAngle(tube, 0.7853981633974483F, 0.0F, 0.0F);
        this.cabin = new ModelRenderer(this, 0, 0);
        this.cabin.setRotationPoint(-5.0F, 0.0F, -5.0F);
        this.cabin.addBox(0.0F, 0.0F, 0.0F, 10, 8, 10, 0.0F);
        this.glass = new ModelRenderer(this, 30, 0);
        this.glass.setRotationPoint(-3.0F, -3.0F, -3.0F);
        this.glass.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.peak = new ModelRenderer(this, 0, 28);
        this.peak.setRotationPoint(13.0F, 4.0F, -2.0F);
        this.peak.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(peak, 0.7853981633974483F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.tube.render(f5);
        this.cabin.render(f5);
        this.glass.render(f5);
        this.peak.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
