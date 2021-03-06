package to.joe.j2mc.survival.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.survival.J2MC_Survival;
import to.joe.j2mc.survival.J2MC_Survival.GameStatus;

public class ArenaCommand extends MasterCommand {

    J2MC_Survival plugin;

    public ArenaCommand(J2MC_Survival survival) {
        super(survival);
        this.plugin = survival;
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (!isPlayer) {
            sender.sendMessage(ChatColor.RED + "Only players may use this command");
            return;
        }
        if (this.plugin.participants.contains(player.getName()) && (this.plugin.status == GameStatus.InGame || this.plugin.status == GameStatus.Countdown)) {
            sender.sendMessage(ChatColor.RED + "You cannot go to the arena while in game. Type" + ChatColor.AQUA + " /leave" + ChatColor.RED + " to leave this game");
            return;
        }
        player.teleport(this.plugin.gameWorld.getSpawnLocation());
        player.setAllowFlight(true);
        sender.sendMessage(ChatColor.AQUA + "Welcome to the arena");
    }

}
