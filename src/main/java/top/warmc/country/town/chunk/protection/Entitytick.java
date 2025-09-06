package top.warmc.country.town.chunk.protection;

import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.core.BlockPos;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistries;
import top.warmc.country.config.Config.Config;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.classes.Town;
import top.warmc.country.core.pool.CountryPool;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Mod.EventBusSubscriber
public class Entitytick {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
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
