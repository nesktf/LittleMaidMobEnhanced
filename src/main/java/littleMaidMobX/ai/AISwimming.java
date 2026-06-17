package littleMaidMobX.ai;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;

public class AISwimming extends EntityAISwimming {

    protected EntityLiving theEntity;

    public AISwimming(EntityLiving par1EntityLiving) {
        super(par1EntityLiving);
        theEntity = par1EntityLiving;
    }

    @Override
    public boolean shouldExecute() {

        return (theEntity.getNavigator()
            .noPath() ? (!theEntity.onGround || theEntity.isInsideOfMaterial(Material.water)) : theEntity.isInWater())
            || theEntity.handleLavaMovement();
    }

}
