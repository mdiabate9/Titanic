package command;

import personages.Hero;

public abstract class Instruction {
	
	protected int nbArgMax;  // number of Arguments Max of the command

	/**
	 * Instruction Constructor
	 * @param n is the number of Arguments Max of the command
	 */
	public Instruction(int n){
		this.nbArgMax = n; 
	}

	/**
	 * This function manage the instruction behavior.
	 * It analyze the sentence entered by the player
	 * taking into account the number of argument, and other 
	 * parameters related to the type of instruction
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public abstract void instructionManager(Hero hero, String[] tab);
	
}
