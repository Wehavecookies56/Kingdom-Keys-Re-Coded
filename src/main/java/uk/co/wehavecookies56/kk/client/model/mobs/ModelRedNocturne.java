package uk.co.wehavecookies56.kk.client.model.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;

public class ModelRedNocturne extends ModelBase {
	ModelRenderer LowerBody;
	ModelRenderer UpperBody;
	ModelRenderer MidBody;
	ModelRenderer Head;
	ModelRenderer Helmet04;
	ModelRenderer Helmet02;
	ModelRenderer Helmet01;
	ModelRenderer Helmet03;
	ModelRenderer Helmet05;
	ModelRenderer Helmet06;
	ModelRenderer Antenna01;
	ModelRenderer RightLeg;
	ModelRenderer LeftLeg;
	ModelRenderer Antenna02;
	ModelRenderer Antenna03;
	ModelRenderer Antenna04;
	ModelRenderer Antenna05;
 
	private int ticksBeforeNextAnimationMelee = 0, ticksForMeleeAnimation = 0;

	public ModelRedNocturne() {
		
		textureWidth = 64;
		textureHeight = 64;

		LowerBody = new ModelRenderer(this, 0, 47);
		LowerBody.addBox(-4F, 0F, -4F, 8, 3, 8);
		LowerBody.setRotationPoint(0F, 1F, 0F);
		LowerBody.setTextureSize(64, 32);
		LowerBody.mirror = true;
		setRotation(LowerBody, 0F, 0F, 0F);
		
		UpperBody = new ModelRenderer(this, 0, 30);
		UpperBody.addBox(-3F, -4F, -3F, 6, 2, 6);
		UpperBody.setRotationPoint(0F, 1F, 0F);
		UpperBody.setTextureSize(64, 32);
		UpperBody.mirror = true;
		setRotation(UpperBody, 0F, 0F, 0F);
		
		MidBody = new ModelRenderer(this, 0, 38);
		MidBody.addBox(-3.5F, -2F, -3.5F, 7, 2, 7);
		MidBody.setRotationPoint(0F, 1F, 0F);
		MidBody.setTextureSize(64, 32);
		MidBody.mirror = true;
		setRotation(MidBody, 0F, 0F, 0F);
		
		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(-2F, -8F, -2F, 4, 4, 4);
		Head.setRotationPoint(0F, 1F, 0F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		
		Helmet04 = new ModelRenderer(this, 0, 13);
		Helmet04.addBox(-3F, -6F, -3F, 0, 3, 6);
		Helmet04.setRotationPoint(0F, 1F, 0F);
		Helmet04.setTextureSize(64, 32);
		Helmet04.mirror = true;
		setRotation(Helmet04, 0F, 0F, 0F);
		
		Helmet02 = new ModelRenderer(this, 0, 13);
		Helmet02.addBox(3F, -6F, -3F, 0, 3, 6);
		Helmet02.setRotationPoint(0F, 1F, 0F);
		Helmet02.setTextureSize(64, 32);
		Helmet02.mirror = true;
		setRotation(Helmet02, 0F, 0F, 0F);
		
		Helmet01 = new ModelRenderer(this, 14, 13);
		Helmet01.addBox(-3F, -6F, -3F, 6, 3, 0);
		Helmet01.setRotationPoint(0F, 1F, 0F);
		Helmet01.setTextureSize(64, 32);
		Helmet01.mirror = true;
		setRotation(Helmet01, 0F, 0F, 0F);
		
		Helmet03 = new ModelRenderer(this, 0, 13);
		Helmet03.addBox(-3F, -6F, 3F, 6, 3, 0);
		Helmet03.setRotationPoint(0F, 1F, 0F);
		Helmet03.setTextureSize(64, 32);
		Helmet03.mirror = true;
		setRotation(Helmet03, 0F, 0F, 0F);
		
		Helmet05 = new ModelRenderer(this, 34, 0);
		Helmet05.addBox(-3F, -10F, -3F, 6, 2, 6);
		Helmet05.setRotationPoint(0F, 1F, 0F);
		Helmet05.setTextureSize(64, 32);
		Helmet05.mirror = true;
		setRotation(Helmet05, 0F, 0F, 0F);
		
		Helmet06 = new ModelRenderer(this, 34, 0);
		Helmet06.addBox(-2.5F, -11F, -2.5F, 5, 1, 5);
		Helmet06.setRotationPoint(0F, 1F, 0F);
		Helmet06.setTextureSize(64, 32);
		Helmet06.mirror = true;
		setRotation(Helmet06, 0F, 0F, 0F);
		
		Antenna01 = new ModelRenderer(this, 41, 0);
		Antenna01.addBox(-0.5F, -15F, -0.5F, 1, 4, 1);
		Antenna01.setRotationPoint(0F, 1F, 0F);
		Antenna01.setTextureSize(64, 32);
		Antenna01.mirror = true;
		setRotation(Antenna01, 0F, 0F, 0F);
		
		RightLeg = new ModelRenderer(this, 30, 0);
		RightLeg.addBox(-2.5F, 3F, 0F, 1, 2, 0);
		RightLeg.setRotationPoint(0F, 1F, 0F);
		RightLeg.setTextureSize(64, 32);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		
		LeftLeg = new ModelRenderer(this, 30, 0);
		LeftLeg.addBox(1.5F, 3F, 0F, 1, 2, 0);
		LeftLeg.setRotationPoint(0F, 1F, 0F);
		LeftLeg.setTextureSize(64, 32);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		
		Antenna02 = new ModelRenderer(this, 41, 0);
		Antenna02.addBox(10.1F, -10.9F, -0.5F, 3, 1, 1);
		Antenna02.setRotationPoint(0F, 1F, 0F);
		Antenna02.setTextureSize(64, 32);
		Antenna02.mirror = true;
		setRotation(Antenna02, 0F, 0F, -0.7853982F);
		
		Antenna03 = new ModelRenderer(this, 41, 0);
		Antenna03.addBox(-12.66667F, -13.2F, -0.5F, 2, 1, 1);
		Antenna03.setRotationPoint(0F, 1F, 0F);
		Antenna03.setTextureSize(64, 32);
		Antenna03.mirror = true;
		setRotation(Antenna03, 0F, 0F, 0.7853982F);
		
		Antenna04 = new ModelRenderer(this, 41, 0);
		Antenna04.addBox(10.1F, -13.7F, -0.5F, 3, 1, 1);
		Antenna04.setRotationPoint(0F, 1F, 0F);
		Antenna04.setTextureSize(64, 32);
		Antenna04.mirror = true;
		setRotation(Antenna04, 0F, 0F, -0.7853982F);
		
		Antenna05 = new ModelRenderer(this, 41, 0);
		Antenna05.addBox(-12.8F, -11.23333F, -0.5F, 1, 1, 1);
		Antenna05.setRotationPoint(0F, 1F, 0F);
		Antenna05.setTextureSize(64, 32);
		Antenna05.mirror = true;
		setRotation(Antenna05, 0F, 0F, 0.7853982F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		LowerBody.render(f5);
		UpperBody.render(f5);
		MidBody.render(f5);
		Head.render(f5);
		Helmet04.render(f5);
		Helmet02.render(f5);
		Helmet01.render(f5);
		Helmet03.render(f5);
		Helmet05.render(f5);
		Helmet06.render(f5);
		Antenna01.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
		Antenna02.render(f5);
		Antenna03.render(f5);
		Antenna04.render(f5);
		Antenna05.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) 
	{
		//System.out.println(entity.getDataManager().get(EntityHelper.ANIMATION));
		
		if (EntityHelper.getAnimation(entity) == 0) 
		{
			LowerBody.rotateAngleX = UpperBody.rotateAngleX = MidBody.rotateAngleX = Head.rotateAngleX = Helmet01.rotateAngleX = Helmet02.rotateAngleX = Helmet03.rotateAngleX 
					= Helmet04.rotateAngleX = Helmet05.rotateAngleX = Helmet06.rotateAngleX = RightLeg.rotateAngleX = LeftLeg.rotateAngleX = Antenna01.rotateAngleX = 0;
			//System.out.println(entity);
		}
		if (EntityHelper.getAnimation(entity) == 1) 
		{
			LowerBody.rotateAngleX = UpperBody.rotateAngleX = MidBody.rotateAngleX = Head.rotateAngleX = Helmet01.rotateAngleX = Helmet02.rotateAngleX = Helmet03.rotateAngleX 
					= Helmet04.rotateAngleX = Helmet05.rotateAngleX = Helmet06.rotateAngleX = RightLeg.rotateAngleX = LeftLeg.rotateAngleX = Antenna01.rotateAngleX = degToRad(-43);	
			
			if(ticksForMeleeAnimation <= 360 / 30)
			{
				
				LowerBody.rotateAngleY = UpperBody.rotateAngleY = MidBody.rotateAngleY = Head.rotateAngleY = Helmet01.rotateAngleY = Helmet02.rotateAngleY = Helmet03.rotateAngleY 
						= Helmet04.rotateAngleY = Helmet05.rotateAngleY = Helmet06.rotateAngleY = RightLeg.rotateAngleY = LeftLeg.rotateAngleY = Antenna01.rotateAngleY = degToRad(ticksForMeleeAnimation * 30);
				ticksForMeleeAnimation++;
			}
			else
			{	
				//EntityHelper.setAnimation(entity, 0);
				ticksForMeleeAnimation = 0;
			}
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

	protected float degToRad(double degrees)
	{
		return (float) (degrees * (double)Math.PI / 180) ;
	}
}
