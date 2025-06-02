package top.warmc.country.procedures.country.other;

import top.warmc.country.CountryMod;

import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.api.distmarker.Dist;
//import top.warmc.country.procedures.file.ReadDataProcedure;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.DEDICATED_SERVER})
public class OnServerStartProcedure {
	@SubscribeEvent
	public static void init(FMLDedicatedServerSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		CountryMod.LOGGER.info("====================================================");
		CountryMod.LOGGER.info("|  ▋▋▋                                             |");
		CountryMod.LOGGER.info("| ▋   ▋                                            |");
		CountryMod.LOGGER.info("| ▋                                                |");
		CountryMod.LOGGER.info("| ▋        ▋▋    ▋  ▋    ▋ ▋▋     ▋    ▋ ▋   ▋   ▋ |");
		CountryMod.LOGGER.info("| ▋       ▋  ▋   ▋  ▋    ▋▋  ▋   ▋▋▋   ▋▋ ▋  ▋   ▋ |");
		CountryMod.LOGGER.info("| ▋   ▋   ▋  ▋   ▋  ▋    ▋   ▋    ▋    ▋     ▋   ▋ |");
		CountryMod.LOGGER.info("|  ▋▋▋     ▋▋     ▋▋ ▋   ▋   ▋    ▋▋   ▋      ▋▋▋  |");
		CountryMod.LOGGER.info("|                                               ▋  |");
		CountryMod.LOGGER.info("|                                             ▋▋   |");
		CountryMod.LOGGER.info("====================================================");
		CountryMod.LOGGER.info("Reading Data");
//		ReadDataProcedure.execute();
	}
}
