package command;

import personages.Hero;

public class Inventory extends Instruction{
	/**
	 * Inventory constructor super one argument
	 */
	public Inventory() {
		super(1);
	}

	/**
	 * Display the backpack, outfits and the members of the team
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		if(tab.length == 1){
			System.out.print("\t");hero.getBackPack().display();      // displaying the hero's back
			System.out.println();
			System.out.print("\t\t");hero.getOutfit().display();    // displaying the hero's outfit
			System.out.println();
			System.out.print("\t\t\t");hero.getTeam().display();   // displaying the hero's team
		}
		else{
			System.out.println("Invalid number of arguments for command inventory.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}	
	}

}
