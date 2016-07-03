package littleMaidMobX.registry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.ClientHelper;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.util.helper.PathHelper;
import littleMaidMobX.io.Config;
import littleMaidMobX.io.FileManager;
import littleMaidMobX.io.ZipTexturesLoader;
import littleMaidMobX.model.maid.ModelMultiBase;
import littleMaidMobX.network.NetConstants;
import littleMaidMobX.textures.ITextureEntity;
import littleMaidMobX.textures.TextureBox;
import littleMaidMobX.textures.TextureBoxBase;
import littleMaidMobX.textures.TextureBoxServer;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ModelManager {

	
	public static ModelManager instance = new ModelManager();

	public static String nameTextureIndex = "config/mod_LMM_textureList.cfg";
	public static String defaultModelName = "Orign";

	public static final int tx_oldwild = 0x10; //16;
	public static final int tx_oldarmor1 = 0x11; //17;
	public static final int tx_oldarmor2 = 0x12; //18;
	public static final int tx_oldeye = 0x13; //19;
	public static final int tx_gui = 0x20; //32;
	public static final int tx_wild = 0x30; //48;
	public static final int tx_armor1 = 0x40; //64;
	public static final int tx_armor2 = 0x50; //80;
	public static final int tx_eye = 0x60; //96;
	public static final int tx_eyecontract = 0x60; //96;
	public static final int tx_eyewild = 0x70; //112;
	public static final int tx_armor1light = 0x80; //128;
	public static final int tx_armor2light = 0x90; //144;
	public static String[] armorFilenamePrefix;
	
	protected static String defNames[] = {
		"mob_littlemaid0.png", "mob_littlemaid1.png",
		"mob_littlemaid2.png", "mob_littlemaid3.png",
		"mob_littlemaid4.png", "mob_littlemaid5.png",
		"mob_littlemaid6.png", "mob_littlemaid7.png",
		"mob_littlemaid8.png", "mob_littlemaid9.png",
		"mob_littlemaida.png", "mob_littlemaidb.png",
		"mob_littlemaidc.png", "mob_littlemaidd.png",
		"mob_littlemaide.png", "mob_littlemaidf.png",
		"mob_littlemaidw.png",
		"mob_littlemaid_a00.png", "mob_littlemaid_a01.png"
	};

	
	public Map < String, ModelMultiBase[] > modelMap = new TreeMap < String, ModelMultiBase[] > ();
	
	public List < TextureBox > textures = new ArrayList < TextureBox > ();
	
	public Map < TextureBox, Integer > textureServerIndex = new HashMap < TextureBox, Integer > ();
	
	public List < TextureBoxServer > textureServer = new ArrayList < TextureBoxServer > ();
	
	public Map < Class, TextureBox > defaultTextures = new HashMap < Class, TextureBox > ();

	
	protected String[] requestString = new String[] {
		null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null
	};
	protected int[] requestStringCounter = new int[] {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	protected int[] requestIndex = new int[] {
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
	};
	protected int[] requestIndexCounter = new int[] {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	protected Map < ITextureEntity, int[] > stackGetTexturePack = new HashMap < ITextureEntity, int[] > ();
	protected Map < ITextureEntity, Object[] > stackSetTexturePack = new HashMap < ITextureEntity, Object[] > ();
	
	protected List<String[]> searchPrefix = new ArrayList<String[]>();
	
	public static final String[] searchFileNamePrefix = new String[]{"littleMaidMob","mmmlibx","ModelMulti","LittleMaidMob","MultiModel"};

	public void init() {
		// 検索対象ファイル名を登録します。
		// パターンを登録しない場合、独自名称のMODファイル、テクスチャディレクトリ、クラスが読み込まれません。
		FileManager.getModFile("mmmlibx", "littleMaidMob");
		FileManager.getModFile("mmmlibx", "mmmlibx");
		FileManager.getModFile("mmmlibx", "ModelMulti");
		FileManager.getModFile("mmmlibx", "LittleMaidMob");
		
		addSearch("mmmlibx", "/assets/minecraft/textures/entity/ModelMulti/", "ModelMulti_");
		addSearch("mmmlibx", "/assets/minecraft/textures/entity/littleMaid/", "ModelMulti_");
		addSearch("mmmlibx", "/assets/minecraft/textures/entity/littleMaid/", "ModelLittleMaid_");
		addSearch("mmmlibx", "/mob/ModelMulti/", "ModelMulti_");
		addSearch("mmmlibx", "/mob/littleMaid/", "ModelLittleMaid_");
	}
	
	/**
	 * 追加対象となる検索対象ファイル群とそれぞれの検索文字列を設定する。
	 */
	public void addSearch(String pName, String pTextureDir, String pClassPrefix)
	{
		searchPrefix.add(new String[] {pName, pTextureDir, pClassPrefix});
	}
	
	public TextureBox getTextureBox(String pName)
	{
		for (TextureBox ltb: getTextureList())
		{
			if (ltb.textureName.equals(pName))
			{
				return ltb;
			}
		}
		return null;
	}

	public static List < TextureBox > getTextureList() {
		return instance.textures;
	}

	
	public TextureBox getTextureBox(TextureBoxBase pBoxBase) {
		if (pBoxBase instanceof TextureBox) {
			return (TextureBox) pBoxBase;
		} else if (pBoxBase instanceof TextureBoxServer) {
			return getTextureBox(pBoxBase.textureName);
		}
		return null;
	}

	public TextureBoxServer getTextureBoxServer(String pName) {
		for (TextureBoxServer lbox: textureServer) {
			if (lbox.textureName.equals(pName)) {
				return lbox;
			}
		}
		return null;
	}

	public TextureBoxServer getTextureBoxServer(int pIndex) {
		//		LMM_LittleMaidMobX.Debug("getTextureBoxServer: %d / %d", pIndex, textureServer.size());
		if (textureServer.size() > pIndex) {
			return textureServer.get(pIndex);
		}
		return null;
	}

	protected void getArmorPrefix() {
		armorFilenamePrefix = RenderBiped.bipedArmorFilenamePrefix;
		
	}

	boolean init = false;
	public boolean loadTextures(boolean server)
	{
		if (Helper.isClient)
		{
			getArmorPrefix();
		}
		
		// this is called server and client side

		// this can be simplified
		StringBuilder hack = new StringBuilder();
		for (Class c : ModelRegistry.list) {
			try {
				if(server)
				{
					addModelClassServer(c, hack);
				} else {
					addModelClass(c);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		for (String texturePath : TextureRegistry.list)
		{
			try
			{
				addTexture(texturePath);
			}
			catch (Throwable e)
			{
				e.printStackTrace();
			}
		}
		
		for (String[] lst : searchPrefix) {
			// mods
			searchFiles(FileManager.dirMods, lst, server);
		}

		buildCrafterTexture();
	
		ModelMultiBase[] ldm = modelMap.get(defaultModelName);
		if (ldm == null && !modelMap.isEmpty()) {
			ldm = (ModelMultiBase[]) modelMap.values().toArray()[0];
		}
		for (TextureBox ltb: textures) {
			if (ltb.modelName.isEmpty()) {
				ltb.setModels(defaultModelName, null, ldm);
			} else {
				if (modelMap.containsKey(ltb.modelName)) {
					ltb.setModels(ltb.modelName, modelMap.get(ltb.modelName), ldm);
				}
			}
		}
		for (Entry < String, ModelMultiBase[] > le: modelMap.entrySet()) {
			String ls = le.getValue()[0].getUsingTexture();
			if (ls != null) {
				if (getTextureBox(ls + "_" + le.getKey()) == null) {
					TextureBox lbox = null;
					for (TextureBox ltb: textures) {
						if (ltb.packageName.equals(ls)) {
							lbox = ltb;
							break;
						}
					}
					if (lbox != null) {
						lbox = lbox.duplicate();
						lbox.setModels(le.getKey(), null, le.getValue());
						textures.add(lbox);
					}
				}
			}
		}
		Debug.texture("Loaded Texture Lists.(%d)", textures.size());
		for (TextureBox lbox: textures) {
			Debug.texture("texture: %s(%s) - hasModel:%b", lbox.textureName, lbox.fileName, lbox.models != null);
		}
		for (int li = textures.size() - 1; li >= 0; li--) {
			if (textures.get(li).models == null) {
				textures.remove(li);
			}
		}
		Debug.texture("Rebuild Texture Lists.(%d)", textures.size());
		for (TextureBox lbox: textures) {
			Debug.texture("texture: %s(%s) - hasModel:%b", lbox.textureName, lbox.fileName, lbox.models != null);
		}


		setDefaultTexture(EntityLivingBase.class, getTextureBox("default_" + defaultModelName));

		return false;
	}
	
	private void searchFiles(File ln, String[] lst, boolean server) {
		Debug.texture("getTexture[%s:%s].", lst[0], lst[1]);
		// mods
		for (File lf : ln.listFiles()) {
			boolean lflag;
			if (lf.isDirectory()) {
				// ディレクトリ
				lflag = addTexturesDir(lf, lst, server);
			} else {
				// zip
				lflag = addTexturesZip(lf, lst, server);
			}
			Debug.texture("getTexture-append-%s-%s.", lf.getName(), lflag ? "done" : "fail");
		}
	}

	public void buildCrafterTexture() {
		
		TextureBox lbox = new TextureBox("Crafter_Steve");
		lbox.fileName = "";

		lbox.addTexture(0x0c, "/assets/minecraft/textures/entity/steve.png");
		if (armorFilenamePrefix != null && armorFilenamePrefix.length > 0) {
			for (String ls: armorFilenamePrefix) {
				Map < Integer, ResourceLocation > lmap = new HashMap < Integer, ResourceLocation > ();
				lmap.put(tx_armor1, new ResourceLocation(
				(new StringBuilder()).append("textures/models/armor/").append(ls).append("_layer_2.png").toString()));
				lmap.put(tx_armor2, new ResourceLocation(
				(new StringBuilder()).append("textures/models/armor/").append(ls).append("_layer_1.png").toString()));
				lbox.armors.put(ls, lmap);
			}
		}

		textures.add(lbox);
	}


	public boolean loadTextureServer()
	{
		textureServer.clear();
		for (TextureBox lbox: getTextureList()) {
			textureServer.add(new TextureBoxServer(lbox));
		}
		
		File lfile = MinecraftServer.getServer().getFile(nameTextureIndex);
		if (lfile.exists() && lfile.isFile()) {
			try {
				FileReader fr = new FileReader(lfile);
				BufferedReader br = new BufferedReader(fr);
				String ls;

				while ((ls = br.readLine()) != null) {
					String lt[] = ls.split(",");
					if (lt.length >= 7) {
						
						TextureBoxServer lbox = getTextureBoxServer(lt[6]);
						if (lbox == null) {
							lbox = new TextureBoxServer();
							textureServer.add(lbox);
						}
						lbox.contractColor = Helper.getHexToInt(lt[0]);
						lbox.wildColor = Helper.getHexToInt(lt[1]);
						lbox.setModelSize(
						Float.valueOf(lt[2]),
						Float.valueOf(lt[3]),
						Float.valueOf(lt[4]),
						Float.valueOf(lt[5]));
						lbox.textureName = lt[6];
					}
				}

				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Debug.texture("Loaded ServerBoxList.(%d)", textureServer.size());
			for (int li = 0; li < textureServer.size(); li++) {
				TextureBoxServer lbox = textureServer.get(li);
				Debug.texture("%04d=%s:%04x:%04x", li, lbox.textureName, lbox.contractColor, lbox.wildColor);
			}
			return true;
		} else {}

		return false;
	}

	public void saveTextureServer() {
		
		File lfile = MinecraftServer.getServer().getFile(nameTextureIndex);
		try {
			FileWriter fw = new FileWriter(lfile);
			BufferedWriter bw = new BufferedWriter(fw);

			for (TextureBoxServer lbox: textureServer) {
				bw.write(String.format("%04x,%04x,%f,%f,%f,%f,%s",
				lbox.getContractColorBits(),
				lbox.getWildColorBits(),
				lbox.getHeight(null),
				lbox.getWidth(null),
				lbox.getYOffset(null),
				lbox.getMountedYOffset(null),
				lbox.textureName));
				bw.newLine();
			}

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void initTextureList(boolean pFlag) {
		Debug.texture("Clear TextureBoxServer.");
		textureServerIndex.clear();
		textureServer.clear();
		if (pFlag) {
			int li = 0;
			for (TextureBox lbc: getTextureList()) {
				TextureBoxServer lbs = new TextureBoxServer(lbc);
				textureServer.add(lbs);
				textureServerIndex.put(lbc, li++);
			}
			Debug.texture("Rebuild TextureBoxServer(%d).", textureServer.size());
		}
	}

	private void addModelClass(Class lclass) throws Throwable
	{
		String modelName = lclass.getSimpleName();
		int n = modelName.indexOf("_");
		if (n > 0 && n < modelName.length()-1) {
			modelName = modelName.substring(modelName.indexOf("_")+1);
		}
		ModelMultiBase mlm[] = new ModelMultiBase[3];
		Constructor < ModelMultiBase > cm = lclass.getConstructor(float.class);
		mlm[0] = cm.newInstance(0.0F);
		float[] lsize = mlm[0].getArmorModelsSize();
		mlm[1] = cm.newInstance(lsize[0]);
		mlm[2] = cm.newInstance(lsize[1]);
		modelMap.put(modelName, mlm);
		Debug.model("getModelClass-%s:%s", modelName, mlm);
	}
	
	protected void addModelClass(String fname, String[] pSearch) throws Throwable {
		// モデルを追加
		int lfindprefix = fname.indexOf(pSearch[2]);
		if (lfindprefix > -1/* && fname.endsWith(".class")*/) {
			String cn = fname.endsWith(".class") ? fname.substring(0,fname.lastIndexOf(".class")) : fname;
			String pn = cn.substring(pSearch[2].length() + lfindprefix);
			
			if (modelMap.containsKey(pn)) return;
			try {
				Package lpackage = LittleMaidMobX.class.getPackage();
				Class lclass;
				if (lpackage != null) {
//					cn = (new StringBuilder("")).append(".").append(cn).toString();
					cn = cn.replace("/", ".");
					System.out.println("ModelManager.addModelClass : "+cn);
					lclass = FileManager.COMMON_CLASS_LOADER.loadClass(cn);
				} else {
					lclass = Class.forName(cn);
				}
				if (!(ModelMultiBase.class).isAssignableFrom(lclass) || Modifier.isAbstract(lclass.getModifiers())) {
					Debug.model("getModelClass-fail.");
					return;
				}
				//addModelClass(lclass);
				ModelMultiBase mlm[] = new ModelMultiBase[3];
				Constructor<ModelMultiBase> cm = lclass.getConstructor(float.class);
				mlm[0] = cm.newInstance(0.0F);
				float[] lsize = mlm[0].getArmorModelsSize();
				mlm[1] = cm.newInstance(lsize[0]);
				mlm[2] = cm.newInstance(lsize[1]);
				modelMap.put(pn, mlm);
				Debug.model("getModelClass-%s:%s", pn, cn);
			}
			catch (Exception exception) {
				Debug.model("getModelClass-Exception: %s", fname);
				if(Config.isDebugModels) exception.printStackTrace();
			}
			catch (Error error) {
				Debug.model("getModelClass-Error: %s", fname);
				if(Config.isDebugModels) error.printStackTrace();
			}
		}
	}
	
	private void addModelClassServer(Class lclass, StringBuilder hack) throws Throwable {
		String modelName = lclass.getSimpleName();
		int n = modelName.indexOf("_");
		if (n > 0 && n < modelName.length()-1) {
			modelName = modelName.substring(modelName.indexOf("_")+1);
		}
		ModelMultiBase mlm[] = new ModelMultiBase[3];
		Constructor < ModelMultiBase > cm = lclass.getConstructor(StringBuilder.class);
		mlm[0] = cm.newInstance(new Object[]{hack});
//		float[] lsize = mlm[0].getArmorModelsSize();
//		mlm[1] = cm.newInstance(lsize[0]);
//		mlm[2] = cm.newInstance(lsize[1]);
		mlm[1] = mlm[0];
		mlm[2] = mlm[0];
		modelMap.put(modelName, mlm);
		Debug.model("getModelClassServer-%s:%s", modelName, mlm);
	}
	
	protected void addModelClassServer(String fname, String[] pSearch) throws Throwable {
		// モデルを追加
		int lfindprefix = fname.indexOf(pSearch[2]);
		if (lfindprefix > -1/* && fname.endsWith(".class")*/) {
			String cn = fname.endsWith(".class") ? fname.substring(0,fname.lastIndexOf(".class")) : fname;
			String pn = cn.substring(pSearch[2].length() + lfindprefix);
			
			if (modelMap.containsKey(pn)) return;
			try {
				Package lpackage = LittleMaidMobX.class.getPackage();
				Class lclass;
				if (lpackage != null) {
//					cn = (new StringBuilder("")).append(".").append(cn).toString();
					cn = cn.replace("/", ".");
					System.out.println("MMM_TextureManager.addModelClass : "+cn);
					lclass = FileManager.COMMON_CLASS_LOADER.loadClass(cn);
				} else {
					lclass = Class.forName(cn);
				}
				if (!(ModelMultiBase.class).isAssignableFrom(lclass) || Modifier.isAbstract(lclass.getModifiers())) {
					Debug.model("getModelClassServer-fail.");
					return;
				}
				ModelMultiBase mlm[] = new ModelMultiBase[3];
				Constructor<ModelMultiBase> cm = lclass.getConstructor(float.class);
				mlm[0] = cm.newInstance(0.0F);
				//float[] lsize = mlm[0].getArmorModelsSize();
				mlm[1] = mlm[0];
				mlm[2] = mlm[0];
				modelMap.put(pn, mlm);
				Debug.model("getModelClassServer-%s:%s", pn, mlm);
			}
			catch (Exception exception) {
				Debug.model("getModelClassServer-Exception: %s", fname);
				if(Config.isDebugModels) exception.printStackTrace();
			}
			catch (Error error) {
				Debug.model("getModelClass-Error: %s", fname);
				if(Config.isDebugModels) error.printStackTrace();
			}
		}
	}
	
	protected boolean addTexturesZip(File file, String[] pSearch, boolean server) {
		//
		if (file == null || file.isDirectory()) {
			return false;
		}
		try {
			FileManager.COMMON_CLASS_LOADER.addURL(file.toURI().toURL());
		} catch (MalformedURLException e) {
		}
		try {
			StringBuilder hack = new StringBuilder();
			FileInputStream fileinputstream = new FileInputStream(file);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			Debug.addon("Start searching %s", file.getName());
			do {
				zipentry = zipinputstream.getNextEntry();
				if(zipentry == null)
				{
					break;
				}
				if (!zipentry.isDirectory()) {
					if (zipentry.getName().endsWith(".class"))
					{
						if (server)
						{
							try {
								addModelClassServer(zipentry.getName(), pSearch);
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
						else
						{
							try {
								addModelClass(zipentry.getName(), pSearch);
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
					}
					else if(zipentry.getName().endsWith(".png")){
						String lt1 = "mob/littleMaid";
						String lt2 = "mob/ModelMulti";
						addTextureName(zipentry.getName(), pSearch);
						if(FMLCommonHandler.instance().getSide()==Side.CLIENT&&
								(zipentry.getName().startsWith(lt1)||zipentry.getName().startsWith(lt2)))
							ZipTexturesLoader.keys.add(zipentry.getName());
					}
				}
			} while(true);
			
			zipinputstream.close();
			fileinputstream.close();
			
			return true;
		} catch (Exception exception) {
			Debug.addon("addTextureZip-Exception.");
			return false;
		}
	}

	protected boolean addTexturesDir(File file, String[] pSearch, boolean server) {
		// modsフォルダに突っ込んであるものも検索、再帰で。
		if (file == null) {
			return false;
		}
		
		try {
			FileManager.COMMON_CLASS_LOADER.addURL(file.toURI().toURL());
		} catch (MalformedURLException e1) {
		}
		
		try {
			StringBuilder hack = new StringBuilder();
			for (File nfile : file.listFiles()) {
				if(nfile.isDirectory()) {
					addTexturesDir(nfile, pSearch, server);
				} else {
					String tn = PathHelper.getLinuxAntiDotName(nfile.getAbsolutePath());
					String rmn = PathHelper.getLinuxAntiDotName(FileManager.dirMods.getAbsolutePath());
					if (nfile.getName().endsWith(".class")) {
						if(tn.startsWith(rmn))
						{
							if (server)
							{
								try {
									addModelClassServer(PathHelper.getClassName(tn, rmn), pSearch);
								} catch (Throwable e) {
									e.printStackTrace();
								}
							}
							else
							{
								try {
									addModelClass(PathHelper.getClassName(tn, rmn), pSearch);
								} catch (Throwable e) {
									e.printStackTrace();
								}
							}
						}
					} else if(nfile.getName().endsWith(".png")) {
						String s = nfile.getPath().replace('\\', '/');
						int i = s.indexOf(pSearch[1]);
						if (i > -1) {
							// 対象はTexture Directory
							addTextureName(s.substring(i), pSearch);
//							addTextureName(s.substring(i).replace('\\', '/'));
						}
					} else {
						// サブフォルダ分のアーカイブを検索
						addTexturesZip(nfile, pSearch, server);
					}
				}
			}
			return true;
		} catch (Exception e) {
			Debug.addon("addTextureDebug-Exception.");
			return false;
		}
	}
	
	protected void addTexture(String path)
	{
		String packageName3 = path.substring(0, path.lastIndexOf("/"));
		String packageName = packageName3.substring(packageName3.lastIndexOf("/")+1);
		String fn = path.substring(path.lastIndexOf("/")+1);
		int lindex = getIndex(fn);
		if (lindex > -1) {
			if (lindex == tx_oldarmor1) {
				lindex = tx_armor1;
			}
			if (lindex == tx_oldarmor2) {
				lindex = tx_armor2;
			}
			if (lindex == tx_oldwild) {
				lindex = tx_wild + 12;
			}
			TextureBox lts = getTextureBox(packageName);
			if (lts == null)
			{
				lts = new TextureBox(packageName);
				textures.add(lts);
				Debug.texture("getTextureName-append-texturePack-%s", packageName);
			}
			lts.addTexture(lindex, path);
		}
		else
		{
			System.err.println("Texture does not have index assigned: "+path);
		}
	}

	protected boolean addTextureName(String fname, String[] pSearch)
	{
		// パッケージにテクスチャを登録
		if (!fname.startsWith("/"))
		{
			fname = (new StringBuilder()).append("/").append(fname).toString();
		}
//		MMMLib.Debug("MMM_TextureManager.addTextureName : %s # %s # %s # %s", fname, pSearch[0], pSearch[1], pSearch[2]);
		if (fname.startsWith(pSearch[1]))
		{
			int i = fname.lastIndexOf("/");
			if (pSearch[1].length() < i)
			{
				String pn = fname.substring(pSearch[1].length(), i);
				pn = pn.replace('/', '.');
				String fn = fname.substring(i);
				int lindex = getIndex(fn);
				if (lindex > -1)
				{
					if (lindex == tx_oldarmor1)
					{
						lindex = tx_armor1;
					}
					if (lindex == tx_oldarmor2)
					{
						lindex = tx_armor2;
					}
					if (lindex == tx_oldwild)
					{
						lindex = tx_wild + 12;
					}
					TextureBox lts = getTextureBox(pn);
					if (lts == null)
					{
						lts = new TextureBox(pn/*, pSearch*/);
						textures.add(lts);
						Debug.texture("getTextureName-append-texturePack-%s", pn);
					}
					lts.addTexture(lindex, fname);
					return true;
				}
			}
		}
		return false;
	}

	protected int getIndex(String name) {
		
		for (int i = 0; i < defNames.length; i++) {
			if (name.endsWith(defNames[i])) {
				return i;
			}
		}

		Pattern p = Pattern.compile("_([0-9a-f]+).png");
		Matcher m = p.matcher(name);
		if (m.find()) {
			return Integer.decode("0x" + m.group(1));
		}

		return -1;
	}

	public TextureBox getNextPackege(TextureBox pNowBox, int pColor) {
		
		boolean f = false;
		TextureBox lreturn = null;
		for (TextureBox ltb: getTextureList()) {
			if (ltb.hasColor(pColor)) {
				if (f) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				f = true;
			}
		}
		return lreturn == null ? null : lreturn;
	}

	public TextureBox getPrevPackege(TextureBox pNowBox, int pColor) {
		
		TextureBox lreturn = null;
		for (TextureBox ltb: getTextureList()) {
			if (ltb == pNowBox) {
				if (lreturn != null) {
					break;
				}
			}
			if (ltb.hasColor(pColor)) {
				lreturn = ltb;
			}
		}
		return lreturn == null ? null : lreturn;
	}

	
	public int getTextureCount() {
		return getTextureList().size();
	}

	public TextureBox getNextArmorPackege(TextureBox pNowBox) {
		
		boolean f = false;
		TextureBox lreturn = null;
		for (TextureBox ltb: getTextureList()) {
			if (ltb.hasArmor()) {
				if (f) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				f = true;
			}
		}
		return lreturn;
	}

	public TextureBox getPrevArmorPackege(TextureBox pNowBox) {
		
		TextureBox lreturn = null;
		for (TextureBox ltb: getTextureList()) {
			if (ltb == pNowBox) {
				if (lreturn != null) {
					break;
				}
			}
			if (ltb.hasArmor()) {
				lreturn = ltb;
			}
		}
		return lreturn;
	}

	public String getRandomTextureString(Random pRand) {
		return getRandomTexture(pRand).textureName;
	}

	public TextureBoxServer getRandomTexture(Random pRand) {
		if (textureServer.isEmpty()) {
			return null;
		} else {
			
			List < TextureBoxServer > llist = new ArrayList < TextureBoxServer > ();
			for (TextureBoxServer lbox: textureServer) {
				if (lbox.getWildColorBits() > 0) {
					llist.add(lbox);
				}
			}
			return llist.get(pRand.nextInt(llist.size()));
		}
	}

	
	public int getIndexTextureBoxServer(ITextureEntity pEntity, String pPackName) {
		for (int li = 0; li < textureServer.size(); li++) {
			if (textureServer.get(li).textureName.equals(pPackName)) {
				return li;
			}
		}
		
		//		int li = textureServerIndex.get(getDefaultTexture(pEntity));
		TextureBox lbox = getDefaultTexture(pEntity);
		if (lbox != null) {
			pPackName = lbox.textureName;
			for (int li = 0; li < textureServer.size(); li++) {
				if (textureServer.get(li).textureName.equals(pPackName)) {
					return li;
				}
			}
		}
		return 0;
	}

	
	public int getIndexTextureBoxServerIndex(TextureBox pBox) {
		return textureServerIndex.get(pBox);
	}

	
	public void setDefaultTexture(ITextureEntity pEntity, TextureBox pBox) {
		setDefaultTexture(pEntity.getClass(), pBox);
	}
	public void setDefaultTexture(Class pEntityClass, TextureBox pBox) {
		defaultTextures.put(pEntityClass, pBox);
		Debug.texture("appendDefaultTexture:%s(%s)",
		pEntityClass.getSimpleName(), pBox == null ? "NULL" : pBox.textureName);
	}

	
	public TextureBox getDefaultTexture(ITextureEntity pEntity) {
		return getDefaultTexture(pEntity.getClass());
	}
	public TextureBox getDefaultTexture(Class pEntityClass) {
		if (defaultTextures.containsKey(pEntityClass)) {
			return defaultTextures.get(pEntityClass);
		} else {
			Class lsuper = pEntityClass.getSuperclass();
			if (lsuper != null) {
				TextureBox lbox = getDefaultTexture(lsuper);
				if (lbox != null) {
					setDefaultTexture(pEntityClass, lbox);
				}
				return lbox;
			}
			return null;
		}
	}



	

	
	protected int getRequestStringIndex(String pVal) {
		int lblank = -1;
		for (int li = 0; li < requestString.length; li++) {
			if (requestString[li] == null) {
				lblank = li;
				requestStringCounter[li] = 0;
			} else if (requestString[li].equals(pVal)) {
				
				return -2;
			}
		}
		if (lblank >= 0) {
			requestString[lblank] = pVal;
		} else {
			Debug.addon("requestString Overflow!");
		}
		return lblank;
	}

	protected String getRequestString(int pIndex) {
		String ls = requestString[pIndex];
		requestString[pIndex] = null;
		return ls;
	}

	protected int getRequestIndex(int pTextureServerBoxIndex) {
		int lblank = -1;
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == -1) {
				lblank = li;
				requestIndexCounter[li] = 0;
			} else if (requestIndex[li] == pTextureServerBoxIndex) {
				
				return -2;
			}
		}
		if (lblank >= 0) {
			requestIndex[lblank] = pTextureServerBoxIndex;
		} else {
			Debug.addon("requestIndex Overflow!");
		}
		return lblank;
	}

	protected boolean clearRequestIndex(int pTextureServerBoxIndex) {
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == pTextureServerBoxIndex) {
				
				requestIndex[li] = -1;
				return true;
			}
		}
		return false;
	}


	public TextureBox getTextureBoxServerIndex(int pIndex) {
		for (Entry < TextureBox, Integer > le: textureServerIndex.entrySet()) {
			if (le.getValue() == pIndex) {
				return le.getKey();
			}
		}
		return null;
	}


	
	public void postSetTexturePack(ITextureEntity pEntity, int pColor, TextureBoxBase[] pBox) {
		// Client
		if (!(pEntity instanceof Entity)) return;
		
		int lindex[] = new int[pBox.length];
		boolean lflag = true;

		
		for (int li = 0; li < pBox.length; li++) {
			lindex[li] = checkTextureBoxServer((TextureBox) pBox[li]);
			if (lindex[li] < 0) {
				lflag = false;
			}
		}

		if (lflag) {
			
			sendToServerSetTexturePackIndex(pEntity, pColor, lindex);
		} else {
			
			Object lo[] = new Object[1 + pBox.length];
			lo[0] = pColor;
			for (int li = 0; li < pBox.length; li++) {
				lo[li + 1] = pBox[li];
			}
			stackSetTexturePack.put(pEntity, lo);
		}
	}

	
	public int checkTextureBoxServer(TextureBox pBox) {
		// Client
		if (textureServerIndex.containsKey(pBox)) {
			return textureServerIndex.get(pBox);
		} else {
			int ll = getRequestStringIndex(pBox.textureName);
			if (ll > -1) {
				sendToServerGetTextureIndex(ll, pBox);
				return -1;
			} else {
				return ll;
			}
		}
	}

	protected void sendToServerSetTexturePackIndex(ITextureEntity pEntity, int pColor, int[] pIndex) {
		// Client
		
		if (pEntity instanceof Entity) {
			byte ldata[] = new byte[6 + pIndex.length * 2];
			ldata[0] = NetConstants.Server_SetTexturePackIndex;
			Helper.setInt(ldata, 1, ((Entity) pEntity).getEntityId());
			ldata[5] = (byte) pColor;
			int li = 6;
			for (int ll: pIndex) {
				Helper.setShort(ldata, li, ll);
				li += 2;
			}
			ClientHelper.sendToServer(ldata);
		}
	}

	public void reciveFromClientSetTexturePackIndex(Entity pEntity, byte[] pData) {
		// Server
		if (pEntity instanceof ITextureEntity) {
			
			int lcount = (pData.length - 6) / 2;
			if (lcount < 1) return;
			int lindex[] = new int[lcount];

			for (int li = 0; li < lcount; li++) {
				lindex[li] = Helper.getShort(pData, 6 + li * 2);
			}
			Debug.texture("reciveFromClientSetTexturePackIndex: %d, %4x", pData[5], lindex[0]);
			((ITextureEntity) pEntity).setTexturePackIndex(pData[5], lindex);
		}
	}

	protected void sendToServerGetTextureIndex(int pBufIndex, TextureBox pBox) {
		// Client
		
		
		
		byte ldata[] = new byte[22 + pBox.textureName.length()];
		ldata[0] = NetConstants.Server_GetTextureIndex;
		ldata[1] = (byte) pBufIndex;
		Helper.setShort(ldata, 2, pBox.getContractColorBits());
		Helper.setShort(ldata, 4, pBox.getWildColorBits());
		Helper.setFloat(ldata, 6, pBox.getHeight(null));
		Helper.setFloat(ldata, 10, pBox.getWidth(null));
		Helper.setFloat(ldata, 14, pBox.getYOffset(null));
		Helper.setFloat(ldata, 18, pBox.getMountedYOffset(null));
		Helper.setStr(ldata, 22, pBox.textureName);
		ClientHelper.sendToServer(ldata);
		Debug.texture("Server_GetTextureIndex: %s", pBox.textureName);
	}

	public void reciveFromClientGetTexturePackIndex(EntityPlayer player, byte[] pData) {
		// Server
		
		String lpackname = Helper.getStr(pData, 22);
		TextureBoxServer lboxsrv = getTextureBoxServer(lpackname);
		int li;
		if (lboxsrv == null) {
			li = textureServer.size();
			lboxsrv = new TextureBoxServer();
			textureServer.add(lboxsrv);
		} else {
			li = textureServer.indexOf(lboxsrv);
		}
		lboxsrv.setValue(pData);

		byte ldata[] = new byte[4];
		ldata[0] = NetConstants.Client_SetTextureIndex;
		ldata[1] = pData[1];
		Helper.setShort(ldata, 2, li);
		Debug.client("reciveFromClientGetTexturePackIndex: %s, %04x", lpackname, li);
		LittleMaidMobX.sendToClient(player, ldata);
	}

	public void reciveFormServerSetTexturePackIndex(byte[] pData) {
		// Client
		
		TextureBox lbox = getTextureBox(getRequestString(pData[1]));
		textureServerIndex.put(lbox, (int) Helper.getShort(pData, 2));
		Debug.server("reciveFormServerSetTexturePackIndex: %s, %04x", lbox.textureName, (int) Helper.getShort(pData, 2));

		
		Map < ITextureEntity, Object[] > lmap = new HashMap < ITextureEntity, Object[] > (stackSetTexturePack);
		stackSetTexturePack.clear();
		for (Entry < ITextureEntity, Object[] > le: lmap.entrySet()) {
			Object lo[] = le.getValue();
			TextureBox ls[] = new TextureBox[le.getValue().length - 1];
			int lc = (Integer) lo[0];
			for (int li = 1; li < lo.length; li++) {
				ls[li - 1] = (TextureBox) lo[li];
			}
			postSetTexturePack(le.getKey(), lc, ls);
		}
	}



	
	public void postGetTexturePack(ITextureEntity pEntity, int[] pIndex) {
		// Client
		
		TextureBox lbox[] = new TextureBox[pIndex.length];
		boolean lflag = true;

		
		for (int li = 0; li < pIndex.length; li++) {
			lbox[li] = getTextureBoxServerIndex(pIndex[li]);
			if (lbox[li] == null) {
				if (getRequestIndex(pIndex[li]) > -1) {
					sendToServerGetTexturePackName(pIndex[li]);
				}
				lflag = false;
			}
		}

		if (lflag) {
			
			pEntity.setTexturePackName(lbox);
		} else {
			
			stackGetTexturePack.put(pEntity, pIndex);
		}
	}

	protected void sendToServerGetTexturePackName(int pIndex) {
		// Client
		
		if (pIndex < 0) {
			Debug.server("request range out.");
			return;
		}
		byte ldata[] = new byte[3];
		ldata[0] = NetConstants.Server_GetTexturePackName;
		Helper.setShort(ldata, 1, pIndex);
		ClientHelper.sendToServer(ldata);
	}

	public void reciveFromClientGetTexturePackName(EntityPlayer player, byte[] pData) {
		// Server
		
		int lindex = Helper.getShort(pData, 1);
		TextureBoxServer lboxserver = getTextureBoxServer(lindex);

		
		byte ldata[] = new byte[23 + lboxserver.textureName.length()];
		ldata[0] = NetConstants.Client_SetTexturePackName;
		Helper.setShort(ldata, 1, lindex);
		Helper.setShort(ldata, 3, lboxserver.getContractColorBits());
		Helper.setShort(ldata, 5, lboxserver.getWildColorBits());
		Helper.setFloat(ldata, 7, lboxserver.getHeight(null));
		Helper.setFloat(ldata, 11, lboxserver.getWidth(null));
		Helper.setFloat(ldata, 15, lboxserver.getYOffset(null));
		Helper.setFloat(ldata, 19, lboxserver.getMountedYOffset(null));
		Helper.setStr(ldata, 23, lboxserver.textureName);
		LittleMaidMobX.sendToClient(player, ldata);
		Debug.client("SetTexturePackName:%04x - %s", lindex, lboxserver.textureName);
	}

	public void reciveFromServerSetTexturePackName(byte[] pData) {
		// Client
		
		String lpackname = Helper.getStr(pData, 23);
		TextureBox lbox = getTextureBox(lpackname);
		if (lbox == null) {
			
			
			lbox = getTextureBox("default_Orign").duplicate();
			lbox.textureName = lpackname;
			//			lbox = new MMM_TextureBox(lpackname, null);
			lbox.setModelSize(
			Helper.getFloat(pData, 7),
			Helper.getFloat(pData, 11),
			Helper.getFloat(pData, 15),
			Helper.getFloat(pData, 19));
			textures.add(lbox);
		}
		int lindex = Helper.getShort(pData, 1);
		textureServerIndex.put(lbox, lindex);
		clearRequestIndex(lindex);

		
		Map < ITextureEntity, int[] > lmap = new HashMap < ITextureEntity, int[] > (stackGetTexturePack);
		stackGetTexturePack.clear();
		for (Entry < ITextureEntity, int[] > le: lmap.entrySet()) {
			postGetTexturePack(le.getKey(), le.getValue());
		}
	}

	
	protected void onUpdate() {
		for (int li = 0; li < requestString.length; li++) {
			
			if (requestString[li] != null && requestStringCounter[li]++ > 600) {
				requestString[li] = null;
				requestStringCounter[li] = 0;
			}
			if (requestIndex[li] != -1 && requestIndexCounter[li]++ > 600) {
				requestIndex[li] = -1;
				requestIndexCounter[li] = 0;
			}
		}
	}

}
