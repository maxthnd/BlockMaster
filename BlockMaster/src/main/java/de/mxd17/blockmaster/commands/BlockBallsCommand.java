package de.mxd17.blockmaster.commands;

import de.mxd17.blockmaster.BlockMaster;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockBallsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(BlockMaster.getInstance().getConfig().getString("prefix") + ChatColor.RED + "BlockMaster kann nur von Spielern genutzt werden.");
            return true;
        }
        Player player = (Player) commandSender;
        if(player.isOp() || player.hasPermission("blockmaster.admin")) {
            player.sendMessage(BlockMaster.getInstance().getConfig().getString("prefix") + "§7Dir wurden " + ChatColor.YELLOW + "x16" + ChatColor.GRAY + " die " + BlockMaster.getInstance().getConfig().getString("settings.balls-name") + " §7gegeben");
            ItemStack snowballs = new ItemStack(Material.SNOWBALL, 16);
            ItemMeta meta = snowballs.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', BlockMaster.getInstance().getConfig().getString("settings.balls-name")));
                snowballs.setItemMeta(meta);
            }
            player.getInventory().addItem(snowballs);
        } else{
            player.sendMessage(BlockMaster.getInstance().getConfig().getString("prefix") + "§cDu hast keine Berechtigung für diesen Command!");
        }
        return true;
    }
}
