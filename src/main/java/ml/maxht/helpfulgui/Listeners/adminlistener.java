package ml.maxht.helpfulgui.Listeners;

import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class adminlistener implements Listener {

    @EventHandler
    public void onMenuClick (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "Admin Menu")){


            switch (e.getCurrentItem().getType()) {

                case NETHERITE_AXE:
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(p, 54, ChatColor.RED + "Admin Gui: Ban Player");
                    int i = 0;
                    for(Player player : Bukkit.getOnlinePlayers())
                    {
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta headmeta = (SkullMeta) head.getItemMeta();
                        headmeta.setOwnerProfile(player.getPlayerProfile());
                        headmeta.setDisplayName(player.getDisplayName());
                        headmeta.setLore(Collections.singletonList("Ban this player"));
                        head.setItemMeta(headmeta);
                        inv.setItem(inv.firstEmpty(), head);
                        i++;
                    }
                    ItemStack back = new ItemStack(Material.BARRIER, 1);
                    ItemMeta backmeta = back.getItemMeta();
                    backmeta.setDisplayName(ChatColor.RED + "Back");
                    ArrayList backlore = new ArrayList<>();
                    backlore.add("Go back to");
                    backlore.add("Main admin screen");
                    backmeta.setLore(backlore);
                    back.setItemMeta(backmeta);
                    inv.setItem(44, back);
                    p.openInventory(inv);
                    }
                    e.setCancelled(true);
                }

            }

}


