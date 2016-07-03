package littleMaidMobX.aimodes;

import littleMaidMobX.ai.AIHurtByTarget;
import littleMaidMobX.ai.AINearestAttackableTarget;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.util.helper.Helper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;


public class Mode_Fencer extends ModeBase {

	public static final int mmode_Fencer		= 0x0080;
	public static final int mmode_Bloodsucker	= 0x00c0;


	public Mode_Fencer(EntityLittleMaid pEntity) {
		super(pEntity);
		TriggerSelect.appendTriggerItem(null, "Sword", "");
		TriggerSelect.appendTriggerItem(null, "Axe", "");
	}

	@Override
	public int priority()
	{
		return 3000;
	}

	@Override
	public void init()
	{
		
	}

	@Override
	public void addEntityMode(EntityAITasks pDefaultMove, EntityAITasks pDefaultTargeting) {
		// Fencer:0x0080
		EntityAITasks[] ltasks = new EntityAITasks[2];
		ltasks[0] = pDefaultMove;
		ltasks[1] = new EntityAITasks(owner.aiProfiler);
		
//		ltasks[1].addTask(1, new EntityAIOwnerHurtByTarget(owner));
//		ltasks[1].addTask(2, new EntityAIOwnerHurtTarget(owner));
		ltasks[1].addTask(3, new AIHurtByTarget(owner, true));
		ltasks[1].addTask(4, new AINearestAttackableTarget(owner, EntityLivingBase.class, 0, true));
		
		owner.addMaidMode(ltasks, "Fencer", mmode_Fencer);
		
		
		// Bloodsucker:0x00c0
		EntityAITasks[] ltasks2 = new EntityAITasks[2];
		ltasks2[0] = pDefaultMove;
		ltasks2[1] = new EntityAITasks(owner.aiProfiler);
		
		ltasks2[1].addTask(1, new AIHurtByTarget(owner, true));
		ltasks2[1].addTask(2, new AINearestAttackableTarget(owner, EntityLivingBase.class, 0, true));
		
		owner.addMaidMode(ltasks2, "Bloodsucker", mmode_Bloodsucker);
	}

	@Override
	public boolean changeMode(EntityPlayer pentityplayer) {
		ItemStack litemstack = owner.maidInventory.getStackInSlot(0);
		if (litemstack != null) {
			if (litemstack.getItem() instanceof ItemSword || TriggerSelect.checkItem(owner.getMaidMaster(), "Sword", litemstack)) {
				owner.setMaidMode("Fencer");
				return true;
			} else  if (litemstack.getItem() instanceof ItemAxe || TriggerSelect.checkItem(owner.getMaidMaster(), "Axe", litemstack)) {
				owner.setMaidMode("Bloodsucker");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setMode(int pMode) {
		switch (pMode) {
		case mmode_Fencer :
//			pentitylittlemaid.maidInventory.currentItem = getNextEquipItem(pentitylittlemaid, pMode);
			owner.setBloodsuck(false);
			owner.aiAttack.isGuard = true;
			return true;
		case mmode_Bloodsucker :
//			pentitylittlemaid.maidInventory.currentItem = getNextEquipItem(pentitylittlemaid, pMode);
			owner.setBloodsuck(true);
			return true;
		}
		
		return false;
	}

	@Override
	public int getNextEquipItem(int pMode) {
		int li;
		int ll = -1;
		double ld = 0;
		double lld;
		ItemStack litemstack;
		
		
		switch (pMode) {
		case mmode_Fencer : 
			for (li = 0; li < owner.maidInventory.maxInventorySize; li++) {
				litemstack = owner.maidInventory.getStackInSlot(li);
				if (litemstack == null) continue;
				
				
				if (litemstack.getItem() instanceof ItemSword || TriggerSelect.checkItem(owner.getMaidMaster(), "Sword", litemstack)) {
					return li;
				}
				
				
				lld = 1;
				try {
					lld = Helper.getAttackVSEntity(litemstack);
				}
				catch (Exception e) {
				}
				if (lld > ld) {
					ll = li;
					ld = lld;
				}
			}
			break;
		case mmode_Bloodsucker :
			for (li = 0; li < owner.maidInventory.maxInventorySize; li++) {
				litemstack = owner.maidInventory.getStackInSlot(li);
				if (litemstack == null) continue;
				
				if (litemstack.getItem() instanceof ItemAxe || TriggerSelect.checkItem(owner.getMaidMaster(), "Axe", litemstack))
				{
					return li;
				}
				
				
				lld = 1;
				try {
					lld = Helper.getAttackVSEntity(litemstack);
				}
				catch (Exception e) {
				}
				if (lld > ld) {
					ll = li;
					ld = lld;
				}
			}
			break;
		}
		
		return ll;
	}

	@Override
	public boolean checkItemStack(ItemStack pItemStack)
	{
		String ls = owner.getMaidMaster();
		return (pItemStack.getItem() == Items.sugar
				|| pItemStack.getItem() instanceof ItemSword
				|| TriggerSelect.checkItem(ls, "Sword", pItemStack)
				|| pItemStack.getItem() instanceof ItemAxe
				|| TriggerSelect.checkItem(ls, "Axe", pItemStack)
				|| TriggerSelect.checkItem(ls, "Pickup", pItemStack));
	}

}
