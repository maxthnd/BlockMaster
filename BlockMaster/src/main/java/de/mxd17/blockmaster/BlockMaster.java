package de.plorax.blockmaster;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockMaster extends JavaPlugin
{

    @Override
    public void onEnable() {
        getLogger().info("[BlockMaster] Das Plugin wurde erfolgreich gestartet.");
    }

    @Override
    public void onDisable() {
        getLogger().info("[BlockMaster] Das Plugin wurde deaktiviert.");
    }

}
