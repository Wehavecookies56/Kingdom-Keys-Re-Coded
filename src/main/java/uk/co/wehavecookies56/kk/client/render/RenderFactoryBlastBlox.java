package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;

public class RenderFactoryBlastBlox implements IRenderFactory<EntityBlastBlox> {

    @Override
    public Render<? super EntityBlastBlox> createRenderFor (RenderManager manager) {
        return new RenderBlastBlox(manager);
    }

}