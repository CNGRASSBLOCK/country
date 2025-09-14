package top.warmc.country.town.chunk;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.warmc.country.CountryMod;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;
//圈地相关
@Mod.EventBusSubscriber(modid = CountryMod.MODID, value = Dist.CLIENT)
public class Operation {
	public static void Statement(Player player, boolean isAuto) {
        //防止空指针异常
        if (player == null) return;
        //依旧检测
        //获取信息
        Town town = CountryPool.getTownFromPlayer(player);
        //检测是否在城镇中
        if (town == null && !isAuto) {
            player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立城镇!"), false);
            return;
        }
        //检测区块状态
        if (CountryPool.getTownFromLand(player.level(), player.level().getChunk(player.getOnPos())) != null && !isAuto) {
            player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§c该区块已被声明!"), false);
            return;
        }
        //
        Country country = CountryPool.getCountryFromTown(town);
        //防止空指针异常
        if (country == null) return;
        //检测国家状态
        if (country.isPeace()) {
            town.getLand().add(player.level(), player.level().getChunk(player.getOnPos()));

            if (!isAuto)player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§e声明成功!"), false);
        }
        //这几把else了个啥
        else {

        }
    }

    public static void UnStatement(Player player) {
        if (player == null) return;

        Town town = CountryPool.getTownFromPlayer(player);
        if (town == null) { player.displayClientMessage(Component.literal("§6[Country]§3[player]§c您没有建立城镇!"), false); return; }

        if (CountryPool.getTownFromLand(player.level(), player.level().getChunk(player.getOnPos())) != null) { player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§c该区块已被声明!"), false); return; }

        if (town.getLand().remove(player.level(), player.level().getChunk(player.getOnPos())))
            player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§e取消声明成功!"), false);
        else
            player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§c该区块未被声明!"), false);
    }



    public static void OpenAutoStatement(Player player) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putBoolean("auto_statement", true);
        player.getPersistentData().put("country", compoundTag);
        player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§e自动圈地已开启!"), false);
    }

    public static void CloseAutoStatement(Player player) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putBoolean("auto_statement", false);
        player.getPersistentData().put("country", compoundTag);
        player.displayClientMessage(Component.literal("§6[Country]§a[chunk]§e自动圈地已关闭!"), false);
    }

    @SubscribeEvent
    public static void AutoStatement(TickEvent.PlayerTickEvent event) {
        if (event.player.getPersistentData().getCompound("country").getBoolean("auto_statement")) Statement(event.player, true);
    }
}
