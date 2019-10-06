package yoneyone.yone.yo.yone_gui_test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Yone_GUI_test extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents((Listener) new Inventory_test_event(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }
        Player player = (Player)sender;
        if (label.equals("open")){
            test_GUI_main(player);
        }
        return true;
    }
    public void test_GUI_main(Player player){
        String title = ChatColor.translateAlternateColorCodes('&',"&ltestGUI");
        Inventory inv = Bukkit.createInventory(null, 9,title);
        ItemStack food = new ItemStack(Material.APPLE);

        ItemMeta meta_date = food.getItemMeta();
        String message = ChatColor.translateAlternateColorCodes('&',"&cサブへ");
        meta_date.setDisplayName(message);
        food.setItemMeta(meta_date);

        inv.setItem(4, food);
        player.openInventory(inv);
    }

}
