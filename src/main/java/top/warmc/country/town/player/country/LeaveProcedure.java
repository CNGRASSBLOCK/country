//package top.warmc.country.procedures.player.country;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.network.chat.Component;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class LeaveProcedure {
//	public static void execute(Entity entity) {
//		if (entity == null)
//			return;
//		double number = 0;
//		double number_1 = 0;
//		List<String> player_list = new ArrayList<>();
//		boolean logic = false;
//		boolean logic_1 = false;
//		if (!CountryModVariables.country_owner.contains((entity.getStringUUID()))) {
//			number = 0;
//			logic = false;
//			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//				player_list.clear();
//				player_list.addAll((List) CountryModVariables.country_player.get((int) number));
//				if (player_list.contains((entity.getStringUUID()))) {
//					logic = true;
//					break;
//				}
//				number = number + 1;
//			}
//			if (logic) {
//		    	List<String> players = new ArrayList<>();
//		    	players.add((String) (entity.getStringUUID()));
//				player_list.removeAll(players);
//				CountryModVariables.country_player.set((int) number, player_list);
//				if (entity instanceof Player _player && !_player.level().isClientSide())
//					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A72\u9000\u51FA\u6210\u529F!"), false);
//			} else {
//				if (entity instanceof Player _player && !_player.level().isClientSide())
//					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A74\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6"), false);
//			}
//		} else {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A74\u60A8\u9700\u8981\u5C06\u4E3B\u6743\u8F6C\u79FB"), false);
//		}
//	}
//}
