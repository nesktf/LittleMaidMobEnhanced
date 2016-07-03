package littleMaidMobX.entity;

import java.util.ArrayList;
import java.util.List;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.ClientHelper;
import littleMaidMobX.util.helper.Helper;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;


public class EntityDummy extends Entity {
	
	private int livecount;
	private final int maxlivecount = 16;
	private int entityColor;
	public Entity entityOwner;
	
	public static boolean isEnable = false;
	
	public static List<EntityDummy> appendList = new ArrayList<EntityDummy>();


	public EntityDummy(World world, int color, Entity owner) {
		super(world);
		livecount = maxlivecount;
		entityColor = color;
//		setSize(1F, 1F);
		entityOwner = owner;
	}
	
	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
	}

	@Override
	public void onUpdate() {
//		super.onUpdate();
		
		if (--livecount < 0 || !isEnable) {
			setDead();
		}
	}

	public float getAlpha(float max) {
		if (livecount >= 0) {
			return max * (float)livecount / (float)maxlivecount;
		} else {
			return 0F;
		}
	}

	public int getColor() {
		return entityColor;
	}

	public boolean setOwnerdEntityDead(Entity entity) {
		if (entityOwner == entity) {
			setDead();
			return true;
		}
		return false;
	}

	
	public static void clearDummyEntity(Entity entity) {
		if (!isEnable) return;
		if (!Helper.isClient) return;
		
		List<Entity> liste = entity.worldObj.loadedEntityList;
		for (Entity entity1 : liste) {
			if (entity1 instanceof EntityDummy) {
				((EntityDummy)entity1).setOwnerdEntityDead(entity);
			}
		}
	}

	
	public static void setDummyEntity(Entity owner, int color, double posx, double posy, double posz) {
		if (!isEnable) return;
		if (!Helper.isClient) return;
		
		
		if (owner.worldObj.isRemote) {
			Debug.entity("L");
		}
		
		EntityDummy ed = new EntityDummy(ClientHelper.getMCtheWorld(), color, owner);
		ed.setPosition(posx, posy, posz);
		appendList.add(ed);
	}

}
