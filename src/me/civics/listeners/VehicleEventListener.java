package me.civics.listeners;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class VehicleEventListener implements Listener{

	Player player;
	Entity entity;
	String name = "VehicleEvent";
	
    
    @EventHandler
    public void  VehicleEnterEvent(VehicleEnterEvent event)
    {
    	entity = event.getVehicle();
    	player = (Player) event.getEntered();
    	if (event.getEntered().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.HORSE)  
    			|| entity.getType().equals(EntityType.ZOMBIE_HORSE) || entity.getType().equals(EntityType.PIG))) {
    		//Bukkit.broadcastMessage(player.getName()+" mounted a " + event.getVehicle().getName());
    		
    		//TODO maybe make an interface for this part?
    		//upon event, check if the player is within the subscriber list
    		//TODO make the sublist as a seperate class that will be populated by the user's government confirmchanges
    		
    		//for that valid player, grab their government from the playerdatamanager
    		//then loop thru each policy in their government and attempt to applyEffect on each valid card needing this listener using some internal func?
    		
    		
    		
    	}
    	//TODO: for some reason, this event fires twice?
    	if (event.getEntered().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.BOAT))) {
    		Bukkit.broadcastMessage(player.getName()+" embarked on a " + event.getVehicle().getName());
    	}
    }
    
    @EventHandler
    public void  VehicleExitEvent(VehicleExitEvent event)
    {
    	entity = event.getVehicle();
    	player = (Player) event.getExited();
    	if (event.getExited().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.HORSE)  
    			|| entity.getType().equals(EntityType.ZOMBIE_HORSE) || entity.getType().equals(EntityType.PIG))) {
    		Bukkit.broadcastMessage(player.getName()+" hopped off a " + event.getVehicle().getName());
    		//upon event, check if the player is within the subscriber list (provided by the policy confirm handler) use map for this?
    	    //for that valid player, loop thru each policy in their government and attempt to removeEffect on each valid card needing this listener
    		
    	}
    	if (event.getExited().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.BOAT))) {
    		Bukkit.broadcastMessage(player.getName()+" disembarked from a " + event.getVehicle().getName());
    	}
    }
}
