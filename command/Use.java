package command;

import personages.Hero;
import interfaces.Usable;

public class Use extends Instruction{

	/**
	 * Use constructor super two arguments maximum
	 */
	public Use() {
		super(2);
	}

	/**
	 * Use the item if it is in the hero's outfit or in the backPack
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord;
		if(tab.length == 2){
			secondWord = tab[1];
			
			if(hero.hasObjectInOutfit(secondWord)){                          // if the item is in the hero's outfit
				System.out.println(secondWord + " is already worn");
			}	
			
			else if(hero.hasObjectInBackPack(secondWord)){		           // if it's already in the backPack
				try{ 	                                                  // catching an exception if the object cannot be cast in a usable
					Usable u = (Usable)hero.getObjectInBackPack(secondWord); 
					u.use(hero);   								    	 // using the object 
				}
				catch(java.lang.ClassCastException a){
					System.out.println(secondWord + " is in the backPack but, is not usable");
				}
			}
			
			else if(hero.hasObjectInRoom(secondWord)){              // if the item is in the current room
				try{
					Usable u = (Usable)hero.getObjectInRoom(secondWord);
					u.use(hero);
				}
				catch(java.lang.ClassCastException a){
					System.out.println(secondWord + " is in this room but, is not usable");
				}
			}
			
			else{
				System.out.println("No item named as " + secondWord);
			}
			
		}
		else{
			System.out.println("Invalid number of arguments for command use.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
	
}
