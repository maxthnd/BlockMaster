package de.mxd17.blockmaster.listeners;

import de.mxd17.blockmaster.BlockMaster;
import de.mxd17.blockmaster.utils.EffectType;
import de.mxd17.blockmaster.utils.EntitySpawner;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Random;

public class ProjectileHitListener implements Listener {

    private static final String METADATA_KEY = "blockmaster_griefer_balls";

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile instanceof Snowball && projectile.getShooter() instanceof Player) {
            Player player = (Player) projectile.getShooter();

            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand.getType() == Material.SNOWBALL && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName()) {
                String itemName = itemInHand.getItemMeta().getDisplayName();
                String configName = ChatColor.translateAlternateColorCodes('&',
                        BlockMaster.getInstance().getConfig().getString("settings.balls-name"));

                if (itemName.equals(configName)) {
                    projectile.setMetadata(METADATA_KEY, new FixedMetadataValue(BlockMaster.getInstance(), true));
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile instanceof Snowball &&
                projectile.hasMetadata(METADATA_KEY) &&
                projectile.getShooter() instanceof Player) {

            Player player = (Player) projectile.getShooter();
            Location hitLocation = null;

            if (event.getHitBlock() != null) {
                hitLocation = event.getHitBlock().getLocation().add(0.5, 1, 0.5);
            } else if (event.getHitEntity() != null) {
                hitLocation = event.getHitEntity().getLocation();
            } else {
                hitLocation = projectile.getLocation();
            }

            String eventName = getRandomEvent();
            switch (eventName) {
                case "ENTITIES":
                    EntitySpawner.spawnRandomEntity(hitLocation);
                    break;
                case "EXPLOSION":
                    BlockMaster.getInstance().getEffectManager().playEffect(hitLocation, EffectType.EXPLOSION);
                    break;
                case "LIGHTNING":
                    BlockMaster.getInstance().getEffectManager().playEffect(hitLocation, EffectType.LIGHTNING);
                    break;
                case "SPIRALE":
                    BlockMaster.getInstance().getEffectManager().playEffect(hitLocation, EffectType.SPIRALE);
                    break;
            }
        }
    }

    private String getRandomEvent() {
        String[] events = {"SPIRALE", "ENTITIES", "EXPLOSION", "LIGHTNING"};
        Random random = new Random();
        return events[random.nextInt(events.length)];
    }
}