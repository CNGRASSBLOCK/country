package top.warmc.country.config;

import net.minecraftforge.eventbus.api.IEventBus;
import top.warmc.country.CountryMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.warmc.country.config.Config.Config;

public class CountryModConfigs {
	public static void register(IEventBus eventBus) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "country_config.toml");
	}
}
