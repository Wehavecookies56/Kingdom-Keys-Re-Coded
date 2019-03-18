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
    public ModelRenderer rightCube;
    public ModelRenderer leftCube;
    public ModelRenderer cabinBottom;
    public ModelRenderer rightThruster;
    public ModelRenderer leftThruster;
    public ModelRenderer rightCannon1;
    public ModelRenderer rightCannon2;
    public ModelRenderer rightCannonTip1;
    public ModelRenderer rightCannonTip2;
    public ModelRenderer leftCannon1;
    public ModelRenderer leftCannon2;
    public ModelRenderer leftCannonTip1;
    public ModelRenderer leftCannonTip2;

    public ModelGummiShip() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rightThruster = new ModelRenderer(this, 26, 20);
        this.rightThruster.setRotationPoint(-2.0F, 4.0F, 0.5F);
        this.rightThruster.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
        this.leftThruster = new ModelRenderer(this, 26, 20);
        this.leftThruster.setRotationPoint(-2.0F, 4.0F, -4.4F);
        this.leftThruster.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
        this.rightCannonTip2 = new ModelRenderer(this, 36, 28);
        this.rightCannonTip2.setRotationPoint(9.2F, 5.0F, -9.0F);
        this.rightCannonTip2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.leftCube = new ModelRenderer(this, 40, 10);
        this.leftCube.setRotationPoint(-3.0F, 4.0F, 5.0F);
        this.leftCube.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.leftCannonTip2 = new ModelRenderer(this, 36, 28);
        this.leftCannonTip2.setRotationPoint(9.0F, 5.0F, 5.0F);
        this.leftCannonTip2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.peak = new ModelRenderer(this, 0, 28);
        this.peak.setRotationPoint(13.0F, 4.0F, -2.0F);
        this.peak.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(peak, 0.7853981633974483F, 0.0F, 0.0F);
        this.leftCannonTip1 = new ModelRenderer(this, 36, 28);
        this.leftCannonTip1.setRotationPoint(9.0F, 4.0F, 6.0F);
        this.leftCannonTip1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.rightCannon2 = new ModelRenderer(this, 12, 28);
        this.rightCannon2.setRotationPoint(1.2F, 5.0F, -9.0F);
        this.rightCannon2.addBox(0.0F, 0.0F, 0.0F, 8, 2, 4, 0.0F);
        this.rightCannon1 = new ModelRenderer(this, 12, 28);
        this.rightCannon1.setRotationPoint(1.2F, 4.0F, -8.0F);
        this.rightCannon1.addBox(0.0F, 0.0F, 0.0F, 8, 4, 2, 0.0F);
        this.leftCannon1 = new ModelRenderer(this, 12, 28);
        this.leftCannon1.setRotationPoint(1.0F, 4.0F, 6.0F);
        this.leftCannon1.addBox(0.0F, 0.0F, 0.0F, 8, 4, 2, 0.0F);
        this.cabin = new ModelRenderer(this, 0, 0);
        this.cabin.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.cabin.addBox(-5.0F, 0.0F, -5.0F, 8, 4, 10, 0.0F);
        this.glass = new ModelRenderer(this, 30, 0);
        this.glass.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.glass.addBox(-3.0F, -3.0F, -3.0F, 6, 3, 6, 0.0F);
        this.rightCube = new ModelRenderer(this, 40, 10);
        this.rightCube.setRotationPoint(-3.0F, 4.0F, -9.0F);
        this.rightCube.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.rightCannonTip1 = new ModelRenderer(this, 36, 28);
        this.rightCannonTip1.setRotationPoint(9.2F, 4.0F, -8.0F);
        this.rightCannonTip1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.leftCannon2 = new ModelRenderer(this, 12, 28);
        this.leftCannon2.setRotationPoint(1.0F, 5.0F, 5.0F);
        this.leftCannon2.addBox(0.0F, 0.0F, 0.0F, 8, 2, 4, 0.0F);
        this.tube = new ModelRenderer(this, 0, 18);
        this.tube.setRotationPoint(5.0F, 4.0F, -3.5F);
        this.tube.addBox(0.0F, 0.0F, 0.0F, 8, 5, 5, 0.0F);
        this.setRotateAngle(tube, 0.7853981633974483F, 0.0F, 0.0F);
        this.cabinBottom = new ModelRenderer(this, 0, 0);
        this.cabinBottom.setRotationPoint(1.0F, 3.0F, -5.0F);
        this.cabinBottom.addBox(0.0F, 0.0F, 0.0F, 4, 5, 10, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rightThruster.render(f5);
        this.leftThruster.render(f5);
        this.rightCannonTip2.render(f5);
        this.leftCube.render(f5);
        this.leftCannonTip2.render(f5);
        this.peak.render(f5);
        this.leftCannonTip1.render(f5);
        this.rightCannon2.render(f5);
        this.rightCannon1.render(f5);
        this.leftCannon1.render(f5);
        this.cabin.render(f5);
        this.glass.render(f5);
        this.rightCube.render(f5);
        this.rightCannonTip1.render(f5);
        this.leftCannon2.render(f5);
        this.tube.render(f5);
        this.cabinBottom.render(f5);
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
