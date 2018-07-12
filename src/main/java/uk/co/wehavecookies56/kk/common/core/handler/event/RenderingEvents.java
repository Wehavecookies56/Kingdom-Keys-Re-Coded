package uk.co.wehavecookies56.kk.common.core.handler.event;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderItemInFrameEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;

/**
 * Created by Toby on 19/07/2016.
 */
public class RenderingEvents {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderItemInFrame (RenderItemInFrameEvent event) {
        //if (!ItemStack.areItemStacksEqual(event.getItem(), ItemStack.EMPTY)) if (event.getItem().getItem() instanceof ItemKeyblade) GlStateManager.scale(0.02f, 0.02f, 0.02f);
    }

    @SideOnly (Side.CLIENT)
    @SubscribeEvent
    public void fovUpdate (FOVUpdateEvent event) {
        if (event.getEntity().getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() == 0) event.setNewfov(1f);
    }

}
