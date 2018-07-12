package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.org.ItemOrgShield;

/**
 * Created by Toby on 06/11/2016.
 */
public class TESRPedestal extends TileEntitySpecialRenderer<TileEntityPedestal> {

    private RenderItem renderItem;

    @Override
    public void render(TileEntityPedestal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
            IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
            GlStateManager.pushAttrib();
            GlStateManager.pushMatrix();

            GlStateManager.translate(x, y, z);
            GlStateManager.disableRescaleNormal();
            this.renderItem = Minecraft.getMinecraft().getRenderItem();
            GlStateManager.pushMatrix(); {
                int rot = te.getRotation();
                GlStateManager.translate(0.5, 1.8, 0.5);
                GlStateManager.rotate(90*rot-90, 0, 1, 0);
                GlStateManager.scale(2, 2, 2);
                te.setKeyblade(itemHandler.getStackInSlot(0));
                Item itemToRender = te.keyblade.getItem();
                GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
                //GlStateManager.enableBlend();
                //GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_DST_COLOR);
                int l = Minecraft.getMinecraft().getRenderManager().world.getCombinedLight(te.getPos().up(), 0);
                int i1 = l % 65536;
                int j1 = l / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)i1, (float)j1);
                GL11.glColor4f(1,1,1,1);
                if(itemToRender instanceof ItemKeyblade)
                    renderItem.renderItem(new ItemStack(itemToRender), ItemCameraTransforms.TransformType.FIXED);
                else if (itemToRender instanceof ItemKeychain)
                    renderItem.renderItem(new ItemStack(((ItemKeychain) itemToRender).getKeyblade()), ItemCameraTransforms.TransformType.FIXED);
                else if (itemToRender instanceof ItemOrgShield)
                    renderItem.renderItem(new ItemStack((itemToRender)), ItemCameraTransforms.TransformType.FIXED);
                //GlStateManager.disableBlend();
                RenderHelper.disableStandardItemLighting();
                GL11.glPopAttrib();

            }
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
            GlStateManager.popAttrib();
        }

        super.render(te, x, y, z, partialTicks, destroyStage, alpha);
    }
}