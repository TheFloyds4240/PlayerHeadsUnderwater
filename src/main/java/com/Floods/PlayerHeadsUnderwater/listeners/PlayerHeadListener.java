package com.Floods.PlayerHeadsUnderwater.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Block;
import org.bukkit.Material;

public class PlayerHeadListener implements Listener {
    
    public PlayerHeadListener() {
        // Empty constructor
    }

    @EventHandler
    public void onPlayerPlaceHead(BlockPlaceEvent event) {
        Block block = event.getBlock();

        // Check if the block being placed is a player head
        if (event.getItemInHand().getType() == Material.PLAYER_HEAD) {
            // Check if the block is underwater
            if (block.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.WATER) {
                // Prevent the head from breaking
                event.setCancelled(true);
                block.setType(Material.PLAYER_HEAD);
                block.getState().update(true);
            }
        }
    }
}