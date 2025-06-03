package top.warmc.country.core.classes;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.ArrayList;
import java.util.List;

public class LandGroup {
    private final List<ChunkPos> chunk = new ArrayList<>();

    public boolean has(ChunkAccess chunkAccess) { return chunk.contains(chunkAccess.getPos()); }
    public boolean add(ChunkAccess chunkAccess) { if (chunk.contains(chunkAccess.getPos())) { return false; } else { chunk.add(chunkAccess.getPos()); return true; } }
    public boolean remove(ChunkAccess chunkAccess) { return chunk.remove(chunkAccess.getPos()); }
}
