package winningBrakes;

import personages.Hero;

public abstract class WinningBrakes extends Thread{

	protected Hero hero;
	
	/**
	 * Constructor WinningBrakes
	 * @param h is the hero
	 */
	public WinningBrakes(Hero h){
		this.hero = h;
	}
	
	/**
	 * Abstract function to run the threads
	 */
	public abstract void run();
	
	/**
	 * Abstract function to increase difficulty
	 */
	public abstract void increaseDifficulty();
	
	/**
	 * Abstract function to decrease difficulty
	 */
	public abstract void decreaseDifficulty();

}
