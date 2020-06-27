package me.civics.governments;

import java.util.ArrayList;
import java.util.List;

import me.civics.listeners.SubscriberCatalog;
import me.civics.policies.EmptyPolicy;
import me.civics.policies.PolicyCard;
import me.civics.policies.policytype;

public abstract class Government {
	//each player should have an instance of a government
	
	//TODO add unlock costs
	String playerowner;
	String name;
	String desc;
	int numOfMilitarySlots;
	int numOfEconomicSlots;
	int numOfDiplomaticSlots;
	int numOfWildcardSlots;
	
	
	//TODO add capabilities to resize the slots without losing the preslotted policies
	//the reason these slots aren't implemented as arrays is because i eventually want to add things that give extra slots to governments
	List<PolicyCard> military_slots = new ArrayList<PolicyCard>();
	List<PolicyCard> economic_slots = new ArrayList<PolicyCard>();
	List<PolicyCard> diplomatic_slots = new ArrayList<PolicyCard>();
	List<PolicyCard> wildcard_slots = new ArrayList<PolicyCard>();
	
	//TODO maybe move these functions into a handler/interface of sorts?
	public void initializeSlots() {
		for (int i = 0; i < numOfMilitarySlots; i++) {
			military_slots.add(new EmptyPolicy(policytype.MILITARY));
		}
		for (int i = 0; i < numOfEconomicSlots; i++) {
			military_slots.add(new EmptyPolicy(policytype.ECONOMIC));
		}
		for (int i = 0; i < numOfDiplomaticSlots; i++) {
			military_slots.add(new EmptyPolicy(policytype.DIPLOMATIC));
		}
		for (int i = 0; i < numOfWildcardSlots; i++) {
			military_slots.add(new EmptyPolicy(policytype.WILDCARD));
		}
	}
	
	
	//TODO implement all the below
	
	//this one function will handle the actual changing of policies
	public void swapPolicy(PolicyCard oldCard, PolicyCard newCard) {
		
		switch(newCard.getType()) {
		case MILITARY:
			if(military_slots.indexOf(oldCard) != -1) {
				//TODO make sure the old card is loaded back into the user's civics repo
				military_slots.set(military_slots.indexOf(oldCard), newCard);
			}
		
		case ECONOMIC:
			if(economic_slots.indexOf(oldCard) != -1) {
				//TODO make sure the old card is loaded back into the user's civics repo
				economic_slots.set(economic_slots.indexOf(oldCard), newCard);
			}
		
		case DIPLOMATIC:
			if(diplomatic_slots.indexOf(oldCard) != -1) {
				//TODO make sure the old card is loaded back into the user's civics repo
				diplomatic_slots.set(diplomatic_slots.indexOf(oldCard), newCard);
			}
		
		case WILDCARD:
			if(wildcard_slots.indexOf(oldCard) != -1) {
				//TODO make sure the old card is loaded back into the user's civics repo
				wildcard_slots.set(wildcard_slots.indexOf(oldCard), newCard);
			}
		case DARK:
			if(wildcard_slots.indexOf(oldCard) != -1) {
				//TODO make sure the old card is loaded back into the user's civics repo
				wildcard_slots.set(wildcard_slots.indexOf(oldCard), newCard);
			}
		}
	}
	
	public void removePolicy(PolicyCard card) {
		swapPolicy(card, new EmptyPolicy(card.type));
	}
	
	
	public void changePolicies() {
		//call to edit changes
		;
	}
	
	//this approach may not be right
	public void confirmChanges() {
		System.out.println("calling confirm changes");
		for (PolicyCard card : military_slots) {
			//TODO if the card does not require listeners, just apply the effect directly here (or maybe elsewhere)
			for (String listener : card.getListeners()){
				SubscriberCatalog.addSubscriberToListener(listener, playerowner); //for each policy in each row, subscribe to the listeners
			}
		}
		
		;
	}
	
	public abstract void applyInherentEffect();
	public abstract void removeInherentEffect();
	
}
