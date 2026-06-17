package littleMaidMobX.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class AIRestrictRain extends EntityAIBase implements IEntityAI {

    protected EntityLiving theEntity;
    protected boolean isEnable;

    public AIRestrictRain(EntityLiving par1EntityLiving) {
        theEntity = par1EntityLiving;
        isEnable = false;
    }

    @Override
    public boolean shouldExecute() {
        return isEnable && theEntity.worldObj.isRaining();
    }

    @Override
    public void startExecuting() {
        theEntity.getNavigator()
            .setAvoidSun(true);
    }

    @Override
    public void resetTask() {
        theEntity.getNavigator()
            .setAvoidSun(false);
    }

    @Override
    public void setEnable(boolean pFlag) {
        isEnable = pFlag;
    }

    @Override
    public boolean getEnable() {
        return isEnable;
    }

}
