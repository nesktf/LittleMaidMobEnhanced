package littleMaidMobX.util.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import cpw.mods.fml.common.ObfuscationReflectionHelper;

public class Helper {

	public static final boolean isClient;
	public static final Package fpackage = null;
//	public static final String packegeBase;
	public static final boolean isForge = true;//ModLoader.isModLoaded("Forge");
	public static final Minecraft mc;
//	public static Method methGetSmeltingResultForge = null;
	public static Class entityRegistry = null;
	public static Method registerModEntity = null;
	protected static final Map<Class, Class>replaceEntitys = new HashMap<Class, Class>();
	protected static Map<String, Integer> entityIDList = new HashMap<String, Integer>();
	
	static {
		
//		fpackage = ModLoader.class.getPackage();
//		packegeBase = "";//fpackage == null ? "" : fpackage.getName().concat(".");

		Minecraft lm = null;
		try {
			lm =  Minecraft.getMinecraft();// ModLoader.getMinecraftInstance();
		} catch (Exception e) {
//			e.printStackTrace();
		} catch (Error e) {
//			e.printStackTrace();
		}
		mc = lm;
		isClient = mc != null;
		/*
		if (isForge) {
			try {
				methGetSmeltingResultForge = FurnaceRecipes.class.getMethod("getExperience", ItemStack.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				entityRegistry = getNameOfClass("cpw.mods.fml.common.registry.EntityRegistry");
				registerModEntity = entityRegistry.getMethod("registerModEntity",
						Class.class, String.class, int.class, Object.class, int.class, int.class, boolean.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
	}

	
	public static boolean isLocalPlay() {
		return isClient && mc.isIntegratedServerRunning();
	}

	
	public static void updateCheckinghSlot(Entity pEntity, ItemStack pItemstack) {
		if (pEntity instanceof EntityPlayerMP) {
			
			EntityPlayerMP lep = (EntityPlayerMP)pEntity;
			Container lctr = lep.openContainer;
			for (int li = 0; li < lctr.inventorySlots.size(); li++) {
				ItemStack lis = ((Slot)lctr.getSlot(li)).getStack(); 
				if (lis == pItemstack) {
					lctr.inventoryItemStacks.set(li, pItemstack.copy());
					break;
				}
			}
		}
	}
	
	public static String getPlayerName(EntityPlayer player)
	{
		return player.getGameProfile().getName();
	}
	
	
	

	
	public static Class getNameOfClass(String pName) {
		if (fpackage != null) {
			pName = fpackage.getName() + "." + pName;
		}
		Class lclass = null;
		try {
			lclass = Class.forName(pName);
		} catch (Exception e) {
			Debug.addon("Class:%s is not found.", pName);
		}
		
		return lclass;
	}

	
	public static void setValue(byte[] pData, int pIndex, int pVal, int pSize) {
		for (int li = 0; li < pSize; li++) {
			pData[pIndex++] = (byte)(pVal & 0xff);
			pVal = pVal >>> 8;
		}
	}
	
	public static void setInt(byte[] pData, int pIndex, int pVal) {
		pData[pIndex + 3]	= (byte)(pVal & 0xff);
		pData[pIndex + 2]	= (byte)((pVal >>> 8) & 0xff);
		pData[pIndex + 1]	= (byte)((pVal >>> 16) & 0xff);
		pData[pIndex + 0]	= (byte)((pVal >>> 24) & 0xff);
	}
	
	public static int getInt(byte[] pData, int pIndex) {
		return (pData[pIndex + 3] & 0xff) | ((pData[pIndex + 2] & 0xff) << 8) | ((pData[pIndex + 1] & 0xff) << 16) | ((pData[pIndex + 0] & 0xff) << 24);
	}

	public static void setFloat(byte[] pData, int pIndex, float pVal) {
		setInt(pData, pIndex, Float.floatToIntBits(pVal));
	}

	public static float getFloat(byte[] pData, int pIndex) {
		return Float.intBitsToFloat(getInt(pData, pIndex));
	}

	public static void setShort(byte[] pData, int pIndex, int pVal) {
		pData[pIndex++]	= (byte)(pVal & 0xff);
		pData[pIndex]	= (byte)((pVal >>> 8) & 0xff);
	}

	public static short getShort(byte[] pData, int pIndex) {
		return (short)((pData[pIndex] & 0xff) | ((pData[pIndex + 1] & 0xff) << 8));
	}

	public static String getStr(byte[] pData, int pIndex, int pLen) {
		String ls = new String(pData, pIndex, pLen);
		return ls;
	}
	public static String getStr(byte[] pData, int pIndex) {
		return getStr(pData, pIndex, pData.length - pIndex);
	}

	public static void setStr(byte[] pData, int pIndex, String pVal) {
		byte[] lb = pVal.getBytes();
		for (int li = pIndex; li < pData.length; li++) {
			pData[li] = lb[li - pIndex];
		}
	}

	
	public static boolean canBlockBeSeen(Entity pEntity, int x, int y, int z, boolean toTop, boolean do1, boolean do2) {
		
		Vec3 vec3d = Vec3.createVectorHelper(pEntity.posX, pEntity.posY + pEntity.getEyeHeight(), pEntity.posZ);
		Vec3 vec3d1 = Vec3.createVectorHelper((double)x + 0.5D, (double)y + (toTop ? 0.9D : 0.5D), (double)z + 0.5D);
		
		MovingObjectPosition movingobjectposition = pEntity.worldObj.func_147447_a(vec3d, vec3d1, do1, do2, false);
		if (movingobjectposition == null) {
			return false;
		}
		if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
			if (movingobjectposition.blockX == MathHelper.floor_double(vec3d1.xCoord) && 
				movingobjectposition.blockY == MathHelper.floor_double(vec3d1.yCoord) &&
				movingobjectposition.blockZ == MathHelper.floor_double(vec3d1.zCoord)) {
				return true;
			}
		}
		return false;
	}

	public static boolean setPathToTile(EntityLiving pEntity, TileEntity pTarget, boolean flag) {
		
		PathNavigate lpn = pEntity.getNavigator();
		float lspeed = 1.0F;
		
		int i = (pTarget.yCoord == MathHelper.floor_double(pEntity.posY) && flag) ? 2 : 1;
		switch (pEntity.worldObj.getBlockMetadata(pTarget.xCoord, pTarget.yCoord, pTarget.zCoord)) {
		case 3:
			return lpn.tryMoveToXYZ(pTarget.xCoord, pTarget.yCoord, pTarget.zCoord + i, lspeed);
		case 2:
			return lpn.tryMoveToXYZ(pTarget.xCoord, pTarget.yCoord, pTarget.zCoord - i, lspeed);
		case 5:
			return lpn.tryMoveToXYZ(pTarget.xCoord + 1, pTarget.yCoord, pTarget.zCoord, lspeed);
		case 4:
			return lpn.tryMoveToXYZ(pTarget.xCoord - i, pTarget.yCoord, pTarget.zCoord, lspeed);
		default:
			return lpn.tryMoveToXYZ(pTarget.xCoord, pTarget.yCoord, pTarget.zCoord, lspeed);
		}
	}

	
	

	
	

	private static int getModEntityID(String uniqueModeName) {
		int li = 0;
		if (entityIDList.containsKey(uniqueModeName)) {
			li = entityIDList.get(uniqueModeName);
		}
		entityIDList.put(uniqueModeName, li + 1);
		return li;
	}

	
	public static Entity getEntity(byte[] pData, int pIndex, World pWorld) {
		return pWorld.getEntityByID(Helper.getInt(pData, pIndex));
	}

	
	public static Entity getAvatarEntity(Entity pEntity){
		
		if (pEntity == null) return null;
		try {
			
			Field field = pEntity.getClass().getField("avatar");
			pEntity = (EntityLivingBase)field.get(pEntity);
		} catch (NoSuchFieldException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
		
		return pEntity;
	}

	
	public static Entity getAvatarPlayer(Entity entity) {
		
		try {
			Field field = entity.getClass().getField("maidAvatar");
			entity = (Entity)field.get(entity);
		}
		catch (NoSuchFieldException e) {
		}
		catch (Exception e) {
		}
		return entity;
	}

	
	public static ItemStack decPlayerInventory(EntityPlayer par1EntityPlayer, int par2Index, int par3DecCount) {
		if (par1EntityPlayer == null) {
			return null;
		}
		
		if (par2Index == -1) {
			par2Index = par1EntityPlayer.inventory.currentItem;
		}
		ItemStack itemstack1 = par1EntityPlayer.inventory.getStackInSlot(par2Index);
		if (itemstack1 == null) {
			return null;
		}
		
		if (!par1EntityPlayer.capabilities.isCreativeMode) {
			
			itemstack1.stackSize -= par3DecCount;
		}
		
		if (itemstack1.getItem() instanceof ItemPotion) {
			if(itemstack1.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Items.glass_bottle, par3DecCount));
				return null;
			} else {
				par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle, par3DecCount));
			}
		} else {
			if (itemstack1.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par2Index, null);
				return null;
			}
		}
		
		return itemstack1;
	}

	protected static float convRevision(String pRev) {
		Pattern lp = Pattern.compile("(\\d+)(\\w*)");
		Matcher lm = lp.matcher(pRev);
		float lf = 0;
		if (lm.find()) {
			lf = Integer.valueOf(lm.group(1));
			if (!lm.group(2).isEmpty()) {
				lf += (float)(lm.group(2).charAt(0) - 96) * 0.01;
			}
		}
		return lf;
	}
	protected static float convRevision() {
		
		return 0;// convRevision(MMMLib.Revision);
	}

	
	public static void checkRevision(String pRev) {
		if (convRevision() < convRevision(pRev)) {
			
		
		//	ModLoader.getLogger().warning("you must check MMMLib revision.");
		//	throw new RuntimeException("The revision of MMMLib is old.");
		}
	}

	
	public static void replaceEntityList(Class pSrcClass, Class pDestClass) {
		
		
		try {
			// stringToClassMapping
			Map lmap;
			int lint = 0;
			String ls = "";
			lmap = EntityList.stringToClassMapping;
			for (Entry<String, Class> le : ((Map<String, Class>)lmap).entrySet()) {
				if (le.getValue() == pSrcClass) {
					le.setValue(pDestClass);
				}
			}
			// classToStringMapping
			lmap = EntityList.classToStringMapping;
			if (lmap.containsKey(pSrcClass)) {
				ls = (String)lmap.get(pSrcClass);
//				lmap.remove(pSrcClass);
				lmap.put(pDestClass, ls);
			}
			// IDtoClassMapping
			lmap = EntityList.IDtoClassMapping;
			for (Entry<Integer, Class> le : ((Map<Integer, Class>)lmap).entrySet()) {
				if (le.getValue() == pSrcClass) {
					le.setValue(pDestClass);
				}
			}
			
			lmap = (Map)ObfuscationReflectionHelper.getPrivateValue(EntityList.class, null, "field_75624_e", "classToIDMapping");
			if (lmap.containsKey(pSrcClass)) {
				lint = (Integer)lmap.get(pSrcClass);
//				lmap.remove(pSrcClass);
				lmap.put(pDestClass, lint);
			}
			replaceEntitys.put(pSrcClass, pDestClass);
			Debug.entity("Replace %s -> %s(EntityListID: %d, EntityListString: %s)", pSrcClass.getSimpleName(), pDestClass.getSimpleName(), lint, ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void replaceCreatureList(List<SpawnListEntry> pMobs) {
		if (pMobs == null) return;
		for (Entry<Class, Class> le : replaceEntitys.entrySet()) {
			for (int j = 0; j < pMobs.size(); j++) {
				if (pMobs.get(j).entityClass == le.getKey()) {
					pMobs.get(j).entityClass = le.getValue();
					Debug.entity("ReplaceCreatureList: %s -> %s", le.getKey().getSimpleName(), le.getValue().getSimpleName());
				}
			}
		}
	}

	
	protected static void replaceBaiomeSpawn() {
		
		if (replaceEntitys.isEmpty()) return;
		BiomeGenBase[] biomeList = BiomeGenBase.getBiomeGenArray();
		for (int i = 0; i < biomeList.length; i++) {
			if (biomeList[i] == null) continue;
			List<SpawnListEntry> mobs;
			Debug.entity("ReplaceBaiomeSpawn:%s", biomeList[i].biomeName);
			Debug.entity("[Creature]");
			replaceCreatureList(biomeList[i].getSpawnableList(EnumCreatureType.creature));//.spawnableCreatureList);
			Debug.entity("[WaterCreature]");
			replaceCreatureList(biomeList[i].getSpawnableList(EnumCreatureType.waterCreature));//.spawnableWaterCreatureList);
			Debug.entity("[CaveCreature]");
			replaceCreatureList(biomeList[i].getSpawnableList(EnumCreatureType.ambient));//.spawnableCaveCreatureList);
			Debug.entity("[Monster]");
			replaceCreatureList(biomeList[i].getSpawnableList(EnumCreatureType.monster));//.spawnableMonsterList);
		}
	}

	
	public static Entity getRayTraceEntity(EntityLivingBase pEntity, double pRange, float pDelta, float pExpand) {
		Vec3 lvpos = Vec3.createVectorHelper(
				pEntity.posX, pEntity.posY + pEntity.getEyeHeight(), pEntity.posZ);
//		Vec3 lvpos = pEntity.getPosition(pDelta).addVector(0D, pEntity.getEyeHeight(), 0D);
		Vec3 lvlook = pEntity.getLook(pDelta);
		Vec3 lvview = lvpos.addVector(lvlook.xCoord * pRange, lvlook.yCoord * pRange, lvlook.zCoord * pRange);
		Entity ltarget = null;
		List llist = pEntity.worldObj.getEntitiesWithinAABBExcludingEntity(pEntity, pEntity.boundingBox.addCoord(lvlook.xCoord * pRange, lvlook.yCoord * pRange, lvlook.zCoord * pRange).expand((double)pExpand, (double)pExpand, (double)pExpand));
		double ltdistance = pRange * pRange;
		
		for (int var13 = 0; var13 < llist.size(); ++var13) {
			Entity lentity = (Entity)llist.get(var13);
			
			if (lentity.canBeCollidedWith()) {
				float lexpand = lentity.getCollisionBorderSize() + 0.3F;
				AxisAlignedBB laabb = lentity.boundingBox.expand((double)lexpand, (double)lexpand, (double)lexpand);
				MovingObjectPosition lmop = laabb.calculateIntercept(lvpos, lvview);
				
				if (laabb.isVecInside(lvpos)) {
					if (0.0D < ltdistance || ltdistance == 0.0D) {
						ltarget = lentity;
						ltdistance = 0.0D;
					}
				} else if (lmop != null) {
					double ldis = lvpos.squareDistanceTo(lmop.hitVec);
					
					if (ldis < ltdistance || ltdistance == 0.0D) {
						ltarget = lentity;
						ltdistance = ldis;
					}
				}
			}
		}
		return ltarget;
	}


	

	
	public static ItemStack getSmeltingResult(ItemStack pItemstack) {
/*
		if (methGetSmeltingResultForge != null) {
			try {
				return (ItemStack)methGetSmeltingResultForge.invoke(FurnaceRecipes.smelting(), pItemstack);
			}catch (Exception e) {
			}
		}
*/
		return FurnaceRecipes.smelting().getSmeltingResult(pItemstack);
	}

	
	public static boolean hasEffect(ItemStack pItemStack) {
		
		if (pItemStack != null) {
			Item litem = pItemStack.getItem();
			if (litem instanceof ItemPotion) {
				List llist = ((ItemPotion)litem).getEffects(pItemStack);
				return llist != null && !llist.isEmpty();
			}
		}
		return false;
	}
	
