package littleMaidMobX.model.modchu;

import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.render.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

public class ModelModchuBaseSR2 extends ModelModchuBaseMulti {

	public ModelRenderer eyeR;
	public ModelRenderer eyeL;

	public ModelModchuBaseSR2(StringBuilder hack) {
		super(hack);
	}

	public ModelModchuBaseSR2() {
		super();
	}
	public ModelModchuBaseSR2(float psize) {
		super(psize);
	}
	public ModelModchuBaseSR2(float psize, float pyoffset, int pTextureWidth, int pTextureHeight) {
		super(psize, pyoffset, pTextureWidth, pTextureHeight);
	}


	@Override
	public void initModel(float psize, float pyoffset, boolean isAfterInit) {
		super.initModel(psize, pyoffset, isAfterInit);
		
		
		eyeR = new ModelRenderer(this, 32, 19, "eyeR");
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModelRenderer(this, 42, 19, "eyeL");
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
	}

	@Override
	public void setLivingAnimations(IModelCaps pEntityCaps, float par2, float par3, float pRenderPartialTicks) {
		super.setLivingAnimations(pEntityCaps, par2, par3, pRenderPartialTicks);
		
		float f3 = (float)entityTicksExisted + pRenderPartialTicks + entityIdFactor;
		
		if( 0 > mh_sin(f3 * 0.05F) + mh_sin(f3 * 0.13F) + mh_sin(f3 * 0.7F) + 2.55F) { 
			eyeR.setVisible(true);
			eyeL.setVisible(true);
		} else { 
			eyeR.setVisible(false);
			eyeL.setVisible(false);
		}
	}

	@Override
	public void setRotationAngles(float par1, float par2, float pTicksExisted,
			float pHeadYaw, float pHeadPitch, float par6, IModelCaps pEntityCaps) {
		super.setRotationAngles(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, pEntityCaps);
		if (aimedBow) {
			if (ModelCapsHelper.getCapsValueInt(pEntityCaps, caps_dominantArm) == 0) {
				eyeL.setVisible(true);
			} else {
				eyeR.setVisible(true);
			}
		}
	}

	@Override
	public String getUsingTexture() {
		return null;
	}

	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
		eyeAnimations(entityCaps, f, f1, renderPartialTicks);
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		eyeRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}

	protected void eyeAnimations(IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		Object entityliving = entityCaps != null ? entityCaps.getCapsValue(caps_Entity) : null;
		//Modchu_Debug.mDebug("MultiModel_SR2 eyeAnimations entityliving="+entityliving);
		if (entityliving != null); else return;
		int ticksExisted = Helper.getEntityTicksExisted(entityliving);
		float f3 = (float)ticksExisted + renderPartialTicks + ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		// 目パチ
		boolean eyeFlag = equipmentCheckOfHead(entityCaps);
		if(eyeFlag && 0 > Helper.sin(f3 * 0.05F) + Helper.sin(f3 * 0.13F) + Helper.sin(f3 * 0.7F) + 2.55F) {
			setCapsValue(entityCaps, caps_visible, eyeR, true);
			setCapsValue(entityCaps, caps_visible, eyeL, true);
		} else {
			setCapsValue(entityCaps, caps_visible, eyeR, false);
			setCapsValue(entityCaps, caps_visible, eyeL, false);
		}
	}

	protected void eyeRotationAngles(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, eyeL, true);
			setCapsValue(entityCaps, caps_visible, eyeR, false);
		}
	}

	public boolean equipmentCheckOfHead(IModelCaps entityCaps) {
		boolean flag = true;
		Object itemstack = getCapsValue(caps_currentArmor, 3);
		if (itemstack != null) {
			int addSupport = addSupportChecks(entityCaps, itemstack, 1);
			if (addSupport == 3 |
					addSupport == 4) flag = false;
		}
		Object inventory = entityCaps.getCapsValue(caps_Inventory);
		if (inventory instanceof IInventory) {
			Object pEntity = entityCaps.getCapsValue(caps_Entity);
			int slot = pEntity instanceof EntityPlayer ? 10 : 16;
			Object itemstack1 = ((IInventory)inventory).getStackInSlot(slot);
			if (itemstack1 != null) {
				int addSupport = addSupportChecks(entityCaps, itemstack, 1);
				if (addSupport == 3 |
						addSupport == 4) flag = false;
			}
		}
		return flag;
	}
}
