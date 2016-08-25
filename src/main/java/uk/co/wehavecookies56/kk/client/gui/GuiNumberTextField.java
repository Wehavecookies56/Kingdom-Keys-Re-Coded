package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

/**
 * Created by Toby on 19/07/2016.
 */
public class GuiNumberTextField extends GuiTextField {

    int maxValue;

    public GuiNumberTextField (int componentId, FontRenderer fontrendererObj, int x, int y, int width, int height, int maxValue) {
        super(componentId, fontrendererObj, x, y, width, height);
        this.setMaxStringLength(String.valueOf(maxValue).length());
        this.maxValue = maxValue;

    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isNumber (char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean textboxKeyTyped (char c, int id) {
        switch (id) {
            case Keyboard.KEY_BACK:
                this.deleteFromCursor(0);
                break;
            case Keyboard.KEY_LEFT:
                this.moveCursorBy(0);
                break;
            case Keyboard.KEY_RIGHT:
                this.moveCursorBy(0);
                break;
            default:
                if (isNumber(c)) {
                    String text = new StringBuilder(this.getText()).insert(this.getCursorPosition(), c).toString();
                    if (Integer.parseInt(text) > maxValue) {
                        return false;
                    }
                } else {
                    return false;
                }
                break;
        }
        return super.textboxKeyTyped(c, id);
    }
}
