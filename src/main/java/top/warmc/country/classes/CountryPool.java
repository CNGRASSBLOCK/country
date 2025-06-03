package top.warmc.country.classes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.ArrayList;
import java.util.List;

public class CountryPool {
    private static final List<Country> CountryPool = new ArrayList<>();
    private static List<Country> CilentCountryPool = new ArrayList<>();

    public static List<String> getAllName(Country country) {
        List<String> allName = new ArrayList<>();
        for (Country countrys : CountryPool) allName.add(country.name);
        return allName;
    }
    public static boolean add(Country country) { if (CountryPool.contains(country)) { return false; } else { CountryPool.add(country); return true; } }
    public static boolean remove(Country country) { return CountryPool.remove(country); }
    public static boolean has(String country_name) { for (Country country : CountryPool) { if (country.name.equals(country_name)) return true; } return false; }

    public static Country getCountryFromName(String country_name) { for (Country country : CountryPool) { if (country.name.equals(country_name)) return country; } return null; }
    public static Country getCountryFromPlayer(Player player) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.getPlayer().has(player.getUUID())) return country;
        return null;
    }
    public static Country getCountryFromLand(ChunkAccess chunkAccess) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.getLand().has(chunkAccess)) return country;
        return null;
    }
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
    public static Town getTownFromLand(ChunkAccess chunkAccess) {
        for (Country country : CountryPool) for (Town town : country.getAllTown()) if (town.getLand().has(chunkAccess)) return town;
        return null;
    }

    public static void updateCilentCountryPoolList(List<Country> list) { CilentCountryPool = list; }
    public static List<Country> getCilentCountryPoolList() { return new ArrayList<>(CilentCountryPool); }
}
