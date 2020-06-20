package me.civics;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class VehicleEventListener implements Listener{

	Player player;
	Entity entity;
	
	AttributeModifier horselord = new AttributeModifier("HorseLords Bonus", 1, Operation.ADD_NUMBER); //TODO move this to the card
	//TODO move player stuff to another listener
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	player = event.getPlayer();
        event.setJoinMessage("Welcome, " + player.getName() + "!");
        //just incase some bugs occur, maybe have a reset here
        //System.out.println("prejoin"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
        //player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
        //System.out.println("post join"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
    }
  //TODO move this stuff to another listener
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
    	player = event.getPlayer();
        event.setQuitMessage("Goodbye " + player.getName() + "!");
        for (AttributeModifier mod: player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getModifiers()) {
			player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(mod);
		}
    }
    
    @EventHandler
    public void  VehicleEnterEvent(VehicleEnterEvent event)
    {
    	entity = event.getVehicle();
    	player = (Player) event.getEntered();
    	if (event.getEntered().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.HORSE)  
    			|| entity.getType().equals(EntityType.ZOMBIE_HORSE) || entity.getType().equals(EntityType.PIG))) {
    		//Bukkit.broadcastMessage(player.getName()+" mounted a " + event.getVehicle().getName());
    		//upon event, check if the player is within the subscriber list (provided by the policy confirm handler) use map for this?
    		//for that valid player, loop thru each policy in their government and attempt to applyEffect on each valid card needing this listener
    		System.out.println("prebuff"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
    		player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).addModifier(horselord);
    		System.out.println("postbuff"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
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
    		
    		System.out.println("preremove"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
    		player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(horselord);
    		System.out.println("postremove"+player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue());
    	}
    	if (event.getExited().getType().equals(EntityType.PLAYER) && (entity.getType().equals(EntityType.BOAT))) {
    		Bukkit.broadcastMessage(player.getName()+" disembarked from a " + event.getVehicle().getName());
    	}
    }
}
