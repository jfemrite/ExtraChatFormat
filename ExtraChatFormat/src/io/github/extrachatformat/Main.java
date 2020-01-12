package io.github.extrachatformat;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin implements Listener {

    private YamlConfiguration fileConfig;
    private File file;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        try {
            initiateFiles();
        } catch (IOException e) {
            System.out.println("AN ERROR HAS OCCURRED WHILE INITIALIZING FILES");
            e.printStackTrace();
        }
        System.out.println("PLUGIN SUCCESSFULLY ENABLED");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("color")) {
                openInventory(player);
            }
        }

        return false;
    }

    @EventHandler
    public void inventoryInteract(InventoryClickEvent e) {

        if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Please select a color!")) {
            Player player = (Player) e.getWhoClicked();
            ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem.getData().getData() == (byte) 13) {
                fileConfig.set(player.getUniqueId().toString(), "DARK_GREEN");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 14) {
                fileConfig.set(player.getUniqueId().toString(), "RED");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 1) {
                fileConfig.set(player.getUniqueId().toString(), "GOLD");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 5) {
                fileConfig.set(player.getUniqueId().toString(), "GREEN");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 4) {
                fileConfig.set(player.getUniqueId().toString(), "YELLOW");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 11) {
                fileConfig.set(player.getUniqueId().toString(), "DARK_BLUE");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 9) {
                fileConfig.set(player.getUniqueId().toString(), "DARK_AQUA");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 10) {
                fileConfig.set(player.getUniqueId().toString(), "DARK_PURPLE");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 2) {
                fileConfig.set(player.getUniqueId().toString(), "LIGHT_PURPLE");
                saveFiles();
            } else if(clickedItem.getData().getData() == (byte) 0) {
                fileConfig.set(player.getUniqueId().toString(), "WHITE");
                saveFiles();
            }
            e.setCancelled(true);
        }

    }

    public void openInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Please select a color!");
        List<ItemStack> invItems = new ArrayList<>();
        ItemStack dark_green = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        ItemMeta dark_greenMeta = dark_green.getItemMeta();
        dark_greenMeta.setDisplayName(ChatColor.DARK_GREEN + "Dark Green");
        dark_green.setItemMeta(dark_greenMeta);
        invItems.add(dark_green);

        ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.RED + "Red");
        red.setItemMeta(redMeta);
        invItems.add(red);

        ItemStack gold_orange = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1);
        ItemMeta gold_orangeMeta = gold_orange.getItemMeta();
        gold_orangeMeta.setDisplayName(ChatColor.GOLD + "Gold/Orange");
        gold_orange.setItemMeta(gold_orangeMeta);
        invItems.add(gold_orange);

        ItemStack green = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "Green");
        green.setItemMeta(greenMeta);
        invItems.add(green);

        ItemStack yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1);
        ItemMeta yellowMeta = yellow.getItemMeta();
        yellowMeta.setDisplayName(ChatColor.YELLOW + "Yellow");
        yellow.setItemMeta(yellowMeta);
        invItems.add(yellow);

        ItemStack dark_blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta dark_blueMeta = dark_blue.getItemMeta();
        dark_blueMeta.setDisplayName(ChatColor.DARK_BLUE + "Dark Blue");
        dark_blue.setItemMeta(dark_blueMeta);
        invItems.add(dark_blue);

        ItemStack cyan = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
        ItemMeta cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.DARK_AQUA + "Cyan");
        cyan.setItemMeta(cyanMeta);
        invItems.add(cyan);

        ItemStack dark_purple = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemMeta dark_purpleMeta = dark_purple.getItemMeta();
        dark_purpleMeta.setDisplayName(ChatColor.DARK_PURPLE + "Dark Purple");
        dark_purple.setItemMeta(dark_purpleMeta);
        invItems.add(dark_purple);

        ItemStack purple = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1);
        ItemMeta purpleMeta = purple.getItemMeta();
        purpleMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Light Purple");
        purple.setItemMeta(purpleMeta);
        invItems.add(purple);

        ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.WHITE + "White");
        white.setItemMeta(whiteMeta);
        invItems.add(white);

        for(int i = 0; i < invItems.size(); i++) {
            inv.addItem(invItems.get(i));
        }
        player.openInventory(inv);

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player player = e.getPlayer();
        if(message.contains("**")) {
            String bold = "**";
            int count = StringUtils.countMatches(message, bold);
            for(int i = 0; i < count; i++) {
                if(i % 2 != 0) {
                    message = message.replaceFirst("\\*\\*", "&r");
                } else {
                    message = message.replaceFirst("\\*\\*", "&l");
                }
            }
        }
        if(message.contains("*")) {
            String italics = "*";
            int count = StringUtils.countMatches(message, italics);
            for(int i = 0; i < count; i++) {
                if(i % 2 != 0) {
                    message = message.replaceFirst("\\*", "&r");
                } else {
                    message = message.replaceFirst("\\*", "&o");
                }
            }
        }
        if(message.contains("_")) {
            String symbol = "_";
            int count = StringUtils.countMatches(message, symbol);
            for(int i = 0; i < count; i++) {
                if(i % 2 != 0) {
                    message = message.replaceFirst("_", "&r");
                } else {
                    message = message.replaceFirst("_", "&n");
                }
            }
        }
        if(message.contains("~")) {
            String symbol = "~";
            int count = StringUtils.countMatches(message, symbol);
            for(int i = 0; i < count; i++) {
                if(i % 2 != 0) {
                    message = message.replaceFirst("~", "&r");
                } else {
                    message = message.replaceFirst("~", "&m");
                }
            }
        }
        ChatColor color;
        if(!fileConfig.getString(player.getUniqueId().toString()).isEmpty()) {
            color = ChatColor.valueOf(fileConfig.getString(player.getUniqueId().toString()));
        } else {
            color = ChatColor.WHITE;
        }
        e.setFormat(color + player.getDisplayName() + ChatColor.RESET + ": " + ChatColor.translateAlternateColorCodes('&', message));

    }

    private void saveFiles() {
        try {
            fileConfig.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initiateFiles() throws IOException {
        file = new File(Bukkit.getPluginManager().getPlugin("ExtraChatFormat").getDataFolder(), "colors.yml");
        if(!Bukkit.getPluginManager().getPlugin("ExtraChatFormat").getDataFolder().exists()) {
            Bukkit.getPluginManager().getPlugin("ExtraChatFormat").getDataFolder().mkdir();
        }
        if(!file.exists()) {
            file.createNewFile();
        }
        fileConfig = YamlConfiguration.loadConfiguration(file);
    }
}
