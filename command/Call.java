package command;

import personages.Hero;
import personages.Personage;

public class Call extends Instruction{

	/**
	 * Call constructor super two arguments
	 */
	public Call() {
		super(2);
	}

	/**
	 * adding a new character to the team 
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord;
		if(tab.length == 2){
			secondWord = tab[1]; 
			if(hero.hasCharacterInRoom(secondWord)) {                 // check if the character is in the current room
				Personage p = hero.getCharacterInRoom(secondWord);   // getting the right character
				hero.addCharacterInTeam(p);							// adding the character to the hero's team
				hero.removeCharacterInRoom(secondWord);            // remove the character from the current room
				System.out.println(secondWord + " is added to the team");
				hero.getTeam().display();                         // displaying all the team
			}
			else if(hero.hasCharacterInTeam(secondWord)){        // if the character is already in the hero's team
				System.out.println(secondWord + " is already in your team");
			}
			else {
				System.out.println("No character named as " + secondWord + " in this room");
			}
		}
		else{
			System.out.println("Invalid number of arguments for command call.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
}
