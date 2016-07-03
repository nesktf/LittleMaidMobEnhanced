package littleMaidMobX.textures;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.entity.EntitySelect;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.maid.ModelMultiBase;
import littleMaidMobX.registry.ModelManager;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;




public class TextureData {
	//public class MMM_TextureData implements MMM_ITextureEntity {

	public EntityLivingBase owner;
	public IModelCaps entityCaps;

	
	public ResourceLocation textures[][];
	
	public int color;
	
	public boolean contract;

	public TextureBoxBase textureBox[];
	public int textureIndex[];
	public ModelMultiBase textureModel[];

	
	public int selectValue;


	public int data_Color = 19;
	public int data_Texture = 20;
	public int data_Value = 21;


	public TextureData(EntityLivingBase pEntity, IModelCaps pCaps) {
		owner = pEntity;
		entityCaps = pCaps;
		textures = new ResourceLocation[][] {
			 {
				null, null
			},
			 {
				null, null, null, null
			},
			 {
				null, null, null, null
			},
			 {
				null, null, null, null
			},
			 {
				null, null, null, null
			}
		};
		color = 12;
		contract = false;
		textureBox = new TextureBoxBase[2];
		textureBox[0] = textureBox[1] = ModelManager.instance.getDefaultTexture(owner.getClass());
		textureIndex = new int[] {
			0, 0
		};
		textureModel = new ModelMultiBase[3];
	}

	
	public boolean setTextureNames() {
		textureModel[0] = null;
		textureModel[1] = null;
		textureModel[2] = null;

		if (owner.worldObj.isRemote) {
			return setTextureNamesClient();
		} else {
			return setTextureNamesServer();
		}
	}

	
	protected boolean setTextureNamesClient() {
		// Client
		boolean lf = false;
		TextureBox lbox;

		if (textureBox[0] instanceof TextureBox) {
			int lc = (color & 0x00ff) + (contract ? 0 : ModelManager.tx_wild);
			lbox = (TextureBox) textureBox[0];
			if (lbox.hasColor(lc)) {
				textures[0][0] = lbox.getTextureName(lc);
				lc = (color & 0x00ff) + (contract ? ModelManager.tx_eyecontract : ModelManager.tx_eyewild);
				textures[0][1] = lbox.getTextureName(lc);
				lf = true;
				textureModel[0] = lbox.models[0];
			}
			
			else {
				lbox = ModelManager.instance.getDefaultTexture((ITextureEntity) owner);
				textureBox[0] = textureBox[1] = lbox;

				if (lbox.hasColor(lc)) {
					textures[0][0] = lbox.getTextureName(lc);
					lc = (color & 0x00ff) + (contract ? ModelManager.tx_eyecontract : ModelManager.tx_eyewild);
					textures[0][1] = lbox.getTextureName(lc);
					lf = true;
					textureModel[0] = lbox.models[0];
				} else {
					
				}
			}
		} else {
			textureBox[0] = ModelManager.instance.getTextureBoxServerIndex(textureIndex[0]);
		}
		if (textureBox[1] instanceof TextureBox && owner != null) {
			lbox = (TextureBox) textureBox[1];
			for (int i = 0; i < 4; i++) {
				ItemStack is = owner.getEquipmentInSlot(i + 1);
				textures[1][i] = lbox.getArmorTextureName(ModelManager.tx_armor1, is);
				textures[2][i] = lbox.getArmorTextureName(ModelManager.tx_armor2, is);
				textures[3][i] = lbox.getArmorTextureName(ModelManager.tx_armor1light, is);
				textures[4][i] = lbox.getArmorTextureName(ModelManager.tx_armor2light, is);
			}
			textureModel[1] = lbox.models[1];
			textureModel[2] = lbox.models[2];
		} else {
			textureBox[0] = ModelManager.instance.getTextureBoxServerIndex(textureIndex[0]);
		}
		return lf;
	}

