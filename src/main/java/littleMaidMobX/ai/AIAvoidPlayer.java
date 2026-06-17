package littleMaidMobX.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import littleMaidMobX.entity.EntityLittleMaid;

public class AIAvoidPlayer extends EntityAIBase implements IEntityAI {

    /** The entity we are attached to */
    protected EntityLittleMaid theMaid;
    protected EntityPlayer theMaster;
    protected float speedNormal;
    protected PathEntity avoidPath;
    /** The PathNavigate of our entity */
    protected PathNavigate entityPathNavigate;
    protected boolean isEnable;

    public boolean isActive;
    public int minDist;

    public AIAvoidPlayer(EntityLittleMaid pEntityLittleMaid, float pSpeed, int pMinDist) {
        theMaid = pEntityLittleMaid;
        speedNormal = pSpeed;
        entityPathNavigate = pEntityLittleMaid.getNavigator();
        isActive = false;
        isEnable = false;
        minDist = pMinDist;
        setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!isEnable || !isActive || !theMaid.isContract()) {
            isActive = false;
            return false;
        }

        theMaster = theMaid.mstatMasterEntity;

        // http://forum.minecraftuser.jp/viewtopic.php?f=13&t=23347&start=180#p211806
        if (theMaster == null) {
            return false;
        }

        if (!theMaid.getEntitySenses()
            .canSee(theMaster)) {
            return false;
        }

        Vec3 vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(
            theMaid,
            minDist,
            7,
            Vec3.createVectorHelper(theMaster.posX, theMaster.posY, theMaster.posZ));

        if (vec3d == null) {
            return false;
        }

        if (theMaster.getDistanceSq(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord) < theMaid.mstatMasterDistanceSq) {
            return false;
        }

        avoidPath = entityPathNavigate.getPathToXYZ(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord);

        if (avoidPath == null) {
            return false;
        }

        return avoidPath.isDestinationSame(vec3d);
    }

    @Override
    public boolean continueExecuting() {
        if (theMaster == null) return false;
        return !entityPathNavigate.noPath() && theMaid.getDistanceSqToEntity(theMaster) < 144D;
    }

    @Override
    public void startExecuting() {
        entityPathNavigate.setPath(avoidPath, speedNormal);
    }

    @Override
    public void resetTask() {
        isActive = false;
    }

    public void setActive() {

        isActive = true;
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
