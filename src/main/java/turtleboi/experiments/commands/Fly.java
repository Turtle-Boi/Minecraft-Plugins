package turtleboi.experiments.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            //If the command is run through the console
            sender.sendMessage("This command is not valid in the console.");
            return true;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight()) {
            //Player already has flight
            player.setAllowFlight(false);
            player.sendMessage("Flying disabled.");
        } else {
            //Player is requesting flight
            player.setAllowFlight(true);
            player.sendMessage("Flying enabled.");
        }

        return true;
    }
}
