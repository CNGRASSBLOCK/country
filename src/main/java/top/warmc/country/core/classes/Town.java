package top.warmc.country.core.classes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.Objects;
import java.util.UUID;

public class Town {
    //主要的内容
    public String name;
    public UUID owner;
    public BlockPos spawn;

    private final PeopleGroup player = new PeopleGroup();
    private final PeopleGroup admin = new PeopleGroup();
    private final PeopleGroup interviewer = new PeopleGroup();

    private final LandGroup land;

    public Town(String name, UUID owner, Level level, BlockPos blockPos) {
        this.name = name;
        this.owner = owner;
        this.spawn = blockPos;
        this.land = new LandGroup(level);
    }

    public PeopleGroup getPlayer() { return player; }
    public PeopleGroup getAdmin() { return admin; }
    public PeopleGroup getInterviewer() { return interviewer; }

    public LandGroup getLand() { return land; }

    public void setName(String name) { this.name = name; }
    public void setOwner(UUID owner) { this.owner = owner; }
    public void setSpawn(BlockPos spawn) { this.spawn = spawn; }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Town town)) return false;
        return Objects.equals(name, town.name);
    }
    @Override public int hashCode() {
        return Objects.hashCode(name);
    }
}
