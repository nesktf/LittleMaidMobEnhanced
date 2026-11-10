package littleMaidMobX.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import littleMaidMobX.entity.EntitySelect;
import littleMaidMobX.model.maid.ModelMultiBase;
import littleMaidMobX.registry.ModelManager;
import littleMaidMobX.textures.TextureBox;
import littleMaidMobX.textures.TextureBoxBase;
import littleMaidMobX.util.helper.ClientHelper;

public class GuiTextureSlot extends GuiSlot {

    public static final int[] COLOR_TABLE = new int[] { 0xFFFFFF, 0xE67E22, 0xBA4A00, 0x5DADE2, 0xF1C40F, 0x58D68D,
        0xEC7063, 0x566573, 0xABB2B9, 0x16A085, 0x8E44AD, 0x2980B9, 0x784212, 0x27AE60, 0xC0392B, 0x1C1C1C };

    public GuiTextureSelect owner;
    public int selected;
    public EntitySelect entity;
    public List<TextureBox> allTexture;
    public List<TextureBox> allArmor;
    public List<TextureBox> indexTexture;
    public List<TextureBox> indexArmor;
    public TextureBox selectedTexture;
    public TextureBox selectedArmor;
    public String currentFilter = "";
    public boolean mode;
    public int texsel[] = new int[2];
    public int color;
    public int selectColor;
    private ItemStack armors[] = new ItemStack[] { new ItemStack(Items.leather_boots),
        new ItemStack(Items.leather_leggings), new ItemStack(Items.leather_chestplate),
        new ItemStack(Items.leather_helmet) };
    protected boolean isContract;
    protected static TextureBox blankBox;

    public GuiTextureSlot(GuiTextureSelect pOwner) {
        super(pOwner.mc, pOwner.width, pOwner.height, 34, pOwner.height - 64, 36);
        owner = pOwner;
        entity = new EntitySelect(owner.mc.theWorld);
        color = owner.target.getColor();
        selectColor = -1;
        blankBox = new TextureBox();
        blankBox.models = new ModelMultiBase[] { null, null, null };

        texsel[0] = 0;
        texsel[1] = 0;
        allTexture = new ArrayList<TextureBox>();
        allArmor = new ArrayList<TextureBox>();
        indexTexture = new ArrayList<TextureBox>();
        indexArmor = new ArrayList<TextureBox>();
        isContract = owner.target.isContract();
        entity.setContract(isContract);
        TextureBoxBase ltbox[] = owner.target.getTextureBox();
        for (int li = 0; li < ModelManager.instance.getTextureCount(); li++) {
            TextureBox lbox = ModelManager.getTextureList()
                .get(li);
            if (isContract) {
                if (lbox.getContractColorBits() > 0) {
                    allTexture.add(lbox);
                }
            } else {
                if (lbox.getWildColorBits() > 0) {
                    allTexture.add(lbox);
                }
            }
            if (lbox.hasArmor()) {
                allArmor.add(lbox);
            }
            if (lbox == ltbox[0]) {
                selectedTexture = lbox;
                texsel[0] = allTexture.size() - 1;
            }
            if (lbox == ltbox[1]) {
                selectedArmor = lbox;
                texsel[1] = allArmor.size() - 1;
            }
        }
        if (selectedTexture == null && !allTexture.isEmpty()) {
            selectedTexture = allTexture.get(0);
        }
        if (selectedArmor == null && !allArmor.isEmpty()) {
            selectedArmor = allArmor.get(0);
        }
        indexTexture.addAll(allTexture);
        indexArmor.addAll(allArmor);
        setMode(false);
    }

    public void filter(String query) {
        currentFilter = query == null ? ""
            : query.trim()
                .toLowerCase();
        indexTexture.clear();
        for (TextureBox box : allTexture) {
            if (matchesFilter(box, currentFilter)) {
                indexTexture.add(box);
            }
        }
        indexArmor.clear();
        for (TextureBox box : allArmor) {
            if (matchesFilter(box, currentFilter)) {
                indexArmor.add(box);
            }
        }
        if (mode) {
            selected = indexArmor.indexOf(selectedArmor);
        } else {
            selected = indexTexture.indexOf(selectedTexture);
        }
    }

