package uk.co.wehavecookies56.kk.client.model.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;

public class ModelShadow extends ModelBase
{
    ModelRenderer UpperBody;
    ModelRenderer LowerBody;
    ModelRenderer LowerHead;
    ModelRenderer Head;
    ModelRenderer LegLeft1;
    ModelRenderer LegLeft3;
    ModelRenderer LegLeft2;
    ModelRenderer LegRight1;
    ModelRenderer LegRight3;
    ModelRenderer LegRight2;
    ModelRenderer ArmLeft1;
    ModelRenderer ArmLeft2;
    ModelRenderer ArmRight1;
    ModelRenderer ArmRight2;
    ModelRenderer AntenaLeft1;
    ModelRenderer AntenaLeft2;
    ModelRenderer AntenaRight1;
    ModelRenderer AntenaRight2;

    // Default variables for every model
    protected double distanceMovedTotal = 0.0D; 
    protected double CYCLES_PER_BLOCK; 
    protected int cycleIndex = 0;
    private int[][] ticksForWalkingAnimation = new int[][]
    {
        {0, -90}, {100, 2}, {51, -51}
    };
    
    // Walking animation
    protected double[][] animationWalk = new double[][]
    {  
        { 0        , 100    , 51    , -90    , 2        , -46},
        { -40    , 51    , 0        , -40    , 51    , 0},
        { -90    , 2        , -46    , 0        , 100    , 51},
        { -90    , 2        , -46    , 0        , 100    , 51},
        { -40    , 51    , 0        , -40    , 51    , 0},
        { 0        , 100    , -51    , -90    , 2        , -46},
    };

