package me.civics.policies;

//future maybe todo, make a factory for this and make an (ingame?) API for it
//TODO maybe encapsulate the member variables? 
public abstract class PolicyCard {
	enum policytype {
		MILITARY,
		ECONOMIC,
		DIPLOMATIC,
		WILDCARD,
		DARK
	}
	public policytype type;
	String name;
	String description;
	//TODO add list of registered listeners to activate the applyEffect
	//TODO add an unlock switch as a variable
	
	//apply the effect described by the description
	public abstract void applyEffect();
	
}
