package littleMaidMobX.network;

import static littleMaidMobX.util.Statics.LMN_Client_SetIFFValue;
import static littleMaidMobX.util.Statics.LMN_Server_DecDyePowder;
import static littleMaidMobX.util.Statics.LMN_Server_GetIFFValue;
import static littleMaidMobX.util.Statics.LMN_Server_SaveIFF;
import static littleMaidMobX.util.Statics.LMN_Server_SetIFFValue;
import static littleMaidMobX.util.Statics.LMN_Server_UpdateSlots;
import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.aimodes.IFF;
import littleMaidMobX.aimodes.SwingStatus;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Net {
	
	
	public static void sendToAllEClient(EntityLittleMaid pEntity, byte[] pData)
	{
		Helper.setInt(pData, 1, pEntity.getEntityId());
		
		EntityTracker et = ((WorldServer)pEntity.worldObj).getEntityTracker();
		for(EntityPlayer player : et.getTrackingPlayers(pEntity))
		{
			Network.sendPacketToPlayer(2, player, pData);
		}
//		((WorldServer)pEntity.worldObj).getEntityTracker().func_151248_b(pEntity, new Packet250CustomPayload("LMM|Upd", pData));
	}

	

	public static void sendToClient(EntityPlayer player, byte[] pData) {
		Network.sendPacketToPlayer(2, player, pData);
//		ModLoader.serverSendPacket(pHandler, new Packet250CustomPayload("LMM|Upd", pData));
	}

	
	public static void sendToEServer(EntityLittleMaid pEntity, byte[] pData) {
		Helper.setInt(pData, 1, pEntity.getEntityId());
		Network.sendPacketToServer(2,pData);
//		ModLoader.clientSendPacket(new Packet250CustomPayload("LMM|Upd", pData));
		Debug.server(String.format("LMM|Upd:send:%2x:%d", pData[0], pEntity.getEntityId()));
	}

	public static void sendToServer(byte[] pData) {
		Network.sendPacketToServer(2, pData);
//		ModLoader.clientSendPacket(new Packet250CustomPayload("LMM|Upd", pData));
		Debug.server(String.format("LMM|Upd:%2x:NOEntity", pData[0]));
	}

	
	public static void saveIFF() {
		sendToServer(new byte[] {LMN_Server_SaveIFF});
	}

	
	public static EntityLittleMaid getLittleMaid(byte[] pData, int pIndex, World pWorld)
	{
		Entity lentity = Helper.getEntity(pData, pIndex, pWorld);
		if (lentity instanceof EntityLittleMaid)
		{
			return (EntityLittleMaid)lentity;
		}
		else
		{
			return null;
		}
	}

	
	
	public static void serverCustomPayload(EntityPlayer playerEntity, Message pPayload)
	{
		
		byte lmode = pPayload.data[0];
		int leid = 0;
		EntityLittleMaid lemaid = null;
		if ((lmode & 0x80) != 0) {
			leid = Helper.getInt(pPayload.data, 1);
			lemaid = getLittleMaid(pPayload.data, 1, playerEntity.worldObj);
			if (lemaid == null) return;
		}
		Debug.server(String.format("LMM|Upd Srv Call[%2x:%d].", lmode, leid));
		byte[] ldata;
		int lindex;
		int lval;
		String lname;
		
		switch (lmode) {
		case LMN_Server_UpdateSlots : 
			
			
			lemaid.maidInventory.clearChanged();
			for (SwingStatus lswing : lemaid.mstatSwingStatus) {
				lswing.lastIndex = -1;
			}
			break;
			
		case LMN_Server_DecDyePowder:
			
			
			int lcolor2 = pPayload.data[1];
			if (!playerEntity.capabilities.isCreativeMode) {
				for (int li = 0; li < playerEntity.inventory.mainInventory.length; li++) {
					ItemStack lis = playerEntity.inventory.mainInventory[li];
					if (lis != null && lis.getItem() == Items.dye) {
						if (lis.getItemDamage() == (15 - lcolor2)) {
							Helper.decPlayerInventory(playerEntity, li, 1);
						}
					}
				}
			}
			break;
			
		case LMN_Server_SetIFFValue:
			
			lval = pPayload.data[1];
			lindex = Helper.getInt(pPayload.data, 2);
			lname = Helper.getStr(pPayload.data, 6);
			Debug.server("setIFF-SV user:%s %s(%d)=%d", Helper.getPlayerName(playerEntity), lname, lindex, lval);
			IFF.setIFFValue(Helper.getPlayerName(playerEntity), lname, lval);
			sendIFFValue(playerEntity, lval, lindex);
			break;
		case LMN_Server_GetIFFValue:
			// IFFGUI open
			lindex = Helper.getInt(pPayload.data, 1);
			lname = Helper.getStr(pPayload.data, 5);
			lval = IFF.getIFF(Helper.getPlayerName(playerEntity), lname, playerEntity.worldObj);
			Debug.server("getIFF-SV user:%s %s(%d)=%d", Helper.getPlayerName(playerEntity), lname, lindex, lval);
			sendIFFValue(playerEntity, lval, lindex);
			break;
		case LMN_Server_SaveIFF:
			
			IFF.saveIFF(Helper.getPlayerName(playerEntity));
			if (!playerEntity.worldObj.isRemote) {
				IFF.saveIFF("");
			}
			break;
			
		}
	}

	
	protected static void sendIFFValue(EntityPlayer player, int pValue, int pIndex) {
		byte ldata[] = new byte[] {
				LMN_Client_SetIFFValue,
				0,
				0, 0, 0, 0
		};
		ldata[1] = (byte)pValue;
		Helper.setInt(ldata, 2, pIndex);
		sendToClient(player, ldata);
	}
}
