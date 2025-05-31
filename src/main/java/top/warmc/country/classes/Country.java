package top.warmc.country.classes;

import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Country {
    //主要的内容
    public String name;
    public UUID owner;
    public BlockPos spawn;

    private final PlayerGroup player = new PlayerGroup();
    private final PlayerGroup admin = new PlayerGroup();
    private final PlayerGroup interviewer = new PlayerGroup();

    private final LandGroup land = new LandGroup();

    public String color = "6";
    public Integer level = 1;

    public Country(String name, UUID owner, BlockPos blockPos) {
        this.name = name;
        this.owner = owner;
        this.spawn = blockPos;
    }

    public PlayerGroup getPlayer() { return player; }
    public PlayerGroup getAdmin() { return admin; }
    public PlayerGroup getInterviewer() { return interviewer; }

    public LandGroup getLand() { return land; }

    public void setName(String name) { this.name = name; }
    public void setOwner(UUID owner) { this.owner = owner; }
    public void setSpawn(BlockPos spawn) { this.spawn = spawn; }
    public void setColor(String color) { this.color = color; }


    //战争内容
    public String state = "peace";
    public List<Country> war = new ArrayList<>();

    public boolean launch(String country_name) {return true;}
}
