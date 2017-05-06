package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Toby on 27/04/2017.
 */
public class GuiOrgUnlock extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/org/org_unlock.png");
    ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

    int texWidth = 256;
    int texHeight = 202;

    int maxHeight = 650;
    int minHeight = -100;
    int maxWidth = 200;
    int minWidth = -200;

    int dispX = 0;
    int dispY = 0;
    int startDispX = 0;
    int startDispY = 0;

    int mouseStartX = 0;
    int mouseStartY = 0;

    GuiButton unlock;
    final int UNLOCK = 0;

    UnlockNode selected;

    GuiNodeButton[] unlocks;

    public GuiOrgUnlock() {
        Utils.OrgMember member = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember();
        unlocks = new GuiNodeButton[50];
        if (member != null && member != Utils.OrgMember.NONE) {
            switch (member) {
                case XEMNAS:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.Malice, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Sanction, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Overlord, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Veneration, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Autocracy, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.Conquest, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Terminus, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Judgement, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Discipline, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Aristocracy, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Superiority, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Aggression, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Fury, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Despair, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.Triumph, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Ruination, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Domination, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Annihilation, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Tyrant, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.Magnificence, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.Infinity, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Interdiction, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.RoundFan, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Absolute, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case XIGBAR:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.Standalone, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Killerbee, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Stingray, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Counterweight, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Precision, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.DualHead, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Bahamut, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Gullwing, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.BlueFrame, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.StarShell, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Sunrise, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Ignition, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Armstrong, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.HardBoiledHeat, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.DiabloEye, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.DoubleTap, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Stardust, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.EnergyMuzzle, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.CrimeAndPunishment, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.CupidsArrow, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.FinalWeapon, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Sharpshooter, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.Dryer, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Trumpet, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case XALDIN:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.Zephyr, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Moonglade, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Aer, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Nescience, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Brume, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.Asura, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Crux, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Paladin, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Fellking, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Nightcloud, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Shimmer, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Vortex, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Scission, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Heavenfall, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.Aether, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Mazzaroth, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Hegemon, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Foxfire, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Yaksha, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.Cynosura, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.Dragonreign, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Lindworm, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.Broom, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Wyvern, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case VEXEN:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.TesterZero, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.ProductOne, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.DeepFreeze, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.CryoliteShield, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.FalseTheory, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.Glacier, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.AbsoluteZero, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Gunz, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Mindel, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Snowslide, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Iceberg, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Inquisition, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Scrutiny, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Empiricism, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.Edification, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Contrivance, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Wurm, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Subzero, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.ColdBlood, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.DiamondShield, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.Aegis, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.FrozenPride, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.PotLid, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Snowman, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case LEXAEUS:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.Reticence, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Goliath, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.CopperRed, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Daybreak, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Colossus, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.UrsaMajor, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Megacosm, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Terrene, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Fuligin, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.HardWinter, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Firefly, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Harbinger, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Redwood, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Sequoia, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.IronBlack, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Earthshine, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Octiron, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Hyperion, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Clarity, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.OneThousandAndOneNights, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.CardinalVirtue, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Skysplitter, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.BleepBloopBop, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Monolith, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case ZEXION:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.BlackPrimer, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.WhiteTome, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.IllicitResearch, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.BuriedSecrets, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.ArcaneCompendium, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.DissentersNotes, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.NefariousCodex, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.MysticAlbum, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.CursedManual, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.TabooText, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.EldritchEsoterica, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.FreakishBestiary, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.MadmansVita, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.UntitledWritings, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.AbandonedDogma, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.AtlasOfOmens, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.RevoltingScrapbook, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.LostHeterodoxy, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.OtherworldlyTales, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.IndescribableLore, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.RadicalTreatise, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.BookofRetribution, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.MidnightSnack, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.DearDiary, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case SAIX:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.NewMoon, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Werewolf, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Artemis, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Luminary, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Selene, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.Moonrise, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Astrologia, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Crater, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.LunarPhase, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Crescent, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Gibbous, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Berserker, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Twilight, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.QueenOfTheNight, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.BalsamicMoon, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Orbit, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.LightYear, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.KingOfTheNight, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Moonset, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.Horoscope, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.Dichotomy, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Lunatic, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.JustDesserts, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Bunnymoon, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case AXEL:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode(0,  0,   ModItems.Ashes, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Doldrums, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode(0,  -2,  ModItems.DelayedAction, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode(2,  -2,  ModItems.DiveBombers, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Combustion, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.MoulinRouge, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode(1,  -4,  ModItems.BlazeofGlory, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode(3,  -4,  ModItems.Prometheus, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Ifrit, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode(0,  -6,  ModItems.MagmaOcean, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode(2,  -6,  ModItems.Volcanis, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Inferno, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode(1,  -8,  ModItems.SizzlingEdge, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Corona, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.FerrisWheel, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode(1,  -10, ModItems.Burnout, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode(3,  -10, ModItems.OmegaTrinity, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Outbreak, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode(0,  -12, ModItems.DoubleEdge, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode(2,  -12, ModItems.Wildfire, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode(0,  -14, ModItems.Prominence, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode(0,  -16, ModItems.EternalFlames, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.PizzaCut, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode(1,  -18, ModItems.Conformers, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case DEMYX:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.BasicModel, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.TuneUp, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Quartet, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Quintet, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Overture, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.OldHand, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.DaCapo, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.PowerChord, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Fermata, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Interlude, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.Serenade, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Songbird, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.RiseToFame, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.RockStar, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.EightFinger, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Concerto, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Harmonics, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.MillionBucks, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Fortissimo, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.UpToEleven, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.Sanctuary, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Arpeggio, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.PrinceOfAwesome, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.AfterSchool, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case LUXORD:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.TheFool, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.TheMagician, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.TheStar, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.TheMoon, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Justice, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.TheHierophant, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.TheWorld, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Temperance, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.TheHighPriestess, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.TheTower, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.TheHangedMan, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Death, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.TheHermit, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Strength, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.TheLovers, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.TheChariot, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.TheSun, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.TheDevil, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.TheEmpress, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.TheEmperor, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.TheJoker, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.FairGame, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.FinestFantasy13, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.HighRollersSecret, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case MARLUXIA:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.FickleErica, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.JiltedAnemone, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.ProudAmaryllis, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.MadSafflower, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.PoorMelissa, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.TragicAllium, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.MournfalCineria, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.PseudoSilene, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.FaithlessDigitalis, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.GrimMuscari, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.DocileVallota, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.QuietBelladonna, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.PartingIpheion, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.LoftyGerbera, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.GallantAchillea, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.NoblePeony, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.FearsomeAnise, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.VindictiveThistle, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.FairHelianthus, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.SolemnMagnolia, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.HallowedLotus, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.GracefulDahlia, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.StirringLadle, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.DaintyBellflowers, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case LARXENE:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.Trancheuse, null), this);
                    unlocks[1]  = new GuiNodeButton(2,  0, 0, new UnlockNode(-2, -2,  ModItems.Orage, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[2]  = new GuiNodeButton(3,  0, 0, new UnlockNode( 0, -2,  ModItems.Tourbillon, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[3]  = new GuiNodeButton(4,  0, 0, new UnlockNode( 2, -2,  ModItems.Tempete, new UnlockNode[]{unlocks[0].getNode()}), this);
                    unlocks[4]  = new GuiNodeButton(5,  0, 0, new UnlockNode(-3, -4,  ModItems.Carmin, new UnlockNode[]{unlocks[1].getNode()}), this);
                    unlocks[5]  = new GuiNodeButton(6,  0, 0, new UnlockNode(-1, -4,  ModItems.Meteore, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    unlocks[6]  = new GuiNodeButton(7,  0, 0, new UnlockNode( 1, -4,  ModItems.Etoile, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    unlocks[7]  = new GuiNodeButton(8,  0, 0, new UnlockNode( 3, -4,  ModItems.Irregulier, new UnlockNode[]{unlocks[3].getNode()}), this);
                    unlocks[8]  = new GuiNodeButton(9,  0, 0, new UnlockNode(-2, -6,  ModItems.Dissonance, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    unlocks[9]  = new GuiNodeButton(10, 0, 0, new UnlockNode( 0, -6,  ModItems.Eruption, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode( 2, -6,  ModItems.SoleilCouchant, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8,  ModItems.Indigo, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode( 1, -8,  ModItems.Vague, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Deluge, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.Rafale, new UnlockNode[]{unlocks[11].getNode()}), this);
                    unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode( 1, -10, ModItems.Typhon, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode( 3, -10, ModItems.Extirpeur, new UnlockNode[]{unlocks[12].getNode()}), this);
                    unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.CroixDuSud, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode( 0, -12, ModItems.Lumineuse, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode( 2, -12, ModItems.ClairdeLune, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode( 0, -14, ModItems.VoldeNuit, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode( 0, -16, ModItems.Foudre, new UnlockNode[]{unlocks[20].getNode()}), this);
                    unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.Demoiselle, new UnlockNode[]{unlocks[21].getNode()}), this);
                    unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode( 1, -18, ModItems.Ampoule, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
                case ROXAS:
                    unlocks[0]  = new GuiNodeButton(1,  0, 0, new UnlockNode( 0, 0,   ModItems.KingdomKey, null), this);
                    break;
            }
        }
    }

    public Dimension convertToGUICoords(UnlockNode node) {
        double zeroX = (double) width / 2.0D;
        double zeroY = (double) height / 2.0D;
        int scale = 32;
        return new Dimension((int)zeroX + (node.getxPos()*scale),(int)zeroY + (node.getyPos()*scale));
    }

    public void drawNodes(int mouseX, int mouseY, GuiNodeButton[] nodes) {
        GlStateManager.color(1, 1, 1, 1);
        for(GuiNodeButton n : nodes) {
            if (n != null) {
                Dimension d = convertToGUICoords(n.getNode());
                if (n.getNode().getParents() != null) {
                    UnlockNode[] parents = n.getNode().getParents();
                    for (UnlockNode p : parents) {
                        if (p != null) {
                            List<Item> unlockedWeapons = mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).unlockedWeapons();
                            GlStateManager.pushMatrix();
                            Dimension pd = convertToGUICoords(p);
                            GlStateManager.disableTexture2D();
                            GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                            if (unlockedWeapons.contains(p.getUnlock())) {
                                n.getNode().setUnlockable(true);
                                if (unlockedWeapons.contains(n.getNode().getUnlock())) {
                                    n.getNode().setUnlocked(true);
                                }
                                GlStateManager.color(1, 1, 1, 1);
                            } else {
                                GlStateManager.color(0, 0, 0, 0.2F);
                            }
                            GL11.glLineWidth(3F);
                            GlStateManager.glBegin(GL11.GL_LINES);
                            GlStateManager.glVertex3f((float) d.getWidth() + dispX, (float) d.getHeight() + dispY, 0);
                            GlStateManager.glVertex3f((float) pd.getWidth() + dispX, (float) pd.getHeight() + dispY, 0);
                            GlStateManager.glEnd();
                            GlStateManager.enableTexture2D();
                            GlStateManager.color(1, 1, 1);
                            GlStateManager.popMatrix();
                        }
                    }
                } else {
                    n.getNode().setUnlocked(true);
                }
            }
        }
        for(GuiNodeButton n : nodes) {
            if (n != null) {
                Dimension d = convertToGUICoords(n.getNode());
                n.xPosition = (int) d.getWidth();
                n.yPosition = (int) d.getHeight();
                n.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        GL11.glPushMatrix();
        ScaledResolution sr = new ScaledResolution(mc);
        int sw = 255;
        int sh = 190;
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor(((width / 2) - (texWidth / 2)) * sr.getScaleFactor(), ((height / 2) - (texHeight / 2)) * sr.getScaleFactor() + 10, sw * sr.getScaleFactor(), sh * sr.getScaleFactor());
        Minecraft.getMinecraft().renderEngine.bindTexture(background);
        GL11.glColor4f(0.15F, 0.15F, 0.15F, 1);
        drawModalRectWithCustomSizedTexture((((width / 2) - (texWidth / 2)) * sr.getScaleFactor() + dispX) - 1000, (((height / 2) - (texHeight / 2)) * sr.getScaleFactor() + dispY) - 1000,0, 0, 2000,2000, 32, 32);
        drawNodes(mouseX, mouseY, unlocks);
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
        GL11.glPopMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int posX = (width / 2) - (texWidth / 2);
        int posY = (height / 2) - (texHeight / 2);
        drawTexturedModalRect(posX, posY, 0, 0, texWidth, texHeight);
        fontRendererObj.drawString("Weapon unlocks for " + Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember().toString(), posX + 5, posY + 5, 0x2B2B2B);
        fontRendererObj.drawString("Points: " + Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getUnlockPoints(), posX + 256 - fontRendererObj.getStringWidth("Points: " + Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getUnlockPoints()) - 5, posY + 5, 0x2B2B2B);
        super.drawScreen(mouseX, mouseY, partialTicks);
        if (selected != null)
            fontRendererObj.drawString(new ItemStack(selected.unlock).getDisplayName() + " selected", (width / 2) - (texWidth / 2) + 5, (height / 2) - (texHeight / 2) + 180, 0x2B2B2B);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case UNLOCK:
                if (selected != null) {
                    OrganizationXIIICapability.IOrganizationXIII weapons = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
                    weapons.addUnlockedWeapon(selected.getUnlock());
                    weapons.removePoints(1);
                    PacketDispatcher.sendToServer(new SyncOrgXIIIData(weapons));
                }
                break;
        }
        updateButtons();
        super.actionPerformed(button);
    }

    @Override
    public void initGui() {
        buttonList.add(unlock = new GuiButton(UNLOCK, (width / 2) - (texWidth / 2) + 180, (height / 2) - (texWidth / 2) + 202, "Unlock"));
        unlock.width = 60;
        updateButtons();
        super.initGui();
    }

    public void updateButtons() {
        if (selected != null) {
            if (Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).unlockedWeapons().contains(selected.getUnlock())) {
                selected.unlockable = false;
                selected.unlocked = true;
            }
            if (Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getUnlockPoints() < 1) {
                selected.unlockable = false;
            }
            if (selected.unlockable) {
                unlock.enabled = true;
                unlock.displayString = "Unlock";
            } else if (selected.unlocked) {
                unlock.enabled = false;
                unlock.displayString = "Unlocked";
            } else {
                unlock.enabled = false;
                unlock.displayString = "Locked";
            }
        } else {
            unlock.enabled = false;
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        //mouseButton 0 == M1, 1 == M2, 2 == M3, 3 == M4, 4 == M5
        for(GuiNodeButton n : unlocks) {
            if (n != null)
                n.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
        }
        if (mouseButton == 0) {
            mouseStartX = mouseX;
            mouseStartY = mouseY;
            startDispX = dispX;
            startDispY = dispY;
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        if (clickedMouseButton == 0) {
            dispX = dispX >= 0 ? Math.min(startDispX + ((mouseX - mouseStartX)), maxWidth) : Math.max(startDispX + ((mouseX - mouseStartX)), minWidth);
            dispY = dispY >= 0 ? Math.min(startDispY + ((mouseY - mouseStartY)), maxHeight) :  Math.max(startDispY + ((mouseY - mouseStartY)), minHeight);
        }
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }
}
