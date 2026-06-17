package littleMaidMobX;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.entity.EntityLittleMaidAvatar;

public class EventHook {

    public static boolean isLiving(Entity e) {
        return e instanceof EntityLiving;
    }

    public static boolean isLivingBase(Entity e) {
        return e instanceof EntityLivingBase;
    }

    public static boolean isAvatar(Entity e) {
        return e instanceof EntityLittleMaidAvatar;
    }

    public static boolean isMaid(Entity e) {
        return e instanceof EntityLittleMaid;
    }

    @SubscribeEvent
    public void onEntityItemPickupEvent(EntityItemPickupEvent event) {
        if (event.entityPlayer instanceof EntityLittleMaidAvatar) {
            if (event.item != null && LittleMaidMobX.isMaidIgnoreItem(event.item.getEntityItem())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onEntitySpawned(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityArrow) {
            EntityArrow arrow = (EntityArrow) event.entity;
            if (arrow.shootingEntity instanceof EntityLittleMaidAvatar) {
                EntityLittleMaidAvatar avatar = (EntityLittleMaidAvatar) arrow.shootingEntity;
                arrow.shootingEntity = avatar.avatar;
            }
        }
    }

    @SubscribeEvent
    public void onLivingSetAttacktarget(LivingSetAttackTargetEvent event) {
        if (isLiving(event.entity) && isAvatar(((EntityLiving) event.entity).getAttackTarget())) {
            EntityLittleMaidAvatar avatar = (EntityLittleMaidAvatar) event.target;
            ((EntityLiving) event.entity).setAttackTarget(avatar.avatar);
        }
        if (isLivingBase(event.entity) && isAvatar(((EntityLivingBase) event.entity).getAITarget())) {
            EntityLittleMaidAvatar avatar = (EntityLittleMaidAvatar) event.target;
            ((EntityLivingBase) event.entity).setRevengeTarget(avatar.avatar);
        }
    }
}
