package littleMaidMobX.model;

import littleMaidMobX.model.maid.ModelBase;
import littleMaidMobX.model.maid.ModelMultiBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class ModelStabilizerBase extends ModelBase {

	public ModelStabilizerBase() {
	}

	/**
	 * �
	 */
	public ResourceLocation getTexture() {
		return null;
	}

	/**
	 * �
	 * pName:�
	 */
	public boolean checkEquipment(String pName) {
		return true;
	}

	/**
	 * 
	 */
	public abstract String getName();

	/**
	 * 
	 */
	public int getExclusive() {
		return 0;
	}

	/**
	 * 
	 */
	public boolean isLoadAnotherTexture() {
		return false;
	}

	/**
	 * 
	 */
	public void init(EquippedStabilizer pequipped) {
		// 
	}
/*	
	@Deprecated
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	}

	/**
	 * 
	 */
	public void render(ModelMultiBase pModel, Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
//		render(par1Entity, par2, par3, par4, par5, par6, par7);
	}

}
