package littleMaidMobX.model.maid;

import java.util.Map;
import java.util.Map.Entry;

import littleMaidMobX.util.helper.ClientHelper;
import littleMaidMobX.model.EquippedStabilizer;
import littleMaidMobX.model.ModelStabilizerBase;
import littleMaidMobX.model.caps.IModelCaps;

import org.lwjgl.opengl.GL11;


public abstract class ModelMultiMMMBase extends ModelMultiBase {

	public Map<String, EquippedStabilizer> stabiliser;
	
	@Deprecated
	public float onGround;
	
	@Deprecated
	public float heldItemLeft;
	
	@Deprecated
	public float heldItemRight;

	public ModelMultiMMMBase(StringBuilder hack) {
		super(hack);
	}

	public ModelMultiMMMBase() {
		super();
		initModel(1, 0);
	}
	public ModelMultiMMMBase(float pSizeAdjust) {
		super(pSizeAdjust);
		initModel(pSizeAdjust, 0);
	}
	public ModelMultiMMMBase(float pSizeAdjust, float pYOffset, int pTextureWidth, int pTextureHeight) {
		super(pSizeAdjust, pYOffset, pTextureWidth, pTextureHeight);
		initModel(pSizeAdjust, pYOffset);
	}

	
	@Override
	public void render(IModelCaps pEntityCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender)
	{
		if (pEntityCaps==null)
		{
			System.out.println("SCREAMS!");
		}
		
		setRotationAngles(par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pEntityCaps);
		mainFrame.render(par7, pIsRender);
		renderStabilizer(pEntityCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);
	}

	
	public boolean preRender(float par2, float par3,
			float par4, float par5, float par6, float par7) {
		return true;
	}

	
	public void renderExtention(float par2, float par3,
			float par4, float par5, float par6, float par7) {
	}

	protected void renderStabilizer(IModelCaps pEntityCaps, float par2, float par3,
			float ticksExisted, float pheadYaw, float pheadPitch, float par7) {
		if (stabiliser == null || stabiliser.isEmpty() || render == null)
			return;

		GL11.glPushMatrix();
		for (Entry<String, EquippedStabilizer> le : stabiliser.entrySet()) {
			EquippedStabilizer les = le.getValue();
			if (les != null && les.equipPoint != null) {
				ModelStabilizerBase lsb = les.stabilizer;
				if (lsb.isLoadAnotherTexture()) {
					ClientHelper.setTexture(lsb.getTexture());
				}
				les.equipPoint.loadMatrix();
				lsb.render(this, null, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);
			}
		}
		GL11.glPopMatrix();
	}
	
	public void changeModel(IModelCaps pEntityCaps) {
		
	}

	
	public void buildTexture() {
		
	}

	public void setDefaultPause() {
	}

	public void setDefaultPause(float par1, float par2, float pTicksExisted,
			float pHeadYaw, float pHeadPitch, float par6, IModelCaps pEntityCaps) {
		setDefaultPause();
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_changeModel:
			changeModel((IModelCaps)pArg[0]);
			return true;
		case caps_renderFace:
			renderFace((IModelCaps)pArg[0], (Float)pArg[1], (Float)pArg[2], (Float)pArg[3],
				(Float)pArg[4], (Float)pArg[5], (Float)pArg[6], (Boolean)pArg[7]);
			return true;
		case caps_renderBody:
			renderBody((IModelCaps)pArg[0], (Float)pArg[1], (Float)pArg[2], (Float)pArg[3],
				(Float)pArg[4], (Float)pArg[5], (Float)pArg[6], (Boolean)pArg[7]);
			return true;
		}
		return super.setCapsValue(pIndex, pArg);
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_setFaceTexture:
			return setFaceTexture((Integer)pArg[0]);
		case caps_textureLightColor:
			return getTextureLightColor((IModelCaps)pArg[0]);
		}
		return super.getCapsValue(pIndex, pArg);
	}

	
	
	public void renderFace(IModelCaps pEntityCaps, float par2, float par3, float ticksExisted,
			float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {
	}
	public void renderBody(IModelCaps pEntityCaps, float par2, float par3, float ticksExisted,
			float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {
	}
	
	public int setFaceTexture(int pIndex) {
		// u = (int)(pIndex % 2) * 32 / 64
		// v = (int)(pIndex / 2) * 32 / 32
		GL11.glTranslatef(((pIndex & 0x01) * 32) / textureWidth, (((pIndex >>> 1) & 0x01) * 16) / textureHeight , 0F);
		return pIndex / 4;
	}

	public float[] getTextureLightColor(IModelCaps pEntityCaps) {
		return null;
	}

	@Override
	public void showAllParts(IModelCaps iModelCaps) {
	}

}
