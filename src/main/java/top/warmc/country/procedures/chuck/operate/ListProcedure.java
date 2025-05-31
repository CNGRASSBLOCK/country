package top.warmc.country.procedures.chuck.operate;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

public class ListProcedure {
	public static InteractionResult execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		boolean logic = false;
		double number = 0;
		double number_x = 0;
		double number_z = 0;
		String out_string_row = "";
		List<String> player_list = new ArrayList<>();
		List<List> my_country_chucks = new ArrayList<>();
		List<List> other_country_chucks = new ArrayList<>();
		number = 0;
		logic = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			player_list.clear();
			player_list.addAll((List) CountryModVariables.country_player.get((int) number));
			if (player_list.contains((entity.getStringUUID()))) {
				logic = true;
				break;
			}
			number = number + 1;
		}
		if (!logic) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
			return InteractionResult.PASS;
		}
		my_country_chucks.clear();
		my_country_chucks.addAll((List) CountryModVariables.country_chucks.get((int) number));
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			other_country_chucks.addAll((List) CountryModVariables.country_chucks.get(index0));
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A72================"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7d----------------\u00A79north\u00A7d-----------------"), false);
		number_z = -7;
		for (int index1 = 0; index1 < 15; index1++) {
			out_string_row = "";
			number_x = -7;
			for (int index2 = 0; index2 < 15; index2++) {
		        List<Integer> chuck_pos = new ArrayList<>();
				chuck_pos.add((world.getChunk(new BlockPos((int) (number_x * 16 + Math.round(entity.getX())), (int) 0, (int) (number_z * 16 + Math.round(entity.getZ())))).getPos().getMinBlockX()));
				chuck_pos.add((world.getChunk(new BlockPos((int) (number_x * 16 + Math.round(entity.getX())), (int) 0, (int) (number_z * 16 + Math.round(entity.getZ())))).getPos().getMinBlockZ()));
                if (!(number_x == 0 && number_z == 0)) {
					if (my_country_chucks.contains(chuck_pos)) {
						out_string_row = out_string_row + "\u00A7a\u25A0 ";
					} else {
						if (other_country_chucks.contains(chuck_pos)) {
							out_string_row = out_string_row + "\u00A74\u25A0 ";
						} else {
							out_string_row = out_string_row + "\u00A7e\u25A1 ";
						}
					}
				} else {
					out_string_row = out_string_row + "\u00A7c+ ";
				}
				number_x++;
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(out_string_row), false);
			number_z++;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A7d----------------\u00A79south\u00A7d-----------------"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A72=============================="), false);
		return InteractionResult.SUCCESS;
	}
}
