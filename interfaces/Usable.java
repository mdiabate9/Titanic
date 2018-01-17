package interfaces;

import personages.Hero;

public interface Usable {
	
	/**
	 * Say how the usable instance will be used by the hero
	 * @param h is the hero who will use this usable instance
	 */
	public void use(Hero h);
}
