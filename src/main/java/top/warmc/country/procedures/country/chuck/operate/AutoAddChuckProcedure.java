//package top.warmc.country.procedures.chuck.operate;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.eventbus.api.Event;
//import net.minecraftforge.event.TickEvent;
//
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.core.BlockPos;
//
//import java.util.List;
//import javax.annotation.Nullable;
//
//@Mod.EventBusSubscriber
//public class AutoAddChuckProcedure {
//	@SubscribeEvent
//	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//		if (event.phase == TickEvent.Phase.END) {
//			execute(event, event.player.level(), event.player);
//		}
//	}
//
//	public static void execute(LevelAccessor world, Entity entity) {
//		execute(null, world, entity);
//	}
//
//	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
//		if (entity == null)
//			return;
//		if (entity.level().isClientSide())
//			return;
//		boolean logic_for_find_player_pos = false;
//		int number_for_find_player_pos = 0;
//		for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
//			if (((List) CountryModVariables.country_player.get(index0)).contains((entity.getStringUUID()))) {
//				logic_for_find_player_pos = true;
//				number_for_find_player_pos = index0;
//				break;
//			}
//		}
//		if (!logic_for_find_player_pos) {
//			return;
//		}
//		if (!((String) CountryModVariables.country_start.get(number_for_find_player_pos)).equals("peace")) {
//			{
//				boolean _setval = false;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.auto_add_chuck = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//		}
//		String pos = "";
//		if (!(entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).auto_add_chuck) {
//			return;
//		}
//		pos = world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockX() + "," + world.getChunk(new BlockPos((int) (entity.getX()), (int) 0, (int) (entity.getZ()))).getPos().getMinBlockZ();
//		if (!(pos).equals((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).auto_add_chuck_old_pos)) {
//			AddProcedure.execute(world, entity, true);
//			{
//				String _setval = pos;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.auto_add_chuck_old_pos = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//		}
//		return;
//	}
//}
