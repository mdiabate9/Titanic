package command;

import personages.Hero;
import world.Boat;

public class Level extends Instruction{

	/**
	 * Level constructor super one argument
	 */
	public Level() {
		super(1);
	}

	/**
	 * Print the water level in the boat
	 * @param hero is the one who will execute the instruction
	 * @param tab represents the sentence entered by the player
	 */
	public void instructionManager(Hero hero, String[] tab) {
		if(tab.length == 1){
			Boat b = ((Boat)hero.getWorld());      // getting the hero's World
			//Math.round(((Boat)this.hero.getWorld()).getWaterLevel()*1000.0)/1000.0
			System.out.println("Water level : " + Math.round(b.getWaterLevel()*1000.0)/1000.0);
		}
		else{
			System.out.println("Invalid number of arguments for command level.");
			System.out.println("Type \"help\" at any time for game instructions.");
		}
	}
}
