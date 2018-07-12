package uk.co.wehavecookies56.kk.common.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import uk.co.wehavecookies56.kk.client.gui.*;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.container.ContainerDriveForms;
import uk.co.wehavecookies56.kk.common.container.ContainerKKChest;
import uk.co.wehavecookies56.kk.common.container.ContainerKeychain;
import uk.co.wehavecookies56.kk.common.container.ContainerPedestal;
import uk.co.wehavecookies56.kk.common.container.ContainerPotionsMenu;
import uk.co.wehavecookies56.kk.common.container.ContainerSpells;
import uk.co.wehavecookies56.kk.common.container.ContainerSynthesisBagL;
import uk.co.wehavecookies56.kk.common.container.ContainerSynthesisBagM;
import uk.co.wehavecookies56.kk.common.container.ContainerSynthesisBagS;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;

/**
 * Created by Toby on 28/03/2016.
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(xyz);

        if (ID == GuiIDs.GUI_KEYCHAIN_INV)
            return new ContainerKeychain(player, player.inventory);
        else if (ID == GuiIDs.GUI_POTIONS_INV)
            return new ContainerPotionsMenu(player, player.inventory);
        else if (ID == GuiIDs.GUI_SPELLS_INV)
            return new ContainerSpells(player, player.inventory);
        else if (ID == GuiIDs.GUI_DRIVE_INV)
            return new ContainerDriveForms(player, player.inventory);
        else if (ID == GuiIDs.GUI_KKCHEST_INV) {
            if (te instanceof TileEntityKKChest)
                return new ContainerKKChest(player.inventory, (TileEntityKKChest) world.getTileEntity(new BlockPos(x, y, z)));
            else
                return null;
        } else if (ID == GuiIDs.GUI_SPELLS_INV) {
            return null;
        } else if (ID == GuiIDs.GUI_SYNTHESISBAGS_INV)
            return new ContainerSynthesisBagS(player, player.inventory);
        else if (ID == GuiIDs.GUI_SYNTHESISBAGM_INV)
            return new ContainerSynthesisBagM(player, player.inventory);
        else if (ID == GuiIDs.GUI_SYNTHESISBAGL_INV)
            return new ContainerSynthesisBagL(player, player.inventory);
        else if (ID == GuiIDs.GUI_PEDESTAL_INV) {
            if (te instanceof TileEntityPedestal)
                return new ContainerPedestal(player.inventory, (TileEntityPedestal) world.getTileEntity(new BlockPos(x, y, z)));
            else
                return null;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(xyz);

        if (ID == GuiIDs.GUI_KEYCHAIN_INV)
            return new GuiKeychains(player, player.inventory);
        else if (ID == GuiIDs.GUI_POTIONS_INV)
            return new GuiPotions(player, player.inventory);
        else if (ID == GuiIDs.GUI_SPELLS_INV)
            return new GuiSpells(player, player.inventory);
        else if (ID == GuiIDs.GUI_DRIVE_INV)
            return new GuiDriveForms(player, player.inventory);
        else if (ID == GuiIDs.GUI_KKCHEST_INV) {
            if (te instanceof TileEntityKKChest)
                return new GuiKKChest(player.inventory, (TileEntityKKChest) world.getTileEntity(new BlockPos(x, y, z)));
            else
                return null;
        }
        else if (ID == GuiIDs.GUI_SYNTHESISTABLE)
            return new GuiSynthesis(null);
        else if (ID == GuiIDs.GUI_SYNTHESISBAGS_INV)
            return new GuiSynthesisBagS(player, player.inventory);
        else if (ID == GuiIDs.GUI_SYNTHESISBAGM_INV)
            return new GuiSynthesisBagM(player, player.inventory);
        else if (ID == GuiIDs.GUI_SYNTHESISBAGL_INV) 
            return new GuiSynthesisBagL(player, player.inventory);
        else if (ID == GuiIDs.GUI_SHOP) 
            return new GuiShop(null);
        else if (ID == GuiIDs.GUI_PEDESTAL_INV)
            if (te instanceof TileEntityPedestal)
                return new GuiPedestal(player.inventory, (TileEntityPedestal) world.getTileEntity(new BlockPos(x, y, z)));
            else
                return null;
        else if (ID == GuiIDs.GUI_ORG_WEAPONS)
            return new GuiOrgWeapon();
        else if (ID == GuiIDs.GUI_ORG)
            return new GuiOrg();
        else if (ID == GuiIDs.GUI_ORG_UNLOCK)
            return new GuiOrgUnlock();
        else if (ID == GuiIDs.GUI_PLAYER_ITEMS) {
            System.out.println("TEST");
            return new GuiMenu_Items_Player();
        }
        return null;

    }
}
