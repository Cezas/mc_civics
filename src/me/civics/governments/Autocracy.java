package me.civics.governments;

public class Autocracy extends Government{

	public Autocracy() {
		numOfMilitarySlots = 2;
		numOfEconomicSlots = 1;
		numOfDiplomaticSlots = 0;
		numOfWildcardSlots = 1;
		initializeSlots();
	}
	
	public void applyInherentEffect() {
		;
	};
	
	public void removeInherentEffect() {
		
	};
}
