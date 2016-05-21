package littleMaidMobX.entity;

import static littleMaidMobX.util.Statics.dataWatch_Absoption;
import static littleMaidMobX.util.Statics.dataWatch_Color;
import static littleMaidMobX.util.Statics.dataWatch_DominamtArm;
import static littleMaidMobX.util.Statics.dataWatch_ExpValue;
import static littleMaidMobX.util.Statics.dataWatch_Flags;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Aimebow;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Bloodsuck;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Freedom;
import static littleMaidMobX.util.Statics.dataWatch_Flags_LooksSugar;
import static littleMaidMobX.util.Statics.dataWatch_Flags_OverDrive;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Tracer;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Wait;
import static littleMaidMobX.util.Statics.dataWatch_Flags_Working;
import static littleMaidMobX.util.Statics.dataWatch_Flags_looksWithInterest;
import static littleMaidMobX.util.Statics.dataWatch_Flags_looksWithInterestAXIS;
import static littleMaidMobX.util.Statics.dataWatch_Flags_remainsContract;
import static littleMaidMobX.util.Statics.dataWatch_Free;
import static littleMaidMobX.util.Statics.dataWatch_Gotcha;
import static littleMaidMobX.util.Statics.dataWatch_ItemUse;
import static littleMaidMobX.util.Statics.dataWatch_Mode;
import static littleMaidMobX.util.Statics.dataWatch_Parts;
import static littleMaidMobX.util.Statics.dataWatch_Texture;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.ai.AIAttackArrow;
import littleMaidMobX.ai.AIAttackOnCollide;
import littleMaidMobX.ai.AIAvoidPlayer;
import littleMaidMobX.ai.AIBeg;
import littleMaidMobX.ai.AIBegMove;
import littleMaidMobX.ai.AICollectItem;
import littleMaidMobX.ai.AIFindBlock;
import littleMaidMobX.ai.AIFleeRain;
import littleMaidMobX.ai.AIFollowOwner;
import littleMaidMobX.ai.AIJumpToMaster;
import littleMaidMobX.ai.AIRestrictRain;
import littleMaidMobX.ai.AISwimming;
import littleMaidMobX.ai.AITracerMove;
import littleMaidMobX.ai.AIWait;
import littleMaidMobX.ai.AIWander;
import littleMaidMobX.aimodes.IFF;
import littleMaidMobX.aimodes.ModeBase;
import littleMaidMobX.aimodes.ModeManager;
import littleMaidMobX.aimodes.Mode_Playing;
import littleMaidMobX.aimodes.SwingStatus;
import littleMaidMobX.gui.GuiCommonHandler;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.inventory.InventoryLittleMaid;
import littleMaidMobX.io.Config;
import littleMaidMobX.model.caps.EntityCapsMaid;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.network.Net;
import littleMaidMobX.registry.ModelManager;
import littleMaidMobX.sound.EnumSound;
import littleMaidMobX.textures.ITextureEntity;
import littleMaidMobX.textures.TextureBox;
import littleMaidMobX.textures.TextureBoxBase;
import littleMaidMobX.textures.TextureBoxServer;
import littleMaidMobX.textures.TextureData;
import littleMaidMobX.util.Counter;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.Statics;
import littleMaidMobX.wrapper.MinecraftWrapper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
 
public class EntityLittleMaid extends EntityTameable implements ITextureEntity {

	
//	protected static final UUID maidUUID = UUID.nameUUIDFromBytes("lmm.littleMaidMob".getBytes());
	protected static final UUID maidUUID = UUID.fromString("e2361272-644a-3028-8416-8536667f0efb");
//	protected static final UUID maidUUIDSneak = UUID.nameUUIDFromBytes("lmm.littleMaidMob.sneak".getBytes());
	protected static final UUID maidUUIDSneak = UUID.fromString("5649cf91-29bb-3a0c-8c31-b170a1045560");
	protected static AttributeModifier attCombatSpeed = (new AttributeModifier(maidUUID, "Combat speed boost", 0.07D, 0)).setSaved(false);
	protected static AttributeModifier attAxeAmp = (new AttributeModifier(maidUUID, "Axe Attack boost", 0.5D, 1)).setSaved(false);
	protected static AttributeModifier attSneakingSpeed = (new AttributeModifier(maidUUIDSneak, "Sneking speed ampd", -0.4D, 2)).setSaved(false);


	

	public int maidContractLimit;		
	protected long maidAnniversary;			
	public int maidDominantArm;			
	
	public TextureData textureData;
	
	
	public InventoryLittleMaid maidInventory;
	public EntityLittleMaidAvatar maidAvatar;
	public EntityCapsMaid maidCaps;	
	
	public List<ModeBase> maidEntityModeList;
	public Map<Integer, EntityAITasks[]> maidModeList;
	public Map<String, Integer> maidModeIndexList;
	public int maidMode;		// 2Byte
	public boolean maidTracer;
	public boolean maidFreedom;
	public boolean maidWait;
	public int homeWorld;
	public int maidTiles[][] = new int[9][3];
	public int maidTile[] = new int[3];
	public TileEntity maidTileEntity;
	
	
	public EntityPlayer mstatMasterEntity;	
	public double mstatMasterDistanceSq;		
	public Entity mstatgotcha;				
	protected boolean mstatBloodsuck;
	protected boolean mstatClockMaid;
	
	protected int mstatMaskSelect;
	
	protected boolean mstatCamouflage;
	protected boolean mstatPlanter;
//	protected boolean isMaidChaseWait;
	protected int mstatWaitCount;
	protected int mstatTime;
	public Counter maidOverDriveTime;
	protected boolean mstatFirstLook;
	protected boolean mstatLookSuger;
	public Counter mstatWorkingCount;
	protected int mstatPlayingRole;
	protected int mstatWorkingInt;
	protected String mstatModeName;
	protected boolean mstatOpenInventory;
	
	public SwingStatus mstatSwingStatus[]; 
	public boolean mstatAimeBow;
	
	private boolean looksWithInterest;
	private boolean looksWithInterestAXIS;
	private float rotateAngleHead;			// Angle
	private float prevRotateAngleHead;		// prevAngle

	
	public float entityIdFactor;
	
	public boolean weaponFullAuto;	
	public boolean weaponReload;	
	public boolean maidCamouflage;
	
	
	
//	protected LMM_EnumSound maidAttackSound;
	public EnumSound maidDamageSound;
	protected int maidSoundInterval;
	
	//TODO: figure out if its required to set this value
	// minecraft has volume faders for different categories already
	// the categories are defined in our sounds.json
	protected float maidSoundRate = 0.8F;
	
	
	private int firstload = 1;
	public String statusMessage = "";
	
	
	// AI
	public EntityAITempt aiTempt;
	public AIBeg aiBeg;
	public AIBegMove aiBegMove;
	public EntityAIOpenDoor aiOpenDoor;
	public EntityAIRestrictOpenDoor aiCloseDoor;
	public AIAvoidPlayer aiAvoidPlayer;
	public AIFollowOwner aiFollow;
	public AIAttackOnCollide aiAttack;
	public AIAttackArrow aiShooting;
	public AICollectItem aiCollectItem;
	public AIRestrictRain aiRestrictRain;
	public AIFleeRain aiFleeRain;
	public AIWander aiWander;
	public AIJumpToMaster aiJumpTo;
	public AIFindBlock aiFindBlock;
	public AITracerMove aiTracer;
	public EntityAISwimming aiSwiming;
	public EntityAIPanic aiPanic;
	// ActiveModeClass
	public ModeBase maidActiveModeClass;
	public Profiler aiProfiler;


	public EntityLittleMaid(World par1World) {
		super(par1World);
		
		maidInventory = new InventoryLittleMaid(this);
		if (par1World != null ) {
			maidAvatar = new EntityLittleMaidAvatar(par1World, this);
		}
		mstatOpenInventory = false;
//		isMaidChaseWait = false;
		mstatTime = 6000;
		maidOverDriveTime = new Counter(5, 300, -100);
		mstatWorkingCount = new Counter(11, 10, -10);
		
		
		maidCaps = new EntityCapsMaid(this);
		
		
		textureData = new TextureData(this, maidCaps);
		textureData.setColor(12);
		TextureBox ltb[] = new TextureBox[2];
		ltb[0] = ltb[1] = ModelManager.instance.getDefaultTexture(this);
		setTexturePackName(ltb);
		
		entityIdFactor = (float)(getEntityId() * 70);
		
		mstatSwingStatus = new SwingStatus[] { new SwingStatus(), new SwingStatus()};
		setDominantArm(rand.nextInt(mstatSwingStatus.length));
		
		
//		maidAttackSound = LMM_EnumSound.attack;
		maidDamageSound = EnumSound.hurt;
		maidSoundInterval = 0;
		
		
		setHealth(15F);
		
		
		getNavigator().setAvoidsWater(true);
		getNavigator().setBreakDoors(true);
		
		
		
//		maidStabilizer.put("HeadTop", MMM_StabilizerManager.getStabilizer("WitchHat", "HeadTop"));
		
		
		
		
		maidEntityModeList = ModeManager.instance.getModeList(this);
		
		maidActiveModeClass = null;
		maidModeList = new HashMap<Integer, EntityAITasks[]>();
		maidModeIndexList = new HashMap<String, Integer>();
		initModeList();
		mstatModeName = "";
		maidMode = 65535;
		
		for (ModeBase lem : maidEntityModeList) {
			lem.initEntity();
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		
		String ls;
		if (Config.defaultTexture.isEmpty()) {
			ls = ModelManager.instance.getRandomTextureString(rand);
		} else {
			ls = Config.defaultTexture;
		}
		textureData.setTextureInitServer(ls);
		Debug.entity("init-ID:%d, %s:%d", getEntityId(), textureData.textureBox[0].textureName, textureData.getColor());
		setTexturePackIndex(textureData.getColor(), textureData.textureIndex);
		setMaidMode("Wild");
		return super.onSpawnWithEgg(par1EntityLivingData);
	}

	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		
		getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		
		
		
		// 0:Flags
		// 1:Air
		// 2, 3, 4, 5,
		// 6: HP
		// 7, 8:PotionMap
		// 9: ArrowCount
		
		
		// 12: GrowingAge
		// 16: Tame(4), Sit(1) 
		// 17: ownerName
		
		
		// 17 -> 18
		
		dataWatcher.addObject(dataWatch_Absoption, Float.valueOf(0.0F));
		
		
		// 19:maidColor
		dataWatcher.addObject(dataWatch_Color, Byte.valueOf((byte)0));
		
		dataWatcher.addObject(dataWatch_Texture, Integer.valueOf(0));
		
		dataWatcher.addObject(dataWatch_Parts, Integer.valueOf(0));
		
		dataWatcher.addObject(dataWatch_Flags, Integer.valueOf(0));
		// 23:GotchaID
		dataWatcher.addObject(dataWatch_Gotcha, Integer.valueOf(0));
		
		dataWatcher.addObject(dataWatch_Mode, Short.valueOf((short)0));
		
		dataWatcher.addObject(dataWatch_DominamtArm, Byte.valueOf((byte)0));
		
		dataWatcher.addObject(dataWatch_ItemUse, Integer.valueOf(0));
		
		dataWatcher.addObject(dataWatch_ExpValue, Integer.valueOf(0));
		
		// TODO:test
		
		dataWatcher.addObject(dataWatch_Free, new Integer(0));
	}

	public void initModeList() {
		// AI
		aiBeg = new AIBeg(this, 8F);
		aiBegMove = new AIBegMove(this, 1.0F);
		aiOpenDoor = new EntityAIOpenDoor(this, true);
		aiCloseDoor = new EntityAIRestrictOpenDoor(this);
		aiAvoidPlayer = new AIAvoidPlayer(this, 1.0F, 3);
		aiFollow = new AIFollowOwner(this, 1.0F, 36D, 25D, 81D);
		aiAttack = new AIAttackOnCollide(this, 1.0F, true);
		aiShooting = new AIAttackArrow(this);
		aiCollectItem = new AICollectItem(this, 1.0F);
		aiRestrictRain = new AIRestrictRain(this);
		aiFleeRain = new AIFleeRain(this, 1.0F);
		aiWander = new AIWander(this, 1.0F);
		aiJumpTo = new AIJumpToMaster(this);
		aiFindBlock = new AIFindBlock(this);
		aiSwiming = new AISwimming(this);
		aiPanic = new EntityAIPanic(this, 2.0F);
		aiTracer = new AITracerMove(this);
		aiSit = new AIWait(this);
		
		
		aiProfiler = worldObj != null && worldObj.theProfiler != null ? worldObj.theProfiler : null;

		
		EntityAITasks ltasks[] = new EntityAITasks[2];
		ltasks[0] = new EntityAITasks(aiProfiler);
		ltasks[1] = new EntityAITasks(aiProfiler);
		
		// default
		ltasks[0].addTask(1, aiSwiming);
		ltasks[0].addTask(2, aiSit);
		ltasks[0].addTask(3, aiJumpTo);
		ltasks[0].addTask(4, aiFindBlock);
		ltasks[0].addTask(6, aiAttack);
		ltasks[0].addTask(7, aiShooting);
		//ltasks[0].addTask(8, aiPanic);
		ltasks[0].addTask(10, aiBeg);
		ltasks[0].addTask(11, aiBegMove);
		ltasks[0].addTask(20, aiAvoidPlayer);
		ltasks[0].addTask(21, aiFleeRain);
		ltasks[0].addTask(22, aiCollectItem);
		
		ltasks[0].addTask(30, aiTracer);
		ltasks[0].addTask(31, aiFollow);
		ltasks[0].addTask(32, aiWander);
		ltasks[0].addTask(33, new EntityAILeapAtTarget(this, 0.3F));
		
		ltasks[0].addTask(40, aiCloseDoor);
		ltasks[0].addTask(41, aiOpenDoor);
		ltasks[0].addTask(42, aiRestrictRain);
		
		ltasks[0].addTask(51, new EntityAIWatchClosest(this, EntityLivingBase.class, 10F));
		ltasks[0].addTask(52, new EntityAILookIdle(this));
		
		
		for (ModeBase ieml : maidEntityModeList) {
			ieml.addEntityMode(ltasks[0], ltasks[1]);
		}
	}


