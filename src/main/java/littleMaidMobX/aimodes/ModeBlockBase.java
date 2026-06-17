package littleMaidMobX.aimodes;

import net.minecraft.tileentity.TileEntity;

import littleMaidMobX.entity.EntityLittleMaid;

public abstract class ModeBlockBase extends ModeBase {

    // protected TileEntity fTile;
    protected double fDistance;

    public ModeBlockBase(EntityLittleMaid pEntity) {
        super(pEntity);
    }

    @Override
    public void updateBlock() {

        owner.setTilePos(0);
    }

    @Override
    public boolean isSearchBlock() {
        boolean lflag = false;
        for (int li = 0; li < owner.maidTiles.length; li++) {
            if (owner.maidTiles[li] != null) {
                TileEntity ltile = owner.getTileEntity(li);
                if (ltile != null && !checkWorldMaid(ltile)) {
                    if (!lflag) {
                        owner.setTilePos(ltile);
                    }
                    lflag = true;
                }
            }
        }
        return !lflag;
    }

    @Override
    public boolean overlooksBlock(int pMode) {
        if (owner.isTilePos()) {
            owner.setTilePos(0);
        }
        return true;
    }

    protected boolean checkWorldMaid(TileEntity pTile) {

        for (Object lo : owner.worldObj.loadedEntityList) {
            if (lo == owner) continue;
            if (lo instanceof EntityLittleMaid) {
                EntityLittleMaid lem = (EntityLittleMaid) lo;
                if (lem.isUsingTile(pTile)) {

                    return true;
                }
            }
        }
        return false;
    }

}
