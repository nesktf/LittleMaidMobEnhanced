package littleMaidMobX.network;

import static littleMaidMobX.util.Statics.LMN_Client_PlaySound;
import static littleMaidMobX.util.Statics.LMN_Client_SetIFFValue;
import static littleMaidMobX.util.Statics.LMN_Client_SwingArm;
import littleMaidMobX.LittleMaidMobX;
import littleMaidMobX.aimodes.IFF;
import littleMaidMobX.entity.EntityDummy;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.entity.EntityLittleMaidAvatar;
import littleMaidMobX.entity.EntitySelect;
import littleMaidMobX.util.Debug;
import littleMaidMobX.util.helper.Helper;
import littleMaidMobX.render.RenderDummy;
import littleMaidMobX.render.RenderLittleMaid;
import littleMaidMobX.render.RenderModelMulti;
import littleMaidMobX.sound.EnumSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ProxyClient extends ProxyCommon
{

	public void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLittleMaid.class,new RenderLittleMaid(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySelect.class,	new RenderModelMulti(0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDummy.class,		new RenderDummy());

	}
	

// Avatarr
	
	public void onItemPickup(EntityLittleMaidAvatar pAvatar, Entity entity, int i) {
		
		
//        mc.effectRenderer.addEffect(new EntityPickupFX(mc.theWorld, entity, avatar, -0.5F));
		Helper.mc.effectRenderer.addEffect(new EntityPickupFX(Helper.mc.theWorld, entity, pAvatar.avatar, 0.1F));
	}

	public void onCriticalHit(EntityLittleMaidAvatar pAvatar, Entity par1Entity) {
		Helper.mc.effectRenderer.addEffect(new EntityCrit2FX(Helper.mc.theWorld, par1Entity));
	}

	public void onEnchantmentCritical(EntityLittleMaidAvatar pAvatar, Entity par1Entity) {
		EntityCrit2FX entitycrit2fx = new EntityCrit2FX(Helper.mc.theWorld, par1Entity, "magicCrit");
		Helper.mc.effectRenderer.addEffect(entitycrit2fx);
	}

	
// Network

	public void clientCustomPayload(Message var2) {
		
		byte lmode = var2.data[0];
		int leid = 0;
		EntityLittleMaid lemaid = null;
		if ((lmode & 0x80) != 0) {
			leid = Helper.getInt(var2.data, 1);
			lemaid =Net.getLittleMaid(var2.data, 1, Helper.mc.theWorld);
			if (lemaid == null) return;
		}
		Debug.client(String.format("LMM|Upd Clt Call[%2x:%d].", lmode, leid));
		
		switch (lmode) {
		case LMN_Client_SwingArm : 
			
			byte larm = var2.data[5];
			EnumSound lsound = EnumSound.getEnumSound(Helper.getInt(var2.data, 6));
			lemaid.setSwinging(larm, lsound);
//			mod_LMM_littleMaidMob.Debug(String.format("SwingSound:%s", lsound.name()));
			break;
			
		case LMN_Client_SetIFFValue:
			
			int lval = var2.data[1];
			int lindex = Helper.getInt(var2.data, 2);
			String lname = (String)IFF.DefaultIFF.keySet().toArray()[lindex];
			Debug.client("setIFF-CL %s(%d)=%d", lname, lindex, lval);
			IFF.setIFFValue(null, lname, lval);
			break;
			
		case LMN_Client_PlaySound : 
			
			EnumSound lsound9 = EnumSound.getEnumSound(Helper.getInt(var2.data, 5));
			lemaid.playLittleMaidSound(lsound9, true);
			Debug.sound(String.format("playSound:%s", lsound9.name()));
			break;
			
		}
	}

	public EntityPlayer getClientPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}


	public boolean isSinglePlayer()
	{
		return Minecraft.getMinecraft().isSingleplayer();
	}
}
