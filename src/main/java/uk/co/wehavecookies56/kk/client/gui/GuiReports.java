package uk.co.wehavecookies56.kk.client.gui;

import static org.lwjgl.opengl.GL11.glColor4f;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.util.Utils;

@SideOnly (Side.CLIENT)
public class GuiReports extends GuiScreen {

    static ResourceLocation gui = new ResourceLocation(Reference.MODID, "textures/gui/book.png");
    static ResourceLocation chapterbutton = new ResourceLocation(Reference.MODID, "textures/gui/button.png");

    private static final int BOOK_BTN_NEXT = 0;
    private static final int BOOK_BTN_PREV = 1;

    private static final int BOOK_BTN_BACK = 2;
    private static final int BOOK_BTN_KEYBLADES = 3;
    private static final int BOOK_BTN_SYNTHESIS = 4;

    private static final int BOOK_BTN_KEYBLADE_SUMMON = 5;

    private static final int CHAPTER_MAIN = 0;
    private static final int CHAPTER_KEYBLADES = 1;
    private static final int CHAPTER_SUMMON = 2;

    private static final int WIDTH = 175;
    private static final int HEIGHT = 228;

    private GuiButton next;
    private GuiButton prev;
    private GuiButton keyblades;
    private GuiButton back;
    private GuiButton synthesis;
    private GuiButton summon;

    private int keybladesPageIndex = 0;
    private int summonPageIndex = 0;
    private int mainPageIndex = 0;
    private int chapterIndex = 0;
    private int chapterPages = 1;
    private int keybladesPages = 2;
    private int summonPages = 1;
    private int bookTotalPages = 11;

    private int bookXStart;

    @Override
    @SuppressWarnings ("all")
    public void initGui () {
        super.initGui();

        bookXStart = (width - WIDTH) / 2;

        buttonList.add(keyblades = new GuiButtonChapterChange(BOOK_BTN_KEYBLADES, bookXStart + 7, 30, false, "Keyblades"));
        buttonList.add(summon = new GuiButtonChapterChange(BOOK_BTN_KEYBLADE_SUMMON, bookXStart + 7, 30, false, "Summoning Keyblades"));
        buttonList.add(synthesis = new GuiButtonChapterChange(BOOK_BTN_SYNTHESIS, bookXStart + 7, 51, false, "Synthesis"));
        buttonList.add(next = new GuiButtonPageChange(BOOK_BTN_NEXT, bookXStart + WIDTH - 26, 210, false));
        buttonList.add(prev = new GuiButtonPageChange(BOOK_BTN_PREV, bookXStart + 10, 210, true));
        buttonList.add(back = new GuiButton(BOOK_BTN_BACK, bookXStart + (WIDTH / 2) - 30, 205, 60, 20, "Back"));

        updateButtons();
    }

    @Override
    protected void actionPerformed (GuiButton button) {
        switch (button.id) {
            case BOOK_BTN_NEXT:
                switch (chapterIndex) {
                    case CHAPTER_MAIN:
                        mainPageIndex++;
                        break;
                    case CHAPTER_KEYBLADES:
                        keybladesPageIndex++;
                        break;
                }
                break;
            case BOOK_BTN_PREV:
                switch (chapterIndex) {
                    case CHAPTER_MAIN:
                        --mainPageIndex;
                        break;
                    case CHAPTER_KEYBLADES:
                        --keybladesPageIndex;
                }
                break;
            case BOOK_BTN_KEYBLADES:
                chapterIndex = CHAPTER_KEYBLADES;
                break;
            case BOOK_BTN_BACK:
                switch (chapterIndex) {
                    case CHAPTER_KEYBLADES:
                        chapterIndex = CHAPTER_MAIN;
                        break;
                    case CHAPTER_SUMMON:
                        chapterIndex = CHAPTER_KEYBLADES;
                }
                break;
        }
        updateButtons();
    }

    private void updateButtons () {
        this.next.visible = (this.mainPageIndex < this.bookTotalPages - 1) && this.chapterIndex == CHAPTER_KEYBLADES;
        this.prev.visible = this.mainPageIndex > 0 && this.chapterIndex == CHAPTER_KEYBLADES;
        this.keyblades.visible = this.chapterIndex == CHAPTER_MAIN;
        switch (chapterIndex) {
            case CHAPTER_MAIN:
                this.back.visible = false;
                this.summon.visible = false;
                this.keyblades.visible = true;
                this.synthesis.visible = true;
                break;
            case CHAPTER_SUMMON:
                this.back.visible = true;
                this.summon.visible = false;
                this.keyblades.visible = false;
                this.synthesis.visible = false;
                break;
            case CHAPTER_KEYBLADES:
                this.back.visible = true;
                this.summon.visible = true;
                this.keyblades.visible = false;
                this.synthesis.visible = false;
                break;
        }
    }

