package top.warmc.country.core.classes;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.ArrayList;
import java.util.List;

public class LandGroup {
    private final List<ChunkPos> chunk = new ArrayList<>();
    private final String WorldID ;

    public LandGroup(Level world) {
        this.WorldID = world.dimension().location().toString();
    }

    public LandGroup(String world) {
        this.WorldID =world;
    }

    public String getWorldID() { return WorldID; }

    public void removeAll() { chunk.clear(); }
    public List<ChunkPos> getAll() { return new ArrayList<>(chunk); }
    public boolean has(Level level, ChunkAccess chunkAccess) { return chunk.contains(chunkAccess.getPos()); }
    public boolean add(Level level, ChunkAccess chunkAccess) { if (chunk.contains(chunkAccess.getPos()) || !level.dimension().location().toString().equals(WorldID)) { return false; } else { chunk.add(chunkAccess.getPos()); return true; } }
    public boolean remove(Level level, ChunkAccess chunkAccess) { if (level.dimension().location().toString().equals(WorldID)) return chunk.remove(chunkAccess.getPos()); else return false;}
}
