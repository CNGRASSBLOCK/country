//package top.warmc.country.procedures.player.country;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class GospawnProcedure {
//	public static InteractionResult execute(double x, double y, double z, Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		boolean logic = false;
//		double number = 0;
//		List<String> player_list = new ArrayList<>();
//		if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick > 0) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u5C1A\u5728\u5904\u7406\u7684\u8BF7\u6C42!"), false);
//			return InteractionResult.PASS;
//		}
//		number = 0;
//		logic = false;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			player_list.clear();
//			player_list.addAll((List) CountryModVariables.country_player.get((int) number));
//			if (player_list.contains((entity.getStringUUID()))) {
//				logic = true;
//				break;
//			}
//			number = number + 1;
//		}
//		if (!logic) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
//			return InteractionResult.PASS;
//		}
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A72\u4F20\u9001\u4E2D!"), false);
//		{
//			double _setval = 100;
//			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//				capability.spawn_particle_tick = _setval;
//				capability.syncPlayerVariables(entity);
//			});
//		}
//		{
//			double _setval = x;
//			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//				capability.spawn_laster_pos_x = _setval;
//				capability.syncPlayerVariables(entity);
//			});
//		}
//		{
//			double _setval = y;
//			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//				capability.spawn_laster_pos_y = _setval;
//				capability.syncPlayerVariables(entity);
//			});
//		}
//		{
//			double _setval = z;
//			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//				capability.spawn_laster_pos_z = _setval;
//				capability.syncPlayerVariables(entity);
//			});
//		}
//		return InteractionResult.SUCCESS;
//	}
//}
