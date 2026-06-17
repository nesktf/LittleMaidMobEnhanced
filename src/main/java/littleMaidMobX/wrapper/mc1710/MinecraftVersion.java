package littleMaidMobX.wrapper.mc1710;

import java.util.UUID;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityTameable;

import com.mojang.authlib.GameProfile;

import littleMaidMobX.wrapper.IMinecraftVersion;

public class MinecraftVersion implements IMinecraftVersion {

    public void setOwner(EntityTameable entity, String name) {
        entity.func_152115_b(name);
    }

    public String getOwnerName(IEntityOwnable entity) {
        return entity.func_152113_b();
    }

    public GameProfile newGameProfile(String UUIDid, String name) {
        return new GameProfile(UUID.randomUUID(), name);
    }

    public void notifyAdmins(ICommandSender p_152374_0_, ICommand p_152374_1_, int p_152374_2_, String p_152374_3_,
        Object... p_152374_4_) {
        CommandBase.func_152374_a(p_152374_0_, p_152374_1_, p_152374_2_, p_152374_3_, p_152374_4_);
    }
}
