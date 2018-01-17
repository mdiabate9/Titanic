package externalEvents;

import personages.Hero;
import world.Boat;

public class WaterRecall extends ExternalEvents{
	
	private int recallInterval = 160;

	/**
	 * WaterRecall constructor that super hero to ExternalInfluence
	 * @param h
	 */
	public WaterRecall(Hero h) {
		super(h);
	}
	
	/**
	 * setter on the recallInterval
	 * @param a is the new recallInterval
	 */
	public void setWaterRecall(int a){
		this.recallInterval = a;
	}

	/**
	 * run the thread to recall the water level and print it on the screen
	 */
	public void run(){
		while(true){
			try{
				Thread.sleep(this.recallInterval * 1000);
			}
			catch(InterruptedException a){
				System.out.println("Another ressource made our game crashed");
			} 
			System.out.println("Water Level Recall : " + Math.round(((Boat)this.hero.getWorld()).getWaterLevel()*1000.0)/1000.0);
			System.out.println("Hurry Up! You're dying\n");
		}
	}
}
