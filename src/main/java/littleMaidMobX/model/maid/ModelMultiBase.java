package littleMaidMobX.model.maid;

import java.util.HashMap;
import java.util.Map;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.render.model.ModelRenderer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;


public abstract class ModelMultiBase extends ModelBase implements IModelCaps {

	public float heldItem[] = new float[] {0.0F, 0.0F};
	public boolean aimedBow;
	public boolean isSneak;
	public boolean isWait;
	
	public ModelRenderer mainFrame;
	public ModelRenderer HeadMount;
	public ModelRenderer HeadTop;
	public ModelRenderer Arms[];
	public ModelRenderer HardPoint[];
	
	public float entityIdFactor;
	public int entityTicksExisted;
	
	public float scaleFactor = 0.9375F;
	
	@SuppressWarnings("serial")
	private final Map<String, Integer> fcapsmap = new HashMap<String, Integer>() {{
		put("onGround",			caps_onGround);
		put("isRiding",			caps_isRiding);
		put("isSneak",			caps_isSneak);
		put("isWait",			caps_isWait);
		put("isChild",			caps_isChild);
		put("heldItemLeft",		caps_heldItemLeft);
		put("heldItemRight",	caps_heldItemRight);
		put("aimedBow",			caps_aimedBow);
		put("ScaleFactor", 		caps_ScaleFactor);
		put("entityIdFactor",	caps_entityIdFactor);
		put("dominantArm",		caps_dominantArm);
	}};
	
	public ModelMultiBase(StringBuilder hack) {}

	public ModelMultiBase() {
		this(0.0F);
	}

	public ModelMultiBase(float pSizeAdjust) {
		this(pSizeAdjust, 0.0F, 64, 32);
	}

	public ModelMultiBase(float pSizeAdjust, float pYOffset, int pTextureWidth, int pTextureHeight) {
		this.modelSize = pSizeAdjust;
		isSneak = false;
		aimedBow = false;
		textureWidth = pTextureWidth;
		textureHeight = pTextureHeight;
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
//			LMM_LittleMaidMobX.Debug("ModelMulti.InitClient");
			
			Arms = new ModelRenderer[2];
			HeadMount = new ModelRenderer(this, "HeadMount");
			HeadTop = new ModelRenderer(this, "HeadTop");
		}
	}

	

	
	public abstract void initModel(float psize, float pyoffset);

	
	public String getUsingTexture() {
		return null;
	}

	
	@Deprecated
	public abstract float getHeight();
	
	public float getHeight(IModelCaps pEntityCaps) {
		return getHeight();
	}
	
	@Deprecated
	public abstract float getWidth();
	
	public float getWidth(IModelCaps pEntityCaps) {
		return getWidth();
	}
	
	@Deprecated
	public abstract float getyOffset();
	
	public float getyOffset(IModelCaps pEntityCaps) {
		return getyOffset();
	}
	
	@Deprecated
	public abstract float getMountedYOffset();
	
	public float getMountedYOffset(IModelCaps pEntityCaps) {
		return getMountedYOffset();
	}

	
	public float getLeashOffset(IModelCaps pEntityCaps) {
		return 0.4F;
	}

	
	@Deprecated
	public boolean isItemHolder() {
		return false;
	}
	
	public boolean isItemHolder(IModelCaps pEntityCaps) {
		return isItemHolder();
	}

	
	public abstract void showAllParts(IModelCaps pEntityCaps);

	
	public int showArmorParts(IModelCaps iModelCaps, int parts, int index) {
		return -1;
	}

	
	public abstract void renderItems(IModelCaps pEntityCaps);

	public abstract void renderFirstPersonHand(IModelCaps pEntityCaps);



	// IModelCaps

	@Override
	public Map<String, Integer> getModelCaps() {
		return fcapsmap;
	}

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		switch (pIndex) {
		case caps_onGround:
			return onGrounds;
		case caps_isRiding:
			return isRiding;
		case caps_isSneak:
			return isSneak;
		case caps_isWait:
			return isWait;
		case caps_isChild:
			return isChild;
		case caps_heldItemLeft:
			return heldItem[1];
		case caps_heldItemRight:
			return heldItem[0];
		case caps_aimedBow:
			return aimedBow;
		case caps_entityIdFactor:
			return entityIdFactor;
		case caps_ticksExisted:
			return entityTicksExisted;
		case caps_ScaleFactor:
			return scaleFactor;
		case caps_dominantArm:
			return dominantArm;
		case caps_oldwalking:
			return false;
		case caps_breastFloats:
			return false;
		case caps_skirtFloats:
			return 0;
		case caps_skirtFloatsMotionY:
			return 0.0D;
		}
		return null;
	}
	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue(null, pIndex, pArg);
	}

	public boolean setCapsValue(IModelCaps caps, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_onGround:
			for (int li = 0; li < onGrounds.length && li < pArg.length; li++) {
				onGrounds[li] = (Float)pArg[li];
			}
			return true;
		case caps_isRiding:
			isRiding = (Boolean)pArg[0];
			return true;
		case caps_isSneak:
			isSneak = (Boolean)pArg[0];
			return true;
		case caps_isWait:
			isWait = (Boolean)pArg[0];
			return true;
		case caps_isChild:
			isChild = (Boolean)pArg[0];
			return true;
		case caps_heldItemLeft:
			heldItem[1] = (Integer)pArg[0];
			return true;
		case caps_heldItemRight:
			heldItem[0] = (Integer)pArg[0];
			return true;
		case caps_aimedBow:
			aimedBow = (Boolean)pArg[0];
			return true;
		case caps_entityIdFactor:
			entityIdFactor = (Float)pArg[0];
			return true;
		case caps_ticksExisted:
			entityTicksExisted = (Integer)pArg[0];
			return true;
		case caps_ScaleFactor:
			scaleFactor = (Float)pArg[0];
			return true;
		case caps_dominantArm:
			dominantArm = (Integer)pArg[0];
			return true;
		case caps_visible:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				((ModelRenderer) pArg[0]).setVisible((Boolean)pArg[1]);
				return true;
			}
			return false;
		}
		
		return false;
	}

}
