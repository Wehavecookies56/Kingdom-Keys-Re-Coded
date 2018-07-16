package uk.co.wehavecookies56.kk.client.model.mobs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityBlueRhapsody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGreenRequiem;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityRedNocturne;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityYellowOpera;

public class ModelRedNocturne extends ModelBase
{
	public ModelRenderer Body;
	public ModelRenderer Body1;
	public ModelRenderer RightLeg;
	public ModelRenderer LeftLeg;
	public ModelRenderer Body2;
	public ModelRenderer Collar1;
	public ModelRenderer Collar2;
	public ModelRenderer Collar3;
	public ModelRenderer Collar4;
	public ModelRenderer Head;
	public ModelRenderer Hat;
	public ModelRenderer Hat1;
	public ModelRenderer HatDetail1;
	public ModelRenderer HatDetail2;
	public ModelRenderer HatDetail3;
	public ModelRenderer HatDetail4;
	public ModelRenderer HatTop1;
	public ModelRenderer HatTop2;
	public ModelRenderer HatTop3;
	public ModelRenderer HatTop4;
	public ModelRenderer HatTop5;
	public ModelRenderer RightLegDetail1;
	public ModelRenderer RightLegDetail2;
	public ModelRenderer RightLegDetail3;
	public ModelRenderer LeftLegDetail1;
	public ModelRenderer LeftLegDetail2;
	public ModelRenderer LeftLegDetail3;
	
    private boolean canAnimate = true;
	private double frame;

