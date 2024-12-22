package com.Floods.PlayerHeadsUnderwater;

import org.bukkit.plugin.java.JavaPlugin;
import com.Floods.PlayerHeadsUnderwater.listeners.PlayerHeadListener;
import com.Floods.PlayerHeadsUnderwater.listeners.WaterproofHeadListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerHeadListener(), this);
        getServer().getPluginManager().registerEvents(new WaterproofHeadListener(), this);
        getLogger().info("PlayerHeadPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlayerHeadPlugin has been disabled!");
    }
}