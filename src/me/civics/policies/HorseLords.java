package me.civics.policies;

public class HorseLords extends PolicyCard{
	
	public HorseLords() {
		type = policytype.MILITARY;
		name = "HorseLords";
		description = "test";	
	}
	
	public void applyEffect() {
		System.out.println("Message");
	}
	
}
