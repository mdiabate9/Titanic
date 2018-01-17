package items;

import personages.Hero;
import interfaces.Usable;


public class TeleportationCage extends UmpregnableItem implements Usable{

	/**
	 * Create a new teleportationCage
	 */
	public TeleportationCage() {
		super("teleport");
	}

	/**
	 * display the description of this item
	 */
	public void descriptive() {
		System.out.println("Teleportation cage, can take you instantly to a random room");
	}

	/**
	 * Usage made for this item by the hero.
	 * Teleport the hero in another randoom  place
	 */
	public void use(Hero h) {
		h.RandomTeleportation();
		System.out.println("Teleportation done");
		System.out.println("You are now in the " + h.getPosition());
	}
	
}
