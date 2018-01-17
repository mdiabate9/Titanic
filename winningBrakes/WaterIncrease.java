package winningBrakes;

import personages.Hero;
import world.Boat;

public class WaterIncrease extends WinningBrakes{
	
	private int speedOfIncrease = 2;   // speed of increase in seconds
											// The level of water is increased every speedOfIncrease seconds
	/**
	 * Waterincrease constructor that super the hero to WinningBrakes
	 * @param h is the hero
	 */
	public WaterIncrease(Hero h) {
		super(h);
	}

	/**
	 * Increase the level of difficulty by increasing the speed of water level
	 */
	public void increaseDifficulty() {
		this.speedOfIncrease += 1.0;
	}

	/**
	 * Decrease the level of difficulty by increasing the speed of water level
	 */
	public void decreaseDifficulty() {
		this.speedOfIncrease -= 1.0;
	}
	
	/**
	 * run the thread
	 */
	public void run(){
		while(true){
			try{
				Thread.sleep(this.speedOfIncrease * 1000);
			}
			catch(InterruptedException a){
				System.out.println("Another ressource made our game crashed");
			}
			((Boat)this.hero.getWorld()).increaseWaterLevel();
		}
	}

}
