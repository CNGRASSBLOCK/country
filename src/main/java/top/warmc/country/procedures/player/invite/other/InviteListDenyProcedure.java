package top.warmc.country.procedures.player.invite.other;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;
import java.util.ArrayList;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.server.level.ServerLevel;
import top.warmc.country.procedures.player.invite.my.InviteMessageProcedure;

public class InviteListDenyProcedure {
	public static InteractionResult execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		double number_for_my_country = 0;
		double number_for_onedata = 0;
		boolean logic_for_my_country = false;
		boolean logic_for_onedata = false;
		String the_player_uuid = "";
		String player_name = "";
		number_for_my_country = 0;
		logic_for_my_country = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			List<String> admin_list = new ArrayList<>();
			admin_list.addAll((List) CountryModVariables.country_admin.get((int) number_for_my_country));
			if (admin_list.contains((entity.getStringUUID()))) {
				logic_for_my_country = true;
				break;
			}
			number_for_my_country = number_for_my_country + 1;
		}
		if (!logic_for_my_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u56FD\u5BB6!"), false);
			return InteractionResult.SUCCESS;
		}
		player_name = StringArgumentType.getString(arguments, "player_name");
		for (int index1 = 0; index1 < (int) CountryModVariables.country_invites.size(); index1++) {
			List<String> invite_onedata = new ArrayList<>();
			invite_onedata.addAll((List) CountryModVariables.country_invites.get((int) number_for_onedata));
			if ((invite_onedata.get(1)).equals(player_name) && (invite_onedata.get(2)).equals(CountryModVariables.country_name.get((int) number_for_onedata)) && (invite_onedata.get(3)).equals("spend")) {
				logic_for_onedata = true;
				the_player_uuid = (String) invite_onedata.get(0);
				break;
			}
			number_for_onedata = number_for_onedata + 1;
		}
		if (!logic_for_onedata) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u6CA1\u6709\u6B64\u7533\u8BF7!"), false);
			return InteractionResult.SUCCESS;
		}
		List<String> invite_onedata = new ArrayList<>();
		invite_onedata.addAll((List) CountryModVariables.country_invites.get((int) number_for_onedata));
		invite_onedata.set(3, "deny");
		CountryModVariables.country_invites.set((int) number_for_onedata, invite_onedata);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u62D2\u7EDD\u6210\u529F!"), false);
        Entity entitys = new Object() {
			Entity getEntity(String uuid) {
				Entity _uuidentity = null;
				if (world instanceof ServerLevel _server) {
					try {
						_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
					} catch (IllegalArgumentException e) {
					}
				}
				return _uuidentity;
			}
		}.getEntity(the_player_uuid);
		if (entitys != null) {
			InviteMessageProcedure.execute(entity);
		}
		return InteractionResult.SUCCESS;
	}
}
