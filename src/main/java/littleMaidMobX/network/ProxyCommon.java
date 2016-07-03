package littleMaidMobX.network;

import littleMaidMobX.entity.EntityLittleMaidAvatar;
import littleMaidMobX.registry.ModelManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class ProxyCommon
{
	public void init() {}
	public void onItemPickup(EntityLittleMaidAvatar lmm_EntityLittleMaidAvatar,Entity entity, int i) {}
	public void onCriticalHit(EntityLittleMaidAvatar pAvatar, Entity par1Entity) {}
	public void onEnchantmentCritical(EntityLittleMaidAvatar pAvatar, Entity par1Entity) {}
	public void clientCustomPayload(Message var2) {}
	public EntityPlayer getClientPlayer(){ return null; }
	public void loadSounds(){}
	
	public void loadTextures()
	{
		ModelManager.instance.loadTextures(false);
	}
	
	public boolean isSinglePlayer()
	{
		return MinecraftServer.getServer().isSinglePlayer();
	}
}
