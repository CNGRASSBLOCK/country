package top.warmc.country.procedures.file;

//import top.warmc.country.procedures.file.DataFixProcedure;


//@Mod.EventBusSubscriber
//public class ReadDataProcedure {
//	public static void execute() {
//		File main_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country"), File.separator + ("main" + ".txt"));
//		List<String> country_names = new ArrayList<>();
//
//		if (!main_file.exists()) {
//			try {
//				main_file.getParentFile().mkdirs();
//				main_file.createNewFile();
//			} catch (IOException exception) {
//				exception.printStackTrace();
//			}
//		} else {
//			try {
//				BufferedReader main_fileReader = new BufferedReader(new FileReader(main_file));
//				String stringiterator = "";
//				while ((stringiterator = main_fileReader.readLine()) != null) {
//					if (!(stringiterator).equals("country:")) {
//						country_names.add(stringiterator);
//					}
//				}
//				main_fileReader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			for (String country_name : country_names) {
//				File country_info_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/info"), File.separator + (country_names + ".json"));
//				Country country = null;
//				if (!country_info_file.exists()) {
//					country = new Country(country_name, new UUID(0, 0));
//					CountryMod.LOGGER.error(("[Country] Can't find %s in info file".formatted(country_name)));
//				} else {
//					{
//						try {
//							BufferedReader bufferedReader = new BufferedReader(new FileReader(country_info_file));
//							StringBuilder jsonstringbuilder = new StringBuilder();
//							String line;
//							while ((line = bufferedReader.readLine()) != null) {
//								jsonstringbuilder.append(line);
//							}
//							bufferedReader.close();
//							JsonObject info_main_json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
//
//							country = new Country(country_name, new UUID(0, 0));
//
//							if (info_main_json.has("owner") && !info_main_json.get("owner").getAsString().isEmpty())
//								country.owner = UUID.fromString(info_main_json.get("owner").getAsString());
//							if (info_main_json.has("spawn_pos_x") && info_main_json.has("spawn_pos_y") && info_main_json.has("spawn_pos_z"))
//								country.spawn = new BlockPos((int) info_main_json.get("spawn_pos_x").getAsDouble(), (int) info_main_json.get("spawn_pos_y").getAsDouble(), (int) info_main_json.get("spawn_pos_z").getAsDouble());
//
//							if (info_main_json.has("start")) country.state = info_main_json.get("start").getAsString();
//							if (info_main_json.has("color")) country.color = info_main_json.get("color").getAsString();
//							if (info_main_json.has("level"))
//								country.level = (int) info_main_json.get("level").getAsDouble();
//
//							if (info_main_json.has("war")) {
//								List<List> country_war = new ArrayList<>();
//								info_war_file = info_main_json.get("war").getAsJsonObject();
//								war_one_data_for_number = 0;
//								for (int index1 = 0; index1 < (int) info_war_file.size(); index1++) {
//									info_war_file_one_data = info_war_file.get(("the_" + (int) war_one_data_for_number + "_data")).getAsJsonObject();
//									List<String> country_war_one_data = new ArrayList<>();
//									country_war_one_data.add((String) info_war_file_one_data.get("other_country_name").getAsString());
//									country_war_one_data.add((String) info_war_file_one_data.get("type").getAsString());
//									country_war.add((List) country_war_one_data);
//									war_one_data_for_number = war_one_data_for_number + 1;
//								}
//								CountryModVariables.country_war.add(country_war);
//							} else {
//								List<List> country_war = new ArrayList<>();
//								CountryModVariables.country_war.add(country_war);
//							}
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//
//				info_file_for_number = 0;
//				for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//					country_names = "" + CountryModVariables.country_name.get((int) info_file_for_number);
//					File country_info_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/info"), File.separator + (country_names + ".json"));
//					if (!country_info_file.exists()) {
//						CountryMod.LOGGER.error(("Can't find " + CountryModVariables.country_name.get((int) info_file_for_number) + " in info file"));
//						CountryModVariables.country_owner.add("None");
//						List<Double> country_spawn_pos = new ArrayList<>();
//						CountryModVariables.country_spawn_pos.add(country_spawn_pos);
//						CountryModVariables.country_start.add("peace");
//						CountryModVariables.country_color.add("6");
//						CountryModVariables.country_level.add(1);
//						List<List> country_war = new ArrayList<>();
//						CountryModVariables.country_war.add(country_war);
//					} else {
//						{
//							try {
//								BufferedReader bufferedReader = new BufferedReader(new FileReader(country_info_file));
//								StringBuilder jsonstringbuilder = new StringBuilder();
//								String line;
//								while ((line = bufferedReader.readLine()) != null) {
//									jsonstringbuilder.append(line);
//								}
//								bufferedReader.close();
//								info_main_json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
//								if (info_main_json.has("owner")) {
//									CountryModVariables.country_owner.add(info_main_json.get("owner").getAsString());
//								} else {
//									CountryMod.LOGGER.error(("Can't find Owner in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									CountryModVariables.country_owner.add("None");
//								}
//								if (info_main_json.has("spawn_pos_x") && info_main_json.has("spawn_pos_y") && info_main_json.has("spawn_pos_z")) {
//									List<Double> country_spawn_pos = new ArrayList<>();
//									country_spawn_pos.add(info_main_json.get("spawn_pos_x").getAsDouble());
//									country_spawn_pos.add(info_main_json.get("spawn_pos_y").getAsDouble());
//									country_spawn_pos.add(info_main_json.get("spawn_pos_z").getAsDouble());
//									CountryModVariables.country_spawn_pos.add(country_spawn_pos);
//								} else {
//									CountryMod.LOGGER.error(("Can't find SpawnPos in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									List<Double> country_spawn_pos = new ArrayList<>();
//									CountryModVariables.country_spawn_pos.add(country_spawn_pos);
//								}
//								if (info_main_json.has("start")) {
//									CountryModVariables.country_start.add(info_main_json.get("start").getAsString());
//								} else {
//									CountryMod.LOGGER.error(("Can't find Start in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									CountryModVariables.country_start.add("peace");
//								}
//								if (info_main_json.has("color")) {
//									CountryModVariables.country_color.add(info_main_json.get("color").getAsString());
//								} else {
//									CountryMod.LOGGER.error(("Can't find Color in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									CountryModVariables.country_color.add("6");
//								}
//
//								if (info_main_json.has("level")) {
//									CountryModVariables.country_level.add((int) info_main_json.get("level").getAsDouble());
//								} else {
//									CountryMod.LOGGER.error(("Can't find Level in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									CountryModVariables.country_level.add(1);
//								}
//								if (info_main_json.has("war")) {
//									List<List> country_war = new ArrayList<>();
//									info_war_file = info_main_json.get("war").getAsJsonObject();
//									war_one_data_for_number = 0;
//									for (int index1 = 0; index1 < (int) info_war_file.size(); index1++) {
//										info_war_file_one_data = info_war_file.get(("the_" + (int) war_one_data_for_number + "_data")).getAsJsonObject();
//										List<String> country_war_one_data = new ArrayList<>();
//										country_war_one_data.add((String) info_war_file_one_data.get("other_country_name").getAsString());
//										country_war_one_data.add((String) info_war_file_one_data.get("type").getAsString());
//										country_war.add((List) country_war_one_data);
//										war_one_data_for_number = war_one_data_for_number + 1;
//									}
//									CountryModVariables.country_war.add(country_war);
//								} else {
//									List<List> country_war = new ArrayList<>();
//									CountryModVariables.country_war.add(country_war);
//								}
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//					country_players_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/player"), File.separator + (country_names + ".json"));
//					if (!country_players_file.exists()) {
//						CountryMod.LOGGER.error(("Can't find " + CountryModVariables.country_name.get((int) info_file_for_number) + " in player file"));
//						List<String> country_player_list = new ArrayList<>();
//						CountryModVariables.country_player.add(country_player_list);
//					} else {
//						{
//							try {
//								BufferedReader bufferedReader = new BufferedReader(new FileReader(country_players_file));
//								StringBuilder jsonstringbuilder = new StringBuilder();
//								String line;
//								while ((line = bufferedReader.readLine()) != null) {
//									jsonstringbuilder.append(line);
//								}
//								bufferedReader.close();
//								player_main_json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
//								if (!(player_main_json.size() == 0)) {
//									player_one_uuid_for_number = 0;
//									List<String> country_player_list = new ArrayList<>();
//									for (int index2 = 0; index2 < (int) player_main_json.size(); index2++) {
//										country_player_list.add(player_main_json.get(("the_" + (int) player_one_uuid_for_number + "_uuid")).getAsString());
//										player_one_uuid_for_number = player_one_uuid_for_number + 1;
//									}
//									CountryModVariables.country_player.add(country_player_list);
//								} else {
//									CountryMod.LOGGER.warn(("Can't find Player in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									List<String> country_player_list = new ArrayList<>();
//									CountryModVariables.country_player.add(country_player_list);
//								}
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//					country_admins_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/admin"), File.separator + (country_names + ".json"));
//					if (!country_admins_file.exists()) {
//						CountryMod.LOGGER.error(("Can't find " + CountryModVariables.country_name.get((int) info_file_for_number) + " in admin file"));
//						List<String> country_admin_list = new ArrayList<>();
//						CountryModVariables.country_admin.add(country_admin_list);
//					} else {
//						{
//							try {
//								BufferedReader bufferedReader = new BufferedReader(new FileReader(country_admins_file));
//								StringBuilder jsonstringbuilder = new StringBuilder();
//								String line;
//								while ((line = bufferedReader.readLine()) != null) {
//									jsonstringbuilder.append(line);
//								}
//								bufferedReader.close();
//								admin_main_json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
//								if (!(admin_main_json.size() == 0)) {
//									admin_one_uuid_for_number = 0;
//									List<String> country_admin_list = new ArrayList<>();
//									for (int index2 = 0; index2 < (int) admin_main_json.size(); index2++) {
//										country_admin_list.add(admin_main_json.get(("the_" + (int) admin_one_uuid_for_number + "_uuid")).getAsString());
//										admin_one_uuid_for_number = admin_one_uuid_for_number + 1;
//									}
//									CountryModVariables.country_admin.add(country_admin_list);
//								} else {
//									CountryMod.LOGGER.warn(("Can't find Player in " + CountryModVariables.country_name.get((int) info_file_for_number)));
//									List<String> country_admin_list = new ArrayList<>();
//									CountryModVariables.country_admin.add(country_admin_list);
//								}
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//
//					country_chucks_file = new File((FMLPaths.GAMEDIR.get().toString() + "/world/country/chuck"), File.separator + (country_names + ".json"));
//					if (!country_chucks_file.exists()) {
//						CountryMod.LOGGER.error(("Can't find " + CountryModVariables.country_name.get((int) info_file_for_number) + " in chuck file"));
//						List<List> country_chucks = new ArrayList<>();
//						CountryModVariables.country_chucks.add(country_chucks);
//					} else {
//						{
//							try {
//								BufferedReader bufferedReader = new BufferedReader(new FileReader(country_chucks_file));
//								StringBuilder jsonstringbuilder = new StringBuilder();
//								String line;
//								while ((line = bufferedReader.readLine()) != null) {
//									jsonstringbuilder.append(line);
//								}
//								bufferedReader.close();
//								chuck_main_json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
//								if (!(chuck_main_json.size() == 0)) {
//									chuck_one_pos_for_number = 0;
//									List<List> country_chucks = new ArrayList<>();
//									for (int index3 = 0; index3 < (int) chuck_main_json.size(); index3++) {
//										List<Integer> country_chuck_pos = new ArrayList<>();
//										country_chuck_one_data_pos = chuck_main_json.get(("the_" + (int) chuck_one_pos_for_number + "_chuck_pos")).getAsString();
//										String[] Chuck_Pos_String_list = country_chuck_one_data_pos.split(",");
//										country_chuck_pos.add(Integer.parseInt(Chuck_Pos_String_list[0]));
//										country_chuck_pos.add(Integer.parseInt(Chuck_Pos_String_list[1]));
//										country_chucks.add(country_chuck_pos);
//										chuck_one_pos_for_number = chuck_one_pos_for_number + 1;
//									}
//									CountryModVariables.country_chucks.add(country_chucks);
//								}
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//					info_file_for_number = info_file_for_number + 1;
//				}
//			}
//			DataFixProcedure.execute();
//		}
//	}
//}
