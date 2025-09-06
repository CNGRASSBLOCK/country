package top.warmc.country.town.player.country;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;
import top.warmc.country.core.pool.InvitePool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Invite {
    public static boolean Invite(CommandContext<CommandSourceStack> arguments, Player player) {
        if (player == null) return false;

        Entity entity;
        try { entity = EntityArgument.getEntity(arguments, "name"); } catch (CommandSyntaxException e) { throw new RuntimeException(e); }
        if (!(entity instanceof Player other_player)) { player.displayClientMessage(Component.literal("§6[Country]§4[error]§c错误:空实体!"), false); return false; }

        if (CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(player)) == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false); return false; }
        if (player.getUUID().equals(other_player.getUUID())) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c你不能邀请你自己!"), false); return false; }
        if (CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(other_player)) != null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c对方已有所属国!"), false); return false; }

        Town town = CountryPool.getTownFromPlayer(player);
        if (town == null) { player.displayClientMessage(Component.literal("§6[Country]§4[error]§c错误:town is null! 请联系管理员！"), false); return false; }
        if (!town.getAdmin().has(player.getUUID())) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c权限不足!"), false); return false; }

        top.warmc.country.core.classes.Invite invite = new top.warmc.country.core.classes.Invite(town, other_player, 300000);

        if (InvitePool.has(invite)) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c有未处理的邀请!"), false); return false; }

        InvitePool.add(invite);

        other_player.displayClientMessage(Component.literal("§8---------§6[Country]§8---------"), false);
        other_player.displayClientMessage(Component.literal(("§2" + entity.getDisplayName().getString() + "邀请您加入他们")), false);
        other_player.displayClientMessage(Component.literal("§2输入 \"/country invitations accept\" 同意 "), false);
        other_player.displayClientMessage(Component.literal("§c输入 \"/country invitations deny\" 拒绝"), false);
        other_player.displayClientMessage(Component.literal("§3该邀请将在1分钟后被撤回"), false);
        other_player.displayClientMessage(Component.literal("§8----------------------------"), false);

        player.displayClientMessage(Component.literal(("§6[Country]§2已向 " + other_player.getName() + " 发送邀请!")), false);
        return true;
    }
}