	public static int getHexToInt(String pValue) {
		String ls = "00000000".concat(pValue);
		int llen = ls.length();
		int li = Integer.parseInt(ls.substring(llen - 4, llen), 16);
		int lj = Integer.parseInt(ls.substring(llen - 8, llen - 4), 16);
		return (lj << 16) | li;
	}

	
	public static double getAttackVSEntity(ItemStack pItemStack) {
		AttributeModifier lam = (AttributeModifier)pItemStack.getAttributeModifiers().get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
		return lam == null ? 0 : lam.getAmount();
	}


	public static float sin(float f) {
		return MathHelper.sin(f);
	}


	public static float cos(float f) {
		return MathHelper.cos(f);
	}


	public static float sqrt(float f) {
		return MathHelper.sqrt_float(f);
	}


	public static int getEntityTicksExisted(Object entity) {
		if (entity instanceof Entity) {
			return ((Entity)entity).ticksExisted;
		}
		return 0;
	}


	public static Object getRidingEntity(Object entity) {
		if (entity instanceof Entity) {
			return ((Entity)entity).ridingEntity;
		}
		return null;
	}


	public static boolean isRidingMaster(Object entityliving) {
		// TODO Auto-generated method stub
//		Modchu_Reflect.loadClass("EntityPlayer").isInstance(Modchu_Reflect.getFieldObject("Entity", "field_70154_o", "ridingEntity", entityliving));
		return false;
	}


