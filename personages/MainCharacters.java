package personages;

import world.Place;

public abstract class MainCharacters extends Personage {

	/**
	 * MainCharacters constructor that super the name and the place to personage
	 * @param name is the personage
	 * @param p is the place where he will be create
	 */
	public MainCharacters(String name, Place p) {
		super(name, p);
	}
	
}
