package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.item.Item;

/**
 * Created by Toby on 27/04/2017.
 */
public class UnlockNode {

    public UnlockNode parent;
    public int xPos, yPos;
    Item unlock;
    boolean unlocked;

    public UnlockNode(int x, int y, Item unlock, UnlockNode parent) {
        xPos = x;
        yPos = y;
        this.unlock = unlock;
        this.parent = parent;
    }

    public UnlockNode getParent() {
        return parent;
    }

    public void setParent(UnlockNode parent) {
        this.parent = parent;
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

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
