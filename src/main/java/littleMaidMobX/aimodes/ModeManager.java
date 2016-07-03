package littleMaidMobX.aimodes;

import java.util.ArrayList;
import java.util.List;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.io.FileManager;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.manager.ManagerBase;

public class ModeManager extends ManagerBase
{
	public static ModeManager instance = new ModeManager();

	public static final String prefix = "EntityMode";
	public static List<ModeBase> maidModeList = new ArrayList<ModeBase>();

	public ModeManager()
	{
		append(Mode_Archer.class);
		append(Mode_BookDecorder.class);
		append(Mode_Fencer.class);
		append(Mode_Healer.class);
		append(Mode_Playing.class);
		append(Mode_Ripper.class);
		append(Mode_Test.class);
		append(Mode_Torcher.class);
		append(Mode_Cooking.class);
		append(Mode_Pharmacist.class);
		append(Mode_Miner.class);
		append(Mode_Basic.class);
		append(Mode_Farmer.class);
	}
	
	public static void init()
	{
		// 特定名称をプリフィックスに持つmodファイをを獲得
		FileManager.getModFile("EntityMode", prefix);
	}
	
	public static void loadEntityMode()
	{
		(new ModeManager()).load();
	}

	@Override
	protected String getPreFix()
	{
		return prefix;
	}
	
	protected boolean append(Class pclass) {
		// Priority 順に追加
		// uses sort？
		if (!ModeBase.class.isAssignableFrom(pclass)) {
			return false;
		}
		
		try {
			ModeBase lemb = null;
			lemb = (ModeBase)pclass.getConstructor(EntityLittleMaid.class).newInstance((EntityLittleMaid)null);
			lemb.init();
			
			//既存
			if(maidModeList.contains(lemb)) return false;
			
			if (maidModeList.isEmpty() || lemb.priority() >= maidModeList.get(maidModeList.size() - 1).priority()) {
				maidModeList.add(lemb);
			} else {
				for (int li = 0; li < maidModeList.size(); li++) {
					if (lemb.priority() < maidModeList.get(li).priority()) {
						maidModeList.add(li, lemb);
						break;
					}
				}
			}

			return true;
		} catch (Exception e) {
		} catch (Error e) {
		}

		return false;
	}
	
	/**
	 * AI追加用のリストを獲得。 
	 */
	public List<ModeBase> getModeList(EntityLittleMaid pentity) {
		List<ModeBase> llist = new ArrayList<ModeBase>();
		for (ModeBase lmode : maidModeList) {
			try {
				llist.add(lmode.getClass().getConstructor(EntityLittleMaid.class).newInstance(pentity));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return llist;
	}
	
	/**
	 * ロードされているモードリストを表示する。
	 */
	public static void showLoadedModes() {
		Debug.addon("Loaded Mode lists(%d)", maidModeList.size());
		for (ModeBase lem : maidModeList) {
			Debug.addon("%04d : %s", lem.priority(), lem.getClass().getSimpleName());
		}
	}
}
