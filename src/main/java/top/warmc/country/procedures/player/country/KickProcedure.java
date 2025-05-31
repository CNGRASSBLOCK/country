package top.warmc.country.procedures.player.country;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.util.List;
import java.util.ArrayList;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class KickProcedure {
	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		List<String> player_list = new ArrayList<>();
		List<String> admin_list = new ArrayList<>();
		int number_for_my_country = 0;
		boolean logic_for_my_country = false;
		String the_player_uuid = "";
		if (!((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) == null)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A74[error]\u00A7c\u9519\u8BEF:\u7A7A\u5B9E\u4F53!"), false);
			return InteractionResult.SUCCESS;
		}
		number_for_my_country = 0;
		logic_for_my_country = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			player_list.clear();
			player_list.addAll((List) CountryModVariables.country_player.get((int) number_for_my_country));
			if (player_list.contains((entity.getStringUUID()))) {
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
		admin_list.clear();
		admin_list.addAll((List) CountryModVariables.country_admin.get((int) number_for_my_country));
		if (!admin_list.contains((entity.getStringUUID()))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u6743\u9650!"), false);
			return InteractionResult.SUCCESS;
		}
		the_player_uuid = (new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getStringUUID();
		if (!player_list.contains(the_player_uuid)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u6743\u9650!"), false);
			return InteractionResult.SUCCESS;
		}
		if (admin_list.contains(the_player_uuid)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60a8\u4e0d\u80fd\u8e22\u51fa\u5176\u4ed6\u7ba1\u7406\u5458!"), false);
			return InteractionResult.SUCCESS;
		}
		player_list.remove(the_player_uuid);
		CountryModVariables.country_player.set((int) number_for_my_country, player_list);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A72\u8E22\u51FA\u6210\u529F!"), false);
		return InteractionResult.SUCCESS;
	}
}
