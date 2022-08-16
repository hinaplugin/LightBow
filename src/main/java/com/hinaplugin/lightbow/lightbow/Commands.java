package com.hinaplugin.lightbow.lightbow;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class Commands extends Insights implements CommandExecutor {
    public Commands(LightBow plugin) {
        super(plugin);
    }

    private final NamespacedKey namespacedKey = new NamespacedKey(LightBow.getPlugin(), "LB");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ItemStack itemStack = new ItemStack(Material.BOW, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Damageable damageable = (Damageable) itemMeta;
        //damageable.setDamage(256);
        PersistentDataContainer container = damageable.getPersistentDataContainer();
        container.set(namespacedKey, PersistentDataType.STRING, "LBA");
        damageable.setDisplayName("明かりを灯せ・・・LightningArrow！");
        damageable.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        damageable.addEnchant(Enchantment.MENDING, 1, true);

        itemStack.setItemMeta(damageable);
        Player player = (Player) sender;
        Inventory inventory = player.getInventory();
        inventory.addItem(itemStack);
        return false;
    }
}
