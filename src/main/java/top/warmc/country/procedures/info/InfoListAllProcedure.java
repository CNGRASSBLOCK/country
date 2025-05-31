package top.warmc.country.procedures.info;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class InfoListAllProcedure {
	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		double PrintPos = 0;
		double page = 0;
		page = DoubleArgumentType.getDouble(arguments, "page") - 1;
		if (page < 0 || page * 10 > CountryModVariables.country_name.size()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country][player]\u00A7c\u9875\u9762\u4E0D\u5B58\u5728"), false);
			return InteractionResult.PASS;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7e====================="), false);
		if (CountryModVariables.country_name.size() <= 10) {
			PrintPos = 0;
			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7e" + ((int) PrintPos + 1) + ". \u00A7" + CountryModVariables.country_color.get((int) PrintPos) + CountryModVariables.country_name.get((int) PrintPos))), false);
				PrintPos = PrintPos + 1;
			}
		} else {
			PrintPos = page * 10;
			if (CountryModVariables.country_name.size() - (PrintPos + 10) >= 10) {
				for (int index1 = 0; index1 < 10; index1++) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7e" + ((int) PrintPos + 1) + ". \u00A7" + CountryModVariables.country_color.get((int) PrintPos) + CountryModVariables.country_name.get((int) PrintPos))), false);
					PrintPos = PrintPos + 1;
				}
			} else {
				for (int index2 = 0; index2 < (int) (CountryModVariables.country_name.size() - PrintPos); index2++) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7e" + ((int) PrintPos + 1) + ". \u00A7" + CountryModVariables.country_color.get((int) PrintPos) + CountryModVariables.country_name.get((int) PrintPos))), false);
					PrintPos = PrintPos + 1;
				}
			}
		}
		if (CountryModVariables.country_name.size() <= 100) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7e============\u00A7d0" + ((int) (page + 1)) + "/0" + (int) Math.ceil(CountryModVariables.country_name.size() / 10.0) + "\u00A7e============")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7e============\u00A7d0" + ((int) (page + 1)) + "/" + (int) Math.ceil(CountryModVariables.country_name.size() / 10.0) + "\u00A7e============")), false);
		}
		return InteractionResult.SUCCESS;
	}
}
