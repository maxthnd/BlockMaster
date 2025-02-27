package de.mxd17.blockmaster.utils;

import de.mxd17.blockmaster.BlockMaster;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EffectManager {

    private final JavaPlugin plugin;

    public EffectManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void playEffect(Location location, EffectType effectType) {
        switch (effectType) {
            case SPIRALE:
                playSpiralEffect(location);
                break;
            case EXPLOSION:
                playExplosionEffect(location);
                break;
            case LIGHTNING:
                playLightningEffect(location);
                break;
        }
    }

    private void playSpiralEffect(Location location) {
        new BukkitRunnable() {
            double radius = 1.5;
            double height = 0;
            double angle = 0;
            int particles = 20;
            @Override
            public void run() {
                if (height > 3) {
                    cancel();
                    return;
                }

                for (int i = 0; i < particles; i++) {
                    double angleStep = 2 * Math.PI * i / particles;
                    double x = radius * Math.cos(angleStep);
                    double z = radius * Math.sin(angleStep);
                    location.getWorld().spawnParticle(Particle.SNOWFLAKE, location.clone().add(x, height, z), 1, 0, 0, 0, 0);
                }

                height += 0.2;
                radius *= 0.98;
                particles = Math.max(5, particles - 1);
            }
        }.runTaskTimer(plugin, 0, 5);
    }

    private void playExplosionEffect(Location location) {
        location.getWorld().createExplosion(location, BlockMaster.getInstance().getConfig().getInt("settings.explosion-radius"));
    }

    private void playLightningEffect(Location location) {
        location.getWorld().strikeLightningEffect(location);
    }

}
