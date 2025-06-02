
package top.warmc.country.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
//import top.warmc.country.procedures.file.SaveDataProcedure;
//import top.warmc.country.procedures.file.ReadDataProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class CountryadminCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		LiteralArgumentBuilder<CommandSourceStack> main_command = Commands.literal("countryadmin");

		main_command.then(Commands.literal("read_data").executes(arguments -> {
//			ReadDataProcedure.execute();
			return 0;
		}));

		main_command.then(Commands.literal("save_data").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();

//			SaveDataProcedure.execute(world);
			return 0;
		}));

		event.getDispatcher().register(main_command);
	}
}
