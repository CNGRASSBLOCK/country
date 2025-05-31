package top.warmc.country.classes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.ArrayList;
import java.util.List;

public class CountryPool {
    private static final List<Country> countryPool = new ArrayList<>();

    public static boolean add(Country country) { if (countryPool.contains(country)) { return false; } else { countryPool.add(country); return true; } }
    public static boolean remove(Country country) { return countryPool.remove(country); }
    public static boolean has(String country_name) { for (Country country : countryPool) { if (country.name.equals(country)) return true; } return false; }

    public static Country getFromName(String country_name) { for (Country country : countryPool) { if (country.name.equals(country)) return country; } return null; }
    public static Country getFromPlayer(Player player) { for (Country country : countryPool) { if (country.getPlayer().has(player.getUUID()) ) return country; } return null; }
    public static Country getFromLand(ChunkAccess chunkAccess) { for (Country country : countryPool) { if (country.getLand().has(chunkAccess)) return country; } return null; }
}
