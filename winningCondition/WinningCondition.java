package winningCondition;


import personages.Hero;

public abstract class WinningCondition extends Thread{

	protected Hero hero;
	
	/**
	 * Constructor WinnigCondition 
	 * @param h is hero
	 */
	public WinningCondition(Hero h){
		this.hero = h;
	}
	
	/**
	 * Abstract function to run the threads 
	 */
	public abstract void run();
}
