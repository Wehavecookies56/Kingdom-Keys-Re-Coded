package uk.co.wehavecookies56.kk.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;

public class ContainerKKChest extends Container {

    private TileEntityKKChest tileEntityKKChest;

    private final int HOTBAR_SLOT_COUNT = 9;
    private final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    private final int VANILLA_FIRST_SLOT_INDEX = 0;
    private final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private final int TE_INVENTORY_COLUMN_COUNT = 9;
    private final int TE_INVENTORY_ROW_COUNT = 4;

    private final int TE_INVENTORY_SLOT_COUNT = TE_INVENTORY_ROW_COUNT * TE_INVENTORY_COLUMN_COUNT;

    public ContainerKKChest (InventoryPlayer invPlayer, TileEntityKKChest tileEntityKKChest) {
        this.tileEntityKKChest = tileEntityKKChest;
        IItemHandler inventory = tileEntityKKChest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        if (TE_INVENTORY_SLOT_COUNT != inventory.getSlots()) System.err.println("Mismatched slot count in ContainerBasic(" + TE_INVENTORY_SLOT_COUNT + ") and TileInventory (" + inventory.getSlots() + ")");

        int i;
        int j;

        for (i = 0; i < 4; i++)
            for (j = 0; j < 9; j++)
                addSlotToContainer(new SlotItemHandler(inventory, j + i * 9, 8 + j * 18, 20 + i * 18) {
                    @Override
                    public void onSlotChanged() {
                        inventory.markDirty();
                    }
                });

        for (i = 0; i < 3; ++i)
            for (j = 0; j < 9; ++j)
                addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 105 + i * 18));

        for (i = 0; i < 9; ++i)
            addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 163));
    }

    @Override
    public boolean canInteractWith (EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot (EntityPlayer player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemStack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack1);
        }

        return itemStack;
    }
}