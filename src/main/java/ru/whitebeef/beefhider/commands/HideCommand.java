package ru.whitebeef.beefhider.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.whitebeef.beefhider.BeefHider;
import ru.whitebeef.beefhider.managers.HideManager;
import ru.whitebeef.beeflibrary.chat.MessageSender;
import ru.whitebeef.beeflibrary.commands.AbstractCommand;
import ru.whitebeef.beeflibrary.commands.Alias;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class HideCommand extends AbstractCommand {
    public HideCommand(@NotNull String name, @Nullable String permission, @Nullable String description, @Nullable String usageMessage, boolean onlyForPlayers, BiConsumer<CommandSender, String[]> onCommand, BiFunction<CommandSender, String[], List<String>> onTabComplete, Map<String, AbstractCommand> subCommands, List<Alias> aliases, int minArgsCount) {
        super(name, permission, description, usageMessage, onlyForPlayers, onCommand, onTabComplete, subCommands, aliases, minArgsCount);
    }

    @Override
    protected void onCommand(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        HideManager hideManager = HideManager.getInstance();
        if (hideManager.isHiding(player)) {
            hideManager.showPlayers(player);
        } else {
            hideManager.hidePlayers(player);
        }
    }
}
