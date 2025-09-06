package top.warmc.country.country.info;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ModInfoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					"\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76="),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76Country \u00A78- \u00A76\u56FD\u5BB6\u7CFB\u7EDF"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76\u7248\u672C \u00A752.9.5"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A72By \u00A76CN_GOOD_GRASS"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					"\u00A76=§e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76=\u00A7e=\u00A76="),
					false);
	}
}
