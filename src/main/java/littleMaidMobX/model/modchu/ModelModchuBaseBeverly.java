package littleMaidMobX.model.modchu;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.render.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public abstract class ModelModchuBaseBeverly extends ModelModchuBaseSR2 {

	public ModelModchuBaseBeverly(StringBuilder hack) {
		super(hack);
	}
	
	public ModelModchuBaseBeverly() {
		this(0.0F);
	}

	public ModelModchuBaseBeverly(float f) {
		this(f, 0.0F);
	}

	public ModelModchuBaseBeverly(float f, float f1) {
		this(f, f1, 64, 64);
	}

	public ModelModchuBaseBeverly(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}

	@Override
	public void setLivingAnimationsLM(IModelCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Entity entityliving = (Entity) entityCaps.getCapsValue(caps_Entity);
		if (entityliving == null)
			return;
		if (entityliving.worldObj != null && !entityliving.isSneaking()) {
			int x = MathHelper.floor_double(entityliving.posX);
			int y = MathHelper.floor_double(entityliving.boundingBox.maxY+1);
			int z = MathHelper.floor_double(entityliving.posZ);
			isSneak = entityliving.worldObj.isAirBlock(x, y, z);
		}

		if (entityliving instanceof EntityPlayer) {
			rightLeg.rotateAngleY = 0.5F;
			leftLeg.rotateAngleY = -0.5F;
		} else {
			rightLeg.rotateAngleY = 0F;
			leftLeg.rotateAngleY = 0F;
		}

	}

	@Override
	public float getHeight(IModelCaps entityCaps) {
		return 1.99F;
	}

	@Override
	public float getWidth(IModelCaps entityCaps) {
		return 0.6F;
	}

	@Override
	public float getRidingHeight(IModelCaps entityCaps) {
		return 0.99F;
	}

	@Override
	public float getyOffset(IModelCaps entityCaps) {
		return 1.81F;
	}

	@Override
	public float getRidingYOffset(IModelCaps entityCaps) {
		return 1.61F;
	}

	@Override
	public float getMountedYOffset(IModelCaps entityCaps) {
		return 0.7F;
	}

	@Override
	public double getSittingYOffset(IModelCaps entityCaps) {
		return -0.5D;
	}

	@Override
	public void renderFirstPersonHand(IModelCaps entityCaps) {
//		bipedBody.postRender(f);
////		if (i == 0) 
//			getDominantArm((IModelCaps) entityCaps).render(f);
////		if (i == 1) getNotDominantArm((IModelCaps) entityCaps).render(f);
	}

	@Override
	public ModelRenderer getDominantArm(IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;
		return leftArm;
	}

	@Override
	public ModelRenderer getNotDominantArm(IModelCaps entityCaps) {
		if (ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return leftArm;
		return rightArm;
	}

	@Override
	public ModelRenderer getBipedRightArm(IModelCaps entityCaps) {
		return rightArm;
	}

	@Override
	public ModelRenderer getBipedLeftArm(IModelCaps entityCaps) {
		return leftArm;
	}

	@Override
	public ModelRenderer getBipedRightLeg(IModelCaps entityCaps) {
		return rightLeg;
	}

	@Override
	public ModelRenderer getBipedLeftLeg(IModelCaps entityCaps) {
		return leftLeg;
	}

}
