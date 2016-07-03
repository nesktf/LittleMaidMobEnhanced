package littleMaidMobX.textures;

import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;

public class TextureBoxServer extends TextureBoxBase {

	
	protected TextureBox localBox;


	public TextureBoxServer() {
	}

	public TextureBoxServer(TextureBox pBox) {
		localBox		= pBox;
		contractColor	= pBox.getContractColorBits();
		wildColor		= pBox.getWildColorBits();
		textureName		= pBox.textureName;
		isUpdateSize = (pBox.models != null && pBox.models[0] != null) ?
				ModelCapsHelper.getCapsValueBoolean(pBox.models[0], IModelCaps.caps_isUpdateSize) : false;
/*
		if (pBox.models != null) {
			modelHeight			= pBox.models[0].getHeight(null);
			modelWidth			= pBox.models[0].getWidth(null);
			modelYOffset		= pBox.models[0].getyOffset(null);
			modelMountedYOffset	= pBox.models[0].getMountedYOffset(null);
		}
*/
	}

	/*
	 * MMM_Statics.Server_GetTextureIndex
	 */
	public void setValue(byte[] pData) {
		contractColor		= Helper.getShort(pData, 2);
		wildColor			= Helper.getShort(pData, 4);
		modelHeight			= Helper.getFloat(pData, 6);
		modelWidth			= Helper.getFloat(pData, 10);
		modelYOffset		= Helper.getFloat(pData, 14);
		modelMountedYOffset	= Helper.getFloat(pData, 18);
		textureName			= Helper.getStr(pData, 22);
	}

	@Override
	public float getHeight(IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getHeight(pEntityCaps) : modelHeight;
	}

	@Override
	public float getWidth(IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getWidth(pEntityCaps) : modelWidth;
	}

	@Override
	public float getYOffset(IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getyOffset(pEntityCaps) : modelYOffset;
	}

	@Override
	public float getMountedYOffset(IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getMountedYOffset(pEntityCaps) : modelMountedYOffset;
	}

}
