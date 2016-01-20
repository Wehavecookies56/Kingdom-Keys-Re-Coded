package wehavecookies56.kk.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import wehavecookies56.kk.entities.projectiles.EntitySharpshooterBullet;

public class RenderFactorySharpshooterBullet implements IRenderFactory<EntitySharpshooterBullet> {

	@Override
	public Render<? super EntitySharpshooterBullet> createRenderFor(RenderManager manager) {
		return new RenderEntitySharpshooterBullet(manager);
	}

}