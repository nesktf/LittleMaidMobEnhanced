package littleMaidMobX.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;

public class AIWander extends EntityAIWander implements IEntityAI {

    protected boolean isEnable;

    public AIWander(EntityCreature par1EntityCreature, float par2) {
        super(par1EntityCreature, par2);

        isEnable = false;
    }

    @Override
    public boolean shouldExecute() {
        return isEnable && super.shouldExecute();
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