	public ModelRedNocturne()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.HatDetail4 = new ModelRenderer(this, 29, 5);
		this.HatDetail4.setRotationPoint(-2.5F, 2.0F, 0.5F);
		this.HatDetail4.addBox(0.0F, -0.5F, -3.0F, 0, 1, 6, 0.0F);
		this.Collar4 = new ModelRenderer(this, 29, -3);
		this.Collar4.setRotationPoint(-3.0F, -1.0F, 0.0F);
		this.Collar4.addBox(0.0F, -1.0F, -3.0F, 0, 2, 6, 0.0F);
		this.RightLegDetail3 = new ModelRenderer(this, 0, 35);
		this.RightLegDetail3.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.RightLegDetail3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.Body2 = new ModelRenderer(this, 0, 23);
		this.Body2.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.Body2.addBox(-3.0F, 0.0F, -3.0F, 6, 3, 6, 0.0F);
		this.RightLegDetail1 = new ModelRenderer(this, 0, 35);
		this.RightLegDetail1.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.RightLegDetail1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(RightLegDetail1, 0.0F, 0.0F, 0.7853981633974483F);
		this.HatDetail2 = new ModelRenderer(this, 29, 6);
		this.HatDetail2.setRotationPoint(0.5F, 2.0F, 3.5F);
		this.HatDetail2.addBox(-3.0F, -0.5F, 0.0F, 6, 1, 0, 0.0F);
		this.LeftLegDetail1 = new ModelRenderer(this, 0, 35);
		this.LeftLegDetail1.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.LeftLegDetail1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LeftLegDetail1, 0.0F, 0.0F, 0.7853981633974483F);
		this.LeftLegDetail2 = new ModelRenderer(this, 0, 35);
		this.LeftLegDetail2.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.LeftLegDetail2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LeftLegDetail2, 0.0F, 0.0F, -0.7853981633974483F);
		this.HatTop3 = new ModelRenderer(this, 28, 25);
		this.HatTop3.setRotationPoint(0.5F, -2.5F, 0.0F);
		this.HatTop3.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(HatTop3, 0.0F, 0.0F, 1.5707963267948966F);
		this.RightLeg = new ModelRenderer(this, 0, 35);
		this.RightLeg.setRotationPoint(-2.0F, 1.0F, 0.5F);
		this.RightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.Collar1 = new ModelRenderer(this, 29, 0);
		this.Collar1.setRotationPoint(0.0F, -1.0F, -3.0F);
		this.Collar1.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 0, 0.0F);
		this.Head = new ModelRenderer(this, 0, 53);
		this.Head.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.HatTop1 = new ModelRenderer(this, 28, 34);
		this.HatTop1.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.HatTop1.addBox(-0.5F, -4.5F, -0.5F, 1, 4, 1, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 0, 35);
		this.LeftLeg.setRotationPoint(2.0F, 1.0F, 0.5F);
		this.LeftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.LeftLegDetail3 = new ModelRenderer(this, 0, 35);
		this.LeftLegDetail3.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.LeftLegDetail3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.HatTop4 = new ModelRenderer(this, 28, 20);
		this.HatTop4.setRotationPoint(-0.5F, 3.3F, 0.0F);
		this.HatTop4.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(HatTop4, 0.0F, 0.0F, 1.5707963267948966F);
		this.HatTop2 = new ModelRenderer(this, 28, 30);
		this.HatTop2.setRotationPoint(-0.1F, -4.2F, 0.0F);
		this.HatTop2.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(HatTop2, 0.0F, 0.0F, 0.7853981633974483F);
		this.Hat = new ModelRenderer(this, 0, 34);
		this.Hat.setRotationPoint(-0.5F, -3.5F, -0.5F);
		this.Hat.addBox(-2.5F, -0.5F, -2.5F, 6, 2, 6, 0.0F);
		this.Hat1 = new ModelRenderer(this, 0, 44);
		this.Hat1.setRotationPoint(0.5F, -0.5F, 0.5F);
		this.Hat1.addBox(-2.5F, -1.0F, -2.5F, 5, 1, 5, 0.0F);
		this.HatDetail1 = new ModelRenderer(this, 29, 6);
		this.HatDetail1.setRotationPoint(0.5F, 2.0F, -2.5F);
		this.HatDetail1.addBox(-3.0F, -0.5F, 0.0F, 6, 1, 0, 0.0F);
		this.Body1 = new ModelRenderer(this, 0, 12);
		this.Body1.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.Body1.addBox(-3.5F, 0.0F, -3.5F, 7, 2, 7, 0.0F);
		this.RightLegDetail2 = new ModelRenderer(this, 0, 35);
		this.RightLegDetail2.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.RightLegDetail2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(RightLegDetail2, 0.0F, 0.0F, -0.7853981633974483F);
		this.HatTop5 = new ModelRenderer(this, 22, 23);
		this.HatTop5.setRotationPoint(-1.0F, -2.5F, 0.0F);
		this.HatTop5.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(HatTop5, 0.0F, 0.0F, 1.5707963267948966F);
		this.Collar3 = new ModelRenderer(this, 29, -3);
		this.Collar3.setRotationPoint(3.0F, -1.0F, 0.0F);
		this.Collar3.addBox(0.0F, -1.0F, -3.0F, 0, 2, 6, 0.0F);
		this.Collar2 = new ModelRenderer(this, 29, 0);
		this.Collar2.setRotationPoint(0.0F, -1.0F, 3.0F);
		this.Collar2.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 0, 0.0F);
		this.HatDetail3 = new ModelRenderer(this, 29, 5);
		this.HatDetail3.setRotationPoint(3.5F, 2.0F, 0.5F);
		this.HatDetail3.addBox(0.0F, -0.5F, -3.0F, 0, 1, 6, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 8.1F, 0.0F);
		this.Body.addBox(-4.0F, -1.0F, -4.0F, 8, 2, 8, 0.0F);
		this.Hat.addChild(this.HatDetail4);
		this.Body2.addChild(this.Collar4);
		this.RightLeg.addChild(this.RightLegDetail3);
		this.Body1.addChild(this.Body2);
		this.RightLeg.addChild(this.RightLegDetail1);
		this.Hat.addChild(this.HatDetail2);
		this.LeftLeg.addChild(this.LeftLegDetail1);
		this.LeftLeg.addChild(this.LeftLegDetail2);
		this.HatTop2.addChild(this.HatTop3);
		this.Body.addChild(this.RightLeg);
		this.Body2.addChild(this.Collar1);
		this.Body2.addChild(this.Head);
		this.Hat1.addChild(this.HatTop1);
		this.Body.addChild(this.LeftLeg);
		this.LeftLeg.addChild(this.LeftLegDetail3);
		this.HatTop3.addChild(this.HatTop4);
		this.HatTop1.addChild(this.HatTop2);
		this.Head.addChild(this.Hat);
		this.Hat.addChild(this.Hat1);
		this.Hat.addChild(this.HatDetail1);
		this.Body.addChild(this.Body1);
		this.RightLeg.addChild(this.RightLegDetail2);
		this.HatTop4.addChild(this.HatTop5);
		this.Body2.addChild(this.Collar3);
		this.Body2.addChild(this.Collar2);
		this.Hat.addChild(this.HatDetail3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
    	super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Body.render(f5);
	}
	
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	double[] animationShootFire = new double[]
				{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360};
    	double[] animationShootBlizzard = new double[]
				{0, -10, -20, -30, -20, -10, 0, 10, 20, 30, 40, 50, 60, 70, 60, 50, 40, 30, 20, 10, 5, 0};

    	double[] animationMeleeAttack = new double[]
				{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520, 530};

    	
	    if(!Minecraft.getMinecraft().isGamePaused())
	    {
	    	if(EntityHelper.getState(entity) == 1)
	    	{
	    		if(entity instanceof EntityRedNocturne || entity instanceof EntityYellowOpera || entity instanceof EntityGreenRequiem)
	    		{
		    		if(frame < animationShootFire.length)
		    		{
			    		this.Hat1.offsetY = this.HatTop1.offsetY = -0.2F;
		    			this.Hat1.rotateAngleY = degToRad(animationShootFire[(int) frame]);
		    			this.HatTop1.rotateAngleY = degToRad(animationShootFire[(animationShootFire.length - 1) - (int) frame]) * 2;
		    		}
		    		else
		    		{
		    			this.Hat1.rotateAngleY = this.HatTop1.rotateAngleY = degToRad(0);
		    			this.Hat1.offsetY = this.HatTop1.offsetY = 0F;
		    			frame = 0;
		    			EntityHelper.setState(entity, 0);
		    		}
		    		
		    		this.frame += 0.7;
	    		}
	    		else if(entity instanceof EntityBlueRhapsody)
	    		{
		    		if(frame < animationShootBlizzard.length)
		    		{
		    			this.Body.rotateAngleX = degToRad(animationShootBlizzard[(int) frame]);
		    			
		    			if(frame > animationShootBlizzard.length - 16)
		    			{
				    		this.Hat1.offsetY = this.HatTop1.offsetY = -0.2F;
			    			this.Hat1.rotateAngleY = degToRad(animationShootFire[(int) frame]);
			    			this.HatTop1.rotateAngleY = degToRad(animationShootFire[(animationShootFire.length - 1) - (int) frame]) * 2;				
		    			}
		    		}
		    		else
		    		{
		    			this.Hat1.rotateAngleY = this.HatTop1.rotateAngleY = degToRad(0);
		    			this.Hat1.offsetY = this.HatTop1.offsetY = 0F;
		    			this.Body.rotateAngleX = degToRad(0);
		    			frame = 0;
		    			EntityHelper.setState(entity, 0);
		    		}
		    		
		    		this.frame += 0.6;    			
	    		}
	    	}
	    	else if(EntityHelper.getState(entity) == 2)
	    	{
	    		if(frame < animationMeleeAttack.length)
	    		{
		    		this.Hat1.offsetY = this.HatTop1.offsetY = -0.6F;
		    		this.Body.rotateAngleX = degToRad(85);	    		
	    			this.Body.rotateAngleY = degToRad(animationMeleeAttack[(int) frame]);
	    		}
	    		else
	    		{
	    			this.Body.rotateAngleX = degToRad(0);
	    			this.Hat1.rotateAngleY = this.Body.rotateAngleY = degToRad(0);
	    			this.Hat1.offsetY = this.HatTop1.offsetY = 0F;
	    			frame = 0;
	    			EntityHelper.setState(entity, 0);
	    		}
	    		
	    		this.frame += 1.2;
	    	}
	    	else if(EntityHelper.getState(entity) == 3)
	    	{
	    		if(entity instanceof EntityYellowOpera)
	    		{
		    		if(frame < animationMeleeAttack.length)
		    		{
			    		this.Body.rotateAngleX = degToRad(90);	    		
		    			this.Body.rotateAngleZ = degToRad(animationMeleeAttack[(int) frame]);
		    		}
		    		else
		    		{
		    			this.Body.rotateAngleX = this.Body.rotateAngleZ = degToRad(0);
		    			frame = 0;
		    			EntityHelper.setState(entity, 0);
		    		}
		    		
		    		this.frame += 1.2;
	    		}
	    	}
	    }
    }

    protected float degToRad(double degrees)
    {
        return (float) (degrees * (double)Math.PI / 180);
    }
    
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
