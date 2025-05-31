package top.warmc.country.procedures.chuck.protection;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import top.warmc.country.config.ConfigConfiguration;
import top.warmc.country.network.CountryModVariables;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.core.BlockPos;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.server.level.FullChunkStatus;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class EntitytickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			LevelAccessor world = event.level;
			
			List<String> del_type = new ArrayList<>();
			for (String stringiterator : ConfigConfiguration.DEL_ENTITY.get()) {
				del_type.add(stringiterator);
			}
			
			List<List> chuck_list = new ArrayList<>();
			for (int index0 = 0; index0 < (int) CountryModVariables.country_name.size(); index0++) {
				if ((CountryModVariables.country_start.get(index0).equals("peace"))) {
					chuck_list.addAll((List) CountryModVariables.country_chucks.get(index0));
				}
			}
			
			List<Entity> entity_List = new ArrayList<>();
			for (List chuck_pos : chuck_list) {
				LevelChunk one_chuck = (LevelChunk) world.getChunk(new BlockPos((int) (chuck_pos.get(0)), (int) (-64), (int) (chuck_pos.get(1))));
				if (one_chuck.getFullStatus() == FullChunkStatus.ENTITY_TICKING) {
					AABB boundingBox = new AABB(((int) (chuck_pos.get(0))), -64, ((int) (chuck_pos.get(1))), (((int) (chuck_pos.get(0))) + 16), 320, (((int) (chuck_pos.get(1))) + 16));
					List<Entity> entities = world.getEntitiesOfClass(Entity.class, boundingBox);
                	entity_List.addAll((List) entities);
				}
			}
			
	        for(Entity entitys : entity_List){
			    if (del_type.contains((ForgeRegistries.ENTITY_TYPES.getKey(entitys.getType()).toString()))) {
	                entitys.discard();
			    }
	        }
		}
	}
}
