package top.warmc.country.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Country {
    //主要的内容
    public String name;
    public UUID owner;

    private final PeopleGroup admin = new PeopleGroup();

    private final List<Town> Towns = new ArrayList<>();

    public String color = "6";

    public Country(String name, UUID owner) {
        this.name = name;
        this.owner = owner;
    }

    public PeopleGroup getAdmin() { return admin; }

    public void setName(String name) { this.name = name; }
    public void setOwner(UUID owner) { this.owner = owner; }
    public void setColor(String color) { this.color = color; }

    public List<Town> getAllTown() { return new ArrayList<>(this.Towns); }
    public Town getTown(String name) {
        for (Town town : this.Towns) if (town.name.equals(name)) return town;
        return null;
    }
    public boolean addTown(Town town) {
        for (Town town1 : this.Towns) if (town1.equals(town)) return false;
        this.Towns.add(town);
        return true;
    }
    public boolean removeTown(Town town) { return this.Towns.remove(town); }

    //战争内容
    public List<Country> war = new ArrayList<>();

    public boolean isPeace() { return this.war.isEmpty(); }
    public boolean launch(String country_name) {
        Country country = CountryPool.getFromName(country_name);
        if (country == null) return false;
        if (this.war.contains(country)) return false;
        this.war.add(country);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Country country)) return false;
        return Objects.equals(name, country.name);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
