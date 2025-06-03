package top.warmc.country.procedures.country;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.pool.CountryPool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Spawn {
	public static boolean Spawn(Player player) {
        if (player == null) return false;
		Country country = CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(player));
		if (country == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false); return false; }

		country.getTown(country.name).spawn = player.getOnPos();
		player.displayClientMessage(Component.literal("§6[Country]§3[player]§2设置成功!"), false);
        return true;
	}
}
