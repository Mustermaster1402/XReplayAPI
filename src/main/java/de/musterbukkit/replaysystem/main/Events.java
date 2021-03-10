package de.musterbukkit.replaysystem.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.musterbukkit.replaysystem.main.Events;
import de.musterbukkit.replaysystem.main.Main;
import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {

	public static String XReplay = ChatColor.GOLD.toString() + ChatColor.BOLD + "X" + ChatColor.WHITE + " Replay"
			+ ChatColor.WHITE;

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player p = event.getPlayer();
		if (p.hasPermission("replay.debug") || p.isOp()) {
			new BukkitRunnable() {


				public void run() {
					p.sendMessage(Main.Prefix + "This is only for developers who don't own " + XReplay
							+ " but want to integrate it into their plugin.");
				}
			}.runTaskLater(Main.getinstance(), 40L);
			new BukkitRunnable() {


				public void run() {
					p.sendMessage(Main.Prefix + "It is only the public API.");
				}
			}.runTaskLater(Main.getinstance(), 50L);
			new BukkitRunnable() {


				public void run() {
					p.sendMessage(Main.Prefix + "You " + ChatColor.UNDERLINE + "can't" + ChatColor.WHITE
							+ " replay anything with this plugin!");
				}
			}.runTaskLater(Main.getinstance(), 60L);
			new BukkitRunnable() {


				public void run() {
					p.sendMessage(
							Main.Prefix + "If you are looking for a replay system, use " + XReplay + ChatColor.WHITE
									+ " https://www.spigotmc.org/resources/x-replay-advanced-replay-plugin.49554/");
				}
			}.runTaskLater(Main.getinstance(), 80L);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		if (Main.zPlayerDebug.contains(p.getUniqueId().toString())) {
			Main.zPlayerDebug.remove(p.getUniqueId().toString());
		}
	}


}
