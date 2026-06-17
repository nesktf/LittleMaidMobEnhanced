package littleMaidMobX.ai;

import net.minecraft.entity.ai.EntityAISit;

import littleMaidMobX.entity.EntityLittleMaid;

public class AIWait extends EntityAISit {

    public EntityLittleMaid theMaid;

    public AIWait(EntityLittleMaid pEntity) {
        super(pEntity);
        this.setMutexBits(5);

        theMaid = pEntity;
    }

    @Override
    public boolean shouldExecute() {
        return theMaid.isMaidWaitEx() || (!theMaid.isFreedom() && theMaid.mstatMasterEntity == null);
    }

}