	protected boolean setTextureNamesServer() {
		// Server
		boolean lf = false;
		TextureBoxServer lbox;
		if (textureBox[0] instanceof TextureBoxServer) {
			lbox = (TextureBoxServer) textureBox[0];
			if (lbox.localBox != null) {
				int lc = (color & 0x00ff) + (contract ? 0 : ModelManager.tx_wild);
				if (lbox.localBox.hasColor(lc)) {
					if (Helper.isClient) {
						textures[0][0] = lbox.localBox.getTextureName(lc);
						lc = (color & 0x00ff) + (contract ? ModelManager.tx_eyecontract : ModelManager.tx_eyewild);
						textures[0][1] = lbox.localBox.getTextureName(lc);
					}
					lf = true;
					textureModel[0] = lbox.localBox.models[0];
				}
			}
		}
		if (textureBox[1] instanceof TextureBoxServer && owner != null) {
			lbox = (TextureBoxServer) textureBox[1];
			if (lbox.localBox != null) {
				if (Helper.isClient) {
					for (int i = 0; i < 4; i++) {
						ItemStack is = owner.getEquipmentInSlot(i + 1);
						textures[1][i] = lbox.localBox.getArmorTextureName(ModelManager.tx_armor1, is);
						textures[2][i] = lbox.localBox.getArmorTextureName(ModelManager.tx_armor2, is);
						textures[3][i] = lbox.localBox.getArmorTextureName(ModelManager.tx_armor1light, is);
						textures[4][i] = lbox.localBox.getArmorTextureName(ModelManager.tx_armor2light, is);
					}
				}
				textureModel[1] = lbox.localBox.models[1];
				textureModel[2] = lbox.localBox.models[2];
			}
		}
		return lf;
	}

	public void setNextTexturePackage(int pTargetTexture) {
		if (pTargetTexture == 0) {
			int lc = getColor() + (isContract() ? 0 : ModelManager.tx_wild);
			
			if (textureBox[0] instanceof TextureBox) {
				textureBox[0] = ModelManager.instance.getNextPackege((TextureBox) textureBox[0], lc);
			} else {
				textureBox[0] = null;
			}
			if (textureBox[0] == null) {
				
				textureBox[0] = textureBox[1] = ModelManager.instance.getDefaultTexture((ITextureEntity) owner);
				setColor(12);
			} else {
				textureBox[1] = textureBox[0];
			}
			if (!((TextureBox) textureBox[1]).hasArmor()) {
				pTargetTexture = 1;
			}
		}
		if (pTargetTexture == 1) {
			textureBox[1] = ModelManager.instance.getNextArmorPackege((TextureBox) textureBox[1]);
		}
	}

	public void setPrevTexturePackege(int pTargetTexture) {
		if (pTargetTexture == 0) {
			int lc = getColor() + (isContract() ? 0 : ModelManager.tx_wild);
			textureBox[0] = ModelManager.instance.getPrevPackege((TextureBox) textureBox[0], lc);
			textureBox[1] = textureBox[0];
			if (!((TextureBox) textureBox[1]).hasArmor()) {
				pTargetTexture = 1;
			}
		}
		if (pTargetTexture == 1) {
			textureBox[1] = ModelManager.instance.getPrevArmorPackege((TextureBox) textureBox[1]);
		}
	}

	
	public void onUpdate() {

		
		// http://forum.minecraftuser.jp/viewtopic.php?f=13&t=23347&start=160#p210319
		if (textureBox != null && textureBox.length > 0 && textureBox[0] != null) {
			
			if (textureBox[0].isUpdateSize) {
				setSize();
			}
		}
	}

	protected void setSize() {

		if (textureBox != null && textureBox.length > 0 && textureBox[0] != null) {
			
			//		owner.setSize(textureBox[0].getWidth(entityCaps), textureBox[0].getHeight(entityCaps));
			if (owner instanceof EntityLittleMaid) {
				((EntityLittleMaid) owner).setSize2(textureBox[0].getWidth(entityCaps), textureBox[0].getHeight(entityCaps));
			} else if (owner instanceof EntitySelect) {
				((EntitySelect) owner).setSize2(textureBox[0].getWidth(entityCaps), textureBox[0].getHeight(entityCaps));
			}

			if (owner instanceof EntityAgeable) {
				
				((EntityAgeable) owner).setScaleForAge(owner.isChild());
			}
		}
	}


	//	@Override
	public void setTexturePackIndex(int pColor, int[] pIndex) {
		// Server
		for (int li = 0; li < pIndex.length; li++) {
			textureIndex[li] = pIndex[li];
			textureBox[li] = ModelManager.instance.getTextureBoxServer(textureIndex[li]);
		}
		color = pColor;
		setSize();
	}

	//	@Override
	public void setTexturePackName(TextureBox[] pTextureBox) {
		// Client
		for (int li = 0; li < pTextureBox.length; li++) {
			textureBox[li] = pTextureBox[li];
		}
		setSize();
	}

	//	@Override
	public boolean setColor(int pColor) {
		boolean lf = (color != pColor);
		color = pColor;
		return lf;
	}

	//	@Override
	public int getColor() {
		return color & 0x00ff;
	}

	//	@Override
	public void setContract(boolean pContract) {
		contract = pContract;
	}

	//	@Override
	public boolean isContract() {
		return contract;
	}

