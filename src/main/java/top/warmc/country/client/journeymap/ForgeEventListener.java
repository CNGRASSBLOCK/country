package top.warmc.country.client.journeymap;

import journeymap.client.api.IClientAPI;
import journeymap.client.api.display.DisplayType;
import journeymap.client.api.display.PolygonOverlay;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.warmc.country.CountryMod;

import java.util.HashMap;

public class ForgeEventListener
{
    IClientAPI jmAPI;

    ForgeEventListener(IClientAPI jmAPI)
    {
        this.jmAPI = jmAPI;
    }
}
