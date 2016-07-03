package littleMaidMobX.aimodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.io.Config;
import littleMaidMobX.wrapper.MinecraftWrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;


public class IFF {

	public static final int iff_Enemy = 0;
	public static final int iff_Unknown = 1;
	public static final int iff_Friendry = 2;

	
	public static Map<String, Integer> DefaultIFF = new TreeMap<String, Integer>();
	
	public static Map<String, Map<String, Integer>> UserIFF = new HashMap<String, Map<String, Integer>>();

	
	public static Map<String, Integer> getUserIFF(String pUsername)
	{
		if (pUsername == null) {
			return DefaultIFF;
		}
		if (Helper.isLocalPlay()) {
			pUsername = "";
		}
		
		if (!UserIFF.containsKey(pUsername))
		{	
			if (pUsername.isEmpty()) {
				UserIFF.put(pUsername, DefaultIFF);
			} else {
				Map<String, Integer> lmap = new HashMap<String, Integer>();
				lmap.putAll(DefaultIFF);
				UserIFF.put(pUsername, lmap);
			}
		}
		
		return UserIFF.get(pUsername);
	}

	public static void setIFFValue(String pUsername, String pName, int pValue) {
		Map<String, Integer> lmap = getUserIFF(pUsername);
		lmap.put(pName, pValue);
	}

	public static int checkEntityStatic(String pName, Entity pEntity,
			int pIndex, Map<String, Entity> pMap) {
		int liff = IFF.iff_Unknown;
		if (pEntity instanceof EntityLivingBase) {
			if (pEntity instanceof EntityLittleMaid) {
				switch (pIndex) {
				case 0:
					
					liff = IFF.iff_Unknown;
					break;
				case 1:
					
					pName = (new StringBuilder()).append(pName).append(":Contract").toString();
					((EntityLittleMaid) pEntity).setContract(true);
					liff = IFF.iff_Friendry;
					break;
				case 2:
					
					pName = (new StringBuilder()).append(pName).append(":Others").toString();
					((EntityLittleMaid) pEntity).setContract(true);
					liff = IFF.iff_Friendry;
					break;
				}
			} else if (pEntity instanceof IEntityOwnable) {
				switch (pIndex) {
				case 0:
					
					break;
				case 1:
					
					pName = (new StringBuilder()).append(pName).append(":Taim").toString();
					if (pEntity instanceof EntityTameable) {
						((EntityTameable) pEntity).setTamed(true);
					}
					liff = IFF.iff_Friendry;
					break;
				case 2:
					
					pName = (new StringBuilder()).append(pName).append(":Others").toString();
					if (pEntity instanceof EntityTameable) {
						((EntityTameable) pEntity).setTamed(true);
					}
					liff = IFF.iff_Unknown;
					break;
				}
				if (pIndex != 0) {
					if (pEntity instanceof EntityOcelot) {
						((EntityOcelot) pEntity).setTameSkin(1 + (new Random()).nextInt(3));
					}
				}
			}
			if (pMap != null) {
				
				pMap.put(pName, pEntity);
				Debug.ai(pName + " added.");
			}
			
			
			if (!DefaultIFF.containsKey(pName)) {
				if (pEntity instanceof IMob) {
					liff = IFF.iff_Enemy;
				}
				DefaultIFF.put(pName, liff);
			}
		}
		
		return liff;
	}

	
	public static int getIFF(String pUsername, String entityname, World world) {
		if (entityname == null) {
			return Config.Aggressive ? iff_Enemy : iff_Friendry;
		}
		int lt = iff_Enemy;
		Map<String, Integer> lmap = getUserIFF(pUsername);
		if (lmap.containsKey(entityname)) {
			lt = lmap.get(entityname);
		} else if (lmap != DefaultIFF && DefaultIFF.containsKey(entityname)) {
			
			lt = DefaultIFF.get(entityname);
			lmap.put(entityname, lt);
		} else {
			
			int li = entityname.indexOf(":");
			String ls;
			if (li > -1) {
				ls = entityname.substring(0, li);
			} else {
				ls = entityname;
			}
			Entity lentity = EntityList.createEntityByName(ls, world);
			li = 0;
			if (entityname.indexOf(":Contract") > -1) {
				li = 1;
			} else 
			if (entityname.indexOf(":Taim") > -1) {
				li = 1;
			} else
			if (entityname.indexOf(":Others") > -1) {
				li = 2;
			}
			lt = checkEntityStatic(ls, lentity, li, null);
			lmap.put(entityname, lt);
		}
		return lt;
	}

	
	public static int getIFF(String pUsername, Entity entity) {
		if (entity == null || !(entity instanceof EntityLivingBase)) {
			return Config.Aggressive ? iff_Enemy : iff_Friendry;
		}
		String lename = EntityList.getEntityString(entity);
		String lcname = lename;
		if (lename == null) {
			
			return iff_Friendry;
			// return mod_LMM_littleMaidMob.Aggressive ? iff_Unknown :
			// iff_Friendry;
		}
		int li = 0;
		if (entity instanceof EntityLittleMaid) {
			if (((EntityLittleMaid) entity).isContract()) {
				if (((EntityLittleMaid) entity).getMaidMaster().contentEquals(pUsername)) {
					
					lcname = (new StringBuilder()).append(lename).append(":Contract").toString();
					li = 1;
				} else {
					
					lcname = (new StringBuilder()).append(lename).append(":Others").toString();
					li = 2;
				}
			}
		} else if (entity instanceof IEntityOwnable) {
			String loname = MinecraftWrapper.getOwnerName((IEntityOwnable)entity);
			if (!loname.isEmpty()) {
				if (loname.contentEquals(pUsername)) {
					
					lcname = (new StringBuilder()).append(lename).append(":Taim").toString();
					li = 1;
				} else {
					
					lcname = (new StringBuilder()).append(lename).append(":Others").toString();
					li = 2;
				}
			}
		}
		if (!getUserIFF(pUsername).containsKey(lcname)) {
			checkEntityStatic(lename, entity, li, null);
		}
		return getIFF(pUsername, lcname, entity.worldObj);
	}

