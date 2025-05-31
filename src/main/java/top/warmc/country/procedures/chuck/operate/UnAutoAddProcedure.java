package top.warmc.country.procedures.chuck.operate;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import top.warmc.country.procedures.chuck.operate.AddProcedure;

public class UnAutoAddProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		AddProcedure.execute(world, entity, false);
	}
}
