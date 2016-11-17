package uk.co.wehavecookies56.kk.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.container.slot.SlotCustom;

public class ContainerPedestal extends Container {

	private TileEntityPedestal tileEntityPedestal;

	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
	private final int VANILLA_FIRST_SLOT_INDEX = 0;
	
	private final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

	private final int TE_INVENTORY_SLOT_COUNT = 1;

	public ContainerPedestal (InventoryPlayer invPlayer, TileEntityPedestal tileEntityPedestal) {
		this.tileEntityPedestal = tileEntityPedestal;

		if (TE_INVENTORY_SLOT_COUNT != tileEntityPedestal.getSizeInventory()) System.err.println("Mismatched slot count in ContainerBasic(" + TE_INVENTORY_SLOT_COUNT + ") and TileInventory (" + tileEntityPedestal.getSizeInventory() + ")");
		
		int i;
		int j;
		
		addSlotToContainer(new SlotCustom(tileEntityPedestal, 0, 80, 56, 6));


		for (i = 0; i < 3; ++i)
			for (j = 0; j < 9; ++j)
				addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 105 + i * 18));

		for (i = 0; i < 9; ++i)
			addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 163));
	}

	@Override
	public boolean canInteractWith (EntityPlayer player) {
		return tileEntityPedestal.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot (EntityPlayer player, int sourceSlotIndex) {
		Slot sourceSlot = inventorySlots.get(sourceSlotIndex);
		if (sourceSlot == null || !sourceSlot.getHasStack()) return null;
		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
			if (!mergeItemStack(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) return null;
		} else if (sourceSlotIndex >= TE_INVENTORY_FIRST_SLOT_INDEX && sourceSlotIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
			if (!mergeItemStack(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) return null;
		} else {
			System.err.print("Invalid slotIndex: " + sourceSlotIndex);
			return null;
		}

		if (sourceStack.stackSize == 0)
			sourceSlot.putStack(null);
		else
			sourceSlot.onSlotChanged();

		sourceSlot.onPickupFromSlot(player, sourceStack);
		return copyOfSourceStack;
	}

	@Override
	public void onContainerClosed (EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		this.tileEntityPedestal.closeInventory(playerIn);
	}
}