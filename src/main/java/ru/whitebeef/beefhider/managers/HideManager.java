package ru.whitebeef.beefhider.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.whitebeef.beefhider.BeefHider;
import ru.whitebeef.beeflibrary.chat.MessageSender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HideManager {

    private static HideManager instance;

    public static HideManager getInstance() {
        return instance;
    }

    private final Set<UUID> hiding = new HashSet<>();

    public HideManager() {
        instance = this;
    }

    public boolean isHiding(Player player) {
        return hiding.contains(player.getUniqueId());
    }

    public void showPlayers(Player player) {
        hiding.remove(player.getUniqueId());
        new ArrayList<>(Bukkit.getOnlinePlayers()).forEach(player1 -> player.showPlayer(BeefHider.getInstance(), player1));
        MessageSender.sendMessageType(player, BeefHider.getInstance(), "show_players");
    }

    public void hidePlayers(Player player) {
        hiding.add(player.getUniqueId());
        new ArrayList<>(Bukkit.getOnlinePlayers()).forEach(player1 -> player.hidePlayer(BeefHider.getInstance(), player1));
        MessageSender.sendMessageType(player, BeefHider.getInstance(), "hide_players");
    }

}
