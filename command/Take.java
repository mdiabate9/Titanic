package command;

import personages.Hero;
import items.PregnableItem;
import items.Item;

public class Take extends Instruction{
	
	/**
	 * Take constructor super two arguments maximum
	 */
	public Take() {
		super(2);
	}

	/**
	 * Take an item if it's a pregnable item
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord;
		if(tab.length == 2){
			secondWord = tab[1];
			if(hero.getObjectInRoom(secondWord) instanceof Item){             // if the second word is an item in the current room
				if(hero.getObjectInRoom(secondWord) instanceof PregnableItem){  // if the item is pregnable
					hero.take((PregnableItem)hero.getObjectInRoom(secondWord));     // We take it
				}
				else{
					System.out.println(secondWord + " is umpregnable");
				}
			}
			else{
				System.out.println("No item named as " + secondWord + " in this room");
			}
		}
		else{
			System.out.println("Invalid number of arguments for command take.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
}
