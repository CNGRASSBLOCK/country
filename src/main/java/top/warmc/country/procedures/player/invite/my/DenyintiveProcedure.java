package top.warmc.country.procedures.player.invite.my;

import top.warmc.country.network.CountryModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import com.mojang.util.UUIDTypeAdapter;

public class DenyintiveProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_spend_time > 0) {
			if (!(new Object() {
				Entity getEntity(String uuid) {
					Entity _uuidentity = null;
					if (world instanceof ServerLevel _server) {
						try {
							_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
						} catch (IllegalArgumentException e) {
						}
					}
					return _uuidentity;
				}
			}.getEntity(((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_player_uuid)) == null)) {
				{
					double _setval = 0;
					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.country_invite_spend_time = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "";
					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.country_invite_player_uuid = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A72\u62D2\u7EDD\u6210\u529F!"), false);
				if (new Object() {
					Entity getEntity(String uuid) {
						Entity _uuidentity = null;
						if (world instanceof ServerLevel _server) {
							try {
								_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
							} catch (IllegalArgumentException e) {
							}
						}
						return _uuidentity;
					}
				}.getEntity(((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_player_uuid)) instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A72\u5BF9\u65B9\u62D2\u7EDD\u52A0\u5165!"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c\u9519\u8BEF:\u7A7A\u5B9E\u4F53!"), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c\u60A8\u6CA1\u6709\u9080\u8BF7\u6216\u9080\u8BF7\u5DF2\u8FC7\u671F!"), false);
		}
	}
}
