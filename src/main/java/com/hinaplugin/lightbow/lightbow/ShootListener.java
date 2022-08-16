package com.hinaplugin.lightbow.lightbow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.type.Ladder;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.projectiles.ProjectileSource;

public class ShootListener extends Insights implements Listener {
    public ShootListener(LightBow plugin) {
        super(plugin);
    }

    private NamespacedKey namespacedKey = new NamespacedKey(LightBow.getPlugin(), "LB");


    @EventHandler
    public void onShooting(ProjectileHitEvent event){
        if (event.getEntity() instanceof Arrow){
            if (event.getHitBlock() == null || event.getHitBlockFace() == null){
                return;
            }

            ProjectileSource source = event.getEntity().getShooter();
            Player player = (Player) source;
            if (player == null){
                return;
            }
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            PersistentDataContainer container = itemStack.getItemMeta().getPersistentDataContainer();
            if ("LBA".equalsIgnoreCase(container.get(namespacedKey, PersistentDataType.STRING))){
                if (event.getHitBlockFace() != null){
                    double blockX;
                    double blockY;
                    double blockZ;
                    switch (event.getHitBlockFace()){
                        case UP:
                            blockX = Math.floor(event.getHitBlock().getX());
                            blockY = Math.floor(event.getHitBlock().getY()) + 1;
                            blockZ = Math.floor(event.getHitBlock().getZ());
                            if (event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.AIR || event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.CAVE_AIR){
                                event.getHitBlock().getWorld().setType(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ), Material.TORCH);
                            }
                            break;
                        case NORTH:
                            blockX = Math.floor(event.getHitBlock().getX());
                            blockY = Math.floor(event.getHitBlock().getY());
                            blockZ = Math.floor(event.getHitBlock().getZ()) - 1;
                            if (event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.AIR || event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.CAVE_AIR){
                                //event.getHitBlock().getWorld().setType(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ), Material.TORCH);
                                Block block = event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ));
                                block.setType(Material.WALL_TORCH);
                                Directional directional = (Directional) block.getBlockData();
                                directional.setFacing(BlockFace.NORTH);
                                block.setBlockData(directional);
                            }
                            break;
                        case EAST:
                            blockX = Math.floor(event.getHitBlock().getX()) + 1;
                            blockY = Math.floor(event.getHitBlock().getY());
                            blockZ = Math.floor(event.getHitBlock().getZ());
                            if (event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.AIR || event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.CAVE_AIR){
                                //event.getHitBlock().getWorld().setType(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ), Material.TORCH);
                                Block block = event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ));
                                block.setType(Material.WALL_TORCH);
                                Directional directional = (Directional) block.getBlockData();
                                directional.setFacing(BlockFace.EAST);
                                block.setBlockData(directional);
                            }
                            break;
                        case WEST:
                            blockX = Math.floor(event.getHitBlock().getX()) - 1;
                            blockY = Math.floor(event.getHitBlock().getY());
                            blockZ = Math.floor(event.getHitBlock().getZ());
                            if (event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.AIR || event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.CAVE_AIR){
                                //event.getHitBlock().getWorld().setType(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ), Material.TORCH);
                                Block block = event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ));
                                block.setType(Material.WALL_TORCH);
                                Directional directional = (Directional) block.getBlockData();
                                directional.setFacing(BlockFace.WEST);
                                block.setBlockData(directional);
                            }
                            break;
                        case SOUTH:
                            blockX = Math.floor(event.getHitBlock().getX());
                            blockY = Math.floor(event.getHitBlock().getY());
                            blockZ = Math.floor(event.getHitBlock().getZ()) + 1;
                            if (event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.AIR || event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ)).getType() == Material.CAVE_AIR){
                                //event.getHitBlock().getWorld().setType(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ), Material.TORCH);
                                Block block = event.getHitBlock().getWorld().getBlockAt(new Location(event.getHitBlock().getWorld(), blockX, blockY, blockZ));
                                block.setType(Material.WALL_TORCH);
                                Directional directional = (Directional) block.getBlockData();
                                directional.setFacing(BlockFace.SOUTH);
                                block.setBlockData(directional);
                            }
                            break;
                        default:
                    }
                    event.getEntity().remove();

                }
            }
            /*
            double x = Math.floor(event.getEntity().getLocation().getX());
            double y = Math.floor(event.getEntity().getLocation().getY());
            double z = Math.floor(event.getEntity().getLocation().getZ());
            if (player != null){
                player.sendMessage(x + ", " + y + ", " + z + ", " + event.getHitBlock());
                player.sendMessage(x + ", " + y + ", " + z + ", " + event.getHitBlockFace());
            }

             */
        }
    }

    @EventHandler
    public void onItem(PlayerItemDamageEvent event){
        ItemStack itemStack = event.getItem();
        PersistentDataContainer container = itemStack.getItemMeta().getPersistentDataContainer();
        if ("LBA".equalsIgnoreCase(container.get(namespacedKey, PersistentDataType.STRING))){
            event.setDamage(event.getDamage() + 2);
        }
    }
}
