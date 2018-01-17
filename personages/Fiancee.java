package personages;

import world.Place;

public class Fiancee extends MainCharacters{

	/**
	 * Create the fiancee of the hero
	 * @param p is the place where the fiancee will be made
	 */
	public Fiancee(Place p) {
		super("Kate", p);
	}

	/**
	 * Description of the fiancee
	 */
	public void descriptive() {
		System.out.println("Your fiancee");
	}

}
