//package top.warmc.country.procedures.player.invite.other;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.network.chat.Component;
//import net.minecraft.commands.CommandSourceStack;
//import net.minecraft.commands.CommandSource;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class ListMyCountryInviteProcedure {
//	public static InteractionResult execute(Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		double number_for_my_country = 0;
//		double number_for_one_invite = 0;
//		boolean logic_for_my_country = false;
//		String message_command = "";
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			if ((CountryModVariables.country_owner.get((int) number_for_my_country)).equals(entity.getStringUUID())) {
//				logic_for_my_country = true;
//				break;
//			}
//			number_for_my_country = number_for_my_country + 1;
//		}
//		if (!logic_for_my_country) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u56FD\u5BB6!"), false);
//			return InteractionResult.SUCCESS;
//		}
//		String country_name = (String) CountryModVariables.country_name.get((int) number_for_my_country);
//		List<List> invite = new ArrayList<>();
//		for (int index1 = 0; index1 < (int) CountryModVariables.country_name.size(); index1++) {
//			List<String> one_invite = new ArrayList<>();one_invite = new ArrayList<>();
//			one_invite.addAll((List) CountryModVariables.country_invites.get((int) index1));
//			if ((one_invite.get(2)).equals(country_name)) {
//				invite.add((List) CountryModVariables.country_invites.get((int) index1));
//				break;
//			}
//		}
//		if (invite.isEmpty()) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u7684\u56FD\u5BB6\u6CA1\u6709\u9080\u8BF7!"), false);
//			return InteractionResult.SUCCESS;
//		}
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7e======================="), false);
//		message_command = "tellraw @s [{\"text\":\"{name}\",\"color\":\"light_purple\"},{\"text\":\"\u00A0\u3010\u540C\u610F\u3011\",\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"a\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"\u70B9\u51FB\u540C\u610F\"}},{\"text\":\"\u3010\u62D2\u7EDD\u3011\",\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"a\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"\u70B9\u51FB\u62D2\u7EDD\"}}]";
//		for (int index2 = 0; index2 < (int) invite.size(); index2++) {
//			List<String> invites = new ArrayList<>();
//			invites.addAll((List) invite.get((int) number_for_one_invite));
//			String player_name = (String) invites.get(1);
//			String out_command = message_command.replace("{name}", player_name);
//			{
//
//				Entity _ent = entity;
//				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
//					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
//							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), out_command);
//				}
//			}
//			number_for_one_invite = number_for_one_invite + 1;
//		}
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//			_player.displayClientMessage(Component.literal("\u00A7e==============================="), false);
//		return InteractionResult.SUCCESS;
//	}
//}
