package top.warmc.country.country;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.pool.CountryPool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
//设置出生点
@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Spawn {
	public static void Spawn(Player player) {
        //防止空指针异常
        if (player == null) return;
		Country country = CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(player));
        //查询是否在国家内
		if (country == null) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false);
            return;
        }
        //查询权限，这里为啥是只有国主？
        if (!country.owner.equals(player.getUUID())) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有权限!"), false);
            return;
        }
        //执行设置出生点
        country.getTown(country.name).spawn = player.getOnPos();
        //结束弹出消息
		player.displayClientMessage(Component.literal("§6[Country]§3[player]§2设置成功!"), false);
	}
}
