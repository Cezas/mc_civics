package me.civics.player;

import java.util.HashMap;
import java.util.Map;

import me.civics.governments.GovernmentCatalog;
import me.civics.policies.PolicyCatalog;

public class PlayerDataManager {

	//static PlayerDataMap databank = PlayerDataMap.getInstance();
	public static Map<String,PlayerData> databank = new HashMap<String,PlayerData>(); 
	
	public static void addPlayerData(String playername) {
		databank.put(playername, new PlayerData(playername));
	}
	
	public static PlayerData getPlayerData(String playername) {
		return databank.get(playername);
	}
	
	public static void addGovernmentToPlayer(String govt, String playername) {
		 databank.get(playername).unlockedgovernments.add(GovernmentCatalog.governments.get(govt));
	}
	
	public static void addPolicyToPlayer(String card, String playername) {
		databank.get(playername).unlockedpolicies.add(PolicyCatalog.policies.get(card));
	}
	
	public static void setGovernmentForPlayer(String govt, String playername) {
		databank.get(playername).currentgovernment = GovernmentCatalog.governments.get(govt); //TODO make sure this a copy and not a reference
	}
	

	
	
	public static void removePolicyFromPlayer() {
		;
	}
}
