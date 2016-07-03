package littleMaidMobX.util.manager;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import cpw.mods.fml.relauncher.FMLInjectionData;
import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.PathHelper;
import littleMaidMobX.io.Config;
import littleMaidMobX.io.FileManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public abstract class ManagerBase
{
	protected abstract String getPreFix();
	/**
	 * 追加処理の本体
	 */
	protected abstract boolean append(Class pclass);


	protected void load() {
		// load
		
		// 開発用
		startSearch(FileManager.dirMods, false);
	}
	
	private void startSearch(File root, boolean dev){
		if(dev){
			if (root.isDirectory()) {
				// ディレクトリの解析
				decodeDirectory(root, root);
			} else {
				// Zipの解析
				decodeZip(root);
			}
			return;
		}
		
		// mods]
		String mcv = (String) FMLInjectionData.data()[4];
		Debug.addon("MC %s", mcv);
		Debug.addon("START SEARCH MODS FOLDER");
		decodeDirectory(root, root);
		for (File lf : root.listFiles()) {
			if (lf.isFile() && (lf.getName().endsWith(".zip") || lf.getName().endsWith(".jar"))) {
				// パッケージ
				decodeZip(lf);
			} else if (lf.isDirectory()) {
				// ディレクトリの解析
				String md = PathHelper.getLinuxAntiDotName(lf.getAbsolutePath());
				if (md.endsWith("/")) {
					md = md.substring(0, md.length()-1);
				}

				Debug.addon("DIR SEARCH %s", md);
				String mf = PathHelper.getFileName(md);
				Debug.addon(" SPLICE %s", mf);
				if (mf.equals(mcv)) {
					Debug.addon("DEBUG START SEARCH DIVIDED FOLDER");
					startSearch(lf, false);
				}
			}
		}
	}

	private void decodeDirectory(File pfile, File pRoot) {
		try {
			FileManager.COMMON_CLASS_LOADER.addURL(pRoot.toURI().toURL());
		} catch (MalformedURLException e) {
			return;
		}
		// ディレクトリ内のクラスを検索
		for (File lf : pfile.listFiles()) {
			if (lf.isFile()) {
				String lname = lf.getName();
				if (lname.indexOf(getPreFix()) >= 0 && lname.endsWith(".class")) {
					// 対象クラスファイルなのでロード
					//ディレクトリはパスを自動で治してくれないので、手動で。
					loadClass(PathHelper.getClassName(
							PathHelper.getLinuxAntiDotName(lf.getAbsolutePath()), 
							PathHelper.getLinuxAntiDotName(pRoot.getAbsolutePath())));
				}
			}else{
				//ディレクトリの場合は中身も捜索
				decodeDirectory(lf, pRoot);
			}
		}
	}

	private void decodeZip(File pfile) {
		// zipファイルを解析
		try {
			// 多分いらんと思う…
			FileManager.COMMON_CLASS_LOADER.addURL(pfile.toURI().toURL());
		} catch (MalformedURLException e) {
			return;
		}
		try {
			FileInputStream fileinputstream = new FileInputStream(pfile);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			
			do {
				zipentry = zipinputstream.getNextEntry();
				if(zipentry == null) {
					break;
				}
				if (!zipentry.isDirectory()) {
					String lname = zipentry.getName();
					if (lname.indexOf(getPreFix()) >= 0 && lname.endsWith(".class")) {
						loadClass(zipentry.getName());
					}
				}
			} while(true);
			
			zipinputstream.close();
			fileinputstream.close();
		}
		catch (Exception exception) {
			Debug.addon("add%sZip-Exception.", getPreFix());
		}
		
	}

	private void loadClass(String pname) {
		String lclassname = "";
		// 対象ファイルをクラスとしてロード
		try {
			Package lpackage = LittleMaidMobX.class.getPackage();
			lclassname = pname.endsWith(".class") ? pname.substring(0, pname.lastIndexOf(".class")) : pname;
			Class lclass;
			if(lpackage != null) {
	// TODO ★	lclassname = (new StringBuilder(String.valueOf(lpackage.getName()))).append(".").append(lclassname).toString();
				lclassname = lclassname.replace("/", ".");
// LMM_EntityModeManager でしか使ってないので暫定
				lclass = FileManager.COMMON_CLASS_LOADER.loadClass(lclassname);
			} else {
				lclass = Class.forName(lclassname);
			}
			if (Modifier.isAbstract(lclass.getModifiers()))
			{
				return;
			}
			if (append(lclass)) {
				Debug.addon("get%sClass-done: %s", getPreFix(), lclassname);
			} else {
				Debug.addon("get%sClass-fail: %s", getPreFix(), lclassname);
			}
			/*
            if (!(MMM_ModelStabilizerBase.class).isAssignableFrom(lclass) || Modifier.isAbstract(lclass.getModifiers())) {
            	MMMLib.Debug(String.format(String.format("get%sClass-fail: %s", pprefix, lclassname)));
                return;
            }
            
            MMM_ModelStabilizerBase lms = (MMM_ModelStabilizerBase)lclass.newInstance();
            pmap.put(lms.getName(), lms);
            MMMLib.Debug(String.format("get%sClass-done: %s[%s]", pprefix, lclassname, lms.getName()));
            */
		}
		catch (Exception exception) {
			Debug.addon("get%sClass-Exception.(%s)", getPreFix(), lclassname);
			if(Config.isDebugAll||Config.isDebugAddons) exception.printStackTrace();
		}
		catch (Error error) {
			Debug.addon("get%sClass-Error: %s", getPreFix(), lclassname);
			if(Config.isDebugAll||Config.isDebugAddons) error.printStackTrace();
		}
		
	}
	
	
}
