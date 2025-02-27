package de.mxd17.blockmaster.listeners;

import de.mxd17.blockmaster.BlockMaster;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener  implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(BlockMaster.getInstance().getConfig().getString("prefix") + " " + ChatColor.GRAY + "Das Plugin " + ChatColor.AQUA + "BlockMaster " + ChatColor.GRAY + "ist " + ChatColor.GREEN + "verfügbar." + ChatColor.GRAY + " Für weitere Infos tippe " + ChatColor.YELLOW + " /blockmaster");
    }
}