    private boolean matchesFilter(TextureBox box, String query) {
        if (query.isEmpty()) {
            return true;
        }
        if (
            box.textureName != null && box.textureName.toLowerCase()
                .contains(query)
        ) {
            return true;
        }
        if (
            box.modelName != null && box.modelName.toLowerCase()
                .contains(query)
        ) {
            return true;
        }
        if (
            box.packageName != null && box.packageName.toLowerCase()
                .contains(query)
        ) {
            return true;
        }
        return false;
    }

    @Override
    protected int getSize() {
        return mode ? indexArmor.size() : indexTexture.size();
    }

    @Override
    protected void elementClicked(int var1, boolean var2, int var3, int var4) {
        if (mode) {
            if (var1 >= 0 && var1 < indexArmor.size()) {
                selected = var1;
                selectedArmor = indexArmor.get(var1);
                texsel[1] = allArmor.indexOf(selectedArmor);
            }
        } else {
            if (var1 >= 0 && var1 < indexTexture.size()) {
                TextureBox lbox = indexTexture.get(var1);
                if (lbox.hasColor(selectColor, isContract) && (owner.canSelectColor & (1 << selectColor)) > 0) {
                    selected = var1;
                    selectedTexture = lbox;
                    texsel[0] = allTexture.indexOf(selectedTexture);
                    owner.selectColor = selectColor;
                } else if (lbox.hasColor(color, isContract)) {
                    selected = var1;
                    selectedTexture = lbox;
                    texsel[0] = allTexture.indexOf(selectedTexture);
                    owner.selectColor = color;
                }
            }
        }
    }

    @Override
    protected boolean isSelected(int var1) {
        if (mode) {
            return var1 >= 0 && var1 < indexArmor.size() && indexArmor.get(var1) == selectedArmor;
        } else {
            return var1 >= 0 && var1 < indexTexture.size() && indexTexture.get(var1) == selectedTexture;
        }
    }

    @Override
    protected void drawBackground() {}

