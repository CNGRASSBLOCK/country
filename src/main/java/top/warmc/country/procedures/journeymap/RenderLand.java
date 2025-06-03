package top.warmc.country.procedures.journeymap;

import journeymap.client.api.ClientPlugin;
import journeymap.client.api.IClientAPI;
import journeymap.client.api.IClientPlugin;
import journeymap.client.api.event.ClientEvent;
import journeymap.client.api.model.ShapeProperties;
import journeymap.client.api.display.*;
import journeymap.client.api.model.*;
import journeymap.client.api.util.PolygonHelper;
import net.minecraft.world.level.Level;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

@journeymap.client.api.ClientPlugin
public class RenderLand implements IClientPlugin {
    private static final String MOD_ID = "country"; // 替换为你的模组ID
    private static IClientAPI jmAPI;
    private PolygonOverlay overlay;

    @Override public void initialize(IClientAPI iClientAPI) { this.jmAPI = iClientAPI; }
    @Override public String getModId() { return MOD_ID; }

    @Override
    public void onEvent(ClientEvent clientEvent) {

    }

    private void addSampleRegions() {
        if (jmAPI == null) return;

        var shapeProps = new ShapeProperties()
                .setStrokeWidth(0)
                .setFillColor(0x80FF0000);

        var textProps = new TextProperties()
                .setColor(0x80FF0000)
                .setOpacity(1f)
                .setFontShadow(true);

        var polygon = PolygonHelper.createChunkPolygon(0, 1, 0);

        var overlay = new PolygonOverlay(MOD_ID, "id", Level.OVERWORLD, shapeProps, polygon);

        overlay.setOverlayGroupName("Claimed Chunks")
                .setTitle("测试")
                .setTextProperties(textProps);
    }
}
