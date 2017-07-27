package uk.co.wehavecookies56.kk.common.container;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagM;
import uk.co.wehavecookies56.kk.common.container.slot.SlotSynthesisBag;

public class ContainerSynthesisBagM extends Container {

    private IItemHandler inventory;

    private static final int INV_START = InventorySynthesisBagM.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

    public ContainerSynthesisBagM (EntityPlayer player, InventoryPlayer invPlayer) {
        if (invPlayer.getCurrentItem().hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            inventory = invPlayer.getCurrentItem().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            int i;
            int j;

            // Bag Inventory
            for (i = 0; i < 4; i++)
                for (j = 0; j < 7; j++)
                    addSlotToContainer(new SlotSynthesisBag(inventory, j + i * 7, 26 + j * 18, 18 + i * 18) {
                        @Override
                        public void onSlotChange(@Nonnull ItemStack p_75220_1_, @Nonnull ItemStack p_75220_2_) {
                            inventory.markDirty();
                        }
                    });

            for (i = 0; i < 3; ++i)
                for (j = 0; j < 9; ++j)
                    addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 94 + i * 18));

            for (i = 0; i < 9; ++i)
                addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 152));
        }
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

    @Override
    public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, EntityPlayer player) {
        if (slot >= 0 && getSlot(slot).getStack() == player.getHeldItem(EnumHand.MAIN_HAND)) return ItemStack.EMPTY;
        return super.slotClick(slot, dragType, clickTypeIn, player);
    }

    @Override
    protected boolean mergeItemStack (ItemStack stack, int start, int end, boolean backwards) {
        boolean flag1 = false;
        int k = (backwards ? end - 1 : start);
        Slot slot;
        ItemStack itemstack1;

        if (stack.isStackable()) while (stack.getCount() > 0 && (!backwards && k < end || backwards && k >= start)) {
            slot = inventorySlots.get(k);
            itemstack1 = slot.getStack();

            if (!slot.isItemValid(stack)) {
                k += (backwards ? -1 : 1);
                continue;
            }

            if (!ItemStack.areItemStacksEqual(itemstack1, ItemStack.EMPTY) && itemstack1.getItem() == stack.getItem() && (!stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, itemstack1)) {
                int l = itemstack1.getCount() + stack.getCount();

                if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
                    stack.setCount(0);
                    itemstack1.setCount(1);
                    flag1 = true;
                } else if (itemstack1.getCount() < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
                    stack.setCount(stack.getCount() - (stack.getMaxStackSize() - itemstack1.getCount()));
                    itemstack1.setCount(stack.getMaxStackSize());
                    flag1 = true;
                }
            }

            k += (backwards ? -1 : 1);
        }

        if (stack.getCount() > 0) {
            k = (backwards ? end - 1 : start);

            while (!backwards && k < end || backwards && k >= start) {
                slot = inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += (backwards ? -1 : 1);
                    continue;
                }

                if (ItemStack.areItemStacksEqual(itemstack1, ItemStack.EMPTY)) {
                    int l = stack.getCount();

                    if (l <= slot.getSlotStackLimit()) {
                        slot.putStack(stack.copy());
                        stack.setCount(0);
                        flag1 = true;
                        break;
                    } else {
                        putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
                        stack.setCount(stack.getCount() - slot.getSlotStackLimit());
                        flag1 = true;
                    }
                }

                k += (backwards ? -1 : 1);
            }
        }

        return flag1;
    }
}