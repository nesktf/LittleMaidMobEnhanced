package littleMaidMobX.ai;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.aimodes.SwingStatus;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.entity.EntityLittleMaidAvatar;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.inventory.InventoryLittleMaid;
import littleMaidMobX.sound.EnumSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AIAttackArrow extends EntityAIBase implements IEntityAI {

	protected boolean fEnable;
	
	protected EntityLittleMaid fMaid;
	protected EntityLittleMaidAvatar fAvatar;
	protected InventoryLittleMaid fInventory;
	protected SwingStatus swingState;
	protected World worldObj;
	protected EntityLivingBase fTarget;
	protected int fForget;

	
	public AIAttackArrow(EntityLittleMaid pEntityLittleMaid) {
		fMaid = pEntityLittleMaid;
		fAvatar = pEntityLittleMaid.maidAvatar;
		fInventory = pEntityLittleMaid.maidInventory;
		swingState = pEntityLittleMaid.getSwingStatusDominant();
		worldObj = pEntityLittleMaid.worldObj;
		fEnable = false;
		setMutexBits(3);
	}
	
	@Override
	public boolean shouldExecute() {
		EntityLivingBase entityliving = fMaid.getAttackTarget();
		
		if (!fEnable || entityliving == null || entityliving.isDead) {
			fMaid.setAttackTarget(null);
			fMaid.setTarget(null);
			if (entityliving != null) {
				fMaid.getNavigator().clearPathEntity();
			}
			fTarget = null;
			return false;
		} else {
			fTarget = entityliving;
			return true;
		}
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		fMaid.playSound(fMaid.isBloodsuck() ? EnumSound.findTarget_B : EnumSound.findTarget_N, false);
		swingState = fMaid.getSwingStatusDominant();
	}

	@Override
	public boolean continueExecuting() {
		return shouldExecute() || (fTarget != null && !fMaid.getNavigator().noPath());
	}

	@Override
	public void resetTask() {
		fTarget = null;
	}

	@Override
	public void updateTask() {

		double backupPosX = fMaid.posX;
		double backupPosZ = fMaid.posZ;
		
		
		
		if(fMaid.ridingEntity instanceof EntityPlayer)
		{
			double dtx = fTarget.posX - fMaid.posX;
			double dtz = fTarget.posZ - fMaid.posZ;
			double distTarget = MathHelper.sqrt_double(dtx*dtx + dtz*dtz);
			fMaid.posX += dtx / distTarget * 1.0;	
			fMaid.posZ += dtz / distTarget * 1.0;	
		}
		
		double lrange = 225D;
		double ldist = fMaid.getDistanceSqToEntity(fTarget);
		boolean lsee = fMaid.getEntitySenses().canSee(fTarget);
		
		
		if (lsee) {
			fForget = 0;
		} else {
			fForget++;
		}
		
		
		fMaid.getLookHelper().setLookPositionWithEntity(fTarget, 30F, 30F);
		
		if (ldist < lrange) {
			
			double atx = fTarget.posX - fMaid.posX;
			double aty = fTarget.posY - fMaid.posY;
			double atz = fTarget.posZ - fMaid.posZ;
			if (fTarget.isEntityAlive()) {
				ItemStack litemstack = fMaid.getCurrentEquippedItem();
				
				double atl = atx * atx + aty * aty + atz * atz;
				double il = -1D;
				double milsq = 10D;
				Entity masterEntity = fMaid.getMaidMasterEntity();
				if (masterEntity != null && !fMaid.isPlaying()) {
					
					double amx = masterEntity.posX - fMaid.posX;
					double amy = masterEntity.posY - fMaid.posY;//-2D
					double amz = masterEntity.posZ - fMaid.posZ;
					
					
					il = (amx * atx + amy * aty + amz * atz) / atl;
					
					
					double mix = (fMaid.posX + il * atx) - masterEntity.posX;
					double miy = (fMaid.posY + il * aty) - masterEntity.posY;// + 2D;
					double miz = (fMaid.posZ + il * atz) - masterEntity.posZ;
					
					milsq = mix * mix + miy * miy + miz * miz;
//					mod_LMM_littleMaidMob.Debug("il:%f, milsq:%f", il, milsq);
				}
				
				if (litemstack != null && !(litemstack.getItem() instanceof ItemFood) && !fMaid.weaponReload) {
					int lastentityid = worldObj.loadedEntityList.size();
					int itemcount = litemstack.stackSize;
					fMaid.mstatAimeBow = true;
					fAvatar.getValueVectorFire(atx, aty, atz, atl);
					
					boolean lcanattack = true;
					boolean ldotarget = false;
					double tpr = Math.sqrt(atl);
					Entity lentity = Helper.getRayTraceEntity(fMaid.maidAvatar, tpr + 1.0F, 1.0F, 1.0F);
					Item helmid = !fMaid.isMaskedMaid() ? null : fInventory.armorInventory[3].getItem();
					if (helmid == Items.diamond_helmet || helmid == Items.golden_helmet) {
						
						if (lentity != null && fMaid.getIFF(lentity)) {
							lcanattack = false;
//							mod_LMM_littleMaidMob.Debug("ID:%d-friendly fire to ID:%d.", fMaid.entityId, lentity.entityId);
						}
					}
					if (lentity == fTarget) {
						ldotarget = true;
					}
					lcanattack &= (milsq > 3D || il < 0D);
					lcanattack &= ldotarget;
					
					if (!lcanattack) {
						
						double tpx = fMaid.posX;
						double tpy = fMaid.posY;
						double tpz = fMaid.posZ;
//						double tpr = Math.sqrt(atl) * 0.5D;
						tpr = tpr * 0.5D;
						if (fMaid.isBloodsuck()) {
							
							tpx += (atz / tpr);
							tpz -= (atx / tpr);
						} else {
							
							tpx -= (atz / tpr);
							tpz += (atx / tpr);
						}
						fMaid.getNavigator().tryMoveToXYZ(tpx, tpy, tpz, 1.0F);
					}
					else if (lsee & ldist < 100) {
						fMaid.getNavigator().clearPathEntity();
//						mod_LMM_littleMaidMob.Debug("Shooting Range.");
					}
					
					lcanattack &= lsee;
//            		mod_littleMaidMob.Debug(String.format("id:%d at:%d", entityId, attackTime));
					if (((fMaid.weaponFullAuto && !lcanattack) || (lcanattack && fMaid.getSwingStatusDominant().canAttack())) && fAvatar.isItemTrigger) {
						
						
						Debug.entity("id:%d shoot.", fMaid.getEntityId());
						fAvatar.stopUsingItem();
						fMaid.setSwing(30, EnumSound.shoot);
					} else {
						
						if (litemstack.getMaxItemUseDuration() > 500) {
//                			mod_littleMaidMob.Debug(String.format("non reload.%b", isMaskedMaid));
							
							if (!fAvatar.isUsingItemLittleMaid()) {
								
								if (!fMaid.weaponFullAuto || lcanattack) {
									
									int at = ((helmid == Items.iron_helmet) || (helmid == Items.diamond_helmet)) ? 26 : 16;
									if (swingState.attackTime < at) {
										fMaid.setSwing(at, EnumSound.sighting);
										litemstack = litemstack.useItemRightClick(worldObj, fAvatar);
										Debug.entity("id:%d redygun.", fMaid.getEntityId());
									}
								} else {
									Debug.ai(String.format("ID:%d-friendly fire FullAuto.", fMaid.getEntityId()));
								}
							}
						} 
						else if (litemstack.getMaxItemUseDuration() == 0) {
							
							if (swingState.canAttack() && !fAvatar.isUsingItem()) {
								if (lcanattack) {
									litemstack = litemstack.useItemRightClick(worldObj, fAvatar);
									
									fMaid.mstatAimeBow = false;
									fMaid.setSwing(10, (litemstack.stackSize == itemcount) ? EnumSound.shoot_burst : EnumSound.Null);
									Debug.ai(String.format("id:%d throw weapon.(%d:%f:%f)", fMaid.getEntityId(), swingState.attackTime, fMaid.rotationYaw, fMaid.rotationYawHead));
								} else {
									Debug.ai(String.format("ID:%d-friendly fire throw weapon.", fMaid.getEntityId()));
								}
							}
						} else {
							
							if (!fAvatar.isUsingItemLittleMaid()) {
								litemstack = litemstack.useItemRightClick(worldObj, fAvatar);
								Debug.ai(String.format("%d reload.", fMaid.getEntityId()));
							}
							
							swingState.attackTime = 5;
						}
					}
//            		maidAvatarEntity.setValueRotation();
					fAvatar.setValueVector();
					
					if (litemstack.stackSize <= 0) {
						fMaid.destroyCurrentEquippedItem();
						fMaid.getNextEquipItem();
					} else {
						fInventory.setInventoryCurrentSlotContents(litemstack);
					}
				}
			}
		} else {
			
			if (fMaid.getNavigator().noPath()) {
				fMaid.getNavigator().tryMoveToEntityLiving(fTarget, 1.0);
			}
			if (fMaid.getNavigator().noPath()) {
				Debug.ai("id:%d Target renge out.", fMaid.getEntityId());
				fMaid.setAttackTarget(null);
			}
			if (fMaid.weaponFullAuto && fAvatar.isItemTrigger) {
				fAvatar.stopUsingItem();
			} else {
				fAvatar.clearItemInUse();
			}
			
		}
		

		
		fMaid.posX = backupPosX;
		fMaid.posZ = backupPosZ;
	}

	@Override
	public void setEnable(boolean pFlag) {
		fEnable = pFlag;
	}

	@Override
	public boolean getEnable() {
		return fEnable;
	}

}
