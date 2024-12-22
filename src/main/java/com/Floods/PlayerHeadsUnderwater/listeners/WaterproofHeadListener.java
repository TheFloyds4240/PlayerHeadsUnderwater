package com.Floods.PlayerHeadsUnderwater.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class WaterproofHeadListener implements Listener {
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPhysics(BlockPhysicsEvent event) {
        if (event.getBlock().getType() == Material.PLAYER_HEAD || 
            event.getBlock().getType() == Material.PLAYER_WALL_HEAD) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onLiquidFlow(BlockFromToEvent event) {
        Block to = event.getToBlock();
        if (to.getType() == Material.PLAYER_HEAD || 
            to.getType() == Material.PLAYER_WALL_HEAD) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onWaterPlace(PlayerBucketEmptyEvent event) {
        Block targetBlock = event.getBlock();
        for (BlockFace face : BlockFace.values()) {
            Block relative = targetBlock.getRelative(face);
            if (relative.getType() == Material.PLAYER_HEAD || 
                relative.getType() == Material.PLAYER_WALL_HEAD) {
                event.setCancelled(true);
                return;
            }
        }
    }
}
