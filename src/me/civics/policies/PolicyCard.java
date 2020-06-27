package me.civics.policies;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;

//future maybe todo, make a factory for this and make an (ingame?) API for it
//TODO maybe encapsulate the member variables? 
//TODO maybe make separate packages for policy types?
public abstract class PolicyCard {
	public policytype type;
	String name;
	String description;
	List<String> registeredListeners = new ArrayList<String>();
	
	
	public policytype getType() {
		return type;
	}
	
	
	public List<String> getListeners(){
		return registeredListeners;
	}
	/*
	public void addListener(String listener) {
		registeredListeners.add(listener);
	}
	
	public void removeListener(String listener) {
		registeredListeners.remove(listener);
	}
	*/
	//TODO add list of registered listeners to activate the applyEffect
	//TODO add an unlock switch as a variable
	
	//apply the effect described by the description
	public abstract void applyEffect(Entity entity);
	
	public abstract void removeEffect(Entity entity);
	
}
