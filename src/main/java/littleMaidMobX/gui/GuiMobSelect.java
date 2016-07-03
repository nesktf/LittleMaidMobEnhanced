package littleMaidMobX.gui;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.util.Debug;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public abstract class GuiMobSelect extends GuiScreen {

	public Map<String, Entity> entityMap;
	public static Map<Class, String> entityMapClass = new HashMap<Class, String>();
	public static List<String> exclusionList = new ArrayList<String>();
	
	protected String screenTitle;
	protected GuiSlot selectPanel;



	public GuiMobSelect(World pWorld) {
		entityMap = new TreeMap<String, Entity>();
		initEntitys(pWorld, true);
	}

	public GuiMobSelect(World pWorld, Map<String, Entity> pMap) {
		entityMap = pMap;
		initEntitys(pWorld, false);
	}


	public void initEntitys(World world, boolean pForce) {
		
		if (entityMapClass.isEmpty()) {
			try {
				Map lmap = EntityList.classToStringMapping;// (Map)ModLoader.getPrivateValue(EntityList.class, null, 1);
				entityMapClass.putAll(lmap);
			}
			catch (Exception e) {
				Debug.gui("EntityClassMap copy failed.");
			}
		}
		
		if (entityMap == null) return;
		if (!pForce && !entityMap.isEmpty()) return;
		
		for (Map.Entry<Class, String> le : entityMapClass.entrySet()) {
			if (Modifier.isAbstract(le.getKey().getModifiers())) continue;
			int li = 0;
			Entity lentity = null;
			try {
				
				do {
					lentity = (EntityLivingBase)le.getKey().getConstructor(World.class).newInstance(world);
//					lentity = (EntityLivingBase)EntityList.createEntityByName(le.getValue(), world);
				} while (lentity != null && checkEntity(le.getValue(), lentity, li++));
			} catch (Exception e) {
				Debug.gui("Entity [" + le.getValue() + "] can't created.");
			}
		}
	}

	
	protected boolean checkEntity(String pName, Entity pEntity, int pIndex) {
		entityMap.put(pName, pEntity);
		return false;
	}

	@Override
	public void initGui() {
		selectPanel = new GuiSlotMobSelect(mc, this);
		selectPanel.registerScrollButtons(3, 4);
	}

	@Override
	public void drawScreen(int px, int py, float pf) {
		float lhealthScale = BossStatus.healthScale;
		int lstatusBarLength = BossStatus.statusBarTime;
		String lbossName = BossStatus.bossName;
		boolean lfield_82825_d = BossStatus.hasColorModifier;
		
		drawDefaultBackground();
		selectPanel.drawScreen(px, py, pf);
		drawCenteredString(this.mc.fontRenderer, StatCollector.translateToLocal(screenTitle), width / 2, 20, 0xffffff);
		super.drawScreen(px, py, pf);
		
		
		BossStatus.healthScale = lhealthScale;
		BossStatus.statusBarTime = lstatusBarLength;
		BossStatus.bossName = lbossName;
		BossStatus.hasColorModifier = lfield_82825_d;
	}

	
	public abstract void clickSlot(int pIndex, boolean pDoubleClick, String pName, EntityLivingBase pEntity);

	
	public abstract void drawSlot(int pSlotindex, int pX, int pY, int pDrawheight, Tessellator pTessellator, String pName, Entity pEntity);
	
}
