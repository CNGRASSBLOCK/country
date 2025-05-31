package top.warmc.country.procedures.other;

import top.warmc.country.network.CountryModVariables;
import top.warmc.country.config.ConfigConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import top.warmc.country.CountryMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class MessageProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, String text) {
		Integer number = 0;
		List<String> playert_list = new ArrayList<>();
		String country_disname = "";
		String message = "";
		String message_out = "";
		String player_name = "";
		String config_message = "";
		CountryMod.LOGGER.info("Do True");
		if (ConfigConfiguration.TAKE_OVER_MESSAGE_EVENT.get()) {
			CountryMod.LOGGER.info("True");
		    event.setCanceled(true);
			player_name = entity.getDisplayName().getString();
			message = text;
			country_disname = "";
			config_message = ConfigConfiguration.CHAT_FORMAT.get();
			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
				playert_list.clear();
				playert_list.addAll((List) CountryModVariables.country_player.get((int) number));
				if (playert_list.contains((entity.getStringUUID()))) {
					country_disname = "§8[§" + ((String) CountryModVariables.country_color.get((int) number)) + CountryModVariables.country_name.get((int) number) + "§8]§r";
					break;
				}
				number = number + 1;
			}
			message_out = config_message;
			message_out = message_out.replace("%country_disname%" , country_disname);
			message_out = message_out.replace("%player_name%" , player_name);
			message_out = message_out.replace("%message%" , message);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(message_out), false);
		}
	}
}
