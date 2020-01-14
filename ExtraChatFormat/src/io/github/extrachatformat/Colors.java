package io.github.extrachatformat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Colors {

    public static List<ItemStack> colorList() {
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

        ItemStack dark_red = new ItemStack(Material.BROWN_STAINED_GLASS_PANE, 1);
        ItemMeta dark_redMeta = dark_red.getItemMeta();
        dark_redMeta.setDisplayName(ChatColor.DARK_RED + "Dark Red");
        dark_red.setItemMeta(dark_redMeta);
        invItems.add(dark_red);

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

        ItemStack light_blue = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta light_blueMeta = light_blue.getItemMeta();
        light_blueMeta.setDisplayName(ChatColor.AQUA + "Light Blue");
        light_blue.setItemMeta(light_blueMeta);
        invItems.add(light_blue);

        ItemStack light_gray = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta light_grayMeta = light_blue.getItemMeta();
        light_grayMeta.setDisplayName(ChatColor.GRAY + "Gray");
        light_gray.setItemMeta(light_grayMeta);
        invItems.add(light_gray);

        ItemStack dark_gray = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta dark_grayMeta = dark_gray.getItemMeta();
        dark_grayMeta.setDisplayName(ChatColor.DARK_GRAY + "Dark Gray");
        dark_gray.setItemMeta(dark_grayMeta);
        invItems.add(dark_gray);

        ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.BLACK + "Black");
        black.setItemMeta(blackMeta);
        invItems.add(black);

        ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.WHITE + "White");
        white.setItemMeta(whiteMeta);
        invItems.add(white);

        ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta sunflowerMeta = sunflower.getItemMeta();
        sunflowerMeta.setDisplayName(ChatColor.RED + "R" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "i" + ChatColor.GREEN + "n" + ChatColor.AQUA + "b" + ChatColor.BLUE + "o" + ChatColor.DARK_PURPLE + "w");
        sunflower.setItemMeta(sunflowerMeta);
        invItems.add(sunflower);
        return invItems;
    }

}
