package yoneyone.yone.yo.yone_gui_test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Inventory_test_event implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
        String title = e.getView().getTitle();
        Player player = (Player)e.getView().getPlayer();
        if (title.equals(ChatColor.translateAlternateColorCodes('&',"&ltestsubGUI"))){
            e.setCancelled(true);
            if (e.getSlotType() == InventoryType.SlotType.CONTAINER){
                switch (e.getSlot()){
                    case 0:
                        void_GUI(player);
                        break;
                    case 1:
                        dice_GUI(player);
                        break;
                }
            }
        }else if (title.equals(ChatColor.translateAlternateColorCodes('&',"&ltestGUI"))){
            e.setCancelled(true);
            if (e.getSlotType() == InventoryType.SlotType.CONTAINER){
                switch (e.getSlot()){
                    case 4:
                        test_GUI_sub(player);
                        break;
                }
            }
        }else if (title.equals(ChatColor.translateAlternateColorCodes('&',"&lサイコロ一覧"))){
            e.setCancelled(true);
            if (e.getSlotType() == InventoryType.SlotType.CONTAINER){
                switch (e.getSlot()){
                    case 0:
                        dice_result(player, 2);
                        break;
                    case 1:
                        dice_result(player, 3);
                        break;
                    case 2:
                        dice_result(player, 6);
                        break;
                    case 3:
                        dice_result(player, 10);
                        break;
                    case 4:
                        dice_result(player, 20);
                        break;
                    case 5:
                        dice_result(player, 100);
                        break;
                    case 8:
                        e.getView().close();
                        break;
                }
            }
        }else if(title.equals(ChatColor.translateAlternateColorCodes('&',"&lサイコロ結果"))){
            e.setCancelled(true);
            switch (e.getSlot()){
                case 8:
                    dice_GUI(player);
            }
        }
    }
    public void test_GUI_sub(Player player){
        String title = ChatColor.translateAlternateColorCodes('&',"&ltestsubGUI");
        Inventory inv = Bukkit.createInventory(null, 9,title);
        ItemStack bucket = new ItemStack(Material.BUCKET);
        ItemStack dice = new ItemStack(Material.APPLE);
        //0
        ItemMeta meta_date0 = bucket.getItemMeta();
        String message0 = ChatColor.translateAlternateColorCodes('&',"&lゴミ箱");

        List<String> lore0_list = new ArrayList<String>();
        String lore0_1 = ChatColor.translateAlternateColorCodes('&',"&5ゴミはゴミ箱へ！");
        String lore0_2 = ChatColor.translateAlternateColorCodes('&',"&5不法投棄は許さないぞ！");
        lore0_list.add(lore0_1);
        lore0_list.add(lore0_2);

        meta_date0.setLore(lore0_list);
        meta_date0.setDisplayName(message0);
        bucket.setItemMeta(meta_date0);
        //1
        ItemMeta meta_date1 = dice.getItemMeta();
        String message1 = ChatColor.translateAlternateColorCodes('&',"&lサイコロ一覧");

        List<String> lore1_list = new ArrayList<String>();
        String lore1_1 = ChatColor.translateAlternateColorCodes('&', "&4サイコロを振ります");
        String lore1_2 = ChatColor.translateAlternateColorCodes('&', "&7周りの人には見えません");
        lore1_list.add(lore1_1);
        lore1_list.add(lore1_2);

        meta_date1.setLore(lore1_list);
        meta_date1.setDisplayName(message1);
        dice.setItemMeta(meta_date1);
        //終了
        inv.setItem(0, bucket);
        inv.setItem(1, dice);
        player.openInventory(inv);
    }
    public void void_GUI(Player player){
        String title = ChatColor.translateAlternateColorCodes('&',"&lゴミ箱 &0中身は消えます");
        Inventory inv = Bukkit.createInventory(null, 54,title);

        player.openInventory(inv);
    }
    public void dice_GUI(Player player){
        String title = ChatColor.translateAlternateColorCodes('&',"&lサイコロ一覧");
        Inventory inv = Bukkit.createInventory(null, 9,title);
        ItemStack dice_2 = new ItemStack(Material.APPLE);
        ItemStack dice_3 = new ItemStack(Material.APPLE);
        ItemStack dice_6 = new ItemStack(Material.APPLE);
        ItemStack dice_10 = new ItemStack(Material.APPLE);
        ItemStack dice_20 = new ItemStack(Material.APPLE);
        ItemStack dice_100 = new ItemStack(Material.APPLE);
        ItemStack stop = new ItemStack(Material.PAPER);

        ItemMeta meta_date_2 = dice_2.getItemMeta();
        ItemMeta meta_date_3 = dice_3.getItemMeta();
        ItemMeta meta_date_6 = dice_6.getItemMeta();
        ItemMeta meta_date_10 = dice_10.getItemMeta();
        ItemMeta meta_date_20 = dice_20.getItemMeta();
        ItemMeta meta_date_100 = dice_100.getItemMeta();
        ItemMeta meta_date_stop = stop.getItemMeta();

        String message_2 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：2");
        String message_3 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：3");
        String message_6 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：6");
        String message_10 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：10");
        String message_20 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：20");
        String message_100 = ChatColor.translateAlternateColorCodes('&',"&lサイコロを振る：100");
        String message_stop = ChatColor.translateAlternateColorCodes('&',"&l終了");

        meta_date_2.setDisplayName(message_2);
        meta_date_3.setDisplayName(message_3);
        meta_date_6.setDisplayName(message_6);
        meta_date_10.setDisplayName(message_10);
        meta_date_20.setDisplayName(message_20);
        meta_date_100.setDisplayName(message_100);
        meta_date_stop.setDisplayName(message_stop);

        dice_2.setItemMeta(meta_date_2);
        dice_3.setItemMeta(meta_date_3);
        dice_6.setItemMeta(meta_date_6);
        dice_10.setItemMeta(meta_date_10);
        dice_20.setItemMeta(meta_date_20);
        dice_100.setItemMeta(meta_date_100);
        stop.setItemMeta(meta_date_stop);

        inv.setItem(0,dice_2);
        inv.setItem(1,dice_3);
        inv.setItem(2,dice_6);
        inv.setItem(3,dice_10);
        inv.setItem(4,dice_20);
        inv.setItem(5,dice_100);
        inv.setItem(8,stop);

        player.openInventory(inv);
    }
    public void dice_result(Player player, int i){
        String title = ChatColor.translateAlternateColorCodes('&',"&lサイコロ結果");
        Inventory inv = Bukkit.createInventory(null, 9,title);
        ItemStack dice_result = new ItemStack(Material.PAPER);
        ItemStack Return = new ItemStack(Material.PAPER);
        ItemMeta meta_result = dice_result.getItemMeta();
        ItemMeta meta_Return = Return.getItemMeta();

        int result_int = new Random().nextInt(i) + 1;
        String message_result = ChatColor.translateAlternateColorCodes('&',"結果："+ result_int);
        meta_result.setDisplayName(message_result);
        dice_result.setItemMeta(meta_result);

        String message_Return = ChatColor.translateAlternateColorCodes('&',"&lサイコロ選択画面に戻る");
        meta_Return.setDisplayName(message_Return);
        Return.setItemMeta(meta_Return);

        inv.setItem(4,dice_result);
        inv.setItem(8,Return);
        player.openInventory(inv);
    }
}
