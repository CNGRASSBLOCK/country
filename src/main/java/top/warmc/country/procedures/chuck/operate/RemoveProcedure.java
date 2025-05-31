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

public class RemoveProcedure {
	public static InteractionResult execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		double number = 0;
		boolean logic = false;
		List<Integer> chuck_pos = new ArrayList<>();
		List<List> chuck_list = new ArrayList<>();
		List<String> player_list = new ArrayList<>();
		logic = false;
		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			player_list.clear();
			player_list.addAll((List) CountryModVariables.country_admin.get((int) number));
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
		chuck_pos.clear();
		chuck_pos.add((world.getChunk(new BlockPos((int) (entity.getX()), (int) (entity.getY()), (int) (entity.getZ()))).getPos().getMinBlockX()));
		chuck_pos.add((world.getChunk(new BlockPos((int) (entity.getX()), (int) (entity.getY()), (int) (entity.getZ()))).getPos().getMinBlockZ()));
		chuck_list.clear();
		chuck_list.addAll((List) CountryModVariables.country_chucks.get((int) number));
		if (!chuck_list.contains((List) chuck_pos)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A7c\u8BE5\u533A\u5757\u4E0D\u4E3A\u9886\u571F!"), false);
			return InteractionResult.PASS;
		}
		chuck_list.remove(chuck_pos);
		CountryModVariables.country_chucks.set((int) number, chuck_list);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A72\u5220\u9664\u533A\u57DF\u6210\u529F!"), false);
		return InteractionResult.SUCCESS;
	}
}