    @Override
    public void drawScreen (int mouseX, int mouseY, float renderPartials) {
        drawBackground();
        drawForeground();

        super.drawScreen(mouseX, mouseY, renderPartials);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public boolean doesGuiPauseGame () {
        return true;
    }

    @Override
    protected void keyTyped (char character, int key) {
        if (key == Keyboard.KEY_ESCAPE) mc.displayGuiScreen(null);
    }

    protected void drawBackground () {
        mc.renderEngine.bindTexture(gui);
        drawTexturedModalRect(bookXStart, 5, 0, 0, WIDTH, HEIGHT);
    }

    public void drawForeground () {
        switch (chapterIndex) {
            case CHAPTER_MAIN:
                switch (mainPageIndex) {
                    case 0:
                        buildPage("gui." + Reference.MODID + ".reports.title.main", "", 1, chapterPages, CHAPTER_MAIN);
                        break;
                }
            case CHAPTER_KEYBLADES:
                switch (keybladesPageIndex) {
                    case 0:
                        // drawCenteredString(fontRendererObj,
                        // Utils.translateToLocal("Kingdom Hearts"), bookXStart +
                        // 85, 20,
                        // 0x666666);
                        buildPage("gui." + Reference.MODID + ".reports.keyblades.title.main", "", 1, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 1:
                        buildPage("gui." + Reference.MODID + ".reports.title.1", "gui." + Reference.MODID + ".reports.content.1", 2, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 2:
                        buildPage("gui." + Reference.MODID + ".reports.title.2", "gui." + Reference.MODID + ".reports.content.2", 3, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 3:
                        buildPage("gui." + Reference.MODID + ".reports.title.3", "gui." + Reference.MODID + ".reports.content.3", 4, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 4:
                        buildPage("gui." + Reference.MODID + ".reports.title.4", "gui." + Reference.MODID + ".reports.content.4", 5, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 5:
                        buildPage("gui." + Reference.MODID + ".reports.title.5", "gui." + Reference.MODID + ".reports.content.5", 6, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 6:
                        buildPage("gui." + Reference.MODID + ".reports.title.6", "gui." + Reference.MODID + ".reports.content.6", 7, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 7:
                        buildPage("gui." + Reference.MODID + ".reports.title.7", "gui." + Reference.MODID + ".reports.content.7", 8, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 8:
                        buildPage("gui." + Reference.MODID + ".reports.title.8", "gui." + Reference.MODID + ".reports.content.8", 9, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 9:
                        buildPage("gui." + Reference.MODID + ".reports.title.9", "gui." + Reference.MODID + ".reports.content.9", 10, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    case 10:
                        buildPage("gui." + Reference.MODID + ".reports.title.10", "gui." + Reference.MODID + ".reports.content.10", 11, keybladesPages, CHAPTER_KEYBLADES);
                        break;
                    default:
                        break;
                }
                break;
            case CHAPTER_SUMMON:
                switch (summonPageIndex) {
                    case 0:
                        buildPage("gui." + Reference.MODID + ".reports.keyblades.summon.title.main", "", 1, summonPages, CHAPTER_SUMMON);
                        break;
                }
                break;
        }

    }

    private void buildPage (String unlocTitle, String unlocBody, int page, int totalPages, int desiredChapter) {
        RenderHelper.disableStandardItemLighting();
        if (chapterIndex == desiredChapter) {
            drawCenteredString(fontRenderer, Utils.translateToLocal(unlocTitle), bookXStart + 85, 20, 0x666666);
            fontRenderer.setUnicodeFlag(false);
            fontRenderer.drawSplitString(Utils.translateToLocal(unlocBody), bookXStart + 20, 60, WIDTH - 40, 0x666666);
        }
        // drawCenteredString(fontRendererObj, page + " / " + totalPages,
        // bookXStart + 85, 215, 0x666666);
        RenderHelper.enableStandardItemLighting();
    }

    public class GuiButtonPageChange extends GuiButton {

        private final boolean previous;

        public GuiButtonPageChange (int id, int x, int y, boolean previous) {
            super(id, x, y, 16, 16, "");
            this.previous = previous;
        }

        @Override
        public void drawButton (Minecraft mc, int mouseX, int mouseY) {
            if (visible) {
                boolean mouseOver = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
                glColor4f(1, 1, 1, 1);
                mc.renderEngine.bindTexture(gui);
                int u = 175;
                int v = 0;

                if (mouseOver) v += 17;

                if (previous) u += 17;

                GL11.glPushMatrix();

                GL11.glDisable(GL11.GL_LIGHTING);
                RenderHelper.disableStandardItemLighting();
                GL11.glColor4f(1, 1, 1, 1);

                drawTexturedModalRect(xPosition, yPosition, u, v, width, height);

                GL11.glEnable(GL11.GL_LIGHTING);
                RenderHelper.enableStandardItemLighting();

                GL11.glPopMatrix();
            }
        }
    }

    public class GuiButtonChapterChange extends GuiButton {
        private final boolean previous;
        private final String text;

        public GuiButtonChapterChange (int id, int x, int y, boolean previous, String text) {
            super(id, x, y, 161, 20, "");
            this.previous = previous;
            this.text = text;
        }

        @Override
        public void drawButton (Minecraft mc, int mouseX, int mouseY) {
            if (visible) {
                boolean mouseOver = mouseX > xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
                glColor4f(1, 1, 1, 1);
                mc.renderEngine.bindTexture(chapterbutton);
                int u = 0;
                int v = 0;
                if (mouseOver) {

                }
                if (previous) {

                }

                GL11.glPushMatrix();

                GL11.glDisable(GL11.GL_LIGHTING);
                RenderHelper.disableStandardItemLighting();
                GL11.glColor4f(1, 1, 1, 1);

                drawTexturedModalRect(xPosition, yPosition, u, v, width, height);
                itemRender.renderItemAndEffectIntoGUI(new ItemStack(ModItems.KingdomKey), xPosition + 2, yPosition + 2);
                drawString(fontRenderer, text, xPosition + 160 / 2 - 40, yPosition + 6, 0xFFFFFF);

                GL11.glEnable(GL11.GL_LIGHTING);
                RenderHelper.enableStandardItemLighting();

                GL11.glPopMatrix();
            }
        }
    }
}
