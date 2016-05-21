package littleMaidMobX.util;

import littleMaidMobX.io.Config;

public class Debug
{
    private static String location()
    {
    	String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        return (className + "." + methodName + "(): " + lineNumber);
    }
    
    //Standard Prints
    public static void print(String pText, Object... pData)
	{
    	if (Config.isDebugAll)
    	{
			System.out.println(String.format("LMM: " + location() + "  " + pText, pData));
    	}
	}
    
    public static void print(String debugType, String pText, Object... pData)
    {
    	System.out.println(String.format(debugType + location() + "  " + pText, pData));
    }
    
    public static void print(boolean isRemote, String debugType, String pText, Object... pData)
	{
			System.out.println(String.format("["+(isRemote? "Client":"Server")+"] " + location() + "  " + pText, pData));
	}

    //Sound Debugging
	public static void sound(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugSound)
		{
			print("LMM Sound: ", pText, pData);
		}
	}
	
	//Entity Debugging
	public static void entity(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugEntity)
		{
			print("LMM Entity: ", pText, pData);
		}
	}
	
	public static void entity(boolean isRemote, String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugEntity)
		{
			print(isRemote, "LMM Entity: ", pText, pData);
		}
	}
	
	//GUI Debugging
	public static void gui(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugGui)
		{
			print("LMM GUI: ", pText, pData);
		}
	}
	
	//Add-on Debugging
	public static void addon(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugAddons)
		{
			print("LMM Add-on: ", pText, pData);
		}
	}
	
	//Model Debugging
	public static void model(String string, Object... pData)
	{
		if (Config.isDebugAll||Config.isDebugModels)
		{
			print("LMM Models: ", string, pData);
		}
	}
	
	//Texture Debugging
	public static void texture(String string, Object... pData)
	{
		if (Config.isDebugAll||Config.isDebugTextures)
		{
			print("LMM Textures: ", string, pData);
		}
	}
	
	//AI Debugging
	public static void ai(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugAI)
		{
			print("LMM AI: ", pText, pData);
		}
	}
	
	//Client Debugging
	public static void client(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugClient)
		{
			print("LMM Client: ", pText, pData);
		}
	}
	
	//Server Debugging
	public static void server(String pText, Object... pData)
	{
		if(Config.isDebugAll||Config.isDebugServer)
		{
			print("LMM Server: ", pText, pData);
		}
	}
}
