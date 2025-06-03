package top.warmc.country.procedures.country.player.invite.my;

import top.warmc.country.network.CountryModNetWork;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayertickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).disband_tick > 0) {
			{
				double _setval = (entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).disband_tick - 1;
				entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.disband_tick = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_cooling > 0) {
			{
				double _setval = (entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_cooling - 1;
				entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.country_invite_cooling = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_spend_time > 1) {
			{
				double _setval = (entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_spend_time - 1;
				entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.country_invite_spend_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_spend_time == 1) {
			{
				double _setval = (entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModNetWork.PlayerVariables())).country_invite_spend_time - 1;
				entity.getCapability(CountryModNetWork.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.country_invite_spend_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u9080\u8BF7\u5DF2\u8FC7\u671F"), false);
		}
	}
}
