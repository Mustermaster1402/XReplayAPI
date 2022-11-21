package de.musterbukkit.replaysystem.main;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReplayEndEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private Player player;
	private String replayID;
	
	public ReplayEndEvent(Player player , String replayID){
		this.player = player;
		this.replayID = replayID;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public String getReplayID(){
		return replayID;
	}
	
	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}

}