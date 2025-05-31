package top.warmc.country.procedures.info;

import top.warmc.country.network.CountryModVariables;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import java.util.List;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

import java.util.ArrayList;

public class InfoCountryProcedure {
	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		String country_name = "";
		String owner_name = "";
		Integer number_for_my_country = 0;
		boolean logic_for_my_country = false;
		country_name = StringArgumentType.getString(arguments, "country_name");
		if ((country_name).isEmpty()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u8F93\u5165\u4E3A\u7A7A"), false);
			return InteractionResult.PASS;
		}
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			if (((String) CountryModVariables.country_name.get((int) number_for_my_country)).equals(country_name)) {
				logic_for_my_country = true;
				break;
			}
			number_for_my_country = number_for_my_country + 1;
		}
		if (!logic_for_my_country) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u6CA1\u6709\u8FD9\u4E2A\u56FD\u5BB6"), false);
			return InteractionResult.PASS;
		}
		File file = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "usernamecache.json");;
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				json = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (json.has((String) CountryModVariables.country_owner.get((int) number_for_my_country))) {
					owner_name = json.get((String) CountryModVariables.country_owner.get((int) number_for_my_country)).getAsString();
				} else {
					owner_name = "\u00A74\u9519\u8BEF:\u00A7c\u65E0\u6548\u7684uuid";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7e======================="), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u56FD\u5BB6\u540D\u79F0: \u00A7" + CountryModVariables.country_color.get((int) number_for_my_country) + CountryModVariables.country_name.get((int) number_for_my_country))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u56FD\u738B: \u00A73" + owner_name)), false);
		List<Double> spawn_pos = new ArrayList<>();
		spawn_pos.addAll((List) CountryModVariables.country_spawn_pos.get((int) number_for_my_country));
		double spawn_x = (Double) spawn_pos.get(0);
		double spawn_y = (Double) spawn_pos.get(1);
		double spawn_z = (Double) spawn_pos.get(2);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u51FA\u751F\u70B9\u5750\u6807: \u00A72x:" + (int) spawn_x + " y:" + (int) spawn_y + " z:" + (int) spawn_z)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u603B\u4EBA\u6570: \u00A7a" + ((List) CountryModVariables.country_player.get((int) number_for_my_country)).size())), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u571F\u5730\u603B\u6570: \u00A75" + ((List) CountryModVariables.country_chucks.get((int) number_for_my_country)).size())), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u7B49\u7EA7: \u00A74" + CountryModVariables.country_level.get((int) number_for_my_country))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A76\u5F53\u524D\u72B6\u6001: \u00A7c" + CountryModVariables.country_start.get((int) number_for_my_country))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7e==============================="), false);
		return InteractionResult.PASS;
	}
}
