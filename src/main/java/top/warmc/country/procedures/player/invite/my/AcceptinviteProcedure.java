package top.warmc.country.procedures.player.invite.my;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import top.warmc.country.network.CountryModVariables;

import java.util.List;
import java.util.ArrayList;

import com.mojang.util.UUIDTypeAdapter;

public class AcceptinviteProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double number = 0;
		boolean logic = false;
		List<Object> player_list = new ArrayList<>();
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
				number = 0;
				for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
					if ((CountryModVariables.country_owner.get((int) number)).equals((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_player_uuid)) {
						player_list.clear();
						player_list.addAll((List) CountryModVariables.country_player.get((int) number));
						player_list.add((entity.getStringUUID()));
						CountryModVariables.country_player.set((int) number, player_list);
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
							_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A72\u63A5\u53D7\u6210\u529F!"), false);
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
						}.getEntity(((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).country_invite_player_uuid)) instanceof Player _player
								&& !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A72\u5BF9\u65B9\u5DF2\u540C\u610F\u52A0\u5165!"), false);
						break;
					}
					number = 1 + number;
				}
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
