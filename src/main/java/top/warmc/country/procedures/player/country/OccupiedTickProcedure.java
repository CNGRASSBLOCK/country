package top.warmc.country.procedures.player.country;

import top.warmc.country.network.CountryModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import top.warmc.country.procedures.other.ResetPlayerAllDataProcedure;

import javax.annotation.Nullable;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class OccupiedTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		List<Integer> my_pos = new ArrayList<>();
		List<List> my_country_chuck_list = new ArrayList<>();
		List<List> other_country_chuck_list = new ArrayList<>();
		double time = 0;
		double my_country = 0;
		double other_country = 0;
		String my_chuck_pos = "";
		String progress_bar = "";
		String dis_progress_bar = "";
		time = (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).war_chuck_occupied_time;
		my_country = (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).war_chuck_occupied_my_country;
		other_country = (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).war_chuck_occupied_other_country;
		if (time > 1) {
			my_chuck_pos = world.getChunk(new BlockPos((int) x, (int) 0, (int) z)).getPos().getMinBlockX() + "," + world.getChunk(new BlockPos((int) x, (int) 0, (int) z)).getPos().getMinBlockZ();
			if ((my_chuck_pos).equals((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).war_chuck_occupied)) {
				progress_bar = "";
				for (int index0 = 0; index0 < (int) (100 - Math.round(100 * (time / 1200))); index0++) {
					progress_bar = progress_bar + "\u00A7a|";
				}
				for (int index1 = 0; index1 < Math.round(100 * (time / 1200)); index1++) {
					progress_bar = progress_bar + "\u00A7e|";
				}
				if (time >= 1180 && time <= 1200) {
					dis_progress_bar = "\u00A75-+\u00A7d{" + progress_bar.substring((int) (150 - Math.floor((1200 - time) * 7.5)), (int) (150 + Math.ceil((1200 - time) * 7.5))) + "\u00A7d}\u00A75+-";
				} else {
					dis_progress_bar = "\u00A75-+\u00A7d{" + progress_bar + "\u00A7d}\u00A75+-";
				}
				{
					double _setval = time - 1;
					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.war_chuck_occupied_time = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(dis_progress_bar), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75-+\u00A7d{\u00A7c||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\u00A7d}\u00A75+-"), true);
				{
					String _setval = "";
					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.war_chuck_occupied = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.war_chuck_occupied_time = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (time == 1) {
			my_pos.clear();
			my_pos.add((int) (world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockX()));
			my_pos.add((int) (world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockZ()));
			my_country_chuck_list.addAll((List) CountryModVariables.country_chucks.get((int) my_country));
			other_country_chuck_list.addAll((List) CountryModVariables.country_chucks.get((int) other_country));
			my_country_chuck_list.add(my_pos);
			other_country_chuck_list.remove(my_pos);
			CountryModVariables.country_chucks.set((int) my_country, my_country_chuck_list);
			CountryModVariables.country_chucks.set((int) other_country, other_country_chuck_list);
			if (other_country_chuck_list.isEmpty()) {
				CountryModVariables.country_name.remove((int) other_country);
				CountryModVariables.country_owner.remove((int) other_country);
				CountryModVariables.country_admin.remove((int) other_country);
				CountryModVariables.country_spawn_pos.remove((int) other_country);
				CountryModVariables.country_chucks.remove((int) other_country);
				CountryModVariables.country_start.remove((int) other_country);
				CountryModVariables.country_level.remove((int) other_country);
				CountryModVariables.country_color.remove((int) other_country);
				CountryModVariables.country_war.remove((int) other_country);
				ResetPlayerAllDataProcedure.execute(world, (int) other_country);
				CountryModVariables.country_player.remove((int) other_country);
			}
			{
				double _setval = 0;
				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.war_chuck_occupied_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A7a[chuck]\u00A72\u6210\u529F\u5360\u9886\u8BE5\u533A\u5757!"), false);
		}
	}
}
