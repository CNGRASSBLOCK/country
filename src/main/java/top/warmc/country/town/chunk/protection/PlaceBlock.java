package top.warmc.country.town.chunk.protection;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;


@Mod.EventBusSubscriber
public class PlaceBlock {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);
        BlockPos blockPos = event.getPos();

        Town town = CountryPool.getTownFromLand(level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
    }
}
