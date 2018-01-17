package engine;

import java.util.Scanner;

import personages.Hero;



import winningBrakes.OutfitConstraint;
import winningBrakes.WaterConstraint;
import winningBrakes.WaterIncrease;
import winningCondition.SuccessPlaces;
import world.Boat;
import world.World;
import command.Command;
import externalEvents.WaterRecall;


public class Main {

	public static void main(String[] args) {

		World boat = new Boat();
		Hero hero = new Hero(boat.getCentralPlace());	

		/***********************************************************************/
		/***********LAUNCHING THREADS TO ACCOMPLISH ALL THE TASKS **************/
		/**********************************************************************/
		//Test if he's in the right room
		SuccessPlaces s = new SuccessPlaces(hero, boat.getSensitivePlaces());
		s.start();
		
		//Increase the water level
		WaterIncrease w = new WaterIncrease(hero);
		w.start();
				
		//Display a message at the screen after every x seconds to show the waterLevel
		WaterRecall wr = new WaterRecall(hero);
		wr.start();
				
		//Testing the lossCondition. End the game when he waterLevel exceed the hero's size
		WaterConstraint wc = new WaterConstraint(hero);
		wc.start();
		
		OutfitConstraint o = new OutfitConstraint(hero);
		o.start();
		
		/***********************************************************************/
		/*********HEART OF THE GAME. AFTER EACH INSTRUCTION WE LOOP AGAIN******/
		/**********************************************************************/
		
		System.out.println("The boat is sinking");
		System.out.println("Get out of here with your fiancee");
		System.out.println("Type \"help\" at any time for game instructions.\n");
		
		Scanner sc = new Scanner(System.in);  // Scanner in order to read instructions
		while(true){

			// java synchronous input and output in command line
			System.out.print(" > ");
			String instructions = sc.nextLine();		
			String[] instrTab = instructions.split(" "); // Put all the instructions words
														// in a String tab for a future 
													   // analysis
			String firstWord = instrTab[0].toUpperCase().toLowerCase();; // Collecting the first word 
			try{ 
				System.out.println();
				hero.execute(Command.valueOf(firstWord).getInstruction(), instrTab);
			} catch(java.lang.IllegalArgumentException e){
				System.out.println("Wrong command. Try again");
				System.out.println("Remember, type \"help\" at any time for game instructions.");
			}
			System.out.println();
		}
	}
}
