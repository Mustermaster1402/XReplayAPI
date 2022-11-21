package de.musterbukkit.replaysystem.main;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReplaySaveEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private String filepath;
	private String replayID;
	private String qualifiedPath;

	public ReplaySaveEvent(String filepath, String replayID, String qualifiedPath) {
		this.filepath = filepath;
		this.replayID = replayID;
		this.qualifiedPath = qualifiedPath;
	}

	public String getFilepath() {
		return filepath;
	}

	public String getReplayID() {
		return replayID;
	}

	public String getQualifiedPath() {
		return qualifiedPath;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

}