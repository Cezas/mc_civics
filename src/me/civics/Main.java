package me.civics;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.civics.listeners.PlayerJoinAndQuitListener;
import me.civics.listeners.VehicleEventListener;


public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		//TODO maybe have a thing that registers the listeners for all policies
		getServer().getPluginManager().registerEvents(new PlayerJoinAndQuitListener(), this);
		getServer().getPluginManager().registerEvents(new VehicleEventListener(), this);
		//reload
		//plugin reload
		
	}
	
	@Override
	public void onDisable() {
		//shutdown
		//reload
		//pluginreload
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("reset")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.GREEN + "Resetting stats" + ChatColor.BOLD +"");
				for (AttributeModifier mod: player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getModifiers()) {
					player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(mod);
				}
				return true;
			}
			else {
				sender.sendMessage("TODO global reset of everyones stats");
				return true;
			}
		}
		
		if (label.equalsIgnoreCase("changepolicies")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.GREEN + "Changing policies..." + ChatColor.BOLD +"");
				//make a call to the policymanager which will lookup the corresponding government and policies
				return true;
			}
		}
		
		
		if (label.equalsIgnoreCase("mypolicies")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.GREEN + "My unlocked policies are " + ChatColor.BOLD +"");
				//make a call to the policymanager which will lookup the corresponding government and policies
				return true;
			}
		}
		
		return false;
	}
	
}
