//package top.warmc.country.procedures.other;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.entity.Entity;
//
//
//import net.minecraft.server.level.ServerLevel;
//
//import com.mojang.util.UUIDTypeAdapter;
//
//import java.util.List;
//import java.util.ArrayList;
//
//
//public class ResetPlayerAllDataProcedure {
//	public static void execute(LevelAccessor world, int number_for_my_country) {
//		List<String> my_country_player_list = new ArrayList<>();
//		my_country_player_list.clear();
//		my_country_player_list.addAll((List) CountryModVariables.country_player.get((int) number_for_my_country));
//		for (int index0 = 0; index0 < (int) my_country_player_list.size(); index0++) {
//			Entity player_entity = new Object() {
//				Entity getEntity(String uuid) {
//					Entity _uuidentity = null;
//					if (world instanceof ServerLevel _server) {
//						try {
//							_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
//						} catch (IllegalArgumentException e) {
//						}
//					}
//					return _uuidentity;
//				}
//			}.getEntity((String) my_country_player_list.get(index0));
//			if (!(player_entity == null)) {
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.disband_tick = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.spawn_laster_pos_x = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.spawn_laster_pos_y = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.spawn_laster_pos_z = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.spawn_particle_tick = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.war_chuck_occupied_time = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.war_chuck_occupied_my_country = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.war_chuck_occupied_other_country = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.surrender_tick = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.country_invite_spend_time = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//				{
//					double _setval = 0;
//					player_entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.country_invite_cooling = _setval;
//						capability.syncPlayerVariables(player_entity);
//					});
//				}
//			}
//		}
//	}
//}
