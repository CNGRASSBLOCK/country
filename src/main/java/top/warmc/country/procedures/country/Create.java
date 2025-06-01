package top.warmc.country.procedures.country;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.classes.Country;
import top.warmc.country.classes.CountryPool;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Create {
	public static void Create(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (!(entity instanceof Player player) || world.isClientSide() || world.getServer() == null) return;

		if (CountryPool.getFromPlayer(player) != null) {
			player.displayClientMessage(Component.literal("§6[Country]§3[player]§c存在同名国家!"), false);
			return;
		}

		String country_name = StringArgumentType.getString(arguments, "country_name");
		if (country_name.isEmpty()) {
			player.displayClientMessage(Component.literal("§6[Country]§3[player]§c国家名字不能为空!"), false);
			return;
		}
		if (CountryPool.has(country_name)) {
			player.displayClientMessage(Component.literal("§6[Country]§3[player]§c存在同名国家!"), false);
			return;
		}

		Country country = new Country(country_name, player.getUUID());

//		boolean add_chuck = false;
//		for (int x = 0; x < 5; x++) {
//			for (int z = 0; z < 5; z++) {
//				ChunkAccess chunkAccess = world.getChunk(new BlockPos((int) (player.getX() + (x - 2) * 16), 0, (int) (player.getZ() + (z - 2) * 16)));
//				if (CountryPool.getFromLand(chunkAccess) == null) { country.getLand().add(chunkAccess); add_chuck = true; }
//			}
//		}
		if (!add_chuck) player.displayClientMessage(Component.literal("§6[Country]§3[player]§c无法为您的国家声明土地!"), false);

		player.displayClientMessage(Component.literal("§6[Country]§3[player]§2建国成功!"), false);
		world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("§6[Country]§3[player]§3玩家 %s §2在 §4x:%d z:%d §3建立了新的国家".formatted(player.getName().getString(), Math.round(entity.getX()), Math.round(entity.getZ())))), false);
	}
}
