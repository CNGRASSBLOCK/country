//package top.warmc.country.procedures.player.invite.my;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.eventbus.api.Event;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.network.chat.Component;
//
//import javax.annotation.Nullable;
//
//import java.util.List;
//import java.util.ArrayList;
//
//@Mod.EventBusSubscriber
//public class InviteMessageProcedure {
//	@SubscribeEvent
//	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
//		execute(event, event.getEntity());
//	}
//
//	public static InteractionResult execute(Entity entity) {
//		return execute(null, entity);
//	}
//
//	private static InteractionResult execute(@Nullable Event event, Entity entity) {
//		if (entity == null)
//			return InteractionResult.PASS;
//		double number_for_onedata = 0;
//		String player_uuid = "";
//		String country_name = "";
//		boolean logic_for_onedata = false;
//		boolean return_logic = false;
//		player_uuid = entity.getStringUUID();
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_invites.size(); index0++) {
//			List<String> invite_onedata = new ArrayList<>();
//			invite_onedata.addAll((List) CountryModVariables.country_invites.get((int) number_for_onedata));
//			if ((invite_onedata.get(0)).equals(player_uuid) && (invite_onedata.get(2)).equals(CountryModVariables.country_name.get((int) number_for_onedata)) && !(invite_onedata.get(3)).equals("spend")) {
//				logic_for_onedata = true;
//				if ((invite_onedata.get(3)).equals("accept")) {
//					return_logic = true;
//				} else {
//					return_logic = false;
//				}
//				break;
//			}
//			number_for_onedata = number_for_onedata + 1;
//		}
//		if (!logic_for_onedata) {
//			return InteractionResult.SUCCESS;
//		}
//		if (return_logic) {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal(("\u00A76[Country]\u00A73[player]\u00A7a\u60A8\u53D1\u9001\u7ED9 " + country_name + " \u7684\u7533\u8BF7\u901A\u8FC7\u4E86")), false);
//			return InteractionResult.SUCCESS;
//		} else {
//			if (entity instanceof Player _player && !_player.level().isClientSide())
//				_player.displayClientMessage(Component.literal(("\u00A76[Country]\u00A73[player]\u00A7c\u60A8\u53D1\u9001\u7ED9 " + country_name + " \u7684\u7533\u8BF7\u88AB\u62D2\u7EDD")), false);
//			return InteractionResult.SUCCESS;
//		}
//	}
//}
