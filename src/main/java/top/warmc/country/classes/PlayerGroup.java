package top.warmc.country.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerGroup {
    private static final List<UUID> players = new ArrayList<>();

    public boolean has(UUID uuid) { return players.contains(uuid); }
    public boolean add(UUID uuid) { if (players.contains(uuid)) { return false; } else { players.add(uuid); return true; } }
    public boolean remove(UUID uuid) { return players.remove(uuid); }
}
