//package top.warmc.country.procedures.file;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraftforge.fml.loading.FMLPaths;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.eventbus.api.Event;
//
//import net.minecraft.world.level.LevelAccessor;
//
//import javax.annotation.Nullable;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import java.io.IOException;
//import java.io.FileWriter;
//import java.io.File;
//import java.io.BufferedWriter;
//
//@Mod.EventBusSubscriber
//public class SaveDataProcedure {
//	@SubscribeEvent
//	public static void onWorldUnload(net.minecraftforge.event.level.LevelEvent.Unload event) {
//		execute(event, event.getLevel());
//	}
//
//	public static void execute(LevelAccessor world) {
//		execute(null, world);
//	}
//
//	private static void execute(@Nullable Event event, LevelAccessor world) {
//		if (world.isClientSide()) {
//			return;
//		}
//		String country_name = "";
//		String country_owner = "";
//		String country_start = "";
//		String country_color = "";
//		double country_level = 0;
//		int main_file_for_number = 0;
//		int info_file_for_number = 0;
//		int war_one_data_for_number = 0;
//		int player_file_for_number = 0;
//		int player_one_uuid_for_number = 0;
//		int admin_file_for_number = 0;
//		int admin_one_uuid_for_number = 0;
//		int chuck_one_pos_for_number = 0;
//		int chuck_file_for_number = 0;
//		File main_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country"), File.separator + ("main" + ".txt"));
//		if (!main_file.exists()) {
//			try {
//				main_file.getParentFile().mkdirs();
//				main_file.createNewFile();
//			} catch (IOException exception) {
//				exception.printStackTrace();
//			}
//		}
//		try {
//			FileWriter main_filewriter = new FileWriter(main_file, false);
//			BufferedWriter main_filebw = new BufferedWriter(main_filewriter);
//			{
//				main_filebw.write("country:");
//				main_filebw.newLine();
//			}
//			main_file_for_number = 0;
//			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//				{
//					main_filebw.write(("" + CountryModVariables.country_name.get((int) main_file_for_number)));
//					main_filebw.newLine();
//				}
//				main_file_for_number = main_file_for_number + 1;
//			}
//			main_filebw.close();
//			main_filewriter.close();
//		} catch (IOException exception) {
//			exception.printStackTrace();
//		}
//		info_file_for_number = 0;
//		for (int index1 = 0; index1 < (int) CountryModVariables.country_name.size(); index1++) {
//			country_name = "" + CountryModVariables.country_name.get((int) info_file_for_number);
//			File country_info_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/info"), File.separator + (country_name + ".json"));
//			com.google.gson.JsonObject info_main_json = new com.google.gson.JsonObject();
//			if (!country_info_file.exists()) {
//				try {
//					country_info_file.getParentFile().mkdirs();
//					country_info_file.createNewFile();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			info_main_json.addProperty("owner", ("" + CountryModVariables.country_owner.get((int) info_file_for_number)));
//			List<Double> country_spawn_pos = new ArrayList<>();
//			country_spawn_pos.addAll((List) CountryModVariables.country_spawn_pos.get((int) info_file_for_number));
//			info_main_json.addProperty("spawn_pos_x", new Object() {
//				double convert(String s) {
//					try {
//						return Double.parseDouble(s.trim());
//					} catch (Exception e) {
//					}
//					return 0;
//				}
//			}.convert("" + country_spawn_pos.get(0)));
//			info_main_json.addProperty("spawn_pos_y", new Object() {
//				double convert(String s) {
//					try {
//						return Double.parseDouble(s.trim());
//					} catch (Exception e) {
//					}
//					return 0;
//				}
//			}.convert("" + country_spawn_pos.get(1)));
//			info_main_json.addProperty("spawn_pos_z", new Object() {
//				double convert(String s) {
//					try {
//						return Double.parseDouble(s.trim());
//					} catch (Exception e) {
//					}
//					return 0;
//				}
//			}.convert("" + country_spawn_pos.get(2)));
//			info_main_json.addProperty("start", ("" + CountryModVariables.country_start.get((int) info_file_for_number)));
//			info_main_json.addProperty("color", ((String) CountryModVariables.country_color.get((int) info_file_for_number)));
//			info_main_json.addProperty("level", (int) new Object() {
//				double convert(String s) {
//					try {
//						return Double.parseDouble(s.trim());
//					} catch (Exception e) {
//					}
//					return 0;
//				}
//			}.convert("" + CountryModVariables.country_level.get((int) info_file_for_number)));
//			List<List> country_war = new ArrayList<>();
//			country_war.addAll((List) CountryModVariables.country_war.get((int) info_file_for_number));
//			if (!country_war.isEmpty()) {
//				com.google.gson.JsonObject info_war_file = new com.google.gson.JsonObject();
//				war_one_data_for_number = 0;
//				for (int index2 = 0; index2 < (int) country_war.size(); index2++) {
//					List<String> country_war_one_data = new ArrayList<>();
//					com.google.gson.JsonObject info_war_file_one_data = new com.google.gson.JsonObject();
//					country_war_one_data.addAll((List) country_war.get((int) war_one_data_for_number));
//					info_war_file_one_data.addProperty("other_country_name", ("" + country_war_one_data.get(0)));
//					info_war_file_one_data.addProperty("type", ("" + country_war_one_data.get(1)));
//					info_war_file.add(("the_" + (int) war_one_data_for_number + "_data"), info_war_file_one_data);
//					war_one_data_for_number = war_one_data_for_number + 1;
//				}
//				info_main_json.add("war", info_war_file);
//			}
//			{
//				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
//				try {
//					FileWriter fileWriter = new FileWriter(country_info_file);
//					fileWriter.write(mainGSONBuilderVariable.toJson(info_main_json));
//					fileWriter.close();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			info_file_for_number = info_file_for_number + 1;
//		}
//		player_file_for_number = 0;
//		for (int index3 = 0; index3 < (int) CountryModVariables.country_name.size(); index3++) {
//			country_name = "" + CountryModVariables.country_name.get((int) player_file_for_number);
//			com.google.gson.JsonObject player_main_json = new com.google.gson.JsonObject();
//			File country_players_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/player"), File.separator + (country_name + ".json"));
//			if (!country_players_file.exists()) {
//				try {
//					country_players_file.getParentFile().mkdirs();
//					country_players_file.createNewFile();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			List<String> country_player_list = new ArrayList<>();
//			country_player_list.addAll((List) CountryModVariables.country_player.get((int) player_file_for_number));
//			player_one_uuid_for_number = 0;
//			for (int index4 = 0; index4 < (int) country_player_list.size(); index4++) {
//				player_main_json.addProperty(("the_" + (int) player_one_uuid_for_number + "_uuid"), ((String) country_player_list.get((int) player_one_uuid_for_number)));
//				player_one_uuid_for_number = player_one_uuid_for_number + 1;
//			}
//			{
//				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
//				try {
//					FileWriter fileWriter = new FileWriter(country_players_file);
//					fileWriter.write(mainGSONBuilderVariable.toJson(player_main_json));
//					fileWriter.close();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			player_file_for_number = player_file_for_number + 1;
//		}
//		admin_file_for_number = 0;
//		for (int index3 = 0; index3 < (int) CountryModVariables.country_name.size(); index3++) {
//			country_name = "" + CountryModVariables.country_name.get((int) admin_file_for_number);
//			com.google.gson.JsonObject admin_main_json = new com.google.gson.JsonObject();
//			File country_admins_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/admin"), File.separator + (country_name + ".json"));
//			if (!country_admins_file.exists()) {
//				try {
//					country_admins_file.getParentFile().mkdirs();
//					country_admins_file.createNewFile();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			List<String> country_admin_list = new ArrayList<>();
//			country_admin_list.addAll((List) CountryModVariables.country_admin.get((int) admin_file_for_number));
//			admin_one_uuid_for_number = 0;
//			for (int index4 = 0; index4 < (int) country_admin_list.size(); index4++) {
//				admin_main_json.addProperty(("the_" + (int) admin_one_uuid_for_number + "_uuid"), ((String) country_admin_list.get((int) admin_one_uuid_for_number)));
//				admin_one_uuid_for_number = admin_one_uuid_for_number + 1;
//			}
//			{
//				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
//				try {
//					FileWriter fileWriter = new FileWriter(country_admins_file);
//					fileWriter.write(mainGSONBuilderVariable.toJson(admin_main_json));
//					fileWriter.close();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			admin_file_for_number = admin_file_for_number + 1;
//		}
//		chuck_file_for_number = 0;
//		for (int index5 = 0; index5 < (int) CountryModVariables.country_name.size(); index5++) {
//			country_name = "" + CountryModVariables.country_name.get((int) chuck_file_for_number);
//			com.google.gson.JsonObject chuck_main_json = new com.google.gson.JsonObject();
//			File country_chucks_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/chuck"), File.separator + (country_name + ".json"));
//			if (!country_chucks_file.exists()) {
//				try {
//					country_chucks_file.getParentFile().mkdirs();
//					country_chucks_file.createNewFile();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			List<List> country_chucks = new ArrayList<>();
//			country_chucks.addAll((List) CountryModVariables.country_chucks.get((int) chuck_file_for_number));
//			chuck_one_pos_for_number = 0;
//			for (int index6 = 0; index6 < (int) country_chucks.size(); index6++) {
//				List<Integer> country_chuck_pos = new ArrayList<>();
//				country_chuck_pos.addAll((List) country_chucks.get((int) chuck_one_pos_for_number));
//				chuck_main_json.addProperty(("the_" + (int) chuck_one_pos_for_number + "_chuck_pos"), ((int) country_chuck_pos.get(0) + "," + (int) country_chuck_pos.get(1)));
//				chuck_one_pos_for_number = chuck_one_pos_for_number + 1;
//			}
//			{
//				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
//				try {
//					FileWriter fileWriter = new FileWriter(country_chucks_file);
//					fileWriter.write(mainGSONBuilderVariable.toJson(chuck_main_json));
//					fileWriter.close();
//				} catch (IOException exception) {
//					exception.printStackTrace();
//				}
//			}
//			chuck_file_for_number = chuck_file_for_number + 1;
//		}
//	}
//}
