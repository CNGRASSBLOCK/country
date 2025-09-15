package top.warmc.country.country;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.pool.CountryPool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import net.minecraft.world.level.LevelAccessor;
//删除国家
@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Disband {
	public static void Disband(LevelAccessor world, Player player) {
        //防止空指针异常
        if (player == null) return;
        //查询玩家是否在国家内ps.又开始了
		Country country = CountryPool.getCountryFromTown(CountryPool.getTownFromPlayer(player));
		if (country == null) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false);
            return;
        }
        //查询玩家是否是国主
		if (!country.owner.equals(player.getUUID())) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有权限!"), false);
            return;
        }
        //检查是否在战争状态
		if (!country.war.isEmpty()) {
            player.displayClientMessage(Component.literal("§6[Country]§c[war]§c您不能在战争时解散国家!"), false);
            return;
        }
        //解散
		CountryPool.remove(country);
        //结束，发送信息
		player.displayClientMessage(Component.literal("§6[Country]§3[player]§c国家已解散!"), false);
		world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("§6[Country]§3[player]§c国家 %s 已被解散".formatted(country.name)), false);
	}
}
