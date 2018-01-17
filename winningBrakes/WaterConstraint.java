package winningBrakes;

import personages.Hero;
import world.Boat;


public class WaterConstraint extends WinningBrakes{
	private double limit;
	
	/**
	 * WaterConstraint constructor that super hero to WinningBrakes
	 * And set the limit to the hero size
	 * @param h is the hero
	 */
	public WaterConstraint(Hero h){
		super(h);
		this.limit = h.getSize();
	}
	
	/**
	 * getter of the limit
	 * @return the limit of water level
	 */
	public double getLimit(){
		return this.limit;
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
	 * Run the thread
	 */
	public void run(){
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
		System.out.println("Water killed you");
		System.out.println("Party lost");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}

}
