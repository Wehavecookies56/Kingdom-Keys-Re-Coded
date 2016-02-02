package wehavecookies56.kk.client.render;

import api.player.model.ModelPlayerArmor;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import net.minecraft.client.entity.AbstractClientPlayer;

public class RenderPlayerDrive extends RenderPlayerBase {

	public RenderPlayerDrive (RenderPlayerAPI renderPlayerAPI) {
		super(renderPlayerAPI);
	}
	
	@Override
	public void doRender (AbstractClientPlayer player, double x, double y, double z, float yaw, float ticks) {
		super.doRender(player, x, y, z, yaw, ticks);
	}
	
	@Override
	public void renderRightArm (AbstractClientPlayer paramAbstractClientPlayer) {
		super.renderRightArm(paramAbstractClientPlayer);
	}

}
