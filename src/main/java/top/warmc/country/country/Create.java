package top.warmc.country.country;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.pool.CountryPool;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import top.warmc.country.core.classes.Town;
//创建国家
@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER)
public class Create {
	public static void Create(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Player player) {
		//防止空指针异常
        if (player == null) return;
        //检测玩家是否加入国家
		if (CountryPool.isInCountry(player)) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您已在某个国家内!"), false);
            return;
        }
        //国家名称获取
		String country_name = StringArgumentType.getString(arguments, "country_name");
        //国家名称验证
		if (country_name.isEmpty()) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c国家名字不能为空!"), false);
            return;
        }
        //CountryPool国家池 ps.不用数据库的弱智写法，受不了一点
		if (CountryPool.has(country_name)) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c存在同名国家!"), false);
            return;
        }
        //他妈的写了一万个if的究极屎山，虽然用了else更屎
        //国家建立
		Country country = new Country(country_name, player.getUUID());
        //自动创建国家同名的城镇 ps.这个建议优化掉，因为这样跟后面城镇建立会起很大冲突
        Town town = new Town(country_name, player.getUUID(), player.level(), player.getOnPos());
        //将首都添加进国家（脱裤子放屁）
        country.addTown(town);
        //初始领土设置ps.哇是for仙人
		boolean add_chuck = false;
		for (int x = 0; x < 5; x++) {
			for (int z = 0; z < 5; z++) {
                //加x y 区块
				ChunkAccess chunkAccess = world.getChunk(new BlockPos((int) (player.getX() + (x - 2) * 16), 0, (int) (player.getZ() + (z - 2) * 16)));
                //检查是否被占用
				if (!CountryPool.isInCountry(player.level(), chunkAccess)) { town.getLand().add(player.level(), chunkAccess);
                    add_chuck = true;
                }
			}
		}
		if (!add_chuck) player.displayClientMessage(Component.literal("§6[Country]§3[player]§c无法为您的国家声明土地!"), false);
        //创建结束，发送提示信息
		CountryPool.add(country);
		player.displayClientMessage(Component.literal("§6[Country]§3[player]§2建国成功!"), false);
		world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("§6[Country]§3[player]§3玩家 %s §2在 §4x:%d z:%d §3建立了新的国家".formatted(player.getName().getString(), Math.round(player.getX()), Math.round(player.getZ())))), false);
	}
}
