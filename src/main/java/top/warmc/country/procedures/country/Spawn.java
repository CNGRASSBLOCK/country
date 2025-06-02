//package top.warmc.country.procedures.country;
//
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.common.Mod;
//import top.warmc.country.classes.Country;
//import top.warmc.country.classes.CountryPool;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.network.chat.Component;
//
//@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
//public class Spawn {
//	public Spawn(Entity entity) {
//		if (!(entity instanceof Player player)) return;
//		Country country = CountryPool.getFromPlayer(player);
//		if (country == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false); return; }
//
//		country.spawn = player.getOnPos();
//		player.displayClientMessage(Component.literal("§6[Country]§3[player]§2设置成功!"), false);
//	}
//}
