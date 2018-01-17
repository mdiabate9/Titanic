package externalEvents;

import personages.Hero;

public abstract class ExternalEvents extends Thread{
	
	protected Hero hero;
	
	/**
	 * ExternalInfluence constructor that set the hero
	 * @param h is the hero
	 */
	public ExternalEvents(Hero h){
		this.hero = h;
	}
	
	/**
	 * Abstract method to run the threads
	 */
	public abstract void run();
}
