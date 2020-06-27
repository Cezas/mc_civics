package me.civics.policies;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class HorseLords extends PolicyCard{
	AttributeModifier horselord = new AttributeModifier("HorseLords Bonus", 1, Operation.ADD_NUMBER);
	
	public HorseLords() {
		type = policytype.MILITARY;
		name = "HorseLords";
		description = "test";
		registeredListeners.add("VehicleEvent");
	}

	public void applyEffect(Entity entity){
		((Player)entity).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).addModifier(horselord);
	}
	
	public void removeEffect(Entity entity) {
		((Player)entity).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(horselord);
	}
	
}
