package littleMaidMobX.aimodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import littleMaidMobX.util.helper.Helper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class TriggerSelect {

	public static List<String> selector = new ArrayList<String>();
	public static Map<String, Map<Integer, List<Item>>> usersTrigger = new HashMap<String, Map<Integer,List<Item>>>();
	public static Map<Integer, List<Item>> defaultTrigger = new HashMap<Integer,List<Item>>();


	public static Map<Integer, List<Item>> getUserTrigger(String pUsername) {
		if (pUsername == null) {
			return defaultTrigger;
		}
		if (Helper.isLocalPlay()) {
			
			pUsername = "";
		}
		
		if (!usersTrigger.containsKey(pUsername)) {
			if (pUsername.isEmpty()) {
				
				usersTrigger.put(pUsername, defaultTrigger);
			} else {
				Map<Integer, List<Item>> lmap = new HashMap<Integer, List<Item>>();
				lmap.putAll(defaultTrigger);
				usersTrigger.put(pUsername, lmap);
			}
		}
		
		return usersTrigger.get(pUsername);
	}

	public static List<Item> getuserTriggerList(String pUsername, String pSelector) {
		if (!selector.contains(pSelector)) {
			selector.add(pSelector);
		}
		int lindex = selector.indexOf(pSelector);
		Map<Integer, List<Item>> lmap = getUserTrigger(pUsername);
		List<Item> llist;
		if (lmap.containsKey(lindex)) {
			llist = lmap.get(lindex);
		} else {
			llist = new ArrayList<Item>();
			lmap.put(lindex, llist);
		}
		return llist;
	}


	
	public static void appendTriggerItem(String pUsername, String pSelector, String pIndexstr) {
		
		appendWeaponsIndex(pIndexstr, getuserTriggerList(pUsername, pSelector));
	}

	
	private static void appendWeaponsIndex(String indexstr, List<Item> indexlist) {
		if (indexstr.isEmpty()) return;
		String[] s = indexstr.split(",");
		for (String t : s) {
			Object o = Item.itemRegistry.getObject(t);
			if(o instanceof Item)
			{
				indexlist.add((Item)o);
			}
		}
	}

	
	public static boolean checkItem(String pUsername, String pSelector, ItemStack pItemStack) {
		if (!selector.contains(pSelector)) {
			return false;
		}
		if (Helper.isLocalPlay()) {
			return getuserTriggerList(null, pSelector).contains(pItemStack.getItem());
		}
		if (!usersTrigger.containsKey(pUsername)) {
			return false;
		}
		return getuserTriggerList(pUsername, pSelector).contains(pItemStack.getItem());
	}

}
