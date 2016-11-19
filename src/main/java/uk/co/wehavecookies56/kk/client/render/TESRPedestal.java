package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;

/**
 * Created by Toby on 06/11/2016.
 */
public class TESRPedestal extends TileEntitySpecialRenderer<TileEntityPedestal> {

    private RenderItem renderItem;

    @Override
    public void renderTileEntityAt(TileEntityPedestal te, double x, double y, double z, float partialTicks, int destroyStage) {
        if(te != null && te instanceof TileEntityPedestal) {
            if (te.getStackInSlot(0) != null) {

                GlStateManager.pushAttrib();
                GlStateManager.pushMatrix();

                GlStateManager.translate(x, y, z);
                GlStateManager.disableRescaleNormal();
                this.renderItem = Minecraft.getMinecraft().getRenderItem();
                RenderHelper.enableStandardItemLighting();
                GlStateManager.enableLighting();
                GlStateManager.pushMatrix();
                {
                    GlStateManager.translate(0.5, 1.3, 0.5);
                    //switch(te.rotation){}
                    GlStateManager.rotate(90*te.rotation, 0, 1, 0);
                    GlStateManager.scale(0.02, 0.02, 0.02);
                    Item itemToRender = te.getStackInSlot(0).getItem();
                    if(itemToRender instanceof ItemKeyblade)
                 	  renderItem.renderItem(new ItemStack(itemToRender), ItemCameraTransforms.TransformType.NONE);
                    else if (itemToRender instanceof ItemKeychain)
                   	  renderItem.renderItem(new ItemStack(((ItemKeychain) itemToRender).getKeyblade()), ItemCameraTransforms.TransformType.NONE);

                }
                GlStateManager.popMatrix();
                GlStateManager.popMatrix();
                GlStateManager.popAttrib();
            }
        }

        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
    }
}