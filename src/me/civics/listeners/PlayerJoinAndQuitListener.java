package me.civics.listeners;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.civics.player.PlayerDataManager;
public class PlayerJoinAndQuitListener implements Listener{

	Player player;
	Entity entity;
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	player = event.getPlayer();
        event.setJoinMessage("Welcome, " + player.getName() + "!");
        //TODO get and load their government/civics here
        //and then call an update/confirmchanges afterwards to subscribe to the listeners
        
        //TODO save their playerdata somehwere, for now just generate it on the fly
        PlayerDataManager.addPlayerData(player.getName());
        //for now, give everyone autocracy 
        PlayerDataManager.addGovernmentToPlayer("Autocracy", player.getName());
        //and give them horselords
        PlayerDataManager.addPolicyToPlayer("HorseLords", player.getName());
        
        //force them to slot in autocracy and horselords
       // PlayerDataManager.setGovernmentForPlayer(PlayerDataManager.getPlayerData(player.getName())., player.getName());
        //PlayerDataManager.setPlayerpolicy
        //PlayerDataManager.getPlayerData(player.getName()).currentgovernment.swapPolicy(, );
        //and subscribe by confirming changes
        System.out.println("current govt is "+PlayerDataManager.getPlayerData(player.getName()).currentgovernment);
        PlayerDataManager.getPlayerData(player.getName()).currentgovernment.confirmChanges();
        
        
        
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
    	player = event.getPlayer();
        event.setQuitMessage("Goodbye " + player.getName() + "!");
        //TODO from a list of modified attributes that the player has a list of, remove modifiers from each of those attributes
        //will need to look up player name and call removeEffect on all of their policies 
        
        //TODO: failsafe to remove all effects incase any of the other functions dont resolve, will probably remove later
        //for (AttributeModifier mod: player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getModifiers()) {
		//	player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(mod);
		//}
    }
    
   
}
