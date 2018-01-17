package items;

import personages.Hero;
import interfaces.Usable;
import world.Boat;

public class WaterAspirator extends UmpregnableItem implements Usable {
	
	/**
	 * Create a new waterAspirator
	 */
	public WaterAspirator() {
		super("waterAspirator");
	}

	/**
	 * display the description of this item
	 */
	public void descriptive() {
		System.out.println("This is an Aspirator which has a 20L fuel tank");
	}

	/**
	 * Usage made for this item by the WaterAspirator
	 * Decrease the waterLevel of x Litter, 
	 * x being fixed and can be modified in the class Boat
	 */
	public void use(Hero h) {
		
		((Boat)h.getWorld()).decreaseWaterLevel();
		System.out.println("WaterLevel Decreased");
		System.out.println("New Water Level : " + Math.round(((Boat)h.getWorld()).getWaterLevel()*1000.0)/1000.0);

		
	}

}
