package de.musterbukkit.replaysystem.main;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ReplayAPI {

	public static Random r = new Random();

	public static void setReplayName(String Servername) {
		Main.ReplayName = Servername;
		Main.sendDebugMessages("setRepalyName(" + Servername + ")");
	}

	public static String getReplayName() {
		Main.sendDebugMessages("setRepalyName(" + ") - " + Main.ReplayName);
		return Main.ReplayName;
	}

	public static void saveReplay() {
		Main.sendDebugMessages("saveReplay(" + ")");
	}

	public static void addMessage(String Message) {
		Main.sendDebugMessages("addMessage(" + Message + ")");
	}

	/**
	 * Method getReplayID() return the ReplayID of the current Replay
	 * 
	 * @return Returns the Replay ID.
	 */
	public static String getReplayID() {
		String rp = "123" + r.nextInt(9) + r.nextInt(9);
		Main.sendDebugMessages("getReplayID(" + ") - " + rp);
		return rp;
	}

	public static Integer getTime() {
		Main.sendDebugMessages("getTime(" + ")");
		return r.nextInt(10000);
	}

	public static void setMapName(String name) {
		Main.MapName = name;
		Main.sendDebugMessages("setMapName(" + name + ")");
	}

	public static boolean checkIfReplayEnds(Player p) {
		Boolean b = r.nextBoolean();
		Main.sendDebugMessages("checkIfReplayEnds(" + p.getName() + ") - " + b);
		return b;
	}

	public static boolean deleteReplayID(String ReplayID) {
		Boolean b = r.nextBoolean();
		Main.sendDebugMessages("deleteReplayID(" + ReplayID + ") - " + b);
		return b;
	}

	public static boolean playReplayID(String ReplayID, Player p) {
		Boolean b = r.nextBoolean();
		Main.sendDebugMessages("playReplayID(" + ReplayID + ";" + p.getName() + ") - " + b);
		return b;
	}

	public static String createSnapshot(Integer seconds) {
		String rp = "123" + r.nextInt(9) + r.nextInt(9);
		Main.sendDebugMessages("createSnapshot(" + seconds + ") - " + rp);
		return rp;
	}

	public static String createSnapshotPlayer(Integer seconds, Player target) {
		String rp = "123" + r.nextInt(9) + r.nextInt(9);
		Main.sendDebugMessages("createSnapshotPlayer(" + seconds + ";" + target.getName() + ") - " + rp);
		return rp;
	}

	public static String teleportToNPC(Player p, String toUUID) {
		String rp = r.nextBoolean() + "";
		Main.sendDebugMessages("teleportToNPC(" + p.getName() + ";" + toUUID + ") - " + rp);
		return rp;
	}

	public static String getLastSnapshot() {
		String rp = "123" + r.nextInt(9) + r.nextInt(9);
		Main.sendDebugMessages("getLastSnapshot(" + ") - " + rp);
		return rp;
	}

	public static boolean checkIfPlayerIsPlayingBackAReplay(Player p) {
		Boolean b = r.nextBoolean();
		Main.sendDebugMessages("checkIfPlayerIsPlayingBackAReplay(" + p.getName() + ") - " + b);
		return b;
	}
	
	public static void setSpectatorLocation(Location loc){
		Main.sendDebugMessages("setSpectatorLocation(" + loc.getX() + ")");
	}

	public static void setSaveReplay(boolean saveReplay){
		Main.sendDebugMessages("setSaveReplay(" + saveReplay + ")");
	}

	public static void anonymize(Player viewer, String suspect){
		Main.sendDebugMessages("anonymize(" + viewer.getUniqueId().toString() + ")");
	}
}
