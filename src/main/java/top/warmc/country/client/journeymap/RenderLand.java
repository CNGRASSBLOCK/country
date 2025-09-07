package top.warmc.country.client.journeymap;

import journeymap.client.api.ClientPlugin;
import journeymap.client.api.IClientAPI;
import journeymap.client.api.IClientPlugin;
import journeymap.client.api.event.ClientEvent;
import journeymap.client.api.model.ShapeProperties;
import journeymap.client.api.display.*;
import journeymap.client.api.model.*;
import journeymap.client.api.util.PolygonHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import top.warmc.country.CountryMod;


import java.util.Arrays;
import java.util.EnumSet;

import static journeymap.client.api.event.ClientEvent.Type.*;

@ClientPlugin
@Mod.EventBusSubscriber(modid = CountryMod.MODID, value = Dist.CLIENT)
public class RenderLand implements IClientPlugin {
    private static IClientAPI jmAPI = null;
    private ForgeEventListener forgeEventListener;

    @Override public void initialize(@NotNull IClientAPI iClientAPI) {
        jmAPI = iClientAPI;
        forgeEventListener = new ForgeEventListener(jmAPI);
        MinecraftForge.EVENT_BUS.register(forgeEventListener);

        // Subscribe to desired ClientEvent types from JourneyMap
        this.jmAPI.subscribe(getModId(), EnumSet.of(ClientEvent.Type.DEATH_WAYPOINT, MAPPING_STARTED, MAPPING_STOPPED, REGISTRY));
        int a = 0;
    }
    @Override public String getModId() { return CountryMod.MODID; }

    @Override public void onEvent(@NotNull ClientEvent clientEvent) { }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (jmAPI == null) return;
        MapPolygon polygon = PolygonHelper.createChunkPolygon(0, 1, 0);

        // 设置样式
        ShapeProperties shapeProps = new ShapeProperties()
                .setStrokeWidth(2)
                .setFillColor(0xFFFFFFFF)
                .setFillOpacity(0.5f);

        // 创建多边形覆盖物
        PolygonOverlay polygonOverlay = new PolygonOverlay("vs_orbit", "country", Level.OVERWORLD, shapeProps, polygon);

        polygonOverlay.setActiveUIs(EnumSet.of(Context.UI.Minimap, Context.UI.Fullscreen));
        polygonOverlay.setActiveMapTypes(EnumSet.of(Context.MapType.Day, Context.MapType.Night));

        // 显示
        try {
            jmAPI.show(polygonOverlay);
        } catch (Exception e) {
        }
    }
}
