package top.warmc.country.core.pool;

import net.minecraft.world.entity.player.Player;
import top.warmc.country.core.classes.Country;
import top.warmc.country.core.classes.Invite;
import top.warmc.country.core.classes.Town;

import java.util.*;

public abstract class InvitePool {
    private static final List<Invite> InvitePool = new ArrayList<>();

    public static void removeAll() { InvitePool.clear(); }
    public static boolean add(Invite invite) { if (InvitePool.contains(invite)) { return false; } else { InvitePool.add(invite); return true; } }
    public static boolean remove(Invite invite) { return InvitePool.remove(invite); }
    public static boolean has(Invite invite) { return InvitePool.contains(invite); }

    public static List<Invite> getAllSendInviteFromTown(Town town) {
        List<Invite> invites = new ArrayList<>();
        for (Invite invite : InvitePool) if (invite.getFrom().equals(town)) invites.add(invite);
        return invites;
    }
    public static List<Invite> getAllSendInviteFromPlayer(Player player) {
        List<Invite> invites = new ArrayList<>();
        for (Invite invite : InvitePool) if (invite.getFrom().equals(player)) invites.add(invite);
        return invites;
    }
    public static List<Invite> getAllReceiveInviteFromTown(Town town) {
        List<Invite> invites = new ArrayList<>();
        for (Invite invite : InvitePool) if (invite.getTo().equals(town)) invites.add(invite);
        return invites;
    }
    public static List<Invite> getAllReceiveInviteFromPlayer(Player player) {
        List<Invite> invites = new ArrayList<>();
        for (Invite invite : InvitePool) if (invite.getTo().equals(player)) invites.add(invite);
        return invites;
    }

    public static void upTime() { for (Invite invite : InvitePool) if ((invite.CreateTime + invite.LifeTime) < System.currentTimeMillis()) top.warmc.country.core.pool.InvitePool.remove(invite); }
}
