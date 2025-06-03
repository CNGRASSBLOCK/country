package top.warmc.country.core.classes;

import net.minecraft.world.entity.player.Player;

public class Invite {
    private final Object From;
    private final Object To;

    public Invite(Town from_town, Player to_player) {
        this.From = from_town;
        this.To = to_player.getUUID();
    }
    public Invite(Player from_player, Town to_town) {
        this.From = from_player.getUUID();
        this.To = to_town;
    }
}
