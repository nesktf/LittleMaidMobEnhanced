package modchu.lib.lmm.characteristic;

import littleMaidMobX.render.EntityCapsBase;
import modchu.lib.characteristic.Modchu_EntityCapsBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LMMXModelCaps extends EntityCapsBase {
	protected Modchu_EntityCapsBase master;

	public Modchu_LMMXModelCaps(EntityLivingBase pOwner) {
		super(pOwner);
	}

	public Modchu_LMMXModelCaps(Modchu_EntityCapsBase entityCapsBase) {
		super((EntityLivingBase) entityCapsBase.getCapsValue(caps_Entity));
		master = entityCapsBase;
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		Object o = master != null ? master.getCapsValue(pIndex, pArg) : null;
		if (o != null) return o;
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return master != null
				&& master.setCapsValue(pIndex, pArg) ? true : super.setCapsValue(pIndex, pArg);
	}

	public Modchu_EntityCapsBase getMaster() {
		return master;
	}

	public void setMaster(Modchu_EntityCapsBase entityCapsBase) {
		master = entityCapsBase;
	}
}