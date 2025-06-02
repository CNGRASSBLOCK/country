//package top.warmc.country.procedures.player.invite.other;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//import net.minecraft.commands.CommandSourceStack;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import com.mojang.brigadier.context.CommandContext;
//import com.mojang.brigadier.arguments.StringArgumentType;
//
//public class SendInviteToCountryProcedure {
//	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		boolean isinvite = false;
//		int isnumber = 0;
//		boolean logic_for_my_country = false;
//		int number_for_my_country = 0;
//;
//		String country_name = StringArgumentType.getString(arguments, "country_name");
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			if ((CountryModVariables.country_name.get((int) number_for_my_country)).equals(country_name)) {
//				logic_for_my_country = true;
//				break;
//			}
//			number_for_my_country = number_for_my_country + 1;
//		}
//		if (!logic_for_my_country) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c国家不存在!"), false);
//			return InteractionResult.SUCCESS;
//		}
//		int number = 0;
//		boolean logic = false;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			List<String> player_list = new ArrayList<>();
//			player_list.addAll((List) CountryModVariables.country_player.get((int) number));
//			if (player_list.contains((entity.getStringUUID()))) {
//				logic = true;
//				break;
//			}
//			number = number + 1;
//		}
//		if (logic) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c您已有国家!"), false);
//			return InteractionResult.SUCCESS;
//		}
//		for (int index1 = 0; index1 < (int) CountryModVariables.country_invites.size(); index1++) {
//			List<String> invitesdata = new ArrayList<>();
//			invitesdata.addAll((List) CountryModVariables.country_invites.get((int) isnumber));
//			if ((invitesdata.get(0)).equals(entity.getStringUUID())) {
//				isinvite = true;
//			}
//			isnumber = isnumber + 1;
//		}
//		if (isinvite) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u5DF2\u7ECF\u7533\u8BF7\u8FC7\u4E86!"), false);
//			return InteractionResult.SUCCESS;
//		}
//		List<String> data = new ArrayList<>();
//		data.add((entity.getStringUUID()));
//		data.add(entity.getDisplayName().getString());
//		data.add(country_name);
//		data.add("spend");
//		CountryModVariables.country_invites.add(data);
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7a成功申请"), false);
//		return InteractionResult.SUCCESS;
//	}
//}
