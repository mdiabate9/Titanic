package command;

import personages.Hero;
import world.ExitCode;
import world.ExitKey;
import interfaces.Openable;
import items.ChestCode;
import items.ChestKey;
import items.Key;

public class Open extends Instruction{
	
	/**
	 * Open constructor super three arguments maximum
	 */
	public Open(){
		super(3);
	}

	/**
	 * This function open an exit or a chest
	 * More over both of them can be openable with a key or a code
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player, it may be two or three
	 */
	public void instructionManager(Hero hero, String[] tab) {
		String secondWord;
		String thirdWord;
		
		if(tab.length == 2){								// if there are two words
			secondWord = tab[1]; 							// Collecting the second word
			if(hero.hasNeighbour(secondWord)){  			// if the hero's current room has a secondWord as a neighbor room
				hero.getNeighbourExit(secondWord).open();  // opening the exit
			}
			
			else if(hero.hasObjectInRoom(secondWord)){	// if it is an object, 
				try{								   // we try if it's an openable object
					Openable o = (Openable)hero.getObjectInRoom(secondWord);
					o.open();
				}
				catch(java.lang.ClassCastException a){
					System.out.println(secondWord + " is not a chest. Cannot be open");
				}
			}
			
			else{
				System.out.println(secondWord + " is neither a neighboor room nor a chest");
			}
		}
		
		
		else if(tab.length == 3){  // if there are three words
			secondWord = tab[1];   
			thirdWord = tab[2];
			
			if(hero.hasNeighbour(secondWord)){ 										  // if it's an exit, we must determine what kind of exit
				
				if (hero.getNeighbourExit(secondWord) instanceof ExitCode){     	 // if the exit is an exitCode
					((ExitCode)hero.getNeighbourExit(secondWord)).open(thirdWord);  // we need to cast it before opening
				}
				
				else if((hero.getNeighbourExit(secondWord) instanceof ExitKey)){   // if it is an exit with key
																				   // we need to test if the third word
																				  // correspond to an key in the hero's backpack
					if(hero.hasObjectInBackPack(thirdWord)){			// if the third word is an object
						try{ 											// trying to catch an exception if the corresponding object is not a key
							Key key = (Key)hero.getObjectInBackPack(thirdWord);
							((ExitKey)hero.getNeighbourExit(secondWord)).open(key);
						}
						catch(java.lang.ClassCastException a){
							System.out.println("You own " + thirdWord + " in your backPack but it isn't a key");
						}
					}
					
					else{ // if the third word is not a key
						System.out.println("You don't own any key named as " + thirdWord + " in your backPack");
					}
				}
				
				else{  // if it is nor a ExitKey nor an exitCode
					System.out.println(secondWord + " is not secured by a key or a code. Open it simply.");
				}
			}
			/**/
			else if((Openable)hero.getObjectInRoom(secondWord) instanceof Openable ){ // if it's an item
				if(hero.getObjectInRoom(secondWord) instanceof ChestCode){
					((ChestCode)hero.getObjectInRoom(secondWord)).open(thirdWord);
				}
				else if(hero.getObjectInRoom(secondWord) instanceof ChestKey){
					if(hero.hasObjectInBackPack(thirdWord)){			// if the third word is an object
						try{ 											// trying to catch an exception if the corresponding object is not a key
							Key key = (Key)hero.getObjectInBackPack(thirdWord);
							((ChestKey)hero.getObjectInRoom(secondWord)).open(key);
						}
						catch(java.lang.ClassCastException a){
							System.out.println("You own " + thirdWord + " in your backPack but it isn't a key");
						}
					}
					else{ // if the third word is not a key
						System.out.println("You don't own any key named as " + thirdWord + " in your backPack");
					}
				}
				else{
					System.out.println(secondWord + " is not secured by a key or a code. Open it simply.");
				}
			}
			/**/	
			else{  // if the second word is not an exit nor a Chest
				System.out.println(secondWord + " is not a neighbour room nor a chest.");
			}
		}
		else{
			System.out.println("Invalid number of arguments for command open.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}		
	}
	
}
