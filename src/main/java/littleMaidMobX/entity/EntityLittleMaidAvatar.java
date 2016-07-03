package littleMaidMobX.entity;

import java.util.Collection;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.sound.EnumSound;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.Statics;
import littleMaidMobX.wrapper.MinecraftWrapper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;



public class EntityLittleMaidAvatar extends EntityPlayer {

	public EntityLittleMaid avatar;
	
	public boolean isItemTrigger;
	
	public boolean isItemReload;
	
	private boolean isItemPreReload;
	private double appendX;
	private double appendY;
	private double appendZ;


	public EntityLittleMaidAvatar(World par1World)
	{
		super(par1World, MinecraftWrapper.newGameProfile("1", "LMM_EntityLittleMaidAvatar"));
	}
	
	public EntityLittleMaidAvatar(World par1World, EntityLittleMaid par2EntityLittleMaid) {
		super(par1World, MinecraftWrapper.newGameProfile("1", "LMM_EntityLittleMaidAvatar"));
		
		
		avatar = par2EntityLittleMaid;
		dataWatcher = avatar.getDataWatcher();
		
		this.dataWatcher.addObject(Statics.dataWatch_AbsorptionAmount, Float.valueOf(0.0F));
		
		inventory = avatar.maidInventory;
		inventory.player = this;
	}

