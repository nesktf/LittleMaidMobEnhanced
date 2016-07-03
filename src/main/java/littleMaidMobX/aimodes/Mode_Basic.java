package littleMaidMobX.aimodes;

import java.util.ArrayList;
import java.util.List;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.ai.AIHurtByTarget;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.sound.EnumSound;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;

public class Mode_Basic extends ModeBlockBase {

	public static final int mmode_Wild		= 0x0000;
	public static final int mmode_Escorter	= 0x0001;
	
	private IInventory myInventory;
	private IInventory myChest;
	private List<IInventory> fusedTiles;
	private boolean isWorking;
	private double lastdistance;
	private int maidSearchCount;

	
	/**
	 * Wild, Escorter 
	 */
	public Mode_Basic(EntityLittleMaid pEntity) {
		super(pEntity);
		fusedTiles = new ArrayList<IInventory>();
		TriggerSelect.appendTriggerItem(null, "Pickup", "");
//		myTile = null;
	}

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return 9000;
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void addEntityMode(EntityAITasks pDefaultMove, EntityAITasks pDefaultTargeting) {
		// Wild
		EntityAITasks[] ltasks = new EntityAITasks[2];
		ltasks[0] = new EntityAITasks(null);
		ltasks[1] = new EntityAITasks(null);

		ltasks[0].addTask(1, owner.aiSwiming);
		ltasks[0].addTask(2, owner.aiAttack);
		ltasks[0].addTask(3, owner.aiPanic);
		ltasks[0].addTask(4, owner.aiBegMove);
		ltasks[0].addTask(4, owner.aiBeg);
		ltasks[0].addTask(5, owner.aiRestrictRain);
		ltasks[0].addTask(6, owner.aiFleeRain);
//      ltasks[0].addTask(4, new EntityAIMoveIndoors(this));
//		ltasks[0].addTask(7, owner.aiCloseDoor);
//		ltasks[0].addTask(8, owner.aiOpenDoor);
		ltasks[0].addTask(9, owner.aiCollectItem);
		ltasks[0].addTask(10, new EntityAILeapAtTarget(owner, 0.3F));
		ltasks[0].addTask(11, owner.aiWander);
		ltasks[0].addTask(12, new EntityAIWatchClosest2(owner, EntityLivingBase.class, 10F, 0.02F));
		ltasks[0].addTask(13, new EntityAIWatchClosest2(owner, EntityLittleMaid.class, 10F, 0.02F));
		ltasks[0].addTask(13, new EntityAIWatchClosest2(owner, EntityPlayer.class, 10F, 0.02F));
		ltasks[0].addTask(13, new EntityAILookIdle(owner));

		ltasks[1].addTask(1, new AIHurtByTarget(owner, false));

		owner.addMaidMode(ltasks, "Wild", mmode_Wild);

		// Escorter:0x0001
		ltasks = new EntityAITasks[2];
		ltasks[0] = pDefaultMove;
		ltasks[1] = pDefaultTargeting;
		owner.addMaidMode(ltasks, "Escorter", mmode_Escorter);
		
	}

	@Override
	public boolean changeMode(EntityPlayer pentityplayer) {
		
		owner.setMaidMode("Escorter");
		return true;
	}
	
	@Override
	public boolean setMode(int pMode) {
		switch (pMode) {
		case mmode_Wild :
			owner.setFreedom(true);
//			owner.aiWander.setEnable(true);
			return true;
		case mmode_Escorter :
			owner.aiAvoidPlayer.setEnable(false);
			for (int li = 0; li < owner.mstatSwingStatus.length; li++) {
				owner.setEquipItem(li, -1);
			}
			return true;
		}
//		owner.getNavigator().clearPathEntity()
		return false;
	}
	
	@Override
	public int getNextEquipItem(int pMode) {
		return pMode == mmode_Wild ? 0 : -1;
	}
	
	@Override
	public boolean checkItemStack(ItemStack pItemStack)
	{
		return true;
	}

	@Override
	public boolean isSearchBlock() {
		if (owner.getMaidModeInt() == mmode_Escorter && owner.isFreedom() &&
				owner.maidInventory.getFirstEmptyStack() == -1) {
			
			fDistance = 100F;
			return myInventory == null;
		}
//		clearMy();
//		fusedTiles.clear();
		return false;
	}

	@Override
	public boolean shouldBlock(int pMode) {
		return myInventory instanceof TileEntity;
	}

