package top.warmc.country.core.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PeopleGroup {
    private static final List<UUID> players = new ArrayList<>();

    public void removeAll() { players.clear(); }
    public boolean has(UUID uuid) { return players.contains(uuid); }
    public boolean add(UUID uuid) { if (players.contains(uuid)) { return false; } else { players.add(uuid); return true; } }
    public boolean remove(UUID uuid) { return players.remove(uuid); }
}