	////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void entityInit()
	{
		super.entityInit();
	}
	public void readEntityFromNBT(NBTTagCompound var1)
	{
		super.readEntityFromNBT(var1);
	}
	public void writeEntityToNBT(NBTTagCompound var1)
	{
		super.writeEntityToNBT(var1);
	}
	public ItemStack getHeldItem()
	{
		return super.getHeldItem();
	}
	public void setCurrentItemOrArmor(int var1, ItemStack var2)
	{
		super.setCurrentItemOrArmor(var1, var2);
	}
	public String getCommandSenderName(){ return super.getCommandSenderName(); }
	public World getEntityWorld(){ return super.getEntityWorld(); }
	////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	protected void applyEntityAttributes() {
		
		
		super.applyEntityAttributes();
//		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.13000000417232513D);
	}

	@Override
	public float getEyeHeight() {
		return avatar.getEyeHeight();
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(int var1, String var2) {
		return false;
	}

	@Override
	public void addStat(StatBase par1StatBase, int par2) {}

	@Override
	public void addScore(int par1) {}

	@Override
	public void onUpdate() {
//		posX = avatar.posX;
		EntityPlayer lep = avatar.getMaidMasterEntity();
		setEntityId(avatar.getEntityId());
		
		if (lep != null) {
			capabilities.isCreativeMode = lep.capabilities.isCreativeMode;
		}
		
		if (xpCooldown > 0) {
			xpCooldown--;
		}
		avatar.setExperienceValue(experienceTotal);
	}

	@Override
	public void onItemPickup(Entity entity, int i) {
		
		if (worldObj.isRemote) {
			// Client
			LittleMaidMobX.proxy.onItemPickup(this, entity, i);
		} else {
			super.onItemPickup(entity, i);
		}
	}

	@Override
	public void onCriticalHit(Entity par1Entity) {
		if (worldObj.isRemote) {
			// Client
			LittleMaidMobX.proxy.onCriticalHit(this, par1Entity);
		} else {
//TODO GGG			((WorldServer)worldObj).getEntityTracker().func_151248_b(avatar, new S0BPacketAnimation(par1Entity, 6));
		}
	}

	@Override
	public void onEnchantmentCritical(Entity par1Entity) {
		if (worldObj.isRemote) {
			LittleMaidMobX.proxy.onEnchantmentCritical(this, par1Entity);
		} else {
//TODO GGG			((WorldServer)worldObj).getEntityTracker().func_151248_b(avatar, new S0BPacketAnimation(par1Entity, 7));
		}
	}

	// maybe do not attack "as player" at all. not sure where the advantage is, 
	// enchantments and armor works for EntityLivingBase as well
	// of course it would not drop items then
	@Override
	public void attackTargetEntityWithCurrentItem(Entity par1Entity) {
		// TODO:
		float ll = 0;
		if (par1Entity instanceof EntityLivingBase) {
			ll = ((EntityLivingBase)par1Entity).getHealth();
		}
//		super.attackTargetEntityWithCurrentItem(par1Entity);
		this.localAttackTargetEntityWithCurrentItem(par1Entity);
		if (par1Entity instanceof EntityLivingBase) {
			((EntityLivingBase)par1Entity).setRevengeTarget(avatar);
		}
		if (par1Entity instanceof EntityCreature) {
			((EntityCreature)par1Entity).setTarget(avatar);
		}
		if (ll > 0) {
			Debug.entity(String.format("ID:%d Given Damege:%f", avatar.getEntityId(), ll - ((EntityLivingBase)par1Entity).getHealth()));
		}
	}

	private void localAttackTargetEntityWithCurrentItem(Entity p_71059_1_) {

		//do not fire "player attacks entity" event
//        if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent(this, p_71059_1_))) 
//        {
//            return;
//        }
        ItemStack stack = getCurrentEquippedItem();
     // maybe remove this too, it passes our player entity along
        if (stack != null && stack.getItem().onLeftClickEntity(stack, this, p_71059_1_)) 
        {
            return;
        }
        if (p_71059_1_.canAttackWithItem())
        {
            if (!p_71059_1_.hitByEntity(this.avatar))
            {
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i = 0;
                float f1 = 0.0F;

                if (p_71059_1_ instanceof EntityLivingBase)
                {
                    f1 = EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)p_71059_1_);
                    i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)p_71059_1_);
                }

                if (this.isSprinting())
                {
                    ++i;
                }

                if (f > 0.0F || f1 > 0.0F)
                {
                    boolean flag = this.fallDistance > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && p_71059_1_ instanceof EntityLivingBase;

                    if (flag && f > 0.0F)
                    {
                        f *= 1.5F;
                    }

                    f += f1;
                    boolean flag1 = false;
                    int j = EnchantmentHelper.getFireAspectModifier(this);

                    if (p_71059_1_ instanceof EntityLivingBase && j > 0 && !p_71059_1_.isBurning())
                    {
                        flag1 = true;
                        p_71059_1_.setFire(1);
                    }

//                    boolean flag2 = p_71059_1_.attackEntityFrom(DamageSource.causePlayerDamage(this), f);
                    boolean flag2 = p_71059_1_.attackEntityFrom(DamageSource.causeMobDamage(this.avatar), f);

                    if (flag2)
                    {
                        if (i > 0)
                        {
                            p_71059_1_.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                            this.motionX *= 0.6D;
                            this.motionZ *= 0.6D;
                            this.setSprinting(false);
                        }

                        if (flag)
                        {
                            this.onCriticalHit(p_71059_1_);
                        }

                        if (f1 > 0.0F)
                        {
                            this.onEnchantmentCritical(p_71059_1_);
                        }

                        if (f >= 18.0F)
                        {
                            this.triggerAchievement(AchievementList.overkill);
                        }

                        this.setLastAttacker(p_71059_1_);

                        if (p_71059_1_ instanceof EntityLivingBase)
                        {
                            EnchantmentHelper.func_151384_a((EntityLivingBase)p_71059_1_, this);
                        }

                        EnchantmentHelper.func_151385_b(this, p_71059_1_);
                        ItemStack itemstack = this.getCurrentEquippedItem();
                        Object object = p_71059_1_;

                        if (p_71059_1_ instanceof EntityDragonPart)
                        {
                            IEntityMultiPart ientitymultipart = ((EntityDragonPart)p_71059_1_).entityDragonObj;

                            if (ientitymultipart != null && ientitymultipart instanceof EntityLivingBase)
                            {
                                object = (EntityLivingBase)ientitymultipart;
                            }
                        }

                        if (itemstack != null && object instanceof EntityLivingBase)
                        {
                            itemstack.hitEntity((EntityLivingBase)object, this);

                            if (itemstack.stackSize <= 0)
                            {
                                this.destroyCurrentEquippedItem();
                            }
                        }

                        if (p_71059_1_ instanceof EntityLivingBase)
                        {
                            this.addStat(StatList.damageDealtStat, Math.round(f * 10.0F));

                            if (j > 0)
                            {
                                p_71059_1_.setFire(j * 4);
                            }
                        }

                        this.addExhaustion(0.3F);
                    }
                    else if (flag1)
                    {
                        p_71059_1_.extinguish();
                    }
                }
            }
        }
	}

	@Override
	public ItemStack getCurrentEquippedItem() {
		return avatar.getCurrentEquippedItem();
	}

	@Override
	public ItemStack getCurrentArmor(int par1) {
		//TODO GGG		return avatar.func_130225_q(par1);
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		return avatar.getEquipmentInSlot(par1);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return avatar.getLastActiveItems();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		
		
//		super.destroyCurrentEquippedItem();
		inventory.setInventorySlotContents(inventory.currentItem, (ItemStack)null);
		avatar.getNextEquipItem();
	}

	@Override
	public void onKillEntity(EntityLivingBase entityliving) {
		avatar.onKillEntity(entityliving);
	}

	protected Entity getEntityServer() {
		return worldObj.isRemote ? null : this;
	}

	

	public int getItemInUseDuration(int pIndex) {
		return avatar.getSwingStatus(pIndex).getItemInUseDuration();
	}
