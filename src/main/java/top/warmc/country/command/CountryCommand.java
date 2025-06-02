
package top.warmc.country.command;

//import com.mojang.brigadier.builder.LiteralArgumentBuilder;
//import net.minecraft.commands.CommandSourceStack;
//import top.warmc.country.procedures.chuck.operate.UnAutoAddProcedure;
//import top.warmc.country.procedures.war.SurrenderProcedure;
//import top.warmc.country.procedures.player.country.SetColorProcedure;
//import top.warmc.country.procedures.player.country.SetAdminProcedure;
//import top.warmc.country.procedures.player.invite.other.SendInviteToCountryProcedure;
//import top.warmc.country.procedures.chuck.operate.RemoveProcedure;
//import top.warmc.country.procedures.player.country.RemoveAdminProcedure;
//import top.warmc.country.procedures.info.ModInfoProcedure;
//import top.warmc.country.procedures.chuck.operate.ListProcedure;
//import top.warmc.country.procedures.player.invite.other.ListMyCountryInviteProcedure;
//import top.warmc.country.procedures.player.country.LeaveProcedure;
//import top.warmc.country.procedures.war.LaunchProcedure;
//import top.warmc.country.procedures.player.country.KickProcedure;
//import top.warmc.country.procedures.player.country.InviteProcedure;
//import top.warmc.country.procedures.player.invite.other.InviteListDenyProcedure;
//import top.warmc.country.procedures.player.invite.other.InviteListAcceptProcedure;
//import top.warmc.country.procedures.info.InfoListAllProcedure;
//import top.warmc.country.procedures.info.InfoCountryProcedure;
//import top.warmc.country.procedures.player.country.GospawnProcedure;
//import top.warmc.country.procedures.war.FallbackProcedure;
//import top.warmc.country.procedures.country.Disband;
//import top.warmc.country.procedures.player.invite.my.DenyintiveProcedure;
//import top.warmc.country.procedures.country.Create;
//import top.warmc.country.procedures.chuck.operate.AutoAddChuckOpenProcedure;
//import top.warmc.country.procedures.player.invite.my.AcceptinviteProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class CountryCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
//		LiteralArgumentBuilder<CommandSourceStack> main_command = Commands.literal("country");
//		main_command.then(Commands.literal("create").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			Create.Create(world, arguments, entity);
//			return 0;
//		})));
//
//		main_command.then(Commands.literal("invitations").then(Commands.literal("accept").executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			AcceptinviteProcedure.execute(world, entity);
//			return 0;
//		})));
//		main_command.then(Commands.literal("invitations").then(Commands.literal("deny").executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			DenyintiveProcedure.execute(world, entity);
//			return 0;
//		})));
//		main_command.then(Commands.literal("invitations").then(Commands.literal("send").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			SendInviteToCountryProcedure.execute(arguments, entity);
//			return 0;
//		}))));
//
//		main_command.then(Commands.literal("info").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			InfoCountryProcedure.execute(arguments, entity);
//			return 0;
//		})));
//		main_command.then(Commands.literal("info").then(Commands.literal("list").then(Commands.argument("page", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			InfoListAllProcedure.execute(arguments, entity);
//			return 0;
//		}))));
//		main_command.then(Commands.literal("info").executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			ModInfoProcedure.execute(entity);
//			return 0;
//		}));
//
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("setspawn").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					return 0;
//				})));
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("spawn").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					double x = arguments.getSource().getPosition().x();
//					double y = arguments.getSource().getPosition().y();
//					double z = arguments.getSource().getPosition().z();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					GospawnProcedure.execute(x, y, z, entity);
//					return 0;
//				})));
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("kick").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					KickProcedure.execute(arguments, entity);
//					return 0;
//				}))));
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("leave").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					LeaveProcedure.execute(entity);
//					return 0;
//				})));
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("color").then(Commands.literal("set").then(Commands.argument("color", StringArgumentType.word()).executes(arguments -> {
//						Level world = arguments.getSource().getUnsidedLevel();
//						Entity entity = arguments.getSource().getEntity();
//						if (entity == null && world instanceof ServerLevel _servLevel)
//							entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//						SetColorProcedure.execute(arguments, entity);
//						return 0;
//					})))));
//		main_command.then(Commands.literal("mycountry").then(Commands.literal("disband").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					return 0;
//				})));
//
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("war").then(Commands.literal("launch").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			LaunchProcedure.execute(world, arguments, entity);
//			return 0;
//		})))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("war").then(Commands.literal("surrender").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			SurrenderProcedure.execute(world, arguments, entity);
//			return 0;
//		})))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("war").then(Commands.literal("fallback").then(Commands.argument("country_name", StringArgumentType.string()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			FallbackProcedure.execute(world, arguments, entity);
//			return 0;
//		})))));
//
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("invite").then(Commands.literal("accept").then(Commands.argument("player_name", StringArgumentType.word()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					InviteListAcceptProcedure.execute(world, arguments, entity);
//					return 0;
//				})))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("invite").then(Commands.literal("deny").then(Commands.argument("player_name", StringArgumentType.word()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					InviteListDenyProcedure.execute(world, arguments, entity);
//					return 0;
//				})))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("invite").then(Commands.literal("list").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					ListMyCountryInviteProcedure.execute(entity);
//					return 0;
//				}))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("invite").then(Commands.literal("send").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					InviteProcedure.execute(arguments, entity);
//					return 0;
//
//				})))));
//
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("chuck").then(Commands.literal("add").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					UnAutoAddProcedure.execute(world, entity);
//					return 0;
//				}))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("chuck").then(Commands.literal("del").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					RemoveProcedure.execute(world, entity);
//					return 0;
//				}))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("chuck").then(Commands.literal("list").executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					ListProcedure.execute(world, entity);
//					return 0;
//				}))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("chuck").then(Commands.literal("autoadd").then(Commands.argument("type", BoolArgumentType.bool()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					AutoAddChuckOpenProcedure.execute(arguments, entity);
//					return 0;
//				})))));
//
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("admin").then(Commands.literal("set").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
//					Level world = arguments.getSource().getUnsidedLevel();
//					Entity entity = arguments.getSource().getEntity();
//					if (entity == null && world instanceof ServerLevel _servLevel)
//						entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//					SetAdminProcedure.execute(arguments, entity);
//					return 0;
//				})))));
//			main_command.then(Commands.literal("mycountry").then(Commands.literal("admin").then(Commands.literal("kick").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
//			Level world = arguments.getSource().getUnsidedLevel();
//			Entity entity = arguments.getSource().getEntity();
//			if (entity == null && world instanceof ServerLevel _servLevel)
//				entity = FakePlayerFactory.getMinecraft(_servLevel);
//
//			RemoveAdminProcedure.execute(arguments, entity);
//			return 0;
//		})))));
//
//		event.getDispatcher().register(main_command);
    }
}