	public void addMaidMode(EntityAITasks[] peaiTasks, String pmodeName, int pmodeIndex) {
		maidModeList.put(pmodeIndex, peaiTasks);
		maidModeIndexList.put(pmodeName, pmodeIndex);
	}


	public int getMaidModeInt() {
		return maidMode;
	}

	public String getMaidModeString() {
		if (!isContract())
		{
			return getMaidModeString(maidMode);
		}
		else if (!isRemainsContract())
		{
			return "Strike";
		}
		else if (isMaidWait())
		{
			return "Wait";
		}
		else if (isPlaying())
		{
			return "Playing";
		}
		else
		{
			String ls = getMaidModeString(maidMode);
			if (maidOverDriveTime.isEnable())
			{
				ls = "D-" + ls;
			} else
			if (isTracer()) {
				ls = "T-" + ls;
			} else
			if (isFreedom()) {
				ls = "F-" + ls;
			}
			return ls;
		}
	}

	public String getMaidModeString(int pindex) {
		
		String ls = "";
		for (Entry<String, Integer> le : maidModeIndexList.entrySet())
		{
			if (le.getValue() == pindex)
			{
				ls = le.getKey();
				break;
			}
		}
		return ls;
	}

	public boolean setMaidMode(String pname) {
		return setMaidMode(pname, false);
	}

	public boolean setMaidMode(String pname, boolean pplaying) {
		if (!maidModeIndexList.containsKey(pname)) {
			return false;
		}
		return setMaidMode(maidModeIndexList.get(pname), pplaying);
	}

	public boolean setMaidMode(int pindex) {
		return setMaidMode(pindex, false);
	}


	public boolean setMaidMode(int pindex, boolean pplaying) {
		
		velocityChanged = true;
		if (!maidModeList.containsKey(pindex)) return false;
		if (maidMode == pindex) return true;
		
		if (pplaying) {
			
		} else {
			mstatWorkingInt = pindex;
		}
		mstatModeName = getMaidModeString(pindex);
		maidMode = pindex;
		dataWatcher.updateObject(dataWatch_Mode, (short)maidMode);
		EntityAITasks[] ltasks = maidModeList.get(pindex);
		
		
		if (ltasks.length > 0 && ltasks[0] != null)
		{
			setMaidModeAITasks(ltasks[0], tasks);
		}
		else
		{
			setMaidModeAITasks(null, tasks);
		}
		if (ltasks.length > 1 && ltasks[1] != null)
		{
			setMaidModeAITasks(ltasks[1], targetTasks);
		}
		else
		{
			setMaidModeAITasks(null, targetTasks);
		}

		maidAvatar.stopUsingItem();
		setSitting(false);
		setSneaking(false);
		setActiveModeClass(null);
		aiJumpTo.setEnable(true);
//		aiFollow.setEnable(true);
		aiAttack.setEnable(true);
		aiShooting.setEnable(false);
		aiAvoidPlayer.setEnable(true);
//		aiWander.setEnable(maidFreedom);
		setBloodsuck(false);
		clearTilePosAll();
		for (int li = 0; li < maidEntityModeList.size(); li++) {
			ModeBase iem = maidEntityModeList.get(li); 
			
			if (iem.setMode(maidMode)) {
				setActiveModeClass(iem);
				aiFollow.minDist = iem.getRangeToMaster(0);
				aiFollow.maxDist = iem.getRangeToMaster(1);
				break;
			}
		}
		getNextEquipItem();
		
		return true;
	}

	protected void setMaidModeAITasks(EntityAITasks pTasksSRC, EntityAITasks pTasksDEST) {
		
		
		try {
			ArrayList<EntityAITaskEntry> ltasksDoDEST = getEntityAITasks_taskEntries(pTasksDEST);
			ArrayList<EntityAITaskEntry> ltasksExeDEST = getEntityAITasks_executingTaskEntries(pTasksDEST);
			
			if (pTasksSRC == null) {
				ltasksDoDEST.clear();
				ltasksExeDEST.clear();
			} else {
				ArrayList<EntityAITaskEntry> ltasksDoSRC = getEntityAITasks_taskEntries(pTasksSRC);
//				ArrayList<EntityAITaskEntry> ltasksExeSRC = getEntityAITasks_executingTaskEntries(pTasksSRC);
				
				Iterator iterator;
				iterator = ltasksExeDEST.iterator();
				while (iterator.hasNext()) {
					EntityAITaskEntry ltaskentory = (EntityAITaskEntry)iterator.next();
					ltaskentory.action.resetTask();
				}	
				ltasksExeDEST.clear();
				
				ltasksDoDEST.clear();
				ltasksDoDEST.addAll(ltasksDoSRC);
				
//				for (EntityAITaskEntry ltask : ltasksDoSRC) {
//					if (ltask instanceof IEntityAI)
//					{
////						((LMM_IEntityAI)ltask).setDefaultEnable();
//					}
//				}
			}
		} catch (Exception s) {
		}
	}
	public static ArrayList<EntityAITaskEntry> getEntityAITasks_taskEntries(EntityAITasks task)
	{
		return (ArrayList<EntityAITaskEntry>)ObfuscationReflectionHelper.getPrivateValue(EntityAITasks.class, task, "field_75782_a", "taskEntries");
	}
	public static ArrayList<EntityAITaskEntry> getEntityAITasks_executingTaskEntries(EntityAITasks task)
	{
		return (ArrayList<EntityAITaskEntry>)ObfuscationReflectionHelper.getPrivateValue(EntityAITasks.class, task, "field_75780_b", "executingTaskEntries");
	}

	
	public ModeBase getActiveModeClass() {
		return maidActiveModeClass;
	}

	public void setActiveModeClass(ModeBase pEntityMode) {
		maidActiveModeClass = pEntityMode;
	}

	public boolean isActiveModeClass() {
		return maidActiveModeClass != null;
	}

	
	@Override
	protected String getHurtSound()
	{
		playSound(maidDamageSound, true);
		return null;
	}

	@Override
	protected String getDeathSound() {
		playSound(EnumSound.death, true);
		return null;
	}

