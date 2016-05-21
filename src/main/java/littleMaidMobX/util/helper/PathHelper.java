package littleMaidMobX.util.helper;

import java.io.File;

public class PathHelper
{
	public static String getClassName(String path, String root)
	{
		if(!path.endsWith(".class"))
		{
				return null;
		}

		if(root!=null)
		{
			if(!root.isEmpty()&&path.startsWith(root))
			{
				path = path.substring(root.length());
			}
		}
		if(path.startsWith("/"))
		{
			path = path.substring(1);
		}
		if(path.endsWith(".class"))
		{
			path = path.substring(0,path.lastIndexOf(".class"));
		}
		return path.replace("/", ".");
	}
	
	public static String getRelativePathSimple(File basePath, File path)
	{
		String relativePath = path.getAbsolutePath();
		String basePathS = basePath.getAbsolutePath();
		if (relativePath.indexOf(basePathS) != 0)
		{
			return null;
		}
		relativePath = relativePath.substring(basePath.getAbsolutePath().length());
		while (relativePath.startsWith("/") || relativePath.startsWith("\\"))
		{
			relativePath = relativePath.substring(1);
		}
		return relativePath;
	}
	
	public static String getLinuxAntiDotName(String par1)
	{
		par1 = par1.replace("\\", "/").replace("/./", "/");
		if(par1.endsWith("/.")) par1.substring(0, par1.lastIndexOf("/."));
		return par1;
	}
	
	public static String getParentDir(String path)
	{
		if(path.endsWith("/.")) path=path.substring(0,path.length()-1);
		if(path.endsWith("/")) path=path.substring(0,path.length()-1);
		return path.substring(0,path.lastIndexOf("/"));
	}
	
	public static String getFileName(String path)
	{
		if (path.indexOf("/") == -1) return path;
		return path.substring(path.lastIndexOf("/")+1);
	}
}
