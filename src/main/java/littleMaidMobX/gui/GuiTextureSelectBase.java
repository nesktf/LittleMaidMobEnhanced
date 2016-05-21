package littleMaidMobX.gui;

import littleMaidMobX.network.Net;
import littleMaidMobX.registry.ModelManager;
import littleMaidMobX.textures.ITextureEntity;
import littleMaidMobX.util.Statics;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;


public class GuiTextureSelectBase extends GuiTextureSelect {

	public GuiTextureSelectBase(GuiScreen pOwner, ITextureEntity pTarget,
			int pColor, boolean pToServer) {
		super(pOwner, pTarget, pColor, pToServer);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		super.actionPerformed(par1GuiButton);
		switch (par1GuiButton.id) {
		case 200:
			if (toServer) {
				ModelManager.instance.postSetTexturePack(target, selectColor, target.getTextureBox());
				if (selectColor != selectPanel.color) {
					
//					theMaid.maidColor = selectPanel.color | 0x010000 | (selectColor << 8);
					
					byte ldata[] = new byte[2];
					ldata[0] = Statics.LMN_Server_DecDyePowder;
					ldata[1] = (byte)selectColor;
					Net.sendToServer(ldata);
				}
			}
			break;
		}
	}

}