	@Override
	public boolean checkBlock(int pMode, int px, int py, int pz) {
		TileEntity ltile = owner.worldObj.getTileEntity(px, py, pz);
		if (!(ltile instanceof IInventory)) {
			return false;
		}
		if (((IInventory)ltile).getSizeInventory() < 18) {
			
			return false;
		}
		
		
		if (checkWorldMaid(ltile)) return false;
		
		if (fusedTiles.contains(ltile)) {
			
			return false;
		}
		
		double ldis = owner.getDistanceTilePosSq(ltile);
		if (fDistance > ldis) {
			myInventory = (IInventory)ltile;
			fDistance = ldis;
		}
		return false;
	}

	@Override
	public boolean overlooksBlock(int pMode) {
		
		List<Entity> list = owner.worldObj.getEntitiesWithinAABB(IInventory.class, owner.boundingBox.expand(8D, 2D, 8D));
		double cartl = 256D;
		for (Entity lentity : list) {
			if (!fusedTiles.contains(lentity)) {
				if (((IInventory)lentity).getSizeInventory() < 18) {
					
					continue;
				}
				double lr = lentity.getDistanceSqToEntity(owner);
				
				
				if (fDistance > lr && owner.getEntitySenses().canSee(lentity)) {
					myInventory = (IInventory)lentity;
					fDistance = lr;
				}
			}
		}
		lastdistance = -1;
		myChest = null;
		maidSearchCount = 0;
		if (myInventory instanceof TileEntity) {
			owner.setTilePos((TileEntity)myInventory);
			return myInventory != null;
		} else {
			owner.setTarget((Entity)myInventory);
			return false;
		}
//		return myInventory != null;
	}

	@Override
	public void startBlock(int pMode) {
	}

	@Override
	public void resetBlock(int pMode) {
		clearMy();
//		fusedTiles.clear();
	}

	protected void clearMy() {
		myInventory = null;
		if (myChest != null) {
			myChest.closeInventory();
			myChest = null;
		}
		owner.clearTilePos();
		owner.setTarget(null);
	}

	@Override
	public boolean executeBlock(int pMode, int px, int py, int pz) {
//		isMaidChaseWait = true;
		if (myInventory instanceof TileEntityChest) {
			
			TileEntityChest lchest = (TileEntityChest)myInventory;
			if (!lchest.isInvalid()) {
				
				if (Helper.canBlockBeSeen(owner, lchest.xCoord, lchest.yCoord, lchest.zCoord, false, true, false)) {
					if (myChest == null)
					{
						getChest();
						if (myChest != null)
						{
							myChest.openInventory();
						} else {
							
							myInventory = null;
						}
					}
					
					owner.setWorking(true);
					putChest();
					return true;
				} else {
					
					clearMy();
				}
			} else {
				
				clearMy();
			}
		} else {
			
			if (myInventory != null) {
				fusedTiles.add(myInventory);
			}
			clearMy();
		}
		return false;
	}

	@Override
	public boolean outrangeBlock(int pMode, int pX, int pY, int pZ) {
		
		boolean lf = false;
		if (!owner.isMaidWaitEx()) {
			double distance;
			if (myInventory instanceof TileEntity) {
				distance = owner.getDistanceTilePos();
				if (distance == lastdistance) {
					
					
					Debug.ai("Assert.");
					owner.updateWanderPath();
					lf = true;
				} else {
					lf = Helper.setPathToTile(owner, (TileEntity)myInventory, false);
				}
			} else {
				distance = 0;
			}
			lastdistance = distance;
			
			if (myChest != null) {
				myChest.closeInventory();
				myChest = null;
			}
		}
		return lf;
	}

	@Override
	public void farrangeBlock() {
		super.farrangeBlock();
		clearMy();
	}


	protected boolean getChest() {
		
		if (myInventory == null) {
			return false;
		}
		
		fusedTiles.add(myInventory);
		if (myInventory instanceof TileEntityChest) {
			TileEntityChest lchest = (TileEntityChest)myInventory;
			if (!lchest.adjacentChestChecked) {
				lchest.checkForAdjacentChests();
			}
			fusedTiles.add(lchest.adjacentChestXNeg);
			fusedTiles.add(lchest.adjacentChestXPos);
			fusedTiles.add(lchest.adjacentChestZNeg);
			fusedTiles.add(lchest.adjacentChestZPos);
		}
		
		TileEntity ltile = (TileEntity)myInventory;
		Block lblock = owner.worldObj.getBlock(ltile.xCoord, ltile.yCoord, ltile.zCoord);
		myChest = myInventory;
		if (lblock instanceof BlockChest) {
			myChest = ((BlockChest)lblock).func_149951_m(owner.worldObj, ltile.xCoord, ltile.yCoord, ltile.zCoord);
		}
		
		return myChest != null;
	}

