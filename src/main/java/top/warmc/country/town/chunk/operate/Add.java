package top.warmc.country.town.chunk.operate;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;

import java.util.logging.Level;

public class Add {
	public static void add(Player player) {
        if (player == null) return;

        Town town = CountryPool.getTownFromPlayer(player);
        if (town == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立城镇!"), false); return; }

        if (CountryPool.getTownFromLand(player.level().getChunk(player.getOnPos())) != null) { player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§c该区块已被声明!"), false); return; }

        town.getLand().add(player.level(), player.level().getChunk(player.getOnPos()));

        player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§e声明成功!"), false);
    }
}
