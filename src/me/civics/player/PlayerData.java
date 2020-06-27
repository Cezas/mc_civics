package me.civics.player;

import java.util.ArrayList;
import java.util.List;

import me.civics.governments.Government;
import me.civics.policies.PolicyCard;

//TODO eventually replace with a DB
//for now, each player will have an instance of their playerdata that will be stored in some globalish map with policymanager
public class PlayerData {
	public String player;
	public List<PolicyCard> unlockedpolicies;
	public List<Government> unlockedgovernments;
	public Government currentgovernment;
	public List<PolicyCard> slottedpolicies;
	
	public PlayerData(String playername) {
		player = playername;
		unlockedpolicies = new ArrayList<PolicyCard>();
		unlockedgovernments = new ArrayList<Government>();
	}
}
