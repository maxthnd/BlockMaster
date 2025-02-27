package de.mxd17.blockmaster.listeners;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunchListener implements Listener {

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        if(projectile instanceof Snowball){
            if(projectile.getShooter() instanceof Player){
                Player player = (Player) projectile.getShooter();
                if(projectile.getName().equals("")){

                }
            }
        }
    }

    private Item getRandomEvent(Player player) {
        // return random item from config
        return null;
    }
}
