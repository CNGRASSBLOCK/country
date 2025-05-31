package top.warmc.country.procedures.chuck.protection;

import top.warmc.country.network.CountryModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BreakBlockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
        double number = 0;
		List<Integer> pos = new ArrayList<>();
		List<Object> cant_build_chuck_pos = new ArrayList<>();
		List<String> player_list = new ArrayList<>();
		boolean logic = false;
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
			number = 0;
			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
			    player_list.clear();
				player_list.addAll((List) CountryModVariables.country_player.get((int) number));
				if (!player_list.contains((entity.getStringUUID())) && (CountryModVariables.country_start.get((int) number)).equals("peace")) {
					cant_build_chuck_pos.addAll((List) CountryModVariables.country_chucks.get((int) number));
				}
				number = number + 1;
			}
			pos.add((world.getChunk(new BlockPos((int) x, (int) y, (int) z)).getPos().getMinBlockX()));
			pos.add((world.getChunk(new BlockPos((int) x, (int) y, (int) z)).getPos().getMinBlockZ()));
			logic = !cant_build_chuck_pos.contains(pos) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity);
			if (!logic) {
			    event.setCanceled(true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7c\u60A8\u4E0D\u80FD\u5728\u6B64\u4EA4\u4E92"), false);
			}
		}
	}
}
