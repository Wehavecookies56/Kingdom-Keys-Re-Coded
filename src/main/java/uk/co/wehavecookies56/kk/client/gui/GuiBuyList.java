package uk.co.wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.GuiScrollingList;
import uk.co.wehavecookies56.kk.api.munny.MunnyRegistry;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiBuyList extends GuiScrollingList {

    private GuiShop parent;

    FontRenderer f = Minecraft.getMinecraft().fontRenderer;
    RenderItem ir = Minecraft.getMinecraft().getRenderItem();
    static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
    static int width = sr.getScaledWidth();
    static int height = sr.getScaledHeight();
    static int sizeX = 150;
    static int posX = 5;
    static int posY = (height - 200) / 2;

    public static List<ItemStack> itemsForSale = new ArrayList<ItemStack>();

    public GuiBuyList(GuiShop parent) {
        super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
        this.parent = parent;
        itemsForSale.clear();

        ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial);

        BlazingShard.setTagCompound(new NBTTagCompound());
        BlazingShard.getTagCompound().setString("material", "sm.blazingshard");
        BlazingShard.getTagCompound().setString("rank", "sm.rank.c");

        BlazingStone.setTagCompound(new NBTTagCompound());
        BlazingStone.getTagCompound().setString("material", "sm.blazingstone");
        BlazingStone.getTagCompound().setString("rank", "sm.rank.b");

        BlazingGem.setTagCompound(new NBTTagCompound());
        BlazingGem.getTagCompound().setString("material", "sm.blazinggem");
        BlazingGem.getTagCompound().setString("rank", "sm.rank.a");

        BlazingCrystal.setTagCompound(new NBTTagCompound());
        BlazingCrystal.getTagCompound().setString("material", "sm.blazingcrystal");
        BlazingCrystal.getTagCompound().setString("rank", "sm.rank.s");


        BrightShard.setTagCompound(new NBTTagCompound());
        BrightShard.getTagCompound().setString("material", "sm.brightshard");
        BrightShard.getTagCompound().setString("rank", "sm.rank.c");

        BrightStone.setTagCompound(new NBTTagCompound());
        BrightStone.getTagCompound().setString("material", "sm.brightstone");
        BrightStone.getTagCompound().setString("rank", "sm.rank.b");

        BrightGem.setTagCompound(new NBTTagCompound());
        BrightGem.getTagCompound().setString("material", "sm.brightgem");
        BrightGem.getTagCompound().setString("rank", "sm.rank.a");

        BrightCrystal.setTagCompound(new NBTTagCompound());
        BrightCrystal.getTagCompound().setString("material", "sm.brightcrystal");
        BrightCrystal.getTagCompound().setString("rank", "sm.rank.s");


        DarkShard.setTagCompound(new NBTTagCompound());
        DarkShard.getTagCompound().setString("material", "sm.darkshard");
        DarkShard.getTagCompound().setString("rank", "sm.rank.c");

        DarkStone.setTagCompound(new NBTTagCompound());
        DarkStone.getTagCompound().setString("material", "sm.darkstone");
        DarkStone.getTagCompound().setString("rank", "sm.rank.b");

        DarkGem.setTagCompound(new NBTTagCompound());
        DarkGem.getTagCompound().setString("material", "sm.darkgem");
        DarkGem.getTagCompound().setString("rank", "sm.rank.a");

        DarkCrystal.setTagCompound(new NBTTagCompound());
        DarkCrystal.getTagCompound().setString("material", "sm.darkcrystal");
        DarkCrystal.getTagCompound().setString("rank", "sm.rank.s");


        DenseShard.setTagCompound(new NBTTagCompound());
        DenseShard.getTagCompound().setString("material", "sm.denseshard");
        DenseShard.getTagCompound().setString("rank", "sm.rank.c");

        DenseStone.setTagCompound(new NBTTagCompound());
        DenseStone.getTagCompound().setString("material", "sm.densestone");
        DenseStone.getTagCompound().setString("rank", "sm.rank.b");

        DenseGem.setTagCompound(new NBTTagCompound());
        DenseGem.getTagCompound().setString("material", "sm.densegem");
        DenseGem.getTagCompound().setString("rank", "sm.rank.a");

        DenseCrystal.setTagCompound(new NBTTagCompound());
        DenseCrystal.getTagCompound().setString("material", "sm.densecrystal");
        DenseCrystal.getTagCompound().setString("rank", "sm.rank.s");


        EnergyShard.setTagCompound(new NBTTagCompound());
        EnergyShard.getTagCompound().setString("material", "sm.energyshard");
        EnergyShard.getTagCompound().setString("rank", "sm.rank.c");

        EnergyStone.setTagCompound(new NBTTagCompound());
        EnergyStone.getTagCompound().setString("material", "sm.energystone");
        EnergyStone.getTagCompound().setString("rank", "sm.rank.b");

        EnergyGem.setTagCompound(new NBTTagCompound());
        EnergyGem.getTagCompound().setString("material", "sm.energygem");
        EnergyGem.getTagCompound().setString("rank", "sm.rank.a");

        EnergyCrystal.setTagCompound(new NBTTagCompound());
        EnergyCrystal.getTagCompound().setString("material", "sm.energycrystal");
        EnergyCrystal.getTagCompound().setString("rank", "sm.rank.s");


        FrostShard.setTagCompound(new NBTTagCompound());
        FrostShard.getTagCompound().setString("material", "sm.frostshard");
        FrostShard.getTagCompound().setString("rank", "sm.rank.c");

        FrostStone.setTagCompound(new NBTTagCompound());
        FrostStone.getTagCompound().setString("material", "sm.froststone");
        FrostStone.getTagCompound().setString("rank", "sm.rank.b");

        FrostGem.setTagCompound(new NBTTagCompound());
        FrostGem.getTagCompound().setString("material", "sm.frostgem");
        FrostGem.getTagCompound().setString("rank", "sm.rank.a");

        FrostCrystal.setTagCompound(new NBTTagCompound());
        FrostCrystal.getTagCompound().setString("material", "sm.frostcrystal");
        FrostCrystal.getTagCompound().setString("rank", "sm.rank.s");


        LightningShard.setTagCompound(new NBTTagCompound());
        LightningShard.getTagCompound().setString("material", "sm.lightningshard");
        LightningShard.getTagCompound().setString("rank", "sm.rank.c");

        LightningStone.setTagCompound(new NBTTagCompound());
        LightningStone.getTagCompound().setString("material", "sm.lightningstone");
        LightningStone.getTagCompound().setString("rank", "sm.rank.b");

        LightningGem.setTagCompound(new NBTTagCompound());
        LightningGem.getTagCompound().setString("material", "sm.lightninggem");
        LightningGem.getTagCompound().setString("rank", "sm.rank.a");

        LightningCrystal.setTagCompound(new NBTTagCompound());
        LightningCrystal.getTagCompound().setString("material", "sm.lightningcrystal");
        LightningCrystal.getTagCompound().setString("rank", "sm.rank.s");


        LucidShard.setTagCompound(new NBTTagCompound());
        LucidShard.getTagCompound().setString("material", "sm.lucidshard");
        LucidShard.getTagCompound().setString("rank", "sm.rank.c");

        LucidStone.setTagCompound(new NBTTagCompound());
        LucidStone.getTagCompound().setString("material", "sm.lucidstone");
        LucidStone.getTagCompound().setString("rank", "sm.rank.b");

        LucidGem.setTagCompound(new NBTTagCompound());
        LucidGem.getTagCompound().setString("material", "sm.lucidgem");
        LucidGem.getTagCompound().setString("rank", "sm.rank.a");

        LucidCrystal.setTagCompound(new NBTTagCompound());
        LucidCrystal.getTagCompound().setString("material", "sm.lucidcrystal");
        LucidCrystal.getTagCompound().setString("rank", "sm.rank.s");

        PowerShard.setTagCompound(new NBTTagCompound());
        PowerShard.getTagCompound().setString("material", "sm.powershard");
        PowerShard.getTagCompound().setString("rank", "sm.rank.c");

        PowerStone.setTagCompound(new NBTTagCompound());
        PowerStone.getTagCompound().setString("material", "sm.powerstone");
        PowerStone.getTagCompound().setString("rank", "sm.rank.b");

        PowerGem.setTagCompound(new NBTTagCompound());
        PowerGem.getTagCompound().setString("material", "sm.powergem");
        PowerGem.getTagCompound().setString("rank", "sm.rank.a");

        PowerCrystal.setTagCompound(new NBTTagCompound());
        PowerCrystal.getTagCompound().setString("material", "sm.powercrystal");
        PowerCrystal.getTagCompound().setString("rank", "sm.rank.s");


        RemembranceShard.setTagCompound(new NBTTagCompound());
        RemembranceShard.getTagCompound().setString("material", "sm.remembranceshard");
        RemembranceShard.getTagCompound().setString("rank", "sm.rank.c");

        RemembranceStone.setTagCompound(new NBTTagCompound());
        RemembranceStone.getTagCompound().setString("material", "sm.remembrancestone");
        RemembranceStone.getTagCompound().setString("rank", "sm.rank.b");

        RemembranceGem.setTagCompound(new NBTTagCompound());
        RemembranceGem.getTagCompound().setString("material", "sm.remembrancegem");
        RemembranceGem.getTagCompound().setString("rank", "sm.rank.a");

        RemembranceCrystal.setTagCompound(new NBTTagCompound());
        RemembranceCrystal.getTagCompound().setString("material", "sm.remembrancecrystal");
        RemembranceCrystal.getTagCompound().setString("rank", "sm.rank.s");


        SerenityShard.setTagCompound(new NBTTagCompound());
        SerenityShard.getTagCompound().setString("material", "sm.serenityshard");
        SerenityShard.getTagCompound().setString("rank", "sm.rank.c");

        SerenityStone.setTagCompound(new NBTTagCompound());
        SerenityStone.getTagCompound().setString("material", "sm.serenitystone");
        SerenityStone.getTagCompound().setString("rank", "sm.rank.b");

        SerenityGem.setTagCompound(new NBTTagCompound());
        SerenityGem.getTagCompound().setString("material", "sm.serenitygem");
        SerenityGem.getTagCompound().setString("rank", "sm.rank.a");

        SerenityCrystal.setTagCompound(new NBTTagCompound());
        SerenityCrystal.getTagCompound().setString("material", "sm.serenitycrystal");
        SerenityCrystal.getTagCompound().setString("rank", "sm.rank.s");


        StormyShard.setTagCompound(new NBTTagCompound());
        StormyShard.getTagCompound().setString("material", "sm.stormyshard");
        StormyShard.getTagCompound().setString("rank", "sm.rank.c");

        StormyStone.setTagCompound(new NBTTagCompound());
        StormyStone.getTagCompound().setString("material", "sm.stormystone");
        StormyStone.getTagCompound().setString("rank", "sm.rank.b");

        StormyGem.setTagCompound(new NBTTagCompound());
        StormyGem.getTagCompound().setString("material", "sm.stormygem");
        StormyGem.getTagCompound().setString("rank", "sm.rank.a");

        StormyCrystal.setTagCompound(new NBTTagCompound());
        StormyCrystal.getTagCompound().setString("material", "sm.stormycrystal");
        StormyCrystal.getTagCompound().setString("rank", "sm.rank.s");


        TranquilShard.setTagCompound(new NBTTagCompound());
        TranquilShard.getTagCompound().setString("material", "sm.tranquilshard");
        TranquilShard.getTagCompound().setString("rank", "sm.rank.c");

        TranquilStone.setTagCompound(new NBTTagCompound());
        TranquilStone.getTagCompound().setString("material", "sm.tranquilstone");
        TranquilStone.getTagCompound().setString("rank", "sm.rank.b");

        TranquilGem.setTagCompound(new NBTTagCompound());
        TranquilGem.getTagCompound().setString("material", "sm.tranquilgem");
        TranquilGem.getTagCompound().setString("rank", "sm.rank.a");

        TranquilCrystal.setTagCompound(new NBTTagCompound());
        TranquilCrystal.getTagCompound().setString("material", "sm.tranquilcrystal");
        TranquilCrystal.getTagCompound().setString("rank", "sm.rank.s");


        TwilightShard.setTagCompound(new NBTTagCompound());
        TwilightShard.getTagCompound().setString("material", "sm.twilightshard");
        TwilightShard.getTagCompound().setString("rank", "sm.rank.c");

        TwilightStone.setTagCompound(new NBTTagCompound());
        TwilightStone.getTagCompound().setString("material", "sm.twilightstone");
        TwilightStone.getTagCompound().setString("rank", "sm.rank.b");

        TwilightGem.setTagCompound(new NBTTagCompound());
        TwilightGem.getTagCompound().setString("material", "sm.twilightgem");
        TwilightGem.getTagCompound().setString("rank", "sm.rank.a");

        TwilightCrystal.setTagCompound(new NBTTagCompound());
        TwilightCrystal.getTagCompound().setString("material", "sm.twilightcrystal");
        TwilightCrystal.getTagCompound().setString("rank", "sm.rank.s");


        Orichalcum.setTagCompound(new NBTTagCompound());
        Orichalcum.getTagCompound().setString("material", "sm.orichalcum");
        Orichalcum.getTagCompound().setString("rank", "sm.rank.a");

        OrichalcumPlus.setTagCompound(new NBTTagCompound());
        OrichalcumPlus.getTagCompound().setString("material", "sm.orichalcum+");
        OrichalcumPlus.getTagCompound().setString("rank", "sm.rank.s");

        LostIllusion.setTagCompound(new NBTTagCompound());
        LostIllusion.getTagCompound().setString("material", "sm.lostillusion");
        LostIllusion.getTagCompound().setString("rank", "sm.rank.s");

        ManifestIllusion.setTagCompound(new NBTTagCompound());
        ManifestIllusion.getTagCompound().setString("material", "sm.manifestillusion");
        ManifestIllusion.getTagCompound().setString("rank", "sm.rank.a");

        itemsForSale.add(BlazingShard);
        itemsForSale.add(BlazingStone);
        itemsForSale.add(BlazingGem);
        itemsForSale.add(BlazingCrystal);

        itemsForSale.add(BrightShard);
        itemsForSale.add(BrightStone);
        itemsForSale.add(BrightGem);
        itemsForSale.add(BrightCrystal);

        itemsForSale.add(DarkShard);
        itemsForSale.add(DarkStone);
        itemsForSale.add(DarkGem);
        itemsForSale.add(DarkCrystal);

        itemsForSale.add(DenseShard);
        itemsForSale.add(DenseStone);
        itemsForSale.add(DenseGem);
        itemsForSale.add(DenseCrystal);

        itemsForSale.add(EnergyShard);
        itemsForSale.add(EnergyStone);
        itemsForSale.add(EnergyGem);
        itemsForSale.add(EnergyCrystal);

        itemsForSale.add(FrostShard);
        itemsForSale.add(FrostStone);
        itemsForSale.add(FrostGem);
        itemsForSale.add(FrostCrystal);

        itemsForSale.add(LightningShard);
        itemsForSale.add(LightningStone);
        itemsForSale.add(LightningGem);
        itemsForSale.add(LightningCrystal);

        itemsForSale.add(LucidShard);
        itemsForSale.add(LucidStone);
        itemsForSale.add(LucidGem);
        itemsForSale.add(LucidCrystal);

        itemsForSale.add(PowerShard);
        itemsForSale.add(PowerStone);
        itemsForSale.add(PowerGem);
        itemsForSale.add(PowerCrystal);

        itemsForSale.add(RemembranceShard);
        itemsForSale.add(RemembranceStone);
        itemsForSale.add(RemembranceGem);
        itemsForSale.add(RemembranceCrystal);

        itemsForSale.add(SerenityShard);
        itemsForSale.add(SerenityStone);
        itemsForSale.add(SerenityGem);
        itemsForSale.add(SerenityCrystal);

        itemsForSale.add(StormyShard);
        itemsForSale.add(StormyStone);
        itemsForSale.add(StormyGem);
        itemsForSale.add(StormyCrystal);

        itemsForSale.add(TranquilShard);
        itemsForSale.add(TranquilStone);
        itemsForSale.add(TranquilGem);
        itemsForSale.add(TranquilCrystal);

        itemsForSale.add(TwilightShard);
        itemsForSale.add(TwilightStone);
        itemsForSale.add(TwilightGem);
        itemsForSale.add(TwilightCrystal);

        itemsForSale.add(Orichalcum);
        itemsForSale.add(OrichalcumPlus);

        itemsForSale.add(ManifestIllusion);
        itemsForSale.add(LostIllusion);

        itemsForSale.add(new ItemStack(ModItems.Potion));
        itemsForSale.add(new ItemStack(ModItems.Ether));

    }

    @Override
    protected int getSize () {
        return itemsForSale.size();
    }

    @Override
    protected void elementClicked (int index, boolean doubleClick) {
        parent.buySelected = index;
        parent.updateButtons();
    }

    @Override
    protected boolean isSelected (int index) {
        if (index == parent.buySelected) return true;
        return false;
    }

    @Override
    protected void drawBackground () {

    }

    @Override
    protected void drawSlot (int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {

        String name = itemsForSale.get(slotIdx).getDisplayName();

        if (itemsForSale.get(slotIdx).hasTagCompound()) {
            if (itemsForSale.get(slotIdx).getTagCompound().hasKey("material")) {
                name = Utils.translateToLocal(itemsForSale.get(slotIdx).getTagCompound().getString("material") + ".name");
            }
        }
        Minecraft.getMinecraft().fontRenderer.drawString(name, this.left + 3, slotTop, 0xFFFFFF);
        for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
            if (ItemEvents.areItemStacksEqual(stack, itemsForSale.get(slotIdx))) {
                Minecraft.getMinecraft().fontRenderer.drawString(MunnyRegistry.munnyValues.get(stack)+"", this.left + 3, slotTop + 12, 0xFFFF55);
            }
        }
    }

    public void drawBuySelected() {
        int posX = 220;
        if (parent.buySelected != -1) {
            Minecraft.getMinecraft().renderEngine.bindTexture(parent.optionsBackground);
            drawGradientRect(posX - 10, 60, 700, parent.height - ((parent.height / 8) + 70 / 16), -1072689136, -804253680);
        }
        GL11.glPushMatrix(); {
            GL11.glTranslatef(posX, 70, 0);
            GL11.glScalef(2, 2, 2);
            parent.drawString(Minecraft.getMinecraft().fontRenderer, itemsForSale.get(parent.buySelected).getDisplayName(), 0, 0, 0xFFFFFF);
        }
        GL11.glPopMatrix();
        parent.drawString(Minecraft.getMinecraft().fontRenderer, Utils.translateToLocal(Strings.Gui_Shop_Buy_Quantity), 220, parent.height - ((parent.height / 8) + 70 / 16) - 60, 0xFFFFFF);
        GL11.glPushMatrix(); {
            GL11.glTranslatef(posX, 90, 0);
            for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
                if (ItemEvents.areItemStacksEqual(stack, itemsForSale.get(parent.buySelected))) {
                    Minecraft.getMinecraft().fontRenderer.drawString(Utils.translateToLocal(Strings.Gui_Shop_Buy_Cost) + ": " + MunnyRegistry.munnyValues.get(stack), 0, 0, 0xFFFF55);
                }
            }
        }
        GL11.glPopMatrix();
    }

}