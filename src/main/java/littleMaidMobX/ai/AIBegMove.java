package littleMaidMobX.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

import littleMaidMobX.entity.EntityLittleMaid;

public class AIBegMove extends EntityAIBase {

    private EntityLittleMaid theMaid;
    private EntityPlayer thePlayer;
    private float moveSpeed;

    public AIBegMove(EntityLittleMaid pEntityLittleMaid, float pmoveSpeed) {
        theMaid = pEntityLittleMaid;
        moveSpeed = pmoveSpeed;

        setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        return theMaid.isLookSuger();
    }

    @Override
    public void startExecuting() {
        thePlayer = theMaid.aiBeg.getPlayer();
    }

    @Override
    public void resetTask() {
        thePlayer = null;
    }

    @Override
    public boolean continueExecuting() {
        return shouldExecute();
    }

    @Override
    public void updateTask() {

        // http://forum.minecraftuser.jp/viewtopic.php?f=13&t=23347&start=220

        if (theMaid.aiBeg.getDistanceSq() < 3.5D || thePlayer == null) {
            theMaid.getNavigator()
                .clearPathEntity();
        } else {
            theMaid.getNavigator()
                .tryMoveToEntityLiving(thePlayer, moveSpeed);
        }
    }
}
