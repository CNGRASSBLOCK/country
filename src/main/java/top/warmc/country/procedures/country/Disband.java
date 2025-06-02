//package top.warmc.country.procedures.country;
//
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.common.Mod;
//import top.warmc.country.classes.Country;
//import top.warmc.country.classes.CountryPool;
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//
//import net.minecraft.world.level.LevelAccessor;
//import top.warmc.country.procedures.other.ResetPlayerAllDataProcedure;
//
//@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
//public class Disband {
//	public static void Disband(LevelAccessor world, Entity entity) {
//		if (!(entity instanceof Player player) || world.isClientSide() || world.getServer() == null) return;
//		Country country = CountryPool.getFromPlayer(player);
//		if (country == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立国家!"), false); return; }
//
//		if (!country.owner.equals(player.getUUID())) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有权限!"), false); return; }
//		if (!country.state.equals("peace")) { player.displayClientMessage(Component.literal("§6[Country]§c[war]§c您不能在战争时解散国家!"), false); }
//
//		CountryPool.remove(country);
//
//		player.displayClientMessage(Component.literal("§6[Country]§3[player]§c国家已解散!"), false);
//		world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("§6[Country]§3[player]§c国家 %s 已被解散".formatted(country.name)), false);
//	}
//}
