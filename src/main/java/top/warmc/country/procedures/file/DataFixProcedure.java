//package top.warmc.country.procedures.file;
//
//import top.warmc.country.network.CountryModVariables;
//import top.warmc.country.CountryMod;
//
//import net.minecraft.world.InteractionResult;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class DataFixProcedure {
//	public static InteractionResult execute() {
//		int number_for_one_data = 0;
//		int main_list_long = 0;
//		int number_for_one_admin = 0;
//		String one_owner_uuid = "";
//		String one_admin_uuid = "";
//		number_for_one_data = CountryModVariables.country_name.size();
//		if (!(CountryModVariables.country_owner.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Owner data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_player.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Player data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_spawn_pos.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("SpawnPos data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_chucks.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Chuck data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_start.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Start data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_level.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Level data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_color.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Color data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_war.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("War data has problem");
//			return InteractionResult.FAIL;
//		}
//		if (!(CountryModVariables.country_admin.size() == number_for_one_data)) {
//			CountryMod.LOGGER.fatal("Admin data has problem");
//			return InteractionResult.FAIL;
//		}
//		number_for_one_data = 0;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			one_owner_uuid = (String) CountryModVariables.country_owner.get((int) number_for_one_data);
//			List<String> one_admin_list = new ArrayList<>();
//			one_admin_list.addAll((List) CountryModVariables.country_admin.get((int) number_for_one_data));
//			List<String> one_player_list = new ArrayList<>();
//			one_player_list.addAll((List) CountryModVariables.country_player.get((int) number_for_one_data));
//			if (!(one_admin_list.contains(one_owner_uuid))) {
//				CountryMod.LOGGER.warn(("Admin data don't has owner for " + CountryModVariables.country_name.get((int) number_for_one_data)));
//				one_admin_list.add(one_owner_uuid);
//				CountryMod.LOGGER.info("Fix Succesful");
//			}
//			if (!(one_player_list.contains(one_owner_uuid))) {
//				CountryMod.LOGGER.warn(("Player data don't has owner for " + CountryModVariables.country_name.get((int) number_for_one_data)));
//				one_player_list.add(one_owner_uuid);
//				CountryMod.LOGGER.info("Fix Succesful");
//			}
//			number_for_one_admin = 0;
//			for (int index1 = 0; index1 < (int) one_admin_list.size(); index1++) {
//				one_admin_uuid = (String) one_admin_list.get((int) number_for_one_admin);
//				if (!(one_player_list.contains(one_admin_uuid))) {
//					CountryMod.LOGGER.warn(("Player data don't has admin for " + CountryModVariables.country_name.get((int) number_for_one_data)));
//					one_player_list.add(one_admin_uuid);
//					CountryMod.LOGGER.info("Fix Succesful");
//				}
//				number_for_one_admin = number_for_one_admin + 1;
//			}
//			CountryModVariables.country_admin.set((int) number_for_one_data, one_admin_list);
//			CountryModVariables.country_player.set((int) number_for_one_data, one_player_list);
//			number_for_one_data = number_for_one_data + 1;
//		}
//		return InteractionResult.SUCCESS;
//	}
//}
