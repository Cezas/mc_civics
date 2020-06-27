package me.civics.policies;

import org.bukkit.entity.Entity;

public class EmptyPolicy extends PolicyCard{
	public EmptyPolicy(policytype _type) {
		type = _type;
		name = "Empty slot";
		description = "PLACE YOUR POLICY HERE";
	}
	
	public void applyEffect(Entity entity) {
		;
	};
	
	public void removeEffect(Entity entity) {
		
	};
}