    @Override
    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5, int var6, int var7) {
        if (var1 < 0 || (mode ? var1 >= indexArmor.size() : var1 >= indexTexture.size())) {
            return;
        }

        TextureBox lbox;
        if (mode) {
            lbox = indexArmor.get(var1);
            entity.textureData.textureBox[0] = blankBox;
            entity.textureData.textureBox[1] = lbox;
        } else {
            lbox = indexTexture.get(var1);
            entity.textureData.textureBox[0] = lbox;
            entity.textureData.textureBox[1] = blankBox;
        }
        ModelManager.instance.checkTextureBoxServer(lbox);

        boolean isHovered = (var7 >= top && var7 <= bottom && var7 >= var3 && var7 <= var3 + slotHeight);

        if (!mode) {
            for (int li = 0; li < 16; li++) {
                int lx = var2 + 15 + 12 * li;
                if (isHovered) {
                    selectColor = (var6 - (var2 + 15)) / 12;
                    if ((selectColor < 0) || (selectColor > 15)) {
                        selectColor = -1;
                    }
                }
                if (color == li) {
                    owner.drawRect(lx, var3, lx + 11, var3 + 36, 0x88882222);
                } else if (owner.selectColor == li) {
                    owner.drawRect(lx, var3, lx + 11, var3 + 36, 0x88226622);
                } else if ((owner.canSelectColor & (1 << li)) > 0) {
                    owner.drawRect(lx, var3, lx + 11, var3 + 36, 0x88222288);
                }
            }
        }

        GL11.glDisable(GL11.GL_BLEND);
        owner.drawString(this.owner.mc.fontRenderer, lbox.textureName, var2 + 16, var3 + 25, -1);

        if (mode) {
            if (isHovered) {
                GL11.glPushMatrix();
                GL11.glTranslatef(var2 + 8F, var3 + 25F, 50F);
                GL11.glScalef(12F, -12F, 12F);
                entity.renderYawOffset = 30F;
                entity.rotationYawHead = 15F;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);

                Map<Integer, ResourceLocation> lmap = lbox.armors.get("default");
                if (lmap != null) {
                    entity.setTextureNames("default");
                    RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
                }
                for (String ls : ModelManager.armorFilenamePrefix) {
                    GL11.glTranslatef(1F, 0, 0);
                    if (lbox.armors.containsKey(ls)) {
                        entity.setTextureNames(ls);
                        RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
                        ClientHelper.setLightmapTextureCoords(0x00f0);
                    }
                }
                GL11.glPopMatrix();
            } else {
                int offset = 0;
                if (lbox.armors.containsKey("default")) {
                    int lx = var2 + 15 + 14 * offset;
                    owner.drawRect(lx + 1, var3 + 7, lx + 11, var3 + 19, 0xFF000000);
                    owner.drawRect(lx + 2, var3 + 8, lx + 10, var3 + 18, 0xFF888888);
                    offset++;
                }
                for (String ls : ModelManager.armorFilenamePrefix) {
                    if (lbox.armors.containsKey(ls)) {
                        int lx = var2 + 15 + 14 * offset;
                        owner.drawRect(lx + 1, var3 + 7, lx + 11, var3 + 19, 0xFF000000);
                        owner.drawRect(lx + 2, var3 + 8, lx + 10, var3 + 18, 0xFF5B7898);
                        offset++;
                    }
                }
            }
        } else {
            if (isHovered) {
                GL11.glPushMatrix();
                GL11.glTranslatef(var2 + 8F, var3 + 25F, 50F);
                GL11.glScalef(12F, -12F, 12F);
                entity.renderYawOffset = 30F;
                entity.rotationYawHead = 15F;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);

                for (int li = 0; li < 16; li++) {
                    GL11.glTranslatef(1F, 0, 0);
                    if (lbox.hasColor(li, isContract)) {
                        entity.setColor(li);
                        entity.setContract(isContract);
                        entity.setTextureNames();
                        RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
                        ClientHelper.setLightmapTextureCoords(0x00f0);
                    }
                }
                GL11.glPopMatrix();
            } else {
                for (int li = 0; li < 16; li++) {
                    if (lbox.hasColor(li, isContract)) {
                        int lx = var2 + 15 + 12 * li;
                        int swatchColor = COLOR_TABLE[li] | 0xFF000000;
                        owner.drawRect(lx + 1, var3 + 7, lx + 10, var3 + 19, 0xFF000000);
                        owner.drawRect(lx + 2, var3 + 8, lx + 9, var3 + 18, swatchColor);
                    }
                }
            }
        }
    }

    public TextureBox getSelectedBox() {
        return mode ? selectedArmor : selectedTexture;
    }

    public TextureBox getSelectedBox(int pIndex) {
        if (mode) {
            return (pIndex >= 0 && pIndex < indexArmor.size()) ? indexArmor.get(pIndex) : selectedArmor;
        } else {
            return (pIndex >= 0 && pIndex < indexTexture.size()) ? indexTexture.get(pIndex) : selectedTexture;
        }
    }

    public TextureBox getSelectedBox(boolean pMode) {
        return pMode ? selectedArmor : selectedTexture;
    }

    public void setMode(boolean pFlag) {
        scrollBy(slotHeight * -getSize());
        if (pFlag) {
            mode = true;
            entity.setCurrentItemOrArmor(1, armors[0]);
            entity.setCurrentItemOrArmor(2, armors[1]);
            entity.setCurrentItemOrArmor(3, armors[2]);
            entity.setCurrentItemOrArmor(4, armors[3]);
        } else {
            mode = false;
            entity.setCurrentItemOrArmor(1, null);
            entity.setCurrentItemOrArmor(2, null);
            entity.setCurrentItemOrArmor(3, null);
            entity.setCurrentItemOrArmor(4, null);
        }
        filter(currentFilter);
        int selIdx = mode ? indexArmor.indexOf(selectedArmor) : indexTexture.indexOf(selectedTexture);
        if (selIdx >= 0) {
            selected = selIdx;
            scrollBy(slotHeight * selected);
        } else {
            selected = -1;
        }
    }

}
