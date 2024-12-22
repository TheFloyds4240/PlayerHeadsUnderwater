package com.Floods.PlayerHeadsUnderwater.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.block.Block;

public class HeadProtectionListener implements Listener {
    
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.PLAYER_HEAD) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.PLAYER_HEAD && 
            block.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.WATER) {
            event.setCancelled(true);
        }
    }
}
