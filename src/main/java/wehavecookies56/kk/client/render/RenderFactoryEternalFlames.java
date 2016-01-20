package wehavecookies56.kk.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import wehavecookies56.kk.entities.projectiles.EntityEternalFlames;

public class RenderFactoryEternalFlames implements IRenderFactory<EntityEternalFlames> {

	@Override
	public Render<? super EntityEternalFlames> createRenderFor(RenderManager manager) {
		return new RenderEntityEternalFlames(manager);
	}

}