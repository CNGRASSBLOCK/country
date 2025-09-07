package top.warmc.country.core.pool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.classes.Town;

import java.util.ArrayList;
import java.util.List;

public abstract class CountryPool {
    private static final List<Country> CountryPool = new ArrayList<>();
    private static List<Country> CilentCountryPool = new ArrayList<>();

    public static List<String> getAllName() {
        List<String> allName = new ArrayList<>();
        for (Country country : CountryPool) allName.add(country.name);
        return allName;
    }

    public static void removeAll() { CountryPool.clear(); }
    public static boolean add(Country country) { if (CountryPool.contains(country)) { return false; } else { CountryPool.add(country); return true; } }
    public static boolean remove(Country country) { return CountryPool.remove(country); }
    public static boolean has(String country_name) { for (Country country : CountryPool) { if (country.name.equals(country_name)) return true; } return false; }

    public static boolean isInCountry(Player player) { return top.warmc.country.core.pool.CountryPool.getTownFromPlayer(player) != null; }
    public static boolean isInCountry(Level level, ChunkAccess chunkAccess) { return top.warmc.country.core.pool.CountryPool.getTownFromLand(level, chunkAccess) != null; }

    public static Country getCountryFromName(String country_name) { for (Country country : CountryPool) { if (country.name.equals(country_name)) return country; } return null; }
    public static Country getCountryFromTown(Town town) {
        for (Country country : CountryPool) if (country.getAllTown().contains(town)) return country;
        return null;
    }
    public static Town getTownFromName(String town_name) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.name.equals(town_name)) return town;
        return null;
    }
    public static Town getTownFromPlayer(Player player) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.getPlayer().has(player.getUUID())) return town;
        return null;
    }
    public static Town getTownFromLand(Level level, ChunkAccess chunkAccess) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.getLand().has(level, chunkAccess)) return town;
        return null;
    }

    public static void updateCilentCountryPoolList(List<Country> list) { CilentCountryPool = list; }
    public static List<Country> getCilentCountryPoolList() { return new ArrayList<>(CilentCountryPool); }
}
