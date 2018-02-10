package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.common.entity.EntityFlyingHeart;

public class RenderFactoryFlyingHeart implements IRenderFactory<EntityFlyingHeart> {

    @Override
    public Render<? super EntityFlyingHeart> createRenderFor (RenderManager manager) {
        return new RenderEntityFlyingHeart(manager);
    }

}