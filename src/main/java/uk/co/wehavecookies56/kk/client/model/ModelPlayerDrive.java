package uk.co.wehavecookies56.kk.client.model;

/*
import org.lwjgl.opengl.GL11;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerArmor;
import api.player.model.ModelPlayerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.common.entity.ExtendedPlayer;
import Reference;
import Strings;

public class ModelPlayerDrive extends ModelPlayerBase {

	public ModelPlayerDrive (ModelPlayerAPI modelPlayerAPI) {
		super(modelPlayerAPI);
	}

	ResourceLocation valorA = new ResourceLocation(Reference.MODID, "textures/armour/Valor_A.png");
	ResourceLocation valorB = new ResourceLocation(Reference.MODID, "textures/armour/Valor_B.png");

	ResourceLocation wisdomA = new ResourceLocation(Reference.MODID, "textures/armour/Wisdom_A.png");
	ResourceLocation wisdomB = new ResourceLocation(Reference.MODID, "textures/armour/Wisdom_B.png");

	ResourceLocation limitA = new ResourceLocation(Reference.MODID, "textures/armour/Limit_A.png");
	ResourceLocation limitB = new ResourceLocation(Reference.MODID, "textures/armour/Limit_B.png");

	ResourceLocation masterA = new ResourceLocation(Reference.MODID, "textures/armour/Master_A.png");
	ResourceLocation masterB = new ResourceLocation(Reference.MODID, "textures/armour/Master_B.png");

	ResourceLocation finalA = new ResourceLocation(Reference.MODID, "textures/armour/Final_A.png");
	ResourceLocation finalB = new ResourceLocation(Reference.MODID, "textures/armour/Final_B.png");

	ResourceLocation driveInUseA;
	ResourceLocation driveInUseB;

	ModelPlayerArmor drive;

	@Override
	public void beforeRender (Entity paramEntity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
		super.beforeRender(paramEntity, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
	}

	@Override
	public void afterRender (Entity paramEntity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
		super.afterRender(paramEntity, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);

	}

	@Override
	public void afterSetRotationAngles (float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Entity paramEntity) {
		super.afterSetRotationAngles(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramEntity);
	}

	@Override
	public void render (Entity paramEntity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
		super.render(paramEntity, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
		if(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).inDrive){
			switch(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getDriveInUse()){
				case Strings.Form_Valor:
					driveInUseA = valorA;
					driveInUseB = valorB;
					break;
				case Strings.Form_Wisdom:
					driveInUseA = wisdomA;
					driveInUseB = wisdomB;
					break;
				case Strings.Form_Limit:
					driveInUseA = limitA;
					driveInUseB = limitB;
					break;
				case Strings.Form_Master:
					driveInUseA = masterA;
					driveInUseB = masterB;
					break;
				case Strings.Form_Final:
					driveInUseA = finalA;
					driveInUseB = finalB;
					break;
				case Strings.Form_Anti:
					GL11.glPushMatrix();
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glColor4f(0, 0, 0, 0.85f);
					driveInUseA = null;
					driveInUseB = null;
					modelPlayer.bipedHead.render(0.0625f);
					modelPlayer.bipedBody.render(0.0625f);
					modelPlayer.bipedRightArm.render(0.0625f);
					modelPlayer.bipedRightLeg.render(0.0625f);
					modelPlayer.bipedLeftArm.render(0.0625f);
					modelPlayer.bipedLeftLeg.render(0.0625f);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
					break;
				default:
					driveInUseA = null;
					driveInUseB = null;
					break;
			}
			if(driveInUseA != null && driveInUseB != null){
				float size = (float) paramFloat6;
				drive = new ModelPlayerArmor(size);
				Minecraft.getMinecraft().renderEngine.bindTexture(driveInUseA);
				drive.copyModelAngles(modelPlayer.bipedBodyWear, drive.bipedBody);
				drive.bipedBody.render(size);
				drive.copyModelAngles(modelPlayer.bipedLeftArm, drive.bipedLeftArm);
				drive.bipedLeftArm.render(size);
				drive.copyModelAngles(modelPlayer.bipedRightArm, drive.bipedRightArm);
				drive.bipedRightArm.render(size);
				Minecraft.getMinecraft().renderEngine.bindTexture(driveInUseB);
				drive.copyModelAngles(modelPlayer.bipedLeftLeg, drive.bipedLeftLeg);
				drive.bipedLeftLeg.render(size);
				drive.copyModelAngles(modelPlayer.bipedRightLeg, drive.bipedRightLeg);
				drive.bipedRightLeg.render(size);
			}
		}
	}

	@Override
	public void renderRightArm () {
		super.renderRightArm();

		if(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).inDrive){
			switch(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getDriveInUse()){
				case Strings.Form_Valor:
					driveInUseA = valorA;
					break;
				case Strings.Form_Wisdom:
					driveInUseA = wisdomA;
					break;
				case Strings.Form_Limit:
					driveInUseA = limitA;
					break;
				case Strings.Form_Master:
					driveInUseA = masterA;
					break;
				case Strings.Form_Final:
					driveInUseA = finalA;
					break;
				case Strings.Form_Anti:
					GL11.glPushMatrix();
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glColor4f(0, 0, 0, 0.9f);
					driveInUseA = null;
					modelPlayer.bipedRightArm.render(0.0625f);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
					break;
				default:
					driveInUseA = null;
					break;
			}
			if(driveInUseA != null){
				Minecraft.getMinecraft().renderEngine.bindTexture(driveInUseA);
				ModelPlayerArmor armour = new ModelPlayerArmor(0.0625f);
				armour.setRotationAngles(0, 0, 0, 0, 0, 0.0625f, Minecraft.getMinecraft().thePlayer);
				armour.bipedRightArm.render(0.0625f);
			}	
		}
	}
}
*/
