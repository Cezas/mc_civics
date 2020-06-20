package me.civics;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		//TODO have a thing that registers the listeners for all policies
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
				sender.sendMessage("WASSSUPPPP");
				return true;
			}
		}
		return false;
	}
	
}
