package ru.whitebeef.beefhider.handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.whitebeef.beefhider.BeefHider;
import ru.whitebeef.beefhider.managers.HideManager;

import java.util.ArrayList;

public class PlayerJoinHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        HideManager hideManager = HideManager.getInstance();
        new ArrayList<>(Bukkit.getOnlinePlayers()).stream()
                .filter(hideManager::isHiding)
                .forEach(player1 -> player1.hidePlayer(BeefHider.getInstance(), player));

        hideManager.hidePlayers(player);
    }


}
