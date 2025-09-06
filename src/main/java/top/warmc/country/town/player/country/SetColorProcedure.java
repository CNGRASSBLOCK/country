//package top.warmc.country.procedures.player.country;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//import net.minecraft.commands.CommandSourceStack;
//
//import com.mojang.brigadier.context.CommandContext;
//import com.mojang.brigadier.arguments.StringArgumentType;
//
//import java.util.List;
//import java.util.ArrayList;
//
//public class SetColorProcedure {
//	public static InteractionResult execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		double number = 0;
//		boolean logic = false;
//		logic = false;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			List<String> player_list = new ArrayList<>();
//			player_list.addAll((List) CountryModVariables.country_admin.get((int) number));
//			if (player_list.contains((entity.getStringUUID()))) {
//				logic = true;
//				break;
//			}
//			number = number + 1;
//		}
//		String color = "";
//		if (!logic) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u6CA1\u6709\u5728\u4EFB\u4F55\u4E00\u4E2A\u56FD\u5BB6!"), false);
//			return InteractionResult.PASS;
//		}
//		color = StringArgumentType.getString(arguments, "color");
//		if ((color).isEmpty()) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u8F93\u5165\u4E3A\u7A7A!"), false);
//			return InteractionResult.PASS;
//		}
//		if ((color).length() > 1) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u8F93\u5165\u8FC7\u957F!"), false);
//			return InteractionResult.PASS;
//		}
//		if (entity instanceof Player _player && !_player.level().isClientSide())
//			_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7a\u8BBE\u7F6E\u6210\u529F!"), false);
//		CountryModVariables.country_color.set((int) number, color);
//		return InteractionResult.SUCCESS;
//	}
//}