    public ModelShadow(double cycles){
    	this.CYCLES_PER_BLOCK = cycles;
        textureWidth = 32;
        textureHeight = 32;

        UpperBody = new ModelRenderer(this, 0, 0);
        UpperBody.addBox(-1.5F, -4.5F, -1.8F, 3, 5, 4);
        UpperBody.setRotationPoint(0F, 19F, 2F);
        UpperBody.setTextureSize(32, 32);
        UpperBody.mirror = true;
        setRotation(UpperBody, 0.7063936F, 0F, 0F);

        LowerBody = new ModelRenderer(this, 0, 0);
        LowerBody.addBox(-2F, -1F, -2F, 4, 3, 4);
        LowerBody.setRotationPoint(0F, 19F, 2F);
        LowerBody.setTextureSize(32, 32);
        LowerBody.mirror = true;
        setRotation(LowerBody, 0F, 0F, 0F);

        LowerHead = new ModelRenderer(this, 0, 0);
        LowerHead.addBox(-1.5F, -5.066667F, -4.4F, 3, 3, 3);
        LowerHead.setRotationPoint(0F, 19F, 2F);
        LowerHead.setTextureSize(32, 32);
        LowerHead.mirror = true;
        setRotation(LowerHead, 0F, 0F, 0F);

        Head = new ModelRenderer(this, 0, 10);
        Head.addBox(-2.5F, -5.5F, -9F, 5, 5, 5);
        Head.setRotationPoint(0F, 19F, 2F);
        Head.setTextureSize(32, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);

        LegLeft1 = new ModelRenderer(this, 0, 0);
        LegLeft1.addBox(2F, 0.06666667F, 0.5F, 1, 3, 2);
        LegLeft1.setRotationPoint(0F, 19F, 2F);
        LegLeft1.setTextureSize(32, 32);
        LegLeft1.mirror = true;
        setRotation(LegLeft1, -0.7063936F, 0F, 0F);

        LegLeft3 = new ModelRenderer(this, 0, 0);
        LegLeft3.addBox(1.5F, 4F, -3.5F, 2, 1, 5);
        LegLeft3.setRotationPoint(0F, 19F, 2F);
        LegLeft3.setTextureSize(32, 32);
        LegLeft3.mirror = true;
        setRotation(LegLeft3, 0F, 0F, 0F);

        LegLeft2 = new ModelRenderer(this, 0, 0);
        LegLeft2.addBox(2F, 1.533333F, -3.066667F, 1, 2, 1);
        LegLeft2.setRotationPoint(0F, 19F, 2F);
        LegLeft2.setTextureSize(32, 32);
        LegLeft2.mirror = true;
        setRotation(LegLeft2, 0.8922867F, 0F, 0F);

        LegRight1 = new ModelRenderer(this, 0, 0);
        LegRight1.addBox(-3F, 0.06666667F, 0.5F, 1, 3, 2);
        LegRight1.setRotationPoint(0F, 19F, 2F);
        LegRight1.setTextureSize(32, 32);
        LegRight1.mirror = true;
        setRotation(LegRight1, -0.7063936F, 0F, 0F);

        LegRight3 = new ModelRenderer(this, 0, 0);
        LegRight3.addBox(-3.5F, 4F, -3.5F, 2, 1, 5);
        LegRight3.setRotationPoint(0F, 19F, 2F);
        LegRight3.setTextureSize(32, 32);
        LegRight3.mirror = true;
        setRotation(LegRight3, 0F, 0F, 0F);

        LegRight2 = new ModelRenderer(this, 0, 0);
        LegRight2.addBox(-3F, 1.533333F, -3.066667F, 1, 2, 1);
        LegRight2.setRotationPoint(0F, 19F, 2F);
        LegRight2.setTextureSize(32, 32);
        LegRight2.mirror = true;
        setRotation(LegRight2, 0.8922867F, 0F, 0F);

        ArmLeft1 = new ModelRenderer(this, 0, 0);
        ArmLeft1.addBox(1F, -1.466667F, -2.266667F, 2, 2, 1);
        ArmLeft1.setRotationPoint(0F, 19F, 2F);
        ArmLeft1.setTextureSize(32, 32);
        ArmLeft1.mirror = true;
        setRotation(ArmLeft1, -0.4089647F, 0F, 0F);

        ArmLeft2 = new ModelRenderer(this, 0, 0);
        ArmLeft2.addBox(2F, -1.4F, -4.333333F, 1, 1, 3);
        ArmLeft2.setRotationPoint(0F, 19F, 2F);
        ArmLeft2.setTextureSize(32, 32);
        ArmLeft2.mirror = true;
        setRotation(ArmLeft2, 0.4461433F, 0F, 0F);

        ArmRight1 = new ModelRenderer(this, 0, 0);
        ArmRight1.addBox(-3F, -1.466667F, -2.266667F, 2, 2, 1);
        ArmRight1.setRotationPoint(0F, 19F, 2F);
        ArmRight1.setTextureSize(32, 32);
        ArmRight1.mirror = true;
        setRotation(ArmRight1, -0.4089647F, 0F, 0F);

        ArmRight2 = new ModelRenderer(this, 0, 0);
        ArmRight2.addBox(-3F, -1.4F, -4.333333F, 1, 1, 3);
        ArmRight2.setRotationPoint(0F, 19F, 2F);
        ArmRight2.setTextureSize(32, 32);
        ArmRight2.mirror = true;
        setRotation(ArmRight2, 0.4461433F, 0F, 0F);

        AntenaLeft1 = new ModelRenderer(this, 0, 0);
        AntenaLeft1.addBox(1F, -6.5F, -8F, 1, 2, 1);
        AntenaLeft1.setRotationPoint(0F, 19F, 2F);
        AntenaLeft1.setTextureSize(32, 32);
        AntenaLeft1.mirror = true;
        setRotation(AntenaLeft1, 0F, 0F, 0F);

        AntenaLeft2 = new ModelRenderer(this, 0, 0);
        AntenaLeft2.addBox(1F, -7.5F, -10F, 1, 1, 3);
        AntenaLeft2.setRotationPoint(0F, 19F, 2F);
        AntenaLeft2.setTextureSize(32, 32);
        AntenaLeft2.mirror = true;
        setRotation(AntenaLeft2, 0F, 0F, 0F);

        AntenaRight1 = new ModelRenderer(this, 0, 0);
        AntenaRight1.addBox(-2F, -6.5F, -8F, 1, 2, 1);
        AntenaRight1.setRotationPoint(0F, 19F, 2F);
        AntenaRight1.setTextureSize(32, 32);
        AntenaRight1.mirror = true;
        setRotation(AntenaRight1, 0F, 0F, 0F);

        AntenaRight2 = new ModelRenderer(this, 0, 0);
        AntenaRight2.addBox(-2F, -7.5F, -10F, 1, 1, 3);
        AntenaRight2.setRotationPoint(0F, 19F, 2F);
        AntenaRight2.setTextureSize(32, 32);
        AntenaRight2.mirror = true;
        setRotation(AntenaRight2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        //if(EntityHelper.getState(entity) != 1)
        //{
            UpperBody.render(f5);
            LowerBody.render(f5);
            LowerHead.render(f5);
            Head.render(f5);
            LegLeft1.render(f5);
            LegLeft3.render(f5);
            LegLeft2.render(f5);
            LegRight1.render(f5);
            LegRight3.render(f5);
            LegRight2.render(f5);
            ArmLeft1.render(f5);
            ArmLeft2.render(f5);
            ArmRight1.render(f5);
            ArmRight2.render(f5);
            AntenaLeft1.render(f5);
            AntenaLeft2.render(f5);
            AntenaRight1.render(f5);
            AntenaRight2.render(f5);
       //}
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
    {
        updateDistanceMovedTotal(e);
        cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % animationWalk.length);
        
        if(e.getDistance(e.prevPosX, e.prevPosY, e.prevPosZ) > 0){
            LegLeft1.rotateAngleX = degToRad(animationWalk[cycleIndex][0]);
            LegLeft2.rotateAngleX = degToRad(animationWalk[cycleIndex][1]);
            LegLeft3.rotateAngleX = degToRad(animationWalk[cycleIndex][2]);

            LegRight1.rotateAngleX = degToRad(animationWalk[cycleIndex][3]);
            LegRight2.rotateAngleX = degToRad(animationWalk[cycleIndex][4]);
            LegRight3.rotateAngleX = degToRad(animationWalk[cycleIndex][5]);
        }else{
            LegLeft1.rotateAngleX = LegRight1.rotateAngleX = -0.7063936F;
            LegLeft2.rotateAngleX = LegRight2.rotateAngleX = 0.8922867F;
            LegLeft3.rotateAngleX = LegRight3.rotateAngleX = 0;
        }

    }

    // Default methods/functions for every model
    protected void updateDistanceMovedTotal(Entity e)
    {
        distanceMovedTotal += e.getDistance(e.prevPosX, e.prevPosY, e.prevPosZ);
    }
    
    protected double getDistanceMovedTotal() 
    {
        return (distanceMovedTotal);
    }

    protected float degToRad(double degrees)
    {
        return (float) (degrees * (double)Math.PI / 180);
    }
}