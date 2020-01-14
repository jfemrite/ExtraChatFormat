package io.github.extrachatformat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ColorListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Inventory inv = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Please select a color!") && item != null) {

            switch(item.getType()) {
                case GREEN_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_GREEN");
                    Main.saveFiles();
                    break;

                case RED_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "RED");
                    Main.saveFiles();
                    break;

                case BROWN_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_RED");
                    Main.saveFiles();
                    break;

                case ORANGE_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "GOLD");
                    Main.saveFiles();
                    break;

                case LIME_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "GREEN");
                    Main.saveFiles();
                    break;

                case YELLOW_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "YELLOW");
                    Main.saveFiles();
                    break;

                case BLUE_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_BLUE");
                    Main.saveFiles();
                    break;

                case CYAN_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_AQUA");
                    Main.saveFiles();
                    break;

                case PURPLE_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_PURPLE");
                    Main.saveFiles();
                    break;

                case MAGENTA_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "LIGHT_PURPLE");
                    Main.saveFiles();
                    break;

                case LIGHT_BLUE_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "AQUA");
                    Main.saveFiles();
                    break;

                case LIGHT_GRAY_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "GRAY");
                    Main.saveFiles();
                    break;

                case GRAY_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "DARK_GRAY");
                    Main.saveFiles();
                    break;

                case BLACK_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "BLACK");
                    Main.saveFiles();
                    break;

                case WHITE_STAINED_GLASS_PANE:
                    Main.fileConfig.set(player.getUniqueId().toString(), "WHITE");
                    Main.saveFiles();
                    break;

                case SUNFLOWER:
                    Main.fileConfig.set(player.getUniqueId().toString(), "RAINBOW");
                    Main.saveFiles();
                    break;
            }

            player.closeInventory();
            e.setCancelled(true);
        }


    }


}
