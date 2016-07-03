package littleMaidMobX.ai;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.util.Debug;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AIJumpToMaster extends EntityAIBase implements IEntityAI {

	protected EntityLittleMaid theMaid;
	protected EntityLivingBase theOwner;
	protected World theWorld;
	protected boolean isEnable;
	private boolean jumpTarget;
	protected AxisAlignedBB boundingBox;

	public AIJumpToMaster(EntityLittleMaid pEntityLittleMaid) {
		super();
		
		theMaid = pEntityLittleMaid;
		theWorld = pEntityLittleMaid.worldObj;
		isEnable = true;
		boundingBox = AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}
	
	public void resetTask() {
		// TODO Auto-generated method stub
		super.resetTask();
	}

	@Override
	public boolean shouldExecute() {
		if (!isEnable || !theMaid.isContractEX() || theMaid.isMaidWaitEx()) {
			
			return false;
		}
		if (theMaid.getLeashed()) {
			
			return false;
		}
		if (theMaid.isFreedom()) {
			
			if (theMaid.homeWorld != theMaid.dimension) {
				Debug.ai(String.format("ID:%d, %d -> %d, Change HomeWorld. reset HomePosition.",
						theMaid.getEntityId(),theMaid.homeWorld, theMaid.worldObj.provider.dimensionId));
//				theMaid.func_110171_b(
				theMaid.setHomeArea(
						MathHelper.floor_double(theMaid.posX),
						MathHelper.floor_double(theMaid.posY),
						MathHelper.floor_double(theMaid.posZ), 16);
				return false;
			}
			
			if (theMaid.getHomePosition().getDistanceSquared(
					MathHelper.floor_double(theMaid.posX),
					MathHelper.floor_double(theMaid.posY),
					MathHelper.floor_double(theMaid.posZ)) > 400D) {
				jumpTarget = false;
				Debug.ai(String.format(
						"ID:%d(%s) Jump To Home.", theMaid.getEntityId(),
						theMaid.worldObj.isRemote ? "C" : "W"));
				return true;
			}
		} else {
			jumpTarget = true;
			theOwner = theMaid.getMaidMasterEntity();
			if (theMaid.getAttackTarget() == null) {
				if (theMaid.mstatMasterDistanceSq < 144D) {
					return false;
				}
			} else {
				
				if (theMaid.mstatMasterDistanceSq < (theMaid.isBloodsuck() ? 1024D : 256D)) {
					return false;
				}
			}
			Debug.ai(
					"ID:%d(%s) Jump To Master.",
					theMaid.getEntityId(), theMaid.worldObj.isRemote ? "C" : "W");
			return true;
		}
		return false;
	}

	@Override
	public void startExecuting() {
		if (jumpTarget) {
			if (theOwner != null) {
				int i = MathHelper.floor_double(theOwner.posX) - 2;
				int j = MathHelper.floor_double(theOwner.posZ) - 2;
				int k = MathHelper.floor_double(theOwner.boundingBox.minY);
				
				for (int l = 0; l <= 4; l++) {
					for (int i1 = 0; i1 <= 4; i1++) {
						if ((l < 1 || i1 < 1 || l > 3 || i1 > 3)
								&& theWorld.getBlock(i + l, k - 1, j + i1).isNormalCube()
								&& !theWorld.getBlock(i + l, k, j + i1).isNormalCube()
								&& !theWorld.getBlock(i + l, k + 1, j + i1).isNormalCube()) {
							
							double dd = theOwner.getDistanceSq(
									(double) (i + l) + 0.5D + MathHelper.sin(theOwner.rotationYaw * 0.01745329252F) * 2.0D,
									(double) k,
									(double) (j + i1) - MathHelper.cos(theOwner.rotationYaw * 0.01745329252F) * 2.0D);
							if (dd > 8D) {
	//							theMaid.setTarget(null);
	//							theMaid.setRevengeTarget(null);
	//							theMaid.setAttackTarget(null);
	//							theMaid.getNavigator().clearPathEntity();
								theMaid.setLocationAndAngles(
										(float) (i + l) + 0.5F, k, (float) (j + i1) + 0.5F,
										theMaid.rotationYaw, theMaid.rotationPitch);
								return;
							}
						}
					}
				}
			} else {
				System.out.println("Owner is null");
			}
		} else {
			
			int lx = theMaid.getHomePosition().posX;
			int ly = theMaid.getHomePosition().posY;
			int lz = theMaid.getHomePosition().posZ;
			if (!(isCanJump(lx, ly, lz))) {
				
				Debug.ai(String.format(
						"ID:%d(%s) home lost.",
						theMaid.getEntityId(), theMaid.worldObj.isRemote ? "C" : "W"));
				int a;
				int b;
				// int c;
				boolean f = false;
				
				for (a = 1; a < 6 && !f; a++) {
					if (isCanJump(lx, ly + a, lz)) {
						f = true;
						ly += a;
						break;
					}
				}
				for (a = -1; a > -6 && !f; a--) {
					if (isCanJump(lx, ly + a, lz)) {
						f = true;
						ly += a;
						break;
					}
				}

				
				loop_search: for (a = 2; a < 18 && !f; a += 2) {
					lx--;
					lz--;
					for (int c = 0; c < 4; c++) {
						for (b = 0; b <= a; b++) {
							// N
							if (isCanJump(lx, ly + a, lz)) {
								f = true;
								break loop_search;
							}
							if (c == 0)
								lx++;
							else if (c == 1)
								lz++;
							else if (c == 2)
								lx--;
							else if (c == 3)
								lz--;
						}
					}
				}
				if (f) {
//					theMaid.func_110171_b(lx, ly, lz, (int) theMaid.func_110174_bM());
					theMaid.setHomeArea(lx, ly, lz, (int) theMaid.func_110174_bM());
					Debug.ai(String.format(
							"Find new position:%d, %d, %d.", lx, ly, lz));
				} else {
					if (isCanJump(lx, ly - 6, lz)) {
						ly -= 6;
					}
					Debug.ai(String.format(
							"loss new position:%d, %d, %d.", lx, ly, lz));
				}
			} else {
				Debug.ai(String.format(
						"ID:%d(%s) home solid.",
						theMaid.getEntityId(), theMaid.worldObj.isRemote ? "C" : "W"));
			}
			
//			theMaid.setTarget(null);
//			theMaid.setAttackTarget(null);
//			theMaid.getNavigator().clearPathEntity();
			theMaid.setLocationAndAngles((double) lx + 05D, (double) ly, (double) lz + 0.5D,
					theMaid.rotationYaw, theMaid.rotationPitch);
			
		}
		
		theMaid.setTarget(null);
		theMaid.setAttackTarget(null);
		theMaid.setRevengeTarget(null);
		theMaid.getNavigator().clearPathEntity();
		Debug.ai(String.format("ID:%d(%s) Jump Fail.",
				theMaid.getEntityId(), theMaid.worldObj.isRemote ? "C" : "W"));
	}

	
	protected boolean isCanJump(int px, int py, int pz) {
		double lw = (double) theMaid.width / 2D;
		double ly = (double) py - (double) (theMaid.yOffset + theMaid.ySize);
		boundingBox.setBounds((double) px - lw, ly, (double) pz - lw,
				(double) px + lw, ly + (double) theMaid.height, (double) pz + lw);
		
		return theWorld.getBlock(px, py - 1, pz).getMaterial().isSolid()
				&& theWorld.func_147461_a(boundingBox).isEmpty();
	}

	@Override
	public boolean continueExecuting() {
		return false;
	}

	@Override
	public void setEnable(boolean pFlag) {
		isEnable = pFlag;
	}

	@Override
	public boolean getEnable() {
		return isEnable;
	}

	@Override
	public boolean isInterruptible() {
		return true;
	}

}
