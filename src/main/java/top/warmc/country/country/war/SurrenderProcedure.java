//package top.warmc.country.procedures.war;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//import net.minecraft.commands.CommandSourceStack;
//import net.minecraft.world.level.LevelAccessor;
//
//import top.warmc.country.CountryMod;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import com.mojang.brigadier.context.CommandContext;
//import com.mojang.brigadier.arguments.StringArgumentType;
////import top.warmc.country.procedures.other.ResetPlayerAllDataProcedure;
//
//public class SurrenderProcedure {
//	public static InteractionResult execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		List<List> my_country_war_list = new ArrayList<>();
//		List<String> my_country_war_one_data = new ArrayList<>();
//		int number_for_my_country = 0;
//		int number_for_other_country = 0;
//		int number_for_my_country_war_data_list = 0;
//		boolean logic_for_my_country = false;
//		boolean logic_for_other_country = false;
//		boolean logic_for_my_country_war_data_list = false;
//		logic_for_my_country = false;
//		number_for_my_country = 0;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			if (((String) CountryModVariables.country_owner.get((int) number_for_my_country)).equals(entity.getStringUUID())) {
//				logic_for_my_country = true;
//				break;
//			}
//			number_for_my_country = number_for_my_country + 1;
//		}
//		if (!logic_for_my_country) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
//			return InteractionResult.PASS;
//		}
//		if (!(CountryModVariables.country_name.contains(StringArgumentType.getString(arguments, "country_name")))) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u56fd\u5bb6\u4e0d\u5b58\u5728!"), false);
//			return InteractionResult.PASS;
//		}
//		if (((String) CountryModVariables.country_name.get(number_for_my_country)).equals(StringArgumentType.getString(arguments, "country_name"))) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60a8\u4e0d\u80fd\u5411\u81ea\u5df1\u6295\u964d!"), false);
//			return InteractionResult.PASS;
//		}
//		if ((CountryModVariables.country_start.get((int) number_for_my_country)).equals("peace")) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u7684\u56FD\u5BB6\u6CA1\u6709\u5904\u4E8E\u6218\u4E89\u4E2D!"), false);
//			return InteractionResult.PASS;
//		}
//		my_country_war_list.clear();
//		my_country_war_list.addAll((List) CountryModVariables.country_war.get((int) number_for_my_country));
//		if (my_country_war_list.isEmpty()) {
//			CountryModVariables.country_start.set((int) number_for_my_country, "peace");
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u72B6\u6001\u4FE1\u606F\u9519\u8BEF!\u00A7a\u5DF2\u91CD\u7F6E!"), false);
//			return InteractionResult.PASS;
//		}
//		logic_for_my_country_war_data_list = false;
//		number_for_my_country_war_data_list = 0;
//		for (int index1 = 0; index1 < (int) my_country_war_list.size(); index1++) {
//			my_country_war_one_data.clear();
//			my_country_war_one_data.addAll((List) my_country_war_list.get((int) number_for_my_country_war_data_list));			CountryMod.LOGGER.info(((String) my_country_war_one_data.get(0)).equals(StringArgumentType.getString(arguments, "country_name")) && ((String) my_country_war_one_data.get(1)).equals("attacked"));
//			if (((String) my_country_war_one_data.get(0)).equals(StringArgumentType.getString(arguments, "country_name")) && ((String) my_country_war_one_data.get(1)).equals("attacked")) {
//				logic_for_my_country_war_data_list = true;
//				break;
//			}
//			number_for_my_country_war_data_list = number_for_my_country_war_data_list + 1;
//		}
//		if (!logic_for_my_country_war_data_list) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u8BE5\u56FD\u672A\u5BF9\u4F60\u53D1\u8D77\u6218\u4E89!"), false);
//			return InteractionResult.PASS;
//		}
//		if (!((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).surrender_tick > 0)) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u786E\u5B9A\u8981\u6295\u964D\u5417?\u8BF7\u572810\u79D2\u5185\u518D\u6B21\u8F93\u5165\u6B64\u547D\u4EE4\u786E\u8BA4!"), false);
//			{
//				double _setval = 200;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.surrender_tick = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//			return InteractionResult.PASS;
//		}
//		String old_country_name = "" + CountryModVariables.country_name.get((int) number_for_my_country);
//		CountryModVariables.country_name.remove((int) number_for_my_country);
//		CountryModVariables.country_owner.remove((int) number_for_my_country);
//		CountryModVariables.country_admin.remove((int) number_for_my_country);
//		CountryModVariables.country_spawn_pos.remove((int) number_for_my_country);
//		CountryModVariables.country_chucks.remove((int) number_for_my_country);
//		CountryModVariables.country_start.remove((int) number_for_my_country);
//		CountryModVariables.country_level.remove((int) number_for_my_country);
//		CountryModVariables.country_color.remove((int) number_for_my_country);
//		CountryModVariables.country_war.remove((int) number_for_my_country);
//		ResetPlayerAllDataProcedure.execute(world, number_for_my_country);
//		CountryModVariables.country_player.remove((int) number_for_my_country);
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c[War]\u00A74\u5DF2\u6295\u964D!"), false);
//		if (!world.isClientSide() && world.getServer() != null)
//			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76[Country]\u00A7c[War]\u00A74\u56fd\u5bb6 " + old_country_name + " \u8986\u706d!")), false);
//		return InteractionResult.PASS;
//	}
//}
