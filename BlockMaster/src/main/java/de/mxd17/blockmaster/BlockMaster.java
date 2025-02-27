package de.mxd17.blockmaster;

import de.mxd17.blockmaster.commands.BlockBallsCommand;
import de.mxd17.blockmaster.commands.BlockMasterCommand;
import de.mxd17.blockmaster.listeners.PlayerJoinListener;
import de.mxd17.blockmaster.listeners.ProjectileHitListener;
import de.mxd17.blockmaster.utils.EffectManager;
import de.mxd17.blockmaster.utils.EntitySpawner;
import org.bukkit.plugin.java.JavaPlugin;


public class BlockMaster extends JavaPlugin
{

    private static BlockMaster instance;
    private EffectManager effectManager;
    private EntitySpawner entitySpawner;

    public static BlockMaster getInstance(){
        return instance;
    }

    public EffectManager getEffectManager() {
        return effectManager;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        registerEvents();
        registerCommands();
        effectManager = new EffectManager(this);
        getLogger().info("[BlockMaster] Das Plugin wurde erfolgreich gestartet.");
    }

    @Override
    public void onDisable() {
        getLogger().info("[BlockMaster] Das Plugin wurde deaktiviert.");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitListener(), this);
    }

    private void registerCommands() {
        getCommand("blockmaster").setExecutor(new BlockMasterCommand());
        getCommand("blockballs").setExecutor(new BlockBallsCommand());
    }

}
