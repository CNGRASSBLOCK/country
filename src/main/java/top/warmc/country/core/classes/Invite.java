package top.warmc.country.core.classes;

import net.minecraft.world.entity.player.Player;

import java.util.Objects;

public class Invite {
    private final Object From;
    private final Object To;

    public final Long CreateTime;
    public final Long LifeTime;

    public Invite(Town from_town, Player to_player, long lifeTime) {
        this.From = from_town;
        this.To = to_player.getUUID();
        this.CreateTime = System.currentTimeMillis() / 1000;
        this.LifeTime = lifeTime;
    }
    public Invite(Player from_player, Town to_town, long lifeTime) {
        this.From = from_player.getUUID();
        this.To = to_town;
        this.CreateTime = System.currentTimeMillis() / 1000;
        this.LifeTime = lifeTime;
    }

    public Object getFrom() { return From; }
    public Object getTo() { return To; }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Invite invite)) return false;
        return Objects.equals(From, invite.From) && Objects.equals(To, invite.To);
    }
    @Override public int hashCode() { return Objects.hash(From, To); }
}
