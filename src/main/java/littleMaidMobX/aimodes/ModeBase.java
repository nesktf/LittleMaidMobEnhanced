package littleMaidMobX.aimodes;

import java.util.List;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.render.RenderLittleMaid;
import littleMaidMobX.util.Debug;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;


public abstract class ModeBase {

	public final EntityLittleMaid owner;


	
	public ModeBase(EntityLittleMaid pEntity) {
		owner = pEntity;
	}

	public int fpriority;
	
	/**
	 * 優先順位。
	 * 番号が若いほうが先に処理される。
	 * 下二桁が00のものはシステム予約。
	 */
	public abstract int priority();

	
	public void init() {
	}

	
	public void initEntity()
	{
	}

	
	public abstract void addEntityMode(EntityAITasks pDefaultMove, EntityAITasks pDefaultTargeting);

	
	public void writeEntityToNBT(NBTTagCompound par1nbtTagCompound) {
	}
	
	public void readEntityFromNBT(NBTTagCompound par1nbtTagCompound) {
	}

	
	public void showSpecial(RenderLittleMaid prenderlittlemaid, double px, double py, double pz) {
	}

	
	public void updateAITick(int pMode) {
	}

	
	public void onUpdate(int pMode) {
	}

	
	public boolean preInteract(EntityPlayer pentityplayer, ItemStack pitemstack) {
		return false;
	}
	
	public boolean interact(EntityPlayer pentityplayer, ItemStack pitemstack) {
		return false;
	}

	
	public boolean changeMode(EntityPlayer pentityplayer) {
		return false;
	}

	
	public boolean setMode(int pMode) {
		return false;
	}

	
	public int getNextEquipItem(int pMode) {
		
		return -1;
	}
	
	
	public boolean checkItemStack(ItemStack pItemStack)//This is used to determine wether or not a maid is allowed to pick up items.
	{
		return (pItemStack.getItem() == Items.sugar);
	}

	
	public boolean attackEntityAsMob(int pMode, Entity pEntity) {
		
		return false;
	}

	
	public boolean isSearchBlock() {
		return false;
	}

	
	public boolean shouldBlock(int pMode) {
		return false;
	}

	//What does this do?
	public boolean checkBlock(int pMode, int px, int py, int pz) {
		return false;
	}

	
	public boolean overlooksBlock(int pMode) {
		return false;
	}
//	@Deprecated
//	public TileEntity overlooksBlock(int pMode) {
//		return null;
//	}

	
	public void farrangeBlock() {
		owner.getNavigator().clearPathEntity();
	}

	
	public boolean outrangeBlock(int pMode, int pX, int pY, int pZ) {
		return owner.getNavigator().tryMoveToXYZ(pX, pY, pZ, 1.0F);
	}
	public boolean outrangeBlock(int pMode) {
		return outrangeBlock(pMode, owner.maidTile[0], owner.maidTile[1], owner.maidTile[2]);
	}

	
	public boolean executeBlock(int pMode, int px, int py, int pz) {
		return false;
	}
	public boolean executeBlock(int pMode) {
		return executeBlock(pMode, owner.maidTile[0], owner.maidTile[1], owner.maidTile[2]);
	}

	
	public void startBlock(int pMode) {
	}

	
	public void resetBlock(int pMode) {
	}

	
	public void updateBlock() {
	}


	
	public boolean isSearchEntity() {
		return false;
	}

	
	public boolean checkEntity(int pMode, Entity pEntity) {
		return false;
	}

	
	public int colorMultiplier(float pLight, float pPartialTicks) {
		return 0;
	}
	
	
	public float attackEntityFrom(DamageSource par1DamageSource, float par2) {
		return 0;
	}
	
	public boolean damageEntity(int pMode, DamageSource par1DamageSource, float par2) {
		return false;
	}

	
	public boolean isUsingTile(TileEntity pTile) {
		return false;
	}

	
	public List<TileEntity> getTiles() {
		return null;
	}

	
	protected boolean canBlockBeSeen(int pX, int pY, int pZ, boolean toTop, boolean do1, boolean do2) {
		
		World worldObj = owner.worldObj;
		Block lblock = worldObj.getBlock(pX, pY, pZ);
		if (lblock == null) {
			Debug.ai("block-null: %d, %d, %d", pX, pY, pZ);
			return false;
		}
		lblock.setBlockBoundsBasedOnState(worldObj, pX, pY, pZ);
		
		Vec3 vec3do = Vec3.createVectorHelper(owner.posX, owner.posY + owner.getEyeHeight(), owner.posZ);
		Vec3 vec3dt = Vec3.createVectorHelper((double)pX + 0.5D, (double)pY + ((lblock.getBlockBoundsMaxY() + lblock.getBlockBoundsMinY()) * (toTop ? 0.9D : 0.5D)), (double)pZ + 0.5D);
		MovingObjectPosition movingobjectposition = worldObj.func_147447_a(vec3do, vec3dt, do1, do2, false);
		
		if (movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
			
			if (movingobjectposition.blockX == pX && 
					movingobjectposition.blockY == pY &&
					movingobjectposition.blockZ == pZ) {
				return true;
			}
		}
		return false;
	}

	
	public double getRangeToMaster(int pIndex) {
		return pIndex == 0 ? 36D : pIndex == 1 ? 25D : 0D;
	}

	
	public boolean isChangeTartget(Entity pTarget) {
		return !owner.isBloodsuck();
	}

}
