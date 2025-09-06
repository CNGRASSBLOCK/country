//package top.warmc.country.procedures.player.country;
//
//import top.warmc.country.network.CountryModVariables;
//
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.eventbus.api.Event;
//import net.minecraftforge.event.TickEvent;
//
//import net.minecraft.world.phys.Vec3;
//import net.minecraft.world.phys.Vec2;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.util.RandomSource;
//import net.minecraft.util.Mth;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.network.chat.Component;
//import net.minecraft.commands.CommandSourceStack;
//import net.minecraft.commands.CommandSource;
//
//import javax.annotation.Nullable;
//
//import java.util.List;
//import java.util.ArrayList;
//
//@Mod.EventBusSubscriber
//public class DoparticleProcedure {
//	@SubscribeEvent
//	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//		if (event.phase == TickEvent.Phase.END) {
//			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
//		}
//	}
//
//	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
//		execute(null, world, x, y, z, entity);
//	}
//
//	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
//		if (entity == null)
//			return;
//		boolean logic = false;
//		double number = 0;
//		double circle_1_range = 0;
//		List<String> player_list = new ArrayList<>();
//		List<Double> spawn = new ArrayList<>();
//		if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick > 0) {
//			if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_laster_pos_y != y
//					|| (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_laster_pos_x != x
//					|| (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_laster_pos_z != z) {
//				{
//					double _setval = 0;
//					entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						capability.spawn_particle_tick = _setval;
//						capability.syncPlayerVariables(entity);
//					});
//				}
//				if (entity instanceof Player _player && !_player.level().isClientSide())
//					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A7c\u4F20\u9001\u5931\u8D25!"), false);
//                return;
//			}
//			circle_1_range = 0;
//			for (int index0 = 0; index0 < 91; index0++) {
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), y, (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), y, (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), y, (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), y, (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), (y + 1.8), (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), (y + 1.8), (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), (y + 1.8), (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands().performPrefixedCommand(
//							new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), (y + 1.8), (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//									.withSuppressedOutput(),
//							"particle dust_color_transition 0.5 0.5 1.0 0.25 0.0 0.5 1.0");
//				circle_1_range = circle_1_range + 1;
//			}
//			circle_1_range = 0;
//			for (int index1 = 0; index1 < 9; index1++) {
//				if (Mth.nextInt(RandomSource.create(), 0, 29) == 0) {
//					if (world instanceof ServerLevel _level)
//						_level.getServer().getCommands().performPrefixedCommand(
//								new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), (y + 1.8), (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//										.withSuppressedOutput(),
//								"particle firework");
//					if (world instanceof ServerLevel _level)
//						_level.getServer().getCommands().performPrefixedCommand(
//								new CommandSourceStack(CommandSource.NULL, new Vec3((x + Math.cos(circle_1_range) * 0.65), (y + 1.8), (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//										.withSuppressedOutput(),
//								"particle firework");
//					if (world instanceof ServerLevel _level)
//						_level.getServer().getCommands().performPrefixedCommand(
//								new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), (y + 1.8), (z + Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//										.withSuppressedOutput(),
//								"particle firework");
//					if (world instanceof ServerLevel _level)
//						_level.getServer().getCommands().performPrefixedCommand(
//								new CommandSourceStack(CommandSource.NULL, new Vec3((x - Math.cos(circle_1_range) * 0.65), (y + 1.8), (z - Math.sin(circle_1_range) * 0.65)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
//										.withSuppressedOutput(),
//								"particle firework");
//				}
//				circle_1_range = circle_1_range + 10;
//			}
//			circle_1_range = 0;
//			for (int index2 = 0; index2 < 91; index2++) {
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands()
//							.performPrefixedCommand(
//									new CommandSourceStack(CommandSource.NULL,
//											new Vec3((x + Math.cos(circle_1_range) * 0.5),
//													((y + 1.8) - (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick / 55.56),
//													(z + Math.sin(circle_1_range) * 0.5)),
//											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
//									"particle dust_color_transition 1.0 0.5 1.0 0.25 1.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands()
//							.performPrefixedCommand(
//									new CommandSourceStack(CommandSource.NULL,
//											new Vec3((x + Math.cos(circle_1_range) * 0.5),
//													((y + 1.8) - (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick / 55.56),
//													(z - Math.sin(circle_1_range) * 0.5)),
//											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
//									"particle dust_color_transition 1.0 0.5 1.0 0.25 1.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands()
//							.performPrefixedCommand(
//									new CommandSourceStack(CommandSource.NULL,
//											new Vec3((x - Math.cos(circle_1_range) * 0.5),
//													((y + 1.8) - (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick / 55.56),
//													(z + Math.sin(circle_1_range) * 0.5)),
//											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
//									"particle dust_color_transition 1.0 0.5 1.0 0.25 1.0 0.5 1.0");
//				if (world instanceof ServerLevel _level)
//					_level.getServer().getCommands()
//							.performPrefixedCommand(
//									new CommandSourceStack(CommandSource.NULL,
//											new Vec3((x - Math.cos(circle_1_range) * 0.5),
//													((y + 1.8) - (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick / 55.56),
//													(z - Math.sin(circle_1_range) * 0.5)),
//											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
//									"particle dust_color_transition 1.0 0.5 1.0 0.25 1.0 0.5 1.0");
//				circle_1_range = circle_1_range + 1;
//			}
//			if ((entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick == 1) {
//				number = 0;
//				logic = false;
//				for (int index3 = 0; index3 < (int) CountryModVariables.country_name.size(); index3++) {
//					player_list.clear();
//					player_list.addAll((List) CountryModVariables.country_player.get((int) number));
//					if (player_list.contains((entity.getStringUUID()))) {
//						logic = true;
//						break;
//					}
//					number = number + 1;
//				}
//				spawn.clear();
//				spawn.addAll((List) CountryModVariables.country_spawn_pos.get((int) number));
//				{
//					Entity _ent = entity;
//					_ent.teleportTo(spawn.get(0), spawn.get(1), spawn.get(2));
//					if (_ent instanceof ServerPlayer _serverPlayer)
//						_serverPlayer.connection.teleport(spawn.get(0), spawn.get(1), spawn.get(2), _ent.getYRot(), _ent.getXRot());
//				}
//				if (entity instanceof Player _player && !_player.level().isClientSide())
//					_player.displayClientMessage(Component.literal("\u00A76[Country]\u00A73[player]\u00A72\u4F20\u9001\u6210\u529F!"), false);
//			}
//			{
//				double _setval = (entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CountryModVariables.PlayerVariables())).spawn_particle_tick - 1;
//				entity.getCapability(CountryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//					capability.spawn_particle_tick = _setval;
//					capability.syncPlayerVariables(entity);
//				});
//			}
//		}
//	}
//}
