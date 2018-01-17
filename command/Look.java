package command;

import personages.Hero;

public class Look extends Instruction{
	
	/**
	 * Look constructor super two arguments maximum
	 */
	public Look() {
		super(2);
	}

	/**
	 * Display the hero's current room corrent if there is no secondWord
	 * if the command look is foolowed by item or character, get the description
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord; 
		if(tab.length == 1){ 
			hero.getPosition().display();    	    // display all the hero's current room content
		}
		else if(tab.length == 2){ 
			secondWord = tab[1];  							// collecting the second Word of the player's sentence
			System.out.print(secondWord + " : ");
			if(hero.hasObjectInRoom(secondWord)){ 			// checking if the item is present in the current room
				hero.getObjectInRoom(secondWord).descriptive(); 
			}
			else if(hero.hasObjectInBackPack(secondWord)){  // checking if the object is  in the hero's backpack
				hero.getObjectInBackPack(secondWord).descriptive(); 
			}
			else if(hero.hasObjectInOutfit(secondWord)){    // checking if the object is in the hero's outfit
				hero.getObjectInOutfit(secondWord).descriptive(); 
			}
			else if(hero.hasCharacterInTeam(secondWord)){   // if the character is in the hero's team
				hero.getCharacterInTeam(secondWord).descriptive();
			}
			else if(hero.hasCharacterInRoom(secondWord)){   // if the character is in the hero's current room
				hero.getCharacterInRoom(secondWord).descriptive();
			}
			else{
				System.out.println("No items and characters corresponding " );
			}
		}
		else{
			System.out.println("Invalid number of arguments for command look.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
}
