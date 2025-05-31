package top.warmc.country.procedures.chuck.operate;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

import java.util.List;

public class AutoAddChuckOpenProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		boolean logic_for_find_player_pos = false;
		int number_for_find_player_pos = 0;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			if ((((List) CountryModVariables.country_player.get(index0)).contains((entity.getStringUUID())))) {
				logic_for_find_player_pos = true;
				number_for_find_player_pos = index0;
				break;
			}
		}
		if (!logic_for_find_player_pos) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u56FD\u5BB6!"), false);
			return;
		}
		if (!((String) CountryModVariables.country_start.get(number_for_find_player_pos)).equals("peace")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u4e0d\u5141\u8bb8\u5728\u6218\u4e89\u4e2d\u4f7f\u7528\u8be5\u529f\u80fd!"), false);
			return;
		}
		{
			boolean _setval = BoolArgumentType.getBool(arguments, "type");
			entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.auto_add_chuck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7a\u8BBE\u7F6E\u6210\u529F!"), false);
	}
}
