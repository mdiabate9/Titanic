package personages;

import world.Place;
import interfaces.Describable;

public abstract class SecondaryCharacters extends Personage implements Describable{
	
	/**
	 * NeedyCharacter constructor that super the name and the place to Personage
	 * @param name is the personage
	 * @param p is the place where he will be created
	 */
	public SecondaryCharacters(String name, Place p) {
		super(name, p);
	}
}
