package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.item.Item;

/**
 * Created by Toby on 27/04/2017.
 */
public class UnlockNode {

    public UnlockNode[] parents;
    public int xPos, yPos;
    Item unlock;
    boolean unlocked;
    boolean unlockable;

    public UnlockNode(int x, int y, Item unlock, UnlockNode[] parents) {
        xPos = x;
        yPos = y;
        this.unlock = unlock;
        this.parents = parents;
    }

    public UnlockNode[] getParents() {
        return parents;
    }

    public void setParents(UnlockNode[] parents) {
        this.parents = parents;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Item getUnlock() {
        return unlock;
    }

    public void setUnlock(Item unlock) {
        this.unlock = unlock;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public boolean isUnlockable() {
        return unlockable;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setUnlockable(boolean unlockable) {
        this.unlockable = unlockable;
    }
}
