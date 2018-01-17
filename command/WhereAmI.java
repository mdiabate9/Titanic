package command;

import personages.Hero;

public class WhereAmI extends Instruction{

	/**
	 * WhereAmI constructor super one argument
	 */
	public WhereAmI() {
		super(1);
	}

	/**
	 * Print the current position in the boat
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		if(tab.length == 1){
			System.out.println("Current room : " + hero.getPosition());
		}
		else{
			System.out.println("Invalid number of arguments for command whereami.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
	
	

}