	@Override
	protected String getLivingSound()
	{
		EnumSound so = EnumSound.Null;
		if (getHealth() < 10)
		{
			so = EnumSound.living_whine;
		}
		else if (rand.nextFloat() < maidSoundRate)
		{
			if (mstatTime > 23500 || mstatTime < 1500)
			{
				so = EnumSound.living_morning;
			}
			else if (mstatTime < 12500)
			{
				if (isContract())
				{
					BiomeGenBase biomegenbase = worldObj.getBiomeGenForCoords(MathHelper.floor_double(posX + 0.5D), MathHelper.floor_double(posZ + 0.5D));
					float ltemp = biomegenbase.getFloatTemperature((int)this.posX, (int)this.posY, (int)this.posZ);
					if (ltemp <= 0.15F)
					{
						so = EnumSound.living_cold;
					}
					else if (ltemp > 1.0F)
					{
						so = EnumSound.living_hot;
					}
					else
					{
						so = EnumSound.living_daytime;
					}
					if (worldObj.isRaining())
					{
						if (biomegenbase.canSpawnLightningBolt())
						{
							so = EnumSound.living_rain;
						}
						else if (biomegenbase.getEnableSnow())
						{
							so = EnumSound.living_snow;
						}
					}
				}
				else
				{
					so = EnumSound.living_daytime;
				}
			}
			else
			{
				so = EnumSound.living_night;
			}
		}
		
		Debug.sound("id:%d LivingSound:%s", getEntityId(), worldObj == null ? "null" : worldObj.isRemote ? "Client" : "Server");
		playLittleMaidSound(so, false);
		return null;
	}

	
	public void playSound(String pname)
	{
		playSound(pname, 0.5F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
	}

	
	public void playSound(EnumSound enumsound, boolean force) {
		if ((maidSoundInterval > 0 && !force) || enumsound == EnumSound.Null) return;
		maidSoundInterval = 20;
		if (worldObj.isRemote) {
			// Client
//			String lsound = LMM_SoundManager.getSoundValue(enumsound, textureName, maidColor & 0x00ff);
//			float lpitch = mod_LMM_littleMaidMob.VoiceDistortion ? (rand.nextFloat() * 0.2F) + 0.95F : 1.0F;
//			worldObj.playSound(posX, posY, posZ, lsound, getSoundVolume(), lpitch, false);
		} else {
			// Server
			Debug.entity("id:%d-%s, seps:%04x-%s", getEntityId(), worldObj.isRemote ? "Client" : "Server",  enumsound.index, enumsound.name());
			byte[] lbuf = new byte[] {
					Statics.LMN_Client_PlaySound,
					0, 0, 0, 0,
					0, 0, 0, 0
			};
			Helper.setInt(lbuf, 5, enumsound.index);
			Net.sendToAllEClient(this, lbuf);
		}
	}

	
	public void playLittleMaidSound(EnumSound enumsound, boolean force)
	{
		if (((maidSoundInterval > 0 && !force) || enumsound == EnumSound.Null) || !Config.makeNoise)
		{
			return;
		}
		maidSoundInterval = 20;
		if (worldObj.isRemote) {
			// Client
			// TODO: TEST
			String s = enumsound.toString();//LMM_SoundManager.getSoundValue(enumsound, textureData.getTextureName(0), textureData.getColor());
			if(!s.isEmpty() && !s.startsWith("minecraft:"))
			{
				s = LittleMaidMobX.DOMAIN + ":" + s;
			}
			Debug.entity(String.format("id:%d, se:%04x-%s (%s)", getEntityId(), enumsound.index, enumsound.name(), s));
			if(!s.isEmpty())
			{
				float lpitch = Config.VoiceDistortion ? (rand.nextFloat() * 0.2F) + 0.95F : 1.0F;
				worldObj.playSound(posX, posY, posZ, s, getSoundVolume(), lpitch, false);
			}
		}
	}

	@Override
	public void onKillEntity(EntityLivingBase par1EntityLiving) {
		super.onKillEntity(par1EntityLiving);
		if (isBloodsuck()) {
//			mod_LMM_littleMaidMob.Debug("nice Kill.");
			playSound(EnumSound.laughter, true);
		} else {
			setTarget(null);
			setAttackTarget(null);
		}
	}

	@Override
	protected boolean canDespawn()
	{
		return Config.canDespawn || super.canDespawn();
	}

	@Override
	public boolean getCanSpawnHere() {
		
		if (Config.spawnLimit <= getMaidCount())
		{
			//LittleMaidMobX.Debug("Spawn Limit.");
			System.out.println("Spawn Limit Hit.");
			return false;
		}
		int lx = MathHelper.floor_double(this.posX);
		int ly = MathHelper.floor_double(this.boundingBox.minY);
		int lz = MathHelper.floor_double(this.posZ);
		
		if (Config.Dominant) {
			
			return this.worldObj.checkNoEntityCollision(this.boundingBox) 
					&& this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() 
					&& !this.worldObj.isAnyLiquid(this.boundingBox)
					&& this.getBlockPathWeight(lx, ly, lz) >= 0.0F;
		} else {
			return super.getCanSpawnHere();
		}
	}

	@Override
	public void setDead() {
		if (mstatgotcha != null) {
			
			EntityItem entityitem = new EntityItem(worldObj, mstatgotcha.posX, mstatgotcha.posY, mstatgotcha.posZ, new ItemStack(Items.string));
			worldObj.spawnEntityInWorld(entityitem);
			mstatgotcha = null;
		}
		super.setDead();
	}

	
	public int getMaidCount() {
		int lj = 0;
		for (int li = 0; li < worldObj.loadedEntityList.size(); li++) {
			if (worldObj.loadedEntityList.get(li) instanceof EntityLittleMaid) {
				lj++;
			}
		}
		//System.out.println("Current maid count is" + lj);
		return lj;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		
		return null;
	}

	
	protected void showParticleFX(String s) {
		showParticleFX(s, 1D, 1D, 1D);
	}

	protected void showParticleFX(String s, double d, double d1, double d2) {
		showParticleFX(s, d, d1, d2, 0D, 0D, 0D);
	}

	protected void showParticleFX(String s, double d, double d1, double d2, double d3, double d4, double d5 ) {
		for (int i = 0; i < 7; i++) {
			double d6 = rand.nextGaussian() * d + d3;
			double d7 = rand.nextGaussian() * d1 + d4;
			double d8 = rand.nextGaussian() * d2 + d5;
			worldObj.spawnParticle(s, (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d6, d7, d8);
		}
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		
		switch (par1) {
		case 10:
			
			showParticleFX("smoke", 0.02D, 0.02D, 0.02D);
			break;
		case 11:
			
			double a = getContractLimitDays() / 7D;
			double d6 = a * 0.3D;
			double d7 = a;
			double d8 = a * 0.3D;
			worldObj.spawnParticle("note", posX, posY + height + 0.1D, posZ, d6, d7, d8);
			break;
		case 12:
			
			showParticleFX("reddust", 0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
			break;
		case 13:
			
			showParticleFX("smoke", 0.02D, 0.02D, 0.02D);
			break;
		case 14:
			
			showParticleFX("explode", 0.3D, 0.3D, 0.3D, 0.0D, 0.0D, 0.0D);
			break;
			
		default:
			super.handleHealthUpdate(par1);
		}
	}

	
	public void setAbsorptionAmount(float par1) {
		// AbsorptionAmount
		if (par1 < 0.0F) {
			par1 = 0.0F;
		}
		
		this.getDataWatcher().updateObject(dataWatch_Absoption, Float.valueOf(par1));
	}
	public float getAbsorptionAmount() {
		return this.getDataWatcher().getWatchableObjectFloat(dataWatch_Absoption);
	}


	public int colorMultiplier(float pLight, float pPartialTicks) {
		
		int lbase = 0;
		if (maidOverDriveTime.isDelay()) {
			int i;
			if (maidOverDriveTime.isEnable()) {
				i = 100;
			} else {
				i = 100 + maidOverDriveTime.getValue();
			}
			lbase = i << 24 | 0x00df0f0f;
		}
		
		if (isActiveModeClass()) {
			lbase = lbase | getActiveModeClass().colorMultiplier(pLight, pPartialTicks);
		}
		
		return lbase;
	}


	
	@Override
	protected boolean isAIEnabled() {
		
		return true;
	}
	
	
	public boolean getIFF(Entity pEntity) {
		
		if (pEntity == null || pEntity == mstatMasterEntity) {
			return true;
		}
		
		int tt = IFF.getIFF(getMaidMaster(), pEntity);
		switch (tt) {
		case IFF.iff_Enemy:
			return false;
		case IFF.iff_Friendry:
			return true;
		case IFF.iff_Unknown:
			if (isBloodsuck()) {
				
				return false;
			}
			if (pEntity instanceof EntityLittleMaid) {
				
				if (((EntityLittleMaid)pEntity).mstatPlayingRole > Mode_Playing.mpr_NULL) {
					return true;
				}
			}
			if (pEntity instanceof EntityCreature) {
				
				Entity et = ((EntityCreature)pEntity).getEntityToAttack();
				if (et != null && et == mstatMasterEntity) {
					return false;
				}
				if (et == this) {
					return false;
				}
				if (et instanceof EntityLittleMaid) {
					
					if (((EntityLittleMaid)et).getMaidMasterEntity() == mstatMasterEntity) {
						return false;
					}
				}
			}
			return true;
			
		default :
			return false;
		}
	}

	@Override
	public boolean canAttackClass(Class par1Class) {
		
		return true;
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {

		
		if (getHealth() < 10 && !isBloodsuck() && maidInventory.hasItem(Items.sugar)) {
			return true;
		}
		
		
		if (isActiveModeClass() && getActiveModeClass().attackEntityAsMob(maidMode, par1Entity)) {
			return true;
		}
		
		
		setSwing(20, isBloodsuck() ? EnumSound.attack_bloodsuck : EnumSound.attack);
		maidAvatar.attackTargetEntityWithCurrentItem(par1Entity);
		return true;
	}

	@Override
	public boolean isBreedingItem(ItemStack par1ItemStack) {
		
		if (isContractEX()) {
			return par1ItemStack.getItem() == Items.sugar;
		} else {
			return par1ItemStack.getItem() == Items.cake;
		}
	}

	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1nbtTagCompound) {
		
		super.writeEntityToNBT(par1nbtTagCompound);
		
		par1nbtTagCompound.setTag("Inventory", maidInventory.writeToNBT(new NBTTagList()));
		par1nbtTagCompound.setString("Mode", getMaidModeString(mstatWorkingInt));
		par1nbtTagCompound.setBoolean("Wait", isMaidWait());
		par1nbtTagCompound.setBoolean("Freedom", isFreedom());
		par1nbtTagCompound.setBoolean("Tracer", isTracer());
		par1nbtTagCompound.setInteger("LimitCount", maidContractLimit);
		par1nbtTagCompound.setLong("Anniversary", maidAnniversary);
		par1nbtTagCompound.setInteger("EXP", experienceValue);
		par1nbtTagCompound.setInteger("DominantArm", maidDominantArm);
		par1nbtTagCompound.setInteger("Color", textureData.getColor());
		par1nbtTagCompound.setString("texName", textureData.getTextureName(0));
//		System.out.println("Save textureName: " + textureData.getTextureName(0));
		par1nbtTagCompound.setString("texArmor", textureData.getTextureName(1));
//		System.out.println("Save textureArmor: " + textureData.getTextureName(1));
		// HomePosition
		par1nbtTagCompound.setInteger("homeX", getHomePosition().posX);
		par1nbtTagCompound.setInteger("homeY", getHomePosition().posY);
		par1nbtTagCompound.setInteger("homeZ", getHomePosition().posZ);
		par1nbtTagCompound.setInteger("homeWorld", homeWorld);
		// Tiles
		NBTTagCompound lnbt = new NBTTagCompound();
		par1nbtTagCompound.setTag("Tiles", lnbt);
		for (int li = 0; li < maidTiles.length; li++) {
			if (maidTiles[li] != null) {
				lnbt.setIntArray(String.valueOf(li), maidTiles[li]);
			}
		}
		
		for (int li = 0; li < maidEntityModeList.size(); li++) {
			maidEntityModeList.get(li).writeEntityToNBT(par1nbtTagCompound);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1nbtTagCompound) {
		
		super.readEntityFromNBT(par1nbtTagCompound);
		
		if (par1nbtTagCompound.hasKey("ModeColor")) {
			
			String s = par1nbtTagCompound.getString("Master");
			if(s.length() > 0) {
				MinecraftWrapper.setOwner(this, s);
				setContract(true);
			}
			NBTTagList nbttaglist = par1nbtTagCompound.getTagList("Inventory", 10);
			maidInventory.readFromNBT(nbttaglist);
			
			ItemStack[] armi = new ItemStack[4];
			for (int i = 0; i < 4; i++) {
				ItemStack is = maidInventory.armorItemInSlot(i);
				if (is != null) {
					armi[3 - ((ItemArmor)is.getItem()).armorType] = is; 
				}
			}
			maidInventory.armorInventory = armi; 
			//
			setMaidWait(par1nbtTagCompound.getBoolean("Wait"));
			setFreedom(par1nbtTagCompound.getBoolean("Freedom"));
			setTracer(par1nbtTagCompound.getBoolean("Tracer"));
			textureData.textureIndex[0] = ModelManager.instance.getIndexTextureBoxServer(this, par1nbtTagCompound.getString("texName"));
//			System.out.println("Get texName: " + par1nbtTagCompound.getString("texName"));
			textureData.textureIndex[1] = ModelManager.instance.getIndexTextureBoxServer(this, par1nbtTagCompound.getString("texArmor"));
//			System.out.println("Get texArmor: " + par1nbtTagCompound.getString("texArmor"));
			textureData.textureBox[0] = ModelManager.instance.getTextureBoxServer(textureData.textureIndex[0]);
			textureData.textureBox[1] = ModelManager.instance.getTextureBoxServer(textureData.textureIndex[1]);
			byte b = par1nbtTagCompound.getByte("ModeColor");
			setColor(b & 0x0f);
			switch ((b & 0xf0) >> 4) {
			case 0:
				setMaidMode(0x0000);	// Wild
				break;
			case 2:
				setMaidMode(0x0001);	// Escorter
				break;
			case 4:
				setMaidMode(0x0080);	// Fencer
				break;
			case 5:
				setMaidMode(0x0000);	// Healer
				break;
			case 6:
				setMaidMode(0x0021);	// Cooking
				break;
			case 7:
				setMaidMode(0x00c0);	// Bloodsucker
				break;
			case 8:
				setMaidMode(0x0083);	// Archer
				break;
			case 9:
				setMaidMode(0x00c3);	// Blazingstar
				break;
			case 10:
				setMaidMode(0x0081);	// Ripper
				break;
			case 11:
				setMaidMode(0x00c2);	// Detonator
				break;
			case 12:
				setMaidMode(0x00c1);	// TNT-D
				break;
			case 13:
				setMaidMode(0x0020);	// Torcher
				break;
			case 15:
				setMaidMode(0x0000);	// Pharmacist
				break;
			/*case ??:
				setMaidMode(0x0023);	//Miner
				break;
			case ??:
				setMaidMode(0x0024);	//Farmer
				break;*/
			default :
				setMaidMode(0x0000);	// Wild
			}
//			setMaidMode((b & 0xf0) >> 4);
			int lhx = MathHelper.floor_double(posX);
			int lhy = MathHelper.floor_double(posY);
			int lhz = MathHelper.floor_double(posZ);;
//			func_110172_bL().set(lhx, lhy, lhz);
			getHomePosition().set(lhx, lhy, lhz);
			long lcl = par1nbtTagCompound.getLong("Limit");
			if (isContract() && lcl == 0) {
				maidContractLimit = 24000;
			} else {
				maidContractLimit = (int)((lcl - worldObj.getTotalWorldTime()));
			}
			maidAnniversary = par1nbtTagCompound.getLong("Anniversary");
			if (maidAnniversary == 0L && isContract()) {
				
				maidAnniversary = worldObj.getWorldTime() - getEntityId();
			}
			
		} else {
			
			Debug.entity("read." + worldObj.isRemote);
			
			maidInventory.readFromNBT(par1nbtTagCompound.getTagList("Inventory", 10));
			setMaidWait(par1nbtTagCompound.getBoolean("Wait"));
			setFreedom(par1nbtTagCompound.getBoolean("Freedom"));
			setTracer(par1nbtTagCompound.getBoolean("Tracer"));
			setMaidMode(par1nbtTagCompound.getString("Mode"));
			if (par1nbtTagCompound.hasKey("LimitCount")) {
				maidContractLimit = par1nbtTagCompound.getInteger("LimitCount");
			} else {
				long lcl = par1nbtTagCompound.getLong("Limit");
				if (isContract() && lcl == 0) {
					maidContractLimit = 24000;
				} else {
					maidContractLimit = (int)((lcl - worldObj.getWorldTime()));
				}
			}
			if (isContract() && maidContractLimit == 0) {
				
//				maidContractLimit = worldObj.getWorldTime() + 24000L;
				maidContractLimit = 24000;
			}
			maidAnniversary = par1nbtTagCompound.getLong("Anniversary");
			if (maidAnniversary == 0L && isContract()) {
				
				maidAnniversary = worldObj.getWorldTime() - getEntityId();
			}
			if (maidAvatar != null) {
				maidAvatar.experienceTotal = par1nbtTagCompound.getInteger("EXP");
			}
			setDominantArm(par1nbtTagCompound.getInteger("DominantArm"));
			if (mstatSwingStatus.length <= maidDominantArm) {
				maidDominantArm = 0;
			}
			textureData.textureIndex[0] = ModelManager.instance.getIndexTextureBoxServer(this, par1nbtTagCompound.getString("texName"));
//			System.out.println("Get texName: " + par1nbtTagCompound.getString("texName"));
			textureData.textureIndex[1] = ModelManager.instance.getIndexTextureBoxServer(this, par1nbtTagCompound.getString("texArmor"));
//			System.out.println("Get texArmor: " + par1nbtTagCompound.getString("texArmor"));
			textureData.textureBox[0] = ModelManager.instance.getTextureBoxServer(textureData.textureIndex[0]);
			textureData.textureBox[1] = ModelManager.instance.getTextureBoxServer(textureData.textureIndex[1]);
			textureData.setColor(par1nbtTagCompound.getInteger("Color"));
			setTexturePackIndex(textureData.color, textureData.getTextureIndex());
			
			// HomePosition
			int lhx = par1nbtTagCompound.getInteger("homeX");
			int lhy = par1nbtTagCompound.getInteger("homeY");
			int lhz = par1nbtTagCompound.getInteger("homeZ");
//			func_110172_bL().set(lhx, lhy, lhz);
			getHomePosition().set(lhx, lhy, lhz);
			homeWorld = par1nbtTagCompound.getInteger("homeWorld");
			
			// Tiles
			NBTTagCompound lnbt = par1nbtTagCompound.getCompoundTag("Tiles");
			for (int li = 0; li < maidTiles.length; li++) {
				int ltile[] = lnbt.getIntArray(String.valueOf(li));
				maidTiles[li] = ltile.length > 0 ? ltile : null;
			}
			
			
			for (int li = 0; li < maidEntityModeList.size(); li++) {
				maidEntityModeList.get(li).readEntityFromNBT(par1nbtTagCompound);
			}
		}
		onInventoryChanged();
		
		//What is this?
		if (Config.antiDoppelganger && maidAnniversary > 0L) {
			for (int i = 0; i < worldObj.loadedEntityList.size(); i++) {
				Entity entity1 = (Entity)worldObj.loadedEntityList.get(i);
				if (!entity1.isDead && entity1 instanceof EntityLittleMaid) {
					EntityLittleMaid elm = (EntityLittleMaid)entity1;
					if (elm != this && elm.isContract() && elm.maidAnniversary == maidAnniversary
							&& elm.getMaidMaster().equalsIgnoreCase(getMaidMaster())) {
						
						if (getEntityId() > elm.getEntityId()) {
							Debug.entity(String.format("Load Doppelganger ID:%d, %d" ,elm.getEntityId(), maidAnniversary));
							elm.setDead();
						} else {
							Debug.entity(String.format("Load Doppelganger ID:%d, %d" ,getEntityId(), maidAnniversary));
							setDead();
							break;
						}
					}
				}
			}
		} else {
//			System.out.println(String.format("Load ID:%d, MaidMaster:%s, x:%.1f, y:%.1f, z:%.1f, %d" ,getEntityId(), getMaidMaster(), posX, posY, posZ, maidAnniversary));
			Debug.entity(String.format("Load ID:%d, MaidMaster:%s, x:%.1f, y:%.1f, z:%.1f, %d" ,getEntityId(), getMaidMaster(), posX, posY, posZ, maidAnniversary));
		}
		
	}

	@Override
	public IIcon getItemIcon(ItemStack par1ItemStack, int par2) {
		
		if (maidAvatar != null) {
			return maidAvatar.getItemIcon(par1ItemStack, par2);
		}
		
		if (par1ItemStack.getItem().requiresMultipleRenderPasses()) {
			return par1ItemStack.getItem().getIconFromDamageForRenderPass(par1ItemStack.getItemDamage(), par2);
		} else {
			return super.getItemIcon(par1ItemStack, par2);
		}
	}

	public boolean canBePushed()
	{
		// --------------------------------------------
		
		if (ridingEntity != null && ridingEntity == mstatMasterEntity) {
			if(ridingEntity.ridingEntity instanceof EntityHorse)
			{
				return false;
			}
		}
		// --------------------------------------------

		return !this.isDead;
	}

	
	@Override
	public boolean canBeCollidedWith() {
		if (ridingEntity != null && ridingEntity == mstatMasterEntity) {
			ItemStack litemstack = ((EntityPlayer)mstatMasterEntity).getCurrentEquippedItem();
			return (litemstack == null) || (litemstack.getItem() == Items.saddle);
		} else {
			return super.canBeCollidedWith();
		}
	}

	@Override
	public boolean canAttackWithItem() {
		if (ridingEntity != null && ridingEntity == mstatMasterEntity) {
			return false;
		} else {
			return super.canAttackWithItem();
		}
	}

	@Override
	public double getMountedYOffset() {
		
		if (riddenByEntity instanceof EntityChicken) {
			return height + 0.03D;
		}
		if (riddenByEntity instanceof EntitySquid) {
			return height - 0.2D;
		}
		return super.getMountedYOffset() + 0.35D;
	}

	@Override
	public double getYOffset() {
		if(ridingEntity instanceof EntityPlayer) {
			
//			setSneaking(true);
//			mstatAimeBow = true;
//			updateAimebow();
//			return (double)(yOffset - 1.8F);

			// --------------------------------------------
			
			if(ridingEntity.ridingEntity instanceof EntityHorse)
			{
				if(this.worldObj.isRemote)
				{
					return (double)(yOffset - 2.8F);
				}
				else
				{
					return (double)(yOffset - 1.0F);
				}
			}
			
			else
			{
				return (double)(yOffset - 2.0F);
			}
			// --------------------------------------------
		}
		return (double)(yOffset - 0.25F);
	}

	@Override
	public void updateRidden() {
		
		++ticksExisted;
		//
		
		if(ridingEntity instanceof EntityPlayer) {
			EntityPlayer lep = (EntityPlayer)ridingEntity;
			
			
			renderYawOffset = lep.renderYawOffset;
			prevRenderYawOffset = lep.prevRenderYawOffset;
			double llpx = lastTickPosX;
			double llpy = lastTickPosY;
			double llpz = lastTickPosZ;
			
			
			super.updateRidden();
			
			renderYawOffset = lep.renderYawOffset;
			if (((rotationYaw - renderYawOffset) % 360F) > 90F) {
				rotationYaw = renderYawOffset + 90F;
			}
			if (((rotationYaw - renderYawOffset) % 360F) < -90F) {
				rotationYaw = renderYawOffset - 90F;
			}
			if (((rotationYawHead - renderYawOffset) % 360F) > 90F) {
				rotationYawHead = renderYawOffset + 90F;
			}
			if (((rotationYawHead - renderYawOffset) % 360F) < -90F) {
				rotationYawHead = renderYawOffset - 90F;
			}

			double dx, dz;
			// --------------------------------------------
			
			
			if(lep.ridingEntity instanceof EntityHorse)
			{
				EntityHorse horse = (EntityHorse)lep.ridingEntity;
				if(this.worldObj.isRemote)
				{
					dx = Math.sin(((double)horse.renderYawOffset * Math.PI) / 180D) * 0.5;
					dz = Math.cos(((double)horse.renderYawOffset * Math.PI) / 180D) * 0.5;
				}
				else
				{
					dx = Math.sin(((double)horse.renderYawOffset * Math.PI) / 180D) * 0.9;
					dz = Math.cos(((double)horse.renderYawOffset * Math.PI) / 180D) * 0.9;
				}
			}
			else
			{
				dx = Math.sin(((double)lep.renderYawOffset * Math.PI) / 180D) * 0.35;
				dz = Math.cos(((double)lep.renderYawOffset * Math.PI) / 180D) * 0.35;
			}
			// --------------------------------------------
			
			setPosition(lep.posX + dx, posY, lep.posZ - dz);
			lastTickPosX = llpx;
			lastTickPosY = llpy;
			lastTickPosZ = llpz;
		} else {
			super.updateRidden();
		}
	}
	
	@Override
	public void updateRiderPosition() {
		super.updateRiderPosition();
	}

	@Override
	public float getSwingProgress(float par1) {
		for (SwingStatus lswing : mstatSwingStatus) {
			lswing.getSwingProgress(par1);
		}
		return getSwingStatusDominant().onGround;
	}

	
	public void setLooksWithInterest(boolean f) {
		if (looksWithInterest != f) {
			looksWithInterest = f;
			if (numTicksToChaseTarget <= 0) {
				looksWithInterestAXIS = rand.nextBoolean();
			}
			int li = dataWatcher.getWatchableObjectInt(dataWatch_Flags);
			li = looksWithInterest ? (li | dataWatch_Flags_looksWithInterest) : (li & ~dataWatch_Flags_looksWithInterest);
			li = looksWithInterestAXIS ? (li | dataWatch_Flags_looksWithInterestAXIS) : (li & ~dataWatch_Flags_looksWithInterestAXIS);
			dataWatcher.updateObject(dataWatch_Flags, Integer.valueOf(li));
		}
	}

	public boolean getLooksWithInterest() {
		looksWithInterest = (dataWatcher.getWatchableObjectInt(dataWatch_Flags) & dataWatch_Flags_looksWithInterest) > 0;
		looksWithInterestAXIS = (dataWatcher.getWatchableObjectInt(dataWatch_Flags) & dataWatch_Flags_looksWithInterestAXIS) > 0;

		return looksWithInterest;
	}

	public float getInterestedAngle(float f) {
		return (prevRotateAngleHead + (rotateAngleHead - prevRotateAngleHead) * f) * ((looksWithInterestAXIS ? 0.08F : -0.08F) * (float)Math.PI);
	}


	
//	@Override
	public boolean isBlocking() {
		return getSwingStatusDominant().isBlocking();
//		return maidAvatar.isBlocking();
	}

	@Override
	protected void damageArmor(float pDamage)
	{
		Debug.entity(String.format("Armor Damage being calculated" , this.getEntityId(), pDamage));
		maidInventory.damageArmor(pDamage);
		//maidAvatar.damageArmor(pDamage);
	}

	@Override
	public int getTotalArmorValue() {
		return maidAvatar.getTotalArmorValue();
	}

	@Override
	protected float applyArmorCalculations(DamageSource par1DamageSource, float par2)
	{
		return maidAvatar.applyArmorCalculations(par1DamageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource par1DamageSource, float par2) {
		return maidAvatar.applyPotionDamageCalculations(par1DamageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource par1DamageSource, float par2) {
		
		if (par1DamageSource == DamageSource.fall)
		{
			maidDamageSound = EnumSound.hurt_fall;
		}
		
		if(!par1DamageSource.isUnblockable() && isBlocking())
		{
//			par2 = (1.0F + par2) * 0.5F; //What is this for?
			Debug.entity(String.format("Blocking success ID:%d, %f -> %f" , this.getEntityId(), par2, (par2 = (1.0F + par2) * 0.5F)));
			maidDamageSound = EnumSound.hurt_guard;
		}
		
		float llasthealth = getHealth();
		if (par2 > 0 && getActiveModeClass() != null && !getActiveModeClass().damageEntity(maidMode, par1DamageSource, par2))
		{
			//maidAvatar.damageEntity(par1DamageSource, par2);
			super.damageEntity(par1DamageSource, par2);
			setMaidWait(false);
		}
		
		if (llasthealth == getHealth() && maidDamageSound == EnumSound.hurt)
		{
			maidDamageSound = EnumSound.hurt_nodamage;
		}
		Debug.entity(String.format("GetDamage ID:%d, %s, %f/ %f" , this.getEntityId(), par1DamageSource.damageType, llasthealth - getHealth(), par2));
		//super.damageEntity(par1DamageSource, par2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		Entity entity = par1DamageSource.getEntity();
		
		if(par1DamageSource.getDamageType().equalsIgnoreCase("thrown"))
		{
			if(entity!=null && this.maidAvatar!=null && entity.getEntityId()==this.maidAvatar.getEntityId())
			{
				return false;
			}
		}
		
		Debug.entity("LMM_EntityLittleMaid.attackEntityFrom "+this+"("+this.maidAvatar+") <= "+entity);
		
		
		maidDamageSound = EnumSound.hurt;
		if (par1DamageSource == DamageSource.inFire || par1DamageSource == DamageSource.onFire || par1DamageSource == DamageSource.lava) {
			maidDamageSound = EnumSound.hurt_fire;
		}
		for (ModeBase lm : maidEntityModeList) {
			float li = lm.attackEntityFrom(par1DamageSource, par2);
			if (li > 0) return li == 1 ? false : true;
		}
		
		setMaidWait(false);
		setMaidWaitCount(0);
		if (par2 > 0) {
			
			setPlayingRole(0);
			getNextEquipItem();
		}
		
		if(isContract() && (entity instanceof EntityLivingBase) || (entity instanceof EntityArrow)) {
			if(worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
				par2 = 0;
			}
			if(worldObj.difficultySetting == EnumDifficulty.EASY && par2 > 0) {
				par2 = par2 / 2 + 1;
			}
			if(worldObj.difficultySetting == EnumDifficulty.HARD) {
				par2 = (par2 * 3) / 2;
			}
		}
		
//		if (par2 == 0 && maidMode != mmode_Detonator) {
		if (par2 == 0) {
			
			if (maidDamageSound == EnumSound.hurt) {
				maidDamageSound = EnumSound.hurt_nodamage;
			}
			playSound(maidDamageSound, true);
			return false;
		}
		
		if(super.attackEntityFrom(par1DamageSource, par2)) {
			
			if (isContract() && entity != null) {
				if (getIFF(entity) && !isPlaying()) {
					fleeingTick = 0;
					return true;
				}
			} else if (maidInventory.getCurrentItem() == null) {
				return true;
			}
			fleeingTick = 0;
//			entityToAttack = entity;
			
			return true; 
		} else {
			return false;
		}
		
		
//		return maidAvatar.attackEntityFrom(par1DamageSource, par2);
	}

	
	public void usePotionTotarget(EntityLivingBase entityliving) {
		ItemStack itemstack = maidInventory.getCurrentItem();
		if (itemstack != null && itemstack.getItem() instanceof ItemPotion) {
			
			itemstack.stackSize--;
			List list = ((ItemPotion)itemstack.getItem()).getEffects(itemstack);
			if (list != null) {
				PotionEffect potioneffect;
				for (Iterator iterator = list.iterator(); iterator.hasNext(); entityliving.addPotionEffect(new PotionEffect(potioneffect))) {
					potioneffect = (PotionEffect)iterator.next();
				}
			}
			if(itemstack.stackSize <= 0) {
				maidInventory.setInventoryCurrentSlotContents(null);
			}
			maidInventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
		}
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		
		int k = rand.nextInt(3 + par2);
		for(int j = 0; j <= k; j++) {
			if(rand.nextInt(30) == 0) {
				dropItem(Items.slime_ball, 1);
			}
			if(rand.nextInt(50) == 0) {
				entityDropItem(new ItemStack(Items.dye, 1, 3), 0F);
			}
			dropItem(Items.sugar, 1);
		}
		
		
		maidInventory.dropAllItems();
	}

	@Override
	protected Item getDropItem() {
		return Items.sugar;
	}

	@Override
	public int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return experienceValue;
	}


	@Override
	public void applyEntityCollision(Entity par1Entity) {
		
		super.applyEntityCollision(par1Entity);
		
		if (par1Entity instanceof EntityLittleMaid) {
			if (((EntityLittleMaid)par1Entity).aiAvoidPlayer.isActive) {
				aiAvoidPlayer.isActive = true;
			}
		} else if (par1Entity == mstatMasterEntity) {
			aiAvoidPlayer.setActive();
		}
	}

	@Override
	protected void updateAITick() {

//		dataWatcher.updateObject(dataWatch_Health, Integer.valueOf(getHealth()));
		
		
		for (ModeBase ieml : maidEntityModeList) {
			ieml.updateAITick(getMaidModeInt());
		}
	}
	public void updateAITasks()
	{
		super.updateAITasks();
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
	}

	
	private boolean isBlockTranslucent(int par1, int par2, int par3) {
		return this.worldObj.getBlock(par1, par2, par3).isNormalCube();
	}

	
	@Override
	protected boolean func_145771_j(double par1, double par3, double par5)
	{
		return pushOutOfBlocks(par1, par3, par5);
	}
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		
		int var7 = MathHelper.floor_double(par1);
		int var8 = MathHelper.floor_double(par3);
		int var9 = MathHelper.floor_double(par5);
		double var10 = par1 - (double)var7;
		double var12 = par5 - (double)var9;
		
		boolean lflag = false;
		for (int li = 0; (float)li < height; li++) {
			lflag |= this.isBlockTranslucent(var7, var8 + li, var9);
		}
		if (lflag) {
			boolean var14 = !this.isBlockTranslucent(var7 - 1, var8, var9) && !this.isBlockTranslucent(var7 - 1, var8 + 1, var9);
			boolean var15 = !this.isBlockTranslucent(var7 + 1, var8, var9) && !this.isBlockTranslucent(var7 + 1, var8 + 1, var9);
			boolean var16 = !this.isBlockTranslucent(var7, var8, var9 - 1) && !this.isBlockTranslucent(var7, var8 + 1, var9 - 1);
			boolean var17 = !this.isBlockTranslucent(var7, var8, var9 + 1) && !this.isBlockTranslucent(var7, var8 + 1, var9 + 1);
			byte var18 = -1;
			double var19 = 9999.0D;
			
			if (var14 && var10 < var19) {
				var19 = var10;
				var18 = 0;
			}
			
			if (var15 && 1.0D - var10 < var19) {
				var19 = 1.0D - var10;
				var18 = 1;
			}
			
			if (var16 && var12 < var19) {
				var19 = var12;
				var18 = 4;
			}
			
			if (var17 && 1.0D - var12 < var19) {
				var19 = 1.0D - var12;
				var18 = 5;
			}
			
			float var21 = 0.1F;
			
			if (var18 == 0) {
				this.motionX = (double)(-var21);
			}
			
			if (var18 == 1) {
				this.motionX = (double)var21;
			}
			
			if (var18 == 4) {
				this.motionZ = (double)(-var21);
			}
			
			if (var18 == 5) {
				this.motionZ = (double)var21;
			}
			
			return !(var14 | var15 | var16 | var17);
		}
		
		return false;
	}

	@Override
	public void onLivingUpdate() {
		
		float lhealth = getHealth();
		if (lhealth > 0) {
			if (!worldObj.isRemote) {
				if (getSwingStatusDominant().canAttack()) {
					if (!isBloodsuck()) {
						
						if (lhealth < getMaxHealth()) {
							if (maidInventory.consumeInventoryItem(Items.sugar)) {
								eatSugar(true, false);
							}
						}
					}
				}
			}
		}
		
		super.onLivingUpdate();
		
		maidInventory.decrementAnimations();
		
		boolean grave = true;
		grave &= pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY, posZ + (double)width * 0.34999999999999998D);
		grave &= pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY, posZ - (double)width * 0.34999999999999998D);
		grave &= pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY, posZ - (double)width * 0.34999999999999998D);
		grave &= pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY, posZ + (double)width * 0.34999999999999998D);
		if (grave && onGround) {
			jump();
		}
		if(lhealth > 0) {
			
			
			if (!worldObj.isRemote) {
				List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(1.0D, 0.0D, 1.0D));
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Entity entity = (Entity)list.get(i);
						if (!entity.isDead) {
							if (entity instanceof EntityArrow) {
								
								((EntityArrow)entity).canBePickedUp = 1;
							}
							entity.onCollideWithPlayer(maidAvatar);
						}
					}
					
					if (entityToAttack instanceof EntityItem && maidInventory.getFirstEmptyStack() == -1) {
						setTarget(null);
					}
				}
			}
			
			
			if (isContractEX() && mstatClockMaid) {
				
				mstatTime = (int)(worldObj.getWorldTime() % 24000);
				if (mstatMasterEntity != null) {
					boolean b = mstatMasterEntity.isPlayerSleeping();
					
					if (mstatMasterDistanceSq < 25D && getEntitySenses().canSee(mstatMasterEntity))	{
						EnumSound lsound = EnumSound.Null;
						if (mstatFirstLook && (mstatTime > 23500 || mstatTime < 1500)) {
							lsound = EnumSound.goodmorning;
							mstatFirstLook = false;
						} 
						else if (!mstatFirstLook && b) {
							lsound = EnumSound.goodnight;
							mstatFirstLook = true;
						} 
						else if (mstatFirstLook && !b) {
							mstatFirstLook = false;
						}
						
						if (lsound != EnumSound.Null) {
							playSound(lsound, true);
							setLooksWithInterest(true);
						}
					} else {
						if (!mstatFirstLook && (b || (mstatTime > 18000 && mstatTime < 23500))) {
							mstatFirstLook = true;
						}
					}
				}
			} else {
				mstatTime = 6000;
			}
			
			// TNT-D System
			maidOverDriveTime.onUpdate();
			if (maidOverDriveTime.isDelay()) {
				for (int li = 0; li < mstatSwingStatus.length; li++) {
					mstatSwingStatus[li].attackTime--;
				}
				if (maidOverDriveTime.isEnable()) {
					worldObj.spawnParticle("reddust", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, 1.2D, 0.4D, 0.4D);
				}
				if (!worldObj.isRemote) {
					Entity lattackentity = getAttackTarget();
					if (lattackentity == null) {
						lattackentity = getEntityToAttack();
					}
					if (lattackentity != null) {
						PathEntity pe = worldObj.getPathEntityToEntity(this, lattackentity, 16F, true, false, false, true);
						
						if (pe != null) {
							pe.incrementPathIndex();
							if (!pe.isFinished()) {
								Vec3 v = pe.getPosition(this);
								setPosition(v.xCoord, v.yCoord, v.zCoord);
							}
						}
					}
				}
			}
			
			if (!worldObj.isRemote) {
				if (getSwingStatusDominant().canAttack()) {
//					mod_LMM_littleMaidMob.Debug("isRemort:" + worldObj.isRemote);
					
					if (getHealth() < getMaxHealth()) {
						if (maidInventory.consumeInventoryItem(Items.sugar)) {
							eatSugar(true, false);
						}
					}
					
					if (rand.nextInt(50000) == 0 && maidInventory.consumeInventoryItem(Items.sugar)) {
						eatSugar(true, false);
					}
					
					if (isContractEX()) {
						float f = getContractLimitDays();
						if (f <= 6 && maidInventory.consumeInventoryItem(Items.sugar)) {
							
							eatSugar(true, true);
						}
					}
				}
			}
		}
	}

	@Override
	public void onUpdate() {
		int litemuse = 0;
		
		
		
		if (firstload > 0) {
			
			
			if (--firstload == 0) {
				if (worldObj.isRemote) {
					Net.sendToEServer(this, new byte[] {Statics.LMN_Server_UpdateSlots, 0, 0, 0, 0});
				} else {
				}
			}
		}
		
		
		weaponFullAuto = false;
		weaponReload = false;
		
		
		mstatMasterEntity = getMaidMasterEntity();
		if (mstatMasterEntity != null) {
			mstatMasterDistanceSq = getDistanceSqToEntity(mstatMasterEntity);
		}
		
		textureData.onUpdate();
		
		if (worldObj.isRemote) {
			
			boolean lupd = false;
			lupd |= updateMaidContract();
			lupd |= updateMaidColor();
//			lupd |= updateTexturePack();
			updateTexturePack();
			if (lupd) {
				setTextureNames();
			}
			setMaidMode(dataWatcher.getWatchableObjectShort(dataWatch_Mode));
			setDominantArm(dataWatcher.getWatchableObjectByte(dataWatch_DominamtArm));
			updateMaidFlagsClient();
			updateGotcha();
			
			
			litemuse = dataWatcher.getWatchableObjectInt(dataWatch_ItemUse);
			for (int li = 0; li < mstatSwingStatus.length; li++) {
				ItemStack lis = mstatSwingStatus[li].getItemStack(this);
				if ((litemuse & (1 << li)) > 0 && lis != null) {
					mstatSwingStatus[li].setItemInUse(lis, lis.getMaxItemUseDuration(), this);
				} else {
					mstatSwingStatus[li].stopUsingItem(this);
				}
			}
		} else {
			boolean lf;
			
			updateRemainsContract();
			// Overdrive
			lf = maidOverDriveTime.isEnable();
			if (getMaidFlags(dataWatch_Flags_OverDrive) != lf) {
				if (lf) {
					playSound(EnumSound.TNT_D, true);
				}
				setMaidFlags(lf, dataWatch_Flags_OverDrive);
			}
			// Working!
			lf = mstatWorkingCount.isEnable();
			if (getMaidFlags(dataWatch_Flags_Working) != lf) {
				setMaidFlags(lf, dataWatch_Flags_Working);
			}
			
			if (!isContractEX() && !isFreedom()) {
				setFreedom(true);
				setMaidWait(false);
			}
			
			IAttributeInstance latt = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			
			latt.removeModifier(attCombatSpeed);
			if (isContract()) {
				if (!isFreedom() || (entityToAttack != null || getAttackTarget() != null)) {
					
					latt.applyModifier(attCombatSpeed);
				}
			}
			
			latt.removeModifier(attSneakingSpeed);
			if ((onGround && isSneaking()) || isUsingItem()) {
				latt.applyModifier(attSneakingSpeed);
			}
//			isSprinting()
		}
		
		
		for (ModeBase leb : maidEntityModeList) {
			leb.onUpdate(maidMode);
		}
		
		
		super.onUpdate();
		// SwingUpdate
		SwingStatus lmss1 = getSwingStatusDominant();
		prevSwingProgress = maidAvatar.prevSwingProgress = lmss1.prevSwingProgress;
		swingProgress = maidAvatar.swingProgress = lmss1.swingProgress;
		swingProgressInt = maidAvatar.swingProgressInt = lmss1.swingProgressInt;
		isSwingInProgress = maidAvatar.isSwingInProgress = lmss1.isSwingInProgress;
		
		
		if (maidAvatar != null) {
			maidAvatar.getValue();
			maidAvatar.onUpdate();
//			maidAvatar.setValue();
		}
		
		
		if (mstatWaitCount > 0) {
			if (hasPath()) {
				mstatWaitCount = 0;
			} else {
				mstatWaitCount--;
			}
		}
		if (maidSoundInterval > 0) {
			maidSoundInterval--;
		}
		
		
		prevRotateAngleHead = rotateAngleHead;
		if (getLooksWithInterest()) {
			rotateAngleHead = rotateAngleHead + (1.0F - rotateAngleHead) * 0.4F;
			numTicksToChaseTarget = 10;
		} else {
			rotateAngleHead = rotateAngleHead + (0.0F - rotateAngleHead) * 0.4F;
			if (numTicksToChaseTarget > 0) numTicksToChaseTarget--;
		}
		
		if (getAttackTarget() != null || getEntityToAttack() != null) {
			setWorking(true);
		}
		
		mstatWorkingCount.onUpdate();
		
		
		litemuse = 0;
		for (int li = 0; li < mstatSwingStatus.length; li++) {
			mstatSwingStatus[li].onUpdate(this);
			if (mstatSwingStatus[li].isUsingItem()) {
				litemuse |= (1 << li);
			}
		}
		
		SwingStatus lmss = getSwingStatusDominant();
		prevSwingProgress = maidAvatar.prevSwingProgress = lmss.prevSwingProgress;
		swingProgress = maidAvatar.swingProgress = lmss.swingProgress;
		swingProgressInt = maidAvatar.swingProgressInt = lmss.swingProgressInt;
		isSwingInProgress = maidAvatar.isSwingInProgress = lmss.isSwingInProgress;
		
		
		if (maidInventory.inventoryChanged) {
			onInventoryChanged();
			maidInventory.inventoryChanged = false;
		}
		if (!worldObj.isRemote) {
			
			
			dataWatcher.updateObject(dataWatch_ItemUse, litemuse);
			
//			if (!mstatOpenInventory) {
				for (int li = 0 ;li < maidInventory.getSizeInventory(); li++) {
					boolean lchange = false;
					int lselect = 0xff;
					
					for (int lj = 0; lj < mstatSwingStatus.length; lj++) {
						lchange = mstatSwingStatus[lj].checkChanged();
						if (mstatSwingStatus[lj].index == li) {
							lselect = lj;
						}
					}
					
					if (lchange || maidInventory.isChanged(li)) {
						((WorldServer)worldObj).getEntityTracker().func_151247_a(this, new S04PacketEntityEquipment(this.getEntityId(), (li | lselect << 8) + 5, maidInventory.getStackInSlot(li)));
						maidInventory.resetChanged(li);
						Debug.entity(String.format("ID:%d-%s - Slot(%x:%d-%d,%d) Update.", getEntityId(), worldObj.isRemote ? "Client" : "Server", lselect, li, mstatSwingStatus[0].index, mstatSwingStatus[1].index));
					}
//				}
			}
			
			
			mstatAimeBow &= !getSwingStatusDominant().canAttack();
			
			updateAimebow();
			
			// TODO:test
			if (dataWatcher.getWatchableObjectInt(dataWatch_ExpValue) != experienceValue) {
				dataWatcher.updateObject(dataWatch_ExpValue, Integer.valueOf(experienceValue));
			}
			
			
			if (riddenByEntity != null && !(riddenByEntity instanceof EntitySquid)) {
				if (height * width < riddenByEntity.height * riddenByEntity.width) {
					if (riddenByEntity instanceof EntityLivingBase) {
						attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)riddenByEntity), 0);
					}
					riddenByEntity.mountEntity(null);
					return;
				}
			}
			
			
			IAttributeInstance latt = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
			
			latt.removeModifier(attAxeAmp);
			ItemStack lis = getCurrentEquippedItem();
			if (lis != null && lis.getItem() instanceof ItemAxe) {
				
				latt.applyModifier(attAxeAmp);
			}
		} else {
			// Client
			// TODO:test
			experienceValue = dataWatcher.getWatchableObjectInt(dataWatch_ExpValue);
		}
		
		
		if(mstatgotcha != null) {
			double d = mstatgotcha.getDistanceSqToEntity(this);
			if (entityToAttack == null) {
				
				if (d > 4D) {
//					setPathToEntity(null);
					getNavigator().clearPathEntity();
					getLookHelper().setLookPositionWithEntity(mstatgotcha, 15F, 15F);
				}
				if (d > 12.25D) {
//					setPathToEntity(worldObj.getPathEntityToEntity(mstatgotcha, this, 16F, true, false, false, true));
					getNavigator().tryMoveToXYZ(mstatgotcha.posX, mstatgotcha.posY, mstatgotcha.posZ, 1.0F);
					getLookHelper().setLookPositionWithEntity(mstatgotcha, 15F, 15F);
				}
			}
			if (d > 25D) {
				double d1 = mstatgotcha.posX - posX;
				double d3 = mstatgotcha.posZ - posZ;
				double d5 = 0.125D / (Math.sqrt(d1 * d1 + d3 * d3) + 0.0625D);
				d1 *= d5;
				d3 *= d5;
				motionX += d1;
				motionZ += d3;
			}
			if (d > 42.25D) {
				double d2 = mstatgotcha.posX - posX;
				double d4 = mstatgotcha.posZ - posZ;
				double d6 = 0.0625D / (Math.sqrt(d2 * d2 + d4 * d4) + 0.0625D);
				d2 *= d6;
				d4 *= d6;
				mstatgotcha.motionX -= d2;
				mstatgotcha.motionZ -= d4;
			}
			if (d > 64D) {
				setGotcha(0);
				mstatgotcha = null;
				playSound("random.drr");
			}
			if(rand.nextInt(16) == 0) {
				List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(8D, 8D, 8D));
				for (int k = 0; k < list.size(); k++) {
					Entity entity = (Entity)list.get(k);
					if (!(entity instanceof EntityMob)) {
						continue;
					}
					EntityMob entitymob = (EntityMob)entity;
					if (entitymob.getEntityToAttack() == mstatgotcha) {
						entitymob.setTarget(this);
					}
				}
			}
		}
		
	}


	@Override
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
		
		
		if (!worldObj.isRemote) {
			
			if (Config.DeathMessage && mstatMasterEntity != null) {
				String ls = par1DamageSource.getDamageType();
				Entity lentity = par1DamageSource.getEntity();
				if (lentity != null) {
					if (par1DamageSource.getEntity() instanceof EntityPlayer) {
						ls += ":" + Helper.getPlayerName((EntityPlayer)lentity);  
					} else {
						String lt = EntityList.getEntityString(lentity);
						if (lt != null) {
							ls += ":" + lt;
						}
					}
				}
				
				
				// http://forum.minecraftuser.jp/viewtopic.php?f=13&t=23347&p=212078#p211805
				String lt = func_145748_c_().getUnformattedTextForChat();

				ChatComponentText text = new ChatComponentText(String.format("Your maid %s was killed by %s", lt, ls));
				mstatMasterEntity.addChatMessage(text);
			}
		}
	}

	
	@Override
	protected void onNewPotionEffect(PotionEffect par1PotionEffect) {
		super.onNewPotionEffect(par1PotionEffect);
		if (mstatMasterEntity instanceof EntityPlayerMP) {
			((EntityPlayerMP)mstatMasterEntity).playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.getEntityId(), par1PotionEffect));
		}
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect par1PotionEffect, boolean par2) {
		super.onChangedPotionEffect(par1PotionEffect, par2);
		
//		if (mstatMasterEntity instanceof EntityPlayerMP) {
//			((EntityPlayerMP)mstatMasterEntity).playerNetServerHandler.sendPacketToPlayer(new Packet41EntityEffect(this.getEntityId(), par1PotionEffect));
//		}
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect par1PotionEffect) {
		super.onFinishedPotionEffect(par1PotionEffect);
		if (mstatMasterEntity instanceof EntityPlayerMP) {
			((EntityPlayerMP)mstatMasterEntity).playerNetServerHandler.sendPacket(new S1EPacketRemoveEntityEffect(this.getEntityId(), par1PotionEffect));
		}
	}



	
	public void onInventoryChanged() {
		checkClockMaid();
		checkMaskedMaid();
		checkHeadMount();
		getNextEquipItem();
//		setArmorTextureValue();
	}

	
	public boolean getNextEquipItem() {
		if (worldObj.isRemote) {
			
			return false;
		}
		
		int li;
		if (isActiveModeClass()) {
			li = getActiveModeClass().getNextEquipItem(maidMode);
		} else {
			li = -1;
		}
		setEquipItem(maidDominantArm, li);
		return li > -1; 
	}

	public void setEquipItem(int pArm, int pIndex) {
		if (pArm == maidDominantArm) {
			maidInventory.currentItem = pIndex;
		}
		int li = mstatSwingStatus[pArm].index;
		if (li != pIndex) {
			if (li > -1) {
				maidInventory.setChanged(li);
			}
			if (pIndex > -1) {
				maidInventory.setChanged(pIndex);
			}
			mstatSwingStatus[pArm].setSlotIndex(pIndex);
		}
	}
	public void setEquipItem(int pIndex) {
		setEquipItem(maidDominantArm, pIndex);
	}


	
	public void getWeaponStatus() {
		
		ItemStack is = maidInventory.getCurrentItem();
		if (is == null) return;
		
		try {
			Method me = is.getItem().getClass().getMethod("isWeaponReload", ItemStack.class, EntityPlayer.class);
			weaponReload = (Boolean)me.invoke(is.getItem(), is, maidAvatar);
		}
		catch (NoSuchMethodException e) {
		}
		catch (Exception e) {
		}
		
		try {
			Method me = is.getItem().getClass().getMethod("isWeaponFullAuto", ItemStack.class);
			weaponFullAuto = (Boolean)me.invoke(is.getItem(), is);
		}
		catch (NoSuchMethodException e) {
		}
		catch (Exception e) {
		}
	}

	

	
	public ItemStack getCurrentEquippedItem() {
		return maidInventory.getCurrentItem();
	}
	@Override
	public ItemStack getHeldItem() {
		return maidInventory.getCurrentItem();
	}

	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		if (par1 == 0) {
			return getHeldItem();
		} else if (par1 < 5) {
			return maidInventory.armorItemInSlot(par1 - 1);
		} else {
			return maidInventory.getStackInSlot(par1 - 5);
		}
	}

	@Override
	public ItemStack func_130225_q(int par1) {
		return maidInventory.armorItemInSlot(par1);
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		par1 &= 0x0000ffff;
		if (par1 == 0) {
			maidInventory.setInventoryCurrentSlotContents(par2ItemStack);
		} else if (par1 > 0 && par1 < 4) {
			maidInventory.armorInventory[par1 - 1] = par2ItemStack;
			setTextureNames();
		} else if (par1 == 4) {
//			maidInventory.mainInventory[mstatMaskSelect] = mstatMaskSelect > -1 ? par2ItemStack : null;
			if (mstatMaskSelect > -1) {
				maidInventory.mainInventory[mstatMaskSelect] = par2ItemStack;
			}
			setTextureNames();
		} else {
			par1 -= 5;
			
			
			
			int lslotindex = par1 & 0x7f;
			int lequip = (par1 >>> 8) & 0xff;
			maidInventory.setInventorySlotContents(lslotindex, par2ItemStack);
			maidInventory.resetChanged(lslotindex);	
			maidInventory.inventoryChanged = true;
//			if (par1 >= maidInventory.mainInventory.length) {
//				LMM_Client.setArmorTextureValue(this);
//			}

			for (SwingStatus lss: mstatSwingStatus) {
				if (lslotindex == lss.index) {
					lss.index = -1;
				}
			}
			if (lequip != 0xff) {
				setEquipItem(lequip, lslotindex);
//				mstatSwingStatus[lequip].index = lslotindex;
			}
			if (lslotindex >= maidInventory.maxInventorySize) {
				setTextureNames();
			}
			String s = par2ItemStack == null ? null : par2ItemStack.getDisplayName();
			Debug.entity(String.format("ID:%d Slot(%2d:%d):%s", getEntityId(), lslotindex, lequip, s == null ? "NoItem" : s));
		}
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return maidInventory.armorInventory;
	}

	protected void checkClockMaid() {
		
		mstatClockMaid = maidInventory.getInventorySlotContainItem(Items.clock) > -1;
	}
	
	public boolean isClockMaid() {
		return mstatClockMaid;
	}

	protected void checkMaskedMaid() {
		
		for (int i = maidInventory.mainInventory.length - 1; i >= 0; i--) {
			ItemStack is = maidInventory.getStackInSlot(i);
			if (is != null && is.getItem() instanceof ItemArmor && ((ItemArmor)is.getItem()).armorType == 0) {
				
				mstatMaskSelect = i;
				maidInventory.armorInventory[3] = is;
				if (worldObj.isRemote) {
					setTextureNames();
				}
				return;
			}
		}
		
		mstatMaskSelect = -1;
		maidInventory.armorInventory[3] = null;
		return;
	}
	
	public boolean isMaskedMaid() {
		return mstatMaskSelect > -1;
	}

	protected void checkHeadMount() {
		
		ItemStack lis = maidInventory.getHeadMount();
		mstatPlanter = false;
		mstatCamouflage = false;
		if (lis != null) {
			if (lis.getItem() instanceof ItemBlock) {
				Block lblock = Block.getBlockFromItem(lis.getItem());
//				mstatPlanter =	(lblock instanceof BlockFlower      && lblock.getRenderType() ==  1) ||
				mstatPlanter =	(lblock.getRenderType() ==  1) ||
								(lblock instanceof BlockDoublePlant && lblock.getRenderType() == 40);
				mstatCamouflage = (lblock instanceof BlockLeaves) || (lblock instanceof BlockPumpkin) || (lblock instanceof BlockStainedGlass);
			} else if (lis.getItem() instanceof ItemSkull) {
				mstatCamouflage = true;
			}
		}		
	}
	
	public boolean isCamouflage() {
		return mstatCamouflage;
	}
	
	public boolean isPlanter() {
		return mstatPlanter;
	}

	
	public int getSwingSpeedModifier() {
		if (isPotionActive(Potion.digSpeed)) {
			return 6 - (1 + getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1;
		}
		
		if (isPotionActive(Potion.digSlowdown)) {
			return 6 + (1 + getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2;
		} else {
			return 6;
		}
	}

	
	public void destroyCurrentEquippedItem() {
		maidInventory.setInventoryCurrentSlotContents(null);
	}

	
	public void displayGUIMaidInventory(EntityPlayer pEntityPlayer) {
		if (!worldObj.isRemote) {
			GuiCommonHandler.maidServer = this;
			pEntityPlayer.openGui(LittleMaidMobX.instance, GuiCommonHandler.GUI_ID_INVVENTORY, this.worldObj,
					(int)this.posX, (int)this.posY, (int)this.posZ);
//			System.out.println("Texture: " + textureData.getTextureName(0));
//			System.out.println("Inv dump:");
//			
//			ItemStack stack;
//			for(int i=0;i<maidInventory.getSizeInventory();i++) {
//				stack = maidInventory.getStackInSlot(i);
//				System.out.println("\t" + i + ": " + (stack == null ? "empty" : stack.getDisplayName()));
//			}
			
		}
		else
		{
			GuiCommonHandler.maidClient = this;
		}
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		Debug.entity(this.worldObj.isRemote, "LMM_EntityLittleMaid.interact:"+par1EntityPlayer.getGameProfile().getName());
		float lhealth = getHealth();
		ItemStack itemstack1 = par1EntityPlayer.getCurrentEquippedItem();
		
		
		for (int li = 0; li < maidEntityModeList.size(); li++) {
			if (maidEntityModeList.get(li).preInteract(par1EntityPlayer, itemstack1)) {
				return true;
			}
		}
		
		if (par1EntityPlayer.isSneaking()) {
			return false;
		}
		
		if (lhealth > 0F && par1EntityPlayer.riddenByEntity != null && !(par1EntityPlayer.riddenByEntity instanceof EntityLittleMaid)) {
			
			par1EntityPlayer.riddenByEntity.mountEntity(this);
			return true;
		}
		
		
		
		if (mstatgotcha == null && par1EntityPlayer.fishEntity == null) {
			if(itemstack1 != null && itemstack1.getItem() == Items.string) {
				
				setGotcha(par1EntityPlayer.getEntityId());
				mstatgotcha = par1EntityPlayer;
				Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
				playSound("random.pop");
				return true;
			} 
			
			if (isContract()) {
				
				if (lhealth > 0F && isMaidContractOwner(par1EntityPlayer)) {
					if (itemstack1 != null) {
						
						setPathToEntity(null);
						
						for (int li = 0; li < maidEntityModeList.size(); li++) {
							if (maidEntityModeList.get(li).interact(par1EntityPlayer, itemstack1)) {
								return true;
							}
						}
						if (isRemainsContract()) {
							
							if (itemstack1.getItem() == Items.sugar) {
								
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								eatSugar(false, true);
								worldObj.setEntityState(this, (byte)11);
								
								Debug.entity("give suger." + worldObj.isRemote);
								if (!worldObj.isRemote) {
									setFreedom(isFreedom());
									if (isMaidWait()) {
										
										boolean lflag = false;
										setActiveModeClass(null);
										for (int li = 0; li < maidEntityModeList.size() && !lflag; li++) {
											lflag = maidEntityModeList.get(li).changeMode(par1EntityPlayer);
											if (lflag) {
												setActiveModeClass(maidEntityModeList.get(li));
											}
										}
										if (!lflag) {
											setMaidMode("Escorter");
											setEquipItem(-1);
//											maidInventory.currentItem = -1;
										}
										setMaidWait(false);
										getNextEquipItem();
									} else {
										
										setMaidWait(true);
									}
								}
								return true;
							}
							else if (itemstack1.getItem() == Items.dye) {
								
								if (!worldObj.isRemote) {
									setColor(15 - itemstack1.getItemDamage());
								}
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								return true;
							}
							else if (itemstack1.getItem() == Items.feather) {
								
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								setFreedom(!isFreedom());
								worldObj.setEntityState(this, isFreedom() ? (byte)12 : (byte)13);
								return true;
							}
							else if (itemstack1.getItem() == Items.saddle) {
								
								if (!worldObj.isRemote) {
									if (ridingEntity == par1EntityPlayer) {
										this.mountEntity(null);
									} else {
										this.mountEntity(par1EntityPlayer);
									}
									return true;
								}
							}
							else if (itemstack1.getItem() == Items.gunpowder) {
								// test TNT-D
//								playSound(LMM_EnumSound.eatGunpowder, false);
								maidOverDriveTime.setValue(itemstack1.stackSize * 10);
								Helper.decPlayerInventory(par1EntityPlayer, -1, itemstack1.stackSize);
								return true;
							}
							else if (itemstack1.getItem() == Items.book) {
								
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								if (worldObj.isRemote) {
									par1EntityPlayer.openGui(LittleMaidMobX.instance,
											GuiCommonHandler.GUI_ID_IFF,
											this.worldObj,
											(int)this.posX,
											(int)this.posY,
											(int)this.posZ);
								}
								return true;
							}
							else if ((itemstack1.getItem() == Items.glass_bottle) && (experienceValue >= 5)) {
								
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								if (!worldObj.isRemote) {
									entityDropItem(new ItemStack(Items.experience_bottle), 0.5F);
									experienceValue -= 5;
									if (maidAvatar != null) {
										maidAvatar.experienceTotal -= 5;
									}
								}
								return true;
							}
							else if (itemstack1.getItem() instanceof ItemPotion) {
								
								if(!worldObj.isRemote) {
									List list = ((ItemPotion)itemstack1.getItem()).getEffects(itemstack1);
									if (list != null) {
										PotionEffect potioneffect;
										for (Iterator iterator = list.iterator(); iterator.hasNext(); addPotionEffect(new PotionEffect(potioneffect))) {
											potioneffect = (PotionEffect)iterator.next();
										}
									}
								}
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								return true;
							}
							else if (isFreedom() && itemstack1.getItem() == Items.redstone) {
								// Tracer
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								setPathToEntity(null);
								setMaidWait(false);
								setTracer(!isTracer());
								if (isTracer()) {
									worldObj.setEntityState(this, (byte)14);
								} else {
									worldObj.setEntityState(this, (byte)12);
								}
								
								return true;
							}
						} else {
							
							if (itemstack1.getItem() == Items.sugar) {
								
								worldObj.setEntityState(this, (byte)10);
								return true;
							} else if (itemstack1.getItem() == Items.cake) {
								
								Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
								maidContractLimit = (24000 * 7);
								setFreedom(false);
								setTracer(false);
								setMaidWait(false);
								setMaidMode("Escorter");
								worldObj.setEntityState(this, (byte)11);
								playSound(EnumSound.Recontract, true);
								return true;
							}
						}
					}
					
					MinecraftWrapper.setOwner(this, Helper.getPlayerName(par1EntityPlayer));
					getNavigator().clearPathEntity();
					isJumping = false;
					displayGUIMaidInventory(par1EntityPlayer);
					return true;
				}
			} else {
				
				if (itemstack1 != null) {
					if (itemstack1.getItem() == Items.cake) {
						
						Helper.decPlayerInventory(par1EntityPlayer, -1, 1);
						
						deathTime = 0;
						if (!worldObj.isRemote) {
							if (LittleMaidMobX.ac_Contract != null) {
								par1EntityPlayer.triggerAchievement(LittleMaidMobX.ac_Contract);
							}
							setContract(true);
							MinecraftWrapper.setOwner(this, Helper.getPlayerName(par1EntityPlayer));
							setHealth(20);
							setMaidMode("Escorter");
							setMaidWait(false);
							setFreedom(false);
							playSound(EnumSound.getCake, true);
//							playLittleMaidSound(LMM_EnumSound.getCake, true);
//							playTameEffect(true);
							worldObj.setEntityState(this, (byte)7);
							
							maidContractLimit = (24000 * 7);
							maidAnniversary = worldObj.getTotalWorldTime();
							
//							LMM_Net.sendToAllEClient(this, new byte[] {LMM_Net.LMN_Client_UpdateTexture, 0, 0, 0, 0});
							
						}
						return true;
					} else {
//						worldObj.setEntityState(this, (byte)6);
					}
				}
			}
		} else if (lhealth > 0F && mstatgotcha != null) {
			if (!worldObj.isRemote) {
				EntityItem entityitem = new EntityItem(worldObj, mstatgotcha.posX, mstatgotcha.posY, mstatgotcha.posZ, new ItemStack(Items.string));
				worldObj.spawnEntityInWorld(entityitem);
				setGotcha(0);
				mstatgotcha = null;
			}
			return true;
		} 
		
		return false;
	}

	
	@Override
	public boolean isTamed() {
		return isContract();
	}
	public boolean isContract() {
//		return worldObj.isRemote ? maidContract : super.isTamed();
		return super.isTamed();
	}
	public boolean isContractEX() {
		return isContract() && isRemainsContract();
	}

	@Override
	public void setTamed(boolean par1) {
		setContract(par1);
	}
	@Override
	public void setContract(boolean flag) {
		super.setTamed(flag);
		textureData.setContract(flag);
		if (flag) {
//			maidMode = mmode_Escorter;
		} else {
		}
	}

	
	protected void updateRemainsContract() {
		boolean lflag = false;
		if (maidContractLimit > 0) {
			maidContractLimit--;
			lflag = true;
		}
		if (getMaidFlags(dataWatch_Flags_remainsContract) != lflag) {
			setMaidFlags(lflag, dataWatch_Flags_remainsContract);
		}
	}
	
	public boolean isRemainsContract() {
		return getMaidFlags(dataWatch_Flags_remainsContract);
	}

	public float getContractLimitDays() {
		return maidContractLimit > 0 ? ((float)maidContractLimit / 24000F) : -1F;
	}

	public boolean updateMaidContract() {
		
		boolean lf = isContract();
		if (textureData.isContract() != lf) {
			textureData.setContract(lf);
			return true;
		}
		return false;
	}

	@Override
	public EntityLivingBase getOwner() {
		return getMaidMasterEntity();
	}
	public String getMaidMaster() {
		return MinecraftWrapper.getOwnerName(this);
	}

	public EntityPlayer getMaidMasterEntity() {
		
		if (isContract()) {
			EntityPlayer entityplayer = mstatMasterEntity;
			if (mstatMasterEntity == null || mstatMasterEntity.isDead) {
				String lname; 
				

				
				EntityPlayer clientPlayer = LittleMaidMobX.proxy.getClientPlayer();

				if (!LittleMaidMobX.proxy.isSinglePlayer()
						|| Config.checkOwnerName 
						|| clientPlayer == null) {
					lname = getMaidMaster();
				} else {
					lname = Helper.getPlayerName(clientPlayer);
				}
				entityplayer = worldObj.getPlayerEntityByName(lname);
				
				
//				maidAvatar.username = lname;
				
				if (entityplayer != null && maidAvatar != null) {
					maidAvatar.capabilities.isCreativeMode = entityplayer.capabilities.isCreativeMode;
				}
				
			}
			return entityplayer;
		} else {
			return null;
		}
	}

	public boolean isMaidContractOwner(String pname) {
		return pname.equalsIgnoreCase(Helper.getPlayerName(mstatMasterEntity));
	}

	public boolean isMaidContractOwner(EntityPlayer pentity) {
		return pentity == getMaidMasterEntity();
		
//		return pentity == mstatMasterEntity;
	}

	
	public boolean isMaidWait() {
		return maidWait;
	}

	public boolean isMaidWaitEx() {
		return isMaidWait() | (mstatWaitCount > 0) | isOpenInventory();
	}

	public void setMaidWait(boolean pflag) {
		
		maidWait = pflag;
		setMaidFlags(pflag, dataWatch_Flags_Wait);
		
		aiSit.setSitting(pflag);
		maidWait = pflag;
		isJumping = false;
		setAttackTarget(null);
		setRevengeTarget(null);
		setPathToEntity(null);
		getNavigator().clearPathEntity();
		velocityChanged = true;
		setFreedom(false);
	}

	public void setMaidWaitCount(int count) {
		mstatWaitCount = count;
	}

	
	
	
	public void setOpenInventory(boolean flag) {
		mstatOpenInventory = flag;
	}

	public boolean isOpenInventory() {
		return mstatOpenInventory;
	}

	
	public void onGuiOpened() {
		setOpenInventory(true);
	}

	
	public void onGuiClosed() {
		setOpenInventory(false);
		int li = maidMode & 0x0080;
		setMaidWaitCount((li == 0) ? 50 : 0);
	}

	
	public void setSwing(int attacktime, EnumSound enumsound) {
		setSwing(attacktime, enumsound, maidDominantArm);
	}
	public void setSwing(int pattacktime, EnumSound enumsound, int pArm) {
		mstatSwingStatus[pArm].attackTime = pattacktime;
//		maidAttackSound = enumsound;

		if (!weaponFullAuto) {
			setSwinging(pArm, enumsound);
		}
		if (!worldObj.isRemote) {
			byte[] lba = new byte[] {
				Statics.LMN_Client_SwingArm,
				0, 0, 0, 0,
				(byte)pArm,
				0, 0, 0, 0
			};
			Helper.setInt(lba, 6, enumsound.index);
			Net.sendToAllEClient(this, lba);
		}
	}

	public void setSwinging(EnumSound pSound) {
		setSwinging(maidDominantArm, pSound);
	}
	public void setSwinging(int pArm, EnumSound pSound) {
		if (mstatSwingStatus[pArm].setSwinging()) {
			playLittleMaidSound(pSound, true);
			maidAvatar.swingProgressInt = -1;
//			maidAvatar.swingProgressInt = -1;
			maidAvatar.isSwingInProgress = true;
		}
	}

	public boolean getSwinging() {
		return getSwinging(maidDominantArm);
	}
	public boolean getSwinging(int pArm) {
		return mstatSwingStatus[pArm].isSwingInProgress;
	}

	
	public SwingStatus getSwingStatusDominant() {
		return mstatSwingStatus[maidDominantArm];
	}

	public SwingStatus getSwingStatus(int pindex) {
		return mstatSwingStatus[pindex];
	}


	
	public void setBloodsuck(boolean pFlag) {
		mstatBloodsuck = pFlag;
		setMaidFlags(pFlag, dataWatch_Flags_Bloodsuck);
	}

	public boolean isBloodsuck() {
		return mstatBloodsuck;
	}


	
	public void setLookSuger(boolean pFlag) {
		mstatLookSuger = pFlag;
		setMaidFlags(pFlag, dataWatch_Flags_LooksSugar);
	}

	public boolean isLookSuger() {
		return mstatLookSuger;
	}

	
	public void eatSugar(boolean motion, boolean recontract) {
		if (motion) {
			setSwing(2, (getMaxHealth() - getHealth() <= 1F) ?  EnumSound.eatSugar_MaxPower : EnumSound.eatSugar);
		}
		int h = hurtResistantTime;
		heal(1);
		hurtResistantTime = h;
		playSound("random.pop");
		Debug.entity(("eat Suger." + worldObj.isRemote));
		
		if (recontract) {
			
			maidContractLimit += 24000;
			if (maidContractLimit > 168000) {
				maidContractLimit = 168000;	// 24000 * 7
			}
		}
		
		
		if (maidAvatar != null) {
			maidAvatar.getFoodStats().addStats(20, 20F);
		}
	}


	
	
	public void setWorking(boolean pFlag) {
		mstatWorkingCount.setEnable(pFlag);
	}
	
	
	public boolean isWorking() {
		return mstatWorkingCount.isEnable();
	}

	
	public boolean isWorkingDelay() {
		return mstatWorkingCount.isDelay();
	}

	
	public void setTracer(boolean pFlag) {
		maidTracer = pFlag;
		setMaidFlags(pFlag, dataWatch_Flags_Tracer);
		if (maidTracer) {
			setFreedom(true);
		}
		aiTracer.setEnable(pFlag);
	}

	
	public boolean isTracer() {
		return maidTracer;
	}


	
	public void setPlayingRole(int pValue) {
		if (mstatPlayingRole != pValue) {
			mstatPlayingRole = pValue;
			if (pValue == 0) {
				setAttackTarget(null);
				setMaidMode(mstatWorkingInt , true);
			} else {
				setMaidMode(0x00ff, true);
			}
		}
	}

	public int getPlayingRole() {
		return mstatPlayingRole;
	}

	public boolean isPlaying() {
		return mstatPlayingRole != 0;
	}


	
	public void setFreedom(boolean pFlag) {
		
		maidFreedom = pFlag;
		aiRestrictRain.setEnable(pFlag);
		aiFleeRain.setEnable(pFlag);
		aiWander.setEnable(pFlag);
//		aiJumpTo.setEnable(!pFlag);
		aiAvoidPlayer.setEnable(!pFlag);
		aiFollow.setEnable(!pFlag);
		aiTracer.setEnable(false);
//		setAIMoveSpeed(pFlag ? moveSpeed_Nomal : moveSpeed_Max);
//		setMoveForward(0.0F);
		
		if (maidFreedom && isContract()) {
			setHomeArea(
//			setHomeArea(
					MathHelper.floor_double(posX),
					MathHelper.floor_double(posY),
					MathHelper.floor_double(posZ), 16);
		} else {
			detachHome();
			setPlayingRole(0);
		}
		
		setMaidFlags(maidFreedom, dataWatch_Flags_Freedom);
	}

	public boolean isFreedom() {
		return maidFreedom;
	}


	
	public boolean sendTextureToServer() {
		
		ModelManager.instance.postSetTexturePack(this, textureData.getColor(), textureData.getTextureBox());
		return true;
	}


	public boolean updateTexturePack() {
		
		
		boolean lflag = false;
		TextureBoxServer lbox;
		
		int ltexture = dataWatcher.getWatchableObjectInt(dataWatch_Texture);
		int larmor = (ltexture >>> 16) & 0xffff;
		ltexture &= 0xffff;
		if (textureData.textureIndex[0] != ltexture) {
			textureData.textureIndex[0] = ltexture;
			lflag = true;
		}
		if (textureData.textureIndex[1] != larmor) {
			textureData.textureIndex[1] = larmor;
			lflag = true;
		}
		if (lflag) {
			ModelManager.instance.postGetTexturePack(this, textureData.getTextureIndex());
		}
		return lflag;
	}

	@Override
	public int getColor() {
//		return textureData.getColor();
		return dataWatcher.getWatchableObjectByte(dataWatch_Color);
	}

	@Override
	public void setColor(int index) {
		textureData.setColor(index);
		dataWatcher.updateObject(dataWatch_Color, (byte)index);
	}

	public boolean updateMaidColor() {
		
		int lc = getColor();
		if (textureData.getColor() != lc) {
			textureData.setColor(lc);
			return true;
		}
		return false;
	}

	
	public void updateGotcha() {
		int lid = dataWatcher.getWatchableObjectInt(dataWatch_Gotcha);
		if (lid == 0) {
			mstatgotcha = null;
			return;
		}
		if (mstatgotcha != null && mstatgotcha.getEntityId() == lid) {
			return;
		}
		for (int li = 0; li < worldObj.loadedEntityList.size(); li++) {
			if (((Entity)worldObj.loadedEntityList.get(li)).getEntityId() == lid) {
				mstatgotcha = (Entity)worldObj.loadedEntityList.get(li);
				break;
			}
		}
	}

	public void setGotcha(int pEntityID) {
		dataWatcher.updateObject(dataWatch_Gotcha, Integer.valueOf(pEntityID));
	}
	public void setGotcha(Entity pEntity) {
		setGotcha(pEntity == null ? 0 : pEntity.getEntityId());
	}


	
	public void updateAimebow() {
		boolean lflag = (maidAvatar != null && maidAvatar.isUsingItemLittleMaid()) || mstatAimeBow;
		setMaidFlags(lflag, dataWatch_Flags_Aimebow);
	}

	public boolean isAimebow() {
		return (dataWatcher.getWatchableObjectInt(dataWatch_Flags) & dataWatch_Flags_Aimebow) > 0;
	}


	
	public void updateMaidFlagsClient() {
		int li = dataWatcher.getWatchableObjectInt(dataWatch_Flags);
		maidFreedom = (li & dataWatch_Flags_Freedom) > 0;
		maidTracer = (li & dataWatch_Flags_Tracer) > 0;
		maidWait = (li & dataWatch_Flags_Wait) > 0;
		mstatAimeBow = (li & dataWatch_Flags_Aimebow) > 0;
		mstatLookSuger = (li & dataWatch_Flags_LooksSugar) > 0;
		mstatBloodsuck = (li & dataWatch_Flags_Bloodsuck) > 0;
		looksWithInterest = (li & dataWatch_Flags_looksWithInterest) > 0;
		looksWithInterestAXIS = (li & dataWatch_Flags_looksWithInterestAXIS) > 0;
		maidOverDriveTime.updateClient((li & dataWatch_Flags_OverDrive) > 0);
		mstatWorkingCount.updateClient((li & dataWatch_Flags_Working) > 0);
	}

	
	public void setMaidFlags(boolean pFlag, int pFlagvalue) {
		int li = dataWatcher.getWatchableObjectInt(dataWatch_Flags);
		li = pFlag ? (li | pFlagvalue) : (li & ~pFlagvalue);
		dataWatcher.updateObject(dataWatch_Flags, Integer.valueOf(li));
	}

	
	public boolean getMaidFlags(int pFlagvalue) {
		return (dataWatcher.getWatchableObjectInt(dataWatch_Flags) & pFlagvalue) > 0;
	}

	
	public void setDominantArm(int pindex) {
		if (mstatSwingStatus.length <= pindex) return;
		if (maidDominantArm == pindex) return;
		for (SwingStatus lss : mstatSwingStatus) {
			lss.index = lss.lastIndex = -1;
		}
		maidDominantArm = pindex;
		dataWatcher.updateObject(dataWatch_DominamtArm, (byte)maidDominantArm);
		Debug.entity("Change Dominant.");
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		homeWorld = dimension;
		super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public void setTexturePackIndex(int pColor, int[] pIndex) {
		// Server
		textureData.setTexturePackIndex(pColor, pIndex);
		dataWatcher.updateObject(dataWatch_Texture, ((textureData.textureIndex[0] & 0xffff) | (textureData.textureIndex[1] & 0xffff) << 16));
		Debug.texture("changeSize-ID:%d: %f, %f, %b", getEntityId(), width, height, worldObj.isRemote);
		setColor(pColor);
		setTextureNames();
	}

	@Override
	public void setTexturePackName(TextureBox[] pTextureBox) {
		// Client
		textureData.setTexturePackName(pTextureBox);
		setTextureNames();
		Debug.texture("ID:%d, TextureModel:%s", getEntityId(), textureData.getTextureName(0));
		
		((TextureBox)textureData.textureBox[0]).models[0].setCapsValue(IModelCaps.caps_changeModel, maidCaps);
		
//		for (Entry<String, MMM_EquippedStabilizer> le : pEntity.maidStabilizer.entrySet()) {
//			if (le.getValue() != null) {
//				le.getValue().updateEquippedPoint(pEntity.textureModel0);
//			}
//		}
//		maidSoundRate = LMM_SoundManager.getSoundRate(textureData.getTextureName(0), getColor());

	}

	
	public void setTextureNames() {
		if (!textureData.setTextureNames()) {
			// TODO:setDefaultTexture
//			if (worldObj.isRemote) {
				setNextTexturePackage(0);
//			}
		}
	}

	public void setNextTexturePackage(int pTargetTexture) {
		textureData.setNextTexturePackage(pTargetTexture);
	}

	public void setPrevTexturePackege(int pTargetTexture) {
		textureData.setPrevTexturePackege(pTargetTexture);
	}


	// textureEntity

	@Override
	public void setTextureBox(TextureBoxBase[] pTextureBox) {
		textureData.setTextureBox(pTextureBox);
	}

	@Override
	public TextureBoxBase[] getTextureBox() {
		return textureData.getTextureBox();
	}

	@Override
	public void setTextureIndex(int[] pTextureIndex) {
		textureData.setTextureIndex(pTextureIndex);
	}

	@Override
	public int[] getTextureIndex() {
		return textureData.getTextureIndex();
	}

	@Override
	public void setTextures(int pIndex, ResourceLocation[] pNames) {
		textureData.setTextures(pIndex, pNames);
	}

	@Override
	public ResourceLocation[] getTextures(int pIndex) {
		return textureData.getTextures(pIndex);
	}

	@Override
	public TextureData getTextureData() {
		return textureData;
	}

	

	
	public boolean isUsingTile(TileEntity pTile) {
		if (isActiveModeClass()) {
			return getActiveModeClass().isUsingTile(pTile);
		}
		for (int li = 0; li < maidTiles.length; li++) {
			if (maidTiles[li] != null &&
					pTile.xCoord == maidTiles[li][0] &&
					pTile.yCoord == maidTiles[li][1] &&
					pTile.zCoord == maidTiles[li][2]) {
				return true;
			}
		}
		return false;
	}

	public boolean isEqualTile() {
		return worldObj.getTileEntity(maidTile[0], maidTile[1], maidTile[2]) == maidTileEntity;
	}

	public boolean isTilePos() {
		return maidTileEntity != null;
	}
	public boolean isTilePos(int pIndex) {
		if (pIndex < maidTiles.length) {
			return maidTiles[pIndex] != null;
		}
		return false;
	}

	
	public boolean getTilePos(int pIndex) {
		if (pIndex < maidTiles.length && maidTiles[pIndex] != null) {
			maidTile[0] = maidTiles[pIndex][0];
			maidTile[1] = maidTiles[pIndex][1];
			maidTile[2] = maidTiles[pIndex][2];
			return true;
		}
		return false;
	}

	public void setTilePos(int pX, int pY, int pZ) {
		maidTile[0] = pX;
		maidTile[1] = pY;
		maidTile[2] = pZ;
	}
	public void setTilePos(TileEntity pEntity) {
		maidTile[0] = pEntity.xCoord;
		maidTile[1] = pEntity.yCoord;
		maidTile[2] = pEntity.zCoord;
		maidTileEntity = pEntity;
	}
	public void setTilePos(int pIndex) {
		if (pIndex < maidTiles.length) {
			if (maidTiles[pIndex] == null) {
				maidTiles[pIndex] = new int[3];
			}
			maidTiles[pIndex][0] = maidTile[0];
			maidTiles[pIndex][1] = maidTile[1];
			maidTiles[pIndex][2] = maidTile[2];
		}
	}
	public void setTilePos(int pIndex, int pX, int pY, int pZ) {
		if (pIndex < maidTiles.length) {
			if (maidTiles[pIndex] == null) {
				maidTiles[pIndex] = new int[3];
			}
			maidTiles[pIndex][0] = pX;
			maidTiles[pIndex][1] = pY;
			maidTiles[pIndex][2] = pZ;
		}
	}

	public TileEntity getTileEntity() {
		return maidTileEntity = worldObj.getTileEntity(maidTile[0], maidTile[1], maidTile[2]);
	}
	public TileEntity getTileEntity(int pIndex) {
		if (pIndex < maidTiles.length && maidTiles[pIndex] != null) {
			TileEntity ltile = worldObj.getTileEntity(
					maidTiles[pIndex][0], maidTiles[pIndex][1], maidTiles[pIndex][2]);
			if (ltile == null) {
				clearTilePos(pIndex);
			}
			return ltile;
		}
		return null;
	}

	public void clearTilePos() {
		maidTileEntity = null;
	}
	public void clearTilePos(int pIndex) {
		if (pIndex < maidTiles.length) {
			maidTiles[pIndex] = null;
		}
	}
	public void clearTilePosAll() {
		for (int li = 0; li < maidTiles.length; li++) {
			maidTiles[li] = null;
		}
	}

	public double getDistanceTilePos() {
		return getDistance(
				(double)maidTile[0] + 0.5D,
				(double)maidTile[1] + 0.5D,
				(double)maidTile[2] + 0.5D);
	}
	public double getDistanceTilePosSq() {
		return getDistanceSq(
				(double)maidTile[0] + 0.5D,
				(double)maidTile[1] + 0.5D,
				(double)maidTile[2] + 0.5D);
	}

	public double getDistanceTilePos(int pIndex) {
		if (maidTiles.length > pIndex && maidTiles[pIndex] != null) {
			return getDistance(
					(double)maidTiles[pIndex][0] + 0.5D,
					(double)maidTiles[pIndex][1] + 0.5D,
					(double)maidTiles[pIndex][2] + 0.5D);
		}
		return -1D;
	}
	public double getDistanceTilePosSq(int pIndex) {
		if (maidTiles.length > pIndex && maidTiles[pIndex] != null) {
			return getDistanceSq(
					(double)maidTiles[pIndex][0] + 0.5D,
					(double)maidTiles[pIndex][1] + 0.5D,
					(double)maidTiles[pIndex][2] + 0.5D);
		}
		return -1D;
	}
	public double getDistanceTilePos(TileEntity pTile) {
		if (pTile != null) {
			return getDistance(
					(double)pTile.xCoord + 0.5D,
					(double)pTile.yCoord + 0.5D,
					(double)pTile.zCoord + 0.5D);
		}
		return -1D;
	}
	public double getDistanceTilePosSq(TileEntity pTile) {
		if (pTile != null) {
			return getDistanceSq(
					(double)pTile.xCoord + 0.5D,
					(double)pTile.yCoord + 0.5D,
					(double)pTile.zCoord + 0.5D);
		}
		return -1D;
	}

	public void looksTilePos() {
		getLookHelper().setLookPosition(
				maidTile[0] + 0.5D, maidTile[1] + 0.5D, maidTile[2] + 0.5D,
				10F, getVerticalFaceSpeed());
	}
	public void looksTilePos(int pIndex) {
		if (maidTiles.length > pIndex && maidTiles[pIndex] != null) {
			getLookHelper().setLookPosition(
					maidTiles[pIndex][0] + 0.5D,
					maidTiles[pIndex][1] + 0.5D,
					maidTiles[pIndex][2] + 0.5D,
					10F, getVerticalFaceSpeed());
		}
	}

	public boolean isUsingItem() {
		return dataWatcher.getWatchableObjectInt(dataWatch_ItemUse) > 0;
	}

	public boolean isUsingItem(int pIndex) {
		return (dataWatcher.getWatchableObjectInt(dataWatch_ItemUse) & (1 << pIndex)) > 0;
	}
	
	public void setExperienceValue(int val)
	{
		this.experienceValue = val;
	}

	public void setFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}
	
	public void updateWanderPath()
	{
		super.updateWanderPath();
	}
	public boolean isMovementCeased()
	{
		return super.isMovementCeased();
	}

	public void setSize2(float par1, float par2)
	{
		super.setSize(par1, par2);
	}
}