//	@Deprecated
	@Override
	public int getItemInUseDuration() {
		return getItemInUseDuration(avatar.maidDominantArm);
	}

	public ItemStack getItemInUse(int pIndex) {
		return avatar.getSwingStatus(pIndex).getItemInUse();
	}
//	@Deprecated
	@Override
	public ItemStack getItemInUse() {
		return getItemInUse(avatar.maidDominantArm);
	}

	public int getItemInUseCount(int pIndex) {
		return avatar.getSwingStatus(pIndex).getItemInUseCount();
	}
//	@Deprecated
	@Override
	public int getItemInUseCount() {
		return getItemInUseCount(avatar.maidDominantArm);
	}

	public boolean isUsingItem(int pIndex) {
		return avatar.getSwingStatus(pIndex).isUsingItem();
	}
//	@Deprecated
	@Override
	public boolean isUsingItem() {
		return isUsingItem(avatar.maidDominantArm);
	}
	public boolean isUsingItemLittleMaid() {
		return super.isUsingItem() | isItemTrigger;
	}

	public void clearItemInUse(int pIndex) {
		isItemTrigger = false;
		isItemReload = isItemPreReload = false;
		avatar.getSwingStatus(pIndex).clearItemInUse(getEntityServer());
	}
//	@Deprecated
	@Override
	public void clearItemInUse() {
//		super.clearItemInUse();
		isItemTrigger = false;
		isItemReload = isItemPreReload = false;
		clearItemInUse(avatar.maidDominantArm);
	}

	public void stopUsingItem(int pIndex) {
		isItemTrigger = false;
		isItemReload = isItemPreReload = false;
		avatar.getSwingStatus(pIndex).stopUsingItem(getEntityServer());
	}
//	@Deprecated
	@Override
	public void stopUsingItem() {
//		super.stopUsingItem();
		isItemTrigger = false;
		isItemReload = isItemPreReload = false;
		stopUsingItem(avatar.maidDominantArm);
	}

	public void setItemInUse(int pIndex, ItemStack itemstack, int i) {
		isItemTrigger = true;
		isItemReload = isItemPreReload;
		avatar.getSwingStatus(pIndex).setItemInUse(itemstack, i, getEntityServer());
	}