	protected void putChest() {
		
		if (owner.getSwingStatusDominant().canAttack() && myChest != null) {
			
			ItemStack is;
			Debug.ai(String.format("getChest:%d", maidSearchCount));
			while ((is = owner.maidInventory.getStackInSlot(maidSearchCount)) == null && maidSearchCount < owner.maidInventory.mainInventory.length) {
				maidSearchCount++;
			}
			if (is != null && !(
					   is.getItem() == Items.sugar
					|| is.getItem() == Items.clock
					|| (is == owner.maidInventory.armorItemInSlot(3))
//					|| (is.getItem() instanceof ItemArmor && ((ItemArmor)is.getItem()).armorType == 0)
				))
			{
//				mod_littleMaidMob.Debug("getchest2.");
				boolean f = false;
				for (int j = 0; j < myChest.getSizeInventory() && is.stackSize > 0; j++)
				{
					ItemStack isc = myChest.getStackInSlot(j);
					if (isc == null)
					{
//						mod_littleMaidMob.Debug(String.format("%s -> NULL", is.getItemName()));
						myChest.setInventorySlotContents(j, is.copy());
						is.stackSize = 0;
						f = true;
						break;
					}
					else if (isc.isStackable() && isc.isItemEqual(is))
					{
//						mod_littleMaidMob.Debug(String.format("%s -> %s", is.getItemName(), isc.getItemName()));
						f = true;
						isc.stackSize += is.stackSize;
						if (isc.stackSize > isc.getMaxStackSize())
						{
							is.stackSize = isc.stackSize - isc.getMaxStackSize();
							isc.stackSize = isc.getMaxStackSize();
						} else {
							is.stackSize = 0; 
							break;
						}
					}
				}
				if (is.stackSize <= 0) {
					owner.maidInventory.setInventorySlotContents(maidSearchCount, null);
				}
				if (f) {
					owner.playSound("random.pop");
					owner.setSwing(2, EnumSound.Null);
				}
			}
//			mod_littleMaidMob.Debug(String.format("getchest3:%d", maidSearchCount));
			if (++maidSearchCount >= owner.maidInventory.mainInventory.length) {
				
//				serchedChest.add(myChest);
				clearMy();
				lastdistance = 0D;
				Debug.ai("endChest.");
				
				if (owner.maidInventory.getFirstEmptyStack() > -1) {
					Debug.ai("Search clear.");
					fusedTiles.clear();
				}
			}
		}
	}

	@Override
	public boolean attackEntityAsMob(int pMode, Entity pEntity) {
		if (pEntity == myInventory) {
			
			Entity lentity = (Entity)myInventory;
			if (!lentity.isDead) {
				if (owner.getDistanceSqToEntity(lentity) < 5D)	{
					owner.getNavigator().clearPathEntity();
					if (myChest == null) {
						myChest = (IInventory)lentity;
						fusedTiles.add(myChest);
						myChest.openInventory();
					}
					if (myChest != null) {
						owner.getLookHelper().setLookPositionWithEntity(lentity, 30F, 40F);
					}
					
					putChest();
				} else {
					
					if (!owner.isMaidWaitEx()) {
						double distance = owner.getDistanceSqToEntity(lentity);
						if (distance == lastdistance) {
							
							Debug.ai("Assert.");
							owner.updateWanderPath();
						} else {
							owner.getNavigator().tryMoveToXYZ(lentity.posX, lentity.posY, lentity.posZ, 1.0F);
						}
						lastdistance = distance;
//						mod_littleMaidMob.Debug(String.format("Rerute:%b", hasPath()));
						if (myChest != null) {
							myChest.closeInventory();
							myChest = null;
						}
					}
				}
			} else {
				
				clearMy();
			}
			return true;
		} else {
			
			clearMy();
		}
		return true;
	}

	@Override
	public boolean isChangeTartget(Entity pTarget) {
		if (pTarget instanceof IInventory) {
			return false;
		}
		return super.isChangeTartget(pTarget);
	}

	@Override
	public boolean preInteract(EntityPlayer pentityplayer, ItemStack pitemstack) {
		
		if (pentityplayer.isSneaking()) {
			return false;
		}
		if (owner.isContract()) {
			
			if (owner.isEntityAlive() && owner.isMaidContractOwner(pentityplayer)) {
				if (pitemstack != null) {
					
					owner.setPathToEntity(null);
					if (owner.isRemainsContract()) {
						if (pitemstack.getItem() instanceof ItemAppleGold) {
							
							if(!owner.worldObj.isRemote) {
								((ItemAppleGold)pitemstack.getItem()).onEaten(pitemstack, owner.worldObj, owner.maidAvatar);
							}

							return true;
						}
						else if (pitemstack.getItem() instanceof ItemBucketMilk && !owner.getActivePotionEffects().isEmpty()) {
							
							if(!owner.worldObj.isRemote) {
								owner.clearActivePotions();
							}
							Helper.decPlayerInventory(pentityplayer, -1, 1);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
