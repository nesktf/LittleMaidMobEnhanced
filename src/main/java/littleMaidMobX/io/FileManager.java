package littleMaidMobX.io;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import cpw.mods.fml.relauncher.FMLInjectionData;

public class FileManager
{
	public static class CommonClassLoaderWrapper extends URLClassLoader
	{
		public CommonClassLoaderWrapper(URL[] urls, ClassLoader parent)
		{
			super(urls, parent);
			// TODO 自動生成されたコンストラクター・スタブ
		}
		@Override
		public void addURL(URL url)
		{
			// 可視化
			if (new ArrayList(Arrays.asList(getURLs())).contains(url)) return;
			super.addURL(url);
		}
	}
	public static File minecraftDir;
	public static File dirMods;
	public static File dirModsVersion;
	public static File dirDevClasses;
	public static File dirDevClassAssets;
	public static List<File> dirDevIncludeClasses = new ArrayList<File>();
	
	public static List<File> files;
	public static Map<String,List<File>>    fileList = new HashMap<String, List<File>>();

	public static CommonClassLoaderWrapper COMMON_CLASS_LOADER;
	
	public static void init()
	{
		dirMods = new File(minecraftDir, "mods");
		// ClassLoaderを初期化
		List<URL> urls = new ArrayList<URL>();
		try
		{
			urls.add(FileManager.dirMods.toURI().toURL());
		}
		catch (MalformedURLException e1)
		{
					
		}
		FileManager.COMMON_CLASS_LOADER = new CommonClassLoaderWrapper(urls.toArray(new URL[]{}), LittleMaidMobX.class.getClassLoader());
		
		//TODO: better way?! this is called when loading configs
		// look at other mods how they load configs
		Object[] lo = FMLInjectionData.data();
		minecraftDir = (File)lo[6];
		
		//開発モード
		dirModsVersion = new File(dirMods, (String)lo[4]);
		Debug.addon("FileManager initialized.");
	}
	
	/**
	 * MOD Directoryに含まれる対象fileのオブジェクトを取得。
	 * @param pname 検索リスト名称、getFileList()で使う。
	 * @param pprefix この文字列の含まれるfileを列挙する。
	 * @return 列挙されたfileのリスト。
	 */
	public static List<File> getModFile(String pname, String pprefix) {
		// 検索済みかどうかの判定
		List<File> llist;
		if (fileList.containsKey(pname)) {
			llist = fileList.get(pname);
		} else {
			llist = new ArrayList<File>();
			fileList.put(pname, llist);
		}
		
		Debug.addon("getModFile:[%s]:%s", pname, dirMods.getAbsolutePath());
		// File Directory を検索
		try {
			if (dirMods.isDirectory()) {
				Debug.addon("getModFile-get:%d.", dirMods.list().length);
				for (File t : dirMods.listFiles()) {
					if (t.getName().indexOf(pprefix) != -1) {
						if (t.getName().endsWith(".zip") || t.getName().endsWith(".jar")) {
							llist.add(t);
							Debug.addon("getModFile-file:%s", t.getName());
						} else if (t.isDirectory()) {
							llist.add(t);
							Debug.addon("getModFile-file:%s", t.getName());
						}
					}
				}
				Debug.addon("getModFile-files:%d", llist.size());
			} else {
				// まずありえない
				Debug.addon("getModFile-fail.");
			}
		}
		catch (Exception exception) {
			Debug.addon("getModFile-Exception.");
		}
		return llist;

	}

	public static List<File> getAllmodsFiles(ClassLoader pClassLoader, boolean pFlag) {
		List<File> llist = new ArrayList<File>();
		if (pClassLoader instanceof URLClassLoader ) {
			for (URL lurl : ((URLClassLoader)pClassLoader).getURLs()) {
				try {
					String ls = lurl.toString();
					if (ls.endsWith("/bin/") || ls.indexOf("/mods/") > -1) {
						llist.add(new File(lurl.toURI()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (pFlag) {
			if (dirMods.exists()) {
				for (File lf : dirMods.listFiles()) {
					addList(llist, lf);
				}
			}
			if (dirModsVersion.exists()) {
				for (File lf : dirModsVersion.listFiles()) {
					addList(llist, lf);
				}
			}
		}
		files = llist;
		return llist;
	}
	
	protected static boolean addList(List<File> pList, File pFile) {
		for (File lf : pList) {
			try {
				if (pFile.getCanonicalPath().compareTo(lf.getCanonicalPath()) == 0) {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pList.add(pFile);
		return true;
	}
}
