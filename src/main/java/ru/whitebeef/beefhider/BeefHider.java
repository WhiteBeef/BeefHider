package ru.whitebeef.beefhider;

import org.bukkit.plugin.java.JavaPlugin;
import ru.whitebeef.beefhider.commands.HideCommand;
import ru.whitebeef.beefhider.handlers.PlayerJoinHandler;
import ru.whitebeef.beefhider.managers.HideManager;
import ru.whitebeef.beeflibrary.BeefLibrary;
import ru.whitebeef.beeflibrary.commands.AbstractCommand;

public final class BeefHider extends JavaPlugin {

    private static BeefHider instance;

    public static BeefHider getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        new HideManager();

        BeefLibrary.loadConfig(this);
        BeefLibrary.registerListeners(this, new PlayerJoinHandler());

        AbstractCommand.builder("hide", HideCommand.class)
                .setPermission("beefhider.commands.hide")
                .setOnlyForPlayers(true)
                .build().register(this);
    }

    @Override
    public void onDisable() {

    }
}
