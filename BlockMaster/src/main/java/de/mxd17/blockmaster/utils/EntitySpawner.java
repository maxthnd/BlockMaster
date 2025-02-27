package de.mxd17.blockmaster.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

import java.util.Random;

public class EntitySpawner {

    private static final EntityType[] ENTITIES = {
            EntityType.SKELETON, EntityType.ZOMBIE, EntityType.CREEPER,
            EntityType.BEE, EntityType.COW, EntityType.DONKEY, EntityType.SKELETON,
    };

    private static final Random random = new Random();

    public static void spawnRandomEntity(Location location) {
        World world = location.getWorld();
        if (world == null) return;
        EntityType randomEntity = ENTITIES[random.nextInt(ENTITIES.length)];
        world.spawnEntity(location, randomEntity);
    }

}
