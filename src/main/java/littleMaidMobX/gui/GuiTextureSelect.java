package littleMaidMobX.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.EXTRescaleNormal;
import org.lwjgl.opengl.GL11;

import littleMaidMobX.registry.ModelManager;
import littleMaidMobX.textures.ITextureEntity;
import littleMaidMobX.textures.TextureBox;

public class GuiTextureSelect extends GuiScreen {

    private String screenTitle = "Texture Select";
    protected GuiScreen owner;
    protected GuiTextureSlot selectPanel;
    protected GuiButton modeButton[] = new GuiButton[2];
    protected GuiTextField searchField;
    protected GuiButton clearButton;
    public ITextureEntity target;
    public int canSelectColor;
    public int selectColor;
    protected boolean toServer;

    public GuiTextureSelect(GuiScreen pOwner, ITextureEntity pTarget, int pColor, boolean pToServer) {
        owner = pOwner;
        target = pTarget;
        canSelectColor = pColor;
        selectColor = pTarget.getColor();
        toServer = pToServer;
    }

    @Override
    public void initGui() {
        selectPanel = new GuiTextureSlot(this);
        selectPanel.registerScrollButtons(3, 4);

        int searchWidth = 140;
        int searchHeight = 14;
        int searchX = width / 2 - searchWidth / 2 - 8;
        int searchY = 16;
        String prevQuery = searchField != null ? searchField.getText() : "";
        searchField = new GuiTextField(mc.fontRenderer, searchX, searchY, searchWidth, searchHeight);
        searchField.setText(prevQuery);
        searchField.setFocused(true);

        buttonList.add(clearButton = new GuiButton(300, searchX + searchWidth + 2, searchY, 14, searchHeight, "x"));
        buttonList.add(modeButton[0] = new GuiButton(100, width / 2 - 55, height - 55, 80, 20, "Texture"));
        buttonList.add(modeButton[1] = new GuiButton(101, width / 2 + 30, height - 55, 80, 20, "Armor"));
        buttonList.add(new GuiButton(200, width / 2 - 10, height - 30, 120, 20, "Select"));
        modeButton[0].enabled = false;

        if (!prevQuery.isEmpty()) {
            selectPanel.filter(prevQuery);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (searchField != null) {
            searchField.updateCursorCounter();
        }
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        if (par2 == 1) {
            mc.displayGuiScreen(owner);
            return;
        }
        if (searchField != null && searchField.isFocused()) {
            String prevText = searchField.getText();
            if (searchField.textboxKeyTyped(par1, par2)) {
                if (
                    !searchField.getText()
                        .equals(prevText)
                ) {
                    selectPanel.filter(searchField.getText());
                }
                return;
            }
        }
        super.keyTyped(par1, par2);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 1 && searchField != null) {
            if (
                mouseX >= searchField.xPosition && mouseX < searchField.xPosition + searchField.width
                    && mouseY >= searchField.yPosition
                    && mouseY < searchField.yPosition + searchField.height
            ) {
                searchField.setText("");
                searchField.setFocused(true);
                selectPanel.filter("");
                return;
            }
        }
        if (searchField != null) {
            searchField.mouseClicked(mouseX, mouseY, mouseButton);
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        drawDefaultBackground();
        selectPanel.drawScreen(par1, par2, par3);
        drawCenteredString(mc.fontRenderer, StatCollector.translateToLocal(screenTitle), width / 2, 4, 0xffffff);

        if (searchField != null) {
            searchField.drawTextBox();
        }
        if (selectPanel.getSize() == 0) {
            drawCenteredString(mc.fontRenderer, "No textures found", width / 2, height / 2 - 10, 0x888888);
        }

        super.drawScreen(par1, par2, par3);

        GL11.glPushMatrix();
        GL11.glEnable(EXTRescaleNormal.GL_RESCALE_NORMAL_EXT);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        RenderHelper.enableGUIStandardItemLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        TextureBox lbox = selectPanel.getSelectedBox();
        GL11.glTranslatef(width / 2 - 115F, height - 5F, 100F);
        GL11.glScalef(60F, -60F, 60F);
        selectPanel.entity.renderYawOffset = -25F;
        selectPanel.entity.rotationYawHead = -10F;
        ResourceLocation ltex[];
        if (selectPanel.mode) {
            selectPanel.entity.textureData.textureBox[0] = selectPanel.blankBox;
            selectPanel.entity.textureData.textureBox[1] = lbox;
            selectPanel.entity.setTextureNames("default");
        } else {
            selectPanel.entity.textureData.textureBox[0] = lbox;
            selectPanel.entity.textureData.textureBox[1] = selectPanel.blankBox;
            selectPanel.entity.setColor(selectColor);
            selectPanel.entity.setTextureNames();
        }
        RenderManager.instance.renderEntityWithPosYaw(selectPanel.entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        for (int li = 0; li < 16; li++) {
            if (lbox.hasColor(li)) {
                break;
            }
        }
        GL11.glDisable(EXTRescaleNormal.GL_RESCALE_NORMAL_EXT);
        GL11.glPopMatrix();
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton) {
        switch (par1GuiButton.id) {
            case 300:
                if (searchField != null) {
                    searchField.setText("");
                    searchField.setFocused(true);
                    selectPanel.filter("");
                }
                break;
            case 100:
                modeButton[0].enabled = false;
                modeButton[1].enabled = true;
                selectPanel.setMode(false);
                break;
            case 101:
                modeButton[0].enabled = true;
                modeButton[1].enabled = false;
                selectPanel.setMode(true);
                break;
            case 200:
                boolean lflag = false;
                target.setColor(selectColor);
                if (selectPanel.texsel[0] > -1) {
                    target.getTextureBox()[0] = selectPanel.getSelectedBox(false);
                }
                if (selectPanel.texsel[1] > -1) {
                    target.getTextureBox()[1] = selectPanel.getSelectedBox(true);
                }
                target.getTextureData()
                    .setTextureNames();
                if (toServer) {
                    ModelManager.instance.postSetTexturePack(target, selectColor, target.getTextureBox());
                } else {
                    TextureBox lboxs[] = new TextureBox[2];
                    lboxs[0] = (TextureBox) target.getTextureBox()[0];
                    lboxs[1] = (TextureBox) target.getTextureBox()[1];
                    target.setTexturePackName(lboxs);
                }
                System.out.println(
                    String.format(
                        "select: %d(%d/%s), %d(%d/%s)",
                        selectPanel.texsel[0],
                        target.getTextureIndex()[0],
                        target.getTextureBox()[0].textureName,
                        selectPanel.texsel[1],
                        target.getTextureIndex()[1],
                        target.getTextureBox()[1].textureName));
                mc.displayGuiScreen(owner);
                break;
        }
    }

}
