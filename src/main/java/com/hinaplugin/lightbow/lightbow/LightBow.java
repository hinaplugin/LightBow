package com.hinaplugin.lightbow.lightbow;

import org.bukkit.plugin.java.JavaPlugin;

public final class LightBow extends JavaPlugin {
    public static LightBow plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new ShootListener(plugin), this);
        getCommand("getLightBow").setExecutor(new Commands(plugin));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LightBow getPlugin(){ return plugin; }
}
