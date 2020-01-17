package io.github.extrachatformat;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JavaPlugin implements Listener {

    public static YamlConfiguration fileConfig;
    private static File file;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        config = this.getConfig();

        try {
            initiateFiles();
        } catch (IOException e) {
            System.out.println("AN ERROR HAS OCCURRED WHILE INITIALIZING FILES");
            e.printStackTrace();
        }
        System.out.println("PLUGIN SUCCESSFULLY ENABLED");
        Bukkit.getPluginManager().registerEvents(new ColorListener(), this);
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

    public void openInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Please select a color!");
        for(int i = 0; i < Colors.colorList().size(); i++) {
            inv.addItem(Colors.colorList().get(i));
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
        if(fileConfig.get(player.getUniqueId().toString()) != null && !fileConfig.getString(player.getUniqueId().toString()).equalsIgnoreCase("RAINBOW")) {
            color = ChatColor.valueOf(fileConfig.getString(player.getUniqueId().toString()));
        } else {
            color = ChatColor.WHITE;
        }

        String name = player.getDisplayName();
        if(fileConfig.get(player.getUniqueId().toString()) != null && fileConfig.getString(player.getUniqueId().toString()).equalsIgnoreCase("RAINBOW")) {
            List<String> playerLetterList = new ArrayList<>();
            for(int i = 0; i < player.getName().length(); i++) {
                char x = player.getName().charAt(i);
                String y = Character.toString(x);
                playerLetterList.add(y);
            }
            for(int i = 0; i < playerLetterList.size(); i++) {
                if(i == 0 || i == 7 || i == 14) {
                    playerLetterList.set(i, ChatColor.RED + playerLetterList.get(i));
                } else if (i == 1 || i == 8 || i == 15) {
                    playerLetterList.set(i, ChatColor.GOLD + playerLetterList.get(i));
                } else if (i == 2 || i == 9 || i == 16) {
                    playerLetterList.set(i, ChatColor.YELLOW + playerLetterList.get(i));
                } else if (i == 3 || i == 10) {
                    playerLetterList.set(i, ChatColor.GREEN + playerLetterList.get(i));
                } else if (i == 4 || i == 11) {
                    playerLetterList.set(i, ChatColor.AQUA + playerLetterList.get(i));
                } else if (i == 5 || i == 12) {
                    playerLetterList.set(i, ChatColor.BLUE + playerLetterList.get(i));
                } else if (i == 6 || i == 13) {
                    playerLetterList.set(i, ChatColor.DARK_PURPLE + playerLetterList.get(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < playerLetterList.size(); i++) {
                sb.append(playerLetterList.get(i));
            }
            name = sb.toString();
        }
        message = ChatColor.translateAlternateColorCodes('&', message);
        String format = config.getString("chat-format");
        format = ChatColor.translateAlternateColorCodes('&', format);
        format = format.replace("{player}", name);
        format = format.replace("{message}", message);


        e.setFormat(color + format);

    }

    public static void saveFiles() {
        try {
            fileConfig.save(Main.file);
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
