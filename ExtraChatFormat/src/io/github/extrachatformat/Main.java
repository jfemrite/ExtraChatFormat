package io.github.extrachatformat;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

public class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(this, this);

        System.out.println("PLUGIN SUCCESSFULLY ENABLED");
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



        e.setFormat(ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET + ": " + ChatColor.translateAlternateColorCodes('&', message));


    }




}
