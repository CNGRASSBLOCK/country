package top.warmc.country.town.chunk;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import top.warmc.country.CountryMod;
import top.warmc.country.config.Config.Config;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = CountryMod.MODID, value = Dist.CLIENT)
public class Protection {
    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);
        BlockPos blockPos = event.getPos();

        Town town = CountryPool.getTownFromLand(player.level(), level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
    }

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
		if (player == null) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);
        BlockPos blockPos = event.getPos();

        Town town = CountryPool.getTownFromLand(player.level(), level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
	}

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (player == null) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);
        BlockPos blockPos = event.getPos();

        Town town = CountryPool.getTownFromLand(player.level(), level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
    }

    @SubscribeEvent
    public static void onBucketFill(FillBucketEvent event) {
        Player player = event.getEntity();
        if (player == null) return;
        Level level = player.level();
        if (level.isClientSide()) event.setCanceled(true);

        Vec3 lookVec = player.getLookAngle();
        Vec3 startVec = player.getEyePosition(1.0F);
        Vec3 endVec = player.getEyePosition(1.0F).add(lookVec.x * Double.MAX_VALUE, lookVec.y * Double.MAX_VALUE, lookVec.z * Double.MAX_VALUE);
        ClipContext context = new ClipContext(startVec, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player);
        BlockPos blockPos =  player.level().clip(context).getBlockPos();

        Town town = CountryPool.getTownFromLand(player.level(), level.getChunk(blockPos));
        if (town == null) return;

        if (!town.getPlayer().has(player.getUUID())) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("§6[Country]§c您不能在此交互"), false);
        }
    }

    @SubscribeEvent
    public static void EntitiesTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        if (event.level == null) return;

        List<ChunkPos> chunk = new ArrayList<>();
        for (String country_name : CountryPool.getAllName()) {
            Country country = CountryPool.getCountryFromName(country_name);
            if (country == null) continue;
            for (Town town : country.getAllTown()) for (ChunkPos chunkPos : town.getLand().getAll()) if (event.level.isLoaded(new BlockPos(chunkPos.x, 0, chunkPos.z))) chunk.add(chunkPos);
        }

        List<Entity> entities = new ArrayList<>();
        for (ChunkPos chunkPos : chunk) {
            AABB aabb = new AABB(new BlockPos(chunkPos.x, 0, chunkPos.z), new BlockPos(chunkPos.x + 16, 256, chunkPos.z + 16));
            entities.addAll(event.level.getEntities(null, aabb));
        }

        for (Entity entity : entities) if (Config.DEL_ENTITY.get().contains(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString())) entity.discard();
    }
}
