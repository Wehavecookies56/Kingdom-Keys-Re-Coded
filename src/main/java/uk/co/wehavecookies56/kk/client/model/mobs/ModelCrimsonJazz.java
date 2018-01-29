package uk.co.wehavecookies56.kk.client.model.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelRedNocturne - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCrimsonJazz extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer Antenna05;
    public ModelRenderer Antenna04;
    public ModelRenderer Antenna03;
    public ModelRenderer Antenna02;
    public ModelRenderer Antenna01;
    public ModelRenderer UpperBody;
    public ModelRenderer MidBody;
    public ModelRenderer LowerBody;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Helmet06;
    public ModelRenderer Helmet05;
    public ModelRenderer Helmet04;
    public ModelRenderer Helmet03;
    public ModelRenderer Helmet02;
    public ModelRenderer Helmet01;

    public ModelCrimsonJazz() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LowerBody = new ModelRenderer(this, 32, 26);
        this.LowerBody.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.LowerBody.addBox(-4.0F, 0.0F, -4.0F, 8, 3, 8, 0.0F);
        this.Head = new ModelRenderer(this, 2, 1);
        this.Head.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Head.addBox(-2.5F, -8.0F, -2.5F, 5, 4, 5, 0.0F);
        this.Antenna01 = new ModelRenderer(this, 56, 15);
        this.Antenna01.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Antenna01.addBox(-0.5F, -15.0F, -0.5F, 1, 4, 1, 0.0F);
        this.Antenna05 = new ModelRenderer(this, 30, 18);
        this.Antenna05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Antenna05.addBox(-12.8F, -11.23F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Antenna05, 0.0F, 0.0F, 0.7853981633974483F);
        this.UpperBody = new ModelRenderer(this, 0, 13);
        this.UpperBody.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.UpperBody.addBox(-3.0F, -4.0F, -3.0F, 6, 2, 6, 0.0F);
        this.Helmet06 = new ModelRenderer(this, 29, 10);
        this.Helmet06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet06.addBox(-2.5F, -11.0F, -2.5F, 5, 1, 5, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 32, 0);
        this.LeftLeg.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.LeftLeg.addBox(1.5F, 3.0F, 0.0F, 1, 2, 0, 0.0F);
        this.Helmet05 = new ModelRenderer(this, 34, -3);
        this.Helmet05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet05.addBox(-3.0F, -10.0F, -3.0F, 6, 2, 6, 0.0F);
        this.Helmet03 = new ModelRenderer(this, 0, 45);
        this.Helmet03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet03.addBox(-3.0F, -6.0F, 3.0F, 6, 3, 0, 0.0F);
        this.RightLeg = new ModelRenderer(this, 30, 0);
        this.RightLeg.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.RightLeg.addBox(-2.5F, 3.0F, 0.0F, 1, 2, 0, 0.0F);
        this.Antenna02 = new ModelRenderer(this, 48, 18);
        this.Antenna02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Antenna02.addBox(10.1F, -10.9F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(Antenna02, 0.0F, 0.0F, -0.7853981633974483F);
        this.Helmet02 = new ModelRenderer(this, 0, 33);
        this.Helmet02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet02.addBox(3.0F, -6.0F, -3.0F, 0, 3, 6, 0.0F);
        this.Antenna04 = new ModelRenderer(this, 34, 18);
        this.Antenna04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Antenna04.addBox(10.1F, -13.7F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(Antenna04, 0.0F, 0.0F, -0.7853981633974483F);
        this.Helmet04 = new ModelRenderer(this, 14, 39);
        this.Helmet04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet04.addBox(-3.0F, -6.0F, -3.0F, 0, 3, 6, 0.0F);
        this.Antenna03 = new ModelRenderer(this, 42, 18);
        this.Antenna03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Antenna03.addBox(-12.67F, -13.2F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Antenna03, 0.0F, 0.0F, 0.7853981633974483F);
        this.Helmet01 = new ModelRenderer(this, 14, 39);
        this.Helmet01.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Helmet01.addBox(-3.0F, -6.0F, -3.0F, 6, 3, 0, 0.0F);
        this.MidBody = new ModelRenderer(this, 0, 23);
        this.MidBody.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.MidBody.addBox(-3.5F, -2.0F, -3.5F, 7, 2, 7, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LowerBody.render(f5);
        this.Head.render(f5);
        this.Antenna01.render(f5);
        this.Antenna05.render(f5);
        this.UpperBody.render(f5);
        this.Helmet06.render(f5);
        this.LeftLeg.render(f5);
        this.Helmet05.render(f5);
        this.Helmet03.render(f5);
        this.RightLeg.render(f5);
        this.Antenna02.render(f5);
        this.Helmet02.render(f5);
        this.Antenna04.render(f5);
        this.Helmet04.render(f5);
        this.Antenna03.render(f5);
        this.Helmet01.render(f5);
        this.MidBody.render(f5);
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
