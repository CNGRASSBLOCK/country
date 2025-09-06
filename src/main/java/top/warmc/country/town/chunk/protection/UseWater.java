package top.warmc.country.town.chunk.protection;

import net.minecraft.world.level.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;

@Mod.EventBusSubscriber
public class UseWater {
	@SubscribeEvent
	public static void onBucketFill(FillBucketEvent event) {
        Player player = event.getEntity();
        if (player == null) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);
        BlockPos blockPos = getPlayerLookAt(player).getBlockPos();

        Town town = CountryPool.getTownFromLand(level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
    }

    private static BlockHitResult getPlayerLookAt(Player player) {
        Vec3 lookVec = player.getLookAngle();
        Vec3 startVec = player.getEyePosition(1.0F);
        Vec3 endVec = player.getEyePosition(1.0F).add(lookVec.x * Double.MAX_VALUE, lookVec.y * Double.MAX_VALUE, lookVec.z * Double.MAX_VALUE);
        // 创建射线追踪上下文
        ClipContext context = new ClipContext(startVec, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player);

        // 执行射线追踪并返回结果
        return player.level().clip(context);
    }

}