	public static int normalize(int i, int min, int max, int minOver, int maxOver) {
		return i < min ? minOver : i > max ? maxOver : i;
	}

	public static long normalize(long l, long min, long max, long minOver, long maxOver) {
		return l < min ? minOver : l > max ? maxOver : l;
	}

	public static float normalize(float f, float min, float max, float minOver, float maxOver) {
		return f < min ? minOver : f > max ? maxOver : f;
	}

	public static double normalize(double d, double min, double max, double minOver, double maxOver) {
		return d < min ? minOver : d > max ? maxOver : d;
	}
	public static Block getBlock(Object itemstack) {
		if (itemstack instanceof ItemStack) {
			Item item = ((ItemStack)itemstack).getItem();
			return item != null ? Block.getBlockFromItem(item) : null;
		}
		return null;
	}

	public static boolean isCamouflage(Object itemstack) {
		Block block = getBlock(itemstack);
		if (block instanceof BlockLeavesBase || block instanceof BlockPumpkin) {
			return true;
		}
		return false;
	}

	public static boolean isPlanter(Object stack) {
		Block itemStackOrBlockOrItem = getBlock(stack);
		return itemStackOrBlockOrItem instanceof BlockFlower
				|| itemStackOrBlockOrItem instanceof BlockDoublePlant
				|| itemStackOrBlockOrItem instanceof BlockMushroom
				|| itemStackOrBlockOrItem instanceof BlockSapling
				|| itemStackOrBlockOrItem instanceof BlockTallGrass;
	}


	public static float degToRad(float deg) {
		return deg / 180F * (float) Math.PI;
	}
	
	//Returns time in ticks
	public static float getMineTime(World worldObj, int pX, int pY, int pZ, ItemStack item)
	{
		return worldObj.getBlock(pX, pY, pZ).getBlockHardness(worldObj, pX, pY, pZ) * 1.5f * 20.0f;
	}
}