//	@Deprecated
	@Override
	public void setItemInUse(ItemStack itemstack, int i) {
//		super.setItemInUse(itemstack, i);
		isItemTrigger = true;
		isItemReload = isItemPreReload;
		setItemInUse(avatar.maidDominantArm, itemstack, i);
	}

	@Override
	public void setEating(boolean par1) {
		avatar.setEating(par1);
	}

	@Override
	public boolean isEating() {
		return avatar.isEating();
	}

	@Override
	public void setAir(int par1) {
		avatar.setAir(par1);
	}

	@Override
	public int getAir() {
		return avatar.getAir();
	}

	@Override
	public void setFire(int par1) {
		avatar.setFire(par1);
	}

	@Override
	public boolean isBurning() {
		return avatar.isBurning();
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		avatar.setFlag(par1, par2);
	}

	@Override
	public boolean isBlocking() {
		return avatar.isBlocking();
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		avatar.playSound(par1Str, par2, par3);
	}
	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return null;
	}

//	@Override
//	public void sendChatToPlayer(ChatMessageComponent var1) {

//	}

	@Override
	public void addChatMessage(IChatComponent var1) {
		
	}

	

	@Override
	protected void setHideCape(int par1, boolean par2) {}

	@Override
	protected boolean getHideCape(int par1) {
		return false;
	}

	@Override
	public void setScore(int par1) {}

	@Override
	public int getScore() {
		return 0;
	}

	public void setAbsorptionAmount(float par1) {
		avatar.setAbsorptionAmount(par1);
	}

	public float getAbsorptionAmount() {
		return avatar.getAbsorptionAmount();
	}

	
	public BaseAttributeMap getAttributeMap() {
//		return super.func_110140_aT();
		return avatar == null ? super.getAttributeMap() : avatar.getAttributeMap();
	}

	@Override
	public void addPotionEffect(PotionEffect par1PotionEffect) {
		avatar.addPotionEffect(par1PotionEffect);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion par1Potion) {
		return avatar.getActivePotionEffect(par1Potion);
	}

	@Override
	public Collection getActivePotionEffects() {
		return avatar.getActivePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		avatar.clearActivePotions();
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect par1PotionEffect, boolean par2) {
		avatar.onChangedPotionEffect(par1PotionEffect, par2);
	}

	public void getValue() {
		
		setPosition(avatar.posX, avatar.posY, avatar.posZ);
		prevPosX = avatar.prevPosX;
		prevPosY = avatar.prevPosY;
		prevPosZ = avatar.prevPosZ;
		rotationPitch = avatar.rotationPitch;
		rotationYaw = avatar.rotationYaw;
		prevRotationPitch = avatar.prevRotationPitch;
		prevRotationYaw = avatar.prevRotationYaw;
		yOffset = avatar.yOffset;
		renderYawOffset = avatar.renderYawOffset;
		prevRenderYawOffset = avatar.prevRenderYawOffset;
		rotationYawHead = avatar.rotationYawHead;
		attackTime = avatar.attackTime;
	}

	public void getValueVector(double atx, double aty, double atz, double atl) {
		
		double l = MathHelper.sqrt_double(atl);
		appendX = atx / l;
		appendY = aty / l;
		appendZ = atz / l;
		posX = avatar.posX + appendX;
		posY = avatar.posY + appendY;
		posZ = avatar.posZ + appendZ;
		prevPosX = avatar.prevPosX + appendX;
		prevPosY = avatar.prevPosY + appendY;
		prevPosZ = avatar.prevPosZ + appendZ;
		rotationPitch		= avatar.rotationPitch;
		prevRotationPitch	= avatar.prevRotationPitch;
		rotationYaw			= avatar.rotationYaw;
		prevRotationYaw		= avatar.prevRotationYaw;
		renderYawOffset		= avatar.renderYawOffset;
		prevRenderYawOffset	= avatar.prevRenderYawOffset;
		rotationYawHead		= avatar.rotationYawHead;
		prevRotationYawHead	= avatar.prevRotationYawHead;
		yOffset = avatar.yOffset;
		motionX = avatar.motionX;
		motionY = avatar.motionY;
		motionZ = avatar.motionZ;
		isSwingInProgress = avatar.getSwinging();
	}

	
	public void getValueVectorFire(double atx, double aty, double atz, double atl) {
		
		double l = MathHelper.sqrt_double(atl);
		appendX = atx / l;
		appendY = aty / l;
		appendZ = atz / l;
		posX = avatar.posX + appendX;
		posY = avatar.posY + appendY;
		posZ = avatar.posZ + appendZ;
		prevPosX = avatar.prevPosX + appendX;
		prevPosY = avatar.prevPosY + appendY;
		prevPosZ = avatar.prevPosZ + appendZ;
		rotationPitch		= updateDirection(avatar.rotationPitch);
		prevRotationPitch	= updateDirection(avatar.prevRotationPitch);
		rotationYaw			= updateDirection(avatar.rotationYawHead);
		prevRotationYaw		= updateDirection(avatar.prevRotationYawHead);
		renderYawOffset		= updateDirection(avatar.renderYawOffset);
		prevRenderYawOffset	= updateDirection(avatar.prevRenderYawOffset);
		rotationYawHead		= updateDirection(avatar.rotationYawHead);
		prevRotationYawHead	= updateDirection(avatar.prevRotationYawHead);
		yOffset = avatar.yOffset;
		motionX = avatar.motionX;
		motionY = avatar.motionY;
		motionZ = avatar.motionZ;
		isSwingInProgress = avatar.getSwinging();
	}

	protected float updateDirection(float pValue) {
		pValue %= 360F;
		if (pValue < 0) pValue += 360F;
		return pValue;
	}


	public void setValue() {
		
		avatar.setPosition(posX, posY, posZ);
		avatar.prevPosX = prevPosX;
		avatar.prevPosY = prevPosY;
		avatar.prevPosZ = prevPosZ;
		avatar.rotationPitch = rotationPitch;
		avatar.rotationYaw = rotationYaw;
		avatar.prevRotationPitch = prevRotationPitch;
		avatar.prevRotationYaw = prevRotationYaw;
		avatar.yOffset = yOffset;
		avatar.renderYawOffset = renderYawOffset;
		avatar.prevRenderYawOffset = prevRenderYawOffset;
		avatar.getSwingStatusDominant().attackTime = avatar.attackTime = attackTime;
	}

	public void setValueRotation() {
		
		avatar.rotationPitch = rotationPitch;
		avatar.rotationYaw = rotationYaw;
		avatar.prevRotationPitch = prevRotationPitch;
		avatar.prevRotationYaw = prevRotationYaw;
		avatar.renderYawOffset = renderYawOffset;
		avatar.prevRenderYawOffset = prevRenderYawOffset;
		avatar.motionX = motionX;
		avatar.motionY = motionY;
		avatar.motionZ = motionZ;
		if (isSwingInProgress) avatar.setSwinging(EnumSound.Null);
		
	}

	public void setValueVector() {
		
		avatar.posX = posX - appendX;
		avatar.posY = posY - appendY;
		avatar.posZ = posZ - appendZ;
		avatar.prevPosX = prevPosX - appendX;
		avatar.prevPosY = prevPosY - appendY;
		avatar.prevPosZ = prevPosZ - appendZ;
		avatar.rotationPitch	 = rotationPitch;
		avatar.prevRotationPitch = prevRotationPitch;
//		avatar.rotationYaw			= rotationYaw;
//		avatar.prevRotationYaw		= prevRotationYaw;
//		avatar.renderYawOffset		= renderYawOffset;
//		avatar.prevRenderYawOffset	= prevRenderYawOffset;
		avatar.motionX = motionX;
		avatar.motionY = motionY;
		avatar.motionZ = motionZ;
		if (isSwingInProgress) avatar.setSwinging(EnumSound.Null);
	}

	/*protected void damageArmor(float par1)
	{
		super.damageArmor(par1);
	}*/
	
	public float applyArmorCalculations(DamageSource par1DamageSource, float par2)
	{
		return super.applyArmorCalculations(par1DamageSource, par2);
	}

	protected float applyPotionDamageCalculations(DamageSource par1DamageSource, float par2)
	{
		return super.applyPotionDamageCalculations(par1DamageSource, par2);
	}

	/*public void damageEntity(DamageSource par1DamageSource, float par2)
	{
		super.damageEntity(par1DamageSource, par2);
	}*/
	
}
