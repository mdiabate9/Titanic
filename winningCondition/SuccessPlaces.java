package winningCondition;

import java.util.HashMap;
import java.util.Map;

import personages.Hero;

import world.Place;

public class SuccessPlaces extends WinningCondition{
	
	private Map<String,Place> sensitivePlaces= new HashMap<String,Place>();
	
	/**
	 * Constructor SuccesPlaces
	 * @param h is the hero 
	 * @param places are the wining places which are actually the emergencies
	 */
	public SuccessPlaces(Hero h, Map<String,Place> places) {
		super(h);
		this.sensitivePlaces = places;
	}

	/**
	 * Run the thread and look if the hero is in a winning place and the fiancee is with him
	 * than he will win
	 */
	@Override
	public void run() {
		Place currentPlace = new Place(null);
		Place predPlace = currentPlace;
		
		while(!(isAWinnigPlace(currentPlace) && this.hero.hasFianceeInTeam())){	
			try{
				if(isAWinnigPlace(currentPlace) && !testSamePlace(predPlace,currentPlace)){
					System.err.println("You forgot Your Fiancee ! Go get her, Hurry Up!");
					Thread.sleep(1000);
				}
					Thread.sleep(100);
				}
			catch(InterruptedException a){
				System.out.println("Another ressource made our game crashed");
			}
			predPlace = currentPlace;
			currentPlace = this.hero.getPosition();
		}
		System.out.println("You win");
		System.out.println("You saved " + hero.getTeam().numberOfCharacters() + " persons ");
		System.out.println("Your score is : " + hero.getTeam().numberOfCharacters()*50);
		System.out.println("Congratulations !");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	/**
	 * Check is the place is winning place
	 * @param p is the place
	 * @return the boolean that says if it is a winning place
	 */
	public boolean isAWinnigPlace(Place p){
		return this.sensitivePlaces.containsValue(p);
	}
	
	/**
	 * Check if two places are the same
	 * @param a is the first place 
	 * @param b is the second place
	 * @return the boolean that says if they are the same
	 */
	public boolean testSamePlace(Place a, Place b){
		return (a == b);
	}
	
}