	public static void loadIFFs() {
		
		if (!Helper.isClient) {
			
			loadIFF("");
			File lfile = MinecraftServer.getServer().getFile("");
			for (File lf : lfile.listFiles()) {
				if (lf.getName().endsWith("littleMaidMob.iff")) {
					String ls = lf.getName().substring(17, lf.getName().length() - 20);
					Debug.ai(ls);
					loadIFF(ls);
				}
			}
		} else {
			
			loadIFF(null);
		}
	}

	protected static File getFile(String pUsername) {
		File lfile;
		if (pUsername == null) {
			lfile = new File(Helper.mc.mcDataDir, "config/littleMaidMob.iff");
		} else {
			String lfilename;
			if (pUsername.isEmpty()) {
				lfilename = "config/littleMaidMob.iff";
			} else {
				lfilename = "config/littleMaidMob_".concat(pUsername).concat(".iff");
			}
			lfile = MinecraftServer.getServer().getFile(lfilename);
		}
		Debug.ai(lfile.getAbsolutePath());
		return lfile;
	}

	public static void loadIFF(String pUsername) {
		
		
		File lfile = getFile(pUsername);
		if (!(lfile.exists() && lfile.canRead())) {
			return;
		}
		Map<String, Integer> lmap = getUserIFF(pUsername);
		
		try {
			FileReader fr = new FileReader(lfile);
			BufferedReader br = new BufferedReader(fr);
			
			String s;
			while ((s = br.readLine()) != null) {
				String t[] = s.split("=");
				if (t.length > 1) {
					if (t[0].startsWith("triggerWeapon")) {
						TriggerSelect.appendTriggerItem(pUsername, t[0].substring(13), t[1]);
						continue;
					}
					int i = Integer.valueOf(t[1]);
					if (i > 2) {
						i = iff_Unknown;
					}
					lmap.put(t[0], i);
				}
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveIFF(String pUsername) {
		
		File lfile = getFile(LittleMaidMobX.proxy.isSinglePlayer() ? null : pUsername);
		Map<String, Integer> lmap = getUserIFF(pUsername);
		
		try {
			if ((lfile.exists() || lfile.createNewFile()) && lfile.canWrite()) {
				FileWriter fw = new FileWriter(lfile);
				BufferedWriter bw = new BufferedWriter(fw);
				
				
				for (Entry<Integer, List<Item>> le : TriggerSelect.getUserTrigger(pUsername).entrySet())
				{
					StringBuilder sb = new StringBuilder();
					sb.append("triggerWeapon")
							.append(TriggerSelect.selector.get(le.getKey()))
							.append("=");
					if (!le.getValue().isEmpty()) {
						String itemName = Item.itemRegistry.getNameForObject(le.getValue().get(0));
						sb.append(itemName);
						for (int i = 1; i < le.getValue().size(); i++) {
							itemName = Item.itemRegistry.getNameForObject(le.getValue().get(i));
							sb.append(",").append(itemName);
						}
					}
					sb.append("\r\n");
					bw.write(sb.toString());
				}
				
				for (Map.Entry<String, Integer> me : lmap.entrySet()) {
					bw.write(String.format("%s=%d\r\n", me.getKey(),
							me.getValue()));
				}
				
				bw.close();
				fw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
