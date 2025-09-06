package top.warmc.country;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;
import top.warmc.country.config.CountryModConfigs;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

import java.lang.reflect.Field;

import java.io.StringWriter;
import java.io.PrintWriter;

@Mod("country")
public class CountryMod {
	public static final Logger LOGGER = LogManager.getLogger(CountryMod.class);
	public static final String MODID = "country";

	public CountryMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        DisplayMessage();
        CountryModConfigs.register(bus);
	}


	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}
	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0) actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}

    private void DisplayMessage() {
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
    }
}
