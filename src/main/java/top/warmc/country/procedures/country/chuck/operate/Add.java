package top.warmc.country.procedures.country.chuck.operate;

//public class Add {
//	public static boolean add(LevelAccessor world, Entity entity, boolean auto) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		boolean logic_for_find_player_pos = false;
//		boolean logic_for_has_the_chuck = false;
//		double number_for_find_player_pos = 0;
//		double number_for_add_all_country_chuck = 0;
//		double number_for_add_peace_country_chuck = 0;
//		double number_for_other_country = 0;
//		logic_for_find_player_pos = false;
//		number_for_find_player_pos = 0;
//		//for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			if ((((List) CountryModVariables.country_player.get((int) number_for_find_player_pos))).contains((entity.getStringUUID()))) {
//				logic_for_find_player_pos = true;
//				break;
//			}
//			number_for_find_player_pos = number_for_find_player_pos + 1;
//		}
//		if (!logic_for_find_player_pos) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
//			return InteractionResult.PASS;
//		}
//		if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).war_chuck_occupied_time > 0) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u5904\u7406\u4E2D\u7684\u7533\u8BF7!"), false);
//			return InteractionResult.PASS;
//		}
//		if ((((List) CountryModVariables.country_chucks.get((int) number_for_find_player_pos))).size() >= (double) ConfigConfiguration.MAX_CHUCK.get()) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u533A\u5757\u6570\u5DF2\u6EE1!"), false);
//			return InteractionResult.PASS;
//		}
//		List<Integer> my_chuck_pos = new ArrayList<>();
//		my_chuck_pos.add((int) (world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockX()));
//		my_chuck_pos.add((int) (world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockZ()));
//		number_for_add_all_country_chuck = 0;
//		List<List> all_country_chuck = new ArrayList<>();
//		for (int index1 = 0; index1 < (int) CountryModVariables.country_name.size(); index1++) {
//			all_country_chuck.addAll((List) CountryModVariables.country_chucks.get((int) number_for_add_all_country_chuck));
//			if ((((List) CountryModVariables.country_chucks.get((int) number_for_add_all_country_chuck))).contains(my_chuck_pos)) {
//				number_for_other_country = number_for_add_all_country_chuck;
//				logic_for_has_the_chuck = true;
//			}
//			number_for_add_all_country_chuck = number_for_add_all_country_chuck + 1;
//		}
//		number_for_add_peace_country_chuck = 0;
//		List<List> peace_country_chuck = new ArrayList<>();
//		for (int index2 = 0; index2 < (int) CountryModVariables.country_name.size(); index2++) {
//			if (!(CountryModVariables.country_start.get((int) number_for_add_peace_country_chuck)).equals("peace")) {
//				all_country_chuck.addAll((List) CountryModVariables.country_chucks.get((int) number_for_add_peace_country_chuck));
//				number_for_add_peace_country_chuck = number_for_add_peace_country_chuck + 1;
//			}
//		}
//		if (all_country_chuck.contains(my_chuck_pos) && peace_country_chuck.contains(my_chuck_pos)) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u8BE5\u533A\u5757\u4E0D\u80FD\u88AB\u58F0\u660E!"), false);
//			return InteractionResult.PASS;
//		}
//		if (logic_for_has_the_chuck) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u60A8\u5DF2\u58F0\u660E\u8BE5\u533A\u5757!"), false);
//			return InteractionResult.PASS;
//		}
//		if (all_country_chuck.contains(my_chuck_pos) && !peace_country_chuck.contains(my_chuck_pos)) {
//			if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7e\u68C0\u6D4B\u5230\u8BE5\u9886\u571F\u6B63\u5728\u53D1\u751F\u6218\u4E89,\u8FDB\u5165\u00A7c\u5360\u9886\u00A7e\u6A21\u5F0F!"), false);
//			{
//				String _setval = world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockX() + ","
//						+ world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockZ();
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.war_chuck_occupied = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//			{
//				double _setval = number_for_find_player_pos;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.war_chuck_occupied_my_country = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//			{
//				double _setval = number_for_other_country;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.war_chuck_occupied_other_country = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//			{
//				double _setval = 1200;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.war_chuck_occupied_time = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//			return InteractionResult.PASS;
//		}
//		List<List> my_country_chuck_list = new ArrayList<>();
//		my_country_chuck_list.addAll((List) CountryModVariables.country_chucks.get((int) number_for_find_player_pos));
//		my_country_chuck_list.add(my_chuck_pos);
//		CountryModVariables.country_chucks.set((int) number_for_find_player_pos, my_country_chuck_list);
//		if (entity instanceof Player _player && !_player.level().isClientSide() && !auto)
//			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A72\u6210\u529F\u58F0\u660E\u8BE5\u533A\u5757!"), false);
//		return InteractionResult.PASS;
//	}
//}
