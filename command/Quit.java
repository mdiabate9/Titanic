package command;

import personages.Hero;

public class Quit extends Instruction{

	/**
	 * Quit constructor super one argument 
	 */
	public Quit() {
		super(1);
	}

	/**
	 * Quit the party
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		if(tab.length == 1){
			System.out.println("Party left");
			System.exit(1);    // Get out of the game
		}
		else{
			System.out.println("Invalid number of arguments for command quit.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}

}
