package winningBrakes;

import personages.Hero;
import world.Boat;

public class OutfitConstraint extends WinningBrakes{
	private double limit;
	
	/**
	 * WaterConstraint constructor that super hero to WinningBrakes
	 * And set the limit 
	 * @param h is the hero
	 */
	public OutfitConstraint(Hero h) {
		super(h);
		this.limit = (3*h.getSize())/4 ;
	}

	/**
	 * Increase the level of difficulty by increasing the limit of water level
	 */
	public void increaseDifficulty() {
		this.limit += 0.1;
	}

	/**
	 * Decrease the level of difficulty by increasing the limit of water level
	 */
	public void decreaseDifficulty() {
		this.limit -= 0.1;	
	}
	
	/**
	 * run the thread
	 */
	public void run() {
		double waterLevel = ((Boat)this.hero.getWorld()).getWaterLevel();
		while(waterLevel < this.limit){
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException a){
				System.out.println("Another computer ressource made our game crashed");
			}
			waterLevel = ((Boat)this.hero.getWorld()).getWaterLevel();
		}
		System.out.println("\nThe water level is too high");
		if(hero.getOutfit().isEmpty()){
			System.out.println("You don't have any outfit to protect you from the water pressure");
			System.out.println("Party lost");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(1);
		}
		else{
			System.out.println("Fortunately you used some diver outfits");
			System.out.println("You can go ahead !");
		}		
	}

}
