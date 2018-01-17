package command;

import personages.Hero;
import world.Exit;

public class Go extends Instruction{

	/**
	 * Call constructor super two arguments
	 */
	public Go() {
		super(2);
	}

	/**
	 * go to a new room
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord;				
		if(tab.length == 2){ 		   
			secondWord = tab[1];      					  // Collecting the second word of the player's sentence
			if(hero.hasNeighbour(secondWord)){	         // checking if the place is a neighboorRoom
				Exit e = hero.getNeighbourExit(secondWord); // getting the right exit
				hero.goTo(e); 						   // crossing the exit
				hero.getTeam().moveAllTo(e);          // moving all the hero's team into the new hero's room
													 // the hero's team is following him
			}
			else{
				System.out.println(secondWord + " is not a neighboor room");
			}
		}
		else{
			System.out.println("Invalid number of arguments for command go.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
}
