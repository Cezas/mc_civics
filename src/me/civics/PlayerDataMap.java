package me.civics;

import java.util.HashMap;
import java.util.Map;

import me.civics.player.PlayerData;

//UNUSED FOR NOW
//Java program to create Thread Safe 
//Singleton class 
public class PlayerDataMap
{ 
//private instance, so that it can be 
//accessed by only by getInstance() method 
private static PlayerDataMap instance; 

Map<String,PlayerData> playerdataMap;
private PlayerDataMap() 
{ 
	//TODO replace with a DB
	playerdataMap = new HashMap<String,PlayerData>(); 
	// private constructor 
} 

//synchronized method to control simultaneous access 
synchronized public static PlayerDataMap getInstance() 
{ 
	if (instance == null) 
	{ 
	// if instance is null, initialize 
	instance = new PlayerDataMap(); 
	} 
	return instance; 
} 
} 