	//	@Override
	public void setTextureBox(TextureBoxBase[] pTextureBox) {
		textureBox = pTextureBox;
	}

	//	@Override
	public TextureBoxBase[] getTextureBox() {
		return textureBox;
	}

	//	@Override
	public void setTextureIndex(int[] pTextureIndex) {
		textureIndex = pTextureIndex;
	}

	//	@Override
	public int[] getTextureIndex() {
		return textureIndex;
	}

	//	@Override
	public void setTextures(int pIndex, ResourceLocation[] pNames) {
		textures[pIndex] = pNames;
	}

	//	@Override
	public ResourceLocation[] getTextures(int pIndex) {
		return textures[pIndex];
	}


	
	public int getWildColor() {
		return textureBox[0].getRandomWildColor(owner.getRNG());
	}

	
	public void setTextureInitServer(String pName) {
		Debug.texture("request Init Texture: %s", pName);
		textureIndex[0] = textureIndex[1] = ModelManager.instance.getIndexTextureBoxServer((ITextureEntity) owner, pName);
		textureBox[0] = textureBox[1] = ModelManager.instance.getTextureBoxServer(textureIndex[0]);
		color = textureBox[0].getRandomWildColor(owner.getRNG());
	}
	public void setTextureInitClient() {
		TextureBox lbox = ModelManager.instance.getDefaultTexture(owner.getClass());
		for (int li = 0; li < textureBox.length; li++) {
			textureBox[li] = lbox;
			textureIndex[li] = ModelManager.instance.getIndexTextureBoxServerIndex(lbox);
		}
		color = textureBox[0].getRandomWildColor(owner.getRNG());
	}

	public String getTextureName(int pIndex) {
		return textureBox[pIndex].textureName;
	}

	public ResourceLocation getGUITexture() {
		return ((TextureBox) textureBox[0]).getTextureName(ModelManager.tx_gui);
	}

	/**
	 * 
	 * @param pIndex 0-31
	 * @return
	 */
	public boolean isValueFlag(int pIndex) {
		return ((selectValue >>> pIndex) & 0x01) == 1;
	}

	/**
	 * 
	 * @param pIndex 0-31
	 * @param pFlag
	 */
	public void setValueFlag(int pIndex, boolean pFlag) {
		selectValue |= ((pFlag ? 1 : 0) << pIndex);
	}

	
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		NBTTagCompound lnbt = new NBTTagCompound();
		lnbt.setIntArray("Textures", textureIndex);
		lnbt.setInteger("Color", color);
		lnbt.setBoolean("Contract", contract);
		lnbt.setInteger("SelectValue", selectValue);
		par1nbtTagCompound.setTag("TextureData", lnbt);
	}

	
	public void readToNBT(NBTTagCompound par1nbtTagCompound) {
		if (par1nbtTagCompound.hasKey("TextureData")) {
			NBTTagCompound lnbt = par1nbtTagCompound.getCompoundTag("TextureData");
			color = lnbt.getInteger("Color");
			contract = lnbt.getBoolean("Contract");
			selectValue = lnbt.getInteger("SelectValue");
			int[] intList = lnbt.getIntArray("Textures");

			if (intList.length > 0) {
				setTexturePackIndex(color, intList);
			} else {
				
				TextureBox lbox = ModelManager.instance.getDefaultTexture((ITextureEntity) owner);
				int li = ModelManager.instance.getIndexTextureBoxServerIndex(lbox);
				setTexturePackIndex(color, new int[] {
					li, li
				});
			}
		}
	}

	/**
	 * 
	 * @param pColor
	 * @param pTextureIndex
	 * @return
	 */
	public boolean updateTexture(int pColor, int[] pTextureIndex) {
		boolean lf = false;
		lf |= setColor(pColor);
		for (int li = 0; li < pTextureIndex.length; li++) {
			if (textureIndex[li] != pTextureIndex[li]) {
				textureIndex[li] = pTextureIndex[li];
				lf |= true;
			}
		}
		if (lf) {
			setTextureNames();
		}

		return lf;
	}

	
	
	public void entityInit(DataWatcher pDataWatcher) {
		// Color
		pDataWatcher.addObject(data_Color, Byte.valueOf((byte) 0));
		
		pDataWatcher.addObject(data_Texture, Integer.valueOf(0));
		
		pDataWatcher.addObject(data_Value, Integer.valueOf(0));
	}

	protected void setWatchedColor(int pColor) {
		owner.getDataWatcher().updateObject(data_Color, (byte) pColor);
	}

	protected int getWatchedColor() {
		return owner.getDataWatcher().getWatchableObjectByte(data_Color);
	}

}
