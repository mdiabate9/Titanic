package command;

import personages.Hero;

public class Help extends Instruction{
	/**
	 * Help constructor super one argument
	 */
	public Help() {
		super(1);
	}

	/**
	 * Display all the commands with there meaning to help the player
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		if(tab.length == this.nbArgMax){
			System.out.println("<-----HELP---->");
			System.out.println("enter: \"quit\" to quit the party");
			System.out.println("enter: \"call\" followed by a character's name to call a character");
			System.out.println("enter: \"go\" followed by the name of a neighbour room to go to it");
			System.out.println("enter: \"inventory\" to see your backpack, yours outfits and the members of your team");
			System.out.println("enter: \"level\" to see the water level in the boat");
			System.out.println("enter: \"look\" to see items and characters in the room and also the reachable rooms");
			System.out.println("\tor \"look\" followed by item or character to see their descriptions.");
			System.out.println("enter: \"open\" followed by the name of a neighbour room or a chest to open it");
			System.out.println("enter: \"take\" followed by pregnable the item to take it");
			System.out.println("enter: \"use\" followed by the item to use an item, every type of items is used differently");
			System.out.println("enter: \"whereami\" to see your current position in the boat");
		}
		else{
			System.out.println("Invalid number of arguments for command help.");
			System.out.println("Please check help for help.");
		}
		
	}

}
