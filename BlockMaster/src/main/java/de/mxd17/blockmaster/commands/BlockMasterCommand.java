package de.mxd17.blockmaster.commands;

import de.mxd17.blockmaster.BlockMaster;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockMasterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(BlockMaster.getInstance().getConfig().getString("prefix") + ChatColor.RED + "BlockMaster kann nur von Spielern genutzt werden.");
            return true;
        }
        Player player = (Player) commandSender;
        for(int i = 0; i < 20; i++){
            player.sendMessage(" ");
        }
        player.sendMessage(ChatColor.GRAY + "[===============[ " + ChatColor.AQUA + ChatColor.BOLD + "BlockMaster" + ChatColor.GRAY + " ]===============]");
        player.sendMessage(ChatColor.GRAY + "Das Plugin wurde von " + ChatColor.YELLOW + "mxd17" + ChatColor.GRAY + " geschrieben.");
        player.sendMessage(ChatColor.RED + "Bei Fragen oder Problemen wende dich an " + ChatColor.YELLOW + "maxthnd auf GitHub");
        player.sendMessage(ChatColor.GRAY + "[===============[ " + ChatColor.AQUA + ChatColor.BOLD + "BlockMaster" + ChatColor.GRAY + " ]===============]");
        return true;
    }
}
