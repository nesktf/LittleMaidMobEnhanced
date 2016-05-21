package littleMaidMobX.util;

public class Statics
{

	
	public static final int dataWatch_Absoption		= 18;
	
	
	public static final int dataWatch_Color			= 19;
	
	public static final int dataWatch_Texture		= 20;
	
	public static final int dataWatch_Parts			= 21;
	
	public static final int dataWatch_Flags			= 22;
	public static final int dataWatch_Flags_looksWithInterest		= 0x00000001;
	public static final int dataWatch_Flags_looksWithInterestAXIS	= 0x00000002;
	public static final int dataWatch_Flags_Aimebow					= 0x00000004;
	public static final int dataWatch_Flags_Freedom					= 0x00000008;
	public static final int dataWatch_Flags_Tracer					= 0x00000010;
	public static final int dataWatch_Flags_remainsContract			= 0x00000020;
	public static final int dataWatch_Flags_PlayingMode				= 0x00000040;
	public static final int dataWatch_Flags_Working					= 0x00000080;
	public static final int dataWatch_Flags_Wait						= 0x00000100;
	public static final int dataWatch_Flags_WaitEx					= 0x00000200;
	public static final int dataWatch_Flags_LooksSugar				= 0x00000400;
	public static final int dataWatch_Flags_Bloodsuck				= 0x00000800;
	public static final int dataWatch_Flags_OverDrive				= 0x00001000;
	
	public static final int dataWatch_Gotcha			= 23;
	
	
	public static final int dataWatch_Mode			= 24;
	
	public static final int dataWatch_DominamtArm	= 25;
	
	public static final int dataWatch_ItemUse		= 26;
	
	public static final int dataWatch_ExpValue		= 27;
	
	
	public static final int dataWatch_AbsorptionAmount	= 28;
	
	
	
	public static final int dataWatch_Free			= 31;
	
	public static final int dataFlags_ForceUpdateInventory	= 0x80000000;

// NetWork

	
	
	
	
	public static final byte LMN_Server_UpdateSlots		= (byte)0x80;
	
	public static final byte LMN_Client_SwingArm		= (byte)0x81;
	
	public static final byte LMN_Server_DecDyePowder	= (byte)0x02;
	
	public static final byte LMN_Server_SetIFFValue		= (byte)0x04;
	
	public static final byte LMN_Client_SetIFFValue		= (byte)0x04;
	
	public static final byte LMN_Server_GetIFFValue		= (byte)0x05;
	
	public static final byte LMN_Server_SaveIFF			= (byte)0x06;
	
	public static final byte LMN_Client_PlaySound		= (byte)0x89;


}
