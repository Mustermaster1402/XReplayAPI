package de.musterbukkit.replaysystem.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.musterbukkit.replaysystem.main.Events;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
    private static Main instance;

    public static ArrayList<String> zPlayerDebug = new ArrayList<String>();

    public static String Prefix = ChatColor.GOLD.toString() + ChatColor.BOLD + "X" + ChatColor.WHITE + " Replay"
            + ChatColor.BLUE + " API" + ChatColor.GRAY + " » " + ChatColor.WHITE;

    public static String ReplayName = "Server-1";
    public static String MapName = "world";

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(
                Main.Prefix + "Enabling " + "Version: " + Main.getinstance().getDescription().getVersion() + " by Mustermaster1402");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                Main.Prefix + "Disabling " + "Version: " + Main.getinstance().getDescription().getVersion() + " by Mustermaster1402");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("rpdebug")) {
            Boolean permisson = false;
            String SenderName = "";
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("replay.debug") || p.isOp()) {
                    permisson = true;
                    SenderName = p.getUniqueId().toString();
                }
            } else {
                SenderName = "CONSOLE";
                System.out.println(ReplayAPI.getReplayID());
                System.out.println(ReplayAPI.getLastSnapshot());
                permisson = true;
            }

            if (permisson) {
                if (zPlayerDebug.contains(SenderName)) {
                    sender.sendMessage(Prefix + "You no longer recive Debug Messages.");
                    zPlayerDebug.remove(SenderName);
                } else {
                    zPlayerDebug.add(SenderName);
                    sender.sendMessage(Prefix + "You now recive Debug Messages.");
                }
            } else {
                sender.sendMessage(Prefix + "No Permissons.");
            }
        }

        return false;
    }

    public static Plugin getinstance() {

        return instance;
    }

    public static void sendDebugMessages(String pMessage){
        for(Player all : Bukkit.getOnlinePlayers()){
            if(zPlayerDebug.contains(all.getUniqueId().toString())){
                all.sendMessage(Prefix + ChatColor.GRAY + "[Debug] " + ChatColor.WHITE + pMessage);
            }
        }
        if(zPlayerDebug.contains("CONSOLE")){
            Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.GRAY + "[Debug] " + ChatColor.WHITE + pMessage);
        }
    }

}
