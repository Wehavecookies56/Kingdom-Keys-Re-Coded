package uk.co.wehavecookies56.kk.common.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagL;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagM;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagS;
import uk.co.wehavecookies56.kk.common.item.base.ItemDriveForm;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemSpellOrb;
import uk.co.wehavecookies56.kk.common.item.org.ItemOrgShield;

public class SlotCustom extends SlotItemHandler {
    int window;

    public SlotCustom (IItemHandler inventory, int index, int x, int y, int window) {
        super(inventory, index, x, y);
        this.window = window;
    }

    @Override
    public boolean canTakeStack(EntityPlayer playerIn) {
        switch (window) {
            case 1:
                if (playerIn.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned(EnumHand.MAIN_HAND)) {
                    return false;
                }
                break;
        }
        return super.canTakeStack(playerIn);
    }

    @Override
    public boolean isItemValid (ItemStack stack) {
        /*
         * 1-KeyChain 2-SynthBag 3-Potion 4-Spells 5-DriveForms 6-Pedestal
         */
        switch (window) {
            case 1:
                if (stack.getItem() instanceof ItemKeychain) return true;
                break;
            case 2:
                if (stack.getItem() instanceof ItemSynthesisBagS || stack.getItem() instanceof ItemSynthesisBagM || stack.getItem() instanceof ItemSynthesisBagL) return true;
                break;
            case 3:
                if (stack.getItem() instanceof ItemKKPotion) return true;
                break;
            case 4:
                if (stack.getItem() instanceof ItemSpellOrb) return true;
                break;
            case 5:
                if (stack.getItem() instanceof ItemDriveForm) return true;
                break;
            case 6:
                if (stack.getItem() instanceof ItemKeyblade || stack.getItem() instanceof ItemKeychain || stack.getItem() instanceof ItemOrgShield) return true;
                break;
        }
        return false;
    }
}
